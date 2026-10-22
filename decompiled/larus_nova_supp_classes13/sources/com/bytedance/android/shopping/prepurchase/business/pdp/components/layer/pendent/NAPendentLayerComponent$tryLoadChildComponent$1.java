package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.anchorv4.components.ShopFloatEntryVO;
import com.bytedance.android.shopping.anchorv4.components.SmallVideoWindowVO;
import com.bytedance.android.shopping.anchorv4.dto.business.HeadMoreVideo;
import com.bytedance.android.shopping.anchorv4.floatwidget.replay.PlayBackEntryVO;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.container.component.Component;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
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
import vg3.b0;
import vg3.i0;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/a;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.NAPendentLayerComponent$tryLoadChildComponent$1", f = "NAPendentLayerComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NAPendentLayerComponent$tryLoadChildComponent$1 extends SuspendLambda implements Function3<CoroutineScope, vg3.a, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ m this$0;

    public static final class a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ NAPendentLayerComponent$tryLoadChildComponent$1 a;

        public a(NAPendentLayerComponent$tryLoadChildComponent$1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r5) {
            if (((PlayBackEntryVO) r5) == null) goto L10;
            m r6 = this.a.this$0;
            if (r6.n != null) goto L9;
            LivingIconComponent r0 = new LivingIconComponent();
            m r1 = this.a.this$0;
            View r2 = r1.e2();
            Intrinsics.checkNotNullParameter(r0, "component");
            Intrinsics.checkNotNullParameter(r2, "contentView");
            r1.d2().c(r0, r2);
            Unit r3 = Unit.INSTANCE;
            r6.n = r0;
            return;
        L9:
            return;
        }
    }

    public static final class b<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ NAPendentLayerComponent$tryLoadChildComponent$1 a;

        public b(NAPendentLayerComponent$tryLoadChildComponent$1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r6) {
            if (((HeadMoreVideo) r6) == null) goto L14;
            m r7 = this.a.this$0;
            if (r7.m != null) goto L12;
            MoreVideoComponent r0 = new MoreVideoComponent();
            m r1 = this.a.this$0;
            View r2 = r1.e2();
            if (r2 == null) goto L11;
            Component.a2(r1, (ViewGroup) r2, r0, null, 12);
            Unit r3 = Unit.INSTANCE;
            r7.m = r0;
            return;
        L11:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        L12:
            return;
        }
    }

    public static final class c<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ NAPendentLayerComponent$tryLoadChildComponent$1 a;

        public c(NAPendentLayerComponent$tryLoadChildComponent$1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r5) {
            if (((SmallVideoWindowVO) r5) == null) goto L10;
            m r6 = this.a.this$0;
            if (r6.r != null) goto L9;
            com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.b r0 = new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.b();
            m r1 = this.a.this$0;
            View r2 = r1.e2();
            Intrinsics.checkNotNullParameter(r0, "component");
            Intrinsics.checkNotNullParameter(r2, "contentView");
            r1.d2().c(r0, r2);
            Unit r3 = Unit.INSTANCE;
            r6.r = r0;
            return;
        L9:
            return;
        }
    }

    public static final class d<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ NAPendentLayerComponent$tryLoadChildComponent$1 a;

        public d(NAPendentLayerComponent$tryLoadChildComponent$1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r6) {
            if (((ShopFloatEntryVO) r6) == null) goto L23;
            m r7 = this.a.this$0;
            if (r7.p != null) goto L19;
            ShopFloatEntryComponent r0 = new ShopFloatEntryComponent();
            m r1 = this.a.this$0;
            View r2 = r1.e2();
            if (r2 == null) goto L18;
            Component.a2(r1, (ViewGroup) r2, r0, null, 12);
            Unit r3 = Unit.INSTANCE;
            r7.p = r0;
            QuestionnaireEntranceComponent r8 = this.a.this$0.q;
            if (r8 != null) goto L12;
            return;
        L12:
            if (r8.m != null) goto L14;
        L16:
            r8.h2();
            return;
        L14:
            if (r8.e2().getVisibility() != 0) goto L16;
            r8.i2();
            return;
        L18:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        L19:
            return;
        }
    }

    public static final class e<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ NAPendentLayerComponent$tryLoadChildComponent$1 a;

        public e(NAPendentLayerComponent$tryLoadChildComponent$1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r6) {
            if (((l73.c) r6) == null) goto L23;
            m r7 = this.a.this$0;
            if (r7.q != null) goto L12;
            QuestionnaireEntranceComponent r0 = new QuestionnaireEntranceComponent();
            m r1 = this.a.this$0;
            View r2 = r1.e2();
            if (r2 == null) goto L11;
            Component.a2(r1, (ViewGroup) r2, r0, null, 12);
            Unit r3 = Unit.INSTANCE;
            r7.q = r0;
            goto L12
        L11:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        L12:
            QuestionnaireEntranceComponent r8 = this.a.this$0.q;
            if (r8 != null) goto L15;
            return;
        L15:
            if (r8.m != null) goto L17;
        L19:
            r8.h2();
            return;
        L17:
            if (r8.e2().getVisibility() != 0) goto L19;
            r8.i2();
            return;
        }
    }

    public NAPendentLayerComponent$tryLoadChildComponent$1(m r1, Continuation r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, vg3.a r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "it");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        NAPendentLayerComponent$tryLoadChildComponent$1 r5 = new NAPendentLayerComponent$tryLoadChildComponent$1(this.this$0, r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (vg3.a) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r11);
        vg3.a r3 = (vg3.a) this.L$0;
        m r12 = this.this$0;
        int r1 = m.s;
        w r4 = (w) r12.N1(w.class);
        vg3.l r5 = (vg3.l) this.this$0.N1(vg3.l.class);
        i0 r6 = (i0) this.this$0.N1(i0.class);
        m r13 = this.this$0;
        View r0 = r13.e2();
        if (r0 == null) goto L16;
        AbsComponent.Y1(r13, b0.class, new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.i(r13, (ViewGroup) r0, r3, r4, r5, r6), false, 12);
        m r14 = this.this$0;
        HeaderFloatVideoComponent r2 = new HeaderFloatVideoComponent();
        r14.getClass();
        Intrinsics.checkNotNullParameter(r2, "service");
        r14.d2().d(r2);
        PdpDataStore r15 = this.this$0.O1().d().getData();
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) r15.m.getValue(), this.this$0, new a(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) r15.n.getValue(), this.this$0, new b(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) r15.t.getValue(), this.this$0, new c(this));
        m r7 = this.this$0;
        if (r7.o != null) goto L13;
        BackToTopEntryComponent r8 = new BackToTopEntryComponent();
        m r9 = this.this$0;
        View r10 = r9.e2();
        if (r10 == null) goto L12;
        Component.a2(r9, (ViewGroup) r10, r8, null, 12);
        Unit r16 = Unit.INSTANCE;
        r7.o = r8;
        goto L13
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L13:
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) r15.q.getValue(), this.this$0, new d(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) r15.s.getValue(), this.this$0, new e(this));
        return Unit.INSTANCE;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
