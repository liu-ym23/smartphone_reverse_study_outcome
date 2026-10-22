package zb1;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.bytedance.android.live.uikit.refresh.I18nSwipeRefreshLayout;
import com.bytedance.android.live.uikit.refresh.MaterialProgressDrawable;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f571121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f571122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ I18nSwipeRefreshLayout f571123c;

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r100, Transformation r101) {
        MaterialProgressDrawable r102 = this.f571123c.f102352r;
        int r103 = this.f571121a;
        r102.f102369b.f102399u = (int) (r103 + ((this.f571122b - r103) * r100));
    }

    public d(I18nSwipeRefreshLayout r100, int r101, int r102) {
        this.f571123c = r100;
        this.f571121a = r101;
        this.f571122b = r102;
    }
}
