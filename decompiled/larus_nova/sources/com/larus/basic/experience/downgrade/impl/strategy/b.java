package com.larus.basic.experience.downgrade.impl.strategy;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f294853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<T> f294854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f294855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f294856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JSONObject f294857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f294858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.larus.network.http.a<T> f294859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f294860h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f294853a, r101.f294853a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f294854b, r101.f294854b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f294855c, r101.f294855c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f294856d, r101.f294856d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f294857e, r101.f294857e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f294858f, r101.f294858f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f294859g, r101.f294859g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f294860h, r101.f294860h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f294853a.hashCode() * 31) + this.f294854b.hashCode()) * 31) + this.f294855c.hashCode()) * 31;
        Map<String, String> r101 = this.f294856d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        JSONObject r105 = this.f294857e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Map<String, String> r108 = this.f294858f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        com.larus.network.http.a<T> r111 = this.f294859g;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Map<String, String> r114 = this.f294860h;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DowngradeContext(path=" + this.f294853a + ", outClazz=" + this.f294854b + ", headerMap=" + this.f294855c + ", extra=" + this.f294856d + ", bodyJson=" + this.f294857e + ", queryMap=" + this.f294858f + ", resp=" + this.f294859g + ", logExtra=" + this.f294860h + ')';
    }

    public static b a(b r110, Map r111, com.larus.network.http.a r112, int r113) {
        Map<String, String> r100 = null;
        if ((r113 & 1) == 0) goto L5;
        String r101 = r110.f294853a;
    L7:
        if ((r113 & 2) == 0) goto L9;
        Class<T> r102 = r110.f294854b;
    L11:
        if ((r113 & 4) == 0) goto L13;
        r111 = r110.f294855c;
    L13:
        Map r103 = r111;
        if ((r113 & 8) == 0) goto L16;
        Map<String, String> r104 = r110.f294856d;
    L18:
        if ((r113 & 16) == 0) goto L20;
        JSONObject r105 = r110.f294857e;
    L22:
        if ((r113 & 32) == 0) goto L24;
        Map<String, String> r106 = r110.f294858f;
    L26:
        if ((r113 & 64) == 0) goto L28;
        r112 = r110.f294859g;
    L28:
        com.larus.network.http.a r107 = r112;
        if ((r113 & 128) == 0) goto L31;
        r100 = r110.f294860h;
    L31:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "path");
        Intrinsics.checkNotNullParameter(r102, "outClazz");
        Intrinsics.checkNotNullParameter(r103, "headerMap");
        return new b(r101, r102, r103, r104, r105, r106, r107, r100);
    L24:
        r106 = null;
        goto L26
    L20:
        r105 = null;
        goto L22
    L16:
        r104 = null;
        goto L18
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(String r100, Class<T> r101, Map<String, String> r102, Map<String, String> r103, JSONObject r104, Map<String, String> r105, com.larus.network.http.a<? extends T> r106, Map<String, String> r107) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "outClazz");
        Intrinsics.checkNotNullParameter(r102, "headerMap");
        this.f294853a = r100;
        this.f294854b = r101;
        this.f294855c = r102;
        this.f294856d = r103;
        this.f294857e = r104;
        this.f294858f = r105;
        this.f294859g = r106;
        this.f294860h = r107;
    }
}
