package com.larus.bmhome.view;

import android.view.MotionEvent;
import android.view.View;
import com.larus.utils.logger.FLogger;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j2 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<View, Unit> f316985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<View, Unit> f316986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f316987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i2 f316988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f316989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f316990f;

    public static final class a {
    }

    static {
    }

    public j2(Function1 r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "onLongPress");
        Intrinsics.checkNotNullParameter(r101, "onLongPressCancel");
        this.f316985a = r100;
        this.f316986b = r101;
        this.f316987c = 200;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v3, types: [com.larus.bmhome.view.i2, java.lang.Runnable] */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(final View r110, MotionEvent r111) {
        Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r111, "event");
        int r112 = r111.getAction();
        if (r112 == 0) goto L16;
        if (r112 != 1) goto L6;
        r110.removeCallbacks(this.f316988d);
        this.f316988d = null;
        this.f316986b.invoke(r110);
        if (this.f316989e == true) goto L14;
        long r100 = System.currentTimeMillis();
        FLogger r113 = FLogger.f375446a;
        r113.i("LongPressTouchListener", "ACTION_UP called 01 lastClickTime=" + this.f316990f + " curClickTime=" + r100 + " gap=" + (r100 - this.f316990f) + " hashCode=" + hashCode());
        if ((r100 - this.f316990f) < 800) goto L14;
        this.f316990f = r100;
        r113.i("LongPressTouchListener", "ACTION_UP called 02 lastClickTime=" + this.f316990f + " hashCode=" + hashCode());
        r110.performClick();
    L14:
        return true;
    L6:
        if (r112 == 2) goto L8;
        return false;
    L8:
        return true;
    L16:
        if ((System.currentTimeMillis() - this.f316990f) >= 800) goto L18;
        return true;
    L18:
        this.f316989e = false;
        ?? r114 = new i2(this, r110);
        this.f316988d = r114;
        r110.postDelayed(r114, this.f316987c);
        return true;
    }
}
