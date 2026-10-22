package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.SwitchKt$Switch$1$1", f = "Switch.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {})
public final class SwitchKt$Switch$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnchoredDraggableState<Boolean> $anchoredDraggableState;
    final /* synthetic */ State<Boolean> $currentChecked$delegate;
    final /* synthetic */ State<Function1<Boolean, Unit>> $currentOnCheckedChange$delegate;
    final /* synthetic */ MutableState<Boolean> $forceAnimationCheck$delegate;
    int label;

    /* JADX INFO: renamed from: androidx.compose.material.SwitchKt$Switch$1$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "newValue", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.SwitchKt$Switch$1$1$2", f = "Switch.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ State<Boolean> $currentChecked$delegate;
        final /* synthetic */ State<Function1<Boolean, Unit>> $currentOnCheckedChange$delegate;
        final /* synthetic */ MutableState<Boolean> $forceAnimationCheck$delegate;
        /* synthetic */ boolean Z$0;
        int label;

        public AnonymousClass2(State<Boolean> r1, State<? extends Function1<? super Boolean, Unit>> r2, MutableState<Boolean> r3, Continuation<? super AnonymousClass2> r4) {
            this.$currentChecked$delegate = r1;
            this.$currentOnCheckedChange$delegate = r2;
            this.$forceAnimationCheck$delegate = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$currentChecked$delegate, this.$currentOnCheckedChange$delegate, this.$forceAnimationCheck$delegate, r6);
            r0.Z$0 = ((Boolean) r5).booleanValue();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
        }

        public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
            return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L13;
            ResultKt.throwOnFailure(r2);
            boolean r3 = this.Z$0;
            if (SwitchKt.access$Switch$lambda$11(this.$currentChecked$delegate) == r3) goto L11;
            Function1 r0 = SwitchKt.access$Switch$lambda$10(this.$currentOnCheckedChange$delegate);
            if (r0 == null) goto L9;
            r0.invoke(Boxing.boxBoolean(r3));
        L9:
            MutableState<Boolean> r4 = this.$forceAnimationCheck$delegate;
            SwitchKt.access$Switch$lambda$4(r4, !SwitchKt.access$Switch$lambda$3(r4));
        L11:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public SwitchKt$Switch$1$1(AnchoredDraggableState<Boolean> r1, State<Boolean> r2, State<? extends Function1<? super Boolean, Unit>> r3, MutableState<Boolean> r4, Continuation<? super SwitchKt$Switch$1$1> r5) {
        this.$anchoredDraggableState = r1;
        this.$currentChecked$delegate = r2;
        this.$currentOnCheckedChange$delegate = r3;
        this.$forceAnimationCheck$delegate = r4;
        super(2, r5);
    }

    public static /* synthetic */ boolean a(AnchoredDraggableState r0) {
        return invokeSuspend$lambda$0(r0);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SwitchKt$Switch$1$1(this.$anchoredDraggableState, this.$currentChecked$delegate, this.$currentOnCheckedChange$delegate, this.$forceAnimationCheck$delegate, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    private static final boolean invokeSuspend$lambda$0(AnchoredDraggableState r0) {
        return ((Boolean) r0.getCurrentValue()).booleanValue();
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        final AnchoredDraggableState<Boolean> r9 = this.$anchoredDraggableState;
        Flow r10 = SnapshotStateKt.snapshotFlow(new ac(r9));
        AnonymousClass2 r2 = new AnonymousClass2(this.$currentChecked$delegate, this.$currentOnCheckedChange$delegate, this.$forceAnimationCheck$delegate, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r10, r2, this) != r0) goto L12;
        return r0;
    }
}
