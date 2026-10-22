package com.ss.android.lark.image.api;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.util.Util;
import rkb.f;

/* JADX INFO: loaded from: classes36.dex */
public class SimpleTarget<R> implements Target<R> {
    private final int height;
    private Request originRequest;
    private f request;
    private final int width;

    @Override // com.ss.android.lark.image.api.Target
    public void onLoadCleared(Drawable r100) {
    }

    @Override // com.ss.android.lark.image.api.Target
    public void onLoadFailed(Drawable r100) {
    }

    @Override // com.ss.android.lark.image.api.Target
    public void onLoadStarted(Drawable r100) {
    }

    @Override // com.ss.android.lark.image.api.Target
    public void onResourceReady(R r100) {
    }

    @Override // com.ss.android.lark.image.api.Target
    public void removeCallback(SizeReadyCallback r100) {
    }

    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.ss.android.lark.image.api.Target
    public Request getOriginRequest() {
        return this.originRequest;
    }

    @Override // com.ss.android.lark.image.api.Target
    public f getRequest() {
        return this.request;
    }

    @Override // com.ss.android.lark.image.api.Target
    public final void getSize(SizeReadyCallback r100) {
        if (Util.isValidDimensions(this.width, this.height) == false) goto L7;
        r100.onSizeReady(this.width, this.height);
        return;
    L7:
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.width + " and height: " + this.height + ", either provide dimensions in the constructor or call override()");
    }

    @Override // com.ss.android.lark.image.api.Target
    public void setOriginRequest(Request r100) {
        this.originRequest = r100;
    }

    @Override // com.ss.android.lark.image.api.Target
    public void setRequest(f r100) {
        this.request = r100;
    }

    public SimpleTarget(int r100, int r101) {
        this.width = r100;
        this.height = r101;
    }
}
