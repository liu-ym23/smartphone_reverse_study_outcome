package com.larus.av_call.component;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.av_call.service.DefaultRealtimeCallService;
import g88.h;
import g88.i;
import g88.j;
import g88.k;
import h88.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import t1a.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/larus/av_call/component/BaseRealtimeComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/ui/arch/context/external/VAbility;", "<init>", "()V", "argumentData", "Lcom/larus/av_call/model/BaseRealtimeArgumentData;", "getArgumentData", "()Lcom/larus/av_call/model/BaseRealtimeArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "runtimeData", "Lcom/larus/av_call/model/BaseRealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/av_call/model/BaseRealtimeRuntimeData;", "runtimeData$delegate", "callService", "Lcom/larus/av_call/service/DefaultRealtimeCallService;", "getCallService", "()Lcom/larus/av_call/service/DefaultRealtimeCallService;", "callService$delegate", "callParam", "Lcom/larus/audio/call/RealtimeCallParam;", "getCallParam", "()Lcom/larus/audio/call/RealtimeCallParam;", "callParam$delegate", "onVContextReady", "", "onResume", LiveCommonConstants.REASON_ON_DEDTROY, "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BaseRealtimeComponent extends RealtimeComponent implements a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f290486r = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f290487n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f290488o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f290489p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f290490q;

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void A0() {
        h88.a r100 = (h88.a) this.f290487n.getValue();
        b r101 = (b) this.f290488o.getValue();
        DefaultRealtimeCallService r102 = (DefaultRealtimeCallService) this.f290489p.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        RealtimeCallParam r100 = (RealtimeCallParam) this.f290490q.getValue();
        RealtimeCallParam.k r101 = r100.f288756p;
        r101.f288862j = ((b) this.f290488o.getValue()).f484274o;
        ((DefaultRealtimeCallService) this.f290489p.getValue()).e(r100);
        throw null;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        ((DefaultRealtimeCallService) this.f290489p.getValue()).d((RealtimeCallParam) this.f290490q.getValue());
        throw null;
    }

    public BaseRealtimeComponent() {
        this.f290487n = LazyKt.lazy(new h(this));
        this.f290488o = LazyKt.lazy(new i(this));
        this.f290489p = LazyKt.lazy(new j(this));
        this.f290490q = LazyKt.lazy(new k(this));
    }
}
