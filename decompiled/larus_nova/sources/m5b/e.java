package m5b;

import android.content.Context;
import android.net.Uri;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.lark.pb.basic.v1.File;
import com.ss.android.lark.biz.im.api.k;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e {
    public final List<File> A;
    public final boolean B;
    public k C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f512223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f512224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f512225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f512226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f512227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f512228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f512229g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f512230h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f512231i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f512232j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f512233k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Integer f512234l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f512235m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f512236n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Uri f512237o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f512238p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Boolean f512239q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Boolean f512240r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Message f512241s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo f512242t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f512243u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Integer f512244v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f512245w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public MonitorMessageSendCallback f512246x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f512247y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public xcb.a f512248z;

    public e() {
        this(null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 536870911);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f512223a, r101.f512223a) == true) goto L12;
        return false;
    L12:
        if (this.f512224b == r101.f512224b) goto L15;
        return false;
    L15:
        if (this.f512225c == r101.f512225c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f512226d, r101.f512226d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f512227e, r101.f512227e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f512228f, r101.f512228f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f512229g, r101.f512229g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f512230h, r101.f512230h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f512231i, r101.f512231i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f512232j, r101.f512232j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f512233k, r101.f512233k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f512234l, r101.f512234l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f512235m, r101.f512235m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f512236n, r101.f512236n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f512237o, r101.f512237o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f512238p, r101.f512238p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f512239q, r101.f512239q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f512240r, r101.f512240r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f512241s, r101.f512241s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f512242t, r101.f512242t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f512243u, r101.f512243u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f512244v, r101.f512244v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f512245w, r101.f512245w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.f512246x, r101.f512246x) == true) goto L81;
        return false;
    L81:
        if (this.f512247y == r101.f512247y) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.f512248z, r101.f512248z) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r101.A) == true) goto L90;
        return false;
    L90:
        if (this.B == r101.B) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.C, r101.C) == true) goto L95;
        return false;
    L95:
        return true;
    }

    public final int hashCode() {
        Context r100 = this.f512223a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        int r104 = 1231;
        if (this.f512224b == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f512225c == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        Long r109 = this.f512226d;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        Boolean r112 = this.f512227e;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f512228f;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        String r118 = this.f512229g;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f512230h;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        String r124 = this.f512231i;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        String r127 = this.f512232j;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (r126 + r128) * 31;
        String r130 = this.f512233k;
        if (r130 != null) goto L45;
        int r131 = 0;
    L46:
        int r132 = (r129 + r131) * 31;
        Integer r133 = this.f512234l;
        if (r133 != null) goto L49;
        int r134 = 0;
    L50:
        int r135 = (r132 + r134) * 31;
        Integer r136 = this.f512235m;
        if (r136 != null) goto L53;
        int r137 = 0;
    L54:
        int r138 = (r135 + r137) * 31;
        String r139 = this.f512236n;
        if (r139 != null) goto L57;
        int r140 = 0;
    L58:
        int r141 = (r138 + r140) * 31;
        Uri r142 = this.f512237o;
        if (r142 != null) goto L61;
        int r143 = 0;
    L62:
        int r144 = (r141 + r143) * 31;
        String r145 = this.f512238p;
        if (r145 != null) goto L65;
        int r146 = 0;
    L66:
        int r147 = (r144 + r146) * 31;
        Boolean r148 = this.f512239q;
        if (r148 != null) goto L69;
        int r149 = 0;
    L70:
        int r150 = (r147 + r149) * 31;
        Boolean r151 = this.f512240r;
        if (r151 != null) goto L73;
        int r152 = 0;
    L74:
        int r153 = (r150 + r152) * 31;
        Message r154 = this.f512241s;
        if (r154 != null) goto L77;
        int r155 = 0;
    L78:
        int r156 = (r153 + r155) * 31;
        com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r157 = this.f512242t;
        if (r157 != null) goto L81;
        int r158 = 0;
    L82:
        int r159 = (r156 + r158) * 31;
        String r160 = this.f512243u;
        if (r160 != null) goto L85;
        int r161 = 0;
    L86:
        int r162 = (r159 + r161) * 31;
        Integer r163 = this.f512244v;
        if (r163 != null) goto L89;
        int r164 = 0;
    L90:
        int r165 = (r162 + r164) * 31;
        String r166 = this.f512245w;
        if (r166 != null) goto L93;
        int r167 = 0;
    L94:
        int r168 = (r165 + r167) * 31;
        MonitorMessageSendCallback r169 = this.f512246x;
        if (r169 != null) goto L97;
        int r170 = 0;
    L98:
        int r171 = (r168 + r170) * 31;
        if (this.f512247y == false) goto L101;
        int r172 = 1231;
    L102:
        int r173 = (r171 + r172) * 31;
        xcb.a r174 = this.f512248z;
        if (r174 != null) goto L105;
        int r175 = 0;
    L106:
        int r176 = (r173 + r175) * 31;
        List<File> r177 = this.A;
        if (r177 != null) goto L109;
        int r178 = 0;
    L110:
        int r179 = (r176 + r178) * 31;
        if (this.B == true) goto L114;
        r104 = 1237;
    L114:
        int r180 = (r179 + r104) * 31;
        k r181 = this.C;
        if (r181 == null) goto L119;
        r101 = r181.hashCode();
    L119:
        return r180 + r101;
    L109:
        r178 = r177.hashCode();
        goto L110
    L105:
        r175 = r174.hashCode();
        goto L106
    L101:
        r172 = 1237;
        goto L102
    L97:
        r170 = r169.hashCode();
        goto L98
    L93:
        r167 = r166.hashCode();
        goto L94
    L89:
        r164 = r163.hashCode();
        goto L90
    L85:
        r161 = r160.hashCode();
        goto L86
    L81:
        r158 = r157.hashCode();
        goto L82
    L77:
        r155 = r154.hashCode();
        goto L78
    L73:
        r152 = r151.hashCode();
        goto L74
    L69:
        r149 = r148.hashCode();
        goto L70
    L65:
        r146 = r145.hashCode();
        goto L66
    L61:
        r143 = r142.hashCode();
        goto L62
    L57:
        r140 = r139.hashCode();
        goto L58
    L53:
        r137 = r136.hashCode();
        goto L54
    L49:
        r134 = r133.hashCode();
        goto L50
    L45:
        r131 = r130.hashCode();
        goto L46
    L41:
        r128 = r127.hashCode();
        goto L42
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SendInfoExtraParam(context=" + this.f512223a + ", isMentionDoubao=" + this.f512224b + ", voiceTextPostProcess=" + this.f512225c + ", sendWithQueueId=" + this.f512226d + ", isLastInBatch=" + this.f512227e + ", imageUpload=" + this.f512228f + ", fileUploadId=" + this.f512229g + ", mediaUploadId=" + this.f512230h + ", firstScreenImageUploadId=" + this.f512231i + ", rootMsgId=" + this.f512232j + ", parentMsgId=" + this.f512233k + ", imageWidth=" + this.f512234l + ", imageHeight=" + this.f512235m + ", resourcePath=" + this.f512236n + ", uri=" + this.f512237o + ", threadId=" + this.f512238p + ", isReplyInThread=" + this.f512239q + ", isNotifyed=" + this.f512240r + ", message=" + this.f512241s + ", partialReplyInfo=" + this.f512242t + ", cid=" + this.f512243u + ", audioDuration=" + this.f512244v + ", audioFileName=" + this.f512245w + ", sendCallback=" + this.f512246x + ", keepOrigin=" + this.f512247y + ", urlPreviewEntityPbBundle=" + this.f512248z + ", fileAttachments=" + this.A + ", transmitToChat=" + this.B + ", doubaoResource=" + this.C + ')';
    }

    public final Context getContext() {
        return this.f512223a;
    }

    public e(Context r210, boolean r211, boolean r212, Long r213, Boolean r214, String r215, String r216, String r217, String r218, String r310, String r311, Integer r312, Integer r313, String r314, Uri r315, boolean r316, xcb.a r317, List r318, boolean r319, int r410) {
        if ((r410 & 1) == 0) goto L5;
        Context r100 = null;
    L7:
        if ((r410 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r410 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r410 & 8) == 0) goto L17;
        Long r103 = null;
    L19:
        if ((r410 & 16) == 0) goto L21;
        Boolean r104 = null;
    L23:
        if ((r410 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r410 & 64) == 0) goto L29;
        String r110 = null;
    L31:
        if ((r410 & 128) == 0) goto L33;
        String r111 = null;
    L35:
        if ((r410 & 256) == 0) goto L37;
        String r112 = null;
    L39:
        if ((r410 & 512) == 0) goto L41;
        String r113 = null;
    L43:
        if ((r410 & 1024) == 0) goto L45;
        String r114 = null;
    L47:
        if ((r410 & 2048) == 0) goto L49;
        Integer r115 = null;
    L51:
        if ((r410 & 4096) == 0) goto L53;
        Integer r106 = null;
    L55:
        if ((r410 & 8192) == 0) goto L57;
        String r107 = null;
    L58:
        String r219 = r107;
        if ((r410 & 16384) == 0) goto L61;
        Uri r108 = null;
    L63:
        if ((r410 & 16777216) == 0) goto L65;
        boolean r116 = false;
    L67:
        if ((r410 & 33554432) == 0) goto L69;
        xcb.a r117 = null;
    L71:
        if ((r410 & 67108864) == 0) goto L73;
        List r118 = null;
    L75:
        if ((r410 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L77;
        boolean r109 = false;
    L78:
        this.f512223a = r100;
        this.f512224b = r101;
        this.f512225c = r102;
        this.f512226d = r103;
        this.f512227e = r104;
        this.f512228f = r105;
        this.f512229g = r110;
        this.f512230h = r111;
        this.f512231i = r112;
        this.f512232j = r113;
        this.f512233k = r114;
        this.f512234l = r115;
        this.f512235m = r106;
        this.f512236n = r219;
        this.f512237o = r108;
        this.f512238p = null;
        this.f512239q = null;
        this.f512240r = null;
        this.f512241s = null;
        this.f512242t = null;
        this.f512243u = null;
        this.f512244v = null;
        this.f512245w = null;
        this.f512246x = null;
        this.f512247y = r116;
        this.f512248z = r117;
        this.A = r118;
        this.B = r109;
        this.C = null;
        return;
    L77:
        r109 = r319;
        goto L78
    L73:
        r118 = r318;
        goto L75
    L69:
        r117 = r317;
        goto L71
    L65:
        r116 = r316;
        goto L67
    L61:
        r108 = r315;
        goto L63
    L57:
        r107 = r314;
        goto L58
    L53:
        r106 = r313;
        goto L55
    L49:
        r115 = r312;
        goto L51
    L45:
        r114 = r311;
        goto L47
    L41:
        r113 = r310;
        goto L43
    L37:
        r112 = r218;
        goto L39
    L33:
        r111 = r217;
        goto L35
    L29:
        r110 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
