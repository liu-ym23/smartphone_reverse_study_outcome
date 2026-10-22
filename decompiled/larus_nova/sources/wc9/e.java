package wc9;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.conversation.BotConversationType;
import com.larus.im.bean.conversation.CellType;
import com.larus.im.bean.conversation.ConversationStatus;
import com.larus.im.bean.conversation.ConversationType;
import com.larus.im.bean.conversation.CreateChannel;
import com.larus.im.bean.conversation.CreateScene;
import com.larus.im.bean.conversation.GroupReviewStatus;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.conversation.Templates;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import ouc.d0;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    public final Boolean A;
    public final String B;
    public final Integer C;
    public final Integer D;
    public final Integer E;
    public final int F;
    public final int G;
    public final String H;
    public final String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final String f559197J;
    public final long K;
    public final long L;
    public d0 M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f559198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IconImage f559199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f559200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f559201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f559202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f559203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConversationPage f559204g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Templates> f559205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f559206i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f559207j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Integer f559208k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Integer f559209l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f559210m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f559211n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Long f559212o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Long f559213p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Long f559214q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f559215r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f559216s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Integer f559217t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f559218u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Integer f559219v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Long f559220w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Map<String, String> f559221x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Map<String, String> f559222y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f559223z;

    public static final class a {
    }

    static {
    }

    public e() {
        this(null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, 0, null, null, 0, -1, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f559198a, r101.f559198a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f559199b, r101.f559199b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f559200c, r101.f559200c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f559201d, r101.f559201d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f559202e, r101.f559202e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f559203f, r101.f559203f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f559204g, r101.f559204g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f559205h, r101.f559205h) == true) goto L33;
        return false;
    L33:
        if (this.f559206i == r101.f559206i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f559207j, r101.f559207j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f559208k, r101.f559208k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f559209l, r101.f559209l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f559210m, r101.f559210m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f559211n, r101.f559211n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f559212o, r101.f559212o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f559213p, r101.f559213p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f559214q, r101.f559214q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f559215r, r101.f559215r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f559216s, r101.f559216s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f559217t, r101.f559217t) == true) goto L69;
        return false;
    L69:
        if (this.f559218u == r101.f559218u) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f559219v, r101.f559219v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f559220w, r101.f559220w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.f559221x, r101.f559221x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.f559222y, r101.f559222y) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.f559223z, r101.f559223z) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r101.A) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.B, r101.B) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.C, r101.C) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.D, r101.D) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.E, r101.E) == true) goto L102;
        return false;
    L102:
        if (this.F == r101.F) goto L105;
        return false;
    L105:
        if (this.G == r101.G) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.H, r101.H) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.I, r101.I) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.f559197J, r101.f559197J) == true) goto L117;
        return false;
    L117:
        if (this.K == r101.K) goto L120;
        return false;
    L120:
        if (this.L == r101.L) goto L122;
        return false;
    L122:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f559198a.hashCode() * 31;
        IconImage r101 = this.f559199b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f559200c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Long r108 = this.f559201d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f559202e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.f559203f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        ConversationPage r117 = this.f559204g;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        List<Templates> r120 = this.f559205h;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        if (this.f559206i == false) goto L33;
        int r123 = 1231;
    L34:
        int r124 = (r122 + r123) * 31;
        Integer r125 = this.f559207j;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.f559208k;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.f559209l;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.f559210m;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.f559211n;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        Long r140 = this.f559212o;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        Long r143 = this.f559213p;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        Long r146 = this.f559214q;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.f559215r;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.f559216s;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        Integer r155 = this.f559217t;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        long r157 = this.f559218u;
        int r158 = (((r154 + r156) * 31) + ((int) (r157 ^ (r157 >>> 32)))) * 31;
        Integer r159 = this.f559219v;
        if (r159 != null) goto L81;
        int r160 = 0;
    L82:
        int r161 = (r158 + r160) * 31;
        Long r162 = this.f559220w;
        if (r162 != null) goto L85;
        int r163 = 0;
    L86:
        int r164 = (r161 + r163) * 31;
        Map<String, String> r165 = this.f559221x;
        if (r165 != null) goto L89;
        int r166 = 0;
    L90:
        int r167 = (r164 + r166) * 31;
        Map<String, String> r168 = this.f559222y;
        if (r168 != null) goto L93;
        int r169 = 0;
    L94:
        int r170 = (r167 + r169) * 31;
        String r171 = this.f559223z;
        if (r171 != null) goto L97;
        int r172 = 0;
    L98:
        int r173 = (r170 + r172) * 31;
        Boolean r174 = this.A;
        if (r174 != null) goto L101;
        int r175 = 0;
    L102:
        int r176 = (r173 + r175) * 31;
        String r177 = this.B;
        if (r177 != null) goto L105;
        int r178 = 0;
    L106:
        int r179 = (r176 + r178) * 31;
        Integer r180 = this.C;
        if (r180 != null) goto L109;
        int r181 = 0;
    L110:
        int r182 = (r179 + r181) * 31;
        Integer r183 = this.D;
        if (r183 != null) goto L113;
        int r184 = 0;
    L114:
        int r185 = (r182 + r184) * 31;
        Integer r186 = this.E;
        if (r186 != null) goto L117;
        int r187 = 0;
    L118:
        int r188 = (((((r185 + r187) * 31) + this.F) * 31) + this.G) * 31;
        String r189 = this.H;
        if (r189 != null) goto L121;
        int r190 = 0;
    L122:
        int r191 = (r188 + r190) * 31;
        String r192 = this.I;
        if (r192 != null) goto L125;
        int r193 = 0;
    L126:
        int r194 = (r191 + r193) * 31;
        String r195 = this.f559197J;
        if (r195 == null) goto L130;
        r102 = r195.hashCode();
    L130:
        int r196 = (r194 + r102) * 31;
        long r197 = this.K;
        int r198 = (r196 + ((int) (r197 ^ (r197 >>> 32)))) * 31;
        long r199 = this.L;
        return r198 + ((int) (r199 ^ (r199 >>> 32)));
    L125:
        r193 = r192.hashCode();
        goto L126
    L121:
        r190 = r189.hashCode();
        goto L122
    L117:
        r187 = r186.hashCode();
        goto L118
    L113:
        r184 = r183.hashCode();
        goto L114
    L109:
        r181 = r180.hashCode();
        goto L110
    L105:
        r178 = r177.hashCode();
        goto L106
    L101:
        r175 = r174.hashCode();
        goto L102
    L97:
        r172 = r171.hashCode();
        goto L98
    L93:
        r169 = r168.hashCode();
        goto L94
    L89:
        r166 = r165.hashCode();
        goto L90
    L85:
        r163 = r162.hashCode();
        goto L86
    L81:
        r160 = r159.hashCode();
        goto L82
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = 1237;
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "Conversation(conversationId=" + this.f559198a + ", iconImage=" + this.f559199b + ", name=" + this.f559200c + ", updateTime=" + this.f559201d + ", pinned=" + this.f559202e + ", isLocal=" + this.f559203f + ", conversationPage=" + this.f559204g + ", templates=" + this.f559205h + ", ttsEnable=" + this.f559206i + ", conversationType=" + this.f559207j + ", participantCount=" + this.f559208k + ", badgeCount=" + this.f559209l + ", readBadgeCount=" + this.f559210m + ", briefMessageLocalId=" + this.f559211n + ", readMessageIndex=" + this.f559212o + ", oldestMessageIndex=" + this.f559213p + ", latestMessageIndex=" + this.f559214q + ", ext=" + this.f559215r + ", bizModel=" + this.f559216s + ", status=" + this.f559217t + ", version=" + this.f559218u + ", botConversationType=" + this.f559219v + ", retentionIndex=" + this.f559220w + ", bizExtra=" + this.f559221x + ", traceMap=" + this.f559222y + ", ownerId=" + this.f559223z + ", isDeleted=" + this.A + ", sectionId=" + this.B + ", inputLeftActionStyle=" + this.C + ", groupReviewStatus=" + this.D + ", createScene=" + this.E + ", cellType=" + this.F + ", createChannel=" + this.G + ", parentCellId=" + this.H + ", projectId=" + this.I + ", deviceId=" + this.f559197J + ", createTime=" + this.K + ", pinTime=" + this.L + ')';
    }

    public final Boolean a() {
        String r100 = this.f559215r;
        if (r100 != null) goto L22;
        return null;
    L22:
        d0 r101 = this.M;     // Catch: Exception -> L21
        if (r101 != null) goto L8;
        r101 = ouc.k.n(ouc.a.f526798d.e(r100));     // Catch: Exception -> L21
    L8:
        this.M = r101;     // Catch: Exception -> L21
        ouc.i r102 = (ouc.i) r101.get("is_default_name");     // Catch: Exception -> L21
        if (r102 == null) goto L11;
        String r103 = ouc.k.o(r102).a();     // Catch: Exception -> L21
    L13:
        if (Intrinsics.areEqual(r103, "true") == false) goto L17;
        Boolean r104 = Boolean.TRUE;     // Catch: Exception -> L21
    L20:
        return r104;
    L17:
        if (Intrinsics.areEqual(r103, "false") == false) goto L23;
        r104 = Boolean.FALSE;     // Catch: Exception -> L21
        goto L20
    L23:
        return null;
    L11:
        r103 = null;
        goto L13
    L24:
        return null;
    }

    public final Triple<Pair<String, Integer>, String, Integer> f() {
        String r100 = this.f559215r;
        if (r100 != null) goto L43;
        return null;
    L43:
        d0 r101 = this.M;     // Catch: Exception -> L42
        if (r101 != null) goto L8;
        r101 = ouc.k.n(ouc.a.f526798d.e(r100));     // Catch: Exception -> L42
    L8:
        this.M = r101;     // Catch: Exception -> L42
        ouc.i r102 = (ouc.i) r101.get("model_item_key");     // Catch: Exception -> L42
        if (r102 == null) goto L11;
        String r103 = ouc.k.o(r102).a();     // Catch: Exception -> L42
    L12:
        d0 r104 = this.M;     // Catch: Exception -> L42
        if (r104 == null) goto L17;
        ouc.i r105 = (ouc.i) r104.get("reply_mode");     // Catch: Exception -> L42
        if (r105 == null) goto L17;
        Integer r106 = ouc.k.l(ouc.k.o(r105));     // Catch: Exception -> L42
    L18:
        d0 r107 = this.M;     // Catch: Exception -> L42
        if (r107 == null) goto L23;
        ouc.i r108 = (ouc.i) r107.get("mode_id");     // Catch: Exception -> L42
        if (r108 == null) goto L23;
        String r109 = ouc.k.o(r108).a();     // Catch: Exception -> L42
    L24:
        d0 r110 = this.M;     // Catch: Exception -> L42
        if (r110 == null) goto L29;
        ouc.i r111 = (ouc.i) r110.get("reasoning_effort");     // Catch: Exception -> L42
        if (r111 == null) goto L29;
        Integer r112 = ouc.k.l(ouc.k.o(r111));     // Catch: Exception -> L42
    L30:
        if (r103 != null) goto L32;
    L35:
        boolean r113 = true;
    L36:
        if (r113 == false) goto L39;
        if (r106 != null) goto L39;
        return null;
    L39:
        return new Triple(new Pair(r103, r106), r109, r112);
    L32:
        if (r103.length() == 0) goto L35;
        r113 = false;
    L29:
        r112 = null;
    L23:
        r109 = null;
    L17:
        r106 = null;
        goto L18
    L11:
        r103 = null;
    L46:
        return null;
    }

    public final boolean h() {
        Integer r100 = this.f559217t;
        if (r100 != null) goto L6;
    L7:
        Integer r101 = this.f559217t;
        if (r101 != null) goto L11;
        return true;
    L11:
        if (r101.intValue() != 8) goto L16;
    L13:
        return false;
    L16:
        return true;
    L6:
        if (r100.intValue() == 1) goto L13;
        goto L7
    }

    public final boolean g() {
        Boolean r100 = a();
        if (r100 == null) goto L6;
        return r100.booleanValue();
    L6:
        if (this.f559215r != null) goto L8;
        return true;
    L8:
        return false;
    }

    public final Integer b() {
        return this.f559219v;
    }

    public final String c() {
        return this.f559198a;
    }

    public final Integer d() {
        return this.E;
    }

    public final String e() {
        return this.f559215r;
    }

    public /* synthetic */ e(String r410, IconImage r411, String r412, Long r510, Integer r511, Integer r512, ConversationPage r513, List r514, boolean r515, Integer r516, Integer r517, Integer r518, Integer r519, String r610, Long r611, Long r612, Long r613, String r614, String r615, Integer r616, long r617, Integer r618, Long r710, Map r711, Map r712, String r713, Boolean r714, String r715, Integer r716, Integer r717, Integer r718, int r719, int r810, String r811, String r812, long r813, int r814, int r815) {
        String r100 = "";
        if ((r814 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r814 & 2) == 0) goto L9;
        IconImage r102 = null;
    L11:
        if ((r814 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r814 & 8) == 0) goto L17;
        Long r104 = null;
    L19:
        if ((r814 & 16) == 0) goto L21;
        Integer r105 = null;
    L23:
        if ((r814 & 32) == 0) goto L25;
        Integer r106 = null;
    L27:
        if ((r814 & 64) == 0) goto L29;
        ConversationPage r110 = null;
    L31:
        if ((r814 & 128) == 0) goto L33;
        List r111 = null;
    L35:
        if ((r814 & 256) == 0) goto L37;
        boolean r112 = true;
    L39:
        if ((r814 & 512) == 0) goto L41;
        Integer r113 = null;
    L43:
        if ((r814 & 1024) == 0) goto L45;
        Integer r114 = null;
    L47:
        if ((r814 & 2048) == 0) goto L49;
        Integer r115 = null;
    L51:
        if ((r814 & 4096) == 0) goto L53;
        Integer r116 = null;
    L55:
        if ((r814 & 8192) == 0) goto L57;
        String r117 = null;
    L59:
        if ((r814 & 16384) == 0) goto L61;
        Long r118 = null;
    L63:
        if ((32768 & r814) == 0) goto L65;
        Long r119 = null;
    L67:
        if ((65536 & r814) == 0) goto L69;
        Long r210 = null;
    L71:
        if ((131072 & r814) == 0) goto L73;
        String r211 = null;
    L75:
        if ((262144 & r814) == 0) goto L77;
        String r212 = null;
    L79:
        if ((524288 & r814) == 0) goto L81;
        Integer r107 = 0;
    L83:
        if ((r814 & 1048576) == 0) goto L85;
        long r213 = 0;
    L87:
        if ((r814 & 2097152) == 0) goto L89;
        Integer r214 = 0;
    L91:
        if ((r814 & 4194304) == 0) goto L93;
        Long r310 = null;
    L95:
        if ((r814 & 8388608) == 0) goto L97;
        Map r311 = null;
    L99:
        if ((r814 & 16777216) == 0) goto L101;
        Map r312 = null;
    L103:
        if ((r814 & 33554432) == 0) goto L105;
        String r313 = null;
    L107:
        if ((r814 & 67108864) == 0) goto L109;
        Boolean r314 = Boolean.FALSE;
    L111:
        if ((r814 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        String r315 = "";
    L115:
        if ((r814 & 268435456) == 0) goto L117;
        Integer r316 = null;
    L119:
        if ((r814 & 536870912) == 0) goto L121;
        Integer r317 = 0;
    L123:
        if ((r814 & 1073741824) == 0) goto L125;
        Integer r318 = 0;
    L127:
        if ((r814 & Integer.MIN_VALUE) == 0) goto L129;
        int r108 = 0;
    L131:
        if ((r815 & 1) == 0) goto L133;
        int r319 = 0;
    L135:
        if ((r815 & 2) != 0) goto L139;
        r100 = r811;
    L139:
        if ((r815 & 4) == 0) goto L141;
        String r413 = null;
    L143:
        if ((r815 & 32) == 0) goto L145;
        long r414 = 0;
    L146:
        this(r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r107, r213, r214, r310, r311, r312, r313, r314, r315, r316, r317, r318, r108, r319, r100, r413, null, 0, r414);
        return;
    L145:
        r414 = r813;
        goto L146
    L141:
        r413 = r812;
        goto L143
    L133:
        r319 = r810;
        goto L135
    L129:
        r108 = r719;
        goto L131
    L125:
        r318 = r718;
        goto L127
    L121:
        r317 = r717;
        goto L123
    L117:
        r316 = r716;
        goto L119
    L113:
        r315 = r715;
        goto L115
    L109:
        r314 = r714;
        goto L111
    L105:
        r313 = r713;
        goto L107
    L101:
        r312 = r712;
        goto L103
    L97:
        r311 = r711;
        goto L99
    L93:
        r310 = r710;
        goto L95
    L89:
        r214 = r618;
        goto L91
    L85:
        r213 = r617;
        goto L87
    L81:
        r107 = r616;
        goto L83
    L77:
        r212 = r615;
        goto L79
    L73:
        r211 = r614;
        goto L75
    L69:
        r210 = r613;
        goto L71
    L65:
        r119 = r612;
        goto L67
    L61:
        r118 = r611;
        goto L63
    L57:
        r117 = r610;
        goto L59
    L53:
        r116 = r519;
        goto L55
    L49:
        r115 = r518;
        goto L51
    L45:
        r114 = r517;
        goto L47
    L41:
        r113 = r516;
        goto L43
    L37:
        r112 = r515;
        goto L39
    L33:
        r111 = r514;
        goto L35
    L29:
        r110 = r513;
        goto L31
    L25:
        r106 = r512;
        goto L27
    L21:
        r105 = r511;
        goto L23
    L17:
        r104 = r510;
        goto L19
    L13:
        r103 = r412;
        goto L15
    L9:
        r102 = r411;
        goto L11
    L5:
        r101 = r410;
        goto L7
    }

    public e(String r100, IconImage r101, String r102, Long r103, Integer r104, Integer r105, ConversationPage r110, List<Templates> r111, boolean r112, @ConversationType Integer r113, Integer r114, Integer r115, Integer r116, String r117, Long r118, Long r119, Long r210, String r211, String r212, @ConversationStatus Integer r213, long r214, @BotConversationType Integer r215, Long r216, Map<String, String> r217, Map<String, String> r218, String r310, Boolean r311, String r312, Integer r313, @GroupReviewStatus Integer r314, @CreateScene Integer r315, @CellType int r316, @CreateChannel int r317, String r318, String r319, String r410, long r411, long r412) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        this.f559198a = r100;
        this.f559199b = r101;
        this.f559200c = r102;
        this.f559201d = r103;
        this.f559202e = r104;
        this.f559203f = r105;
        this.f559204g = r110;
        this.f559205h = r111;
        this.f559206i = r112;
        this.f559207j = r113;
        this.f559208k = r114;
        this.f559209l = r115;
        this.f559210m = r116;
        this.f559211n = r117;
        this.f559212o = r118;
        this.f559213p = r119;
        this.f559214q = r210;
        this.f559215r = r211;
        this.f559216s = r212;
        this.f559217t = r213;
        this.f559218u = r214;
        this.f559219v = r215;
        this.f559220w = r216;
        this.f559221x = r217;
        this.f559222y = r218;
        this.f559223z = r310;
        this.A = r311;
        this.B = r312;
        this.C = r313;
        this.D = r314;
        this.E = r315;
        this.F = r316;
        this.G = r317;
        this.H = r318;
        this.I = r319;
        this.f559197J = r410;
        this.K = r411;
        this.L = r412;
    }
}
