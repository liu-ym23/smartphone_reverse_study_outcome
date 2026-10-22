package com.bytedance.awemeopen.apps.framework.framework.viewpager;

import android.view.View;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.npth.AoExceptionReporter;
import com.bytedance.awemeopen.infra.base.npth.ErrorPriority;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class g<Model> {
    public final View a;
    public Model b;
    public boolean c;
    public boolean d;

    public static final class a {
    }

    static {
    }

    public boolean d() {
        return false;
    }

    public abstract void e(Model r1, int r2);

    public void f() {
    }

    public void g() {
    }

    public void h() {
    }

    public void j() {
    }

    public void m() {
    }

    public final void i() {
        if (this.c == true) goto L10;
        String r0 = getClass().getSimpleName().concat(" must bind before selected!");
        if (AoEnv.h() == true) goto L8;
        AoNpthService r1 = AoExceptionReporter.a;
        AoExceptionReporter.b(ErrorPriority.p1, "AosPagerItemViewHolder", null, r0, 20);
        goto L10
    L8:
        throw new RuntimeException(r0);
    L10:
        if (this.d == false) goto L12;
        return;
    L12:
        this.d = true;
        f();
    }

    public final void k() {
        if (this.c == true) goto L9;
        String r0 = getClass().getSimpleName().concat(" must bind before unbind!");
        if (AoEnv.h() == true) goto L8;
        AoNpthService r2 = AoExceptionReporter.a;
        AoExceptionReporter.b(ErrorPriority.p1, "AosPagerItemViewHolder", null, r0, 20);
        goto L9
    L8:
        throw new RuntimeException(r0);
    L9:
        l();
        this.c = false;
        g();
        this.b = null;
    }

    public final void l() {
        if (this.c == true) goto L10;
        String r0 = getClass().getSimpleName().concat(" must bind before unSelected!");
        if (AoEnv.h() == true) goto L8;
        AoNpthService r1 = AoExceptionReporter.a;
        AoExceptionReporter.b(ErrorPriority.p1, "AosPagerItemViewHolder", null, r0, 20);
        goto L10
    L8:
        throw new RuntimeException(r0);
    L10:
        if (this.d == true) goto L12;
        return;
    L12:
        this.d = false;
        h();
    }

    public g(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        this.a = r2;
    }

    public final void c(Model r6, int r7) {
        if (this.c == false) goto L9;
        String r0 = getClass().getSimpleName().concat(" already bind!");
        if (AoEnv.h() == true) goto L8;
        AoNpthService r1 = AoExceptionReporter.a;
        AoExceptionReporter.b(ErrorPriority.p1, "AosPagerItemViewHolder", null, r0, 20);
        goto L9
    L8:
        throw new RuntimeException(r0);
    L9:
        this.c = true;
        this.b = r6;
        e(r6, r7);
    }
}
