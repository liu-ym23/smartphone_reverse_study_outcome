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
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import java.util.Locale;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
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

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final boolean f232217J;
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f232218a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f232219a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f232220b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f232221b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f232222c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public float f232223c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f232224d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final h f232225d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f232226e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final boolean f232227e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f232228f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final boolean f232229f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FragmentManager f232230g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final CommentArea f232231g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.comment.p f232232h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f232233i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f232234j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public sbb.e f232235k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f232236l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f232237m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CommentStyle f232238n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f232239o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f232240p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.comment.export.o f232241q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final pcb.a f232242r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f232243s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f232244t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f232245u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f232246v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f232247w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TranslateConfig f232248x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f232249y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f232250z;

    public static final class a {
    }

    static {
    }

    public p() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f232218a, r101.f232218a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f232220b, r101.f232220b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f232222c, r101.f232222c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f232224d, r101.f232224d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f232226e, r101.f232226e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f232228f, r101.f232228f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f232230g, r101.f232230g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f232232h, r101.f232232h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f232233i, r101.f232233i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f232234j, r101.f232234j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f232235k, r101.f232235k) == true) goto L42;
        return false;
    L42:
        if (this.f232236l == r101.f232236l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f232237m, r101.f232237m) == true) goto L48;
        return false;
    L48:
        if (this.f232238n == r101.f232238n) goto L51;
        return false;
    L51:
        if (this.f232239o == r101.f232239o) goto L54;
        return false;
    L54:
        if (this.f232240p == r101.f232240p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f232241q, r101.f232241q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f232242r, r101.f232242r) == true) goto L63;
        return false;
    L63:
        if (this.f232243s == r101.f232243s) goto L66;
        return false;
    L66:
        if (this.f232244t == r101.f232244t) goto L69;
        return false;
    L69:
        if (this.f232245u == r101.f232245u) goto L72;
        return false;
    L72:
        if (this.f232246v == r101.f232246v) goto L75;
        return false;
    L75:
        if (this.f232247w == r101.f232247w) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.f232248x, r101.f232248x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.f232249y, r101.f232249y) == true) goto L84;
        return false;
    L84:
        if (this.f232250z == r101.f232250z) goto L87;
        return false;
    L87:
        if (this.A == r101.A) goto L90;
        return false;
    L90:
        if (this.B == r101.B) goto L93;
        return false;
    L93:
        if (this.C == r101.C) goto L96;
        return false;
    L96:
        if (this.D == r101.D) goto L99;
        return false;
    L99:
        if (this.E == r101.E) goto L102;
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
        if (this.f232217J == r101.f232217J) goto L117;
        return false;
    L117:
        if (this.K == r101.K) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.L, r101.L) == true) goto L123;
        return false;
    L123:
        if (Intrinsics.areEqual(this.M, r101.M) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.N, r101.N) == true) goto L129;
        return false;
    L129:
        if (Intrinsics.areEqual(this.O, r101.O) == true) goto L132;
        return false;
    L132:
        if (this.P == r101.P) goto L135;
        return false;
    L135:
        if (Intrinsics.areEqual(this.Q, r101.Q) == true) goto L138;
        return false;
    L138:
        if (Intrinsics.areEqual(this.R, r101.R) == true) goto L141;
        return false;
    L141:
        if (Intrinsics.areEqual(this.S, r101.S) == true) goto L144;
        return false;
    L144:
        if (this.T == r101.T) goto L147;
        return false;
    L147:
        if (this.U == r101.U) goto L150;
        return false;
    L150:
        if (this.V == r101.V) goto L153;
        return false;
    L153:
        if (this.W == r101.W) goto L156;
        return false;
    L156:
        if (Intrinsics.areEqual(this.X, r101.X) == true) goto L159;
        return false;
    L159:
        if (Intrinsics.areEqual(this.Y, r101.Y) == true) goto L161;
        return false;
    L161:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f232218a.hashCode() * 31;
        Fragment r101 = this.f232220b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f232222c.hashCode()) * 31;
        FrameLayout r105 = this.f232224d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((((((((((((r104 + r106) * 31) + this.f232226e.hashCode()) * 31) + this.f232228f.hashCode()) * 31) + this.f232230g.hashCode()) * 31) + this.f232232h.hashCode()) * 31) + this.f232233i.hashCode()) * 31) + this.f232234j.hashCode()) * 31) + this.f232235k.hashCode()) * 31;
        int r108 = 1231;
        if (this.f232236l == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (((((r107 + r109) * 31) + this.f232237m.hashCode()) * 31) + this.f232238n.hashCode()) * 31;
        long r111 = this.f232239o;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        long r113 = this.f232240p;
        int r114 = (((((r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31) + this.f232241q.hashCode()) * 31) + this.f232242r.hashCode()) * 31;
        if (this.f232243s == false) goto L17;
        int r115 = 1231;
    L18:
        int r116 = (r114 + r115) * 31;
        if (this.f232244t == false) goto L21;
        int r117 = 1231;
    L22:
        int r118 = (r116 + r117) * 31;
        if (this.f232245u == false) goto L25;
        int r119 = 1231;
    L26:
        int r120 = (r118 + r119) * 31;
        if (this.f232246v == false) goto L29;
        int r121 = 1231;
    L30:
        int r122 = (r120 + r121) * 31;
        if (this.f232247w == false) goto L33;
        int r123 = 1231;
    L34:
        int r124 = (((((r122 + r123) * 31) + this.f232248x.hashCode()) * 31) + this.f232249y.hashCode()) * 31;
        if (this.f232250z == false) goto L37;
        int r125 = 1231;
    L38:
        int r126 = (r124 + r125) * 31;
        if (this.A == false) goto L41;
        int r127 = 1231;
    L42:
        int r128 = (r126 + r127) * 31;
        if (this.B == false) goto L45;
        int r129 = 1231;
    L46:
        int r130 = (r128 + r129) * 31;
        if (this.C == false) goto L49;
        int r131 = 1231;
    L50:
        int r132 = (r130 + r131) * 31;
        if (this.D == false) goto L53;
        int r133 = 1231;
    L54:
        int r134 = (r132 + r133) * 31;
        if (this.E == false) goto L57;
        int r135 = 1231;
    L58:
        int r136 = (r134 + r135) * 31;
        if (this.F == false) goto L61;
        int r137 = 1231;
    L62:
        int r138 = (r136 + r137) * 31;
        if (this.G == false) goto L65;
        int r139 = 1231;
    L66:
        int r140 = (r138 + r139) * 31;
        v r141 = this.H;
        if (r141 != null) goto L69;
        int r142 = 0;
    L70:
        int r143 = (r140 + r142) * 31;
        String r144 = this.I;
        if (r144 != null) goto L73;
        int r145 = 0;
    L74:
        int r146 = (r143 + r145) * 31;
        if (this.f232217J == false) goto L77;
        int r147 = 1231;
    L78:
        int r148 = (r146 + r147) * 31;
        if (this.K == false) goto L81;
        int r149 = 1231;
    L82:
        int r150 = (r148 + r149) * 31;
        com.bytedance.ee.bear.middleground.comment.export.g r151 = this.L;
        if (r151 != null) goto L85;
        int r152 = 0;
    L86:
        int r153 = (r150 + r152) * 31;
        com.bytedance.ee.bear.middleground.comment.export.m r154 = this.M;
        if (r154 != null) goto L89;
        int r155 = 0;
    L90:
        int r156 = (((r153 + r155) * 31) + this.N.hashCode()) * 31;
        String r157 = this.O;
        if (r157 != null) goto L93;
        int r158 = 0;
    L94:
        int r159 = (r156 + r158) * 31;
        if (this.P == false) goto L97;
        int r160 = 1231;
    L98:
        int r161 = (r159 + r160) * 31;
        af5.b r162 = this.Q;
        if (r162 != null) goto L101;
        int r163 = 0;
    L102:
        int r164 = (r161 + r163) * 31;
        com.bytedance.ee.bear.middleground.comment.export.t r165 = this.R;
        if (r165 != null) goto L105;
        int r166 = 0;
    L106:
        int r167 = (((r164 + r166) * 31) + this.S.hashCode()) * 31;
        if (this.T == false) goto L109;
        int r168 = 1231;
    L110:
        int r169 = (r167 + r168) * 31;
        if (this.U == false) goto L113;
        int r170 = 1231;
    L114:
        int r171 = (r169 + r170) * 31;
        if (this.V == false) goto L117;
        int r172 = 1231;
    L118:
        int r173 = (r171 + r172) * 31;
        if (this.W == true) goto L122;
        r108 = 1237;
    L122:
        int r174 = (((r173 + r108) * 31) + this.X.hashCode()) * 31;
        Function0<Boolean> r175 = this.Y;
        if (r175 == null) goto L127;
        r102 = r175.hashCode();
    L127:
        return r174 + r102;
    L117:
        r172 = 1237;
        goto L118
    L113:
        r170 = 1237;
        goto L114
    L109:
        r168 = 1237;
        goto L110
    L105:
        r166 = r165.hashCode();
        goto L106
    L101:
        r163 = r162.hashCode();
        goto L102
    L97:
        r160 = 1237;
        goto L98
    L93:
        r158 = r157.hashCode();
        goto L94
    L89:
        r155 = r154.hashCode();
        goto L90
    L85:
        r152 = r151.hashCode();
        goto L86
    L81:
        r149 = 1237;
        goto L82
    L77:
        r147 = 1237;
        goto L78
    L73:
        r145 = r144.hashCode();
        goto L74
    L69:
        r142 = r141.hashCode();
        goto L70
    L65:
        r139 = 1237;
        goto L66
    L61:
        r137 = 1237;
        goto L62
    L57:
        r135 = 1237;
        goto L58
    L53:
        r133 = 1237;
        goto L54
    L49:
        r131 = 1237;
        goto L50
    L45:
        r129 = 1237;
        goto L46
    L41:
        r127 = 1237;
        goto L42
    L37:
        r125 = 1237;
        goto L38
    L33:
        r123 = 1237;
        goto L34
    L29:
        r121 = 1237;
        goto L30
    L25:
        r119 = 1237;
        goto L26
    L21:
        r117 = 1237;
        goto L22
    L17:
        r115 = 1237;
        goto L18
    L13:
        r109 = 1237;
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "Config(activity=" + this.f232218a + ", sourceFragment=" + this.f232220b + ", viewParent=" + this.f232222c + ", asideContainer=" + this.f232224d + ", imageViewerParent=" + this.f232226e + ", reactionAnimationParent=" + this.f232228f + ", fragmentManager=" + this.f232230g + ", commentServiceImpl=" + this.f232232h + ", token=" + this.f232233i + ", docUrl=" + this.f232234j + ", pageType=" + this.f232235k + ", isWiki=" + this.f232236l + ", subFileType=" + this.f232237m + ", commentStyle=" + this.f232238n + ", commentType=" + this.f232239o + ", styleType=" + this.f232240p + ", per=" + this.f232241q + ", keyboardHeightProvider=" + this.f232242r + ", isVC=" + this.f232243s + ", inCCM=" + this.f232244t + ", hideResolveEntry=" + this.f232245u + ", showVoice=" + this.f232246v + ", showReaction=" + this.f232247w + ", translate=" + this.f232248x + ", currentCommentId=" + this.f232249y + ", showBlank=" + this.f232250z + ", useCustomHeight=" + this.A + ", usePermissionShare=" + this.B + ", usePhoneLandscapeMode=" + this.C + ", audioAvailable=" + this.D + ", showInsertImage=" + this.E + ", showCommentImage=" + this.F + ", enableFontScale=" + this.G + ", isOwner=" + this.H + ", appId=" + this.I + ", disableShowShadow=" + this.f232217J + ", useWebDataControl=" + this.K + ", calcScrollPosConf=" + this.L + ", interceptor=" + this.M + ", eventDispatcher=" + this.N + ", copyLinkTemplate=" + this.O + ", setStatusBarColor=" + this.P + ", perfProvider=" + this.Q + ", vcInfo=" + this.R + ", adminPermission=" + this.S + ", enableFilePreviewPermission=" + this.T + ", enableMarkdownRender=" + this.U + ", isRecordComment=" + this.V + ", isHostAdjustResize=" + this.W + ", hostDelegate=" + this.X + ", createWholeCommentAction=" + this.Y + ')';
    }

    public final FragmentManager d() {
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm_mobile_ccm_at_doubao_reverse_in_feishu") == true) goto L7;
        return this.f232230g;
    L7:
        if (ForsetiHelper.s(this.f232220b) == false) goto L13;
        Fragment r100 = ForsetiHelper.g(this.f232220b);
        if (r100 == null) goto L16;
        FragmentManager r101 = r100.getChildFragmentManager();
        if (r101 == null) goto L16;
        return r101;
    L16:
        return getActivity().getSupportFragmentManager();
    L13:
        FragmentManager r102 = getActivity().getSupportFragmentManager();
        Intrinsics.checkNotNull(r102);
        return r102;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.i
    public final af5.b a() {
        return this.Q;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.i
    public final h b() {
        return this.f232225d0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.i
    public final com.bytedance.ee.bear.middleground.comment.export.o c() {
        return this.f232241q;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.i
    public FragmentActivity getActivity() {
        return this.f232218a;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.i
    public final CommentArea getArea() {
        return this.f232231g0;
    }

    public p(FragmentActivity r110, Fragment r111, FrameLayout r210, FrameLayout r211, FrameLayout r212, FrameLayout r213, FragmentManager r214, com.bytedance.ee.bear.middleground.comment.p r215, String r216, String r217, sbb.e r218, boolean r219, String r310, CommentStyle r311, long r312, long r313, com.bytedance.ee.bear.middleground.comment.export.o r314, pcb.a r315, boolean r316, boolean r317, boolean r410, boolean r411, boolean r412, boolean r413, boolean r414, v r415, boolean r416, com.bytedance.ee.bear.middleground.comment.export.g r417, com.bytedance.ee.bear.middleground.comment.export.m r418, Comment.c r419, com.bytedance.ee.bear.middleground.comment.export.t r510, bf5.a r511, boolean r512, boolean r513, boolean r514, boolean r515, com.bytedance.ee.bear.middleground.comment.export.k r516, Function0 r517) {
        TranslateConfig r100 = new TranslateConfig();
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r210, "viewParent");
        Intrinsics.checkNotNullParameter(r212, "imageViewerParent");
        Intrinsics.checkNotNullParameter(r213, "reactionAnimationParent");
        Intrinsics.checkNotNullParameter(r214, "fragmentManager");
        Intrinsics.checkNotNullParameter(r215, "commentServiceImpl");
        Intrinsics.checkNotNullParameter(r216, "token");
        Intrinsics.checkNotNullParameter(r217, "docUrl");
        Intrinsics.checkNotNullParameter(r218, "pageType");
        Intrinsics.checkNotNullParameter(r310, "subFileType");
        Intrinsics.checkNotNullParameter(r311, "commentStyle");
        Intrinsics.checkNotNullParameter(r314, "per");
        Intrinsics.checkNotNullParameter(r315, "keyboardHeightProvider");
        Intrinsics.checkNotNullParameter(r100, "translate");
        Intrinsics.checkNotNullParameter("", "currentCommentId");
        Intrinsics.checkNotNullParameter(r419, "eventDispatcher");
        Intrinsics.checkNotNullParameter(r511, "adminPermission");
        Intrinsics.checkNotNullParameter(r516, "hostDelegate");
        this.f232218a = r110;
        this.f232220b = r111;
        this.f232222c = r210;
        this.f232224d = r211;
        this.f232226e = r212;
        this.f232228f = r213;
        this.f232230g = r214;
        this.f232232h = r215;
        this.f232233i = r216;
        this.f232234j = r217;
        this.f232235k = r218;
        this.f232236l = r219;
        this.f232237m = r310;
        this.f232238n = r311;
        this.f232239o = r312;
        this.f232240p = r313;
        this.f232241q = r314;
        this.f232242r = r315;
        this.f232243s = r316;
        boolean r101 = true;
        this.f232244t = true;
        this.f232245u = false;
        this.f232246v = r317;
        this.f232247w = r410;
        this.f232248x = r100;
        this.f232249y = "";
        this.f232250z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = r411;
        this.E = r412;
        this.F = r413;
        this.G = r414;
        this.H = r415;
        this.I = "";
        this.f232217J = false;
        this.K = r416;
        this.L = r417;
        this.M = r418;
        this.N = r419;
        this.O = null;
        this.P = true;
        this.Q = null;
        this.R = r510;
        this.S = r511;
        this.T = r512;
        this.U = r513;
        this.V = r514;
        this.W = r515;
        this.X = r516;
        this.Y = r517;
        this.Z = 0.2f;
        this.f232219a0 = 0.4f;
        this.f232221b0 = 0.6928f;
        this.f232223c0 = 0.9f;
        String r102 = r218.getType();
        if (r312 != 0) goto L5;
        boolean r103 = true;
    L6:
        this.f232225d0 = new h(r215, r216, r102, r103, r311.getStyle(), r415, this.f232243s);
        com.bytedance.ee.bear.appsetting.c r104 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        boolean r105 = r104.h("ccm.comment.private_comment_permission");
        if (r105 == true) goto L9;
        tt5.a.h("Config", "isCommentPrivateVisible, isEnable: " + r105);
        boolean r106 = TextUtils.equals(this.f232235k.getType(), sbb.e.f541304o.getType());
    L39:
        this.f232227e0 = r106;
        this.f232229f0 = r106;
        this.f232231g0 = new CommentArea();
        return;
    L9:
        tt5.a.h("Config", "isCommentPrivateVisible, pageType.type: " + this.f232235k.getType());
        String r107 = this.f232235k.getType();
        if (Intrinsics.areEqual(r107, sbb.e.f541300k.getType()) == false) goto L12;
    L38:
        r106 = r101;
        goto L39
    L12:
        if (Intrinsics.areEqual(r107, sbb.e.f541297h.getType()) == true) goto L38;
        if (Intrinsics.areEqual(r107, sbb.e.f541302m.getType()) == true) goto L38;
        if (Intrinsics.areEqual(r107, sbb.e.f541304o.getType()) == true) goto L38;
        if (Intrinsics.areEqual(r107, sbb.e.f541301l.getType()) == false) goto L35;
        String r108 = StringsKt.removePrefix(StringsKt.trim(r310).toString(), ".").toLowerCase(Locale.ROOT);
        if (r108.length() != 0) goto L23;
        boolean r109 = true;
    L24:
        if (r109 == false) goto L27;
    L37:
        r101 = false;
        goto L38
    L27:
        if (TextUtils.equals(r108, ExportFileExtension.PDF) == true) goto L38;
        String r112 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r108);
        if (r112 == null) goto L37;
        if (StringsKt.startsWith$default(r112, "image/", false, 2, null) != true) goto L37;
    L23:
        r109 = false;
        goto L24
    L35:
        if (Intrinsics.areEqual(r107, sbb.e.f541298i.getType()) == false) goto L37;
        r101 = r104.h("base.comment.private_comment_permission");
        goto L38
    L5:
        r103 = false;
        goto L6
    }
}
