package com.bytedance.helios.api.consumer;

import com.bytedance.helios.common.utils.e;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.ss.ttm.player.MediaPlayer;
import dh7.b;
import hz5.c;
import hz5.d;
import hz5.f;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class PrivacyEvent implements f, b {
    public FrequencyExtra A;
    public AnchorExtra B;
    public ClosureExtra C;
    public String D;
    public List<? extends Object> E;
    public String F;
    public List<String> G;
    public int H;
    public final Set<String> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f245363J;
    public String K;
    public final Set<Map<String, ?>> L;
    public BPEAInfo M;
    public final List<d> N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f245364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f245365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f245366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f245367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f245368e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Throwable f245369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f245370g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f245371h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f245372i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f245373j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f245374k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f245375l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f245376m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, Object> f245377n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f245378o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f245379p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f245380q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f245381r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f245382s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f245383t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Set<String> f245384u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f245385v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f245386w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f245387x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f245388y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ControlExtra f245389z;

    /* JADX INFO: loaded from: classes19.dex */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/helios/api/consumer/PrivacyEvent$ActionType;", "", "api_release"}, k = 1, mv = {1, 1, 16})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ActionType {
    }

    public static final class Companion {

        /* JADX INFO: loaded from: classes19.dex */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/helios/api/consumer/PrivacyEvent$Companion$SourceType;", "", "api_release"}, k = 1, mv = {1, 1, 16})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface SourceType {
        }

        /* JADX INFO: loaded from: classes19.dex */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/helios/api/consumer/PrivacyEvent$Companion$WarningType;", "", "api_release"}, k = 1, mv = {1, 1, 16})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface WarningType {
        }
    }

    static {
    }

    public PrivacyEvent() {
        this(null, null, 0, null, null, null, false, null, null, 0, 0, null, null, 0, false, null, 0, null, null, null, null, null, null, null, null, null, -1, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PrivacyEvent) == false) goto L88;
        PrivacyEvent r101 = (PrivacyEvent) r100;
        if (Intrinsics.areEqual(this.f245364a, r101.f245364a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f245365b, r101.f245365b) == true) goto L10;
        return false;
    L10:
        if (this.f245366c == r101.f245366c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f245367d, r101.f245367d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f245368e, r101.f245368e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f245369f, r101.f245369f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f245370g, r101.f245370g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f245371h, r101.f245371h) == true) goto L22;
        return false;
    L22:
        if (this.f245372i == r101.f245372i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f245373j, r101.f245373j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f245374k, r101.f245374k) == true) goto L28;
        return false;
    L28:
        if (this.f245375l == r101.f245375l) goto L30;
        return false;
    L30:
        if (this.f245376m == r101.f245376m) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f245377n, r101.f245377n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f245378o, r101.f245378o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f245379p, r101.f245379p) == true) goto L38;
        return false;
    L38:
        if (this.f245380q == r101.f245380q) goto L40;
        return false;
    L40:
        if (this.f245381r == r101.f245381r) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f245382s, r101.f245382s) == true) goto L44;
        return false;
    L44:
        if (this.f245383t == r101.f245383t) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.f245384u, r101.f245384u) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f245385v, r101.f245385v) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.f245386w, r101.f245386w) == true) goto L52;
        return false;
    L52:
        if (this.f245387x == r101.f245387x) goto L54;
        return false;
    L54:
        if (this.f245388y == r101.f245388y) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.f245389z, r101.f245389z) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.A, r101.A) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.B, r101.B) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.C, r101.C) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.D, r101.D) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.E, r101.E) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.F, r101.F) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.G, r101.G) == true) goto L72;
        return false;
    L72:
        if (this.H != r101.H) goto L125;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L76;
        return false;
    L76:
        if (Intrinsics.areEqual(this.I, r101.I) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.f245363J, r101.f245363J) == true) goto L80;
        return false;
    L80:
        if (Intrinsics.areEqual(this.K, r101.K) == true) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.L, r101.L) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.M, r101.M) == true) goto L86;
        return false;
    L86:
        if (Intrinsics.areEqual(this.N, r101.N) == true) goto L133;
        return false;
    L133:
        return true;
    L125:
        return false;
    L88:
        return false;
    }

    @Override // hz5.f
    public final String getTag() {
        return "PrivacyEvent";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v102 */
    /* JADX WARN: Type inference failed for: r2v107 */
    /* JADX WARN: Type inference failed for: r2v110 */
    /* JADX WARN: Type inference failed for: r2v117 */
    /* JADX WARN: Type inference failed for: r2v118 */
    /* JADX WARN: Type inference failed for: r2v119 */
    /* JADX WARN: Type inference failed for: r2v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31, types: [int] */
    /* JADX WARN: Type inference failed for: r2v46, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f245364a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f245365b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f245366c) * 31;
        String r107 = this.f245367d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f245368e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Throwable r113 = this.f245369f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f245370g;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f245371h;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        boolean r122 = this.f245372i;
        ?? r123 = 1;
        ?? r124 = r122;
        if (r122 == false) goto L33;
        r124 = 1;
    L33:
        int r125 = (r121 + r124) * 31;
        String r126 = this.f245373j;
        if (r126 == null) goto L36;
        int r127 = r126.hashCode();
    L37:
        int r128 = (r125 + r127) * 31;
        String r129 = this.f245374k;
        if (r129 == null) goto L40;
        int r130 = r129.hashCode();
    L41:
        int r131 = (((r128 + r130) * 31) + this.f245375l) * 31;
        long r132 = this.f245376m;
        int r133 = (r131 + ((int) (r132 ^ (r132 >>> 32)))) * 31;
        Map<String, Object> r134 = this.f245377n;
        if (r134 == null) goto L44;
        int r135 = r134.hashCode();
    L45:
        int r136 = (r133 + r135) * 31;
        String r137 = this.f245378o;
        if (r137 == null) goto L48;
        int r138 = r137.hashCode();
    L49:
        int r139 = (r136 + r138) * 31;
        String r140 = this.f245379p;
        if (r140 == null) goto L52;
        int r141 = r140.hashCode();
    L53:
        int r142 = (r139 + r141) * 31;
        long r143 = this.f245380q;
        int r144 = (r142 + ((int) (r143 ^ (r143 >>> 32)))) * 31;
        boolean r145 = this.f245381r;
        ?? r146 = r145;
        if (r145 == false) goto L56;
        r146 = 1;
    L56:
        int r147 = (r144 + r146) * 31;
        String r148 = this.f245382s;
        if (r148 == null) goto L59;
        int r149 = r148.hashCode();
    L60:
        int r150 = (((r147 + r149) * 31) + this.f245383t) * 31;
        Set<String> r151 = this.f245384u;
        if (r151 == null) goto L63;
        int r152 = r151.hashCode();
    L64:
        int r153 = (r150 + r152) * 31;
        String r154 = this.f245385v;
        if (r154 == null) goto L67;
        int r155 = r154.hashCode();
    L68:
        int r156 = (r153 + r155) * 31;
        String r157 = this.f245386w;
        if (r157 == null) goto L71;
        int r158 = r157.hashCode();
    L72:
        int r159 = (r156 + r158) * 31;
        boolean r160 = this.f245387x;
        ?? r161 = r160;
        if (r160 == false) goto L75;
        r161 = 1;
    L75:
        int r162 = (r159 + r161) * 31;
        boolean r163 = this.f245388y;
        if (r163 == true) goto L79;
        r123 = r163;
    L79:
        int r164 = (r162 + r123) * 31;
        ControlExtra r165 = this.f245389z;
        if (r165 == null) goto L82;
        int r166 = r165.hashCode();
    L83:
        int r167 = (r164 + r166) * 31;
        FrequencyExtra r168 = this.A;
        if (r168 == null) goto L86;
        int r169 = r168.hashCode();
    L87:
        int r170 = (r167 + r169) * 31;
        AnchorExtra r171 = this.B;
        if (r171 == null) goto L90;
        int r172 = r171.hashCode();
    L91:
        int r173 = (r170 + r172) * 31;
        ClosureExtra r174 = this.C;
        if (r174 == null) goto L94;
        int r175 = r174.hashCode();
    L95:
        int r176 = (r173 + r175) * 31;
        String r177 = this.D;
        if (r177 == null) goto L98;
        int r178 = r177.hashCode();
    L99:
        int r179 = (r176 + r178) * 31;
        List<? extends Object> r180 = this.E;
        if (r180 == null) goto L102;
        int r181 = r180.hashCode();
    L103:
        int r182 = (r179 + r181) * 31;
        String r183 = this.F;
        if (r183 == null) goto L106;
        int r184 = r183.hashCode();
    L107:
        int r185 = (r182 + r184) * 31;
        List<String> r186 = this.G;
        if (r186 == null) goto L110;
        int r187 = r186.hashCode();
    L111:
        int r188 = (((((r185 + r187) * 31) + this.H) * 31) + 0) * 31;
        Set<String> r189 = this.I;
        if (r189 == null) goto L114;
        int r190 = r189.hashCode();
    L115:
        int r191 = (r188 + r190) * 31;
        String r192 = this.f245363J;
        if (r192 == null) goto L118;
        int r193 = r192.hashCode();
    L119:
        int r194 = (r191 + r193) * 31;
        String r195 = this.K;
        if (r195 == null) goto L122;
        int r196 = r195.hashCode();
    L123:
        int r197 = (r194 + r196) * 31;
        Set<Map<String, ?>> r198 = this.L;
        if (r198 == null) goto L126;
        int r199 = r198.hashCode();
    L127:
        int r200 = (r197 + r199) * 31;
        BPEAInfo r201 = this.M;
        if (r201 == null) goto L130;
        int r202 = r201.hashCode();
    L131:
        int r203 = (r200 + r202) * 31;
        List<d> r204 = this.N;
        if (r204 == null) goto L135;
        r101 = r204.hashCode();
    L135:
        return r203 + r101;
    L130:
        r202 = 0;
        goto L131
    L126:
        r199 = 0;
        goto L127
    L122:
        r196 = 0;
        goto L123
    L118:
        r193 = 0;
        goto L119
    L114:
        r190 = 0;
        goto L115
    L110:
        r187 = 0;
        goto L111
    L106:
        r184 = 0;
        goto L107
    L102:
        r181 = 0;
        goto L103
    L98:
        r178 = 0;
        goto L99
    L94:
        r175 = 0;
        goto L95
    L90:
        r172 = 0;
        goto L91
    L86:
        r169 = 0;
        goto L87
    L82:
        r166 = 0;
        goto L83
    L71:
        r158 = 0;
        goto L72
    L67:
        r155 = 0;
        goto L68
    L63:
        r152 = 0;
        goto L64
    L59:
        r149 = 0;
        goto L60
    L52:
        r141 = 0;
        goto L53
    L48:
        r138 = 0;
        goto L49
    L44:
        r135 = 0;
        goto L45
    L40:
        r130 = 0;
        goto L41
    L36:
        r127 = 0;
        goto L37
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final PrivacyEvent a() {
        return new PrivacyEvent(this.f245364a, this.f245365b, this.f245366c, this.f245367d, this.f245368e, this.f245371h, this.f245372i, this.f245373j, this.f245374k, this.f245375l, this.f245376m, new HashMap(this.f245377n), this.f245379p, this.f245380q, this.f245381r, this.f245382s, this.f245383t, this.f245385v, this.f245386w, this.f245389z, this.F, this.I, this.f245363J, this.K, this.L, this.M, 2106605664, MediaPlayer.MEDIA_PLAYER_OPTION_DELAY_BUFFERING_UPDATE);
    }

    public final String toString() {
        return "PrivacyEvent(eventSource=" + this.f245364a + ", eventId=" + this.f245366c + ", resourceId=" + this.f245365b + ", eventName=" + this.f245367d + ", eventSubType=" + this.f245368e + ", startTime=" + this.f245376m + ')';
    }

    public final void b(Throwable r100) {
        if (r100 == null) goto L9;
        int r101 = e.f245397a;
        String r102 = r100.getMessage();
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        this.f245370g = e.a(r100, r102);
        this.f245369f = r100;
        return;
    }

    public /* synthetic */ PrivacyEvent(String r410, String r510, int r511, String r512, String r513, String r514, boolean r515, String r516, String r517, int r518, long r519, Map r610, String r611, long r612, boolean r613, String r614, int r615, String r616, String r617, ControlExtra r710, String r711, Set r712, String r713, String r714, Set r715, BPEAInfo r716, int r717, int r718) {
        if ((r717 & 1) == 0) goto L5;
        String r100 = "bytex";
    L7:
        if ((r717 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r717 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r717 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r717 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r717 & 64) == 0) goto L25;
        String r110 = "";
    L27:
        if ((r717 & 128) == 0) goto L29;
        String r111 = "";
    L31:
        if ((r717 & 256) == 0) goto L33;
        boolean r112 = false;
    L35:
        if ((r717 & 512) == 0) goto L37;
        String r113 = "";
    L39:
        if ((r717 & 1024) == 0) goto L41;
        String r114 = "";
    L43:
        if ((r717 & 2048) == 0) goto L45;
        int r115 = 0;
    L47:
        if ((r717 & 4096) == 0) goto L49;
        long r116 = 0;
    L51:
        if ((r717 & 8192) == 0) goto L53;
        Map r210 = new LinkedHashMap();
    L55:
        if ((r717 & 16384) == 0) goto L57;
        String r211 = "";
    L59:
        if ((32768 & r717) == 0) goto L61;
        String r212 = "";
    L63:
        if ((65536 & r717) == 0) goto L65;
        long r213 = 0;
    L67:
        if ((131072 & r717) == 0) goto L69;
        boolean r214 = false;
    L71:
        if ((262144 & r717) == 0) goto L73;
        String r215 = "";
    L75:
        if ((524288 & r717) == 0) goto L77;
        int r216 = 2;
    L79:
        if ((1048576 & r717) == 0) goto L81;
        LinkedHashSet r217 = new LinkedHashSet();
    L83:
        if ((2097152 & r717) == 0) goto L85;
        String r310 = "";
    L87:
        if ((4194304 & r717) == 0) goto L89;
        String r311 = "";
    L91:
        if ((33554432 & r717) == 0) goto L93;
        ControlExtra r312 = new ControlExtra(null, null, null, null, null, null, null, null, false, null, null, null, UnixStat.PERM_MASK, null);
    L95:
        if ((r717 & Integer.MIN_VALUE) == 0) goto L97;
        String r105 = "";
    L99:
        if ((r718 & 2) == 0) goto L101;
        int r411 = -3;
    L103:
        if ((r718 & 8) == 0) goto L105;
        Set r412 = new LinkedHashSet();
    L107:
        if ((r718 & 16) == 0) goto L109;
        String r413 = "";
    L111:
        if ((r718 & 32) == 0) goto L113;
        String r414 = "";
    L115:
        if ((r718 & 64) == 0) goto L117;
        Set r415 = new LinkedHashSet();
    L119:
        if ((r718 & 128) == 0) goto L121;
        BPEAInfo r416 = null;
    L123:
        if ((r718 & 256) == 0) goto L125;
        ArrayList r106 = new ArrayList();
    L126:
        this(r100, r101, r102, r103, r104, null, r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, false, false, r312, null, null, null, null, null, r105, null, r411, null, r412, r413, r414, r415, r416, r106);
        return;
    L125:
        r106 = null;
        goto L126
    L121:
        r416 = r716;
        goto L123
    L117:
        r415 = r715;
        goto L119
    L113:
        r414 = r714;
        goto L115
    L109:
        r413 = r713;
        goto L111
    L105:
        r412 = r712;
        goto L107
    L101:
        r411 = 0;
        goto L103
    L97:
        r105 = r711;
        goto L99
    L93:
        r312 = r710;
        goto L95
    L89:
        r311 = r617;
        goto L91
    L85:
        r310 = r616;
        goto L87
    L81:
        r217 = null;
        goto L83
    L77:
        r216 = r615;
        goto L79
    L73:
        r215 = r614;
        goto L75
    L69:
        r214 = r613;
        goto L71
    L65:
        r213 = r612;
        goto L67
    L61:
        r212 = r611;
        goto L63
    L57:
        r211 = null;
        goto L59
    L53:
        r210 = r610;
        goto L55
    L49:
        r116 = r519;
        goto L51
    L45:
        r115 = r518;
        goto L47
    L41:
        r114 = r517;
        goto L43
    L37:
        r113 = r516;
        goto L39
    L33:
        r112 = r515;
        goto L35
    L29:
        r111 = r514;
        goto L31
    L25:
        r110 = null;
        goto L27
    L21:
        r104 = r513;
        goto L23
    L17:
        r103 = r512;
        goto L19
    L13:
        r102 = r511;
        goto L15
    L9:
        r101 = r510;
        goto L11
    L5:
        r100 = r410;
        goto L7
    }

    public PrivacyEvent(String r100, String r101, int r102, String r103, String r104, Throwable r105, String r110, String r111, boolean r112, String r113, String r114, int r115, long r116, Map<String, Object> r117, String r118, String r210, long r211, boolean r212, String r213, int r214, Set<String> r215, String r216, String r217, boolean r218, boolean r310, ControlExtra r311, FrequencyExtra r312, AnchorExtra r313, ClosureExtra r314, String r315, List<? extends Object> r316, String r317, List<String> r318, int r319, c r410, Set<String> r411, String r412, String r413, Set<Map<String, ?>> r414, BPEAInfo r415, List<d> r416) {
        this.f245364a = r100;
        this.f245365b = r101;
        this.f245366c = r102;
        this.f245367d = r103;
        this.f245368e = r104;
        this.f245369f = r105;
        this.f245370g = r110;
        this.f245371h = r111;
        this.f245372i = r112;
        this.f245373j = r113;
        this.f245374k = r114;
        this.f245375l = r115;
        this.f245376m = r116;
        this.f245377n = r117;
        this.f245378o = r118;
        this.f245379p = r210;
        this.f245380q = r211;
        this.f245381r = r212;
        this.f245382s = r213;
        this.f245383t = r214;
        this.f245384u = r215;
        this.f245385v = r216;
        this.f245386w = r217;
        this.f245387x = r218;
        this.f245388y = r310;
        this.f245389z = r311;
        this.A = r312;
        this.B = r313;
        this.C = r314;
        this.D = r315;
        this.E = r316;
        this.F = r317;
        this.G = r318;
        this.H = r319;
        this.I = r411;
        this.f245363J = r412;
        this.K = r413;
        this.L = r414;
        this.M = r415;
        this.N = r416;
    }
}
