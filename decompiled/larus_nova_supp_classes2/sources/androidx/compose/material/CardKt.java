package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a`\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0084\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Card", "", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Card-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "onClick", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Card-LPr_se0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CardKt {
    /* JADX INFO: renamed from: Card-F-jzlyU, reason: not valid java name */
    public static final void m1977CardFjzlyU(Modifier r13, Shape r14, long r15, long r17, BorderStroke r19, float r20, Function2<? super Composer, ? super Integer, Unit> r21, Composer r22, int r23, int r24) {
        if ((r24 & 1) == 0) goto L5;
        Modifier r1 = Modifier.Companion;
    L7:
        if ((r24 & 2) == 0) goto L9;
        Shape r2 = MaterialTheme.INSTANCE.getShapes(r22, 6).getMedium();
    L11:
        if ((r24 & 4) == 0) goto L13;
        long r3 = MaterialTheme.INSTANCE.getColors(r22, 6).m2003getSurface0d7_KjU();
    L15:
        if ((r24 & 8) == 0) goto L17;
        long r5 = ColorsKt.m2017contentColorForek8zF_U(r3, r22, (r23 >> 6) & 14);
    L19:
        if ((r24 & 16) == 0) goto L21;
        BorderStroke r7 = null;
    L23:
        if ((r24 & 32) == 0) goto L25;
        float r8 = Dp.constructor-impl(1);
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventStart(-574573525, r23, -1, "androidx.compose.material.Card (Card.kt:63)");
    L29:
        SurfaceKt.m2175SurfaceFjzlyU(r1, r2, r3, r5, r7, r8, r21, r22, ((((((r23 & 14) | (r23 & 112)) | (r23 & 896)) | (r23 & 7168)) | (57344 & r23)) | (458752 & r23)) | (r23 & 3670016), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventEnd();
        return;
    L33:
        return;
    L25:
        r8 = r20;
        goto L27
    L21:
        r7 = r19;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r3 = r15;
        goto L15
    L9:
        r2 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }

    /* JADX INFO: renamed from: Card-LPr_se0, reason: not valid java name */
    public static final void m1978CardLPr_se0(Function0<Unit> r16, Modifier r17, boolean r18, Shape r19, long r20, long r22, BorderStroke r24, float r25, MutableInteractionSource r26, Function2<? super Composer, ? super Integer, Unit> r27, Composer r28, int r29, int r30) {
        if ((r30 & 2) == 0) goto L5;
        Modifier r2 = Modifier.Companion;
    L7:
        if ((r30 & 4) == 0) goto L9;
        boolean r3 = true;
    L11:
        if ((r30 & 8) == 0) goto L13;
        Shape r5 = MaterialTheme.INSTANCE.getShapes(r28, 6).getMedium();
    L15:
        if ((r30 & 16) == 0) goto L17;
        long r6 = MaterialTheme.INSTANCE.getColors(r28, 6).m2003getSurface0d7_KjU();
    L19:
        if ((r30 & 32) == 0) goto L21;
        long r8 = ColorsKt.m2017contentColorForek8zF_U(r6, r28, (r29 >> 12) & 14);
    L22:
        MutableInteractionSource r11 = null;
        if ((r30 & 64) == 0) goto L25;
        BorderStroke r10 = null;
    L27:
        if ((r30 & 128) == 0) goto L29;
        float r13 = Dp.constructor-impl(1);
    L31:
        if ((r30 & 256) != 0) goto L35;
        r11 = r26;
    L35:
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventStart(-103820906, r29, -1, "androidx.compose.material.Card (Card.kt:115)");
    L37:
        SurfaceKt.m2176SurfaceLPr_se0(r16, r2, r3, r5, r6, r8, r10, r13, r11, r27, r28, (((((((((r29 & 14) | (r29 & 112)) | (r29 & 896)) | (r29 & 7168)) | (57344 & r29)) | (458752 & r29)) | (3670016 & r29)) | (29360128 & r29)) | (234881024 & r29)) | (r29 & 1879048192), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L41;
        ComposerKt.traceEventEnd();
        return;
    L41:
        return;
    L29:
        r13 = r25;
        goto L31
    L25:
        r10 = r24;
        goto L27
    L21:
        r8 = r22;
        goto L22
    L17:
        r6 = r20;
        goto L19
    L13:
        r5 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }
}
