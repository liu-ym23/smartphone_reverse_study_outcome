package com.larus.multitask_management.impl;

import com.larus.im.FlowRuntime;
import com.larus.im.internal.delegate.c0;
import com.larus.multitask_management.api.spi.net.FlowHttpConnection;
import gd9.z;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kl9.o0;
import kl9.p0;
import kl9.q0;
import kl9.u;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import ouc.v;

/* JADX INFO: loaded from: classes4.dex */
public final class RemoteTaskRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RemoteTaskRepo f359434a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z f359435b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineScope f359436c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final akc.c<String, List<u>> f359437d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final akc.c<String, String> f359438e = null;

    public RemoteTaskRepo() {
    }

    static {
        f359434a = new RemoteTaskRepo();
        f359435b = FlowRuntime.b().i();
        f359436c = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        f359437d = new akc.c();
        f359438e = new akc.c();
    }

    public static String c() {
        return "keva_key_remote_task_list_" + FlowRuntime.b().h().getUserId();
    }

    public static String d() {
        return "keva_key_remote_task_language_" + FlowRuntime.b().h().getUserId();
    }

    public static void f(List r100) {
        Intrinsics.checkNotNullParameter(r100, "taskRecordList");
        String r101 = c();
        f359437d.put(r101, r100);
        BuildersKt.launch$default(f359436c, null, null, new RemoteTaskRepo$saveRemoteTaskRecordList$1(r101, r100, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(kl9.i r100, Continuation<? super u> r101) {
        if ((r101 instanceof RemoteTaskRepo$createTask$1) == false) goto L7;
        RemoteTaskRepo$createTask$1 r102 = (RemoteTaskRepo$createTask$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        com.larus.multitask_management.api.spi.net.b r107 = (com.larus.multitask_management.api.spi.net.b) r104;
        if ((r107 instanceof com.larus.multitask_management.api.spi.net.b.C4423b) == false) goto L24;
        com.larus.multitask_management.api.spi.net.b.C4423b r108 = (com.larus.multitask_management.api.spi.net.b.C4423b) r107;
        if (r108.f359402a.a() == false) goto L24;
        kl9.j r109 = (kl9.j) r108.f359402a.f359396d;
        if (r109 != null) goto L27;
        return null;
    L27:
        return r109.f503920c;
    L24:
        c0.f348199b.e("multitask-RemoteTaskRepo", "createTask failed, result = " + r107);
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        RemoteTaskRepo$createTask$result$1 r110 = new RemoteTaskRepo$createTask$result$1(r100, null);
        r102.label = 1;
        r104 = FlowHttpConnection.f359391a.a(r110, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new RemoteTaskRepo$createTask$1(this, r101);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(List<String> r100, Continuation<? super List<u>> r101) {
        if ((r101 instanceof RemoteTaskRepo$fetchRemoteTaskUpdate$1) == false) goto L7;
        RemoteTaskRepo$fetchRemoteTaskUpdate$1 r102 = (RemoteTaskRepo$fetchRemoteTaskUpdate$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        com.larus.multitask_management.api.spi.net.b r107 = (com.larus.multitask_management.api.spi.net.b) r104;
        if ((r107 instanceof com.larus.multitask_management.api.spi.net.b.C4423b) == false) goto L33;
        com.larus.multitask_management.api.spi.net.b.C4423b r108 = (com.larus.multitask_management.api.spi.net.b.C4423b) r107;
        if (r108.f359402a.a() == false) goto L33;
        o0 r109 = (o0) r108.f359402a.f359396d;
        if (r109 == null) goto L32;
        Map<String, u> r110 = r109.f503954b;
        if (r110 == null) goto L32;
        Collection<u> r111 = r110.values();
        if (r111 == null) goto L32;
        List r112 = CollectionsKt.toList(r111);
        if (r112 == null) goto L32;
        List r113 = CollectionsKt.filterNotNull(r112);
        if (r113 == null) goto L32;
        return r113;
    L32:
        return CollectionsKt.emptyList();
    L33:
        c0.f348199b.e("multitask-RemoteTaskRepo", "fetchRemoteTaskUpdate failed, result = " + r107);
        return CollectionsKt.emptyList();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        RemoteTaskRepo$fetchRemoteTaskUpdate$result$1 r114 = new RemoteTaskRepo$fetchRemoteTaskUpdate$result$1(r100, null);
        r102.label = 1;
        r104 = FlowHttpConnection.f359391a.a(r114, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new RemoteTaskRepo$fetchRemoteTaskUpdate$1(this, r101);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object g(p0 r100, Continuation<? super u> r101) {
        if ((r101 instanceof RemoteTaskRepo$updateTask$1) == false) goto L7;
        RemoteTaskRepo$updateTask$1 r102 = (RemoteTaskRepo$updateTask$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        com.larus.multitask_management.api.spi.net.b r107 = (com.larus.multitask_management.api.spi.net.b) r104;
        if ((r107 instanceof com.larus.multitask_management.api.spi.net.b.C4423b) == false) goto L24;
        com.larus.multitask_management.api.spi.net.b.C4423b r108 = (com.larus.multitask_management.api.spi.net.b.C4423b) r107;
        if (r108.f359402a.a() == false) goto L24;
        c0.f348199b.i("multitask-RemoteTaskRepo", "updateTask success, result = " + r107);
        q0 r109 = (q0) r108.f359402a.f359396d;
        if (r109 != null) goto L27;
        return null;
    L27:
        return r109.f503975c;
    L24:
        c0.f348199b.e("multitask-RemoteTaskRepo", "updateTask failed, result = " + r107);
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        RemoteTaskRepo$updateTask$result$1 r110 = new RemoteTaskRepo$updateTask$result$1(r100, null);
        r102.label = 1;
        r104 = FlowHttpConnection.f359391a.a(r110, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new RemoteTaskRepo$updateTask$1(this, r101);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object e(long r100, boolean r110, boolean r111, Continuation<? super List<u>> r112) {
        if ((r112 instanceof RemoteTaskRepo$listUserTasks$1) == false) goto L7;
        RemoteTaskRepo$listUserTasks$1 r101 = (RemoteTaskRepo$listUserTasks$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r113 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        List<u> r105 = (List) r101.L$0;
        ResultKt.throwOnFailure(r113);
    L38:
        com.larus.multitask_management.api.spi.net.b r114 = (com.larus.multitask_management.api.spi.net.b) r113;
        if ((r114 instanceof com.larus.multitask_management.api.spi.net.b.C4423b) == false) goto L50;
        com.larus.multitask_management.api.spi.net.b.C4423b r115 = (com.larus.multitask_management.api.spi.net.b.C4423b) r114;
        if (r115.f359402a.a() == false) goto L50;
        o0 r106 = (o0) r115.f359402a.f359396d;
        if (r106 == null) goto L49;
        List<u> r107 = r106.f503953a;
        if (r107 == null) goto L49;
        List r108 = CollectionsKt.filterNotNull(r107);
        if (r108 == null) goto L49;
        return r108;
    L49:
        return CollectionsKt.emptyList();
    L50:
        c0.f348199b.e("multitask-RemoteTaskRepo", "pullRemoteTasks failed, result = " + r114);
        return r105;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        if (r110 == false) goto L33;
        String r116 = c();
        akc.c<String, List<u>> r109 = f359437d;
        if (r109.get(r116) == null) goto L52;
        List<u> r117 = r109.get(r116);
    L28:
        c0 r118 = c0.f348199b;
        StringBuilder r119 = new StringBuilder("listUserTasks local cache task size = ");
        if (r117 == null) goto L31;
        Integer r120 = Boxing.boxInt(r117.size());
    L32:
        r119.append(r120);
        r118.i("multitask-RemoteTaskRepo", r119.toString());
    L34:
        RemoteTaskRepo$listUserTasks$result$1 r121 = new RemoteTaskRepo$listUserTasks$result$1(r100, r111, null);
        r101.L$0 = r117;
        r101.label = 1;
        r113 = FlowHttpConnection.f359391a.a(r121, r101);
        if (r113 != r103) goto L37;
        return r103;
    L37:
        r105 = r117;
        goto L38
    L31:
        r120 = null;
        goto L32
    L52:
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L21
        v r123 = com.larus.multitask_management.api.spi.net.d.f359404a;     // Catch: Throwable -> L21
        String r124 = f359435b.a(r116, "", "keva_repo_multitask");     // Catch: Throwable -> L21
        r123.getClass();     // Catch: Throwable -> L21
        Object r125 = Result.m9449constructorimpl((List) r123.c(new nuc.f(u.Companion.serializer()), r124));     // Catch: Throwable -> L21
    L24:
        if (Result.m9452exceptionOrNullimpl(r125) == null) goto L27;
        r125 = CollectionsKt.emptyList();
    L27:
        List<u> r126 = (List) r125;
        f359437d.put(r116, r126);
        r117 = r126;
    L21:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L33:
        r117 = null;
    L7:
        r101 = new RemoteTaskRepo$listUserTasks$1(this, r112);
        goto L8
    }
}
