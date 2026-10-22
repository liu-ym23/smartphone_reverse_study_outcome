package com.bytedance.ies.bullet.base.utils.logger;

import android.os.Handler;
import com.alipay.sdk.m.u.i;
import com.bytedance.ies.bullet.base.settings.c;
import com.bytedance.ies.bullet.core.h;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import w26.e;
import w26.g;

/* JADX INFO: loaded from: classes19.dex */
public final class HybridLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HybridLogger f246343a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f246344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f246345c = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f246346a;

        public a(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f246346a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f246346a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public HybridLogger() {
    }

    static {
        f246343a = new HybridLogger();
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        g r101 = (g) x26.a.a(g.class);
        if (r101 == null) goto L7;
        e r102 = (e) r101.n0(e.class);
        if (r102 == null) goto L7;
        int r103 = r102.k2();
    L8:
        f246344b = r103;
        f246345c = LazyKt.lazy(HybridLogger$logHandler$2.INSTANCE);
        return;
    L7:
        r103 = 4;
        goto L8
    }

    public static void b(Function0 r100) {
        ((Handler) f246345c.getValue()).post(new a(r100));
    }

    public static String j(String r100) {
        StringBuilder r101 = new StringBuilder("HybridLogger");
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L12;
        r101.append("_");
        r101.append(r100);
    L12:
        return r101.toString();
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    public static final String a(String r100, Map r110, com.bytedance.ies.bullet.base.utils.logger.a r111) {
        boolean r101 = false;
        boolean r102 = true;
        if (r110 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        if (r111 != null) goto L12;
        return r100;
    L12:
        List<b> r104 = null;
        if (c.a().d() != 1) goto L61;
        StringBuilder r105 = new StringBuilder(r100.length() + 256);
        r105.append(r100);
        if (r110 != null) goto L17;
    L20:
        boolean r106 = true;
    L22:
        if (r106 == true) goto L38;
        r105.append("|xParam:{");
        Iterator r107 = r110.entrySet().iterator();
        boolean r112 = true;
    L25:
        if (r107.hasNext() == false) goto L37;
        Map.Entry r108 = (Map.Entry) r107.next();
        String r109 = (String) r108.getKey();
        Object r113 = r108.getValue();
        if (r112 == true) goto L29;
        r105.append(",");
    L29:
        r105.append("\"");
        r105.append(r109);
        r105.append("\":");
        if ((r113 instanceof String) == false) goto L33;
        r105.append("\"");
        r105.append((String) r113);
        r105.append("\"");
    L36:
        r112 = false;
        goto L25
    L33:
        if ((r113 instanceof Number) == false) goto L35;
        r105.append(r113);
        goto L36
    L35:
        r105.append(r113);
        goto L36
    L37:
        r105.append(i.f25855d);
    L38:
        if (r111 == null) goto L40;
        List<b> r114 = r111.f246347a;
    L41:
        if (r114 != null) goto L43;
    L46:
        boolean r115 = true;
    L47:
        if (r115 == true) goto L96;
        r105.append("|xContext:{");
        if (r111 == null) goto L51;
        r104 = r111.f246347a;
    L51:
        if (r104 == null) goto L59;
        Iterator<T> r116 = r104.iterator();
    L54:
        if (r116.hasNext() == false) goto L59;
        b r117 = (b) r116.next();
        if (r102 == true) goto L58;
        r105.append(",");
    L58:
        r105.append("\"");
        r105.append(r117.f246348a);
        r105.append("\":\"");
        r105.append(r117.f246349b);
        r105.append("\"");
        r102 = false;
    L59:
        r105.append(i.f25855d);
    L96:
        return r105.toString();
    L43:
        if (r114.isEmpty() == true) goto L46;
        r115 = false;
        goto L47
    L40:
        r114 = null;
        goto L41
    L17:
        if (r110.isEmpty() == true) goto L20;
        r106 = false;
        goto L22
    L61:
        StringBuffer r118 = new StringBuffer(r100);
        if (r110 != null) goto L64;
    L67:
        boolean r119 = true;
    L68:
        if (r119 == true) goto L70;
        r118.append("|xParam:");
        r118.append(new JSONObject(r110).toString());
    L70:
        if (r111 == null) goto L72;
        r104 = r111.f246347a;
    L72:
        if (r104 != null) goto L74;
    L75:
        r101 = true;
    L76:
        if (r101 == true) goto L87;
        JSONObject r120 = new JSONObject();
        if (r111 == null) goto L85;
        List<b> r121 = r111.f246347a;
        if (r121 == null) goto L85;
        Iterator r122 = ((ArrayList) r121).iterator();
    L83:
        if (r122.hasNext() == false) goto L85;
        b r123 = (b) r122.next();
        r120.put(r123.f246348a, r123.f246349b);
    L85:
        r118.append("|xContext:");
        r118.append(r120.toString());
    L87:
        return r118.toString();
    L74:
        if (r104.isEmpty() == false) goto L76;
    L64:
        if (r110.isEmpty() == true) goto L67;
        r119 = false;
        goto L68
    L5:
        if (r110.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    public static boolean c(String r100, String r101, LogLevel r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "logLevel");
        if (StringsKt.contains$default(r100, "_undropped", false, 2, null) == false) goto L5;
        return false;
    L5:
        int r103 = com.bytedance.android.anniex.utils.a.f41398a;
        c.a();
        c.a();
        if (c.a().a() == 1) goto L8;
        return false;
    L8:
        if (r101.length() <= 3000) goto L12;
        return true;
    L12:
        return false;
    }

    public static void d(String r100, String r101, Map r102, com.bytedance.ies.bullet.base.utils.logger.a r103) {
        Intrinsics.checkNotNullParameter(r100, "moduleTag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        e(r100, r101, r102, r103, true);
    }

    public static /* synthetic */ void f(String r100, String r101, Map r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        d(r100, r101, r102, null);
    }

    public static void g(String r100, String r101, Map r102, com.bytedance.ies.bullet.base.utils.logger.a r103) {
        Intrinsics.checkNotNullParameter(r100, "moduleTag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        h(r100, r101, r102, r103, true);
    }

    public static /* synthetic */ void i(String r100, String r101, Map r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        g(r100, r101, r102, null);
    }

    public static void k(String r100, String r101, Map r102, com.bytedance.ies.bullet.base.utils.logger.a r103) {
        Intrinsics.checkNotNullParameter(r100, "moduleTag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        l(r100, r101, r102, r103, true);
    }

    public static void n(String r100, String r101, Map r102, com.bytedance.ies.bullet.base.utils.logger.a r103) {
        Intrinsics.checkNotNullParameter(r100, "moduleTag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        o(r100, r101, r102, r103, true);
    }

    public static /* synthetic */ void p(String r100, String r101, Map r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        n(r100, r101, r102, null);
    }

    public static void e(final String r100, final String r101, final Map r102, final com.bytedance.ies.bullet.base.utils.logger.a r110, final boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "moduleTag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (c(j(r100), r101, LogLevel.D) == false) goto L6;
        return;
    L6:
        if (f246344b > 3) goto L8;
    L9:
        b(new AnonymousClass1(r111, r100, r101, r102, r110));
        return;
    L8:
        if (h.f246501h.f246502a == true) goto L9;
    }

    public static void h(final String r100, final String r101, final Map r102, final com.bytedance.ies.bullet.base.utils.logger.a r110, final boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "moduleTag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (f246344b > 6) goto L5;
    L6:
        b(new C105541(r111, r100, r101, r102, r110));
        return;
    L5:
        if (h.f246501h.f246502a == true) goto L6;
    }

    public static void l(final String r100, final String r101, final Map r102, final com.bytedance.ies.bullet.base.utils.logger.a r110, final boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "moduleTag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (c(j(r100), r101, LogLevel.I) == false) goto L6;
        return;
    L6:
        if (f246344b > 4) goto L8;
    L9:
        b(new C105551(r111, r100, r101, r102, r110));
        return;
    L8:
        if (h.f246501h.f246502a == true) goto L9;
    }

    public static /* synthetic */ void m(String r100, String r101, Map r102, com.bytedance.ies.bullet.base.utils.logger.a r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        k(r100, r101, r102, r103);
    }

    public static void o(final String r100, final String r101, final Map r102, final com.bytedance.ies.bullet.base.utils.logger.a r110, final boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "moduleTag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (f246344b > 5) goto L5;
    L6:
        b(new HybridLogger$w$1(r111, r100, r101, r102, r110));
        return;
    L5:
        if (h.f246501h.f246502a == true) goto L6;
    }
}
