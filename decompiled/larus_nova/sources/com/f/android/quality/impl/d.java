package com.f.android.quality.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f274091g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f274092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f274093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f274094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f274095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f274096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f274097f;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L14;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f274094c, r101.f274094c) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f274095d, r101.f274095d) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f274096e, r101.f274096e) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f274097f, r101.f274097f) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f274094c;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f274095d;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f274096e;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f274097f;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ReportBean(event=" + this.f274094c + ", bizType=" + this.f274095d + ", majorName=" + this.f274096e + ", minorName=" + this.f274097f + ")";
    }

    public final void a(Integer r100, String r101) {
        if (r100 == null) goto L4;
        int r102 = r100.intValue();
        this.f274093b.put("err_no", Integer.valueOf(r102));
    L4:
        if (r101 == null) goto L7;
        this.f274093b.put("err_tips", r101);
        return;
    }

    public d(String r100, String r101, String r102, String r103) {
        this.f274094c = r100;
        this.f274095d = r101;
        this.f274096e = r102;
        this.f274097f = r103;
        this.f274092a = new LinkedHashMap();
        this.f274093b = new LinkedHashMap();
    }
}
