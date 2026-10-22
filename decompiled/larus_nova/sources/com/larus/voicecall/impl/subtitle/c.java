package com.larus.voicecall.impl.subtitle;

import com.larus.audio.call.subtitle.DisplayType;
import com.larus.im.bean.message.block.Block;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f378854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Block> f378855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DisplayType f378856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f378857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f378858e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f378859f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f378860g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f378861h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public x3a.a f378862i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f378863j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, Object> f378864k;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f378854a, r101.f378854a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f378855b, r101.f378855b) == true) goto L15;
        return false;
    L15:
        if (this.f378856c == r101.f378856c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f378857d, r101.f378857d) == true) goto L21;
        return false;
    L21:
        if (this.f378858e == r101.f378858e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f378859f, r101.f378859f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f378854a.hashCode() * 31;
        List<Block> r101 = this.f378855b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f378856c.hashCode()) * 31;
        String r105 = this.f378857d;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        long r106 = this.f378858e;
        return ((((r104 + r102) * 31) + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.f378859f.hashCode();
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DisplaySubtitleData(data=" + this.f378854a + ", blockData=" + this.f378855b + ", displayType=" + this.f378856c + ", littleSubtitleData=" + this.f378857d + ", subtitleCreateTime=" + this.f378858e + ", questionId=" + this.f378859f + ')';
    }

    public /* synthetic */ c(String r110, DisplayType r111, long r112, int r113) {
        String r100 = "";
        if ((r113 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r113 & 4) == 0) goto L9;
        r111 = DisplayType.REPLY_TXT;
    L9:
        DisplayType r102 = r111;
        if ((r113 & 32) != 0) goto L13;
        r100 = null;
    L13:
        this(r101, null, r102, null, r112, r100);
        return;
    L5:
        r101 = r110;
        goto L7
    }

    public c(String r100, List<Block> r101, DisplayType r102, String r103, long r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r102, "displayType");
        Intrinsics.checkNotNullParameter(r105, "questionId");
        this.f378854a = r100;
        this.f378855b = r101;
        this.f378856c = r102;
        this.f378857d = r103;
        this.f378858e = r104;
        this.f378859f = r105;
        this.f378863j = "";
        this.f378864k = new LinkedHashMap();
    }

    public static c a(c r100, String r101, List r110, DisplayType r111, String r112, String r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        r101 = r100.f378854a;
    L5:
        String r102 = r101;
        if ((r114 & 2) == 0) goto L8;
        r110 = r100.f378855b;
    L8:
        List r103 = r110;
        if ((r114 & 4) == 0) goto L11;
        r111 = r100.f378856c;
    L11:
        DisplayType r104 = r111;
        if ((r114 & 8) == 0) goto L14;
        r112 = r100.f378857d;
    L14:
        String r105 = r112;
        if ((r114 & 16) == 0) goto L17;
        long r106 = r100.f378858e;
    L18:
        long r107 = r106;
        if ((r114 & 32) == 0) goto L21;
        r113 = r100.f378859f;
    L21:
        String r108 = r113;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "data");
        Intrinsics.checkNotNullParameter(r104, "displayType");
        Intrinsics.checkNotNullParameter(r108, "questionId");
        return new c(r102, r103, r104, r105, r107, r108);
    L17:
        r106 = 0;
        goto L18
    }
}
