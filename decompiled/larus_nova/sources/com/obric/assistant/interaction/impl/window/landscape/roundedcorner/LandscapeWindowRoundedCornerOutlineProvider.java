package com.obric.assistant.interaction.impl.window.landscape.roundedcorner;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\f\u0010\f\u001a\u00020\r*\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerOutlineProvider;", "Landroid/view/ViewOutlineProvider;", "cornerRadii", "Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowCornerRadii;", "<init>", "(Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowCornerRadii;)V", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "maxRadius", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LandscapeWindowRoundedCornerOutlineProvider extends ViewOutlineProvider {
    private final LandscapeWindowCornerRadii cornerRadii;

    public LandscapeWindowRoundedCornerOutlineProvider(LandscapeWindowCornerRadii r100) {
        Intrinsics.checkNotNullParameter(r100, "cornerRadii");
        this.cornerRadii = r100;
    }

    private final float maxRadius(LandscapeWindowCornerRadii r100) {
        return ComparisonsKt.maxOf(RangesKt.coerceAtLeast(r100.getTopLeft(), 0.0f), new float[]{RangesKt.coerceAtLeast(r100.getTopRight(), 0.0f), RangesKt.coerceAtLeast(r100.getBottomRight(), 0.0f), RangesKt.coerceAtLeast(r100.getBottomLeft(), 0.0f)});
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View r100, Outline r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r110, "outline");
        if (r100.getWidth() > 0) goto L5;
        return;
    L5:
        if (r100.getHeight() > 0) goto L7;
        return;
    L7:
        if (this.cornerRadii.getHasRoundedCorner$impl_mainlandRelease() == false) goto L13;
        r110.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), RangesKt.coerceAtMost(maxRadius(this.cornerRadii), Math.min(r100.getWidth(), r100.getHeight()) / 2.0f));
        return;
    }
}
