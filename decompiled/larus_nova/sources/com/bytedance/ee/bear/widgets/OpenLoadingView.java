package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class OpenLoadingView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Button f240111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ProgressBar f240112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f240113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f240114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f240115e;

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.space_facade_external_loading_view, this);
        this.f240111a = (Button) findViewById(R.id.cancel);
        this.f240112b = (ProgressBar) findViewById(R.id.progress_bar);
        this.f240113c = (TextView) findViewById(R.id.loading_title);
        this.f240114d = (TextView) findViewById(R.id.tv_progress);
    }

    public OpenLoadingView(Context r100) {
        super(r100);
        a();
    }

    public void setCancelClickListener(View.OnClickListener r100) {
        this.f240111a.setOnClickListener(r100);
    }

    public void setProgress(int r100) {
        if (r100 >= 0) goto L6;
        this.f240115e = 0;
    L9:
        this.f240112b.setProgress(this.f240115e);
        this.f240114d.setText(String.format("%d%%", new Object[]{Integer.valueOf(this.f240115e)}));
        return;
    L6:
        if (r100 <= 100) goto L8;
        this.f240115e = 100;
        goto L9
    L8:
        this.f240115e = r100;
        goto L9
    }

    public void setTitle(int r100) {
        this.f240113c.setText(r100);
    }

    public OpenLoadingView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    public OpenLoadingView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }
}
