package com.larus.avlink.e.model.session_memory;

import com.larus.avlink.model.DoraVisionBizScene;
import com.larus.avlink.n1;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.model.FlowDoraSubBizType;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.network.FlowHttpConnection;
import com.larus.network.http.ServiceType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes25.dex */
public final class SessionMemoryMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f291830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f291831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f291832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f291833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f291834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f291835f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f291836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Job f291837h;

    public static final class a {
    }

    static {
    }

    public final void b(int r110) {
        n1.d("SessionMemoryMode", "Starting timer with interval: " + r110 + " ms.");
        this.f291836g = r110;
        this.f291837h = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new SessionMemoryMode$startTimerInternal$1(this, r110, null), 3, null);
    }

    public final void c(int r110) {
        n1.d("SessionMemoryMode", "tryRestartTimer called, new interval: " + r110 + ", last interval: " + this.f291836g + '.');
        int r100 = this.f291836g;
        if (r100 == r110) goto L10;
        if (r100 == 0) goto L11;
        n1.d("SessionMemoryMode", "Stopping timer and cleaning up resources.");
        Job r101 = this.f291837h;
        if (r101 == null) goto L8;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L8:
        this.f291837h = null;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new SessionMemoryMode$tryRestartTimer$1(this, null), 3, null);
        b(r110);
        return;
    L11:
        return;
    }

    public static final Object a(SessionMemoryMode r210, Continuation r211) {
        r210.getClass();
        if ((r211 instanceof SessionMemoryMode$reportSessionMemory$1) == false) goto L7;
        SessionMemoryMode$reportSessionMemory$1 r100 = (SessionMemoryMode$reportSessionMemory$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        SessionMemoryMode$reportSessionMemory$1 r110 = r100;
        Object r102 = r110.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        b r105 = (b) r110.L$0;
        ResultKt.throwOnFailure(r102);
    L36:
        dm9.a r106 = (dm9.a) r102;
        if ((r106 instanceof dm9.a.b) == false) goto L40;
        n1.d("SessionMemoryMode", "Session memory reported successfully with interval " + r210.f291836g + ", request: " + r105);
    L43:
        return Unit.INSTANCE;
    L40:
        if ((r106 instanceof dm9.a.C5690a) == false) goto L45;
        n1.b("SessionMemoryMode", "Failed to report session memory: " + ((dm9.a.C5690a) r106).f469229b + ", request: " + r105);
        goto L43
    L45:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        String r111 = r210.f291830a;
        String r107 = r210.f291831b;
        Integer r112 = Boxing.boxInt(11);
        Integer r108 = r210.f291834e;
        if (r108 == null) goto L17;
        int r109 = r108.intValue();
    L24:
        Integer r113 = Boxing.boxInt(r109);
        DoraVisionBizScene.a r114 = DoraVisionBizScene.Companion;
        Integer r115 = r210.f291832c;
        if (r115 == null) goto L27;
        int r116 = r115.intValue();
    L28:
        r114.getClass();
        DoraVisionBizScene r117 = DoraVisionBizScene.a.a(r116);
        if (r117 == null) goto L31;
        Integer r118 = Boxing.boxInt(r117.getValue());
    L32:
        b r119 = new b(r111, r107, r112, r113, r118, r210.f291833d);
        n1.d("SessionMemoryMode", "Reporting session memory with interval " + r210.f291836g + ", request: " + r119);
        SessionMemoryApi.a r120 = SessionMemoryApi.f291828a;
        SessionMemoryMode$reportSessionMemory$result$1 r121 = new SessionMemoryMode$reportSessionMemory$result$1(r119, null);
        r110.L$0 = r119;
        r110.label = 1;
        r120.getClass();
        FlowHttpConnection r122 = FlowHttpConnection.f359975a;
        Object r123 = FlowHttpConnection.g(ServiceType.AUDIO, SessionMemoryApi.class, r121, false, null, null, null, r110, 248);
        if (r123 == r103) goto L46;
        r105 = r119;
        r102 = r123;
        goto L36
    L46:
        return r103;
    L31:
        r118 = null;
        goto L32
    L27:
        r116 = 6;
        goto L28
    L17:
        IDoraService r124 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r124 == null) goto L22;
        DeviceService r125 = r124.device();
        if (r125 == null) goto L22;
        Integer r126 = Integer.valueOf(r125.y());
    L23:
        FlowDoraSubBizType.Companion.getClass();
        r109 = FlowDoraSubBizType.a.b(r126);
        r210.f291834e = Integer.valueOf(r109);
    L22:
        r126 = null;
    L7:
        r100 = new SessionMemoryMode$reportSessionMemory$1(r210, r211);
        goto L8
    }

    public SessionMemoryMode(String r100, String r101, Integer r102) {
        this.f291830a = r100;
        this.f291831b = r101;
        this.f291832c = r102;
        this.f291833d = null;
        this.f291835f = LazyKt.lazy(new com.larus.avlink.e.model.session_memory.a());
    }
}
