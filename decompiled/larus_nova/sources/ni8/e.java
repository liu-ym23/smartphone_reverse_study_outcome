package ni8;

import android.os.Bundle;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.platform.model.RecommendFrom;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f519352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f519353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f519354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f519355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f519356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f519357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f519358g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConversationPage f519359h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f519360i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f519361j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f519362k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Integer f519363l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<Integer> f519364m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Integer f519365n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f519366o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RecommendFrom f519367p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f519368q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f519369r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f519370s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Bundle f519371t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f519372u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f519373v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f519374w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f519375x;

    public e() {
        this(null, null, null, false, false, false, 0, null, null, null, null, null, null, 0, null, null, null, null, null, null, 0, 0, 0, 16777215);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f519352a, r101.f519352a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f519353b, r101.f519353b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f519354c, r101.f519354c) == true) goto L18;
        return false;
    L18:
        if (this.f519355d == r101.f519355d) goto L21;
        return false;
    L21:
        if (this.f519356e == r101.f519356e) goto L24;
        return false;
    L24:
        if (this.f519357f == r101.f519357f) goto L27;
        return false;
    L27:
        if (this.f519358g == r101.f519358g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f519359h, r101.f519359h) == true) goto L33;
        return false;
    L33:
        if (this.f519360i == r101.f519360i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f519361j, r101.f519361j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f519362k, r101.f519362k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f519363l, r101.f519363l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f519364m, r101.f519364m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f519365n, r101.f519365n) == true) goto L51;
        return false;
    L51:
        if (this.f519366o == r101.f519366o) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f519367p, r101.f519367p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f519368q, r101.f519368q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f519369r, r101.f519369r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f519370s, r101.f519370s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f519371t, r101.f519371t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f519372u, r101.f519372u) == true) goto L72;
        return false;
    L72:
        if (this.f519373v == r101.f519373v) goto L75;
        return false;
    L75:
        if (this.f519374w == r101.f519374w) goto L78;
        return false;
    L78:
        if (this.f519375x == r101.f519375x) goto L80;
        return false;
    L80:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f519352a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f519353b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f519354c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        int r110 = 1231;
        if (this.f519355d == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.f519356e == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        if (this.f519357f == false) goto L25;
        int r115 = 1231;
    L26:
        int r116 = (((r114 + r115) * 31) + this.f519358g) * 31;
        ConversationPage r117 = this.f519359h;
        if (r117 != null) goto L29;
        int r118 = 0;
    L30:
        int r119 = (r116 + r118) * 31;
        if (this.f519360i == true) goto L34;
        r110 = 1237;
    L34:
        int r120 = (r119 + r110) * 31;
        String r121 = this.f519361j;
        if (r121 != null) goto L37;
        int r122 = 0;
    L38:
        int r123 = (r120 + r122) * 31;
        String r124 = this.f519362k;
        if (r124 != null) goto L41;
        int r125 = 0;
    L42:
        int r126 = (r123 + r125) * 31;
        Integer r127 = this.f519363l;
        if (r127 != null) goto L45;
        int r128 = 0;
    L46:
        int r129 = (((r126 + r128) * 31) + this.f519364m.hashCode()) * 31;
        Integer r130 = this.f519365n;
        if (r130 != null) goto L49;
        int r131 = 0;
    L50:
        int r132 = (r129 + r131) * 31;
        long r133 = this.f519366o;
        int r134 = (r132 + ((int) (r133 ^ (r133 >>> 32)))) * 31;
        RecommendFrom r135 = this.f519367p;
        if (r135 != null) goto L53;
        int r136 = 0;
    L54:
        int r137 = (r134 + r136) * 31;
        String r138 = this.f519368q;
        if (r138 != null) goto L57;
        int r139 = 0;
    L58:
        int r140 = (r137 + r139) * 31;
        String r141 = this.f519369r;
        if (r141 != null) goto L61;
        int r142 = 0;
    L62:
        int r143 = (r140 + r142) * 31;
        String r144 = this.f519370s;
        if (r144 != null) goto L65;
        int r145 = 0;
    L66:
        int r146 = (r143 + r145) * 31;
        Bundle r147 = this.f519371t;
        if (r147 != null) goto L69;
        int r148 = 0;
    L70:
        int r149 = (r146 + r148) * 31;
        String r150 = this.f519372u;
        if (r150 == null) goto L74;
        r101 = r150.hashCode();
    L74:
        int r151 = (((((r149 + r101) * 31) + this.f519373v) * 31) + this.f519374w) * 31;
        long r152 = this.f519375x;
        return r151 + ((int) (r152 ^ (r152 >>> 32)));
    L69:
        r148 = r147.hashCode();
        goto L70
    L65:
        r145 = r144.hashCode();
        goto L66
    L61:
        r142 = r141.hashCode();
        goto L62
    L57:
        r139 = r138.hashCode();
        goto L58
    L53:
        r136 = r135.hashCode();
        goto L54
    L49:
        r131 = r130.hashCode();
        goto L50
    L45:
        r128 = r127.hashCode();
        goto L46
    L41:
        r125 = r124.hashCode();
        goto L42
    L37:
        r122 = r121.hashCode();
        goto L38
    L29:
        r118 = r117.hashCode();
        goto L30
    L25:
        r115 = 1237;
        goto L26
    L21:
        r113 = 1237;
        goto L22
    L17:
        r111 = 1237;
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
        return "SwitchConversationParams(cvsId=" + this.f519352a + ", bgImgUrl=" + this.f519353b + ", bgImgColor=" + this.f519354c + ", bgImgOpen=" + this.f519355d + ", isShowTab=" + this.f519356e + ", isCallBot=" + this.f519357f + ", defaultTab=" + this.f519358g + ", conversationPage=" + this.f519359h + ", isSub=" + this.f519360i + ", botId=" + this.f519361j + ", clickEnterFrom=" + this.f519362k + ", conversationType=" + this.f519363l + ", pageList=" + this.f519364m + ", botType=" + this.f519365n + ", localIndex=" + this.f519366o + ", recommendFrom=" + this.f519367p + ", messageId=" + this.f519368q + ", searchKeyword=" + this.f519369r + ", searchHighlightKeyword=" + this.f519370s + ", callBotParam=" + this.f519371t + ", chatTitle=" + this.f519372u + ", botConversationType=" + this.f519373v + ", redDotEntryUnreadCount=" + this.f519374w + ", redDotEntryReadMessageIndex=" + this.f519375x + ')';
    }

    public /* synthetic */ e(String r310, String r311, String r312, boolean r313, boolean r314, boolean r315, int r316, ConversationPage r317, String r410, String r411, Integer r412, List r413, Integer r414, long r415, RecommendFrom r416, String r417, String r418, String r510, Bundle r511, String r512, int r513, int r514, long r515, int r516) {
        String r100 = null;
        if ((r516 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r516 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r516 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r516 & 8) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r516 & 16) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r516 & 32) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r516 & 64) == 0) goto L29;
        int r110 = 0;
    L31:
        if ((r516 & 128) == 0) goto L33;
        ConversationPage r111 = null;
    L35:
        if ((r516 & 512) == 0) goto L37;
        String r107 = "";
    L39:
        if ((r516 & 1024) == 0) goto L41;
        String r112 = "";
    L43:
        if ((r516 & 2048) == 0) goto L45;
        Integer r113 = null;
    L47:
        if ((r516 & 4096) == 0) goto L49;
        List r114 = CollectionsKt.emptyList();
    L51:
        if ((r516 & 8192) == 0) goto L53;
        Integer r115 = null;
    L55:
        if ((r516 & 16384) == 0) goto L57;
        long r210 = -1;
    L59:
        if ((32768 & r516) == 0) goto L61;
        RecommendFrom r211 = null;
    L63:
        if ((65536 & r516) == 0) goto L65;
        String r212 = null;
    L67:
        if ((131072 & r516) == 0) goto L69;
        String r213 = null;
    L71:
        if ((262144 & r516) == 0) goto L73;
        String r214 = null;
    L75:
        if ((524288 & r516) == 0) goto L77;
        Bundle r215 = null;
    L79:
        if ((1048576 & r516) != 0) goto L83;
        r100 = r512;
    L83:
        if ((2097152 & r516) == 0) goto L85;
        int r216 = 0;
    L87:
        if ((4194304 & r516) == 0) goto L89;
        int r217 = 0;
    L91:
        if ((r516 & 8388608) == 0) goto L93;
        long r218 = -1;
    L94:
        this(r101, r102, r103, r104, r105, r106, r110, r111, false, r107, r112, r113, r114, r115, r210, r211, r212, r213, r214, r215, r100, r216, r217, r218);
        return;
    L93:
        r218 = r515;
        goto L94
    L89:
        r217 = r514;
        goto L91
    L85:
        r216 = r513;
        goto L87
    L77:
        r215 = r511;
        goto L79
    L73:
        r214 = r510;
        goto L75
    L69:
        r213 = r418;
        goto L71
    L65:
        r212 = r417;
        goto L67
    L61:
        r211 = r416;
        goto L63
    L57:
        r210 = r415;
        goto L59
    L53:
        r115 = r414;
        goto L55
    L49:
        r114 = r413;
        goto L51
    L45:
        r113 = r412;
        goto L47
    L41:
        r112 = r411;
        goto L43
    L37:
        r107 = r410;
        goto L39
    L33:
        r111 = r317;
        goto L35
    L29:
        r110 = r316;
        goto L31
    L25:
        r106 = r315;
        goto L27
    L21:
        r105 = r314;
        goto L23
    L17:
        r104 = r313;
        goto L19
    L13:
        r103 = r312;
        goto L15
    L9:
        r102 = r311;
        goto L11
    L5:
        r101 = r310;
        goto L7
    }

    public e(String r100, String r101, String r102, boolean r103, boolean r104, boolean r105, int r110, ConversationPage r111, boolean r112, String r113, String r114, Integer r115, List<Integer> r116, Integer r117, long r118, RecommendFrom r210, String r211, String r212, String r213, Bundle r214, String r215, int r216, int r217, long r218) {
        Intrinsics.checkNotNullParameter(r116, "pageList");
        this.f519352a = r100;
        this.f519353b = r101;
        this.f519354c = r102;
        this.f519355d = r103;
        this.f519356e = r104;
        this.f519357f = r105;
        this.f519358g = r110;
        this.f519359h = r111;
        this.f519360i = r112;
        this.f519361j = r113;
        this.f519362k = r114;
        this.f519363l = r115;
        this.f519364m = r116;
        this.f519365n = r117;
        this.f519366o = r118;
        this.f519367p = r210;
        this.f519368q = r211;
        this.f519369r = r212;
        this.f519370s = r213;
        this.f519371t = r214;
        this.f519372u = r215;
        this.f519373v = r216;
        this.f519374w = r217;
        this.f519375x = r218;
    }
}
