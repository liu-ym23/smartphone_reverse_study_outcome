package com.suite.component.logger;

import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.component.logger.api.LogLevel;
import com.suite.component.logger.api.h;
import com.suite.component.logger.interceptor.PrintLogInterceptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f460092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<com.suite.component.logger.api.f> f460093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.suite.component.logger.api.d> f460094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.suite.component.logger.api.c f460095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f460096e;

    /* JADX INFO: renamed from: com.suite.component.logger.a$a, reason: collision with other inner class name */
    public static final class C5516a extends com.suite.component.logger.api.b {
        @Override // com.suite.component.logger.api.b
        public final h a() {
            g r100 = new g();
            Intrinsics.checkNotNullParameter(r100, "executor");
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.f460100b = r100;
            return new a(this);
        }

        @Override // com.suite.component.logger.api.b
        public final com.suite.component.logger.api.b b() {
            C5516a r100 = new C5516a(getContext());
            com.suite.component.logger.api.c r101 = this.f460100b;
            if (r101 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("executor");
            r101 = null;
        L6:
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            r100.f460100b = r101;
            List<com.suite.component.logger.api.f> r102 = this.f460102d;
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r100.f460102d = r102;
            List<com.suite.component.logger.api.d> r103 = this.f460103e;
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            r100.f460103e = r103;
            List<com.suite.component.logger.api.e> r104 = this.f460104f;
            Intrinsics.checkNotNullParameter(r104, "<set-?>");
            r100.f460104f = r104;
            return r100;
        }

        public C5516a(b r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
        }
    }

    @Override // com.suite.component.logger.api.h
    public final c obtain() {
        Object r100 = c.f460112w;
        c r101 = c.a.a();
        r101.f460132r = this;
        return r101;
    }

    public a(com.suite.component.logger.api.b r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        b r101 = r100.getContext();
        this.f460092a = r101;
        this.f460093b = new ArrayList(r100.f460102d);
        com.suite.component.logger.api.c r102 = r100.f460100b;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("executor");
        r102 = null;
    L6:
        this.f460095d = r102;
        ArrayList r103 = new ArrayList();
        this.f460094c = r103;
        r103.add(new com.suite.component.logger.interceptor.a());
        r103.addAll(r100.f460103e);
        r103.add(new PrintLogInterceptor(r101, new ArrayList(r100.f460104f)));
        this.f460096e = new e(r101, r103);
    }

    @Override // com.suite.component.logger.api.h
    public final void h(c r100) {
        Intrinsics.checkNotNullParameter(r100, "log");
        Iterator<com.suite.component.logger.api.f> r101 = this.f460093b.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (r101.next().a(this.f460092a, r100) == true) goto L4;
        return;
    L9:
        if (this.f460095d.isRunning() == true) goto L21;
        com.suite.component.logger.api.c r102 = this.f460095d;
        monitor-enter(r102);
    L18:
        th = move-exception;
        throw th;
    L13:
        if (this.f460095d.isRunning() == true) goto L15;
        this.f460095d.b();     // Catch: Throwable -> L18
    L15:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r102);
    L21:
        r100.f460133s = this.f460096e;
        this.f460095d.a(r100);
    }

    @Override // com.suite.component.logger.api.h
    public final void d(String r110, String r111, Throwable r112) {
        Intrinsics.checkNotNullParameter(r110, "tag");
        Intrinsics.checkNotNullParameter(r111, "msg");
        a(this, LogLevel.DEBUG, r110, r111, r112, false, new String[0], 40);
    }

    @Override // com.suite.component.logger.api.h
    public final void i(String r110, String r111, Throwable r112) {
        Intrinsics.checkNotNullParameter(r110, "tag");
        Intrinsics.checkNotNullParameter(r111, "msg");
        a(this, LogLevel.INFO, r110, r111, r112, false, new String[0], 40);
    }

    @Override // com.suite.component.logger.api.h
    public final void v(String r110, String r111, Throwable r112) {
        Intrinsics.checkNotNullParameter(r110, "tag");
        Intrinsics.checkNotNullParameter(r111, "msg");
        a(this, LogLevel.VERBOSE, r110, r111, r112, false, new String[0], 40);
    }

    @Override // com.suite.component.logger.api.h
    public final void w(String r110, String r111, Throwable r112) {
        Intrinsics.checkNotNullParameter(r110, "tag");
        Intrinsics.checkNotNullParameter(r111, "msg");
        a(this, LogLevel.WARN, r110, r111, r112, false, new String[0], 40);
    }

    @Override // com.suite.component.logger.api.h
    public final void g(String r110, String r111, Throwable r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "tag");
        Intrinsics.checkNotNullParameter(r111, "msg");
        a(this, LogLevel.ERROR, r110, r111, r112, r113, new String[0], 8);
    }

    public static void a(a r100, LogLevel r101, String r102, String r103, Throwable r104, boolean r105, String[] r106, int r107) {
        if ((r107 & 4) == 0) goto L6;
        r103 = null;
    L6:
        if ((r107 & 16) == 0) goto L8;
        r104 = null;
    L8:
        c r108 = r100.obtain();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r108.f460115a = r101;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r108.f460116b = r102;
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r108.f460117c = r103;
        r108.f460118d = r106;
        r108.f460119e = null;
        r108.f460124j = r104;
        Intrinsics.checkNotNullParameter(r108, "<this>");
        h r109 = r108.f460132r;
        if (r109 == null) goto L15;
        r109.h(r108);
        return;
    }
}
