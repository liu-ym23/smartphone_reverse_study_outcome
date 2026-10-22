package no1;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.MaterialProgressDrawable;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.SwipeRefreshLayout;

/* JADX INFO: loaded from: classes8.dex */
public final class j extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f519897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f519898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f519899c;

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r100, Transformation r101) {
        MaterialProgressDrawable r102 = this.f519899c.f113894x;
        int r103 = this.f519897a;
        r102.f113837b.f113867u = (int) (r103 + ((this.f519898b - r103) * r100));
    }

    public j(SwipeRefreshLayout r100, int r101, int r102) {
        this.f519899c = r100;
        this.f519897a = r101;
        this.f519898b = r102;
    }
}
