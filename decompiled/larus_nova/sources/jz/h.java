package jz;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.tencent.connect.share.QzonePublish;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f501082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f501083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f501084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f501085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f501086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f501087f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f501088g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f501089h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f501090i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f501091j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f501092k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f501093l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L30;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f501082a, r101.f501082a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f501083b, r101.f501083b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f501084c, r101.f501084c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f501085d, r101.f501085d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f501086e, r101.f501086e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f501087f, r101.f501087f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f501088g, r101.f501088g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f501089h, r101.f501089h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f501090i, r101.f501090i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f501091j, r101.f501091j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f501092k, r101.f501092k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f501093l, r101.f501093l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f501082a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f501083b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f501084c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.f501085d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f501086e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, String> r116 = this.f501087f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f501088g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f501089h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f501090i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f501091j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f501092k;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f501093l;
        if (r134 == null) goto L50;
        r101 = r134.hashCode();
    L50:
        return r133 + r101;
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
        return "SoloKtvPublishModel(videoPath=" + this.f501082a + ", shootWay=" + this.f501083b + ", title=" + this.f501084c + ", challenges=" + this.f501085d + ", creationId=" + this.f501086e + ", anchorInfo=" + this.f501087f + ", songName=" + this.f501088g + ", enterFrom=" + this.f501089h + ", recordType=" + this.f501090i + ", templateType=" + this.f501091j + ", mvType=" + this.f501092k + ", mvId=" + this.f501093l + ")";
    }

    public h(String r100, String r101, List r102, String r103, Map r104, String r105, String r106, String r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
        Intrinsics.checkNotNullParameter("solo_ktv", "shootWay");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "challenges");
        Intrinsics.checkNotNullParameter(r103, "creationId");
        Intrinsics.checkNotNullParameter(r104, "anchorInfo");
        Intrinsics.checkNotNullParameter(r105, "songName");
        Intrinsics.checkNotNullParameter(r106, "enterFrom");
        Intrinsics.checkNotNullParameter(r110, "recordType");
        Intrinsics.checkNotNullParameter(r111, GXTemplateKey.GAIAX_TEMPLATE_TYPE);
        Intrinsics.checkNotNullParameter(r112, "mvType");
        Intrinsics.checkNotNullParameter(r113, "mvId");
        this.f501082a = r100;
        this.f501083b = "solo_ktv";
        this.f501084c = r101;
        this.f501085d = r102;
        this.f501086e = r103;
        this.f501087f = r104;
        this.f501088g = r105;
        this.f501089h = r106;
        this.f501090i = r110;
        this.f501091j = r111;
        this.f501092k = r112;
        this.f501093l = r113;
    }
}
