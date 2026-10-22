package com.bytedance.ee.bear.document.export.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class FileExportTypeItemView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f219843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f219844b;

    public FileExportTypeItemView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        if (r100 == false) goto L5;
        float r101 = 1.0f;
    L6:
        setAlpha(r101);
        return;
    L5:
        r101 = 0.5f;
        goto L6
    }

    @Override // android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        if (r100 == false) goto L5;
        int r101 = R.drawable.document_export_type_item_selected;
    L6:
        setBackgroundResource(r101);
        return;
    L5:
        r101 = R.drawable.document_export_type_item_normal;
        goto L6
    }

    public void setTitleMaxLines(int r100) {
        this.f219844b.setMaxLines(r100);
    }

    public FileExportTypeItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void a(int r100, int r101) {
        this.f219843a.setImageResource(r100);
        this.f219844b.setText(r101);
    }

    public FileExportTypeItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.document_export_type_item, this, true);
        this.f219843a = (ImageView) findViewById(R.id.export_type_icon);
        this.f219844b = (TextView) findViewById(R.id.export_type_title);
        setBackgroundResource(R.drawable.document_export_type_item_normal);
        setClickable(true);
        setFocusable(true);
    }
}
