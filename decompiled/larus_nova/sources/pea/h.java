package pea;

import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f528783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f528784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f528785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Intent f528786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f528787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f528788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f528789g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f528790h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f528791i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f528792j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f528793k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f528794l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f528795m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f528796n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f528797o;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f528783a == r101.f528783a) goto L12;
        return false;
    L12:
        if (this.f528784b == r101.f528784b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f528785c, r101.f528785c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f528786d, r101.f528786d) == true) goto L21;
        return false;
    L21:
        if (this.f528787e == r101.f528787e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f528788f, r101.f528788f) == true) goto L27;
        return false;
    L27:
        if (this.f528789g == r101.f528789g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f528790h, r101.f528790h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f528791i, r101.f528791i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f528792j, r101.f528792j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f528793k, r101.f528793k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f528794l, r101.f528794l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f528795m, r101.f528795m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f528796n, r101.f528796n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f528797o, r101.f528797o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f528783a * 31) + this.f528784b) * 31;
        String r101 = this.f528785c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Intent r105 = this.f528786d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.f528787e == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        String r110 = this.f528788f;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((r109 + r111) * 31) + this.f528789g) * 31;
        String r113 = this.f528790h;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f528791i;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f528792j;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f528793k;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f528794l;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f528795m;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.f528796n;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f528797o;
        if (r134 == null) goto L51;
        r102 = r134.hashCode();
    L51:
        return r133 + r102;
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ExpandedImageTextActionInfo(type=" + this.f528783a + ", actionParamType=" + this.f528784b + ", action=" + this.f528785c + ", intent=" + this.f528786d + ", clickWithCollapse=" + this.f528787e + ", actionIcon=" + this.f528788f + ", actionIconResId=" + this.f528789g + ", actionIconDark=" + this.f528790h + ", actionIconDarkResId=" + this.f528791i + ", actionBgColor=" + this.f528792j + ", actionTitle=" + this.f528793k + ", actionTitleColor=" + this.f528794l + ", actionTitleColorDark=" + this.f528795m + ", actionIntentType=" + this.f528796n + ", actionIntent=" + this.f528797o + ')';
    }

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("type", this.f528783a);
        r100.put("clickWithCollapse", this.f528787e);
        if (this.f528784b != 0) goto L5;
        r100.put("action", this.f528785c);
    L29:
        return r100;
    L5:
        r100.put("actionIcon", this.f528788f);
        r100.put("actionIconDark", this.f528790h);
        String r101 = this.f528792j;
        if (r101 == null) goto L8;
        r100.put("actionBgColor", r101);
    L8:
        String r102 = this.f528793k;
        if (r102 == null) goto L11;
        r100.put("actionTitle", r102);
    L11:
        String r103 = this.f528794l;
        if (r103 == null) goto L14;
        r100.put("actionTitleColor", r103);
    L14:
        String r104 = this.f528795m;
        if (r104 == null) goto L17;
        r100.put("actionTitleColorDark", r104);
    L17:
        Intent r105 = this.f528786d;
        if (r105 == null) goto L22;
        String r106 = r105.toUri(1);
        if (r106 == null) goto L22;
    L23:
        this.f528797o = r106;
        if (r106 == null) goto L26;
        r100.put("actionIntent", r106);
    L26:
        Integer r107 = this.f528796n;
        if (r107 == null) goto L29;
        r107.intValue();
        r100.put("actionIntentType", this.f528796n);
    L22:
        r106 = null;
        goto L23
    }

    public final int getType() {
        return this.f528783a;
    }

    public h(String r100, boolean r101, String r102, int r103, String r104, Integer r110, int r111) {
        if ((r111 & 2) == 0) goto L5;
        int r105 = 0;
    L7:
        if ((r111 & 4) == 0) goto L10;
        r100 = null;
    L10:
        if ((r111 & 16) == 0) goto L13;
        r101 = false;
    L13:
        if ((r111 & 32) == 0) goto L16;
        r102 = null;
    L16:
        if ((r111 & 128) == 0) goto L19;
        r104 = null;
    L19:
        if ((r111 & 256) == 0) goto L22;
        r110 = null;
    L22:
        if ((r111 & 8192) == 0) goto L24;
        Integer r112 = 2;
    L25:
        this.f528783a = 0;
        this.f528784b = r105;
        this.f528785c = r100;
        this.f528786d = null;
        this.f528787e = r101;
        this.f528788f = r102;
        this.f528789g = r103;
        this.f528790h = r104;
        this.f528791i = r110;
        this.f528792j = null;
        this.f528793k = null;
        this.f528794l = null;
        this.f528795m = null;
        this.f528796n = r112;
        this.f528797o = null;
        return;
    L24:
        r112 = null;
        goto L25
    L5:
        r105 = 1;
        goto L7
    }
}
