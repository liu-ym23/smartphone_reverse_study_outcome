package com.obric.assistant.realtimecall.plugin;

import com.larus.audio.call.arch.c;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.mgr.f;
import com.larus.av_call.service.IRealtimeCallConfigDependency;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.ObricRealtimeCallStateServiceDelegate;
import com.obric.assistant.state.api.multitask.ObricRealtimeCallStateProducerServiceDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
public final class RealtimeCallAssistStatePlugin extends com.larus.audio.call.arch.a<c> implements f.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f391213f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f391214g;

    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        super.e3();
        FLogger r100 = FLogger.f375446a;
        String r101 = this.f391213f;
        StringBuilder r102 = new StringBuilder("onStart, ");
        r102.append(getContext().params().G);
        r102.append(", isScreenShareEnable: ");
        IRealtimeCallConfigDependency r103 = (IRealtimeCallConfigDependency) ServiceManager.get().getService(IRealtimeCallConfigDependency.class);
        if (r103 == null) goto L5;
        Boolean r104 = Boolean.valueOf(r103.g());
    L6:
        r102.append(r104);
        r102.append(", isVideoEnable: ");
        IRealtimeCallConfigDependency r105 = (IRealtimeCallConfigDependency) ServiceManager.get().getService(IRealtimeCallConfigDependency.class);
        if (r105 == null) goto L9;
        Boolean r106 = Boolean.valueOf(r105.e());
    L10:
        r102.append(r106);
        r102.append(", isRTC: ");
        IRealtimeCallConfigDependency r107 = (IRealtimeCallConfigDependency) ServiceManager.get().getService(IRealtimeCallConfigDependency.class);
        if (r107 == null) goto L13;
        Boolean r108 = Boolean.valueOf(r107.i());
    L14:
        r102.append(r108);
        r100.i(r101, r102.toString());
        getContext().a().M0(this);
        ((ObricRealtimeCallStateServiceDelegate) this.f391214g.getValue()).start();
        ObricRealtimeCallStateProducerServiceDelegate.f392945b.g(j3(), k3());
        CoroutineScope r109 = getContext().r();
        if (r109 == null) goto L18;
        BuildersKt.launch$default(r109, null, null, new RealtimeCallAssistStatePlugin$onStart$1(this, null), 3, null);
        return;
    L18:
        return;
    L13:
        r108 = null;
        goto L14
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.larus.audio.call.arch.a
    public final void g3() {
        super.g3();
        FLogger.f375446a.i(this.f391213f, "onStop, " + getContext().params().G);
        getContext().a().V(this);
        ((ObricRealtimeCallStateServiceDelegate) this.f391214g.getValue()).stop();
        ObricRealtimeCallStateProducerServiceDelegate.f392945b.e(j3(), k3());
    }

    public final String j3() {
        String r100 = getContext().params().f288745e;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String k3() {
        return getContext().params().G;
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return this.f391213f;
    }

    public RealtimeCallAssistStatePlugin(c r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f391213f = "RealtimeCallAssistStatePlugin";
        this.f391214g = LazyKt.lazy(new a());
    }

    @Override // com.larus.audio.call.mgr.f.a
    public final void Q(MajorState r100, MajorState r101) {
        Intrinsics.checkNotNullParameter(r100, "prev");
        Intrinsics.checkNotNullParameter(r101, "current");
        FLogger.f375446a.i(this.f391213f, "onStateChanged, prev=" + r100 + ", current=" + r101 + ", cvsId: " + getContext().params().G + ", " + getContext().params().f288752l.f288787c);
        ((ObricRealtimeCallStateServiceDelegate) this.f391214g.getValue()).c(r100, r101);
        ObricRealtimeCallStateProducerServiceDelegate.f392945b.b(j3(), k3(), r100.f289171a, r101.f289171a);
    }
}
