package com.larus.video.impl.sdk;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.applet.aibridge.AIBridgePreloadMediaResourceMethod;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.larus.common.apphost.AppHost;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.k0;
import com.larus.platform.api.l4;
import com.larus.platform.api.z3;
import com.larus.platform.constants.media.DataLoaderPreloadPriority;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.launch.ObricLazyInitSettingsServiceDelegate;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.PreloaderURLItem;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.download.DownloadTask;
import com.ss.ttvideoengine.download.DownloadURLTask;
import com.ss.ttvideoengine.download.Downloader;
import com.ss.ttvideoengine.download.IDownloaderListener;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.utils.Error;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class TTVideoEngineStaticServiceImpl implements z3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, kotlinx.coroutines.i<String>> f375777a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, kotlinx.coroutines.i<Boolean>> f375778b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f375779c = null;

    public static final class a implements IDownloaderListener {
        public a() {
        }

        @Override // com.ss.ttvideoengine.download.IDownloaderListener
        public final void downloaderWriteData(Downloader r100, DownloadTask r101, long r102, long r103) {
        }

        @Override // com.ss.ttvideoengine.download.IDownloaderListener
        public final void downloaderDidComplete(Downloader r100, DownloadTask r101, Error r102) {
            String r103 = null;
            if ((r101 instanceof DownloadURLTask) == false) goto L5;
            DownloadURLTask r104 = (DownloadURLTask) r101;
        L6:
            if (r104 == null) goto L8;
            String r105 = r104.getKey();
        L9:
            if (r105 != null) goto L11;
            r105 = "";
        L11:
            boolean r106 = true;
            if (r105.length() != 0) goto L14;
            boolean r107 = true;
        L15:
            if (r107 == false) goto L17;
            return;
        L17:
            FLogger r108 = FLogger.f375446a;
            StringBuilder r109 = new StringBuilder("[downloadUrlUseDataLoader] complete, key=");
            r109.append(r105);
            r109.append(", errorCode=");
            if (r102 == null) goto L20;
            Integer r110 = Integer.valueOf(r102.code);
        L21:
            r109.append(r110);
            r109.append(", errorMsg=");
            if (r102 == null) goto L24;
            String r111 = r102.description;
        L25:
            r109.append(r111);
            r108.i("TTVideoEngineStaticServiceImpl", r109.toString());
            ConcurrentHashMap<String, kotlinx.coroutines.i<String>> r112 = TTVideoEngineStaticServiceImpl.f375777a;
            if (r101 == null) goto L28;
            String r113 = r101.getAvailableLocalFilePath();
        L29:
            if (r102 != null) goto L38;
            if (r113 != null) goto L32;
        L35:
            boolean r114 = true;
        L36:
            if (r114 == true) goto L38;
        L39:
            if (r106 == false) goto L41;
            r103 = r113;
        L41:
            kotlinx.coroutines.i<String> r115 = TTVideoEngineStaticServiceImpl.f375777a.remove(r105);
            if (r115 != null) goto L45;
            return;
        L45:
            if (r115.isActive() == false) goto L48;
            r115.resumeWith(Result.m9449constructorimpl(r103));
            return;
        L48:
            return;
        L32:
            if (r113.length() == 0) goto L35;
            r114 = false;
        L38:
            r106 = false;
            goto L39
        L28:
            r113 = null;
            goto L29
        L24:
            r111 = null;
            goto L25
        L20:
            r110 = null;
            goto L21
        L14:
            r107 = false;
            goto L15
        L8:
            r105 = null;
            goto L9
        L5:
            r104 = null;
            goto L6
        }

        @Override // com.ss.ttvideoengine.download.IDownloaderListener
        public final void downloaderDidLoadAllTask(Downloader r100, List<DownloadTask> r101, Error r102) {
            FLogger r103 = FLogger.f375446a;
            StringBuilder r104 = new StringBuilder("[downloadUrlUseDataLoader] load all tasks, taskSize=");
            String r105 = null;
            if (r101 == null) goto L5;
            Integer r106 = Integer.valueOf(r101.size());
        L6:
            r104.append(r106);
            r104.append(", errorCode=");
            if (r102 == null) goto L9;
            Integer r107 = Integer.valueOf(r102.code);
        L10:
            r104.append(r107);
            r104.append(", errorMsg=");
            if (r102 == null) goto L13;
            r105 = r102.description;
        L13:
            r104.append(r105);
            r103.i("TTVideoEngineStaticServiceImpl", r104.toString());
            ConcurrentHashMap<String, kotlinx.coroutines.i<String>> r108 = TTVideoEngineStaticServiceImpl.f375777a;
            if (r102 != null) goto L16;
            boolean r109 = true;
        L17:
            Iterator<Map.Entry<String, kotlinx.coroutines.i<Boolean>>> r110 = TTVideoEngineStaticServiceImpl.f375778b.entrySet().iterator();
        L19:
            if (r110.hasNext() == false) goto L23;
            Map.Entry<String, kotlinx.coroutines.i<Boolean>> r111 = r110.next();
            String r112 = r111.getKey();
            kotlinx.coroutines.i<Boolean> r113 = r111.getValue();
            TTVideoEngineStaticServiceImpl.f375778b.remove(r112);
            if (r113.isActive() == false) goto L19;
            r113.resumeWith(Result.m9449constructorimpl(Boolean.valueOf(r109)));
            goto L19
        L23:
            return;
        L16:
            r109 = false;
            goto L17
        L9:
            r107 = null;
            goto L10
        L5:
            r106 = null;
            goto L6
        }

        @Override // com.ss.ttvideoengine.download.IDownloaderListener
        public final void downloaderStateChanged(Downloader r100, DownloadTask r101, int r102) {
            FLogger r103 = FLogger.f375446a;
            StringBuilder r104 = new StringBuilder("[downloadUrlUseDataLoader] state=");
            r104.append(r102);
            r104.append(", key=");
            String r105 = null;
            if ((r101 instanceof DownloadURLTask) == false) goto L5;
            DownloadURLTask r106 = (DownloadURLTask) r101;
        L6:
            if (r106 == null) goto L8;
            r105 = r106.getKey();
        L8:
            r104.append(r105);
            r103.d("TTVideoEngineStaticServiceImpl", r104.toString());
            return;
        L5:
            r106 = null;
            goto L6
        }

        @Override // com.ss.ttvideoengine.download.IDownloaderListener
        public final void downloaderDidResume(Downloader r100, DownloadTask r101, long r102, long r103) {
            FLogger r104 = FLogger.f375446a;
            StringBuilder r105 = new StringBuilder("[downloadUrlUseDataLoader] resume, key=");
            String r106 = null;
            if ((r101 instanceof DownloadURLTask) == false) goto L5;
            DownloadURLTask r107 = (DownloadURLTask) r101;
        L6:
            if (r107 == null) goto L8;
            r106 = r107.getKey();
        L8:
            r105.append(r106);
            r105.append(", offset=");
            r105.append(r102);
            r105.append(", total=");
            r105.append(r103);
            r104.i("TTVideoEngineStaticServiceImpl", r105.toString());
            return;
        L5:
            r107 = null;
            goto L6
        }

        @Override // com.ss.ttvideoengine.download.IDownloaderListener
        public final void downloaderProgress(Downloader r100, DownloadTask r101, long r102, long r103) {
            FLogger r104 = FLogger.f375446a;
            StringBuilder r105 = new StringBuilder("[downloadUrlUseDataLoader] progress, key=");
            String r106 = null;
            if ((r101 instanceof DownloadURLTask) == false) goto L5;
            DownloadURLTask r107 = (DownloadURLTask) r101;
        L6:
            if (r107 == null) goto L8;
            r106 = r107.getKey();
        L8:
            r105.append(r106);
            r105.append(", received=");
            r105.append(r102);
            r105.append(", total=");
            r105.append(r103);
            r104.d("TTVideoEngineStaticServiceImpl", r105.toString());
            return;
        L5:
            r107 = null;
            goto L6
        }
    }

    public static final class b {
    }

    public static final class c implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f375780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DownloadURLTask f375781b;

        public c(String r100, TTVideoEngineStaticServiceImpl r101, DownloadURLTask r102) {
            this.f375780a = r100;
            this.f375781b = r102;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable r100) {
            TTVideoEngineStaticServiceImpl.f375777a.remove(this.f375780a);
            DownloadURLTask r101 = this.f375781b;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
            r101.suspend();     // Catch: Throwable -> L5
            Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L7:
            String r104 = this.f375780a;
            Throwable r105 = Result.m9452exceptionOrNullimpl(r103);
            if (r105 == null) goto L11;
            FLogger.f375446a.e("TTVideoEngineStaticServiceImpl", "[downloadUrlUseDataLoader] suspend task failed, key=" + r104 + ", " + r105);
        L11:
            return Unit.INSTANCE;
        L5:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L7
        }
    }

    public TTVideoEngineStaticServiceImpl() {
    }

    @Override // com.larus.platform.api.z3
    public final void o() {
    }

    static {
        f375777a = new ConcurrentHashMap();
        f375778b = new ConcurrentHashMap();
        f375779c = new a();
    }

    @Override // com.larus.platform.api.z3
    public final void j() {
        if (ObricLazyInitSettingsServiceDelegate.f392888a.b() == false) goto L6;
        FLogger.f375446a.i("BackgroundLazyInit", "event=component_init_request, component=VideoEngine, trigger=first_use");
        n2a.c.f516801a.getClass();
        n2a.c.a();
        return;
    }

    @Override // com.larus.platform.api.z3
    public final void switchToCellularNetwork() {
        List<o> r100 = o.f375810l;
        TTVideoEngine.switchToCellularNetwork();
    }

    @Override // com.larus.platform.api.z3
    public final void switchToDefaultNetwork() {
        List<o> r100 = o.f375810l;
        TTVideoEngine.switchToDefaultNetwork();
    }

    @Override // com.larus.platform.api.z3
    public final int e(com.larus.video.impl.sdk.a r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        List<o> r101 = o.f375810l;
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        VideoModel r102 = r100.f375782a;
        if (r102 != null) goto L5;
        r102 = null;
    L5:
        if (r102 != null) goto L8;
        return 0;
    L8:
        return r102.getVideoRefInt(3);
    }

    @Override // com.larus.platform.api.z3
    public final yq9.a g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        DataLoaderHelper.DataLoaderCacheInfo r101 = TTVideoEngine.getCacheInfo(r100);
        if (r101 != null) goto L7;
        return new yq9.a(0);
    L7:
        return new yq9.a(r101.mMediaSize, r101.mCacheSizeFromZero, r101.mLocalFilePath);
    }

    @Override // com.larus.platform.api.z3
    public final void k(Function1<? super IVideoController, Boolean> r100) {
        List<o> r101 = o.f375810l;
        List<o> r102 = o.f375810l;
        if (((ArrayList) r102).size() == 0) goto L30;
        monitor-enter(r102);
        Iterator r103 = ((ArrayList) r102).iterator();     // Catch: Throwable -> L20
    L8:
        if (r103.hasNext() == false) goto L17;
        o r104 = (o) r103.next();     // Catch: Throwable -> L20
        if (r100 != null) goto L12;
    L14:
        boolean r105 = false;
    L15:
        if (r105 == true) goto L8;
        r104.b();     // Catch: Throwable -> L20
        goto L8
    L12:
        if (r100.invoke(r104).booleanValue() == true) goto L14;
        r105 = true;
        goto L15
    L17:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r102);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.platform.api.z3
    public final void n(Function1<? super IVideoController, Boolean> r100) {
        List<o> r101 = o.f375810l;
        List<o> r102 = o.f375810l;
        if (((ArrayList) r102).size() == 0) goto L30;
        monitor-enter(r102);
        Iterator r103 = ((ArrayList) r102).iterator();     // Catch: Throwable -> L20
    L8:
        if (r103.hasNext() == false) goto L17;
        o r104 = (o) r103.next();     // Catch: Throwable -> L20
        if (r100 != null) goto L12;
    L14:
        boolean r105 = false;
    L15:
        if (r105 == true) goto L8;
        r104.stop();     // Catch: Throwable -> L20
        goto L8
    L12:
        if (r100.invoke(r104).booleanValue() == true) goto L14;
        r105 = true;
        goto L15
    L17:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r102);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.platform.api.z3
    public final void f(String r100, l4 r101) {
        List<o> r102 = o.f375810l;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L13;
        ThreadPlus.submitRunnable(new k(r100, r101));
        return;
    L13:
        return;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r103 = false;
        goto L9
    }

    @Override // com.larus.platform.api.z3
    public final void i(yq9.d r100, final AIBridgePreloadMediaResourceMethod.b r110) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        List<o> r101 = o.f375810l;
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        PreloaderURLItem r102 = new PreloaderURLItem(r100.f568869a, null, r100.f568870b, new String[]{r100.f568871c});
        r102.setPriorityLevel(r100.f568872d.getValue());
        r102.setCallBackListener(new n(r110));
        TTVideoEngine.addTask(r102);
    }

    @Override // com.larus.platform.api.z3
    public final Object h(String r110, String r111, Continuation<? super String> r210) {
        String r100 = r111;
        if ((r210 instanceof TTVideoEngineStaticServiceImpl$downloadUrlUseDataLoader$1) == false) goto L7;
        TTVideoEngineStaticServiceImpl$downloadUrlUseDataLoader$1 r101 = (TTVideoEngineStaticServiceImpl$downloadUrlUseDataLoader$1) r210;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        Downloader r106 = (Downloader) r101.L$2;
        String r107 = (String) r101.L$1;
        String r108 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L87:
        return r103;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Downloader r109 = (Downloader) r101.L$2;
        String r112 = (String) r101.L$1;
        String r113 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Downloader r114 = r109;
        r100 = r112;
    L49:
        if (((Boolean) r103).booleanValue() == true) goto L52;
        FLogger.f375446a.e("TTVideoEngineStaticServiceImpl", "[downloadUrlUseDataLoader] load all tasks failed, key=" + r100);
        return null;
    L52:
        r101.L$0 = r113;
        r101.L$1 = r100;
        r101.L$2 = r114;
        r101.label = 2;
        kotlinx.coroutines.j r115 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r115.C();
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L55
        Object r117 = Result.m9449constructorimpl(r114.urlTask(new String[]{r113}, r100, null));     // Catch: Throwable -> L55
    L57:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L61;
        FLogger.f375446a.e("TTVideoEngineStaticServiceImpl", "[downloadUrlUseDataLoader] create task failed, key=" + r100 + ", " + r118);
    L61:
        if (Result.m9455isFailureimpl(r117) == false) goto L63;
        r117 = null;
    L63:
        DownloadURLTask r119 = (DownloadURLTask) r117;
        if (r119 != null) goto L66;
        FLogger.f375446a.e("TTVideoEngineStaticServiceImpl", "[downloadUrlUseDataLoader] create task returned null, key=" + r100);
        r115.resumeWith(Result.m9449constructorimpl(null));
    L82:
        r103 = r115.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L85;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L85:
        if (r103 != r104) goto L87;
        return r104;
    L66:
        kotlinx.coroutines.i<String> r120 = f375777a.put(r100, r115);
        if (r120 != null) goto L69;
    L71:
        r115.i(new c(r100, this, r119));
        FLogger.f375446a.i("TTVideoEngineStaticServiceImpl", "[downloadUrlUseDataLoader] start, key=" + r100 + ", url=" + r113);     // Catch: Throwable -> L74
        r119.resume();     // Catch: Throwable -> L74
        Object r121 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L74
    L76:
        Throwable r122 = Result.m9452exceptionOrNullimpl(r121);
        if (r122 == null) goto L82;
        f375777a.remove(r100);
        if (r115.isActive() == false) goto L81;
        r115.resumeWith(Result.m9449constructorimpl(null));
    L81:
        FLogger.f375446a.e("TTVideoEngineStaticServiceImpl", "[downloadUrlUseDataLoader] resume task failed, key=" + r100 + ", " + r122);
    L74:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L76
    L69:
        if (r120.isActive() == false) goto L71;
        r120.resumeWith(Result.m9449constructorimpl(null));
    L55:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L57
    L16:
        ResultKt.throwOnFailure(r103);
        if (r110.length() != 0) goto L19;
        boolean r125 = true;
    L20:
        if (r125 == false) goto L22;
    L88:
        boolean r126 = true;
        FLogger r127 = FLogger.f375446a;
        StringBuilder r128 = new StringBuilder("[downloadUrlUseDataLoader] invalid params, urlEmpty=");
        if (r110.length() != 0) goto L91;
        boolean r129 = true;
    L92:
        r128.append(r129);
        r128.append(", cacheKeyEmpty=");
        if (r111.length() == 0) goto L96;
        r126 = false;
    L96:
        r128.append(r126);
        r127.e("TTVideoEngineStaticServiceImpl", r128.toString());
        return null;
    L91:
        r129 = false;
        goto L92
    L22:
        if (r111.length() != 0) goto L24;
        boolean r130 = true;
    L25:
        if (r130 == true) goto L88;
        r114 = Downloader.getInstance();
        r114.setListener(f375779c);
        Intrinsics.checkNotNull(r114);
        r113 = r110;
        r101.L$0 = r113;
        r101.L$1 = r100;
        r101.L$2 = r114;
        r101.label = 1;
        kotlinx.coroutines.j r131 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r131.C();
        kotlinx.coroutines.i<Boolean> r132 = f375778b.put(r100, r131);
        if (r132 != null) goto L30;
    L32:
        r131.i(new p(r100));
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L35
        r114.loadAllTasks(AppHost.f326268a.getApplication());     // Catch: Throwable -> L35
        Object r134 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L37:
        Throwable r135 = Result.m9452exceptionOrNullimpl(r134);
        if (r135 == null) goto L43;
        f375778b.remove(r100);
        if (r131.isActive() == false) goto L42;
        r131.resumeWith(Result.m9449constructorimpl(Boxing.boxBoolean(false)));
    L42:
        FLogger.f375446a.e("TTVideoEngineStaticServiceImpl", "[downloadUrlUseDataLoader] load all tasks exception, key=" + r100 + ", " + r135);
    L43:
        r103 = r131.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L46;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L46:
        if (r103 != r104) goto L49;
        return r104;
    L35:
        th = move-exception;
        Result.Companion r136 = Result.Companion;
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L37
    L30:
        if (r132.isActive() == false) goto L32;
        Result.Companion r137 = Result.Companion;
        r132.resumeWith(Result.m9449constructorimpl(Boxing.boxBoolean(false)));
        goto L32
    L24:
        r130 = false;
        goto L25
    L19:
        r125 = false;
    L7:
        r101 = new TTVideoEngineStaticServiceImpl$downloadUrlUseDataLoader$1(this, r210);
        goto L8
    }

    @Override // com.larus.platform.api.z3
    public final o m(String r100, boolean r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        List<o> r103 = o.f375810l;
        Intrinsics.checkNotNullParameter(r100, "tag");
        o r104 = new o(r102);
        Intrinsics.checkNotNullParameter(r100, "tag");
        r104.f375814d.setTag(r100);
        r104.y(r101, "getNewInstance");
        return r104;
    }

    @Override // com.larus.platform.api.z3
    public final void l(com.larus.video.impl.sdk.a r100, String r101, long r102, DataLoaderPreloadPriority r103, k0 r104) {
        Intrinsics.checkNotNullParameter(r103, "priority");
        List<o> r105 = o.f375810l;
        o.a.a(r100, r101, r102, r103, r104);
    }
}
