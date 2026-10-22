package androidx.compose.foundation.text.contextmenu.gestures;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0080@¢\u0006\u0002\u0010\u0006\u001a\u0012\u0010\u0007\u001a\u00020\b*\u00020\tH\u0082@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"onRightClickDown", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDown", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstRightClickDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RightClickGesturesKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.contextmenu.gestures.RightClickGesturesKt$awaitFirstRightClickDown$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.contextmenu.gestures.RightClickGesturesKt", f = "RightClickGestures.kt", i = {0}, l = {45}, m = "awaitFirstRightClickDown", n = {"$this$awaitFirstRightClickDown"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return RightClickGesturesKt.access$awaitFirstRightClickDown(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.contextmenu.gestures.RightClickGesturesKt$onRightClickDown$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.contextmenu.gestures.RightClickGesturesKt$onRightClickDown$2", f = "RightClickGestures.kt", i = {0}, l = {32, 35}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"})
    public static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Offset, Unit> $onDown;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Function1<? super Offset, Unit> r1, Continuation<? super AnonymousClass2> r2) {
            this.$onDown = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$onDown, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((AwaitPointerEventScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r8);
        L16:
            PointerInputChange r9 = (PointerInputChange) r8;
            if (r9 == null) goto L20;
            r9.consume();
        L20:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            AwaitPointerEventScope r2 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r8);
        L13:
            PointerInputChange r10 = (PointerInputChange) r8;
            r10.consume();
            this.$onDown.invoke(Offset.box-impl(r10.getPosition-F1C5BW0()));
            this.L$0 = null;
            this.label = 2;
            r8 = TapGestureDetectorKt.waitForUpOrCancellation$default(r2, null, this, 1, null);
            if (r8 != r0) goto L16;
            return r0;
        L10:
            ResultKt.throwOnFailure(r8);
            r2 = (AwaitPointerEventScope) this.L$0;
            this.L$0 = r2;
            this.label = 1;
            r8 = RightClickGesturesKt.access$awaitFirstRightClickDown(r2, this);
            if (r8 != r0) goto L13;
            return r0;
        }
    }

    public static final /* synthetic */ Object access$awaitFirstRightClickDown(AwaitPointerEventScope r0, Continuation r1) {
        return awaitFirstRightClickDown(r0, r1);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0041 -> B:18:0x0044). Please report as a decompilation issue!!! */
    private static final Object awaitFirstRightClickDown(AwaitPointerEventScope r8, Continuation<? super PointerInputChange> r9) {
        if ((r9 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r9;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = (AwaitPointerEventScope) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L18:
        PointerEvent r11 = (PointerEvent) r10;
        if (PointerEvent_androidKt.isSecondaryPressed-aHzCx-E(r11.getButtons-ry648PA()) == true) goto L20;
    L15:
        r0.L$0 = r8;
        r0.label = 1;
        r10 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r8, null, r0, 1, null);
        if (r10 != r2) goto L18;
        return r2;
    L20:
        List r4 = r11.getChanges();
        int r5 = r4.size();
        int r6 = 0;
    L21:
        if (r6 >= r5) goto L26;
        if (PointerEventKt.changedToDown((PointerInputChange) ListProtector.get(r4, r6)) == false) goto L24;
        r6 = r6 + 1;
        goto L21
    L24:
        boolean r7 = false;
    L27:
        if (r7 == false) goto L15;
        return ListProtector.get(r11.getChanges(), 0);
    L26:
        r7 = true;
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
    L7:
        r0 = new AnonymousClass1(r9);
        goto L8
    }

    public static final Object onRightClickDown(PointerInputScope r2, Function1<? super Offset, Unit> r3, Continuation<? super Unit> r4) {
        Object r5 = ForEachGestureKt.awaitEachGesture(r2, new AnonymousClass2(r3, null), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }
}
