package com.bytedance.ee.bear.drive.biz.preview.block;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.nova.R;
import kac.a;

/* JADX INFO: loaded from: classes16.dex */
public class DriveBlockTitleView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f223280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f223281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f223282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f223283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f223284e;

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.drive_block_titlebar, this);
        this.f223280a = (ImageView) findViewById(R.id.icon);
        this.f223281b = (TextView) findViewById(R.id.title);
        this.f223284e = findViewById(R.id.block_preview);
        this.f223280a.setImageResource(a.b(R.drawable.ud_icon_file_unknow_colorful));
    }

    public DriveBlockTitleView(Context r100) {
        super(r100);
        a();
    }

    public void setForceGone(boolean r100) {
        this.f223282c = r100;
        setVisibility(this.f223283d);
    }

    public void setIcon(int r100) {
        this.f223280a.setImageResource(a.b(r100));
    }

    public void setTitle(CharSequence r100) {
        this.f223281b.setText(r100);
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        this.f223283d = r100;
        if (this.f223282c == false) goto L6;
        super.setVisibility(8);
        return;
    L6:
        super.setVisibility(r100);
    }

    public DriveBlockTitleView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }
}
