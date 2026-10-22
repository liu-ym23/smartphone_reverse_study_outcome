package zb1;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.bytedance.android.live.uikit.refresh.I18nSwipeRefreshLayout;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ I18nSwipeRefreshLayout f571119a;

    public b(I18nSwipeRefreshLayout r100) {
        this.f571119a = r100;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r100, Transformation r101) {
        I18nSwipeRefreshLayout.b(this.f571119a, r100);
    }
}
