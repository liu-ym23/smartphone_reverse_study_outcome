package com.larus.kmp.voice_setting.voice.feature;

import com.larus.im.bean.bot.SpeakerVoice;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f353326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<SpeakerVoice> f353327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f353328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f353329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<SpeakerVoice> f353330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f353331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f353332g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f353333h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f353334i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.network.b<SpeakerVoice> f353335j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.network.b<SpeakerVoice> f353336k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.network.b<ah9.b> f353337l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.network.b<SpeakerVoice> f353338m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ah9.a f353339n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.network.b<SpeakerVoice> f353340o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.network.b<SpeakerVoice> f353341p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ah9.c f353342q;

    public l() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f353326a == r101.f353326a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f353327b, r101.f353327b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f353328c, r101.f353328c) == true) goto L18;
        return false;
    L18:
        if (this.f353329d == r101.f353329d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f353330e, r101.f353330e) == true) goto L24;
        return false;
    L24:
        if (this.f353331f == r101.f353331f) goto L27;
        return false;
    L27:
        if (this.f353332g == r101.f353332g) goto L30;
        return false;
    L30:
        if (this.f353333h == r101.f353333h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f353334i, r101.f353334i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f353335j, r101.f353335j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f353336k, r101.f353336k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f353337l, r101.f353337l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f353338m, r101.f353338m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f353339n, r101.f353339n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f353340o, r101.f353340o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f353341p, r101.f353341p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f353342q, r101.f353342q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f353326a;
        int r101 = ((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f353327b.hashCode()) * 31) + this.f353328c.hashCode()) * 31;
        if (this.f353329d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((((((r101 + r102) * 31) + this.f353330e.hashCode()) * 31) + this.f353331f) * 31) + this.f353332g) * 31) + this.f353333h) * 31;
        String r104 = this.f353334i;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        com.larus.kmp.voice_setting.voice.network.b<SpeakerVoice> r108 = this.f353335j;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        com.larus.kmp.voice_setting.voice.network.b<SpeakerVoice> r111 = this.f353336k;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        com.larus.kmp.voice_setting.voice.network.b<ah9.b> r114 = this.f353337l;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        com.larus.kmp.voice_setting.voice.network.b<SpeakerVoice> r117 = this.f353338m;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        ah9.a r120 = this.f353339n;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        com.larus.kmp.voice_setting.voice.network.b<SpeakerVoice> r123 = this.f353340o;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        com.larus.kmp.voice_setting.voice.network.b<SpeakerVoice> r126 = this.f353341p;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        ah9.c r129 = this.f353342q;
        if (r129 == null) goto L43;
        r105 = r129.hashCode();
    L43:
        return r128 + r105;
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
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "UgcVoiceRepoStateData(eventToken=" + this.f353326a + ", myVoiceList=" + this.f353327b + ", failedVoiceIds=" + this.f353328c + ", myVoiceListLoaded=" + this.f353329d + ", recommendVoiceList=" + this.f353330e + ", recommendCacheStatus=" + this.f353331f + ", recommendLoadMoreStatus=" + this.f353332g + ", myVoiceLoadMoreStatus=" + this.f353333h + ", createVoiceLocalId=" + this.f353334i + ", createVoiceResult=" + this.f353335j + ", createVoiceResultV2=" + this.f353336k + ", deleteVoiceResult=" + this.f353337l + ", editVoiceNameResult=" + this.f353338m + ", checkVoiceResult=" + this.f353339n + ", cloneVoiceResult=" + this.f353340o + ", updateVoiceResult=" + this.f353341p + ", recommendFirstPage=" + this.f353342q + ')';
    }

    public /* synthetic */ l(int r210) {
        this(0, CollectionsKt.emptyList(), SetsKt.emptySet(), false, CollectionsKt.emptyList(), CacheStatus.EMPTY.ordinal(), 2, 2, null, null, null, null, null, null, null, null, null);
    }

    public l(long r100, List<SpeakerVoice> r101, Set<String> r110, boolean r111, List<SpeakerVoice> r112, int r113, int r114, int r115, String r116, com.larus.kmp.voice_setting.voice.network.b<SpeakerVoice> r117, com.larus.kmp.voice_setting.voice.network.b<SpeakerVoice> r118, com.larus.kmp.voice_setting.voice.network.b<ah9.b> r119, com.larus.kmp.voice_setting.voice.network.b<SpeakerVoice> r210, ah9.a r211, com.larus.kmp.voice_setting.voice.network.b<SpeakerVoice> r212, com.larus.kmp.voice_setting.voice.network.b<SpeakerVoice> r213, ah9.c r214) {
        Intrinsics.checkNotNullParameter(r101, "myVoiceList");
        Intrinsics.checkNotNullParameter(r110, "failedVoiceIds");
        Intrinsics.checkNotNullParameter(r112, "recommendVoiceList");
        this.f353326a = r100;
        this.f353327b = r101;
        this.f353328c = r110;
        this.f353329d = r111;
        this.f353330e = r112;
        this.f353331f = r113;
        this.f353332g = r114;
        this.f353333h = r115;
        this.f353334i = r116;
        this.f353335j = r117;
        this.f353336k = r118;
        this.f353337l = r119;
        this.f353338m = r210;
        this.f353339n = r211;
        this.f353340o = r212;
        this.f353341p = r213;
        this.f353342q = r214;
    }

    public static l a(l r110, long r111, List r210, Set r211, boolean r212, List r213, int r214, int r215, int r216, String r217, com.larus.kmp.voice_setting.voice.network.b r218, com.larus.kmp.voice_setting.voice.network.b r219, com.larus.kmp.voice_setting.voice.network.b r310, com.larus.kmp.voice_setting.voice.network.b r311, ah9.a r312, com.larus.kmp.voice_setting.voice.network.b r313, com.larus.kmp.voice_setting.voice.network.b r314, ah9.c r315, int r316) {
        if ((r316 & 1) == 0) goto L5;
        long r100 = r110.f353326a;
    L7:
        if ((r316 & 2) == 0) goto L9;
        List r101 = r110.f353327b;
    L11:
        if ((r316 & 4) == 0) goto L13;
        Set r102 = r110.f353328c;
    L15:
        if ((r316 & 8) == 0) goto L17;
        boolean r103 = r110.f353329d;
    L19:
        if ((r316 & 16) == 0) goto L21;
        List r104 = r110.f353330e;
    L23:
        if ((r316 & 32) == 0) goto L25;
        int r105 = r110.f353331f;
    L27:
        if ((r316 & 64) == 0) goto L29;
        int r106 = r110.f353332g;
    L31:
        if ((r316 & 128) == 0) goto L33;
        int r112 = r110.f353333h;
    L35:
        if ((r316 & 256) == 0) goto L37;
        String r113 = r110.f353334i;
    L39:
        if ((r316 & 512) == 0) goto L41;
        com.larus.kmp.voice_setting.voice.network.b r114 = r110.f353335j;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        com.larus.kmp.voice_setting.voice.network.b r115 = r110.f353336k;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        com.larus.kmp.voice_setting.voice.network.b r116 = r110.f353337l;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        com.larus.kmp.voice_setting.voice.network.b r117 = r110.f353338m;
    L54:
        com.larus.kmp.voice_setting.voice.network.b r317 = r117;
        if ((r316 & 8192) == 0) goto L57;
        ah9.a r118 = r110.f353339n;
    L58:
        ah9.a r318 = r118;
        if ((r316 & 16384) == 0) goto L61;
        com.larus.kmp.voice_setting.voice.network.b r119 = r110.f353340o;
    L62:
        com.larus.kmp.voice_setting.voice.network.b r319 = r119;
        if ((r316 & 32768) == 0) goto L65;
        com.larus.kmp.voice_setting.voice.network.b r120 = r110.f353341p;
    L67:
        if ((r316 & 65536) == 0) goto L69;
        ah9.c r107 = r110.f353342q;
    L70:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "myVoiceList");
        Intrinsics.checkNotNullParameter(r102, "failedVoiceIds");
        Intrinsics.checkNotNullParameter(r104, "recommendVoiceList");
        return new l(r100, r101, r102, r103, r104, r105, r106, r112, r113, r114, r115, r116, r317, r318, r319, r120, r107);
    L69:
        r107 = r315;
        goto L70
    L65:
        r120 = r314;
        goto L67
    L61:
        r119 = r313;
        goto L62
    L57:
        r118 = r312;
        goto L58
    L53:
        r117 = r311;
        goto L54
    L49:
        r116 = r310;
        goto L51
    L45:
        r115 = r219;
        goto L47
    L41:
        r114 = r218;
        goto L43
    L37:
        r113 = r217;
        goto L39
    L33:
        r112 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
