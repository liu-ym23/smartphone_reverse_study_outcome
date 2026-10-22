package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.crypto.engines.ChaChaEngine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
class Seed {
    public Seed() {
    }

    public static void get_seed(HashFunctions r100, byte[] r101, int r110, byte[] r111, Tree.leafaddr r112) {
        byte[] r102 = new byte[40];
        int r103 = 0;
    L4:
        if (r103 >= 32) goto L6;
        r102[r103] = r111[r103];
        r103 = r103 + 1;
        goto L4
    L6:
        long r104 = ((long) r112.level) | (r112.subtree << 4);
        Pack.longToLittleEndian((r112.subleaf << 59) | r104, r102, 32);
        r100.varlen_hash(r101, r110, r102, 40);
    }

    public static void prg(byte[] r100, int r101, long r102, byte[] r110, int r111) {
        ChaChaEngine r103 = new ChaChaEngine(12);
        KeyParameter r104 = new KeyParameter(r110, r111, 32);
        r103.init(true, new ParametersWithIV(r104, new byte[8]));
        r103.processBytes(r100, r101, (int) r102, r100, r101);
    }
}
