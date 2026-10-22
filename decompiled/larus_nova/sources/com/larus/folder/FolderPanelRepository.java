package com.larus.folder;

import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes29.dex */
public final class FolderPanelRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FolderPanelRepository f343613a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f343614b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f343615c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, List<j>> f343616d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Deferred<m>> f343617e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f343618f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f343619g;

    public FolderPanelRepository() {
    }

    static {
        f343613a = new FolderPanelRepository();
        f343614b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f343615c = new Object();
        f343616d = new LinkedHashMap();
        f343617e = new LinkedHashMap();
    }

    public static List d() {
        f343619g++;
        ((LinkedHashMap) f343616d).clear();
        LinkedHashMap r100 = (LinkedHashMap) f343617e;
        List r101 = CollectionsKt.toList(r100.values());
        r100.clear();
        return r101;
    }

    public static List a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "deviceId");
        String r101 = AccountService.f365697a.getUserId();
        CollectionsKt.emptyList();
        Object r102 = f343615c;
        monitor-enter(r102);
        List r103 = c(r101);     // Catch: Throwable -> L8
        List r104 = (List) ((LinkedHashMap) f343616d).get(r100);     // Catch: Throwable -> L8
        monitor-exit(r102);
        b(r103);
        return r104;
    L8:
        th = move-exception;
        throw th;
    }

    public static void b(List r100) {
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Job.DefaultImpls.cancel$default((Deferred) r101.next(), null, 1, null);
        goto L4
    }

    public static List c(String r100) {
        String r101 = f343618f;
        if (r101 != null) goto L7;
        f343618f = r100;
        return CollectionsKt.emptyList();
    L7:
        if (Intrinsics.areEqual(r101, r100) == true) goto L9;
        FLogger.f375446a.i("FolderPanelRepository", "[ensureCacheOwnerLocked] account changed, invalidate folder cache");
        f343618f = r100;
        return d();
    L9:
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v7, types: [T, java.util.List] */
    public final Object e(final String r210, Continuation<? super m> r211) {
        if ((r211 instanceof FolderPanelRepository$refreshFolders$1) == false) goto L7;
        FolderPanelRepository$refreshFolders$1 r100 = (FolderPanelRepository$refreshFolders$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        FolderPanelRepository$refreshFolders$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L17;
        if (r105 != 1) goto L16;
        ResultKt.throwOnFailure(r103);     // Catch: CancellationException -> L13
    L37:
        return (m) r103;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r103);
        String r106 = AccountService.f365697a.getUserId();
        Ref.ObjectRef r110 = new Ref.ObjectRef();
        r110.element = CollectionsKt.emptyList();
        Object r111 = f343615c;
        monitor-enter(r111);
        r110.element = c(r106);     // Catch: Throwable -> L44
        Map<String, Deferred<m>> r112 = f343617e;     // Catch: Throwable -> L44
        final Deferred<m> r107 = (Deferred) ((LinkedHashMap) r112).get(r210);     // Catch: Throwable -> L44
        if (r107 != null) goto L22;
    L31:
        long r108 = f343619g;     // Catch: Throwable -> L44
        r107 = BuildersKt.async$default(f343614b, null, CoroutineStart.LAZY, new FolderPanelRepository$createRequestLocked$request$1(r210, r106, r108, null), 1, null);     // Catch: Throwable -> L44
        r112.put(r210, r107);     // Catch: Throwable -> L44
        r107.invokeOnCompletion(new k(r210, r107));     // Catch: Throwable -> L44
    L32:
        monitor-exit(r111);
        b((List) r110.element);
        r107.start();
        r102.label = 1;     // Catch: CancellationException -> L13
        r103 = r107.await(r102);     // Catch: CancellationException -> L13
        if (r103 != r104) goto L37;
        return r104;
    L22:
        if (r107.isCompleted() == false) goto L24;
    L26:
        boolean r109 = false;
    L27:
        if (r109 == true) goto L30;
        r107 = null;
    L30:
        if (r107 != null) goto L32;
    L24:
        if (r107.isCancelled() == true) goto L26;
        r109 = true;
    L44:
        th = move-exception;
        throw th;
    L13:
        e = move-exception;
        if (JobKt.isActive(r102.getContext()) == true) goto L42;
        throw e;
    L42:
        return m.b.f343639a;
    L7:
        r100 = new FolderPanelRepository$refreshFolders$1(this, r211);
        goto L8
    }
}
