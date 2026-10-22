package com.bytedance.mira.plugin.core.func.soloader.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes21.dex */
public class Elf32Header extends Elf.Header {
    private final ElfParser parser;

    @Override // com.bytedance.mira.plugin.core.func.soloader.elf.Elf.Header
    public Elf.ProgramHeader getProgramHeader(long r100) throws IOException {
        return new Program32Header(this.parser, this, r100);
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.elf.Elf.Header
    public Elf.SectionHeader getSectionHeader(int r100) throws IOException {
        return new Section32Header(this.parser, this, r100);
    }

    public Elf32Header(boolean r100, ElfParser r101) throws IOException {
        this.bigEndian = r100;
        this.parser = r101;
        ByteBuffer r102 = ByteBuffer.allocate(4);
        if (r100 == false) goto L5;
        ByteOrder r103 = ByteOrder.BIG_ENDIAN;
    L6:
        r102.order(r103);
        this.type = r101.readHalf(r102, 16);
        this.phoff = r101.readWord(r102, 28);
        this.shoff = r101.readWord(r102, 32);
        this.phentsize = r101.readHalf(r102, 42);
        this.phnum = r101.readHalf(r102, 44);
        this.shentsize = r101.readHalf(r102, 46);
        this.shnum = r101.readHalf(r102, 48);
        this.shstrndx = r101.readHalf(r102, 50);
        return;
    L5:
        r103 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.elf.Elf.Header
    public Elf.DynamicStructure getDynamicStructure(long r100, int r110) throws IOException {
        return new Dynamic32Structure(this.parser, this, r100, r110);
    }
}
