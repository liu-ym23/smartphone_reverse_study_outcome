package q99;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final yc9.m f532171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f532172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f532173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f532174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f532175e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f532176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f532177g;

    public m() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f532171a, r101.f532171a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f532172b, r101.f532172b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f532173c, r101.f532173c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f532174d, r101.f532174d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f532175e, r101.f532175e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f532176f, r101.f532176f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f532177g, r101.f532177g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f532171a.hashCode() * 31;
        Integer r101 = this.f532172b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f532173c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f532174d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f532175e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f532176f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Map<String, String> r117 = this.f532177g;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowMessageFeedbackRequest(imRequest=" + this.f532171a + ", feedbackScene=" + this.f532172b + ", feedbackId=" + this.f532173c + ", sectionId=" + this.f532174d + ", clickFrom=" + this.f532175e + ", callId=" + this.f532176f + ", extraParams=" + this.f532177g + ')';
    }

    public m(yc9.m r100, Integer r101, String r102, String r103, String r104, String r105, Map r106, int r110) {
        if ((r110 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r110 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r110 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r110 & 16) == 0) goto L15;
        r104 = null;
    L15:
        if ((r110 & 32) == 0) goto L18;
        r105 = null;
    L18:
        if ((r110 & 64) == 0) goto L20;
        r106 = null;
    L20:
        Intrinsics.checkNotNullParameter(r100, "imRequest");
        this.f532171a = r100;
        this.f532172b = r101;
        this.f532173c = r102;
        this.f532174d = r103;
        this.f532175e = r104;
        this.f532176f = r105;
        this.f532177g = r106;
    }
}
