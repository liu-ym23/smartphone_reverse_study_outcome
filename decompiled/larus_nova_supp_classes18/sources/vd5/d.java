package vd5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.widgets.universedesign.SpaceLoadingImage;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import cqa.e;
import cqa.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends FrameLayout implements e {
    public final SpaceLoadingImage a;

    public final boolean a() {
        return false;
    }

    public final void b(boolean r1, float r2, int r3, int r4, int r5) {
    }

    public final void d(float r1, int r2, int r3) {
    }

    public final void f(h r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "layout");
    }

    public final void g(SmartRefreshLayout.j r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "kernel");
    }

    public View getView() {
        return this;
    }

    public final void i(h r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "refreshLayout");
    }

    public final int j(SmartRefreshLayout r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "layout");
        return 0;
    }

    public void setPrimaryColors(int... r2) {
        Intrinsics.checkNotNullParameter(r2, "colors");
    }

    public dqa.b getSpinnerStyle() {
        return dqa.b.d;
    }

    public d(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, null);
        LayoutInflater.from(r2).inflate(2131564867, this);
        SpaceLoadingImage r3 = (SpaceLoadingImage) findViewById(2131386418);
        this.a = r3;
        r3.stop();
    }

    public final void e(h r2, RefreshState r3, RefreshState r4) {
        Intrinsics.checkNotNullParameter(r2, "refreshLayout");
        Intrinsics.checkNotNullParameter(r3, "oldState");
        Intrinsics.checkNotNullParameter(r4, "newState");
        SpaceLoadingImage r5 = this.a;
        if (r4 != RefreshState.None) goto L5;
        r5.stop();
        return;
    L5:
        UDLoadingDrawable r6 = r5.a;
        if (r6 == null) goto L10;
        r6.start();
        return;
    }
}
