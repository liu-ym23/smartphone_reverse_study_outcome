package com.larus.connector;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class e extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConnectorAdapter.ConnectorViewHolder f330198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f330199b;

    public e(ConnectorAdapter.ConnectorViewHolder r100, String r101) {
        this.f330198a = r100;
        this.f330199b = r101;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        if (Intrinsics.areEqual(this.f330198a.f330155g, this.f330199b) == false) goto L6;
        this.f330198a.T3(false);
        return;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        if (((ImageInfo) r101) != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.f330198a.f330155g, this.f330199b) == false) goto L9;
        this.f330198a.T3(true);
        return;
    }
}
