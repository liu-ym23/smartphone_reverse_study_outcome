package tk7;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f546539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f546540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f546541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f546542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f546543e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f546544f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f546545g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final JSONObject f546546h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final JSONObject f546547i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Long f546548j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f546549k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Long f546550l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f546551m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f546552n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L34;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f546539a, r101.f546539a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f546540b, r101.f546540b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f546541c, r101.f546541c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f546542d, r101.f546542d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f546543e, r101.f546543e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f546544f, r101.f546544f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f546545g, r101.f546545g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f546546h, r101.f546546h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f546547i, r101.f546547i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f546548j, r101.f546548j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f546549k, r101.f546549k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f546550l, r101.f546550l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f546551m, r101.f546551m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f546552n, r101.f546552n) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f546539a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f546540b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f546541c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f546542d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f546543e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f546544f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f546545g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        JSONObject r122 = this.f546546h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        JSONObject r125 = this.f546547i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Long r128 = this.f546548j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f546549k;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Long r134 = this.f546550l;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.f546551m;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.f546552n;
        if (r140 == null) goto L58;
        r101 = r140.hashCode();
    L58:
        return r139 + r101;
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
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
        return "ActionTaskModel(globalTaskId=" + this.f546539a + ", taskType=" + this.f546540b + ", taskId=" + this.f546541c + ", taskToken=" + this.f546542d + ", targetPage=" + this.f546543e + ", activityId=" + this.f546544f + ", extra=" + this.f546545g + ", extraParams=" + this.f546546h + ", cacheJson=" + this.f546547i + ", createTime=" + this.f546548j + ", from=" + this.f546549k + ", expireTimeMs=" + this.f546550l + ", clearCacheReason=" + this.f546551m + ", uniqueType=" + this.f546552n + ")";
    }

    public a(String r100, String r101, String r102, String r103, String r104, String r105, String r106, JSONObject r107, String r108) {
        this.f546539a = r100;
        this.f546540b = r101;
        this.f546541c = r102;
        this.f546542d = r103;
        this.f546543e = r104;
        this.f546544f = r105;
        this.f546545g = r106;
        this.f546546h = r107;
        this.f546547i = null;
        this.f546548j = null;
        this.f546549k = "schema";
        this.f546550l = null;
        this.f546551m = null;
        this.f546552n = r108;
    }
}
