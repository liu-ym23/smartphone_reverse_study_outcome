package com.bytedance.ies.xelement;

/* JADX INFO: loaded from: classes19.dex */
public final class k implements AndroidNestedScrollView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxNestedScrollView f250101a;

    @Override // com.bytedance.ies.xelement.AndroidNestedScrollView.a
    public final void a() {
    }

    @Override // com.bytedance.ies.xelement.AndroidNestedScrollView.a
    public final void b() {
    }

    @Override // com.bytedance.ies.xelement.AndroidNestedScrollView.a
    public final void d() {
    }

    @Override // com.bytedance.ies.xelement.AndroidNestedScrollView.a
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
    }

    public k(LynxNestedScrollView r100) {
        this.f250101a = r100;
    }

    @Override // com.bytedance.ies.xelement.AndroidNestedScrollView.a
    public final void onScrollStateChanged(int r100) {
        LynxNestedScrollView r101 = this.f250101a;
        if (r101.f249647d == true) goto L7;
        if (r100 == 0) goto L10;
        r101.recognizeGesturere();
        return;
    L10:
        return;
    L7:
        if (r100 != 1) goto L12;
        r101.recognizeGesturere();
        return;
    }
}
