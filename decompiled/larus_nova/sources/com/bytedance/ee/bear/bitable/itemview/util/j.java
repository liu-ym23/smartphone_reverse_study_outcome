package com.bytedance.ee.bear.bitable.itemview.util;

import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes15.dex */
public final class j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f214288e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<View> f214289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<View> f214290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f214291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f214292d;

    public static final class a {
    }

    static {
    }

    public j() {
    }

    public final void a(boolean r100) {
        if (r100 == false) goto L20;
        WeakReference<View> r101 = this.f214290b;
        if (r101 == null) goto L8;
        View r102 = r101.get();
        if (r102 == null) goto L8;
        r102.setSelected(false);
    L8:
        WeakReference<View> r103 = this.f214290b;
        if (r103 == null) goto L13;
        View r104 = r103.get();
        if (r104 == null) goto L13;
        r104.setActivated(false);
    L13:
        WeakReference<View> r105 = this.f214289a;
        if (r105 == null) goto L20;
        View r106 = r105.get();
        if (r106 == null) goto L20;
        Drawable r107 = r106.getBackground();
        if (r107 == null) goto L20;
        r107.setAlpha(255);
    L20:
        this.f214289a = null;
        this.f214290b = null;
        this.f214291c = null;
        this.f214292d = null;
    }
}
