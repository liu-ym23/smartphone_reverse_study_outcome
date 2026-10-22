package com.bytedance.creativex.mediaimport.view.internal.base;

/* JADX INFO: loaded from: classes15.dex */
public final class v0 implements ti4.y.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseMediaSelectListView<Object> f203878a;

    public v0(BaseMediaSelectListView<Object> r100) {
        this.f203878a = r100;
    }

    @Override // ti4.y.a
    public final int a(int r100) {
        BaseMediaSelectListView<Object> r101 = this.f203878a;
        BaseMediaSelectListView.b<Object> r102 = r101.f203744r;
        if (r102.f203788y == true) goto L5;
        return r100;
    L5:
        if (r102.A == true) goto L7;
        return r100;
    L7:
        return r101.l(r100);
    }
}
