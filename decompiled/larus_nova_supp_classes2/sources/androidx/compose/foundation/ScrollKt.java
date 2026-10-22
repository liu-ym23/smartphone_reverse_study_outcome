package androidx.compose.foundation;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a2\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\t\u001a<\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\t\u001a2\u0010\u000f\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\t\u001a<\u0010\u000f\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\t\u001aJ\u0010\u0010\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¨\u0006\u0014"}, d2 = {"rememberScrollState", "Landroidx/compose/foundation/ScrollState;", "initial", "", "(ILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/ScrollState;", "verticalScroll", "Landroidx/compose/ui/Modifier;", "state", "enabled", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "reverseScrolling", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "horizontalScroll", "scroll", "isScrollable", "isVertical", "useLocalOverscrollFactory", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ScrollKt {
    public static /* synthetic */ ScrollState a(int r0) {
        return rememberScrollState$lambda$1$lambda$0(r0);
    }

    private static final ScrollState rememberScrollState$lambda$1$lambda$0(int r1) {
        return new ScrollState(r1);
    }

    public static final ScrollState rememberScrollState(final int r5, Composer r6, int r7, int r8) {
        boolean r0 = true;
        if ((r8 & 1) == 0) goto L6;
        r5 = 0;
    L6:
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventStart(-1464256199, r7, -1, "androidx.compose.foundation.rememberScrollState (Scroll.kt:68)");
    L8:
        Object[] r9 = new Object[0];
        Saver<ScrollState, ?> r2 = ScrollState.Companion.getSaver();
        if (((r7 & 14) ^ 6) <= 4) goto L13;
        if (r6.changed(r5) == false) goto L13;
    L16:
        Object r10 = r6.rememberedValue();
        if (r0 == false) goto L19;
    L20:
        r10 = new f1(r5);
        r6.updateRememberedValue(r10);
    L21:
        ScrollState r11 = (ScrollState) RememberSaveableKt.rememberSaveable(r9, r2, (Function0) r10, r6, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r11;
    L19:
        if (r10 != Composer.Companion.getEmpty()) goto L21;
    L13:
        if ((r7 & 6) == 4) goto L16;
        r0 = false;
        goto L16
    }

    public static final Modifier horizontalScroll(Modifier r10, ScrollState r11, boolean r12, FlingBehavior r13, boolean r14) {
        return scroll$default(r10, r11, r14, r13, r12, false, true, null, 64, null);
    }

    public static final Modifier verticalScroll(Modifier r10, ScrollState r11, boolean r12, FlingBehavior r13, boolean r14) {
        return scroll$default(r10, r11, r14, r13, r12, true, true, null, 64, null);
    }

    public static final Modifier horizontalScroll(Modifier r8, ScrollState r9, OverscrollEffect r10, boolean r11, FlingBehavior r12, boolean r13) {
        return scroll(r8, r9, r13, r12, r11, false, false, r10);
    }

    public static final Modifier verticalScroll(Modifier r8, ScrollState r9, OverscrollEffect r10, boolean r11, FlingBehavior r12, boolean r13) {
        return scroll(r8, r9, r13, r12, r11, true, false, r10);
    }

    public static /* synthetic */ Modifier horizontalScroll$default(Modifier r0, ScrollState r1, boolean r2, FlingBehavior r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = true;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 8) == 0) goto L12;
        r4 = false;
    L12:
        return horizontalScroll(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Modifier verticalScroll$default(Modifier r0, ScrollState r1, boolean r2, FlingBehavior r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = true;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 8) == 0) goto L12;
        r4 = false;
    L12:
        return verticalScroll(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Modifier horizontalScroll$default(Modifier r6, ScrollState r7, OverscrollEffect r8, boolean r9, FlingBehavior r10, boolean r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L5;
        boolean r3 = true;
    L7:
        if ((r12 & 8) == 0) goto L9;
        r10 = null;
    L9:
        FlingBehavior r4 = r10;
        if ((r12 & 16) == 0) goto L12;
        boolean r5 = false;
    L14:
        return horizontalScroll(r6, r7, r8, r3, r4, r5);
    L12:
        r5 = r11;
        goto L14
    L5:
        r3 = r9;
        goto L7
    }

    private static final Modifier scroll(Modifier r14, ScrollState r15, boolean r16, FlingBehavior r17, boolean r18, boolean r19, boolean r20, OverscrollEffect r21) {
        if (r19 == false) goto L5;
        Orientation r1 = Orientation.Vertical;
    L7:
        return ScrollingContainerKt.scrollingContainer$default(r14, r15, r1, r18, r16, r17, r15.getInternalInteractionSource$foundation_release(), r20, r21, null, 256, null).then(new ScrollingLayoutElement(r15, r16, r19));
    L5:
        r1 = Orientation.Horizontal;
        goto L7
    }

    public static /* synthetic */ Modifier verticalScroll$default(Modifier r6, ScrollState r7, OverscrollEffect r8, boolean r9, FlingBehavior r10, boolean r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L5;
        boolean r3 = true;
    L7:
        if ((r12 & 8) == 0) goto L9;
        r10 = null;
    L9:
        FlingBehavior r4 = r10;
        if ((r12 & 16) == 0) goto L12;
        boolean r5 = false;
    L14:
        return verticalScroll(r6, r7, r8, r3, r4, r5);
    L12:
        r5 = r11;
        goto L14
    L5:
        r3 = r9;
        goto L7
    }

    public static /* synthetic */ Modifier scroll$default(Modifier r9, ScrollState r10, boolean r11, FlingBehavior r12, boolean r13, boolean r14, boolean r15, OverscrollEffect r16, int r17, Object r18) {
        if ((r17 & 64) == 0) goto L5;
        OverscrollEffect r8 = null;
    L7:
        return scroll(r9, r10, r11, r12, r13, r14, r15, r8);
    L5:
        r8 = r16;
        goto L7
    }
}
