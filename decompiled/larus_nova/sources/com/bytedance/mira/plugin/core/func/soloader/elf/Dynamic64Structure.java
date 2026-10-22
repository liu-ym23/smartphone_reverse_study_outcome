package com.bytedance.mira.plugin.core.func.soloader.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes21.dex */
public class Dynamic64Structure extends Elf.DynamicStructure {
    public Dynamic64Structure(ElfParser r100, Elf.Header r101, long r102, int r103) throws IOException {
        ByteBuffer r104 = ByteBuffer.allocate(8);
        if (r101.bigEndian == false) goto L5;
        ByteOrder r105 = ByteOrder.BIG_ENDIAN;
    L6:
        r104.order(r105);
        long r106 = r102 + ((long) (r103 * 16));
        this.tag = r100.readLong(r104, r106);
        this.val = r100.readLong(r104, r106 + 8);
        return;
    L5:
        r105 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
