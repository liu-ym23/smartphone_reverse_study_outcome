package com.ss.android.ainote;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.ss.android.ainote.model.AINoteBlockStatus;
import com.ss.android.ainote.model.AINoteContentState;
import com.ss.android.ainote.model.AINoteCreateSource;
import com.ss.android.ainote.model.AINoteImageUploadState;
import com.ss.android.ainote.model.AINoteScene;
import com.ss.android.ainote.model.AINoteType;
import com.ss.android.ainote.util.AINoteCompareUtils;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class j {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f406761g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<Long, a> f406762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<Long, g> f406763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap<String, f> f406764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap<Long, d> f406765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashMap<String, e> f406766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashMap<String, c> f406767f;

    public static final class a {
        public final AINoteBlockStatus A;
        public final List<xra.b> B;
        public final List<String> C;
        public final boolean D;
        public final boolean E;
        public final AINotePendingDeleteReason F;
        public final boolean G;
        public final boolean H;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f406768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f406769b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AINoteScene f406770c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f406771d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f406772e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AINoteCreateSource f406773f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AINoteType f406774g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f406775h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f406776i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f406777j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final AINoteContentState f406778k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f406779l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final boolean f406780m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final long f406781n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final long f406782o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final String f406783p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final long f406784q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final boolean f406785r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final RichText f406786s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final List<xra.b> f406787t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final List<String> f406788u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final AINoteContentState f406789v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final RichText f406790w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final String f406791x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final RichText f406792y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final String f406793z;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f406768a == r101.f406768a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f406769b, r101.f406769b) == true) goto L15;
            return false;
        L15:
            if (this.f406770c == r101.f406770c) goto L18;
            return false;
        L18:
            if (this.f406771d == r101.f406771d) goto L21;
            return false;
        L21:
            if (this.f406772e == r101.f406772e) goto L24;
            return false;
        L24:
            if (this.f406773f == r101.f406773f) goto L27;
            return false;
        L27:
            if (this.f406774g == r101.f406774g) goto L30;
            return false;
        L30:
            if (this.f406775h == r101.f406775h) goto L33;
            return false;
        L33:
            if (this.f406776i == r101.f406776i) goto L36;
            return false;
        L36:
            if (this.f406777j == r101.f406777j) goto L39;
            return false;
        L39:
            if (this.f406778k == r101.f406778k) goto L42;
            return false;
        L42:
            if (this.f406779l == r101.f406779l) goto L45;
            return false;
        L45:
            if (this.f406780m == r101.f406780m) goto L48;
            return false;
        L48:
            if (this.f406781n == r101.f406781n) goto L51;
            return false;
        L51:
            if (this.f406782o == r101.f406782o) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.f406783p, r101.f406783p) == true) goto L57;
            return false;
        L57:
            if (this.f406784q == r101.f406784q) goto L60;
            return false;
        L60:
            if (this.f406785r == r101.f406785r) goto L63;
            return false;
        L63:
            if (Intrinsics.areEqual(this.f406786s, r101.f406786s) == true) goto L66;
            return false;
        L66:
            if (Intrinsics.areEqual(this.f406787t, r101.f406787t) == true) goto L69;
            return false;
        L69:
            if (Intrinsics.areEqual(this.f406788u, r101.f406788u) == true) goto L72;
            return false;
        L72:
            if (this.f406789v == r101.f406789v) goto L75;
            return false;
        L75:
            if (Intrinsics.areEqual(this.f406790w, r101.f406790w) == true) goto L78;
            return false;
        L78:
            if (Intrinsics.areEqual(this.f406791x, r101.f406791x) == true) goto L81;
            return false;
        L81:
            if (Intrinsics.areEqual(this.f406792y, r101.f406792y) == true) goto L84;
            return false;
        L84:
            if (Intrinsics.areEqual(this.f406793z, r101.f406793z) == true) goto L87;
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
            if (this.H == r101.H) goto L110;
            return false;
        L110:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f406768a;
            int r101 = ((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f406769b.hashCode()) * 31) + this.f406770c.hashCode()) * 31;
            long r102 = this.f406771d;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.f406772e;
            int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            AINoteCreateSource r106 = this.f406773f;
            int r107 = 0;
            if (r106 != null) goto L5;
            int r108 = 0;
        L6:
            int r109 = (((r105 + r108) * 31) + this.f406774g.hashCode()) * 31;
            long r110 = this.f406775h;
            int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
            long r112 = this.f406776i;
            int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
            long r114 = this.f406777j;
            int r115 = (((r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31) + this.f406778k.hashCode()) * 31;
            int r116 = 1231;
            if (this.f406779l == false) goto L9;
            int r117 = 1231;
        L10:
            int r118 = (r115 + r117) * 31;
            if (this.f406780m == false) goto L13;
            int r119 = 1231;
        L14:
            long r120 = this.f406781n;
            int r121 = (((r118 + r119) * 31) + ((int) (r120 ^ (r120 >>> 32)))) * 31;
            long r122 = this.f406782o;
            int r123 = (r121 + ((int) (r122 ^ (r122 >>> 32)))) * 31;
            String r124 = this.f406783p;
            if (r124 != null) goto L17;
            int r125 = 0;
        L18:
            long r126 = this.f406784q;
            int r127 = (((r123 + r125) * 31) + ((int) (r126 ^ (r126 >>> 32)))) * 31;
            if (this.f406785r == false) goto L21;
            int r128 = 1231;
        L22:
            int r129 = (r127 + r128) * 31;
            RichText r130 = this.f406786s;
            if (r130 != null) goto L25;
            int r131 = 0;
        L26:
            int r132 = (((((((r129 + r131) * 31) + this.f406787t.hashCode()) * 31) + this.f406788u.hashCode()) * 31) + this.f406789v.hashCode()) * 31;
            RichText r133 = this.f406790w;
            if (r133 != null) goto L29;
            int r134 = 0;
        L30:
            int r135 = (r132 + r134) * 31;
            String r136 = this.f406791x;
            if (r136 != null) goto L33;
            int r137 = 0;
        L34:
            int r138 = (r135 + r137) * 31;
            RichText r139 = this.f406792y;
            if (r139 != null) goto L37;
            int r140 = 0;
        L38:
            int r141 = (r138 + r140) * 31;
            String r142 = this.f406793z;
            if (r142 != null) goto L41;
            int r143 = 0;
        L42:
            int r144 = (((((((r141 + r143) * 31) + this.A.hashCode()) * 31) + this.B.hashCode()) * 31) + this.C.hashCode()) * 31;
            if (this.D == false) goto L45;
            int r145 = 1231;
        L46:
            int r146 = (r144 + r145) * 31;
            if (this.E == false) goto L49;
            int r147 = 1231;
        L50:
            int r148 = (r146 + r147) * 31;
            AINotePendingDeleteReason r149 = this.F;
            if (r149 == null) goto L54;
            r107 = r149.hashCode();
        L54:
            int r150 = (r148 + r107) * 31;
            if (this.G == false) goto L57;
            int r151 = 1231;
        L58:
            int r152 = (r150 + r151) * 31;
            if (this.H == true) goto L63;
            r116 = 1237;
        L63:
            return r152 + r116;
        L57:
            r151 = 1237;
            goto L58
        L49:
            r147 = 1237;
            goto L50
        L45:
            r145 = 1237;
            goto L46
        L41:
            r143 = r142.hashCode();
            goto L42
        L37:
            r140 = r139.hashCode();
            goto L38
        L33:
            r137 = r136.hashCode();
            goto L34
        L29:
            r134 = r133.hashCode();
            goto L30
        L25:
            r131 = r130.hashCode();
            goto L26
        L21:
            r128 = 1237;
            goto L22
        L17:
            r125 = r124.hashCode();
            goto L18
        L13:
            r119 = 1237;
            goto L14
        L9:
            r117 = 1237;
            goto L10
        L5:
            r108 = r106.hashCode();
            goto L6
        }

        public final String toString() {
            return "AINoteDraft(noteId=" + this.f406768a + ", requestId=" + this.f406769b + ", scene=" + this.f406770c + ", cid=" + this.f406771d + ", sid=" + this.f406772e + ", noteSource=" + this.f406773f + ", noteType=" + this.f406774g + ", version=" + this.f406775h + ", clientTime=" + this.f406776i + ", serverTime=" + this.f406777j + ", contentState=" + this.f406778k + ", polishEnabled=" + this.f406779l + ", deleted=" + this.f406780m + ", createRelMeetingTime=" + this.f406781n + ", createRelAudioTime=" + this.f406782o + ", markId=" + this.f406783p + ", audioLocationTime=" + this.f406784q + ", aiContentAck=" + this.f406785r + ", committedInputRichText=" + this.f406786s + ", committedImages=" + this.f406787t + ", committedDeletedImageIds=" + this.f406788u + ", committedContentState=" + this.f406789v + ", inputRichText=" + this.f406790w + ", inputMarkdown=" + this.f406791x + ", aiRichText=" + this.f406792y + ", aiMarkdown=" + this.f406793z + ", status=" + this.A + ", images=" + this.B + ", deletedImageIds=" + this.C + ", pendingCommit=" + this.D + ", pendingDelete=" + this.E + ", pendingDeleteReason=" + this.F + ", firstNeedRequested=" + this.G + ", pendingFirstNeedAfterCreate=" + this.H + ')';
        }

        public final boolean a() {
            List<xra.b> r100 = this.B;
            if ((r100 instanceof Collection) == true) goto L5;
        L7:
            Iterator<T> r101 = r100.iterator();
        L9:
            if (r101.hasNext() == false) goto L23;
            if (((xra.b) r101.next()).f564926h != AINoteImageUploadState.UPLOADED) goto L13;
            boolean r102 = true;
        L14:
            if (r102 == true) goto L9;
            return false;
        L13:
            r102 = false;
            goto L14
        L23:
            return true;
        L5:
            if (r100.isEmpty() == false) goto L7;
            return true;
        }

        public final xra.a c() {
            return n.d(new xra.a(this.f406771d, this.f406772e, this.f406773f, this.f406790w, this.f406791x, this.f406792y, this.f406793z, this.B, this.f406774g, this.f406775h, this.f406776i, this.f406777j, this.f406778k, this.f406779l, this.f406780m, this.f406781n, this.f406782o, this.f406783p, this.f406784q, this.f406785r, this.A, 2097152));
        }

        public a(long r110, String r111, AINoteScene r112, long r113, long r210, AINoteCreateSource r211, AINoteType r212, long r213, long r214, long r215, AINoteContentState r310, boolean r311, boolean r312, long r313, long r314, String r315, long r316, boolean r410, RichText r411, List<xra.b> r412, List<String> r413, AINoteContentState r414, RichText r415, String r416, RichText r417, String r418, AINoteBlockStatus r419, List<xra.b> r510, List<String> r511, boolean r512, boolean r513, AINotePendingDeleteReason r514, boolean r515, boolean r516) {
            Intrinsics.checkNotNullParameter(r111, "requestId");
            Intrinsics.checkNotNullParameter(r112, "scene");
            Intrinsics.checkNotNullParameter(r212, "noteType");
            Intrinsics.checkNotNullParameter(r310, "contentState");
            Intrinsics.checkNotNullParameter(r412, "committedImages");
            Intrinsics.checkNotNullParameter(r413, "committedDeletedImageIds");
            Intrinsics.checkNotNullParameter(r414, "committedContentState");
            Intrinsics.checkNotNullParameter(r419, "status");
            Intrinsics.checkNotNullParameter(r510, "images");
            Intrinsics.checkNotNullParameter(r511, "deletedImageIds");
            this.f406768a = r110;
            this.f406769b = r111;
            this.f406770c = r112;
            this.f406771d = r113;
            this.f406772e = r210;
            this.f406773f = r211;
            this.f406774g = r212;
            this.f406775h = r213;
            this.f406776i = r214;
            this.f406777j = r215;
            this.f406778k = r310;
            this.f406779l = r311;
            this.f406780m = r312;
            this.f406781n = r313;
            this.f406782o = r314;
            this.f406783p = r315;
            this.f406784q = r316;
            this.f406785r = r410;
            this.f406786s = r411;
            this.f406787t = r412;
            this.f406788u = r413;
            this.f406789v = r414;
            this.f406790w = r415;
            this.f406791x = r416;
            this.f406792y = r417;
            this.f406793z = r418;
            this.A = r419;
            this.B = r510;
            this.C = r511;
            this.D = r512;
            this.E = r513;
            this.F = r514;
            this.G = r515;
            this.H = r516;
        }

        public static a b(a r410, long r411, long r412, long r413, AINoteCreateSource r510, AINoteType r511, long r512, long r513, long r514, AINoteContentState r515, boolean r516, boolean r610, long r611, long r612, String r613, long r614, boolean r615, RichText r616, List r710, List r711, AINoteContentState r712, RichText r713, String r714, RichText r715, String r716, AINoteBlockStatus r717, List r718, List r719, boolean r810, boolean r811, AINotePendingDeleteReason r812, boolean r813, boolean r814, int r815, int r816) {
            if ((r815 & 1) == 0) goto L5;
            long r100 = r410.f406768a;
        L6:
            AINoteScene r101 = null;
            if ((r815 & 2) == 0) goto L9;
            String r102 = r410.f406769b;
        L11:
            if ((r815 & 4) == 0) goto L14;
            r101 = r410.f406770c;
        L14:
            if ((r815 & 8) == 0) goto L16;
            long r103 = r410.f406771d;
        L18:
            if ((r815 & 16) == 0) goto L20;
            long r104 = r410.f406772e;
        L22:
            if ((r815 & 32) == 0) goto L24;
            AINoteCreateSource r110 = r410.f406773f;
        L26:
            if ((r815 & 64) == 0) goto L28;
            AINoteType r111 = r410.f406774g;
        L30:
            if ((r815 & 128) == 0) goto L32;
            long r112 = r410.f406775h;
        L34:
            if ((r815 & 256) == 0) goto L36;
            long r113 = r410.f406776i;
        L37:
            long r114 = r113;
            if ((r815 & 512) == 0) goto L40;
            long r115 = r410.f406777j;
        L41:
            long r116 = r115;
            if ((r815 & 1024) == 0) goto L44;
            AINoteContentState r117 = r410.f406778k;
        L46:
            if ((r815 & 2048) == 0) goto L48;
            boolean r118 = r410.f406779l;
        L49:
            boolean r210 = r118;
            if ((r815 & 4096) == 0) goto L52;
            boolean r119 = r410.f406780m;
        L53:
            boolean r211 = r119;
            long r212 = r112;
            if ((r815 & 8192) == 0) goto L56;
            long r120 = r410.f406781n;
        L57:
            long r213 = r120;
            if ((r815 & 16384) == 0) goto L60;
            long r121 = r410.f406782o;
        L62:
            if ((32768 & r815) == 0) goto L64;
            String r122 = r410.f406783p;
        L66:
            if ((r815 & 65536) == 0) goto L68;
            long r123 = r410.f406784q;
        L70:
            if ((r815 & 131072) == 0) goto L72;
            boolean r124 = r410.f406785r;
        L74:
            if ((262144 & r815) == 0) goto L76;
            RichText r125 = r410.f406786s;
        L78:
            if ((r815 & 524288) == 0) goto L80;
            List r126 = r410.f406787t;
        L82:
            if ((r815 & 1048576) == 0) goto L84;
            List r127 = r410.f406788u;
        L86:
            if ((r815 & 2097152) == 0) goto L88;
            AINoteContentState r128 = r410.f406789v;
        L90:
            if ((r815 & 4194304) == 0) goto L92;
            RichText r129 = r410.f406790w;
        L94:
            if ((r815 & 8388608) == 0) goto L96;
            String r130 = r410.f406791x;
        L98:
            if ((r815 & 16777216) == 0) goto L100;
            RichText r131 = r410.f406792y;
        L102:
            if ((r815 & 33554432) == 0) goto L104;
            String r132 = r410.f406793z;
        L106:
            if ((r815 & 67108864) == 0) goto L108;
            AINoteBlockStatus r133 = r410.A;
        L110:
            if ((r815 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L112;
            List r105 = r410.B;
        L114:
            if ((268435456 & r815) == 0) goto L116;
            List r106 = r410.C;
        L118:
            if ((r815 & 536870912) == 0) goto L120;
            boolean r107 = r410.D;
        L122:
            if ((1073741824 & r815) == 0) goto L124;
            boolean r108 = r410.E;
        L126:
            if ((r815 & Integer.MIN_VALUE) == 0) goto L128;
            AINotePendingDeleteReason r109 = r410.F;
        L129:
            AINotePendingDeleteReason r817 = r109;
            if ((r816 & 1) == 0) goto L132;
            boolean r134 = r410.G;
        L134:
            if ((r816 & 2) == 0) goto L136;
            boolean r818 = r410.H;
        L137:
            Intrinsics.checkNotNullParameter(r102, "requestId");
            Intrinsics.checkNotNullParameter(r101, "scene");
            Intrinsics.checkNotNullParameter(r111, "noteType");
            Intrinsics.checkNotNullParameter(r117, "contentState");
            Intrinsics.checkNotNullParameter(r126, "committedImages");
            Intrinsics.checkNotNullParameter(r127, "committedDeletedImageIds");
            Intrinsics.checkNotNullParameter(r128, "committedContentState");
            Intrinsics.checkNotNullParameter(r133, "status");
            Intrinsics.checkNotNullParameter(r105, "images");
            Intrinsics.checkNotNullParameter(r106, "deletedImageIds");
            return new a(r100, r102, r101, r103, r104, r110, r111, r212, r114, r116, r117, r210, r211, r213, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r105, r106, r107, r108, r817, r134, r818);
        L136:
            r818 = r814;
            goto L137
        L132:
            r134 = r813;
            goto L134
        L128:
            r109 = r812;
            goto L129
        L124:
            r108 = r811;
            goto L126
        L120:
            r107 = r810;
            goto L122
        L116:
            r106 = r719;
            goto L118
        L112:
            r105 = r718;
            goto L114
        L108:
            r133 = r717;
            goto L110
        L104:
            r132 = r716;
            goto L106
        L100:
            r131 = r715;
            goto L102
        L96:
            r130 = r714;
            goto L98
        L92:
            r129 = r713;
            goto L94
        L88:
            r128 = r712;
            goto L90
        L84:
            r127 = r711;
            goto L86
        L80:
            r126 = r710;
            goto L82
        L76:
            r125 = r616;
            goto L78
        L72:
            r124 = r615;
            goto L74
        L68:
            r123 = r614;
            goto L70
        L64:
            r122 = r613;
            goto L66
        L60:
            r121 = r612;
            goto L62
        L56:
            r120 = r611;
            goto L57
        L52:
            r119 = r610;
            goto L53
        L48:
            r118 = r516;
            goto L49
        L44:
            r117 = r515;
            goto L46
        L40:
            r115 = r514;
            goto L41
        L36:
            r113 = r513;
            goto L37
        L32:
            r112 = r512;
            goto L34
        L28:
            r111 = r511;
            goto L30
        L24:
            r110 = r510;
            goto L26
        L20:
            r104 = r413;
            goto L22
        L16:
            r103 = r412;
            goto L18
        L9:
            r102 = null;
            goto L11
        L5:
            r100 = r411;
            goto L6
        }
    }

    public static final class b {
        public static String a(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "imageId");
            StringBuilder r102 = new StringBuilder();
            r102.append(r100);
            r102.append(':');
            if (r101 == false) goto L5;
            String r103 = PlayerResolution.SDKKEY.ORIGIN;
        L6:
            r102.append(r103);
            return r102.toString();
        L5:
            r103 = "thumb";
            goto L6
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f406794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f406795b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AINoteScene f406796c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<Long> f406797d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f406798e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f406799f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f406794a, r101.f406794a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f406795b, r101.f406795b) == true) goto L15;
            return false;
        L15:
            if (this.f406796c == r101.f406796c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f406797d, r101.f406797d) == true) goto L21;
            return false;
        L21:
            if (this.f406798e == r101.f406798e) goto L24;
            return false;
        L24:
            if (this.f406799f == r101.f406799f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f406794a.hashCode() * 31) + this.f406795b.hashCode()) * 31) + this.f406796c.hashCode()) * 31) + this.f406797d.hashCode()) * 31;
            long r101 = this.f406798e;
            return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f406799f;
        }

        public final String toString() {
            return "PendingBatchCreateTask(batchId=" + this.f406794a + ", requestId=" + this.f406795b + ", scene=" + this.f406796c + ", noteIds=" + this.f406797d + ", createdAtMs=" + this.f406798e + ", retryCount=" + this.f406799f + ')';
        }

        public static c a(c r110, List r111, int r112, int r113) {
            AINoteScene r100 = null;
            if ((r113 & 1) == 0) goto L5;
            String r101 = r110.f406794a;
        L7:
            if ((r113 & 2) == 0) goto L9;
            String r102 = r110.f406795b;
        L11:
            if ((r113 & 4) == 0) goto L13;
            r100 = r110.f406796c;
        L13:
            AINoteScene r103 = r100;
            if ((r113 & 8) == 0) goto L16;
            r111 = r110.f406797d;
        L16:
            List r104 = r111;
            if ((r113 & 16) == 0) goto L19;
            long r105 = r110.f406798e;
        L20:
            long r106 = r105;
            if ((r113 & 32) == 0) goto L23;
            r112 = r110.f406799f;
        L23:
            r110.getClass();
            Intrinsics.checkNotNullParameter(r101, "batchId");
            Intrinsics.checkNotNullParameter(r102, "requestId");
            Intrinsics.checkNotNullParameter(r103, "scene");
            Intrinsics.checkNotNullParameter(r104, "noteIds");
            return new c(r101, r102, r103, r104, r106, r112);
        L19:
            r105 = 0;
            goto L20
        L9:
            r102 = null;
            goto L11
        L5:
            r101 = null;
            goto L7
        }

        public c(String r100, String r101, AINoteScene r102, List<Long> r103, long r104, int r105) {
            Intrinsics.checkNotNullParameter(r100, "batchId");
            Intrinsics.checkNotNullParameter(r101, "requestId");
            Intrinsics.checkNotNullParameter(r102, "scene");
            Intrinsics.checkNotNullParameter(r103, "noteIds");
            this.f406794a = r100;
            this.f406795b = r101;
            this.f406796c = r102;
            this.f406797d = r103;
            this.f406798e = r104;
            this.f406799f = r105;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f406800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f406801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f406802c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AINoteScene f406803d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f406804e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f406805f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f406800a == r101.f406800a) goto L12;
            return false;
        L12:
            if (this.f406801b == r101.f406801b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f406802c, r101.f406802c) == true) goto L18;
            return false;
        L18:
            if (this.f406803d == r101.f406803d) goto L21;
            return false;
        L21:
            if (this.f406804e == r101.f406804e) goto L24;
            return false;
        L24:
            if (this.f406805f == r101.f406805f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f406800a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f406801b;
            int r103 = (((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f406802c.hashCode()) * 31) + this.f406803d.hashCode()) * 31;
            long r104 = this.f406804e;
            int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            long r106 = this.f406805f;
            return r105 + ((int) (r106 ^ (r106 >>> 32)));
        }

        public final String toString() {
            return "PendingDeleteTask(taskId=" + this.f406800a + ", noteId=" + this.f406801b + ", requestId=" + this.f406802c + ", scene=" + this.f406803d + ", sid=" + this.f406804e + ", version=" + this.f406805f + ')';
        }

        public d(long r100, long r101, String r102, AINoteScene r103, long r104, long r110) {
            Intrinsics.checkNotNullParameter(r102, "requestId");
            Intrinsics.checkNotNullParameter(r103, "scene");
            this.f406800a = r100;
            this.f406801b = r101;
            this.f406802c = r102;
            this.f406803d = r103;
            this.f406804e = r104;
            this.f406805f = r110;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f406806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f406807b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AINoteScene f406808c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f406809d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final s f406810e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f406811f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f406812g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f406813h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (this.f406806a == r101.f406806a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f406807b, r101.f406807b) == true) goto L15;
            return false;
        L15:
            if (this.f406808c == r101.f406808c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f406809d, r101.f406809d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f406810e, r101.f406810e) == true) goto L24;
            return false;
        L24:
            if (this.f406811f == r101.f406811f) goto L27;
            return false;
        L27:
            if (this.f406812g == r101.f406812g) goto L30;
            return false;
        L30:
            if (this.f406813h == r101.f406813h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f406806a;
            int r101 = ((((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f406807b.hashCode()) * 31) + this.f406808c.hashCode()) * 31) + this.f406809d.hashCode()) * 31) + this.f406810e.hashCode()) * 31;
            if (this.f406811f == false) goto L5;
            int r102 = 1231;
        L6:
            long r103 = this.f406812g;
            return ((((r101 + r102) * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f406813h;
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "PendingImageDownloadTask(noteId=" + this.f406806a + ", requestId=" + this.f406807b + ", scene=" + this.f406808c + ", imageId=" + this.f406809d + ", source=" + this.f406810e + ", forOrigin=" + this.f406811f + ", nextAttemptAtMs=" + this.f406812g + ", retryCount=" + this.f406813h + ')';
        }

        public final String a() {
            int r100 = j.f406761g;
            return b.a(this.f406809d, this.f406811f);
        }

        public e(long r100, String r101, AINoteScene r102, String r103, s r104, boolean r105, long r106, int r110) {
            Intrinsics.checkNotNullParameter(r101, "requestId");
            Intrinsics.checkNotNullParameter(r102, "scene");
            Intrinsics.checkNotNullParameter(r103, "imageId");
            Intrinsics.checkNotNullParameter(r104, "source");
            this.f406806a = r100;
            this.f406807b = r101;
            this.f406808c = r102;
            this.f406809d = r103;
            this.f406810e = r104;
            this.f406811f = r105;
            this.f406812g = r106;
            this.f406813h = r110;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f406814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f406815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AINoteScene f406816c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f406817d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f406818e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f406819f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (this.f406814a == r101.f406814a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f406815b, r101.f406815b) == true) goto L15;
            return false;
        L15:
            if (this.f406816c == r101.f406816c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f406817d, r101.f406817d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f406818e, r101.f406818e) == true) goto L24;
            return false;
        L24:
            if (this.f406819f == r101.f406819f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f406814a;
            int r101 = ((((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f406815b.hashCode()) * 31) + this.f406816c.hashCode()) * 31) + this.f406817d.hashCode()) * 31) + this.f406818e.hashCode()) * 31;
            long r102 = this.f406819f;
            return r101 + ((int) (r102 ^ (r102 >>> 32)));
        }

        public final String toString() {
            return "PendingImageUploadTask(noteId=" + this.f406814a + ", requestId=" + this.f406815b + ", scene=" + this.f406816c + ", imageId=" + this.f406817d + ", localUri=" + this.f406818e + ", nextAttemptAtMs=" + this.f406819f + ')';
        }

        public /* synthetic */ f(long r110, String r111, AINoteScene r112, String r113, String r114) {
            this(r110, r111, r112, r113, r114, 0);
        }

        public f(long r100, String r101, AINoteScene r102, String r103, String r104, long r105) {
            Intrinsics.checkNotNullParameter(r101, "requestId");
            Intrinsics.checkNotNullParameter(r102, "scene");
            Intrinsics.checkNotNullParameter(r103, "imageId");
            Intrinsics.checkNotNullParameter(r104, "localUri");
            this.f406814a = r100;
            this.f406815b = r101;
            this.f406816c = r102;
            this.f406817d = r103;
            this.f406818e = r104;
            this.f406819f = r105;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f406820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f406821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f406822c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AINoteScene f406823d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f406824e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final RichText f406825f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f406826g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f406827h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (this.f406820a == r101.f406820a) goto L12;
            return false;
        L12:
            if (this.f406821b == r101.f406821b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f406822c, r101.f406822c) == true) goto L18;
            return false;
        L18:
            if (this.f406823d == r101.f406823d) goto L21;
            return false;
        L21:
            if (this.f406824e == r101.f406824e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f406825f, r101.f406825f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f406826g, r101.f406826g) == true) goto L30;
            return false;
        L30:
            if (this.f406827h == r101.f406827h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f406820a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f406821b;
            int r103 = (((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f406822c.hashCode()) * 31) + this.f406823d.hashCode()) * 31;
            long r104 = this.f406824e;
            int r105 = (((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.f406825f.hashCode()) * 31;
            String r106 = this.f406826g;
            if (r106 != null) goto L5;
            int r107 = 0;
        L6:
            int r108 = (r105 + r107) * 31;
            if (this.f406827h == false) goto L9;
            int r109 = 1231;
        L11:
            return r108 + r109;
        L9:
            r109 = 1237;
            goto L11
        L5:
            r107 = r106.hashCode();
            goto L6
        }

        public final String toString() {
            return "PendingTextTask(taskId=" + this.f406820a + ", noteId=" + this.f406821b + ", requestId=" + this.f406822c + ", scene=" + this.f406823d + ", version=" + this.f406824e + ", inputRichText=" + this.f406825f + ", inputMarkdown=" + this.f406826g + ", isCreate=" + this.f406827h + ')';
        }

        public g(long r100, long r101, String r102, AINoteScene r103, long r104, RichText r110, String r111, boolean r112) {
            Intrinsics.checkNotNullParameter(r102, "requestId");
            Intrinsics.checkNotNullParameter(r103, "scene");
            Intrinsics.checkNotNullParameter(r110, "inputRichText");
            this.f406820a = r100;
            this.f406821b = r101;
            this.f406822c = r102;
            this.f406823d = r103;
            this.f406824e = r104;
            this.f406825f = r110;
            this.f406826g = r111;
            this.f406827h = r112;
        }
    }

    static {
    }

    public final List<a> a() {
        return CollectionsKt.toList(this.f406762a.values());
    }

    public final List<c> b() {
        return CollectionsKt.toList(this.f406767f.values());
    }

    public final List<d> c() {
        return CollectionsKt.toList(this.f406765d.values());
    }

    public final List<e> d() {
        return CollectionsKt.toList(this.f406766e.values());
    }

    public final List<f> e() {
        return CollectionsKt.toList(this.f406764c.values());
    }

    public final List<g> g() {
        return CollectionsKt.toList(this.f406763b.values());
    }

    public j() {
        this.f406762a = new LinkedHashMap();
        this.f406763b = new LinkedHashMap();
        this.f406764c = new LinkedHashMap();
        this.f406765d = new LinkedHashMap();
        this.f406766e = new LinkedHashMap();
        this.f406767f = new LinkedHashMap();
    }

    public final g f(long r100) {
        return this.f406763b.get(Long.valueOf(r100));
    }

    public final boolean h(long r100) {
        a r101 = p(r100);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.E != true) goto L7;
        return true;
    }

    public final void i(long r100) {
        Long r101 = q(r100);
        if (r101 == null) goto L6;
        a r102 = this.f406762a.remove(r101);
        return;
    }

    public final void j(long r110) {
        Collection<c> r100 = this.f406767f.values();
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L14;
        c r103 = (c) r102.next();
        List<Long> r104 = r103.f406797d;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L6:
        boolean r107 = false;
        if (r106.hasNext() == false) goto L13;
        Object r108 = r106.next();
        if (((Number) r108).longValue() != r110) goto L11;
        r107 = true;
    L11:
        if (r107 == true) goto L6;
        r105.add(r108);
        goto L6
    L13:
        r101.add(c.a(r103, r105, 0, 55));
        goto L4
    L14:
        this.f406767f.clear();
        Iterator r111 = r101.iterator();
    L16:
        if (r111.hasNext() == false) goto L20;
        c r112 = (c) r111.next();
        if ((!r112.f406797d.isEmpty()) == false) goto L16;
        this.f406767f.put(r112.f406794a, r112);
        goto L16
    }

    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "batchId");
        this.f406767f.remove(r100);
    }

    public final void m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "imageId");
        this.f406764c.remove(r100);
    }

    public final a p(long r100) {
        Long r101 = q(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return this.f406762a.get(r101);
    }

    public final Long q(long r100) {
        if (this.f406762a.containsKey(Long.valueOf(r100)) == true) goto L5;
        Iterator<T> r101 = this.f406762a.values().iterator();
    L8:
        if (r101.hasNext() == false) goto L15;
        Object r102 = r101.next();
        if (((a) r102).f406771d != r100) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L8;
    L16:
        a r104 = (a) r102;
        if (r104 != null) goto L19;
        return null;
    L19:
        return Long.valueOf(r104.f406768a);
    L12:
        r103 = false;
        goto L13
    L15:
        r102 = null;
        goto L16
    L5:
        return Long.valueOf(r100);
    }

    public final void t(d r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        this.f406765d.put(Long.valueOf(r100.f406801b), r100);
    }

    public final boolean u(g r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        g r101 = this.f406763b.get(Long.valueOf(r100.f406821b));
        int r102 = AINoteCompareUtils.f407215a;
        if (r101 == null) goto L12;
        RichText r103 = r100.f406825f;
        String r104 = r100.f406826g;
        boolean r105 = r100.f406827h;
        long r106 = r100.f406824e;
        if (r103 == null) goto L12;
        if (AINoteCompareUtils.a(r101, r103, r105, r106) == false) goto L12;
        if (Intrinsics.areEqual(r101.f406826g, r104) == false) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == false) goto L15;
        return false;
    L15:
        this.f406763b.put(Long.valueOf(r100.f406821b), r100);
        return true;
    L12:
        r107 = false;
        goto L13
    }

    public final boolean l(long r100, Long r101) {
        d r102 = this.f406765d.get(Long.valueOf(r100));
        if (r102 != null) goto L5;
        return false;
    L5:
        if (r101 != null) goto L7;
    L9:
        this.f406765d.remove(Long.valueOf(r100));
        return true;
    L7:
        if (r102.f406800a == r101.longValue()) goto L9;
        return false;
    }

    public final boolean n(long r100, Long r101) {
        g r102 = this.f406763b.get(Long.valueOf(r100));
        if (r102 != null) goto L5;
        return false;
    L5:
        if (r101 != null) goto L7;
    L9:
        this.f406763b.remove(Long.valueOf(r100));
        return true;
    L7:
        if (r102.f406820a == r101.longValue()) goto L9;
        return false;
    }

    public static void w(j r100, String r101, Integer r102, List r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "batchId");
        c r105 = r100.f406767f.get(r101);
        if (r105 == null) goto L21;
        LinkedHashMap<String, c> r106 = r100.f406767f;
        if (r102 == null) goto L14;
        int r107 = r102.intValue();
    L15:
        if (r103 == null) goto L18;
        List<Long> r108 = CollectionsKt.distinct(r103);
        if (r108 == null) goto L18;
    L19:
        r106.put(r101, c.a(r105, r108, r107, 23));
        return;
    L18:
        r108 = r105.f406797d;
        goto L19
    L14:
        r107 = r105.f406799f;
        goto L15
    }

    public final void r(List<a> r100, List<g> r101, List<f> r102, List<d> r103, List<e> r104, List<c> r110) {
        Intrinsics.checkNotNullParameter(r100, "drafts");
        Intrinsics.checkNotNullParameter(r101, "pendingTextTasks");
        Intrinsics.checkNotNullParameter(r102, "pendingImageTasks");
        Intrinsics.checkNotNullParameter(r103, "pendingDeleteTasks");
        Intrinsics.checkNotNullParameter(r104, "pendingDownloadTasks");
        Intrinsics.checkNotNullParameter(r110, "pendingBatchCreateTasks");
        this.f406762a.clear();
        Iterator<T> r105 = r100.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        a r106 = (a) r105.next();
        this.f406762a.put(Long.valueOf(r106.f406768a), r106);
        goto L4
    L6:
        this.f406763b.clear();
        Iterator<T> r107 = r101.iterator();
    L8:
        if (r107.hasNext() == false) goto L10;
        g r108 = (g) r107.next();
        this.f406763b.put(Long.valueOf(r108.f406821b), r108);
        goto L8
    L10:
        this.f406764c.clear();
        Iterator<T> r109 = r102.iterator();
    L12:
        if (r109.hasNext() == false) goto L14;
        f r111 = (f) r109.next();
        this.f406764c.put(r111.f406817d, r111);
        goto L12
    L14:
        this.f406765d.clear();
        Iterator<T> r112 = r103.iterator();
    L16:
        if (r112.hasNext() == false) goto L18;
        d r113 = (d) r112.next();
        this.f406765d.put(Long.valueOf(r113.f406801b), r113);
        goto L16
    L18:
        this.f406766e.clear();
        Iterator<T> r114 = r104.iterator();
    L20:
        if (r114.hasNext() == false) goto L22;
        e r115 = (e) r114.next();
        this.f406766e.put(r115.a(), r115);
        goto L20
    L22:
        this.f406767f.clear();
        Iterator<T> r116 = r110.iterator();
    L24:
        if (r116.hasNext() == false) goto L26;
        c r117 = (c) r116.next();
        this.f406767f.put(r117.f406794a, c.a(r117, CollectionsKt.distinct(r117.f406797d), 0, 55));
        goto L24
    }

    public static void s(j r410, String r510, AINoteScene r511, xra.a r512, Boolean r513, Boolean r514, AINotePendingDeleteReason r515, Boolean r516, Boolean r517, int r518) {
        if ((r518 & 2) == 0) goto L5;
        AINoteScene r100 = AINoteScene.Meeting;
    L7:
        if ((r518 & 8) == 0) goto L9;
        Boolean r101 = null;
    L11:
        if ((r518 & 16) == 0) goto L13;
        Boolean r102 = null;
    L15:
        if ((r518 & 32) == 0) goto L17;
        AINotePendingDeleteReason r103 = null;
    L19:
        if ((r518 & 64) == 0) goto L21;
        Boolean r104 = null;
    L23:
        if ((r518 & 128) == 0) goto L25;
        Boolean r105 = null;
    L26:
        r410.getClass();
        Intrinsics.checkNotNullParameter(r510, "requestId");
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r512, "note");
        Long r106 = r410.q(r512.c());
        if (r106 == null) goto L29;
        a r110 = r410.f406762a.get(r106);
    L30:
        List<xra.b> r111 = r512.f564903h;
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator<T> r113 = r111.iterator();
    L32:
        if (r113.hasNext() == false) goto L34;
        r112.add(((xra.b) r113.next()).f564919a);
        goto L32
    L34:
        HashSet r114 = CollectionsKt.toHashSet(r112);
        if (r101 != null) goto L41;
        if (r110 == null) goto L39;
        r101 = Boolean.valueOf(r110.D);
    L40:
        if (r101 != null) goto L41;
        boolean r411 = false;
    L43:
        if (r102 == null) goto L45;
        boolean r107 = r102.booleanValue();
    L50:
        boolean r412 = r107;
    L52:
        if (r110 == null) goto L61;
        List<String> r108 = r110.C;
        if (r108 == null) goto L61;
        ArrayList r109 = new ArrayList();
        Iterator<T> r115 = r108.iterator();
    L57:
        if (r115.hasNext() == false) goto L62;
        Object r116 = r115.next();
        if (r114.contains((String) r116) == true) goto L57;
        r109.add(r116);
    L62:
        if (r109 != null) goto L64;
        List r413 = CollectionsKt.emptyList();
    L65:
        if (r106 == null) goto L69;
        long r117 = r512.c();
        if (r106.longValue() == r117) goto L69;
        r410.f406762a.remove(r106);
    L69:
        LinkedHashMap<Long, a> r118 = r410.f406762a;
        Long r119 = Long.valueOf(r512.c());
        long r120 = r512.c();
        long r121 = r512.f564896a;
        long r122 = r512.f564897b;
        AINoteCreateSource r123 = r512.f564898c;
        AINoteType r124 = r512.f564904i;
        long r125 = r512.f564905j;
        long r126 = r512.f564906k;
        long r127 = r512.f564907l;
        AINoteContentState r128 = r512.f564908m;
        boolean r129 = r512.f564909n;
        boolean r130 = r512.f564910o;
        long r131 = r512.f564911p;
        long r132 = r512.f564912q;
        String r133 = r512.f564913r;
        long r134 = r512.f564914s;
        boolean r135 = r512.f564915t;
        if (r110 == null) goto L73;
        RichText r136 = r110.f406786s;
        if (r136 == null) goto L73;
    L74:
        RichText r310 = r136;
        if (r110 == null) goto L78;
        List<xra.b> r137 = r110.f406787t;
        if (r137 == null) goto L78;
    L79:
        List<xra.b> r311 = r137;
        if (r110 == null) goto L82;
        List<String> r138 = r110.f406788u;
    L83:
        if (r138 != null) goto L85;
        r138 = CollectionsKt.emptyList();
    L85:
        List<String> r312 = r138;
        if (r110 == null) goto L89;
        AINoteContentState r139 = r110.f406789v;
        if (r139 == null) goto L89;
    L90:
        AINoteContentState r313 = r139;
        RichText r140 = r512.f564899d;
        String r141 = r512.f564900e;
        RichText r142 = r512.f564901f;
        String r143 = r512.f564902g;
        AINoteBlockStatus r144 = r512.f564916u;
        List<xra.b> r145 = r512.f564903h;
        if (r412 == false) goto L96;
        if (r103 != null) goto L97;
        if (r110 == null) goto L96;
        r103 = r110.F;
    L97:
        AINotePendingDeleteReason r414 = r103;
    L98:
        if (r104 == null) goto L100;
        boolean r146 = r104.booleanValue();
    L105:
        boolean r415 = r146;
    L107:
        if (r105 != null) goto L114;
        if (r110 == null) goto L111;
        Boolean r314 = Boolean.valueOf(r110.H);
    L112:
        if (r314 == null) goto L115;
        r105 = r314;
        goto L114
    L115:
        boolean r416 = false;
    L116:
        r118.put(r119, new a(r120, r510, r100, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r310, r311, r312, r313, r140, r141, r142, r143, r144, r145, r413, r411, r412, r414, r415, r416));
        return;
    L111:
        r314 = null;
    L114:
        r416 = r105.booleanValue();
        goto L116
    L100:
        if (r110 == null) goto L102;
        Boolean r147 = Boolean.valueOf(r110.G);
    L103:
        if (r147 == null) goto L106;
        r146 = r147.booleanValue();
        goto L105
    L106:
        r415 = false;
        goto L107
    L102:
        r147 = null;
    L96:
        r414 = null;
    L89:
        r139 = r512.f564908m;
        goto L90
    L82:
        r138 = null;
    L78:
        r137 = r512.f564903h;
    L73:
        r136 = r512.f564899d;
        goto L74
    L64:
        r413 = r109;
    L61:
        r109 = null;
        goto L62
    L45:
        if (r110 == null) goto L47;
        Boolean r148 = Boolean.valueOf(r110.E);
    L48:
        if (r148 == null) goto L51;
        r107 = r148.booleanValue();
        goto L50
    L51:
        r412 = false;
        goto L52
    L47:
        r148 = null;
        goto L48
    L39:
        r101 = null;
    L41:
        r411 = r101.booleanValue();
        goto L43
    L29:
        r110 = null;
        goto L30
    L25:
        r105 = r517;
        goto L26
    L21:
        r104 = r516;
        goto L23
    L17:
        r103 = r515;
        goto L19
    L13:
        r102 = r514;
        goto L15
    L9:
        r101 = r513;
        goto L11
    L5:
        r100 = r511;
        goto L7
    }

    public static void o(j r510, long r511, String r512, AINoteScene r513, xra.a r514, RichText r515, boolean r516, boolean r610, boolean r611, AINotePendingDeleteReason r612, List r613, int r614) {
        if ((r614 & 4) == 0) goto L5;
        AINoteScene r100 = AINoteScene.Meeting;
    L7:
        if ((r614 & 32) == 0) goto L9;
        RichText r310 = r514.f564899d;
    L11:
        if ((r614 & 64) == 0) goto L13;
        List<xra.b> r101 = r514.f564903h;
    L15:
        if ((r614 & 128) == 0) goto L17;
        boolean r410 = false;
    L19:
        if ((r614 & 256) == 0) goto L21;
        boolean r411 = false;
    L23:
        if ((r614 & 512) == 0) goto L25;
        boolean r412 = false;
    L27:
        if ((r614 & 1024) == 0) goto L29;
        AINotePendingDeleteReason r102 = null;
    L31:
        if ((r614 & 2048) == 0) goto L33;
        List r110 = CollectionsKt.emptyList();
    L35:
        if ((r614 & 4096) == 0) goto L37;
        List r111 = r110;
    L39:
        if ((r614 & 8192) == 0) goto L41;
        AINoteContentState r103 = r514.f564908m;
    L42:
        r510.getClass();
        Intrinsics.checkNotNullParameter(r512, "requestId");
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r514, "note");
        Intrinsics.checkNotNullParameter(r101, "committedImages");
        Intrinsics.checkNotNullParameter(r110, "deletedImageIds");
        Intrinsics.checkNotNullParameter(r111, "committedDeletedImageIds");
        Intrinsics.checkNotNullParameter(r103, "committedContentState");
        r510.i(r511);
        LinkedHashMap<Long, a> r112 = r510.f406762a;
        Long r113 = Long.valueOf(r514.c());
        long r104 = r514.c();
        long r114 = r514.f564896a;
        List r115 = r110;
        long r116 = r514.f564897b;
        AINoteCreateSource r105 = r514.f564898c;
        List r117 = r111;
        AINoteType r118 = r514.f564904i;
        AINoteContentState r311 = r103;
        List<xra.b> r312 = r101;
        long r106 = r514.f564905j;
        long r107 = r514.f564906k;
        long r108 = r514.f564907l;
        AINoteContentState r109 = r514.f564908m;
        boolean r119 = r514.f564909n;
        boolean r120 = r514.f564910o;
        long r121 = r514.f564911p;
        long r122 = r514.f564912q;
        String r123 = r514.f564913r;
        long r124 = r514.f564914s;
        boolean r125 = r514.f564915t;
        RichText r126 = r514.f564899d;
        String r127 = r514.f564900e;
        RichText r128 = r514.f564901f;
        String r129 = r514.f564902g;
        AINoteBlockStatus r130 = r514.f564916u;
        List<xra.b> r131 = r514.f564903h;
        if (r412 == false) goto L45;
        AINotePendingDeleteReason r413 = r102;
    L46:
        r112.put(r113, new a(r104, r512, r100, r114, r116, r105, r118, r106, r107, r108, r109, r119, r120, r121, r122, r123, r124, r125, r310, r312, r117, r311, r126, r127, r128, r129, r130, r131, r115, false, r412, r413, r410, r411));
        return;
    L45:
        r413 = null;
        goto L46
    L41:
        r103 = null;
        goto L42
    L37:
        r111 = null;
        goto L39
    L33:
        r110 = r613;
        goto L35
    L29:
        r102 = r612;
        goto L31
    L25:
        r412 = r611;
        goto L27
    L21:
        r411 = r610;
        goto L23
    L17:
        r410 = r516;
        goto L19
    L13:
        r101 = null;
        goto L15
    L9:
        r310 = r515;
        goto L11
    L5:
        r100 = r513;
        goto L7
    }

    public static void v(j r610, long r611, Long r612, RichText r613, String r710, RichText r711, String r712, AINoteBlockStatus r713, List r714, Boolean r715, RichText r716, AINoteContentState r717, Boolean r718, AINotePendingDeleteReason r719, Boolean r810, Boolean r811, AINoteCreateSource r812, AINoteContentState r813, int r814) {
        if ((r814 & 2) == 0) goto L5;
        Long r100 = null;
    L7:
        if ((r814 & 4) == 0) goto L9;
        RichText r101 = null;
    L11:
        if ((r814 & 8) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r814 & 16) == 0) goto L17;
        RichText r103 = null;
    L19:
        if ((r814 & 32) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r814 & 64) == 0) goto L25;
        AINoteBlockStatus r105 = null;
    L27:
        if ((r814 & 128) == 0) goto L29;
        List r106 = null;
    L31:
        if ((r814 & 512) == 0) goto L33;
        Boolean r110 = null;
    L35:
        if ((r814 & 1024) == 0) goto L37;
        RichText r111 = null;
    L39:
        if ((r814 & 8192) == 0) goto L41;
        AINoteContentState r112 = null;
    L43:
        if ((r814 & 16384) == 0) goto L45;
        Boolean r113 = null;
    L47:
        if ((32768 & r814) == 0) goto L49;
        AINotePendingDeleteReason r114 = null;
    L51:
        if ((65536 & r814) == 0) goto L53;
        Boolean r115 = null;
    L55:
        if ((r814 & 131072) == 0) goto L57;
        Boolean r116 = null;
    L59:
        if ((r814 & 262144) == 0) goto L61;
        AINoteCreateSource r117 = null;
    L63:
        if ((r814 & 524288) == 0) goto L65;
        AINoteContentState r107 = null;
    L66:
        Long r118 = r610.q(r611);
        if (r118 == null) goto L147;
        long r119 = r118.longValue();
        AINoteContentState r614 = r107;
        a r108 = r610.f406762a.get(Long.valueOf(r119));
        if (r108 == null) goto L148;
        if (r106 != null) goto L73;
        r106 = r108.B;
    L73:
        List r510 = r106;
        List<String> r109 = r108.C;
        if (r109.isEmpty() == false) goto L76;
        List r511 = r109;
    L88:
        if (r113 == null) goto L90;
        boolean r120 = r113.booleanValue();
    L91:
        boolean r512 = r120;
        LinkedHashMap<Long, a> r121 = r610.f406762a;
        Long r122 = Long.valueOf(r119);
        if (r100 == null) goto L94;
        long r123 = r100.longValue();
    L95:
        long r310 = r123;
        if (r111 != null) goto L98;
        r111 = r108.f406786s;
    L98:
        RichText r410 = r111;
        List<xra.b> r124 = r108.f406787t;
        List<String> r125 = r108.f406788u;
        if (r112 != null) goto L101;
        r112 = r108.f406789v;
    L101:
        AINoteContentState r513 = r112;
        if (r117 != null) goto L104;
        AINoteCreateSource r210 = r108.f406773f;
    L105:
        if (r101 != null) goto L107;
        r101 = r108.f406790w;
    L107:
        RichText r514 = r101;
        if (r102 != null) goto L110;
        r102 = r108.f406791x;
    L110:
        String r515 = r102;
        if (r103 != null) goto L113;
        r103 = r108.f406792y;
    L113:
        RichText r516 = r103;
        if (r104 != null) goto L116;
        r104 = r108.f406793z;
    L116:
        String r517 = r104;
        if (r105 != null) goto L119;
        r105 = r108.A;
    L119:
        AINoteBlockStatus r518 = r105;
        if (r110 == null) goto L122;
        boolean r126 = r110.booleanValue();
    L123:
        boolean r519 = r126;
        if (r512 == true) goto L126;
        AINotePendingDeleteReason r211 = null;
    L128:
        AINotePendingDeleteReason r615 = r211;
    L130:
        if (r115 == 0) goto L132;
        boolean r127 = r115.booleanValue();
    L133:
        boolean r616 = r127;
        if (r116 == null) goto L136;
        boolean r128 = r116.booleanValue();
    L137:
        boolean r617 = r128;
        if (r614 != null) goto L140;
        AINoteContentState r311 = r108.f406778k;
    L141:
        r121.put(r122, a.b(r108, 0, 0, 0, r210, null, r310, 0, 0, r311, r108.f406779l, r108.f406780m, r108.f406781n, r108.f406782o, r108.f406783p, r108.f406784q, r108.f406785r, r410, r124, r125, r513, r514, r515, r516, r517, r518, r510, r511, r519, r512, r615, r616, r617, TTVideoEngineInterface.PLAYER_OPTION_HW_DYNAMIC_FRAME_DROPPING_CHECK_PERIOD, 0));
        return;
    L140:
        r311 = r614;
        goto L141
    L136:
        r128 = r108.H;
        goto L137
    L132:
        r127 = r108.G;
        goto L133
    L126:
        if (r114 != 0) goto L129;
        r211 = r108.F;
        goto L128
    L129:
        r615 = r114;
        goto L130
    L122:
        r126 = r108.D;
        goto L123
    L104:
        r210 = r117;
        goto L105
    L94:
        r123 = r108.f406775h;
        goto L95
    L90:
        r120 = r108.E;
        goto L91
    L76:
        List r129 = r510;
        ArrayList r130 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r129, 10));
        Iterator r131 = r129.iterator();
    L78:
        if (r131.hasNext() == false) goto L80;
        r130.add(((xra.b) r131.next()).f564919a);
        goto L78
    L80:
        HashSet r132 = CollectionsKt.toHashSet(r130);
        ArrayList r133 = new ArrayList();
        Iterator r134 = r109.iterator();
    L82:
        if (r134.hasNext() == false) goto L87;
        Object r135 = r134.next();
        Iterator r618 = r134;
        if (r132.contains((String) r135) == true) goto L86;
        r133.add(r135);
    L86:
        r134 = r618;
        goto L82
    L87:
        r511 = r133;
        goto L88
    L148:
        return;
    L147:
        return;
    L65:
        r107 = r813;
        goto L66
    L61:
        r117 = r812;
        goto L63
    L57:
        r116 = r811;
        goto L59
    L53:
        r115 = r810;
        goto L55
    L49:
        r114 = r719;
        goto L51
    L45:
        r113 = r718;
        goto L47
    L41:
        r112 = r717;
        goto L43
    L37:
        r111 = r716;
        goto L39
    L33:
        r110 = r715;
        goto L35
    L29:
        r106 = r714;
        goto L31
    L25:
        r105 = r713;
        goto L27
    L21:
        r104 = r712;
        goto L23
    L17:
        r103 = r711;
        goto L19
    L13:
        r102 = r710;
        goto L15
    L9:
        r101 = r613;
        goto L11
    L5:
        r100 = r612;
        goto L7
    }
}
