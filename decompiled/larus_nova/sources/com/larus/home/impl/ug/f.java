package com.larus.home.impl.ug;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Boolean, Unit> f346301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f346302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f346303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<Activity> f346304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f346305e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f346306f;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f346307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f346308b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f346307a == r101.f346307a) goto L12;
            return false;
        L12:
            if (this.f346308b == r101.f346308b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f346307a * 31) + this.f346308b;
        }

        public final String toString() {
            return "DraggableY(top=" + this.f346307a + ", bottom=" + this.f346308b + ')';
        }

        public b(int r100, int r101) {
            this.f346307a = r100;
            this.f346308b = r101;
        }
    }

    static {
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [com.larus.home.impl.ug.e] */
    public f(Context r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "onDraggableYChanged");
        this.f346301a = r101;
        int r102 = com.larus.utils.i.c(r100);
        this.f346302b = r102;
        double r103 = r102;
        b r104 = new b((int) (0.15d * r103), (int) (r103 * 0.76d));
        this.f346303c = r104;
        this.f346305e = r104;
        this.f346306f = new e(this);
    }
}
