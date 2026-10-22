package com.bytedance.android.shopping.store.tabkit.mixframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import cqa.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends FrameLayout implements cqa.e {
    public final LoadMoreStatusView a;

    public static final class a {
    }

    static {
    }

    public final boolean a() {
        return false;
    }

    public final void d(float r1, int r2, int r3) {
    }

    public final void e(h r2, RefreshState r3, RefreshState r4) {
        Intrinsics.checkNotNullParameter(r2, "refreshLayout");
        Intrinsics.checkNotNullParameter(r3, "oldState");
        Intrinsics.checkNotNullParameter(r4, "newState");
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

    public void setPrimaryColors(int... r2) {
        Intrinsics.checkNotNullParameter(r2, "colors");
    }

    public dqa.b getSpinnerStyle() {
        return dqa.b.d;
    }

    public f(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        LoadMoreStatusView r4 = LayoutInflater.from(r3).inflate(2131560921, this, true).findViewById(2131370123);
        this.a = r4;
        if (r4 == null) goto L6;
        r4.setVisibility(0);
        return;
    }

    public final int j(SmartRefreshLayout r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "refreshLayout");
        LoadMoreStatusView r3 = this.a;
        if (r3 == null) goto L7;
        r3.b();
        return 10;
    L7:
        return 10;
    }

    public final void f(h r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "refreshLayout");
        LoadMoreStatusView r4 = this.a;
        if (r4 == null) goto L6;
        r4.a();
        return;
    }

    public final void b(boolean r1, float r2, int r3, int r4, int r5) {
        LoadMoreStatusView r6 = this.a;
        if (r6 == null) goto L6;
        r6.a();
        return;
    }
}
