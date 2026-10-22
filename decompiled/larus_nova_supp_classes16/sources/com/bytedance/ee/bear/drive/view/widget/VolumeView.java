package com.bytedance.ee.bear.drive.view.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class VolumeView extends FrameLayout implements View.OnClickListener {
    public ImageView a;
    public ImageView b;
    public boolean c;
    public a d;

    public interface a {
        void f(boolean r1);
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(2131560251, this);
        this.a = (ImageView) findViewById(2131386506);
        this.b = (ImageView) findViewById(2131392641);
        setSilent(this.c);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
    }

    public VolumeView(Context r1) {
        super(r1);
        this.c = false;
        a();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        int r3 = r2.getId();
        if (r3 != 2131386506) goto L6;
        setSilent(false);
        return;
    L6:
        if (r3 != 2131392641) goto L10;
        setSilent(true);
        return;
    }

    public void setSilent(boolean r4) {
        this.c = r4;
        if (r4 == false) goto L5;
        this.a.setVisibility(0);
        this.b.setVisibility(8);
    L6:
        a r0 = this.d;
        if (r0 == null) goto L10;
        r0.f(r4);
        return;
    L10:
        return;
    L5:
        this.a.setVisibility(8);
        this.b.setVisibility(0);
        goto L6
    }

    public void setSilentDrawable(Drawable r2) {
        this.a.setImageDrawable(r2);
    }

    public void setSilentSrc(int r2) {
        this.a.setImageResource(r2);
    }

    public void setVocalDrawable(Drawable r2) {
        this.b.setImageDrawable(r2);
    }

    public void setVocalSrc(int r2) {
        this.b.setImageResource(r2);
    }

    public void setVolumeStateChangedListener(a r1) {
        this.d = r1;
    }

    public VolumeView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.c = false;
        a();
    }

    public VolumeView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.c = false;
        a();
    }
}
