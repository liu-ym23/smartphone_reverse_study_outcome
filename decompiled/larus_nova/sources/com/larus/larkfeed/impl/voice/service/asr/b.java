package com.larus.larkfeed.impl.voice.service.asr;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f355614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f355615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f355616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f355617d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f355614a, r101.f355614a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f355615b, r101.f355615b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f355616c, r101.f355616c) == true) goto L18;
        return false;
    L18:
        if (this.f355617d == r101.f355617d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f355614a.hashCode() * 31) + this.f355615b.hashCode()) * 31) + this.f355616c.hashCode()) * 31;
        if (this.f355617d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "FlowAsrRuntimeConfig(language=" + this.f355614a + ", model=" + this.f355615b + ", speechLanguage=" + this.f355616c + ", optOutVoiceEnabled=" + this.f355617d + ')';
    }

    public b(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "language");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r102, "speechLanguage");
        this.f355614a = r100;
        this.f355615b = r101;
        this.f355616c = r102;
        this.f355617d = r103;
    }
}
