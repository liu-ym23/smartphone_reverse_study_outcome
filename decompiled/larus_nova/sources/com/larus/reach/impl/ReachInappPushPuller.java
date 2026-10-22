package com.larus.reach.impl;

import com.larus.im.IInstantMessenger;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import com.larus.reach.api.ReachRequestSource;
import com.larus.reach.runtime.r;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ReachInappPushPuller {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f367144d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile WorkerPool f367145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque<b> f367146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f367147c;

    /* JADX INFO: loaded from: classes31.dex */
    public final class WorkerPool {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CoroutineScope f367148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Channel<b> f367149b;

        public WorkerPool(ReachInappPushPuller r110) {
            this.f367148a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
            this.f367149b = ChannelKt.Channel$default(5, null, null, 6, null);
            int r100 = 0;
        L4:
            if (r100 >= 2) goto L6;
            BuildersKt.launch$default(this.f367148a, null, null, new ReachInappPushPuller$WorkerPool$1$1(this, r110, null), 3, null);
            r100 = r100 + 1;
            goto L4
        }
    }

    public static final class a {
    }

    /* JADX INFO: loaded from: classes31.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f367150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f367151b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f367150a, r101.f367150a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f367151b, r101.f367151b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f367150a.hashCode() * 31;
            String r101 = this.f367151b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "PullTask(scene=" + this.f367150a + ", launchSchema=" + this.f367151b + ')';
        }

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            this.f367150a = r100;
            this.f367151b = r101;
        }
    }

    static {
    }

    public ReachInappPushPuller() {
        this.f367146b = new ArrayDeque();
    }

    public final Object b(String r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof ReachInappPushPuller$prepareFrontierForPull$1) == false) goto L7;
        ReachInappPushPuller$prepareFrontierForPull$1 r102 = (ReachInappPushPuller$prepareFrontierForPull$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L25:
        Boolean r107 = (Boolean) r104;
        if (r107 == null) goto L28;
        boolean r108 = r107.booleanValue();
    L29:
        if (r108 == true) goto L32;
        FLogger.f375446a.w("ReachInappPushPull", "continue inapp push pull after frontier wait timeout, scene=" + r100);
    L32:
        return Unit.INSTANCE;
    L28:
        r108 = false;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        IInstantMessenger r109 = (IInstantMessenger) ServiceManager.get().getService(IInstantMessenger.class);
        if (r109 != null) goto L19;
        FLogger.f375446a.w("ReachInappPushPull", "continue inapp push pull without frontier wait, scene=" + r100 + ", reason=im_unavailable");
        return Unit.INSTANCE;
    L19:
        if (r109.b() == true) goto L21;
        FLogger.f375446a.i("ReachInappPushPull", "wait frontier connected before inapp push pull, scene=" + r100);
        r109.d();
        ReachInappPushPuller$prepareFrontierForPull$connected$1 r110 = new ReachInappPushPuller$prepareFrontierForPull$connected$1(r109, null);
        r102.L$0 = r100;
        r102.label = 1;
        r104 = TimeoutKt.c(10000, r110, r102);
        if (r104 != r105) goto L25;
        return r105;
    L21:
        return Unit.INSTANCE;
    L7:
        r102 = new ReachInappPushPuller$prepareFrontierForPull$1(this, r101);
        goto L8
    }

    public final void c(ReachInappPushBizScenePage r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        String r102 = r100.getProtocolValue();
        int r103 = xa9.a.f563097a;
        boolean r104 = false;
        if (ga9.a.b("inapp_push_cold_start_pull_enable", false) == true) goto L6;
        FLogger.f375446a.i("ReachInappPushPull", "skip inapp push pull, scene=" + r102 + ", reason=switch_off");
        return;
    L6:
        b r105 = new b(r102, r101);
        monitor-enter(this);
        WorkerPool r106 = this.f367145a;     // Catch: Throwable -> L30
        if (r106 == null) goto L13;
    L21:
        monitor-exit(this);
        if (r106 == null) goto L24;
        Intrinsics.checkNotNullParameter(r105, "task");
        Object r107 = r106.f367149b.mo10962trySendJP2dKIU(r105);
        kotlinx.coroutines.channels.g.c r108 = kotlinx.coroutines.channels.g.f504696b;
        r104 = true ^ (r107 instanceof kotlinx.coroutines.channels.g.c);
    L27:
        if (r104 == true) goto L35;
        FLogger.f375446a.w("ReachInappPushPull", "drop inapp push pull, scene=" + r102 + ", reason=queue_overflow");
        return;
    L35:
        return;
    L24:
        if (r104 == false) goto L26;
        Dispatchers.getIO().dispatch(EmptyCoroutineContext.INSTANCE, new g(this));
    L26:
        r104 = true;
        goto L27
    L13:
        if (this.f367146b.size() < 5) goto L16;
        monitor-exit(this);
        goto L27
    L16:
        this.f367146b.addLast(r105);     // Catch: Throwable -> L30
        if (this.f367147c == true) goto L20;
        this.f367147c = true;     // Catch: Throwable -> L30
        r104 = true;
    L20:
        r106 = null;
    L30:
        th = move-exception;
        throw th;
    }

    public static final Object a(ReachInappPushPuller r100, b r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof ReachInappPushPuller$executePull$1) == false) goto L7;
        ReachInappPushPuller$executePull$1 r103 = (ReachInappPushPuller$executePull$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        ResultKt.throwOnFailure(r105);
    L23:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r101 = (b) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L19:
        String r108 = r101.f367150a;
        String r109 = r101.f367151b;
        r103.L$0 = null;
        r103.label = 2;
        if (r100.d(r108, r109, r103) != r106) goto L23;
        return r106;
    L16:
        ResultKt.throwOnFailure(r105);
        String r110 = r101.f367150a;
        r103.L$0 = r101;
        r103.label = 1;
        if (r100.b(r110, r103) != r106) goto L19;
        return r106;
    L7:
        r103 = new ReachInappPushPuller$executePull$1(r100, r102);
        goto L8
    }

    public final Object d(String r110, String r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof ReachInappPushPuller$requestAndConsume$1) == false) goto L7;
        ReachInappPushPuller$requestAndConsume$1 r100 = (ReachInappPushPuller$requestAndConsume$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ReachInappPushPuller$requestAndConsume$1 r102 = r100;
        Object r113 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        List<ns9.m> r114 = null;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        r111 = (String) r102.L$1;
        r110 = (String) r102.L$0;
        ResultKt.throwOnFailure(r113);
    L17:
        dm9.a r115 = (dm9.a) r113;
        if ((r115 instanceof dm9.a.b) == false) goto L40;
        BizResponse<T> r116 = ((dm9.a.b) r115).f469231a;
        if (r116.isSuccess() == true) goto L23;
        FLogger.f375446a.w("ReachInappPushPull", "inapp push pull returned biz error, scene=" + r110 + ", code=" + r116.getCode() + ", msg=" + r116.getMsg());
        return Unit.INSTANCE;
    L23:
        GetInappPushData r117 = (GetInappPushData) r116.getData();
        if (r117 == null) goto L26;
        r114 = r117.getPushInfoList();
    L26:
        if (r114 != null) goto L28;
        r114 = CollectionsKt.emptyList();
    L28:
        List r118 = CollectionsKt.filterNotNull(r114);
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("inapp push pull success, scene=");
        r106.append(r110);
        r106.append(", hasSchema=");
        if (r111 != null) goto L31;
    L34:
        boolean r119 = true;
    L35:
        r106.append(!r119);
        r106.append(", count=");
        r106.append(r118.size());
        r105.i("ReachInappPushPull", r106.toString());
        Iterator r120 = r118.iterator();
    L37:
        if (r120.hasNext() == false) goto L43;
        r.a(new com.larus.reach.runtime.w(Boxing.boxInt(80006), (ns9.m) r120.next(), ReachRequestSource.INAPP_PUSH_PULL));
    L43:
        return Unit.INSTANCE;
    L31:
        if (StringsKt.isBlank(r111) == true) goto L34;
        r119 = false;
        goto L35
    L40:
        if ((r115 instanceof dm9.a.C5690a) == false) goto L45;
        FLogger r121 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("inapp push pull failed, scene=");
        r107.append(r110);
        r107.append(", code=");
        dm9.a.C5690a r122 = (dm9.a.C5690a) r115;
        r107.append(r122.f469228a);
        r107.append(", msg=");
        r107.append(r122.f469229b);
        r121.e("ReachInappPushPull", r107.toString(), r122.f469230c);
        goto L43
    L45:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        ReachInappPushApi.a r123 = ReachInappPushApi.f367140a;
        ReachInappPushPuller$requestAndConsume$result$1 r108 = new ReachInappPushPuller$requestAndConsume$result$1(r110, r111, null);
        r102.L$0 = r110;
        r102.L$1 = r111;
        r102.label = 1;
        r123.getClass();
        FlowHttpConnection r124 = FlowHttpConnection.f359975a;
        r113 = FlowHttpConnection.g(ServiceType.BASIC_SERVICE, ReachInappPushApi.class, r108, true, null, null, null, r102, 240);
        if (r113 != r103) goto L17;
        return r103;
    L7:
        r100 = new ReachInappPushPuller$requestAndConsume$1(this, r112);
        goto L8
    }
}
