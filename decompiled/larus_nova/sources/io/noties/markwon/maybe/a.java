package io.noties.markwon.maybe;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements vvc.f {
    public a() {
    }

    @Override // vvc.f
    public final uvc.b a(uvc.b r100) {
        uvc.b r101 = r100;
    L3:
        uvc.b r102 = r101.f551902c;
        if (r102 == null) goto L7;
        r101 = r102;
        goto L3
    L7:
        if ((r101 instanceof MaybeNode) == true) goto L11;
        uvc.b r103 = r101.f551900a;
        if (r103 == null) goto L11;
        r101 = r103;
    L11:
        b(r100, r101);
        return r100;
    }

    public static void b(uvc.b r100, uvc.b r101) {
        uvc.b r102 = r100.f551901b;
    L3:
        if (r102 == null) goto L10;
        uvc.b r103 = r102.f551904e;
        if ((r102 instanceof MaybeNode) == false) goto L8;
        if (r102 == r101) goto L8;
        MaybeNode r104 = (MaybeNode) r102;
        r104.d(r104.f551901b);
        r104.g();
    L9:
        r102 = r103;
    L8:
        b(r102, r101);
        goto L9
    }
}
