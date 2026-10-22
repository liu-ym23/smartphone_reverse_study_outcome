package zb1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Animation.AnimationListener f571118a;

    @Override // android.view.View
    public final void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener r100 = this.f571118a;
        if (r100 == null) goto L6;
        r100.onAnimationEnd(getAnimation());
        return;
    }

    @Override // android.view.View
    public final void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener r100 = this.f571118a;
        if (r100 == null) goto L6;
        r100.onAnimationStart(getAnimation());
        return;
    }

    public a(Context r100) {
        super(r100);
        Resources r101 = getContext().getResources();
        float r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density;
        ShapeDrawable r103 = new ShapeDrawable(new OvalShape());
        ViewCompat.setElevation(this, r102 * 4.0f);
        r103.getPaint().setColor(-328966);
        setBackgroundDrawable(r103);
    }

    @Override // android.view.View
    public final void setBackgroundColor(int r100) {
        if ((getBackground() instanceof ShapeDrawable) == false) goto L6;
        Resources r101 = getResources();
        ((ShapeDrawable) getBackground()).getPaint().setColor(r101.getColor(r100));
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }
}
