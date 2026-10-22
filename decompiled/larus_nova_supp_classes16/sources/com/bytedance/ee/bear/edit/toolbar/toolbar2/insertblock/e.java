package com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.util.ui.k;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public float[] a;
    public View b;
    public ValueAnimator c;
    public float d;
    public a e;
    public boolean f;

    public interface a {
        void a(int r1);
    }

    public final void a(float r4) {
        if (r4 >= 0.0f) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r0 = this.b.getLayoutParams();
        if (r0 == null) goto L23;
        Context r1 = this.b.getContext();
        if ((r1 instanceof Activity) == false) goto L10;
        boolean r2 = n.D((Activity) r1);
    L11:
        if (r2 == true) goto L13;
    L15:
        int r3 = (int) r4;
        if (r3 != r0.height) goto L18;
        return;
    L18:
        r0.height = r3;
    L19:
        this.b.setLayoutParams(r0);
        int r5 = (int) r4;
        a r6 = this.e;
        if (r6 == null) goto L24;
        r6.a(r5);
        return;
    L24:
        return;
    L13:
        if (k.f(r1) == false) goto L15;
        r0.height = ((int) r4) + k.d(r1);
        goto L19
    L10:
        r2 = false;
        goto L11
    }

    public e(FragmentActivity r6, View r7, float r8) {
        float r0 = n.t() * 0.2f;
        float r1 = n.t() * 0.9f;
        this.f = true;
        this.b = r7;
        if (ku5.c.k(r7.getContext()) == true) goto L6;
        r8 = (float) (((double) n.t()) * 0.55d);
    L10:
        this.a = new float[]{r0, r8, r1};
        this.d = n.f(r6, 180) / 200;
        a(r8);
        return;
    L6:
        if (r8 <= r1) goto L8;
    L9:
        r8 = r0 + ((r1 - r0) * 0.5f);
        goto L10
    L8:
        if (r8 >= r0) goto L10;
        goto L9
    }
}
