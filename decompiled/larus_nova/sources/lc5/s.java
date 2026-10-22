package lc5;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f508549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f508550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f508552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f508553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f508554f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f508549a, r101.f508549a) == true) goto L12;
        return false;
    L12:
        if (this.f508550b == r101.f508550b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508551c, r101.f508551c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f508552d, r101.f508552d) == true) goto L21;
        return false;
    L21:
        if (this.f508553e == r101.f508553e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f508554f, r101.f508554f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f508549a.hashCode() * 31;
        if (this.f508550b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (((r100 + r101) * 31) + this.f508551c.hashCode()) * 31;
        String r103 = this.f508552d;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return ((((r102 + r104) * 31) + this.f508553e) * 31) + this.f508554f.hashCode();
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ReportRemoveManualOfflineParam(analyticService=" + this.f508549a + ", isGrid=" + this.f508550b + ", module=" + this.f508551c + ", objToken=" + this.f508552d + ", type=" + this.f508553e + ", result=" + this.f508554f + ')';
    }

    public final int getType() {
        return this.f508553e;
    }

    public s(com.bytedance.ee.bear.contract.d r100, boolean r101, String r102, String r103, int r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "analyticService");
        Intrinsics.checkNotNullParameter(r102, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r105, "result");
        this.f508549a = r100;
        this.f508550b = r101;
        this.f508551c = r102;
        this.f508552d = r103;
        this.f508553e = r104;
        this.f508554f = r105;
    }
}
