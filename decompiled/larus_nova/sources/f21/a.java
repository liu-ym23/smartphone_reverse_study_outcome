package f21;

import com.bytedance.android.live.revlink.impl.global.c;
import com.bytedance.android.live.revlink.impl.multianchor.AnchorLinkInitType;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e;
import com.bytedance.android.live.revlink.impl.multianchor.utils.g;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.d7;
import com.bytedance.android.livesdk.link.model.m;
import com.bytedance.android.livesdk.link.model.o9;
import com.bytedance.android.livesdk.link.model.x6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f475111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f475112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AnchorLinkInitType f475113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f475114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f475115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f475116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f475117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f475118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f475119i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f475120j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f475121k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f475122l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f475123m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f475124n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final C5849a f475125o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final d7 f475126p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final v1 f475127q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final g f475128r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f475129s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final m f475130t;

    /* JADX INFO: renamed from: f21.a$a, reason: collision with other inner class name */
    public static final class C5849a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f475131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f475132b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final IBattleConfigSetting f475133c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f475134d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final x6 f475135e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final o9 f475136f;

        public C5849a() {
            this(0, false, null, 0, null, 63);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C5849a) == false) goto L18;
            C5849a r101 = (C5849a) r100;
            if (this.f475131a == r101.f475131a) goto L8;
            return false;
        L8:
            if (this.f475132b == r101.f475132b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f475133c, r101.f475133c) == true) goto L12;
            return false;
        L12:
            if (this.f475134d == r101.f475134d) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f475135e, r101.f475135e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f475136f, r101.f475136f) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v13 */
        public final int hashCode() {
            int r100 = this.f475131a * 31;
            boolean r101 = this.f475132b;
            ?? r102 = r101;
            if (r101 == false) goto L5;
            r102 = 1;
        L5:
            int r103 = (r100 + r102) * 31;
            IBattleConfigSetting r104 = this.f475133c;
            int r105 = 0;
            if (r104 == null) goto L8;
            int r106 = r104.hashCode();
        L9:
            int r107 = (((r103 + r106) * 31) + this.f475134d) * 31;
            x6 r108 = this.f475135e;
            if (r108 == null) goto L12;
            int r109 = r108.hashCode();
        L13:
            int r110 = (r107 + r109) * 31;
            o9 r111 = this.f475136f;
            if (r111 == null) goto L17;
            r105 = r111.hashCode();
        L17:
            return r110 + r105;
        L12:
            r109 = 0;
            goto L13
        L8:
            r106 = 0;
            goto L9
        }

        public final String toString() {
            return "Extra(multiPkMode=" + this.f475131a + ", firstFrameOpt=" + this.f475132b + ", battleConfigSetting=" + this.f475133c + ", inviterFromScene=" + this.f475134d + ", multiAnchorExtra=" + this.f475135e + ", switchSceneData=" + this.f475136f + ")";
        }

        public C5849a(int r100, boolean r101, IBattleConfigSetting r102, int r103, o9 r104, int r105) {
            if ((r105 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r101 = false;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r102 = null;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r103 = 0;
        L15:
            if ((r105 & 32) == 0) goto L17;
            r104 = null;
        L17:
            this.f475131a = r100;
            this.f475132b = r101;
            this.f475133c = r102;
            this.f475134d = r103;
            this.f475135e = null;
            this.f475136f = r104;
        }
    }

    public final boolean a() {
        AnchorLinkInitType r100 = this.f475113c;
        if (r100 != AnchorLinkInitType.REPLY_AGREE_API) goto L5;
    L10:
        return true;
    L5:
        if (r100 == AnchorLinkInitType.REPLY_AGREE_MSG) goto L10;
        if (r100 == AnchorLinkInitType.PERMIT_AGREE_MSG) goto L10;
        return false;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("AnchorConnectionContext{Type=");
        r100.append(this.f475113c);
        r100.append(", connectionRoleType=");
        r100.append(this.f475122l);
        r100.append(", matchType=");
        r100.append(this.f475114d);
        r100.append(", inviteeList=");
        r100.append(this.f475115e);
        r100.append(", pkSwitchToLink=");
        r100.append(this.f475116f);
        r100.append(", switchChannel=");
        r100.append(this.f475120j);
        r100.append(", multiToMulti=");
        r100.append(this.f475121k);
        r100.append(", linkFromPkMultiInvite=");
        r100.append(this.f475118h);
        r100.append(", connectionType=");
        r100.append(this.f475123m);
        r100.append(", uiLayout=");
        m r101 = this.f475130t;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = ef2.a.c(r101);
    L6:
        r100.append(r103);
        r100.append(", extra={, multiPkMode=");
        r100.append(this.f475125o.f475131a);
        r100.append(", multiAnchorExtra=");
        x6 r104 = this.f475125o.f475135e;
        if (r104 == null) goto L9;
        Intrinsics.checkNotNullParameter(r104, "$this$toSimpleString");
        String r105 = "MultiAnchorExtra{inviteRole=" + r104.getInviteRole() + ", matchType=" + r104.getMatchType() + ", roleMap=" + r104.getRoleLinkMicMap() + '}';
    L10:
        r100.append(r105);
        r100.append(", inviterFromScene=");
        r100.append(this.f475125o.f475134d);
        r100.append(", battleSetting=");
        IBattleConfigSetting r106 = this.f475125o.f475133c;
        if (r106 == null) goto L13;
        r102 = ef2.a.c(r106);
    L13:
        r100.append(r102);
        r100.append("}}");
        return r100.toString();
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public final boolean b() {
        if (c() == true) goto L5;
        return true;
    L5:
        if (this.f475118h == false) goto L13;
        c r100 = this.f475112b;
        if (r100 == null) goto L16;
        AnchorRtcConnectModel r101 = r100.Hb();
        if (r101 != null) goto L11;
        return true;
    L11:
        if (r101.enableFirstFrameOpt() == true) goto L13;
        return true;
    L16:
        return true;
    L13:
        return false;
    }

    public final boolean c() {
        if (a() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f475125o.f475132b == false) goto L7;
        return true;
    }

    public a(c r210, AnchorLinkInitType r211, int r310, boolean r311, String r312, boolean r313, boolean r314, boolean r315, boolean r316, int r317, String r318, String r319, C5849a r410, d7 r411, v1 r412, g r413, long r414, m r415, int r416) {
        if ((r416 & 2) == 0) goto L5;
        AnchorLinkInitType r100 = AnchorLinkInitType.NONE;
    L7:
        if ((r416 & 4) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r416 & 8) == 0) goto L13;
        boolean r102 = true;
    L15:
        if ((r416 & 16) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r416 & 128) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r416 & 256) == 0) goto L25;
        boolean r110 = false;
    L27:
        if ((r416 & 512) == 0) goto L29;
        boolean r111 = false;
    L31:
        if ((r416 & 1024) == 0) goto L33;
        boolean r112 = false;
    L35:
        if ((r416 & 2048) == 0) goto L37;
        int r113 = 0;
    L39:
        if ((r416 & 4096) == 0) goto L41;
        String r114 = "manual_link";
    L43:
        if ((r416 & 8192) == 0) goto L50;
        if (r210 == null) goto L49;
        e r115 = r210.getLinkOptLogContext();
        if (r115 == null) goto L49;
        String r116 = r115.f93591a;
        if (r116 == null) goto L49;
    L52:
        if ((r416 & 16384) == 0) goto L54;
        C5849a r105 = new C5849a(0, false, null, 0, null, 63);
    L56:
        if ((r416 & 32768) == 0) goto L58;
        d7 r212 = null;
    L60:
        if ((r416 & 65536) == 0) goto L62;
        v1 r213 = null;
    L64:
        if ((r416 & 131072) == 0) goto L66;
        g r214 = null;
    L68:
        if ((r416 & 262144) == 0) goto L70;
        long r215 = 0;
    L72:
        if ((r416 & 524288) == 0) goto L74;
        m r106 = null;
    L75:
        Intrinsics.checkNotNullParameter(r100, "initType");
        Intrinsics.checkNotNullParameter(r103, "inviteeList");
        Intrinsics.checkNotNullParameter(r114, "linkConnectionType");
        Intrinsics.checkNotNullParameter(r116, "panelSource");
        Intrinsics.checkNotNullParameter(r105, "extra");
        this.f475112b = r210;
        this.f475113c = r100;
        this.f475114d = r101;
        this.f475115e = r103;
        this.f475116f = false;
        this.f475117g = false;
        this.f475118h = r104;
        this.f475119i = r110;
        this.f475120j = r111;
        this.f475121k = r112;
        this.f475122l = r113;
        this.f475123m = r114;
        this.f475124n = r116;
        this.f475125o = r105;
        this.f475126p = r212;
        this.f475127q = r213;
        this.f475128r = r214;
        this.f475129s = r215;
        this.f475130t = r106;
        this.f475111a = r102;
        return;
    L74:
        r106 = r415;
        goto L75
    L70:
        r215 = r414;
        goto L72
    L66:
        r214 = r413;
        goto L68
    L62:
        r213 = r412;
        goto L64
    L58:
        r212 = r411;
        goto L60
    L54:
        r105 = r410;
    L49:
        r116 = "";
        goto L52
    L50:
        r116 = r319;
        goto L52
    L41:
        r114 = r318;
        goto L43
    L37:
        r113 = r317;
        goto L39
    L33:
        r112 = r316;
        goto L35
    L29:
        r111 = r315;
        goto L31
    L25:
        r110 = r314;
        goto L27
    L21:
        r104 = r313;
        goto L23
    L17:
        r103 = r312;
        goto L19
    L13:
        r102 = r311;
        goto L15
    L9:
        r101 = r310;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }
}
