package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u implements Runnable {
    public final /* synthetic */ float a;
    public final /* synthetic */ float b;
    public final /* synthetic */ ViewParent c;
    public final /* synthetic */ View d;

    public u(ViewParent r2, View r3) {
        this.a = 0.25f;
        this.b = 0.2f;
        this.c = r2;
        this.d = r3;
    }

    public final void a() {
        int r0 = v.a;
        float r1 = this.a;
        float r2 = this.b;
        int r3 = ((FrameLayout) this.c).getMeasuredHeight();
        Context r4 = this.d.getContext();
        float r5 = r3;
        int r6 = (int) (r1 * r5);
        int r7 = (int) (r2 * r5);
        FrameLayout r8 = new FrameLayout(r4);
        r8.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View r9 = new View(r4);
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-1, r6);
        ViewCompat.setBackground(r9, ResourcesCompat.getDrawable(r4.getResources(), 2131247947, r4.getTheme()));
        r8.addView(r9, r10);
        View r11 = new View(r4);
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-1, r7);
        r12.gravity = 80;
        ViewCompat.setBackground(r11, ResourcesCompat.getDrawable(r4.getResources(), 2131247946, r4.getTheme()));
        r8.addView(r11, r12);
        r8.setTag("shadowView");
        ViewParent r13 = this.c;
        ((FrameLayout) r13).addView(r8, ((FrameLayout) r13).indexOfChild(this.d) + 1);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
