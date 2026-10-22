package no1;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.DoubleBallSwipeRefreshLayout;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.MaterialProgressDrawable;

/* JADX INFO: loaded from: classes8.dex */
public final class d extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f519887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f519888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DoubleBallSwipeRefreshLayout f519889c;

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r100, Transformation r101) {
        MaterialProgressDrawable r102 = this.f519889c.f113800w;
        int r103 = this.f519887a;
        r102.f113837b.f113867u = (int) (r103 + ((this.f519888b - r103) * r100));
    }

    public d(DoubleBallSwipeRefreshLayout r100, int r101, int r102) {
        this.f519889c = r100;
        this.f519887a = r101;
        this.f519888b = r102;
    }
}
