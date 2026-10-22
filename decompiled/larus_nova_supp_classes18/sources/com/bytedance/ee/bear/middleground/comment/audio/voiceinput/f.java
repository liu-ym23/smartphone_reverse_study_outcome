package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.richtext.CommentVoiceEditTextBridge;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.ss.android.lark.audio.voiceinput.VoiceInputSpeechScene;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
    public final Function2<p, CharSequence, Unit> J;
    public final Function2<View, MotionEvent, Boolean> K;
    public final Activity a;
    public final Fragment b;
    public final CommentVoiceEditTextBridge c;
    public final Function0<ViewGroup> d;
    public final String e;
    public final com.bytedance.ee.bear.middleground.comment.uitls.h f;
    public final String g;
    public final String h;
    public final VoiceInputSpeechScene i;
    public final String j;
    public final Function0<View> k;
    public final Function0<View> l;
    public final Function0<View> m;
    public final boolean n;
    public final Function0<Unit> o;
    public final Function0<Unit> p;
    public final Function1<Boolean, Unit> q;
    public final Function0<List<View>> r;
    public final Function0<List<View>> s;
    public final Function0<List<View>> t;
    public final Function0<List<View>> u;
    public final Function0<List<View>> v;
    public final com.ss.android.lark.keyboard.plugin.tool.voice.immersive.a w;
    public final boolean x;
    public final Integer y;
    public final int z;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r6.n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r6.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r6.t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r6.u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r6.v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r6.w) == true) goto L78;
        return false;
    L78:
        if (this.x == r6.x) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r6.y) == true) goto L84;
        return false;
    L84:
        if (this.z == r6.z) goto L87;
        return false;
    L87:
        if (this.A == r6.A) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.B, r6.B) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.C, r6.C) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.D, r6.D) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.E, r6.E) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.F, r6.F) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.G, r6.G) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.H, r6.H) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.I, r6.I) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.J, r6.J) == true) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.K, r6.K) == true) goto L119;
        return false;
    L119:
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
        Function0<ViewGroup> r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.e.hashCode()) * 31;
        com.bytedance.ee.bear.middleground.comment.uitls.h r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((((r7 + r9) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        VoiceInputSpeechScene r11 = this.i;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((r10 + r12) * 31) + this.j.hashCode()) * 31;
        Function0<View> r14 = this.k;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Function0<View> r17 = this.l;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Function0<View> r20 = this.m;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        int r23 = 1231;
        if (this.n == false) goto L33;
        int r24 = 1231;
    L34:
        int r25 = (r22 + r24) * 31;
        Function0<Unit> r26 = this.o;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        Function0<Unit> r29 = this.p;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r28 + r30) * 31;
        Function1<Boolean, Unit> r32 = this.q;
        if (r32 != null) goto L45;
        int r33 = 0;
    L46:
        int r34 = (r31 + r33) * 31;
        Function0<List<View>> r35 = this.r;
        if (r35 != null) goto L49;
        int r36 = 0;
    L50:
        int r37 = (r34 + r36) * 31;
        Function0<List<View>> r38 = this.s;
        if (r38 != null) goto L53;
        int r39 = 0;
    L54:
        int r40 = (r37 + r39) * 31;
        Function0<List<View>> r41 = this.t;
        if (r41 != null) goto L57;
        int r42 = 0;
    L58:
        int r43 = (r40 + r42) * 31;
        Function0<List<View>> r44 = this.u;
        if (r44 != null) goto L61;
        int r45 = 0;
    L62:
        int r46 = (r43 + r45) * 31;
        Function0<List<View>> r47 = this.v;
        if (r47 != null) goto L65;
        int r48 = 0;
    L66:
        int r49 = (r46 + r48) * 31;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.a r50 = this.w;
        if (r50 != null) goto L69;
        int r51 = 0;
    L70:
        int r52 = (r49 + r51) * 31;
        if (this.x == false) goto L73;
        int r53 = 1231;
    L74:
        int r54 = (r52 + r53) * 31;
        Integer r55 = this.y;
        if (r55 != null) goto L77;
        int r56 = 0;
    L78:
        int r57 = (((r54 + r56) * 31) + this.z) * 31;
        if (this.A == true) goto L82;
        r23 = 1237;
    L82:
        int r58 = (r57 + r23) * 31;
        Function0<Unit> r59 = this.B;
        if (r59 != null) goto L85;
        int r60 = 0;
    L86:
        int r61 = (r58 + r60) * 31;
        Function0<Unit> r62 = this.C;
        if (r62 != null) goto L89;
        int r63 = 0;
    L90:
        int r64 = (r61 + r63) * 31;
        Function0<Unit> r65 = this.D;
        if (r65 != null) goto L93;
        int r66 = 0;
    L94:
        int r67 = (r64 + r66) * 31;
        Function2<List<String>, Function1<? super Map<String, Boolean>, Unit>, Unit> r68 = this.E;
        if (r68 != null) goto L97;
        int r69 = 0;
    L98:
        int r70 = (r67 + r69) * 31;
        Function1<Boolean, Unit> r71 = this.F;
        if (r71 != null) goto L101;
        int r72 = 0;
    L102:
        int r73 = (r70 + r72) * 31;
        Function1<Boolean, Unit> r74 = this.G;
        if (r74 != null) goto L105;
        int r75 = 0;
    L106:
        int r76 = (r73 + r75) * 31;
        Function0<Boolean> r77 = this.H;
        if (r77 != null) goto L109;
        int r78 = 0;
    L110:
        int r79 = (r76 + r78) * 31;
        o r80 = this.I;
        if (r80 != null) goto L113;
        int r81 = 0;
    L114:
        int r82 = (r79 + r81) * 31;
        Function2<p, CharSequence, Unit> r83 = this.J;
        if (r83 != null) goto L117;
        int r84 = 0;
    L118:
        int r85 = (r82 + r84) * 31;
        Function2<View, MotionEvent, Boolean> r86 = this.K;
        if (r86 == null) goto L123;
        r2 = r86.hashCode();
    L123:
        return r85 + r2;
    L117:
        r84 = r83.hashCode();
        goto L118
    L113:
        r81 = r80.hashCode();
        goto L114
    L109:
        r78 = r77.hashCode();
        goto L110
    L105:
        r75 = r74.hashCode();
        goto L106
    L101:
        r72 = r71.hashCode();
        goto L102
    L97:
        r69 = r68.hashCode();
        goto L98
    L93:
        r66 = r65.hashCode();
        goto L94
    L89:
        r63 = r62.hashCode();
        goto L90
    L85:
        r60 = r59.hashCode();
        goto L86
    L77:
        r56 = r55.hashCode();
        goto L78
    L73:
        r53 = 1237;
        goto L74
    L69:
        r51 = r50.hashCode();
        goto L70
    L65:
        r48 = r47.hashCode();
        goto L66
    L61:
        r45 = r44.hashCode();
        goto L62
    L57:
        r42 = r41.hashCode();
        goto L58
    L53:
        r39 = r38.hashCode();
        goto L54
    L49:
        r36 = r35.hashCode();
        goto L50
    L45:
        r33 = r32.hashCode();
        goto L46
    L41:
        r30 = r29.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = 1237;
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommentVoiceInputContext(hostActivity=" + this.a + ", hostFragment=" + this.b + ", editTextBridge=" + this.c + ", advancedUiContainerProvider=" + this.d + ", psdaToken=" + this.e + ", commentAnalytic=" + this.f + ", fileId=" + this.g + ", fileType=" + this.h + ", speechScene=" + this.i + ", voiceInputLocation=" + this.j + ", textBarProvider=" + this.k + ", voiceBarProvider=" + this.l + ", advancedAnchorProvider=" + this.m + ", hideAdvancedAnchorInVoice=" + this.n + ", imeHider=" + this.o + ", imeShower=" + this.p + ", voiceBarDismissInterceptor=" + this.q + ", extraHiddenInVoiceProvider=" + this.r + ", extraInvisibleInVoiceProvider=" + this.s + ", extraHiddenInAdvancedProvider=" + this.t + ", extraInvisibleInAdvancedProvider=" + this.u + ", extraShownInAdvancedProvider=" + this.v + ", advanceVoiceButtonConfig=" + this.w + ", isAsideMode=" + this.x + ", advancedHostTopMarginPx=" + this.y + ", advancedHostBottomMarginPx=" + this.z + ", restoreTextBarOnAdvancedDismiss=" + this.A + ", onAdvancedDismiss=" + this.B + ", onEnterVoiceMode=" + this.C + ", onVoiceRichTextChanged=" + this.D + ", mentionUserReadPermissionFetcher=" + this.E + ", forceOrientationRequestHandler=" + this.F + ", onVoiceBarShowingChanged=" + this.G + ", primaryVoiceClickInterceptor=" + this.H + ", simpleInputContext=" + this.I + ", unifiedVoiceComponentSimpleFinalTextHandler=" + this.J + ", larkSimpleTouchHandler=" + this.K + ')';
    }

    public static f a(f r42, Function0 r43, boolean r44, Function0 r45, Function0 r46, Function0 r47, Function0 r48, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.a r49, boolean r50, Integer r51, int r52, Function0 r53, Function0 r54, Function1 r55, int r56, int r57) {
        Function2<View, MotionEvent, Boolean> r3 = null;
        if ((r56 & 1) == 0) goto L5;
        Activity r5 = r42.a;
    L7:
        if ((r56 & 2) == 0) goto L9;
        Fragment r6 = r42.b;
    L11:
        if ((r56 & 4) == 0) goto L13;
        CommentVoiceEditTextBridge r7 = r42.c;
    L15:
        if ((r56 & 8) == 0) goto L17;
        Function0<ViewGroup> r8 = r42.d;
    L19:
        if ((r56 & 16) == 0) goto L21;
        String r9 = r42.e;
    L23:
        if ((r56 & 32) == 0) goto L25;
        com.bytedance.ee.bear.middleground.comment.uitls.h r10 = r42.f;
    L27:
        if ((r56 & 64) == 0) goto L29;
        String r11 = r42.g;
    L31:
        if ((r56 & 128) == 0) goto L33;
        String r12 = r42.h;
    L35:
        if ((r56 & 256) == 0) goto L37;
        VoiceInputSpeechScene r13 = r42.i;
    L39:
        if ((r56 & 512) == 0) goto L41;
        String r14 = r42.j;
    L43:
        if ((r56 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L45;
        Function0<View> r15 = r42.k;
    L47:
        if ((r56 & DocUserPermission.USER_PREVIEW) == 0) goto L49;
        Function0<View> r16 = r42.l;
    L51:
        if ((r56 & DocUserPermission.USER_PERCEIVE) == 0) goto L53;
        Function0 r17 = r42.m;
    L55:
        if ((r56 & 8192) == 0) goto L57;
        boolean r18 = r42.n;
    L59:
        if ((r56 & 16384) == 0) goto L61;
        Function0 r19 = r42.o;
    L63:
        if ((32768 & r56) == 0) goto L65;
        Function0<Unit> r20 = r42.p;
    L67:
        if ((65536 & r56) == 0) goto L69;
        Function1<Boolean, Unit> r21 = r42.q;
    L71:
        if ((131072 & r56) == 0) goto L73;
        Function0<List<View>> r22 = r42.r;
    L75:
        if ((262144 & r56) == 0) goto L77;
        Function0 r23 = r42.s;
    L79:
        if ((524288 & r56) == 0) goto L81;
        Function0<List<View>> r24 = r42.t;
    L83:
        if ((1048576 & r56) == 0) goto L85;
        Function0 r25 = r42.u;
    L87:
        if ((2097152 & r56) == 0) goto L89;
        Function0 r26 = r42.v;
    L91:
        if ((4194304 & r56) == 0) goto L93;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.a r27 = r42.w;
    L95:
        if ((8388608 & r56) == 0) goto L97;
        boolean r28 = r42.x;
    L99:
        if ((16777216 & r56) == 0) goto L101;
        Integer r29 = r42.y;
    L103:
        if ((33554432 & r56) == 0) goto L105;
        int r30 = r42.z;
    L107:
        if ((67108864 & r56) == 0) goto L109;
        boolean r31 = r42.A;
    L111:
        if ((134217728 & r56) == 0) goto L113;
        Function0 r32 = r42.B;
    L115:
        if ((268435456 & r56) == 0) goto L117;
        Function0 r33 = r42.C;
    L119:
        if ((536870912 & r56) == 0) goto L121;
        Function0<Unit> r34 = r42.D;
    L123:
        if ((1073741824 & r56) == 0) goto L125;
        Function2<List<String>, Function1<? super Map<String, Boolean>, Unit>, Unit> r35 = r42.E;
    L127:
        if ((r56 & Integer.MIN_VALUE) == 0) goto L129;
        Function1<Boolean, Unit> r36 = r42.F;
    L131:
        if ((r57 & 1) == 0) goto L133;
        Function1 r37 = r42.G;
    L135:
        if ((r57 & 2) == 0) goto L137;
        Function0<Boolean> r38 = r42.H;
    L139:
        if ((r57 & 4) == 0) goto L141;
        o r39 = r42.I;
    L143:
        if ((r57 & 8) == 0) goto L145;
        Function2<p, CharSequence, Unit> r40 = r42.J;
    L147:
        if ((r57 & 16) == 0) goto L149;
        r3 = r42.K;
    L149:
        Intrinsics.checkNotNullParameter(r5, "hostActivity");
        Intrinsics.checkNotNullParameter(r7, "editTextBridge");
        Intrinsics.checkNotNullParameter(r9, "psdaToken");
        Intrinsics.checkNotNullParameter(r11, "fileId");
        Intrinsics.checkNotNullParameter(r12, "fileType");
        Intrinsics.checkNotNullParameter(r14, "voiceInputLocation");
        return new f(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r3);
    L145:
        r40 = null;
        goto L147
    L141:
        r39 = null;
        goto L143
    L137:
        r38 = null;
        goto L139
    L133:
        r37 = r55;
        goto L135
    L129:
        r36 = null;
        goto L131
    L125:
        r35 = null;
        goto L127
    L121:
        r34 = null;
        goto L123
    L117:
        r33 = r54;
        goto L119
    L113:
        r32 = r53;
        goto L115
    L109:
        r31 = false;
        goto L111
    L105:
        r30 = r52;
        goto L107
    L101:
        r29 = r51;
        goto L103
    L97:
        r28 = r50;
        goto L99
    L93:
        r27 = r49;
        goto L95
    L89:
        r26 = r48;
        goto L91
    L85:
        r25 = r47;
        goto L87
    L81:
        r24 = null;
        goto L83
    L77:
        r23 = r46;
        goto L79
    L73:
        r22 = null;
        goto L75
    L69:
        r21 = null;
        goto L71
    L65:
        r20 = null;
        goto L67
    L61:
        r19 = r45;
        goto L63
    L57:
        r18 = r44;
        goto L59
    L53:
        r17 = r43;
        goto L55
    L49:
        r16 = null;
        goto L51
    L45:
        r15 = null;
        goto L47
    L41:
        r14 = null;
        goto L43
    L37:
        r13 = null;
        goto L39
    L33:
        r12 = null;
        goto L35
    L29:
        r11 = null;
        goto L31
    L25:
        r10 = null;
        goto L27
    L21:
        r9 = null;
        goto L23
    L17:
        r8 = null;
        goto L19
    L13:
        r7 = null;
        goto L15
    L9:
        r6 = null;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public /* synthetic */ f(FragmentActivity r39, Fragment r40, CommentVoiceEditTextBridge r41, Function0 r42, com.bytedance.ee.bear.middleground.comment.uitls.h r43, String r44, String r45, VoiceInputSpeechScene r46, Function0 r47, Function0 r48, Function0 r49, Function0 r50, Function0 r51, Function1 r52, Function0 r53, Function0 r54, Function0 r55, Function0 r56, Function2 r57, Function1 r58, Function1 r59, Function0 r60, o r61, Function2 r62, Function2 r63, int r64, int r65) {
        if ((r64 & 32) == 0) goto L5;
        com.bytedance.ee.bear.middleground.comment.uitls.h r6 = null;
    L7:
        if ((r64 & 64) == 0) goto L9;
        String r7 = "";
    L11:
        if ((r64 & 128) == 0) goto L13;
        String r8 = "";
    L15:
        if ((r64 & 256) == 0) goto L17;
        VoiceInputSpeechScene r9 = null;
    L19:
        if ((r64 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L21;
        Function0 r11 = null;
    L23:
        if ((r64 & DocUserPermission.USER_PREVIEW) == 0) goto L25;
        Function0 r12 = null;
    L27:
        if ((r64 & DocUserPermission.USER_PERCEIVE) == 0) goto L29;
        Function0 r13 = null;
    L31:
        if ((r64 & 16384) == 0) goto L33;
        Function0 r15 = null;
    L35:
        if ((32768 & r64) == 0) goto L37;
        Function0 r16 = null;
    L39:
        if ((65536 & r64) == 0) goto L41;
        Function1 r17 = null;
    L43:
        if ((131072 & r64) == 0) goto L45;
        Function0 r18 = null;
    L47:
        if ((524288 & r64) == 0) goto L49;
        Function0 r20 = null;
    L51:
        if ((268435456 & r64) == 0) goto L53;
        Function0 r29 = null;
    L55:
        if ((536870912 & r64) == 0) goto L57;
        Function0 r30 = null;
    L59:
        if ((1073741824 & r64) == 0) goto L61;
        Function2 r31 = null;
    L63:
        if ((r64 & Integer.MIN_VALUE) == 0) goto L65;
        Function1 r32 = null;
    L67:
        if ((r65 & 1) == 0) goto L69;
        Function1 r33 = null;
    L71:
        if ((r65 & 2) == 0) goto L73;
        Function0 r34 = null;
    L75:
        if ((r65 & 4) == 0) goto L77;
        o r35 = null;
    L79:
        if ((r65 & 8) == 0) goto L81;
        Function2 r36 = null;
    L83:
        if ((r65 & 16) == 0) goto L85;
        Function2 r37 = null;
    L86:
        this(r39, r40, r41, r42, "LARK-PSDA-ccm_android_comment_request_record_audio_permssion", r6, r7, r8, r9, "input_box", r11, r12, r13, false, r15, r16, r17, r18, null, r20, null, null, null, false, null, 0, false, null, r29, r30, r31, r32, r33, r34, r35, r36, r37);
        return;
    L85:
        r37 = r63;
        goto L86
    L81:
        r36 = r62;
        goto L83
    L77:
        r35 = r61;
        goto L79
    L73:
        r34 = r60;
        goto L75
    L69:
        r33 = r59;
        goto L71
    L65:
        r32 = r58;
        goto L67
    L61:
        r31 = r57;
        goto L63
    L57:
        r30 = r56;
        goto L59
    L53:
        r29 = r55;
        goto L55
    L49:
        r20 = r54;
        goto L51
    L45:
        r18 = r53;
        goto L47
    L41:
        r17 = r52;
        goto L43
    L37:
        r16 = r51;
        goto L39
    L33:
        r15 = r50;
        goto L35
    L29:
        r13 = r49;
        goto L31
    L25:
        r12 = r48;
        goto L27
    L21:
        r11 = r47;
        goto L23
    L17:
        r9 = r46;
        goto L19
    L13:
        r8 = r45;
        goto L15
    L9:
        r7 = r44;
        goto L11
    L5:
        r6 = r43;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Activity r9, Fragment r10, CommentVoiceEditTextBridge r11, Function0<? extends ViewGroup> r12, String r13, com.bytedance.ee.bear.middleground.comment.uitls.h r14, String r15, String r16, VoiceInputSpeechScene r17, String r18, Function0<? extends View> r19, Function0<? extends View> r20, Function0<? extends View> r21, boolean r22, Function0<Unit> r23, Function0<Unit> r24, Function1<? super Boolean, Unit> r25, Function0<? extends List<? extends View>> r26, Function0<? extends List<? extends View>> r27, Function0<? extends List<? extends View>> r28, Function0<? extends List<? extends View>> r29, Function0<? extends List<? extends View>> r30, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.a r31, boolean r32, Integer r33, int r34, boolean r35, Function0<Unit> r36, Function0<Unit> r37, Function0<Unit> r38, Function2<? super List<String>, ? super Function1<? super Map<String, Boolean>, Unit>, Unit> r39, Function1<? super Boolean, Unit> r40, Function1<? super Boolean, Unit> r41, Function0<Boolean> r42, o r43, Function2<? super p, ? super CharSequence, Unit> r44, Function2<? super View, ? super MotionEvent, Boolean> r45) {
        Intrinsics.checkNotNullParameter(r9, "hostActivity");
        Intrinsics.checkNotNullParameter(r11, "editTextBridge");
        Intrinsics.checkNotNullParameter(r13, "psdaToken");
        Intrinsics.checkNotNullParameter(r15, "fileId");
        Intrinsics.checkNotNullParameter(r16, "fileType");
        Intrinsics.checkNotNullParameter(r18, "voiceInputLocation");
        this.a = r9;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.h = r16;
        this.i = r17;
        this.j = r18;
        this.k = r19;
        this.l = r20;
        this.m = r21;
        this.n = r22;
        this.o = r23;
        this.p = r24;
        this.q = r25;
        this.r = r26;
        this.s = r27;
        this.t = r28;
        this.u = r29;
        this.v = r30;
        this.w = r31;
        this.x = r32;
        this.y = r33;
        this.z = r34;
        this.A = r35;
        this.B = r36;
        this.C = r37;
        this.D = r38;
        this.E = r39;
        this.F = r40;
        this.G = r41;
        this.H = r42;
        this.I = r43;
        this.J = r44;
        this.K = r45;
    }
}
