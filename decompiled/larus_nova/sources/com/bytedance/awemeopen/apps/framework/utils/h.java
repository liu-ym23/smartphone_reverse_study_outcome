package com.bytedance.awemeopen.apps.framework.utils;

import android.content.Context;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.util.Pair;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f197699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f197700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f197701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f197702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f197703e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f197704f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f197705g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f197706h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MotionEvent f197707i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MotionEvent f197708j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ g.a f197709k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ r0 f197710l;

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r101, "event");
        this.f197709k.onTouch(r101);
        int r102 = r101.getAction();
        if (r102 == 0) goto L31;
        if (r102 != 1) goto L6;
        boolean r103 = this.f197705g;
        if (r103 == true) goto L19;
    L54:
        return false;
    L19:
        if (this.f197706h == false) goto L21;
    L26:
        MotionEvent r104 = this.f197708j;
        if (r104 == null) goto L29;
        Intrinsics.checkNotNull(r104);
        r104.recycle();
    L29:
        this.f197708j = MotionEvent.obtain(r101);
        goto L54
    L21:
        if (this.f197707i != null) goto L24;
        r103 = false;
    L24:
        if (r103 == false) goto L26;
        r0 r105 = this.f197710l;
        Message r106 = r105.obtainMessage(0, new Pair(Float.valueOf(this.f197699a), Float.valueOf(this.f197700b)));
        long r107 = ((long) ViewConfiguration.getDoubleTapTimeout()) - r101.getEventTime();
        MotionEvent r108 = this.f197707i;
        Intrinsics.checkNotNull(r108);
        r105.sendMessageDelayed(r106, r107 + r108.getEventTime());
        goto L26
    L6:
        if (r102 != 2) goto L54;
        int r109 = (int) (r101.getX() - this.f197699a);
        int r110 = (int) (r101.getY() - this.f197700b);
        int r111 = (r109 * r109) + (r110 * r110);
        if (r111 <= this.f197702d) goto L11;
    L12:
        this.f197705g = false;
        this.f197710l.removeMessages(0);
    L14:
        if (r111 <= this.f197703e) goto L54;
        this.f197704f = false;
        goto L54
    L11:
        if (Math.abs(r109) < this.f197701c) goto L14;
    L31:
        if (this.f197710l.hasMessages(0) == false) goto L33;
        this.f197710l.removeMessages(0);
    L33:
        this.f197706h = false;
        MotionEvent r112 = this.f197707i;
        MotionEvent r113 = this.f197708j;
        if (r112 == null) goto L47;
        if (r113 == null) goto L47;
        if (this.f197704f == false) goto L47;
        long r114 = r101.getEventTime() - r113.getEventTime();
        if (r114 > ViewConfiguration.getDoubleTapTimeout()) goto L47;
        if (r114 < 40) goto L47;
        int r115 = ((int) r112.getX()) - ((int) r101.getX());
        int r116 = ((int) r112.getY()) - ((int) r101.getY());
        if (((r115 * r115) + (r116 * r116)) >= this.f197703e) goto L47;
        boolean r117 = true;
    L48:
        if (r117 == false) goto L50;
        this.f197706h = true;
        this.f197709k.a(this.f197707i, this.f197708j, r101);
    L50:
        MotionEvent r118 = this.f197707i;
        if (r118 == null) goto L53;
        Intrinsics.checkNotNull(r118);
        r118.recycle();
    L53:
        this.f197707i = MotionEvent.obtain(r101);
        this.f197705g = true;
        this.f197704f = true;
        this.f197699a = r101.getX();
        this.f197700b = r101.getY();
    L47:
        r117 = false;
        goto L48
    }

    public h(Context r100, g.a r101, r0 r102) {
        this.f197709k = r101;
        this.f197710l = r102;
        int r103 = ViewConfiguration.get(r100).getScaledDoubleTapSlop();
        int r104 = ViewConfiguration.get(r100).getScaledTouchSlop() * 3;
        this.f197701c = r104;
        this.f197702d = r104 * r104;
        this.f197703e = r103 * r103;
    }
}
