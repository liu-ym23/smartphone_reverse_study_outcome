package com.larus.bmhome.chat.component.bottom.core;

import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public interface z8 {

    public static final class a {

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final a f299531y = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f299532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f299533b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f299534c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<Integer, g9.a> f299535d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f299536e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f299537f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final e f299538g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final c f299539h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f299540i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f299541j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Map<String, String> f299542k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final b f299543l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final d f299544m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f299545n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Function0<Boolean> f299546o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final boolean f299547p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final boolean f299548q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final boolean f299549r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final boolean f299550s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final boolean f299551t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final boolean f299552u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final boolean f299553v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final boolean f299554w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final wc9.e f299555x;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.z8$a$a, reason: collision with other inner class name */
        public static final class C4036a {
        }

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f299532a == r101.f299532a) goto L12;
            return false;
        L12:
            if (this.f299533b == r101.f299533b) goto L15;
            return false;
        L15:
            if (this.f299534c == r101.f299534c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f299535d, r101.f299535d) == true) goto L21;
            return false;
        L21:
            if (this.f299536e == r101.f299536e) goto L24;
            return false;
        L24:
            if (this.f299537f == r101.f299537f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f299538g, r101.f299538g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f299539h, r101.f299539h) == true) goto L33;
            return false;
        L33:
            if (this.f299540i == r101.f299540i) goto L36;
            return false;
        L36:
            if (this.f299541j == r101.f299541j) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.f299542k, r101.f299542k) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.f299543l, r101.f299543l) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.f299544m, r101.f299544m) == true) goto L48;
            return false;
        L48:
            if (this.f299545n == r101.f299545n) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.f299546o, r101.f299546o) == true) goto L54;
            return false;
        L54:
            if (this.f299547p == r101.f299547p) goto L57;
            return false;
        L57:
            if (this.f299548q == r101.f299548q) goto L60;
            return false;
        L60:
            if (this.f299549r == r101.f299549r) goto L63;
            return false;
        L63:
            if (this.f299550s == r101.f299550s) goto L66;
            return false;
        L66:
            if (this.f299551t == r101.f299551t) goto L69;
            return false;
        L69:
            if (this.f299552u == r101.f299552u) goto L72;
            return false;
        L72:
            if (this.f299553v == r101.f299553v) goto L75;
            return false;
        L75:
            if (this.f299554w == r101.f299554w) goto L78;
            return false;
        L78:
            if (Intrinsics.areEqual(this.f299555x, r101.f299555x) == true) goto L80;
            return false;
        L80:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f299532a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f299533b == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (r102 + r103) * 31;
            if (this.f299534c == false) goto L13;
            int r105 = 1231;
        L14:
            int r106 = (((r104 + r105) * 31) + this.f299535d.hashCode()) * 31;
            if (this.f299536e == false) goto L17;
            int r107 = 1231;
        L18:
            int r108 = (r106 + r107) * 31;
            if (this.f299537f == false) goto L21;
            int r109 = 1231;
        L22:
            int r110 = (r108 + r109) * 31;
            e r111 = this.f299538g;
            int r112 = 0;
            if (r111 != null) goto L25;
            int r113 = 0;
        L26:
            int r114 = (r110 + r113) * 31;
            c r115 = this.f299539h;
            if (r115 != null) goto L29;
            int r116 = 0;
        L30:
            int r117 = (r114 + r116) * 31;
            if (this.f299540i == false) goto L33;
            int r118 = 1231;
        L34:
            int r119 = (r117 + r118) * 31;
            if (this.f299541j == false) goto L37;
            int r120 = 1231;
        L38:
            int r121 = (((r119 + r120) * 31) + this.f299542k.hashCode()) * 31;
            b r122 = this.f299543l;
            if (r122 != null) goto L41;
            int r123 = 0;
        L42:
            int r124 = (r121 + r123) * 31;
            d r125 = this.f299544m;
            if (r125 != null) goto L45;
            int r126 = 0;
        L46:
            int r127 = (r124 + r126) * 31;
            if (this.f299545n == false) goto L49;
            int r128 = 1231;
        L50:
            int r129 = (r127 + r128) * 31;
            Function0<Boolean> r130 = this.f299546o;
            if (r130 != null) goto L53;
            int r131 = 0;
        L54:
            int r132 = (r129 + r131) * 31;
            if (this.f299547p == false) goto L57;
            int r133 = 1231;
        L58:
            int r134 = (r132 + r133) * 31;
            if (this.f299548q == false) goto L61;
            int r135 = 1231;
        L62:
            int r136 = (r134 + r135) * 31;
            if (this.f299549r == false) goto L65;
            int r137 = 1231;
        L66:
            int r138 = (r136 + r137) * 31;
            if (this.f299550s == false) goto L69;
            int r139 = 1231;
        L70:
            int r140 = (r138 + r139) * 31;
            if (this.f299551t == false) goto L73;
            int r141 = 1231;
        L74:
            int r142 = (r140 + r141) * 31;
            if (this.f299552u == false) goto L77;
            int r143 = 1231;
        L78:
            int r144 = (r142 + r143) * 31;
            if (this.f299553v == false) goto L81;
            int r145 = 1231;
        L82:
            int r146 = (r144 + r145) * 31;
            if (this.f299554w == true) goto L86;
            r100 = 1237;
        L86:
            int r147 = (r146 + r100) * 31;
            wc9.e r148 = this.f299555x;
            if (r148 == null) goto L91;
            r112 = r148.hashCode();
        L91:
            return r147 + r112;
        L81:
            r145 = 1237;
            goto L82
        L77:
            r143 = 1237;
            goto L78
        L73:
            r141 = 1237;
            goto L74
        L69:
            r139 = 1237;
            goto L70
        L65:
            r137 = 1237;
            goto L66
        L61:
            r135 = 1237;
            goto L62
        L57:
            r133 = 1237;
            goto L58
        L53:
            r131 = r130.hashCode();
            goto L54
        L49:
            r128 = 1237;
            goto L50
        L45:
            r126 = r125.hashCode();
            goto L46
        L41:
            r123 = r122.hashCode();
            goto L42
        L37:
            r120 = 1237;
            goto L38
        L33:
            r118 = 1237;
            goto L34
        L29:
            r116 = r115.hashCode();
            goto L30
        L25:
            r113 = r111.hashCode();
            goto L26
        L21:
            r109 = 1237;
            goto L22
        L17:
            r107 = 1237;
            goto L18
        L13:
            r105 = 1237;
            goto L14
        L9:
            r103 = 1237;
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "Config(enable=" + this.f299532a + ", speakerAsrOnly=" + this.f299533b + ", disableFullScreenAction=" + this.f299534c + ", statusConfig=" + this.f299535d + ", disableAutoResetHint=" + this.f299536e + ", disableKeyboardLongPressPopup=" + this.f299537f + ", inputPopupMenuAction=" + this.f299538g + ", actionEntranceOuterInterceptor=" + this.f299539h + ", enableDisclaimer=" + this.f299540i + ", enableActionbar=" + this.f299541j + ", eventInfoMap=" + this.f299542k + ", actionEntranceMenuInterceptor=" + this.f299543l + ", inputAllActionMobInterceptor=" + this.f299544m + ", enableClearContentTextAfterSend=" + this.f299545n + ", onVoiceTouchBlockCallback=" + this.f299546o + ", forceAudioInputEnable=" + this.f299547p + ", banInstructionHandleContent=" + this.f299548q + ", disableActionBar=" + this.f299549r + ", enableSetFullScreenEditBackground=" + this.f299550s + ", overrideActionEntranceIcon=" + this.f299551t + ", takeOverActionEntranceVisibility=" + this.f299552u + ", disableCreationActionEntrance=" + this.f299553v + ", retainVoiceEntranceWithText=" + this.f299554w + ", sendConversation=" + this.f299555x + ')';
        }

        static {
            f299531y = new a(0);
        }

        public /* synthetic */ a(int r210) {
            this(false, false, false, MapsKt.emptyMap(), false, false, null, null, true, true, MapsKt.emptyMap(), null, null, true, null, false, false, false, false, false, false, false, false, null);
        }

        public a(boolean r100, boolean r101, boolean r102, Map<Integer, g9.a> r103, boolean r104, boolean r110, e r111, c r112, boolean r113, boolean r114, Map<String, String> r115, b r116, d r117, boolean r118, Function0<Boolean> r119, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r217, wc9.e r218) {
            Intrinsics.checkNotNullParameter(r103, "statusConfig");
            Intrinsics.checkNotNullParameter(r115, "eventInfoMap");
            this.f299532a = r100;
            this.f299533b = r101;
            this.f299534c = r102;
            this.f299535d = r103;
            this.f299536e = r104;
            this.f299537f = r110;
            this.f299538g = r111;
            this.f299539h = r112;
            this.f299540i = r113;
            this.f299541j = r114;
            this.f299542k = r115;
            this.f299543l = r116;
            this.f299544m = r117;
            this.f299545n = r118;
            this.f299546o = r119;
            this.f299547p = r210;
            this.f299548q = r211;
            this.f299549r = r212;
            this.f299550s = r213;
            this.f299551t = r214;
            this.f299552u = r215;
            this.f299553v = r216;
            this.f299554w = r217;
            this.f299555x = r218;
        }

        public static a a(a r110, boolean r111, boolean r112, boolean r210, Map r211, boolean r212, boolean r213, e r214, c r215, boolean r216, boolean r217, Map r218, b r219, d r310, boolean r311, Function0 r312, boolean r313, boolean r314, boolean r315, boolean r316, boolean r317, boolean r318, boolean r319, boolean r410, wc9.e r411, int r412) {
            if ((r412 & 1) == 0) goto L5;
            boolean r100 = r110.f299532a;
        L7:
            if ((r412 & 2) == 0) goto L9;
            boolean r101 = r110.f299533b;
        L11:
            if ((r412 & 4) == 0) goto L13;
            boolean r102 = r110.f299534c;
        L15:
            if ((r412 & 8) == 0) goto L17;
            Map r103 = r110.f299535d;
        L19:
            if ((r412 & 16) == 0) goto L21;
            boolean r104 = r110.f299536e;
        L23:
            if ((r412 & 32) == 0) goto L25;
            boolean r105 = r110.f299537f;
        L27:
            if ((r412 & 64) == 0) goto L29;
            e r106 = r110.f299538g;
        L31:
            if ((r412 & 128) == 0) goto L33;
            c r107 = r110.f299539h;
        L35:
            if ((r412 & 256) == 0) goto L37;
            boolean r113 = r110.f299540i;
        L39:
            if ((r412 & 512) == 0) goto L41;
            boolean r114 = r110.f299541j;
        L43:
            if ((r412 & 1024) == 0) goto L45;
            Map r115 = r110.f299542k;
        L47:
            if ((r412 & 2048) == 0) goto L49;
            b r116 = r110.f299543l;
        L51:
            if ((r412 & 4096) == 0) goto L53;
            d r117 = r110.f299544m;
        L55:
            if ((r412 & 8192) == 0) goto L57;
            boolean r118 = r110.f299545n;
        L58:
            boolean r320 = r118;
            if ((r412 & 16384) == 0) goto L61;
            Function0 r119 = r110.f299546o;
        L62:
            Function0 r321 = r119;
            if ((r412 & 32768) == 0) goto L65;
            boolean r120 = r110.f299547p;
        L66:
            boolean r322 = r120;
            if ((r412 & 65536) == 0) goto L69;
            boolean r121 = r110.f299548q;
        L70:
            boolean r323 = r121;
            if ((r412 & 131072) == 0) goto L73;
            boolean r122 = r110.f299549r;
        L74:
            boolean r324 = r122;
            if ((r412 & 262144) == 0) goto L77;
            boolean r123 = r110.f299550s;
        L78:
            boolean r325 = r123;
            if ((r412 & 524288) == 0) goto L81;
            boolean r124 = r110.f299551t;
        L82:
            boolean r326 = r124;
            if ((r412 & 1048576) == 0) goto L85;
            boolean r125 = r110.f299552u;
        L86:
            boolean r327 = r125;
            if ((r412 & 2097152) == 0) goto L89;
            boolean r126 = r110.f299553v;
        L90:
            boolean r328 = r126;
            if ((r412 & 4194304) == 0) goto L93;
            boolean r127 = r110.f299554w;
        L95:
            if ((r412 & 8388608) == 0) goto L97;
            wc9.e r108 = r110.f299555x;
        L98:
            r110.getClass();
            Intrinsics.checkNotNullParameter(r103, "statusConfig");
            Intrinsics.checkNotNullParameter(r115, "eventInfoMap");
            return new a(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r127, r108);
        L97:
            r108 = r411;
            goto L98
        L93:
            r127 = r410;
            goto L95
        L89:
            r126 = r319;
            goto L90
        L85:
            r125 = r318;
            goto L86
        L81:
            r124 = r317;
            goto L82
        L77:
            r123 = r316;
            goto L78
        L73:
            r122 = r315;
            goto L74
        L69:
            r121 = r314;
            goto L70
        L65:
            r120 = r313;
            goto L66
        L61:
            r119 = r312;
            goto L62
        L57:
            r118 = r311;
            goto L58
        L53:
            r117 = r310;
            goto L55
        L49:
            r116 = r219;
            goto L51
        L45:
            r115 = r218;
            goto L47
        L41:
            r114 = r217;
            goto L43
        L37:
            r113 = r216;
            goto L39
        L33:
            r107 = r215;
            goto L35
        L29:
            r106 = r214;
            goto L31
        L25:
            r105 = r213;
            goto L27
        L21:
            r104 = r212;
            goto L23
        L17:
            r103 = r211;
            goto L19
        L13:
            r102 = r210;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f299556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Unit> f299557b;

        public b() {
            boolean r100 = false;
            this(r100, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f299556a == r101.f299556a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f299557b, r101.f299557b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f299556a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            Function0<Unit> r102 = this.f299557b;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "InputActionEntranceMenuInterceptor(enableShown=" + this.f299556a + ", onActionEntranceMenuClick=" + this.f299557b + ')';
        }

        public /* synthetic */ b(boolean r100, int r101) {
            if ((r101 & 1) == 0) goto L5;
            r100 = false;
        L5:
            this(r100, null);
        }

        public b(boolean r100, Function0<Unit> r101) {
            this.f299556a = r100;
            this.f299557b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function2<? super Integer, ? super String, Unit> f299558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Boolean> f299559b;

        public c() {
            this(null, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f299558a, r101.f299558a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f299559b, r101.f299559b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Function2<? super Integer, ? super String, Unit> r100 = this.f299558a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Function0<Boolean> r104 = this.f299559b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "InputActionEntranceOuterInterceptor(onOuterClicked=" + this.f299558a + ", onOuterVisibilityInterceptor=" + this.f299559b + ')';
        }

        public /* synthetic */ c(com.larus.common.venue.impl.venue.component.e r100, int r101) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100, null);
        }

        public c(Function2<? super Integer, ? super String, Unit> r100, Function0<Boolean> r101) {
            this.f299558a = r100;
            this.f299559b = r101;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<String, Boolean> f299560a;

        public d() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f299560a, ((d) r100).f299560a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Function1<String, Boolean> r100 = this.f299560a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "InputAllActionMobInterceptor(onInputSwitch=" + this.f299560a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(Function1<? super String, Boolean> r100) {
            this.f299560a = r100;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<Unit> f299561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Unit> f299562b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f299561a, r101.f299561a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f299562b, r101.f299562b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f299561a.hashCode() * 31) + this.f299562b.hashCode();
        }

        public final String toString() {
            return "InputPopupMenuAction(onCopyMenuClick=" + this.f299561a + ", onCopyAndSendMenuClick=" + this.f299562b + ')';
        }

        public e(Function0<Unit> r100, Function0<Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "onCopyMenuClick");
            Intrinsics.checkNotNullParameter(r101, "onCopyAndSendMenuClick");
            this.f299561a = r100;
            this.f299562b = r101;
        }
    }

    void C8(boolean r100);

    void R8();

    void S8(boolean r100);

    void W8(c r100);

    void X8();

    void a9(boolean r100);

    void c9();

    void e9();

    void f9(boolean r100);

    void g9(Map<String, String> r100);

    void j9();

    void l9(b r100);

    void n9(boolean r100);

    void r8(boolean r100, e r101);

    void r9();

    void s9();

    void t9(d r100);

    void v9(Function0<Boolean> r100);

    void w8();

    void w9(boolean r100);

    void y9(int r100, g9.a r101);

    void z9(boolean r100);
}
