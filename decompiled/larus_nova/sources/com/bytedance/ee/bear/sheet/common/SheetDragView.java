package com.bytedance.ee.bear.sheet.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.home.BaseStandardHomeFragment;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.d;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes18.dex */
public class SheetDragView extends CommonActionPanelLayout implements d.b {
    public float A;
    public on5.a B;
    public boolean C;
    public String D;
    public String E;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public a f237473v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public c f237474w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public d f237475x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f237476y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f237477z;

    public interface a {
        void a();
    }

    public interface b {
    }

    public interface c {
        void Q5();

        void W6();
    }

    public void setOnHeightChangeListener(b r100) {
    }

    public final void n() {
        d r100 = this.f237475x;
        float r101 = r100.f226588c[2];
        if (r101 <= r100.b()) goto L5;
        r100.k(r101);
    L5:
        this.C = false;
    }

    public SheetDragView(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d.b
    public final void a(int r100) {
        if (r100 != 0) goto L6;
        m("close");
        a r101 = this.f237473v;
        if (r101 == null) goto L17;
        r101.a();
        return;
    L17:
        return;
    L6:
        float r102 = r100;
        if (Math.abs(r102 - this.f237477z) >= 1.0f) goto L12;
        m("mid");
        c r103 = this.f237474w;
        if (r103 == null) goto L19;
        r103.W6();
        return;
    L19:
        return;
    L12:
        if (Math.abs(r102 - this.A) >= 1.0f) goto L21;
        m(BitableFieldEditAnalytic.ProgressFieldEditScene.MAX);
        c r104 = this.f237474w;
        if (r104 == null) goto L22;
        r104.Q5();
        return;
    L22:
        return;
    }

    public final void m(String r100) {
        if (this.E.equals(r100) == true) goto L9;
        this.E = r100;
        if (this.C == false) goto L7;
        on5.a r101 = this.B;
        String r102 = this.D;
        r101.getClass();
        HashMap r103 = new HashMap();
        r103.put("source", r102);
        r103.put("fab_type", on5.a.f524352b);
        r103.put("op_item", r100);
        r101.c(BaseStandardHomeFragment.KEY_PANEL_HEIGHT, r103);
        return;
    L7:
        this.C = true;
        return;
    }

    public void setDocumentUrl(BearUrl r100) {
        this.B.f524353a = r100;
    }

    public void setDragUpEnable(boolean r100) {
        d r101 = this.f237475x;
        if (r101 == null) goto L6;
        r101.f226595j = r100;
        return;
    }

    public void setOnCloseListener(a r100) {
        this.f237473v = r100;
    }

    public void setOnPositionChangeListener(c r100) {
        this.f237474w = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout
    public void setSlideView(View r100) {
        if (r100 == null) goto L5;
        this.f237475x.i(r100);
        return;
    }

    public void setSource(String r100) {
        this.D = r100;
    }

    public SheetDragView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public SheetDragView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f237476y = 0.0f;
        this.f237477z = getContext().getResources().getDimensionPixelSize(R.dimen.sheet_panel_dragview_height);
        this.A = n.t() * 0.75f;
        d r103 = new d(getContext(), this, this.f237476y, this.f237477z, this.A);
        this.f237475x = r103;
        r103.i(getTopBar());
        this.f237475x.i(getDragHandler());
        this.f237475x.f226593h = this;
        getDragHandler().setOnClickListener(new qm5.c(this));
        this.B = new on5.a();
        this.C = true;
        this.E = "";
    }
}
