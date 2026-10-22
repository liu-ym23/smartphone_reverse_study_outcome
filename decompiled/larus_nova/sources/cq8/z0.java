package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f465007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f465008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f465009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f465010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f465011e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f465012f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f465013g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f465014h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f465015i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f465016j;

    public static final class a {
    }

    public z0() {
        this(null, null, null, null, null, null, null, null, null, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z0) == true) goto L8;
        return false;
    L8:
        z0 r101 = (z0) r100;
        if (Intrinsics.areEqual(this.f465007a, r101.f465007a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465008b, r101.f465008b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465009c, r101.f465009c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f465010d, r101.f465010d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f465011e, r101.f465011e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f465012f, r101.f465012f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f465013g, r101.f465013g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f465014h, r101.f465014h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f465015i, r101.f465015i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f465016j, r101.f465016j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f465007a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f465008b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f465009c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f465010d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f465011e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f465012f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f465013g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f465014h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.f465015i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f465016j;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
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
        return "WidgetTrackingContext(botId=" + this.f465007a + ", conversationId=" + this.f465008b + ", chatType=" + this.f465009c + ", templateType=" + this.f465010d + ", actionBarItemId=" + this.f465011e + ", instructionType=" + this.f465012f + ", actionBarKey=" + this.f465013g + ", previousPage=" + this.f465014h + ", isCreationActionBar=" + this.f465015i + ", optionLabel=" + this.f465016j + ')';
    }

    static {
    }

    public /* synthetic */ z0(String r110, String r111, String r112, String r113, String r114, String r210, String r211, Boolean r212, String r213, int r214) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r214 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r214 & 8) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r214 & 16) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r214 & 32) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r214 & 64) == 0) goto L25;
        String r115 = null;
    L27:
        if ((r214 & 128) == 0) goto L29;
        String r116 = null;
    L31:
        if ((r214 & 256) == 0) goto L33;
        Boolean r117 = null;
    L35:
        if ((r214 & 512) == 0) goto L37;
        String r118 = null;
    L38:
        this(r100, null, r101, r102, r103, r104, r115, r116, r117, r118);
        return;
    L37:
        r118 = r213;
        goto L38
    L33:
        r117 = r212;
        goto L35
    L29:
        r116 = r211;
        goto L31
    L25:
        r115 = r210;
        goto L27
    L21:
        r104 = r114;
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

    public z0(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, Boolean r108, String r110) {
        this.f465007a = r100;
        this.f465008b = r101;
        this.f465009c = r102;
        this.f465010d = r103;
        this.f465011e = r104;
        this.f465012f = r105;
        this.f465013g = r106;
        this.f465014h = r107;
        this.f465015i = r108;
        this.f465016j = r110;
    }
}
