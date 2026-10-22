package com.lynx.tasm.service;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import java.util.Map;
import v7a.a;
import v7a.e;
import v7a.f;

/* JADX INFO: loaded from: classes32.dex */
public interface ILynxImageService extends IServiceProvider {

    /* JADX INFO: renamed from: com.lynx.tasm.service.ILynxImageService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Class $default$getServiceClass(ILynxImageService r100) {
            return ILynxImageService.class;
        }
    }

    boolean canParseUrl(String r100);

    void decodeImage(f r100, e r101);

    void fetchImage(f r100, e r101, a r102, Context r103);

    int getImageOrigin(Object r100);

    Object getImageSRPostProcessor();

    @Override // com.lynx.tasm.service.IServiceProvider
    Class<? extends IServiceProvider> getServiceClass();

    boolean pauseAnimation(Drawable r100);

    void prefetchImage(String r100, Object r101, Map<String, Object> r102);

    void prefetchImage(String r100, Object r101, Map<String, Object> r102, e r103);

    void releaseAnimDrawable(Drawable r100);

    void releaseImage(f r100);

    boolean resumeAnimation(Drawable r100);

    void setCacheKeyUri(Object r100, Uri r101);

    void setCustomImageDecoder(Object r100);

    void setImageCacheChoice(String r100, Object r101);

    void setImageDecodeRegion(Object r100, Rect r101);

    void setImagePlaceHolderHash(Object r100, Object r101, Object r102, String r103, String r104, int r105, int r106, int r107, int r108, boolean r110);

    void setImageSRSize(Object r100, int r101, int r102);

    void setImageSRSize(Object r100, View r101);

    void setSampleSize(Object r100, int r101);

    boolean startAnimation(Drawable r100);

    boolean stopAnimation(Drawable r100);
}
