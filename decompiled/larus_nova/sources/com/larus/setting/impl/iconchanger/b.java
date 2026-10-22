package com.larus.setting.impl.iconchanger;

import com.larus.bmhome.auth.CocoSetting;
import com.larus.im.bean.bot.SpeakerVoice;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f368348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f368349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f368350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f368351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f368352e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, SpeakerVoice> f368353f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f368354g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f368355h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CocoSetting f368356i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f368348a == r101.f368348a) goto L12;
        return false;
    L12:
        if (this.f368349b == r101.f368349b) goto L15;
        return false;
    L15:
        if (this.f368350c == r101.f368350c) goto L18;
        return false;
    L18:
        if (this.f368351d == r101.f368351d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f368352e, r101.f368352e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f368353f, r101.f368353f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f368354g, r101.f368354g) == true) goto L30;
        return false;
    L30:
        if (this.f368355h == r101.f368355h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f368356i, r101.f368356i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f368348a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f368349b) * 31;
        if (this.f368350c == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f368351d == true) goto L14;
        r100 = 1237;
    L14:
        int r105 = (r104 + r100) * 31;
        Map<String, String> r106 = this.f368352e;
        int r107 = 0;
        if (r106 != null) goto L17;
        int r108 = 0;
    L18:
        int r109 = (r105 + r108) * 31;
        Map<String, SpeakerVoice> r110 = this.f368353f;
        if (r110 != null) goto L21;
        int r111 = 0;
    L22:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f368354g;
        if (r113 == null) goto L27;
        r107 = r113.hashCode();
    L27:
        return ((((r112 + r107) * 31) + this.f368355h) * 31) + this.f368356i.hashCode();
    L21:
        r111 = r110.hashCode();
        goto L22
    L17:
        r108 = r106.hashCode();
        goto L18
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChangeAppIconData(needAdjust=" + this.f368348a + ", adjustHeight=" + this.f368349b + ", selected=" + this.f368350c + ", useDynamicIcon=" + this.f368351d + ", cocoVoiceTypeMap=" + this.f368352e + ", voice=" + this.f368353f + ", appIconId=" + this.f368354g + ", appIcon=" + this.f368355h + ", cocoSetting=" + this.f368356i + ')';
    }

    public static b a(b r110, boolean r111, int r112, boolean r113, Map r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        r111 = r110.f368348a;
    L5:
        boolean r100 = r111;
        if ((r115 & 2) == 0) goto L8;
        r112 = r110.f368349b;
    L8:
        int r101 = r112;
        if ((r115 & 4) == 0) goto L11;
        r113 = r110.f368350c;
    L11:
        boolean r102 = r113;
        if ((r115 & 8) == 0) goto L14;
        boolean r103 = r110.f368351d;
    L16:
        if ((r115 & 16) == 0) goto L18;
        Map<String, String> r104 = r110.f368352e;
    L20:
        if ((r115 & 32) == 0) goto L22;
        r114 = r110.f368353f;
    L22:
        Map r105 = r114;
        if ((r115 & 64) == 0) goto L25;
        Integer r106 = r110.f368354g;
    L27:
        if ((r115 & 128) == 0) goto L29;
        int r107 = r110.f368355h;
    L31:
        if ((r115 & 256) == 0) goto L33;
        CocoSetting r108 = r110.f368356i;
    L34:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r108, "cocoSetting");
        return new b(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = null;
        goto L34
    L29:
        r107 = 0;
        goto L31
    L25:
        r106 = null;
        goto L27
    L18:
        r104 = null;
        goto L20
    L14:
        r103 = false;
        goto L16
    }

    public b(boolean r100, int r101, boolean r102, boolean r103, Map<String, String> r104, Map<String, SpeakerVoice> r105, Integer r106, int r107, CocoSetting r110) {
        Intrinsics.checkNotNullParameter(r110, "cocoSetting");
        this.f368348a = r100;
        this.f368349b = r101;
        this.f368350c = r102;
        this.f368351d = r103;
        this.f368352e = r104;
        this.f368353f = r105;
        this.f368354g = r106;
        this.f368355h = r107;
        this.f368356i = r110;
    }
}
