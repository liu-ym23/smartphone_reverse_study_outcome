package com.bytedance.ee.bear.drive.view.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class VolumeView extends FrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f225965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f225966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f225967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f225968d;

    public interface a {
        void f(boolean r100);
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.drive_volume_view, this);
        this.f225965a = (ImageView) findViewById(R.id.silent);
        this.f225966b = (ImageView) findViewById(R.id.vocal);
        setSilent(this.f225967c);
        this.f225965a.setOnClickListener(this);
        this.f225966b.setOnClickListener(this);
    }

    public VolumeView(Context r100) {
        super(r100);
        this.f225967c = false;
        a();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = r100.getId();
        if (r101 != R.id.silent) goto L6;
        setSilent(false);
        return;
    L6:
        if (r101 != R.id.vocal) goto L10;
        setSilent(true);
        return;
    }

    public void setSilent(boolean r100) {
        this.f225967c = r100;
        if (r100 == false) goto L5;
        this.f225965a.setVisibility(0);
        this.f225966b.setVisibility(8);
    L6:
        a r101 = this.f225968d;
        if (r101 == null) goto L10;
        r101.f(r100);
        return;
    L10:
        return;
    L5:
        this.f225965a.setVisibility(8);
        this.f225966b.setVisibility(0);
        goto L6
    }

    public void setSilentDrawable(Drawable r100) {
        this.f225965a.setImageDrawable(r100);
    }

    public void setSilentSrc(int r100) {
        this.f225965a.setImageResource(r100);
    }

    public void setVocalDrawable(Drawable r100) {
        this.f225966b.setImageDrawable(r100);
    }

    public void setVocalSrc(int r100) {
        this.f225966b.setImageResource(r100);
    }

    public void setVolumeStateChangedListener(a r100) {
        this.f225968d = r100;
    }

    public VolumeView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f225967c = false;
        a();
    }

    public VolumeView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f225967c = false;
        a();
    }
}
