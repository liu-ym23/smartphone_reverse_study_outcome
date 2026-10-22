package com.bytedance.ee.bear.facade.common.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import cqa.h;
import dqa.b;
import wa5.a;

/* JADX INFO: loaded from: classes16.dex */
public class PlaceholderHeader extends View implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f226685a;

    @Override // cqa.f
    public final boolean a() {
        return false;
    }

    @Override // cqa.f
    public final void d(float r100, int r101, int r102) {
    }

    @Override // cqa.f
    public final void f(h r100, int r101, int r102) {
    }

    @Override // cqa.f
    public View getView() {
        return this;
    }

    @Override // cqa.f
    public void setPrimaryColors(int... r100) {
    }

    @Override // cqa.f
    public b getSpinnerStyle() {
        return b.f469717d;
    }

    public PlaceholderHeader(Context r100) {
        super(r100);
    }

    @Override // wa5.a
    public void setAssociatedHeader(a r100) {
        this.f226685a = r100;
    }

    @Override // wa5.a
    public void setCustomText(String r100) {
        a r101 = this.f226685a;
        if (r101 == null) goto L6;
        r101.setCustomText(r100);
        return;
    }

    @Override // wa5.a
    public void setStartNumber(int r100) {
        a r101 = this.f226685a;
        if (r101 == null) goto L6;
        r101.setStartNumber(r100);
        return;
    }

    public PlaceholderHeader(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // cqa.f
    public final int j(SmartRefreshLayout r100, boolean r101) {
        a r102 = this.f226685a;
        if (r102 != null) goto L5;
        return 500;
    L5:
        return r102.j(r100, r101);
    }

    public PlaceholderHeader(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    @Override // gqa.e
    public final void e(h r100, RefreshState r101, RefreshState r102) {
        a r103 = this.f226685a;
        if (r103 == null) goto L6;
        r103.e(r100, r101, r102);
        return;
    }

    @Override // cqa.f
    public final void g(SmartRefreshLayout.j r100, int r101, int r102) {
        a r103 = this.f226685a;
        if (r103 == null) goto L6;
        r103.g(r100, r101, r102);
        return;
    }

    @Override // cqa.f
    public final void i(h r100, int r101, int r102) {
        a r103 = this.f226685a;
        if (r103 == null) goto L6;
        r103.i(r100, r101, r102);
        return;
    }

    @Override // cqa.f
    public final void b(boolean r100, float r101, int r102, int r110, int r111) {
        a r103 = this.f226685a;
        if (r103 == null) goto L6;
        r103.b(r100, r101, r102, r110, r111);
        return;
    }
}
