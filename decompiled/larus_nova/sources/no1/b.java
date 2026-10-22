package no1;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.DoubleBallSwipeRefreshLayout;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoubleBallSwipeRefreshLayout f519885a;

    public b(DoubleBallSwipeRefreshLayout r100) {
        this.f519885a = r100;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r100, Transformation r101) {
        DoubleBallSwipeRefreshLayout r102 = this.f519885a;
        r102.scrollTo(0, (int) (r102.f113782e * r100));
    }
}
