package kq9;

import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f505618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f505619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f505620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f505621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f505622e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f505623f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f505624g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f505625h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f505626i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Boolean f505627j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f505628k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f505629l;

    public e() {
        this(null, null, 0, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f505618a, r101.f505618a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f505619b, r101.f505619b) == true) goto L15;
        return false;
    L15:
        if (this.f505620c == r101.f505620c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f505621d, r101.f505621d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f505622e, r101.f505622e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f505623f, r101.f505623f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f505624g, r101.f505624g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f505625h, r101.f505625h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f505626i, r101.f505626i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f505627j, r101.f505627j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f505628k, r101.f505628k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f505629l, r101.f505629l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f505618a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f505619b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f505620c) * 31;
        String r107 = this.f505621d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f505622e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f505623f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f505624g;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f505625h;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f505626i;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.f505627j;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.f505628k;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f505629l;
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
        return "AlbumTraceInfo(botId=" + this.f505618a + ", conversationId=" + this.f505619b + ", botConversationType=" + this.f505620c + ", chatType=" + this.f505621d + ", previousPage=" + this.f505622e + ", clickFrom=" + this.f505623f + ", referenceFromType=" + this.f505624g + ", referenceMessageId=" + this.f505625h + ", tracePreviousCameraTabName=" + this.f505626i + ", isAiDoc=" + this.f505627j + ", isReplicaCreate=" + this.f505628k + ", replicaCreateId=" + this.f505629l + ')';
    }

    public e(String r100, String r101, int r102, String r103, String r104, String r105, String r106, String r110, String r111, Boolean r112, Boolean r113, String r114, int r115) {
        if ((r115 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r115 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r115 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r115 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r115 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r115 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r115 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r115 & 128) == 0) goto L27;
        r110 = null;
    L27:
        if ((r115 & 256) == 0) goto L30;
        r111 = null;
    L30:
        if ((r115 & 512) == 0) goto L33;
        r112 = null;
    L33:
        if ((r115 & 1024) == 0) goto L36;
        r113 = null;
    L36:
        if ((r115 & 2048) == 0) goto L38;
        r114 = null;
    L38:
        this.f505618a = r100;
        this.f505619b = r101;
        this.f505620c = r102;
        this.f505621d = r103;
        this.f505622e = r104;
        this.f505623f = r105;
        this.f505624g = r106;
        this.f505625h = r110;
        this.f505626i = r111;
        this.f505627j = r112;
        this.f505628k = r113;
        this.f505629l = r114;
    }
}
