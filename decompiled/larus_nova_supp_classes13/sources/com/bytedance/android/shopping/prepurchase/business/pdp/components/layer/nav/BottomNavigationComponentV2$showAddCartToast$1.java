package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.shopping.anchorv4.dto.elements.ToastElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.m;
import com.bytedance.android.shopping.prepurchase.business.pdp.util.BottomNavigationToaster;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.BottomNavigationComponentV2$showAddCartToast$1", f = "BottomNavigationComponentV2.kt", i = {0}, l = {322, 329}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class BottomNavigationComponentV2$showAddCartToast$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $callback;
    final /* synthetic */ ToastElement $toastElement;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BottomNavigationComponentV2 this$0;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.BottomNavigationComponentV2$showAddCartToast$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/w;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.BottomNavigationComponentV2$showAddCartToast$1$1", f = "BottomNavigationComponentV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<CoroutineScope, w, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BottomNavigationComponentV2$showAddCartToast$1 this$0;

        public AnonymousClass1(BottomNavigationComponentV2$showAddCartToast$1 r1, Continuation r2) {
            this.this$0 = r1;
            super(3, r2);
        }

        public final Continuation<Unit> create(CoroutineScope r2, w r3, Continuation<? super Unit> r4) {
            Intrinsics.checkNotNullParameter(r2, "$this$create");
            Intrinsics.checkNotNullParameter(r3, "it");
            Intrinsics.checkNotNullParameter(r4, "continuation");
            AnonymousClass1 r5 = new AnonymousClass1(this.this$0, r4);
            r5.L$0 = r3;
            return r5;
        }

        public final Object invoke(Object r1, Object r2, Object r3) {
            return create((CoroutineScope) r1, (w) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r8);
            m.a.a(((w) this.L$0).m().d(this.this$0.$toastElement.getTrackParams()), "add_cart_toast_show", false, null, null, 12);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public BottomNavigationComponentV2$showAddCartToast$1(BottomNavigationComponentV2 r1, ToastElement r2, Function2 r3, Continuation r4) {
        this.this$0 = r1;
        this.$toastElement = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Intrinsics.checkNotNullParameter(r6, "completion");
        BottomNavigationComponentV2$showAddCartToast$1 r0 = new BottomNavigationComponentV2$showAddCartToast$1(this.this$0, this.$toastElement, this.$callback, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r4 = 1;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r20);
    L27:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r20);
    L13:
        BottomNavigationToaster r5 = (BottomNavigationToaster) this.this$0.p.getValue();
        FragmentActivity r6 = this.this$0.O1().getContainerAbility().mo2525getContext();
        ToastElement r13 = this.$toastElement;
        r5.getClass();
        if (r13 == null) goto L23;
        if (r6 == null) goto L23;
        LinearLayout r7 = new LinearLayout(r6);
        r7.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r7.setOrientation(1);
        r7.setGravity(17);
        TextWithOneIconElementView r15 = new TextWithOneIconElementView(r6, null, 0, null, 30);
        TextWithOneIconElementView.b(r15, r13.getContent(), null, false, null, 14);
        r7.addView(r15);
        Toast r8 = new Toast(r6);
        r8.setView(r7);
        r8.setGravity(17, 0, 0);
        Float r9 = r13.getDuration();
        if (r9 != null) goto L20;
    L21:
        r4 = 0;
    L22:
        r8.setDuration(r4);
        r8.show();
        goto L23
    L20:
        if (r9.floatValue() >= 2.5f) goto L22;
    L23:
        this.this$0.Z1(w.class, new AnonymousClass1(this, null));
        Function2 r10 = this.$callback;
        this.L$0 = null;
        this.label = 2;
        if (r10.invoke(r3, this) != r1) goto L27;
        return r1;
    L10:
        ResultKt.throwOnFailure(r20);
        r3 = (CoroutineScope) this.L$0;
        this.L$0 = r3;
        this.label = 1;
        if (DelayKt.delay(350, this) != r1) goto L13;
        return r1;
    }
}
