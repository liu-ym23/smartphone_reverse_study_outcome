package androidx.compose.foundation;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.BitmapPainterKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a_\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0017\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Image", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "Image-5h-nEew", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ImageKt {
    private static final Unit Image$lambda$4(Painter r11, String r12, Modifier r13, Alignment r14, ContentScale r15, float r16, ColorFilter r17, int r18, int r19, Composer r20, int r21) {
        Image(r11, r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Painter r0, String r1, Modifier r2, Alignment r3, ContentScale r4, float r5, ColorFilter r6, int r7, int r8, Composer r9, int r10) {
        return Image$lambda$4(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit b(String r0, SemanticsPropertyReceiver r1) {
        return Image$lambda$2$lambda$1(r0, r1);
    }

    private static final Unit Image$lambda$2$lambda$1(String r0, SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setContentDescription(r1, r0);
        SemanticsPropertiesKt.setRole-kuIjeqM(r1, Role.Companion.getImage-o7Vup1c());
        return Unit.INSTANCE;
    }

    public static final void Image(final Painter r19, final String r20, Modifier r21, Alignment r22, ContentScale r23, float r24, ColorFilter r25, Composer r26, final int r27, final int r28) {
        Composer r1 = r26.startRestartGroup(1142754848);
        if ((r28 & 1) == 0) goto L6;
        int r4 = r27 | 6;
    L14:
        if ((r28 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L23:
        int r5 = r28 & 4;
        if (r5 == 0) goto L27;
        r4 = r4 | 384;
    L33:
        Modifier r7 = r21;
    L34:
        int r9 = r28 & 8;
        if (r9 == 0) goto L38;
        r4 = r4 | 3072;
    L44:
        Alignment r10 = r22;
    L45:
        int r11 = r28 & 16;
        if (r11 == 0) goto L49;
        r4 = r4 | 24576;
    L55:
        ContentScale r12 = r23;
    L56:
        int r13 = r28 & 32;
        if (r13 == 0) goto L60;
        r4 = r4 | 196608;
    L66:
        float r14 = r24;
    L67:
        int r15 = r28 & 64;
        if (r15 == 0) goto L71;
        r4 = r4 | 1572864;
    L78:
        if ((r4 & 599187) == 599186) goto L80;
        boolean r0 = true;
    L82:
        if (r1.shouldExecute(r0, r4 & 1) == false) goto L132;
        if (r5 == 0) goto L85;
        r7 = Modifier.Companion;
    L85:
        if (r9 == 0) goto L87;
        Alignment r2 = Alignment.Companion.getCenter();
    L88:
        if (r11 == 0) goto L90;
        ContentScale r3 = ContentScale.Companion.getFit();
    L91:
        if (r13 == 0) goto L93;
        float r6 = 1.0f;
    L95:
        if (r15 == 0) goto L97;
        ColorFilter r18 = null;
    L99:
        if (ComposerKt.isTraceInProgress() == false) goto L101;
        ComposerKt.traceEventStart(1142754848, r4, -1, "androidx.compose.foundation.Image (Image.kt:247)");
    L101:
        if (r20 == null) goto L112;
        r1.startReplaceGroup(1899234820);
        Modifier.Companion r16 = Modifier.Companion;
        if ((r4 & 112) != 32) goto L105;
        boolean r8 = true;
    L106:
        Object r17 = r1.rememberedValue();
        if (r8 == false) goto L109;
    L110:
        r17 = new o0(r20);
        r1.updateRememberedValue(r17);
    L111:
        Modifier r29 = SemanticsModifierKt.semantics$default(r16, false, (Function1) r17, 1, null);
        r1.endReplaceGroup();
    L113:
        Modifier r30 = PainterModifierKt.paint$default(ClipKt.clipToBounds(r7.then(r29)), r19, false, r2, r3, r6, r18, 2, null);
        Object r31 = r1.rememberedValue();
        if (r31 != Composer.Companion.getEmpty()) goto L116;
        r31 = ImageKt$Image$1$1.INSTANCE;
        r1.updateRememberedValue(r31);
    L116:
        MeasurePolicy r32 = (MeasurePolicy) r31;
        long r33 = ComposablesKt.getCurrentCompositeKeyHashCode(r1, 0);
        int r110 = (int) (r33 ^ (r33 >>> 32));
        Modifier r34 = ComposedModifierKt.materializeModifier(r1, r30);
        CompositionLocalMap r35 = r1.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion r111 = ComposeUiNode.Companion;
        Function0 r112 = r111.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L119;
        ComposablesKt.invalidApplier();
    L119:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L122;
        r1.createNode(r112);
    L123:
        Composer r113 = Updater.constructor-impl(r1);
        Updater.set-impl(r113, r32, r111.getSetMeasurePolicy());
        Updater.set-impl(r113, r35, r111.getSetResolvedCompositionLocals());
        Updater.set-impl(r113, r34, r111.getSetModifier());
        Function2 r36 = r111.getSetCompositeKeyHash();
        if (r113.getInserting() == false) goto L126;
    L127:
        r113.updateRememberedValue(Integer.valueOf(r110));
        r113.apply(Integer.valueOf(r110), r36);
    L128:
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L131;
        ComposerKt.traceEventEnd();
    L131:
        final Alignment r37 = r2;
        final float r38 = r6;
        final ContentScale r39 = r3;
        final Modifier r40 = r7;
        final ColorFilter r41 = r18;
    L133:
        ScopeUpdateScope r114 = r1.endRestartGroup();
        if (r114 == null) goto L137;
        r114.updateScope(new p0(r19, r20, r40, r37, r39, r38, r41, r27, r28));
        return;
    L137:
        return;
    L126:
        if (Intrinsics.areEqual(r113.rememberedValue(), Integer.valueOf(r110)) == true) goto L128;
    L122:
        r1.useNode();
        goto L123
    L109:
        if (r17 != Composer.Companion.getEmpty()) goto L111;
    L105:
        r8 = false;
        goto L106
    L112:
        r1.startReplaceGroup(1899393602);
        r1.endReplaceGroup();
        r29 = Modifier.Companion;
        goto L113
    L97:
        r18 = r25;
        goto L99
    L93:
        r6 = r14;
        goto L95
    L90:
        r3 = r12;
        goto L91
    L87:
        r2 = r10;
        goto L88
    L132:
        r1.skipToGroupEnd();
        r40 = r7;
        r37 = r10;
        r39 = r12;
        r38 = r14;
        r41 = r25;
        goto L133
    L80:
        r0 = false;
        goto L82
    L71:
        if ((r27 & 1572864) != 0) goto L78;
        if (r1.changed(r25) == false) goto L75;
        int r115 = 1048576;
    L76:
        r4 = r4 | r115;
        goto L78
    L75:
        r115 = 524288;
        goto L76
    L60:
        if ((196608 & r27) != 0) goto L66;
        r14 = r24;
        if (r1.changed(r14) == false) goto L64;
        int r116 = 131072;
    L65:
        r4 = r4 | r116;
        goto L67
    L64:
        r116 = 65536;
        goto L65
    L49:
        if ((r27 & 24576) != 0) goto L55;
        r12 = r23;
        if (r1.changed(r12) == false) goto L53;
        int r117 = 16384;
    L54:
        r4 = r4 | r117;
        goto L56
    L53:
        r117 = 8192;
        goto L54
    L38:
        if ((r27 & 3072) != 0) goto L44;
        r10 = r22;
        if (r1.changed(r10) == false) goto L42;
        int r118 = 2048;
    L43:
        r4 = r4 | r118;
        goto L45
    L42:
        r118 = 1024;
        goto L43
    L27:
        if ((r27 & 384) != 0) goto L33;
        r7 = r21;
        if (r1.changed(r7) == false) goto L31;
        int r42 = 256;
    L32:
        r4 = r4 | r42;
        goto L34
    L31:
        r42 = 128;
        goto L32
    L17:
        if ((r27 & 48) != 0) goto L23;
        if (r1.changed(r20) == false) goto L21;
        int r43 = 32;
    L22:
        r4 = r4 | r43;
        goto L23
    L21:
        r43 = 16;
        goto L22
    L6:
        if ((r27 & 6) == 0) goto L8;
        r4 = r27;
        goto L14
    L8:
        if (r1.changedInstance(r19) == false) goto L10;
        int r44 = 4;
    L11:
        r4 = r44 | r27;
        goto L14
    L10:
        r44 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Consider usage of the Image composable that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "Image(bitmap, contentDescription, modifier, alignment, contentScale, alpha, colorFilter, DefaultFilterQuality)", imports = {"androidx.compose.foundation", "androidx.compose.ui.graphics.DefaultAlpha", "androidx.compose.ui.Alignment", "androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultFilterQuality", "androidx.compose.ui.layout.ContentScale.Fit"}))
    public static final /* synthetic */ void Image(ImageBitmap r13, String r14, Modifier r15, Alignment r16, ContentScale r17, float r18, ColorFilter r19, Composer r20, int r21, int r22) {
        if ((r22 & 4) == 0) goto L5;
        Modifier r4 = Modifier.Companion;
    L7:
        if ((r22 & 8) == 0) goto L9;
        Alignment r5 = Alignment.Companion.getCenter();
    L11:
        if ((r22 & 16) == 0) goto L13;
        ContentScale r6 = ContentScale.Companion.getFit();
    L15:
        if ((r22 & 32) == 0) goto L17;
        float r7 = 1.0f;
    L19:
        if ((r22 & 64) == 0) goto L21;
        ColorFilter r8 = null;
    L23:
        if (ComposerKt.isTraceInProgress() == false) goto L25;
        ComposerKt.traceEventStart(-2123228673, r21, -1, "androidx.compose.foundation.Image (Image.kt:98)");
    L25:
        m410Image5hnEew(r13, r14, r4, r5, r6, r7, r8, FilterQuality.Companion.getLow-f-v9h1I(), r20, ((((((r21 & 14) | (r21 & 112)) | (r21 & 896)) | (r21 & 7168)) | (57344 & r21)) | (458752 & r21)) | (r21 & 3670016), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventEnd();
        return;
    L29:
        return;
    L21:
        r8 = r19;
        goto L23
    L17:
        r7 = r18;
        goto L19
    L13:
        r6 = r17;
        goto L15
    L9:
        r5 = r16;
        goto L11
    L5:
        r4 = r15;
        goto L7
    }

    public static final void Image(ImageVector r12, String r13, Modifier r14, Alignment r15, ContentScale r16, float r17, ColorFilter r18, Composer r19, int r20, int r21) {
        if ((r21 & 4) == 0) goto L5;
        Modifier r4 = Modifier.Companion;
    L7:
        if ((r21 & 8) == 0) goto L9;
        Alignment r5 = Alignment.Companion.getCenter();
    L11:
        if ((r21 & 16) == 0) goto L13;
        ContentScale r6 = ContentScale.Companion.getFit();
    L15:
        if ((r21 & 32) == 0) goto L17;
        float r7 = 1.0f;
    L19:
        if ((r21 & 64) == 0) goto L21;
        ColorFilter r8 = null;
    L23:
        if (ComposerKt.isTraceInProgress() == false) goto L25;
        ComposerKt.traceEventStart(1595907091, r20, -1, "androidx.compose.foundation.Image (Image.kt:202)");
    L25:
        Image(VectorPainterKt.rememberVectorPainter(r12, r19, r20 & 14), r13, r4, r5, r6, r7, r8, r19, (((((VectorPainter.$stable | (r20 & 112)) | (r20 & 896)) | (r20 & 7168)) | (57344 & r20)) | (458752 & r20)) | (r20 & 3670016), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventEnd();
        return;
    L29:
        return;
    L21:
        r8 = r18;
        goto L23
    L17:
        r7 = r17;
        goto L19
    L13:
        r6 = r16;
        goto L15
    L9:
        r5 = r15;
        goto L11
    L5:
        r4 = r14;
        goto L7
    }

    /* JADX INFO: renamed from: Image-5h-nEew, reason: not valid java name */
    public static final void m410Image5hnEew(ImageBitmap r16, String r17, Modifier r18, Alignment r19, ContentScale r20, float r21, ColorFilter r22, int r23, Composer r24, int r25, int r26) {
        if ((r26 & 4) == 0) goto L5;
        Modifier r2 = Modifier.Companion;
    L7:
        if ((r26 & 8) == 0) goto L9;
        Alignment r3 = Alignment.Companion.getCenter();
    L11:
        if ((r26 & 16) == 0) goto L13;
        ContentScale r4 = ContentScale.Companion.getFit();
    L15:
        if ((r26 & 32) == 0) goto L17;
        float r5 = 1.0f;
    L19:
        if ((r26 & 64) == 0) goto L21;
        ColorFilter r6 = null;
    L23:
        if ((r26 & 128) == 0) goto L25;
        int r13 = DrawScope.Companion.getDefaultFilterQuality-f-v9h1I();
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventStart(-1396260732, r25, -1, "androidx.compose.foundation.Image (Image.kt:156)");
    L29:
        boolean r8 = r24.changed(r16);
        Object r9 = r24.rememberedValue();
        if (r8 == false) goto L32;
    L33:
        r9 = BitmapPainterKt.BitmapPainter-QZhYCtY$default(r16, 0, 0, r13, 6, null);
        r24.updateRememberedValue(r9);
    L34:
        Image((BitmapPainter) r9, r17, r2, r3, r4, r5, r6, r24, (((((r25 & 112) | (r25 & 896)) | (r25 & 7168)) | (57344 & r25)) | (458752 & r25)) | (r25 & 3670016), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L38;
        ComposerKt.traceEventEnd();
        return;
    L38:
        return;
    L32:
        if (r9 != Composer.Companion.getEmpty()) goto L34;
    L25:
        r13 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }
}
