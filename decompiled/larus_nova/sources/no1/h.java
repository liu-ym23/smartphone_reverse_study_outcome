package no1;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.SwipeRefreshLayout;

/* JADX INFO: loaded from: classes8.dex */
public final class h extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f519895a;

    public h(SwipeRefreshLayout r100) {
        this.f519895a = r100;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r100, Transformation r101) {
        this.f519895a.setAnimationProgress(r100);
    }
}
