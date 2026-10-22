package com.ss.android.lark.compose.chatsetting.main.viewmodel;

import com.lark.kmp.pb.basic.v1.Chat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Chat.Type f417451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f417452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f417453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f417454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f417455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f417456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f417457g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f417458h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f417459i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f417460j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.ss.android.lark.compose.foundation.widget.a f417461k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.ss.android.lark.compose.foundation.widget.a f417462l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.ss.android.lark.compose.foundation.widget.a f417463m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.ss.android.lark.compose.foundation.widget.a f417464n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f417465o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f417466p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f417467q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f417468r;

    public a() {
        this(false, 262143);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f417451a == r101.f417451a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f417452b, r101.f417452b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f417453c, r101.f417453c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f417454d, r101.f417454d) == true) goto L21;
        return false;
    L21:
        if (this.f417455e == r101.f417455e) goto L24;
        return false;
    L24:
        if (this.f417456f == r101.f417456f) goto L27;
        return false;
    L27:
        if (this.f417457g == r101.f417457g) goto L30;
        return false;
    L30:
        if (this.f417458h == r101.f417458h) goto L33;
        return false;
    L33:
        if (this.f417459i == r101.f417459i) goto L36;
        return false;
    L36:
        if (this.f417460j == r101.f417460j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f417461k, r101.f417461k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f417462l, r101.f417462l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f417463m, r101.f417463m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f417464n, r101.f417464n) == true) goto L51;
        return false;
    L51:
        if (this.f417465o == r101.f417465o) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f417466p, r101.f417466p) == true) goto L57;
        return false;
    L57:
        if (this.f417467q == r101.f417467q) goto L60;
        return false;
    L60:
        if (this.f417468r == r101.f417468r) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        Chat.Type r100 = this.f417451a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((((((((r101 * 31) + this.f417452b.hashCode()) * 31) + this.f417453c.hashCode()) * 31) + this.f417454d.hashCode()) * 31) + this.f417455e) * 31;
        int r103 = 1231;
        if (this.f417456f == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f417457g == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f417458h == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f417459i == false) goto L21;
        int r110 = 1231;
    L22:
        int r111 = (r109 + r110) * 31;
        if (this.f417460j == false) goto L25;
        int r112 = 1231;
    L26:
        int r113 = (((((((((r111 + r112) * 31) + this.f417461k.hashCode()) * 31) + this.f417462l.hashCode()) * 31) + this.f417463m.hashCode()) * 31) + this.f417464n.hashCode()) * 31;
        if (this.f417465o == false) goto L29;
        int r114 = 1231;
    L30:
        int r115 = (((r113 + r114) * 31) + this.f417466p.hashCode()) * 31;
        if (this.f417467q == false) goto L33;
        int r116 = 1231;
    L34:
        int r117 = (r115 + r116) * 31;
        if (this.f417468r == true) goto L39;
        r103 = 1237;
    L39:
        return r117 + r103;
    L33:
        r116 = 1237;
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
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatSettingState(chatType=" + this.f417451a + ", avatarKey=" + this.f417452b + ", chatName=" + this.f417453c + ", p2pChatterId=" + this.f417454d + ", userCount=" + this.f417455e + ", isOwner=" + this.f417456f + ", isAdmin=" + this.f417457g + ", offEditGroupChatInfo=" + this.f417458h + ", allCanShare=" + this.f417459i + ", allCanAddMember=" + this.f417460j + ", muteState=" + this.f417461k + ", pinState=" + this.f417462l + ", useDoubaoInChatState=" + this.f417463m + ", doubaoProactiveReplyState=" + this.f417464n + ", isEnterpriseAccount=" + this.f417465o + ", ownerId=" + this.f417466p + ", isQuit=" + this.f417467q + ", isTopicGroup=" + this.f417468r + ')';
    }

    public /* synthetic */ a(boolean r210, int r211) {
        if ((r211 & 2) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r211 & 4) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r211 & 8) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r211 & 128) == 0) goto L17;
        boolean r110 = true;
    L19:
        if ((r211 & 256) == 0) goto L21;
        boolean r111 = true;
    L23:
        if ((r211 & 512) == 0) goto L25;
        boolean r112 = true;
    L27:
        if ((r211 & 1024) == 0) goto L29;
        com.ss.android.lark.compose.foundation.widget.a r113 = new com.ss.android.lark.compose.foundation.widget.a(false, false);
    L31:
        if ((r211 & 2048) == 0) goto L33;
        com.ss.android.lark.compose.foundation.widget.a r114 = new com.ss.android.lark.compose.foundation.widget.a(false, false);
    L35:
        if ((r211 & 4096) == 0) goto L37;
        com.ss.android.lark.compose.foundation.widget.a r115 = new com.ss.android.lark.compose.foundation.widget.a(true, false);
    L39:
        if ((r211 & 8192) == 0) goto L41;
        com.ss.android.lark.compose.foundation.widget.a r212 = new com.ss.android.lark.compose.foundation.widget.a(false, false);
    L43:
        if ((r211 & 16384) == 0) goto L45;
        boolean r213 = false;
    L47:
        if ((r211 & 32768) == 0) goto L49;
        String r116 = "";
    L50:
        this(null, r100, r101, r102, 0, false, false, r110, r111, r112, r113, r114, r115, r212, r213, r116, false, false);
        return;
    L49:
        r116 = null;
        goto L50
    L45:
        r213 = r210;
        goto L47
    L41:
        r212 = null;
        goto L43
    L37:
        r115 = null;
        goto L39
    L33:
        r114 = null;
        goto L35
    L29:
        r113 = null;
        goto L31
    L25:
        r112 = false;
        goto L27
    L21:
        r111 = false;
        goto L23
    L17:
        r110 = false;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = null;
        goto L7
    }

    public a(Chat.Type r110, String r111, String r112, String r113, int r114, boolean r115, boolean r116, boolean r117, boolean r118, boolean r210, com.ss.android.lark.compose.foundation.widget.a r211, com.ss.android.lark.compose.foundation.widget.a r212, com.ss.android.lark.compose.foundation.widget.a r213, com.ss.android.lark.compose.foundation.widget.a r214, boolean r215, String r216, boolean r217, boolean r218) {
        Intrinsics.checkNotNullParameter(r111, "avatarKey");
        Intrinsics.checkNotNullParameter(r112, "chatName");
        Intrinsics.checkNotNullParameter(r113, "p2pChatterId");
        Intrinsics.checkNotNullParameter(r211, "muteState");
        Intrinsics.checkNotNullParameter(r212, "pinState");
        Intrinsics.checkNotNullParameter(r213, "useDoubaoInChatState");
        Intrinsics.checkNotNullParameter(r214, "doubaoProactiveReplyState");
        Intrinsics.checkNotNullParameter(r216, "ownerId");
        this.f417451a = r110;
        this.f417452b = r111;
        this.f417453c = r112;
        this.f417454d = r113;
        this.f417455e = r114;
        this.f417456f = r115;
        this.f417457g = r116;
        this.f417458h = r117;
        this.f417459i = r118;
        this.f417460j = r210;
        this.f417461k = r211;
        this.f417462l = r212;
        this.f417463m = r213;
        this.f417464n = r214;
        this.f417465o = r215;
        this.f417466p = r216;
        this.f417467q = r217;
        this.f417468r = r218;
    }

    public static a a(a r110, Chat.Type r111, String r210, String r211, String r212, int r213, boolean r214, boolean r215, boolean r216, boolean r217, boolean r218, com.ss.android.lark.compose.foundation.widget.a r219, com.ss.android.lark.compose.foundation.widget.a r310, com.ss.android.lark.compose.foundation.widget.a r311, com.ss.android.lark.compose.foundation.widget.a r312, String r313, boolean r314, boolean r315, int r316) {
        if ((r316 & 1) == 0) goto L5;
        Chat.Type r100 = r110.f417451a;
    L7:
        if ((r316 & 2) == 0) goto L9;
        String r101 = r110.f417452b;
    L11:
        if ((r316 & 4) == 0) goto L13;
        String r102 = r110.f417453c;
    L15:
        if ((r316 & 8) == 0) goto L17;
        String r103 = r110.f417454d;
    L19:
        if ((r316 & 16) == 0) goto L21;
        int r104 = r110.f417455e;
    L23:
        if ((r316 & 32) == 0) goto L25;
        boolean r105 = r110.f417456f;
    L27:
        if ((r316 & 64) == 0) goto L29;
        boolean r106 = r110.f417457g;
    L31:
        if ((r316 & 128) == 0) goto L33;
        boolean r107 = r110.f417458h;
    L35:
        if ((r316 & 256) == 0) goto L37;
        boolean r112 = r110.f417459i;
    L39:
        if ((r316 & 512) == 0) goto L41;
        boolean r113 = r110.f417460j;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        com.ss.android.lark.compose.foundation.widget.a r114 = r110.f417461k;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        com.ss.android.lark.compose.foundation.widget.a r115 = r110.f417462l;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        com.ss.android.lark.compose.foundation.widget.a r116 = r110.f417463m;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        com.ss.android.lark.compose.foundation.widget.a r117 = r110.f417464n;
    L58:
        boolean r220 = r113;
        if ((r316 & 16384) == 0) goto L61;
        boolean r118 = r110.f417465o;
    L63:
        if ((r316 & 32768) == 0) goto L65;
        String r119 = r110.f417466p;
    L66:
        boolean r221 = r112;
        if ((r316 & 65536) == 0) goto L69;
        boolean r120 = r110.f417467q;
    L71:
        if ((r316 & 131072) == 0) goto L73;
        boolean r108 = r110.f417468r;
    L74:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "avatarKey");
        Intrinsics.checkNotNullParameter(r102, "chatName");
        Intrinsics.checkNotNullParameter(r103, "p2pChatterId");
        Intrinsics.checkNotNullParameter(r114, "muteState");
        Intrinsics.checkNotNullParameter(r115, "pinState");
        Intrinsics.checkNotNullParameter(r116, "useDoubaoInChatState");
        Intrinsics.checkNotNullParameter(r117, "doubaoProactiveReplyState");
        Intrinsics.checkNotNullParameter(r119, "ownerId");
        return new a(r100, r101, r102, r103, r104, r105, r106, r107, r221, r220, r114, r115, r116, r117, r118, r119, r120, r108);
    L73:
        r108 = r315;
        goto L74
    L69:
        r120 = r314;
        goto L71
    L65:
        r119 = r313;
        goto L66
    L61:
        r118 = false;
        goto L63
    L57:
        r117 = r312;
        goto L58
    L53:
        r116 = r311;
        goto L55
    L49:
        r115 = r310;
        goto L51
    L45:
        r114 = r219;
        goto L47
    L41:
        r113 = r218;
        goto L43
    L37:
        r112 = r217;
        goto L39
    L33:
        r107 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
