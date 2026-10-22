package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.relocation.BringIntoViewResponder;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001FB)\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020\fH\u0002J\u001e\u0010#\u001a\u00020$2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0%H\u0096@¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010\u0015J\u0017\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u0019H\u0016¢\u0006\u0004\b+\u0010,J\n\u0010-\u001a\u0004\u0018\u00010 H\u0002J\b\u0010.\u001a\u00020$H\u0002J\u0010\u0010/\u001a\u0002002\u0006\u0010\u000b\u001a\u00020\fH\u0002J\n\u00101\u001a\u0004\u0018\u00010 H\u0002J\u001f\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020 2\u0006\u00104\u001a\u00020\u0019H\u0002¢\u0006\u0004\b5\u00106J\u001d\u00107\u001a\u00020\n*\u00020 2\b\b\u0002\u0010*\u001a\u00020\u0019H\u0002¢\u0006\u0004\b8\u00109J\u001f\u0010:\u001a\u00020;2\u0006\u00103\u001a\u00020 2\u0006\u00104\u001a\u00020\u0019H\u0002¢\u0006\u0004\b<\u0010=J\u001c\u0010>\u001a\u00020?*\u00020\u00192\u0006\u0010@\u001a\u00020\u0019H\u0082\u0002¢\u0006\u0004\bA\u0010BJ\u001c\u0010>\u001a\u00020?*\u00020C2\u0006\u0010@\u001a\u00020CH\u0082\u0002¢\u0006\u0004\bD\u0010BJ \u0010E\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@BX\u0080\u000e¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Landroidx/compose/foundation/gestures/ContentInViewNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "reverseDirection", "", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "<init>", "(Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/ScrollingLogic;ZLandroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "bringIntoViewRequests", "Landroidx/compose/foundation/gestures/BringIntoViewRequestPriorityQueue;", "focusedChild", "Landroidx/compose/ui/layout/LayoutCoordinates;", "trackingFocusedChild", "childWasMaxVisibleBeforeViewportShrunk", "value", "Landroidx/compose/ui/unit/IntSize;", "viewportSize", "getViewportSize-YbymL2g$foundation_release", "()J", "J", "isAnimationRunning", "calculateRectForParent", "Landroidx/compose/ui/geometry/Rect;", "localRect", "requireBringIntoViewSpec", "bringChildIntoView", "", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onFocusBoundsChanged", "newBounds", "onRemeasured", "size", "onRemeasured-ozmzZPI", "(J)V", "getFocusedChildBounds", "launchAnimation", "calculateScrollDelta", "", "findBringIntoViewRequest", "computeDestination", "childBounds", "containerSize", "computeDestination-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/Rect;", "isMaxVisible", "isMaxVisible-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Z", "relocationOffset", "Landroidx/compose/ui/geometry/Offset;", "relocationOffset-BMxPBkI", "(Landroidx/compose/ui/geometry/Rect;J)J", "compareTo", "", "other", "compareTo-TemP2vQ", "(JJ)I", "Landroidx/compose/ui/geometry/Size;", "compareTo-iLBOSCw", "update", "Request", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContentInViewNode extends Modifier.Node implements BringIntoViewResponder, CompositionLocalConsumerModifierNode, LayoutAwareModifierNode {
    public static final int $stable = 8;
    private final BringIntoViewRequestPriorityQueue bringIntoViewRequests;
    private BringIntoViewSpec bringIntoViewSpec;
    private boolean childWasMaxVisibleBeforeViewportShrunk;
    private LayoutCoordinates focusedChild;
    private boolean isAnimationRunning;
    private Orientation orientation;
    private boolean reverseDirection;
    private final ScrollingLogic scrollingLogic;
    private final boolean shouldAutoInvalidate;
    private boolean trackingFocusedChild;
    private long viewportSize;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/gestures/ContentInViewNode$Request;", "", "currentBounds", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CancellableContinuation;)V", "getCurrentBounds", "()Lkotlin/jvm/functions/Function0;", "getContinuation", "()Lkotlinx/coroutines/CancellableContinuation;", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Request {
        public static final int $stable = 8;
        private final kotlinx.coroutines.i<Unit> continuation;
        private final Function0<Rect> currentBounds;

        public String toString() {
            kotlinx.coroutines.a0 r0 = this.continuation.getContext().get(kotlinx.coroutines.a0.b);
            if (r0 == null) goto L5;
            String r1 = r0.a;
        L6:
            StringBuilder r2 = new StringBuilder("Request@");
            r2.append(Integer.toString(hashCode(), CharsKt.checkRadix(16)));
            if (r1 == null) goto L10;
            String r3 = "[" + r1 + "](";
            if (r3 == null) goto L10;
        L11:
            r2.append(r3);
            r2.append("currentBounds()=");
            r2.append(this.currentBounds.invoke());
            r2.append(", continuation=");
            r2.append(this.continuation);
            r2.append(')');
            return r2.toString();
        L10:
            r3 = "(";
            goto L11
        L5:
            r1 = null;
            goto L6
        }

        public final kotlinx.coroutines.i<Unit> getContinuation() {
            return this.continuation;
        }

        public final Function0<Rect> getCurrentBounds() {
            return this.currentBounds;
        }

        public Request(Function0<Rect> r1, kotlinx.coroutines.i<? super Unit> r2) {
            this.currentBounds = r1;
            this.continuation = r2;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Orientation.values().length];
            r0[Orientation.Vertical.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Orientation.Horizontal.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2", f = "ContentInViewNode.kt", i = {}, l = {215}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UpdatableAnimationState $animationState;
        final /* synthetic */ BringIntoViewSpec $bringIntoViewSpec;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ContentInViewNode this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1", f = "ContentInViewNode.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Job $animationJob;
            final /* synthetic */ UpdatableAnimationState $animationState;
            final /* synthetic */ BringIntoViewSpec $bringIntoViewSpec;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ContentInViewNode this$0;

            public AnonymousClass1(UpdatableAnimationState r1, ContentInViewNode r2, BringIntoViewSpec r3, Job r4, Continuation<? super AnonymousClass1> r5) {
                this.$animationState = r1;
                this.this$0 = r2;
                this.$bringIntoViewSpec = r3;
                this.$animationJob = r4;
                super(2, r5);
            }

            public static /* synthetic */ Unit a(ContentInViewNode r0, UpdatableAnimationState r1, Job r2, NestedScrollScope r3, float r4) {
                return invokeSuspend$lambda$1(r0, r1, r2, r3, r4);
            }

            public static /* synthetic */ Unit c(ContentInViewNode r0, UpdatableAnimationState r1, BringIntoViewSpec r2) {
                return invokeSuspend$lambda$4(r0, r1, r2);
            }

            public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
                AnonymousClass1 r6 = new AnonymousClass1(this.$animationState, this.this$0, this.$bringIntoViewSpec, this.$animationJob, r9);
                r6.L$0 = r8;
                return r6;
            }

            public final Object invoke(NestedScrollScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((NestedScrollScope) r1, (Continuation) r2);
            }

            public final Object invokeSuspend(Object r7) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r7);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r7);
                final NestedScrollScope r8 = (NestedScrollScope) this.L$0;
                this.$animationState.setValue(ContentInViewNode.access$calculateScrollDelta(this.this$0, this.$bringIntoViewSpec));
                final UpdatableAnimationState r2 = this.$animationState;
                final ContentInViewNode r3 = this.this$0;
                final Job r4 = this.$animationJob;
                Function1<? super Float, Unit> r5 = new d0(r3, r2, r4, r8);
                final BringIntoViewSpec r9 = this.$bringIntoViewSpec;
                Function0<Unit> r6 = new e0(r3, r2, r9);
                this.label = 1;
                if (r2.animateToZero(r5, r6, this) != r0) goto L12;
                return r0;
            }

            private static final Unit invokeSuspend$lambda$4(ContentInViewNode r10, UpdatableAnimationState r11, BringIntoViewSpec r12) {
                BringIntoViewRequestPriorityQueue r0 = ContentInViewNode.access$getBringIntoViewRequests$p(r10);
            L3:
                boolean r3 = true;
                if (BringIntoViewRequestPriorityQueue.access$getRequests$p(r0).getSize() == 0) goto L6;
                boolean r1 = true;
            L7:
                if (r1 == false) goto L15;
                Rect r5 = (Rect) ((Request) BringIntoViewRequestPriorityQueue.access$getRequests$p(r0).last()).getCurrentBounds().invoke();
                if (r5 != null) goto L11;
                boolean r2 = true;
            L12:
                if (r2 == false) goto L15;
                ((Request) BringIntoViewRequestPriorityQueue.access$getRequests$p(r0).removeAt(BringIntoViewRequestPriorityQueue.access$getRequests$p(r0).getSize() - 1)).getContinuation().resumeWith(Result.constructor-impl(Unit.INSTANCE));
                goto L3
            L11:
                r2 = ContentInViewNode.m555isMaxVisibleO0kMr_c$default(r10, r5, 0, 1, null);
            L15:
                if (ContentInViewNode.access$getTrackingFocusedChild$p(r10) == false) goto L24;
                Rect r6 = ContentInViewNode.access$getFocusedChildBounds(r10);
                if (r6 != null) goto L19;
            L21:
                r3 = false;
            L22:
                if (r3 == false) goto L24;
                ContentInViewNode.access$setTrackingFocusedChild$p(r10, false);
                goto L24
            L19:
                if (ContentInViewNode.m555isMaxVisibleO0kMr_c$default(r10, r6, 0, 1, null) != true) goto L21;
            L24:
                r11.setValue(ContentInViewNode.access$calculateScrollDelta(r10, r12));
                return Unit.INSTANCE;
            L6:
                r1 = false;
                goto L7
            }

            private static final Unit invokeSuspend$lambda$1(ContentInViewNode r3, UpdatableAnimationState r4, Job r5, NestedScrollScope r6, float r7) {
                if (ContentInViewNode.access$getReverseDirection$p(r3) == false) goto L5;
                float r8 = 1.0f;
            L6:
                ScrollingLogic r9 = ContentInViewNode.access$getScrollingLogic$p(r3);
                float r10 = r8 * r9.m701toFloatk4lQ0M(r9.m699reverseIfNeededMKHz9U(r6.mo614scrollByOzD1aCk(r9.m699reverseIfNeededMKHz9U(r9.m702toOffsettuRUvjQ(r8 * r7)), NestedScrollSource.Companion.getUserInput-WNlRxjI())));
                if (Math.abs(r10) >= Math.abs(r7)) goto L10;
                JobKt.cancel$default(r5, "Scroll animation cancelled because scroll was not consumed (" + r10 + " < " + r7 + ')', null, 2, null);
            L10:
                return Unit.INSTANCE;
            L5:
                r8 = -1.0f;
                goto L6
            }
        }

        public AnonymousClass2(ContentInViewNode r1, UpdatableAnimationState r2, BringIntoViewSpec r3, Continuation<? super AnonymousClass2> r4) {
            this.this$0 = r1;
            this.$animationState = r2;
            this.$bringIntoViewSpec = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, this.$animationState, this.$bringIntoViewSpec, r6);
            r0.L$0 = r5;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            CancellationException r2 = null;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L16 CancellationException -> L18
        L13:
            ContentInViewNode.access$getBringIntoViewRequests$p(this.this$0).resumeAndRemoveAll();     // Catch: Throwable -> L16 CancellationException -> L18
            ContentInViewNode.access$setAnimationRunning$p(this.this$0, false);
            ContentInViewNode.access$getBringIntoViewRequests$p(this.this$0).cancelAndRemoveAll(null);
            ContentInViewNode.access$setTrackingFocusedChild$p(this.this$0, false);
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r13);
            Job r9 = JobKt.getJob(((CoroutineScope) this.L$0).getCoroutineContext());
            ContentInViewNode.access$setAnimationRunning$p(this.this$0, true);     // Catch: Throwable -> L16 CancellationException -> L18
            ScrollingLogic r14 = ContentInViewNode.access$getScrollingLogic$p(this.this$0);     // Catch: Throwable -> L16 CancellationException -> L18
            MutatePriority r3 = MutatePriority.Default;     // Catch: Throwable -> L16 CancellationException -> L18
            AnonymousClass1 r11 = new AnonymousClass1(this.$animationState, this.this$0, this.$bringIntoViewSpec, r9, null);     // Catch: Throwable -> L16 CancellationException -> L18
            this.label = 1;     // Catch: Throwable -> L16 CancellationException -> L18
            if (r14.scroll(r3, r11, this) != r0) goto L13;
            return r0;
        L18:
            e = move-exception;
            r2 = e;
            throw r2;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            ContentInViewNode.access$setAnimationRunning$p(this.this$0, false);
            ContentInViewNode.access$getBringIntoViewRequests$p(this.this$0).cancelAndRemoveAll(r2);
            ContentInViewNode.access$setTrackingFocusedChild$p(this.this$0, false);
            throw th;
        }
    }

    public final /* synthetic */ void onPlaced(LayoutCoordinates r1) {
        LayoutAwareModifierNode.-CC.$default$onPlaced(this, r1);
    }

    private final Rect findBringIntoViewRequest() {
        MutableVector r0 = BringIntoViewRequestPriorityQueue.access$getRequests$p(this.bringIntoViewRequests);
        int r1 = r0.getSize() - 1;
        Object[] r2 = r0.content;
        Rect r3 = null;
        if (r1 >= r2.length) goto L14;
    L4:
        if (r1 < 0) goto L14;
        Rect r4 = (Rect) ((Request) r2[r1]).getCurrentBounds().invoke();
        if (r4 == null) goto L13;
        if (m552compareToiLBOSCw(r4.getSize-NH-jbRc(), IntSizeKt.toSize-ozmzZPI(this.viewportSize)) > 0) goto L10;
        r3 = r4;
        goto L13
    L10:
        if (r3 == null) goto L12;
        return r3;
    L12:
        return r4;
    L13:
        r1 = r1 - 1;
    L14:
        return r3;
    }

    private final BringIntoViewSpec requireBringIntoViewSpec() {
        BringIntoViewSpec r0 = this.bringIntoViewSpec;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (BringIntoViewSpec) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, BringIntoViewSpec_androidKt.getLocalBringIntoViewSpec());
    }

    private final Rect getFocusedChildBounds() {
        if (isAttached() == true) goto L5;
        return null;
    L5:
        LayoutCoordinates r0 = DelegatableNodeKt.requireLayoutCoordinates(this);
        LayoutCoordinates r2 = this.focusedChild;
        if (r2 != null) goto L8;
    L15:
        return null;
    L8:
        if (r2.isAttached() == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L15;
        return r0.localBoundingBoxOf(r2, false);
    }

    private final void launchAnimation() {
        BringIntoViewSpec r0 = requireBringIntoViewSpec();
        if ((!this.isAnimationRunning) == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("launchAnimation called when previous animation was running");
    L5:
        BuildersKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(this, new UpdatableAnimationState(requireBringIntoViewSpec().getScrollAnimationSpec()), r0, null), 1, null);
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    /* JADX INFO: renamed from: getViewportSize-YbymL2g$foundation_release, reason: not valid java name */
    public final long m557getViewportSizeYbymL2g$foundation_release() {
        return this.viewportSize;
    }

    public static final /* synthetic */ BringIntoViewRequestPriorityQueue access$getBringIntoViewRequests$p(ContentInViewNode r0) {
        return r0.bringIntoViewRequests;
    }

    public static final /* synthetic */ Rect access$getFocusedChildBounds(ContentInViewNode r0) {
        return r0.getFocusedChildBounds();
    }

    public static final /* synthetic */ boolean access$getReverseDirection$p(ContentInViewNode r0) {
        return r0.reverseDirection;
    }

    public static final /* synthetic */ ScrollingLogic access$getScrollingLogic$p(ContentInViewNode r0) {
        return r0.scrollingLogic;
    }

    public static final /* synthetic */ boolean access$getTrackingFocusedChild$p(ContentInViewNode r0) {
        return r0.trackingFocusedChild;
    }

    public static final /* synthetic */ boolean access$isAnimationRunning$p(ContentInViewNode r0) {
        return r0.isAnimationRunning;
    }

    public static final /* synthetic */ void access$launchAnimation(ContentInViewNode r0) {
        r0.launchAnimation();
    }

    private final float calculateScrollDelta(BringIntoViewSpec r8) {
        if (IntSize.equals-impl0(this.viewportSize, IntSize.Companion.getZero-YbymL2g()) == false) goto L5;
        return MenuKt.ClosedAlphaTarget;
    L5:
        Rect r0 = findBringIntoViewRequest();
        if (r0 == null) goto L8;
    L13:
        long r1 = IntSizeKt.toSize-ozmzZPI(this.viewportSize);
        Orientation r3 = this.orientation;
        int r4 = WhenMappings.$EnumSwitchMapping$0[r3.ordinal()];
        if (r4 == 1) goto L21;
        if (r4 != 2) goto L19;
        return r8.calculateScrollDistance(r0.getLeft(), r0.getRight() - r0.getLeft(), Float.intBitsToFloat((int) (r1 >> 32)));
    L19:
        throw new NoWhenBranchMatchedException();
    L21:
        return r8.calculateScrollDistance(r0.getTop(), r0.getBottom() - r0.getTop(), Float.intBitsToFloat((int) (r1 & 4294967295L)));
    L8:
        if (this.trackingFocusedChild == false) goto L10;
        r0 = getFocusedChildBounds();
    L11:
        if (r0 != null) goto L13;
        return MenuKt.ClosedAlphaTarget;
    L10:
        r0 = null;
        goto L11
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Rect calculateRectForParent(Rect r5) {
        if ((!IntSize.equals-impl0(this.viewportSize, IntSize.Companion.getZero-YbymL2g())) == true) goto L6;
        InlineClassHelperKt.throwIllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.");
    L6:
        return m553computeDestinationO0kMr_c(r5, this.viewportSize);
    }

    public final void onFocusBoundsChanged(LayoutCoordinates r3) {
        this.focusedChild = r3;
        if (this.childWasMaxVisibleBeforeViewportShrunk == false) goto L9;
        Rect r4 = getFocusedChildBounds();
        if (r4 == null) goto L9;
        if (m554isMaxVisibleO0kMr_c(r4, this.viewportSize) == true) goto L9;
        this.trackingFocusedChild = true;
        launchAnimation();
    L9:
        this.childWasMaxVisibleBeforeViewportShrunk = false;
    }

    /* JADX INFO: renamed from: onRemeasured-ozmzZPI, reason: not valid java name */
    public void m558onRemeasuredozmzZPI(long r3) {
        long r0 = this.viewportSize;
        this.viewportSize = r3;
        if (m551compareToTemP2vQ(r3, r0) < 0) goto L6;
        return;
    L6:
        if (this.isAnimationRunning == false) goto L8;
        return;
    L8:
        if (this.trackingFocusedChild == true) goto L19;
        Rect r4 = getFocusedChildBounds();
        if (r4 != null) goto L14;
        return;
    L14:
        if (m554isMaxVisibleO0kMr_c(r4, r0) == false) goto L18;
        this.childWasMaxVisibleBeforeViewportShrunk = true;
        return;
    L18:
        return;
    }

    public static final /* synthetic */ float access$calculateScrollDelta(ContentInViewNode r0, BringIntoViewSpec r1) {
        return r0.calculateScrollDelta(r1);
    }

    public static final /* synthetic */ void access$setAnimationRunning$p(ContentInViewNode r0, boolean r1) {
        r0.isAnimationRunning = r1;
    }

    public static final /* synthetic */ void access$setTrackingFocusedChild$p(ContentInViewNode r0, boolean r1) {
        r0.trackingFocusedChild = r1;
    }

    /* JADX INFO: renamed from: compareTo-TemP2vQ, reason: not valid java name */
    private final int m551compareToTemP2vQ(long r3, long r5) {
        Orientation r0 = this.orientation;
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L8;
        return Intrinsics.compare((int) (r3 >> 32), (int) (r5 >> 32));
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return Intrinsics.compare((int) (r3 & 4294967295L), (int) (r5 & 4294967295L));
    }

    /* JADX INFO: renamed from: compareTo-iLBOSCw, reason: not valid java name */
    private final int m552compareToiLBOSCw(long r3, long r5) {
        Orientation r0 = this.orientation;
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L8;
        return Float.compare(Float.intBitsToFloat((int) (r3 >> 32)), Float.intBitsToFloat((int) (r5 >> 32)));
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return Float.compare(Float.intBitsToFloat((int) (r3 & 4294967295L)), Float.intBitsToFloat((int) (r5 & 4294967295L)));
    }

    /* JADX INFO: renamed from: computeDestination-O0kMr_c, reason: not valid java name */
    private final Rect m553computeDestinationO0kMr_c(Rect r3, long r4) {
        return r3.translate-k-4lQ0M(Offset.constructor-impl(m556relocationOffsetBMxPBkI(r3, r4) ^ (-9223372034707292160L)));
    }

    /* JADX INFO: renamed from: isMaxVisible-O0kMr_c, reason: not valid java name */
    private final boolean m554isMaxVisibleO0kMr_c(Rect r4, long r5) {
        long r6 = m556relocationOffsetBMxPBkI(r4, r5);
        if (Math.abs(Float.intBitsToFloat((int) (r6 >> 32))) <= 0.5f) goto L5;
    L7:
        return false;
    L5:
        if (Math.abs(Float.intBitsToFloat((int) (r6 & 4294967295L))) > 0.5f) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: relocationOffset-BMxPBkI, reason: not valid java name */
    private final long m556relocationOffsetBMxPBkI(Rect r8, long r9) {
        long r10 = IntSizeKt.toSize-ozmzZPI(r9);
        int r0 = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (r0 != 1) goto L5;
        float r11 = requireBringIntoViewSpec().calculateScrollDistance(r8.getTop(), r8.getBottom() - r8.getTop(), Float.intBitsToFloat((int) (r10 & 4294967295L)));
        return Offset.constructor-impl((Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget) << 32) | (Float.floatToRawIntBits(r11) & 4294967295L));
    L5:
        if (r0 != 2) goto L8;
        return Offset.constructor-impl((Float.floatToRawIntBits(requireBringIntoViewSpec().calculateScrollDistance(r8.getLeft(), r8.getRight() - r8.getLeft(), Float.intBitsToFloat((int) (r10 >> 32)))) << 32) | (((long) Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget)) & 4294967295L));
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Object bringChildIntoView(Function0<Rect> r9, Continuation<? super Unit> r10) {
        Rect r2 = (Rect) r9.invoke();
        boolean r7 = false;
        if (r2 != null) goto L5;
    L7:
        if (r7 == false) goto L9;
        kotlinx.coroutines.j r1 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r10), 1);
        r1.C();
        Request r0 = new Request(r9, r1);
        if (access$getBringIntoViewRequests$p(this).enqueue(r0) == true) goto L13;
    L15:
        Object r11 = r1.B();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L19:
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        return r11;
    L22:
        return Unit.INSTANCE;
    L13:
        if (access$isAnimationRunning$p(this) == true) goto L15;
        access$launchAnimation(this);
        goto L15
    L9:
        return Unit.INSTANCE;
    L5:
        if (m555isMaxVisibleO0kMr_c$default(this, r2, 0, 1, null) == true) goto L7;
        r7 = true;
        goto L7
    }

    public final void update(Orientation r1, boolean r2, BringIntoViewSpec r3) {
        this.orientation = r1;
        this.reverseDirection = r2;
        this.bringIntoViewSpec = r3;
    }

    public ContentInViewNode(Orientation r1, ScrollingLogic r2, boolean r3, BringIntoViewSpec r4) {
        this.orientation = r1;
        this.scrollingLogic = r2;
        this.reverseDirection = r3;
        this.bringIntoViewSpec = r4;
        this.bringIntoViewRequests = new BringIntoViewRequestPriorityQueue();
        this.viewportSize = IntSize.Companion.getZero-YbymL2g();
    }

    /* JADX INFO: renamed from: isMaxVisible-O0kMr_c$default, reason: not valid java name */
    public static /* synthetic */ boolean m555isMaxVisibleO0kMr_c$default(ContentInViewNode r0, Rect r1, long r2, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = r0.viewportSize;
    L6:
        return r0.m554isMaxVisibleO0kMr_c(r1, r2);
    }
}
