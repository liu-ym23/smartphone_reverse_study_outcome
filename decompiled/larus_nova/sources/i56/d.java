package i56;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.bytedance.ies.uikit.refresh.I18nSwipeRefreshLayout;
import com.bytedance.ies.uikit.refresh.MaterialProgressDrawable;

/* JADX INFO: loaded from: classes19.dex */
public final class d extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f488312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f488313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ I18nSwipeRefreshLayout f488314c;

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r100, Transformation r101) {
        MaterialProgressDrawable r102 = this.f488314c.f249122p;
        int r103 = this.f488312a;
        r102.f249141b.f249171u = (int) (r103 + ((this.f488313b - r103) * r100));
    }

    public d(I18nSwipeRefreshLayout r100, int r101, int r102) {
        this.f488314c = r100;
        this.f488312a = r101;
        this.f488313b = r102;
    }
}
