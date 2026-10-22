package com.bytedance.ee.bear.drive.view.preview.pdf;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class SimplePdfItemBottomView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f225079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f225080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f225081c;

    public final void a() {
        this.f225079a = LayoutInflater.from(getContext()).inflate(R.layout.drive_simple_pdf_item_bottom_loading, this, false);
        this.f225080b = LayoutInflater.from(getContext()).inflate(R.layout.drive_simple_pdf_item_bottom_retry, this, false);
        this.f225081c = LayoutInflater.from(getContext()).inflate(R.layout.drive_simple_pdf_item_bottom_see_all, this, false);
    }

    public SimplePdfItemBottomView(Context r100) {
        super(r100);
        a();
    }

    public void setOnRetryClickListener(View.OnClickListener r100) {
        this.f225080b.findViewById(R.id.simple_pdf_bottom_view_retry).setOnClickListener(r100);
    }

    public void setOnSeeAllClickListener(View.OnClickListener r100) {
        this.f225081c.findViewById(R.id.simple_pdf_bottom_view_see_all).setOnClickListener(r100);
    }

    public SimplePdfItemBottomView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    public SimplePdfItemBottomView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }
}
