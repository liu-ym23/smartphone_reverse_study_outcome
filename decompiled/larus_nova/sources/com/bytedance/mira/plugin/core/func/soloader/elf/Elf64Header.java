package com.bytedance.mira.plugin.core.func.soloader.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes21.dex */
public class Elf64Header extends Elf.Header {
    private final ElfParser parser;

    @Override // com.bytedance.mira.plugin.core.func.soloader.elf.Elf.Header
    public Elf.ProgramHeader getProgramHeader(long r100) throws IOException {
        return new Program64Header(this.parser, this, r100);
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.elf.Elf.Header
    public Elf.SectionHeader getSectionHeader(int r100) throws IOException {
        return new Section64Header(this.parser, this, r100);
    }

    public Elf64Header(boolean r100, ElfParser r101) throws IOException {
        this.bigEndian = r100;
        this.parser = r101;
        ByteBuffer r102 = ByteBuffer.allocate(8);
        if (r100 == false) goto L5;
        ByteOrder r103 = ByteOrder.BIG_ENDIAN;
    L6:
        r102.order(r103);
        this.type = r101.readHalf(r102, 16);
        this.phoff = r101.readLong(r102, 32);
        this.shoff = r101.readLong(r102, 40);
        this.phentsize = r101.readHalf(r102, 54);
        this.phnum = r101.readHalf(r102, 56);
        this.shentsize = r101.readHalf(r102, 58);
        this.shnum = r101.readHalf(r102, 60);
        this.shstrndx = r101.readHalf(r102, 62);
        return;
    L5:
        r103 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.elf.Elf.Header
    public Elf.DynamicStructure getDynamicStructure(long r100, int r110) throws IOException {
        return new Dynamic64Structure(this.parser, this, r100, r110);
    }
}
