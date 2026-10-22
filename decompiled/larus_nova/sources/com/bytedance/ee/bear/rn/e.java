package com.bytedance.ee.bear.rn;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.export.bean.VisibilityBean;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f236544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f236545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f236546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f236547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f236548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> f236549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f236550g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f236551h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f236552i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f236553j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f236554k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f236555l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f236556m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<Object, Object> f236557n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f236558o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final VisibilityBean f236559p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f236560q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final SmartReplyDataForInsert f236561r;

    public e() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f236544a, r101.f236544a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f236545b, r101.f236545b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f236546c, r101.f236546c) == true) goto L18;
        return false;
    L18:
        if (this.f236547d == r101.f236547d) goto L21;
        return false;
    L21:
        if (this.f236548e == r101.f236548e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f236549f, r101.f236549f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f236550g, r101.f236550g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f236551h, r101.f236551h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f236552i, r101.f236552i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f236553j, r101.f236553j) == true) goto L39;
        return false;
    L39:
        if (this.f236554k == r101.f236554k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f236555l, r101.f236555l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f236556m, r101.f236556m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f236557n, r101.f236557n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f236558o, r101.f236558o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f236559p, r101.f236559p) == true) goto L57;
        return false;
    L57:
        if (this.f236560q == r101.f236560q) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f236561r, r101.f236561r) == true) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f236544a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f236545b.hashCode()) * 31;
        String r104 = this.f236546c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        int r107 = 1231;
        if (this.f236547d == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f236548e == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r112 = this.f236549f;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f236550g;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        String r118 = this.f236551h;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f236552i;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        String r124 = this.f236553j;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        if (this.f236554k == true) goto L42;
        r107 = 1237;
    L42:
        int r127 = (r126 + r107) * 31;
        String r128 = this.f236555l;
        if (r128 != null) goto L45;
        int r129 = 0;
    L46:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f236556m;
        if (r131 != null) goto L49;
        int r132 = 0;
    L50:
        int r133 = (r130 + r132) * 31;
        Map<Object, Object> r134 = this.f236557n;
        if (r134 != null) goto L53;
        int r135 = 0;
    L54:
        int r136 = (r133 + r135) * 31;
        String r137 = this.f236558o;
        if (r137 != null) goto L57;
        int r138 = 0;
    L58:
        int r139 = (((((r136 + r138) * 31) + this.f236559p.hashCode()) * 31) + this.f236560q) * 31;
        SmartReplyDataForInsert r140 = this.f236561r;
        if (r140 == null) goto L63;
        r101 = r140.hashCode();
    L63:
        return r139 + r101;
    L57:
        r138 = r137.hashCode();
        goto L58
    L53:
        r135 = r134.hashCode();
        goto L54
    L49:
        r132 = r131.hashCode();
        goto L50
    L45:
        r129 = r128.hashCode();
        goto L46
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
        r110 = 1237;
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PublishCommentParams(quote=" + this.f236544a + ", content=" + this.f236545b + ", commentId=" + this.f236546c + ", isAudio=" + this.f236547d + ", whole=" + this.f236548e + ", images=" + this.f236549f + ", tmpCommentId=" + this.f236550g + ", parentType=" + this.f236551h + ", parentToken=" + this.f236552i + ", replyId=" + this.f236553j + ", shouldAuthorize=" + this.f236554k + ", localCommentId=" + this.f236555l + ", position=" + this.f236556m + ", bizParams=" + this.f236557n + ", reply_uuid=" + this.f236558o + ", visibility=" + this.f236559p + ", commentType=" + this.f236560q + ", smartReplyData=" + this.f236561r + ')';
    }

    public e(String r110, String r111, String r210, boolean r211, boolean r212, List r213, String r214, String r215, String r216, String r217, boolean r218, String r219, String r310, Map r311, String r312, VisibilityBean r313, int r314, SmartReplyDataForInsert r315, int r316) {
        String r100 = "";
        if ((r316 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r316 & 4) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r316 & 8) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r316 & 16) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r316 & 32) == 0) goto L21;
        List r112 = null;
    L23:
        if ((r316 & 64) != 0) goto L27;
        r100 = r214;
    L27:
        if ((r316 & 128) == 0) goto L29;
        String r113 = null;
    L31:
        if ((r316 & 256) == 0) goto L33;
        String r114 = null;
    L35:
        if ((r316 & 512) == 0) goto L37;
        String r115 = null;
    L39:
        if ((r316 & 1024) == 0) goto L41;
        boolean r116 = false;
    L43:
        if ((r316 & 2048) == 0) goto L45;
        String r117 = null;
    L47:
        if ((r316 & 4096) == 0) goto L49;
        String r105 = null;
    L51:
        if ((r316 & 8192) == 0) goto L53;
        Map r106 = null;
    L54:
        Map r220 = r106;
        if ((r316 & 16384) == 0) goto L57;
        String r107 = null;
    L59:
        if ((r316 & 32768) == 0) goto L61;
        SmartReplyDataForInsert r118 = null;
        int r119 = 0;
        VisibilityBean r108 = new VisibilityBean(0, 1, null);
    L63:
        if ((65536 & r316) != 0) goto L67;
        r119 = r314;
    L67:
        if ((r316 & 131072) != 0) goto L70;
        r118 = r315;
    L70:
        Intrinsics.checkNotNullParameter(r111, "content");
        Intrinsics.checkNotNullParameter(r108, RemoteMessageConst.Notification.VISIBILITY);
        this.f236544a = r101;
        this.f236545b = r111;
        this.f236546c = r102;
        this.f236547d = r103;
        this.f236548e = r104;
        this.f236549f = r112;
        this.f236550g = r100;
        this.f236551h = r113;
        this.f236552i = r114;
        this.f236553j = r115;
        this.f236554k = r116;
        this.f236555l = r117;
        this.f236556m = r105;
        this.f236557n = r220;
        this.f236558o = r107;
        this.f236559p = r108;
        this.f236560q = r119;
        this.f236561r = r118;
        return;
    L61:
        r118 = null;
        r119 = 0;
        r108 = r313;
        goto L63
    L57:
        r107 = r312;
        goto L59
    L53:
        r106 = r311;
        goto L54
    L49:
        r105 = r310;
        goto L51
    L45:
        r117 = r219;
        goto L47
    L41:
        r116 = r218;
        goto L43
    L37:
        r115 = r217;
        goto L39
    L33:
        r114 = r216;
        goto L35
    L29:
        r113 = r215;
        goto L31
    L21:
        r112 = r213;
        goto L23
    L17:
        r104 = r212;
        goto L19
    L13:
        r103 = r211;
        goto L15
    L9:
        r102 = r210;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
