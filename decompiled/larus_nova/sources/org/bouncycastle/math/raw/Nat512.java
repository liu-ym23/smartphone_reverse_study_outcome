package org.bouncycastle.math.raw;

/* JADX INFO: loaded from: classes42.dex */
public abstract class Nat512 {
    public Nat512() {
    }

    public static void mul(int[] r110, int[] r111, int[] r112) {
        Nat256.mul(r110, r111, r112);
        Nat256.mul(r110, 8, r111, 8, r112, 16);
        int r100 = Nat256.addToEachOther(r112, 8, r112, 16);
        int r101 = r100 + Nat256.addTo(r112, 24, r112, 16, Nat256.addTo(r112, 0, r112, 8, 0) + r100);
        int[] r102 = Nat256.create();
        int[] r113 = Nat256.create();
        if (Nat256.diff(r110, 8, r110, 0, r102, 0) == Nat256.diff(r111, 8, r111, 0, r113, 0)) goto L5;
        boolean r114 = true;
    L6:
        int[] r115 = Nat256.createExt();
        Nat256.mul(r102, r113, r115);
        if (r114 == false) goto L9;
        int r116 = Nat.addTo(16, r115, 0, r112, 8);
    L10:
        Nat.addWordAt(32, r101 + r116, r112, 24);
        return;
    L9:
        r116 = Nat.subFrom(16, r115, 0, r112, 8);
        goto L10
    L5:
        r114 = false;
        goto L6
    }

    public static void square(int[] r110, int[] r111) {
        Nat256.square(r110, r111);
        Nat256.square(r110, 8, r111, 16);
        int r100 = Nat256.addToEachOther(r111, 8, r111, 16);
        int r101 = r100 + Nat256.addTo(r111, 24, r111, 16, Nat256.addTo(r111, 0, r111, 8, 0) + r100);
        int[] r102 = Nat256.create();
        Nat256.diff(r110, 8, r110, 0, r102, 0);
        int[] r112 = Nat256.createExt();
        Nat256.square(r102, r112);
        Nat.addWordAt(32, r101 + Nat.subFrom(16, r112, 0, r111, 8), r111, 24);
    }
}
