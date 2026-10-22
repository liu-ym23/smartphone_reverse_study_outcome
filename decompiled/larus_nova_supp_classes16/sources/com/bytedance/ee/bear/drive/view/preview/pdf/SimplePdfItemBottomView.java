package com.bytedance.ee.bear.drive.view.preview.pdf;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SimplePdfItemBottomView extends FrameLayout {
    public View a;
    public View b;
    public View c;

    public final void a() {
        this.a = LayoutInflater.from(getContext()).inflate(2131560231, this, false);
        this.b = LayoutInflater.from(getContext()).inflate(2131560232, this, false);
        this.c = LayoutInflater.from(getContext()).inflate(2131560233, this, false);
    }

    public SimplePdfItemBottomView(Context r1) {
        super(r1);
        a();
    }

    public void setOnRetryClickListener(View.OnClickListener r3) {
        this.b.findViewById(2131386523).setOnClickListener(r3);
    }

    public void setOnSeeAllClickListener(View.OnClickListener r3) {
        this.c.findViewById(2131386524).setOnClickListener(r3);
    }

    public SimplePdfItemBottomView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a();
    }

    public SimplePdfItemBottomView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a();
    }
}
