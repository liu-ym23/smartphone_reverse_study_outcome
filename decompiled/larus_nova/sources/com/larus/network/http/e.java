package com.larus.network.http;

import androidx.autofill.HintConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f360150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f360151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f360152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f360153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f360154e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f360155f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f360156g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f360150a, r101.f360150a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f360151b, r101.f360151b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f360152c, r101.f360152c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f360153d, r101.f360153d) == true) goto L21;
        return false;
    L21:
        if (this.f360154e == r101.f360154e) goto L24;
        return false;
    L24:
        if (this.f360155f == r101.f360155f) goto L27;
        return false;
    L27:
        if (this.f360156g == r101.f360156g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f360150a.hashCode() * 31) + this.f360151b.hashCode()) * 31) + this.f360152c.hashCode()) * 31) + this.f360153d.hashCode()) * 31;
        int r101 = 1231;
        if (this.f360154e == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f360155f == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f360156g == true) goto L15;
        r101 = 1237;
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "CloudTestParam(phoneNumber=" + this.f360150a + ", verifyCode=" + this.f360151b + ", cvsId=" + this.f360152c + ", flowEnv=" + this.f360153d + ", disableInputText=" + this.f360154e + ", enableScrollToTop=" + this.f360155f + ", evaluateInterferenceShow=" + this.f360156g + ')';
    }

    public e(String r100, String r101, String r102, String r103, boolean r104, boolean r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        Intrinsics.checkNotNullParameter(r101, "verifyCode");
        Intrinsics.checkNotNullParameter(r102, "cvsId");
        Intrinsics.checkNotNullParameter(r103, "flowEnv");
        this.f360150a = r100;
        this.f360151b = r101;
        this.f360152c = r102;
        this.f360153d = r103;
        this.f360154e = r104;
        this.f360155f = r105;
        this.f360156g = r106;
    }
}
