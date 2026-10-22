package com.bytedance.ies.xelement;

import com.alibaba.gaiax.render.view.GXViewKey;

/* JADX INFO: loaded from: classes19.dex */
public final class t implements BounceLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxScrollView f250374a;

    public t(LynxScrollView r100) {
        this.f250374a = r100;
    }

    @Override // com.bytedance.ies.xelement.BounceLayout.b
    public final void a(int r110, int r111, int r112, int r113) {
        if (((BounceLayout) LynxScrollView.Q(this.f250374a)).getMEnableBounce() == true) goto L6;
        return;
    L6:
        if (((BounceLayout) LynxScrollView.Q(this.f250374a)).getMScrollDirection() != BounceLayout.ScrollDirection.HORIZONTAL_LEFT) goto L8;
    L11:
        LynxScrollView r100 = this.f250374a;
        int r101 = r100.f249673s;
        r100.V(r101 + r110, 0, r101 + r112, 0, GXViewKey.VIEW_TYPE_CONTAINER_SCROLL);
        return;
    L8:
        if (((BounceLayout) LynxScrollView.Q(this.f250374a)).getMScrollDirection() == BounceLayout.ScrollDirection.HORIZONTAL_RIGHT) goto L11;
        LynxScrollView r102 = this.f250374a;
        int r103 = r102.f249673s;
        r102.V(0, r103 + r111, 0, r103 + r113, GXViewKey.VIEW_TYPE_CONTAINER_SCROLL);
    }
}
