package com.larus.office.plugins.slides.media;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SelectedImageModel f363268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<JsonObject, Unit> f363269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<JSONObject, Unit> f363270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f363271d;

    public a() {
        this(null, null, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f363268a, r101.f363268a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f363269b, r101.f363269b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f363270c, r101.f363270c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f363271d, r101.f363271d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        SelectedImageModel r100 = this.f363268a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function1<JsonObject, Unit> r104 = this.f363269b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Function1<JSONObject, Unit> r107 = this.f363270c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Function0<Unit> r110 = this.f363271d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SelectLocalImage(selectedImageModel=" + this.f363268a + ", callbackFunctionProxy=" + this.f363269b + ", callbackFunctionProxyV2=" + this.f363270c + ", hideSelectCallback=" + this.f363271d + ')';
    }

    public a(SelectedImageModel r100, w r101, x r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 8) == 0) goto L11;
        r102 = null;
    L11:
        this.f363268a = r100;
        this.f363269b = null;
        this.f363270c = r101;
        this.f363271d = r102;
    }
}
