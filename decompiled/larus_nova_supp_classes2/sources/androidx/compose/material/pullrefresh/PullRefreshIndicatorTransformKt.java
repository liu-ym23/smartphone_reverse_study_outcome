package androidx.compose.material.pullrefresh;

import androidx.compose.animation.core.EasingKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"pullRefreshIndicatorTransform", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material/pullrefresh/PullRefreshState;", "scale", "", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PullRefreshIndicatorTransformKt {
    public static /* synthetic */ Unit a(PullRefreshState r0, boolean r1, GraphicsLayerScope r2) {
        return pullRefreshIndicatorTransform$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(ContentDrawScope r0) {
        return pullRefreshIndicatorTransform$lambda$1(r0);
    }

    private static final Unit pullRefreshIndicatorTransform$lambda$1(ContentDrawScope r9) {
        int r5 = ClipOp.Companion.getIntersect-rtfAjoo();
        DrawContext r6 = r9.getDrawContext();
        long r7 = r6.getSize-NH-jbRc();
        r6.getCanvas().save();
        r6.getTransform().clipRect-N_I0leg(-3.4028235E38f, MenuKt.ClosedAlphaTarget, Float.MAX_VALUE, Float.MAX_VALUE, r5);     // Catch: Throwable -> L6
        r9.drawContent();     // Catch: Throwable -> L6
        r6.getCanvas().restore();
        r6.setSize-uvyYCjk(r7);
        return Unit.INSTANCE;
    L6:
        th = move-exception;
        r6.getCanvas().restore();
        r6.setSize-uvyYCjk(r7);
        throw th;
    }

    public static final Modifier pullRefreshIndicatorTransform(Modifier r1, final PullRefreshState r2, final boolean r3) {
        return GraphicsLayerModifierKt.graphicsLayer(DrawModifierKt.drawWithContent(r1, new g()), new h(r2, r3));
    }

    private static final Unit pullRefreshIndicatorTransform$lambda$2(PullRefreshState r5, boolean r6, GraphicsLayerScope r7) {
        r7.setTranslationY(r5.getPosition$material() - Float.intBitsToFloat((int) (r7.getSize-NH-jbRc() & 4294967295L)));
        if (r6 == false) goto L14;
        if (r5.getRefreshing$material() == true) goto L14;
        float r8 = EasingKt.getLinearOutSlowInEasing().transform(r5.getPosition$material() / r5.getThreshold$material());
        if (r8 >= MenuKt.ClosedAlphaTarget) goto L10;
        r8 = MenuKt.ClosedAlphaTarget;
    L10:
        if (r8 <= 1.0f) goto L12;
        r8 = 1.0f;
    L12:
        r7.setScaleX(r8);
        r7.setScaleY(r8);
    L14:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Modifier pullRefreshIndicatorTransform$default(Modifier r0, PullRefreshState r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return pullRefreshIndicatorTransform(r0, r1, r2);
    }
}
