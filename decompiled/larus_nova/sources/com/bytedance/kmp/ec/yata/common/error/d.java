package com.bytedance.kmp.ec.yata.common.error;

import com.alipay.sdk.m.u.i;
import com.bytedance.kmp.ec.yata.common.init.PackYataSdkConfig;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.bytedance.kmp.ec.yata.common.patch.BasePatch;
import com.bytedance.kmp.ec.yata.common.patch.BasePatchException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f251398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f251399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f251400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f251401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f251402e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f251403f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f251404g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f251405h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f251406i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f251407j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f251408k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, String> f251409l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, Object> f251410m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f251411n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f251412o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f251413p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f251414q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f251415r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f251416s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Throwable f251417t;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f251398a == r101.f251398a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f251399b, r101.f251399b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f251398a * 31) + this.f251399b.hashCode();
    }

    public final String toString() {
        return "YataErrorCodeModel(code=" + this.f251398a + ", message=" + this.f251399b + ')';
    }

    @Deprecated(message = "SDK内部API")
    public final void e() {
        this.f251416s = "p0";
        this.f251409l.put("error_level", "p0");
    }

    @Deprecated(message = "有业务在使用，业务在额外上报")
    public final Map<String, Object> f() {
        Map<String, Object> r100 = this.f251410m;
        Pair[] r101 = new Pair[14];
        r101[0] = TuplesKt.to("code", Integer.valueOf(this.f251398a));
        r101[1] = TuplesKt.to("message", this.f251399b);
        r101[2] = TuplesKt.to("trigger_source", this.f251402e);
        r101[3] = TuplesKt.to("trigger", this.f251400c);
        r101[4] = TuplesKt.to("origin_trigger", this.f251401d);
        r101[5] = TuplesKt.to("event_type", this.f251403f);
        r101[6] = TuplesKt.to("node_name", this.f251404g);
        r101[7] = TuplesKt.to("node_key", this.f251405h);
        r101[8] = TuplesKt.to("detail", this.f251406i);
        r101[9] = TuplesKt.to("origin_detail", this.f251407j);
        PackYataSdkConfig r102 = com.bytedance.kmp.ec.yata.common.init.b.f251424a;
        r101[10] = TuplesKt.to("yata_version", "1.23.7");
        r101[11] = TuplesKt.to("error_trace", this.f251408k);
        r101[12] = TuplesKt.to("error_level", this.f251416s);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(a(this.f251409l));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r104) == false) goto L10;
        r104 = null;
    L10:
        String r105 = (String) r104;
        if (r105 != null) goto L13;
        r105 = "";
    L13:
        r101[13] = TuplesKt.to("params", r105);
        return MapsKt.plus(r100, MapsKt.mapOf(r101));
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static String a(Map r100) {
        StringBuilder r101 = new StringBuilder("{");
        Iterator r102 = ((LinkedHashMap) r100).entrySet().iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L12;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        Map.Entry r106 = (Map.Entry) r104;
        String r107 = (String) r106.getKey();
        String r108 = (String) r106.getValue();
        if (r103 <= 0) goto L11;
        r101.append(",");
    L11:
        r101.append("\"" + b(r107) + "\":\"" + b(r108) + Typography.quote);
        r103 = r105;
        goto L4
    L12:
        r101.append(i.f25855d);
        return r101.toString();
    }

    public static final String b(String r100) {
        StringBuilder r101 = new StringBuilder(r100.length());
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L32;
        char r104 = r100.charAt(r103);
        if (r104 != '\"') goto L8;
        r101.append("\\\"");
    L30:
        r103 = r103 + 1;
        goto L3
    L8:
        if (r104 != '\\') goto L11;
        r101.append("\\\\");
        goto L30
    L11:
        if (r104 != '\b') goto L14;
        r101.append("\\b");
        goto L30
    L14:
        if (r104 != '\n') goto L17;
        r101.append("\\n");
        goto L30
    L17:
        if (r104 != '\r') goto L20;
        r101.append("\\r");
        goto L30
    L20:
        if (r104 != '\t') goto L22;
        r101.append("\\t");
        goto L30
    L22:
        if (r104 >= 0) goto L24;
    L26:
        boolean r105 = false;
    L27:
        if (r105 == false) goto L29;
        r101.append("\\u");
        r101.append(StringsKt.padStart(Integer.toString(r104, CharsKt.checkRadix(16)), 4, '0').toUpperCase(Locale.ROOT));
        goto L30
    L29:
        r101.append(r104);
        goto L30
    L24:
        if (r104 >= ' ') goto L26;
        r105 = true;
        goto L27
    L32:
        return r101.toString();
    }

    @Deprecated(message = "SDK内部API")
    public final void c(String r110) {
        Intrinsics.checkNotNullParameter(r110, "input");
        String r100 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.trim(r110).toString(), " ", "_", false, 4, null), "\n", "_", false, 4, null);
        if (r100.length() <= 255) goto L5;
    L6:
        r100 = "NotMatchMetricsStandard";
    L7:
        this.f251406i = r100;
        this.f251407j = r110;
        this.f251409l.put("origin_detail", r110);
        return;
    L5:
        if (new Regex("^[aa-zA-Z0-9-._/:%]+$").matches(r100) == true) goto L7;
        goto L6
    }

    @Deprecated(message = "SDK内部API")
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "warningMsg");
        this.f251411n = true;
        this.f251412o = r100;
    }

    @Deprecated(message = "SDK内部API")
    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "startSource");
        this.f251402e = r100;
        m("chain_start_source", r100);
        m("trigger_start_source", r100);
    }

    @Deprecated(message = "SDK内部API")
    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        m("error_msg", r100);
    }

    @Deprecated(message = "SDK内部API")
    public final void i(Throwable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f251417t = r100;
        String r101 = r100.getMessage();
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        this.f251408k = r101;
        String r102 = YaTaLog.f251436a;
        YaTaLog.e("YataErrorCodeModel", new YataErrorCodeModel$withException$1(this));
        m(com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName() + ' ' + r100.getMessage());
    }

    @Deprecated(message = "SDK内部API")
    public final void j(y96.c r100) {
        Intrinsics.checkNotNullParameter(r100, "exprResult");
        if (r100.f566979a == false) goto L6;
        this.f251409l.put("expr_code", String.valueOf(r100.f566984f));
        this.f251409l.put("origin_expr", r100.f566980b);
        this.f251409l.put("error_expr", String.valueOf(r100.f566982d));
        i(r100.f566983e);
        return;
    }

    @Deprecated(message = "SDK内部API")
    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeKey");
        if (StringsKt.isBlank(r100) == false) goto L5;
    L7:
        m("key", r100);
        return;
    L5:
        if (Intrinsics.areEqual(r100, "null") == true) goto L7;
        this.f251405h = r100;
        goto L7
    }

    @Deprecated(message = "SDK内部API")
    public final void l(String r100) {
        this.f251404g = String.valueOf(r100);
        this.f251409l.put("name", String.valueOf(r100));
    }

    @Deprecated(message = "SDK内部API")
    public final void n(BasePatch.a r100) {
        Intrinsics.checkNotNullParameter(r100, "patchResult");
        Map<String, Object> r101 = r100.f251448e;
        Map<String, String> r102 = this.f251409l;
        Object r103 = null;
        if (r101 == null) goto L5;
        Object r104 = r101.get("op");
    L6:
        r102.put("op", String.valueOf(r104));
        Map<String, String> r105 = this.f251409l;
        if (r101 == null) goto L9;
        Object r106 = r101.get("from");
    L10:
        r105.put("from", String.valueOf(r106));
        Map<String, String> r107 = this.f251409l;
        if (r101 == null) goto L13;
        r103 = r101.get("path");
    L13:
        r107.put("path", String.valueOf(r103));
        Throwable r108 = r100.f251446c;
        if ((r108 instanceof BasePatchException) == true) goto L17;
        i(r108);
        return;
    L17:
        return;
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    @Deprecated(message = "SDK内部API")
    public final void o(String r110) {
        String r100 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.trim(String.valueOf(r110)).toString(), " ", "_", false, 4, null), "\n", "_", false, 4, null);
        if (r100.length() <= 255) goto L5;
    L8:
        String r101 = "NotMatchMetricsStandard";
    L9:
        this.f251400c = r101;
        this.f251401d = String.valueOf(r110);
        this.f251409l.put("trigger", String.valueOf(r110));
        return;
    L5:
        if (new Regex("^[aa-zA-Z0-9-._/:%]+$").matches(r100) == false) goto L8;
        r101 = new Regex("\\d+").replace(r100, "0");
        goto L9
    }

    public d(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        this.f251398a = r100;
        this.f251399b = r101;
        this.f251400c = "";
        this.f251401d = "";
        this.f251402e = "";
        this.f251403f = "";
        this.f251404g = "";
        this.f251405h = "";
        this.f251406i = "";
        this.f251407j = "";
        this.f251408k = "";
        this.f251409l = new LinkedHashMap();
        this.f251410m = new LinkedHashMap();
        this.f251412o = "";
        this.f251416s = "p1";
    }

    @Deprecated(message = "SDK内部API")
    public final void m(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f251409l.put(r100, String.valueOf(r101));
    }
}
