package com.larus.dora.impl.device.ota;

import com.facebook.keyframes.model.KFAnimation;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f334207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f334208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f334209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f334210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f334211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public l0 f334212f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f334213g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f334214h;

    public k0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r101 = (k0) r100;
        if (Intrinsics.areEqual(this.f334207a, r101.f334207a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f334208b, r101.f334208b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f334209c, r101.f334209c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f334210d, r101.f334210d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f334211e, r101.f334211e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f334212f, r101.f334212f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f334213g, r101.f334213g) == true) goto L30;
        return false;
    L30:
        if (this.f334214h == r101.f334214h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((this.f334207a.hashCode() * 31) + this.f334208b.hashCode()) * 31) + this.f334209c.hashCode()) * 31) + this.f334210d.hashCode()) * 31) + this.f334211e.hashCode()) * 31) + this.f334212f.hashCode()) * 31) + this.f334213g.hashCode()) * 31;
        long r101 = this.f334214h;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "OtaEvent(udid=" + this.f334207a + ", event=" + this.f334208b + ", model=" + this.f334209c + ", osVersion=" + this.f334210d + ", product=" + this.f334211e + ", property=" + this.f334212f + ", traceId=" + this.f334213g + ", timestamp=" + this.f334214h + ')';
    }

    public k0(int r100) {
        l0 r101 = new l0(0);
        Intrinsics.checkNotNullParameter("", "udid");
        Intrinsics.checkNotNullParameter("ota_progress", "event");
        Intrinsics.checkNotNullParameter("", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter("", "osVersion");
        Intrinsics.checkNotNullParameter("", "product");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter("", "traceId");
        this.f334207a = "";
        this.f334208b = "ota_progress";
        this.f334209c = "";
        this.f334210d = "";
        this.f334211e = "";
        this.f334212f = r101;
        this.f334213g = "";
        this.f334214h = 0;
    }
}
