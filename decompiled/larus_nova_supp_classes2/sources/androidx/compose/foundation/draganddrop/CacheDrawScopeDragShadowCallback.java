package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/draganddrop/CacheDrawScopeDragShadowCallback;", "", "<init>", "()V", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "drawDragShadow", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "cachePicture", "Landroidx/compose/ui/draw/DrawResult;", "scope", "Landroidx/compose/ui/draw/CacheDrawScope;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CacheDrawScopeDragShadowCallback {
    public static final int $stable = 8;
    private GraphicsLayer graphicsLayer;

    public CacheDrawScopeDragShadowCallback() {
    }

    public static /* synthetic */ Unit a(CacheDrawScopeDragShadowCallback r0, ContentDrawScope r1) {
        return cachePicture$lambda$4$lambda$3(r0, r1);
    }

    public static /* synthetic */ Unit b(ContentDrawScope r0) {
        return cachePicture$lambda$4$lambda$2$lambda$1(r0);
    }

    private static final Unit cachePicture$lambda$4$lambda$2$lambda$1(ContentDrawScope r0) {
        r0.drawContent();
        return Unit.INSTANCE;
    }

    public final DrawResult cachePicture(CacheDrawScope r11) {
        GraphicsLayer r9 = r11.obtainGraphicsLayer();
        CacheDrawScope.record-TdoYBX4$default(r11, r9, null, null, 0, new a(), 7, null);
        this.graphicsLayer = r9;
        return r11.onDrawWithContent(new b(this));
    }

    public final void drawDragShadow(DrawScope r2) {
        GraphicsLayer r0 = this.graphicsLayer;
        if (r0 == null) goto L7;
        GraphicsLayerKt.drawLayer(r2, r0);
        return;
    L7:
        throw new IllegalArgumentException("No cached drag shadow. Check if the drag source node was rendered first");
    }

    private static final Unit cachePicture$lambda$4$lambda$3(CacheDrawScopeDragShadowCallback r0, ContentDrawScope r1) {
        GraphicsLayer r2 = r0.graphicsLayer;
        Intrinsics.checkNotNull(r2);
        GraphicsLayerKt.drawLayer(r1, r2);
        return Unit.INSTANCE;
    }
}
