package com.bytedance.awemeopen.apps.framework.utils;

import android.content.Context;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.util.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements View.OnTouchListener {
    public float a;
    public float b;
    public final int c;
    public final int d;
    public final int e;
    public boolean f;
    public boolean g;
    public boolean h;
    public MotionEvent i;
    public MotionEvent j;
    public final /* synthetic */ g.a k;
    public final /* synthetic */ r0 l;

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r8, MotionEvent r9) {
        Intrinsics.checkNotNullParameter(r8, "v");
        Intrinsics.checkNotNullParameter(r9, "event");
        this.k.onTouch(r9);
        int r10 = r9.getAction();
        if (r10 == 0) goto L31;
        if (r10 != 1) goto L6;
        boolean r11 = this.g;
        if (r11 == true) goto L19;
    L54:
        return false;
    L19:
        if (this.h == false) goto L21;
    L26:
        MotionEvent r12 = this.j;
        if (r12 == null) goto L29;
        Intrinsics.checkNotNull(r12);
        r12.recycle();
    L29:
        this.j = MotionEvent.obtain(r9);
        goto L54
    L21:
        if (this.i != null) goto L24;
        r11 = false;
    L24:
        if (r11 == false) goto L26;
        r0 r13 = this.l;
        Message r0 = r13.obtainMessage(0, new Pair(Float.valueOf(this.a), Float.valueOf(this.b)));
        long r2 = ((long) ViewConfiguration.getDoubleTapTimeout()) - r9.getEventTime();
        MotionEvent r4 = this.i;
        Intrinsics.checkNotNull(r4);
        r13.sendMessageDelayed(r0, r2 + r4.getEventTime());
        goto L26
    L6:
        if (r10 != 2) goto L54;
        int r14 = (int) (r9.getX() - this.a);
        int r15 = (int) (r9.getY() - this.b);
        int r1 = (r14 * r14) + (r15 * r15);
        if (r1 <= this.d) goto L11;
    L12:
        this.g = false;
        this.l.removeMessages(0);
    L14:
        if (r1 <= this.e) goto L54;
        this.f = false;
        goto L54
    L11:
        if (Math.abs(r14) < this.c) goto L14;
    L31:
        if (this.l.hasMessages(0) == false) goto L33;
        this.l.removeMessages(0);
    L33:
        this.h = false;
        MotionEvent r16 = this.i;
        MotionEvent r3 = this.j;
        if (r16 == null) goto L47;
        if (r3 == null) goto L47;
        if (this.f == false) goto L47;
        long r5 = r9.getEventTime() - r3.getEventTime();
        if (r5 > ViewConfiguration.getDoubleTapTimeout()) goto L47;
        if (r5 < 40) goto L47;
        int r6 = ((int) r16.getX()) - ((int) r9.getX());
        int r17 = ((int) r16.getY()) - ((int) r9.getY());
        if (((r6 * r6) + (r17 * r17)) >= this.e) goto L47;
        boolean r18 = true;
    L48:
        if (r18 == false) goto L50;
        this.h = true;
        this.k.a(this.i, this.j, r9);
    L50:
        MotionEvent r19 = this.i;
        if (r19 == null) goto L53;
        Intrinsics.checkNotNull(r19);
        r19.recycle();
    L53:
        this.i = MotionEvent.obtain(r9);
        this.g = true;
        this.f = true;
        this.a = r9.getX();
        this.b = r9.getY();
    L47:
        r18 = false;
        goto L48
    }

    public h(Context r1, g.a r2, r0 r3) {
        this.k = r2;
        this.l = r3;
        int r4 = ViewConfiguration.get(r1).getScaledDoubleTapSlop();
        int r5 = ViewConfiguration.get(r1).getScaledTouchSlop() * 3;
        this.c = r5;
        this.d = r5 * r5;
        this.e = r4 * r4;
    }
}
