package com.ss.android.ugc.tools.view.widget.statusview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.shortvideo.ScreenUtils;

/* JADX INFO: loaded from: classes40.dex */
public class AVLoadingLayout extends FrameLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f455173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f455174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f455175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f455176d;

    public final void a() {
        if (this.f455175c == true) goto L5;
        return;
    L5:
        FrameLayout.LayoutParams r100 = (FrameLayout.LayoutParams) this.f455174b.getLayoutParams();
        int r101 = r100.height;
        int[] r102 = new int[2];
        getLocationOnScreen(r102);
        int r103 = (((ScreenUtils.a(getContext()) - this.f455176d) - r102[1]) / 2) - (r101 / 2);
        r100.gravity = 49;
        r100.topMargin = r103;
        this.f455174b.setLayoutParams(r100);
    }

    public AVLoadingLayout(Context r100) {
        this(r100, null);
    }

    public void setProgressBarInfo(int r100) {
        if (r100 <= 0) goto L5;
        FrameLayout.LayoutParams r101 = (FrameLayout.LayoutParams) this.f455173a.getLayoutParams();
        r101.width = r100;
        r101.height = r100;
        this.f455173a.setLayoutParams(r101);
        return;
    }

    @Override // com.ss.android.ugc.tools.view.widget.statusview.c
    public void setUseScreenHeight(int r100) {
        this.f455175c = true;
        this.f455176d = r100;
        a();
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        View r101 = this.f455173a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setVisibility(r100);
    }

    public AVLoadingLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public AVLoadingLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.tools_layout_loading, this, true);
        this.f455173a = r103.findViewById(R.id.double_loading_view);
        this.f455174b = (FrameLayout) r103.findViewById(R.id.progressBarLayout);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        a();
    }
}
