package ni2;

import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f519241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ml.b f519242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final il.a f519243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ml.a f519244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f519245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f519246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final JSONObject f519247g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f519248h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final xk.a f519249i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewModelProvider.Factory f519250j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L26;
        b r101 = (b) r100;
        if (this.f519241a == r101.f519241a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f519242b, r101.f519242b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f519243c, r101.f519243c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f519244d, r101.f519244d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f519245e, r101.f519245e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f519246f, r101.f519246f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f519247g, r101.f519247g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f519248h, r101.f519248h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f519249i, r101.f519249i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f519250j, r101.f519250j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f519241a * 31;
        ml.b r101 = this.f519242b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        il.a r105 = this.f519243c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        ml.a r108 = this.f519244d;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f519245e;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f519246f;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        JSONObject r117 = this.f519247g;
        if (r117 == null) goto L25;
        int r118 = r117.hashCode();
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f519248h;
        if (r120 == null) goto L29;
        int r121 = r120.hashCode();
    L30:
        int r122 = (r119 + r121) * 31;
        xk.a r123 = this.f519249i;
        if (r123 == null) goto L33;
        int r124 = r123.hashCode();
    L34:
        int r125 = (r122 + r124) * 31;
        ViewModelProvider.Factory r126 = this.f519250j;
        if (r126 == null) goto L38;
        r102 = r126.hashCode();
    L38:
        return r125 + r102;
    L33:
        r124 = 0;
        goto L34
    L29:
        r121 = 0;
        goto L30
    L25:
        r118 = 0;
        goto L26
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "ECScrollProductCardAdapterParams(funType=" + this.f519241a + ", liveInfo=" + this.f519242b + ", eventMap=" + this.f519243c + ", btmInfo=" + this.f519244d + ", ecomSceneId=" + this.f519245e + ", replayId=" + this.f519246f + ", queryEntranceInfo=" + this.f519247g + ", enterFrom=" + this.f519248h + ", replayParams=" + this.f519249i + ", factory=" + this.f519250j + ")";
    }

    public b(int r100, ml.b r101, il.a r102, ml.a r103, String r104, String r105, JSONObject r106, String r107, xk.a r110, ViewModelProvider.Factory r111) {
        Intrinsics.checkNotNullParameter(r101, "liveInfo");
        Intrinsics.checkNotNullParameter(r102, "eventMap");
        Intrinsics.checkNotNullParameter(r103, "btmInfo");
        Intrinsics.checkNotNullParameter(r104, "ecomSceneId");
        Intrinsics.checkNotNullParameter(r105, "replayId");
        Intrinsics.checkNotNullParameter(r106, "queryEntranceInfo");
        Intrinsics.checkNotNullParameter(r107, "enterFrom");
        Intrinsics.checkNotNullParameter(r110, "replayParams");
        Intrinsics.checkNotNullParameter(r111, "factory");
        this.f519241a = r100;
        this.f519242b = r101;
        this.f519243c = r102;
        this.f519244d = r103;
        this.f519245e = r104;
        this.f519246f = r105;
        this.f519247g = r106;
        this.f519248h = r107;
        this.f519249i = r110;
        this.f519250j = r111;
    }
}
