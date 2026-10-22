package com.larus.gallery.tracker;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes29.dex */
public final class d extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ThumbnailAdapter.ViewHolder f344042a;

    public d(ThumbnailAdapter.ViewHolder r100) {
        this.f344042a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        super.onFailure(r100, r101);
        FLogger r102 = FLogger.f375446a;
        String r103 = this.f344042a.f343998b;
        StringBuilder r104 = new StringBuilder("loadImage onFailure pos:");
        r104.append(this.f344042a.getAdapterPosition());
        r104.append(" error:");
        if (r101 == null) goto L5;
        String r105 = r101.getMessage();
    L6:
        r104.append(r105);
        r104.append(" retryCount:0");
        this.f344042a.getClass();
        r102.i(r103, r104.toString());
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        FLogger.f375446a.i(this.f344042a.f343998b, "loadImage onFinalImageSet");
    }
}
