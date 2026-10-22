package com.bytedance.creativex.filter.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public class FilterIndicator extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f203422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f203423b;

    static {
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
    }

    public FilterIndicator(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
    }

    public FilterIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public FilterIndicator(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        RelativeLayout.inflate(getContext(), R.layout.tools_layout_filter_indicator, this);
        this.f203422a = (TextView) findViewById(R.id.first_tv);
        this.f203423b = (TextView) findViewById(R.id.second_tv);
        this.f203422a.setAlpha(1.0f);
        this.f203423b.setAlpha(1.0f);
        this.f203423b.setVisibility(0);
        this.f203422a.setVisibility(0);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        TextView r105 = this.f203422a;
        if (r105 != null) goto L5;
        return;
    L5:
        if (this.f203423b == null) goto L9;
        r105.getX();
        this.f203423b.getX();
        return;
    }
}
