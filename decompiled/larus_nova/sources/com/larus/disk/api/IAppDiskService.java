package com.larus.disk.api;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000  2\u00020\u0001:\u0001 J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H&J\u0016\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0010\u001a\u00020\u0011H¦@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\nH&J\b\u0010\u001f\u001a\u00020\nH&¨\u0006!"}, d2 = {"Lcom/larus/disk/api/IAppDiskService;", "", "init", "", "startFileUsageMonitor", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "startCheckDisk", "cleanCache", "isManual", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCacheSize", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getManualCacheSize", "cleanManualCache", "Lcom/larus/disk/api/ManualCacheCleanResult;", "operationId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerCacheHandler", "cacheHandler", "Lcom/larus/disk/api/CacheHandler;", "registerManagedCacheDirectory", "directory", "Lcom/larus/disk/api/ManagedCacheDirectory;", "registerMessageCacheEvictionProvider", ShortVideoSegments.KEY_PROP_PROVIDER, "Lcom/larus/disk/api/MessageCacheEvictionProvider;", "isDiskSpaceSufficient", "enableManualDiskClean", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAppDiskService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f330510a = null;

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\rH\u0016J\b\u0010\"\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/disk/api/IAppDiskService$Companion;", "Lcom/larus/disk/api/IAppDiskService;", "<init>", "()V", "impl", "init", "", "startFileUsageMonitor", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "startCheckDisk", "cleanCache", "isManual", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCacheSize", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getManualCacheSize", "cleanManualCache", "Lcom/larus/disk/api/ManualCacheCleanResult;", "operationId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerCacheHandler", "cacheHandler", "Lcom/larus/disk/api/CacheHandler;", "registerManagedCacheDirectory", "directory", "Lcom/larus/disk/api/ManagedCacheDirectory;", "registerMessageCacheEvictionProvider", ShortVideoSegments.KEY_PROP_PROVIDER, "Lcom/larus/disk/api/MessageCacheEvictionProvider;", "isDiskSpaceSufficient", "enableManualDiskClean", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IAppDiskService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f330511b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final IAppDiskService f330512c = null;

        private Companion() {
        }

        static {
            f330511b = new Companion();
            f330512c = (IAppDiskService) ServiceManager.get().getService(IAppDiskService.class);
        }

        @Override // com.larus.disk.api.IAppDiskService
        public final void d() {
            IAppDiskService r100 = f330512c;
            if (r100 == null) goto L6;
            r100.d();
            return;
        }

        @Override // com.larus.disk.api.IAppDiskService
        public final boolean f() {
            IAppDiskService r100 = f330512c;
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.f();
        }

        @Override // com.larus.disk.api.IAppDiskService
        public final boolean h() {
            IAppDiskService r100 = f330512c;
            if (r100 != null) goto L7;
            return true;
        L7:
            return r100.h();
        }

        @Override // com.larus.disk.api.IAppDiskService
        public final void init() {
            IAppDiskService r100 = f330512c;
            if (r100 == null) goto L6;
            r100.init();
            return;
        }

        @Override // com.larus.disk.api.IAppDiskService
        public final Object a(Continuation<? super Long> r100) {
            if ((r100 instanceof IAppDiskService$Companion$getCacheSize$1) == false) goto L7;
            IAppDiskService$Companion$getCacheSize$1 r101 = (IAppDiskService$Companion$getCacheSize$1) r100;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            Object r103 = r101.result;
            Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r105 = r101.label;
            if (r105 == 0) goto L14;
            if (r105 != 1) goto L13;
            ResultKt.throwOnFailure(r103);
        L19:
            long r106 = ((Number) r103).longValue();
        L22:
            return Boxing.boxLong(r106);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r103);
            IAppDiskService r107 = f330512c;
            if (r107 == null) goto L20;
            r101.label = 1;
            r103 = r107.a(r101);
            if (r103 != r104) goto L19;
            return r104;
        L20:
            r106 = 0;
        L7:
            r101 = new IAppDiskService$Companion$getCacheSize$1(this, r100);
            goto L8
        }

        @Override // com.larus.disk.api.IAppDiskService
        public final Object c(Continuation<? super Long> r100) {
            if ((r100 instanceof IAppDiskService$Companion$getManualCacheSize$1) == false) goto L7;
            IAppDiskService$Companion$getManualCacheSize$1 r101 = (IAppDiskService$Companion$getManualCacheSize$1) r100;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            Object r103 = r101.result;
            Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r105 = r101.label;
            if (r105 == 0) goto L14;
            if (r105 != 1) goto L13;
            ResultKt.throwOnFailure(r103);
        L19:
            long r106 = ((Number) r103).longValue();
        L22:
            return Boxing.boxLong(r106);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r103);
            IAppDiskService r107 = f330512c;
            if (r107 == null) goto L20;
            r101.label = 1;
            r103 = r107.c(r101);
            if (r103 != r104) goto L19;
            return r104;
        L20:
            r106 = 0;
        L7:
            r101 = new IAppDiskService$Companion$getManualCacheSize$1(this, r100);
            goto L8
        }

        @Override // com.larus.disk.api.IAppDiskService
        public final void e(c r100) {
            Intrinsics.checkNotNullParameter(r100, "cacheHandler");
            IAppDiskService r101 = f330512c;
            if (r101 == null) goto L6;
            r101.e(r100);
            return;
        }

        @Override // com.larus.disk.api.IAppDiskService
        public final void g(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            IAppDiskService r101 = f330512c;
            if (r101 == null) goto L6;
            r101.g(r100);
            return;
        }

        @Override // com.larus.disk.api.IAppDiskService
        public final Object b(String r110, Continuation<? super j> r111) {
            if ((r111 instanceof IAppDiskService$Companion$cleanManualCache$2) == false) goto L7;
            IAppDiskService$Companion$cleanManualCache$2 r100 = (IAppDiskService$Companion$cleanManualCache$2) r111;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r112 = r100.result;
            Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r103 = r100.label;
            if (r103 == 0) goto L14;
            if (r103 != 1) goto L13;
            r110 = (String) r100.L$0;
            ResultKt.throwOnFailure(r112);
        L19:
            j r113 = (j) r112;
            if (r113 != null) goto L23;
        L21:
            ManualCacheCleanStatus r104 = ManualCacheCleanStatus.FAILED;
            ManualCacheCleanError r105 = ManualCacheCleanError.SERVICE_UNAVAILABLE;
            return new j(r104, -1, -1, r110, r105, r105.getStage());
        L23:
            return r113;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r112);
            IAppDiskService r114 = f330512c;
            if (r114 == null) goto L21;
            r100.L$0 = r110;
            r100.label = 1;
            r112 = r114.b(r110, r100);
            if (r112 != r102) goto L19;
            return r102;
        L7:
            r100 = new IAppDiskService$Companion$cleanManualCache$2(this, r111);
            goto L8
        }
    }

    static {
        f330510a = Companion.f330511b;
    }

    Object a(Continuation<? super Long> r100);

    Object b(String r100, Continuation<? super j> r101);

    Object c(Continuation<? super Long> r100);

    void d();

    void e(c r100);

    boolean f();

    void g(Context r100);

    boolean h();

    void init();
}
