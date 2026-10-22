package ev;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.bytedance.android.gamecp.common.ui.pullrefresh.MaterialProgressDrawable;
import com.bytedance.android.gamecp.common.ui.pullrefresh.SwipeRefreshLayout;

/* JADX INFO: loaded from: classes44.dex */
public final class f extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f474192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f474193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f474194c;

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r100, Transformation r101) {
        MaterialProgressDrawable r102 = this.f474194c.f57114w;
        int r103 = this.f474192a;
        r102.f57059b.f57088u = (int) (r103 + ((this.f474193b - r103) * r100));
    }

    public f(SwipeRefreshLayout r100, int r101, int r102) {
        this.f474194c = r100;
        this.f474192a = r101;
        this.f474193b = r102;
    }
}
