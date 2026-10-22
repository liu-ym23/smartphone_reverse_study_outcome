package no1;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.DoubleBallSwipeRefreshLayout;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoubleBallSwipeRefreshLayout f519886a;

    public c(DoubleBallSwipeRefreshLayout r100) {
        this.f519886a = r100;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r100, Transformation r101) {
        this.f519886a.setAnimationProgress(1.0f - r100);
    }
}
