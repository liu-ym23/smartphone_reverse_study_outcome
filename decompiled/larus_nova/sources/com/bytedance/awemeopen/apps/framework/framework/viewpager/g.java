package com.bytedance.awemeopen.apps.framework.framework.viewpager;

import android.view.View;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.npth.AoExceptionReporter;
import com.bytedance.awemeopen.infra.base.npth.ErrorPriority;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class g<Model> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f197058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Model f197059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f197060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f197061d;

    public static final class a {
    }

    static {
    }

    public boolean d() {
        return false;
    }

    public abstract void e(Model r100, int r101);

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
        if (this.f197060c == true) goto L10;
        String r100 = getClass().getSimpleName().concat(" must bind before selected!");
        if (AoEnv.h() == true) goto L8;
        AoNpthService r101 = AoExceptionReporter.f198706a;
        AoExceptionReporter.b(ErrorPriority.f198711p1, "AosPagerItemViewHolder", null, r100, 20);
        goto L10
    L8:
        throw new RuntimeException(r100);
    L10:
        if (this.f197061d == false) goto L12;
        return;
    L12:
        this.f197061d = true;
        f();
    }

    public final void k() {
        if (this.f197060c == true) goto L9;
        String r100 = getClass().getSimpleName().concat(" must bind before unbind!");
        if (AoEnv.h() == true) goto L8;
        AoNpthService r101 = AoExceptionReporter.f198706a;
        AoExceptionReporter.b(ErrorPriority.f198711p1, "AosPagerItemViewHolder", null, r100, 20);
        goto L9
    L8:
        throw new RuntimeException(r100);
    L9:
        l();
        this.f197060c = false;
        g();
        this.f197059b = null;
    }

    public final void l() {
        if (this.f197060c == true) goto L10;
        String r100 = getClass().getSimpleName().concat(" must bind before unSelected!");
        if (AoEnv.h() == true) goto L8;
        AoNpthService r101 = AoExceptionReporter.f198706a;
        AoExceptionReporter.b(ErrorPriority.f198711p1, "AosPagerItemViewHolder", null, r100, 20);
        goto L10
    L8:
        throw new RuntimeException(r100);
    L10:
        if (this.f197061d == true) goto L12;
        return;
    L12:
        this.f197061d = false;
        h();
    }

    public g(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        this.f197058a = r100;
    }

    public final void c(Model r100, int r101) {
        if (this.f197060c == false) goto L9;
        String r102 = getClass().getSimpleName().concat(" already bind!");
        if (AoEnv.h() == true) goto L8;
        AoNpthService r103 = AoExceptionReporter.f198706a;
        AoExceptionReporter.b(ErrorPriority.f198711p1, "AosPagerItemViewHolder", null, r102, 20);
        goto L9
    L8:
        throw new RuntimeException(r102);
    L9:
        this.f197060c = true;
        this.f197059b = r100;
        e(r100, r101);
    }
}
