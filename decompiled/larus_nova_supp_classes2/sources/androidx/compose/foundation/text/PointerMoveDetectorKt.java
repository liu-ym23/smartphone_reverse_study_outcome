package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0080@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"detectMoves", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "pointerEventPass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "onMove", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PointerMoveDetectorKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2", f = "PointerMoveDetector.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Offset, Unit> $onMove;
        final /* synthetic */ PointerEventPass $pointerEventPass;
        final /* synthetic */ PointerInputScope $this_detectMoves;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2$1", f = "PointerMoveDetector.kt", i = {0, 0}, l = {44}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "previousPosition"}, s = {"L$0", "L$1"})
        public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineContext $currentContext;
            final /* synthetic */ Function1<Offset, Unit> $onMove;
            final /* synthetic */ PointerEventPass $pointerEventPass;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            public AnonymousClass1(CoroutineContext r1, PointerEventPass r2, Function1<? super Offset, Unit> r3, Continuation<? super AnonymousClass1> r4) {
                this.$currentContext = r1;
                this.$pointerEventPass = r2;
                this.$onMove = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
                AnonymousClass1 r0 = new AnonymousClass1(this.$currentContext, this.$pointerEventPass, this.$onMove, r6);
                r0.L$0 = r5;
                return r0;
            }

            public final Object invoke(AwaitPointerEventScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((AwaitPointerEventScope) r1, (Continuation) r2);
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0048 -> B:15:0x004e). Please report as a decompilation issue!!! */
            public final Object invokeSuspend(Object r10) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                Ref.ObjectRef r2 = (Ref.ObjectRef) this.L$1;
                AwaitPointerEventScope r3 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(r10);
                AwaitPointerEventScope r4 = r3;
                Ref.ObjectRef r5 = r2;
                Object r6 = r0;
                AnonymousClass1 r7 = this;
            L15:
                PointerEvent r11 = (PointerEvent) r10;
                int r8 = r11.getType-7fucELk();
                PointerEventType.Companion r9 = PointerEventType.Companion;
                if (PointerEventType.equals-impl0(r8, r9.getMove-7fucELk()) == false) goto L18;
            L21:
                Offset r12 = Offset.box-impl(((PointerInputChange) CollectionsKt.first(r11.getChanges())).getPosition-F1C5BW0());
                if (Offset.equals-impl(r12.unbox-impl(), r5.element) == false) goto L25;
                r12 = null;
            L25:
                if (r12 == null) goto L27;
                Function1<Offset, Unit> r13 = r7.$onMove;
                long r14 = r12.unbox-impl();
                r5.element = Offset.box-impl(r14);
                r13.invoke(Offset.box-impl(r14));
            L27:
                AnonymousClass1 r15 = r7;
                r0 = r6;
                Ref.ObjectRef r16 = r5;
                AwaitPointerEventScope r17 = r4;
            L10:
                if (JobKt.isActive(r15.$currentContext) == false) goto L29;
                PointerEventPass r18 = r15.$pointerEventPass;
                r15.L$0 = r17;
                r15.L$1 = r16;
                r15.label = 1;
                Object r19 = r17.awaitPointerEvent(r18, r15);
                if (r19 != r0) goto L14;
                return r0;
            L14:
                Object r20 = r0;
                r7 = r15;
                r10 = r19;
                r4 = r17;
                r5 = r16;
                r6 = r20;
                goto L15
            L29:
                return Unit.INSTANCE;
            L18:
                if (PointerEventType.equals-impl0(r8, r9.getEnter-7fucELk()) == true) goto L21;
                if (PointerEventType.equals-impl0(r8, r9.getExit-7fucELk()) == false) goto L27;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r10);
                AwaitPointerEventScope r110 = (AwaitPointerEventScope) this.L$0;
                r16 = new Ref.ObjectRef();
                r17 = r110;
                r15 = this;
                goto L10
            }
        }

        public AnonymousClass2(PointerInputScope r1, PointerEventPass r2, Function1<? super Offset, Unit> r3, Continuation<? super AnonymousClass2> r4) {
            this.$this_detectMoves = r1;
            this.$pointerEventPass = r2;
            this.$onMove = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass2(this.$this_detectMoves, this.$pointerEventPass, this.$onMove, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
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
            CoroutineContext r9 = getContext();
            PointerInputScope r2 = this.$this_detectMoves;
            AnonymousClass1 r3 = new AnonymousClass1(r9, this.$pointerEventPass, this.$onMove, null);
            this.label = 1;
            if (r2.awaitPointerEventScope(r3, this) != r0) goto L12;
            return r0;
        }
    }

    public static final Object detectMoves(PointerInputScope r2, PointerEventPass r3, Function1<? super Offset, Unit> r4, Continuation<? super Unit> r5) {
        Object r6 = CoroutineScopeKt.coroutineScope(new AnonymousClass2(r2, r3, r4, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectMoves$default(PointerInputScope r0, PointerEventPass r1, Function1 r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = PointerEventPass.Initial;
    L6:
        return detectMoves(r0, r1, r2, r3);
    }
}
