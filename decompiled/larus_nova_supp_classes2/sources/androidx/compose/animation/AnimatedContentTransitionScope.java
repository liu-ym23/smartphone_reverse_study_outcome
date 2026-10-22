package androidx.compose.animation;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001%J\u0017\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H¦\u0004JL\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2#\b\u0002\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00100\u000fH&¢\u0006\u0004\b\u0014\u0010\u0015JL\u0010\u0016\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2#\b\u0002\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00100\u000fH&¢\u0006\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u0017*\u00020\u001c8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u00020\"X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$\u0082\u0001\u0001&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006'À\u0006\u0001"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScope;", "S", "Landroidx/compose/animation/core/Transition$Segment;", "using", "Landroidx/compose/animation/ContentTransform;", "sizeTransform", "Landroidx/compose/animation/SizeTransform;", "slideIntoContainer", "Landroidx/compose/animation/EnterTransition;", "towards", "Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "initialOffset", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "offsetForFullSlide", "slideIntoContainer-mOhB8PU", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/EnterTransition;", "slideOutOfContainer", "Landroidx/compose/animation/ExitTransition;", "targetOffset", "slideOutOfContainer-mOhB8PU", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/ExitTransition;", "KeepUntilTransitionsFinished", "Landroidx/compose/animation/ExitTransition$Companion;", "getKeepUntilTransitionsFinished$annotations", "(Landroidx/compose/animation/ExitTransition$Companion;)V", "getKeepUntilTransitionsFinished", "(Landroidx/compose/animation/ExitTransition$Companion;)Landroidx/compose/animation/ExitTransition;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "getContentAlignment", "()Landroidx/compose/ui/Alignment;", "SlideDirection", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AnimatedContentTransitionScope<S> extends Transition.Segment<S> {

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentTransitionScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<S> {
        public static /* synthetic */ void getKeepUntilTransitionsFinished$annotations(ExitTransition.Companion r0) {
        }

        public static ExitTransition $default$getKeepUntilTransitionsFinished(AnimatedContentTransitionScope r0, ExitTransition.Companion r1) {
            return r1.getKeepUntilTransitionsFinished$animation();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: slideIntoContainer-mOhB8PU$default, reason: not valid java name */
        public static /* synthetic */ EnterTransition m116slideIntoContainermOhB8PU$default(AnimatedContentTransitionScope r2, int r3, FiniteAnimationSpec r4, Function1 r5, int r6, Object r7) {
            if (r7 != null) goto L12;
            if ((r6 & 2) == 0) goto L7;
            r4 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, null);
        L7:
            if ((r6 & 4) == 0) goto L10;
            r5 = AnimatedContentTransitionScope$slideIntoContainer$1.INSTANCE;
        L10:
            return r2.mo114slideIntoContainermOhB8PU(r3, r4, r5);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: slideIntoContainer-mOhB8PU");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: slideOutOfContainer-mOhB8PU$default, reason: not valid java name */
        public static /* synthetic */ ExitTransition m117slideOutOfContainermOhB8PU$default(AnimatedContentTransitionScope r2, int r3, FiniteAnimationSpec r4, Function1 r5, int r6, Object r7) {
            if (r7 != null) goto L12;
            if ((r6 & 2) == 0) goto L7;
            r4 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, null);
        L7:
            if ((r6 & 4) == 0) goto L10;
            r5 = AnimatedContentTransitionScope$slideOutOfContainer$1.INSTANCE;
        L10:
            return r2.mo115slideOutOfContainermOhB8PU(r3, r4, r5);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: slideOutOfContainer-mOhB8PU");
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    public static final class SlideDirection {
        public static final Companion Companion = null;
        private static final int Down = 0;
        private static final int End = 0;
        private static final int Left = 0;
        private static final int Right = 0;
        private static final int Start = 0;
        private static final int Up = 0;
        private final int value;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection$Companion;", "", "<init>", "()V", "Left", "Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "getLeft-DKzdypw", "()I", "I", "Right", "getRight-DKzdypw", "Up", "getUp-DKzdypw", "Down", "getDown-DKzdypw", "Start", "getStart-DKzdypw", "End", "getEnd-DKzdypw", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            /* JADX INFO: renamed from: getDown-DKzdypw, reason: not valid java name */
            public final int m125getDownDKzdypw() {
                return SlideDirection.access$getDown$cp();
            }

            /* JADX INFO: renamed from: getEnd-DKzdypw, reason: not valid java name */
            public final int m126getEndDKzdypw() {
                return SlideDirection.access$getEnd$cp();
            }

            /* JADX INFO: renamed from: getLeft-DKzdypw, reason: not valid java name */
            public final int m127getLeftDKzdypw() {
                return SlideDirection.access$getLeft$cp();
            }

            /* JADX INFO: renamed from: getRight-DKzdypw, reason: not valid java name */
            public final int m128getRightDKzdypw() {
                return SlideDirection.access$getRight$cp();
            }

            /* JADX INFO: renamed from: getStart-DKzdypw, reason: not valid java name */
            public final int m129getStartDKzdypw() {
                return SlideDirection.access$getStart$cp();
            }

            /* JADX INFO: renamed from: getUp-DKzdypw, reason: not valid java name */
            public final int m130getUpDKzdypw() {
                return SlideDirection.access$getUp$cp();
            }
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ SlideDirection m118boximpl(int r1) {
            return new SlideDirection(r1);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m119constructorimpl(int r0) {
            return r0;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m120equalsimpl(int r2, Object r3) {
            if ((r3 instanceof SlideDirection) == true) goto L6;
            return false;
        L6:
            if (r2 == ((SlideDirection) r3).m124unboximpl()) goto L8;
            return false;
        L8:
            return true;
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m121equalsimpl0(int r0, int r1) {
            if (r0 != r1) goto L4;
            return true;
        L4:
            return false;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m122hashCodeimpl(int r0) {
            return r0;
        }

        public boolean equals(Object r2) {
            return m120equalsimpl(this.value, r2);
        }

        public int hashCode() {
            return m122hashCodeimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m124unboximpl() {
            return this.value;
        }

        static {
            Companion = new Companion(null);
            Left = m119constructorimpl(0);
            Right = m119constructorimpl(1);
            Up = m119constructorimpl(2);
            Down = m119constructorimpl(3);
            Start = m119constructorimpl(4);
            End = m119constructorimpl(5);
        }

        public String toString() {
            return m123toStringimpl(this.value);
        }

        public static final /* synthetic */ int access$getDown$cp() {
            return Down;
        }

        public static final /* synthetic */ int access$getEnd$cp() {
            return End;
        }

        public static final /* synthetic */ int access$getLeft$cp() {
            return Left;
        }

        public static final /* synthetic */ int access$getRight$cp() {
            return Right;
        }

        public static final /* synthetic */ int access$getStart$cp() {
            return Start;
        }

        public static final /* synthetic */ int access$getUp$cp() {
            return Up;
        }

        private /* synthetic */ SlideDirection(int r1) {
            this.value = r1;
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m123toStringimpl(int r1) {
            if (m121equalsimpl0(r1, Left) == false) goto L6;
            return "Left";
        L6:
            if (m121equalsimpl0(r1, Right) == false) goto L9;
            return "Right";
        L9:
            if (m121equalsimpl0(r1, Up) == false) goto L12;
            return "Up";
        L12:
            if (m121equalsimpl0(r1, Down) == false) goto L15;
            return "Down";
        L15:
            if (m121equalsimpl0(r1, Start) == false) goto L18;
            return "Start";
        L18:
            if (m121equalsimpl0(r1, End) == false) goto L20;
            return "End";
        L20:
            return "Invalid";
        }
    }

    Alignment getContentAlignment();

    ExitTransition getKeepUntilTransitionsFinished(ExitTransition.Companion r1);

    /* JADX INFO: renamed from: slideIntoContainer-mOhB8PU, reason: not valid java name */
    EnterTransition mo114slideIntoContainermOhB8PU(int r1, FiniteAnimationSpec<IntOffset> r2, Function1<? super Integer, Integer> r3);

    /* JADX INFO: renamed from: slideOutOfContainer-mOhB8PU, reason: not valid java name */
    ExitTransition mo115slideOutOfContainermOhB8PU(int r1, FiniteAnimationSpec<IntOffset> r2, Function1<? super Integer, Integer> r3);

    ContentTransform using(ContentTransform r1, SizeTransform r2);
}
