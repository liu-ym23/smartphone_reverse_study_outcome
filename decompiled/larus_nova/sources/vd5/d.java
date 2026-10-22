package vd5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.widgets.universedesign.SpaceLoadingImage;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.ss.android.lark.utils.statistics.PerfLog;
import cqa.e;
import cqa.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends FrameLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SpaceLoadingImage f554197a;

    @Override // cqa.f
    public final boolean a() {
        return false;
    }

    @Override // cqa.f
    public final void b(boolean r100, float r101, int r102, int r103, int r104) {
    }

    @Override // cqa.f
    public final void d(float r100, int r101, int r102) {
    }

    @Override // cqa.f
    public final void f(h r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "layout");
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
    public final int j(SmartRefreshLayout r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        return 0;
    }

    @Override // cqa.f
    public void setPrimaryColors(int... r100) {
        Intrinsics.checkNotNullParameter(r100, "colors");
    }

    @Override // cqa.f
    public dqa.b getSpinnerStyle() {
        return dqa.b.f469717d;
    }

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null);
        LayoutInflater.from(r100).inflate(R.layout.sidebar_refresh_header, this);
        SpaceLoadingImage r101 = (SpaceLoadingImage) findViewById(R.id.sidebar_refresh_progress);
        this.f554197a = r101;
        r101.stop();
    }

    @Override // gqa.e
    public final void e(h r100, RefreshState r101, RefreshState r102) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
        Intrinsics.checkNotNullParameter(r101, "oldState");
        Intrinsics.checkNotNullParameter(r102, "newState");
        SpaceLoadingImage r103 = this.f554197a;
        if (r102 != RefreshState.None) goto L5;
        r103.stop();
        return;
    L5:
        UDLoadingDrawable r104 = r103.f240350a;
        if (r104 == null) goto L10;
        r104.start();
        return;
    }
}
