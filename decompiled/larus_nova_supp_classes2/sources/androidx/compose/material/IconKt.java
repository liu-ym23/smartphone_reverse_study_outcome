package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.ImageBitmap;
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
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000e\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u0011\u001a\u0014\u0010\u0012\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u0013\u0010\u0013\u001a\u00020\u0014*\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\"\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Icon", "", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "tint", "Landroidx/compose/ui/graphics/Color;", "Icon-ww6aTOc", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "defaultSizeFor", "isInfinite", "", "Landroidx/compose/ui/geometry/Size;", "isInfinite-uvyYCjk", "(J)Z", "DefaultIconSizeModifier", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IconKt {
    private static final Modifier DefaultIconSizeModifier = null;

    private static final Unit Icon_ww6aTOc$lambda$4(Painter r9, String r10, Modifier r11, long r12, int r14, int r15, Composer r16, int r17) {
        m2081Iconww6aTOc(r9, r10, r11, r12, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Painter r0, String r1, Modifier r2, long r3, int r5, int r6, Composer r7, int r8) {
        return Icon_ww6aTOc$lambda$4(r0, r1, r2, r3, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit b(String r0, SemanticsPropertyReceiver r1) {
        return Icon_ww6aTOc$lambda$3$lambda$2(r0, r1);
    }

    static {
        DefaultIconSizeModifier = SizeKt.m1014size3ABfNKs(Modifier.Companion, Dp.constructor-impl(24));
    }

    /* JADX INFO: renamed from: isInfinite-uvyYCjk, reason: not valid java name */
    private static final boolean m2083isInfiniteuvyYCjk(long r2) {
        if (Float.isInfinite(Float.intBitsToFloat((int) (r2 >> 32))) == true) goto L5;
    L7:
        return false;
    L5:
        if (Float.isInfinite(Float.intBitsToFloat((int) (r2 & 4294967295L))) == false) goto L7;
        return true;
    }

    private static final Unit Icon_ww6aTOc$lambda$3$lambda$2(String r0, SemanticsPropertyReceiver r1) {
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
        if (m2083isInfiniteuvyYCjk(r5.getIntrinsicSize-NH-jbRc()) == true) goto L8;
        r6 = Modifier.Companion;
        goto L10
    }

    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m2081Iconww6aTOc(final Painter r24, final String r25, Modifier r26, long r27, Composer r29, final int r30, final int r31) {
        Composer r12 = r29.startRestartGroup(-1142959010);
        if ((r31 & 1) == 0) goto L6;
        int r1 = r30 | 6;
    L14:
        if ((r31 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r31 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L33:
        Modifier r4 = r26;
    L35:
        if ((r30 & 3072) != 0) goto L43;
        long r7 = r27;
        if ((r31 & 8) == 0) goto L39;
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
        if ((r30 & 1) != 0) goto L53;
    L59:
        if (r2 == 0) goto L61;
        Modifier r3 = Modifier.Companion;
    L63:
        if ((r31 & 8) == 0) goto L65;
        r1 = r1 & (-7169);
        Modifier r13 = r3;
        r7 = Color.copy-wmQWz5c$default(((Color) r12.consume(ContentColorKt.getLocalContentColor())).unbox-impl(), ((Number) r12.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L66:
        r12.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L70;
        ComposerKt.traceEventStart(-1142959010, r1, -1, "androidx.compose.material.Icon (Icon.kt:134)");
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
        if (r25 == null) goto L98;
        r12.startReplaceGroup(609231686);
        Modifier.Companion r10 = Modifier.Companion;
        if ((r1 & 112) != 32) goto L91;
        boolean r11 = true;
    L92:
        Object r14 = r12.rememberedValue();
        if (r11 == false) goto L95;
    L96:
        r14 = new o5(r25);
        r12.updateRememberedValue(r14);
    L97:
        Modifier r15 = SemanticsModifierKt.semantics$default(r10, false, (Function1) r14, 1, null);
        r12.endReplaceGroup();
    L99:
        long r18 = r7;
        BoxKt.Box(PainterModifierKt.paint$default(defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(r13), r24), r24, false, null, ContentScale.Companion.getFit(), androidx.compose.material3.MenuKt.ClosedAlphaTarget, r9, 22, null).then(r15), r12, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L102;
        ComposerKt.traceEventEnd();
    L102:
        final Modifier r16 = r13;
        final long r17 = r18;
    L104:
        ScopeUpdateScope r19 = r12.endRestartGroup();
        if (r19 == null) goto L108;
        r19.updateScope(new p5(r24, r25, r16, r17, r30, r31));
        return;
    L108:
        return;
    L95:
        if (r14 != Composer.Companion.getEmpty()) goto L97;
    L91:
        r11 = false;
        goto L92
    L98:
        r12.startReplaceGroup(609390468);
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
        if ((r31 & 8) == 0) goto L58;
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
        r7 = r27;
        goto L45
    L27:
        if ((r30 & 384) != 0) goto L33;
        r4 = r26;
        if (r12.changed(r4) == false) goto L31;
        int r20 = 256;
    L32:
        r1 = r1 | r20;
        goto L35
    L31:
        r20 = 128;
        goto L32
    L17:
        if ((r30 & 48) != 0) goto L23;
        if (r12.changed(r25) == false) goto L21;
        int r21 = 32;
    L22:
        r1 = r1 | r21;
        goto L23
    L21:
        r21 = 16;
        goto L22
    L6:
        if ((r30 & 6) == 0) goto L8;
        r1 = r30;
        goto L14
    L8:
        if (r12.changedInstance(r24) == false) goto L10;
        int r22 = 4;
    L11:
        r1 = r22 | r30;
        goto L14
    L10:
        r22 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m2080Iconww6aTOc(ImageBitmap r16, String r17, Modifier r18, long r19, Composer r21, int r22, int r23) {
        if ((r23 & 4) == 0) goto L5;
        Modifier r2 = Modifier.Companion;
    L7:
        if ((r23 & 8) == 0) goto L9;
        long r3 = Color.copy-wmQWz5c$default(((Color) r21.consume(ContentColorKt.getLocalContentColor())).unbox-impl(), ((Number) r21.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L11:
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventStart(-554892675, r22, -1, "androidx.compose.material.Icon (Icon.kt:100)");
    L13:
        boolean r6 = r21.changed(r16);
        Object r7 = r21.rememberedValue();
        if (r6 == false) goto L16;
    L17:
        r7 = new BitmapPainter(r16, 0, 0, 6, null);
        r21.updateRememberedValue(r7);
    L18:
        m2081Iconww6aTOc((BitmapPainter) r7, r17, r2, r3, r21, ((r22 & 112) | (r22 & 896)) | (r22 & 7168), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L22;
        ComposerKt.traceEventEnd();
        return;
    L22:
        return;
    L16:
        if (r7 != Composer.Companion.getEmpty()) goto L18;
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m2082Iconww6aTOc(ImageVector r14, String r15, Modifier r16, long r17, Composer r19, int r20, int r21) {
        if ((r21 & 4) == 0) goto L5;
        Modifier r2 = Modifier.Companion;
    L7:
        if ((r21 & 8) == 0) goto L9;
        long r3 = Color.copy-wmQWz5c$default(((Color) r19.consume(ContentColorKt.getLocalContentColor())).unbox-impl(), ((Number) r19.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L11:
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventStart(-800853103, r20, -1, "androidx.compose.material.Icon (Icon.kt:66)");
    L13:
        m2081Iconww6aTOc(VectorPainterKt.rememberVectorPainter(r14, r19, r20 & 14), r15, r2, r3, r19, ((VectorPainter.$stable | (r20 & 112)) | (r20 & 896)) | (r20 & 7168), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventEnd();
        return;
    L17:
        return;
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }
}
