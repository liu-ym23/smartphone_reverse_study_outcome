package com.larus.office.base.watermark;

import android.app.Application;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.office.base.watermark.api.remote.WatermarkApiImpl;
import com.larus.office.base.watermark.common.WatermarkLogger;
import com.larus.office.base.watermark.local.LocalImageBridge;
import com.larus.office.base.watermark.poller.AsyncTaskPoller;
import com.larus.office.base.watermark.rc.ResourceCenterUploadHelper;
import com.larus.platform.service.watermark.DownloadWatermarkScene;
import com.larus.platform.service.watermark.LocalImageWatermarkRequest;
import com.larus.platform.service.watermark.d;
import com.larus.platform.service.watermark.g;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.UStringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k1;

/* JADX INFO: loaded from: classes29.dex */
public final class DownloadWatermarkServiceImpl {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f361215f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f361216g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f361217h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WatermarkApiImpl f361218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AsyncTaskPoller f361219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f361220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicLong f361221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CoroutineScope f361222e;

    public static final class a {
    }

    public static final class b implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadWatermarkServiceImpl f361223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f361224b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Application f361225c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DownloadTask f361226d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ File f361227e;

        public b(DownloadWatermarkServiceImpl r100, String r101, Application r102, DownloadTask r103, PolarisFileWrapper r104) {
            this.f361223a = r100;
            this.f361224b = r101;
            this.f361225c = r102;
            this.f361226d = r103;
            this.f361227e = r104;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable r100) {
            Application r101 = this.f361225c;
            DownloadTask r102 = this.f361226d;
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
            Downloader.getInstance(r101).cancel(r102.getDownloadId());     // Catch: Throwable -> L5
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L7:
            this.f361223a.f361220c.remove(this.f361224b);
            Result.m9449constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(this.f361227e)));     // Catch: Throwable -> L10
        L13:
            return Unit.INSTANCE;
        L10:
            th = move-exception;
            Result.Companion r104 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        L5:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L7
        }
    }

    public static final class c extends AbsDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i<String> f361228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ File f361229b;

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onCanceled(DownloadInfo r100) {
            FLogger.f375446a.w("DownloadWatermarkSvc", "watermark download canceled");
            File r101 = this.f361229b;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
            Result.m9449constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(r101)));     // Catch: Throwable -> L5
        L8:
            if (this.f361228a.isActive() == false) goto L13;
            this.f361228a.resumeWith(Result.m9449constructorimpl(null));
            return;
        L13:
            return;
        L5:
            th = move-exception;
            Result.Companion r103 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L8
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onSuccessed(DownloadInfo r100) {
            if (r100 == null) goto L4;
            String r101 = r100.getTargetFilePath();
        L5:
            FLogger.f375446a.i("DownloadWatermarkSvc", "watermark download success, path=" + r101);
            if (this.f361228a.isActive() == false) goto L9;
            this.f361228a.resumeWith(Result.m9449constructorimpl(r101));
            return;
        L9:
            return;
        L4:
            r101 = null;
            goto L5
        }

        public c(j r100, PolarisFileWrapper r101) {
            this.f361228a = r100;
            this.f361229b = r101;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onFailed(DownloadInfo r100, BaseException r101) {
            FLogger r102 = FLogger.f375446a;
            StringBuilder r103 = new StringBuilder("watermark download failed: ");
            if (r101 == null) goto L5;
            Integer r104 = Integer.valueOf(r101.getErrorCode());
        L6:
            r103.append(r104);
            r103.append('/');
            if (r101 == null) goto L9;
            String r105 = r101.getErrorMessage();
        L10:
            r103.append(r105);
            r102.w("DownloadWatermarkSvc", r103.toString());
            File r106 = this.f361229b;
            Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L13
            Result.m9449constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(r106)));     // Catch: Throwable -> L13
        L16:
            if (this.f361228a.isActive() == false) goto L21;
            this.f361228a.resumeWith(Result.m9449constructorimpl(null));
            return;
        L21:
            return;
        L13:
            th = move-exception;
            Result.Companion r108 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L16
        L9:
            r105 = null;
            goto L10
        L5:
            r104 = null;
            goto L6
        }
    }

    static {
        f361215f = TimeUnit.DAYS.toMillis(7);
        f361216g = TimeUnit.HOURS.toMillis(1);
    }

    public DownloadWatermarkServiceImpl() {
        WatermarkApiImpl r100 = new WatermarkApiImpl();
        this.f361218a = r100;
        this.f361219b = new AsyncTaskPoller(r100);
        this.f361220c = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f361221d = new AtomicLong(0);
        this.f361222e = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public static final long a(DownloadWatermarkServiceImpl r100, File r101) {
        r100.getClass();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        Iterator r103 = SequencesKt.filter(FilesKt.walkTopDown(r101), new com.larus.office.base.watermark.a()).iterator();     // Catch: Throwable -> L9
        long r104 = 0;
    L5:
        if (r103.hasNext() == false) goto L7;
        r104 = r104 + ((File) r103.next()).length();     // Catch: Throwable -> L9
        goto L5
    L7:
        Object r105 = Result.m9449constructorimpl(Long.valueOf(r104));     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r105) == false) goto L15;
        r105 = 0L;
    L15:
        return ((Number) r105).longValue();
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final Object b(com.larus.platform.service.watermark.a r210, Continuation<? super g> r211) {
        com.larus.platform.service.watermark.a r100 = r210;
        if ((r211 instanceof DownloadWatermarkServiceImpl$applyWatermarkToFile$1) == false) goto L7;
        DownloadWatermarkServiceImpl$applyWatermarkToFile$1 r101 = (DownloadWatermarkServiceImpl$applyWatermarkToFile$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        DownloadWatermarkServiceImpl$applyWatermarkToFile$1 r110 = r101;
        Object r103 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        if (r104 == 0) goto L24;
        if (r104 == 1) goto L23;
        if (r104 == 2) goto L18;
        if (r104 == 3) goto L17;
        if (r104 != 4) goto L16;
        ResultKt.throwOnFailure(r103);
    L41:
        return r103;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        Throwable r105 = (Throwable) r110.L$0;
        ResultKt.throwOnFailure(r103);
        throw r105;
    L18:
        long r106 = r110.J$0;
        Function1<? super Continuation<? super Unit>, ? extends Object> r107 = (Function1) r110.L$1;
        r100 = (com.larus.platform.service.watermark.a) r110.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L21
        Function1<? super Continuation<? super Unit>, ? extends Object> r112 = r107;
        long r108 = r106;
    L52:
        nn9.a.AbstractC6944a r109 = (nn9.a.AbstractC6944a) r103;     // Catch: Throwable -> L42
        WatermarkLogger.Path r113 = WatermarkLogger.Path.B_FILE;
        DownloadWatermarkScene r114 = r100.f365845c;
        r110.L$0 = null;
        r110.L$1 = null;
        r110.label = 4;
        r103 = h(r113, r114, r108, r109, r112, "task_create_failed:", r112, r110);
        if (r103 != r111) goto L41;
        return r111;
    L42:
        th = th;
        r107 = r112;
    L46:
        k1 r115 = k1.f504992a;
        DownloadWatermarkServiceImpl$applyWatermarkToFile$resp$1 r116 = new DownloadWatermarkServiceImpl$applyWatermarkToFile$resp$1(r107, null);
        r110.L$0 = th;
        r110.L$1 = null;
        r110.label = 3;
        if (BuildersKt.withContext(r115, r116, r110) != r111) goto L56;
        return r111;
    L56:
        throw th;
    L21:
        th = th;
        goto L46
    L23:
        long r117 = r110.J$0;
        r100 = (com.larus.platform.service.watermark.a) r110.L$0;
        ResultKt.throwOnFailure(r103);
        long r118 = r117;
    L28:
        String r119 = (String) r103;
        if (r119 == null) goto L31;
        Function1<? super Continuation<? super Unit>, ? extends Object> r120 = new DownloadWatermarkServiceImpl$cleanupResource$1(r119, null);
        WatermarkApiImpl r121 = this.f361218a;     // Catch: Throwable -> L44
        DownloadWatermarkScene r122 = r100.f365845c;     // Catch: Throwable -> L44
        r110.L$0 = r100;     // Catch: Throwable -> L44
        r110.L$1 = r120;     // Catch: Throwable -> L44
        r110.J$0 = r118;     // Catch: Throwable -> L44
        r110.label = 2;     // Catch: Throwable -> L44
        long r123 = r118;
        Object r124 = r121.c(r119, null, "file", r122, r110);     // Catch: Throwable -> L44
        if (r124 != r111) goto L36;
        return r111;
    L36:
        r112 = r120;
        r103 = r124;
        r108 = r123;
    L44:
        th = th;
        r107 = r120;
        goto L46
    L31:
        return e(WatermarkLogger.Path.B_FILE, r100.f365845c, r118, "rc_upload_failed", null);
    L24:
        ResultKt.throwOnFailure(r103);
        long r125 = System.currentTimeMillis();
        ResourceCenterUploadHelper r126 = ResourceCenterUploadHelper.f361247a;
        String r127 = r100.f365843a;
        String r128 = r100.f365844b;
        r110.L$0 = r100;
        r110.J$0 = r125;
        r110.label = 1;
        Object r129 = r126.b(r127, r128, r110);
        if (r129 != r111) goto L27;
        return r111;
    L27:
        r118 = r125;
        r103 = r129;
    L7:
        r101 = new DownloadWatermarkServiceImpl$applyWatermarkToFile$1(this, r211);
        goto L8
    }

    public final Object c(com.larus.platform.service.watermark.a r110, Continuation<? super g> r111) {
        if ((r111 instanceof DownloadWatermarkServiceImpl$applyWatermarkToFileAsLocal$1) == false) goto L7;
        DownloadWatermarkServiceImpl$applyWatermarkToFileAsLocal$1 r100 = (DownloadWatermarkServiceImpl$applyWatermarkToFileAsLocal$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L24;
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L18;
        if (r103 == 3) goto L17;
        if (r103 != 4) goto L15;
        Throwable r113 = (Throwable) r100.L$0;
        ResultKt.throwOnFailure(r112);
        throw r113;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        g r114 = (g) r100.L$0;
        ResultKt.throwOnFailure(r112);
        return r114;
    L18:
        g.b r115 = (g.b) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L21
    L39:
        String r116 = (String) r112;     // Catch: Throwable -> L21
        if (r116 == null) goto L42;
        Object r117 = new g.c(r116);     // Catch: Throwable -> L21
    L43:
        k1 r104 = k1.f504992a;
        DownloadWatermarkServiceImpl$applyWatermarkToFileAsLocal$2 r105 = new DownloadWatermarkServiceImpl$applyWatermarkToFileAsLocal$2(r115, null);
        r100.L$0 = r117;
        r100.label = 3;
        if (BuildersKt.withContext(r104, r105, r100) != r102) goto L47;
        return r102;
    L47:
        return r117;
    L42:
        r117 = new g.a("download_to_local_failed");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        g.b r118 = r115;
        th = th;
    L50:
        k1 r106 = k1.f504992a;
        DownloadWatermarkServiceImpl$applyWatermarkToFileAsLocal$2 r107 = new DownloadWatermarkServiceImpl$applyWatermarkToFileAsLocal$2(r118, null);
        r100.L$0 = th;
        r100.label = 4;
        if (BuildersKt.withContext(r106, r107, r100) != r102) goto L58;
        return r102;
    L58:
        throw th;
    L23:
        r110 = (com.larus.platform.service.watermark.a) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L28:
        if ((r112 instanceof g.b) == false) goto L30;
        r118 = (g.b) r112;
    L31:
        if (r118 == null) goto L33;
        String r119 = new PolarisFileWrapper(r110.f365843a).getName();
        String r108 = r118.f365853a;     // Catch: Throwable -> L49
        Intrinsics.checkNotNull(r119);     // Catch: Throwable -> L49
        r100.L$0 = r118;     // Catch: Throwable -> L49
        r100.label = 2;     // Catch: Throwable -> L49
        Object r120 = f(r108, r119, r100);     // Catch: Throwable -> L49
        if (r120 != r102) goto L38;
        return r102;
    L38:
        g.b r109 = r118;
        r112 = r120;
        r115 = r109;
    L49:
        th = th;
        goto L50
    L33:
        return new g.a("file_watermark_failed");
    L30:
        r118 = null;
        goto L31
    L24:
        ResultKt.throwOnFailure(r112);
        r100.L$0 = r110;
        r100.label = 1;
        r112 = b(r110, r100);
        if (r112 != r102) goto L28;
        return r102;
    L7:
        r100 = new DownloadWatermarkServiceImpl$applyWatermarkToFileAsLocal$1(this, r111);
        goto L8
    }

    public final Object d(LocalImageWatermarkRequest r110, Continuation<? super g> r111) {
        if ((r111 instanceof DownloadWatermarkServiceImpl$applyWatermarkToLocalImage$1) == false) goto L7;
        DownloadWatermarkServiceImpl$applyWatermarkToLocalImage$1 r100 = (DownloadWatermarkServiceImpl$applyWatermarkToLocalImage$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        long r104 = r100.J$0;
        r110 = (LocalImageWatermarkRequest) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L18:
        com.larus.platform.service.watermark.c r113 = (com.larus.platform.service.watermark.c) r112;
        if (r113 == null) goto L21;
        int r105 = WatermarkLogger.f361235a;
        WatermarkLogger.b(WatermarkLogger.Path.B_LOCAL, r110.f365825c, WatermarkLogger.Result.READY, System.currentTimeMillis() - r104, null, null, 48);
        return new g.d(r113);
    L21:
        int r114 = WatermarkLogger.f361235a;
        WatermarkLogger.b(WatermarkLogger.Path.B_LOCAL, r110.f365825c, WatermarkLogger.Result.DEGRADED, System.currentTimeMillis() - r104, "local_apply_failed", null, 32);
        return new g.a("local_apply_failed");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        long r106 = System.currentTimeMillis();
        LocalImageBridge r115 = LocalImageBridge.f361240a;
        r100.L$0 = r110;
        r100.J$0 = r106;
        r100.label = 1;
        r115.getClass();
        r112 = LocalImageBridge.b(r110, r100);
        if (r112 != r102) goto L17;
        return r102;
    L17:
        r104 = r106;
    L7:
        r100 = new DownloadWatermarkServiceImpl$applyWatermarkToLocalImage$1(this, r111);
        goto L8
    }

    public final Object g(d r110, Continuation<? super g> r111) {
        if ((r111 instanceof DownloadWatermarkServiceImpl$exchangeWatermarkUrl$1) == false) goto L7;
        DownloadWatermarkServiceImpl$exchangeWatermarkUrl$1 r100 = (DownloadWatermarkServiceImpl$exchangeWatermarkUrl$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DownloadWatermarkServiceImpl$exchangeWatermarkUrl$1 r112 = r100;
        Object r113 = r112.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r112.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r113);
    L23:
        return r113;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r104 = r112.J$0;
        r110 = (d) r112.L$0;
        ResultKt.throwOnFailure(r113);
        long r105 = r104;
    L20:
        WatermarkLogger.Path r106 = WatermarkLogger.Path.A;
        DownloadWatermarkScene r107 = r110.f365851b;
        r112.L$0 = null;
        r112.label = 2;
        r113 = h(r106, r107, r105, (nn9.a.AbstractC6944a) r113, null, "", null, r112);
        if (r113 != r102) goto L23;
        return r102;
    L16:
        ResultKt.throwOnFailure(r113);
        long r108 = System.currentTimeMillis();
        WatermarkApiImpl r109 = this.f361218a;
        String r114 = r110.f365850a;
        DownloadWatermarkScene r115 = r110.f365851b;
        r112.L$0 = r110;
        r112.J$0 = r108;
        r112.label = 1;
        r113 = r109.c(null, r114, "image", r115, r112);
        if (r113 != r102) goto L19;
        return r102;
    L19:
        r105 = r108;
    L7:
        r100 = new DownloadWatermarkServiceImpl$exchangeWatermarkUrl$1(this, r111);
        goto L8
    }

    public final Object f(String r210, String r211, Continuation<? super String> r212) {
        if ((r212 instanceof DownloadWatermarkServiceImpl$downloadWatermarkUrlToCache$1) == false) goto L7;
        DownloadWatermarkServiceImpl$downloadWatermarkUrlToCache$1 r100 = (DownloadWatermarkServiceImpl$downloadWatermarkUrlToCache$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DownloadWatermarkServiceImpl$downloadWatermarkUrlToCache$1 r102 = r100;
        Object r103 = r102.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        String r105 = (String) r102.L$4;
        File r106 = (File) r102.L$3;
        Application r107 = (Application) r102.L$2;
        String r108 = (String) r102.L$1;
        String r109 = (String) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L14
    L35:
        String r111 = (String) r103;     // Catch: Throwable -> L14
        this.f361220c.remove(r105);
        return r111;
    L14:
        th = th;
        String r112 = r105;
    L40:
        this.f361220c.remove(r112);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        Application r113 = AppHost.f326268a.getApplication();
        PolarisFileWrapper r114 = new PolarisFileWrapper(r113.getExternalFilesDir(null), "watermark/cache");
        if (r114.exists() == true) goto L21;
        r114.mkdirs();
    L21:
        long r115 = System.currentTimeMillis();
        long r116 = this.f361221d.get();
        if ((r115 - r116) >= f361216g) goto L25;
    L28:
        PolarisFileWrapper r117 = new PolarisFileWrapper(r114, "dl_" + UStringsKt.m10781toStringV7xB4Y4(UInt.m9544constructorimpl(r210.hashCode()), 16) + '_' + System.currentTimeMillis());
        r117.mkdirs();
        r112 = r117.getAbsolutePath();
        Set<String> r118 = this.f361220c;
        Intrinsics.checkNotNull(r112);
        r118.add(r112);
        r102.L$0 = r210;     // Catch: Throwable -> L39
        r102.L$1 = r211;     // Catch: Throwable -> L39
        r102.L$2 = r113;     // Catch: Throwable -> L39
        r102.L$3 = r117;     // Catch: Throwable -> L39
        r102.L$4 = r112;     // Catch: Throwable -> L39
        r102.label = 1;     // Catch: Throwable -> L39
        j r119 = new j(IntrinsicsKt.intercepted(r102), 1);     // Catch: Throwable -> L39
        r119.C();     // Catch: Throwable -> L39
        DownloadTask r120 = Downloader.with(r113).url(r210).name(r211).savePath(r112).retryCount(2).subThreadListener(new c(r119, r117));     // Catch: Throwable -> L39
        r119.i(new b(this, r112, r113, r120, r117));     // Catch: Throwable -> L39
        r120.asyncDownload(null);     // Catch: Throwable -> L39
        r103 = r119.B();     // Catch: Throwable -> L39
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L32;
        DebugProbesKt.probeCoroutineSuspended(r102);     // Catch: Throwable -> L39
    L32:
        if (r103 != r110) goto L34;
        return r110;
    L34:
        r105 = r112;
    L39:
        th = th;
        goto L40
    L25:
        if (this.f361221d.compareAndSet(r116, r115) == false) goto L28;
        BuildersKt.launch$default(this.f361222e, null, null, new DownloadWatermarkServiceImpl$scheduleCleanup$1(r114, this, r115, null), 3, null);
    L7:
        r100 = new DownloadWatermarkServiceImpl$downloadWatermarkUrlToCache$1(this, r212);
        goto L8
    }

    public static g.a e(WatermarkLogger.Path r100, DownloadWatermarkScene r101, long r110, String r111, String r112) {
        FLogger.f375446a.w("DownloadWatermarkSvc", r100 + " degraded reason=" + r111 + " task=" + r112);
        int r102 = WatermarkLogger.f361235a;
        WatermarkLogger.a(r100, r101, WatermarkLogger.Result.DEGRADED, System.currentTimeMillis() - r110, r111, r112);
        return new g.a(r111);
    }

    public static g.b j(WatermarkLogger.Path r100, DownloadWatermarkScene r110, long r111, String r112, String r113, Function1 r114) {
        int r101 = WatermarkLogger.f361235a;
        WatermarkLogger.b(r100, r110, WatermarkLogger.Result.READY, System.currentTimeMillis() - r111, null, r113, 16);
        if (r114 != null) goto L6;
        r114 = new DownloadWatermarkServiceImpl$readyUrlResult$1(null);
    L6:
        return new g.b(r112, r114);
    }

    public final Object i(WatermarkLogger.Path r100, DownloadWatermarkScene r101, long r110, String r111, Function1<? super Continuation<? super Unit>, ? extends Object> r112, Function1<? super Continuation<? super Unit>, ? extends Object> r113, Continuation<? super g> r114) {
        if ((r114 instanceof DownloadWatermarkServiceImpl$pollReadyUrl$1) == false) goto L7;
        DownloadWatermarkServiceImpl$pollReadyUrl$1 r102 = (DownloadWatermarkServiceImpl$pollReadyUrl$1) r114;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r115 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        long r106 = r102.J$0;
        AsyncTaskPoller.b r116 = (AsyncTaskPoller.b) r102.L$3;
        String r117 = (String) r102.L$2;
        DownloadWatermarkScene r118 = (DownloadWatermarkScene) r102.L$1;
        WatermarkLogger.Path r119 = (WatermarkLogger.Path) r102.L$0;
        ResultKt.throwOnFailure(r115);
    L29:
        long r107 = r106;
        AsyncTaskPoller.b r120 = r116;
        String r108 = r117;
        DownloadWatermarkScene r109 = r118;
        WatermarkLogger.Path r121 = r119;
    L32:
        return e(r121, r109, r107, ((AsyncTaskPoller.b.a) r120).f361245a, r108);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r110 = r102.J$0;
        r113 = (Function1) r102.L$4;
        r112 = (Function1) r102.L$3;
        r111 = (String) r102.L$2;
        r101 = (DownloadWatermarkScene) r102.L$1;
        r100 = (WatermarkLogger.Path) r102.L$0;
        ResultKt.throwOnFailure(r115);
    L19:
        Function1<? super Continuation<? super Unit>, ? extends Object> r122 = r112;
        String r123 = r111;
        Function1<? super Continuation<? super Unit>, ? extends Object> r124 = r113;
        r120 = (AsyncTaskPoller.b) r115;
        if ((r120 instanceof AsyncTaskPoller.b.C4439b) == false) goto L23;
        return j(r100, r101, r110, ((AsyncTaskPoller.b.C4439b) r120).f361246a, r123, r122);
    L23:
        if ((r120 instanceof AsyncTaskPoller.b.a) == false) goto L34;
        if (r124 == null) goto L30;
        r102.L$0 = r100;
        r102.L$1 = r101;
        r102.L$2 = r123;
        r102.L$3 = r120;
        r102.L$4 = null;
        r102.J$0 = r110;
        r102.label = 2;
        if (r124.invoke(r102) != r104) goto L28;
        return r104;
    L28:
        r118 = r101;
        r119 = r100;
        r106 = r110;
        r117 = r123;
        r116 = r120;
        goto L29
    L30:
        r121 = r100;
        r109 = r101;
        r107 = r110;
        r108 = r123;
        goto L32
    L34:
        throw new NoWhenBranchMatchedException();
    L16:
        ResultKt.throwOnFailure(r115);
        AsyncTaskPoller r125 = this.f361219b;
        r102.L$0 = r100;
        r102.L$1 = r101;
        r102.L$2 = r111;
        r102.L$3 = r112;
        r102.L$4 = r113;
        r102.J$0 = r110;
        r102.label = 1;
        r115 = r125.a(r111, r102);
        if (r115 != r104) goto L19;
        return r104;
    L7:
        r102 = new DownloadWatermarkServiceImpl$pollReadyUrl$1(this, r114);
        goto L8
    }

    public final Object h(WatermarkLogger.Path r110, DownloadWatermarkScene r111, long r112, nn9.a.AbstractC6944a r113, Function1<? super Continuation<? super Unit>, ? extends Object> r114, String r210, Function1<? super Continuation<? super Unit>, ? extends Object> r211, Continuation<? super g> r212) {
        if ((r212 instanceof DownloadWatermarkServiceImpl$handleCreateResp$1) == false) goto L7;
        DownloadWatermarkServiceImpl$handleCreateResp$1 r100 = (DownloadWatermarkServiceImpl$handleCreateResp$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DownloadWatermarkServiceImpl$handleCreateResp$1 r102 = r100;
        Object r103 = r102.result;
        Object r115 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        long r105 = r102.J$0;
        String r106 = (String) r102.L$3;
        nn9.a.AbstractC6944a r107 = (nn9.a.AbstractC6944a) r102.L$2;
        DownloadWatermarkScene r108 = (DownloadWatermarkScene) r102.L$1;
        WatermarkLogger.Path r109 = (WatermarkLogger.Path) r102.L$0;
        ResultKt.throwOnFailure(r103);
        String r116 = r106;
        long r117 = r105;
        DownloadWatermarkScene r118 = r108;
    L34:
        return e(r109, r118, r117, r116 + ((nn9.a.AbstractC6944a.C6945a) r107).f519678a, null);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
    L24:
        return r103;
    L16:
        ResultKt.throwOnFailure(r103);
        if ((r113 instanceof nn9.a.AbstractC6944a.c) == false) goto L20;
        return j(r110, r111, r112, ((nn9.a.AbstractC6944a.c) r113).f519680a, null, r114);
    L20:
        if ((r113 instanceof nn9.a.AbstractC6944a.b) == false) goto L26;
        String r119 = ((nn9.a.AbstractC6944a.b) r113).f519679a;
        r102.label = 1;
        r103 = i(r110, r111, r112, r119, r114, r211, r102);
        if (r103 != r115) goto L24;
        return r115;
    L26:
        if ((r113 instanceof nn9.a.AbstractC6944a.C6945a) == false) goto L36;
        if (r211 == null) goto L31;
        WatermarkLogger.Path r120 = r110;
        r102.L$0 = r120;
        r118 = r111;
        r102.L$1 = r118;
        r102.L$2 = r113;
        String r121 = r210;
        r102.L$3 = r121;
        long r122 = r112;
        r102.J$0 = r122;
        r102.label = 2;
        if (r211.invoke(r102) != r115) goto L32;
        return r115;
    L32:
        r116 = r121;
        r107 = r113;
        r109 = r120;
        r117 = r122;
        goto L34
    L31:
        r120 = r110;
        r118 = r111;
        r122 = r112;
        r121 = r210;
        goto L32
    L36:
        throw new NoWhenBranchMatchedException();
    L7:
        r100 = new DownloadWatermarkServiceImpl$handleCreateResp$1(this, r212);
        goto L8
    }
}
