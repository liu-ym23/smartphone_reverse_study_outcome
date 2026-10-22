package d11;

import com.bytedance.android.livesdk.link.model.bridge.g1;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f466251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f466252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f466253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.link.model.bridge.p f466254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f466255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f466256f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f466257g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f466258h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f466259i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f466260j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g1 f466261k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f466262l;

    public a() {
        this(0, 0, 0, null, false, false, false, null, 0, null, null, null, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L30;
        a r101 = (a) r100;
        if (this.f466251a == r101.f466251a) goto L8;
        return false;
    L8:
        if (this.f466252b == r101.f466252b) goto L10;
        return false;
    L10:
        if (this.f466253c == r101.f466253c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f466254d, r101.f466254d) == true) goto L14;
        return false;
    L14:
        if (this.f466255e == r101.f466255e) goto L16;
        return false;
    L16:
        if (this.f466256f == r101.f466256f) goto L18;
        return false;
    L18:
        if (this.f466257g == r101.f466257g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f466258h, r101.f466258h) == true) goto L22;
        return false;
    L22:
        if (this.f466259i == r101.f466259i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f466260j, r101.f466260j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f466261k, r101.f466261k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f466262l, r101.f466262l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        int r100 = ((((this.f466251a * 31) + this.f466252b) * 31) + this.f466253c) * 31;
        com.bytedance.android.livesdk.link.model.bridge.p r101 = this.f466254d;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.f466255e;
        ?? r106 = 1;
        ?? r107 = r105;
        if (r105 == false) goto L9;
        r107 = 1;
    L9:
        int r108 = (r104 + r107) * 31;
        boolean r109 = this.f466256f;
        ?? r110 = r109;
        if (r109 == false) goto L12;
        r110 = 1;
    L12:
        int r111 = (r108 + r110) * 31;
        boolean r112 = this.f466257g;
        if (r112 == true) goto L16;
        r106 = r112;
    L16:
        int r113 = (r111 + r106) * 31;
        String r114 = this.f466258h;
        if (r114 == null) goto L19;
        int r115 = r114.hashCode();
    L20:
        int r116 = (((r113 + r115) * 31) + this.f466259i) * 31;
        String r117 = this.f466260j;
        if (r117 == null) goto L23;
        int r118 = r117.hashCode();
    L24:
        int r119 = (r116 + r118) * 31;
        g1 r120 = this.f466261k;
        if (r120 == null) goto L27;
        int r121 = r120.hashCode();
    L28:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f466262l;
        if (r123 == null) goto L32;
        r102 = r123.hashCode();
    L32:
        return r122 + r102;
    L27:
        r121 = 0;
        goto L28
    L23:
        r118 = 0;
        goto L24
    L19:
        r115 = 0;
        goto L20
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorReplyParams{matchType=" + this.f466251a + ", inviteType=" + this.f466252b + ", inviteSource=" + this.f466253c + ", isMultiReply=" + this.f466256f + ", reqSrc=" + this.f466258h + ", pkSwitchMode=" + this.f466259i + '}';
    }

    public a(int r110, int r111, int r112, com.bytedance.android.livesdk.link.model.bridge.p r113, boolean r114, boolean r210, boolean r211, String r212, int r213, String r214, g1 r215, String r216, int r217) {
        int r100 = 0;
        if ((r217 & 1) == 0) goto L5;
        int r101 = 0;
    L7:
        if ((r217 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r217 & 4) == 0) goto L13;
        int r103 = 0;
    L14:
        String r104 = null;
        if ((r217 & 8) == 0) goto L17;
        com.bytedance.android.livesdk.link.model.bridge.p r105 = null;
    L19:
        if ((r217 & 16) == 0) goto L21;
        boolean r106 = false;
    L23:
        if ((r217 & 32) == 0) goto L25;
        boolean r107 = false;
    L27:
        if ((r217 & 64) == 0) goto L29;
        boolean r115 = false;
    L31:
        if ((r217 & 128) == 0) goto L33;
        String r116 = "";
    L35:
        if ((r217 & 256) != 0) goto L39;
        r100 = r213;
    L39:
        if ((r217 & 512) == 0) goto L41;
        String r117 = null;
    L43:
        if ((r217 & 1024) == 0) goto L45;
        g1 r118 = null;
    L47:
        if ((r217 & 2048) != 0) goto L50;
        r104 = r216;
    L50:
        Intrinsics.checkNotNullParameter(r116, "reqSrc");
        this.f466251a = r101;
        this.f466252b = r102;
        this.f466253c = r103;
        this.f466254d = r105;
        this.f466255e = r106;
        this.f466256f = r107;
        this.f466257g = r115;
        this.f466258h = r116;
        this.f466259i = r100;
        this.f466260j = r117;
        this.f466261k = r118;
        this.f466262l = r104;
        return;
    L45:
        r118 = r215;
        goto L47
    L41:
        r117 = r214;
        goto L43
    L33:
        r116 = r212;
        goto L35
    L29:
        r115 = r211;
        goto L31
    L25:
        r107 = r210;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L14
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
