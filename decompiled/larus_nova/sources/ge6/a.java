package ge6;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.bytedance.lark.lynxlib.image.LynxBackgroundLayerDrawable;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.service.ILynxImageServiceExtension;
import com.lynx.tasm.service.IServiceProvider;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.SimpleTarget;
import java.util.Map;
import v7a.d;
import v7a.e;
import v7a.f;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements ILynxImageService, ILynxImageServiceExtension {

    /* JADX INFO: renamed from: ge6.a$a, reason: collision with other inner class name */
    public class C6015a extends SimpleTarget<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f481021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f481022b;

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadFailed(Drawable r100) {
            super.onLoadFailed(r100);
            this.f481021a.onFailure(-1, new Throwable());
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadStarted(Drawable r100) {
            super.onLoadStarted(r100);
            this.f481021a.onRequestSubmit(this.f481022b);
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r100) {
            Drawable r101 = (Drawable) r100;
            super.onResourceReady(r101);
            this.f481021a.onSuccess(new u7a.a(r101), this.f481022b, new d(r101.getIntrinsicWidth(), r101.getIntrinsicHeight(), false, -1));
        }

        public C6015a(e r100, f r101) {
            this.f481021a = r100;
            this.f481022b = r101;
        }
    }

    public a() {
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final boolean canParseUrl(String r100) {
        return true;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final int getImageOrigin(Object r100) {
        return 0;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final Object getImageSRPostProcessor() {
        return null;
    }

    @Override // com.lynx.tasm.service.ILynxImageService, com.lynx.tasm.service.IServiceProvider
    public final /* synthetic */ Class getServiceClass() {
        return ILynxImageService.CC.$default$getServiceClass(this);
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    public final /* synthetic */ void onInitialize(Context r100) {
        IServiceProvider.CC.$default$onInitialize(this, r100);
    }

    @Override // com.lynx.tasm.service.ILynxImageServiceExtension
    public final void onLynxEnvSetup() {
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final boolean pauseAnimation(Drawable r100) {
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void prefetchImage(String r100, Object r101, Map<String, Object> r102) {
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void releaseAnimDrawable(Drawable r100) {
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void releaseImage(f r100) {
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final boolean resumeAnimation(Drawable r100) {
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void setCacheKeyUri(Object r100, Uri r101) {
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void setCustomImageDecoder(Object r100) {
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void setImageCacheChoice(String r100, Object r101) {
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void setImageDecodeRegion(Object r100, Rect r101) {
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void setImagePlaceHolderHash(Object r100, Object r101, Object r102, String r103, String r104, int r105, int r106, int r107, int r108, boolean r110) {
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void setImageSRSize(Object r100, int r101, int r102) {
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void setImageSRSize(Object r100, View r101) {
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void setSampleSize(Object r100, int r101) {
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final boolean startAnimation(Drawable r100) {
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final boolean stopAnimation(Drawable r100) {
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxImageServiceExtension
    public final a7a.d createBackgroundImageDrawable(Context r100, String r101) {
        return new LynxBackgroundLayerDrawable(r100, r101);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void decodeImage(f r100, e r101) {
        r101.onFailure(-1, new UnsupportedOperationException("decodeImage is not supported"));
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void fetchImage(f r100, e r101, v7a.a r102, Context r103) {
        ImageLoader.with(r103).load(r100.f553504a).into(new C6015a(r101, r100));
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void prefetchImage(String r100, Object r101, Map<String, Object> r102, e r103) {
        if (r103 == null) goto L5;
        r103.onFailure(-1, new UnsupportedOperationException("prefetchImage is not supported"));
        return;
    }
}
