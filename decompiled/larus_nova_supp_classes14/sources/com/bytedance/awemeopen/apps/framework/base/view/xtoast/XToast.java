package com.bytedance.awemeopen.apps.framework.base.view.xtoast;

import android.R;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import ay3.a;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import z04.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class XToast {
    public static int j;
    public final WeakReference<Activity> a;
    public ViewGroup b;
    public View c;
    public int d;
    public AnimatorSet e;
    public AnimatorSet f;
    public final int g;
    public int h;
    public final String i;

    @Retention(RetentionPolicy.SOURCE)
    public @interface XAnimation {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface XDuration {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface XGravity {
    }

    public final void a() {
        Activity r0 = this.a.get();
        if (r0 != null) goto L6;
        return;
    L6:
        if (j != 0) goto L8;
        j = c.a(r0);
    L8:
        View r1 = LayoutInflater.from(r0).inflate(2131558675, null);
        this.c = r1;
        View r2 = r1.findViewById(2131384707);
        this.c.findViewById(2131376297).setVisibility(8);
        TextView r3 = (TextView) this.c.findViewById(2131390392);
        r3.setTextColor(ContextCompat.getColor(this.c.getContext(), 2131100271));
        r3.setText(this.i);
        r2.setAlpha(1.0f);
        LinearLayout.LayoutParams r4 = (LinearLayout.LayoutParams) r2.getLayoutParams();
        int r5 = (int) n0.a(this.c.getContext(), 16.0f);
        r4.leftMargin = r5;
        r4.rightMargin = r5;
        if (this.g != 3) goto L11;
        r2.setBackgroundResource(2131231625);
        r4.topMargin = j + ((int) n0.a(this.c.getContext(), 8.0f));
        r3.setMaxWidth((int) n0.a(this.c.getContext(), 210.0f));
    L12:
        r2.setLayoutParams(r4);
        return;
    L11:
        r2.setBackgroundResource(2131231624);
        goto L12
    }

    public final void b() {
        Activity r0 = this.a.get();
        if (r0 == null) goto L14;
        this.b = (ViewGroup) r0.findViewById(R.id.content);
        int r1 = this.g;
        if (r1 != 1) goto L8;
        a();
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-2, -2);
        r2.gravity = 17;
        this.c.setLayoutParams(r2);
        goto L14
    L8:
        if (r1 == 2) goto L12;
        if (r1 != 3) goto L14;
        a();
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-2, -2);
        r3.gravity = 49;
        this.c.setLayoutParams(r3);
        goto L14
    L12:
        a();
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-1, -2);
        r4.gravity = 81;
        r4.bottomMargin = (int) n0.a(this.c.getContext(), 120.0f);
        this.c.setLayoutParams(r4);
        this.d = 3;
        this.h = 3000;
    L14:
        int r5 = this.d;
        if (r5 != 0) goto L17;
        this.e = a.b(this, 0);
        this.f = a.a(this, 0);
    L19:
        if (this.h != 0) goto L21;
        this.h = ECDraweeView.ROUND;
    L21:
        ay3.c r6 = ay3.c.b;
        monitor-enter(ay3.c.class);
    L30:
        th = move-exception;
        throw th;
    L24:
        if (ay3.c.b != null) goto L26;
        ay3.c.b = new ay3.c(Looper.getMainLooper());     // Catch: Throwable -> L30
    L26:
        ay3.c r7 = ay3.c.b;     // Catch: Throwable -> L30
        monitor-exit(ay3.c.class);
        ((LinkedList) r7.a).offer(this);
        r7.a();
        return;
    L17:
        this.e = a.b(this, r5);
        this.f = a.a(this, this.d);
        goto L19
    }

    public XToast(Activity r2, String r3, int r4) {
        this.g = 3;
        this.a = new WeakReference(r2);
        this.i = r3;
        this.g = r4;
    }
}
