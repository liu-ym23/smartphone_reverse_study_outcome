package com.bytedance.ug.sdk.share.keep.impl;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import eo7.a;
import java.lang.ref.SoftReference;
import oo7.k;

/* JADX INFO: loaded from: classes22.dex */
public class DouYinConfigImpl {
    private SoftReference<DouYinOpenApi> douYinOpenApiCache;

    public DouYinConfigImpl() {
    }

    private DouYinOpenApi getDouYinOpenApi() {
        SoftReference<DouYinOpenApi> r100 = this.douYinOpenApiCache;
        if (r100 != null) goto L5;
    L6:
        a r101 = a.b.f473353a;
        Activity r102 = r101.h();
        if (r102 != null) goto L10;
        return null;
    L10:
        if (TextUtils.isEmpty(r101.f473339m) == true) goto L12;
        String r103 = r101.f473339m;
    L13:
        com.bytedance.sdk.open.douyin.a.init(new DouYinOpenConfig(r103));
        this.douYinOpenApiCache = new SoftReference(com.bytedance.sdk.open.douyin.a.create(r102));
    L14:
        SoftReference<DouYinOpenApi> r104 = this.douYinOpenApiCache;
        if (r104 != null) goto L18;
        return null;
    L18:
        return r104.get();
    L12:
        String r105 = r101.f("douyin");
        r101.f473339m = r105;
        r103 = r105;
        goto L13
    L5:
        if (r100.get() != null) goto L14;
        goto L6
    }

    public boolean isSupportDYStory() {
        DouYinOpenApi r100 = getDouYinOpenApi();     // Catch: Exception -> L6
        if (r100 == null) goto L12;
        return r100.isSupportApi(2, 5);
    L12:
        return false;
    L6:
        e = move-exception;
        k.b(e.getLocalizedMessage());
        return false;
    }

    public boolean isSupportSetDYStoryBackGround() {
        DouYinOpenApi r100 = getDouYinOpenApi();     // Catch: Exception -> L6
        if (r100 == null) goto L12;
        return r100.isSupportApi(2, 7);
    L12:
        return false;
    L6:
        e = move-exception;
        k.b(e.getLocalizedMessage());
        return false;
    }
}
