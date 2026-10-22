package com.bytedance.mira.plugin.core.func.soloader.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes21.dex */
public class Section32Header extends Elf.SectionHeader {
    public Section32Header(ElfParser r100, Elf.Header r101, int r102) throws IOException {
        ByteBuffer r103 = ByteBuffer.allocate(4);
        if (r101.bigEndian == false) goto L5;
        ByteOrder r104 = ByteOrder.BIG_ENDIAN;
    L6:
        r103.order(r104);
        this.info = r100.readWord(r103, (r101.shoff + ((long) (r102 * r101.shentsize))) + 28);
        return;
    L5:
        r104 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
