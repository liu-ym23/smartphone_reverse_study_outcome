package com.bytedance.ies.bullet.service.sdk;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t36.g;

/* JADX INFO: loaded from: classes19.dex */
public final class SchemaService {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy<SchemaService> f248116f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ies.bullet.service.sdk.a f248117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f248118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, b> f248119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Uri, c> f248120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<Uri, t36.d> f248121e;

    public static final class a {
        public static SchemaService a() {
            return SchemaService.f248116f.getValue();
        }
    }

    static {
        f248116f = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, SchemaService$Companion$instance$2.INSTANCE);
    }

    public SchemaService() {
        this.f248117a = new com.bytedance.ies.bullet.service.sdk.a();
        this.f248118b = new f();
        this.f248119c = new LinkedHashMap();
        this.f248120d = new LinkedHashMap();
        this.f248121e = new ConcurrentHashMap();
    }

    public static t36.f d(t36.d r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, "schemaData");
        Intrinsics.checkNotNullParameter(r101, "type");
        if (t36.f.class.isAssignableFrom(r101) == true) goto L9;
    L6:
        return null;
    L9:
        d r102 = (d) r100;     // Catch: Exception -> L8
        r102.getClass();     // Catch: Exception -> L8
        r102.f248136m = System.currentTimeMillis();     // Catch: Exception -> L8
        t36.f r103 = (t36.f) r101.newInstance();     // Catch: Exception -> L8
        r103.a(r100);     // Catch: Exception -> L8
        r102.f(r101.getSimpleName());     // Catch: Exception -> L8
        return r103;
    }

    public final void a(Uri r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "schemaConfig");
        if (Intrinsics.areEqual(r100, Uri.EMPTY) == false) goto L5;
        return;
    L5:
        c r102 = (c) ((LinkedHashMap) this.f248120d).get(r100);
        if (r102 == null) goto L8;
        List<t36.e> r103 = r101.f248123a;
        Intrinsics.checkNotNullParameter(r103, "interceptors");
        ((ArrayList) r102.f248123a).addAll(r103);
        return;
    L8:
        this.f248120d.put(r100, r101);
    }

    public final d b(String r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r101, "url");
        return c(r100, r101, false);
    }

    public final d c(String r110, Uri r111, boolean r210) {
        Intrinsics.checkNotNullParameter(r111, "url");
        if (Intrinsics.areEqual(r111, Uri.EMPTY) == true) goto L5;
        ArrayList r100 = new ArrayList();
        c r101 = this.f248120d.remove(r111);
        if (r101 == null) goto L9;
        r100.addAll(r101.f248123a);
    L9:
        if (r110 == null) goto L15;
        b r102 = (b) ((LinkedHashMap) this.f248119c).get(r110);
        if (r102 != null) goto L13;
        r102 = (b) ((LinkedHashMap) this.f248119c).get("default_bid");
    L13:
        if (r102 == null) goto L15;
        g r103 = r102.f248122b;
        r100.addAll(r102.f248123a);
    L16:
        f r104 = this.f248118b;
        if (r103 != null) goto L19;
        r103 = this.f248117a;
    L19:
        r104.getClass();
        Intrinsics.checkNotNullParameter(r111, "url");
        Intrinsics.checkNotNullParameter(r100, "interceptors");
        Intrinsics.checkNotNullParameter(r103, "schemaMonitor");
        d r105 = new d(r111, r103, r210);
        r105.f248132i = System.currentTimeMillis();
        String r106 = r111.toString();
        int r107 = StringsKt.indexOf$default(r106, "://", 0, false, 6, null);
        if (r107 != (-1)) goto L22;
        r105.h(true);
        Intrinsics.checkNotNullParameter("invalid url", "message");
        r105.f248124a.log("invalid url");
    L42:
        return r105;
    L22:
        int r112 = r106.length();
        r105.f248127d = r106.substring(0, r107);
        int r108 = r107 + 3;
        int r109 = StringsKt.indexOf$default(r106, '?', r108, false, 4, null);
        if (r109 != (-1)) goto L25;
        r105.f248128e = r106.substring(r108, r112);
        String r113 = null;
    L29:
        if (r113 == null) goto L31;
        f.a(r113, r105, 0);
    L31:
        r105.h(false);
        Iterator r114 = r100.iterator();
    L33:
        if (r114.hasNext() == false) goto L40;
        t36.e r115 = (t36.e) r114.next();
        String r116 = r115.getName();
        Intrinsics.checkNotNullParameter(r116, "name");
        r105.f248134k.put(r116, Long.valueOf(System.currentTimeMillis()));
        boolean r117 = r115.b(r105);
        String r118 = r115.getName();
        Intrinsics.checkNotNullParameter(r118, "name");
        Long r119 = (Long) ((LinkedHashMap) r105.f248134k).get(r118);
        if (r119 == null) goto L37;
        r105.f248134k.put(r118, Long.valueOf(System.currentTimeMillis() - r119.longValue()));
    L37:
        if (r117 == true) goto L33;
        String r120 = r115.getName();
        r115.a();
        Intrinsics.checkNotNullParameter(r120, "name");
        Intrinsics.checkNotNullParameter("No Error", "message");
        r105.f248135l.put(r120, "No Error");
        r115.a();
        String r121 = r115.getName() + ":No Error";
        Intrinsics.checkNotNullParameter(r121, "message");
        r105.f248124a.log(r121);
        goto L33
    L40:
        if (r105.f248130g == true) goto L42;
        r105.j();
        goto L42
    L25:
        r105.f248128e = r106.substring(r108, r109);
        int r122 = r109 + 1;
        int r123 = StringsKt.indexOf$default(r106, '#', r122, false, 4, null);
        if (r123 != (-1)) goto L28;
        r113 = r106.substring(r122, r112);
        goto L29
    L28:
        String r124 = r106.substring(r122, r123);
        r105.f248129f = r106.substring(r123 + 1, r112);
        r113 = r124;
    L15:
        r103 = null;
        goto L16
    L5:
        return new d(r111, this.f248117a, r210);
    }
}
