package com.bytedance.ies.dmt.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes19.dex */
public class DmtLoadingLayout extends FrameLayout implements e46.b, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DoubleColorBallAnimationView f248424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f248425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f248426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f248427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f248428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f248429f;

    public final void b() {
        if (this.f248428e == true) goto L5;
        return;
    L5:
        FrameLayout.LayoutParams r100 = (FrameLayout.LayoutParams) this.f248425b.getLayoutParams();
        int r101 = r100.height;
        int[] r102 = new int[2];
        getLocationOnScreen(r102);
        int r103 = (((j46.a.a(getContext()) - this.f248429f) - r102[1]) / 2) - (r101 / 2);
        r100.gravity = 49;
        r100.topMargin = r103;
        this.f248425b.setLayoutParams(r100);
    }

    public DmtLoadingLayout(Context r100) {
        this(r100, null);
    }

    @Override // e46.b
    public final void a(int r100) {
        if (this.f248426c == r100) goto L6;
        this.f248426c = r100;
        return;
    }

    public void setProgressBarInfo(int r100) {
        if (r100 <= 0) goto L7;
        DoubleColorBallAnimationView r101 = this.f248424a;
        if (r101 == null) goto L8;
        FrameLayout.LayoutParams r102 = (FrameLayout.LayoutParams) r101.getLayoutParams();
        r102.width = r100;
        r102.height = r100;
        this.f248424a.setLayoutParams(r102);
        return;
    L8:
        return;
    }

    public void setStartAnimationAfterAttach(boolean r100) {
        DoubleColorBallAnimationView r101 = this.f248424a;
        if (r101 == null) goto L6;
        r101.setStartAnimationAfterAttach(r100);
        return;
    }

    @Override // com.bytedance.ies.dmt.ui.widget.d
    public void setUseScreenHeight(int r100) {
        this.f248428e = true;
        this.f248429f = r100;
        b();
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        DoubleColorBallAnimationView r101 = this.f248424a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setVisibility(r100);
    }

    public void setWeakInfoShow(boolean r100) {
        TextView r101 = this.f248427d;
        if (r101 == null) goto L14;
        if (r100 == false) goto L10;
        r101.setVisibility(0);
        if (TextUtils.isEmpty("") == true) goto L9;
        this.f248427d.setText("");
        return;
    L9:
        this.f248427d.setText("网络信号弱，马上加载完成");
        return;
    L10:
        r101.setVisibility(8);
        return;
    }

    public DmtLoadingLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public DmtLoadingLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        int r103 = e46.a.f470987a;
        this.f248426c = 1;
        View r104 = LayoutInflater.from(r100).inflate(R.layout.layout_loading_modify, this, true);
        this.f248424a = (DoubleColorBallAnimationView) r104.findViewById(R.id.double_loading_view);
        this.f248425b = (FrameLayout) r104.findViewById(R.id.progressBarLayout);
        this.f248427d = (TextView) r104.findViewById(R.id.weak_net_info_test);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        b();
    }
}
