package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.SmallIconButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000e\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u0011\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u00122\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u0013\u001a\u0014\u0010\u0014\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u0013\u0010\u0015\u001a\u00020\u0016*\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\"\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Icon", "", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "tint", "Landroidx/compose/ui/graphics/Color;", "Icon-ww6aTOc", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/graphics/ColorProducer;", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/ColorProducer;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "defaultSizeFor", "isInfinite", "", "Landroidx/compose/ui/geometry/Size;", "isInfinite-uvyYCjk", "(J)Z", "DefaultIconSizeModifier", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IconKt {
    private static final Modifier DefaultIconSizeModifier = null;

    private static final Unit Icon$lambda$13(Painter r7, ColorProducer r8, String r9, Modifier r10, int r11, int r12, Composer r13, int r14) {
        Icon(r7, r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    private static final Unit Icon_ww6aTOc$lambda$0(ImageVector r9, String r10, Modifier r11, long r12, int r14, int r15, Composer r16, int r17) {
        m2775Iconww6aTOc(r9, r10, r11, r12, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    private static final Unit Icon_ww6aTOc$lambda$2(ImageBitmap r9, String r10, Modifier r11, long r12, int r14, int r15, Composer r16, int r17) {
        m2773Iconww6aTOc(r9, r10, r11, r12, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    private static final Unit Icon_ww6aTOc$lambda$6(Painter r9, String r10, Modifier r11, long r12, int r14, int r15, Composer r16, int r17) {
        m2774Iconww6aTOc(r9, r10, r11, r12, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(GraphicsLayer r0, ContentDrawScope r1) {
        return Icon$lambda$12$lambda$11$lambda$10(r0, r1);
    }

    public static /* synthetic */ Unit b(String r0, SemanticsPropertyReceiver r1) {
        return Icon_ww6aTOc$lambda$5$lambda$4(r0, r1);
    }

    public static /* synthetic */ Unit c(ContentDrawScope r0) {
        return Icon$lambda$12$lambda$11$lambda$9$lambda$7(r0);
    }

    public static /* synthetic */ Unit d(Painter r0, ColorProducer r1, String r2, Modifier r3, int r4, int r5, Composer r6, int r7) {
        return Icon$lambda$13(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit e(Painter r0, String r1, Modifier r2, long r3, int r5, int r6, Composer r7, int r8) {
        return Icon_ww6aTOc$lambda$6(r0, r1, r2, r3, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit f(ImageBitmap r0, String r1, Modifier r2, long r3, int r5, int r6, Composer r7, int r8) {
        return Icon_ww6aTOc$lambda$2(r0, r1, r2, r3, r5, r6, r7, r8);
    }

    public static /* synthetic */ DrawResult g(ColorProducer r0, CacheDrawScope r1) {
        return Icon$lambda$12$lambda$11(r0, r1);
    }

    public static /* synthetic */ Unit h(ImageVector r0, String r1, Modifier r2, long r3, int r5, int r6, Composer r7, int r8) {
        return Icon_ww6aTOc$lambda$0(r0, r1, r2, r3, r5, r6, r7, r8);
    }

    static {
        DefaultIconSizeModifier = SizeKt.m1014size3ABfNKs(Modifier.Companion, SmallIconButtonTokens.INSTANCE.getIconSize-D9Ej5fM());
    }

    private static final Unit Icon$lambda$12$lambda$11$lambda$9$lambda$7(ContentDrawScope r0) {
        r0.drawContent();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: isInfinite-uvyYCjk, reason: not valid java name */
    private static final boolean m2776isInfiniteuvyYCjk(long r2) {
        if (Float.isInfinite(Float.intBitsToFloat((int) (r2 >> 32))) == true) goto L5;
    L7:
        return false;
    L5:
        if (Float.isInfinite(Float.intBitsToFloat((int) (r2 & 4294967295L))) == false) goto L7;
        return true;
    }

    private static final DrawResult Icon$lambda$12$lambda$11(ColorProducer r10, CacheDrawScope r11) {
        final GraphicsLayer r9 = r11.obtainGraphicsLayer();
        CacheDrawScope.record-TdoYBX4$default(r11, r9, null, null, 0, new tc(), 7, null);
        if (r10 == null) goto L6;
        r9.setColorFilter(ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, r10.invoke-0d7_KjU(), 0, 2, null));
    L6:
        return r11.onDrawWithContent(new uc(r9));
    }

    private static final Unit Icon$lambda$12$lambda$11$lambda$10(GraphicsLayer r0, ContentDrawScope r1) {
        GraphicsLayerKt.drawLayer(r1, r0);
        return Unit.INSTANCE;
    }

    private static final Unit Icon_ww6aTOc$lambda$5$lambda$4(String r0, SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setContentDescription(r1, r0);
        SemanticsPropertiesKt.setRole-kuIjeqM(r1, Role.Companion.getImage-o7Vup1c());
        return Unit.INSTANCE;
    }

    private static final Modifier defaultSizeFor(Modifier r4, Painter r5) {
        if (Size.equals-impl0(r5.getIntrinsicSize-NH-jbRc(), Size.Companion.getUnspecified-NH-jbRc()) == false) goto L5;
    L8:
        Modifier.Companion r6 = DefaultIconSizeModifier;
    L10:
        return r4.then(r6);
    L5:
        if (m2776isInfiniteuvyYCjk(r5.getIntrinsicSize-NH-jbRc()) == true) goto L8;
        r6 = Modifier.Companion;
        goto L10
    }

    public static final void Icon(final Painter r9, final ColorProducer r10, final String r11, Modifier r12, Composer r13, final int r14, final int r15) {
        Composer r16 = r13.startRestartGroup(1755070997);
        if ((r15 & 1) == 0) goto L6;
        int r1 = r14 | 6;
    L14:
        if ((r15 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r15 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L33:
        int r2 = r15 & 8;
        if (r2 == 0) goto L37;
        r1 = r1 | 3072;
    L44:
        if ((r1 & 1171) == 1170) goto L46;
        boolean r3 = true;
    L48:
        if (r16.shouldExecute(r3, r1 & 1) == false) goto L62;
        if (r2 == 0) goto L52;
        r12 = Modifier.Companion;
    L52:
        if (ComposerKt.isTraceInProgress() == false) goto L54;
        ComposerKt.traceEventStart(1755070997, r1, -1, "androidx.compose.material3.Icon (Icon.kt:189)");
    L54:
        long r4 = Color.Companion.getUnspecified-0d7_KjU();
        boolean r0 = r16.changedInstance(r10);
        Object r5 = r16.rememberedValue();
        if (r0 == false) goto L57;
    L58:
        r5 = new vc(r10);
        r16.updateRememberedValue(r5);
    L59:
        m2774Iconww6aTOc(r9, r11, DrawModifierKt.drawWithCache(r12, (Function1) r5), r4, r16, ((r1 & 14) | 3072) | ((r1 >> 3) & 112), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L63;
        ComposerKt.traceEventEnd();
    L63:
        final Modifier r6 = r12;
        ScopeUpdateScope r17 = r16.endRestartGroup();
        if (r17 == null) goto L67;
        r17.updateScope(new wc(r9, r10, r11, r6, r14, r15));
        return;
    L67:
        return;
    L57:
        if (r5 != Composer.Companion.getEmpty()) goto L59;
    L62:
        r16.skipToGroupEnd();
        goto L63
    L46:
        r3 = false;
        goto L48
    L37:
        if ((r14 & 3072) != 0) goto L44;
        if (r16.changed(r12) == false) goto L41;
        int r7 = 2048;
    L42:
        r1 = r1 | r7;
        goto L44
    L41:
        r7 = 1024;
        goto L42
    L27:
        if ((r14 & 384) != 0) goto L33;
        if (r16.changed(r11) == false) goto L31;
        int r8 = 256;
    L32:
        r1 = r1 | r8;
        goto L33
    L31:
        r8 = 128;
        goto L32
    L17:
        if ((r14 & 48) != 0) goto L24;
        if (r16.changedInstance(r10) == false) goto L21;
        int r18 = 32;
    L22:
        r1 = r1 | r18;
        goto L24
    L21:
        r18 = 16;
        goto L22
    L6:
        if ((r14 & 6) == 0) goto L8;
        r1 = r14;
        goto L14
    L8:
        if (r16.changedInstance(r9) == false) goto L10;
        int r19 = 4;
    L11:
        r1 = r19 | r14;
        goto L14
    L10:
        r19 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m2774Iconww6aTOc(final Painter r22, final String r23, Modifier r24, long r25, Composer r27, final int r28, final int r29) {
        Composer r12 = r27.startRestartGroup(-2142239481);
        if ((r29 & 1) == 0) goto L6;
        int r1 = r28 | 6;
    L14:
        if ((r29 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r29 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L33:
        Modifier r4 = r24;
    L35:
        if ((r28 & 3072) != 0) goto L43;
        long r7 = r25;
        if ((r29 & 8) == 0) goto L39;
    L41:
        int r5 = 1024;
    L42:
        r1 = r1 | r5;
    L45:
        if ((r1 & 1171) == 1170) goto L47;
        boolean r6 = true;
    L49:
        if (r12.shouldExecute(r6, r1 & 1) == false) goto L103;
        r12.startDefaults();
        if ((r28 & 1) != 0) goto L53;
    L59:
        if (r2 == 0) goto L61;
        Modifier r3 = Modifier.Companion;
    L63:
        if ((r29 & 8) == 0) goto L65;
        r1 = r1 & (-7169);
        Modifier r13 = r3;
        r7 = ((Color) r12.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
    L66:
        r12.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L70;
        ComposerKt.traceEventStart(-2142239481, r1, -1, "androidx.compose.material3.Icon (Icon.kt:142)");
    L70:
        if (((r1 & 7168) ^ 3072) <= 2048) goto L74;
        if (r12.changed(r7) == false) goto L74;
    L75:
        boolean r0 = true;
    L77:
        Object r8 = r12.rememberedValue();
        if (r0 == true) goto L82;
        if (r8 == Composer.Companion.getEmpty()) goto L82;
    L86:
        ColorFilter r9 = (ColorFilter) r8;
        if (r23 == null) goto L98;
        r12.startReplaceGroup(-536990979);
        Modifier.Companion r10 = Modifier.Companion;
        if ((r1 & 112) != 32) goto L91;
        boolean r11 = true;
    L92:
        Object r14 = r12.rememberedValue();
        if (r11 == false) goto L95;
    L96:
        r14 = new zc(r23);
        r12.updateRememberedValue(r14);
    L97:
        Modifier r15 = SemanticsModifierKt.semantics$default(r10, false, (Function1) r14, 1, null);
        r12.endReplaceGroup();
    L99:
        long r18 = r7;
        BoxKt.Box(PainterModifierKt.paint$default(defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(r13), r22), r22, false, null, ContentScale.Companion.getFit(), MenuKt.ClosedAlphaTarget, r9, 22, null).then(r15), r12, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L102;
        ComposerKt.traceEventEnd();
    L102:
        final Modifier r16 = r13;
        final long r17 = r18;
    L104:
        ScopeUpdateScope r19 = r12.endRestartGroup();
        if (r19 == null) goto L108;
        r19.updateScope(new ad(r22, r23, r16, r17, r28, r29));
        return;
    L108:
        return;
    L95:
        if (r14 != Composer.Companion.getEmpty()) goto L97;
    L91:
        r11 = false;
        goto L92
    L98:
        r12.startReplaceGroup(-536832197);
        r12.endReplaceGroup();
        r15 = Modifier.Companion;
    L82:
        if (Color.equals-impl0(r7, Color.Companion.getUnspecified-0d7_KjU()) == false) goto L84;
        r8 = null;
    L85:
        r12.updateRememberedValue(r8);
        goto L86
    L84:
        r8 = ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, r7, 0, 2, null);
    L74:
        if ((r1 & 3072) == 2048) goto L75;
        r0 = false;
        goto L77
    L65:
        r13 = r3;
        goto L66
    L61:
        r3 = r4;
        goto L63
    L53:
        if (r12.getDefaultsInvalid() == true) goto L59;
        r12.skipToGroupEnd();
        if ((r29 & 8) == 0) goto L58;
        r1 = r1 & (-7169);
    L58:
        r13 = r4;
        goto L66
    L103:
        r12.skipToGroupEnd();
        r16 = r4;
        r17 = r7;
        goto L104
    L47:
        r6 = false;
        goto L49
    L39:
        if (r12.changed(r7) == false) goto L41;
        r5 = 2048;
        goto L42
    L43:
        r7 = r25;
        goto L45
    L27:
        if ((r28 & 384) != 0) goto L33;
        r4 = r24;
        if (r12.changed(r4) == false) goto L31;
        int r20 = 256;
    L32:
        r1 = r1 | r20;
        goto L35
    L31:
        r20 = 128;
        goto L32
    L17:
        if ((r28 & 48) != 0) goto L23;
        if (r12.changed(r23) == false) goto L21;
        int r21 = 32;
    L22:
        r1 = r1 | r21;
        goto L23
    L21:
        r21 = 16;
        goto L22
    L6:
        if ((r28 & 6) == 0) goto L8;
        r1 = r28;
        goto L14
    L8:
        if (r12.changedInstance(r22) == false) goto L10;
        int r26 = 4;
    L11:
        r1 = r26 | r28;
        goto L14
    L10:
        r26 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m2773Iconww6aTOc(final ImageBitmap r21, final String r22, Modifier r23, long r24, Composer r26, final int r27, final int r28) {
        Composer r15 = r26.startRestartGroup(-1092052280);
        if ((r28 & 1) == 0) goto L6;
        int r1 = r27 | 6;
    L14:
        if ((r28 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r28 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L33:
        final Modifier r3 = r23;
    L35:
        if ((r27 & 3072) == 0) goto L37;
        final long r4 = r24;
    L46:
        if ((r1 & 1171) == 1170) goto L48;
        boolean r6 = true;
    L50:
        if (r15.shouldExecute(r6, r1 & 1) == false) goto L80;
        r15.startDefaults();
        if ((r27 & 1) != 0) goto L54;
    L60:
        if (r2 == 0) goto L62;
        Modifier r5 = Modifier.Companion;
    L64:
        if ((r28 & 8) == 0) goto L66;
        int r10 = r1 & (-7169);
        Modifier r18 = r5;
        long r19 = ((Color) r15.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
    L68:
        r15.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L71;
        ComposerKt.traceEventStart(-1092052280, r10, -1, "androidx.compose.material3.Icon (Icon.kt:105)");
    L71:
        boolean r0 = r15.changed(r21);
        Object r7 = r15.rememberedValue();
        if (r0 == false) goto L74;
    L75:
        BitmapPainter r11 = new BitmapPainter(r21, 0, 0, 6, null);
        r15.updateRememberedValue(r11);
        r7 = r11;
    L76:
        Modifier r12 = r18;
        long r13 = r19;
        Composer r8 = r15;
        m2774Iconww6aTOc((BitmapPainter) r7, r22, r12, r13, r15, ((r10 & 112) | (r10 & 896)) | (r10 & 7168), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L79;
        ComposerKt.traceEventEnd();
    L79:
        r3 = r18;
        r4 = r19;
    L81:
        ScopeUpdateScope r14 = r8.endRestartGroup();
        if (r14 == null) goto L85;
        r14.updateScope(new yc(r21, r22, r3, r4, r27, r28));
        return;
    L85:
        return;
    L74:
        if (r7 != Composer.Companion.getEmpty()) goto L76;
    L66:
        r10 = r1;
        r18 = r5;
    L67:
        r19 = r4;
        goto L68
    L62:
        r5 = r3;
        goto L64
    L54:
        if (r15.getDefaultsInvalid() == true) goto L60;
        r15.skipToGroupEnd();
        if ((r28 & 8) == 0) goto L59;
        r1 = r1 & (-7169);
    L59:
        r10 = r1;
        r18 = r3;
        goto L67
    L80:
        r8 = r15;
        r8.skipToGroupEnd();
        goto L81
    L48:
        r6 = false;
        goto L50
    L37:
        if ((r28 & 8) != 0) goto L41;
        r4 = r24;
        if (r15.changed(r4) == false) goto L42;
        int r9 = 2048;
    L43:
        r1 = r1 | r9;
    L42:
        r9 = 1024;
        goto L43
    L41:
        r4 = r24;
        goto L42
    L27:
        if ((r27 & 384) != 0) goto L33;
        r3 = r23;
        if (r15.changed(r3) == false) goto L31;
        int r16 = 256;
    L32:
        r1 = r1 | r16;
        goto L35
    L31:
        r16 = 128;
        goto L32
    L17:
        if ((r27 & 48) != 0) goto L23;
        if (r15.changed(r22) == false) goto L21;
        int r17 = 32;
    L22:
        r1 = r1 | r17;
        goto L23
    L21:
        r17 = 16;
        goto L22
    L6:
        if ((r27 & 6) == 0) goto L8;
        r1 = r27;
        goto L14
    L8:
        if (r15.changedInstance(r21) == false) goto L10;
        int r20 = 4;
    L11:
        r1 = r20 | r27;
        goto L14
    L10:
        r20 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m2775Iconww6aTOc(final ImageVector r17, final String r18, Modifier r19, long r20, Composer r22, final int r23, final int r24) {
        Composer r2 = r22.startRestartGroup(-126890956);
        if ((r24 & 1) == 0) goto L6;
        int r3 = r23 | 6;
    L14:
        if ((r24 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r5 = r24 & 4;
        if (r5 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Modifier r7 = r19;
    L36:
        if ((r23 & 3072) == 0) goto L38;
        long r8 = r20;
    L47:
        if ((r3 & 1171) == 1170) goto L49;
        boolean r10 = true;
    L51:
        if (r2.shouldExecute(r10, r3 & 1) == false) goto L75;
        r2.startDefaults();
        if ((r23 & 1) != 0) goto L55;
    L61:
        if (r5 == 0) goto L63;
        Modifier r6 = Modifier.Companion;
    L65:
        if ((r24 & 8) == 0) goto L67;
        r3 = r3 & (-7169);
        long r15 = ((Color) r2.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
    L68:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L71;
        ComposerKt.traceEventStart(-126890956, r3, -1, "androidx.compose.material3.Icon (Icon.kt:69)");
    L71:
        Modifier r9 = r6;
        long r11 = r15;
        m2774Iconww6aTOc(VectorPainterKt.rememberVectorPainter(r17, r2, r3 & 14), r18, r9, r11, r2, ((VectorPainter.$stable | (r3 & 112)) | (r3 & 896)) | (r3 & 7168), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L74;
        ComposerKt.traceEventEnd();
    L74:
        final Modifier r4 = r6;
        r8 = r15;
    L76:
        ScopeUpdateScope r12 = r2.endRestartGroup();
        if (r12 == null) goto L80;
        final long r13 = r8;
        r12.updateScope(new xc(r17, r18, r4, r13, r23, r24));
        return;
    L80:
        return;
    L67:
        r15 = r8;
        goto L68
    L63:
        r6 = r7;
        goto L65
    L55:
        if (r2.getDefaultsInvalid() == true) goto L61;
        r2.skipToGroupEnd();
        if ((r24 & 8) == 0) goto L60;
        r3 = r3 & (-7169);
    L60:
        r6 = r7;
        goto L67
    L75:
        r2.skipToGroupEnd();
        r4 = r7;
        goto L76
    L49:
        r10 = false;
        goto L51
    L38:
        if ((r24 & 8) != 0) goto L42;
        r8 = r20;
        if (r2.changed(r8) == false) goto L43;
        int r14 = 2048;
    L44:
        r3 = r3 | r14;
    L43:
        r14 = 1024;
        goto L44
    L42:
        r8 = r20;
        goto L43
    L28:
        if ((r23 & 384) != 0) goto L34;
        r7 = r19;
        if (r2.changed(r7) == false) goto L32;
        int r16 = 256;
    L33:
        r3 = r3 | r16;
        goto L36
    L32:
        r16 = 128;
        goto L33
    L17:
        if ((r23 & 48) != 0) goto L24;
        if (r2.changed(r18) == false) goto L21;
        int r21 = 32;
    L22:
        r3 = r3 | r21;
        goto L24
    L21:
        r21 = 16;
        goto L22
    L6:
        if ((r23 & 6) == 0) goto L8;
        r3 = r23;
        goto L14
    L8:
        if (r2.changed(r17) == false) goto L10;
        int r25 = 4;
    L11:
        r3 = r25 | r23;
        goto L14
    L10:
        r25 = 2;
        goto L11
    }
}
