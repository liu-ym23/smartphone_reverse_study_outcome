package v9b;

import com.ss.android.lark.chat.entity.message.Message;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f553886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f553887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f553888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f553889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f553890e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f553891f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f553892g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f553893h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f553894i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<String> f553895j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f553896k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f553897l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f553898m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Message.Type f553899n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<Integer> f553900o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<String> f553901p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f553902q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f553903r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f553904s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f553905t;

    public a() {
        this(null, null, null, false, false, false, false, false, false, null, 0, null, null, null, null, null, false, false, false, 1048575);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f553886a, r101.f553886a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f553887b, r101.f553887b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f553888c, r101.f553888c) == true) goto L18;
        return false;
    L18:
        if (this.f553889d == r101.f553889d) goto L21;
        return false;
    L21:
        if (this.f553890e == r101.f553890e) goto L24;
        return false;
    L24:
        if (this.f553891f == r101.f553891f) goto L27;
        return false;
    L27:
        if (this.f553892g == r101.f553892g) goto L30;
        return false;
    L30:
        if (this.f553893h == r101.f553893h) goto L33;
        return false;
    L33:
        if (this.f553894i == r101.f553894i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f553895j, r101.f553895j) == true) goto L39;
        return false;
    L39:
        if (this.f553896k == r101.f553896k) goto L42;
        return false;
    L42:
        if (this.f553897l == r101.f553897l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f553898m, r101.f553898m) == true) goto L48;
        return false;
    L48:
        if (this.f553899n == r101.f553899n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f553900o, r101.f553900o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f553901p, r101.f553901p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f553902q, r101.f553902q) == true) goto L60;
        return false;
    L60:
        if (this.f553903r == r101.f553903r) goto L63;
        return false;
    L63:
        if (this.f553904s == r101.f553904s) goto L66;
        return false;
    L66:
        if (this.f553905t == r101.f553905t) goto L68;
        return false;
    L68:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f553886a.hashCode() * 31) + this.f553887b.hashCode()) * 31) + this.f553888c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f553889d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f553890e == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f553891f == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f553892g == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f553893h == false) goto L21;
        int r110 = 1231;
    L22:
        int r111 = (r109 + r110) * 31;
        if (this.f553894i == false) goto L25;
        int r112 = 1231;
    L26:
        int r113 = (((((r111 + r112) * 31) + this.f553895j.hashCode()) * 31) + this.f553896k) * 31;
        if (this.f553897l == false) goto L29;
        int r114 = 1231;
    L30:
        int r115 = (((((((r113 + r114) * 31) + this.f553898m.hashCode()) * 31) + this.f553899n.hashCode()) * 31) + this.f553900o.hashCode()) * 31;
        List<String> r116 = this.f553901p;
        int r117 = 0;
        if (r116 != null) goto L33;
        int r118 = 0;
    L34:
        int r119 = (r115 + r118) * 31;
        String r120 = this.f553902q;
        if (r120 == null) goto L38;
        r117 = r120.hashCode();
    L38:
        int r121 = (r119 + r117) * 31;
        if (this.f553903r == false) goto L41;
        int r122 = 1231;
    L42:
        int r123 = (r121 + r122) * 31;
        if (this.f553904s == false) goto L45;
        int r124 = 1231;
    L46:
        int r125 = (r123 + r124) * 31;
        if (this.f553905t == true) goto L51;
        r101 = 1237;
    L51:
        return r125 + r101;
    L45:
        r124 = 1237;
        goto L46
    L41:
        r122 = 1237;
        goto L42
    L33:
        r118 = r116.hashCode();
        goto L34
    L29:
        r114 = 1237;
        goto L30
    L25:
        r112 = 1237;
        goto L26
    L21:
        r110 = 1237;
        goto L22
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "MessageContextData(messageId=" + this.f553886a + ", botIdList=" + this.f553887b + ", atReadUserList=" + this.f553888c + ", isFromMe=" + this.f553889d + ", isEdit=" + this.f553890e + ", isGroupAnnouncement=" + this.f553891f + ", isPreMessage=" + this.f553892g + ", isSecretMessage=" + this.f553893h + ", isSteamTransporting=" + this.f553894i + ", myAIRunningToolsIds=" + this.f553895j + ", contentCharacterLen=" + this.f553896k + ", isContentTranslated=" + this.f553897l + ", fromChatterTenantId=" + this.f553898m + ", messageType=" + this.f553899n + ", readStateList=" + this.f553900o + ", allAtChatterIds=" + this.f553901p + ", chatId=" + this.f553902q + ", isDing=" + this.f553903r + ", isTranslatedOnlyWithTranslation=" + this.f553904s + ", isLatestMessageFromAndFromMe=" + this.f553905t + ')';
    }

    public a(String r210, List r211, List r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r310, boolean r311, List r312, int r313, String r314, Message.Type r315, List r316, List r317, String r318, boolean r319, boolean r410, boolean r411, int r412) {
        String r100 = "";
        if ((r412 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r412 & 2) == 0) goto L9;
        List r102 = CollectionsKt.emptyList();
    L11:
        if ((r412 & 4) == 0) goto L13;
        List r103 = CollectionsKt.emptyList();
    L15:
        if ((r412 & 8) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r412 & 16) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r412 & 32) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r412 & 64) == 0) goto L29;
        boolean r110 = false;
    L31:
        if ((r412 & 128) == 0) goto L33;
        boolean r111 = false;
    L35:
        if ((r412 & 256) == 0) goto L37;
        boolean r112 = false;
    L39:
        if ((r412 & 512) == 0) goto L41;
        List r113 = CollectionsKt.emptyList();
    L43:
        if ((r412 & 1024) == 0) goto L45;
        int r114 = 0;
    L47:
        if ((r412 & 4096) != 0) goto L51;
        r100 = r314;
    L51:
        if ((r412 & 8192) == 0) goto L53;
        Message.Type r115 = Message.Type.UNKNOWN;
    L55:
        if ((r412 & 16384) == 0) goto L57;
        List r107 = CollectionsKt.emptyList();
    L59:
        if ((r412 & 32768) == 0) goto L61;
        List r116 = null;
    L63:
        if ((r412 & 65536) == 0) goto L65;
        String r117 = null;
    L67:
        if ((r412 & 131072) == 0) goto L69;
        boolean r217 = false;
    L71:
        if ((r412 & 262144) == 0) goto L73;
        boolean r218 = false;
    L75:
        if ((r412 & 524288) == 0) goto L77;
        boolean r118 = false;
    L78:
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r102, "botIdList");
        Intrinsics.checkNotNullParameter(r103, "atReadUserList");
        Intrinsics.checkNotNullParameter(r113, "myAIRunningToolsIds");
        Intrinsics.checkNotNullParameter(r100, "fromChatterTenantId");
        Intrinsics.checkNotNullParameter(r115, "messageType");
        Intrinsics.checkNotNullParameter(r107, "readStateList");
        this.f553886a = r101;
        this.f553887b = r102;
        this.f553888c = r103;
        this.f553889d = r104;
        this.f553890e = r105;
        this.f553891f = r106;
        this.f553892g = r110;
        this.f553893h = r111;
        this.f553894i = r112;
        this.f553895j = r113;
        this.f553896k = r114;
        this.f553897l = false;
        this.f553898m = r100;
        this.f553899n = r115;
        this.f553900o = r107;
        this.f553901p = r116;
        this.f553902q = r117;
        this.f553903r = r217;
        this.f553904s = r218;
        this.f553905t = r118;
        return;
    L77:
        r118 = r411;
        goto L78
    L73:
        r218 = r410;
        goto L75
    L69:
        r217 = r319;
        goto L71
    L65:
        r117 = r318;
        goto L67
    L61:
        r116 = r317;
        goto L63
    L57:
        r107 = r316;
        goto L59
    L53:
        r115 = r315;
        goto L55
    L45:
        r114 = r313;
        goto L47
    L41:
        r113 = r312;
        goto L43
    L37:
        r112 = r311;
        goto L39
    L33:
        r111 = r310;
        goto L35
    L29:
        r110 = r216;
        goto L31
    L25:
        r106 = r215;
        goto L27
    L21:
        r105 = r214;
        goto L23
    L17:
        r104 = r213;
        goto L19
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = r210;
        goto L7
    }
}
