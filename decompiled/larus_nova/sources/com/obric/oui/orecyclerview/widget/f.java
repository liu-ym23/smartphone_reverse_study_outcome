package com.obric.oui.orecyclerview.widget;

/* JADX INFO: loaded from: classes34.dex */
public final class f implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f401810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f401811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f401812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f401813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f401814e;

    public final void a() {
        int r100 = this.f401811b;
        if (r100 != 0) goto L6;
        return;
    L6:
        if (r100 != 1) goto L8;
        this.f401810a.onInserted(this.f401812c, this.f401813d);
    L15:
        this.f401814e = null;
        this.f401811b = 0;
        return;
    L8:
        if (r100 != 2) goto L10;
        this.f401810a.onRemoved(this.f401812c, this.f401813d);
        goto L15
    L10:
        if (r100 != 3) goto L15;
        this.f401810a.onChanged(this.f401812c, this.f401813d, this.f401814e);
        goto L15
    }

    public f(x r100) {
        this.f401811b = 0;
        this.f401812c = -1;
        this.f401813d = -1;
        this.f401814e = null;
        this.f401810a = r100;
    }

    @Override // com.obric.oui.orecyclerview.widget.x
    public final void onInserted(int r100, int r101) {
        if (this.f401811b != 1) goto L10;
        int r102 = this.f401812c;
        if (r100 < r102) goto L10;
        int r103 = this.f401813d;
        if (r100 > (r102 + r103)) goto L10;
        this.f401813d = r103 + r101;
        this.f401812c = Math.min(r100, r102);
        return;
    L10:
        a();
        this.f401812c = r100;
        this.f401813d = r101;
        this.f401811b = 1;
    }

    @Override // com.obric.oui.orecyclerview.widget.x
    public final void onMoved(int r100, int r101) {
        a();
        this.f401810a.onMoved(r100, r101);
    }

    @Override // com.obric.oui.orecyclerview.widget.x
    public final void onRemoved(int r100, int r101) {
        if (this.f401811b != 2) goto L10;
        int r102 = this.f401812c;
        if (r102 < r100) goto L10;
        if (r102 > (r100 + r101)) goto L10;
        this.f401813d += r101;
        this.f401812c = r100;
        return;
    L10:
        a();
        this.f401812c = r100;
        this.f401813d = r101;
        this.f401811b = 2;
    }

    @Override // com.obric.oui.orecyclerview.widget.x
    public final void onChanged(int r100, int r101, Object r102) {
        if (this.f401811b != 3) goto L12;
        int r103 = this.f401812c;
        int r104 = this.f401813d;
        if (r100 > (r103 + r104)) goto L12;
        int r105 = r100 + r101;
        if (r105 < r103) goto L12;
        if (this.f401814e != r102) goto L12;
        this.f401812c = Math.min(r100, r103);
        this.f401813d = Math.max(r104 + r103, r105) - this.f401812c;
        return;
    L12:
        a();
        this.f401812c = r100;
        this.f401813d = r101;
        this.f401814e = r102;
        this.f401811b = 3;
    }
}
