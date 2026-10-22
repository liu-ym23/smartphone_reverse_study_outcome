package org.bouncycastle.math.raw;

/* JADX INFO: loaded from: classes42.dex */
public abstract class Nat384 {
    public Nat384() {
    }

    public static void mul(int[] r110, int[] r111, int[] r112) {
        Nat192.mul(r110, r111, r112);
        Nat192.mul(r110, 6, r111, 6, r112, 12);
        int r100 = Nat192.addToEachOther(r112, 6, r112, 12);
        int r101 = r100 + Nat192.addTo(r112, 18, r112, 12, Nat192.addTo(r112, 0, r112, 6, 0) + r100);
        int[] r102 = Nat192.create();
        int[] r113 = Nat192.create();
        if (Nat192.diff(r110, 6, r110, 0, r102, 0) == Nat192.diff(r111, 6, r111, 0, r113, 0)) goto L5;
        boolean r114 = true;
    L6:
        int[] r115 = Nat192.createExt();
        Nat192.mul(r102, r113, r115);
        if (r114 == false) goto L9;
        int r116 = Nat.addTo(12, r115, 0, r112, 6);
    L10:
        Nat.addWordAt(24, r101 + r116, r112, 18);
        return;
    L9:
        r116 = Nat.subFrom(12, r115, 0, r112, 6);
        goto L10
    L5:
        r114 = false;
        goto L6
    }

    public static void square(int[] r110, int[] r111) {
        Nat192.square(r110, r111);
        Nat192.square(r110, 6, r111, 12);
        int r100 = Nat192.addToEachOther(r111, 6, r111, 12);
        int r101 = r100 + Nat192.addTo(r111, 18, r111, 12, Nat192.addTo(r111, 0, r111, 6, 0) + r100);
        int[] r102 = Nat192.create();
        Nat192.diff(r110, 6, r110, 0, r102, 0);
        int[] r112 = Nat192.createExt();
        Nat192.square(r102, r112);
        Nat.addWordAt(24, r101 + Nat.subFrom(12, r112, 0, r111, 6), r111, 18);
    }
}
