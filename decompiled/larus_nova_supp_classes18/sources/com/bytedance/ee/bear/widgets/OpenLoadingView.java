package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OpenLoadingView extends LinearLayout {
    public Button a;
    public ProgressBar b;
    public TextView c;
    public TextView d;
    public int e;

    public final void a() {
        LayoutInflater.from(getContext()).inflate(2131564894, this);
        this.a = (Button) findViewById(2131365114);
        this.b = (ProgressBar) findViewById(2131383297);
        this.c = (TextView) findViewById(2131379086);
        this.d = (TextView) findViewById(2131391185);
    }

    public OpenLoadingView(Context r1) {
        super(r1);
        a();
    }

    public void setCancelClickListener(View.OnClickListener r2) {
        this.a.setOnClickListener(r2);
    }

    public void setProgress(int r4) {
        if (r4 >= 0) goto L6;
        this.e = 0;
    L9:
        this.b.setProgress(this.e);
        this.d.setText(String.format("%d%%", new Object[]{Integer.valueOf(this.e)}));
        return;
    L6:
        if (r4 <= 100) goto L8;
        this.e = 100;
        goto L9
    L8:
        this.e = r4;
        goto L9
    }

    public void setTitle(int r2) {
        this.c.setText(r2);
    }

    public OpenLoadingView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a();
    }

    public OpenLoadingView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a();
    }
}
