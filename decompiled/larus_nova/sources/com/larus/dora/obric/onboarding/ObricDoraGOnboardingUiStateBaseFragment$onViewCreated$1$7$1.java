package com.larus.dora.obric.onboarding;

import android.content.Context;
import com.larus.nova.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$1$7$1<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObricDoraGOnboardingUiStateBaseFragment f340778a;

    public ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$1$7$1(ObricDoraGOnboardingUiStateBaseFragment r100) {
        this.f340778a = r100;
    }

    public final Object a(g r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$1$7$1$emit$1) == false) goto L7;
        ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$1$7$1$emit$1 r100 = (ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$1$7$1$emit$1) r111;
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
        r110 = (g) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L101:
        if (((g.a) r110).f340856a == LLMCallEvent.REPLY) goto L104;
        this.f340778a.ga0().forceWaitingState();
    L104:
        return Unit.INSTANCE;
    L18:
        r110 = (g) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L88:
        g.a r113 = (g.a) r110;
        if (r113.f340856a == LLMCallEvent.FINISH) goto L101;
        if (CollectionsKt.listOf(new LLMCallEvent[]{LLMCallEvent.WEAR, LLMCallEvent.LINK, LLMCallEvent.INVALID}).contains(r113.f340856a) == false) goto L96;
        r100.L$0 = r110;
        r100.label = 3;
        if (DelayKt.delay(600, r100) != r102) goto L101;
        return r102;
    L96:
        if (r113.f340856a != LLMCallEvent.NEXT) goto L101;
        r100.L$0 = r110;
        r100.label = 4;
        if (DelayKt.delay(100, r100) != r102) goto L101;
        return r102;
    L19:
        r110 = (g) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L82:
        ObricDoraGOnboardingUiStateBaseFragment r114 = this.f340778a;
        r100.L$0 = r110;
        r100.label = 2;
        r114.pa0();
        if (Unit.INSTANCE != r102) goto L88;
        return r102;
    L20:
        ResultKt.throwOnFailure(r112);
        if ((this.f340778a.pa0() instanceof x) == true) goto L23;
    L35:
        p r115 = this.f340778a.pa0();
        if ((r115 instanceof t) == false) goto L38;
        t r116 = (t) r115;
    L39:
        if (r116 == null) goto L47;
        if ((r110 instanceof g.a) == false) goto L47;
        if (((g.a) r110).f340856a != LLMCallEvent.FINISH) goto L47;
        g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "ignore llm finish in long press wakeup state");
        return Unit.INSTANCE;
    L47:
        if ((this.f340778a.pa0() instanceof q) == true) goto L49;
    L58:
        p r117 = this.f340778a.pa0();
        if (r117 != null) goto L61;
    L63:
        boolean r118 = false;
    L64:
        if (r118 == false) goto L68;
        g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "cur state don't handle llm");
        return Unit.INSTANCE;
    L68:
        if ((r110 instanceof g.a) == true) goto L71;
        g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "event is not LLMCallEventState.State");
        return Unit.INSTANCE;
    L71:
        g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "llm call event shared " + r110);
        g.a r119 = (g.a) r110;
        LLMCallEvent r104 = r119.f340856a;
        LLMCallEvent r105 = LLMCallEvent.NET;
        if (r104 != r105) goto L75;
        t19.s r106 = t19.s.f544207a;
        Context r107 = this.f340778a.getContext();
        r106.getClass();
        t19.s.b(r107, R.string.larus_aiPodcast_internet_error_cn, false);
    L75:
        if (CollectionsKt.listOf(new LLMCallEvent[]{r105, LLMCallEvent.INVALID, LLMCallEvent.WEAR, LLMCallEvent.LINK}).contains(r119.f340856a) == false) goto L77;
        this.f340778a.pa0();
        goto L88
    L77:
        LLMCallEvent r120 = r119.f340856a;
        if (r120 != LLMCallEvent.REPLY) goto L86;
        r100.L$0 = r110;
        r100.label = 1;
        if (DelayKt.delay(2000, r100) != r102) goto L82;
        return r102;
    L86:
        if (r120 != LLMCallEvent.FINISH) goto L88;
        this.f340778a.ra0();
        goto L88
    L61:
        if (r117.d() == true) goto L63;
        r118 = true;
        goto L64
    L49:
        if ((r110 instanceof g.a) == false) goto L58;
        LLMCallEvent r121 = ((g.a) r110).f340856a;
        if (r121 != LLMCallEvent.WEAR) goto L55;
        g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "llm call interrupted by wear state in click stop state, goto next");
        this.f340778a.ra0();
        this.f340778a.ga0().forceWaitingState();
        return Unit.INSTANCE;
    L55:
        if (r121 != LLMCallEvent.FINISH) goto L58;
        g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "llm call finished in click stop state, goto next");
        this.f340778a.ra0();
        this.f340778a.ga0().forceWaitingState();
        return Unit.INSTANCE;
    L38:
        r116 = null;
        goto L39
    L23:
        if ((r110 instanceof g.a) == false) goto L35;
        if (((g.a) r110).f340856a != LLMCallEvent.QUERY_END) goto L35;
        ObricDoraGOnboardingUiStateBaseFragment r122 = this.f340778a;
        if (r122.f340765t == true) goto L29;
    L32:
        g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "ignore video query query end, isLlmCallStarted=" + r122.f340765t + ", current=" + ObricDoraGOnboardingUiStateBaseFragment.na0(r122.pa0()));
    L34:
        return Unit.INSTANCE;
    L29:
        if ((r122.pa0() instanceof x) == false) goto L32;
        g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "query end in video query state, goto next");
        r122.ra0();
    L7:
        r100 = new ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$1$7$1$emit$1(this, r111);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
        return a((g) r100, r101);
    }
}
