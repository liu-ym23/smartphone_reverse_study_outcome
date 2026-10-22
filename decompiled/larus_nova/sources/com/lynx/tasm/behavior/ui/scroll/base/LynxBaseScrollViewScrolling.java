package com.lynx.tasm.behavior.ui.scroll.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.lynx.tasm.behavior.ui.scroll.LynxUIScrollViewInternal;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public class LynxBaseScrollViewScrolling extends FrameLayout implements h7a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f382967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f382968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f382969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f382970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f382971e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f382972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f382973g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f382974h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f382975i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d.c f382976j;

    public interface a {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.a
    public int[] getScrollOffset() {
        return new int[]{getScrollX(), getScrollY()};
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.b
    public int[] getScrollRangeHorizontally() {
        return new int[]{0, Math.max(0, this.f382973g[0] - this.f382970d)};
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.g
    public int[] getScrollRangeVertically() {
        return new int[]{0, Math.max(0, this.f382973g[1] - this.f382971e)};
    }

    public final void j() {
        d.c r100 = this.f382976j;
        if (r100 == null) goto L8;
        if (r100 == null) goto L6;
        r100.a(true);
    L6:
        this.f382976j = null;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.b
    public int getScrollOffsetHorizontally() {
        return getScrollX();
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.g
    public int getScrollOffsetVertically() {
        return getScrollY();
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.a
    public int[] getScrollRange() {
        int[] r100 = getScrollRangeHorizontally();
        int[] r101 = getScrollRangeVertically();
        return new int[]{r100[0], r100[1], r101[0], r101[1]};
    }

    @Override // h7a.c
    public final boolean d() {
        return this.f382968b;
    }

    public final void e(int[] r100) {
        if (this.f382969c == false) goto L5;
        int r101 = r100[1];
        int[] r102 = getScrollRangeVertically();
        int r103 = Math.min(Math.max(r101, r102[0]), r102[1]);
        this.f382967a.a(getScrollX(), r103, new f((LynxBaseScrollView) this));
        i(2);
        j();
        return;
    L5:
        int r104 = r100[0];
        int[] r105 = getScrollRangeHorizontally();
        int r106 = Math.min(Math.max(r104, r105[0]), r105[1]);
        this.f382967a.a(r106, getScrollY(), new e((LynxBaseScrollView) this));
        i(2);
        j();
    }

    public final void f(int[] r100) {
        if (this.f382969c == false) goto L5;
        int r101 = r100[1];
        int[] r102 = getScrollRangeVertically();
        h(Math.min(Math.max(r101, r102[0]), r102[1]));
        return;
    L5:
        int r103 = r100[0];
        int[] r104 = getScrollRangeHorizontally();
        g(Math.min(Math.max(r103, r104[0]), r104[1]));
    }

    public final void g(int r100) {
        scrollTo(r100, getScrollY());
    }

    public final void h(int r100) {
        scrollTo(getScrollX(), r100);
    }

    public final void i(int r100) {
        int r101 = this.f382974h;
        if (r101 == r100) goto L17;
        this.f382974h = r100;
        a r102 = this.f382975i;
        if (r102 == null) goto L17;
        LynxUIScrollViewInternal r103 = (LynxUIScrollViewInternal) r102;
        if (r100 != 0) goto L9;
        r103.P("scrollend", null);
    L16:
        HashMap<String, Object> r104 = new HashMap();
        r104.put("previousState", Integer.valueOf(r101));
        r104.put("currentState", Integer.valueOf(r100));
        r103.P("scrollstatechange", r104);
        goto L17
    L9:
        if (r100 == 1) goto L14;
        if (r100 != 2) goto L16;
        if (r101 != 0) goto L16;
        r103.P("scrollstart", null);
        goto L16
    L14:
        r103.P("scrollstart", null);
    L17:
        if (r100 == 2) goto L20;
        j();
        return;
    }

    public void setScrollContentSize(int[] r100) {
        if (this.f382969c == false) goto L5;
        setScrollContentSizeVertically(r100[1]);
        return;
    L5:
        setScrollContentSizeHorizontally(r100[0]);
    }

    public void setScrollContentSizeHorizontally(int r100) {
        int[] r101 = this.f382973g;
        r101[0] = r100;
        r101[1] = this.f382971e;
    }

    public void setScrollContentSizeVertically(int r100) {
        int[] r101 = this.f382973g;
        r101[0] = this.f382970d;
        r101[1] = r100;
    }

    public void setScrollDelegate(a r100) {
        this.f382975i = r100;
    }

    public LynxBaseScrollViewScrolling(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f382968b = true;
        this.f382969c = true;
        this.f382970d = 0;
        this.f382971e = 0;
        this.f382972f = true;
        this.f382973g = new int[2];
        this.f382974h = 0;
        this.f382967a = new d(r100);
    }
}
