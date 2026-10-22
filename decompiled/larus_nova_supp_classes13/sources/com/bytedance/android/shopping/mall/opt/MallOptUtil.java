package com.bytedance.android.shopping.mall.opt;

import com.bytedance.android.shopping.api.mall.MallPageName;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallOptUtil {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final Lazy j = null;
    public static final Lazy k = null;
    public static final Lazy l = null;
    public static final Lazy m = null;
    public static final Lazy n = null;

    public static f d() {
        return (f) n.getValue();
    }

    public static j93.b e() {
        return (j93.b) h.getValue();
    }

    public static aa3.c f() {
        return (aa3.c) f.getValue();
    }

    static {
        a = LazyKt.lazy(MallOptUtil$config$2.INSTANCE);
        b = LazyKt.lazy(MallOptUtil$openSchemaTurboSetting$2.INSTANCE);
        c = LazyKt.lazy(MallOptUtil$openSchemaGcBlockSetting$2.INSTANCE);
        d = LazyKt.lazy(MallOptUtil$preloadConfig$2.INSTANCE);
        e = LazyKt.lazy(MallOptUtil$mallEnterPdOptSetting$2.INSTANCE);
        f = LazyKt.lazy(MallOptUtil$preBindStrategy$2.INSTANCE);
        g = LazyKt.lazy(MallOptUtil$imagePreFetchDelay$2.INSTANCE);
        h = LazyKt.lazy(MallOptUtil$mallReportOpt$2.INSTANCE);
        i = LazyKt.lazy(MallOptUtil$mallFlingOpt$2.INSTANCE);
        j = LazyKt.lazy(MallOptUtil$delayLoadMoreCheck$2.INSTANCE);
        k = LazyKt.lazy(MallOptUtil$asyncReportEvent$2.INSTANCE);
        l = LazyKt.lazy(MallOptUtil$asyncReportEventBlack$2.INSTANCE);
        m = LazyKt.lazy(MallOptUtil$imagePrefetchThread$2.INSTANCE);
        n = LazyKt.lazy(MallOptUtil$frameDropOpt$2.INSTANCE);
    }

    public static boolean b(String r1) {
        return a(r1, MallOptUtil$frameOptVideoPlay$1.INSTANCE);
    }

    public static boolean c(String r1) {
        return a(r1, MallOptUtil$frameOptWithBg$1.INSTANCE);
    }

    public static boolean a(String r2, Function0 r3) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (d().b() == null) goto L14;
        List<String> r1 = d().b();
        if (r1 == null) goto L14;
        if (r1.contains(r2) != true) goto L14;
        return ((Boolean) r3.invoke()).booleanValue();
    L14:
        return false;
    }

    public static int g(String r6, int r7) {
        if (r6 != null) goto L5;
        return -1;
    L5:
        Integer r1 = f().e();
        if (r1 == null) goto L57;
        int r2 = r1.intValue();
        int r3 = r6.hashCode();
        if (r3 == (-1773284929)) goto L18;
        if (r3 != 556139984) goto L23;
        if (r6.equals(MallPageName.X_TAB_MALL) == false) goto L23;
        if ((r2 & 1) == 1) goto L24;
    L25:
        boolean r8 = false;
    L26:
        if (r8 == true) goto L28;
        return -1;
    L28:
        Integer r9 = f().f();
        if (r9 != null) goto L31;
        return -1;
    L31:
        if (((r9.intValue() >> r7) & 1) != 1) goto L59;
        if (r7 == 0) goto L50;
        if (r7 == 1) goto L46;
        if (r7 != 2) goto L36;
        Integer r10 = f().b();
        if (r10 != null) goto L45;
        return -1;
    L45:
        return r10.intValue();
    L36:
        if (r7 != 3) goto L61;
        Integer r11 = f().d();
        if (r11 != null) goto L41;
        return -1;
    L41:
        return r11.intValue();
    L61:
        return -1;
    L46:
        Integer r12 = f().c();
        if (r12 != null) goto L49;
        return -1;
    L49:
        return r12.intValue();
    L50:
        Integer r13 = f().a();
        if (r13 != null) goto L53;
        return -1;
    L53:
        return r13.intValue();
    L59:
        return -1;
    L24:
        r8 = true;
    L23:
        if (((r2 >> 2) & 1) != 1) goto L25;
    L18:
        if (r6.equals("order_homepage") == false) goto L23;
        if (((r2 >> 1) & 1) != 1) goto L25;
    L57:
        return -1;
    }
}
