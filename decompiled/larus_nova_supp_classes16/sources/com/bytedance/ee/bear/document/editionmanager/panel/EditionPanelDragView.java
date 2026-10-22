package com.bytedance.ee.bear.document.editionmanager.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.d;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.util.ui.n;
import d15.e;
import d15.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class EditionPanelDragView extends CommonActionPanelLayout implements d.b {
    public b v;
    public d w;
    public float x;
    public float y;

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    public void setOnCloseListener(a r1) {
    }

    public void setOnPositionChangeListener(c r1) {
    }

    public EditionPanelDragView(Context r2) {
        this(r2, null);
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d.b
    public final void a(int r3) {
        b r0 = this.v;
        if (r0 == null) goto L8;
        EditionListFragment r1 = ((e) r0).a;
        if (r3 != 0) goto L7;
        r1.h.updateActive(false);
        goto L8
    L7:
        int r2 = EditionListFragment.o;
        r1.getClass();
    L8:
        if (r3 == 0) goto L15;
        float r4 = r3;
        if (Math.abs(r4 - this.x) < 1.0f) goto L16;
        Math.abs(r4 - this.y);
        return;
    L16:
        return;
    }

    public void setDragUpEnable(boolean r2) {
        d r0 = this.w;
        if (r0 == null) goto L6;
        r0.j = r2;
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

    public EditionPanelDragView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EditionPanelDragView(Context r7, AttributeSet r8, int r9) {
        super(r7, r8, r9);
        this.x = getContext().getResources().getDimensionPixelSize(2131166477);
        this.y = n.t() * 0.75f;
        d r10 = new d(getContext(), this, 0.0f, this.x, this.y);
        this.w = r10;
        r10.i(getTopBar());
        this.w.i(getDragHandler());
        this.w.h = this;
        getDragHandler().setOnClickListener(new i(this));
        this.w.l = true;
    }
}
