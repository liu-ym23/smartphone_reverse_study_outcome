package com.larus.voicecall.impl.continue_talk;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes32.dex */
public final class h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f378153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f378154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Activity f378155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d19.g f378156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f378157e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f378158f;

    public static final class a {
    }

    static {
    }

    public h2() {
    }

    public final void a() {
        if (this.f378153a == true) goto L6;
        FLogger.f375446a.i("ScreenEdgeEffectManager", "[removeSpecificOverlayView]: view is not added");
        return;
    L6:
        Object r100 = this.f378156d;
        if ((r100 instanceof View) == false) goto L9;
        View r101 = (View) r100;
    L10:
        if (r101 != null) goto L13;
        FLogger.f375446a.i("ScreenEdgeEffectManager", "[removeSpecificOverlayView]: view is null");
        return;
    L13:
        this.f378153a = false;
        ViewGroup r102 = this.f378154b;
        if (r102 == null) goto L16;
        r102.removeView(r101);
    L16:
        this.f378154b = null;
        FLogger.f375446a.i("ScreenEdgeEffectManager", "[removeSpecificOverlayView]: view is removed");
        return;
    L9:
        r101 = null;
        goto L10
    }

    public final void b() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("[visibleScreenEdgeEffect]: visible screen edge effect, screenEdgeEffectView is null(");
        if (this.f378156d != null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        r101.append(')');
        r100.i("ScreenEdgeEffectManager", r101.toString());
        d19.g r103 = this.f378156d;
        if (r103 == null) goto L9;
        r103.d();
    L9:
        Object r104 = this.f378156d;
        if ((r104 instanceof View) == false) goto L12;
        View r105 = (View) r104;
    L13:
        if (r105 == null) goto L16;
        com.larus.utils.e1.x(r105);
        return;
    L16:
        return;
    L12:
        r105 = null;
        goto L13
    L5:
        r102 = false;
        goto L6
    }
}
