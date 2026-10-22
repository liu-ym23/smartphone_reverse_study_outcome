package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.richtext.CommentVoiceEditTextBridge;
import com.ss.android.lark.audio.voiceinput.VoiceInputSpeechScene;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f {
    public final boolean A;
    public final Function0<Unit> B;
    public final Function0<Unit> C;
    public final Function0<Unit> D;
    public final Function2<List<String>, Function1<? super Map<String, Boolean>, Unit>, Unit> E;
    public final Function1<Boolean, Unit> F;
    public final Function1<Boolean, Unit> G;
    public final Function0<Boolean> H;
    public final o I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Function2<p, CharSequence, Unit> f230399J;
    public final Function2<View, MotionEvent, Boolean> K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f230400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f230401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CommentVoiceEditTextBridge f230402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<ViewGroup> f230403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f230404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.comment.uitls.h f230405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f230406g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f230407h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final VoiceInputSpeechScene f230408i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f230409j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<View> f230410k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function0<View> f230411l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<View> f230412m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f230413n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function0<Unit> f230414o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function0<Unit> f230415p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Function1<Boolean, Unit> f230416q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Function0<List<View>> f230417r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Function0<List<View>> f230418s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Function0<List<View>> f230419t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Function0<List<View>> f230420u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Function0<List<View>> f230421v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.plugin.tool.voice.immersive.a f230422w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f230423x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Integer f230424y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f230425z;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f230400a, r101.f230400a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f230401b, r101.f230401b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f230402c, r101.f230402c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f230403d, r101.f230403d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f230404e, r101.f230404e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f230405f, r101.f230405f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f230406g, r101.f230406g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f230407h, r101.f230407h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f230408i, r101.f230408i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f230409j, r101.f230409j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f230410k, r101.f230410k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f230411l, r101.f230411l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f230412m, r101.f230412m) == true) goto L48;
        return false;
    L48:
        if (this.f230413n == r101.f230413n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f230414o, r101.f230414o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f230415p, r101.f230415p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f230416q, r101.f230416q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f230417r, r101.f230417r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f230418s, r101.f230418s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f230419t, r101.f230419t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f230420u, r101.f230420u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f230421v, r101.f230421v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f230422w, r101.f230422w) == true) goto L78;
        return false;
    L78:
        if (this.f230423x == r101.f230423x) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.f230424y, r101.f230424y) == true) goto L84;
        return false;
    L84:
        if (this.f230425z == r101.f230425z) goto L87;
        return false;
    L87:
        if (this.A == r101.A) goto L90;
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
        if (Intrinsics.areEqual(this.F, r101.F) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.G, r101.G) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.H, r101.H) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.I, r101.I) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.f230399J, r101.f230399J) == true) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.K, r101.K) == true) goto L119;
        return false;
    L119:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f230400a.hashCode() * 31;
        Fragment r101 = this.f230401b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f230402c.hashCode()) * 31;
        Function0<ViewGroup> r105 = this.f230403d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f230404e.hashCode()) * 31;
        com.bytedance.ee.bear.middleground.comment.uitls.h r108 = this.f230405f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((((r107 + r109) * 31) + this.f230406g.hashCode()) * 31) + this.f230407h.hashCode()) * 31;
        VoiceInputSpeechScene r111 = this.f230408i;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (((r110 + r112) * 31) + this.f230409j.hashCode()) * 31;
        Function0<View> r114 = this.f230410k;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Function0<View> r117 = this.f230411l;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        Function0<View> r120 = this.f230412m;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        int r123 = 1231;
        if (this.f230413n == false) goto L33;
        int r124 = 1231;
    L34:
        int r125 = (r122 + r124) * 31;
        Function0<Unit> r126 = this.f230414o;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        Function0<Unit> r129 = this.f230415p;
        if (r129 != null) goto L41;
        int r130 = 0;
    L42:
        int r131 = (r128 + r130) * 31;
        Function1<Boolean, Unit> r132 = this.f230416q;
        if (r132 != null) goto L45;
        int r133 = 0;
    L46:
        int r134 = (r131 + r133) * 31;
        Function0<List<View>> r135 = this.f230417r;
        if (r135 != null) goto L49;
        int r136 = 0;
    L50:
        int r137 = (r134 + r136) * 31;
        Function0<List<View>> r138 = this.f230418s;
        if (r138 != null) goto L53;
        int r139 = 0;
    L54:
        int r140 = (r137 + r139) * 31;
        Function0<List<View>> r141 = this.f230419t;
        if (r141 != null) goto L57;
        int r142 = 0;
    L58:
        int r143 = (r140 + r142) * 31;
        Function0<List<View>> r144 = this.f230420u;
        if (r144 != null) goto L61;
        int r145 = 0;
    L62:
        int r146 = (r143 + r145) * 31;
        Function0<List<View>> r147 = this.f230421v;
        if (r147 != null) goto L65;
        int r148 = 0;
    L66:
        int r149 = (r146 + r148) * 31;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.a r150 = this.f230422w;
        if (r150 != null) goto L69;
        int r151 = 0;
    L70:
        int r152 = (r149 + r151) * 31;
        if (this.f230423x == false) goto L73;
        int r153 = 1231;
    L74:
        int r154 = (r152 + r153) * 31;
        Integer r155 = this.f230424y;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (((r154 + r156) * 31) + this.f230425z) * 31;
        if (this.A == true) goto L82;
        r123 = 1237;
    L82:
        int r158 = (r157 + r123) * 31;
        Function0<Unit> r159 = this.B;
        if (r159 != null) goto L85;
        int r160 = 0;
    L86:
        int r161 = (r158 + r160) * 31;
        Function0<Unit> r162 = this.C;
        if (r162 != null) goto L89;
        int r163 = 0;
    L90:
        int r164 = (r161 + r163) * 31;
        Function0<Unit> r165 = this.D;
        if (r165 != null) goto L93;
        int r166 = 0;
    L94:
        int r167 = (r164 + r166) * 31;
        Function2<List<String>, Function1<? super Map<String, Boolean>, Unit>, Unit> r168 = this.E;
        if (r168 != null) goto L97;
        int r169 = 0;
    L98:
        int r170 = (r167 + r169) * 31;
        Function1<Boolean, Unit> r171 = this.F;
        if (r171 != null) goto L101;
        int r172 = 0;
    L102:
        int r173 = (r170 + r172) * 31;
        Function1<Boolean, Unit> r174 = this.G;
        if (r174 != null) goto L105;
        int r175 = 0;
    L106:
        int r176 = (r173 + r175) * 31;
        Function0<Boolean> r177 = this.H;
        if (r177 != null) goto L109;
        int r178 = 0;
    L110:
        int r179 = (r176 + r178) * 31;
        o r180 = this.I;
        if (r180 != null) goto L113;
        int r181 = 0;
    L114:
        int r182 = (r179 + r181) * 31;
        Function2<p, CharSequence, Unit> r183 = this.f230399J;
        if (r183 != null) goto L117;
        int r184 = 0;
    L118:
        int r185 = (r182 + r184) * 31;
        Function2<View, MotionEvent, Boolean> r186 = this.K;
        if (r186 == null) goto L123;
        r102 = r186.hashCode();
    L123:
        return r185 + r102;
    L117:
        r184 = r183.hashCode();
        goto L118
    L113:
        r181 = r180.hashCode();
        goto L114
    L109:
        r178 = r177.hashCode();
        goto L110
    L105:
        r175 = r174.hashCode();
        goto L106
    L101:
        r172 = r171.hashCode();
        goto L102
    L97:
        r169 = r168.hashCode();
        goto L98
    L93:
        r166 = r165.hashCode();
        goto L94
    L89:
        r163 = r162.hashCode();
        goto L90
    L85:
        r160 = r159.hashCode();
        goto L86
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = 1237;
        goto L74
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
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = 1237;
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
        return "CommentVoiceInputContext(hostActivity=" + this.f230400a + ", hostFragment=" + this.f230401b + ", editTextBridge=" + this.f230402c + ", advancedUiContainerProvider=" + this.f230403d + ", psdaToken=" + this.f230404e + ", commentAnalytic=" + this.f230405f + ", fileId=" + this.f230406g + ", fileType=" + this.f230407h + ", speechScene=" + this.f230408i + ", voiceInputLocation=" + this.f230409j + ", textBarProvider=" + this.f230410k + ", voiceBarProvider=" + this.f230411l + ", advancedAnchorProvider=" + this.f230412m + ", hideAdvancedAnchorInVoice=" + this.f230413n + ", imeHider=" + this.f230414o + ", imeShower=" + this.f230415p + ", voiceBarDismissInterceptor=" + this.f230416q + ", extraHiddenInVoiceProvider=" + this.f230417r + ", extraInvisibleInVoiceProvider=" + this.f230418s + ", extraHiddenInAdvancedProvider=" + this.f230419t + ", extraInvisibleInAdvancedProvider=" + this.f230420u + ", extraShownInAdvancedProvider=" + this.f230421v + ", advanceVoiceButtonConfig=" + this.f230422w + ", isAsideMode=" + this.f230423x + ", advancedHostTopMarginPx=" + this.f230424y + ", advancedHostBottomMarginPx=" + this.f230425z + ", restoreTextBarOnAdvancedDismiss=" + this.A + ", onAdvancedDismiss=" + this.B + ", onEnterVoiceMode=" + this.C + ", onVoiceRichTextChanged=" + this.D + ", mentionUserReadPermissionFetcher=" + this.E + ", forceOrientationRequestHandler=" + this.F + ", onVoiceBarShowingChanged=" + this.G + ", primaryVoiceClickInterceptor=" + this.H + ", simpleInputContext=" + this.I + ", unifiedVoiceComponentSimpleFinalTextHandler=" + this.f230399J + ", larkSimpleTouchHandler=" + this.K + ')';
    }

    public static f a(f r410, Function0 r411, boolean r412, Function0 r413, Function0 r414, Function0 r415, Function0 r416, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.a r417, boolean r510, Integer r511, int r512, Function0 r513, Function0 r514, Function1 r515, int r516, int r517) {
        Function2<View, MotionEvent, Boolean> r100 = null;
        if ((r516 & 1) == 0) goto L5;
        Activity r101 = r410.f230400a;
    L7:
        if ((r516 & 2) == 0) goto L9;
        Fragment r102 = r410.f230401b;
    L11:
        if ((r516 & 4) == 0) goto L13;
        CommentVoiceEditTextBridge r103 = r410.f230402c;
    L15:
        if ((r516 & 8) == 0) goto L17;
        Function0<ViewGroup> r104 = r410.f230403d;
    L19:
        if ((r516 & 16) == 0) goto L21;
        String r105 = r410.f230404e;
    L23:
        if ((r516 & 32) == 0) goto L25;
        com.bytedance.ee.bear.middleground.comment.uitls.h r110 = r410.f230405f;
    L27:
        if ((r516 & 64) == 0) goto L29;
        String r111 = r410.f230406g;
    L31:
        if ((r516 & 128) == 0) goto L33;
        String r112 = r410.f230407h;
    L35:
        if ((r516 & 256) == 0) goto L37;
        VoiceInputSpeechScene r113 = r410.f230408i;
    L39:
        if ((r516 & 512) == 0) goto L41;
        String r114 = r410.f230409j;
    L43:
        if ((r516 & 1024) == 0) goto L45;
        Function0<View> r115 = r410.f230410k;
    L47:
        if ((r516 & 2048) == 0) goto L49;
        Function0<View> r116 = r410.f230411l;
    L51:
        if ((r516 & 4096) == 0) goto L53;
        Function0 r117 = r410.f230412m;
    L55:
        if ((r516 & 8192) == 0) goto L57;
        boolean r118 = r410.f230413n;
    L59:
        if ((r516 & 16384) == 0) goto L61;
        Function0 r119 = r410.f230414o;
    L63:
        if ((32768 & r516) == 0) goto L65;
        Function0<Unit> r210 = r410.f230415p;
    L67:
        if ((65536 & r516) == 0) goto L69;
        Function1<Boolean, Unit> r211 = r410.f230416q;
    L71:
        if ((131072 & r516) == 0) goto L73;
        Function0<List<View>> r212 = r410.f230417r;
    L75:
        if ((262144 & r516) == 0) goto L77;
        Function0 r213 = r410.f230418s;
    L79:
        if ((524288 & r516) == 0) goto L81;
        Function0<List<View>> r214 = r410.f230419t;
    L83:
        if ((1048576 & r516) == 0) goto L85;
        Function0 r215 = r410.f230420u;
    L87:
        if ((2097152 & r516) == 0) goto L89;
        Function0 r216 = r410.f230421v;
    L91:
        if ((4194304 & r516) == 0) goto L93;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.a r217 = r410.f230422w;
    L95:
        if ((8388608 & r516) == 0) goto L97;
        boolean r218 = r410.f230423x;
    L99:
        if ((16777216 & r516) == 0) goto L101;
        Integer r219 = r410.f230424y;
    L103:
        if ((33554432 & r516) == 0) goto L105;
        int r310 = r410.f230425z;
    L107:
        if ((67108864 & r516) == 0) goto L109;
        boolean r311 = r410.A;
    L111:
        if ((134217728 & r516) == 0) goto L113;
        Function0 r312 = r410.B;
    L115:
        if ((268435456 & r516) == 0) goto L117;
        Function0 r313 = r410.C;
    L119:
        if ((536870912 & r516) == 0) goto L121;
        Function0<Unit> r314 = r410.D;
    L123:
        if ((1073741824 & r516) == 0) goto L125;
        Function2<List<String>, Function1<? super Map<String, Boolean>, Unit>, Unit> r315 = r410.E;
    L127:
        if ((r516 & Integer.MIN_VALUE) == 0) goto L129;
        Function1<Boolean, Unit> r316 = r410.F;
    L131:
        if ((r517 & 1) == 0) goto L133;
        Function1 r317 = r410.G;
    L135:
        if ((r517 & 2) == 0) goto L137;
        Function0<Boolean> r318 = r410.H;
    L139:
        if ((r517 & 4) == 0) goto L141;
        o r319 = r410.I;
    L143:
        if ((r517 & 8) == 0) goto L145;
        Function2<p, CharSequence, Unit> r418 = r410.f230399J;
    L147:
        if ((r517 & 16) == 0) goto L149;
        r100 = r410.K;
    L149:
        Intrinsics.checkNotNullParameter(r101, "hostActivity");
        Intrinsics.checkNotNullParameter(r103, "editTextBridge");
        Intrinsics.checkNotNullParameter(r105, "psdaToken");
        Intrinsics.checkNotNullParameter(r111, "fileId");
        Intrinsics.checkNotNullParameter(r112, "fileType");
        Intrinsics.checkNotNullParameter(r114, "voiceInputLocation");
        return new f(r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r418, r100);
    L145:
        r418 = null;
        goto L147
    L141:
        r319 = null;
        goto L143
    L137:
        r318 = null;
        goto L139
    L133:
        r317 = r515;
        goto L135
    L129:
        r316 = null;
        goto L131
    L125:
        r315 = null;
        goto L127
    L121:
        r314 = null;
        goto L123
    L117:
        r313 = r514;
        goto L119
    L113:
        r312 = r513;
        goto L115
    L109:
        r311 = false;
        goto L111
    L105:
        r310 = r512;
        goto L107
    L101:
        r219 = r511;
        goto L103
    L97:
        r218 = r510;
        goto L99
    L93:
        r217 = r417;
        goto L95
    L89:
        r216 = r416;
        goto L91
    L85:
        r215 = r415;
        goto L87
    L81:
        r214 = null;
        goto L83
    L77:
        r213 = r414;
        goto L79
    L73:
        r212 = null;
        goto L75
    L69:
        r211 = null;
        goto L71
    L65:
        r210 = null;
        goto L67
    L61:
        r119 = r413;
        goto L63
    L57:
        r118 = r412;
        goto L59
    L53:
        r117 = r411;
        goto L55
    L49:
        r116 = null;
        goto L51
    L45:
        r115 = null;
        goto L47
    L41:
        r114 = null;
        goto L43
    L37:
        r113 = null;
        goto L39
    L33:
        r112 = null;
        goto L35
    L29:
        r111 = null;
        goto L31
    L25:
        r110 = null;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public /* synthetic */ f(FragmentActivity r310, Fragment r410, CommentVoiceEditTextBridge r411, Function0 r412, com.bytedance.ee.bear.middleground.comment.uitls.h r413, String r414, String r415, VoiceInputSpeechScene r416, Function0 r417, Function0 r418, Function0 r419, Function0 r510, Function0 r511, Function1 r512, Function0 r513, Function0 r514, Function0 r515, Function0 r516, Function2 r517, Function1 r518, Function1 r519, Function0 r610, o r611, Function2 r612, Function2 r613, int r614, int r615) {
        if ((r614 & 32) == 0) goto L5;
        com.bytedance.ee.bear.middleground.comment.uitls.h r100 = null;
    L7:
        if ((r614 & 64) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r614 & 128) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r614 & 256) == 0) goto L17;
        VoiceInputSpeechScene r103 = null;
    L19:
        if ((r614 & 1024) == 0) goto L21;
        Function0 r110 = null;
    L23:
        if ((r614 & 2048) == 0) goto L25;
        Function0 r111 = null;
    L27:
        if ((r614 & 4096) == 0) goto L29;
        Function0 r112 = null;
    L31:
        if ((r614 & 16384) == 0) goto L33;
        Function0 r113 = null;
    L35:
        if ((32768 & r614) == 0) goto L37;
        Function0 r114 = null;
    L39:
        if ((65536 & r614) == 0) goto L41;
        Function1 r115 = null;
    L43:
        if ((131072 & r614) == 0) goto L45;
        Function0 r116 = null;
    L47:
        if ((524288 & r614) == 0) goto L49;
        Function0 r210 = null;
    L51:
        if ((268435456 & r614) == 0) goto L53;
        Function0 r211 = null;
    L55:
        if ((536870912 & r614) == 0) goto L57;
        Function0 r311 = null;
    L59:
        if ((1073741824 & r614) == 0) goto L61;
        Function2 r312 = null;
    L63:
        if ((r614 & Integer.MIN_VALUE) == 0) goto L65;
        Function1 r313 = null;
    L67:
        if ((r615 & 1) == 0) goto L69;
        Function1 r314 = null;
    L71:
        if ((r615 & 2) == 0) goto L73;
        Function0 r315 = null;
    L75:
        if ((r615 & 4) == 0) goto L77;
        o r316 = null;
    L79:
        if ((r615 & 8) == 0) goto L81;
        Function2 r317 = null;
    L83:
        if ((r615 & 16) == 0) goto L85;
        Function2 r318 = null;
    L86:
        this(r310, r410, r411, r412, "LARK-PSDA-ccm_android_comment_request_record_audio_permssion", r100, r101, r102, r103, "input_box", r110, r111, r112, false, r113, r114, r115, r116, null, r210, null, null, null, false, null, 0, false, null, r211, r311, r312, r313, r314, r315, r316, r317, r318);
        return;
    L85:
        r318 = r613;
        goto L86
    L81:
        r317 = r612;
        goto L83
    L77:
        r316 = r611;
        goto L79
    L73:
        r315 = r610;
        goto L75
    L69:
        r314 = r519;
        goto L71
    L65:
        r313 = r518;
        goto L67
    L61:
        r312 = r517;
        goto L63
    L57:
        r311 = r516;
        goto L59
    L53:
        r211 = r515;
        goto L55
    L49:
        r210 = r514;
        goto L51
    L45:
        r116 = r513;
        goto L47
    L41:
        r115 = r512;
        goto L43
    L37:
        r114 = r511;
        goto L39
    L33:
        r113 = r510;
        goto L35
    L29:
        r112 = r419;
        goto L31
    L25:
        r111 = r418;
        goto L27
    L21:
        r110 = r417;
        goto L23
    L17:
        r103 = r416;
        goto L19
    L13:
        r102 = r415;
        goto L15
    L9:
        r101 = r414;
        goto L11
    L5:
        r100 = r413;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Activity r100, Fragment r110, CommentVoiceEditTextBridge r111, Function0<? extends ViewGroup> r112, String r113, com.bytedance.ee.bear.middleground.comment.uitls.h r114, String r115, String r116, VoiceInputSpeechScene r117, String r118, Function0<? extends View> r119, Function0<? extends View> r210, Function0<? extends View> r211, boolean r212, Function0<Unit> r213, Function0<Unit> r214, Function1<? super Boolean, Unit> r215, Function0<? extends List<? extends View>> r216, Function0<? extends List<? extends View>> r217, Function0<? extends List<? extends View>> r218, Function0<? extends List<? extends View>> r219, Function0<? extends List<? extends View>> r310, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.a r311, boolean r312, Integer r313, int r314, boolean r315, Function0<Unit> r316, Function0<Unit> r317, Function0<Unit> r318, Function2<? super List<String>, ? super Function1<? super Map<String, Boolean>, Unit>, Unit> r319, Function1<? super Boolean, Unit> r410, Function1<? super Boolean, Unit> r411, Function0<Boolean> r412, o r413, Function2<? super p, ? super CharSequence, Unit> r414, Function2<? super View, ? super MotionEvent, Boolean> r415) {
        Intrinsics.checkNotNullParameter(r100, "hostActivity");
        Intrinsics.checkNotNullParameter(r111, "editTextBridge");
        Intrinsics.checkNotNullParameter(r113, "psdaToken");
        Intrinsics.checkNotNullParameter(r115, "fileId");
        Intrinsics.checkNotNullParameter(r116, "fileType");
        Intrinsics.checkNotNullParameter(r118, "voiceInputLocation");
        this.f230400a = r100;
        this.f230401b = r110;
        this.f230402c = r111;
        this.f230403d = r112;
        this.f230404e = r113;
        this.f230405f = r114;
        this.f230406g = r115;
        this.f230407h = r116;
        this.f230408i = r117;
        this.f230409j = r118;
        this.f230410k = r119;
        this.f230411l = r210;
        this.f230412m = r211;
        this.f230413n = r212;
        this.f230414o = r213;
        this.f230415p = r214;
        this.f230416q = r215;
        this.f230417r = r216;
        this.f230418s = r217;
        this.f230419t = r218;
        this.f230420u = r219;
        this.f230421v = r310;
        this.f230422w = r311;
        this.f230423x = r312;
        this.f230424y = r313;
        this.f230425z = r314;
        this.A = r315;
        this.B = r316;
        this.C = r317;
        this.D = r318;
        this.E = r319;
        this.F = r410;
        this.G = r411;
        this.H = r412;
        this.I = r413;
        this.f230399J = r414;
        this.K = r415;
    }
}
