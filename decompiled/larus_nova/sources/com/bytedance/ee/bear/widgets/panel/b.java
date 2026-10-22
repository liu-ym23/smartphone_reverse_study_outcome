package com.bytedance.ee.bear.widgets.panel;

import android.view.MotionEvent;
import com.bytedance.ee.bear.facade.common.widget.d;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements InterceptTouchRecyclerView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f240304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CommonActionPanelLayout f240305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f240306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f240307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ InterceptTouchRecyclerView f240308e;

    public b(CommonActionPanelLayout r100, InterceptTouchRecyclerView r101) {
        this.f240305b = r100;
        this.f240306c = true;
        this.f240307d = true;
        this.f240308e = r101;
    }

    @Override // com.bytedance.ee.bear.widgets.panel.InterceptTouchRecyclerView.a
    public final boolean a(MotionEvent r100, float r101, float r102) {
        boolean r103 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L11;
        this.f240304a = this.f240305b.getHeight();
        return false;
    L11:
        if (r100 != null) goto L13;
    L15:
        boolean r105 = false;
    L17:
        if (r105 == true) goto L55;
        if (r100 != null) goto L20;
    L22:
        boolean r106 = false;
    L23:
        if (r106 == true) goto L55;
        if (r101 <= 0.0f) goto L44;
        if (this.f240306c == false) goto L44;
        d r107 = this.f240305b.f240267c;
        if (r107 != null) goto L32;
    L37:
        boolean r108 = false;
    L38:
        if (r108 == true) goto L44;
        d r109 = this.f240305b.f240267c;
        if (r109 == null) goto L42;
        r109.l(this.f240304a + r101);
    L42:
        return true;
    L32:
        if (r107.b() < ((int) r107.f226588c[2])) goto L34;
        boolean r110 = true;
    L35:
        if (r110 != true) goto L37;
        r108 = true;
        goto L38
    L34:
        r110 = false;
    L44:
        if (r101 < 0.0f) goto L46;
    L53:
        return false;
    L46:
        if (this.f240307d == false) goto L53;
        if ((!this.f240308e.canScrollVertically(-1)) == false) goto L53;
        CommonActionPanelLayout r111 = this.f240305b;
        d r112 = r111.f240267c;
        if (r112 == null) goto L52;
        r112.l(r111.getHeight() + r102);
    L52:
        return true;
    L20:
        if (r100.getAction() != 1) goto L22;
        r106 = true;
    L55:
        if (Math.abs(r101) <= 100) goto L63;
        d r113 = this.f240305b.f240267c;
        if (r113 != null) goto L59;
    L66:
        return false;
    L59:
        if (r101 < 0.0f) goto L62;
        r103 = false;
    L62:
        r113.g(r103);
        goto L66
    L63:
        d r114 = this.f240305b.f240267c;
        if (r114 == null) goto L66;
        r114.k(this.f240304a);
        goto L66
    L13:
        if (r100.getAction() != 3) goto L15;
        r105 = true;
        goto L17
    L5:
        if (r100.getAction() != 0) goto L7;
        r104 = true;
        goto L8
    }
}
