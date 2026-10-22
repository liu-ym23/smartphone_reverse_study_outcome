package com.bytedance.forest.utils;

import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SimpleDateFormat f244512e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function3<? super Integer, ? super String, ? super Map<String, ? extends Object>, Unit> f244513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f244514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f244515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f244516d;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f244517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f244518b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f244519c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0 f244520d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f244521e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f244522f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f244523g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f244524h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ HashMap f244525i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ Throwable f244526j;

        public b(c r100, long r101, String r102, Function0 r103, int r104, String r105, boolean r106, String r107, HashMap r110, Throwable r111) {
            this.f244517a = r100;
            this.f244518b = r101;
            this.f244519c = r102;
            this.f244520d = r103;
            this.f244521e = r104;
            this.f244522f = r105;
            this.f244523g = r106;
            this.f244524h = r107;
            this.f244525i = r110;
            this.f244526j = r111;
        }

        public final void a() {
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
            Object r101 = Result.m9449constructorimpl(c.f244512e.format(new Date(this.f244518b)));     // Catch: Throwable -> L4
        L7:
            if (Result.m9455isFailureimpl(r101) == false) goto L9;
            r101 = null;
        L9:
            String r102 = (String) r101;
            if (r102 != null) goto L13;
            r102 = "";
        L13:
            String r103 = "[" + r102 + ']' + this.f244519c + ((String) this.f244520d.invoke());
            int r104 = this.f244521e;
            if (r104 != 3) goto L16;
            i r105 = i.f244548a;
            i.a(this.f244522f, r103, this.f244523g, this.f244517a.f244513a, this.f244524h, this.f244525i);
            return;
        L16:
            if (r104 == 4) goto L18;
            i r106 = i.f244548a;
            i.d(this.f244522f, r103, this.f244526j, this.f244523g, this.f244517a.f244513a, this.f244524h, this.f244525i);
            return;
        L18:
            i r107 = i.f244548a;
            i.g(this.f244522f, r103, this.f244523g, this.f244517a.f244513a, this.f244524h, this.f244525i);
            return;
        L4:
            th = move-exception;
            Result.Companion r108 = Result.Companion;
            r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L7
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

    static {
        f244512e = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
    }

    public c() {
        this.f244514b = "";
        this.f244515c = "";
        StringBuilder r100 = new StringBuilder();
        r100.append(hashCode());
        r100.append('-');
        r100.append(System.currentTimeMillis());
        this.f244516d = r100.toString();
    }

    public final void b(int r110, String r111, boolean r112, Throwable r113, String r114, Function0<String> r210) {
        long r100 = System.currentTimeMillis();
        String r101 = "[" + this.f244516d + "][" + ThreadMethodProxy.currentThread().getName() + ']';
        HashMap r115 = new HashMap();
        r115.put("request_id", this.f244516d);
        r115.put("session_id", this.f244514b);
        r115.put("url", this.f244515c);
        ((Handler) ThreadUtils.f244504c.getValue()).post(new b(this, r100, r101, r210, r110, r111, r112, r114, r115, r113));
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.String] */
    public static void a(c r110, int r111, String r112, String r113, boolean r114, Throwable r115, String r116, int r117) {
        if ((r117 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r117 & 8) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r117 & 16) == 0) goto L13;
        Throwable r118 = null;
    L15:
        if ((r117 & 32) == 0) goto L17;
        String r102 = "";
    L18:
        r110.getClass();
        long r103 = System.currentTimeMillis();
        Ref.ObjectRef r104 = new Ref.ObjectRef();
        r104.element = "[" + r110.f244516d + "][" + ThreadMethodProxy.currentThread().getName() + ']' + r113;
        HashMap r105 = new HashMap();
        r105.put("request_id", r110.f244516d);
        r105.put("session_id", r110.f244514b);
        r105.put("url", r110.f244515c);
        ((Handler) ThreadUtils.f244504c.getValue()).post(new d(r110, r103, r104, r111, r100, r101, r102, r105, r118));
        return;
    L17:
        r102 = r116;
        goto L18
    L13:
        r118 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }

    public static /* synthetic */ void c(c r100, int r110, String r111, boolean r112, Throwable r113, String r114, Function0 r115, int r116) {
        if ((r116 & 2) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r116 & 4) == 0) goto L9;
        boolean r102 = false;
    L11:
        if ((r116 & 8) == 0) goto L13;
        Throwable r103 = null;
    L15:
        if ((r116 & 16) == 0) goto L17;
        String r104 = "";
    L18:
        r100.b(r110, r101, r102, r103, r104, r115);
        return;
    L17:
        r104 = r114;
        goto L18
    L13:
        r103 = r113;
        goto L15
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }
}
