package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class DmtStatusView extends FrameLayout implements f, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<View> f193287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f193288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f193289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f193290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f193291e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f193292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f193293b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public View f193294c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View f193295d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f193296e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f193297f;

        public a(Context r100) {
            this.f193297f = -1;
            if (r100 == null) goto L7;
            this.f193292a = r100;
            return;
        L7:
            throw new IllegalArgumentException("DmtStatusView.Builder:Context can not be null");
        }

        public static a a(Context r100) {
            a r101 = new a(r100);
            DmtLoadingLayout r102 = new DmtLoadingLayout(r100);
            r102.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            r101.f193293b = r102;
            r102.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return r101;
        }

        public final void b(View r100) {
            this.f193294c = r100;
            r100.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }

        public final void c(View.OnClickListener r100) {
            Context r101 = this.f193292a;
            com.bytedance.awemeopen.apps.framework.base.view.refresh.a r102 = new com.bytedance.awemeopen.apps.framework.base.view.refresh.a();
            r102.f193418b = r101.getApplicationContext().getString(R.string.aos_load_status_click_retry);
            r102.f193424h = true;
            DmtDefaultView r103 = new DmtDefaultView(this.f193292a);
            r103.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            r103.setStatus(r102);
            this.f193295d = r103;
            r103.setOnClickListener(r100);
        }

        public final void d(View r100) {
            this.f193295d = r100;
            r100.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void d() {
        setVisibility(0);
        setStatus(2);
    }

    public final void e() {
        setVisibility(0);
        setStatus(0);
        List<View> r100 = this.f193287a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (((ArrayList) r100).size() == 0) goto L13;
        View r101 = (View) ListProtector.get(this.f193287a, 0);
        if ((r101 instanceof DmtLoadingLayout) == false) goto L12;
        ((DmtLoadingLayout) r101).setWeakInfoShow(false);
        return;
    L12:
        return;
    }

    public final void c() {
        int r100 = this.f193288b;
        if (r100 != (-1)) goto L5;
        return;
    L5:
        View r101 = b(r100);
        if (r101 == null) goto L8;
        r101.setVisibility(8);
    L8:
        setVisibility(8);
        this.f193288b = -1;
    }

    public View getStatusView() {
        int r100 = this.f193288b;
        if (r100 >= 0) goto L5;
        return null;
    L5:
        if (r100 < ((ArrayList) this.f193287a).size()) goto L8;
        return null;
    L8:
        return (View) ListProtector.get(this.f193287a, this.f193288b);
    }

    public Boolean getForceDarkTheme() {
        return this.f193290d;
    }

    public Boolean getForceLightTheme() {
        return this.f193291e;
    }

    public DmtStatusView(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.f
    public final void a(int r100) {
        f(r100);
    }

    public final View b(int r100) {
        if (r100 >= 0) goto L4;
        return null;
    L4:
        if (r100 < ((ArrayList) this.f193287a).size()) goto L7;
        return null;
    L7:
        return (View) ListProtector.get(this.f193287a, r100);
    }

    public final void f(int r100) {
        if (r100 >= 0) goto L5;
        return;
    L5:
        if (this.f193289c == r100) goto L22;
        this.f193289c = r100;
        View r101 = (View) ListProtector.get(this.f193287a, 0);
        if ((r101 instanceof DmtLoadingLayout) == false) goto L9;
        ((DmtLoadingLayout) r101).a(this.f193289c);
    L9:
        KeyEvent.Callback r102 = (View) ListProtector.get(this.f193287a, 1);
        if ((r102 instanceof f) == false) goto L12;
        ((f) r102).a(this.f193289c);
    L12:
        View r103 = (View) ListProtector.get(this.f193287a, 2);
        if ((r103 instanceof DmtDefaultView) == false) goto L15;
        ((DmtDefaultView) r103).a(this.f193289c);
    L15:
        View r104 = (View) ListProtector.get(this.f193287a, 3);
        if ((r104 instanceof DmtDefaultView) == false) goto L18;
        ((DmtDefaultView) r104).a(this.f193289c);
    L18:
        View r105 = (View) ListProtector.get(this.f193287a, 4);
        if ((r105 instanceof DmtDefaultView) == false) goto L23;
        ((DmtDefaultView) r105).a(this.f193289c);
        return;
    L23:
        return;
    }

    public void setBuilder(a r100) {
        if (r100 != null) goto L4;
        r100 = a.a(getContext());
    L4:
        ((ArrayList) this.f193287a).clear();
        List<View> r101 = this.f193287a;
        ArrayList r102 = (ArrayList) r101;
        r102.add(r100.f193293b);
        List<View> r103 = this.f193287a;
        ArrayList r104 = (ArrayList) r103;
        r104.add(r100.f193294c);
        List<View> r105 = this.f193287a;
        ArrayList r106 = (ArrayList) r105;
        r106.add(r100.f193295d);
        List<View> r107 = this.f193287a;
        ArrayList r108 = (ArrayList) r107;
        r108.add(r100.f193296e);
        ((ArrayList) this.f193287a).add(null);
        if (r100.f193297f >= 0) goto L7;
        r100.f193297f = 1;
    L7:
        f(r100.f193297f);
        removeAllViews();
        int r109 = 0;
    L9:
        if (r109 >= ((ArrayList) this.f193287a).size()) goto L15;
        View r110 = (View) ListProtector.get(this.f193287a, r109);
        if (r110 == null) goto L14;
        r110.setVisibility(8);
        addView(r110);
    L14:
        r109 = r109 + 1;
        goto L9
    }

    public void setForceDarkTheme(Boolean r100) {
        this.f193290d = r100;
        if (r100.booleanValue() == false) goto L10;
        this.f193291e = Boolean.FALSE;
        Iterator r101 = ((ArrayList) this.f193287a).iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        View r102 = (View) r101.next();
        if ((r102 instanceof DmtDefaultView) == false) goto L6;
        ((DmtDefaultView) r102).d(this.f193290d);
        goto L6
    L16:
        return;
    }

    public void setForceLightTheme(Boolean r100) {
        this.f193291e = r100;
        if (r100.booleanValue() == false) goto L10;
        this.f193290d = Boolean.FALSE;
        Iterator r101 = ((ArrayList) this.f193287a).iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        View r102 = (View) r101.next();
        if ((r102 instanceof DmtDefaultView) == false) goto L6;
        ((DmtDefaultView) r102).e(this.f193291e);
        goto L6
    L16:
        return;
    }

    public void setStatus(int r100) {
        int r101 = this.f193288b;
        if (r101 != r100) goto L6;
        return;
    L6:
        if (r101 < 0) goto L10;
        View r102 = b(r101);
        if (r102 == null) goto L10;
        r102.setVisibility(8);
    L10:
        if (r100 < 0) goto L14;
        setVisibility(0);
        View r103 = b(r100);
        if (r103 == null) goto L15;
        r103.setVisibility(0);
    L15:
        this.f193288b = r100;
        return;
    L14:
        setVisibility(8);
        goto L15
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.h
    public void setUseScreenHeight(int r100) {
        KeyEvent.Callback r101 = (View) ListProtector.get(this.f193287a, 0);
        if ((r101 instanceof h) == false) goto L5;
        ((h) r101).setUseScreenHeight(r100);
    L5:
        KeyEvent.Callback r102 = (View) ListProtector.get(this.f193287a, 1);
        if ((r102 instanceof h) == false) goto L8;
        ((h) r102).setUseScreenHeight(r100);
    L8:
        KeyEvent.Callback r103 = (View) ListProtector.get(this.f193287a, 2);
        if ((r103 instanceof h) == false) goto L11;
        ((h) r103).setUseScreenHeight(r100);
    L11:
        KeyEvent.Callback r104 = (View) ListProtector.get(this.f193287a, 3);
        if ((r104 instanceof h) == false) goto L14;
        ((h) r104).setUseScreenHeight(r100);
    L14:
        KeyEvent.Callback r105 = (View) ListProtector.get(this.f193287a, 4);
        if ((r105 instanceof h) == false) goto L18;
        ((h) r105).setUseScreenHeight(r100);
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
    }

    public DmtStatusView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public DmtStatusView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f193287a = new ArrayList(5);
        this.f193288b = -1;
        this.f193289c = -1;
        Boolean r103 = Boolean.FALSE;
        this.f193290d = r103;
        this.f193291e = r103;
    }
}
