package com.bytedance.ee.bear.container;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.dependency.LoadingLayoutScope;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.log.Log;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.container.ContainerFragment$collect$1", f = "ContainerFragment.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
final class ContainerFragment$collect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ContainerFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ContainerFragment a;

        public a(ContainerFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r14, Continuation r16) {
            w r17 = (w) r14;
            Log.i(this.a.e, "==openDocs==container== " + r17);
            d r18 = r17.c;
            FrameLayout r3 = null;
            if (r18 == null) goto L27;
            if (Intrinsics.areEqual(r18, this.a.m) == true) goto L27;
            ContainerFragment r19 = this.a;
            d r4 = r17.c;
            r19.m = r4;
            yx4.d r5 = r4.a;
            if (r5 != null) goto L9;
            r5 = r19.p.b();
        L9:
            yx4.d r6 = r19.l;
            if (r6 == r5) goto L27;
            if (r6 == null) goto L14;
            r6.hideLoading();
        L14:
            yx4.d r7 = r19.l;
            if (r7 == null) goto L17;
            r7.detachLoadingView();
        L17:
            FrameLayout r8 = r19.h;
            if (r8 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("containerContentLoading");
            r8 = null;
        L20:
            r8.setVisibility(8);
            FrameLayout r9 = r19.i;
            if (r9 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("containerFullLoading");
            r9 = null;
        L23:
            r9.setVisibility(8);
            r19.l = r5;
            if (r5 == null) goto L27;
            r5.attachLoadingView(r19.U90());
        L27:
            if (r17.e == null) goto L33;
            FragmentTransaction r110 = this.a.getChildFragmentManager().beginTransaction();
            Fragment r10 = r17.e.a;
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r110, r10, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131367752) == true) goto L32;
            r110 = r110.replace(2131367752, r10);
        L32:
            r110.commitAllowingStateLoss();
        L33:
            e r111 = r17.b;
            boolean r11 = true;
            if (r111 != null) goto L36;
        L38:
            boolean r112 = false;
        L39:
            if (r112 == true) goto L41;
        L43:
            boolean r113 = false;
        L45:
            if (r17.d != null) goto L47;
        L49:
            boolean r12 = false;
        L50:
            View r13 = this.a.o;
            if (r13 == null) goto L58;
            if (r113 == true) goto L56;
            if (r12 == true) goto L56;
            int r20 = 8;
        L57:
            r13.setVisibility(r20);
        L56:
            r20 = 0;
        L58:
            if (r113 == false) goto L67;
            if (r12 == true) goto L67;
            yx4.d r21 = this.a.l;
            if (r21 == null) goto L63;
            LoadingLayoutScope r22 = r21.getScope();
        L65:
            if (r22 != LoadingLayoutScope.FULL_CONTAINER) goto L67;
            boolean r23 = true;
        L69:
            if (r23 == true) goto L83;
            g r24 = r17.a;
            if (r24 != null) goto L73;
        L75:
            r11 = false;
        L76:
            if (r11 == false) goto L83;
            ContainerFragment r26 = this.a;
            FrameLayout r27 = r26.g;
            if (r27 != null) goto L80;
            Intrinsics.throwUninitializedPropertyAccessException("containerTitleBar");
            r27 = null;
        L80:
            r27.setVisibility(0);
            yx4.e r28 = r26.k;
            if (r28 == null) goto L89;
            r28.a();
        L89:
            if (r113 == false) goto L94;
            if (r12 == true) goto L94;
            ContainerFragment r114 = this.a;
            r114.U90().setVisibility(0);
            yx4.d r115 = r114.l;
            if (r115 == null) goto L103;
            r115.showLoading();
        L103:
            c r116 = r17.d;
            if (r116 == null) goto L112;
            ContainerFragment r0 = this.a;
            String r29 = r116.a;
            int r30 = r116.b;
            Integer r31 = r116.c;
            String r117 = r116.d;
            Function0<Unit> r118 = r116.e;
            FrameLayout r119 = r0.j;
            if (r119 != null) goto L108;
            Intrinsics.throwUninitializedPropertyAccessException("containerError");
        L109:
            r3.setVisibility(0);
            yx4.c r120 = r0.n;
            if (r120 == null) goto L120;
            r120.b(new yx4.f(r29, r30, r31, r117, null, r118));
        L120:
            return Unit.INSTANCE;
        L108:
            r3 = r119;
            goto L109
        L112:
            ContainerFragment r121 = this.a;
            FrameLayout r1 = r121.j;
            if (r1 != null) goto L115;
            Intrinsics.throwUninitializedPropertyAccessException("containerError");
        L116:
            r3.setVisibility(8);
            yx4.c r122 = r121.n;
            if (r122 == null) goto L120;
            r122.hideError();
            goto L120
        L115:
            r3 = r1;
        L94:
            ContainerFragment r123 = this.a;
            FrameLayout r32 = r123.h;
            if (r32 != null) goto L97;
            Intrinsics.throwUninitializedPropertyAccessException("containerContentLoading");
            r32 = null;
        L97:
            r32.setVisibility(8);
            FrameLayout r2 = r123.i;
            if (r2 != null) goto L100;
            Intrinsics.throwUninitializedPropertyAccessException("containerFullLoading");
            r2 = null;
        L100:
            r2.setVisibility(8);
            yx4.d r124 = r123.l;
            if (r124 == null) goto L103;
            r124.hideLoading();
            goto L103
        L73:
            if (r24.a != true) goto L75;
        L83:
            ContainerFragment r33 = this.a;
            FrameLayout r34 = r33.g;
            if (r34 != null) goto L86;
            Intrinsics.throwUninitializedPropertyAccessException("containerTitleBar");
            r34 = null;
        L86:
            r34.setVisibility(8);
            yx4.e r36 = r33.k;
            if (r36 == null) goto L89;
            r36.x();
            goto L89
        L63:
            r22 = null;
        L67:
            r23 = false;
            goto L69
        L47:
            if (this.a.n == null) goto L49;
            r12 = true;
            goto L50
        L41:
            if (this.a.l == null) goto L43;
            r113 = true;
            goto L45
        L36:
            if (r111.a != true) goto L38;
            r112 = true;
            goto L39
        }
    }

    public ContainerFragment$collect$1(ContainerFragment r1, Continuation<? super ContainerFragment$collect$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ContainerFragment$collect$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        i1<w> r6 = ((ContainerViewModel) this.this$0.r.getValue()).getState();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
