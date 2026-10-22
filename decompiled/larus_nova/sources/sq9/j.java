package sq9;

import com.larus.bmhome.share.ShareScene;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f543100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f543101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f543102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f543103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f543104e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.bmhome.share.panel.d f543105f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.larus.bmhome.share.panel.h f543106g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ShareScene f543107h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f543108i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f543109j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i f543110k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, String> f543111l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f543112m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f543113n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Integer f543114o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f543115p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f543116q;

    public j() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f543100a, r101.f543100a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f543101b, r101.f543101b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f543102c, r101.f543102c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f543103d, r101.f543103d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f543104e, r101.f543104e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f543105f, r101.f543105f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f543106g, r101.f543106g) == true) goto L30;
        return false;
    L30:
        if (this.f543107h == r101.f543107h) goto L33;
        return false;
    L33:
        if (this.f543108i == r101.f543108i) goto L36;
        return false;
    L36:
        if (this.f543109j == r101.f543109j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f543110k, r101.f543110k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f543111l, r101.f543111l) == true) goto L45;
        return false;
    L45:
        if (this.f543112m == r101.f543112m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f543113n, r101.f543113n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f543114o, r101.f543114o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f543115p, r101.f543115p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f543116q, r101.f543116q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f543100a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.f543101b.hashCode()) * 31) + this.f543102c.hashCode()) * 31;
        String r104 = this.f543103d;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f543104e;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        com.larus.bmhome.share.panel.d r110 = this.f543105f;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        com.larus.bmhome.share.panel.h r113 = this.f543106g;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (((r112 + r114) * 31) + this.f543107h.hashCode()) * 31;
        long r116 = this.f543108i;
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        long r118 = this.f543109j;
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        i r120 = this.f543110k;
        if (r120 != null) goto L25;
        int r121 = 0;
    L26:
        int r122 = (r119 + r121) * 31;
        Map<String, String> r123 = this.f543111l;
        if (r123 != null) goto L29;
        int r124 = 0;
    L30:
        int r125 = (((r122 + r124) * 31) + this.f543112m) * 31;
        String r126 = this.f543113n;
        if (r126 != null) goto L33;
        int r127 = 0;
    L34:
        int r128 = (r125 + r127) * 31;
        Integer r129 = this.f543114o;
        if (r129 != null) goto L37;
        int r130 = 0;
    L38:
        int r131 = (r128 + r130) * 31;
        String r132 = this.f543115p;
        if (r132 != null) goto L41;
        int r133 = 0;
    L42:
        int r134 = (r131 + r133) * 31;
        String r135 = this.f543116q;
        if (r135 == null) goto L47;
        r101 = r135.hashCode();
    L47:
        return r134 + r101;
    L41:
        r133 = r132.hashCode();
        goto L42
    L37:
        r130 = r129.hashCode();
        goto L38
    L33:
        r127 = r126.hashCode();
        goto L34
    L29:
        r124 = r123.hashCode();
        goto L30
    L25:
        r121 = r120.hashCode();
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
        return "CreationImageShareModel(creationId=" + this.f543100a + ", previewImageUrl=" + this.f543101b + ", downloadImageUrl=" + this.f543102c + ", rawImageUrl=" + this.f543103d + ", refImageUrl=" + this.f543104e + ", callback=" + this.f543105f + ", sharePanelEventParam=" + this.f543106g + ", shareScene=" + this.f543107h + ", defaultImageWidth=" + this.f543108i + ", defaultImageHeight=" + this.f543109j + ", creationImageShareEventModel=" + this.f543110k + ", metaDataExifMap=" + this.f543111l + ", videoDuration=" + this.f543112m + ", videoDownloadFilehash=" + this.f543113n + ", taskType=" + this.f543114o + ", vid=" + this.f543115p + ", imageKey=" + this.f543116q + ')';
    }

    public j(String r110, String r210, String r211, String r212, String r213, com.larus.bmhome.share.panel.d r214, com.larus.bmhome.share.panel.h r215, ShareScene r216, long r217, long r218, i r310, Map r311, int r312, String r313, Integer r314, String r315, String r316, int r317) {
        if ((r317 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r317 & 32) == 0) goto L9;
        com.larus.bmhome.share.panel.d r101 = null;
    L10:
        long r102 = -1;
        if ((r317 & 256) == 0) goto L13;
        long r111 = -1;
    L15:
        if ((r317 & 512) != 0) goto L19;
        r102 = r218;
    L19:
        if ((r317 & 1024) == 0) goto L21;
        i r103 = null;
    L23:
        if ((r317 & 4096) == 0) goto L25;
        int r112 = 0;
    L27:
        if ((r317 & 8192) == 0) goto L29;
        String r113 = null;
    L31:
        if ((r317 & 16384) == 0) goto L33;
        Integer r114 = null;
    L35:
        if ((r317 & 32768) == 0) goto L37;
        String r104 = null;
    L39:
        if ((r317 & 65536) == 0) goto L41;
        String r115 = null;
    L42:
        Intrinsics.checkNotNullParameter(r210, "previewImageUrl");
        Intrinsics.checkNotNullParameter(r211, "downloadImageUrl");
        Intrinsics.checkNotNullParameter(r216, "shareScene");
        this.f543100a = r100;
        this.f543101b = r210;
        this.f543102c = r211;
        this.f543103d = r212;
        this.f543104e = r213;
        this.f543105f = r101;
        this.f543106g = r215;
        this.f543107h = r216;
        this.f543108i = r111;
        this.f543109j = r102;
        this.f543110k = r103;
        this.f543111l = r311;
        this.f543112m = r112;
        this.f543113n = r113;
        this.f543114o = r114;
        this.f543115p = r104;
        this.f543116q = r115;
        return;
    L41:
        r115 = r316;
        goto L42
    L37:
        r104 = r315;
        goto L39
    L33:
        r114 = r314;
        goto L35
    L29:
        r113 = r313;
        goto L31
    L25:
        r112 = r312;
        goto L27
    L21:
        r103 = r310;
        goto L23
    L13:
        r111 = r217;
        goto L15
    L9:
        r101 = r214;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }
}
