package com.suite.lark.platform.component.widget.floatingpanel.impl;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.s;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yoc.h;

/* JADX INFO: loaded from: classes36.dex */
@UserScope
public final class FloatingPanelService extends c0c.c implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.suite.lark.platform.component.widget.floatingpanel.impl.a f460665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f460666c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<com.suite.lark.platform.component.widget.floatingpanel.impl.a, Unit> f460667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FloatingPanelService f460668b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super com.suite.lark.platform.component.widget.floatingpanel.impl.a, Unit> r100, FloatingPanelService r101) {
            this.f460667a = r100;
            this.f460668b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f460667a.invoke(this.f460668b.f460665b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // yoc.h
    public final void G6() {
        m(FloatingPanelService$collapseCardList$1.INSTANCE);
    }

    @Override // yoc.h
    public final int c8() {
        return this.f460665b.c8();
    }

    @Inject
    public FloatingPanelService(m r100) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        super(r100);
        this.f460665b = new com.suite.lark.platform.component.widget.floatingpanel.impl.a();
        this.f460666c = new Handler(Looper.getMainLooper());
        s.a(this);
    }

    @Override // c0c.c
    public final void d(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        m(new FloatingPanelService$destroy$1(this));
    }

    public final void m(Function1<? super com.suite.lark.platform.component.widget.floatingpanel.impl.a, Unit> r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L6;
        r100.invoke(this.f460665b);
        return;
    L6:
        this.f460666c.post(new a(r100, this));
    }

    @Override // yoc.h
    public final void ra(final yoc.c r100) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        m(new FloatingPanelService$showCard$1(r100));
    }

    @Override // yoc.h
    public final void y2(final int r100, final String r101) {
        Intrinsics.checkNotNullParameter(r101, "id");
        m(new FloatingPanelService$removeCard$1(r100, r101));
    }
}
