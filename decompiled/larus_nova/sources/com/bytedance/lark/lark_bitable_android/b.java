package com.bytedance.lark.lark_bitable_android;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f252979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f252980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f252981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f252982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f252983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f252984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f252985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f252986h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f252979a, r101.f252979a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f252980b, r101.f252980b) == true) goto L15;
        return false;
    L15:
        if (this.f252981c == r101.f252981c) goto L18;
        return false;
    L18:
        if (this.f252982d == r101.f252982d) goto L21;
        return false;
    L21:
        if (this.f252983e == r101.f252983e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f252984f, r101.f252984f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f252985g, r101.f252985g) == true) goto L30;
        return false;
    L30:
        if (this.f252986h == r101.f252986h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f252979a.hashCode() * 31) + this.f252980b.hashCode()) * 31;
        long r101 = this.f252981c;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f252982d;
        return ((((((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f252983e) * 31) + this.f252984f.hashCode()) * 31) + this.f252985g.hashCode()) * 31) + this.f252986h;
    }

    public final String toString() {
        return "BaseAppPreloadResource(payload=" + this.f252979a + ", source=" + this.f252980b + ", cacheElapsedTime=" + this.f252981c + ", requestStart=" + this.f252982d + ", apiCode=" + this.f252983e + ", errorMsg=" + this.f252984f + ", xttLogId=" + this.f252985g + ", schemaVersion=" + this.f252986h + ')';
    }

    public b(String r100, String r101, long r102, long r103, int r104, String r105, String r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r105, "errorMsg");
        Intrinsics.checkNotNullParameter(r110, "xttLogId");
        this.f252979a = r100;
        this.f252980b = r101;
        this.f252981c = r102;
        this.f252982d = r103;
        this.f252983e = r104;
        this.f252984f = r105;
        this.f252985g = r110;
        this.f252986h = r111;
    }
}
