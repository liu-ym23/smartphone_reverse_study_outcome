package com.larus.dora.impl.offline.record;

import androidx.collection.SieveCacheKt;
import com.bytedance.dora.offline.record.DoraOfflineRecord;
import com.larus.avlink.record.page.RecordMinutesViewModel$syncListener$1;
import com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService;
import com.larus.dora.api.offline.record.c;
import com.larus.dora.api.offline.record.d;
import com.larus.dora.api.offline.record.e;
import fk4.g;
import fk4.h;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0001\u000e\b\u0007\u0018\u0000 I2\u00020\u0001:\u0001IB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017J.\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0096@¢\u0006\u0002\u0010#J\u0018\u0010$\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010%J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\bH\u0016J\u0010\u0010*\u001a\u00020(2\u0006\u0010)\u001a\u00020\bH\u0016J\b\u0010+\u001a\u00020\fH\u0002J\u0010\u0010,\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J(\u0010-\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J\u0012\u0010/\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u00100\u001a\u00020(H\u0002J\u0018\u00101\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u001cH\u0002J\f\u00103\u001a\u000204*\u00020\u0016H\u0002J\f\u00105\u001a\u00020\"*\u000206H\u0002J\f\u00107\u001a\u00020\u0011*\u000208H\u0002J\f\u00109\u001a\u00020:*\u00020;H\u0002J\u0010\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u00020\u001aH\u0002J\u0010\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u00020\u0011H\u0002J\u0010\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u00020:H\u0002J\u0010\u0010B\u001a\u00020(2\u0006\u0010C\u001a\u00020\"H\u0002J \u0010D\u001a\u00020(2\u0006\u0010)\u001a\u00020\b2\u0006\u0010?\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\u001cH\u0002J\u0018\u0010F\u001a\u00020(2\u0006\u0010)\u001a\u00020\b2\u0006\u0010C\u001a\u00020\"H\u0002J\u0018\u0010G\u001a\u00020(2\u0006\u0010)\u001a\u00020\b2\u0006\u0010A\u001a\u00020:H\u0002J\b\u0010H\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/larus/dora/impl/offline/record/DoraOfflineRecordSyncServiceImpl;", "Lcom/larus/dora/api/offline/record/IDoraOfflineRecordSyncService;", "<init>", "()V", "listenerDispatchScope", "Lkotlinx/coroutines/CoroutineScope;", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/larus/dora/api/offline/record/DoraOfflineRecordTransferListener;", "doraOfflineRecord", "Lcom/bytedance/dora/offline/record/DoraOfflineRecord;", "linkDisconnected", "", "transferListener", "com/larus/dora/impl/offline/record/DoraOfflineRecordSyncServiceImpl$transferListener$1", "Lcom/larus/dora/impl/offline/record/DoraOfflineRecordSyncServiceImpl$transferListener$1;", "latestProgress", "Lcom/larus/dora/api/offline/record/DoraOfflineRecordTransferProgress;", "doraLinkCallback", "Lcom/bytedance/dora/link/IDoraLinkCallback;", "configureStorage", "config", "Lcom/larus/dora/api/offline/record/DoraOfflineRecordStorageConfig;", "(Lcom/larus/dora/api/offline/record/DoraOfflineRecordStorageConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindContext", "businessType", "", "vuiId", "", "contextType", "contextId", "(ILjava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSyncedRecordings", "", "Lcom/larus/dora/api/offline/record/DoraOfflineSyncedRecording;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSyncedRecording", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSyncedRecording", "registerTransferListener", "", "listener", "unregisterTransferListener", "initializeDoraOfflineRecord", "configureDoraOfflineRecordStorage", "bindDoraOfflineRecordContext", "getDoraOfflineRecordings", "getDoraOfflineRecording", "initializeOfflineRecordService", "deleteAppSyncedRecording", "reason", "toOfflineRecordStorageConfig", "Lcom/bytedance/dora/offline/record/OfflineRecordStorageConfig;", "toSyncedRecording", "Lcom/bytedance/dora/offline/record/OfflineRecordDelivery;", "toFlowProgress", "Lcom/bytedance/dora/offline/record/OfflineRecordTransferProgress;", "toFlowNotify", "Lcom/larus/dora/api/offline/record/DoraOfflineRecordFileReadyNotify;", "Lcom/bytedance/dora/offline/record/OfflineRecordFileReadyNotify;", "handleDoraLinkStateChanged", "state", "dispatchTransferProgress", "progress", "dispatchRecordFileReadyNotify", "notify", "dispatchTransferCompleted", "recording", "dispatchTransferProgressToListener", "source", "dispatchTransferCompletedToListener", "dispatchRecordFileReadyNotifyToListener", "isOfflineMinutesSupported", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraOfflineRecordSyncServiceImpl implements IDoraOfflineRecordSyncService {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f336530g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f336531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArraySet<c> f336532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DoraOfflineRecord f336533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f336534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile d f336535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.dora.impl.offline.record.a f336536f;

    public static final class a {
    }

    public static final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraOfflineRecordSyncServiceImpl f336537a;

        public b(DoraOfflineRecordSyncServiceImpl r100) {
            this.f336537a = r100;
        }

        @Override // fk4.g
        public final void a(fk4.c r110) {
            Intrinsics.checkNotNullParameter(r110, "delivery");
            DoraOfflineRecordSyncServiceImpl r100 = this.f336537a;
            int r101 = DoraOfflineRecordSyncServiceImpl.f336530g;
            if (r100.h() == true) goto L6;
            g49.d.d("DoraOfflineRecordSyncService", "Skip offline record completion callback because ability is unsupported");
            return;
        L6:
            g49.d.d("DoraOfflineRecordSyncService", "Offline record transfer completed, recordId=" + r110.f477618a + ", size=" + r110.f477625h);
            DoraOfflineRecordSyncServiceImpl r102 = this.f336537a;
            r102.getClass();
            e r111 = DoraOfflineRecordSyncServiceImpl.i(r110);
            g49.d.d("DoraOfflineRecordSyncService", "Dispatch offline record transfer completed, listenerCount=" + r102.f336532b.size() + ", vuiId=" + r111.f331795a + ", size=" + r111.f331801g);
            BuildersKt.launch$default(r102.f336531a, null, null, new DoraOfflineRecordSyncServiceImpl$dispatchTransferCompleted$1(r102, r111, null), 3, null);
        }

        @Override // fk4.g
        public final void b(h r110) {
            Intrinsics.checkNotNullParameter(r110, "progress");
            DoraOfflineRecordSyncServiceImpl r100 = this.f336537a;
            int r101 = DoraOfflineRecordSyncServiceImpl.f336530g;
            if (r100.h() == true) goto L6;
            g49.d.d("DoraOfflineRecordSyncService", "Skip offline record progress callback because ability is unsupported");
            return;
        L6:
            g49.d.d("DoraOfflineRecordSyncService", "SDK onTransferProgress raw: total=" + r110.f477648b + ", completed=" + r110.f477649c + ", percent=" + r110.f477650d + ", recordId=" + r110.f477647a);
            DoraOfflineRecordSyncServiceImpl r102 = this.f336537a;
            r102.getClass();
            int r103 = RangesKt.coerceIn(r110.f477650d, 0, 100);
            int r104 = r110.f477648b;
            if (r104 > 0) goto L9;
        L11:
            boolean r105 = false;
        L12:
            int r106 = r110.f477648b;
            int r107 = r110.f477649c;
            String r108 = r110.f477647a;
            if (r108 != null) goto L15;
            String r109 = "";
        L16:
            String r111 = r110.f477651e;
            if (r111 != null) goto L19;
            String r112 = "";
        L20:
            r102.g(new d(r105, r106, r107, r103, r109, r112, false, null, 192));
            return;
        L19:
            r112 = r111;
            goto L20
        L15:
            r109 = r108;
            goto L16
        L9:
            if (r110.f477649c >= r104) goto L11;
            r105 = true;
            goto L12
        }

        @Override // fk4.g
        public final void c(fk4.e r110) {
            Intrinsics.checkNotNullParameter(r110, "notify");
            DoraOfflineRecordSyncServiceImpl r100 = this.f336537a;
            int r101 = DoraOfflineRecordSyncServiceImpl.f336530g;
            r100.getClass();
            int r102 = r110.f477640a;
            int r103 = r110.f477641b;
            String r104 = r110.f477642c;
            if (r104 != null) goto L5;
            r104 = "";
        L5:
            com.larus.dora.api.offline.record.a r105 = new com.larus.dora.api.offline.record.a(r102, r103, r104, r110.f477643d, r110.f477644e, r110.f477645f, r110.f477646g);
            StringBuilder r111 = new StringBuilder("Offline record file ready notify received, status=");
            r111.append(r105.f331779a);
            r111.append(", isOfflineRecording=");
            boolean r106 = false;
            if (r105.f331779a != 1) goto L8;
            boolean r107 = true;
        L9:
            r111.append(r107);
            r111.append(", businessType=");
            r111.append(r105.f331780b);
            r111.append(", vuiId=");
            r111.append(r105.f331781c);
            r111.append(", fileType=");
            r111.append(r105.f331784f);
            g49.d.d("DoraOfflineRecordSyncService", r111.toString());
            DoraOfflineRecordSyncServiceImpl r112 = this.f336537a;
            r112.getClass();
            StringBuilder r108 = new StringBuilder("Dispatch offline record file ready notify, status=");
            r108.append(r105.f331779a);
            r108.append(", isOfflineRecording=");
            if (r105.f331779a != 1) goto L12;
            r106 = true;
        L12:
            r108.append(r106);
            r108.append(", listenerCount=");
            r108.append(r112.f336532b.size());
            r108.append(", businessType=");
            r108.append(r105.f331780b);
            r108.append(", vuiId=");
            r108.append(r105.f331781c);
            g49.d.d("DoraOfflineRecordSyncService", r108.toString());
            BuildersKt.launch$default(r112.f336531a, null, null, new DoraOfflineRecordSyncServiceImpl$dispatchRecordFileReadyNotify$1(r112, r105, null), 3, null);
            return;
        L8:
            r107 = false;
            goto L9
        }
    }

    static {
    }

    public final boolean h() {
        return this.f336533c.isOfflineMinutesSupported();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.dora.impl.offline.record.a] */
    public DoraOfflineRecordSyncServiceImpl() {
        this.f336531a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO().limitedParallelism(1)));
        this.f336532b = new CopyOnWriteArraySet();
        DoraOfflineRecord r100 = DoraOfflineRecord.getInstance();
        this.f336533c = r100;
        b r101 = new b(this);
        this.f336535e = d.f331786i;
        this.f336536f = new com.larus.dora.impl.offline.record.a(this);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        r100.init();     // Catch: Throwable -> L5
        r100.registerTransferListener(r101);     // Catch: Throwable -> L5
        g49.d.d("DoraOfflineRecordSyncService", "Dora offline record SDK initialized");     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L10;
        g49.d.c("DoraOfflineRecordSyncService", "Initialize Dora offline record SDK failed", r104);
    L10:
        Boolean r105 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r103) == false) goto L14;
        r103 = r105;
    L14:
        if (((Boolean) r103).booleanValue() == true) goto L25;
        g(new d(false, 0, 0, 0, null, null, true, "Initialize Dora offline record SDK failed", 63));
        return;
    L25:
        kj4.a.g().registerDoraLinkCallback(this.f336536f);     // Catch: Throwable -> L18
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L23;
        g49.d.c("DoraOfflineRecordSyncService", "Register Dora link callback for offline record failed", r107);
    L23:
        g49.d.d("DoraOfflineRecordSyncService", "Offline record sync service initialized");
        return;
    L18:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static e i(fk4.c r210) {
        String r100 = r210.f477618a;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        String r101 = r210.f477619b;
        int r102 = r210.f477621d;
        long r103 = r210.f477622e;
        long r104 = r210.f477623f;
        long r105 = r210.f477624g;
        long r110 = r210.f477625h;
        String r111 = r210.f477635r;
        int r112 = (int) RangesKt.coerceIn(r210.f477626i, 0, SieveCacheKt.NodeLinkMask);
        int r113 = r210.f477627j;
        int r114 = r210.f477634q;
        int r115 = r210.f477631n;
        String r106 = r210.f477636s;
        if (r106 != null) goto L8;
        String r116 = "";
    L9:
        long r117 = r210.f477637t;
        String r107 = r210.f477620c;
        if (r107 != null) goto L12;
        String r211 = "";
    L14:
        return new e(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r211);
    L12:
        r211 = r107;
        goto L14
    L8:
        r116 = r106;
        goto L9
    }

    @Override // com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService
    public final Object c(ContinuationImpl r100) {
        if (h() == true) goto L7;
        g49.d.d("DoraOfflineRecordSyncService", "Get synced offline records skipped because ability is unsupported");
        return CollectionsKt.emptyList();
    L7:
        return BuildersKt.withContext(Dispatchers.getIO(), new DoraOfflineRecordSyncServiceImpl$getSyncedRecordings$2(this, null), r100);
    }

    @Override // com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService
    public final void d(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (h() == true) goto L6;
        g49.d.d("DoraOfflineRecordSyncService", "Offline record transfer listener registered without snapshot because ability is unsupported");
        return;
    L6:
        this.f336532b.add(r100);
        BuildersKt.launch$default(this.f336531a, null, null, new DoraOfflineRecordSyncServiceImpl$registerTransferListener$1(this, r100, null), 3, null);
        g49.d.d("DoraOfflineRecordSyncService", "Offline record transfer listener registered, count=" + this.f336532b.size());
    }

    @Override // com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService
    public final void e(RecordMinutesViewModel$syncListener$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        g49.d.d("DoraOfflineRecordSyncService", "Offline record transfer listener unregistered, removed=" + this.f336532b.remove(r100) + ", count=" + this.f336532b.size());
    }

    public final synchronized void g(d r100) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f336534d == true) goto L7;
    L11:
        this.f336535e = r100;     // Catch: Throwable -> L14
        BuildersKt.launch$default(this.f336531a, null, null, new DoraOfflineRecordSyncServiceImpl$dispatchTransferProgress$1(this, r100, null), 3, null);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L7:
        if (r100.f331787a == false) goto L11;
        g49.d.d("DoraOfflineRecordSyncService", "Ignore stale offline record progress after link disconnected, recordId=" + r100.f331791e + ", progress=" + r100.f331790d);     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    @Override // com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService
    public final Object b(String r100, ContinuationImpl r101) {
        if (h() == true) goto L7;
        g49.d.d("DoraOfflineRecordSyncService", "Delete app offline record skipped because ability is unsupported");
        return Boxing.boxBoolean(false);
    L7:
        return BuildersKt.withContext(Dispatchers.getIO(), new DoraOfflineRecordSyncServiceImpl$deleteSyncedRecording$2(this, r100, null), r101);
    }

    @Override // com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService
    public final Object a(String r110, String r111, Continuation r112) {
        if (h() == true) goto L7;
        g49.d.d("DoraOfflineRecordSyncService", "Bind offline record context skipped because ability is unsupported");
        return Boxing.boxBoolean(false);
    L7:
        return BuildersKt.withContext(Dispatchers.getIO(), new DoraOfflineRecordSyncServiceImpl$bindContext$2(this, 1, r110, 1, r111, null), r112);
    }

    public static final void f(DoraOfflineRecordSyncServiceImpl r100, c r101, d r102, String r103) {
        if (r100.h() == true) goto L5;
        return;
    L5:
        if (r100.f336532b.contains(r101) == false) goto L19;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L9
        r101.c(r102);     // Catch: Throwable -> L9
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L18;
        g49.d.c("DoraOfflineRecordSyncService", "Dispatch offline record transfer progress failed, source=" + r103 + ", listener=" + r101.getClass().getName() + ", currentVuiId=" + r102.f331791e + ", progress=" + r102.f331790d + ", syncing=" + r102.f331787a, r106);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
