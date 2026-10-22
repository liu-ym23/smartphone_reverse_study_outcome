package nl0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.ss.android.lark.utils.statistics.PerfLog;
import cqa.e;
import cqa.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends FrameLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveDoubleColorBallAnimationView f519535a;

    /* JADX INFO: renamed from: nl0.a$a, reason: collision with other inner class name */
    public static final class C6938a {
    }

    static {
    }

    @Override // cqa.f
    public final boolean a() {
        return false;
    }

    @Override // cqa.f
    public final void d(float r100, int r101, int r102) {
    }

    @Override // gqa.e
    public final void e(h r100, RefreshState r101, RefreshState r102) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
        Intrinsics.checkNotNullParameter(r101, "oldState");
        Intrinsics.checkNotNullParameter(r102, "newState");
    }

    @Override // cqa.f
    public final void g(SmartRefreshLayout.j r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "kernel");
    }

    @Override // cqa.f
    public View getView() {
        return this;
    }

    @Override // cqa.f
    public final void i(h r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
    }

    @Override // cqa.f
    public void setPrimaryColors(int... r100) {
        Intrinsics.checkNotNullParameter(r100, "colors");
    }

    @Override // cqa.f
    public dqa.b getSpinnerStyle() {
        return dqa.b.f469717d;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        LiveDoubleColorBallAnimationView r101 = (LiveDoubleColorBallAnimationView) LayoutInflater.from(r100).inflate(R.layout.ttlive_layout_douyin_loading_view, this, true).findViewById(R.id.double_loading_view);
        this.f519535a = r101;
        if (r101 == null) goto L6;
        r101.setVisibility(0);
        return;
    }

    @Override // cqa.f
    public final int j(SmartRefreshLayout r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
        LiveDoubleColorBallAnimationView r102 = this.f519535a;
        if (r102 == null) goto L7;
        r102.c();
        return 10;
    L7:
        return 10;
    }

    @Override // cqa.f
    public final void f(h r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
        LiveDoubleColorBallAnimationView r103 = this.f519535a;
        if (r103 == null) goto L6;
        r103.b();
        return;
    }

    @Override // cqa.f
    public final void b(boolean r100, float r101, int r102, int r103, int r104) {
        if (r100 == false) goto L7;
        LiveDoubleColorBallAnimationView r105 = this.f519535a;
        if (r105 == null) goto L8;
        r105.setProgress(r101);
        return;
    L8:
        return;
    }
}
