package ev;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.bytedance.android.gamecp.common.ui.pullrefresh.SwipeRefreshLayout;

/* JADX INFO: loaded from: classes44.dex */
public final class d extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f474190a;

    public d(SwipeRefreshLayout r100) {
        this.f474190a = r100;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r100, Transformation r101) {
        this.f474190a.setAnimationProgress(r100);
    }
}
