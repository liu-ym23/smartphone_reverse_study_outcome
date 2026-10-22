package fy;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f479173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f479174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f479175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f479176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f479177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f479178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f479179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Room f479180h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f479181i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f479182j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f479183k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f479184l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f479185m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Integer f479186n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f479187o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<String> f479188p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f479189q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f479190r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f479191s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f479192t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f479193u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f479194v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f479195w;

    public e() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L52;
        e r101 = (e) r100;
        if (this.f479173a == r101.f479173a) goto L8;
        return false;
    L8:
        if (this.f479174b == r101.f479174b) goto L10;
        return false;
    L10:
        if (this.f479175c == r101.f479175c) goto L12;
        return false;
    L12:
        if (this.f479176d == r101.f479176d) goto L14;
        return false;
    L14:
        if (this.f479177e == r101.f479177e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f479178f, r101.f479178f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f479179g, r101.f479179g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f479180h, r101.f479180h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f479181i, r101.f479181i) == true) goto L24;
        return false;
    L24:
        if (this.f479182j == r101.f479182j) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f479183k, r101.f479183k) == true) goto L28;
        return false;
    L28:
        if (this.f479184l == r101.f479184l) goto L30;
        return false;
    L30:
        if (this.f479185m == r101.f479185m) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f479186n, r101.f479186n) == true) goto L34;
        return false;
    L34:
        if (this.f479187o == r101.f479187o) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f479188p, r101.f479188p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f479189q, r101.f479189q) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.f479190r, r101.f479190r) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f479191s, r101.f479191s) == true) goto L44;
        return false;
    L44:
        if (this.f479192t == r101.f479192t) goto L46;
        return false;
    L46:
        if (this.f479193u == r101.f479193u) goto L48;
        return false;
    L48:
        if (this.f479194v == r101.f479194v) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.f479195w, r101.f479195w) == true) goto L79;
        return false;
    L79:
        return true;
    L52:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f479173a * 31;
        long r101 = this.f479174b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f479175c;
        int r104 = (((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f479176d) * 31) + this.f479177e) * 31;
        String r105 = this.f479178f;
        int r106 = 0;
        if (r105 == null) goto L5;
        int r107 = r105.hashCode();
    L6:
        int r108 = (r104 + r107) * 31;
        String r109 = this.f479179g;
        if (r109 == null) goto L9;
        int r110 = r109.hashCode();
    L10:
        int r111 = (r108 + r110) * 31;
        Room r112 = this.f479180h;
        if (r112 == null) goto L13;
        int r113 = r112.hashCode();
    L14:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f479181i;
        if (r115 == null) goto L17;
        int r116 = r115.hashCode();
    L18:
        int r117 = (((r114 + r116) * 31) + this.f479182j) * 31;
        String r118 = this.f479183k;
        if (r118 == null) goto L21;
        int r119 = r118.hashCode();
    L22:
        long r120 = this.f479184l;
        int r121 = (((((r117 + r119) * 31) + ((int) (r120 ^ (r120 >>> 32)))) * 31) + this.f479185m) * 31;
        Integer r122 = this.f479186n;
        if (r122 == null) goto L25;
        int r123 = r122.hashCode();
    L26:
        int r124 = (((r121 + r123) * 31) + this.f479187o) * 31;
        List<String> r125 = this.f479188p;
        if (r125 == null) goto L29;
        int r126 = r125.hashCode();
    L30:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f479189q;
        if (r128 == null) goto L33;
        int r129 = r128.hashCode();
    L34:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f479190r;
        if (r131 == null) goto L37;
        int r132 = r131.hashCode();
    L38:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f479191s;
        if (r134 == null) goto L41;
        int r135 = r134.hashCode();
    L42:
        int r136 = (((((r133 + r135) * 31) + this.f479192t) * 31) + this.f479193u) * 31;
        long r137 = this.f479194v;
        int r138 = (r136 + ((int) (r137 ^ (r137 >>> 32)))) * 31;
        String r139 = this.f479195w;
        if (r139 == null) goto L46;
        r106 = r139.hashCode();
    L46:
        return r138 + r106;
    L41:
        r135 = 0;
        goto L42
    L37:
        r132 = 0;
        goto L38
    L33:
        r129 = 0;
        goto L34
    L29:
        r126 = 0;
        goto L30
    L25:
        r123 = 0;
        goto L26
    L21:
        r119 = 0;
        goto L22
    L17:
        r116 = 0;
        goto L18
    L13:
        r113 = 0;
        goto L14
    L9:
        r110 = 0;
        goto L10
    L5:
        r107 = 0;
        goto L6
    }

    public final String toString() {
        return "InviteParams(scene=" + this.f479173a + ", roomId=" + this.f479174b + ", toRoomId=" + this.f479175c + ", inviteType=" + this.f479176d + ", matchType=" + this.f479177e + ", toUserId=" + this.f479178f + ", secToUserId=" + this.f479179g + ", targetRoom=" + this.f479180h + ", theme=" + this.f479181i + ", duration=" + this.f479182j + ", activityName=" + this.f479183k + ", matchSubType=" + this.f479184l + ", inviteSource=" + this.f479185m + ", multiPkMode=" + this.f479186n + ", inviteeScene=" + this.f479187o + ", inviteeUserIds=" + this.f479188p + ", battleConfigSettingStr=" + this.f479189q + ", panelType=" + this.f479190r + ", battleAttachedInfo=" + this.f479191s + ", inviterRoomStatus=" + this.f479192t + ", inviteIndex=" + this.f479193u + ", stayDuration=" + this.f479194v + ", clientAttachedInfo=" + this.f479195w + ")";
    }

    public /* synthetic */ e(int r310, long r311, long r312, int r313, int r314, String r315, String r410, Room r411, String r412, String r413, int r414, List r415, String r416, String r417, int r418) {
        if ((r418 & 256) == 0) goto L5;
        String r110 = "";
    L7:
        if ((r418 & 1024) == 0) goto L9;
        String r111 = "";
    L11:
        if ((r418 & 4096) == 0) goto L13;
        int r112 = 0;
    L15:
        if ((32768 & r418) == 0) goto L17;
        List r210 = null;
    L19:
        if ((65536 & r418) == 0) goto L21;
        String r211 = "";
    L23:
        if ((131072 & r418) == 0) goto L25;
        String r212 = null;
    L27:
        if ((262144 & r418) == 0) goto L29;
        String r213 = "";
    L31:
        if ((r418 & 4194304) == 0) goto L33;
        String r316 = "";
    L34:
        this(r310, r311, r312, r313, r314, r315, r410, r411, r110, 0, r111, 0, r112, null, 0, r210, r211, r212, r213, 0, 0, 0, r316);
        return;
    L33:
        r316 = null;
        goto L34
    L29:
        r213 = r417;
        goto L31
    L25:
        r212 = r416;
        goto L27
    L21:
        r211 = null;
        goto L23
    L17:
        r210 = r415;
        goto L19
    L13:
        r112 = r414;
        goto L15
    L9:
        r111 = r413;
        goto L11
    L5:
        r110 = r412;
        goto L7
    }

    public e(int r100, long r110, long r111, int r112, int r113, String r114, String r115, Room r116, String r117, int r210, String r211, long r212, int r213, Integer r214, int r215, List<String> r216, String r217, String r218, String r310, int r311, int r312, long r313, String r314) {
        Intrinsics.checkNotNullParameter(r114, "toUserId");
        Intrinsics.checkNotNullParameter(r115, "secToUserId");
        Intrinsics.checkNotNullParameter(r116, "targetRoom");
        Intrinsics.checkNotNullParameter(r211, "activityName");
        Intrinsics.checkNotNullParameter(r314, "clientAttachedInfo");
        this.f479173a = r100;
        this.f479174b = r110;
        this.f479175c = r111;
        this.f479176d = r112;
        this.f479177e = r113;
        this.f479178f = r114;
        this.f479179g = r115;
        this.f479180h = r116;
        this.f479181i = r117;
        this.f479182j = r210;
        this.f479183k = r211;
        this.f479184l = r212;
        this.f479185m = r213;
        this.f479186n = r214;
        this.f479187o = r215;
        this.f479188p = r216;
        this.f479189q = r217;
        this.f479190r = r218;
        this.f479191s = r310;
        this.f479192t = r311;
        this.f479193u = r312;
        this.f479194v = r313;
        this.f479195w = r314;
    }
}
