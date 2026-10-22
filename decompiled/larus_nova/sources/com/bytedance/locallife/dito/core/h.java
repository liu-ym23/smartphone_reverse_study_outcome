package com.bytedance.locallife.dito.core;

import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Pair<String, Object>> f257920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Pair<String, Object>> f257921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Pair<String, Object>> f257922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Pair<String, Object>> f257923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Pair<String, Object>> f257924e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f257925f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f257926g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f257927h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f257928i;

    public h() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f257920a, r101.f257920a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f257921b, r101.f257921b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f257922c, r101.f257922c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f257923d, r101.f257923d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f257924e, r101.f257924e) == true) goto L24;
        return false;
    L24:
        if (this.f257925f == r101.f257925f) goto L27;
        return false;
    L27:
        if (this.f257926g == r101.f257926g) goto L30;
        return false;
    L30:
        if (this.f257927h == r101.f257927h) goto L33;
        return false;
    L33:
        if (this.f257928i == r101.f257928i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f257920a.hashCode() * 31) + this.f257921b.hashCode()) * 31) + this.f257922c.hashCode()) * 31) + this.f257923d.hashCode()) * 31) + this.f257924e.hashCode()) * 31;
        int r101 = 1231;
        if (this.f257925f == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f257926g == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f257927h == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f257928i == true) goto L19;
        r101 = 1237;
    L19:
        return r107 + r101;
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "DitoFinalUIConfig(headerViewList=" + this.f257920a + ", footerViewList=" + this.f257921b + ", floatViewList=" + this.f257922c + ", bodyViewList=" + this.f257923d + ", backgroundViewList=" + this.f257924e + ", defaultFooterFloat=" + this.f257925f + ", defaultHeaderFloat=" + this.f257926g + ", footerAddDecorView=" + this.f257927h + ", headerAddDecorView=" + this.f257928i + ')';
    }

    public h(Object r100) {
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        ArrayList r105 = new ArrayList();
        Intrinsics.checkNotNullParameter(r101, "headerViewList");
        Intrinsics.checkNotNullParameter(r102, "footerViewList");
        Intrinsics.checkNotNullParameter(r103, "floatViewList");
        Intrinsics.checkNotNullParameter(r104, "bodyViewList");
        Intrinsics.checkNotNullParameter(r105, "backgroundViewList");
        this.f257920a = r101;
        this.f257921b = r102;
        this.f257922c = r103;
        this.f257923d = r104;
        this.f257924e = r105;
        this.f257925f = false;
        this.f257926g = false;
        this.f257927h = false;
        this.f257928i = false;
    }
}
