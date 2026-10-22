package com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.util.ui.k;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float[] f226329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f226330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f226331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f226332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f226333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f226334f;

    public interface a {
        void a(int r100);
    }

    public final void a(float r100) {
        if (r100 >= 0.0f) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r101 = this.f226330b.getLayoutParams();
        if (r101 == null) goto L23;
        Context r102 = this.f226330b.getContext();
        if ((r102 instanceof Activity) == false) goto L10;
        boolean r103 = n.D((Activity) r102);
    L11:
        if (r103 == true) goto L13;
    L15:
        int r104 = (int) r100;
        if (r104 != r101.height) goto L18;
        return;
    L18:
        r101.height = r104;
    L19:
        this.f226330b.setLayoutParams(r101);
        int r105 = (int) r100;
        a r106 = this.f226333e;
        if (r106 == null) goto L24;
        r106.a(r105);
        return;
    L24:
        return;
    L13:
        if (k.f(r102) == false) goto L15;
        r101.height = ((int) r100) + k.d(r102);
        goto L19
    L10:
        r103 = false;
        goto L11
    }

    public e(FragmentActivity r100, View r101, float r102) {
        float r103 = n.t() * 0.2f;
        float r104 = n.t() * 0.9f;
        this.f226334f = true;
        this.f226330b = r101;
        if (ku5.c.k(r101.getContext()) == true) goto L6;
        r102 = (float) (((double) n.t()) * 0.55d);
    L10:
        this.f226329a = new float[]{r103, r102, r104};
        this.f226332d = n.f(r100, 180) / 200;
        a(r102);
        return;
    L6:
        if (r102 <= r104) goto L8;
    L9:
        r102 = r103 + ((r104 - r103) * 0.5f);
        goto L10
    L8:
        if (r102 >= r103) goto L10;
        goto L9
    }
}
