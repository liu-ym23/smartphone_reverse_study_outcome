package com.ss.android.lark.image.api;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import rkb.f;

/* JADX INFO: loaded from: classes36.dex */
public interface Target<R> {
    public static final int SIZE_ORIGINAL = Integer.MIN_VALUE;

    Request getOriginRequest();

    f getRequest();

    void getSize(SizeReadyCallback r100);

    void onLoadCleared(Drawable r100);

    void onLoadFailed(Drawable r100);

    void onLoadStarted(Drawable r100);

    void onResourceReady(R r100);

    void removeCallback(SizeReadyCallback r100);

    void setOriginRequest(Request r100);

    void setRequest(f r100);
}
