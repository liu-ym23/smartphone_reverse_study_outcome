package com.ss.android.lark.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.github.ybq.android.spinkit.SpinKitView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public class CommonLoadingView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xu7.b f444534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f444535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SpinKitView f444536c;

    public CommonLoadingView(Context r100) {
        super(r100);
        a(r100);
    }

    public final void a(Context r100) {
        LinearLayout r101 = (LinearLayout) LayoutInflater.from(r100).inflate(R.layout.common_dialog_loading_layout, this, true);
        this.f444536c = (SpinKitView) r101.findViewById(R.id.spin_kit);
        TextView r102 = (TextView) r101.findViewById(R.id.content);
        this.f444535b = r101.findViewById(R.id.container);
        this.f444536c.setVisibility(8);
        xu7.b r103 = new xu7.b();
        this.f444534a = r103;
        this.f444536c.setIndeterminateDrawable(r103);
        this.f444534a.stop();
    }

    public void setContainerBackGround(Drawable r100) {
        this.f444535b.setBackground(r100);
    }

    public CommonLoadingView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100);
    }

    public CommonLoadingView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a(r100);
    }
}
