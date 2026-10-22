package com.larus.paging;

/* JADX INFO: loaded from: classes29.dex */
public final class d implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e<Object> f363798a;

    public d(e<Object> r100) {
        this.f363798a = r100;
    }

    @Override // com.larus.paging.l
    public final void a(int r100, int r101) {
        if (r101 <= 0) goto L5;
        this.f363798a.f363807b.onChanged(r100, r101, null);
        return;
    }

    @Override // com.larus.paging.l
    public final void onInserted(int r100, int r101) {
        if (r101 <= 0) goto L5;
        this.f363798a.f363807b.onInserted(r100, r101);
        return;
    }

    @Override // com.larus.paging.l
    public final void onRemoved(int r100, int r101) {
        if (r101 <= 0) goto L5;
        this.f363798a.f363807b.onRemoved(r100, r101);
        return;
    }
}
