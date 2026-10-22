package u07;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.backends.pipeline.DefaultDrawableFactory;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.BlurHashBitmapDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.blurhash.BlurDecodeProducer;
import com.facebook.imagepipeline.blurhash.BlurHashConfig;
import com.facebook.imagepipeline.blurhash2.PreviewBlurHashProducer;
import com.facebook.imagepipeline.blurhash2.PreviewHashConfig;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.canvas.KryptonCamera;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.service.ILynxImageServiceExtension;
import com.lynx.tasm.service.IServiceProvider;
import com.lynx.tasm.utils.UIThreadUtils;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import v07.i;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements ILynxImageService, ILynxImageServiceExtension {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile c f548163f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DefaultDrawableFactory f548164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InstrumentedMemoryCache f548165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<v7a.f, CloseableReference<CloseableImage>> f548166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Resources f548167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final UiThreadImmediateExecutorService f548168e;

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            SystemClock.uptimeMillis();     // Catch: Throwable -> L8
            new u07.g().a();     // Catch: Throwable -> L5
            SystemClock.uptimeMillis();     // Catch: Throwable -> L5
        L17:
            return;
        L5:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }

        public a() {
        }
    }

    public class b extends BaseDataSubscriber<CloseableReference<CloseableImage>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v7a.f f548169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v7a.e f548170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ v7a.a f548171c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f548172d;

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
            int r101 = u7a.b.a(r100.getFailureCause());
            this.f548170b.onFailure(r101, r100.getFailureCause());
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> r110) {
            c r100 = this.f548172d;
            v7a.f r101 = this.f548169a;
            v7a.e r102 = this.f548170b;
            v7a.a r103 = this.f548171c;
            r100.getClass();
            CloseableReference<CloseableImage> r111 = r110.getResult();
            CloseableImage r104 = r111.get();     // Catch: Throwable -> L6 Exception -> L8
            if ((r104 instanceof CloseableStaticBitmap) == false) goto L10;
            u7a.a r105 = new u7a.a(new u07.a(r111.clone()));     // Catch: Throwable -> L6 Exception -> L8
            boolean r106 = false;
        L11:
            int r107 = w07.a.a(r104);     // Catch: Throwable -> L6 Exception -> L8
            if (r107 == 1) goto L14;
        L16:
            r102.onSuccess(r105, r101, new v7a.d(r104.getWidth(), r104.getHeight(), r106, r107));     // Catch: Throwable -> L6 Exception -> L8
            if (r101.f553521r == false) goto L23;
            JSONObject r108 = new JSONObject();     // Catch: Throwable -> L6 Exception -> L8
            r108.put(PlayerResolution.SDKKEY.ORIGIN, r107);     // Catch: Throwable -> L6 Exception -> L8 JSONException -> L27
        L20:
            r102.onImageMonitorInfo(r108);     // Catch: Throwable -> L6 Exception -> L8
        L23:
            CloseableReference.closeSafely(r111);
            return;
        L14:
            if (r100.canParseUrl(r101.f553504a) == false) goto L16;
            r107 = 6;
            goto L16
        L10:
            Drawable r109 = r100.f548164a.createDrawable(r111.get());     // Catch: Throwable -> L6 Exception -> L8
            u7a.a r112 = new u7a.a(new u07.a(r109, r111.clone()));     // Catch: Throwable -> L6 Exception -> L8
            r106 = c.g(r101, r109, r103);     // Catch: Throwable -> L6 Exception -> L8
            r105 = r112;
        L8:
            e = move-exception;
            CloseableReference.closeSafely(r111);     // Catch: Throwable -> L6
            r102.onFailure(30102, e);     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            CloseableReference.closeSafely(r111);
            throw th;
        }

        public b(c r100, v7a.f r101, v7a.e r102, v7a.a r103, long r104) {
            this.f548172d = r100;
            this.f548169a = r101;
            this.f548170b = r102;
            this.f548171c = r103;
        }
    }

    /* JADX INFO: renamed from: u07.c$c, reason: collision with other inner class name */
    public class RunnableC7814c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageRequest f548173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v7a.f f548174b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BaseDataSubscriber f548175c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f548176d;

        @Override // java.lang.Runnable
        public final void run() {
            Fresco.getImagePipeline().fetchDecodedImage(this.f548173a, this.f548174b.f553516m).subscribe(this.f548175c, this.f548176d.f548168e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC7814c(c r100, ImageRequest r101, v7a.f r102, b r103) {
            this.f548176d = r100;
            this.f548173a = r101;
            this.f548174b = r102;
            this.f548175c = r103;
        }
    }

    public class d extends BaseAnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v7a.a f548177a;

        public d(v7a.a r100) {
            this.f548177a = r100;
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationRepeat(AnimatedDrawable2 r100) {
            if (r100.isRunning() == false) goto L8;
            d7a.f r101 = ((d7a.f.c) this.f548177a).f467349a;
            if (r101.f467325k0 == false) goto L9;
            d7a.f.a(r101, "currentloopcomplete");
            return;
        L9:
            return;
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStart(AnimatedDrawable2 r100) {
            d7a.f r101 = ((d7a.f.c) this.f548177a).f467349a;
            if (r101.Z == false) goto L6;
            d7a.f.a(r101, "startplay");
            return;
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStop(AnimatedDrawable2 r100) {
            if (r100.isRunning() == false) goto L11;
            d7a.f r101 = ((d7a.f.c) this.f548177a).f467349a;
            if (r101.f467325k0 == false) goto L7;
            d7a.f.a(r101, "currentloopcomplete");
        L7:
            d7a.f r102 = ((d7a.f.c) this.f548177a).f467349a;
            if (r102.f467332p0 == false) goto L12;
            d7a.f.a(r102, "finalloopcomplete");
            return;
        L12:
            return;
        }
    }

    public class e extends BaseDataSubscriber<CloseableReference<CloseableImage>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v7a.e f548178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v7a.f f548179b;

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
            if (r100.getFailureCause() == null) goto L5;
            this.f548178a.onFailure(u7a.b.a(r100.getFailureCause()), r100.getFailureCause());
            return;
        L5:
            this.f548178a.onFailure(-1, new Throwable("imageLoadFailed."));
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> r100) {
            CloseableReference<CloseableImage> r101 = r100.getResult();
            Bitmap r102 = null;
            if (r101 == null) goto L5;
            CloseableImage r103 = r101.get();
        L7:
            if ((r103 instanceof CloseableBitmap) == false) goto L10;
            r102 = ((CloseableBitmap) r103).getUnderlyingBitmap();
        L10:
            if (r102 == null) goto L12;
            this.f548178a.onSuccess(new u7a.a(new u07.a(r101)), this.f548179b, new v7a.d(r102.getWidth(), r102.getHeight(), false, -1));
            return;
        L12:
            this.f548178a.onFailure(-1, new Throwable("empty bitmap!"));
            return;
        L5:
            r103 = null;
            goto L7
        }

        public e(v7a.e r100, v7a.f r101) {
            this.f548178a = r100;
            this.f548179b = r101;
        }
    }

    public class f implements BlurDecodeProducer.BlurDecodeCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f548180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f548181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f548182c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f548183d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ BlurHashConfig f548184e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f548185f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ c f548186g;

        @Override // com.facebook.imagepipeline.blurhash.BlurDecodeProducer.BlurDecodeCallBack
        public final void decodeResult(Bitmap r110) {
            c.e(this.f548186g, r110, (GenericDraweeHierarchy) this.f548180a, (ImageRequest) this.f548181b, (ScalingUtils.ScaleType) this.f548182c, this.f548183d, this.f548184e.getTargetWidth(), this.f548184e.getTargetHeight(), this.f548185f);
        }

        public f(c r100, Object r101, Object r102, Object r103, long r104, BlurHashConfig r105, String r106) {
            this.f548186g = r100;
            this.f548180a = r101;
            this.f548181b = r102;
            this.f548182c = r103;
            this.f548183d = r104;
            this.f548184e = r105;
            this.f548185f = r106;
        }
    }

    public class g implements PreviewBlurHashProducer.PreviewBlurDecodeCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f548187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f548188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f548189c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f548190d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ PreviewHashConfig f548191e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f548192f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ c f548193g;

        @Override // com.facebook.imagepipeline.blurhash2.PreviewBlurHashProducer.PreviewBlurDecodeCallBack
        public final void decodeResult(Bitmap r110) {
            c.e(this.f548193g, r110, (GenericDraweeHierarchy) this.f548187a, (ImageRequest) this.f548188b, (ScalingUtils.ScaleType) this.f548189c, this.f548190d, this.f548191e.getWidth(), this.f548191e.getHeight(), this.f548192f);
        }

        public g(c r100, Object r101, Object r102, Object r103, long r104, PreviewHashConfig r105, String r106) {
            this.f548193g = r100;
            this.f548187a = r101;
            this.f548188b = r102;
            this.f548189c = r103;
            this.f548190d = r104;
            this.f548191e = r105;
            this.f548192f = r106;
        }
    }

    public class h implements PreviewBlurHashProducer.PreviewBlurDecodeCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f548194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f548195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f548196c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f548197d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ PreviewHashConfig f548198e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f548199f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ c f548200g;

        @Override // com.facebook.imagepipeline.blurhash2.PreviewBlurHashProducer.PreviewBlurDecodeCallBack
        public final void decodeResult(Bitmap r110) {
            c.e(this.f548200g, r110, (GenericDraweeHierarchy) this.f548194a, (ImageRequest) this.f548195b, (ScalingUtils.ScaleType) this.f548196c, this.f548197d, this.f548198e.getWidth(), this.f548198e.getHeight(), this.f548199f);
        }

        public h(c r100, Object r101, Object r102, Object r103, long r104, PreviewHashConfig r105, String r106) {
            this.f548200g = r100;
            this.f548194a = r101;
            this.f548195b = r102;
            this.f548196c = r103;
            this.f548197d = r104;
            this.f548198e = r105;
            this.f548199f = r106;
        }
    }

    @Override // com.lynx.tasm.service.ILynxImageService, com.lynx.tasm.service.IServiceProvider
    public final /* synthetic */ Class getServiceClass() {
        return ILynxImageService.CC.$default$getServiceClass(this);
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    public final /* synthetic */ void onInitialize(Context r100) {
        IServiceProvider.CC.$default$onInitialize(this, r100);
    }

    public static c f() {
        if (f548163f != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f548163f != null) goto L9;
        f548163f = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f548163f;
    }

    public c() {
        this.f548166c = new ConcurrentHashMap();
        this.f548167d = null;
        this.f548168e = UiThreadImmediateExecutorService.getInstance();
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final Object getImageSRPostProcessor() {
        return u07.f.a();
    }

    @Override // com.lynx.tasm.service.ILynxImageServiceExtension
    public final void onLynxEnvSetup() {
        LynxThreadPool.b().execute(new a());
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final boolean canParseUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return true;
    L6:
        if (r100.startsWith(MSkiaImageRegionDecoder.FILE_PREFIX) == false) goto L8;
        return true;
    L8:
        if (r100.startsWith("content://") == false) goto L10;
        return true;
    L10:
        if (r100.startsWith("asset://") == false) goto L12;
        return true;
    L12:
        if (r100.startsWith(fyb.a.KEY_DATA) == true) goto L19;
        return false;
    L19:
        return true;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final int getImageOrigin(Object r100) {
        if ((r100 instanceof CloseableImage) == true) goto L5;
        return -1;
    L5:
        return w07.a.a((CloseableImage) r100);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final boolean pauseAnimation(Drawable r100) {
        if ((r100 instanceof AnimatedDrawable2) == false) goto L6;
        ((AnimatedDrawable2) r100).pause();
        return true;
    L6:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.service.ILynxImageService
    public final void releaseAnimDrawable(Drawable r100) {
        if ((r100 instanceof DrawableWithCaches) == false) goto L6;
        ((DrawableWithCaches) r100).dropCaches();
        return;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void releaseImage(v7a.f r100) {
        if (r100 == null) goto L7;
        CloseableReference<CloseableImage> r101 = this.f548166c.remove(r100);
        if (r101 == null) goto L8;
        CloseableReference.closeSafely(r101);
        return;
    L8:
        return;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final boolean resumeAnimation(Drawable r100) {
        if ((r100 instanceof AnimatedDrawable2) == false) goto L6;
        ((AnimatedDrawable2) r100).start();
        return true;
    L6:
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void setCustomImageDecoder(Object r100) {
        if ((r100 instanceof ImageDecodeOptionsBuilder) == false) goto L6;
        ((ImageDecodeOptionsBuilder) r100).setCustomImageDecoder(new v07.a());
        return;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final boolean startAnimation(Drawable r100) {
        if ((r100 instanceof AnimatedDrawable2) == false) goto L6;
        AnimatedDrawable2 r101 = (AnimatedDrawable2) r100;
        r101.stop();
        r101.start();
        return true;
    L6:
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final boolean stopAnimation(Drawable r100) {
        if ((r100 instanceof AnimatedDrawable2) == false) goto L6;
        ((AnimatedDrawable2) r100).stop();
        return true;
    L6:
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxImageServiceExtension
    public final a7a.d createBackgroundImageDrawable(Context r100, String r101) {
        if (LynxEnv.inst().getBackgroundImageLoader() != null) goto L5;
        return null;
    L5:
        return LynxEnv.inst().getBackgroundImageLoader().a(r100, r101);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void decodeImage(v7a.f r100, v7a.e r101) {
        if (r100 == null) goto L8;
        ImagePipeline r102 = Fresco.getImagePipeline();
        ImageDecodeOptionsBuilder r103 = ImageDecodeOptions.newBuilder().setBitmapConfig(r100.f553508e).setForceStaticImage(r100.f553518o);
        if (r100.f553525v == true) goto L6;
        r103.setCustomImageDecoder(new i());
    L6:
        r102.fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r100.f553504a)).setResizeOptions(new ResizeOptions(Integer.MAX_VALUE, Integer.MAX_VALUE, 2.1474836E9f)).setImageDecodeOptions(r103.build()).build(), null).subscribe(new e(r101, r100), CallerThreadExecutor.getInstance());
        return;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void setCacheKeyUri(Object r100, Uri r101) {
        if ((r100 instanceof ImageRequestBuilder) == false) goto L6;
        w07.a.c((ImageRequestBuilder) r100, r101);
        return;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void setImageCacheChoice(String r100, Object r101) {
        if ((r101 instanceof ImageRequestBuilder) == false) goto L6;
        ImageRequestBuilder r102 = (ImageRequestBuilder) r101;
        r102.setCacheChoice(ImageRequest.CacheChoice.CUSTOM);
        r102.setCustomCacheName(r100);
        return;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void setImageDecodeRegion(Object r100, Rect r101) {
        if ((r100 instanceof ImageRequestBuilder) == false) goto L6;
        ImageRequestBuilder r102 = (ImageRequestBuilder) r100;
        ImageDecodeOptionsBuilder r103 = new ImageDecodeOptionsBuilder().setFrom(r102.getImageDecodeOptions());
        r103.setRegionToDecode(r101);
        setSampleSize(r102, 1);
        r102.setImageDecodeOptions(r103.build());
        return;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void setImageSRSize(Object r100, View r101) {
        if ((r100 instanceof ImageRequest) == false) goto L6;
        ((ImageRequest) r100).setSizeDeterminer(new SizeDeterminer(r101));
        return;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void setSampleSize(Object r100, int r101) {
        if ((r100 instanceof ImageRequestBuilder) == false) goto L6;
        w07.a.d((ImageRequestBuilder) r100, r101);
        return;
    }

    public static boolean g(v7a.f r100, Drawable r101, v7a.a r102) {
        if ((r101 instanceof AnimatedDrawable2) == false) goto L14;
        AnimatedDrawable2 r103 = (AnimatedDrawable2) r101;
        if (r102 == null) goto L7;
        r103.setAnimationListener(new d(r102));
    L7:
        r103.setAnimationBackend(new v07.c(r103.getAnimationBackend(), r100.f553507d));
        if (r100.f553519p == true) goto L11;
        r103.setPrivateFrameScheduler(new DropFramesFrameScheduler(r103.getAnimationBackend()));
    L11:
        if (r100.f553517n == false) goto L13;
        r103.start();
    L13:
        return true;
    L14:
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void prefetchImage(String r100, Object r101, Map<String, Object> r102) {
        prefetchImage(r100, r101, r102, null);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void setImageSRSize(Object r100, int r101, int r102) {
        if ((r100 instanceof ImageRequestBuilder) == false) goto L6;
        w07.a.e((ImageRequestBuilder) r100, r101, r102);
        return;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void fetchImage(v7a.f r110, v7a.e r111, v7a.a r112, Context r113) {
        if (this.f548167d != null) goto L6;
        this.f548167d = r113.getResources();
    L6:
        if (this.f548164a != null) goto L9;
        this.f548164a = new DefaultDrawableFactory(this.f548167d, Fresco.getImagePipelineFactory().getAnimatedDrawableFactory(r113));
    L9:
        if (this.f548165b != null) goto L11;
        this.f548165b = Fresco.getImagePipelineFactory().getBitmapMemoryCache();
    L11:
        long r100 = System.currentTimeMillis();
        Uri r114 = UriProtector.parse(r110.f553504a);
        ImageRequestBuilder r101 = ImageRequestBuilder.newBuilderWithSource(r114);
        ImageDecodeOptionsBuilder r102 = new ImageDecodeOptionsBuilder();
        r102.setPreDecodeFrameCount(0);
        Bitmap.Config r103 = r110.f553508e;
        if (r103 == null) goto L15;
        r102.setBitmapConfig(r103);
    L15:
        if (r110.f553510g == false) goto L17;
        r102.setCustomImageDecoder(new v07.a());
    L17:
        Map<String, String> r104 = r110.f553512i;
        if (r104 == null) goto L20;
        r101.setCustomParam(r104);
    L20:
        r101.setAutoRotateEnabled(true).setProgressiveRenderingEnabled(false);
        CloseableReference r105 = null;
        if (r110.f553509f == false) goto L23;
    L32:
        Integer r106 = r110.f553513j;
        if (r106 == null) goto L38;
        if (1 != r106.intValue()) goto L38;
        r101.setCacheChoice(ImageRequest.CacheChoice.SMALL);
    L38:
        if (r110.f553514k == false) goto L41;
        r101.setRequestPriority(Priority.HIGH);
    L41:
        if (r110.f553520q == false) goto L43;
        r101.setProgressiveRenderingAnimatedEnabled(true);
        r101.setProgressiveRenderingEnabled(true);
        r101.setProgressiveRenderingHeicEnabled(true);
    L43:
        v07.h r107 = new v07.h(r110.f553508e);
        List<v7a.b> r108 = r110.f553515l;
        if (r108 != null) goto L46;
    L48:
        float r109 = r110.f553523t;
        if (r109 <= 0.0f) goto L51;
        w07.a.e(r101, (int) (r110.f553505b * r109), (int) (r109 * r110.f553506c));
        r107.f552339c = u07.f.a();
    L51:
        List<v7a.b> r115 = r107.f552337a;
        if (r115 == null) goto L56;
        Postprocessor r116 = r107;
        if (r115.isEmpty() == true) goto L56;
    L57:
        if (r116 == null) goto L60;
        r101.setPostprocessor(r116);
    L60:
        if (r110.f553522s == false) goto L68;
        String r117 = r114.getScheme();
        if (r117 == null) goto L68;
        if (r117.startsWith("http") == false) goto L68;
        String r118 = r114.getPath();
        if (TextUtils.isEmpty(r118) == true) goto L68;
        w07.a.c(r101, UriProtector.parse(r118));
    L68:
        Rect r119 = r110.f553524u;
        if (r119 == null) goto L71;
        r102.setRegionToDecode(r119);
        w07.a.d(r101, 1);
        r101.setImageDecodeOptions(r102.build());
    L71:
        ImageRequest r120 = r101.build();
        InstrumentedMemoryCache r121 = this.f548165b;
        Object r122 = r110.f553516m;
        if (w07.a.f557816a != null) goto L75;
        w07.a.f557816a = Fresco.getImagePipeline().getCacheKeyFactory();
    L75:
        if (w07.a.f557816a == null) goto L81;
        if (r120 == null) goto L81;
        if (r120.getPostprocessor() == null) goto L80;
        CacheKey r123 = w07.a.f557816a.getPostprocessedBitmapCacheKey(r120, r122);
    L82:
        if (r121 == null) goto L86;
        if (r123 == null) goto L86;
        r105 = r121.get(r123);
    L86:
        if (r105 == null) goto L95;
        CloseableImage r124 = (CloseableImage) r105.get();
        if ((r124 instanceof CloseableStaticBitmap) == false) goto L95;
        r111.onSuccess(new u7a.a(new u07.a(r105)), r110, new v7a.d(r124.getWidth(), r124.getHeight(), false, 5));
        if (r110.f553521r == false) goto L103;
        JSONObject r125 = new JSONObject();
        r125.put(PlayerResolution.SDKKEY.ORIGIN, 5);     // Catch: JSONException -> L100
    L93:
        r111.onImageMonitorInfo(r125);
        return;
    L103:
        return;
    L95:
        b r126 = new b(this, r110, r111, r112, r100);
        if (r110.f553514k == false) goto L98;
        LynxThreadPool.d().execute(new RunnableC7814c(this, r120, r110, r126));
        return;
    L98:
        Fresco.getImagePipeline().fetchDecodedImage(r120, r110.f553516m).subscribe(r126, this.f548168e);
        return;
    L80:
        r123 = w07.a.f557816a.getBitmapCacheKey(r120, r122);
    L81:
        r123 = null;
    L56:
        r116 = r107.f552339c;
        goto L57
    L46:
        if (r108.isEmpty() == true) goto L48;
        r107.f552337a = r110.f553515l;
        goto L48
    L23:
        if (r110.f553523t != 0.0f) goto L32;
        if (r110.f553524u != null) goto L32;
        if (r110.f553511h == false) goto L29;
        ResizeOptions r127 = new ResizeOptions(r110.f553505b, r110.f553506c);
    L30:
        if (r127 == null) goto L32;
        r101.setResizeOptions(r127);
        goto L32
    L29:
        r127 = null;
        goto L30
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void prefetchImage(String r100, Object r101, Map<String, Object> r102, v7a.e r110) {
        Map r103 = null;
        if (r102 != null) goto L5;
        String r104 = null;
    L6:
        if (r102 != null) goto L8;
        String r105 = null;
    L9:
        if (r102 == null) goto L12;
        r103 = (Map) r102.get("additional-custom-info");
    L12:
        Uri r106 = UriProtector.parse(r100);
        if (r106.getScheme() != null) goto L15;
        return;
    L15:
        ImageRequestBuilder r107 = ImageRequestBuilder.newBuilderWithSource(r106);
        ImageDecodeOptionsBuilder r108 = new ImageDecodeOptionsBuilder();
        r108.setPreDecodeFrameCount(0);
        r107.setImageDecodeOptions(r108.build());
        if (r103 == null) goto L26;
        HashMap r109 = new HashMap();
        Iterator r111 = r103.entrySet().iterator();
    L19:
        if (r111.hasNext() == false) goto L25;
        Map.Entry r112 = (Map.Entry) r111.next();
        Object r113 = r112.getKey();
        if (r112.getValue() != null) goto L23;
        String r114 = "";
    L24:
        r109.put(r113, r114);
        goto L19
    L23:
        r114 = (String) r112.getValue();
        goto L24
    L25:
        r107.setCustomParam(r109);
    L26:
        if (r105 != null) goto L28;
    L32:
        ImageRequest r115 = r107.build();
        if (r104 != null) goto L35;
    L37:
        if (r104 != null) goto L39;
    L41:
        Priority r116 = Priority.LOW;
    L42:
        DataSource<Void> r117 = Fresco.getImagePipeline().prefetchToDiskCache(r115, r101, r116);
        if (r110 == null) goto L51;
        r117.subscribe(new u07.d(r110), CallerThreadExecutor.getInstance());
        return;
    L51:
        return;
    L39:
        if (r104.equals(KryptonCamera.Config.RESOLUTION_MEDIUM) == false) goto L41;
        r116 = Priority.MEDIUM;
        goto L42
    L35:
        if (r104.equals("high") == false) goto L37;
        r116 = Priority.HIGH;
        goto L42
    L28:
        if (r105.equals(SimplayerImageStrategy.RESULT_BITMAP) == false) goto L32;
        DataSource<Void> r118 = Fresco.getImagePipeline().prefetchToBitmapCache(r107.build(), r101);
        if (r110 == null) goto L49;
        r118.subscribe(new u07.e(r110), CallerThreadExecutor.getInstance());
        return;
    L49:
        return;
    L8:
        r105 = (String) r102.get("cacheTarget");
        goto L9
    L5:
        r104 = (String) r102.get("priority");
        goto L6
    }

    public static void e(c r100, Bitmap r101, GenericDraweeHierarchy r110, ImageRequest r111, ScalingUtils.ScaleType r112, long r113, int r114, int r115, String r116) {
        r100.getClass();
        if (r110 == null) goto L11;
        if (r111 == null) goto L12;
        if (r101 != null) goto L7;
    L9:
        r111.setPreviewError(r116);
        return;
    L7:
        if (r101.isRecycled() == true) goto L9;
        UIThreadUtils.runOnUiThreadImmediately(new u07.b(r101, r113, r111, r110, new BlurHashBitmapDrawable(r101, r114, r115, r112)));
        return;
    L12:
        return;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void setImagePlaceHolderHash(Object r110, Object r111, Object r112, String r113, String r114, int r115, int r210, int r211, int r212, boolean r213) {
        if ((r111 instanceof ImageRequest) == true) goto L5;
        return;
    L5:
        if ((r110 instanceof GenericDraweeHierarchy) == true) goto L7;
        return;
    L7:
        if ((r112 instanceof ScalingUtils.ScaleType) == true) goto L9;
        return;
    L9:
        if (r213 == true) goto L11;
        ImageRequest r100 = (ImageRequest) r111;
        r100.setPreviewUsed(true);
        r100.setPreviewAlgo(1);
        BlurHashConfig r116 = new BlurHashConfig(r115, r210);
        new BlurDecodeProducer(r113, r116, new f(this, r110, r111, r112, SystemClock.uptimeMillis(), r116, r113));
        return;
    L11:
        ImageRequest r101 = (ImageRequest) r111;
        r101.setPreviewUsed(true);
        r101.setPreviewAlgo(2);
        long r102 = SystemClock.uptimeMillis();
        PreviewHashConfig r117 = new PreviewHashConfig(r212, r211, r115, r210);
        if (TextUtils.isEmpty(r114) == true) goto L14;
        new PreviewBlurHashProducer(r113, r114, r117, new g(this, r110, r111, r112, r102, r117, r113));
        return;
    L14:
        new PreviewBlurHashProducer(r113, r117, new h(this, r110, r111, r112, r102, r117, r113));
    }
}
