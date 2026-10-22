package com.ss.android.lark.widget.ptr;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f448060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f448061b;

    public final boolean f() {
        if (this.f448060a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public b() {
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void b(LKUIPtrFrameLayout r100) {
        b r101 = this;
    L3:
        a r102 = r101.f448060a;
        if (r102 == null) goto L6;
        r102.b(r100);
    L6:
        r101 = r101.f448061b;
        if (r101 != null) goto L3;
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void d(LKUIPtrFrameLayout r100) {
        if (f() == true) goto L5;
        return;
    L5:
        b r101 = this;
    L6:
        a r102 = r101.f448060a;
        if (r102 == null) goto L9;
        r102.d(r100);
    L9:
        r101 = r101.f448061b;
        if (r101 != null) goto L6;
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void e(LKUIPtrFrameLayout r100) {
        b r101 = this;
    L3:
        a r102 = r101.f448060a;
        if (r102 == null) goto L6;
        r102.e(r100);
    L6:
        r101 = r101.f448061b;
        if (r101 != null) goto L3;
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void a(LKUIPtrFrameLayout r100, boolean r101) {
        b r102 = this;
    L3:
        a r103 = r102.f448060a;
        if (r103 == null) goto L6;
        r103.a(r100, r101);
    L6:
        r102 = r102.f448061b;
        if (r102 != null) goto L3;
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void c(LKUIPtrFrameLayout r100, boolean r101, byte r102, wdc.a r103) {
        b r104 = this;
    L3:
        a r105 = r104.f448060a;
        if (r105 == null) goto L6;
        r105.c(r100, r101, r102, r103);
    L6:
        r104 = r104.f448061b;
        if (r104 != null) goto L3;
    }
}
