package androidx.compose.foundation.text.selection;

import androidx.collection.SieveCacheKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a+\u0010\u0011\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0015\u001a\"\u0010\u0016\u001a\u00020\u000e*\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0000\u001a\u0014\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0000\u001a0\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\u0011\u0010\u001f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b H\u0001¢\u0006\u0002\u0010!¨\u0006\""}, d2 = {"SelectionHandle", "", "offsetProvider", "Landroidx/compose/foundation/text/selection/OffsetProvider;", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "handlesCrossed", "minTouchTargetSize", "Landroidx/compose/ui/unit/DpSize;", "lineHeight", "", "modifier", "Landroidx/compose/ui/Modifier;", "SelectionHandle-wLIcFTc", "(Landroidx/compose/foundation/text/selection/OffsetProvider;ZLandroidx/compose/ui/text/style/ResolvedTextDirection;ZJFLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SelectionHandleIcon", "iconVisible", "Lkotlin/Function0;", "isLeft", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "drawSelectionHandle", "createHandleImage", "Landroidx/compose/ui/graphics/ImageBitmap;", "Landroidx/compose/ui/draw/CacheDrawScope;", "radius", "HandlePopup", "positionProvider", "handleReferencePoint", "Landroidx/compose/ui/Alignment;", "content", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/text/selection/OffsetProvider;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidSelectionHandles_androidKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Function3<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ Function0<Boolean> $iconVisible;
        final /* synthetic */ boolean $isLeft;

        public AnonymousClass1(Function0<Boolean> r1, boolean r2) {
            this.$iconVisible = r1;
            this.$isLeft = r2;
        }

        public static /* synthetic */ Unit a(Function0 r0, boolean r1, ImageBitmap r2, ColorFilter r3, ContentDrawScope r4) {
            return invoke$lambda$3$lambda$2$lambda$1(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ DrawResult b(long r0, Function0 r2, boolean r3, CacheDrawScope r4) {
            return invoke$lambda$3$lambda$2(r0, r2, r3, r4);
        }

        public final Modifier invoke(Modifier r6, Composer r7, int r8) {
            r7.startReplaceGroup(-196777734);
            if (ComposerKt.isTraceInProgress() == false) goto L5;
            ComposerKt.traceEventStart(-196777734, r8, -1, "androidx.compose.foundation.text.selection.drawSelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:129)");
        L5:
            final long r0 = ((TextSelectionColors) r7.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m1911getHandleColor0d7_KjU();
            boolean r9 = (r7.changed(r0) | r7.changed(this.$iconVisible)) | r7.changed(this.$isLeft);
            final Function0<Boolean> r2 = this.$iconVisible;
            final boolean r3 = this.$isLeft;
            Object r4 = r7.rememberedValue();
            if (r9 == false) goto L8;
        L9:
            r4 = new g(r0, r2, r3);
            r7.updateRememberedValue(r4);
        L10:
            Modifier r10 = DrawModifierKt.drawWithCache(r6, (Function1) r4);
            if (ComposerKt.isTraceInProgress() == false) goto L13;
            ComposerKt.traceEventEnd();
        L13:
            r7.endReplaceGroup();
            return r10;
        L8:
            if (r4 != Composer.Companion.getEmpty()) goto L10;
            goto L9
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((Modifier) r1, (Composer) r2, ((Number) r3).intValue());
        }

        private static final DrawResult invoke$lambda$3$lambda$2(long r7, final Function0 r9, final boolean r10, CacheDrawScope r11) {
            final ImageBitmap r0 = AndroidSelectionHandles_androidKt.createHandleImage(r11, Float.intBitsToFloat((int) (r11.getSize-NH-jbRc() >> 32)) / 2.0f);
            final ColorFilter r8 = ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, r7, 0, 2, null);
            return r11.onDrawWithContent(new h(r9, r10, r0, r8));
        }

        private static final Unit invoke$lambda$3$lambda$2$lambda$1(Function0 r18, boolean r19, ImageBitmap r20, ColorFilter r21, ContentDrawScope r22) {
            r22.drawContent();
            if (((Boolean) r18.invoke()).booleanValue() == false) goto L5;
            if (r19 == false) goto L13;
            long r0 = r22.getCenter-F1C5BW0();
            DrawContext r2 = r22.getDrawContext();
            long r3 = r2.getSize-NH-jbRc();
            r2.getCanvas().save();
            r2.getTransform().scale-0AR0LA0(-1.0f, 1.0f, r0);     // Catch: Throwable -> L10
            DrawScope.-CC.drawImage-gbVJVH8$default(r22, r20, 0, MenuKt.ClosedAlphaTarget, null, r21, 0, 46, null);     // Catch: Throwable -> L10
            r2.getCanvas().restore();
            r2.setSize-uvyYCjk(r3);
        L15:
            return Unit.INSTANCE;
        L10:
            th = move-exception;
            r2.getCanvas().restore();
            r2.setSize-uvyYCjk(r3);
            throw th;
        L13:
            DrawScope.-CC.drawImage-gbVJVH8$default(r22, r20, 0, MenuKt.ClosedAlphaTarget, null, r21, 0, 46, null);
            goto L15
        L5:
            return Unit.INSTANCE;
        }
    }

    private static final Unit HandlePopup$lambda$6(OffsetProvider r0, Alignment r1, Function2 r2, int r3, Composer r4, int r5) {
        HandlePopup(r0, r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit SelectionHandleIcon$lambda$3(Modifier r0, Function0 r1, boolean r2, int r3, Composer r4, int r5) {
        SelectionHandleIcon(r0, r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit SelectionHandle_wLIcFTc$lambda$2(OffsetProvider r12, boolean r13, ResolvedTextDirection r14, boolean r15, long r16, float r18, Modifier r19, int r20, int r21, Composer r22, int r23) {
        m1824SelectionHandlewLIcFTc(r12, r13, r14, r15, r16, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(OffsetProvider r0, boolean r1, boolean r2, SemanticsPropertyReceiver r3) {
        return SelectionHandle_wLIcFTc$lambda$1$lambda$0(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit b(Modifier r0, Function0 r1, boolean r2, int r3, Composer r4, int r5) {
        return SelectionHandleIcon$lambda$3(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit c(OffsetProvider r0, boolean r1, ResolvedTextDirection r2, boolean r3, long r4, float r6, Modifier r7, int r8, int r9, Composer r10, int r11) {
        return SelectionHandle_wLIcFTc$lambda$2(r0, r1, r2, r3, r4, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit d(OffsetProvider r0, Alignment r1, Function2 r2, int r3, Composer r4, int r5) {
        return HandlePopup$lambda$6(r0, r1, r2, r3, r4, r5);
    }

    public static final ImageBitmap createHandleImage(CacheDrawScope r31, float r32) {
        int r5 = ((int) Math.ceil(r32)) * 2;
        HandleImageCache r0 = HandleImageCache.INSTANCE;
        ImageBitmap r1 = r0.getImageBitmap();
        Canvas r2 = r0.getCanvas();
        CanvasDrawScope r11 = r0.getCanvasDrawScope();
        if (r1 == null) goto L9;
        if (r2 == null) goto L9;
        if (r5 > r1.getWidth()) goto L9;
        if (r5 > r1.getHeight()) goto L9;
    L10:
        ImageBitmap r12 = r1;
        Canvas r13 = r2;
        if (r11 != null) goto L13;
        r11 = new CanvasDrawScope();
        r0.setCanvasDrawScope(r11);
    L13:
        CanvasDrawScope r27 = r11;
        LayoutDirection r3 = r31.getLayoutDirection();
        float r4 = r12.getWidth();
        float r6 = r12.getHeight();
        long r7 = Float.floatToRawIntBits(r4);
        long r8 = Size.constructor-impl((((long) Float.floatToRawIntBits(r6)) & 4294967295L) | (r7 << 32));
        CanvasDrawScope.DrawParams r9 = r27.getDrawParams();
        Density r14 = r9.component1();
        LayoutDirection r10 = r9.component2();
        Canvas r15 = r9.component3();
        long r16 = r9.component4-NH-jbRc();
        CanvasDrawScope.DrawParams r17 = r27.getDrawParams();
        r17.setDensity(r31);
        r17.setLayoutDirection(r3);
        r17.setCanvas(r13);
        r17.setSize-uvyYCjk(r8);
        r13.save();
        DrawScope.-CC.drawRect-n-J9OG0$default(r27, Color.Companion.getBlack-0d7_KjU(), 0, r27.getSize-NH-jbRc(), MenuKt.ClosedAlphaTarget, null, null, BlendMode.Companion.getClear-0nO6VwU(), 58, null);
        DrawScope.-CC.drawRect-n-J9OG0$default(r27, ColorKt.Color(4278190080L), Offset.Companion.getZero-F1C5BW0(), Size.constructor-impl((Float.floatToRawIntBits(r32) << 32) | (((long) Float.floatToRawIntBits(r32)) & 4294967295L)), MenuKt.ClosedAlphaTarget, null, null, 0, androidx.compose.material.MenuKt.InTransitionDuration, null);
        long r18 = ColorKt.Color(4278190080L);
        long r19 = Float.floatToRawIntBits(r32);
        DrawScope.-CC.drawCircle-VaOC9Bg$default(r27, r18, r32, Offset.constructor-impl((((long) Float.floatToRawIntBits(r32)) & 4294967295L) | (r19 << 32)), MenuKt.ClosedAlphaTarget, null, null, 0, androidx.compose.material.MenuKt.InTransitionDuration, null);
        r13.restore();
        CanvasDrawScope.DrawParams r20 = r27.getDrawParams();
        r20.setDensity(r14);
        r20.setLayoutDirection(r10);
        r20.setCanvas(r15);
        r20.setSize-uvyYCjk(r16);
        return r12;
    L9:
        r1 = ImageBitmapKt.ImageBitmap-x__-hDU$default(r5, r5, ImageBitmapConfig.Companion.getAlpha8-_sVssgQ(), false, null, 24, null);
        r0.setImageBitmap(r1);
        r2 = CanvasKt.Canvas(r1);
        r0.setCanvas(r2);
        goto L10
    }

    public static final Modifier drawSelectionHandle(Modifier r1, Function0<Boolean> r2, boolean r3) {
        return ComposedModifierKt.composed$default(r1, null, new AnonymousClass1(r2, r3), 1, null);
    }

    private static final Unit SelectionHandle_wLIcFTc$lambda$1$lambda$0(OffsetProvider r8, boolean r9, boolean r10, SemanticsPropertyReceiver r11) {
        long r2 = r8.mo1350provideF1C5BW0();
        SemanticsPropertyKey<SelectionHandleInfo> r12 = SelectionHandlesKt.getSelectionHandleInfoKey();
        if (r9 == false) goto L5;
        Handle r13 = Handle.SelectionStart;
    L6:
        Handle r1 = r13;
        if (r10 == false) goto L9;
        SelectionHandleAnchor r14 = SelectionHandleAnchor.Left;
    L10:
        SelectionHandleAnchor r4 = r14;
        if ((SieveCacheKt.InvalidMapping & r2) == 9205357640488583168L) goto L13;
        boolean r5 = true;
    L14:
        r11.set(r12, new SelectionHandleInfo(r1, r2, r4, r5, null));
        return Unit.INSTANCE;
    L13:
        r5 = false;
        goto L14
    L9:
        r14 = SelectionHandleAnchor.Right;
        goto L10
    L5:
        r13 = Handle.SelectionEnd;
        goto L6
    }

    public static final void HandlePopup(final OffsetProvider r21, final Alignment r22, final Function2<? super Composer, ? super Integer, Unit> r23, Composer r24, final int r25) {
        Composer r11 = r24.startRestartGroup(-1090171650);
        if ((r25 & 6) == 0) goto L5;
        int r3 = r25;
    L14:
        if ((r25 & 48) != 0) goto L21;
        if (r11.changed(r22) == false) goto L18;
        int r5 = 32;
    L19:
        r3 = r3 | r5;
        goto L21
    L18:
        r5 = 16;
    L21:
        if ((r25 & 384) == 0) goto L23;
    L27:
        boolean r8 = false;
        if ((r3 & 147) == 146) goto L30;
        boolean r6 = true;
    L32:
        if (r11.shouldExecute(r6, r3 & 1) == true) goto L34;
        r11.skipToGroupEnd();
    L56:
        ScopeUpdateScope r2 = r11.endRestartGroup();
        if (r2 == null) goto L60;
        r2.updateScope(new a(r21, r22, r23, r25));
        return;
    L60:
        return;
    L34:
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventStart(-1090171650, r3, -1, "androidx.compose.foundation.text.selection.HandlePopup (AndroidSelectionHandles.android.kt:219)");
    L37:
        if ((r3 & 112) != 32) goto L39;
        boolean r4 = true;
    L41:
        if ((r3 & 14) != 4) goto L43;
    L46:
        r8 = true;
    L47:
        boolean r7 = r4 | r8;
        Object r9 = r11.rememberedValue();
        if (r7 == false) goto L50;
    L51:
        r9 = new HandlePositionProvider(r22, r21);
        r11.updateRememberedValue(r9);
    L52:
        AndroidPopup_androidKt.Popup((HandlePositionProvider) r9, null, new PopupProperties(false, false, false, null, true, false, 15, null), r23, r11, ((r3 << 3) & 7168) | 384, 2);
        if (ComposerKt.isTraceInProgress() == false) goto L56;
        ComposerKt.traceEventEnd();
        goto L56
    L50:
        if (r9 != Composer.Companion.getEmpty()) goto L52;
    L43:
        if ((r3 & 8) == 0) goto L47;
        if (r11.changed(r21) == false) goto L47;
    L39:
        r4 = false;
        goto L41
    L30:
        r6 = false;
        goto L32
    L23:
        if (r11.changedInstance(r23) == false) goto L25;
        int r10 = 256;
    L26:
        r3 = r3 | r10;
        goto L27
    L25:
        r10 = 128;
        goto L26
    L5:
        if ((r25 & 8) != 0) goto L7;
        boolean r12 = r11.changed(r21);
    L8:
        if (r12 == false) goto L10;
        int r13 = 4;
    L11:
        r3 = r13 | r25;
        goto L14
    L10:
        r13 = 2;
        goto L11
    L7:
        r12 = r11.changedInstance(r21);
        goto L8
    }

    public static final void SelectionHandleIcon(final Modifier r5, final Function0<Boolean> r6, final boolean r7, Composer r8, final int r9) {
        Composer r10 = r8.startRestartGroup(2111672474);
        if ((r9 & 6) == 0) goto L5;
        int r1 = r9;
    L11:
        if ((r9 & 48) != 0) goto L18;
        if (r10.changedInstance(r6) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r9 & 384) != 0) goto L25;
        if (r10.changed(r7) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r1 & 147) == 146) goto L27;
        boolean r4 = true;
    L29:
        if (r10.shouldExecute(r4, r1 & 1) == true) goto L31;
        r10.skipToGroupEnd();
    L37:
        ScopeUpdateScope r11 = r10.endRestartGroup();
        if (r11 == null) goto L41;
        r11.updateScope(new b(r5, r6, r7, r9));
        return;
    L41:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventStart(2111672474, r1, -1, "androidx.compose.foundation.text.selection.SelectionHandleIcon (AndroidSelectionHandles.android.kt:123)");
    L33:
        SpacerKt.Spacer(drawSelectionHandle(SizeKt.m1016sizeVpY3zN4(r5, SelectionHandlesKt.getHandleWidth(), SelectionHandlesKt.getHandleHeight()), r6, r7), r10, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventEnd();
        goto L37
    L27:
        r4 = false;
        goto L29
    L5:
        if (r10.changed(r5) == false) goto L7;
        int r12 = 4;
    L8:
        r1 = r12 | r9;
        goto L11
    L7:
        r12 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: SelectionHandle-wLIcFTc, reason: not valid java name */
    public static final void m1824SelectionHandlewLIcFTc(final OffsetProvider r18, final boolean r19, final ResolvedTextDirection r20, final boolean r21, long r22, final float r24, final Modifier r25, Composer r26, final int r27, final int r28) {
        Composer r11 = r26.startRestartGroup(-466280168);
        if ((r28 & 1) == 0) goto L6;
        int r1 = r27 | 6;
    L17:
        if ((r28 & 2) == 0) goto L20;
        r1 = r1 | 48;
    L27:
        if ((r28 & 4) == 0) goto L30;
        r1 = r1 | 384;
    L37:
        if ((r28 & 8) == 0) goto L40;
        r1 = r1 | 3072;
    L47:
        if ((r27 & 24576) != 0) goto L55;
        final long r5 = r22;
        if ((r28 & 16) == 0) goto L51;
    L53:
        int r3 = 8192;
    L54:
        r1 = r1 | r3;
    L57:
        if ((r28 & 64) == 0) goto L60;
        r1 = r1 | 1572864;
    L67:
        if ((533651 & r1) == 533650) goto L69;
        boolean r4 = true;
    L71:
        if (r11.shouldExecute(r4, r1 & 1) == false) goto L113;
        r11.startDefaults();
        if ((r27 & 1) == 0) goto L81;
        if (r11.getDefaultsInvalid() == true) goto L81;
        r11.skipToGroupEnd();
        if ((r28 & 16) != 0) goto L83;
    L84:
        final long r16 = r5;
        r11.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L87;
        ComposerKt.traceEventStart(-466280168, r1, -1, "androidx.compose.foundation.text.selection.SelectionHandle (AndroidSelectionHandles.android.kt:65)");
    L87:
        final boolean r6 = SelectionHandlesKt.isLeftSelectionHandle(r19, r20, r21);
        AbsoluteAlignment r0 = AbsoluteAlignment.INSTANCE;
        if (r6 == false) goto L90;
        Alignment r2 = r0.getTopRight();
    L91:
        Alignment r13 = r2;
        int r7 = r1 & 14;
        if (r7 != 4) goto L94;
    L99:
        boolean r8 = true;
    L101:
        if ((r1 & 112) != 32) goto L103;
        boolean r9 = true;
    L104:
        boolean r10 = (r8 | r9) | r11.changed(r6);
        Object r12 = r11.rememberedValue();
        if (r10 == false) goto L107;
    L108:
        r12 = new c(r18, r19, r6);
        r11.updateRememberedValue(r12);
    L109:
        final Modifier r14 = SemanticsModifierKt.semantics$default(r25, false, (Function1) r12, 1, null);
        final ViewConfiguration r15 = (ViewConfiguration) r11.consume(CompositionLocalsKt.getLocalViewConfiguration());
        HandlePopup(r18, r13, ComposableLambdaKt.rememberComposableLambda(1365123137, true, new AndroidSelectionHandles_androidKt$SelectionHandle$1(r15, r16, r6, r14, r18), r11, 54), r11, r7 | 384);
        if (ComposerKt.isTraceInProgress() == false) goto L112;
        ComposerKt.traceEventEnd();
    L112:
        r5 = r16;
    L114:
        ScopeUpdateScope r17 = r11.endRestartGroup();
        if (r17 == null) goto L118;
        r17.updateScope(new d(r18, r19, r20, r21, r5, r24, r25, r27, r28));
        return;
    L118:
        return;
    L107:
        if (r12 != Composer.Companion.getEmpty()) goto L109;
    L103:
        r9 = false;
        goto L104
    L94:
        if ((r1 & 8) != 0) goto L96;
    L98:
        r8 = false;
        goto L101
    L96:
        if (r11.changedInstance(r18) == false) goto L98;
    L90:
        r2 = r0.getTopLeft();
    L83:
        r1 = r1 & (-57345);
    L81:
        if ((r28 & 16) == 0) goto L84;
        r5 = DpSize.Companion.getUnspecified-MYxV2XQ();
        goto L83
    L113:
        r11.skipToGroupEnd();
        goto L114
    L69:
        r4 = false;
        goto L71
    L60:
        if ((r27 & 1572864) != 0) goto L67;
        if (r11.changed(r25) == false) goto L64;
        int r23 = 1048576;
    L65:
        r1 = r1 | r23;
        goto L67
    L64:
        r23 = 524288;
        goto L65
    L51:
        if (r11.changed(r5) == false) goto L53;
        r3 = 16384;
        goto L54
    L55:
        r5 = r22;
        goto L57
    L40:
        if ((r27 & 3072) != 0) goto L47;
        if (r11.changed(r21) == false) goto L44;
        int r29 = 2048;
    L45:
        r1 = r1 | r29;
        goto L47
    L44:
        r29 = 1024;
        goto L45
    L30:
        if ((r27 & 384) != 0) goto L37;
        if (r11.changed(r20.ordinal()) == false) goto L34;
        int r30 = 256;
    L35:
        r1 = r1 | r30;
        goto L37
    L34:
        r30 = 128;
        goto L35
    L20:
        if ((r27 & 48) != 0) goto L27;
        if (r11.changed(r19) == false) goto L24;
        int r31 = 32;
    L25:
        r1 = r1 | r31;
        goto L27
    L24:
        r31 = 16;
        goto L25
    L6:
        if ((r27 & 6) == 0) goto L8;
        r1 = r27;
        goto L17
    L8:
        if ((r27 & 8) != 0) goto L10;
        boolean r32 = r11.changed(r18);
    L11:
        if (r32 == false) goto L13;
        int r33 = 4;
    L14:
        r1 = r33 | r27;
        goto L17
    L13:
        r33 = 2;
        goto L14
    L10:
        r32 = r11.changedInstance(r18);
        goto L11
    }
}
