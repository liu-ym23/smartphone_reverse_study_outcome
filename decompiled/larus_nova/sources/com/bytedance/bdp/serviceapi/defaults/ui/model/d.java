package com.bytedance.bdp.serviceapi.defaults.ui.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import com.bytedance.bdp.bdpplatform.service.image.PreviewImageActivity;

/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f201589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f201590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f201591c;

    public d(Uri r100) {
        Bitmap.Config r101 = Bitmap.Config.RGB_565;
        this.f201590b = r100;
    }

    public d(String r100, PreviewImageActivity.PinchImageView r101) {
        Bitmap.Config r102 = Bitmap.Config.RGB_565;
        this.f201589a = r100;
        this.f201591c = r101;
    }
}
