package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class DmtStatusView extends FrameLayout implements f, h {
    public final List<View> a;
    public int b;
    public int c;
    public Boolean d;
    public Boolean e;

    public static class a {
        public final Context a;
        public View b;
        public View c;
        public View d;
        public View e;
        public int f;

        public a(Context r2) {
            this.f = -1;
            if (r2 == null) goto L7;
            this.a = r2;
            return;
        L7:
            throw new IllegalArgumentException("DmtStatusView.Builder:Context can not be null");
        }

        public static a a(Context r3) {
            a r0 = new a(r3);
            DmtLoadingLayout r1 = new DmtLoadingLayout(r3);
            r1.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            r0.b = r1;
            r1.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return r0;
        }

        public final void b(View r3) {
            this.c = r3;
            r3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }

        public final void c(View.OnClickListener r5) {
            Context r0 = this.a;
            com.bytedance.awemeopen.apps.framework.base.view.refresh.a r1 = new com.bytedance.awemeopen.apps.framework.base.view.refresh.a();
            r1.b = r0.getApplicationContext().getString(2131894221);
            r1.h = true;
            DmtDefaultView r2 = new DmtDefaultView(this.a);
            r2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            r2.setStatus(r1);
            this.d = r2;
            r2.setOnClickListener(r5);
        }

        public final void d(View r3) {
            this.d = r3;
            r3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void d() {
        setVisibility(0);
        setStatus(2);
    }

    public final void e() {
        setVisibility(0);
        setStatus(0);
        List<View> r1 = this.a;
        if (r1 != null) goto L5;
        return;
    L5:
        if (((ArrayList) r1).size() == 0) goto L13;
        View r2 = (View) ListProtector.get(this.a, 0);
        if ((r2 instanceof DmtLoadingLayout) == false) goto L12;
        ((DmtLoadingLayout) r2).setWeakInfoShow(false);
        return;
    L12:
        return;
    }

    public final void c() {
        int r0 = this.b;
        if (r0 != (-1)) goto L5;
        return;
    L5:
        View r1 = b(r0);
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        setVisibility(8);
        this.b = -1;
    }

    public View getStatusView() {
        int r0 = this.b;
        if (r0 >= 0) goto L5;
        return null;
    L5:
        if (r0 < ((ArrayList) this.a).size()) goto L8;
        return null;
    L8:
        return (View) ListProtector.get(this.a, this.b);
    }

    public Boolean getForceDarkTheme() {
        return this.d;
    }

    public Boolean getForceLightTheme() {
        return this.e;
    }

    public DmtStatusView(Context r2) {
        this(r2, null);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.f
    public final void a(int r1) {
        f(r1);
    }

    public final View b(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < ((ArrayList) this.a).size()) goto L7;
        return null;
    L7:
        return (View) ListProtector.get(this.a, r2);
    }

    public final void f(int r2) {
        if (r2 >= 0) goto L5;
        return;
    L5:
        if (this.c == r2) goto L22;
        this.c = r2;
        View r3 = (View) ListProtector.get(this.a, 0);
        if ((r3 instanceof DmtLoadingLayout) == false) goto L9;
        ((DmtLoadingLayout) r3).a(this.c);
    L9:
        KeyEvent.Callback r4 = (View) ListProtector.get(this.a, 1);
        if ((r4 instanceof f) == false) goto L12;
        ((f) r4).a(this.c);
    L12:
        View r5 = (View) ListProtector.get(this.a, 2);
        if ((r5 instanceof DmtDefaultView) == false) goto L15;
        ((DmtDefaultView) r5).a(this.c);
    L15:
        View r6 = (View) ListProtector.get(this.a, 3);
        if ((r6 instanceof DmtDefaultView) == false) goto L18;
        ((DmtDefaultView) r6).a(this.c);
    L18:
        View r7 = (View) ListProtector.get(this.a, 4);
        if ((r7 instanceof DmtDefaultView) == false) goto L23;
        ((DmtDefaultView) r7).a(this.c);
        return;
    L23:
        return;
    }

    public void setBuilder(a r3) {
        if (r3 != null) goto L4;
        r3 = a.a(getContext());
    L4:
        ((ArrayList) this.a).clear();
        List<View> r0 = this.a;
        ArrayList r1 = (ArrayList) r0;
        r1.add(r3.b);
        List<View> r2 = this.a;
        ArrayList r4 = (ArrayList) r2;
        r4.add(r3.c);
        List<View> r5 = this.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(r3.d);
        List<View> r7 = this.a;
        ArrayList r8 = (ArrayList) r7;
        r8.add(r3.e);
        ((ArrayList) this.a).add(null);
        if (r3.f >= 0) goto L7;
        r3.f = 1;
    L7:
        f(r3.f);
        removeAllViews();
        int r9 = 0;
    L9:
        if (r9 >= ((ArrayList) this.a).size()) goto L15;
        View r10 = (View) ListProtector.get(this.a, r9);
        if (r10 == null) goto L14;
        r10.setVisibility(8);
        addView(r10);
    L14:
        r9 = r9 + 1;
        goto L9
    }

    public void setForceDarkTheme(Boolean r3) {
        this.d = r3;
        if (r3.booleanValue() == false) goto L10;
        this.e = Boolean.FALSE;
        Iterator r4 = ((ArrayList) this.a).iterator();
    L6:
        if (r4.hasNext() == false) goto L16;
        View r0 = (View) r4.next();
        if ((r0 instanceof DmtDefaultView) == false) goto L6;
        ((DmtDefaultView) r0).d(this.d);
        goto L6
    L16:
        return;
    }

    public void setForceLightTheme(Boolean r3) {
        this.e = r3;
        if (r3.booleanValue() == false) goto L10;
        this.d = Boolean.FALSE;
        Iterator r4 = ((ArrayList) this.a).iterator();
    L6:
        if (r4.hasNext() == false) goto L16;
        View r0 = (View) r4.next();
        if ((r0 instanceof DmtDefaultView) == false) goto L6;
        ((DmtDefaultView) r0).e(this.e);
        goto L6
    L16:
        return;
    }

    public void setStatus(int r3) {
        int r0 = this.b;
        if (r0 != r3) goto L6;
        return;
    L6:
        if (r0 < 0) goto L10;
        View r1 = b(r0);
        if (r1 == null) goto L10;
        r1.setVisibility(8);
    L10:
        if (r3 < 0) goto L14;
        setVisibility(0);
        View r2 = b(r3);
        if (r2 == null) goto L15;
        r2.setVisibility(0);
    L15:
        this.b = r3;
        return;
    L14:
        setVisibility(8);
        goto L15
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.h
    public void setUseScreenHeight(int r3) {
        KeyEvent.Callback r0 = (View) ListProtector.get(this.a, 0);
        if ((r0 instanceof h) == false) goto L5;
        ((h) r0).setUseScreenHeight(r3);
    L5:
        KeyEvent.Callback r1 = (View) ListProtector.get(this.a, 1);
        if ((r1 instanceof h) == false) goto L8;
        ((h) r1).setUseScreenHeight(r3);
    L8:
        KeyEvent.Callback r2 = (View) ListProtector.get(this.a, 2);
        if ((r2 instanceof h) == false) goto L11;
        ((h) r2).setUseScreenHeight(r3);
    L11:
        KeyEvent.Callback r4 = (View) ListProtector.get(this.a, 3);
        if ((r4 instanceof h) == false) goto L14;
        ((h) r4).setUseScreenHeight(r3);
    L14:
        KeyEvent.Callback r5 = (View) ListProtector.get(this.a, 4);
        if ((r5 instanceof h) == false) goto L18;
        ((h) r5).setUseScreenHeight(r3);
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r1) {
        super.setVisibility(r1);
    }

    public DmtStatusView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public DmtStatusView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new ArrayList(5);
        this.b = -1;
        this.c = -1;
        Boolean r4 = Boolean.FALSE;
        this.d = r4;
        this.e = r4;
    }
}
