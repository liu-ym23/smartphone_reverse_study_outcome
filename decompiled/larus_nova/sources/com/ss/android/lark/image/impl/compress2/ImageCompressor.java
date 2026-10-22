package com.ss.android.lark.image.impl.compress2;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes36.dex */
public class ImageCompressor {
    private final Context mContext;
    private IParamsProvider mParamsProvider;
    private String mTargetDir;

    private void notifyError(Throwable r100, boolean r101) {
    }

    private void notifyStart(boolean r100) {
    }

    private void notifySuccess(CompressResult r100, boolean r101) {
    }

    private ImageCompressor(Context r100) {
        this.mContext = r100;
    }

    private CompressRequest buildRequest(IImageSource r100) {
        return CompressRequest.newBuilder().iImageSource(r100).build();
    }

    public static ImageCompressor with(Context r100) {
        return new ImageCompressor(r100);
    }

    public ImageCompressor paramsProvider(IParamsProvider r100) {
        this.mParamsProvider = r100;
        return this;
    }

    public CompressResult startCompress(File r100) {
        return doCompress(new FileImageSource(r100), false);
    }

    public ImageCompressor targetDir(String r100) {
        this.mTargetDir = r100;
        return this;
    }

    private CompressResult doCompress(IImageSource r100, boolean r101) {
        notifyStart(r101);
        CompressResult r102 = new CompressEngine(new CompressImageCache(this.mContext, this.mTargetDir), new CompressStrategy(this.mParamsProvider)).compress(buildRequest(r100));     // Catch: Exception -> L5
        notifySuccess(r102, r101);     // Catch: Exception -> L5
        return r102;
    L5:
        e = move-exception;
        e.printStackTrace();
        notifyError(e, r101);
        return new CompressResult(e);
    }
}
