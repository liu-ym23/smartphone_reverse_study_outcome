package com.bytedance.sdk.open.aweme.commonbase;

import android.content.Context;
import com.bytedance.sdk.open.aweme.core.OpenImageService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.core.image.LoadImageOptions;

/* JADX INFO: loaded from: classes22.dex */
public class ImageUtils {
    public ImageUtils() {
    }

    public static void loadImage(Context r100, LoadImageOptions r101) {
        OpenImageService r102 = (OpenImageService) OpenServiceManager.getInst().getService(OpenImageService.class);
        if (r102 != null) goto L5;
        return;
    L5:
        r102.loadImage(r100, r101);
    }
}
