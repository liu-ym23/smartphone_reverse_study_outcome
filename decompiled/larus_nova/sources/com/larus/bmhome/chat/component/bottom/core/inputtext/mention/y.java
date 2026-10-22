package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.component.bottom.core.inputtext.t1;
import com.larus.bmhome.taskskill.b2;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class y {

    public static final class a extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f298972a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f298972a, ((a) r100).f298972a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f298972a.hashCode();
        }

        public final String toString() {
            return "Header(title=" + this.f298972a + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "title");
            this.f298972a = r100;
        }
    }

    public static final class b extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f298973a = null;

        static {
            f298973a = new b();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            b r101 = (b) r100;
            return true;
        }

        public final int hashCode() {
            return 1817810821;
        }

        public final String toString() {
            return "Loading";
        }

        public b() {
        }
    }

    public static final class c extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h0 f298974a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f298975b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function0<Unit> f298976c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function0<Unit> f298977d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f298974a, r101.f298974a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f298975b, r101.f298975b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f298976c, r101.f298976c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f298977d, r101.f298977d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f298974a.hashCode() * 31;
            String r101 = this.f298975b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Function0<Unit> r105 = this.f298976c;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return ((r104 + r102) * 31) + this.f298977d.hashCode();
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "More(trace=" + this.f298974a + ", exposeId=" + this.f298975b + ", onShow=" + this.f298976c + ", action=" + this.f298977d + ')';
        }

        public c(h0 r100, String r101, Function0<Unit> r102, Function0<Unit> r103) {
            Intrinsics.checkNotNullParameter(r100, "trace");
            Intrinsics.checkNotNullParameter(r103, "action");
            this.f298974a = r100;
            this.f298975b = r101;
            this.f298976c = r102;
            this.f298977d = r103;
        }
    }

    public static final class d extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f298978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h0 f298979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final g0 f298980c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<String> f298981d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f298982e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final t1 f298983f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Integer f298984g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final b2.b f298985h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f298986i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f298987j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final com.larus.bmhome.chat.component.bottom.core.inputtext.i0 f298988k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final com.larus.bmhome.chat.referenceicon.b f298989l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f298990m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final String f298991n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final String f298992o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final String f298993p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final Function0<Unit> f298994q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final Function0<Unit> f298995r;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f298978a, r101.f298978a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f298979b, r101.f298979b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f298980c, r101.f298980c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f298981d, r101.f298981d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f298982e, r101.f298982e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f298983f, r101.f298983f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f298984g, r101.f298984g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f298985h, r101.f298985h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f298986i, r101.f298986i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f298987j, r101.f298987j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.f298988k, r101.f298988k) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.f298989l, r101.f298989l) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.f298990m, r101.f298990m) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.f298991n, r101.f298991n) == true) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.f298992o, r101.f298992o) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.f298993p, r101.f298993p) == true) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.f298994q, r101.f298994q) == true) goto L60;
            return false;
        L60:
            if (Intrinsics.areEqual(this.f298995r, r101.f298995r) == true) goto L62;
            return false;
        L62:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f298978a.hashCode() * 31) + this.f298979b.hashCode()) * 31;
            g0 r101 = this.f298980c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            List<String> r105 = this.f298981d;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (((r104 + r106) * 31) + this.f298982e.hashCode()) * 31;
            t1 r108 = this.f298983f;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            Integer r111 = this.f298984g;
            if (r111 != null) goto L17;
            int r112 = 0;
        L18:
            int r113 = (r110 + r112) * 31;
            b2.b r114 = this.f298985h;
            if (r114 != null) goto L21;
            int r115 = 0;
        L22:
            int r116 = (r113 + r115) * 31;
            String r117 = this.f298986i;
            if (r117 != null) goto L25;
            int r118 = 0;
        L26:
            int r119 = (r116 + r118) * 31;
            String r120 = this.f298987j;
            if (r120 != null) goto L29;
            int r121 = 0;
        L30:
            int r122 = (r119 + r121) * 31;
            com.larus.bmhome.chat.component.bottom.core.inputtext.i0 r123 = this.f298988k;
            if (r123 != null) goto L33;
            int r124 = 0;
        L34:
            int r125 = (r122 + r124) * 31;
            com.larus.bmhome.chat.referenceicon.b r126 = this.f298989l;
            if (r126 != null) goto L37;
            int r127 = 0;
        L38:
            int r128 = (r125 + r127) * 31;
            String r129 = this.f298990m;
            if (r129 != null) goto L41;
            int r130 = 0;
        L42:
            int r131 = (r128 + r130) * 31;
            String r132 = this.f298991n;
            if (r132 != null) goto L45;
            int r133 = 0;
        L46:
            int r134 = (r131 + r133) * 31;
            String r135 = this.f298992o;
            if (r135 != null) goto L49;
            int r136 = 0;
        L50:
            int r137 = (r134 + r136) * 31;
            String r138 = this.f298993p;
            if (r138 != null) goto L53;
            int r139 = 0;
        L54:
            int r140 = (r137 + r139) * 31;
            Function0<Unit> r141 = this.f298994q;
            if (r141 == null) goto L59;
            r102 = r141.hashCode();
        L59:
            return ((r140 + r102) * 31) + this.f298995r.hashCode();
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
            r124 = r123.hashCode();
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
            return "Row(title=" + this.f298978a + ", trace=" + this.f298979b + ", anchorKey=" + this.f298980c + ", titleHighlights=" + this.f298981d + ", secondaryText=" + this.f298982e + ", skillMatch=" + this.f298983f + ", iconRes=" + this.f298984g + ", skillIconColors=" + this.f298985h + ", iconText=" + this.f298986i + ", iconUrl=" + this.f298987j + ", documentIcon=" + this.f298988k + ", attachmentVisual=" + this.f298989l + ", conversationId=" + this.f298990m + ", avatarKey=" + this.f298991n + ", avatarEntityId=" + this.f298992o + ", exposeId=" + this.f298993p + ", onShow=" + this.f298994q + ", action=" + this.f298995r + ')';
        }

        public /* synthetic */ d(String r210, h0 r211, g0 r212, List r213, String r214, t1 r215, Integer r216, b2.b r310, String r311, String r312, com.larus.bmhome.chat.component.bottom.core.inputtext.i0 r313, com.larus.bmhome.chat.referenceicon.b r314, String r315, String r316, String r317, Function0 r318, int r319) {
            if ((r319 & 4) == 0) goto L5;
            g0 r100 = null;
        L7:
            if ((r319 & 8) == 0) goto L9;
            List r101 = null;
        L11:
            if ((r319 & 16) == 0) goto L13;
            String r102 = "";
        L15:
            if ((r319 & 32) == 0) goto L17;
            t1 r103 = null;
        L19:
            if ((r319 & 128) == 0) goto L21;
            b2.b r110 = null;
        L23:
            if ((r319 & 256) == 0) goto L25;
            String r111 = null;
        L27:
            if ((r319 & 512) == 0) goto L29;
            String r112 = null;
        L31:
            if ((r319 & 1024) == 0) goto L33;
            com.larus.bmhome.chat.component.bottom.core.inputtext.i0 r113 = null;
        L35:
            if ((r319 & 2048) == 0) goto L37;
            com.larus.bmhome.chat.referenceicon.b r114 = null;
        L39:
            if ((r319 & 4096) == 0) goto L41;
            String r115 = null;
        L43:
            if ((r319 & 8192) == 0) goto L45;
            String r116 = null;
        L47:
            if ((r319 & 16384) == 0) goto L49;
            String r117 = null;
        L50:
            this(r210, r211, r100, r101, r102, r103, r216, r110, r111, r112, r113, r114, r115, r116, r117, null, null, r318);
            return;
        L49:
            r117 = r317;
            goto L50
        L45:
            r116 = r316;
            goto L47
        L41:
            r115 = r315;
            goto L43
        L37:
            r114 = r314;
            goto L39
        L33:
            r113 = r313;
            goto L35
        L29:
            r112 = r312;
            goto L31
        L25:
            r111 = r311;
            goto L27
        L21:
            r110 = r310;
            goto L23
        L17:
            r103 = r215;
            goto L19
        L13:
            r102 = r214;
            goto L15
        L9:
            r101 = r213;
            goto L11
        L5:
            r100 = r212;
            goto L7
        }

        public d(String r100, h0 r101, g0 r102, List<String> r110, String r111, t1 r112, Integer r113, b2.b r114, String r115, String r116, com.larus.bmhome.chat.component.bottom.core.inputtext.i0 r117, com.larus.bmhome.chat.referenceicon.b r118, String r119, String r210, String r211, String r212, Function0<Unit> r213, Function0<Unit> r214) {
            Intrinsics.checkNotNullParameter(r100, "title");
            Intrinsics.checkNotNullParameter(r101, "trace");
            Intrinsics.checkNotNullParameter(r111, "secondaryText");
            Intrinsics.checkNotNullParameter(r214, "action");
            this.f298978a = r100;
            this.f298979b = r101;
            this.f298980c = r102;
            this.f298981d = r110;
            this.f298982e = r111;
            this.f298983f = r112;
            this.f298984g = r113;
            this.f298985h = r114;
            this.f298986i = r115;
            this.f298987j = r116;
            this.f298988k = r117;
            this.f298989l = r118;
            this.f298990m = r119;
            this.f298991n = r210;
            this.f298992o = r211;
            this.f298993p = r212;
            this.f298994q = r213;
            this.f298995r = r214;
        }
    }

    public y() {
    }
}
