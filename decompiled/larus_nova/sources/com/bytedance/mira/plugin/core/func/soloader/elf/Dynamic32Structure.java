package com.bytedance.mira.plugin.core.func.soloader.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes21.dex */
public class Dynamic32Structure extends Elf.DynamicStructure {
    public Dynamic32Structure(ElfParser r100, Elf.Header r101, long r102, int r103) throws IOException {
        ByteBuffer r104 = ByteBuffer.allocate(4);
        if (r101.bigEndian == false) goto L5;
        ByteOrder r105 = ByteOrder.BIG_ENDIAN;
    L6:
        r104.order(r105);
        long r106 = r102 + ((long) (r103 * 8));
        this.tag = r100.readWord(r104, r106);
        this.val = r100.readWord(r104, r106 + 4);
        return;
    L5:
        r105 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
