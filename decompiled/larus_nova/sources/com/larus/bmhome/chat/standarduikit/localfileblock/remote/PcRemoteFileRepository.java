package com.larus.bmhome.chat.standarduikit.localfileblock.remote;

import android.os.SystemClock;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.k1;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes26.dex */
public final class PcRemoteFileRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PcRemoteFileRepository f309440a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f309441b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutexImpl f309442c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLong f309443d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<b, Deferred<File>> f309444e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<b, a> f309445f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final MutableLiveData<Unit> f309446g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final MutableLiveData f309447h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f309448i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile Deferred<Unit> f309449j;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f309450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f309451b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f309450a, r101.f309450a) == true) goto L12;
            return false;
        L12:
            if (this.f309451b == r101.f309451b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f309450a.hashCode() * 31;
            long r101 = this.f309451b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "CacheEntry(file=" + this.f309450a + ", createdAt=" + this.f309451b + ')';
        }

        public a(File r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "file");
            this.f309450a = r100;
            this.f309451b = r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f309452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f309453b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f309454c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f309455d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f309456e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f309452a, r101.f309452a) == true) goto L12;
            return false;
        L12:
            if (this.f309453b == r101.f309453b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f309454c, r101.f309454c) == true) goto L18;
            return false;
        L18:
            if (this.f309455d == r101.f309455d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f309456e, r101.f309456e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f309452a.hashCode() * 31;
            long r101 = this.f309453b;
            return ((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f309454c.hashCode()) * 31) + this.f309455d) * 31) + this.f309456e.hashCode();
        }

        public final String toString() {
            return "FileKey(accountId=" + this.f309452a + ", generation=" + this.f309453b + ", sourceDeviceId=" + this.f309454c + ", sourceAppId=" + this.f309455d + ", filePath=" + this.f309456e + ')';
        }

        public b(String r100, long r101, String r102, int r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, "accountId");
            Intrinsics.checkNotNullParameter(r102, "sourceDeviceId");
            Intrinsics.checkNotNullParameter(r104, "filePath");
            this.f309452a = r100;
            this.f309453b = r101;
            this.f309454c = r102;
            this.f309455d = r103;
            this.f309456e = r104;
        }
    }

    public static final class c implements com.larus.platform.api.b {
        public c() {
        }

        @Override // com.larus.platform.api.b
        public final void a(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            PcRemoteFileRepository.a();
        }

        @Override // com.larus.platform.api.b
        public final void b(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            PcRemoteFileRepository.a();
        }
    }

    public PcRemoteFileRepository() {
    }

    public final synchronized void i() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (f309449j == null) goto L7;
        monitor-exit(this);
        return;
    L7:
        f309449j = BuildersKt.async$default(f309441b, null, null, new PcRemoteFileRepository$initialize$1(null), 3, null);     // Catch: Throwable -> L10
        AppHost.f326268a.a().j(new PcRemoteFileRepository$initialize$2());     // Catch: Throwable -> L10
        AccountService.f365697a.E(new c());     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    static {
        f309440a = new PcRemoteFileRepository();
        f309441b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f309442c = kotlinx.coroutines.sync.b.a();
        f309443d = new AtomicLong(0);
        f309444e = new ConcurrentHashMap();
        f309445f = new LinkedHashMap();
        MutableLiveData<Unit> r100 = new MutableLiveData(Unit.INSTANCE);
        f309446g = r100;
        f309447h = r100;
        f309448i = LazyKt.lazy(new e());
    }

    public static final void a() {
        long r100 = f309443d.incrementAndGet();
        f309446g.postValue(Unit.INSTANCE);
        Iterator<Map.Entry<b, Deferred<File>>> r101 = f309444e.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Map.Entry<b, Deferred<File>> r102 = r101.next();
        b r103 = r102.getKey();
        Deferred<File> r104 = r102.getValue();
        if (r103.f309453b >= r100) goto L4;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
        goto L4
    L8:
        BuildersKt.launch$default(f309441b, null, null, new PcRemoteFileRepository$invalidateAccount$2(r100, null), 3, null);
    }

    public static final void c() {
        long r100 = SystemClock.elapsedRealtime();
        Map<b, a> r101 = f309445f;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator r103 = ((LinkedHashMap) r101).entrySet().iterator();
    L3:
        boolean r104 = true;
        if (r103.hasNext() == false) goto L11;
        Map.Entry r105 = (Map.Entry) r103.next();
        if ((r100 - ((a) r105.getValue()).f309451b) >= 3600000) goto L9;
        r104 = false;
    L9:
        if (r104 == false) goto L3;
        r102.put(r105.getKey(), r105.getValue());
        goto L3
    L11:
        List r106 = CollectionsKt.toList(r102.keySet());
        Iterator r107 = r106.iterator();
    L13:
        if (r107.hasNext() == false) goto L22;
        a r108 = f309445f.remove((b) r107.next());
        if (r108 == null) goto L13;
        File r109 = r108.f309450a;
        if (r109 == null) goto L13;
        File r110 = r109.getParentFile();
        if (r110 == null) goto L13;
        k(r110, AiBotPollingAuthResult.STATUS_EXPIRED);
        goto L13
    L22:
        if ((!r106.isEmpty()) == false) goto L39;
        f309446g.postValue(Unit.INSTANCE);
        return;
    }

    public static Object d(Continuation r100) {
        Deferred<Unit> r101 = f309449j;
        if (r101 == null) goto L10;
        Object r102 = r101.await(r100);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r102;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    public static File e(b r100) {
        l(r100);
        Map<b, a> r101 = f309445f;
        a r102 = (a) ((LinkedHashMap) r101).get(r100);
        if (r102 != null) goto L6;
        return null;
    L6:
        if ((SystemClock.elapsedRealtime() - r102.f309451b) < 3600000) goto L8;
    L14:
        r101.remove(r100);
        f309446g.postValue(Unit.INSTANCE);
        File r103 = r102.f309450a.getParentFile();
        if (r103 == null) goto L17;
        k(r103, "cache_invalid");
    L17:
        return null;
    L8:
        if (r102.f309450a.isFile() == false) goto L14;
        if (r102.f309450a.canRead() == false) goto L14;
        return r102.f309450a;
    }

    public static b g(g r100) {
        long r101 = f309443d.get();
        AccountService r102 = AccountService.f365697a;
        String r103 = r102.getUserId();
        if (r102.isLogin().booleanValue() == false) goto L9;
        if (StringsKt.isBlank(r103) == true) goto L9;
        return new b(r103, r101, r100.f309467a, r100.f309468b, r100.f309469c);
    L9:
        throw new PcRemoteFileException(PcRemoteFileError.ACCOUNT_CHANGED, null, 2, null);
    }

    public static void l(b r100) {
        if (r100.f309453b != f309443d.get()) goto L10;
        AccountService r101 = AccountService.f365697a;
        if (r101.isLogin().booleanValue() == false) goto L10;
        if (Intrinsics.areEqual(r100.f309452a, r101.getUserId()) == false) goto L10;
        return;
    L10:
        throw new PcRemoteFileException(PcRemoteFileError.ACCOUNT_CHANGED, null, 2, null);
    }

    public static Object f(g r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PcRemoteFileRepository$cachedFile$2(r100, null), r101);
    }

    public static void k(File r100, String r101) {
    L9:
        e = move-exception;
        FLogger.f375446a.e("PcRemoteFilePreview", "stage=cache_remove_failed reason=" + r101 + " exception=" + e.getClass().getSimpleName());
        return;
    L4:
        if (r100.exists() == true) goto L6;
        return;
    L6:
        if (FilesKt.deleteRecursively(r100) == true) goto L15;
        FLogger.f375446a.e("PcRemoteFilePreview", "stage=cache_remove_failed reason=".concat(r101));     // Catch: Exception -> L9
        return;
    }

    public final Object j(g r110, Continuation<? super File> r111) {
        if ((r111 instanceof PcRemoteFileRepository$prepareFile$1) == false) goto L7;
        PcRemoteFileRepository$prepareFile$1 r100 = (PcRemoteFileRepository$prepareFile$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        b r113 = (b) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L22:
        File r114 = (File) r112;
        l(r113);
        return r114;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        r110.b();
        i();
        final b r115 = g(r110);
        final Deferred<File> r116 = BuildersKt.async$default(f309441b, null, CoroutineStart.LAZY, new PcRemoteFileRepository$prepareFile$candidate$1(r115, r110, null), 1, null);
        Deferred<File> r104 = f309444e.putIfAbsent(r115, r116);
        if (r104 == null) goto L17;
        Job.DefaultImpls.cancel$default(r116, null, 1, null);
        r116 = r104;
    L18:
        r100.L$0 = r115;
        r100.label = 1;
        Object r117 = r116.await(r100);
        if (r117 != r102) goto L21;
        return r102;
    L21:
        r112 = r117;
        r113 = r115;
        goto L22
    L17:
        r116.invokeOnCompletion(new f(r115, r116));
        r116.start();
    L7:
        r100 = new PcRemoteFileRepository$prepareFile$1(this, r111);
        goto L8
    }

    public final Object h(String r100, File r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof PcRemoteFileRepository$download$1) == false) goto L7;
        PcRemoteFileRepository$download$1 r103 = (PcRemoteFileRepository$download$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L15;
        if (r107 != 1) goto L14;
        ResultKt.throwOnFailure(r105);     // Catch: TimeoutCancellationException -> L21
    L19:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r105);
        PcRemoteFileRepository$download$2 r108 = new PcRemoteFileRepository$download$2(r101, r100, null);     // Catch: TimeoutCancellationException -> L21
        r103.label = 1;     // Catch: TimeoutCancellationException -> L21
        if (TimeoutKt.b(900000, r108, r103) != r106) goto L19;
        return r106;
    L22:
        throw new PcRemoteFileException(PcRemoteFileError.DOWNLOAD_FAILED, null, 2, null);
    L7:
        r103 = new PcRemoteFileRepository$download$1(this, r102);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x040f: MOVE (r11 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]) (LINE:67109903), block:B:184:0x040e */
    /* JADX WARN: Type inference failed for: r26v0, types: [com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFileRepository, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v40, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v44, types: [kotlin.jvm.internal.Ref$BooleanRef] */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r4v51 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [kotlin.jvm.internal.Ref$BooleanRef] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v36, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v39, types: [kotlin.jvm.internal.Ref$BooleanRef] */
    /* JADX WARN: Type inference failed for: r9v45 */
    /* JADX WARN: Type inference failed for: r9v47 */
    /* JADX WARN: Type inference failed for: r9v50 */
    public static final Object b(PcRemoteFileRepository r210, b r211, g r212, Continuation r213) {
        r210.getClass();
        if ((r213 instanceof PcRemoteFileRepository$prepareFile$2) == false) goto L7;
        PcRemoteFileRepository$prepareFile$2 r100 = (PcRemoteFileRepository$prepareFile$2) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r104 = r100.label;
        switch(r104) {
            case 0: goto L40;
            case 1: goto L39;
            case 2: goto L38;
            case 3: goto L37;
            case 4: goto L28;
            case 5: goto L17;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            default: goto L11;
        };
    L12:
        Throwable r105 = (Throwable) r100.L$0;
        ResultKt.throwOnFailure(r102);
        throw r105;
    L13:
        File r106 = (File) r100.L$0;
        ResultKt.throwOnFailure(r102);
        return r106;
    L14:
        kotlinx.coroutines.sync.a r107 = (kotlinx.coroutines.sync.a) r100.L$4;
        Ref.BooleanRef r108 = (Ref.BooleanRef) r100.L$3;
        File r109 = (File) r100.L$2;
        File r110 = (File) r100.L$1;
        b r111 = (b) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        ?? r112 = r108;
    L16:
        kotlinx.coroutines.sync.a r113 = r107;
        l(r111);     // Catch: Throwable -> L167
        if (r109.isFile() == false) goto L166;
        if (r109.canRead() == false) goto L166;
        f309445f.put(r111, new a(r109, SystemClock.elapsedRealtime()));     // Catch: Throwable -> L167
        f309446g.postValue(Unit.INSTANCE);     // Catch: Throwable -> L167
        r112.element = true;     // Catch: Throwable -> L167
        r113.unlock(null);     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        BuildersKt.launch$default(f309441b, null, null, new PcRemoteFileRepository$prepareFile$7(null), 3, null);     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        FLogger.f375446a.i("PcRemoteFilePreview", "stage=save_success file_id=" + r110.getName() + " bytes=" + r109.length());     // Catch: Throwable -> L20 PcRemoteFileException -> L24 CancellationException -> L26 Exception -> L171
        if (r112.element == true) goto L211;
        CoroutineContext r114 = k1.f504992a.plus(Dispatchers.getIO());
        PcRemoteFileRepository$prepareFile$8 r115 = new PcRemoteFileRepository$prepareFile$8(r110, null);
        r100.L$0 = r109;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.L$4 = null;
        r100.label = 7;
        if (BuildersKt.withContext(r114, r115, r100) != r103) goto L211;
        return r103;
    L211:
        return r109;
    L166:
        throw new PcRemoteFileException(PcRemoteFileError.DOWNLOAD_FAILED, null, 2, null);     // Catch: Throwable -> L167
    L171:
        e = e;
        ?? r116 = r112;
        File r117 = r110;
    L180:
        FLogger.f375446a.e("PcRemoteFilePreview", "stage=download_failed exception=" + e.getClass().getSimpleName());     // Catch: Throwable -> L20
        throw new PcRemoteFileException(PcRemoteFileError.DOWNLOAD_FAILED, null, 2, null);     // Catch: Throwable -> L20
    L167:
        th = move-exception;
        r113.unlock(null);     // Catch: Throwable -> L20 PcRemoteFileException -> L24 CancellationException -> L26 Exception -> L171
        throw th;     // Catch: Throwable -> L20 PcRemoteFileException -> L24 CancellationException -> L26 Exception -> L171
    L17:
        Ref.BooleanRef r118 = (Ref.BooleanRef) r100.L$3;
        File r119 = (File) r100.L$2;
        r110 = (File) r100.L$1;
        b r120 = (b) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r111 = r120;
        r109 = r119;
        ?? r121 = r118;
    L148:
        r107 = f309442c;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r100.L$0 = r111;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r100.L$1 = r110;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r100.L$2 = r109;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r100.L$3 = r121;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r100.L$4 = r107;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r100.label = 6;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r112 = r121;
        if (r107.a(null, r100) != r103) goto L16;
        return r103;
    L28:
        kotlinx.coroutines.sync.a r122 = (kotlinx.coroutines.sync.a) r100.L$5;
        r116 = (Ref.BooleanRef) r100.L$4;
        File r123 = (File) r100.L$3;
        r117 = (File) r100.L$2;
        String r124 = (String) r100.L$1;
        b r125 = (b) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L31 PcRemoteFileException -> L33 CancellationException -> L35 Exception -> L173
        ?? r126 = r116;
    L200:
        l(r125);     // Catch: Throwable -> L175
        if (r117.mkdirs() == false) goto L138;
    L142:
        Unit r127 = Unit.INSTANCE;     // Catch: Throwable -> L175
        r122.unlock(null);     // Catch: Throwable -> L31 PcRemoteFileException -> L33 CancellationException -> L35 Exception -> L173
        r100.L$0 = r125;     // Catch: Throwable -> L31 PcRemoteFileException -> L33 CancellationException -> L35 Exception -> L173
        r100.L$1 = r117;     // Catch: Throwable -> L31 PcRemoteFileException -> L33 CancellationException -> L35 Exception -> L173
        r100.L$2 = r123;     // Catch: Throwable -> L31 PcRemoteFileException -> L33 CancellationException -> L35 Exception -> L173
        r100.L$3 = r126;     // Catch: Throwable -> L31 PcRemoteFileException -> L33 CancellationException -> L35 Exception -> L173
        r100.L$4 = null;     // Catch: Throwable -> L31 PcRemoteFileException -> L33 CancellationException -> L35 Exception -> L173
        r100.L$5 = null;     // Catch: Throwable -> L31 PcRemoteFileException -> L33 CancellationException -> L35 Exception -> L173
        r100.label = 5;     // Catch: Throwable -> L31 PcRemoteFileException -> L33 CancellationException -> L35 Exception -> L173
        if (r210.h(r124, r123, r100) == r103) goto L217;
        r121 = r126;
        r109 = r123;
        r110 = r117;
        r111 = r125;
        goto L148
    L217:
        return r103;
    L138:
        if (r117.isDirectory() == true) goto L142;
        throw new PcRemoteFileException(PcRemoteFileError.DOWNLOAD_FAILED, null, 2, null);     // Catch: Throwable -> L175
    L175:
        th = move-exception;
        r122.unlock(null);     // Catch: Throwable -> L31 PcRemoteFileException -> L33 CancellationException -> L35 Exception -> L173
        throw th;     // Catch: Throwable -> L31 PcRemoteFileException -> L33 CancellationException -> L35 Exception -> L173
    L33:
        e = move-exception;
        throw e;     // Catch: Throwable -> L20
    L35:
        e = move-exception;
        throw e;     // Catch: Throwable -> L20
    L173:
        e = e;
    L31:
        th = th;
    L186:
        if (r116.element == true) goto L220;
        CoroutineContext r128 = k1.f504992a.plus(Dispatchers.getIO());
        PcRemoteFileRepository$prepareFile$8 r129 = new PcRemoteFileRepository$prepareFile$8(r117, null);
        r100.L$0 = th;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.L$4 = null;
        r100.L$5 = null;
        r100.label = 8;
        if (BuildersKt.withContext(r128, r129, r100) != r103) goto L221;
        return r103;
    L221:
        throw th;
    L220:
        throw th;
    L37:
        g r130 = (g) r100.L$1;
        b r131 = (b) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r125 = r131;
    L57:
        r124 = (String) r102;
        l(r125);
        PolarisFileWrapper r132 = new PolarisFileWrapper((File) f309448i.getValue(), UUID.randomUUID().toString());
        String r133 = StringsKt.trim(StringsKt.substringAfterLast$default(StringsKt.replace$default(r130.f309469c, '\\', '/', false, 4, null), '/', null, 2, null)).toString();
        if (StringsKt.isBlank(r133) == false) goto L60;
    L65:
        boolean r134 = true;
    L66:
        if (r134 == false) goto L69;
        r133 = null;
    L69:
        String r135 = "";
        if (r133 != null) goto L75;
        String r136 = r130.f309470d;
        if (r136 != null) goto L74;
        r136 = "";
    L74:
        r133 = StringsKt.substringAfterLast$default(StringsKt.replace$default(StringsKt.trim(r136).toString(), '\\', '/', false, 4, null), '/', null, 2, null);
    L75:
        ArrayList r137 = new ArrayList(r133.length());
        int r138 = 0;
    L77:
        if (r138 >= r133.length()) goto L82;
        char r139 = r133.charAt(r138);
        if (Character.isISOControl(r139) == false) goto L81;
        r139 = '_';
    L81:
        r137.add(Character.valueOf(r139));
        r138 = r138 + 1;
        goto L77
    L82:
        String r140 = CollectionsKt.joinToString$default(r137, "", null, null, 0, null, null, 62, null);
        if (StringsKt.isBlank(r140) == false) goto L85;
    L88:
        r140 = "file";
    L89:
        String r141 = StringsKt.substringAfterLast(r140, '.', "");
        if (StringsKt.lastIndexOf$default(r140, '.', 0, false, 6, null) > 0) goto L92;
    L94:
        boolean r142 = false;
    L95:
        if (r142 == true) goto L98;
        r141 = null;
    L98:
        if (r141 != null) goto L120;
        String r143 = r130.f309471e;
        if (r143 == null) goto L108;
        String r144 = StringsKt.trim(r143).toString();
        if (r144 == null) goto L108;
        String r145 = StringsKt.removePrefix(r144, ".");
        if (r145 == null) goto L108;
        if (g.a(r145) == false) goto L108;
    L109:
        if (r145 == null) goto L118;
        StringBuilder r146 = new StringBuilder();
        String r147 = StringsKt.trimEnd(r140, new char[]{'.'});
        if (r147.length() != 0) goto L113;
        boolean r148 = true;
    L114:
        if (r148 == false) goto L116;
        String r149 = "file";
    L117:
        r146.append(r149);
        r146.append('.');
        r146.append(r145);
        r140 = r146.toString();
        goto L118
    L116:
        r149 = r147;
        goto L117
    L113:
        r148 = false;
    L118:
        r141 = r145;
    L108:
        r145 = null;
    L120:
        if (r140.getBytes(Charsets.UTF_8).length <= 240) goto L130;
        if (r141 == null) goto L124;
        r140 = StringsKt.substringBeforeLast$default(r140, '.', null, 2, null);
    L124:
        if (r140.getBytes(Charsets.UTF_8).length <= 200) goto L126;
        r140 = r140.substring(0, Character.offsetByCodePoints(r140, r140.length(), -1));
        goto L124
    L126:
        StringBuilder r150 = new StringBuilder();
        r150.append(r140);
        if (r141 == null) goto L129;
        r135 = ".".concat(r141);
    L129:
        r150.append(r135);
        r140 = r150.toString();
    L130:
        PolarisFileWrapper r151 = new PolarisFileWrapper(r132, r140);
        Ref.BooleanRef r152 = new Ref.BooleanRef();
        MutexImpl r153 = f309442c;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r100.L$0 = r125;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r100.L$1 = r124;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r100.L$2 = r132;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r100.L$3 = r151;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r100.L$4 = r152;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r100.L$5 = r153;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r100.label = 4;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        if (r153.a(null, r100) == r103) goto L216;
        r126 = r152;
        r122 = r153;
        r117 = r132;
        r123 = r151;
        goto L200
    L216:
        return r103;
    L92:
        if (g.a(r141) == false) goto L94;
        r142 = true;
        goto L95
    L85:
        if (Intrinsics.areEqual(r140, ".") == true) goto L88;
        if (Intrinsics.areEqual(r140, DownloadConstants.VULNERABILITY_PATH) == false) goto L89;
    L60:
        if (Intrinsics.areEqual(r133, ".") == true) goto L65;
        if (Intrinsics.areEqual(r133, DownloadConstants.VULNERABILITY_PATH) == true) goto L65;
        r134 = false;
        goto L66
    L38:
        kotlinx.coroutines.sync.a r154 = (kotlinx.coroutines.sync.a) r100.L$2;
        g r155 = (g) r100.L$1;
        b r156 = (b) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L198:
        File r157 = e(r156);     // Catch: Throwable -> L193
        r154.unlock(null);
        if (r157 == null) goto L52;
        return r157;
    L52:
        if (NetworkUtils.isNetworkAvailable(AppHost.f326268a.getApplication()) == false) goto L192;
        PcRemoteFileDispatcher r158 = PcRemoteFileDispatcher.f309430a;
        r100.L$0 = r156;
        r100.L$1 = r155;
        r100.L$2 = null;
        r100.label = 3;
        r102 = r158.b(r155, r100);
        if (r102 == r103) goto L215;
        r130 = r155;
        r125 = r156;
        goto L57
    L215:
        return r103;
    L192:
        throw new PcRemoteFileException(PcRemoteFileError.NETWORK_ERROR, null, 2, null);
    L193:
        th = move-exception;
        r154.unlock(null);
        throw th;
    L39:
        g r159 = (g) r100.L$1;
        b r160 = (b) r100.L$0;
        ResultKt.throwOnFailure(r102);
        b r161 = r160;
    L43:
        l(r161);
        MutexImpl r162 = f309442c;
        r100.L$0 = r161;
        r100.L$1 = r159;
        r100.L$2 = r162;
        r100.label = 2;
        if (r162.a(null, r100) == r103) goto L214;
        r156 = r161;
        r155 = r159;
        r154 = r162;
        goto L198
    L214:
        return r103;
    L40:
        ResultKt.throwOnFailure(r102);
        r161 = r211;
        r100.L$0 = r161;
        r159 = r212;
        r100.L$1 = r159;
        r100.label = 1;
        if (d(r100) != r103) goto L43;
        return r103;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        e = e;
    L20:
        th = th;
        r116 = r104;
        r117 = r10;
    L24:
        e = move-exception;
        throw e;     // Catch: Throwable -> L20
    L26:
        e = move-exception;
        throw e;     // Catch: Throwable -> L20
    L7:
        r100 = new PcRemoteFileRepository$prepareFile$2(r210, r213);
        goto L8
    }
}
