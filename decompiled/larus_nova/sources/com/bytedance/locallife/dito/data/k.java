package com.bytedance.locallife.dito.data;

import com.bytedance.android.service.manager.pull.PullConfiguration;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f258208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f258209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f258210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f258211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f258212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f258213f;

    public static final class a {
    }

    static {
    }

    public k() {
        this(null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f258208a, r101.f258208a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f258209b, r101.f258209b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f258210c, r101.f258210c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f258211d, r101.f258211d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f258212e, r101.f258212e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f258208a.hashCode() * 31) + this.f258209b.hashCode()) * 31) + this.f258210c.hashCode()) * 31) + this.f258211d.hashCode()) * 31) + this.f258212e.hashCode();
    }

    public final String toString() {
        return "DitoRequestParams(scene=" + this.f258208a + ", bizParams=" + this.f258209b + ", ditoParams=" + this.f258210c + ", apiParams=" + this.f258211d + ", otherParams=" + this.f258212e + ')';
    }

    public k(Map r100, int r101) {
        LinkedHashMap r102 = null;
        if ((r101 & 1) == 0) goto L5;
        String r103 = "";
    L7:
        if ((r101 & 2) == 0) goto L10;
        r100 = new LinkedHashMap();
    L10:
        if ((r101 & 4) == 0) goto L12;
        LinkedHashMap r104 = new LinkedHashMap();
    L14:
        if ((r101 & 8) == 0) goto L16;
        LinkedHashMap r105 = new LinkedHashMap();
    L18:
        if ((r101 & 16) == 0) goto L20;
        r102 = new LinkedHashMap();
    L20:
        Intrinsics.checkNotNullParameter(r103, "scene");
        Intrinsics.checkNotNullParameter(r100, "bizParams");
        Intrinsics.checkNotNullParameter(r104, "ditoParams");
        Intrinsics.checkNotNullParameter(r105, "apiParams");
        Intrinsics.checkNotNullParameter(r102, "otherParams");
        this.f258208a = r103;
        this.f258209b = r100;
        this.f258210c = r104;
        this.f258211d = r105;
        this.f258212e = r102;
        r104.put("service_type", PullConfiguration.PROCESS_NAME_MAIN);
        this.f258213f = PullConfiguration.PROCESS_NAME_MAIN;
        return;
    L16:
        r105 = null;
        goto L18
    L12:
        r104 = null;
        goto L14
    L5:
        r103 = null;
        goto L7
    }
}
