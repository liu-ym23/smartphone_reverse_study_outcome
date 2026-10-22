package id8;

import android.net.Uri;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f489369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f489370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f489371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f489372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f489373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f489374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f489375g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f489376h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Uri f489377i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Boolean f489378j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, String> f489379k;

    public f() {
        this(null, null, null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f489369a, r101.f489369a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f489370b, r101.f489370b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f489371c, r101.f489371c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f489372d, r101.f489372d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f489373e, r101.f489373e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f489374f, r101.f489374f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f489375g, r101.f489375g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f489376h, r101.f489376h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f489377i, r101.f489377i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f489378j, r101.f489378j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f489379k, r101.f489379k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f489369a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        c r104 = this.f489370b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f489371c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f489372d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f489373e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f489374f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f489375g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.f489376h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Uri r125 = this.f489377i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.f489378j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Map<String, String> r131 = this.f489379k;
        if (r131 == null) goto L47;
        r101 = r131.hashCode();
    L47:
        return r130 + r101;
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
        return "ImmutableUplinkFileEntity(entityType=" + this.f489369a + ", uplinkEntityContent=" + this.f489370b + ", fileIdentifier=" + this.f489371c + ", fileReviewStatus=" + this.f489372d + ", fileParsedStatus=" + this.f489373e + ", upLinkProcess=" + this.f489374f + ", upLinkStatus=" + this.f489375g + ", isFromDraft=" + this.f489376h + ", uri=" + this.f489377i + ", isOriginalImageChecked=" + this.f489378j + ", extra=" + this.f489379k + ')';
    }

    public f(Integer r100, c r101, String r102, Integer r103, Integer r104, Integer r105, Integer r106, Boolean r107, Uri r108, Boolean r110, Map<String, String> r111) {
        this.f489369a = r100;
        this.f489370b = r101;
        this.f489371c = r102;
        this.f489372d = r103;
        this.f489373e = r104;
        this.f489374f = r105;
        this.f489375g = r106;
        this.f489376h = r107;
        this.f489377i = r108;
        this.f489378j = r110;
        this.f489379k = r111;
    }
}
