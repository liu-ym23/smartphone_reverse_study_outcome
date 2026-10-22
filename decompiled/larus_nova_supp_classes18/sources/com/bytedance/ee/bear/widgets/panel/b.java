package com.bytedance.ee.bear.widgets.panel;

import android.view.MotionEvent;
import com.bytedance.ee.bear.facade.common.widget.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements InterceptTouchRecyclerView.a {
    public int a;
    public final /* synthetic */ CommonActionPanelLayout b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ InterceptTouchRecyclerView e;

    public b(CommonActionPanelLayout r1, InterceptTouchRecyclerView r2) {
        this.b = r1;
        this.c = true;
        this.d = true;
        this.e = r2;
    }

    @Override // com.bytedance.ee.bear.widgets.panel.InterceptTouchRecyclerView.a
    public final boolean a(MotionEvent r6, float r7, float r8) {
        boolean r0 = true;
        if (r6 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L11;
        this.a = this.b.getHeight();
        return false;
    L11:
        if (r6 != null) goto L13;
    L15:
        boolean r3 = false;
    L17:
        if (r3 == true) goto L55;
        if (r6 != null) goto L20;
    L22:
        boolean r9 = false;
    L23:
        if (r9 == true) goto L55;
        if (r7 <= 0.0f) goto L44;
        if (this.c == false) goto L44;
        d r10 = this.b.c;
        if (r10 != null) goto L32;
    L37:
        boolean r11 = false;
    L38:
        if (r11 == true) goto L44;
        d r12 = this.b.c;
        if (r12 == null) goto L42;
        r12.l(this.a + r7);
    L42:
        return true;
    L32:
        if (r10.b() < ((int) r10.c[2])) goto L34;
        boolean r13 = true;
    L35:
        if (r13 != true) goto L37;
        r11 = true;
        goto L38
    L34:
        r13 = false;
    L44:
        if (r7 < 0.0f) goto L46;
    L53:
        return false;
    L46:
        if (this.d == false) goto L53;
        if ((!this.e.canScrollVertically(-1)) == false) goto L53;
        CommonActionPanelLayout r14 = this.b;
        d r15 = r14.c;
        if (r15 == null) goto L52;
        r15.l(r14.getHeight() + r8);
    L52:
        return true;
    L20:
        if (r6.getAction() != 1) goto L22;
        r9 = true;
    L55:
        if (Math.abs(r7) <= 100) goto L63;
        d r16 = this.b.c;
        if (r16 != null) goto L59;
    L66:
        return false;
    L59:
        if (r7 < 0.0f) goto L62;
        r0 = false;
    L62:
        r16.g(r0);
        goto L66
    L63:
        d r17 = this.b.c;
        if (r17 == null) goto L66;
        r17.k(this.a);
        goto L66
    L13:
        if (r6.getAction() != 3) goto L15;
        r3 = true;
        goto L17
    L5:
        if (r6.getAction() != 0) goto L7;
        r2 = true;
        goto L8
    }
}
