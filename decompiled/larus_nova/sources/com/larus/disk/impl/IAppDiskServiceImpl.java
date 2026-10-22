package com.larus.disk.impl;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.disk.api.CacheHandlerBiz;
import com.larus.disk.api.CacheHandlerBusiness;
import com.larus.disk.api.IAppDiskDebugService;
import com.larus.disk.api.IAppDiskService;
import com.larus.disk.api.ManualCacheCleanError;
import com.larus.disk.api.ManualCacheCleanStatus;
import com.larus.disk.impl.handler.FrescoCacheHandler;
import com.larus.disk.impl.handler.FrescoCustomCacheHandler;
import com.larus.disk.impl.handler.ImageUrlStorageCacheHandler;
import com.larus.disk.impl.handler.v0;
import com.larus.disk.impl.handler.w0;
import com.larus.settings.value.e10;
import com.larus.update.IBitsUpdate;
import com.larus.update.IInhouseUpdate;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0002J\u000e\u0010\u000f\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\b\u0010\u0014\u001a\u00020\nH\u0016J\u0016\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u0010J\u000e\u0010\u001a\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u0010J\u000e\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u0010J\u000e\u0010\u001d\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0096@¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0013H\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\bH\u0016J\b\u0010+\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/larus/disk/impl/IAppDiskServiceImpl;", "Lcom/larus/disk/api/IAppDiskService;", "Lcom/larus/disk/api/IAppDiskDebugService;", "<init>", "()V", "initializationLock", "", "initialized", "", "init", "", "startFileUsageMonitor", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "ensureInitialized", "ensureInitializedOnIo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDefaultCacheHandlers", "", "Lcom/larus/disk/api/CacheHandler;", "startCheckDisk", "cleanCache", "isManual", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCacheSize", "", "getManualCacheSize", "getCacheBreakdown", "Lcom/larus/disk/api/DiskCacheBreakdownSnapshot;", "cleanManualCache", "Lcom/larus/disk/api/ManualCacheCleanResult;", "operationId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerCacheHandler", "cacheHandler", "registerManagedCacheDirectory", "directory", "Lcom/larus/disk/api/ManagedCacheDirectory;", "registerMessageCacheEvictionProvider", ShortVideoSegments.KEY_PROP_PROVIDER, "Lcom/larus/disk/api/MessageCacheEvictionProvider;", "isDiskSpaceSufficient", "enableManualDiskClean", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IAppDiskServiceImpl implements IAppDiskService, IAppDiskDebugService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f330597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f330598c;

    /* JADX INFO: loaded from: classes27.dex */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f330599a = null;

        static {
            int[] r100 = new int[AppDiskManager.CleanExecutionStatus.values().length];
            r100[AppDiskManager.CleanExecutionStatus.COMPLETED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[AppDiskManager.CleanExecutionStatus.DISABLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[AppDiskManager.CleanExecutionStatus.TASK_RUNNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[AppDiskManager.CleanExecutionStatus.ACCOUNT_CHANGED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[AppDiskManager.CleanExecutionStatus.APP_FOREGROUND.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[AppDiskManager.CleanExecutionStatus.PARTIAL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[AppDiskManager.CleanExecutionStatus.FAILED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f330599a = r100;
        }
    }

    @Override // com.larus.disk.api.IAppDiskService
    public final boolean f() {
        Lazy r100 = d.f330625a;
        if (d.a().h() == true) goto L5;
    L9:
        return false;
    L5:
        if (d.a().p() == false) goto L7;
    L8:
        return true;
    L7:
        if (AppHost.f326268a.isDebug() == false) goto L9;
        goto L8
    }

    public final void j() {
        if (this.f330598c == false) goto L5;
        return;
    L5:
        Object r100 = this.f330597b;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (this.f330598c == false) goto L11;
        monitor-exit(r100);
        return;
    L11:
        AppDiskManager.d0(i());     // Catch: Throwable -> L14
        this.f330598c = true;     // Catch: Throwable -> L14
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r100);
    }

    public IAppDiskServiceImpl() {
        this.f330597b = new Object();
    }

    public static List i() {
        List r100 = CollectionsKt.createListBuilder();
        r100.add(new com.larus.disk.impl.handler.d0());
        r100.add(new com.larus.disk.impl.handler.e());
        r100.add(new com.larus.disk.impl.handler.f());
        r100.add(new com.larus.disk.impl.handler.h());
        r100.add(new com.larus.disk.impl.handler.r());
        r100.add(new com.larus.disk.impl.handler.s());
        r100.add(new com.larus.disk.impl.handler.w());
        r100.add(new FrescoCacheHandler());
        r100.add(new FrescoCustomCacheHandler(CacheHandlerBiz.BIZ_MEDIA_FRESCO_CACHE, CacheHandlerBiz.BIZ_MEDIA_FRESCO_CACHE, true, 4));
        r100.add(new com.larus.disk.impl.handler.o());
        r100.add(new FrescoCustomCacheHandler(CacheHandlerBiz.BIZ_ACCOUNT_AVATAR_FRESCO_CACHE, CacheHandlerBiz.BIZ_ACCOUNT_AVATAR_FRESCO_CACHE, false, 8));
        e10 r101 = e10.f368561a;
        if (e10.n() == false) goto L5;
        r100.add(new FrescoCustomCacheHandler("covn_list.avatar", CacheHandlerBiz.BIZ_CONVERSATION_AVATAR_FRESCO_CACHE, false, 12));
        r100.add(new FrescoCustomCacheHandler("custom_actionbar_icon", CacheHandlerBiz.BIZ_ACTION_BAR_ICON_FRESCO_CACHE, false, 12));
    L5:
        r100.add(new ImageUrlStorageCacheHandler());
        r100.add(new com.larus.disk.impl.handler.g0());
        r100.add(new com.larus.disk.impl.handler.p("custom-img-cache", CacheHandlerBiz.BIZ_CUSTOM_IMAGE_CACHE, "fresco_cache"));
        r100.add(new com.larus.disk.impl.handler.p("plugin-data-ivy", CacheHandlerBiz.BIZ_PLUGIN_IVY_CACHE, "disk_lru_cache"));
        r100.add(new com.larus.disk.impl.handler.p("plugin-data-map", CacheHandlerBiz.BIZ_PLUGIN_MAP_CACHE, "disk_lru_cache"));
        r100.add(new com.larus.disk.impl.handler.p(CacheHandlerBiz.BIZ_VOICE_PITCH_RATE, CacheHandlerBiz.BIZ_VOICE_PITCH_RATE, CacheHandlerBusiness.VOICE_CACHE));
        r100.add(new com.larus.disk.impl.handler.p("creation_attachment_cache", CacheHandlerBiz.BIZ_CREATION_ATTACHMENT, CacheHandlerBusiness.FILE_CACHE));
        r100.add(new com.larus.disk.impl.handler.p("ai_beautify", CacheHandlerBiz.BIZ_AI_BEAUTIFY_LOCAL, CacheHandlerBusiness.FILE_CACHE));
        r100.add(new com.larus.disk.impl.handler.p("creation_video_preprocess", CacheHandlerBiz.BIZ_CREATION_VIDEO_PREPROCESS, CacheHandlerBusiness.FILE_CACHE));
        r100.add(new com.larus.disk.impl.handler.p("image_upload", CacheHandlerBiz.BIZ_IMAGE_UPLOAD_LOCAL, CacheHandlerBusiness.FILE_CACHE));
        r100.add(new com.larus.disk.impl.handler.p("video_upload", CacheHandlerBiz.BIZ_VIDEO_UPLOAD_LOCAL, CacheHandlerBusiness.FILE_CACHE));
        r100.add(new com.larus.disk.impl.handler.p("ugc_original_image_edit_cache.jpeg", CacheHandlerBiz.BIZ_CREATION_ORIGINAL_IMAGE, CacheHandlerBusiness.FILE_CACHE));
        r100.add(new com.larus.disk.impl.handler.p("ugc_image_edit_cache.jpeg", CacheHandlerBiz.BIZ_CREATION_EDIT_IMAGE, CacheHandlerBusiness.FILE_CACHE));
        r100.add(new com.larus.disk.impl.handler.p("image_selector_default_image.jpeg", CacheHandlerBiz.BIZ_IMAGE_SELECTOR_LOCAL, CacheHandlerBusiness.FILE_CACHE));
        r100.add(new com.larus.disk.impl.handler.o0());
        r100.add(new v0(null));
        r100.add(new com.larus.disk.impl.handler.h0());
        r100.add(new com.larus.disk.impl.handler.n0(0));
        IBitsUpdate r102 = (IBitsUpdate) ServiceManager.get().getService(IBitsUpdate.class);
        if (r102 == null) goto L10;
        z1a.i r103 = r102.c();
        if (r103 == null) goto L10;
        r100.add(r103);
    L10:
        IInhouseUpdate r104 = (IInhouseUpdate) ServiceManager.get().getService(IInhouseUpdate.class);
        if (r104 == null) goto L15;
        com.larus.disk.api.c r105 = r104.c();
        if (r105 == null) goto L15;
        r100.add(r105);
    L15:
        r100.add(new com.larus.disk.impl.handler.a());
        r100.add(new com.larus.disk.impl.handler.t());
        r100.add(new com.larus.disk.impl.handler.b());
        r100.add(new com.larus.disk.impl.handler.c());
        r100.add(new com.larus.disk.impl.handler.f0(null));
        n0 r106 = n0.f330778a;
        r100.addAll(CollectionsKt.listOf(new com.larus.disk.impl.handler.c0[]{new com.larus.disk.impl.handler.c0("offlineX", CacheHandlerBiz.BIZ_OFFLINE_X), new com.larus.disk.impl.handler.c0("offlineObricX", CacheHandlerBiz.BIZ_OFFLINE_OBRIC_X)}));
        r100.add(new com.larus.disk.impl.handler.d());
        r100.add(new w0());
        return CollectionsKt.build(r100);
    }

    @Override // com.larus.disk.api.IAppDiskService
    public final void d() {
        j();
        AppDiskManager.f330546a.getClass();
        boolean r100 = AppDiskManager.a0();
        if (r100 == false) goto L5;
        AppDiskManager.A0(false);
    L5:
        BuildersKt.launch$default(GlobalScope.INSTANCE, new kotlinx.coroutines.a0("start_check_disk").plus(AppDiskManager.I("CheckDisk")), null, new AppDiskManager$startCheckDisk$1(r100, null), 2, null);
    }

    @Override // com.larus.disk.api.IAppDiskService
    public final boolean h() {
        return AppDiskManager.h0();
    }

    @Override // com.larus.disk.api.IAppDiskService
    public final void init() {
        j();
    }

    @Override // com.larus.disk.api.IAppDiskService
    public final Object a(Continuation<? super Long> r100) {
        if ((r100 instanceof IAppDiskServiceImpl$getCacheSize$1) == false) goto L7;
        IAppDiskServiceImpl$getCacheSize$1 r101 = (IAppDiskServiceImpl$getCacheSize$1) r100;
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
        ResultKt.throwOnFailure(r103);
    L22:
        return r103;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
    L19:
        r101.label = 2;
        AppDiskManager r106 = AppDiskManager.f330546a;
        r103 = BuildersKt.withContext(Dispatchers.getIO(), new AppDiskManager$getCacheSize$2(null), r101);
        if (r103 != r104) goto L22;
        return r104;
    L16:
        ResultKt.throwOnFailure(r103);
        r101.label = 1;
        if (k(r101) != r104) goto L19;
        return r104;
    L7:
        r101 = new IAppDiskServiceImpl$getCacheSize$1(this, r100);
        goto L8
    }

    @Override // com.larus.disk.api.IAppDiskService
    public final Object c(Continuation<? super Long> r100) {
        if ((r100 instanceof IAppDiskServiceImpl$getManualCacheSize$1) == false) goto L7;
        IAppDiskServiceImpl$getManualCacheSize$1 r101 = (IAppDiskServiceImpl$getManualCacheSize$1) r100;
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
        ResultKt.throwOnFailure(r103);
    L22:
        return r103;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
    L19:
        r101.label = 2;
        r103 = AppDiskManager.Y(r101);
        if (r103 != r104) goto L22;
        return r104;
    L16:
        ResultKt.throwOnFailure(r103);
        r101.label = 1;
        if (k(r101) != r104) goto L19;
        return r104;
    L7:
        r101 = new IAppDiskServiceImpl$getManualCacheSize$1(this, r100);
        goto L8
    }

    @Override // com.larus.disk.api.IAppDiskService
    public final void e(com.larus.disk.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "cacheHandler");
        j();
        AppDiskManager r101 = AppDiskManager.f330546a;
        Intrinsics.checkNotNullParameter(r100, "cacheHandler");
        Object r102 = AppDiskManager.f330549d;
        monitor-enter(r102);
        AppDiskManager r103 = AppDiskManager.f330546a;     // Catch: Throwable -> L48
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L7
        r103.getClass();     // Catch: Throwable -> L7
        Object r105 = Result.m9449constructorimpl(AppDiskManager.u0(r100));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r105) == false) goto L12;
        r105 = null;
    L12:
        File r106 = (File) r105;     // Catch: Throwable -> L48
        boolean r107 = false;
        if (r106 == null) goto L41;
        AppDiskManager.f330546a.getClass();     // Catch: Throwable -> L48
        CopyOnWriteArrayList r108 = AppDiskManager.Q();     // Catch: Throwable -> L48
        if ((r108 instanceof Collection) == true) goto L17;
    L19:
        Iterator r109 = r108.iterator();     // Catch: Throwable -> L48
    L21:
        if (r109.hasNext() == false) goto L38;
        com.larus.disk.api.c r110 = (com.larus.disk.api.c) r109.next();     // Catch: Throwable -> L48
        if ((r110 instanceof com.larus.disk.impl.handler.u) == false) goto L35;
        AppDiskManager r111 = AppDiskManager.f330546a;     // Catch: Throwable -> L48
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L27
        r111.getClass();     // Catch: Throwable -> L27
        Object r113 = Result.m9449constructorimpl(Boolean.valueOf(AppDiskManager.e0(r106, CollectionsKt.listOf(AppDiskManager.u0(r110)))));     // Catch: Throwable -> L27
    L29:
        Boolean r114 = Boolean.TRUE;     // Catch: Throwable -> L48
        if (Result.m9455isFailureimpl(r113) == false) goto L33;
        r113 = r114;
    L33:
        if (((Boolean) r113).booleanValue() == false) goto L35;
        boolean r115 = true;
    L36:
        if (r115 == false) goto L21;
        boolean r116 = true;
    L39:
        if (r116 == false) goto L41;
        r107 = true;
        goto L41
    L27:
        th = move-exception;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L48
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L48
    L35:
        r115 = false;
    L38:
        r116 = false;
        goto L39
    L17:
        if (r108.isEmpty() == false) goto L19;
    L41:
        if (r107 == false) goto L45;
        FLogger r118 = FLogger.f375446a;     // Catch: Throwable -> L48
        StringBuilder r119 = new StringBuilder();     // Catch: Throwable -> L48
        r119.append("reject cache handler overlapping a managed cache directory biz=");     // Catch: Throwable -> L48
        AppDiskManager.f330546a.getClass();     // Catch: Throwable -> L48
        r119.append(AppDiskManager.w0(r100));     // Catch: Throwable -> L48
        r118.e("AppDiskManager", r119.toString());     // Catch: Throwable -> L48
        AppDiskManager.C0("cache handler overlaps managed directory, biz=" + AppDiskManager.w0(r100));     // Catch: Throwable -> L48
        monitor-exit(r102);
        return;
    L45:
        AppDiskManager.f330546a.getClass();     // Catch: Throwable -> L48
        AppDiskManager.Q().addIfAbsent(r100);     // Catch: Throwable -> L48
        monitor-exit(r102);
        return;
    L7:
        th = move-exception;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L48
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.disk.api.IAppDiskService
    public final void g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Context r101 = r100.getApplicationContext();
        if (r101 == null) goto L6;
        r100 = r101;
    L6:
        i0.f330730a.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        i0.e(r100);     // Catch: Exception -> L9 LinkageError -> L11
    L17:
        return;
    L9:
        e = move-exception;
        FLogger.f375446a.e("FileAccessMonitor", "native file usage monitor initialization failed", e);
        return;
    L11:
        e = move-exception;
        FLogger.f375446a.e("FileAccessMonitor", "native file usage monitor linkage failed", e);
    }

    public final Object k(ContinuationImpl r100) {
        Object r101 = BuildersKt.withContext(Dispatchers.getIO(), new IAppDiskServiceImpl$ensureInitializedOnIo$2(this, null), r100);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x009e: MOVE (r0 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]) (LINE:33554590), block:B:35:0x009e */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1, types: [long] */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1, types: [long] */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r22v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r23v1 */
    /* JADX WARN: Type inference failed for: r25v0, types: [com.larus.disk.impl.IAppDiskServiceImpl] */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15, types: [long] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v8, types: [long] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v28, types: [long] */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.Object] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.larus.disk.api.IAppDiskService
    public final Object b(String r210, Continuation<? super com.larus.disk.api.j> r211) {
        if ((r211 instanceof IAppDiskServiceImpl$cleanManualCache$2) == false) goto L7;
        IAppDiskServiceImpl$cleanManualCache$2 r100 = (IAppDiskServiceImpl$cleanManualCache$2) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r104 = r100.label;
        ?? r105 = 1;
        if (r104 != 0) goto L133;
        ResultKt.throwOnFailure(r102);
        if (f() == true) goto L41;
        ManualCacheCleanStatus r110 = ManualCacheCleanStatus.DISABLED;
        ManualCacheCleanError r212 = ManualCacheCleanError.FEATURE_DISABLED;
        return new com.larus.disk.api.j(r110, -1, -1, r210, r212, r212.getStage());
    L41:
        String r106 = "initialization";
        String r107 = r210;
        r100.L$0 = r107;     // Catch: CancellationException -> L100 Exception -> L106
        r100.L$1 = "initialization";     // Catch: CancellationException -> L100 Exception -> L106
        r100.J$0 = -1;     // Catch: CancellationException -> L100 Exception -> L106
        r100.label = 1;     // Catch: CancellationException -> L100 Exception -> L106
        if (k(r100) != r103) goto L45;
        return r103;
    L45:
        r104 = "initialization";
        r105 = -1;
    L131:
        r100.L$0 = r107;     // Catch: Exception -> L128 CancellationException -> L100
        r100.L$1 = "before_size_query";     // Catch: Exception -> L128 CancellationException -> L100
        r100.J$0 = r105;     // Catch: Exception -> L128 CancellationException -> L100
        r100.label = 2;     // Catch: Exception -> L128 CancellationException -> L100
        Object r108 = AppDiskManager.Y(r100);     // Catch: Exception -> L128 CancellationException -> L100
        r104 = "before_size_query";
        r105 = r105;
        if (r108 != r103) goto L49;
        return r103;
    L49:
        long r111 = ((Number) r108).longValue();     // Catch: Exception -> L128 CancellationException -> L100
        AppDiskManager r109 = AppDiskManager.f330546a;     // Catch: CancellationException -> L100 Exception -> L103
        AppDiskManager.CleanScene r112 = AppDiskManager.CleanScene.MANUAL;     // Catch: CancellationException -> L100 Exception -> L103
        r100.L$0 = r107;     // Catch: CancellationException -> L100 Exception -> L103
        r100.L$1 = "execution";     // Catch: CancellationException -> L100 Exception -> L103
        r100.J$0 = r111;     // Catch: CancellationException -> L100 Exception -> L103
        r100.label = 3;     // Catch: CancellationException -> L100 Exception -> L103
        String r113 = "execution";
        Object r114 = AppDiskManager.F(r109, r112, null, r107, r100, 2);     // Catch: CancellationException -> L100 Exception -> L127
        if (r114 != r103) goto L56;
        return r103;
    L56:
        String r115 = r113;
        r111 = r111;
    L142:
        AppDiskManager.b r116 = (AppDiskManager.b) r114;     // Catch: CancellationException -> L100 Exception -> L126
        r115 = "after_size_query";
        r100.L$0 = r107;     // Catch: CancellationException -> L100 Exception -> L126
        r100.L$1 = "after_size_query";     // Catch: CancellationException -> L100 Exception -> L126
        r100.L$2 = r116;     // Catch: CancellationException -> L100 Exception -> L126
        r100.J$0 = r111;     // Catch: CancellationException -> L100 Exception -> L126
        r100.label = 4;     // Catch: CancellationException -> L100 Exception -> L126
        Object r117 = AppDiskManager.Y(r100);     // Catch: CancellationException -> L100 Exception -> L126
        if (r117 != r103) goto L60;
        return r103;
    L60:
        r102 = r117;
        long r118 = r111;
    L61:
        long r119 = ((Number) r102).longValue();     // Catch: Exception -> L24 CancellationException -> L100
        switch(a.f330599a[r116.f330574a.ordinal()]) {
            case 1: goto L74;
            case 2: goto L72;
            case 3: goto L71;
            case 4: goto L70;
            case 5: goto L69;
            case 6: goto L68;
            case 7: goto L65;
            default: goto L99;
        };     // Catch: Exception -> L24 CancellationException -> L100
    L68:
        ManualCacheCleanStatus r120 = ManualCacheCleanStatus.PARTIAL;     // Catch: Exception -> L24 CancellationException -> L100
    L78:
        if (r120 != ManualCacheCleanStatus.SUCCESS) goto L80;
        ManualCacheCleanError r121 = ManualCacheCleanError.NONE;     // Catch: Exception -> L24 CancellationException -> L100
    L93:
        String r122 = r116.f330575b;     // Catch: Exception -> L24 CancellationException -> L100
        if (r121 != r116.f330576c) goto L96;
        String r123 = r116.f330577d;     // Catch: Exception -> L24 CancellationException -> L100
    L97:
        com.larus.disk.api.j r124 = new com.larus.disk.api.j(r120, r118, r119, r122, r121, r123);     // Catch: Exception -> L24 CancellationException -> L100
    L123:
        return r124;
    L96:
        r123 = w.c(r121, SetsKt.emptySet());     // Catch: Exception -> L24 CancellationException -> L100
        goto L97
    L80:
        r121 = r116.f330576c;     // Catch: Exception -> L24 CancellationException -> L100
        if (r121 != ManualCacheCleanError.NONE) goto L93;
        if (r119 <= 0) goto L87;
        r121 = ManualCacheCleanError.REMAINING_CACHE;     // Catch: Exception -> L24 CancellationException -> L100
        goto L93
    L87:
        if (r120 != ManualCacheCleanStatus.TASK_RUNNING) goto L90;
        r121 = ManualCacheCleanError.TASK_RUNNING;     // Catch: Exception -> L24 CancellationException -> L100
        goto L93
    L90:
        if (r120 != ManualCacheCleanStatus.DISABLED) goto L92;
        r121 = ManualCacheCleanError.FEATURE_DISABLED;     // Catch: Exception -> L24 CancellationException -> L100
        goto L93
    L92:
        r121 = ManualCacheCleanError.EXECUTION_FAILED;     // Catch: Exception -> L24 CancellationException -> L100
        goto L93
    L69:
        r120 = ManualCacheCleanStatus.FAILED;     // Catch: Exception -> L24 CancellationException -> L100
        goto L78
    L70:
        r120 = ManualCacheCleanStatus.FAILED;     // Catch: Exception -> L24 CancellationException -> L100
        goto L78
    L71:
        r120 = ManualCacheCleanStatus.TASK_RUNNING;     // Catch: Exception -> L24 CancellationException -> L100
        goto L78
    L72:
        r120 = ManualCacheCleanStatus.DISABLED;     // Catch: Exception -> L24 CancellationException -> L100
        goto L78
    L99:
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L24 CancellationException -> L100
    L65:
        if (r119 >= r118) goto L67;
        r120 = ManualCacheCleanStatus.PARTIAL;     // Catch: Exception -> L24 CancellationException -> L100
        goto L78
    L67:
        r120 = ManualCacheCleanStatus.FAILED;     // Catch: Exception -> L24 CancellationException -> L100
        goto L78
    L74:
        if (r119 != 0) goto L76;
        r120 = ManualCacheCleanStatus.SUCCESS;     // Catch: Exception -> L24 CancellationException -> L100
        goto L78
    L76:
        r120 = ManualCacheCleanStatus.PARTIAL;     // Catch: Exception -> L24 CancellationException -> L100
    L102:
        ?? r125 = r111;
        ?? r126 = r115;
    L140:
        r100.L$0 = r107;     // Catch: Exception -> L114 CancellationException -> L115
        r100.L$1 = r126;     // Catch: Exception -> L114 CancellationException -> L115
        r100.L$2 = null;     // Catch: Exception -> L114 CancellationException -> L115
        r100.J$0 = r125;     // Catch: Exception -> L114 CancellationException -> L115
        r100.label = 5;     // Catch: Exception -> L114 CancellationException -> L115
        Object r127 = AppDiskManager.Y(r100);     // Catch: Exception -> L114 CancellationException -> L115
        if (r127 != r103) goto L110;
        return r103;
    L110:
        ?? r128 = r126;
        String r129 = r107;
        r102 = r127;
        ?? r130 = r125;
    L111:
        String r213 = r129;
        ?? r131 = r130;
        ?? r132 = ((Number) r102).longValue();     // Catch: Exception -> L18 CancellationException -> L115
        ?? r133 = r128;
    L118:
        ManualCacheCleanStatus r134 = ManualCacheCleanStatus.FAILED;
        if (StringsKt.endsWith$default(r133, "size_query", false, 2, null) == false) goto L121;
        ManualCacheCleanError r135 = ManualCacheCleanError.SIZE_QUERY_FAILED;
    L122:
        r124 = new com.larus.disk.api.j(r134, r131, r132, r213, r135, r133);
        goto L123
    L121:
        r135 = ManualCacheCleanError.EXECUTION_FAILED;
        goto L122
    L113:
        r107 = r129;
        ?? r136 = r128;
        ?? r137 = r130;
    L117:
        r213 = r107;
        ?? r138 = r137;
        r132 = r138;
        r133 = r136;
        r131 = r138;
    L114:
        r137 = r125;
        r136 = r126;
    L104:
        r115 = r113;
    L103:
        r113 = "execution";
    L36:
        r126 = r104;
        r125 = r105;
    L106:
        r125 = -1;
        r126 = r106;
        goto L140
    L133:
        if (r104 == 1) goto L32;
        if (r104 == 2) goto L29;
        if (r104 == 3) goto L25;
        if (r104 == 4) goto L21;
        if (r104 != 5) goto L20;
        r130 = r100.J$0;
        r128 = (String) r100.L$1;
        r129 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L18 CancellationException -> L115
        r130 = r130;
        r128 = r128;
        goto L111
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        long r139 = r100.J$0;
        r116 = (AppDiskManager.b) r100.L$2;
        String r140 = (String) r100.L$1;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L24 CancellationException -> L100
        r118 = r139;
    L24:
        r107 = (String) r100.L$0;
        r125 = r139;
        r126 = r140;
        goto L140
    L25:
        long r141 = r100.J$0;
        String r142 = (String) r100.L$1;
        String r143 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L28 CancellationException -> L100
        r111 = r141;
        r114 = r102;
        r107 = r143;
        r115 = r142;
    L28:
        r107 = r143;
        r125 = r141;
        r126 = r142;
        goto L140
    L29:
        long r144 = r100.J$0;
        String r145 = (String) r100.L$1;
        String r146 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L35 CancellationException -> L100
        r108 = r102;
        r107 = r146;
        r104 = r145;
        r105 = r144;
        goto L49
    L32:
        long r147 = r100.J$0;
        String r148 = (String) r100.L$1;
        String r149 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L35 CancellationException -> L100
        r107 = r149;
        r104 = r148;
        r105 = r147;
    L35:
        r107 = r7;
    L115:
        e = move-exception;
        throw e;
    L100:
        e = move-exception;
        throw e;
    L7:
        r100 = new IAppDiskServiceImpl$cleanManualCache$2(this, r211);
        goto L8
    }
}
