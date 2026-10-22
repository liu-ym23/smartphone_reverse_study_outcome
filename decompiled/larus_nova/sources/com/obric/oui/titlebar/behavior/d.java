package com.obric.oui.titlebar.behavior;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f403529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f403530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f403531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f403532d;

    public final void a() {
        View r100 = this.f403529a;
        ViewCompat.offsetTopAndBottom(r100, this.f403532d - (r100.getTop() - this.f403530b));
        View r101 = this.f403529a;
        ViewCompat.offsetLeftAndRight(r101, 0 - (r101.getLeft() - this.f403531c));
    }

    public d(View r100) {
        this.f403529a = r100;
    }
}
