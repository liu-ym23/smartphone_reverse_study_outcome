package com.lynx.canvas.loader;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes32.dex */
public abstract class ResourceResolver {
    private ResolverStatus mStatus;

    public void reject(String r100) {
    }

    public void resolve(Bitmap r100) {
    }

    public void resolve(String r100) {
    }

    public void resolve(byte[] r100, int r101, int r102) {
    }

    public void resolveStreamLoadData(byte[] r100, int r101, int r102) {
    }

    public void resolveStreamLoadEnd(boolean r100, String r101) {
    }

    public void resolveStreamLoadStart(int r100) {
    }

    public ResourceResolver() {
        this.mStatus = ResolverStatus.PENDING;
    }

    public ResolverStatus getStatus() {
        return this.mStatus;
    }

    public void setStatus(ResolverStatus r100) {
        this.mStatus = r100;
    }
}
