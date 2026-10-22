package com.larus.image.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.core.DiskStorageCacheFactory;
import com.facebook.imagepipeline.core.DynamicDefaultDiskStorageFactory;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.bmhome.view.TitleAvatarImageView;
import com.larus.disk.api.CacheHandlerBiz;
import com.larus.platform.api.f2;
import com.larus.utils.y0;
import com.obric.miniapp.alarm.AccountType;
import java.util.HashMap;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: classes4.dex */
public final class ImageLoaderKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f350948a = null;

    /* JADX INFO: loaded from: classes30.dex */
    public static final class a implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DataSource<CloseableReference<CloseableImage>> f350949a;

        public a(DataSource<CloseableReference<CloseableImage>> r100) {
            this.f350949a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable r100) {
            this.f350949a.close();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: loaded from: classes30.dex */
    public static final class b extends BaseDataSubscriber<CloseableReference<CloseableImage>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<CloseableReference<CloseableImage>> f350950a;

        public b(kotlinx.coroutines.j r100) {
            this.f350950a = r100;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
            if (this.f350950a.isActive() == false) goto L6;
            this.f350950a.resumeWith(Result.m9449constructorimpl(null));
            return;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> r100) {
            if (this.f350950a.isActive() == false) goto L10;
            kotlinx.coroutines.i<CloseableReference<CloseableImage>> r101 = this.f350950a;
            Result.Companion r102 = Result.Companion;
            if (r100 == null) goto L7;
            CloseableReference<CloseableImage> r103 = r100.getResult();
        L8:
            r101.resumeWith(Result.m9449constructorimpl(r103));
            return;
        L7:
            r103 = null;
            goto L8
        }
    }

    /* JADX INFO: loaded from: classes30.dex */
    public static final class c implements com.larus.image.loader.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2<PipelineDraweeControllerBuilder, Uri, Unit> f350951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f350952b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g f350953c;

        @Override // com.larus.image.loader.b
        public final AbstractDraweeController a(Uri r100) {
            Intrinsics.checkNotNullParameter(r100, "imageUri");
            PipelineDraweeControllerBuilder r101 = Fresco.newDraweeControllerBuilder();
            Function2<PipelineDraweeControllerBuilder, Uri, Unit> r102 = this.f350951a;
            Intrinsics.checkNotNull(r101);
            r102.invoke(r101, r100);
            ImageRequest r103 = r101.getImageRequest();
            ImageRequest r104 = null;
            if (r103 == null) goto L5;
            ImageRequest r105 = ImageLoaderKt.g(r103, this.f350952b);
        L6:
            r101.setImageRequest(r105);
            if (this.f350953c != null) goto L15;
            if (this.f350952b == null) goto L15;
            ImageRequest r106 = r101.getLowResImageRequest();
            if (r106 == null) goto L13;
            r104 = ImageLoaderKt.g(r106, this.f350952b);
        L13:
            r101.setLowResImageRequest(r104);
        L15:
            return r101.build();
        L5:
            r105 = null;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function2<? super PipelineDraweeControllerBuilder, ? super Uri, Unit> r100, g r101, g r102) {
            this.f350951a = r100;
            this.f350952b = r101;
            this.f350953c = r102;
        }
    }

    static {
        f350948a = LazyKt.lazy(new k());
    }

    public static final ImagePipeline p() {
        return (ImagePipeline) f350948a.getValue();
    }

    public static final g D(String r100) {
        if (f2.f365106a.n() == true) goto L6;
        return null;
    L6:
        Set<String> r101 = com.larus.utils.w.f375482a;
        if (CollectionsKt.contains(com.larus.utils.w.f375482a, r100) == false) goto L10;
        String r102 = CacheHandlerBiz.BIZ_ACCOUNT_AVATAR_FRESCO_CACHE;
    L14:
        return b0.d(r102, true);
    L10:
        if (CollectionsKt.contains(com.larus.utils.w.f375483b, r100) == false) goto L12;
        r102 = CacheHandlerBiz.BIZ_IM_FRESCO_CACHE;
        goto L14
    L12:
        r102 = CacheHandlerBiz.BIZ_MEDIA_FRESCO_CACHE;
        goto L14
    }

    public static final void b(SimpleDraweeView r100) {
        if (r100 == null) goto L5;
        r100.setController(null);
        return;
    }

    public static final void d(GenericDraweeView r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        b0.g(r100, null);
        r100.setController(null);
    }

    public static final void e(SimpleDraweeView r100) {
        if (r100 == null) goto L5;
        r100.setImageURI(null);
        return;
    }

    public static final Object f(Continuation<? super Unit> r100) {
        ImageUrlStorage.f350955a.getClass();
        Object r101 = BuildersKt.withContext((ExecutorCoroutineDispatcher) ImageUrlStorage.f350957c.getValue(), new ImageUrlStorage$clearAndWait$2(null), r100);
        if (r101 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
        r101 = Unit.INSTANCE;
    L7:
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r101;
    L10:
        return Unit.INSTANCE;
    }

    public static final g E(String r100, String r101) {
        String r102 = null;
        if (y0.e(r100) == true) goto L5;
        return null;
    L5:
        String r103 = y0.f(y0.i(r100), "biz_tag");
        if (r103 == null) goto L16;
        if (r103.length() <= 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L13;
        r102 = r103;
    L13:
        if (r102 == null) goto L16;
        r101 = r102;
        goto L16
    L10:
        r104 = false;
    L16:
        return D(r101);
    }

    public static final void c(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "cacheName");
        ImagePipeline r102 = p();
        ImagePipelineFactory r103 = ImagePipelineFactory.getInstance();
        if (Intrinsics.areEqual(r100, CacheHandlerBiz.BIZ_MEDIA_FRESCO_CACHE) == false) goto L16;
        HashMap<String, BufferedDiskCache> r104 = r103.getCustomImageBufferedDiskCacheMap();
        boolean r105 = false;
        if (r104 != null) goto L7;
    L9:
        if (r105 == true) goto L16;
        Context r106 = r103.getImagePipelineConfig().getContext();
        if (new PolarisFileWrapper(r106.getCacheDir(), r100).isDirectory() == true) goto L14;
        return;
    L14:
        DiskCacheConfig r107 = DiskCacheConfig.newBuilder(r106).setBaseDirectoryPath(r106.getCacheDir()).setBaseDirectoryName(r100).build();
        DiskStorageCacheFactory.buildDiskStorageCache(r107, new DynamicDefaultDiskStorageFactory().get(r107), CallerThreadExecutor.getInstance()).clearByTimestamp(r101);
        return;
    L7:
        if (r104.containsKey(r100) != true) goto L9;
        r105 = true;
    L16:
        r102.clearCustomDiskCacheByTimestamp(r100, r101);
    }

    public static final ImageRequest g(ImageRequest r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != null) goto L5;
        return r100;
    L5:
        ImageRequestBuilder r102 = ImageRequestBuilder.fromRequest(r100);
        r102.setCacheChoice(r101.f350969b);
        r102.setCustomCacheName(r101.f350968a);
        return r102.build();
    }

    public static /* synthetic */ Object r(String r100, String r101, Continuation r102) {
        return q(r100, r101, new m(r100, r101), r102);
    }

    public static final void s(GenericDraweeView r100, Uri r101, String r102) {
        u(r100, y0.k(r101), r102);
    }

    public static final void u(GenericDraweeView r100, String r101, String r102) {
        m r103 = new m(r101, r102);
        j.a(r102, r101);
        if (r100 != null) goto L5;
        return;
    L5:
        b0.g(r100, r101);
        if (r101 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
    L18:
        r103.f350986d = AccountType.LOCAL;
        Uri r105 = y0.i(r101);
        r100.setImageURI(r105);
        r103.a("SET_IMAGE_URI", r105);
        return;
    L14:
        if (y0.e(r101) == false) goto L18;
        new e(r100, r103).c(r101, r102, null);
        return;
    L8:
        if (r101.length() == 0) goto L11;
        r104 = false;
        goto L12
    }

    public static final Object q(String r100, String r101, m r110, Continuation<? super Uri> r111) {
        if ((r111 instanceof ImageLoaderKt$getImageUri$1) == false) goto L7;
        ImageLoaderKt$getImageUri$1 r102 = (ImageLoaderKt$getImageUri$1) r111;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r112 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        String r106 = (String) r102.L$1;
        r110 = (m) r102.L$0;
        ResultKt.throwOnFailure(r112);
    L50:
        String r107 = (String) r112;
        r101 = r106;
        r100 = r107;
    L51:
        Uri r108 = b0.b(r100, r101, r110);
        if (r110 == null) goto L54;
        r110.a("GET_IMAGE_URI", r108);
    L54:
        return r108;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        Uri r113 = y0.i(r100);
        boolean r109 = false;
        if (r100 != null) goto L17;
    L20:
        boolean r114 = true;
    L21:
        if (r114 == false) goto L23;
    L55:
        if (r110 == null) goto L57;
        r110.f350986d = AccountType.LOCAL;
    L57:
        if (r110 == null) goto L59;
        r110.a("GET_IMAGE_URI", r113);
    L59:
        return r113;
    L23:
        if (y0.d(r113) == false) goto L55;
        if (r110 == null) goto L27;
        r110.f350986d = "REMOTE";
    L27:
        String r115 = y0.f(r113, "biz_tag");
        if (r115 == null) goto L40;
        if (r115.length() <= 0) goto L32;
        boolean r116 = true;
    L33:
        if (r116 == true) goto L36;
        r115 = null;
    L36:
        if (r115 == null) goto L40;
        r101 = r115;
        goto L40
    L32:
        r116 = false;
    L40:
        if ((o.a() & 1) == 0) goto L42;
        r109 = true;
    L42:
        if (r109 == false) goto L44;
    L46:
        ImageUrlProvider r117 = ImageUrlProvider.f350954a;
        r102.L$0 = r110;
        r102.L$1 = r101;
        r102.label = 1;
        r112 = r117.a(r100, r101, r110, r102);
        if (r112 != r104) goto L49;
        return r104;
    L49:
        r106 = r101;
        goto L50
    L44:
        if (b0.c(r113) == true) goto L46;
    L17:
        if (r100.length() == 0) goto L20;
        r114 = false;
    L7:
        r102 = new ImageLoaderKt$getImageUri$1(r111);
        goto L8
    }

    public static final Object a(String r100, String r101, m r102, Function1<? super ImageRequestBuilder, Unit> r103, Continuation<? super ImageRequest> r104) {
        if ((r104 instanceof ImageLoaderKt$buildImageRequest$1) == false) goto L7;
        ImageLoaderKt$buildImageRequest$1 r105 = (ImageLoaderKt$buildImageRequest$1) r104;
        int r106 = r105.label;
        if ((r106 & Integer.MIN_VALUE) == 0) goto L7;
        r105.label = r106 - Integer.MIN_VALUE;
    L8:
        Object r107 = r105.result;
        Object r108 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r109 = r105.label;
        if (r109 == 0) goto L14;
        if (r109 != 1) goto L13;
        r103 = (Function1) r105.L$0;
        ResultKt.throwOnFailure(r107);
    L17:
        ImageRequestBuilder r110 = ImageRequestBuilder.newBuilderWithSource((Uri) r107);
        if (r103 == null) goto L21;
        Intrinsics.checkNotNull(r110);
        r103.invoke(r110);
    L21:
        return r110.build();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r107);
        r105.L$0 = r103;
        r105.label = 1;
        r107 = q(r100, r101, r102, r105);
        if (r107 != r108) goto L17;
        return r108;
    L7:
        r105 = new ImageLoaderKt$buildImageRequest$1(r104);
        goto L8
    }

    public static /* synthetic */ Object i(String r100, String r110, Function1 r111, Continuation r112, int r113) {
        if ((r113 & 2) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r113 & 8) == 0) goto L9;
        m r102 = new m(r100, r101);
    L11:
        if ((r113 & 32) == 0) goto L13;
        Function1 r103 = null;
    L15:
        return h(r100, r101, null, r102, null, r103, r112);
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public static void l(String r110, String r111, Function1 r112, Function1 r113, int r210) {
        if ((r210 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r210 & 32) == 0) goto L9;
        Function1 r101 = null;
    L10:
        Intrinsics.checkNotNullParameter(r112, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new ImageLoaderKt$fetchDecodedImage$2(r112, r110, r100, null, new m(r110, r100), null, r101, null), 3, null);
        return;
    L9:
        r101 = r113;
        goto L10
    L5:
        r100 = r111;
        goto L7
    }

    public static final void t(GenericDraweeView r100, String r101, com.larus.image.loader.b r102, String r103, g r104) {
        Intrinsics.checkNotNullParameter(r102, "factory");
        m r105 = new m(r101, r103);
        j.a(r103, r101);
        if (r100 != null) goto L5;
        return;
    L5:
        b0.g(r100, r101);
        if (r101 != null) goto L8;
    L11:
        boolean r106 = true;
    L12:
        if (r106 == false) goto L14;
    L18:
        r105.f350986d = AccountType.LOCAL;
        Uri r107 = y0.i(r101);
        r100.setController(r102.a(r107));
        r105.a("SET_CONTROLLER", r107);
        return;
    L14:
        if (y0.e(r101) == false) goto L18;
        new com.larus.image.loader.c(r100, r105, r104).c(r101, r103, r102);
        return;
    L8:
        if (r101.length() == 0) goto L11;
        r106 = false;
        goto L12
    }

    public static final void v(GenericDraweeView r100, String r101, String r102, g r103, Function2<? super PipelineDraweeControllerBuilder, ? super Uri, Unit> r104) {
        Intrinsics.checkNotNullParameter(r104, "builder");
        if (r103 != null) goto L5;
        g r105 = E(r101, r102);
    L6:
        t(r100, r101, new c(r104, r105, r103), r102, r105);
        return;
    L5:
        r105 = r103;
        goto L6
    }

    public static final void w(TitleAvatarImageView r100, String r101, String r102, Function1 r103, g r104) {
        Intrinsics.checkNotNullParameter(r103, "controllerBuilder");
        if (r104 != null) goto L5;
        g r105 = E(r101, r102);
    L6:
        t(r100, r101, new l(r103, r105, r104), r102, r105);
        return;
    L5:
        r105 = r104;
        goto L6
    }

    public static /* synthetic */ void y(GenericDraweeView r100, String r101, String r102, Function2 r103, int r104) {
        if ((r104 & 2) == 0) goto L5;
        r102 = null;
    L5:
        v(r100, r101, r102, null, r103);
    }

    public static /* synthetic */ Object C(String r100, String r110, Object r111, com.larus.gallery.tracker.e r112, Continuation r113, int r114) {
        if ((r114 & 2) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r114 & 4) == 0) goto L9;
        Object r102 = null;
    L11:
        if ((r114 & 8) == 0) goto L13;
        m r103 = new m(r100, r101);
    L15:
        if ((r114 & 32) == 0) goto L17;
        com.larus.gallery.tracker.e r104 = null;
    L19:
        return B(r100, r101, r102, r103, null, r104, r113);
    L17:
        r104 = r112;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public static /* synthetic */ Object k(String r100, String r110, Object r111, com.larus.uaigc.createpage.component.digitalavatar.p r112, Continuation r113, int r114) {
        if ((r114 & 2) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r114 & 4) == 0) goto L9;
        Object r102 = null;
    L11:
        if ((r114 & 8) == 0) goto L13;
        m r103 = new m(r100, r101);
    L15:
        if ((r114 & 32) == 0) goto L17;
        com.larus.uaigc.createpage.component.digitalavatar.p r104 = null;
    L19:
        return j(r100, r101, r102, r103, null, r104, r113);
    L17:
        r104 = r112;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public static /* synthetic */ Object n(String r110, String r111, Bitmap.Config r112, Function1 r113, Continuation r114, int r115) {
        if ((r115 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r115 & 8) == 0) goto L9;
        m r101 = new m(r110, r100);
    L11:
        if ((r115 & 32) == 0) goto L13;
        Bitmap.Config r102 = null;
    L15:
        if ((r115 & 64) == 0) goto L17;
        Function1 r103 = null;
    L19:
        return m(r110, r100, null, r101, null, r102, r103, r114);
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public static void o(String r110, String r111, Object r112, Function1 r113, com.larus.bmhome.chat.larkforward.f r210, int r211) {
        if ((r211 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r211 & 4) == 0) goto L9;
        Object r101 = null;
    L11:
        if ((r211 & 64) == 0) goto L13;
        com.larus.bmhome.chat.larkforward.f r114 = null;
    L14:
        Intrinsics.checkNotNullParameter(r113, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new ImageLoaderKt$fetchDecodedImageNewInstance$2(r113, r110, r100, r101, new m(r110, r100), null, null, r114, null), 3, null);
        return;
    L13:
        r114 = r210;
        goto L14
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public static void x(GenericDraweeView r100, Uri r101, String r102, g r103, Function2 r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 4) == 0) goto L8;
        r103 = null;
    L8:
        Intrinsics.checkNotNullParameter(r104, "callback");
        v(r100, y0.k(r101), r102, r103, r104);
    }

    public static /* synthetic */ Object A(String r100, String r110, Object r111, g r112, Function1 r113, Continuation r114, int r115) {
        if ((r115 & 2) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r115 & 4) == 0) goto L9;
        Object r102 = null;
    L11:
        if ((r115 & 8) == 0) goto L13;
        m r103 = new m(r100, r101);
    L15:
        if ((r115 & 16) == 0) goto L17;
        g r104 = null;
    L19:
        if ((r115 & 32) == 0) goto L21;
        Function1 r105 = null;
    L23:
        return z(r100, r101, r102, r103, r104, r105, r114);
    L21:
        r105 = r113;
        goto L23
    L17:
        r104 = r112;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public static final Object B(String r100, String r101, Object r102, m r103, g r104, Function1<? super ImageRequestBuilder, Unit> r110, Continuation<? super DataSource<Void>> r111) {
        if ((r111 instanceof ImageLoaderKt$prefetchToDiskCache$1) == false) goto L7;
        ImageLoaderKt$prefetchToDiskCache$1 r105 = (ImageLoaderKt$prefetchToDiskCache$1) r111;
        int r106 = r105.label;
        if ((r106 & Integer.MIN_VALUE) == 0) goto L7;
        r105.label = r106 - Integer.MIN_VALUE;
    L8:
        Object r112 = r105.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r105.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        ImagePipeline r109 = (ImagePipeline) r105.L$4;
        r104 = (g) r105.L$3;
        r102 = r105.L$2;
        r101 = (String) r105.L$1;
        String r113 = (String) r105.L$0;
        ResultKt.throwOnFailure(r112);
    L18:
        ImageRequest r114 = (ImageRequest) r112;
        if (r104 != null) goto L22;
        r104 = E(r113, r101);
    L22:
        return r109.prefetchToDiskCache(g(r114, r104), r102);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        ImagePipeline r115 = p();
        r105.L$0 = r100;
        r105.L$1 = r101;
        r105.L$2 = r102;
        r105.L$3 = r104;
        r105.L$4 = r115;
        r105.label = 1;
        Object r116 = a(r100, r101, r103, r110, r105);
        if (r116 != r107) goto L17;
        return r107;
    L17:
        r113 = r100;
        r109 = r115;
        r112 = r116;
    L7:
        r105 = new ImageLoaderKt$prefetchToDiskCache$1(r111);
        goto L8
    }

    public static final Object h(String r100, String r101, Object r102, m r103, g r110, Function1<? super ImageRequestBuilder, Unit> r111, Continuation<? super CloseableReference<CloseableImage>> r112) {
        if ((r112 instanceof ImageLoaderKt$fetchDecodedCloseableImage$1) == false) goto L7;
        ImageLoaderKt$fetchDecodedCloseableImage$1 r104 = (ImageLoaderKt$fetchDecodedCloseableImage$1) r112;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r113 = r104.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r104.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        ImageRequest r108 = (ImageRequest) r104.L$1;
        ResultKt.throwOnFailure(r113);
    L36:
        return r113;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r110 = (g) r104.L$3;
        r102 = r104.L$2;
        r101 = (String) r104.L$1;
        r100 = (String) r104.L$0;
        ResultKt.throwOnFailure(r113);
    L28:
        ImageRequest r114 = (ImageRequest) r113;
        if (r110 != null) goto L31;
        r110 = E(r100, r101);
    L31:
        ImageRequest r109 = g(r114, r110);
        r104.L$0 = r102;
        r104.L$1 = r109;
        r104.L$2 = null;
        r104.L$3 = null;
        r104.label = 2;
        kotlinx.coroutines.j r115 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r104), 1);
        r115.C();
        DataSource<CloseableReference<CloseableImage>> r116 = p().fetchDecodedImage(r109, r102);
        r115.i(new a(r116));
        r116.subscribe(new b(r115), CallerThreadExecutor.getInstance());
        r113 = r115.B();
        if (r113 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L34;
        DebugProbesKt.probeCoroutineSuspended(r104);
    L34:
        if (r113 != r106) goto L36;
        return r106;
    L16:
        ResultKt.throwOnFailure(r113);
        if (r100 != null) goto L19;
    L22:
        boolean r117 = true;
    L23:
        if (r117 == false) goto L25;
        return null;
    L25:
        r104.L$0 = r100;
        r104.L$1 = r101;
        r104.L$2 = r102;
        r104.L$3 = r110;
        r104.label = 1;
        r113 = a(r100, r101, r103, r111, r104);
        if (r113 != r106) goto L28;
        return r106;
    L19:
        if (r100.length() == 0) goto L22;
        r117 = false;
    L7:
        r104 = new ImageLoaderKt$fetchDecodedCloseableImage$1(r112);
        goto L8
    }

    public static final Object j(String r100, String r101, Object r102, m r103, g r110, Function1<? super ImageRequestBuilder, Unit> r111, Continuation<? super Bitmap> r112) {
        if ((r112 instanceof ImageLoaderKt$fetchDecodedImage$1) == false) goto L7;
        ImageLoaderKt$fetchDecodedImage$1 r104 = (ImageLoaderKt$fetchDecodedImage$1) r112;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r113 = r104.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r104.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        ResultKt.throwOnFailure(r113);
    L34:
        return r113;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r110 = (g) r104.L$3;
        r102 = r104.L$2;
        r101 = (String) r104.L$1;
        r100 = (String) r104.L$0;
        ResultKt.throwOnFailure(r113);
    L28:
        ImageRequest r114 = (ImageRequest) r113;
        if (r110 != null) goto L31;
        r110 = E(r100, r101);
    L31:
        ImageRequest r108 = g(r114, r110);
        r104.L$0 = null;
        r104.L$1 = null;
        r104.L$2 = null;
        r104.L$3 = null;
        r104.label = 2;
        r113 = b0.f(r108, r102, false, null, r104, 28);
        if (r113 != r106) goto L34;
        return r106;
    L16:
        ResultKt.throwOnFailure(r113);
        if (r100 != null) goto L19;
    L22:
        boolean r115 = true;
    L23:
        if (r115 == false) goto L25;
        return null;
    L25:
        r104.L$0 = r100;
        r104.L$1 = r101;
        r104.L$2 = r102;
        r104.L$3 = r110;
        r104.label = 1;
        r113 = a(r100, r101, r103, r111, r104);
        if (r113 != r106) goto L28;
        return r106;
    L19:
        if (r100.length() == 0) goto L22;
        r115 = false;
    L7:
        r104 = new ImageLoaderKt$fetchDecodedImage$1(r112);
        goto L8
    }

    public static final Object z(String r100, String r101, Object r102, m r103, g r104, Function1<? super ImageRequestBuilder, Unit> r110, Continuation<? super DataSource<Void>> r111) {
        if ((r111 instanceof ImageLoaderKt$prefetchToBitmapCache$1) == false) goto L7;
        ImageLoaderKt$prefetchToBitmapCache$1 r105 = (ImageLoaderKt$prefetchToBitmapCache$1) r111;
        int r106 = r105.label;
        if ((r106 & Integer.MIN_VALUE) == 0) goto L7;
        r105.label = r106 - Integer.MIN_VALUE;
    L8:
        Object r112 = r105.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r105.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        ImagePipeline r109 = (ImagePipeline) r105.L$4;
        r104 = (g) r105.L$3;
        r102 = r105.L$2;
        r101 = (String) r105.L$1;
        String r113 = (String) r105.L$0;
        ResultKt.throwOnFailure(r112);
    L18:
        ImageRequest r114 = (ImageRequest) r112;
        if (r104 != null) goto L22;
        r104 = E(r113, r101);
    L22:
        return r109.prefetchToBitmapCache(g(r114, r104), r102);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        ImagePipeline r115 = p();
        r105.L$0 = r100;
        r105.L$1 = r101;
        r105.L$2 = r102;
        r105.L$3 = r104;
        r105.L$4 = r115;
        r105.label = 1;
        Object r116 = a(r100, r101, r103, r110, r105);
        if (r116 != r107) goto L17;
        return r107;
    L17:
        r113 = r100;
        r109 = r115;
        r112 = r116;
    L7:
        r105 = new ImageLoaderKt$prefetchToBitmapCache$1(r111);
        goto L8
    }

    public static final Object m(String r100, String r101, Object r102, m r103, g r110, Bitmap.Config r111, Function1<? super ImageRequestBuilder, Unit> r112, Continuation<? super Bitmap> r113) {
        if ((r113 instanceof ImageLoaderKt$fetchDecodedImageNewInstance$1) == false) goto L7;
        ImageLoaderKt$fetchDecodedImageNewInstance$1 r104 = (ImageLoaderKt$fetchDecodedImageNewInstance$1) r113;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r114 = r104.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r104.label;
        if (r107 == 0) goto L17;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        ResultKt.throwOnFailure(r114);
    L35:
        return r114;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r111 = (Bitmap.Config) r104.L$4;
        r110 = (g) r104.L$3;
        r102 = r104.L$2;
        r101 = (String) r104.L$1;
        r100 = (String) r104.L$0;
        ResultKt.throwOnFailure(r114);
    L16:
        Bitmap.Config r108 = r111;
        ImageRequest r115 = (ImageRequest) r114;
        if (r110 != null) goto L32;
        r110 = E(r100, r101);
    L32:
        ImageRequest r109 = g(r115, r110);
        r104.L$0 = null;
        r104.L$1 = null;
        r104.L$2 = null;
        r104.L$3 = null;
        r104.L$4 = null;
        r104.label = 2;
        r114 = b0.f(r109, r102, true, r108, r104, 4);
        if (r114 != r106) goto L35;
        return r106;
    L17:
        ResultKt.throwOnFailure(r114);
        if (r100 != null) goto L20;
    L23:
        boolean r116 = true;
    L24:
        if (r116 == false) goto L26;
        return null;
    L26:
        r104.L$0 = r100;
        r104.L$1 = r101;
        r104.L$2 = r102;
        r104.L$3 = r110;
        r104.L$4 = r111;
        r104.label = 1;
        r114 = a(r100, r101, r103, r112, r104);
        if (r114 != r106) goto L16;
        return r106;
    L20:
        if (r100.length() == 0) goto L23;
        r116 = false;
    L7:
        r104 = new ImageLoaderKt$fetchDecodedImageNewInstance$1(r113);
        goto L8
    }
}
