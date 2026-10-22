package com.bytedance.forest.preload;

import android.net.Uri;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.ResourceFrom2;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.utils.h;
import com.bytedance.forest.utils.i;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements Function1<Response, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response f244467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Function1<Response, Unit>> f244468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile SoftReference<DataSource<CloseableReference<CloseableImage>>> f244469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f244470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Scene f244471e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f244472f;

    /* JADX INFO: renamed from: com.bytedance.forest.preload.a$a, reason: collision with other inner class name */
    public static final class C3496a extends BaseDataSubscriber<CloseableReference<CloseableImage>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f244473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Response f244474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Uri f244475c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0 f244476d;

        @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
        public final void onCancellation(DataSource<CloseableReference<CloseableImage>> r100) {
            i r101 = i.f244548a;
            i.f("PreLoader", "preload image canceled, src = " + this.f244473a.f244470d + ", redirectTo: " + this.f244475c, 4);
            this.f244476d.invoke();
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
            i r101 = i.f244548a;
            i.f("PreLoader", "preload image failed, src = " + this.f244473a.f244470d + ", redirectTo: " + this.f244475c, 4);
            this.f244476d.invoke();
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> r100) {
            if (r100 != null) goto L4;
        L22:
            this.f244476d.invoke();
            return;
        L4:
            if (r100.isFinished() != true) goto L22;
            i r101 = i.f244548a;
            boolean r102 = false;
            i.h("PreLoader", "preDecode bitmap succeed, src = " + this.f244474b.f244315q.getOriginUrl() + ", redirectTo: " + this.f244475c, false, 60);
            CloseableReference<CloseableImage> r103 = r100.getResult();
            if (r103 == null) goto L22;
            if ((r103.get() instanceof CloseableBitmap) == false) goto L22;
            this.f244474b.f244308j = new SoftReference(r103);
            if (this.f244474b.f244316r == true) goto L22;
            this.f244474b.f244316r = true;
            Response r104 = this.f244474b;
            if (((CloseableBitmap) r103.get()).isHitMemoryCache() == false) goto L14;
        L15:
            r102 = true;
        L16:
            r104.f244323y = r102;
            if (((CloseableBitmap) r103.get()).isHitMemoryCache() == false) goto L20;
            Response r105 = this.f244474b;
            r105.C = "FrescoMemoryFetcher";
            r105.f244319u = ResourceFrom.MEMORY;
            r105.f244320v = ResourceFrom2.MEMORY;
            r105.f244321w = ResourceFrom.CDN;
            r105.f244322x = ResourceFrom2.CDN;
            goto L22
        L20:
            if (((CloseableBitmap) r103.get()).isHitDiskCache() == false) goto L22;
            Response r106 = this.f244474b;
            r106.C = "FrescoCDNFetcher";
            r106.f244319u = ResourceFrom.CDN;
            r106.f244323y = true;
            r106.f244320v = ResourceFrom2.CDN_CACHE;
            goto L22
        L14:
            if (((CloseableBitmap) r103.get()).isHitDiskCache() == false) goto L16;
            goto L15
        }

        public C3496a(a r100, Response r101, Uri r102, Function0 r103) {
            this.f244473a = r100;
            this.f244474b = r101;
            this.f244475c = r102;
            this.f244476d = r103;
        }
    }

    public static final class b implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f244477a = null;

        static {
            f244477a = new b();
        }

        public b() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r100) {
            r100.run();
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Response r100) {
        final Response r101 = r100;
        i r102 = i.f244548a;
        i.f("PreLoader", "preload result:" + r101.f244316r, 4);
        if (this.f244471e == Scene.LYNX_IMAGE) goto L26;
    L11:
        this.f244472f.invoke();
        monitor-enter(this);
        this.f244467a = r101;     // Catch: Throwable -> L23
        if ((!((ArrayList) this.f244468b).isEmpty()) == false) goto L20;
        Iterator r103 = ((ArrayList) this.f244468b).iterator();     // Catch: Throwable -> L23
    L17:
        if (r103.hasNext() == false) goto L20;
        ((Function1) r103.next()).invoke(r101);     // Catch: Throwable -> L23
    L20:
        monitor-exit(this);
        return Unit.INSTANCE;
    L23:
        th = move-exception;
        throw th;
    L26:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L6
        a(r101, new CallbackDelegate$invoke$$inlined$runCatching$lambda$1(this, r101));     // Catch: Throwable -> L6
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L11;
        i r107 = i.f244548a;
        i.h("PreLoader", "image preload failed by " + r106, false, 60);
    L6:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final void a(Response r100, Function0<Unit> r101) {
        if (r100.f244316r == false) goto L9;
        String r102 = r100.f244318t;
        if (r102 == null) goto L9;
        if (h.a(r102) != true) goto L9;
        Uri r103 = new Uri.Builder().scheme("file").authority("").path(r100.f244318t).build();
    L10:
        ImageRequest r104 = ImageRequestBuilder.newBuilderWithSource(r103).build();
        DataSource<CloseableReference<CloseableImage>> r105 = Fresco.getImagePipeline().getDataSourceSupplier(r104, null, ImageRequest.RequestLevel.FULL_FETCH).get();
        this.f244469c = new SoftReference(r105);
        r105.subscribe(new C3496a(this, r100, r103, r101), b.f244477a);
        return;
    L9:
        r103 = UriProtector.parse(r100.f244315q.getOriginUrl());
        goto L10
    }

    public a(String r100, Scene r101, Function0<Unit> r102) {
        this.f244470d = r100;
        this.f244471e = r101;
        this.f244472f = r102;
        this.f244468b = new ArrayList();
    }
}
