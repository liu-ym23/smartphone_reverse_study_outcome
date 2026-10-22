package com.bytedance.ee.bear.document.export.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FileExportTypeItemView extends FrameLayout {
    public final ImageView a;
    public final TextView b;

    public FileExportTypeItemView(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        if (r1 == false) goto L5;
        float r2 = 1.0f;
    L6:
        setAlpha(r2);
        return;
    L5:
        r2 = 0.5f;
        goto L6
    }

    @Override // android.view.View
    public void setSelected(boolean r1) {
        super.setSelected(r1);
        if (r1 == false) goto L5;
        int r2 = 2131233912;
    L6:
        setBackgroundResource(r2);
        return;
    L5:
        r2 = 2131233911;
        goto L6
    }

    public void setTitleMaxLines(int r2) {
        this.b.setMaxLines(r2);
    }

    public FileExportTypeItemView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final void a(int r2, int r3) {
        this.a.setImageResource(r2);
        this.b.setText(r3);
    }

    public FileExportTypeItemView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        LayoutInflater.from(r1).inflate(2131560123, this, true);
        this.a = (ImageView) findViewById(2131371976);
        this.b = (TextView) findViewById(2131371977);
        setBackgroundResource(2131233911);
        setClickable(true);
        setFocusable(true);
    }
}
