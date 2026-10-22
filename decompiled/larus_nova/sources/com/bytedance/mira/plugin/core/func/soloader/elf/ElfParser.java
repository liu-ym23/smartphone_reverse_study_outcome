package com.bytedance.mira.plugin.core.func.soloader.elf;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.facebook.soloader.MinElf;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.UByte;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes21.dex */
public class ElfParser implements Closeable, Elf {
    private final int MAGIC;
    private final FileChannel channel;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.channel.close();
    }

    public Elf.Header parseHeader() throws IOException {
        this.channel.position(0);
        ByteBuffer r100 = ByteBuffer.allocate(8);
        r100.order(ByteOrder.LITTLE_ENDIAN);
        if (readWord(r100, 0) != 1179403647) goto L17;
        short r101 = readByte(r100, 4);
        if (readByte(r100, 5) != 2) goto L7;
        boolean r102 = true;
    L8:
        if (r101 == 1) goto L10;
        if (r101 != 2) goto L15;
        return new Elf64Header(r102, this);
    L15:
        throw new IllegalStateException("Invalid class type!");
    L10:
        return new Elf32Header(r102, this);
    L7:
        r102 = false;
        goto L8
    L17:
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    public List<String> parseNeededDependencies() throws IOException {
        this.channel.position(0);
        ArrayList r100 = new ArrayList();
        Elf.Header r101 = parseHeader();
        ByteBuffer r102 = ByteBuffer.allocate(8);
        if (r101.bigEndian == false) goto L5;
        ByteOrder r103 = ByteOrder.BIG_ENDIAN;
    L6:
        r102.order(r103);
        long r104 = r101.phnum;
        int r105 = 0;
        if (r104 != 65535) goto L9;
        r104 = r101.getSectionHeader(0).info;
    L9:
        long r106 = 0;
    L11:
        if (r106 >= r104) goto L16;
        Elf.ProgramHeader r110 = r101.getProgramHeader(r106);
        if (r110.type == 2) goto L14;
        r106 = r106 + 1;
        goto L11
    L14:
        long r107 = r110.offset;
    L18:
        if (r107 == 0) goto L20;
        ArrayList r111 = new ArrayList();
        long r112 = 0;
    L22:
        Elf.DynamicStructure r108 = r101.getDynamicStructure(r107, r105);
        long r113 = r107;
        long r109 = r108.tag;
        if (r109 != 1) goto L26;
        r111.add(Long.valueOf(r108.val));
    L28:
        r105 = r105 + 1;
        if (r108.tag == 0) goto L31;
        r107 = r113;
        goto L22
    L31:
        if (r112 == 0) goto L38;
        long r114 = offsetFromVma(r101, r104, r112);
        Iterator r115 = r111.iterator();
    L34:
        if (r115.hasNext() == false) goto L36;
        r100.add(readString(r102, ((Long) r115.next()).longValue() + r114));
        goto L34
    L36:
        return r100;
    L38:
        throw new IllegalStateException("String table offset not found!");
    L26:
        if (r109 != 5) goto L28;
        r112 = r108.val;
        goto L28
    L20:
        return Collections.unmodifiableList(r100);
    L16:
        r107 = 0;
        goto L18
    L5:
        r103 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }

    public ElfParser(File r100) throws FileNotFoundException {
        this.MAGIC = MinElf.ELF_MAGIC;
        if (r100 == null) goto L9;
        if (r100.exists() == false) goto L9;
        this.channel = new PolarisFileInputStreamWrapper(r100).getChannel();
        return;
    L9:
        throw new IllegalArgumentException("File is null or does not exist");
    }

    public short readByte(ByteBuffer r100, long r101) throws IOException {
        read(r100, r101, 1);
        return (short) (r100.get() & UByte.MAX_VALUE);
    }

    public int readHalf(ByteBuffer r100, long r101) throws IOException {
        read(r100, r101, 2);
        return r100.getShort() & 65535;
    }

    public long readLong(ByteBuffer r100, long r101) throws IOException {
        read(r100, r101, 8);
        return r100.getLong();
    }

    public String readString(ByteBuffer r100, long r101) throws IOException {
        StringBuilder r102 = new StringBuilder();
    L3:
        long r103 = 1 + r101;
        short r104 = readByte(r100, r101);
        if (r104 == 0) goto L7;
        r102.append((char) r104);
        r101 = r103;
        goto L3
    L7:
        return r102.toString();
    }

    public long readWord(ByteBuffer r100, long r101) throws IOException {
        read(r100, r101, 4);
        return ((long) r100.getInt()) & BodyPartID.bodyIdMax;
    }

    private long offsetFromVma(Elf.Header r110, long r111, long r112) throws IOException {
        long r100 = 0;
    L4:
        if (r100 >= r111) goto L15;
        Elf.ProgramHeader r101 = r110.getProgramHeader(r100);
        if (r101.type != 1) goto L13;
        long r102 = r101.vaddr;
        if (r102 > r112) goto L13;
        if (r112 > (r101.memsz + r102)) goto L13;
        return (r112 - r102) + r101.offset;
    L13:
        r100 = r100 + 1;
        goto L4
    L15:
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public void read(ByteBuffer r100, long r101, int r110) throws IOException {
        r100.position(0);
        r100.limit(r110);
        long r102 = 0;
    L4:
        if (r102 >= r110) goto L10;
        int r103 = this.channel.read(r100, r101 + r102);
        if (r103 == (-1)) goto L9;
        r102 = r102 + ((long) r103);
        goto L4
    L9:
        throw new EOFException();
    L10:
        r100.position(0);
    }
}
