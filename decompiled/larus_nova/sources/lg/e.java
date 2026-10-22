package lg;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f509113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f509114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f509115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f509116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f509117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f509118f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f509119g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f509120h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final JSONObject f509121i;

    public e() {
        this(null, null, null, null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L24;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f509113a, r101.f509113a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f509114b, r101.f509114b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f509115c, r101.f509115c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f509116d, r101.f509116d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f509117e, r101.f509117e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f509118f, r101.f509118f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f509119g, r101.f509119g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f509120h, r101.f509120h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f509121i, r101.f509121i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f509113a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        JSONObject r104 = this.f509114b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        JSONObject r107 = this.f509115c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f509116d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f509117e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f509118f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f509119g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f509120h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        JSONObject r125 = this.f509121i;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AdEventParam(logExtra=" + this.f509113a + ", adExtraData=" + this.f509114b + ", entranceInfo=" + this.f509115c + ", creativeId=" + this.f509116d + ", roomId=" + this.f509117e + ", promotionId=" + this.f509118f + ", buyinTrack=" + this.f509119g + ", cBizCombo=" + this.f509120h + ", extra=" + this.f509121i + ")";
    }

    public e(String r100, JSONObject r101, JSONObject r102, String r103, String r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r105 & 16) == 0) goto L17;
        r104 = null;
    L17:
        this.f509113a = r100;
        this.f509114b = r101;
        this.f509115c = r102;
        this.f509116d = r103;
        this.f509117e = r104;
        this.f509118f = null;
        this.f509119g = null;
        this.f509120h = null;
        this.f509121i = null;
    }
}
