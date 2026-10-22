package lda;

import com.obric.assistant.cocreationreview.modules.omni.OmniTaskTriggerType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f508838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f508840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f508841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f508842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f508843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f508844h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f508845i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OmniTaskTriggerType f508846j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f508837a, r101.f508837a) == true) goto L12;
        return false;
    L12:
        if (this.f508838b == r101.f508838b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508839c, r101.f508839c) == true) goto L18;
        return false;
    L18:
        if (this.f508840d == r101.f508840d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f508841e, r101.f508841e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f508842f, r101.f508842f) == true) goto L27;
        return false;
    L27:
        if (this.f508843g == r101.f508843g) goto L30;
        return false;
    L30:
        if (this.f508844h == r101.f508844h) goto L33;
        return false;
    L33:
        if (this.f508845i == r101.f508845i) goto L36;
        return false;
    L36:
        if (this.f508846j == r101.f508846j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f508837a.hashCode() * 31;
        long r101 = this.f508838b;
        int r102 = (((((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f508839c.hashCode()) * 31) + this.f508840d) * 31) + this.f508841e.hashCode()) * 31) + this.f508842f.hashCode()) * 31;
        int r103 = 1231;
        if (this.f508843g == false) goto L5;
        int r104 = 1231;
    L6:
        int r105 = (r102 + r104) * 31;
        if (this.f508844h == true) goto L10;
        r103 = 1237;
    L10:
        long r106 = this.f508845i;
        return ((((r105 + r103) * 31) + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.f508846j.hashCode();
    L5:
        r104 = 1237;
        goto L6
    }

    public final String toString() {
        return "OmniRuntimeStep(recordId=" + this.f508837a + ", createdAt=" + this.f508838b + ", userQuery=" + this.f508839c + ", stepIndex=" + this.f508840d + ", stepDescription=" + this.f508841e + ", modelReply=" + this.f508842f + ", isLastStep=" + this.f508843g + ", isSuccess=" + this.f508844h + ", finishTimeMillis=" + this.f508845i + ", taskTriggerType=" + this.f508846j + ')';
    }

    public w(String r100, long r101, String r102, int r103, String r104, String r105, boolean r106, boolean r110, long r111, OmniTaskTriggerType r112) {
        Intrinsics.checkNotNullParameter(r100, "recordId");
        Intrinsics.checkNotNullParameter(r102, "userQuery");
        Intrinsics.checkNotNullParameter(r104, "stepDescription");
        Intrinsics.checkNotNullParameter(r105, "modelReply");
        Intrinsics.checkNotNullParameter(r112, "taskTriggerType");
        this.f508837a = r100;
        this.f508838b = r101;
        this.f508839c = r102;
        this.f508840d = r103;
        this.f508841e = r104;
        this.f508842f = r105;
        this.f508843g = r106;
        this.f508844h = r110;
        this.f508845i = r111;
        this.f508846j = r112;
    }
}
