package com.obric.assistant.chat.component.interaction;

import android.view.View;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ability.interaction.IRealtimeCallBridgeAbility;
import com.obric.assistant.audio.service.ObricRealtimeCallStateServiceDelegate;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001\u001eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0002R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/chat/component/interaction/RealtimeCallBridgeComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/obric/assistant/ability/interaction/IRealtimeCallBridgeAbility;", "<init>", "()V", "realtimeActionFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "getRealtimeActionFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "obricVoiceService", "Lcom/obric/assistant/audio/service/ObricRealtimeCallStateServiceDelegate;", "getObricVoiceService", "()Lcom/obric/assistant/audio/service/ObricRealtimeCallStateServiceDelegate;", "obricVoiceService$delegate", "Lkotlin/Lazy;", "muteFun", "Lkotlin/Function0;", "", "unMuteFun", "endCallFun", "onAttach", LiveCommonConstants.REASON_ON_DEDTROY, "onViewCreated", "view", "Landroid/view/View;", "muteRealtimeCall", "unMuteRealtimeCall", "endCall", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallBridgeComponent extends BaseContentWidget implements IRealtimeCallBridgeAbility {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f386842r = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MutableSharedFlow<Integer> f386843m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f386844n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public b f386845o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c f386846p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d f386847q;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        FLogger.f375446a.d("RealtimeCallBridgeComponent", LiveCommonConstants.REASON_ON_DEDTROY);
        ((ObricRealtimeCallStateServiceDelegate) this.f386844n.getValue()).b(this.f386845o, this.f386846p, this.f386847q);
        this.f386845o = null;
        this.f386846p = null;
        this.f386847q = null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.assistant.chat.component.interaction.b] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.assistant.chat.component.interaction.c] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.obric.assistant.chat.component.interaction.d] */
    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        FLogger.f375446a.d("RealtimeCallBridgeComponent", "onAttach");
        this.f386845o = new b(this);
        this.f386846p = new c(this);
        this.f386847q = new d(this);
        ((ObricRealtimeCallStateServiceDelegate) this.f386844n.getValue()).a(this.f386845o, this.f386846p, this.f386847q);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, IRealtimeCallBridgeAbility.class);
    }

    public RealtimeCallBridgeComponent() {
        this.f386843m = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f386844n = LazyKt.lazy(new e());
    }

    @Override // com.obric.assistant.ability.interaction.IRealtimeCallBridgeAbility
    public final MutableSharedFlow<Integer> fS() {
        return this.f386843m;
    }
}
