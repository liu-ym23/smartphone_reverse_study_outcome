package com.larus.dora.impl.onboarding.g.v2.base;

import android.content.Context;
import com.larus.dora.impl.onboarding.g.v2.viewmodel.LLMCallEvent;
import com.larus.dora.impl.onboarding.g.v2.viewmodel.z;
import com.larus.nova.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import t19.s;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraGOnboardingUiStateBaseFragment$onViewCreated$1$6$1<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraGOnboardingUiStateBaseFragment f336706a;

    public DoraGOnboardingUiStateBaseFragment$onViewCreated$1$6$1(DoraGOnboardingUiStateBaseFragment r100) {
        this.f336706a = r100;
    }

    public final Object a(z r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof DoraGOnboardingUiStateBaseFragment$onViewCreated$1$6$1$emit$1) == false) goto L7;
        DoraGOnboardingUiStateBaseFragment$onViewCreated$1$6$1$emit$1 r100 = (DoraGOnboardingUiStateBaseFragment$onViewCreated$1$6$1$emit$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L20;
        if (r103 == 1) goto L19;
        if (r103 == 2) goto L18;
        if (r103 == 3) goto L17;
        if (r103 == 4) goto L17;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r110 = (z) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L74:
        if (((z.a) r110).f336835a == LLMCallEvent.REPLY) goto L77;
        this.f336706a.ga0().forceWaitingState();
    L77:
        return Unit.INSTANCE;
    L18:
        r110 = (z) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L61:
        z.a r113 = (z.a) r110;
        if (r113.f336835a == LLMCallEvent.FINISH) goto L74;
        if (CollectionsKt.listOf(new LLMCallEvent[]{LLMCallEvent.WEAR, LLMCallEvent.LINK, LLMCallEvent.INVALID}).contains(r113.f336835a) == false) goto L69;
        r100.L$0 = r110;
        r100.label = 3;
        if (DelayKt.delay(600, r100) != r102) goto L74;
        return r102;
    L69:
        if (r113.f336835a != LLMCallEvent.NEXT) goto L74;
        r100.L$0 = r110;
        r100.label = 4;
        if (DelayKt.delay(100, r100) != r102) goto L74;
        return r102;
    L19:
        r110 = (z) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L49:
        DoraGOnboardingUiStateBaseFragment r114 = this.f336706a;
        r100.L$0 = r110;
        r100.label = 2;
        r114.ma0();
        if (Unit.INSTANCE != r102) goto L61;
        return r102;
    L20:
        ResultKt.throwOnFailure(r112);
        com.larus.dora.impl.onboarding.g.v2.f r115 = this.f336706a.ma0();
        if (r115 != null) goto L23;
    L25:
        boolean r116 = false;
    L27:
        if (r116 == false) goto L31;
        g49.d.d("DoraGOnboardingUiStateBaseFragment", "cur state don't handle llm");
        return Unit.INSTANCE;
    L31:
        if ((r110 instanceof z.a) == true) goto L34;
        g49.d.d("DoraGOnboardingUiStateBaseFragment", "event is not LLMCallEventState.State");
        return Unit.INSTANCE;
    L34:
        g49.d.d("DoraGOnboardingUiStateBaseFragment", "llm call event shared " + r110);
        z.a r117 = (z.a) r110;
        LLMCallEvent r104 = r117.f336835a;
        LLMCallEvent r105 = LLMCallEvent.NET;
        if (r104 != r105) goto L38;
        s r106 = s.f544207a;
        Context r107 = this.f336706a.getContext();
        r106.getClass();
        s.b(r107, R.string.larus_aiPodcast_internet_error_cn, false);
    L38:
        if (CollectionsKt.listOf(new LLMCallEvent[]{r105, LLMCallEvent.INVALID, LLMCallEvent.WEAR, LLMCallEvent.LINK}).contains(r117.f336835a) == false) goto L44;
        DoraGOnboardingUiStateBaseFragment r118 = this.f336706a;
        com.larus.dora.impl.onboarding.g.v2.f r108 = r118.ma0();
        if (r108 == null) goto L61;
        com.larus.dora.impl.onboarding.g.v2.f r109 = r108.d();
        if (r109 == null) goto L61;
        r109.b();
        r118.pa0(r109);
        goto L61
    L44:
        LLMCallEvent r119 = r117.f336835a;
        if (r119 != LLMCallEvent.REPLY) goto L53;
        r100.L$0 = r110;
        r100.label = 1;
        if (DelayKt.delay(2000, r100) != r102) goto L49;
        return r102;
    L53:
        if (r119 != LLMCallEvent.FINISH) goto L61;
        DoraGOnboardingUiStateBaseFragment r120 = this.f336706a;
        com.larus.dora.impl.onboarding.g.v2.f r121 = r120.ma0();
        if (r121 == null) goto L57;
        com.larus.dora.impl.onboarding.g.v2.f r122 = r121.g();
    L58:
        if (r122 == null) goto L60;
        r122.b();
    L60:
        r120.pa0(r122);
        goto L61
    L57:
        r122 = null;
        goto L58
    L23:
        if (r115.f() == true) goto L25;
        r116 = true;
    L7:
        r100 = new DoraGOnboardingUiStateBaseFragment$onViewCreated$1$6$1$emit$1(this, r111);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
        return a((z) r100, r101);
    }
}
