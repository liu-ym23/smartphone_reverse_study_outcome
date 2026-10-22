package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes14.dex */
public class DmtLoadingLayout extends FrameLayout implements f, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f193281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f193282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f193283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f193284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f193285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f193286f;

    public final void b() {
        if (this.f193285e == true) goto L5;
        return;
    L5:
        FrameLayout.LayoutParams r100 = (FrameLayout.LayoutParams) this.f193282b.getLayoutParams();
        int r101 = r100.height;
        int[] r102 = new int[2];
        getLocationOnScreen(r102);
        int r103 = (((d0.c(getContext()) - this.f193286f) - r102[1]) / 2) - (r101 / 2);
        r100.gravity = 49;
        r100.topMargin = r103;
        this.f193282b.setLayoutParams(r100);
    }

    public DmtLoadingLayout(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.f
    public final void a(int r100) {
        if (this.f193283c == r100) goto L6;
        this.f193283c = r100;
        return;
    }

    public void setProgressBarInfo(int r100) {
        if (r100 <= 0) goto L5;
        FrameLayout.LayoutParams r101 = (FrameLayout.LayoutParams) this.f193281a.getLayoutParams();
        r101.width = r100;
        r101.height = r100;
        this.f193281a.setLayoutParams(r101);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.h
    public void setUseScreenHeight(int r100) {
        this.f193285e = true;
        this.f193286f = r100;
        b();
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        View r101 = this.f193281a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setVisibility(r100);
    }

    public void setWeakInfoShow(boolean r100) {
        if (r100 == false) goto L7;
        this.f193284d.setVisibility(0);
        if (TextUtils.isEmpty("") == true) goto L6;
        this.f193284d.setText("");
        return;
    L6:
        this.f193284d.setText("网络信号弱，马上加载完成");
        return;
    L7:
        this.f193284d.setVisibility(8);
    }

    public DmtLoadingLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public DmtLoadingLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f193283c = 1;
        View r103 = LayoutInflater.from(r100).inflate(R.layout.aos_layout_loading_modify, this, true);
        this.f193281a = r103.findViewById(R.id.double_loading_view);
        this.f193282b = (FrameLayout) r103.findViewById(R.id.progressBarLayout);
        this.f193284d = (TextView) r103.findViewById(R.id.weak_net_info_test);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        b();
    }
}
