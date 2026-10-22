package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0000\u001a4\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0000\u001a6\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0014H\u0002¨\u0006\u001b"}, d2 = {"textFieldScrollable", "Landroidx/compose/ui/Modifier;", "scrollerPosition", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "defaultTextFieldScroll", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "textLayoutResultProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "getCursorRectInScroller", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/Density;", "cursorOffset", "", "transformedText", "Landroidx/compose/ui/text/input/TransformedText;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "rtl", "textFieldWidth", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldScrollKt {

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

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass2 implements Function3<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;

        public AnonymousClass2(TextFieldScrollerPosition r1, boolean r2, MutableInteractionSource r3) {
            this.$scrollerPosition = r1;
            this.$enabled = r2;
            this.$interactionSource = r3;
        }

        public static /* synthetic */ float a(TextFieldScrollerPosition r0, float r1) {
            return invoke$lambda$1$lambda$0(r0, r1);
        }

        private static final float invoke$lambda$1$lambda$0(TextFieldScrollerPosition r2, float r3) {
            float r0 = r2.getOffset() + r3;
            if (r0 <= r2.getMaximum()) goto L6;
            r3 = r2.getMaximum() - r2.getOffset();
        L8:
            r2.setOffset(r2.getOffset() + r3);
            return r3;
        L6:
            if (r0 >= MenuKt.ClosedAlphaTarget) goto L8;
            r3 = -r2.getOffset();
            goto L8
        }

        public final Modifier invoke(Modifier r13, Composer r14, int r15) {
            r14.startReplaceGroup(805428266);
            if (ComposerKt.isTraceInProgress() == false) goto L6;
            ComposerKt.traceEventStart(805428266, r15, -1, "androidx.compose.foundation.text.textFieldScrollable.<anonymous> (TextFieldScroll.kt:71)");
        L6:
            if (r14.consume(CompositionLocalsKt.getLocalLayoutDirection()) != LayoutDirection.Rtl) goto L8;
            boolean r16 = true;
        L10:
            if (this.$scrollerPosition.getOrientation() == Orientation.Vertical) goto L14;
            if (r16 == false) goto L14;
            boolean r7 = false;
        L15:
            boolean r17 = r14.changed(this.$scrollerPosition);
            final TextFieldScrollerPosition r18 = this.$scrollerPosition;
            Object r2 = r14.rememberedValue();
            if (r17 == false) goto L18;
        L19:
            r2 = new y3(r18);
            r14.updateRememberedValue(r2);
        L20:
            ScrollableState r19 = ScrollableStateKt.rememberScrollableState((Function1) r2, r14, 0);
            boolean r110 = r14.changed(r19) | r14.changed(this.$scrollerPosition);
            TextFieldScrollerPosition r3 = this.$scrollerPosition;
            Object r4 = r14.rememberedValue();
            if (r110 == false) goto L23;
        L24:
            r4 = new TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1(r19, r3);
            r14.updateRememberedValue(r4);
        L25:
            TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1 r5 = (TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1) r4;
            Modifier.Companion r6 = Modifier.Companion;
            Orientation r8 = this.$scrollerPosition.getOrientation();
            if (this.$enabled == true) goto L28;
        L33:
            boolean r9 = false;
        L34:
            Modifier r111 = ScrollableKt.scrollable$default(r6, r5, r8, r9, r7, null, this.$interactionSource, 16, null);
            if (ComposerKt.isTraceInProgress() == false) goto L37;
            ComposerKt.traceEventEnd();
        L37:
            r14.endReplaceGroup();
            return r111;
        L28:
            if (this.$scrollerPosition.getMaximum() != MenuKt.ClosedAlphaTarget) goto L30;
            boolean r112 = true;
        L31:
            if (r112 == true) goto L33;
            r9 = true;
            goto L34
        L30:
            r112 = false;
            goto L31
        L23:
            if (r4 != Composer.Companion.getEmpty()) goto L25;
        L18:
            if (r2 != Composer.Companion.getEmpty()) goto L20;
        L14:
            r7 = true;
            goto L15
        L8:
            r16 = false;
            goto L10
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((Modifier) r1, (Composer) r2, ((Number) r3).intValue());
        }
    }

    public static final Modifier textFieldScrollable(Modifier r2, final TextFieldScrollerPosition r3, final MutableInteractionSource r4, final boolean r5) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new TextFieldScrollKt$textFieldScrollable$$inlined$debugInspectorInfo$1(r3, r4, r5);
    L7:
        return ComposedModifierKt.composed(r2, r0, new AnonymousClass2(r3, r5, r4));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    public static final Modifier defaultTextFieldScroll(Modifier r4, TextFieldScrollerPosition r5, TextFieldValue r6, VisualTransformation r7, Function0<TextLayoutResultProxy> r8) {
        Orientation r0 = r5.getOrientation();
        int r1 = r5.m1472getOffsetToFollow5zctL8(r6.getSelection-d9O1mEE());
        r5.m1474setPreviousSelection5zctL8(r6.getSelection-d9O1mEE());
        TransformedText r9 = ValidatingOffsetMappingKt.filterWithValidation(r7, r6.getAnnotatedString());
        int r10 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r10 != 1) goto L5;
        Modifier r11 = new VerticalScrollLayoutModifier(r5, r1, r9, r8);
    L11:
        return ClipKt.clipToBounds(r4).then(r11);
    L5:
        if (r10 != 2) goto L8;
        r11 = new HorizontalScrollLayoutModifier(r5, r1, r9, r8);
        goto L11
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ Rect access$getCursorRectInScroller(Density r0, int r1, TransformedText r2, TextLayoutResult r3, boolean r4, int r5) {
        return getCursorRectInScroller(r0, r1, r2, r3, r4, r5);
    }

    private static final Rect getCursorRectInScroller(Density r7, int r8, TransformedText r9, TextLayoutResult r10, boolean r11, int r12) {
        if (r10 == null) goto L5;
        Rect r13 = r10.getCursorRect(r9.getOffsetMapping().originalToTransformed(r8));
        if (r13 == null) goto L5;
    L6:
        Rect r0 = r13;
        int r14 = r7.roundToPx-0680j_4(TextFieldCursor_androidKt.getDefaultCursorThickness());
        if (r11 == false) goto L9;
        float r15 = (r12 - r0.getLeft()) - r14;
    L10:
        float r1 = r15;
        if (r11 == false) goto L13;
        float r3 = r12 - r0.getLeft();
    L15:
        return Rect.copy$default(r0, r1, MenuKt.ClosedAlphaTarget, r3, MenuKt.ClosedAlphaTarget, 10, null);
    L13:
        r3 = r0.getLeft() + r14;
        goto L15
    L9:
        r15 = r0.getLeft();
    L5:
        r13 = Rect.Companion.getZero();
        goto L6
    }

    public static /* synthetic */ Modifier textFieldScrollable$default(Modifier r0, TextFieldScrollerPosition r1, MutableInteractionSource r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = true;
    L9:
        return textFieldScrollable(r0, r1, r2, r3);
    }
}
