package hq9;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class x2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v2 f486805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n2 f486806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f486807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f486808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f486809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f486810f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f486811g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x2) == true) goto L8;
        return false;
    L8:
        x2 r101 = (x2) r100;
        if (Intrinsics.areEqual(this.f486805a, r101.f486805a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486806b, r101.f486806b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486807c, r101.f486807c) == true) goto L18;
        return false;
    L18:
        if (this.f486808d == r101.f486808d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f486809e, r101.f486809e) == true) goto L24;
        return false;
    L24:
        if (this.f486810f == r101.f486810f) goto L27;
        return false;
    L27:
        if (this.f486811g == r101.f486811g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f486805a.hashCode() * 31) + this.f486806b.hashCode()) * 31) + this.f486807c.hashCode()) * 31;
        if (this.f486808d == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        String r103 = this.f486809e;
        if (r103 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r102 + r104) * 31;
        long r106 = this.f486810f;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f486811g;
        return r107 + ((int) (r108 ^ (r108 >>> 32)));
    L9:
        r104 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "LarkSocialUserSettingsSnapshot(session=" + this.f486805a + ", flowSocialNextConfig=" + this.f486806b + ", rawFlowSocialNextConfig=" + this.f486807c + ", socialNextFeatureGating=" + this.f486808d + ", settingsRevision=" + this.f486809e + ", settingsRequestId=" + this.f486810f + ", receivedAtMillis=" + this.f486811g + ')';
    }

    public static x2 a(x2 r110, v2 r111) {
        n2 r100 = r110.f486806b;
        String r101 = r110.f486807c;
        boolean r102 = r110.f486808d;
        String r103 = r110.f486809e;
        long r104 = r110.f486810f;
        long r105 = r110.f486811g;
        Intrinsics.checkNotNullParameter(r111, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r100, "flowSocialNextConfig");
        Intrinsics.checkNotNullParameter(r101, "rawFlowSocialNextConfig");
        return new x2(r111, r100, r101, r102, r103, r104, r105);
    }

    public x2(v2 r100, n2 r101, String r102, boolean r103, String r104, long r105, long r106) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "flowSocialNextConfig");
        Intrinsics.checkNotNullParameter(r102, "rawFlowSocialNextConfig");
        this.f486805a = r100;
        this.f486806b = r101;
        this.f486807c = r102;
        this.f486808d = r103;
        this.f486809e = r104;
        this.f486810f = r105;
        this.f486811g = r106;
    }
}
