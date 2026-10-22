package f2a;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larus.utils.logger.FLogger;
import com.larus.utils.logger.LogLevel;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f475228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LogLevel f475229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f475230c;

    public static String g(String r110) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r110, "<", "", false, 4, null), ">", "", false, 4, null), "\"", "\\\"", false, 4, null);
    }

    public final void a(List r100) {
        this.f475230c.f475254b = r100;
    }

    public final void d(Map r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        g r101 = this.f475230c;
        Map<f, Object> r102 = r101.f475259g;
        if (r102 != null) goto L7;
        r101.f475259g = new HashMap(r100);
        return;
    L7:
        Intrinsics.checkNotNull(r102);
        r102.putAll(r100);
    }

    public final void e(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        LinkedHashMap r101 = new LinkedHashMap();
        r100.invoke(r101);
        d(r101);
    }

    public final void f(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        LinkedHashMap r101 = new LinkedHashMap();
        r100.invoke(r101);
        ArrayList r102 = new ArrayList(r101.size());
        Iterator r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.add(TuplesKt.to(new f((String) r104.getKey()), r104.getValue()));
        goto L4
    L6:
        d(MapsKt.toMap(r102));
    }

    public c(h r100, LogLevel r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        Intrinsics.checkNotNullParameter(r101, "level");
        Intrinsics.checkNotNullParameter(r102, "what");
        this.f475228a = r100;
        this.f475229b = r101;
        this.f475230c = new g(r102);
    }

    public static /* synthetic */ void c(c r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        String r103 = "";
    L7:
        if ((r102 & 2) == 0) goto L9;
        r101 = "";
    L9:
        int r104 = 0;
        if ((r102 & 4) == 0) goto L12;
        int r105 = -1;
    L14:
        if ((r102 & 8) == 0) goto L16;
        r104 = 4;
    L16:
        r100.b(r103, r101, r105, r104);
        return;
    L12:
        r105 = 0;
        goto L14
    L5:
        r103 = null;
        goto L7
    }

    public final void b(String r210, String r211, int r212, int r213) {
        Intrinsics.checkNotNullParameter(r210, "file");
        Intrinsics.checkNotNullParameter(r211, "function");
        StackTraceElement[] r100 = ThreadMethodProxy.currentThread().getStackTrace();
        if (r100.length < (r213 + 1)) goto L5;
        StackTraceElement r101 = r100[r213];
    L6:
        if (r101 == null) goto L11;
        String r102 = r101.getFileName();
        if (r102 == null) goto L11;
        String r103 = r102;
    L12:
        if (r101 == null) goto L15;
        String r104 = r101.getMethodName();
        if (r104 == null) goto L15;
    L16:
        if (r101 == null) goto L18;
        int r105 = r101.getLineNumber();
    L19:
        g r106 = this.f475230c;
        ArrayList r110 = new ArrayList();
        r110.add("<What=" + g(r106.f475253a) + Typography.greater);
        Map<f, Object> r107 = r106.f475259g;
        if (r107 != null) goto L22;
    L38:
        String r108 = r106.f475257e;
        if (r108 == null) goto L41;
        r110.add("<Who=" + g(r108) + Typography.greater);
    L41:
        String r109 = r106.f475256d;
        if (r109 == null) goto L44;
        r110.add("<Where=" + g(r109) + Typography.greater);
    L44:
        String r111 = r106.f475255c;
        if (r111 == null) goto L47;
        r110.add("<EventType=" + g(r111) + Typography.greater);
    L47:
        List<String> r112 = r106.f475254b;
        if (r112 == null) goto L56;
        if ((!r112.isEmpty()) == true) goto L53;
        r112 = null;
    L53:
        if (r112 == null) goto L56;
        r110.add("<LinkID=" + CollectionsKt.joinToString$default(r112, ",", null, null, 0, null, new b(this), 30, null) + Typography.greater);
    L56:
        String r113 = r106.f475258f;
        if (r113 == null) goto L59;
        r110.add("<Source=" + g(r113) + Typography.greater);
    L59:
        String r114 = CollectionsKt.joinToString$default(r110, "", null, null, 0, null, null, 62, null);
        h r115 = this.f475228a;
        LogLevel r116 = this.f475229b;
        r115.getClass();
        Intrinsics.checkNotNullParameter(r116, "level");
        Intrinsics.checkNotNullParameter(r114, "content");
        Intrinsics.checkNotNullParameter(r103, "file");
        Intrinsics.checkNotNullParameter(r104, "function");
        String r117 = r114 + " [" + (((String) CollectionsKt.last(StringsKt.split$default(r103, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null))) + ',' + r104 + ',' + r105) + ']';
        int r118 = h.a.f475261a[r116.ordinal()];
        if (r118 != 1) goto L62;
        FLogger.f375446a.d(r115.f475260a, r117);
        return;
    L62:
        if (r118 != 2) goto L64;
        FLogger.f375446a.i(r115.f475260a, r117);
        return;
    L64:
        if (r118 != 3) goto L66;
        FLogger.f375446a.w(r115.f475260a, r117);
        return;
    L66:
        if (r118 != 4) goto L69;
        FLogger.f375446a.e(r115.f475260a, r117);
        return;
    L69:
        throw new NoWhenBranchMatchedException();
    L22:
        if ((!r107.isEmpty()) == true) goto L25;
        r107 = null;
    L25:
        if (r107 == null) goto L38;
        StringBuilder r119 = new StringBuilder("<Params=");
        ArrayList r120 = new ArrayList(r107.size());
        Iterator<Map.Entry<f, Object>> r121 = r107.entrySet().iterator();
    L28:
        if (r121.hasNext() == false) goto L37;
        Map.Entry<f, Object> r122 = r121.next();
        f r123 = r122.getKey();
        Object r124 = r122.getValue();
        String r125 = "\"" + g(r123.f475252a) + Typography.quote;
        if ((r124 instanceof String) == false) goto L33;
        String r126 = "\"" + g((String) r124) + Typography.quote;
    L36:
        r120.add(r125 + ':' + r126);
        goto L28
    L33:
        if ((r124 instanceof Number) == false) goto L35;
        r126 = r124.toString();
        goto L36
    L35:
        r126 = "\"" + g(r124.toString()) + Typography.quote;
        goto L36
    L37:
        r119.append("{" + CollectionsKt.joinToString$default(r120, ",", null, null, 0, null, null, 62, null) + '}');
        r119.append(Typography.greater);
        r110.add(r119.toString());
        goto L38
    L18:
        r105 = r212;
    L15:
        r104 = r211;
    L11:
        r103 = r210;
        goto L12
    L5:
        r101 = null;
        goto L6
    }
}
