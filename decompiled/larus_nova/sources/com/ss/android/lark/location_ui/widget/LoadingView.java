package com.ss.android.lark.location_ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public class LoadingView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ProgressBar f431281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f431282b;

    public final void a() {
        String r100 = getResources().getString(R.string.Lark_Chat_MapsSearchNoresults);
        this.f431281a.setVisibility(8);
        this.f431282b.setText(r100);
    }

    public final void b() {
        String r100 = getResources().getString(R.string.Lark_Legacy_LoadingTip);
        setVisibility(0);
        this.f431281a.setVisibility(0);
        this.f431282b.setText(r100);
    }

    public LoadingView(Context r100) {
        this(r100, null);
    }

    public LoadingView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public LoadingView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102, 0);
        LayoutInflater.from(getContext()).inflate(R.layout.location_loading_view, this);
        this.f431281a = (ProgressBar) findViewById(R.id.location_pb_loading);
        this.f431282b = (TextView) findViewById(R.id.location_tv_desc);
    }
}
