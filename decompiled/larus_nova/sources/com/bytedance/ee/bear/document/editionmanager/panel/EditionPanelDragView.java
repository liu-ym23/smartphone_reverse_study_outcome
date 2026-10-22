package com.bytedance.ee.bear.document.editionmanager.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.d;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import d15.e;
import d15.i;

/* JADX INFO: loaded from: classes16.dex */
public class EditionPanelDragView extends CommonActionPanelLayout implements d.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public b f219667v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public d f219668w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f219669x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f219670y;

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    public void setOnCloseListener(a r100) {
    }

    public void setOnPositionChangeListener(c r100) {
    }

    public EditionPanelDragView(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d.b
    public final void a(int r100) {
        b r101 = this.f219667v;
        if (r101 == null) goto L8;
        EditionListFragment r102 = ((e) r101).f466380a;
        if (r100 != 0) goto L7;
        r102.f219657h.updateActive(false);
        goto L8
    L7:
        int r103 = EditionListFragment.f219656o;
        r102.getClass();
    L8:
        if (r100 == 0) goto L15;
        float r104 = r100;
        if (Math.abs(r104 - this.f219669x) < 1.0f) goto L16;
        Math.abs(r104 - this.f219670y);
        return;
    L16:
        return;
    }

    public void setDragUpEnable(boolean r100) {
        d r101 = this.f219668w;
        if (r101 == null) goto L6;
        r101.f226595j = r100;
        return;
    }

    public void setOnHeightChangeListener(b r100) {
        this.f219667v = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout
    public void setSlideView(View r100) {
        if (r100 == null) goto L5;
        this.f219668w.i(r100);
        return;
    }

    public EditionPanelDragView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public EditionPanelDragView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f219669x = getContext().getResources().getDimensionPixelSize(R.dimen.edition_panel_drag_view_height);
        this.f219670y = n.t() * 0.75f;
        d r103 = new d(getContext(), this, 0.0f, this.f219669x, this.f219670y);
        this.f219668w = r103;
        r103.i(getTopBar());
        this.f219668w.i(getDragHandler());
        this.f219668w.f226593h = this;
        getDragHandler().setOnClickListener(new i(this));
        this.f219668w.f226597l = true;
    }
}
