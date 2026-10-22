package fj;

import com.bytedance.android.ec.model.response.u1;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Map<String, String> f477432r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f477433s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f477434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f477435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f477436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f477437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f477438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f477439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f477440g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f477441h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f477442i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f477443j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f477444k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f477445l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f477446m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f477447n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f477448o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f477449p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Object f477450q;

    public static final class a {
        public a() {
        }

        public static d a(HashMap r210) {
            Object r100 = null;
            if (r210 != null) goto L5;
            return null;
        L5:
            Object r101 = r210.get("main_url");
            if ((r101 instanceof String) == true) goto L8;
            r101 = null;
        L8:
            String r102 = (String) r101;
            if (r102 != null) goto L11;
            return null;
        L11:
            Object r103 = r210.get(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL);
            if ((r103 instanceof String) == true) goto L14;
            r103 = null;
        L14:
            String r104 = (String) r103;
            if ((r210.get("duration") instanceof Integer) == false) goto L25;
            Object r105 = r210.get("duration");
            if ((r105 instanceof Integer) == true) goto L19;
            r105 = null;
        L19:
            Integer r106 = (Integer) r105;
            if (r106 == null) goto L23;
            long r107 = r106.intValue();
        L22:
            long r110 = r107;
            if ((r210.get("width") instanceof Integer) == false) goto L54;
            Object r108 = r210.get("width");
            if ((r108 instanceof Integer) == true) goto L48;
            r108 = null;
        L48:
            Integer r109 = (Integer) r108;
            if (r109 == null) goto L52;
            long r111 = r109.intValue();
        L51:
            long r112 = r111;
            if ((r210.get("height") instanceof Integer) == false) goto L74;
            Object r113 = r210.get("height");
            if ((r113 instanceof Integer) == true) goto L68;
            r113 = null;
        L68:
            Integer r114 = (Integer) r113;
            if (r114 == null) goto L72;
            long r115 = r114.intValue();
        L71:
            long r116 = r115;
            Object r117 = r210.get("vid");
            if ((r117 instanceof String) == true) goto L86;
            r117 = null;
        L86:
            String r118 = (String) r117;
            if (r118 != null) goto L89;
            return null;
        L89:
            Object r119 = r210.get("poster_url");
            if ((r119 instanceof String) == true) goto L92;
            r119 = null;
        L92:
            String r120 = (String) r119;
            Object r121 = r210.get("need_add_cookie");
            if ((r121 instanceof Boolean) == false) goto L96;
            r100 = r121;
        L96:
            Boolean r122 = (Boolean) r100;
            if (r122 == null) goto L99;
            boolean r211 = r122.booleanValue();
        L101:
            return new d(r102, r104, r118, r112, r116, r110, r120, false, false, false, false, false, null, r211, 0, null, null, 122752);
        L99:
            r211 = false;
            goto L101
        L72:
            return null;
        L74:
            if ((r210.get("height") instanceof String) == false) goto L102;
            Object r123 = r210.get("height");
            if ((r123 instanceof String) == true) goto L78;
            r123 = null;
        L78:
            String r124 = (String) r123;
            if (r124 == null) goto L102;
            Long r125 = StringsKt.toLongOrNull(r124);
            if (r125 == null) goto L102;
            r115 = r125.longValue();
        L102:
            return null;
        L52:
            return null;
        L54:
            if ((r210.get("width") instanceof String) == false) goto L102;
            Object r126 = r210.get("width");
            if ((r126 instanceof String) == true) goto L58;
            r126 = null;
        L58:
            String r127 = (String) r126;
            if (r127 == null) goto L102;
            Long r128 = StringsKt.toLongOrNull(r127);
            if (r128 == null) goto L102;
            r111 = r128.longValue();
            goto L51
        L23:
            return null;
        L25:
            if ((r210.get("duration") instanceof Long) == false) goto L34;
            Object r129 = r210.get("duration");
            if ((r129 instanceof Long) == true) goto L29;
            r129 = null;
        L29:
            Long r130 = (Long) r129;
            if (r130 == null) goto L32;
            r107 = r130.longValue();
            goto L22
        L32:
            return null;
        L34:
            if ((r210.get("duration") instanceof String) == false) goto L102;
            Object r131 = r210.get("duration");
            if ((r131 instanceof String) == true) goto L38;
            r131 = null;
        L38:
            String r132 = (String) r131;
            if (r132 == null) goto L102;
            Long r133 = StringsKt.toLongOrNull(r132);
            if (r133 == null) goto L102;
            r107 = r133.longValue();
            goto L22
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L40;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f477434a, r101.f477434a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f477435b, r101.f477435b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f477436c, r101.f477436c) == true) goto L12;
        return false;
    L12:
        if (this.f477437d == r101.f477437d) goto L14;
        return false;
    L14:
        if (this.f477438e == r101.f477438e) goto L16;
        return false;
    L16:
        if (this.f477439f == r101.f477439f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f477440g, r101.f477440g) == true) goto L20;
        return false;
    L20:
        if (this.f477441h == r101.f477441h) goto L22;
        return false;
    L22:
        if (this.f477442i == r101.f477442i) goto L24;
        return false;
    L24:
        if (this.f477443j == r101.f477443j) goto L26;
        return false;
    L26:
        if (this.f477444k == r101.f477444k) goto L28;
        return false;
    L28:
        if (this.f477445l == r101.f477445l) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f477446m, r101.f477446m) == true) goto L32;
        return false;
    L32:
        if (this.f477447n == r101.f477447n) goto L34;
        return false;
    L34:
        if (this.f477448o == r101.f477448o) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f477449p, r101.f477449p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f477450q, r101.f477450q) == true) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22, types: [int] */
    /* JADX WARN: Type inference failed for: r2v24, types: [int] */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v6 */
    public final int hashCode() {
        String r100 = this.f477434a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f477435b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f477436c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.f477437d;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.f477438e;
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        long r114 = this.f477439f;
        int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        String r116 = this.f477440g;
        if (r116 == null) goto L17;
        int r117 = r116.hashCode();
    L18:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.f477441h;
        ?? r120 = 1;
        ?? r121 = r119;
        if (r119 == false) goto L21;
        r121 = 1;
    L21:
        int r122 = (r118 + r121) * 31;
        boolean r123 = this.f477442i;
        ?? r124 = r123;
        if (r123 == false) goto L24;
        r124 = 1;
    L24:
        int r125 = (r122 + r124) * 31;
        boolean r126 = this.f477443j;
        ?? r127 = r126;
        if (r126 == false) goto L27;
        r127 = 1;
    L27:
        int r128 = (r125 + r127) * 31;
        boolean r129 = this.f477444k;
        ?? r130 = r129;
        if (r129 == false) goto L30;
        r130 = 1;
    L30:
        int r131 = (r128 + r130) * 31;
        boolean r132 = this.f477445l;
        ?? r133 = r132;
        if (r132 == false) goto L33;
        r133 = 1;
    L33:
        int r134 = (r131 + r133) * 31;
        Integer r135 = this.f477446m;
        if (r135 == null) goto L36;
        int r136 = r135.hashCode();
    L37:
        int r137 = (r134 + r136) * 31;
        boolean r138 = this.f477447n;
        if (r138 == true) goto L41;
        r120 = r138;
    L41:
        long r139 = this.f477448o;
        int r140 = (((r137 + r120) * 31) + ((int) (r139 ^ (r139 >>> 32)))) * 31;
        String r141 = this.f477449p;
        if (r141 == null) goto L44;
        int r142 = r141.hashCode();
    L45:
        int r143 = (r140 + r142) * 31;
        Object r144 = this.f477450q;
        if (r144 == null) goto L49;
        r101 = r144.hashCode();
    L49:
        return r143 + r101;
    L44:
        r142 = 0;
        goto L45
    L36:
        r136 = 0;
        goto L37
    L17:
        r117 = 0;
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
        return "PlayInfo(playAddress=" + this.f477434a + ", backupUrl=" + this.f477435b + ", videoId=" + this.f477436c + ", width=" + this.f477437d + ", height=" + this.f477438e + ", duration=" + this.f477439f + ", posterUrl=" + this.f477440g + ", autoPlay=" + this.f477441h + ", isMute=" + this.f477442i + ", repeat=" + this.f477443j + ", keepPosition=" + this.f477444k + ", needCenterCorp=" + this.f477445l + ", sourceType=" + this.f477446m + ", needAddCookie=" + this.f477447n + ", initialStartTimeMs=" + this.f477448o + ", itemId=" + this.f477449p + ", extraInfo=" + this.f477450q + ")";
    }

    static {
        f477433s = new a();
        f477432r = new LinkedHashMap();
    }

    public d(String r110, String r111, String r112, long r210, long r211, long r212, String r213, boolean r214, boolean r215, boolean r216, boolean r310, boolean r311, Integer r312, boolean r313, long r314, String r315, u1 r316, int r317) {
        u1 r100 = null;
        if ((r317 & 64) == 0) goto L5;
        String r101 = null;
    L6:
        boolean r102 = false;
        if ((r317 & 128) == 0) goto L9;
        boolean r103 = false;
    L11:
        if ((r317 & 256) == 0) goto L13;
        boolean r104 = true;
    L15:
        if ((r317 & 512) == 0) goto L17;
        boolean r105 = false;
    L19:
        if ((r317 & 1024) == 0) goto L21;
        boolean r106 = false;
    L23:
        if ((r317 & 2048) == 0) goto L25;
        boolean r107 = false;
    L27:
        if ((r317 & 4096) == 0) goto L29;
        Integer r113 = null;
    L31:
        if ((r317 & 8192) != 0) goto L35;
        r102 = r313;
    L35:
        if ((r317 & 16384) == 0) goto L37;
        long r114 = 0;
    L39:
        if ((32768 & r317) == 0) goto L41;
        String r115 = null;
    L43:
        if ((r317 & 65536) != 0) goto L46;
        r100 = r316;
    L46:
        this.f477434a = r110;
        this.f477435b = r111;
        this.f477436c = r112;
        this.f477437d = r210;
        this.f477438e = r211;
        this.f477439f = r212;
        this.f477440g = r101;
        this.f477441h = r103;
        this.f477442i = r104;
        this.f477443j = r105;
        this.f477444k = r106;
        this.f477445l = r107;
        this.f477446m = r113;
        this.f477447n = r102;
        this.f477448o = r114;
        this.f477449p = r115;
        this.f477450q = r100;
        return;
    L41:
        r115 = r315;
        goto L43
    L37:
        r114 = r314;
        goto L39
    L29:
        r113 = r312;
        goto L31
    L25:
        r107 = r311;
        goto L27
    L21:
        r106 = r310;
        goto L23
    L17:
        r105 = r216;
        goto L19
    L13:
        r104 = r215;
        goto L15
    L9:
        r103 = r214;
        goto L11
    L5:
        r101 = r213;
        goto L6
    }
}
