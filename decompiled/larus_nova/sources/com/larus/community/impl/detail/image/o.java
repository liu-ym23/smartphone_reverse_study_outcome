package com.larus.community.impl.detail.image;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes27.dex */
public final class o implements CreationZoomableDraweeView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CreationDetailImageView f329341a;

    @Override // com.larus.community.impl.detail.image.CreationZoomableDraweeView.b
    public final void c() {
        Function0<Unit> r100 = this.f329341a.getOnImageDoubleTapListener();
        if (r100 == null) goto L6;
        r100.invoke();
        return;
    }

    public o(CreationDetailImageView r100) {
        this.f329341a = r100;
    }
}
