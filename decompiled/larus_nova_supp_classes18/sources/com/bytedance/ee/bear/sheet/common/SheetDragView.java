package com.bytedance.ee.bear.sheet.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.d;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.util.ui.n;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetDragView extends CommonActionPanelLayout implements d.b {
    public float A;
    public on5.a B;
    public boolean C;
    public String D;
    public String E;
    public a v;
    public c w;
    public d x;
    public float y;
    public float z;

    public interface a {
        void a();
    }

    public interface b {
    }

    public interface c {
        void Q5();

        void W6();
    }

    public void setOnHeightChangeListener(b r1) {
    }

    public final void n() {
        d r0 = this.x;
        float r1 = r0.c[2];
        if (r1 <= r0.b()) goto L5;
        r0.k(r1);
    L5:
        this.C = false;
    }

    public SheetDragView(Context r2) {
        this(r2, null);
    }

    public final void a(int r3) {
        if (r3 != 0) goto L6;
        m("close");
        a r4 = this.v;
        if (r4 == null) goto L17;
        r4.a();
        return;
    L17:
        return;
    L6:
        float r5 = r3;
        if (Math.abs(r5 - this.z) >= 1.0f) goto L12;
        m("mid");
        c r6 = this.w;
        if (r6 == null) goto L19;
        r6.W6();
        return;
    L19:
        return;
    L12:
        if (Math.abs(r5 - this.A) >= 1.0f) goto L21;
        m("max");
        c r7 = this.w;
        if (r7 == null) goto L22;
        r7.Q5();
        return;
    L22:
        return;
    }

    public final void m(String r5) {
        if (this.E.equals(r5) == true) goto L9;
        this.E = r5;
        if (this.C == false) goto L7;
        on5.a r0 = this.B;
        String r1 = this.D;
        r0.getClass();
        HashMap r2 = new HashMap();
        r2.put("source", r1);
        r2.put("fab_type", on5.a.b);
        r2.put("op_item", r5);
        r0.c("panel_height", r2);
        return;
    L7:
        this.C = true;
        return;
    }

    public void setDocumentUrl(BearUrl r2) {
        this.B.a = r2;
    }

    public void setDragUpEnable(boolean r2) {
        d r0 = this.x;
        if (r0 == null) goto L6;
        r0.j = r2;
        return;
    }

    public void setOnCloseListener(a r1) {
        this.v = r1;
    }

    public void setOnPositionChangeListener(c r1) {
        this.w = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout
    public void setSlideView(View r2) {
        if (r2 == null) goto L5;
        this.x.i(r2);
        return;
    }

    public void setSource(String r1) {
        this.D = r1;
    }

    public SheetDragView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SheetDragView(Context r7, AttributeSet r8, int r9) {
        super(r7, r8, r9);
        this.y = 0.0f;
        this.z = getContext().getResources().getDimensionPixelSize(2131168160);
        this.A = n.t() * 0.75f;
        d r10 = new d(getContext(), this, this.y, this.z, this.A);
        this.x = r10;
        r10.i(getTopBar());
        this.x.i(getDragHandler());
        this.x.h = this;
        getDragHandler().setOnClickListener(new qm5.c(this));
        this.B = new on5.a();
        this.C = true;
        this.E = "";
    }
}
