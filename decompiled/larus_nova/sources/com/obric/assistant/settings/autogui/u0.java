package com.obric.assistant.settings.autogui;

import com.obric.assistant.RiskPreferenceSettings;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f391960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f391961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f391962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f391963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f391964e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u0) == true) goto L8;
        return false;
    L8:
        u0 r101 = (u0) r100;
        if (Intrinsics.areEqual(this.f391960a, r101.f391960a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f391961b, r101.f391961b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f391962c, r101.f391962c) == true) goto L18;
        return false;
    L18:
        if (this.f391963d == r101.f391963d) goto L21;
        return false;
    L21:
        if (this.f391964e == r101.f391964e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f391960a.hashCode() * 31) + this.f391961b.hashCode()) * 31) + this.f391962c.hashCode()) * 31;
        if (this.f391963d == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f391964e;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "RiskPreferenceItemUiModel(value=" + this.f391960a + ", title=" + this.f391961b + ", subtitle=" + this.f391962c + ", selected=" + this.f391963d + ", cardPosition=" + this.f391964e + ')';
    }

    public u0(@RiskPreferenceSettings String r100, String r101, String r102, boolean r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "subtitle");
        this.f391960a = r100;
        this.f391961b = r101;
        this.f391962c = r102;
        this.f391963d = r103;
        this.f391964e = r104;
    }
}
