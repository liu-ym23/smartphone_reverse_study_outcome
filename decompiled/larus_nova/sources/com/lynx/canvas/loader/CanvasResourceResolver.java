package com.lynx.canvas.loader;

import android.graphics.Bitmap;
import com.lynx.canvas.KryptonLLog;

/* JADX INFO: loaded from: classes32.dex */
public class CanvasResourceResolver extends ResourceResolver {
    private static final String TAG = "KryptonCanvasResourceResolver";
    private final long mNativeResolverPtr;
    private final String mUrl;

    private native void nativeReject(String r100, long r101);

    private native void nativeResolveBytes(byte[] r100, int r101, int r102, long r103);

    private native void nativeResolveImage(Bitmap r100, long r101, boolean r102);

    private native void nativeResolveStreamLoadData(byte[] r100, int r101, int r102, long r103);

    private native void nativeResolveStreamLoadEnd(boolean r100, String r101, long r102);

    private native void nativeResolveStreamLoadStart(int r100, long r101);

    private native void nativeResolveText(String r100, long r101);

    @Override // com.lynx.canvas.loader.ResourceResolver
    public void reject(String r100) {
        if (getStatus() != ResolverStatus.PENDING) goto L5;
        KryptonLLog.i(TAG, "Resource request is rejected with url: " + KryptonResourceUtils.getTruncatePath(this.mUrl));
        nativeReject(r100, this.mNativeResolverPtr);
    L5:
        setStatus(ResolverStatus.REJECTED);
    }

    @Override // com.lynx.canvas.loader.ResourceResolver
    public void resolve(Bitmap r100) {
        if (getStatus() != ResolverStatus.PENDING) goto L5;
        KryptonLLog.i(TAG, "Image resource request is resolved with url: " + KryptonResourceUtils.getTruncatePath(this.mUrl));
        nativeResolveImage(r100, this.mNativeResolverPtr, r100.isPremultiplied());
    L5:
        setStatus(ResolverStatus.RESOLVED);
    }

    @Override // com.lynx.canvas.loader.ResourceResolver
    public void resolveStreamLoadStart(int r100) {
        nativeResolveStreamLoadStart(r100, this.mNativeResolverPtr);
    }

    @Override // com.lynx.canvas.loader.ResourceResolver
    public void resolve(String r100) {
        if (getStatus() != ResolverStatus.PENDING) goto L5;
        KryptonLLog.i(TAG, "Resource request is resolved with url: " + KryptonResourceUtils.getTruncatePath(this.mUrl));
        nativeResolveText(r100, this.mNativeResolverPtr);
    L5:
        setStatus(ResolverStatus.RESOLVED);
    }

    public CanvasResourceResolver(long r100, String r101) {
        this.mNativeResolverPtr = r100;
        this.mUrl = r101;
    }

    @Override // com.lynx.canvas.loader.ResourceResolver
    public void resolveStreamLoadEnd(boolean r100, String r101) {
        nativeResolveStreamLoadEnd(r100, r101, this.mNativeResolverPtr);
    }

    @Override // com.lynx.canvas.loader.ResourceResolver
    public void resolve(byte[] r100, int r110, int r111) {
        if (getStatus() != ResolverStatus.PENDING) goto L5;
        KryptonLLog.i(TAG, "Resource request is resolved with url: " + KryptonResourceUtils.getTruncatePath(this.mUrl));
        nativeResolveBytes(r100, r110, r111, this.mNativeResolverPtr);
    L5:
        setStatus(ResolverStatus.RESOLVED);
    }

    @Override // com.lynx.canvas.loader.ResourceResolver
    public void resolveStreamLoadData(byte[] r100, int r101, int r102) {
        nativeResolveStreamLoadData(r100, r101, r102, this.mNativeResolverPtr);
    }
}
