package yc9;

import com.larus.im.bean.conversation.UserType;
import com.larus.im.bean.message.ClientControllerParam;
import com.larus.im.bean.message.MessageContentType;
import com.larus.im.bean.message.MessageRequestType;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.MessageStatusLocal;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.SuggestQuestion;
import com.larus.im.bean.message.block.Block;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class f0 {
    public Map<String, String> A;
    public final int B;
    public final int C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f567238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MessageRequestType f567239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f567240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f567241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f567242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f567243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<Block> f567244g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f567245h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f567246i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f567247j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f567248k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f567249l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ReferenceInfo f567250m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f567251n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f567252o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f567253p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f567254q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Map<String, String> f567255r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f567256s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List<SuggestQuestion> f567257t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<Integer> f567258u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f567259v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Map<String, String> f567260w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ClientControllerParam f567261x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f567262y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final MessageStatus f567263z;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r101 = (f0) r100;
        if (Intrinsics.areEqual(this.f567238a, r101.f567238a) == true) goto L12;
        return false;
    L12:
        if (this.f567239b == r101.f567239b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f567240c, r101.f567240c) == true) goto L18;
        return false;
    L18:
        if (this.f567241d == r101.f567241d) goto L21;
        return false;
    L21:
        if (this.f567242e == r101.f567242e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f567243f, r101.f567243f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f567244g, r101.f567244g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f567245h, r101.f567245h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f567246i, r101.f567246i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f567247j, r101.f567247j) == true) goto L39;
        return false;
    L39:
        if (this.f567248k == r101.f567248k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f567249l, r101.f567249l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f567250m, r101.f567250m) == true) goto L48;
        return false;
    L48:
        if (this.f567251n == r101.f567251n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f567252o, r101.f567252o) == true) goto L54;
        return false;
    L54:
        if (this.f567253p == r101.f567253p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f567254q, r101.f567254q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f567255r, r101.f567255r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f567256s, r101.f567256s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f567257t, r101.f567257t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f567258u, r101.f567258u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f567259v, r101.f567259v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f567260w, r101.f567260w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.f567261x, r101.f567261x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.f567262y, r101.f567262y) == true) goto L84;
        return false;
    L84:
        if (this.f567263z == r101.f567263z) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r101.A) == true) goto L90;
        return false;
    L90:
        if (this.B == r101.B) goto L93;
        return false;
    L93:
        if (this.C == r101.C) goto L95;
        return false;
    L95:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f567238a.hashCode() * 31) + this.f567239b.hashCode()) * 31) + this.f567240c.hashCode()) * 31) + this.f567241d) * 31) + this.f567242e) * 31;
        String r101 = this.f567243f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        List<Block> r105 = this.f567244g;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Long r108 = this.f567245h;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f567246i;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f567247j;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (((r113 + r115) * 31) + this.f567248k) * 31;
        String r117 = this.f567249l;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        ReferenceInfo r120 = this.f567250m;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        if (this.f567251n == false) goto L33;
        int r123 = 1231;
    L34:
        int r124 = (r122 + r123) * 31;
        String r125 = this.f567252o;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        long r127 = this.f567253p;
        int r128 = (((r124 + r126) * 31) + ((int) (r127 ^ (r127 >>> 32)))) * 31;
        String r129 = this.f567254q;
        if (r129 != null) goto L41;
        int r130 = 0;
    L42:
        int r131 = (r128 + r130) * 31;
        Map<String, String> r132 = this.f567255r;
        if (r132 != null) goto L45;
        int r133 = 0;
    L46:
        int r134 = (r131 + r133) * 31;
        String r135 = this.f567256s;
        if (r135 != null) goto L49;
        int r136 = 0;
    L50:
        int r137 = (r134 + r136) * 31;
        List<SuggestQuestion> r138 = this.f567257t;
        if (r138 != null) goto L53;
        int r139 = 0;
    L54:
        int r140 = (r137 + r139) * 31;
        List<Integer> r141 = this.f567258u;
        if (r141 != null) goto L57;
        int r142 = 0;
    L58:
        int r143 = (r140 + r142) * 31;
        String r144 = this.f567259v;
        if (r144 != null) goto L61;
        int r145 = 0;
    L62:
        int r146 = (((r143 + r145) * 31) + this.f567260w.hashCode()) * 31;
        ClientControllerParam r147 = this.f567261x;
        if (r147 != null) goto L65;
        int r148 = 0;
    L66:
        int r149 = (r146 + r148) * 31;
        String r150 = this.f567262y;
        if (r150 != null) goto L69;
        int r151 = 0;
    L70:
        int r152 = (((r149 + r151) * 31) + this.f567263z.hashCode()) * 31;
        Map<String, String> r153 = this.A;
        if (r153 == null) goto L75;
        r102 = r153.hashCode();
    L75:
        return ((((r152 + r102) * 31) + this.B) * 31) + this.C;
    L69:
        r151 = r150.hashCode();
        goto L70
    L65:
        r148 = r147.hashCode();
        goto L66
    L61:
        r145 = r144.hashCode();
        goto L62
    L57:
        r142 = r141.hashCode();
        goto L58
    L53:
        r139 = r138.hashCode();
        goto L54
    L49:
        r136 = r135.hashCode();
        goto L50
    L45:
        r133 = r132.hashCode();
        goto L46
    L41:
        r130 = r129.hashCode();
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
        return "MessageRequest(conversationId=" + this.f567238a + ", requestType=" + this.f567239b + ", senderId=" + this.f567240c + ", senderType=" + this.f567241d + ", contentType=" + this.f567242e + ", content=" + this.f567243f + ", contentBlock=" + this.f567244g + ", localMessageIndex=" + this.f567245h + ", localMessageId=" + this.f567246i + ", replyId=" + this.f567247j + ", messageStatusLocal=" + this.f567248k + ", localConversationId=" + this.f567249l + ", referenceInfo=" + this.f567250m + ", sourceFromAsr=" + this.f567251n + ", audioUrl=" + this.f567252o + ", audioDuration=" + this.f567253p + ", sectionId=" + this.f567254q + ", ext=" + this.f567255r + ", bizContentType=" + this.f567256s + ", suggestQuestions=" + this.f567257t + ", tags=" + this.f567258u + ", brief=" + this.f567259v + ", businessExt=" + this.f567260w + ", clientControllerParam=" + this.f567261x + ", botId=" + this.f567262y + ", status=" + this.f567263z + ", appletPayload=" + this.A + ", markedImageCount=" + this.B + ", croppedImageCount=" + this.C + ')';
    }

    public static f0 a(f0 r310, String r311, MessageRequestType r312, String r313, int r314, String r315, List r410, String r411, int r412, Map r413, String r414, List r415, String r416, Map r417, ClientControllerParam r418, String r419, int r510) {
        if ((r510 & 1) == 0) goto L5;
        String r100 = r310.f567238a;
    L7:
        if ((r510 & 2) == 0) goto L9;
        MessageRequestType r101 = r310.f567239b;
    L11:
        if ((r510 & 4) == 0) goto L13;
        String r102 = r310.f567240c;
    L15:
        if ((r510 & 8) == 0) goto L17;
        int r103 = r310.f567241d;
    L19:
        if ((r510 & 16) == 0) goto L21;
        int r104 = r310.f567242e;
    L23:
        if ((r510 & 32) == 0) goto L25;
        String r105 = r310.f567243f;
    L27:
        if ((r510 & 64) == 0) goto L29;
        List r110 = r310.f567244g;
    L31:
        if ((r510 & 128) == 0) goto L33;
        Long r106 = r310.f567245h;
    L35:
        if ((r510 & 256) == 0) goto L37;
        String r111 = r310.f567246i;
    L39:
        if ((r510 & 512) == 0) goto L41;
        String r112 = r310.f567247j;
    L43:
        if ((r510 & 1024) == 0) goto L45;
        int r113 = r310.f567248k;
    L47:
        if ((r510 & 2048) == 0) goto L49;
        String r114 = r310.f567249l;
    L51:
        if ((r510 & 4096) == 0) goto L53;
        ReferenceInfo r115 = r310.f567250m;
    L55:
        if ((r510 & 8192) == 0) goto L57;
        boolean r116 = r310.f567251n;
    L59:
        if ((r510 & 16384) == 0) goto L61;
        String r117 = r310.f567252o;
    L62:
        String r316 = r111;
        if ((32768 & r510) == 0) goto L65;
        long r118 = r310.f567253p;
    L66:
        long r119 = r118;
        if ((65536 & r510) == 0) goto L69;
        String r210 = r310.f567254q;
    L71:
        if ((131072 & r510) == 0) goto L73;
        Map r211 = r310.f567255r;
    L75:
        if ((262144 & r510) == 0) goto L77;
        String r212 = r310.f567256s;
    L79:
        if ((524288 & r510) == 0) goto L81;
        List r213 = r310.f567257t;
    L83:
        if ((1048576 & r510) == 0) goto L85;
        List<Integer> r214 = r310.f567258u;
    L87:
        if ((2097152 & r510) == 0) goto L89;
        String r215 = r310.f567259v;
    L91:
        if ((4194304 & r510) == 0) goto L93;
        Map r120 = r310.f567260w;
    L95:
        if ((8388608 & r510) == 0) goto L97;
        ClientControllerParam r216 = r310.f567261x;
    L99:
        if ((16777216 & r510) == 0) goto L101;
        String r217 = r310.f567262y;
    L103:
        if ((33554432 & r510) == 0) goto L105;
        MessageStatus r121 = r310.f567263z;
    L107:
        if ((67108864 & r510) == 0) goto L109;
        Map<String, String> r317 = r310.A;
    L111:
        if ((134217728 & r510) == 0) goto L113;
        int r318 = r310.B;
    L115:
        if ((r510 & 268435456) == 0) goto L117;
        int r319 = r310.C;
    L118:
        r310.getClass();
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "requestType");
        Intrinsics.checkNotNullParameter(r102, "senderId");
        Intrinsics.checkNotNullParameter(r120, "businessExt");
        Intrinsics.checkNotNullParameter(r121, "status");
        MessageStatus r107 = r121;
        return new f0(r100, r101, r102, r103, r104, r105, r110, r106, r316, r112, r113, r114, r115, r116, r117, r119, r210, r211, r212, r213, r214, r215, r120, r216, r217, r107, r317, r318, r319);
    L117:
        r319 = 0;
        goto L118
    L113:
        r318 = 0;
        goto L115
    L109:
        r317 = null;
        goto L111
    L105:
        r121 = null;
        goto L107
    L101:
        r217 = r419;
        goto L103
    L97:
        r216 = r418;
        goto L99
    L93:
        r120 = r417;
        goto L95
    L89:
        r215 = r416;
        goto L91
    L85:
        r214 = null;
        goto L87
    L81:
        r213 = r415;
        goto L83
    L77:
        r212 = r414;
        goto L79
    L73:
        r211 = r413;
        goto L75
    L69:
        r210 = null;
        goto L71
    L65:
        r118 = 0;
        goto L66
    L61:
        r117 = null;
        goto L62
    L57:
        r116 = false;
        goto L59
    L53:
        r115 = null;
        goto L55
    L49:
        r114 = null;
        goto L51
    L45:
        r113 = r412;
        goto L47
    L41:
        r112 = null;
        goto L43
    L37:
        r111 = r411;
        goto L39
    L33:
        r106 = null;
        goto L35
    L29:
        r110 = r410;
        goto L31
    L25:
        r105 = r315;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = 0;
        goto L19
    L13:
        r102 = r313;
        goto L15
    L9:
        r101 = r312;
        goto L11
    L5:
        r100 = r311;
        goto L7
    }

    public /* synthetic */ f0(String r310, MessageRequestType r311, String r312, int r313, int r314, String r315, String r410, String r411, int r412, ReferenceInfo r413, boolean r414, String r415, Map r416, String r417, List r418, List r419, String r510, Map r511, ClientControllerParam r512, String r513, MessageStatus r514, int r515) {
        if ((r515 & 2) == 0) goto L5;
        MessageRequestType r100 = MessageRequestType.UNKNOWN;
    L7:
        if ((r515 & 8) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r515 & 16) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r515 & 32) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r515 & 256) == 0) goto L21;
        String r110 = "";
    L23:
        if ((r515 & 512) == 0) goto L25;
        String r111 = null;
    L27:
        if ((r515 & 1024) == 0) goto L29;
        int r112 = -1;
    L31:
        if ((r515 & 4096) == 0) goto L33;
        ReferenceInfo r113 = null;
    L35:
        if ((r515 & 8192) == 0) goto L37;
        boolean r114 = false;
    L39:
        if ((65536 & r515) == 0) goto L41;
        String r210 = null;
    L43:
        if ((131072 & r515) == 0) goto L45;
        Map r211 = null;
    L47:
        if ((262144 & r515) == 0) goto L49;
        String r212 = null;
    L51:
        if ((524288 & r515) == 0) goto L53;
        List r213 = null;
    L55:
        if ((1048576 & r515) == 0) goto L57;
        List r214 = null;
    L59:
        if ((2097152 & r515) == 0) goto L61;
        String r215 = null;
    L63:
        if ((4194304 & r515) == 0) goto L65;
        Map r216 = new LinkedHashMap();
    L67:
        if ((8388608 & r515) == 0) goto L69;
        ClientControllerParam r217 = null;
    L71:
        if ((16777216 & r515) == 0) goto L73;
        String r218 = null;
    L75:
        if ((r515 & 33554432) == 0) goto L77;
        MessageStatus r219 = MessageStatus.MessageStatus_AVAILABLE;
    L78:
        this(r310, r100, r312, r101, r102, r103, null, null, r110, r111, r112, null, r113, r114, null, 0, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, null, 0, 0);
        return;
    L77:
        r219 = r514;
        goto L78
    L73:
        r218 = r513;
        goto L75
    L69:
        r217 = r512;
        goto L71
    L65:
        r216 = r511;
        goto L67
    L61:
        r215 = r510;
        goto L63
    L57:
        r214 = r419;
        goto L59
    L53:
        r213 = r418;
        goto L55
    L49:
        r212 = r417;
        goto L51
    L45:
        r211 = r416;
        goto L47
    L41:
        r210 = r415;
        goto L43
    L37:
        r114 = r414;
        goto L39
    L33:
        r113 = r413;
        goto L35
    L29:
        r112 = r412;
        goto L31
    L25:
        r111 = r411;
        goto L27
    L21:
        r110 = r410;
        goto L23
    L17:
        r103 = r315;
        goto L19
    L13:
        r102 = r314;
        goto L15
    L9:
        r101 = r313;
        goto L11
    L5:
        r100 = r311;
        goto L7
    }

    public f0(String r100, MessageRequestType r101, String r110, @UserType int r111, @MessageContentType int r112, String r113, List<Block> r114, Long r115, String r116, String r117, @MessageStatusLocal int r118, String r119, ReferenceInfo r210, boolean r211, String r212, long r213, String r214, Map<String, String> r215, String r216, List<SuggestQuestion> r217, List<Integer> r218, String r310, Map<String, String> r311, ClientControllerParam r312, String r313, MessageStatus r314, Map<String, String> r315, int r316, int r317) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "requestType");
        Intrinsics.checkNotNullParameter(r110, "senderId");
        Intrinsics.checkNotNullParameter(r311, "businessExt");
        Intrinsics.checkNotNullParameter(r314, "status");
        this.f567238a = r100;
        this.f567239b = r101;
        this.f567240c = r110;
        this.f567241d = r111;
        this.f567242e = r112;
        this.f567243f = r113;
        this.f567244g = r114;
        this.f567245h = r115;
        this.f567246i = r116;
        this.f567247j = r117;
        this.f567248k = r118;
        this.f567249l = r119;
        this.f567250m = r210;
        this.f567251n = r211;
        this.f567252o = r212;
        this.f567253p = r213;
        this.f567254q = r214;
        this.f567255r = r215;
        this.f567256s = r216;
        this.f567257t = r217;
        this.f567258u = r218;
        this.f567259v = r310;
        this.f567260w = r311;
        this.f567261x = r312;
        this.f567262y = r313;
        this.f567263z = r314;
        this.A = r315;
        this.B = r316;
        this.C = r317;
    }
}
