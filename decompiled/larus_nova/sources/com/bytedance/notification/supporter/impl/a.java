package com.bytedance.notification.supporter.impl;

import android.graphics.Bitmap;
import com.bytedance.android.service.manager.push.notification.AsyncImageDownloader;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements w37.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AsyncImageDownloader f266092a;

    public a() {
    }

    public final Bitmap a(String r100) {
        return this.f266092a.downloadImage(new t67.c(UriProtector.parse(r100)));
    }
}
