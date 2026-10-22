package com.bytedance.ee.bear.facade.common.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import cqa.h;
import dqa.b;
import wa5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PlaceholderHeader extends View implements a {
    public a a;

    public final boolean a() {
        return false;
    }

    public final void d(float r1, int r2, int r3) {
    }

    public final void f(h r1, int r2, int r3) {
    }

    public View getView() {
        return this;
    }

    public void setPrimaryColors(int... r1) {
    }

    public b getSpinnerStyle() {
        return b.d;
    }

    public PlaceholderHeader(Context r1) {
        super(r1);
    }

    @Override // wa5.a
    public void setAssociatedHeader(a r1) {
        this.a = r1;
    }

    @Override // wa5.a
    public void setCustomText(String r2) {
        a r0 = this.a;
        if (r0 == null) goto L6;
        r0.setCustomText(r2);
        return;
    }

    @Override // wa5.a
    public void setStartNumber(int r2) {
        a r0 = this.a;
        if (r0 == null) goto L6;
        r0.setStartNumber(r2);
        return;
    }

    public PlaceholderHeader(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public final int j(SmartRefreshLayout r2, boolean r3) {
        a r0 = this.a;
        if (r0 != null) goto L5;
        return 500;
    L5:
        return r0.j(r2, r3);
    }

    public PlaceholderHeader(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public final void e(h r2, RefreshState r3, RefreshState r4) {
        a r0 = this.a;
        if (r0 == null) goto L6;
        r0.e(r2, r3, r4);
        return;
    }

    public final void g(SmartRefreshLayout.j r2, int r3, int r4) {
        a r0 = this.a;
        if (r0 == null) goto L6;
        r0.g(r2, r3, r4);
        return;
    }

    public final void i(h r2, int r3, int r4) {
        a r0 = this.a;
        if (r0 == null) goto L6;
        r0.i(r2, r3, r4);
        return;
    }

    public final void b(boolean r7, float r8, int r9, int r10, int r11) {
        a r0 = this.a;
        if (r0 == null) goto L6;
        r0.b(r7, r8, r9, r10, r11);
        return;
    }
}
