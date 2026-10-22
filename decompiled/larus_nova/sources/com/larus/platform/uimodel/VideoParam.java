package com.larus.platform.uimodel;

import android.os.Bundle;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.larus.platform.api.FirstFramePreloadVideoData;
import com.larus.platform.api.PrefetchRecommendVideoParam;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
public final class VideoParam {
    public final String A;
    public final String B;
    public final String C;
    public final Integer D;
    public final Integer E;
    public final ArrayList<String> F;
    public final Integer G;
    public final String H;
    public final String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final String f365913J;
    public final String K;
    public final String L;
    public final String M;
    public final String N;
    public final ArrayList<String> O;
    public final Boolean P;
    public final String Q;
    public final FirstFramePreloadVideoData R;
    public final PrefetchRecommendVideoParam S;
    public final boolean T;
    public final long U;
    public final Bundle V;
    public final JSONObject W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<MediaEntity> f365914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaEntityContainer f365915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f365916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f365917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f365918e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f365919f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f365920g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f365921h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f365922i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f365923j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f365924k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, Object> f365925l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final JSONObject f365926m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f365927n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f365928o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final VideoPlayerType f365929p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f365930q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f365931r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f365932s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f365933t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final RecommendType f365934u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f365935v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Integer f365936w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ArrayList<String> f365937x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f365938y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f365939z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/uimodel/VideoParam$RecommendType;", "", "<init>", "(Ljava/lang/String;I)V", "Non", "Search", "AwemeFeed", "PoiFeed", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RecommendType extends Enum<RecommendType> {
        public static final RecommendType AwemeFeed = null;
        public static final RecommendType Non = null;
        public static final RecommendType PoiFeed = null;
        public static final RecommendType Search = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RecommendType[] f365940a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f365941b = null;

        public static EnumEntries<RecommendType> getEntries() {
            return f365941b;
        }

        static {
            RecommendType r100 = new RecommendType("Non", 0);
            Non = r100;
            RecommendType r101 = new RecommendType("Search", 1);
            Search = r101;
            RecommendType r102 = new RecommendType("AwemeFeed", 2);
            AwemeFeed = r102;
            RecommendType r103 = new RecommendType("PoiFeed", 3);
            PoiFeed = r103;
            RecommendType[] r104 = {r100, r101, r102, r103};
            f365940a = r104;
            f365941b = EnumEntriesKt.enumEntries(r104);
        }

        public static RecommendType[] values() {
            return (RecommendType[]) f365940a.clone();
        }

        public static RecommendType valueOf(String r100) {
            return (RecommendType) a.a(RecommendType.class, r100);
        }

        public RecommendType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/platform/uimodel/VideoParam$UgcVideoScene;", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface UgcVideoScene {
        public static final a Companion = null;
        public static final int DEFAULT = 0;
        public static final int UGC_LIMIT = 1;
        public static final int UGC_UN_LIMIT = 2;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f365942a = null;

            static {
                f365942a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f365942a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/uimodel/VideoParam$VideoPlayerType;", "", "<init>", "(Ljava/lang/String;I)V", "VIDEO_ACTIVITY", "DOUYIN_VIDEO_ACTIVITY", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum VideoPlayerType extends Enum<VideoPlayerType> {
        public static final VideoPlayerType DOUYIN_VIDEO_ACTIVITY = null;
        public static final VideoPlayerType VIDEO_ACTIVITY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VideoPlayerType[] f365943a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f365944b = null;

        public static EnumEntries<VideoPlayerType> getEntries() {
            return f365944b;
        }

        static {
            VideoPlayerType r100 = new VideoPlayerType("VIDEO_ACTIVITY", 0);
            VIDEO_ACTIVITY = r100;
            VideoPlayerType r101 = new VideoPlayerType("DOUYIN_VIDEO_ACTIVITY", 1);
            DOUYIN_VIDEO_ACTIVITY = r101;
            VideoPlayerType[] r102 = {r100, r101};
            f365943a = r102;
            f365944b = EnumEntriesKt.enumEntries(r102);
        }

        public static VideoPlayerType[] values() {
            return (VideoPlayerType[]) f365943a.clone();
        }

        public static VideoPlayerType valueOf(String r100) {
            return (VideoPlayerType) a.a(VideoPlayerType.class, r100);
        }

        public VideoPlayerType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public VideoParam() {
        this(null, null, null, null, null, null, null, 0, null, null, null, null, null, 0, 0, null, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0, null, null, -1, 131071);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VideoParam) == true) goto L8;
        return false;
    L8:
        VideoParam r101 = (VideoParam) r100;
        if (Intrinsics.areEqual(this.f365914a, r101.f365914a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365915b, r101.f365915b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365916c, r101.f365916c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f365917d, r101.f365917d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f365918e, r101.f365918e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f365919f, r101.f365919f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f365920g, r101.f365920g) == true) goto L30;
        return false;
    L30:
        if (this.f365921h == r101.f365921h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f365922i, r101.f365922i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f365923j, r101.f365923j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f365924k, r101.f365924k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f365925l, r101.f365925l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f365926m, r101.f365926m) == true) goto L48;
        return false;
    L48:
        if (this.f365927n == r101.f365927n) goto L51;
        return false;
    L51:
        if (this.f365928o == r101.f365928o) goto L54;
        return false;
    L54:
        if (this.f365929p == r101.f365929p) goto L57;
        return false;
    L57:
        if (this.f365930q == r101.f365930q) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f365931r, r101.f365931r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f365932s, r101.f365932s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f365933t, r101.f365933t) == true) goto L69;
        return false;
    L69:
        if (this.f365934u == r101.f365934u) goto L72;
        return false;
    L72:
        if (this.f365935v == r101.f365935v) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f365936w, r101.f365936w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.f365937x, r101.f365937x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.f365938y, r101.f365938y) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.f365939z, r101.f365939z) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r101.A) == true) goto L90;
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
        if (Intrinsics.areEqual(this.f365913J, r101.f365913J) == true) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.K, r101.K) == true) goto L120;
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
        if (Intrinsics.areEqual(this.P, r101.P) == true) goto L135;
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
        if (Intrinsics.areEqual(this.V, r101.V) == true) goto L153;
        return false;
    L153:
        if (Intrinsics.areEqual(this.W, r101.W) == true) goto L155;
        return false;
    L155:
        return true;
    }

    public final int hashCode() {
        ArrayList<MediaEntity> r100 = this.f365914a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        MediaEntityContainer r104 = this.f365915b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f365916c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f365917d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f365918e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f365919f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f365920g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (((((((((((r118 + r120) * 31) + this.f365921h) * 31) + this.f365922i.hashCode()) * 31) + this.f365923j.hashCode()) * 31) + this.f365924k.hashCode()) * 31) + this.f365925l.hashCode()) * 31;
        JSONObject r122 = this.f365926m;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (((((r121 + r123) * 31) + this.f365927n) * 31) + this.f365928o) * 31;
        VideoPlayerType r125 = this.f365929p;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        int r128 = 1231;
        if (this.f365930q == false) goto L41;
        int r129 = 1231;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f365931r;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f365932s;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.f365933t;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (((r136 + r138) * 31) + this.f365934u.hashCode()) * 31;
        if (this.f365935v == false) goto L57;
        int r140 = 1231;
    L58:
        int r141 = (r139 + r140) * 31;
        Integer r142 = this.f365936w;
        if (r142 != null) goto L61;
        int r143 = 0;
    L62:
        int r144 = (r141 + r143) * 31;
        ArrayList<String> r145 = this.f365937x;
        if (r145 != null) goto L65;
        int r146 = 0;
    L66:
        int r147 = (r144 + r146) * 31;
        String r148 = this.f365938y;
        if (r148 != null) goto L69;
        int r149 = 0;
    L70:
        int r150 = (r147 + r149) * 31;
        String r151 = this.f365939z;
        if (r151 != null) goto L73;
        int r152 = 0;
    L74:
        int r153 = (r150 + r152) * 31;
        String r154 = this.A;
        if (r154 != null) goto L77;
        int r155 = 0;
    L78:
        int r156 = (r153 + r155) * 31;
        String r157 = this.B;
        if (r157 != null) goto L81;
        int r158 = 0;
    L82:
        int r159 = (r156 + r158) * 31;
        String r160 = this.C;
        if (r160 != null) goto L85;
        int r161 = 0;
    L86:
        int r162 = (r159 + r161) * 31;
        Integer r163 = this.D;
        if (r163 != null) goto L89;
        int r164 = 0;
    L90:
        int r165 = (r162 + r164) * 31;
        Integer r166 = this.E;
        if (r166 != null) goto L93;
        int r167 = 0;
    L94:
        int r168 = (r165 + r167) * 31;
        ArrayList<String> r169 = this.F;
        if (r169 != null) goto L97;
        int r170 = 0;
    L98:
        int r171 = (r168 + r170) * 31;
        Integer r172 = this.G;
        if (r172 != null) goto L101;
        int r173 = 0;
    L102:
        int r174 = (r171 + r173) * 31;
        String r175 = this.H;
        if (r175 != null) goto L105;
        int r176 = 0;
    L106:
        int r177 = (r174 + r176) * 31;
        String r178 = this.I;
        if (r178 != null) goto L109;
        int r179 = 0;
    L110:
        int r180 = (r177 + r179) * 31;
        String r181 = this.f365913J;
        if (r181 != null) goto L113;
        int r182 = 0;
    L114:
        int r183 = (r180 + r182) * 31;
        String r184 = this.K;
        if (r184 != null) goto L117;
        int r185 = 0;
    L118:
        int r186 = (r183 + r185) * 31;
        String r187 = this.L;
        if (r187 != null) goto L121;
        int r188 = 0;
    L122:
        int r189 = (r186 + r188) * 31;
        String r190 = this.M;
        if (r190 != null) goto L125;
        int r191 = 0;
    L126:
        int r192 = (r189 + r191) * 31;
        String r193 = this.N;
        if (r193 != null) goto L129;
        int r194 = 0;
    L130:
        int r195 = (r192 + r194) * 31;
        ArrayList<String> r196 = this.O;
        if (r196 != null) goto L133;
        int r197 = 0;
    L134:
        int r198 = (r195 + r197) * 31;
        Boolean r199 = this.P;
        if (r199 != null) goto L137;
        int r200 = 0;
    L138:
        int r201 = (r198 + r200) * 31;
        String r202 = this.Q;
        if (r202 != null) goto L141;
        int r203 = 0;
    L142:
        int r204 = (r201 + r203) * 31;
        FirstFramePreloadVideoData r205 = this.R;
        if (r205 != null) goto L145;
        int r206 = 0;
    L146:
        int r207 = (r204 + r206) * 31;
        PrefetchRecommendVideoParam r208 = this.S;
        if (r208 != null) goto L149;
        int r209 = 0;
    L150:
        int r210 = (r207 + r209) * 31;
        if (this.T == true) goto L154;
        r128 = 1237;
    L154:
        long r211 = this.U;
        int r212 = (((r210 + r128) * 31) + ((int) (r211 ^ (r211 >>> 32)))) * 31;
        Bundle r213 = this.V;
        if (r213 != null) goto L157;
        int r214 = 0;
    L158:
        int r215 = (r212 + r214) * 31;
        JSONObject r216 = this.W;
        if (r216 == null) goto L163;
        r101 = r216.hashCode();
    L163:
        return r215 + r101;
    L157:
        r214 = r213.hashCode();
        goto L158
    L149:
        r209 = r208.hashCode();
        goto L150
    L145:
        r206 = r205.hashCode();
        goto L146
    L141:
        r203 = r202.hashCode();
        goto L142
    L137:
        r200 = r199.hashCode();
        goto L138
    L133:
        r197 = r196.hashCode();
        goto L134
    L129:
        r194 = r193.hashCode();
        goto L130
    L125:
        r191 = r190.hashCode();
        goto L126
    L121:
        r188 = r187.hashCode();
        goto L122
    L117:
        r185 = r184.hashCode();
        goto L118
    L113:
        r182 = r181.hashCode();
        goto L114
    L109:
        r179 = r178.hashCode();
        goto L110
    L105:
        r176 = r175.hashCode();
        goto L106
    L101:
        r173 = r172.hashCode();
        goto L102
    L97:
        r170 = r169.hashCode();
        goto L98
    L93:
        r167 = r166.hashCode();
        goto L94
    L89:
        r164 = r163.hashCode();
        goto L90
    L85:
        r161 = r160.hashCode();
        goto L86
    L81:
        r158 = r157.hashCode();
        goto L82
    L77:
        r155 = r154.hashCode();
        goto L78
    L73:
        r152 = r151.hashCode();
        goto L74
    L69:
        r149 = r148.hashCode();
        goto L70
    L65:
        r146 = r145.hashCode();
        goto L66
    L61:
        r143 = r142.hashCode();
        goto L62
    L57:
        r140 = 1237;
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = 1237;
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VideoParam(item=" + this.f365914a + ", container=" + this.f365915b + ", soruceFrom=" + this.f365916c + ", botId=" + this.f365917d + ", messageId=" + this.f365918e + ", conversationId=" + this.f365919f + ", messageErrorMsg=" + this.f365920g + ", videoIndex=" + this.f365921h + ", enterVideoType=" + this.f365922i + ", videoCoverUrl=" + this.f365923j + ", sceneId=" + this.f365924k + ", trackHashMap=" + this.f365925l + ", leaveTraceInfo=" + this.f365926m + ", videoHeight=" + this.f365927n + ", videoWidth=" + this.f365928o + ", videoPlayerType=" + this.f365929p + ", newApi=" + this.f365930q + ", sectionId=" + this.f365931r + ", reqId=" + this.f365932s + ", chatType=" + this.f365933t + ", recommendType=" + this.f365934u + ", keepAllOuterAidWhenRecommend=" + this.f365935v + ", ugcVideoScene=" + this.f365936w + ", query=" + this.f365937x + ", replyId=" + this.f365938y + ", lastMessageId=" + this.f365939z + ", enterFrom=" + this.A + ", enterFromGroupId=" + this.B + ", agentId=" + this.C + ", imprIndex=" + this.D + ", rank=" + this.E + ", replyItemIds=" + this.F + ", streamIndex=" + this.G + ", channelId=" + this.H + ", slideMode=" + this.I + ", cardPosition=" + this.f365913J + ", cardSubPosition=" + this.K + ", richMediaType=" + this.L + ", moduleSource=" + this.M + ", modulePosition=" + this.N + ", extraItemIdList=" + this.O + ", needLoadMore=" + this.P + ", searchId=" + this.Q + ", firstFramePreloadVideoData=" + this.R + ", preloadParam=" + this.S + ", forcePreloadRecommend=" + this.T + ", startPlayPosition=" + this.U + ", extraBundle=" + this.V + ", hostTrackParams=" + this.W + ')';
    }

    public VideoParam(ArrayList r410, MediaEntityContainer r510, Integer r511, String r512, String r513, String r514, String r515, int r516, String r517, String r518, String r519, Map r610, JSONObject r611, int r612, int r613, VideoPlayerType r614, boolean r615, String r616, String r617, String r618, RecommendType r619, boolean r710, Integer r711, ArrayList r712, String r713, String r714, String r715, String r716, String r717, Integer r718, Integer r719, ArrayList r810, Integer r811, String r812, String r813, String r814, String r815, String r816, String r817, String r818, ArrayList r819, String r910, FirstFramePreloadVideoData r911, PrefetchRecommendVideoParam r912, boolean r913, long r914, Bundle r915, JSONObject r916, int r917, int r918) {
        if ((r917 & 1) == 0) goto L5;
        ArrayList r100 = new ArrayList();
    L7:
        if ((r917 & 2) == 0) goto L9;
        MediaEntityContainer r101 = new MediaEntityContainer(null, null, null, null, false, 0, 0, null, 255, null);
    L11:
        if ((r917 & 4) == 0) goto L13;
        Integer r102 = 0;
    L15:
        if ((r917 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r917 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r917 & 32) == 0) goto L25;
        String r110 = "";
    L27:
        if ((r917 & 64) == 0) goto L29;
        String r111 = "";
    L31:
        if ((r917 & 128) == 0) goto L33;
        int r112 = 0;
    L35:
        if ((r917 & 256) == 0) goto L37;
        String r113 = "";
    L39:
        if ((r917 & 512) == 0) goto L41;
        String r114 = "";
    L43:
        if ((r917 & 1024) == 0) goto L45;
        String r115 = "";
    L47:
        if ((r917 & 2048) == 0) goto L49;
        Map r105 = new LinkedHashMap();
    L50:
        int r520 = r112;
        if ((r917 & 4096) == 0) goto L53;
        JSONObject r106 = null;
    L55:
        if ((r917 & 8192) == 0) goto L57;
        int r116 = 10;
    L58:
        int r521 = r116;
        if ((r917 & 16384) == 0) goto L61;
        int r117 = 10;
    L63:
        if ((r917 & 32768) == 0) goto L65;
        VideoPlayerType r118 = null;
    L67:
        if ((r917 & 65536) == 0) goto L69;
        boolean r210 = false;
    L71:
        if ((r917 & 131072) == 0) goto L73;
        String r211 = "";
    L75:
        if ((r917 & 262144) == 0) goto L77;
        String r212 = "";
    L79:
        if ((r917 & 524288) == 0) goto L81;
        String r213 = "";
    L83:
        if ((r917 & 1048576) == 0) goto L85;
        RecommendType r119 = RecommendType.Non;
    L87:
        if ((r917 & 2097152) == 0) goto L89;
        boolean r214 = false;
    L91:
        if ((r917 & 4194304) == 0) goto L93;
        Integer r215 = 0;
    L95:
        if ((r917 & 8388608) == 0) goto L97;
        ArrayList r216 = new ArrayList();
    L99:
        if ((r917 & 16777216) == 0) goto L101;
        String r217 = "";
    L103:
        if ((r917 & 33554432) == 0) goto L105;
        String r310 = "";
    L107:
        if ((r917 & 67108864) == 0) goto L109;
        String r311 = "";
    L111:
        if ((r917 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        String r312 = "";
    L115:
        if ((r917 & 268435456) == 0) goto L117;
        String r313 = "";
    L119:
        if ((r917 & 536870912) == 0) goto L121;
        Integer r314 = null;
    L123:
        if ((r917 & 1073741824) == 0) goto L125;
        Integer r315 = null;
    L127:
        if ((r917 & Integer.MIN_VALUE) == 0) goto L129;
        ArrayList r107 = null;
    L131:
        if ((r918 & 1) == 0) goto L133;
        Integer r316 = null;
    L135:
        if ((r918 & 2) == 0) goto L137;
        String r317 = null;
    L139:
        if ((r918 & 4) == 0) goto L141;
        String r318 = "";
    L143:
        if ((r918 & 8) == 0) goto L145;
        String r319 = "";
    L147:
        if ((r918 & 16) == 0) goto L149;
        String r411 = "";
    L151:
        if ((r918 & 32) == 0) goto L153;
        String r412 = "";
    L155:
        if ((r918 & 64) == 0) goto L157;
        String r413 = "";
    L158:
        ArrayList r218 = r107;
        if ((r918 & 128) == 0) goto L161;
        String r108 = "";
    L162:
        String r414 = r108;
        if ((r918 & 256) == 0) goto L165;
        ArrayList r109 = null;
    L166:
        ArrayList r522 = r109;
        if ((r918 & 1024) == 0) goto L169;
        String r120 = "";
    L170:
        String r523 = r120;
        if ((r918 & 2048) == 0) goto L173;
        FirstFramePreloadVideoData r121 = null;
    L174:
        FirstFramePreloadVideoData r524 = r121;
        if ((r918 & 4096) == 0) goto L177;
        PrefetchRecommendVideoParam r122 = null;
    L178:
        PrefetchRecommendVideoParam r525 = r122;
        if ((r918 & 8192) == 0) goto L181;
        boolean r123 = false;
    L182:
        boolean r219 = r123;
        if ((r918 & 16384) == 0) goto L185;
        long r415 = 0;
    L187:
        if ((r918 & 32768) == 0) goto L189;
        Bundle r124 = null;
    L191:
        if ((r918 & 65536) == 0) goto L193;
        JSONObject r125 = null;
    L194:
        Intrinsics.checkNotNullParameter(r113, "enterVideoType");
        Intrinsics.checkNotNullParameter(r114, "videoCoverUrl");
        Intrinsics.checkNotNullParameter(r115, "sceneId");
        Intrinsics.checkNotNullParameter(r105, "trackHashMap");
        Intrinsics.checkNotNullParameter(r119, "recommendType");
        this.f365914a = r100;
        this.f365915b = r101;
        this.f365916c = r102;
        this.f365917d = r103;
        this.f365918e = r104;
        this.f365919f = r110;
        this.f365920g = r111;
        this.f365921h = r520;
        this.f365922i = r113;
        this.f365923j = r114;
        this.f365924k = r115;
        this.f365925l = r105;
        this.f365926m = r106;
        this.f365927n = r521;
        this.f365928o = r117;
        this.f365929p = r118;
        this.f365930q = r210;
        this.f365931r = r211;
        this.f365932s = r212;
        this.f365933t = r213;
        this.f365934u = r119;
        this.f365935v = r214;
        this.f365936w = r215;
        this.f365937x = r216;
        this.f365938y = r217;
        this.f365939z = r310;
        this.A = r311;
        this.B = r312;
        this.C = r313;
        this.D = r314;
        this.E = r315;
        this.F = r218;
        this.G = r316;
        this.H = r317;
        this.I = r318;
        this.f365913J = r319;
        this.K = r411;
        this.L = r412;
        this.M = r413;
        this.N = r414;
        this.O = r522;
        this.P = null;
        this.Q = r523;
        this.R = r524;
        this.S = r525;
        this.T = r219;
        this.U = r415;
        this.V = r124;
        this.W = r125;
        return;
    L193:
        r125 = r916;
        goto L194
    L189:
        r124 = r915;
        goto L191
    L185:
        r415 = r914;
        goto L187
    L181:
        r123 = r913;
        goto L182
    L177:
        r122 = r912;
        goto L178
    L173:
        r121 = r911;
        goto L174
    L169:
        r120 = r910;
        goto L170
    L165:
        r109 = r819;
        goto L166
    L161:
        r108 = r818;
        goto L162
    L157:
        r413 = r817;
        goto L158
    L153:
        r412 = r816;
        goto L155
    L149:
        r411 = r815;
        goto L151
    L145:
        r319 = r814;
        goto L147
    L141:
        r318 = r813;
        goto L143
    L137:
        r317 = r812;
        goto L139
    L133:
        r316 = r811;
        goto L135
    L129:
        r107 = r810;
        goto L131
    L125:
        r315 = r719;
        goto L127
    L121:
        r314 = r718;
        goto L123
    L117:
        r313 = r717;
        goto L119
    L113:
        r312 = r716;
        goto L115
    L109:
        r311 = r715;
        goto L111
    L105:
        r310 = r714;
        goto L107
    L101:
        r217 = r713;
        goto L103
    L97:
        r216 = r712;
        goto L99
    L93:
        r215 = r711;
        goto L95
    L89:
        r214 = r710;
        goto L91
    L85:
        r119 = r619;
        goto L87
    L81:
        r213 = r618;
        goto L83
    L77:
        r212 = r617;
        goto L79
    L73:
        r211 = r616;
        goto L75
    L69:
        r210 = r615;
        goto L71
    L65:
        r118 = r614;
        goto L67
    L61:
        r117 = r613;
        goto L63
    L57:
        r116 = r612;
        goto L58
    L53:
        r106 = r611;
        goto L55
    L49:
        r105 = r610;
        goto L50
    L45:
        r115 = r519;
        goto L47
    L41:
        r114 = r518;
        goto L43
    L37:
        r113 = r517;
        goto L39
    L33:
        r112 = r516;
        goto L35
    L29:
        r111 = r515;
        goto L31
    L25:
        r110 = r514;
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
}
