package com.ss.android.ugc.tools.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes40.dex */
public class DoubleColorBallAnimationLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f455029a;

    public DoubleColorBallAnimationLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        View r101 = this.f455029a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setVisibility(r100);
    }

    public DoubleColorBallAnimationLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public DoubleColorBallAnimationLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f455029a = LayoutInflater.from(r100).inflate(R.layout.tools_layout_loading, this, true).findViewById(R.id.double_loading_view);
    }
}
