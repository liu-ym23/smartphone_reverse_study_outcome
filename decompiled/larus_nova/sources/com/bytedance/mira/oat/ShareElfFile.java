package com.bytedance.mira.oat;

import com.bytedance.mira.util.IOUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public class ShareElfFile implements Closeable {
    private ElfHeader elfHeader;
    private final FileInputStream fis;
    private ProgramHeader[] programHeaders;
    private SectionHeader[] sectionHeaders;
    private final Map<String, SectionHeader> sectionNameToHeaderMap;

    /* JADX INFO: renamed from: com.bytedance.mira.oat.ShareElfFile$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class ElfHeader {
        public static final int EI_CLASS = 4;
        public static final int EI_DATA = 5;
        private static final int EI_NINDENT = 16;
        public static final int EI_VERSION = 6;
        public static final int ELFCLASS32 = 1;
        public static final int ELFCLASS64 = 2;
        public static final int ELFDATA2LSB = 1;
        public static final int ELFDATA2MSB = 2;
        public static final int ET_CORE = 4;
        public static final int ET_DYN = 3;
        public static final int ET_EXEC = 2;
        public static final int ET_HIPROC = 65535;
        public static final int ET_LOPROC = 65280;
        public static final int ET_NONE = 0;
        public static final int ET_REL = 1;
        public static final int EV_CURRENT = 1;
        public final short eEhSize;
        public final long eEntry;
        public final int eFlags;
        public final byte[] eIndent;
        public final short eMachine;
        public final short ePhEntSize;
        public final short ePhNum;
        public final long ePhOff;
        public final short eShEntSize;
        public final short eShNum;
        public final long eShOff;
        public final short eShStrNdx;
        public final short eType;
        public final int eVersion;

        private ElfHeader(FileChannel r100) throws IOException {
            byte[] r101 = new byte[16];
            this.eIndent = r101;
            r100.position(0);
            r100.read(ByteBuffer.wrap(r101));
            if (r101[0] != 127) goto L28;
            if (r101[1] != 69) goto L28;
            if (r101[2] != 76) goto L28;
            if (r101[3] != 70) goto L28;
            ShareElfFile.access$300(r101[4], 1, 2, "bad elf class: " + r101[4]);
            ShareElfFile.access$300(r101[5], 1, 2, "bad elf data encoding: " + r101[5]);
            if (r101[4] != 1) goto L13;
            int r102 = 36;
        L14:
            ByteBuffer r103 = ByteBuffer.allocate(r102);
            if (r101[5] != 1) goto L17;
            ByteOrder r104 = ByteOrder.LITTLE_ENDIAN;
        L18:
            r103.order(r104);
            ShareElfFile.access$400(r100, r103, "failed to read rest part of ehdr.");
            this.eType = r103.getShort();
            this.eMachine = r103.getShort();
            int r105 = r103.getInt();
            this.eVersion = r105;
            ShareElfFile.access$300(r105, 1, 1, "bad elf version: " + r105);
            byte r106 = r101[4];
            if (r106 == 1) goto L24;
            if (r106 != 2) goto L23;
            this.eEntry = r103.getLong();
            this.ePhOff = r103.getLong();
            this.eShOff = r103.getLong();
        L25:
            this.eFlags = r103.getInt();
            this.eEhSize = r103.getShort();
            this.ePhEntSize = r103.getShort();
            this.ePhNum = r103.getShort();
            this.eShEntSize = r103.getShort();
            this.eShNum = r103.getShort();
            this.eShStrNdx = r103.getShort();
            return;
        L23:
            throw new IOException("Unexpected elf class: " + r101[4]);
        L24:
            this.eEntry = r103.getInt();
            this.ePhOff = r103.getInt();
            this.eShOff = r103.getInt();
            goto L25
        L17:
            r104 = ByteOrder.BIG_ENDIAN;
            goto L18
        L13:
            r102 = 48;
        L28:
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", new Object[]{Byte.valueOf(r101[0]), Byte.valueOf(r101[1]), Byte.valueOf(r101[2]), Byte.valueOf(r101[3])}));
        }

        public /* synthetic */ ElfHeader(FileChannel r100, AnonymousClass1 r101) throws IOException {
            this(r100);
        }
    }

    public static class ProgramHeader {
        public static final int PF_R = 4;
        public static final int PF_W = 2;
        public static final int PF_X = 1;
        public static final int PT_DYNAMIC = 2;
        public static final int PT_HIPROC = Integer.MAX_VALUE;
        public static final int PT_INTERP = 3;
        public static final int PT_LOAD = 1;
        public static final int PT_LOPROC = 1879048192;
        public static final int PT_NOTE = 4;
        public static final int PT_NULL = 0;
        public static final int PT_PHDR = 6;
        public static final int PT_SHLIB = 5;
        public final long pAlign;
        public final long pFileSize;
        public final int pFlags;
        public final long pMemSize;
        public final long pOffset;
        public final long pPddr;
        public final int pType;
        public final long pVddr;

        private ProgramHeader(ByteBuffer r100, int r101) throws IOException {
            if (r101 != 1) goto L5;
            this.pType = r100.getInt();
            this.pOffset = r100.getInt();
            this.pVddr = r100.getInt();
            this.pPddr = r100.getInt();
            this.pFileSize = r100.getInt();
            this.pMemSize = r100.getInt();
            this.pFlags = r100.getInt();
            this.pAlign = r100.getInt();
            return;
        L5:
            if (r101 != 2) goto L8;
            this.pType = r100.getInt();
            this.pFlags = r100.getInt();
            this.pOffset = r100.getLong();
            this.pVddr = r100.getLong();
            this.pPddr = r100.getLong();
            this.pFileSize = r100.getLong();
            this.pMemSize = r100.getLong();
            this.pAlign = r100.getLong();
            return;
        L8:
            throw new IOException("Unexpected elf class: " + r101);
        }

        public /* synthetic */ ProgramHeader(ByteBuffer r100, int r101, AnonymousClass1 r102) throws IOException {
            this(r100, r101);
        }
    }

    public static class SectionHeader {
        public static final int SHF_ALLOC = 2;
        public static final int SHF_EXECINSTR = 4;
        public static final int SHF_MASKPROC = -268435456;
        public static final int SHF_WRITE = 1;
        public static final int SHN_ABS = 65521;
        public static final int SHN_COMMON = 65522;
        public static final int SHN_HIPROC = 65311;
        public static final int SHN_HIRESERVE = 65535;
        public static final int SHN_LOPROC = 65280;
        public static final int SHN_LORESERVE = 65280;
        public static final int SHN_UNDEF = 0;
        public static final int SHT_DYNAMIC = 6;
        public static final int SHT_DYNSYM = 11;
        public static final int SHT_HASH = 5;
        public static final int SHT_HIPROC = Integer.MAX_VALUE;
        public static final int SHT_HIUSER = -1;
        public static final int SHT_LOPROC = 1879048192;
        public static final int SHT_LOUSER = Integer.MIN_VALUE;
        public static final int SHT_NOBITS = 8;
        public static final int SHT_NOTE = 7;
        public static final int SHT_NULL = 0;
        public static final int SHT_PROGBITS = 1;
        public static final int SHT_REL = 9;
        public static final int SHT_RELA = 4;
        public static final int SHT_SHLIB = 10;
        public static final int SHT_STRTAB = 3;
        public static final int SHT_SYMTAB = 2;
        public final long shAddr;
        public final long shAddrAlign;
        public final long shEntSize;
        public final long shFlags;
        public final int shInfo;
        public final int shLink;
        public final int shName;
        public String shNameStr;
        public final long shOffset;
        public final long shSize;
        public final int shType;

        private SectionHeader(ByteBuffer r100, int r101) throws IOException {
            if (r101 != 1) goto L5;
            this.shName = r100.getInt();
            this.shType = r100.getInt();
            this.shFlags = r100.getInt();
            this.shAddr = r100.getInt();
            this.shOffset = r100.getInt();
            this.shSize = r100.getInt();
            this.shLink = r100.getInt();
            this.shInfo = r100.getInt();
            this.shAddrAlign = r100.getInt();
            this.shEntSize = r100.getInt();
        L10:
            this.shNameStr = null;
            return;
        L5:
            if (r101 != 2) goto L8;
            this.shName = r100.getInt();
            this.shType = r100.getInt();
            this.shFlags = r100.getLong();
            this.shAddr = r100.getLong();
            this.shOffset = r100.getLong();
            this.shSize = r100.getLong();
            this.shLink = r100.getInt();
            this.shInfo = r100.getInt();
            this.shAddrAlign = r100.getLong();
            this.shEntSize = r100.getLong();
            goto L10
        L8:
            throw new IOException("Unexpected elf class: " + r101);
        }

        public /* synthetic */ SectionHeader(ByteBuffer r100, int r101, AnonymousClass1 r102) throws IOException {
            this(r100, r101);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.fis.close();
        this.sectionNameToHeaderMap.clear();
        this.programHeaders = null;
        this.sectionHeaders = null;
    }

    private ShareElfFile(File r100) throws IOException {
        AnonymousClass1 r101 = null;
        this.elfHeader = null;
        this.programHeaders = null;
        this.sectionHeaders = null;
        this.sectionNameToHeaderMap = new HashMap();
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);
        this.fis = r102;
        FileChannel r103 = r102.getChannel();
        this.elfHeader = new ElfHeader(r103, r101);
        ByteBuffer r104 = ByteBuffer.allocate(128);
        r104.limit(this.elfHeader.ePhEntSize);
        if (this.elfHeader.eIndent[5] != 1) goto L5;
        ByteOrder r105 = ByteOrder.LITTLE_ENDIAN;
    L6:
        r104.order(r105);
        r103.position(this.elfHeader.ePhOff);
        this.programHeaders = new ProgramHeader[this.elfHeader.ePhNum];
        int r106 = 0;
        int r107 = 0;
    L8:
        if (r107 >= this.programHeaders.length) goto L10;
        readUntilLimit(r103, r104, "failed to read phdr.");
        this.programHeaders[r107] = new ProgramHeader(r104, this.elfHeader.eIndent[4], r101);
        r107 = r107 + 1;
        goto L8
    L10:
        r103.position(this.elfHeader.eShOff);
        r104.limit(this.elfHeader.eShEntSize);
        this.sectionHeaders = new SectionHeader[this.elfHeader.eShNum];
        int r108 = 0;
    L11:
        SectionHeader[] r109 = this.sectionHeaders;
        if (r108 >= r109.length) goto L14;
        readUntilLimit(r103, r104, "failed to read shdr.");
        this.sectionHeaders[r108] = new SectionHeader(r104, this.elfHeader.eIndent[4], r101);
        r108 = r108 + 1;
        goto L11
    L14:
        short r110 = this.elfHeader.eShStrNdx;
        if (r110 <= 0) goto L19;
        ByteBuffer r111 = getSection(r109[r110]);
        SectionHeader[] r112 = this.sectionHeaders;
        int r113 = r112.length;
    L17:
        if (r106 >= r113) goto L23;
        SectionHeader r114 = r112[r106];
        r111.position(r114.shName);
        String r115 = readCString(r111);
        r114.shNameStr = r115;
        this.sectionNameToHeaderMap.put(r115, r114);
        r106 = r106 + 1;
        goto L17
    L23:
        return;
    L19:
        return;
    L5:
        r105 = ByteOrder.BIG_ENDIAN;
        goto L6
    }

    public static boolean checkElfFile(File r100) {
        IOUtils.closeSilently(new ShareElfFile(r100));
        return true;
    L9:
        IOUtils.closeSilently(null);
        return false;
    L6:
        th = move-exception;
        IOUtils.closeSilently(null);
        throw th;
    }

    private ByteBuffer getSection(SectionHeader r100) throws IOException {
        ByteBuffer r101 = ByteBuffer.allocate((int) r100.shSize);
        this.fis.getChannel().position(r100.shOffset);
        readUntilLimit(this.fis.getChannel(), r101, "failed to read section: " + r100.shNameStr);
        return r101;
    }

    private static String readCString(ByteBuffer r100) {
        byte[] r101 = r100.array();
        int r102 = r100.position();
    L4:
        if (r100.hasRemaining() == false) goto L8;
        if (r101[r100.position()] == 0) goto L8;
        r100.position(r100.position() + 1);
    L8:
        r100.position(r100.position() + 1);
        return new String(r101, r102, (r100.position() - r102) - 1, Charset.forName("ASCII"));
    }

    public static /* synthetic */ void access$400(FileChannel r100, ByteBuffer r101, String r102) throws IOException {
        readUntilLimit(r100, r101, r102);
    }

    private static void readUntilLimit(FileChannel r100, ByteBuffer r101, String r102) throws IOException {
        r101.rewind();
        int r103 = r100.read(r101);
        if (r103 != r101.limit()) goto L7;
        r101.flip();
        return;
    L7:
        throw new IOException(r102 + " Rest bytes insufficient, expect to read " + r101.limit() + " bytes but only " + r103 + " bytes were read.");
    }

    public static /* synthetic */ void access$300(int r100, int r101, int r102, String r103) throws IOException {
        assertInRange(r100, r101, r102, r103);
    }

    private static void assertInRange(int r100, int r101, int r102, String r103) throws IOException {
        if (r100 < r101) goto L6;
        if (r100 > r102) goto L6;
        return;
    L6:
        throw new IOException(r103);
    }
}
