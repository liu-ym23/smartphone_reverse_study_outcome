package nr9;

import androidx.camera.video.AudioStats;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f520257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f520258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f520259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f520260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Double f520261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f520262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f f520263g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f520264h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f520265i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f520266j;

    public g() {
        this(null, null, null, null, null, null, null, null, null, null, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f520257a, r101.f520257a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f520258b, r101.f520258b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f520259c, r101.f520259c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f520260d, r101.f520260d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f520261e, r101.f520261e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f520262f, r101.f520262f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f520263g, r101.f520263g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f520264h, r101.f520264h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f520265i, r101.f520265i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f520266j, r101.f520266j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f520257a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f520258b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f520259c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f520260d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Double r113 = this.f520261e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f520262f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        f r119 = this.f520263g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f520264h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f520265i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f520266j;
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
        return "VideoPlayData(vid=" + this.f520257a + ", videoModel=" + this.f520258b + ", downloadUrl=" + this.f520259c + ", downloadFilehash=" + this.f520260d + ", duration=" + this.f520261e + ", format=" + this.f520262f + ", cover=" + this.f520263g + ", localPath=" + this.f520264h + ", resourceId=" + this.f520265i + ", localUri=" + this.f520266j + ')';
    }

    public static g a(g r110, String r111, String r112, String r113, String r114, Double r115, String r210, f r211, int r212) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.f520257a;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.f520258b;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.f520259c;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.f520260d;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Double r104 = r110.f520261e;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.f520262f;
    L27:
        if ((r212 & 64) == 0) goto L29;
        f r116 = r110.f520263g;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r117 = r110.f520264h;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r118 = r110.f520265i;
    L39:
        if ((r212 & 512) == 0) goto L41;
        String r119 = r110.f520266j;
    L42:
        r110.getClass();
        return new g(r100, r101, r102, r103, r104, r105, r116, r117, r118, r119);
    L41:
        r119 = null;
        goto L42
    L37:
        r118 = null;
        goto L39
    L33:
        r117 = null;
        goto L35
    L29:
        r116 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public g(String r100, String r101, String r102, String r103, Double r104, String r105, f r106, String r107, String r108, String r110) {
        this.f520257a = r100;
        this.f520258b = r101;
        this.f520259c = r102;
        this.f520260d = r103;
        this.f520261e = r104;
        this.f520262f = r105;
        this.f520263g = r106;
        this.f520264h = r107;
        this.f520265i = r108;
        this.f520266j = r110;
    }

    public /* synthetic */ g(String r110, String r111, String r112, String r113, Double r114, String r115, f r116, String r117, String r210, String r211, int r212) {
        String r100 = "";
        if ((r212 & 1) == 0) goto L5;
        String r101 = "";
    L6:
        String r102 = null;
        if ((r212 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Double r106 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    L23:
        if ((r212 & 32) != 0) goto L27;
        r100 = r115;
    L27:
        if ((r212 & 64) == 0) goto L29;
        f r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r102 = r211;
    L42:
        this(r101, r103, r104, r105, r106, r100, r107, r108, r118, r102);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
