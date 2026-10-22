package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.SelectionHandleAnchor;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a)\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010\u0014\u001a\f\u0010\u0015\u001a\u00020\u000e*\u00020\u000eH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\b\u0010\u0005¨\u0006\u0016"}, d2 = {"Sqrt2", "", "CursorHandleHeight", "Landroidx/compose/ui/unit/Dp;", "getCursorHandleHeight", "()F", "F", "CursorHandleWidth", "getCursorHandleWidth", "CursorHandle", "", "offsetProvider", "Landroidx/compose/foundation/text/selection/OffsetProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "minTouchTargetSize", "Landroidx/compose/ui/unit/DpSize;", "CursorHandle-USBMPiE", "(Landroidx/compose/foundation/text/selection/OffsetProvider;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "DefaultCursorHandle", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "drawCursorHandle", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidCursorHandle_androidKt {
    private static final float CursorHandleHeight = 0.0f;
    private static final float CursorHandleWidth = 0.0f;
    private static final float Sqrt2 = 1.4142135f;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$drawCursorHandle$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Function3<Modifier, Composer, Integer, Modifier> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
        }

        public static /* synthetic */ Unit a(float r0, ImageBitmap r1, ColorFilter r2, ContentDrawScope r3) {
            return invoke$lambda$4$lambda$3$lambda$2(r0, r1, r2, r3);
        }

        public static /* synthetic */ DrawResult b(long r0, CacheDrawScope r2) {
            return invoke$lambda$4$lambda$3(r0, r2);
        }

        private static final DrawResult invoke$lambda$4$lambda$3(long r8, CacheDrawScope r10) {
            final float r0 = Float.intBitsToFloat((int) (r10.getSize-NH-jbRc() >> 32)) / 2.0f;
            final ImageBitmap r1 = AndroidSelectionHandles_androidKt.createHandleImage(r10, r0);
            final ColorFilter r9 = ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, r8, 0, 2, null);
            return r10.onDrawWithContent(new e(r0, r1, r9));
        }

        public final Modifier invoke(Modifier r5, Composer r6, int r7) {
            r6.startReplaceGroup(-2126899193);
            if (ComposerKt.isTraceInProgress() == false) goto L5;
            ComposerKt.traceEventStart(-2126899193, r7, -1, "androidx.compose.foundation.text.drawCursorHandle.<anonymous> (AndroidCursorHandle.android.kt:87)");
        L5:
            final long r0 = ((TextSelectionColors) r6.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m1911getHandleColor0d7_KjU();
            Modifier.Companion r8 = Modifier.Companion;
            boolean r2 = r6.changed(r0);
            Object r3 = r6.rememberedValue();
            if (r2 == false) goto L8;
        L9:
            r3 = new d(r0);
            r6.updateRememberedValue(r3);
        L10:
            Modifier r9 = r5.then(DrawModifierKt.drawWithCache(r8, (Function1) r3));
            if (ComposerKt.isTraceInProgress() == false) goto L13;
            ComposerKt.traceEventEnd();
        L13:
            r6.endReplaceGroup();
            return r9;
        L8:
            if (r3 != Composer.Companion.getEmpty()) goto L10;
            goto L9
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((Modifier) r1, (Composer) r2, ((Number) r3).intValue());
        }

        private static final Unit invoke$lambda$4$lambda$3$lambda$2(float r17, ImageBitmap r18, ColorFilter r19, ContentDrawScope r20) {
            r20.drawContent();
            DrawContext r1 = r20.getDrawContext();
            long r2 = r1.getSize-NH-jbRc();
            r1.getCanvas().save();
            DrawTransform r0 = r1.getTransform();     // Catch: Throwable -> L6
            DrawTransform.-CC.translate$default(r0, r17, MenuKt.ClosedAlphaTarget, 2, null);     // Catch: Throwable -> L6
            r0.rotate-Uv8p0NA(45.0f, Offset.Companion.getZero-F1C5BW0());     // Catch: Throwable -> L6
            DrawScope.-CC.drawImage-gbVJVH8$default(r20, r18, 0, MenuKt.ClosedAlphaTarget, null, r19, 0, 46, null);     // Catch: Throwable -> L6
            r1.getCanvas().restore();
            r1.setSize-uvyYCjk(r2);
            return Unit.INSTANCE;
        L6:
            th = move-exception;
            r1.getCanvas().restore();
            r1.setSize-uvyYCjk(r2);
            throw th;
        }
    }

    private static final Unit CursorHandle_USBMPiE$lambda$2(OffsetProvider r7, Modifier r8, long r9, int r11, int r12, Composer r13, int r14) {
        m1337CursorHandleUSBMPiE(r7, r8, r9, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    private static final Unit DefaultCursorHandle$lambda$3(Modifier r0, int r1, int r2, Composer r3, int r4) {
        DefaultCursorHandle(r0, r3, RecomposeScopeImplKt.updateChangedFlags(r1 | 1), r2);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(OffsetProvider r0, SemanticsPropertyReceiver r1) {
        return CursorHandle_USBMPiE$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit b(Modifier r0, int r1, int r2, Composer r3, int r4) {
        return DefaultCursorHandle$lambda$3(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit c(OffsetProvider r0, Modifier r1, long r2, int r4, int r5, Composer r6, int r7) {
        return CursorHandle_USBMPiE$lambda$2(r0, r1, r2, r4, r5, r6, r7);
    }

    static {
        float r0 = Dp.constructor-impl(25);
        CursorHandleHeight = r0;
        CursorHandleWidth = Dp.constructor-impl(Dp.constructor-impl(r0 * 2.0f) / 2.4142137f);
    }

    public static final float getCursorHandleHeight() {
        return CursorHandleHeight;
    }

    public static final float getCursorHandleWidth() {
        return CursorHandleWidth;
    }

    private static final Modifier drawCursorHandle(Modifier r3) {
        return ComposedModifierKt.composed$default(r3, null, AnonymousClass1.INSTANCE, 1, null);
    }

    private static final Unit CursorHandle_USBMPiE$lambda$1$lambda$0(OffsetProvider r9, SemanticsPropertyReceiver r10) {
        r10.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, r9.mo1350provideF1C5BW0(), SelectionHandleAnchor.Middle, true, null));
        return Unit.INSTANCE;
    }

    private static final void DefaultCursorHandle(final Modifier r6, Composer r7, final int r8, final int r9) {
        Composer r10 = r7.startRestartGroup(694251107);
        int r1 = r9 & 1;
        if (r1 == 0) goto L6;
        int r3 = r8 | 6;
    L14:
        if ((r3 & 3) == 2) goto L16;
        boolean r2 = true;
    L18:
        if (r10.shouldExecute(r2, r3 & 1) == false) goto L27;
        if (r1 == 0) goto L22;
        r6 = Modifier.Companion;
    L22:
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventStart(694251107, r3, -1, "androidx.compose.foundation.text.DefaultCursorHandle (AndroidCursorHandle.android.kt:82)");
    L24:
        SpacerKt.Spacer(drawCursorHandle(SizeKt.m1016sizeVpY3zN4(r6, CursorHandleWidth, CursorHandleHeight)), r10, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L28;
        ComposerKt.traceEventEnd();
    L28:
        ScopeUpdateScope r11 = r10.endRestartGroup();
        if (r11 == null) goto L32;
        r11.updateScope(new a(r6, r8, r9));
        return;
    L32:
        return;
    L27:
        r10.skipToGroupEnd();
        goto L28
    L16:
        r2 = false;
        goto L18
    L6:
        if ((r8 & 6) == 0) goto L8;
        r3 = r8;
        goto L14
    L8:
        if (r10.changed(r6) == false) goto L10;
        int r4 = 4;
    L11:
        r3 = r4 | r8;
        goto L14
    L10:
        r4 = 2;
        goto L11
    }

    public static final /* synthetic */ void access$DefaultCursorHandle(Modifier r0, Composer r1, int r2, int r3) {
        DefaultCursorHandle(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: CursorHandle-USBMPiE, reason: not valid java name */
    public static final void m1337CursorHandleUSBMPiE(final OffsetProvider r8, final Modifier r9, final long r10, Composer r12, final int r13, final int r14) {
        Composer r15 = r12.startRestartGroup(1776202187);
        if ((r14 & 1) == 0) goto L6;
        int r1 = r13 | 6;
    L17:
        if ((r14 & 2) == 0) goto L20;
        r1 = r1 | 48;
    L27:
        if ((r13 & 384) != 0) goto L36;
        if ((r14 & 4) == 0) goto L31;
    L33:
        int r3 = 128;
    L34:
        r1 = r1 | r3;
        goto L36
    L31:
        if (r15.changed(r10) == false) goto L33;
        r3 = 256;
    L36:
        if ((r1 & 147) == 146) goto L38;
        boolean r4 = true;
    L40:
        if (r15.shouldExecute(r4, r1 & 1) == false) goto L73;
        r15.startDefaults();
        if ((r13 & 1) == 0) goto L50;
        if (r15.getDefaultsInvalid() == true) goto L50;
        r15.skipToGroupEnd();
        if ((r14 & 4) != 0) goto L52;
    L53:
        r15.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L56;
        ComposerKt.traceEventStart(1776202187, r1, -1, "androidx.compose.foundation.text.CursorHandle (AndroidCursorHandle.android.kt:51)");
    L56:
        int r0 = r1 & 14;
        if (r0 != 4) goto L59;
    L64:
        boolean r2 = true;
    L65:
        Object r5 = r15.rememberedValue();
        if (r2 == false) goto L68;
    L69:
        r5 = new b(r8);
        r15.updateRememberedValue(r5);
    L70:
        final Modifier r6 = SemanticsModifierKt.semantics$default(r9, false, (Function1) r5, 1, null);
        AndroidSelectionHandles_androidKt.HandlePopup(r8, Alignment.Companion.getTopCenter(), ComposableLambdaKt.rememberComposableLambda(-1653527038, true, new AndroidCursorHandle_androidKt$CursorHandle$1(r10, r6), r15, 54), r15, r0 | 432);
        if (ComposerKt.isTraceInProgress() == false) goto L74;
        ComposerKt.traceEventEnd();
    L74:
        final long r7 = r10;
        ScopeUpdateScope r11 = r15.endRestartGroup();
        if (r11 == null) goto L78;
        r11.updateScope(new c(r8, r9, r7, r13, r14));
        return;
    L78:
        return;
    L68:
        if (r5 != Composer.Companion.getEmpty()) goto L70;
    L59:
        if ((r1 & 8) != 0) goto L61;
    L63:
        r2 = false;
        goto L65
    L61:
        if (r15.changedInstance(r8) == false) goto L63;
    L52:
        r1 = r1 & (-897);
    L50:
        if ((r14 & 4) == 0) goto L53;
        r10 = DpSize.Companion.getUnspecified-MYxV2XQ();
        goto L52
    L73:
        r15.skipToGroupEnd();
        goto L74
    L38:
        r4 = false;
        goto L40
    L20:
        if ((r13 & 48) != 0) goto L27;
        if (r15.changed(r9) == false) goto L24;
        int r16 = 32;
    L25:
        r1 = r1 | r16;
        goto L27
    L24:
        r16 = 16;
        goto L25
    L6:
        if ((r13 & 6) == 0) goto L8;
        r1 = r13;
        goto L17
    L8:
        if ((r13 & 8) != 0) goto L10;
        boolean r17 = r15.changed(r8);
    L11:
        if (r17 == false) goto L13;
        int r18 = 4;
    L14:
        r1 = r18 | r13;
        goto L17
    L13:
        r18 = 2;
        goto L14
    L10:
        r17 = r15.changedInstance(r8);
        goto L11
    }
}
