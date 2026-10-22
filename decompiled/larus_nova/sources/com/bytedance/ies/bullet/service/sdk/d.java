package com.bytedance.ies.bullet.service.sdk;

import android.net.Uri;
import android.os.Bundle;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ies.bullet.service.schema.SchemaMonitorEvent;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import t36.g;
import t36.h;
import y36.i;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f248124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bundle f248125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f248126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f248127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f248128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f248129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f248130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f248131h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f248132i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f248133j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, Long> f248134k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, String> f248135l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f248136m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, String> f248137n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<String, Integer> f248138o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<String, String> f248139p;

    public static final class a {
    }

    static {
    }

    public final boolean g() {
        if (Intrinsics.areEqual(this.f248127d, "http") == false) goto L5;
        return true;
    L5:
        if (Intrinsics.areEqual(this.f248127d, "https") == true) goto L24;
        String r100 = this.f248128e;
        if (r100 != null) goto L9;
    L11:
        boolean r101 = false;
    L12:
        if (r101 == true) goto L25;
        String r102 = this.f248128e;
        if (r102 != null) goto L16;
    L18:
        boolean r103 = false;
    L19:
        if (r103 == true) goto L26;
        return false;
    L26:
        return true;
    L16:
        if (StringsKt.contains$default(r102, "webview", false, 2, null) != true) goto L18;
        r103 = true;
        goto L19
    L25:
        return true;
    L9:
        if (StringsKt.contains$default(r100, "reactnative", false, 2, null) != true) goto L11;
        r101 = true;
        goto L12
    L24:
        return true;
    }

    @Override // t36.d
    public final String getHost() {
        String r100 = this.f248128e;
        if (r100 == null) goto L8;
        int r101 = StringsKt.indexOf$default(r100, HTTP.URL_DEFAULT, 0, false, 6, null);
        if (r101 != (-1)) goto L10;
        return r100;
    L10:
        return r100.substring(0, r101);
    L8:
        return null;
    }

    @Override // t36.d
    public final Uri getUrl() {
        String r100 = this.f248127d;
        if (r100 == null) goto L18;
        StringBuilder r101 = new StringBuilder();
        r101.append(r100);
        r101.append("://");
        r101.append(this.f248128e);
        boolean r102 = true;
        if ((!this.f248139p.isEmpty()) == false) goto L14;
        r101.append('?');
        Iterator r103 = ((LinkedHashMap) this.f248139p).entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L14;
        Map.Entry r104 = (Map.Entry) r103.next();
        if (r102 == false) goto L12;
        r102 = false;
    L13:
        r101.append((String) r104.getKey());
        r101.append(com.alipay.sdk.m.n.a.f25612h);
        r101.append(Uri.encode((String) r104.getValue()));
        goto L8
    L12:
        r101.append(Typography.amp);
    L14:
        String r105 = this.f248129f;
        if (r105 == null) goto L17;
        r101.append('#');
        r101.append(r105);
    L17:
        Uri r106 = UriProtector.parse(r101.toString());
    L19:
        if (r106 == null) goto L21;
        return r106;
    L21:
        return Uri.EMPTY;
    L18:
        r106 = null;
        goto L19
    }

    public final void l() {
        Intrinsics.checkNotNullParameter("bullet", "scheme");
        this.f248127d = "bullet";
    }

    public final void j() {
        this.f248133j = System.currentTimeMillis();
        if (this.f248135l.isEmpty() == false) goto L6;
        Map<String, String> r100 = null;
    L11:
        this.f248124a.a(SchemaMonitorEvent.CONVERT, this, this.f248131h, r100, this.f248134k);
        ((LinkedHashMap) this.f248135l).clear();
        ((LinkedHashMap) this.f248134k).clear();
        return;
    L6:
        StringBuilder r101 = new StringBuilder();
        StringBuilder r102 = new StringBuilder();
        Iterator r103 = ((LinkedHashMap) this.f248135l).entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        Map.Entry r104 = (Map.Entry) r103.next();
        r101.append((String) r104.getKey());
        r101.append(',');
        r102.append((String) r104.getValue());
        r102.append(',');
        goto L8
    L10:
        r100 = MapsKt.mapOf(new Pair[]{TuplesKt.to("error_converter_names", r101.toString()), TuplesKt.to("error_converter_msg", r102.toString())});
        goto L11
    }

    @Override // t36.d
    public final Bundle B() {
        return this.f248125b;
    }

    @Override // t36.d
    public final long b() {
        return this.f248132i;
    }

    @Override // t36.d
    public final Map<String, String> c() {
        return this.f248139p;
    }

    @Override // t36.d
    public final long d() {
        return this.f248133j;
    }

    @Override // t36.d
    public final Uri getOriginUrl() {
        return this.f248126c;
    }

    public final void e(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        Bundle r101 = this.f248125b;
        if (r101 != null) goto L5;
        this.f248125b = r100;
        return;
    L5:
        if (r101 == null) goto L9;
        r101.putAll(r100);
        return;
    }

    public final void f(String r110) {
        Intrinsics.checkNotNullParameter(r110, "name");
        long r100 = System.currentTimeMillis() - this.f248136m;
        Map<String, String> r101 = MapsKt.plus(this.f248131h, MapsKt.mapOf(TuplesKt.to("model_name", r110)));
        if (this.f248137n.isEmpty() == false) goto L6;
        Map<String, String> r111 = null;
    L5:
        Map<String, String> r102 = r111;
        if (this.f248130g == true) goto L14;
        this.f248124a.a(SchemaMonitorEvent.GENERATE, this, r101, r102, MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(r100))));
    L14:
        ((LinkedHashMap) this.f248137n).clear();
        return;
    L6:
        StringBuilder r112 = new StringBuilder();
        StringBuilder r103 = new StringBuilder();
        Iterator r104 = ((LinkedHashMap) this.f248137n).entrySet().iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        Map.Entry r105 = (Map.Entry) r104.next();
        r112.append((String) r105.getKey());
        r112.append(',');
        r103.append((String) r105.getValue());
        r103.append(',');
        goto L8
    L10:
        r111 = MapsKt.mapOf(new Pair[]{TuplesKt.to("error_param_names", r112.toString()), TuplesKt.to("error_param_msg", r103.toString())});
        goto L5
    }

    public final void h(boolean r100) {
        this.f248134k.put("parse_duration", Long.valueOf(System.currentTimeMillis() - this.f248132i));
        if (r100 == false) goto L6;
        this.f248135l.put("parse_error", "invalid url");
        j();
        return;
    }

    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f248139p.remove(r100);
    }

    public final void k(Uri r110) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        String r100 = r110.toString();
        int r101 = StringsKt.indexOf$default(r100, '?', 0, false, 6, null);
        if (r101 != (-1)) goto L5;
        return;
    L5:
        int r111 = r101 + 1;
        int r102 = StringsKt.indexOf$default(r100, '#', r111, false, 4, null);
        if (r102 != (-1)) goto L8;
        String r103 = r100.substring(r111, r100.length());
    L9:
        Iterator r104 = StringsKt.split$default(r103, new char[]{Typography.amp}, false, 0, 6, null).iterator();
    L11:
        if (r104.hasNext() == false) goto L20;
        List r105 = StringsKt.split$default((String) r104.next(), new char[]{com.alipay.sdk.m.n.a.f25612h}, false, 0, 6, null);
        if (r105.size() != 2) goto L11;
        String r106 = Uri.decode((String) ListProtector.get(r105, 0));
        String r107 = Uri.decode((String) ListProtector.get(r105, 1));
        if (r106 == null) goto L11;
        if (r107 == null) goto L11;
        if (((LinkedHashMap) this.f248139p).get(r106) != null) goto L11;
        this.f248139p.put(r106, r107);
        goto L11
    L20:
        return;
    L8:
        r103 = r100.substring(r111, r102);
        goto L9
    }

    public d(Uri r100, g r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "schemaMonitor");
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "schemaMonitor");
        this.f248124a = r101;
        this.f248126c = r100;
        this.f248131h = MapsKt.mapOf(TuplesKt.to("schema", r100.toString()));
        this.f248134k = new LinkedHashMap();
        this.f248135l = new LinkedHashMap();
        this.f248137n = new LinkedHashMap();
        this.f248138o = new LinkedHashMap();
        this.f248139p = new LinkedHashMap();
        this.f248130g = r102;
    }

    @Override // t36.h
    public final void a(String r100, i r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (r102 == false) goto L5;
    L6:
        this.f248139p.put(r100, r101.a());
        return;
    L5:
        if (((LinkedHashMap) this.f248139p).get(r100) == null) goto L6;
    }
}
