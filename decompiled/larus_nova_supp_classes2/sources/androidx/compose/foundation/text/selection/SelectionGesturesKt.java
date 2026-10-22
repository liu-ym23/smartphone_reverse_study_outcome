package androidx.compose.foundation.text.selection;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.ViewConfiguration;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0000\u001a\u001c\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\"\u0010\r\u001a\u00020\u0007*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012\u001a*\u0010\u0013\u001a\u00020\u0007*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0016\u001a\"\u0010\u0017\u001a\u00020\u0007*\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0080@¢\u0006\u0002\u0010\u0019\u001a\"\u0010\u001a\u001a\u00020\u0007*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012\u001a\"\u0010\u001c\u001a\u00020\u0007*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012\u001a*\u0010\u001d\u001a\u00020\u0007*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0016\u001a\u0012\u0010\u001e\u001a\u00020\u0011*\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u001f\u001a \u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010&\u001a\u00020\u0006*\u00020\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"STATIC_KEY", "", "updateSelectionTouchMode", "Landroidx/compose/ui/Modifier;", "updateTouchMode", "Lkotlin/Function1;", "", "", "selectionGestureInput", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "textDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "touchSelection", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "observer", "down", "Landroidx/compose/ui/input/pointer/PointerEvent;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/TextDragObserver;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseSelection", "clicksCounter", "Landroidx/compose/foundation/text/selection/ClicksCounter;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/selection/ClicksCounter;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectionGesturePointerInputBtf2", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/TextDragObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchSelectionFirstPress", "downEvent", "touchSelectionSubsequentPress", "mouseSelectionBtf2", "awaitDown", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "distanceIsTolerable", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "change1", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "change2", "isPrecisePointer", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SelectionGesturesKt {
    private static final int STATIC_KEY = 8675309;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0}, l = {432}, m = "awaitDown", n = {"$this$awaitDown"}, s = {"L$0"})
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
            return SelectionGesturesKt.access$awaitDown(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0, 0, 1, 1, 1}, l = {159, 184}, m = "mouseSelection", n = {"$this$mouseSelection", "observer", "$this$mouseSelection", "observer", "dragConsumed"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    public static final class C02271 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C02271(Continuation<? super C02271> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return SelectionGesturesKt.access$mouseSelection(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelectionBtf2$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0, 0, 1, 1, 1}, l = {358, 386}, m = "mouseSelectionBtf2", n = {"$this$mouseSelectionBtf2", "observer", "$this$mouseSelectionBtf2", "observer", "dragConsumed"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    public static final class C02281 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C02281(Continuation<? super C02281> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return SelectionGesturesKt.access$mouseSelectionBtf2(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGesturePointerInputBtf2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGesturePointerInputBtf2$2", f = "SelectionGestures.kt", i = {0}, l = {210, 218, 221, 222}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"})
    public static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ClicksCounter $clicksCounter;
        final /* synthetic */ MouseSelectionObserver $mouseSelectionObserver;
        final /* synthetic */ TextDragObserver $textDragObserver;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(ClicksCounter r1, MouseSelectionObserver r2, TextDragObserver r3, Continuation<? super AnonymousClass2> r4) {
            this.$clicksCounter = r1;
            this.$mouseSelectionObserver = r2;
            this.$textDragObserver = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$clicksCounter, this.$mouseSelectionObserver, this.$textDragObserver, r6);
            r0.L$0 = r5;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((AwaitPointerEventScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L13;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L11;
            if (r1 == 3) goto L11;
            if (r1 == 4) goto L11;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r14);
        L41:
            return Unit.INSTANCE;
        L12:
            AwaitPointerEventScope r2 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r14);
        L16:
            PointerEvent r15 = (PointerEvent) r14;
            this.$clicksCounter.update(r15);
            boolean r6 = SelectionGesturesKt.isPrecisePointer(r15);
            if (r6 == true) goto L19;
        L31:
            if (r6 == true) goto L41;
            if (this.$clicksCounter.getClicks() != 1) goto L37;
            TextDragObserver r3 = this.$textDragObserver;
            this.L$0 = null;
            this.label = 3;
            if (SelectionGesturesKt.access$touchSelectionFirstPress(r2, r3, r15, this) != r0) goto L41;
            return r0;
        L37:
            TextDragObserver r4 = this.$textDragObserver;
            this.L$0 = null;
            this.label = 4;
            if (SelectionGesturesKt.access$touchSelectionSubsequentPress(r2, r4, r15, this) != r0) goto L41;
            return r0;
        L19:
            if (PointerEvent_androidKt.isPrimaryPressed-aHzCx-E(r15.getButtons-ry648PA()) == false) goto L31;
            List r8 = r15.getChanges();
            int r9 = r8.size();
            boolean r10 = false;
            int r11 = 0;
        L21:
            if (r11 >= r9) goto L26;
            if ((!((PointerInputChange) ListProtector.get(r8, r11)).isConsumed()) == false) goto L27;
            r11 = r11 + 1;
        L27:
            if (r10 == false) goto L31;
            MouseSelectionObserver r5 = this.$mouseSelectionObserver;
            ClicksCounter r7 = this.$clicksCounter;
            this.L$0 = null;
            this.label = 2;
            if (SelectionGesturesKt.access$mouseSelectionBtf2(r2, r5, r7, r15, this) != r0) goto L41;
            return r0;
        L26:
            r10 = true;
            goto L27
        L13:
            ResultKt.throwOnFailure(r14);
            r2 = (AwaitPointerEventScope) this.L$0;
            this.L$0 = r2;
            this.label = 1;
            r14 = SelectionGesturesKt.access$awaitDown(r2, this);
            if (r14 != r0) goto L16;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0, 0, 0, 1, 1}, l = {126, 130}, m = "touchSelection", n = {"$this$touchSelection", "observer", "firstDown", "$this$touchSelection", "observer"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    public static final class C02301 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C02301(Continuation<? super C02301> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return SelectionGesturesKt.access$touchSelection(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0, 0, 0, 1, 1}, l = {239, 243}, m = "touchSelectionFirstPress", n = {"$this$touchSelectionFirstPress", "observer", "firstDown", "$this$touchSelectionFirstPress", "observer"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    public static final class C02311 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C02311(Continuation<? super C02311> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return SelectionGesturesKt.access$touchSelectionFirstPress(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0, 0, 0, 0, 0, 1, 1}, l = {282, 323}, m = "touchSelectionSubsequentPress", n = {"$this$touchSelectionSubsequentPress", "observer", "firstDown", "overSlop", "pointerId", "$this$touchSelectionSubsequentPress", "observer"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1"})
    public static final class C02321 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C02321(Continuation<? super C02321> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return SelectionGesturesKt.access$touchSelectionSubsequentPress(null, null, null, this);
        }
    }

    public static /* synthetic */ Unit a(TextDragObserver r0, PointerInputChange r1) {
        return touchSelectionSubsequentPress$lambda$8(r0, r1);
    }

    public static /* synthetic */ Unit b(MouseSelectionObserver r0, PointerInputChange r1) {
        return mouseSelection$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit c(MouseSelectionObserver r0, SelectionAdjustment r1, Ref.BooleanRef r2, PointerInputChange r3) {
        return mouseSelection$lambda$4(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit d(TextDragObserver r0, PointerInputChange r1) {
        return touchSelection$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit e(TextDragObserver r0, PointerInputChange r1) {
        return touchSelectionFirstPress$lambda$6(r0, r1);
    }

    public static /* synthetic */ Unit f(MouseSelectionObserver r0, SelectionAdjustment r1, Ref.BooleanRef r2, PointerInputChange r3) {
        return mouseSelectionBtf2$lambda$12(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit g(MouseSelectionObserver r0, PointerInputChange r1) {
        return mouseSelectionBtf2$lambda$10(r0, r1);
    }

    public static final boolean isPrecisePointer(PointerEvent r5) {
        List r6 = r5.getChanges();
        int r0 = r6.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (PointerType.equals-impl0(((PointerInputChange) ListProtector.get(r6, r2)).getType-T8wyACA(), PointerType.Companion.getMouse-T8wyACA()) == false) goto L12;
        r2 = r2 + 1;
        goto L3
    L12:
        return false;
    L8:
        return true;
    }

    public static final /* synthetic */ Object access$awaitDown(AwaitPointerEventScope r0, Continuation r1) {
        return awaitDown(r0, r1);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0042 -> B:18:0x0045). Please report as a decompilation issue!!! */
    private static final Object awaitDown(AwaitPointerEventScope r8, Continuation<? super PointerEvent> r9) {
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
        List r4 = r11.getChanges();
        int r5 = r4.size();
        boolean r6 = false;
        int r7 = 0;
    L19:
        if (r7 >= r5) goto L24;
        if (PointerEventKt.changedToDownIgnoreConsumed((PointerInputChange) ListProtector.get(r4, r7)) == false) goto L25;
        r7 = r7 + 1;
    L25:
        if (r6 == true) goto L26;
    L15:
        PointerEventPass r12 = PointerEventPass.Main;
        r0.L$0 = r8;
        r0.label = 1;
        r10 = r8.awaitPointerEvent(r12, r0);
        if (r10 != r2) goto L18;
        return r2;
    L26:
        return r11;
    L24:
        r6 = true;
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
    L7:
        r0 = new AnonymousClass1(r9);
        goto L8
    }

    private static final Unit mouseSelection$lambda$2(MouseSelectionObserver r2, PointerInputChange r3) {
        if (r2.mo1728onExtendDragk4lQ0M(r3.getPosition-F1C5BW0()) == false) goto L6;
        r3.consume();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit mouseSelectionBtf2$lambda$10(MouseSelectionObserver r2, PointerInputChange r3) {
        if (r2.mo1728onExtendDragk4lQ0M(r3.getPosition-F1C5BW0()) == false) goto L6;
        r3.consume();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit touchSelection$lambda$0(TextDragObserver r2, PointerInputChange r3) {
        r2.mo1450onDragk4lQ0M(PointerEventKt.positionChange(r3));
        r3.consume();
        return Unit.INSTANCE;
    }

    private static final Unit touchSelectionFirstPress$lambda$6(TextDragObserver r2, PointerInputChange r3) {
        r2.mo1450onDragk4lQ0M(PointerEventKt.positionChange(r3));
        r3.consume();
        return Unit.INSTANCE;
    }

    private static final Unit touchSelectionSubsequentPress$lambda$8(TextDragObserver r2, PointerInputChange r3) {
        r2.mo1450onDragk4lQ0M(PointerEventKt.positionChange(r3));
        r3.consume();
        return Unit.INSTANCE;
    }

    public static final Modifier updateSelectionTouchMode(Modifier r2, final Function1<? super Boolean, Unit> r3) {
        return SuspendingPointerInputFilterKt.pointerInput(r2, Integer.valueOf(STATIC_KEY), new C02331(r3));
    }

    public static final /* synthetic */ boolean access$distanceIsTolerable(ViewConfiguration r0, PointerInputChange r1, PointerInputChange r2) {
        return distanceIsTolerable(r0, r1, r2);
    }

    private static final boolean distanceIsTolerable(ViewConfiguration r2, PointerInputChange r3, PointerInputChange r4) {
        float r5 = DragGestureDetectorKt.m587pointerSlopE8SPZFQ(r2, r3.getType-T8wyACA());
        if (Offset.getDistance-impl(Offset.minus-MK-Hz9U(r3.getPosition-F1C5BW0(), r4.getPosition-F1C5BW0())) >= r5) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Modifier selectionGestureInput(Modifier r1, final MouseSelectionObserver r2, final TextDragObserver r3) {
        return SuspendingPointerInputFilterKt.pointerInput(r1, r2, r3, new C02291(r2, r3));
    }

    public static final /* synthetic */ Object access$touchSelection(AwaitPointerEventScope r0, TextDragObserver r1, PointerEvent r2, Continuation r3) {
        return touchSelection(r0, r1, r2, r3);
    }

    public static final /* synthetic */ Object access$touchSelectionFirstPress(AwaitPointerEventScope r0, TextDragObserver r1, PointerEvent r2, Continuation r3) {
        return touchSelectionFirstPress(r0, r1, r2, r3);
    }

    public static final /* synthetic */ Object access$touchSelectionSubsequentPress(AwaitPointerEventScope r0, TextDragObserver r1, PointerEvent r2, Continuation r3) {
        return touchSelectionSubsequentPress(r0, r1, r2, r3);
    }

    private static final Unit mouseSelection$lambda$4(MouseSelectionObserver r2, SelectionAdjustment r3, Ref.BooleanRef r4, PointerInputChange r5) {
        if (r2.mo1726onDrag3MmeM6k(r5.getPosition-F1C5BW0(), r3) == false) goto L6;
        r5.consume();
        r4.element = true;
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit mouseSelectionBtf2$lambda$12(MouseSelectionObserver r2, SelectionAdjustment r3, Ref.BooleanRef r4, PointerInputChange r5) {
        if (r2.mo1726onDrag3MmeM6k(r5.getPosition-F1C5BW0(), r3) == false) goto L6;
        r5.consume();
        r4.element = true;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object selectionGesturePointerInputBtf2(PointerInputScope r3, MouseSelectionObserver r4, TextDragObserver r5, Continuation<? super Unit> r6) {
        Object r7 = ForEachGestureKt.awaitEachGesture(r3, new AnonymousClass2(new ClicksCounter(r3.getViewConfiguration()), r4, r5, null), r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r7;
    L6:
        return Unit.INSTANCE;
    }

    private static final Object touchSelection(AwaitPointerEventScope r8, final TextDragObserver r9, PointerEvent r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof C02301) == false) goto L7;
        C02301 r0 = (C02301) r11;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L16;
        r9 = (TextDragObserver) r0.L$1;
        r8 = (AwaitPointerEventScope) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: CancellationException -> L43
    L32:
        if (((Boolean) r12).booleanValue() == false) goto L40;
        List r13 = r8.getCurrentEvent().getChanges();     // Catch: CancellationException -> L43
        int r14 = r13.size();     // Catch: CancellationException -> L43
        int r15 = 0;
    L34:
        if (r15 >= r14) goto L39;
        PointerInputChange r4 = (PointerInputChange) ListProtector.get(r13, r15);     // Catch: CancellationException -> L43
        if (PointerEventKt.changedToUp(r4) == false) goto L38;
        r4.consume();     // Catch: CancellationException -> L43
    L38:
        r15 = r15 + 1;     // Catch: CancellationException -> L43
        goto L34
    L39:
        r9.onStop();     // Catch: CancellationException -> L43
    L42:
        return Unit.INSTANCE;
    L40:
        r9.onCancel();     // Catch: CancellationException -> L43
        goto L42
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        PointerInputChange r16 = (PointerInputChange) r0.L$2;
        r9 = (TextDragObserver) r0.L$1;
        AwaitPointerEventScope r17 = (AwaitPointerEventScope) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: CancellationException -> L43
        PointerInputChange r18 = r16;
        r8 = r17;
    L24:
        PointerInputChange r19 = (PointerInputChange) r12;     // Catch: CancellationException -> L43
        if (r19 == null) goto L42;
        if (distanceIsTolerable(r8.getViewConfiguration(), r18, r19) == false) goto L42;
        r9.mo1451onStartk4lQ0M(r19.getPosition-F1C5BW0());     // Catch: CancellationException -> L43
        long r110 = r19.getId-J3iCeTQ();     // Catch: CancellationException -> L43
        Function1 r5 = new d0(r9);     // Catch: CancellationException -> L43
        r0.L$0 = r8;     // Catch: CancellationException -> L43
        r0.L$1 = r9;     // Catch: CancellationException -> L43
        r0.L$2 = null;     // Catch: CancellationException -> L43
        r0.label = 2;     // Catch: CancellationException -> L43
        r12 = DragGestureDetectorKt.m584dragjO51t88(r8, r110, r5, r0);     // Catch: CancellationException -> L43
        if (r12 != r2) goto L32;
        return r2;
    L20:
        ResultKt.throwOnFailure(r12);
        r18 = (PointerInputChange) CollectionsKt.first(r10.getChanges());     // Catch: CancellationException -> L43
        long r6 = r18.getId-J3iCeTQ();     // Catch: CancellationException -> L43
        r0.L$0 = r8;     // Catch: CancellationException -> L43
        r0.L$1 = r9;     // Catch: CancellationException -> L43
        r0.L$2 = r18;     // Catch: CancellationException -> L43
        r0.label = 1;     // Catch: CancellationException -> L43
        r12 = DragGestureDetectorKt.m574awaitLongPressOrCancellationrnUCldI(r8, r6, r0);     // Catch: CancellationException -> L43
        if (r12 != r2) goto L24;
        return r2;
    L43:
        e = move-exception;
        r9.onCancel();
        throw e;
    L7:
        r0 = new C02301(r11);
        goto L8
    }

    private static final Object touchSelectionFirstPress(AwaitPointerEventScope r8, final TextDragObserver r9, PointerEvent r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof C02311) == false) goto L7;
        C02311 r0 = (C02311) r11;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L16;
        r9 = (TextDragObserver) r0.L$1;
        r8 = (AwaitPointerEventScope) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: CancellationException -> L43
    L32:
        if (((Boolean) r12).booleanValue() == false) goto L40;
        List r13 = r8.getCurrentEvent().getChanges();     // Catch: CancellationException -> L43
        int r14 = r13.size();     // Catch: CancellationException -> L43
        int r15 = 0;
    L34:
        if (r15 >= r14) goto L39;
        PointerInputChange r4 = (PointerInputChange) ListProtector.get(r13, r15);     // Catch: CancellationException -> L43
        if (PointerEventKt.changedToUp(r4) == false) goto L38;
        r4.consume();     // Catch: CancellationException -> L43
    L38:
        r15 = r15 + 1;     // Catch: CancellationException -> L43
        goto L34
    L39:
        r9.onStop();     // Catch: CancellationException -> L43
    L42:
        return Unit.INSTANCE;
    L40:
        r9.onCancel();     // Catch: CancellationException -> L43
        goto L42
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        PointerInputChange r16 = (PointerInputChange) r0.L$2;
        r9 = (TextDragObserver) r0.L$1;
        AwaitPointerEventScope r17 = (AwaitPointerEventScope) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: CancellationException -> L43
        PointerInputChange r18 = r16;
        r8 = r17;
    L24:
        PointerInputChange r19 = (PointerInputChange) r12;     // Catch: CancellationException -> L43
        if (r19 == null) goto L42;
        if (distanceIsTolerable(r8.getViewConfiguration(), r18, r19) == false) goto L42;
        r9.mo1451onStartk4lQ0M(r19.getPosition-F1C5BW0());     // Catch: CancellationException -> L43
        long r110 = r19.getId-J3iCeTQ();     // Catch: CancellationException -> L43
        Function1 r5 = new h0(r9);     // Catch: CancellationException -> L43
        r0.L$0 = r8;     // Catch: CancellationException -> L43
        r0.L$1 = r9;     // Catch: CancellationException -> L43
        r0.L$2 = null;     // Catch: CancellationException -> L43
        r0.label = 2;     // Catch: CancellationException -> L43
        r12 = DragGestureDetectorKt.m584dragjO51t88(r8, r110, r5, r0);     // Catch: CancellationException -> L43
        if (r12 != r2) goto L32;
        return r2;
    L20:
        ResultKt.throwOnFailure(r12);
        r18 = (PointerInputChange) CollectionsKt.first(r10.getChanges());     // Catch: CancellationException -> L43
        long r6 = r18.getId-J3iCeTQ();     // Catch: CancellationException -> L43
        r0.L$0 = r8;     // Catch: CancellationException -> L43
        r0.L$1 = r9;     // Catch: CancellationException -> L43
        r0.L$2 = r18;     // Catch: CancellationException -> L43
        r0.label = 1;     // Catch: CancellationException -> L43
        r12 = DragGestureDetectorKt.m574awaitLongPressOrCancellationrnUCldI(r8, r6, r0);     // Catch: CancellationException -> L43
        if (r12 != r2) goto L24;
        return r2;
    L43:
        e = move-exception;
        r9.onCancel();
        throw e;
    L7:
        r0 = new C02311(r11);
        goto L8
    }

    private static final Object touchSelectionSubsequentPress(AwaitPointerEventScope r12, final TextDragObserver r13, PointerEvent r14, Continuation<? super Unit> r15) {
        if ((r15 instanceof C02321) == false) goto L7;
        C02321 r0 = (C02321) r15;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L16;
        r13 = (TextDragObserver) r0.L$1;
        r12 = (AwaitPointerEventScope) r0.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: CancellationException -> L55
    L44:
        if (((Boolean) r16).booleanValue() == false) goto L52;
        List r17 = r12.getCurrentEvent().getChanges();     // Catch: CancellationException -> L55
        int r18 = r17.size();     // Catch: CancellationException -> L55
        int r19 = 0;
    L46:
        if (r19 >= r18) goto L51;
        PointerInputChange r4 = (PointerInputChange) ListProtector.get(r17, r19);     // Catch: CancellationException -> L55
        if (PointerEventKt.changedToUp(r4) == false) goto L50;
        r4.consume();     // Catch: CancellationException -> L55
    L50:
        r19 = r19 + 1;     // Catch: CancellationException -> L55
        goto L46
    L51:
        r13.onStop();     // Catch: CancellationException -> L55
    L54:
        return Unit.INSTANCE;
    L52:
        r13.onCancel();     // Catch: CancellationException -> L55
        goto L54
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        long r110 = r0.J$0;
        Ref.LongRef r111 = (Ref.LongRef) r0.L$3;
        PointerInputChange r5 = (PointerInputChange) r0.L$2;
        TextDragObserver r6 = (TextDragObserver) r0.L$1;
        AwaitPointerEventScope r7 = (AwaitPointerEventScope) r0.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: CancellationException -> L20
        Ref.LongRef r8 = r111;
        Object r9 = r16;
        long r112 = r110;
        r13 = r6;
        r12 = r7;
    L26:
        DownResolution r10 = (DownResolution) r9;     // Catch: CancellationException -> L55
        if (r10 != null) goto L30;
        r10 = DownResolution.Timeout;     // Catch: CancellationException -> L55
    L30:
        if (r10 == DownResolution.Cancel) goto L32;
        r13.mo1451onStartk4lQ0M(r5.getPosition-F1C5BW0());     // Catch: CancellationException -> L55
        if (r10 != DownResolution.Up) goto L38;
        r13.onStop();     // Catch: CancellationException -> L55
        return Unit.INSTANCE;
    L38:
        if (r10 != DownResolution.Drag) goto L40;
        r13.mo1450onDragk4lQ0M(r8.element);     // Catch: CancellationException -> L55
    L40:
        Function1 r11 = new g0(r13);     // Catch: CancellationException -> L55
        r0.L$0 = r12;     // Catch: CancellationException -> L55
        r0.L$1 = r13;     // Catch: CancellationException -> L55
        r0.L$2 = null;     // Catch: CancellationException -> L55
        r0.L$3 = null;     // Catch: CancellationException -> L55
        r0.label = 2;     // Catch: CancellationException -> L55
        r16 = DragGestureDetectorKt.m584dragjO51t88(r12, r112, r11, r0);     // Catch: CancellationException -> L55
        if (r16 != r2) goto L44;
        return r2;
    L32:
        return Unit.INSTANCE;
    L20:
        e = e;
        r13 = r6;
    L56:
        r13.onCancel();
        throw e;
    L22:
        ResultKt.throwOnFailure(r16);
        r5 = (PointerInputChange) CollectionsKt.first(r14.getChanges());     // Catch: CancellationException -> L55
        r112 = r5.getId-J3iCeTQ();     // Catch: CancellationException -> L55
        r8 = new Ref.LongRef();     // Catch: CancellationException -> L55
        r8.element = Offset.Companion.getUnspecified-F1C5BW0();     // Catch: CancellationException -> L55
        long r20 = r12.getViewConfiguration().getLongPressTimeoutMillis();     // Catch: CancellationException -> L55
        SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1 r21 = new SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1(r112, r8, null);     // Catch: CancellationException -> L55
        r0.L$0 = r12;     // Catch: CancellationException -> L55
        r0.L$1 = r13;     // Catch: CancellationException -> L55
        r0.L$2 = r5;     // Catch: CancellationException -> L55
        r0.L$3 = r8;     // Catch: CancellationException -> L55
        r0.J$0 = r112;     // Catch: CancellationException -> L55
        r0.label = 1;     // Catch: CancellationException -> L55
        r9 = r12.withTimeoutOrNull(r20, r21, r0);     // Catch: CancellationException -> L55
        if (r9 != r2) goto L26;
        return r2;
    L55:
        e = e;
    L7:
        r0 = new C02321(r15);
        goto L8
    }

    public static final /* synthetic */ Object access$mouseSelection(AwaitPointerEventScope r0, MouseSelectionObserver r1, ClicksCounter r2, PointerEvent r3, Continuation r4) {
        return mouseSelection(r0, r1, r2, r3, r4);
    }

    public static final /* synthetic */ Object access$mouseSelectionBtf2(AwaitPointerEventScope r0, MouseSelectionObserver r1, ClicksCounter r2, PointerEvent r3, Continuation r4) {
        return mouseSelectionBtf2(r0, r1, r2, r3, r4);
    }

    private static final Object mouseSelection(AwaitPointerEventScope r9, final MouseSelectionObserver r10, ClicksCounter r11, PointerEvent r12, Continuation<? super Unit> r13) {
        if ((r13 instanceof C02271) == false) goto L7;
        C02271 r0 = (C02271) r13;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        int r4 = 0;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        Ref.BooleanRef r15 = (Ref.BooleanRef) r0.L$2;
        r10 = (MouseSelectionObserver) r0.L$1;
        AwaitPointerEventScope r16 = (AwaitPointerEventScope) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L45:
        if (((Boolean) r14).booleanValue() == true) goto L47;
    L54:
        r10.onDragDone();
    L56:
        return Unit.INSTANCE;
    L47:
        if (r15.element == false) goto L54;
        List r17 = r16.getCurrentEvent().getChanges();
        int r18 = r17.size();
    L49:
        if (r4 >= r18) goto L54;
        PointerInputChange r19 = (PointerInputChange) ListProtector.get(r17, r4);
        if (PointerEventKt.changedToUp(r19) == false) goto L53;
        r19.consume();
    L53:
        r4 = r4 + 1;
        goto L49
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = (MouseSelectionObserver) r0.L$1;
        r9 = (AwaitPointerEventScope) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L24:
        if (((Boolean) r14).booleanValue() == false) goto L31;
        List r20 = r9.getCurrentEvent().getChanges();
        int r110 = r20.size();
    L26:
        if (r4 >= r110) goto L31;
        PointerInputChange r111 = (PointerInputChange) ListProtector.get(r20, r4);
        if (PointerEventKt.changedToUp(r111) == false) goto L30;
        r111.consume();
    L30:
        r4 = r4 + 1;
    L31:
        r10.onDragDone();
        goto L56
    L16:
        ResultKt.throwOnFailure(r14);
        r11.update(r12);
        PointerInputChange r112 = (PointerInputChange) ListProtector.get(r12.getChanges(), 0);
        if (TextFieldSelectionManager_androidKt.isShiftPressed(r12) == true) goto L19;
        int r113 = r11.getClicks();
        if (r113 == 1) goto L37;
        if (r113 == 2) goto L36;
        final SelectionAdjustment r114 = SelectionAdjustment.Companion.getParagraph();
    L39:
        if (r10.mo1729onStart9KIMszo(r112.getPosition-F1C5BW0(), r114, r11.getClicks()) == false) goto L56;
        final Ref.BooleanRef r115 = new Ref.BooleanRef();
        r115.element = !Intrinsics.areEqual(r114, SelectionAdjustment.Companion.getNone());
        long r5 = r112.getId-J3iCeTQ();
        Function1 r116 = new c0(r10, r114, r115);
        r0.L$0 = r9;
        r0.L$1 = r10;
        r0.L$2 = r115;
        r0.label = 2;
        r14 = DragGestureDetectorKt.m584dragjO51t88(r9, r5, r116, r0);
        if (r14 != r2) goto L43;
        return r2;
    L43:
        r16 = r9;
        r15 = r115;
        goto L45
    L36:
        r114 = SelectionAdjustment.Companion.getWord();
        goto L39
    L37:
        r114 = SelectionAdjustment.Companion.getNone();
        goto L39
    L19:
        if (r10.mo1727onExtendk4lQ0M(r112.getPosition-F1C5BW0()) == false) goto L56;
        long r117 = r112.getId-J3iCeTQ();
        Function1 r118 = new b0(r10);
        r0.L$0 = r9;
        r0.L$1 = r10;
        r0.label = 1;
        r14 = DragGestureDetectorKt.m584dragjO51t88(r9, r117, r118, r0);
        if (r14 != r2) goto L24;
        return r2;
    L7:
        r0 = new C02271(r13);
        goto L8
    }

    private static final Object mouseSelectionBtf2(AwaitPointerEventScope r9, final MouseSelectionObserver r10, ClicksCounter r11, PointerEvent r12, Continuation<? super Unit> r13) {
        if ((r13 instanceof C02281) == false) goto L7;
        C02281 r0 = (C02281) r13;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        int r4 = 0;
        boolean r5 = true;
        if (r3 == 0) goto L24;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        Ref.BooleanRef r15 = (Ref.BooleanRef) r0.L$2;
        r10 = (MouseSelectionObserver) r0.L$1;
        AwaitPointerEventScope r16 = (AwaitPointerEventScope) r0.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L15
    L59:
        if (((Boolean) r14).booleanValue() == true) goto L61;
    L68:
        r10.onDragDone();
    L72:
        return Unit.INSTANCE;
    L61:
        if (r15.element == false) goto L68;
        List r17 = r16.getCurrentEvent().getChanges();     // Catch: Throwable -> L15
        int r18 = r17.size();     // Catch: Throwable -> L15
    L63:
        if (r4 >= r18) goto L68;
        PointerInputChange r19 = (PointerInputChange) r17.get(r4);     // Catch: Throwable -> L15
        if (PointerEventKt.changedToUp(r19) == false) goto L67;
        r19.consume();     // Catch: Throwable -> L15
    L67:
        r4 = r4 + 1;
        goto L63
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r10 = (MouseSelectionObserver) r0.L$1;
        r9 = (AwaitPointerEventScope) r0.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L22
    L32:
        if (((Boolean) r14).booleanValue() == false) goto L39;
        List r20 = r9.getCurrentEvent().getChanges();     // Catch: Throwable -> L22
        int r110 = r20.size();     // Catch: Throwable -> L22
    L34:
        if (r4 >= r110) goto L39;
        PointerInputChange r111 = (PointerInputChange) r20.get(r4);     // Catch: Throwable -> L22
        if (PointerEventKt.changedToUp(r111) == false) goto L38;
        r111.consume();     // Catch: Throwable -> L22
    L38:
        r4 = r4 + 1;
    L39:
        r10.onDragDone();
        goto L72
    L24:
        ResultKt.throwOnFailure(r14);
        PointerInputChange r112 = (PointerInputChange) ListProtector.get(r12.getChanges(), 0);
        if (TextFieldSelectionManager_androidKt.isShiftPressed(r12) == true) goto L27;
        int r113 = r11.getClicks();
        if (r113 == 1) goto L47;
        if (r113 == 2) goto L46;
        final SelectionAdjustment r114 = SelectionAdjustment.Companion.getParagraph();
    L49:
        if (r10.mo1729onStart9KIMszo(r112.getPosition-F1C5BW0(), r114, r11.getClicks()) == false) goto L72;
        r112.consume();     // Catch: Throwable -> L15
        final Ref.BooleanRef r115 = new Ref.BooleanRef();     // Catch: Throwable -> L15
        if (Intrinsics.areEqual(r114, SelectionAdjustment.Companion.getNone()) == false) goto L54;
        r5 = false;
    L54:
        r115.element = r5;     // Catch: Throwable -> L15
        long r6 = r112.getId-J3iCeTQ();     // Catch: Throwable -> L15
        Function1 r116 = new f0(r10, r114, r115);     // Catch: Throwable -> L15
        r0.L$0 = r9;     // Catch: Throwable -> L15
        r0.L$1 = r10;     // Catch: Throwable -> L15
        r0.L$2 = r115;     // Catch: Throwable -> L15
        r0.label = 2;     // Catch: Throwable -> L15
        r14 = DragGestureDetectorKt.m584dragjO51t88(r9, r6, r116, r0);     // Catch: Throwable -> L15
        if (r14 != r2) goto L57;
        return r2;
    L57:
        r16 = r9;
        r15 = r115;
        goto L59
    L46:
        r114 = SelectionAdjustment.Companion.getWord();
        goto L49
    L47:
        r114 = SelectionAdjustment.Companion.getNone();
        goto L49
    L27:
        if (r10.mo1727onExtendk4lQ0M(r112.getPosition-F1C5BW0()) == false) goto L72;
        r112.consume();     // Catch: Throwable -> L22
        long r117 = r112.getId-J3iCeTQ();     // Catch: Throwable -> L22
        Function1 r118 = new e0(r10);     // Catch: Throwable -> L22
        r0.L$0 = r9;     // Catch: Throwable -> L22
        r0.L$1 = r10;     // Catch: Throwable -> L22
        r0.label = 1;     // Catch: Throwable -> L22
        r14 = DragGestureDetectorKt.m584dragjO51t88(r9, r117, r118, r0);     // Catch: Throwable -> L22
        if (r14 != r2) goto L32;
        return r2;
    L22:
        th = move-exception;
        r10.onDragDone();
        throw th;
    L15:
        th = move-exception;
        r10.onDragDone();
        throw th;
    L7:
        r0 = new C02281(r13);
        goto L8
    }
}
