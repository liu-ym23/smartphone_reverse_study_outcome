package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import vg3.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/l;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.HeaderFloatVideoComponent$onAttach$2", f = "HeaderFloatVideoComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class HeaderFloatVideoComponent$onAttach$2 extends SuspendLambda implements Function3<CoroutineScope, vg3.l, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HeaderFloatVideoComponent this$0;

    public static final class a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ HeaderFloatVideoComponent$onAttach$2 a;

        public a(HeaderFloatVideoComponent$onAttach$2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r2) {
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.o r3 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.o) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            this.a.this$0.k = r3;
        }
    }

    public static final class b implements p {
        public final /* synthetic */ HeaderFloatVideoComponent$onAttach$2 a;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void A(boolean r1) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void a(boolean r1) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void c(boolean r1) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void d(boolean r1, int r2) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void e() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void f(boolean r1) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void h(boolean r1) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void j(int r1, ImageInfo r2, boolean r3, int r4) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void k() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void m() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void n(int r1, Boolean r2) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void onDestroy() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void onPageSelected(int r1) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void onPause() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void onResume() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void p(String r1) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void s() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void t() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void u() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void v() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void w(int r1) {
        }

        public b(HeaderFloatVideoComponent$onAttach$2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void i(float r3) {
            HeaderFloatVideoComponent r0 = this.a.this$0;
            if (r3 != 1.0f) goto L5;
            boolean r4 = true;
        L6:
            r0.n = r4;
            if (r0.j != null) goto L12;
            t r5 = r0.d2();
            if (r5 == null) goto L13;
            r5.g(this.a.this$0.n);
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r4 = false;
            goto L6
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void q(AnchorV4HeadV2VO r2) {
            Intrinsics.checkNotNullParameter(r2, "headVo");
            Intrinsics.checkNotNullParameter(r2, "headVo");
        }
    }

    public HeaderFloatVideoComponent$onAttach$2(HeaderFloatVideoComponent r1, Continuation r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, vg3.l r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "it");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        HeaderFloatVideoComponent$onAttach$2 r5 = new HeaderFloatVideoComponent$onAttach$2(this.this$0, r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (vg3.l) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r4);
        vg3.l r5 = (vg3.l) this.L$0;
        r5.G1(new AnonymousClass1(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(r5.L0(), this.this$0, new a(this));
        if (ECSettingKeys.A0().g() == false) goto L8;
        r5.x(new b(this));
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
