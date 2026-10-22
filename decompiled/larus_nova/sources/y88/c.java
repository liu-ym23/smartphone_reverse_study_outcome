package y88;

import com.huawei.hms.api.FailedBinderCallBack;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f566913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f566914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f566915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f566916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f566917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f566918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f566919g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f566920h;

    public c() {
        this(null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f566913a, r101.f566913a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f566914b, r101.f566914b) == true) goto L15;
        return false;
    L15:
        if (this.f566915c == r101.f566915c) goto L18;
        return false;
    L18:
        if (this.f566916d == r101.f566916d) goto L21;
        return false;
    L21:
        if (this.f566917e == r101.f566917e) goto L24;
        return false;
    L24:
        if (this.f566918f == r101.f566918f) goto L27;
        return false;
    L27:
        if (this.f566919g == r101.f566919g) goto L30;
        return false;
    L30:
        if (this.f566920h == r101.f566920h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f566913a.hashCode() * 31) + this.f566914b.hashCode()) * 31;
        int r101 = 1231;
        if (this.f566915c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f566916d == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((r103 + r104) * 31) + this.f566917e) * 31;
        if (this.f566918f == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f566919g == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f566920h == true) goto L23;
        r101 = 1237;
    L23:
        return r109 + r101;
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoraAvlinkSessionContext(sessionId=" + this.f566913a + ", callId=" + this.f566914b + ", supportHardwareAbilityShift=" + this.f566915c + ", isOnboarding=" + this.f566916d + ", modeValue=" + this.f566917e + ", isNotMainBot=" + this.f566918f + ", isRtc=" + this.f566919g + ", isQuic=" + this.f566920h + ')';
    }

    public /* synthetic */ c(String r110, int r111) {
        String r100 = "";
        if ((r111 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r111 & 2) != 0) goto L10;
        r100 = null;
    L10:
        String r102 = r100;
        if ((r111 & 4) == 0) goto L13;
        boolean r103 = true;
    L14:
        this(r101, r102, r103, false, 0, false, false, false);
        return;
    L13:
        r103 = false;
        goto L14
    L5:
        r101 = r110;
        goto L7
    }

    public c(String r100, String r101, boolean r102, boolean r103, int r104, boolean r105, boolean r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, FailedBinderCallBack.CALLER_ID);
        this.f566913a = r100;
        this.f566914b = r101;
        this.f566915c = r102;
        this.f566916d = r103;
        this.f566917e = r104;
        this.f566918f = r105;
        this.f566919g = r106;
        this.f566920h = r107;
    }
}
