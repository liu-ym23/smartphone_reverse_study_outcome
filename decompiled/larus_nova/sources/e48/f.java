package e48;

import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f471013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f471014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f471015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f471016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f471017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f471018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f471019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f471020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f471021i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f471013a, r101.f471013a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f471014b, r101.f471014b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f471015c, r101.f471015c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f471016d, r101.f471016d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f471017e, r101.f471017e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f471018f, r101.f471018f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f471019g, r101.f471019g) == true) goto L30;
        return false;
    L30:
        if (this.f471020h == r101.f471020h) goto L33;
        return false;
    L33:
        if (this.f471021i == r101.f471021i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((this.f471013a.hashCode() * 31) + this.f471014b.hashCode()) * 31) + this.f471015c.hashCode()) * 31) + this.f471016d.hashCode()) * 31) + this.f471017e.hashCode()) * 31) + this.f471018f.hashCode()) * 31) + this.f471019g.hashCode()) * 31;
        long r101 = this.f471020h;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f471021i;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public final String toString() {
        return "AccountSecurityPushPayload(biz=" + this.f471013a + ", messageId=" + this.f471014b + ", riskDeviceId=" + this.f471015c + ", riskReason=" + this.f471016d + ", title=" + this.f471017e + ", text=" + this.f471018f + ", openUrl=" + this.f471019g + ", popupDismissInterval=" + this.f471020h + ", pushThrottleInterval=" + this.f471021i + ')';
    }

    public f(String r100, String r101, String r102, String r103, String r104, String r105, String r106, long r107, long r110) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r102, "riskDeviceId");
        Intrinsics.checkNotNullParameter(r103, "riskReason");
        Intrinsics.checkNotNullParameter(r104, "title");
        Intrinsics.checkNotNullParameter(r105, "text");
        Intrinsics.checkNotNullParameter(r106, RuleConditionBean.OPEN_URL_KEY);
        this.f471013a = r100;
        this.f471014b = r101;
        this.f471015c = r102;
        this.f471016d = r103;
        this.f471017e = r104;
        this.f471018f = r105;
        this.f471019g = r106;
        this.f471020h = r107;
        this.f471021i = r110;
    }
}
