package com.bytedance.ee.bear.document.editionmanager.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.bytedance.ee.bear.widgets.universedesign.SpaceLoadingImage;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import cqa.d;
import cqa.h;
import dqa.b;

/* JADX INFO: loaded from: classes16.dex */
public class EditionListMoreFooter extends RelativeLayout implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f219664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SpaceLoadingImage f219665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f219666c;

    @Override // cqa.f
    public final boolean a() {
        return false;
    }

    @Override // cqa.f
    public final void d(float r100, int r101, int r102) {
    }

    @Override // gqa.e
    public final void e(h r100, RefreshState r101, RefreshState r102) {
    }

    @Override // cqa.f
    public final void f(h r100, int r101, int r102) {
    }

    @Override // cqa.f
    public View getView() {
        return this;
    }

    @Override // cqa.f
    public final void i(h r100, int r101, int r102) {
    }

    @Override // cqa.f
    public final int j(SmartRefreshLayout r100, boolean r101) {
        return 0;
    }

    @Override // cqa.f
    public void setPrimaryColors(int... r100) {
    }

    @Override // cqa.f
    public b getSpinnerStyle() {
        return this.f219664a;
    }

    public EditionListMoreFooter(Context r100) {
        super(r100);
        this.f219664a = b.f469717d;
        k(r100);
    }

    @Override // cqa.d
    public final boolean c(boolean r100) {
        if (this.f219666c == r100) goto L7;
        this.f219666c = r100;
        if (r100 == false) goto L7;
        this.f219665b.stop();
        this.f219665b.setVisibility(8);
    L7:
        return r100;
    }

    public final void k(Context r100) {
        SpaceLoadingImage r101 = new SpaceLoadingImage(r100);
        this.f219665b = r101;
        r101.f240350a.setColorSchemeColors(new int[]{UDColorUtils.getColor(r100, R.color.primary_fill_default)});
        this.f219665b.setVisibility(0);
        RelativeLayout.LayoutParams r102 = new RelativeLayout.LayoutParams(-1, n.f(r100, 54));
        r102.addRule(13);
        addView(this.f219665b, r102);
    }

    public EditionListMoreFooter(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f219664a = b.f469717d;
        k(r100);
    }

    public EditionListMoreFooter(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f219664a = b.f469717d;
        k(r100);
    }

    @Override // cqa.f
    public final void g(SmartRefreshLayout.j r100, int r101, int r102) {
        r100.f405930a.K = false;
    }

    @Override // cqa.f
    public final void b(boolean r100, float r101, int r102, int r103, int r104) {
        if (r100 == false) goto L4;
        return;
    L4:
        if (this.f219666c == true) goto L10;
        this.f219665b.setVisibility(0);
        UDLoadingDrawable r105 = this.f219665b.f240350a;
        if (r105 == null) goto L11;
        r105.start();
        return;
    L11:
        return;
    }
}
