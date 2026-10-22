package com.bytedance.ee.bear.drive.biz.preview.block;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import kac.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveBlockTitleView extends FrameLayout {
    public ImageView a;
    public TextView b;
    public boolean c;
    public int d;
    public View e;

    public final void a() {
        LayoutInflater.from(getContext()).inflate(2131560181, this);
        this.a = (ImageView) findViewById(2131374718);
        this.b = (TextView) findViewById(2131388772);
        this.e = findViewById(2131364279);
        this.a.setImageResource(a.b(2131254721));
    }

    public DriveBlockTitleView(Context r1) {
        super(r1);
        a();
    }

    public void setForceGone(boolean r1) {
        this.c = r1;
        setVisibility(this.d);
    }

    public void setIcon(int r2) {
        this.a.setImageResource(a.b(r2));
    }

    public void setTitle(CharSequence r2) {
        this.b.setText(r2);
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        this.d = r2;
        if (this.c == false) goto L6;
        super.setVisibility(8);
        return;
    L6:
        super.setVisibility(r2);
    }

    public DriveBlockTitleView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a();
    }
}
