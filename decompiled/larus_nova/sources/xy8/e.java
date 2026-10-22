package xy8;

import com.larus.platform.api.creation.UserCreationType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f565443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f565444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f565445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f565446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f565447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f565448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f565449g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f565450h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f565451i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f565452j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f565453k;

    public e() {
        this(null, null, null, null, null, null, null, null, null, false, 2047);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f565443a, r101.f565443a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f565444b, r101.f565444b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f565445c, r101.f565445c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f565446d, r101.f565446d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f565447e, r101.f565447e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f565448f, r101.f565448f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f565449g, r101.f565449g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f565450h, r101.f565450h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f565451i, r101.f565451i) == true) goto L36;
        return false;
    L36:
        if (this.f565452j == r101.f565452j) goto L39;
        return false;
    L39:
        if (this.f565453k == r101.f565453k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f565443a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f565444b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f565445c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f565446d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f565447e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f565448f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f565449g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.f565450h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f565451i;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        int r126 = (r124 + r101) * 31;
        int r127 = 1231;
        if (this.f565452j == false) goto L41;
        int r128 = 1231;
    L42:
        int r129 = (r126 + r128) * 31;
        if (this.f565453k == true) goto L47;
        r127 = 1237;
    L47:
        return r129 + r127;
    L41:
        r128 = 1237;
        goto L42
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
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PublishMetadata(creationId=" + this.f565443a + ", creationType=" + this.f565444b + ", messageId=" + this.f565445c + ", refContent=" + this.f565446d + ", taskId=" + this.f565447e + ", creationIndex=" + this.f565448f + ", materialId=" + this.f565449g + ", fromIMCreationType=" + this.f565450h + ", prompt=" + this.f565451i + ", isBlockContent=" + this.f565452j + ", isPublished=" + this.f565453k + ')';
    }

    public static e a(e r110, String r111, Integer r112, String r113, String r114, String r210, boolean r211, int r212) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.f565443a;
    L7:
        if ((r212 & 2) == 0) goto L9;
        Integer r101 = r110.f565444b;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.f565445c;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.f565446d;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.f565447e;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.f565448f;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r115 = r110.f565449g;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Integer r116 = r110.f565450h;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r117 = r110.f565451i;
    L39:
        if ((r212 & 512) == 0) goto L41;
        boolean r118 = r110.f565452j;
    L43:
        if ((r212 & 1024) == 0) goto L45;
        boolean r119 = r110.f565453k;
    L46:
        r110.getClass();
        return new e(r100, r101, r102, r103, r104, r105, r115, r116, r117, r118, r119);
    L45:
        r119 = r211;
        goto L46
    L41:
        r118 = false;
        goto L43
    L37:
        r117 = r210;
        goto L39
    L33:
        r116 = null;
        goto L35
    L29:
        r115 = r114;
        goto L31
    L25:
        r105 = null;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public /* synthetic */ e(String r110, Integer r111, String r112, String r113, String r210, String r211, String r212, Integer r213, String r214, boolean r215, int r216) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r216 & 2) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r114 = null;
    L31:
        if ((r216 & 128) == 0) goto L33;
        Integer r115 = null;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r116 = null;
    L39:
        if ((r216 & 1024) == 0) goto L41;
        boolean r117 = false;
    L42:
        this(r100, r101, r102, r103, r104, r105, r114, r115, r116, false, r117);
        return;
    L41:
        r117 = r215;
        goto L42
    L37:
        r116 = r214;
        goto L39
    L33:
        r115 = r213;
        goto L35
    L29:
        r114 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public e(String r100, @UserCreationType Integer r101, String r102, String r103, String r104, String r105, String r106, @UserCreationType Integer r107, String r108, boolean r110, boolean r111) {
        this.f565443a = r100;
        this.f565444b = r101;
        this.f565445c = r102;
        this.f565446d = r103;
        this.f565447e = r104;
        this.f565448f = r105;
        this.f565449g = r106;
        this.f565450h = r107;
        this.f565451i = r108;
        this.f565452j = r110;
        this.f565453k = r111;
    }
}
