package com.bytedance.android.shopping.mall.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import cqa.e;
import cqa.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends FrameLayout implements e {
    public final TextView a;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.widget.a$a, reason: collision with other inner class name */
    public static final class C0114a {
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

    public a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.a = (TextView) LayoutInflater.from(r3).inflate(2131564672, this, true).findViewById(2131370122);
    }

    public final void setNightMode(boolean r3) {
        if (r3 == false) goto L6;
        TextView r4 = this.a;
        if (r4 == null) goto L10;
        r4.setTextColor(getResources().getColor(2131106120));
        return;
    L10:
        return;
    L6:
        TextView r5 = this.a;
        if (r5 == null) goto L12;
        r5.setTextColor(getResources().getColor(2131106104));
        return;
    }

    public final int j(SmartRefreshLayout r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "refreshLayout");
        TextView r4 = this.a;
        if (r4 == null) goto L10;
        if (r3 == false) goto L6;
        String r5 = "刷新完成";
    L7:
        r4.setText(r5);
        return 10;
    L6:
        r5 = "刷新失败";
        goto L7
    L10:
        return 10;
    }

    public final void f(h r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "refreshLayout");
        TextView r4 = this.a;
        if (r4 == null) goto L6;
        r4.setText("加载中..");
        return;
    }

    public final void b(boolean r1, float r2, int r3, int r4, int r5) {
        if (r1 == false) goto L11;
        TextView r6 = this.a;
        if (r6 != null) goto L6;
        return;
    L6:
        if (r2 <= 1) goto L8;
        String r7 = "释放立即刷新";
    L9:
        r6.setText(r7);
        return;
    L8:
        r7 = "下拉可以刷新";
        goto L9
    }
}
