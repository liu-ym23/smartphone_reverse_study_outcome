package com.bytedance.ee.bear.fileselector.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.d;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class FilePanelDragView extends CommonActionPanelLayout implements d.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public b f226796v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public d f226797w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f226798x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f226799y;

    public interface a {
    }

    public interface b {
        void a(int r100);
    }

    public interface c {
    }

    public void setOnCloseListener(a r100) {
    }

    public void setOnPositionChangeListener(c r100) {
    }

    public void setSource(String r100) {
    }

    public FilePanelDragView(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d.b
    public final void a(int r100) {
        b r101 = this.f226796v;
        if (r101 == null) goto L5;
        r101.a(r100);
    L5:
        if (r100 == 0) goto L12;
        float r102 = r100;
        if (Math.abs(r102 - this.f226798x) < 1.0f) goto L13;
        Math.abs(r102 - this.f226799y);
        return;
    L13:
        return;
    }

    public void setOnHeightChangeListener(b r100) {
        this.f226796v = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout
    public void setSlideView(View r100) {
        if (r100 == null) goto L5;
        this.f226797w.i(r100);
        return;
    }

    public FilePanelDragView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public FilePanelDragView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f226798x = getContext().getResources().getDimensionPixelSize(R.dimen.file_panel_dragview_height);
        this.f226799y = n.t() * 0.85f;
        d r103 = new d(getContext(), this, 0.0f, this.f226798x, this.f226799y);
        this.f226797w = r103;
        r103.i(getTopBar());
        this.f226797w.f226593h = this;
        getDragHandler().setOnClickListener(new cb5.a(this));
    }
}
