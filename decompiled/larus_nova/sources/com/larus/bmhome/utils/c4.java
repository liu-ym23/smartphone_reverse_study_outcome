package com.larus.bmhome.utils;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f314984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f314985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f314986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BotModel f314987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final wc9.e f314988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f314989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f314990g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f314991h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f314992i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f314993j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f314994k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Message f314995l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final JSONObject f314996m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f314997n;

    public c4() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c4) == true) goto L8;
        return false;
    L8:
        c4 r101 = (c4) r100;
        if (Intrinsics.areEqual(this.f314984a, r101.f314984a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f314985b, r101.f314985b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f314986c, r101.f314986c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f314987d, r101.f314987d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f314988e, r101.f314988e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f314989f, r101.f314989f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f314990g, r101.f314990g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f314991h, r101.f314991h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f314992i, r101.f314992i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f314993j, r101.f314993j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f314994k, r101.f314994k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f314995l, r101.f314995l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f314996m, r101.f314996m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f314997n, r101.f314997n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f314984a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f314985b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f314986c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        BotModel r110 = this.f314987d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        wc9.e r113 = this.f314988e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f314989f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f314990g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f314991h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.f314992i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f314993j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.f314994k;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Message r134 = this.f314995l;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        JSONObject r137 = this.f314996m;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.f314997n;
        if (r140 == null) goto L59;
        r101 = r140.hashCode();
    L59:
        return r139 + r101;
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
        r129 = r128.hashCode();
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
        return "VideoDetailEventParams(botId=" + this.f314984a + ", messageId=" + this.f314985b + ", previousPage=" + this.f314986c + ", botModel=" + this.f314987d + ", conversation=" + this.f314988e + ", enterMethod=" + this.f314989f + ", isUploadVideo=" + this.f314990g + ", creationTaskId=" + this.f314991h + ", position=" + this.f314992i + ", aiCreateShowMode=" + this.f314993j + ", isDeepThinking=" + this.f314994k + ", message=" + this.f314995l + ", customParams=" + this.f314996m + ", currentPage=" + this.f314997n + ')';
    }

    public static c4 a(c4 r110, JSONObject r111) {
        String r100 = r110.f314984a;
        String r101 = r110.f314985b;
        String r102 = r110.f314986c;
        BotModel r103 = r110.f314987d;
        wc9.e r104 = r110.f314988e;
        String r105 = r110.f314989f;
        String r106 = r110.f314990g;
        String r107 = r110.f314991h;
        Integer r108 = r110.f314992i;
        String r112 = r110.f314993j;
        Boolean r113 = r110.f314994k;
        Message r114 = r110.f314995l;
        String r115 = r110.f314997n;
        r110.getClass();
        return new c4(r100, r101, r102, r103, r104, r105, r106, r107, r108, r112, r113, r114, r111, r115);
    }

    public c4(String r100, String r101, String r102, BotModel r103, wc9.e r104, String r105, String r106, String r107, Integer r108, String r110, Boolean r111, Message r112, JSONObject r113, String r114) {
        this.f314984a = r100;
        this.f314985b = r101;
        this.f314986c = r102;
        this.f314987d = r103;
        this.f314988e = r104;
        this.f314989f = r105;
        this.f314990g = r106;
        this.f314991h = r107;
        this.f314992i = r108;
        this.f314993j = r110;
        this.f314994k = r111;
        this.f314995l = r112;
        this.f314996m = r113;
        this.f314997n = r114;
    }

    public /* synthetic */ c4(String r110, String r111, String r112, BotModel r113, wc9.e r210, String r211, String r212, String r213, Integer r214, String r215, Boolean r216, Message r217, JSONObject r218, String r219, int r310) {
        String r100 = null;
        if ((r310 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        BotModel r104 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        wc9.e r105 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r310 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r310 & 256) == 0) goto L37;
        Integer r114 = null;
    L39:
        if ((r310 & 512) == 0) goto L41;
        String r115 = null;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        Boolean r116 = null;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        Message r117 = null;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        JSONObject r118 = null;
    L55:
        if ((r310 & 8192) != 0) goto L58;
        r100 = r219;
    L58:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r114, r115, r116, r117, r118, r100);
        return;
    L53:
        r118 = r218;
        goto L55
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
