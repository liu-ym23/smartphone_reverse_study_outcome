package com.bytedance.ee.bear.middleground.comment.uitls;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.middleground.comment.Comment;
import com.bytedance.ee.bear.middleground.comment.export.CommentStyle;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentArea;
import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import com.bytedance.ee.bear.middleground.comment.export.v;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import java.util.Locale;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p implements com.bytedance.ee.bear.middleground.comment.export.i {
    public boolean A;
    public boolean B;
    public boolean C;
    public final boolean D;
    public final boolean E;
    public final boolean F;
    public final boolean G;
    public final v H;
    public final String I;
    public final boolean J;
    public final boolean K;
    public final com.bytedance.ee.bear.middleground.comment.export.g L;
    public final com.bytedance.ee.bear.middleground.comment.export.m M;
    public final gf5.d N;
    public String O;
    public final boolean P;
    public af5.b Q;
    public final com.bytedance.ee.bear.middleground.comment.export.t R;
    public final bf5.a S;
    public final boolean T;
    public final boolean U;
    public final boolean V;
    public final boolean W;
    public final com.bytedance.ee.bear.middleground.comment.export.k X;
    public Function0<Boolean> Y;
    public float Z;
    public final FragmentActivity a;
    public float a0;
    public final Fragment b;
    public float b0;
    public final FrameLayout c;
    public float c0;
    public final FrameLayout d;
    public final h d0;
    public final FrameLayout e;
    public final boolean e0;
    public final FrameLayout f;
    public final boolean f0;
    public final FragmentManager g;
    public final CommentArea g0;
    public final com.bytedance.ee.bear.middleground.comment.p h;
    public String i;
    public final String j;
    public sbb.e k;
    public final boolean l;
    public final String m;
    public final CommentStyle n;
    public final long o;
    public long p;
    public final com.bytedance.ee.bear.middleground.comment.export.o q;
    public final pcb.a r;
    public boolean s;
    public final boolean t;
    public final boolean u;
    public final boolean v;
    public final boolean w;
    public TranslateConfig x;
    public String y;
    public final boolean z;

    public static final class a {
    }

    static {
    }

    public p() {
        throw null;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof p) == true) goto L8;
        return false;
    L8:
        p r9 = (p) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r9.n) goto L51;
        return false;
    L51:
        if (this.o == r9.o) goto L54;
        return false;
    L54:
        if (this.p == r9.p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r9.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r9.r) == true) goto L63;
        return false;
    L63:
        if (this.s == r9.s) goto L66;
        return false;
    L66:
        if (this.t == r9.t) goto L69;
        return false;
    L69:
        if (this.u == r9.u) goto L72;
        return false;
    L72:
        if (this.v == r9.v) goto L75;
        return false;
    L75:
        if (this.w == r9.w) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.x, r9.x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r9.y) == true) goto L84;
        return false;
    L84:
        if (this.z == r9.z) goto L87;
        return false;
    L87:
        if (this.A == r9.A) goto L90;
        return false;
    L90:
        if (this.B == r9.B) goto L93;
        return false;
    L93:
        if (this.C == r9.C) goto L96;
        return false;
    L96:
        if (this.D == r9.D) goto L99;
        return false;
    L99:
        if (this.E == r9.E) goto L102;
        return false;
    L102:
        if (this.F == r9.F) goto L105;
        return false;
    L105:
        if (this.G == r9.G) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.H, r9.H) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.I, r9.I) == true) goto L114;
        return false;
    L114:
        if (this.J == r9.J) goto L117;
        return false;
    L117:
        if (this.K == r9.K) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.L, r9.L) == true) goto L123;
        return false;
    L123:
        if (Intrinsics.areEqual(this.M, r9.M) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.N, r9.N) == true) goto L129;
        return false;
    L129:
        if (Intrinsics.areEqual(this.O, r9.O) == true) goto L132;
        return false;
    L132:
        if (this.P == r9.P) goto L135;
        return false;
    L135:
        if (Intrinsics.areEqual(this.Q, r9.Q) == true) goto L138;
        return false;
    L138:
        if (Intrinsics.areEqual(this.R, r9.R) == true) goto L141;
        return false;
    L141:
        if (Intrinsics.areEqual(this.S, r9.S) == true) goto L144;
        return false;
    L144:
        if (this.T == r9.T) goto L147;
        return false;
    L147:
        if (this.U == r9.U) goto L150;
        return false;
    L150:
        if (this.V == r9.V) goto L153;
        return false;
    L153:
        if (this.W == r9.W) goto L156;
        return false;
    L156:
        if (Intrinsics.areEqual(this.X, r9.X) == true) goto L159;
        return false;
    L159:
        if (Intrinsics.areEqual(this.Y, r9.Y) == true) goto L161;
        return false;
    L161:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Fragment r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.c.hashCode()) * 31;
        FrameLayout r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((((((((((((r4 + r6) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31;
        int r8 = 1231;
        if (this.l == false) goto L13;
        int r9 = 1231;
    L14:
        int r10 = (((((r7 + r9) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31;
        long r11 = this.o;
        int r12 = (r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31;
        long r13 = this.p;
        int r14 = (((((r12 + ((int) (r13 ^ (r13 >>> 32)))) * 31) + this.q.hashCode()) * 31) + this.r.hashCode()) * 31;
        if (this.s == false) goto L17;
        int r15 = 1231;
    L18:
        int r16 = (r14 + r15) * 31;
        if (this.t == false) goto L21;
        int r17 = 1231;
    L22:
        int r18 = (r16 + r17) * 31;
        if (this.u == false) goto L25;
        int r19 = 1231;
    L26:
        int r20 = (r18 + r19) * 31;
        if (this.v == false) goto L29;
        int r21 = 1231;
    L30:
        int r22 = (r20 + r21) * 31;
        if (this.w == false) goto L33;
        int r23 = 1231;
    L34:
        int r24 = (((((r22 + r23) * 31) + this.x.hashCode()) * 31) + this.y.hashCode()) * 31;
        if (this.z == false) goto L37;
        int r25 = 1231;
    L38:
        int r26 = (r24 + r25) * 31;
        if (this.A == false) goto L41;
        int r27 = 1231;
    L42:
        int r28 = (r26 + r27) * 31;
        if (this.B == false) goto L45;
        int r29 = 1231;
    L46:
        int r30 = (r28 + r29) * 31;
        if (this.C == false) goto L49;
        int r31 = 1231;
    L50:
        int r32 = (r30 + r31) * 31;
        if (this.D == false) goto L53;
        int r33 = 1231;
    L54:
        int r34 = (r32 + r33) * 31;
        if (this.E == false) goto L57;
        int r35 = 1231;
    L58:
        int r36 = (r34 + r35) * 31;
        if (this.F == false) goto L61;
        int r37 = 1231;
    L62:
        int r38 = (r36 + r37) * 31;
        if (this.G == false) goto L65;
        int r39 = 1231;
    L66:
        int r40 = (r38 + r39) * 31;
        v r41 = this.H;
        if (r41 != null) goto L69;
        int r42 = 0;
    L70:
        int r43 = (r40 + r42) * 31;
        String r44 = this.I;
        if (r44 != null) goto L73;
        int r45 = 0;
    L74:
        int r46 = (r43 + r45) * 31;
        if (this.J == false) goto L77;
        int r47 = 1231;
    L78:
        int r48 = (r46 + r47) * 31;
        if (this.K == false) goto L81;
        int r49 = 1231;
    L82:
        int r50 = (r48 + r49) * 31;
        com.bytedance.ee.bear.middleground.comment.export.g r51 = this.L;
        if (r51 != null) goto L85;
        int r52 = 0;
    L86:
        int r53 = (r50 + r52) * 31;
        com.bytedance.ee.bear.middleground.comment.export.m r54 = this.M;
        if (r54 != null) goto L89;
        int r55 = 0;
    L90:
        int r56 = (((r53 + r55) * 31) + this.N.hashCode()) * 31;
        String r57 = this.O;
        if (r57 != null) goto L93;
        int r58 = 0;
    L94:
        int r59 = (r56 + r58) * 31;
        if (this.P == false) goto L97;
        int r60 = 1231;
    L98:
        int r61 = (r59 + r60) * 31;
        af5.b r62 = this.Q;
        if (r62 != null) goto L101;
        int r63 = 0;
    L102:
        int r64 = (r61 + r63) * 31;
        com.bytedance.ee.bear.middleground.comment.export.t r65 = this.R;
        if (r65 != null) goto L105;
        int r66 = 0;
    L106:
        int r67 = (((r64 + r66) * 31) + this.S.hashCode()) * 31;
        if (this.T == false) goto L109;
        int r68 = 1231;
    L110:
        int r69 = (r67 + r68) * 31;
        if (this.U == false) goto L113;
        int r70 = 1231;
    L114:
        int r71 = (r69 + r70) * 31;
        if (this.V == false) goto L117;
        int r72 = 1231;
    L118:
        int r73 = (r71 + r72) * 31;
        if (this.W == true) goto L122;
        r8 = 1237;
    L122:
        int r74 = (((r73 + r8) * 31) + this.X.hashCode()) * 31;
        Function0<Boolean> r75 = this.Y;
        if (r75 == null) goto L127;
        r2 = r75.hashCode();
    L127:
        return r74 + r2;
    L117:
        r72 = 1237;
        goto L118
    L113:
        r70 = 1237;
        goto L114
    L109:
        r68 = 1237;
        goto L110
    L105:
        r66 = r65.hashCode();
        goto L106
    L101:
        r63 = r62.hashCode();
        goto L102
    L97:
        r60 = 1237;
        goto L98
    L93:
        r58 = r57.hashCode();
        goto L94
    L89:
        r55 = r54.hashCode();
        goto L90
    L85:
        r52 = r51.hashCode();
        goto L86
    L81:
        r49 = 1237;
        goto L82
    L77:
        r47 = 1237;
        goto L78
    L73:
        r45 = r44.hashCode();
        goto L74
    L69:
        r42 = r41.hashCode();
        goto L70
    L65:
        r39 = 1237;
        goto L66
    L61:
        r37 = 1237;
        goto L62
    L57:
        r35 = 1237;
        goto L58
    L53:
        r33 = 1237;
        goto L54
    L49:
        r31 = 1237;
        goto L50
    L45:
        r29 = 1237;
        goto L46
    L41:
        r27 = 1237;
        goto L42
    L37:
        r25 = 1237;
        goto L38
    L33:
        r23 = 1237;
        goto L34
    L29:
        r21 = 1237;
        goto L30
    L25:
        r19 = 1237;
        goto L26
    L21:
        r17 = 1237;
        goto L22
    L17:
        r15 = 1237;
        goto L18
    L13:
        r9 = 1237;
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "Config(activity=" + this.a + ", sourceFragment=" + this.b + ", viewParent=" + this.c + ", asideContainer=" + this.d + ", imageViewerParent=" + this.e + ", reactionAnimationParent=" + this.f + ", fragmentManager=" + this.g + ", commentServiceImpl=" + this.h + ", token=" + this.i + ", docUrl=" + this.j + ", pageType=" + this.k + ", isWiki=" + this.l + ", subFileType=" + this.m + ", commentStyle=" + this.n + ", commentType=" + this.o + ", styleType=" + this.p + ", per=" + this.q + ", keyboardHeightProvider=" + this.r + ", isVC=" + this.s + ", inCCM=" + this.t + ", hideResolveEntry=" + this.u + ", showVoice=" + this.v + ", showReaction=" + this.w + ", translate=" + this.x + ", currentCommentId=" + this.y + ", showBlank=" + this.z + ", useCustomHeight=" + this.A + ", usePermissionShare=" + this.B + ", usePhoneLandscapeMode=" + this.C + ", audioAvailable=" + this.D + ", showInsertImage=" + this.E + ", showCommentImage=" + this.F + ", enableFontScale=" + this.G + ", isOwner=" + this.H + ", appId=" + this.I + ", disableShowShadow=" + this.J + ", useWebDataControl=" + this.K + ", calcScrollPosConf=" + this.L + ", interceptor=" + this.M + ", eventDispatcher=" + this.N + ", copyLinkTemplate=" + this.O + ", setStatusBarColor=" + this.P + ", perfProvider=" + this.Q + ", vcInfo=" + this.R + ", adminPermission=" + this.S + ", enableFilePreviewPermission=" + this.T + ", enableMarkdownRender=" + this.U + ", isRecordComment=" + this.V + ", isHostAdjustResize=" + this.W + ", hostDelegate=" + this.X + ", createWholeCommentAction=" + this.Y + ')';
    }

    public final FragmentManager d() {
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm_mobile_ccm_at_doubao_reverse_in_feishu") == true) goto L7;
        return this.g;
    L7:
        if (ForsetiHelper.s(this.b) == false) goto L13;
        Fragment r0 = ForsetiHelper.g(this.b);
        if (r0 == null) goto L16;
        FragmentManager r1 = r0.getChildFragmentManager();
        if (r1 == null) goto L16;
        return r1;
    L16:
        return getActivity().getSupportFragmentManager();
    L13:
        FragmentManager r2 = getActivity().getSupportFragmentManager();
        Intrinsics.checkNotNull(r2);
        return r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.i
    public final af5.b a() {
        return this.Q;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.i
    public final h b() {
        return this.d0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.i
    public final com.bytedance.ee.bear.middleground.comment.export.o c() {
        return this.q;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.i
    public FragmentActivity getActivity() {
        return this.a;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.i
    public final CommentArea getArea() {
        return this.g0;
    }

    public p(FragmentActivity r18, Fragment r19, FrameLayout r20, FrameLayout r21, FrameLayout r22, FrameLayout r23, FragmentManager r24, com.bytedance.ee.bear.middleground.comment.p r25, String r26, String r27, sbb.e r28, boolean r29, String r30, CommentStyle r31, long r32, long r34, com.bytedance.ee.bear.middleground.comment.export.o r36, pcb.a r37, boolean r38, boolean r39, boolean r40, boolean r41, boolean r42, boolean r43, boolean r44, v r45, boolean r46, com.bytedance.ee.bear.middleground.comment.export.g r47, com.bytedance.ee.bear.middleground.comment.export.m r48, Comment.c r49, com.bytedance.ee.bear.middleground.comment.export.t r50, bf5.a r51, boolean r52, boolean r53, boolean r54, boolean r55, com.bytedance.ee.bear.middleground.comment.export.k r56, Function0 r57) {
        TranslateConfig r0 = new TranslateConfig();
        Intrinsics.checkNotNullParameter(r18, "activity");
        Intrinsics.checkNotNullParameter(r20, "viewParent");
        Intrinsics.checkNotNullParameter(r22, "imageViewerParent");
        Intrinsics.checkNotNullParameter(r23, "reactionAnimationParent");
        Intrinsics.checkNotNullParameter(r24, "fragmentManager");
        Intrinsics.checkNotNullParameter(r25, "commentServiceImpl");
        Intrinsics.checkNotNullParameter(r26, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r27, "docUrl");
        Intrinsics.checkNotNullParameter(r28, "pageType");
        Intrinsics.checkNotNullParameter(r30, "subFileType");
        Intrinsics.checkNotNullParameter(r31, "commentStyle");
        Intrinsics.checkNotNullParameter(r36, "per");
        Intrinsics.checkNotNullParameter(r37, "keyboardHeightProvider");
        Intrinsics.checkNotNullParameter(r0, "translate");
        Intrinsics.checkNotNullParameter("", "currentCommentId");
        Intrinsics.checkNotNullParameter(r49, "eventDispatcher");
        Intrinsics.checkNotNullParameter(r51, "adminPermission");
        Intrinsics.checkNotNullParameter(r56, "hostDelegate");
        this.a = r18;
        this.b = r19;
        this.c = r20;
        this.d = r21;
        this.e = r22;
        this.f = r23;
        this.g = r24;
        this.h = r25;
        this.i = r26;
        this.j = r27;
        this.k = r28;
        this.l = r29;
        this.m = r30;
        this.n = r31;
        this.o = r32;
        this.p = r34;
        this.q = r36;
        this.r = r37;
        this.s = r38;
        boolean r4 = true;
        this.t = true;
        this.u = false;
        this.v = r39;
        this.w = r40;
        this.x = r0;
        this.y = "";
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = r41;
        this.E = r42;
        this.F = r43;
        this.G = r44;
        this.H = r45;
        this.I = "";
        this.J = false;
        this.K = r46;
        this.L = r47;
        this.M = r48;
        this.N = r49;
        this.O = null;
        this.P = true;
        this.Q = null;
        this.R = r50;
        this.S = r51;
        this.T = r52;
        this.U = r53;
        this.V = r54;
        this.W = r55;
        this.X = r56;
        this.Y = r57;
        this.Z = 0.2f;
        this.a0 = 0.4f;
        this.b0 = 0.6928f;
        this.c0 = 0.9f;
        String r9 = r28.getType();
        if (r32 != 0) goto L5;
        boolean r1 = true;
    L6:
        this.d0 = new h(r25, r26, r9, r1, r31.getStyle(), r45, this.s);
        com.bytedance.ee.bear.appsetting.c r2 = com.bytedance.ee.bear.appsetting.c.a.a;
        boolean r3 = r2.h("ccm.comment.private_comment_permission");
        if (r3 == true) goto L9;
        tt5.a.h("Config", "isCommentPrivateVisible, isEnable: " + r3);
        boolean r5 = TextUtils.equals(this.k.getType(), sbb.e.o.getType());
    L39:
        this.e0 = r5;
        this.f0 = r5;
        this.g0 = new CommentArea();
        return;
    L9:
        tt5.a.h("Config", "isCommentPrivateVisible, pageType.type: " + this.k.getType());
        String r6 = this.k.getType();
        if (Intrinsics.areEqual(r6, sbb.e.k.getType()) == false) goto L12;
    L38:
        r5 = r4;
        goto L39
    L12:
        if (Intrinsics.areEqual(r6, sbb.e.h.getType()) == true) goto L38;
        if (Intrinsics.areEqual(r6, sbb.e.m.getType()) == true) goto L38;
        if (Intrinsics.areEqual(r6, sbb.e.o.getType()) == true) goto L38;
        if (Intrinsics.areEqual(r6, sbb.e.l.getType()) == false) goto L35;
        String r7 = StringsKt.removePrefix(StringsKt.trim(r30).toString(), ".").toLowerCase(Locale.ROOT);
        if (r7.length() != 0) goto L23;
        boolean r8 = true;
    L24:
        if (r8 == false) goto L27;
    L37:
        r4 = false;
        goto L38
    L27:
        if (TextUtils.equals(r7, ExportFileExtension.PDF) == true) goto L38;
        String r10 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r7);
        if (r10 == null) goto L37;
        if (StringsKt.startsWith$default(r10, "image/", false, 2, null) != true) goto L37;
    L23:
        r8 = false;
        goto L24
    L35:
        if (Intrinsics.areEqual(r6, sbb.e.i.getType()) == false) goto L37;
        r4 = r2.h("base.comment.private_comment_permission");
        goto L38
    L5:
        r1 = false;
        goto L6
    }
}
