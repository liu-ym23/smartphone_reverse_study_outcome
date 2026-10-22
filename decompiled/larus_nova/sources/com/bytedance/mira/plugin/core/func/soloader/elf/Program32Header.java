package com.bytedance.mira.plugin.core.func.soloader.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes21.dex */
public class Program32Header extends Elf.ProgramHeader {
    public Program32Header(ElfParser r100, Elf.Header r101, long r102) throws IOException {
        ByteBuffer r103 = ByteBuffer.allocate(4);
        if (r101.bigEndian == false) goto L5;
        ByteOrder r104 = ByteOrder.BIG_ENDIAN;
    L6:
        r103.order(r104);
        long r105 = r101.phoff + (r102 * ((long) r101.phentsize));
        this.type = r100.readWord(r103, r105);
        this.offset = r100.readWord(r103, 4 + r105);
        this.vaddr = r100.readWord(r103, 8 + r105);
        this.memsz = r100.readWord(r103, r105 + 20);
        return;
    L5:
        r104 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
