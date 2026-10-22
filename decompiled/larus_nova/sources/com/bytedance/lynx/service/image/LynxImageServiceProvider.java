package com.bytedance.lynx.service.image;

import a7a.d;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.service.ILynxImageServiceExtension;
import com.lynx.tasm.service.IServiceProvider;
import java.util.Map;
import u07.c;
import u07.f;
import v7a.a;
import v7a.e;

/* JADX INFO: loaded from: classes21.dex */
public class LynxImageServiceProvider implements ILynxImageService, ILynxImageServiceExtension {
    public LynxImageServiceProvider() {
    }

    @Override // com.lynx.tasm.service.ILynxImageService, com.lynx.tasm.service.IServiceProvider
    public final /* synthetic */ Class getServiceClass() {
        return ILynxImageService.CC.$default$getServiceClass(this);
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    public final /* synthetic */ void onInitialize(Context r100) {
        IServiceProvider.CC.$default$onInitialize(this, r100);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public Object getImageSRPostProcessor() {
        c.f().getClass();
        return f.a();
    }

    @Override // com.lynx.tasm.service.ILynxImageServiceExtension
    public void onLynxEnvSetup() {
        c.f().onLynxEnvSetup();
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public boolean canParseUrl(String r100) {
        return c.f().canParseUrl(r100);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public int getImageOrigin(Object r100) {
        return c.f().getImageOrigin(r100);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public boolean pauseAnimation(Drawable r100) {
        return c.f().pauseAnimation(r100);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void releaseAnimDrawable(Drawable r100) {
        c.f().releaseAnimDrawable(r100);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void releaseImage(v7a.f r100) {
        c.f().releaseImage(r100);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public boolean resumeAnimation(Drawable r100) {
        return c.f().resumeAnimation(r100);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void setCustomImageDecoder(Object r100) {
        c.f().setCustomImageDecoder(r100);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public boolean startAnimation(Drawable r100) {
        return c.f().startAnimation(r100);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public boolean stopAnimation(Drawable r100) {
        return c.f().stopAnimation(r100);
    }

    @Override // com.lynx.tasm.service.ILynxImageServiceExtension
    public d createBackgroundImageDrawable(Context r100, String r101) {
        return c.f().createBackgroundImageDrawable(r100, r101);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void decodeImage(v7a.f r100, e r101) {
        c.f().decodeImage(r100, r101);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void setCacheKeyUri(Object r100, Uri r101) {
        c.f().setCacheKeyUri(r100, r101);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void setImageCacheChoice(String r100, Object r101) {
        c.f().setImageCacheChoice(r100, r101);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void setImageDecodeRegion(Object r100, Rect r101) {
        c.f().setImageDecodeRegion(r100, r101);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void setImageSRSize(Object r100, View r101) {
        c.f().setImageSRSize(r100, r101);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void setSampleSize(Object r100, int r101) {
        c.f().setSampleSize(r100, r101);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void prefetchImage(String r100, Object r101, Map<String, Object> r102) {
        c.f().prefetchImage(r100, r101, r102, null);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void setImageSRSize(Object r100, int r101, int r102) {
        c.f().setImageSRSize(r100, r101, r102);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void fetchImage(v7a.f r100, e r101, a r102, Context r103) {
        c.f().fetchImage(r100, r101, r102, r103);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void prefetchImage(String r100, Object r101, Map<String, Object> r102, e r103) {
        c.f().prefetchImage(r100, r101, r102, r103);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void setImagePlaceHolderHash(Object r110, Object r111, Object r112, String r113, String r114, int r115, int r116, int r117, int r210, boolean r211) {
        c.f().setImagePlaceHolderHash(r110, r111, r112, r113, r114, r115, r116, r117, r210, r211);
    }
}
