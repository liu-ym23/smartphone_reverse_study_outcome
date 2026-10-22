package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.CursorAnimationState;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000¨\u0006\f"}, d2 = {"cursor", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "enabled", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldCursorKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Function3<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ Brush $cursorBrush;
        final /* synthetic */ OffsetMapping $offsetMapping;
        final /* synthetic */ LegacyTextFieldState $state;
        final /* synthetic */ TextFieldValue $value;

        public AnonymousClass1(Brush r1, LegacyTextFieldState r2, TextFieldValue r3, OffsetMapping r4) {
            this.$cursorBrush = r1;
            this.$state = r2;
            this.$value = r3;
            this.$offsetMapping = r4;
        }

        public static /* synthetic */ Unit a(CursorAnimationState r0, OffsetMapping r1, TextFieldValue r2, LegacyTextFieldState r3, Brush r4, ContentDrawScope r5) {
            return invoke$lambda$4$lambda$3(r0, r1, r2, r3, r4, r5);
        }

        public final Modifier invoke(Modifier r9, Composer r10, int r11) {
            r10.startReplaceGroup(-84507373);
            if (ComposerKt.isTraceInProgress() == false) goto L5;
            ComposerKt.traceEventStart(-84507373, r11, -1, "androidx.compose.foundation.text.cursor.<anonymous> (TextFieldCursor.kt:46)");
        L5:
            boolean r12 = ((Boolean) r10.consume(CompositionLocalsKt.getLocalCursorBlinkEnabled())).booleanValue();
            boolean r0 = r10.changed(r12);
            Object r1 = r10.rememberedValue();
            if (r0 == false) goto L8;
        L9:
            r1 = new CursorAnimationState(r12);
            r10.updateRememberedValue(r1);
        L10:
            final CursorAnimationState r3 = (CursorAnimationState) r1;
            SolidColor r13 = this.$cursorBrush;
            boolean r2 = true;
            if ((r13 instanceof SolidColor) == false) goto L20;
            if (r13.getValue-0d7_KjU() != 16) goto L15;
            boolean r14 = true;
        L16:
            if (r14 == false) goto L20;
            r2 = false;
            goto L20
        L15:
            r14 = false;
        L20:
            if (((WindowInfo) r10.consume(CompositionLocalsKt.getLocalWindowInfo())).isWindowFocused() == true) goto L22;
        L37:
            r10.startReplaceGroup(-705473241);
            r10.endReplaceGroup();
            Modifier r15 = Modifier.Companion;
        L39:
            if (ComposerKt.isTraceInProgress() == false) goto L41;
            ComposerKt.traceEventEnd();
        L41:
            r10.endReplaceGroup();
            return r15;
        L22:
            if (this.$state.getHasFocus() == false) goto L37;
            if (TextRange.getCollapsed-impl(this.$value.getSelection-d9O1mEE()) == false) goto L37;
            if (r2 == false) goto L37;
            r10.startReplaceGroup(-707487962);
            AnnotatedString r16 = this.$value.getAnnotatedString();
            TextRange r4 = TextRange.box-impl(this.$value.getSelection-d9O1mEE());
            boolean r5 = r10.changedInstance(r3);
            Object r6 = r10.rememberedValue();
            if (r5 == false) goto L29;
        L30:
            r6 = new TextFieldCursorKt$cursor$1$1$1(r3, null);
            r10.updateRememberedValue(r6);
        L31:
            EffectsKt.LaunchedEffect(r16, r4, (Function2) r6, r10, 0);
            boolean r17 = (((r10.changedInstance(r3) | r10.changedInstance(this.$offsetMapping)) | r10.changed(this.$value)) | r10.changedInstance(this.$state)) | r10.changed(this.$cursorBrush);
            final OffsetMapping r7 = this.$offsetMapping;
            final TextFieldValue r8 = this.$value;
            final LegacyTextFieldState r18 = this.$state;
            final Brush r19 = this.$cursorBrush;
            Object r20 = r10.rememberedValue();
            if (r17 == false) goto L34;
        L35:
            r20 = new i3(r3, r7, r8, r18, r19);
            r10.updateRememberedValue(r20);
        L36:
            r15 = DrawModifierKt.drawWithContent(r9, (Function1) r20);
            r10.endReplaceGroup();
            goto L39
        L34:
            if (r20 != Composer.Companion.getEmpty()) goto L36;
        L29:
            if (r6 != Composer.Companion.getEmpty()) goto L31;
        L8:
            if (r1 != Composer.Companion.getEmpty()) goto L10;
            goto L9
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((Modifier) r1, (Composer) r2, ((Number) r3).intValue());
        }

        private static final Unit invoke$lambda$4$lambda$3(CursorAnimationState r16, OffsetMapping r17, TextFieldValue r18, LegacyTextFieldState r19, Brush r20, ContentDrawScope r21) {
            r21.drawContent();
            float r9 = r16.getCursorAlpha();
            if (r9 != MenuKt.ClosedAlphaTarget) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == true) goto L20;
            int r3 = r17.originalToTransformed(TextRange.getStart-impl(r18.getSelection-d9O1mEE()));
            TextLayoutResultProxy r4 = r19.getLayoutResult();
            if (r4 == null) goto L13;
            TextLayoutResult r5 = r4.getValue();
            if (r5 == null) goto L13;
            Rect r6 = r5.getCursorRect(r3);
            if (r6 == null) goto L13;
        L14:
            float r7 = RangesKt.coerceAtLeast((float) Math.floor(r21.toPx-0680j_4(TextFieldCursor_androidKt.getDefaultCursorThickness())), 1.0f);
            float r8 = r7 / 2;
            float r1 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r6.getLeft() + r8, Float.intBitsToFloat((int) (r21.getSize-NH-jbRc() >> 32)) - r8), r8);
            if ((((int) r7) % 2) != 1) goto L17;
            float r0 = ((float) Math.floor(r1)) + 0.5f;
        L18:
            float r10 = r6.getTop();
            long r11 = Offset.constructor-impl((Float.floatToRawIntBits(r0) << 32) | (((long) Float.floatToRawIntBits(r10)) & 4294967295L));
            float r12 = r6.getBottom();
            long r13 = Float.floatToRawIntBits(r0);
            DrawScope.-CC.drawLine-1RTmtNc$default(r21, r20, r11, Offset.constructor-impl((((long) Float.floatToRawIntBits(r12)) & 4294967295L) | (r13 << 32)), r7, 0, null, r9, null, 0, 432, null);
            goto L20
        L17:
            r0 = (float) Math.rint(r1);
        L13:
            r6 = new Rect(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget);
        L20:
            return Unit.INSTANCE;
        L5:
            r2 = false;
            goto L6
        }
    }

    public static final Modifier cursor(Modifier r0, LegacyTextFieldState r1, TextFieldValue r2, OffsetMapping r3, Brush r4, boolean r5) {
        if (r5 == true) goto L4;
        return r0;
    L4:
        return ComposedModifierKt.composed$default(r0, null, new AnonymousClass1(r4, r1, r2, r3), 1, null);
    }
}
