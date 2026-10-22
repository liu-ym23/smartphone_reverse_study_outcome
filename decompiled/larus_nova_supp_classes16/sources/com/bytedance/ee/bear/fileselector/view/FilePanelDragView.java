package com.bytedance.ee.bear.fileselector.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.d;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FilePanelDragView extends CommonActionPanelLayout implements d.b {
    public b v;
    public d w;
    public float x;
    public float y;

    public interface a {
    }

    public interface b {
        void a(int r1);
    }

    public interface c {
    }

    public void setOnCloseListener(a r1) {
    }

    public void setOnPositionChangeListener(c r1) {
    }

    public void setSource(String r1) {
    }

    public FilePanelDragView(Context r2) {
        this(r2, null);
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d.b
    public final void a(int r3) {
        b r0 = this.v;
        if (r0 == null) goto L5;
        r0.a(r3);
    L5:
        if (r3 == 0) goto L12;
        float r4 = r3;
        if (Math.abs(r4 - this.x) < 1.0f) goto L13;
        Math.abs(r4 - this.y);
        return;
    L13:
        return;
    }

    public void setOnHeightChangeListener(b r1) {
        this.v = r1;
    }

    public void setSlideView(View r2) {
        if (r2 == null) goto L5;
        this.w.i(r2);
        return;
    }

    public FilePanelDragView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FilePanelDragView(Context r7, AttributeSet r8, int r9) {
        super(r7, r8, r9);
        this.x = getContext().getResources().getDimensionPixelSize(2131166508);
        this.y = n.t() * 0.85f;
        d r10 = new d(getContext(), this, 0.0f, this.x, this.y);
        this.w = r10;
        r10.i(getTopBar());
        this.w.h = this;
        getDragHandler().setOnClickListener(new cb5.a(this));
    }
}
