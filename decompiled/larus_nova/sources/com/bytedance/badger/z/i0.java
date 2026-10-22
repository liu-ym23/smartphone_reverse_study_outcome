package com.bytedance.badger.z;

/* JADX INFO: loaded from: classes47.dex */
public final class i0 implements z64.g {
    public i0() {
    }

    @Override // z64.g
    public final void a(z64.i r100) {
        if ((r100 instanceof z64.i.a) == false) goto L6;
        StringBuilder r101 = new StringBuilder(" complete and set async. error");
        r101.append(((z64.i.a) r100).f570475a);
    L8:
        com.bytedance.badger.e.b("sensor#", r101.toString());
        return;
    L6:
        if ((r100 instanceof z64.i.b) == false) goto L10;
        r101 = new StringBuilder(" complete and set async. is full?");
        r101.append(((z64.i.b) r100).f570480c);
        goto L8
    }
}
