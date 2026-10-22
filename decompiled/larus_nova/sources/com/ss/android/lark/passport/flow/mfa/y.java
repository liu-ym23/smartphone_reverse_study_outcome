package com.ss.android.lark.passport.flow.mfa;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlowVerifyFactor f437927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f437928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f437929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f437930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f437931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f437932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f437933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f437934h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f437935i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FlowStep f437936j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final x f437937k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final JSONObject f437938l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (this.f437927a == r101.f437927a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f437928b, r101.f437928b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f437929c, r101.f437929c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f437930d, r101.f437930d) == true) goto L21;
        return false;
    L21:
        if (this.f437931e == r101.f437931e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f437932f, r101.f437932f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f437933g, r101.f437933g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f437934h, r101.f437934h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f437935i, r101.f437935i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f437936j, r101.f437936j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f437937k, r101.f437937k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f437938l, r101.f437938l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f437927a.hashCode() * 31) + this.f437928b.hashCode()) * 31) + this.f437929c.hashCode()) * 31) + this.f437930d.hashCode()) * 31;
        if (this.f437931e == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        String r103 = this.f437932f;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((((r102 + r105) * 31) + this.f437933g.hashCode()) * 31) + this.f437934h.hashCode()) * 31) + this.f437935i.hashCode()) * 31;
        FlowStep r107 = this.f437936j;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        x r110 = this.f437937k;
        if (r110 == null) goto L19;
        r104 = r110.hashCode();
    L19:
        return ((r109 + r104) * 31) + this.f437938l.hashCode();
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowVerifyFactorData(factor=" + this.f437927a + ", title=" + this.f437928b + ", subtitle=" + this.f437929c + ", flowType=" + this.f437930d + ", disabled=" + this.f437931e + ", disabledToastText=" + this.f437932f + ", inputPlaceholder=" + this.f437933g + ", inputLabel=" + this.f437934h + ", buttonText=" + this.f437935i + ", nextButtonStep=" + this.f437936j + ", rsaInfo=" + this.f437937k + ", raw=" + this.f437938l + ')';
    }

    public y(FlowVerifyFactor r100, String r101, String r102, String r103, boolean r104, String r105, String r106, String r107, String r110, FlowStep r111, x r112, JSONObject r113) {
        Intrinsics.checkNotNullParameter(r100, "factor");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "subtitle");
        Intrinsics.checkNotNullParameter(r103, "flowType");
        Intrinsics.checkNotNullParameter(r106, "inputPlaceholder");
        Intrinsics.checkNotNullParameter(r107, "inputLabel");
        Intrinsics.checkNotNullParameter(r110, "buttonText");
        Intrinsics.checkNotNullParameter(r113, TemplateNodeType.RAW);
        this.f437927a = r100;
        this.f437928b = r101;
        this.f437929c = r102;
        this.f437930d = r103;
        this.f437931e = r104;
        this.f437932f = r105;
        this.f437933g = r106;
        this.f437934h = r107;
        this.f437935i = r110;
        this.f437936j = r111;
        this.f437937k = r112;
        this.f437938l = r113;
    }
}
