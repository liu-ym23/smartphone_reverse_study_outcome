package com.bytedance.ies.dmt.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public class DmtStatusView extends FrameLayout implements e46.b, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<View> f248430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f248431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f248432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f248433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f248434e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f248435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f248436b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public View f248437c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View f248438d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f248439e;

        public a(Context r100) {
            this.f248439e = -1;
            if (r100 == null) goto L7;
            this.f248435a = r100;
            return;
        L7:
            throw new IllegalArgumentException("DmtStatusView.Builder:Context can not be null");
        }

        public static a a(Context r100) {
            a r101 = new a(r100);
            DmtLoadingLayout r102 = new DmtLoadingLayout(r100);
            r102.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            r101.f(r102);
            return r101;
        }

        public final void b(View r100) {
            this.f248437c = r100;
            r100.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }

        public final void c(b r100) {
            DmtDefaultView r101 = new DmtDefaultView(this.f248435a);
            r101.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            r101.setStatus(r100);
            this.f248437c = r101;
        }

        public final void d(View r100) {
            this.f248438d = r100;
            r100.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }

        public final void e(b r100) {
            DmtDefaultView r101 = new DmtDefaultView(this.f248435a);
            r101.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            r101.setStatus(r100);
            this.f248438d = r101;
        }

        public final void f(View r100) {
            this.f248436b = r100;
            r100.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void e() {
        setVisibility(0);
        setStatus(1);
    }

    public final void f() {
        setVisibility(0);
        setStatus(2);
    }

    public final void g() {
        setVisibility(0);
        setStatus(0);
        List<View> r100 = this.f248430a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (((ArrayList) r100).size() == 0) goto L13;
        View r101 = (View) ListProtector.get(this.f248430a, 0);
        if ((r101 instanceof DmtLoadingLayout) == false) goto L12;
        ((DmtLoadingLayout) r101).setWeakInfoShow(false);
        return;
    L12:
        return;
    }

    public final void c() {
        int r100 = this.f248431b;
        if (r100 != (-1)) goto L5;
        return;
    L5:
        View r101 = b(r100);
        if (r101 == null) goto L8;
        r101.setVisibility(4);
    L8:
        setVisibility(4);
        this.f248431b = -1;
    }

    public final void d() {
        List<View> r100 = this.f248430a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (((ArrayList) r100).size() == 0) goto L19;
        View r101 = (View) ListProtector.get(this.f248430a, 0);
        if ((r101 instanceof DmtLoadingLayout) == false) goto L18;
        DmtLoadingLayout r102 = (DmtLoadingLayout) r101;
        if (this.f248431b == 0) goto L12;
    L12:
        TextView r103 = r102.f248427d;
        if (r103 == null) goto L20;
        r103.setVisibility(8);
        return;
    L20:
        return;
    L18:
        return;
    }

    public Boolean getForceDarkTheme() {
        return this.f248433d;
    }

    public Boolean getForceLightTheme() {
        return this.f248434e;
    }

    public DmtStatusView(Context r100) {
        this(r100, null);
    }

    @Override // e46.b
    public final void a(int r100) {
        h(r100);
    }

    public final View b(int r100) {
        if (r100 >= 0) goto L4;
        return null;
    L4:
        if (r100 < ((ArrayList) this.f248430a).size()) goto L7;
        return null;
    L7:
        return (View) ListProtector.get(this.f248430a, r100);
    }

    public final void h(int r100) {
        if (r100 < 0) goto L24;
        List<View> r101 = this.f248430a;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f248432c == r100) goto L25;
        this.f248432c = r100;
        View r102 = (View) ListProtector.get(r101, 0);
        if ((r102 instanceof DmtLoadingLayout) == false) goto L11;
        ((DmtLoadingLayout) r102).a(this.f248432c);
    L11:
        KeyEvent.Callback r103 = (View) ListProtector.get(this.f248430a, 1);
        if ((r103 instanceof e46.b) == false) goto L14;
        ((e46.b) r103).a(this.f248432c);
    L14:
        View r104 = (View) ListProtector.get(this.f248430a, 2);
        if ((r104 instanceof DmtDefaultView) == false) goto L17;
        ((DmtDefaultView) r104).a(this.f248432c);
    L17:
        View r105 = (View) ListProtector.get(this.f248430a, 3);
        if ((r105 instanceof DmtDefaultView) == false) goto L20;
        ((DmtDefaultView) r105).a(this.f248432c);
    L20:
        View r106 = (View) ListProtector.get(this.f248430a, 4);
        if ((r106 instanceof DmtDefaultView) == false) goto L26;
        ((DmtDefaultView) r106).a(this.f248432c);
        return;
    L26:
        return;
    L25:
        return;
    }

    public void setBuilder(a r100) {
        if (r100 != null) goto L4;
        r100 = a.a(getContext());
    L4:
        ((ArrayList) this.f248430a).clear();
        List<View> r101 = this.f248430a;
        ArrayList r102 = (ArrayList) r101;
        r102.add(r100.f248436b);
        List<View> r103 = this.f248430a;
        ArrayList r104 = (ArrayList) r103;
        r104.add(r100.f248437c);
        List<View> r105 = this.f248430a;
        ArrayList r106 = (ArrayList) r105;
        r106.add(r100.f248438d);
        ((ArrayList) this.f248430a).add(null);
        ((ArrayList) this.f248430a).add(null);
        if (r100.f248439e >= 0) goto L7;
        int r107 = e46.a.f470987a;
        r100.f248439e = 1;
    L7:
        h(r100.f248439e);
        removeAllViews();
        int r108 = 0;
    L9:
        if (r108 >= ((ArrayList) this.f248430a).size()) goto L15;
        View r109 = (View) ListProtector.get(this.f248430a, r108);
        if (r109 == null) goto L14;
        r109.setVisibility(4);
        addView(r109);
    L14:
        r108 = r108 + 1;
        goto L9
    }

    public void setForceDarkTheme(Boolean r100) {
        this.f248433d = r100;
        if (r100.booleanValue() == false) goto L10;
        this.f248434e = Boolean.FALSE;
        Iterator r101 = ((ArrayList) this.f248430a).iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        View r102 = (View) r101.next();
        if ((r102 instanceof DmtDefaultView) == false) goto L6;
        ((DmtDefaultView) r102).d(this.f248433d);
        goto L6
    L16:
        return;
    }

    public void setForceLightTheme(Boolean r100) {
        this.f248434e = r100;
        if (r100.booleanValue() == false) goto L10;
        this.f248433d = Boolean.FALSE;
        Iterator r101 = ((ArrayList) this.f248430a).iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        View r102 = (View) r101.next();
        if ((r102 instanceof DmtDefaultView) == false) goto L6;
        ((DmtDefaultView) r102).e(this.f248434e);
        goto L6
    L16:
        return;
    }

    public void setStartAnimationAfterAttach(boolean r100) {
        List<View> r101 = this.f248430a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (((ArrayList) r101).size() == 0) goto L13;
        View r102 = (View) ListProtector.get(this.f248430a, 0);
        if ((r102 instanceof DmtLoadingLayout) == false) goto L12;
        ((DmtLoadingLayout) r102).setStartAnimationAfterAttach(r100);
        return;
    L12:
        return;
    }

    public void setStatus(int r100) {
        int r101 = this.f248431b;
        if (r101 != r100) goto L6;
        return;
    L6:
        if (r101 < 0) goto L10;
        View r102 = b(r101);
        if (r102 == null) goto L10;
        r102.setVisibility(4);
    L10:
        if (r100 < 0) goto L14;
        setVisibility(0);
        View r103 = b(r100);
        if (r103 == null) goto L15;
        r103.setVisibility(0);
    L15:
        this.f248431b = r100;
        return;
    L14:
        setVisibility(4);
        goto L15
    }

    @Override // com.bytedance.ies.dmt.ui.widget.d
    public void setUseScreenHeight(int r100) {
        KeyEvent.Callback r101 = (View) ListProtector.get(this.f248430a, 0);
        if ((r101 instanceof d) == false) goto L5;
        ((d) r101).setUseScreenHeight(r100);
    L5:
        KeyEvent.Callback r102 = (View) ListProtector.get(this.f248430a, 1);
        if ((r102 instanceof d) == false) goto L8;
        ((d) r102).setUseScreenHeight(r100);
    L8:
        KeyEvent.Callback r103 = (View) ListProtector.get(this.f248430a, 2);
        if ((r103 instanceof d) == false) goto L11;
        ((d) r103).setUseScreenHeight(r100);
    L11:
        KeyEvent.Callback r104 = (View) ListProtector.get(this.f248430a, 3);
        if ((r104 instanceof d) == false) goto L14;
        ((d) r104).setUseScreenHeight(r100);
    L14:
        KeyEvent.Callback r105 = (View) ListProtector.get(this.f248430a, 4);
        if ((r105 instanceof d) == false) goto L18;
        ((d) r105).setUseScreenHeight(r100);
        return;
    }

    public DmtStatusView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public DmtStatusView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f248430a = new ArrayList(5);
        this.f248431b = -1;
        this.f248432c = -1;
        Boolean r103 = Boolean.FALSE;
        this.f248433d = r103;
        this.f248434e = r103;
    }
}
