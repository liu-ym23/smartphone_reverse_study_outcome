package com.bytedance.live.photoviewer.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes19.dex */
public class LoadingLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DoubleColorBallAnimationView f255738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f255739b;

    public LoadingLayout(Context r100) {
        super(r100);
        a(r100);
    }

    public final void a(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        View r101 = LayoutInflater.from(r100).inflate(R.layout.loading_view, this, true);
        this.f255738a = (DoubleColorBallAnimationView) r101.findViewById(R.id.double_loading_view);
        this.f255739b = (TextView) r101.findViewById(R.id.double_loading_text);
    }

    public void setLoadingText(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        this.f255739b.setVisibility(8);
        return;
    L5:
        this.f255739b.setVisibility(0);
        this.f255739b.setText(r100);
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        DoubleColorBallAnimationView r101 = this.f255738a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setVisibility(r100);
    }

    public LoadingLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100);
    }
}
