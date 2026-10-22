package com.bytedance.badger.z;

/* JADX INFO: loaded from: classes47.dex */
public final class f0 implements z64.g {
    public f0() {
    }

    @Override // z64.g
    public final void a(z64.i r100) {
        if ((r100 instanceof z64.i.a) == false) goto L6;
        com.bytedance.badger.e.g("oppo#", " complete and set async. error" + ((z64.i.a) r100).f570475a);
        return;
    L6:
        if ((r100 instanceof z64.i.b) == false) goto L10;
        com.bytedance.badger.e.b("oppo#", " complete and set async. is full?" + ((z64.i.b) r100).f570480c);
        return;
    }
}
