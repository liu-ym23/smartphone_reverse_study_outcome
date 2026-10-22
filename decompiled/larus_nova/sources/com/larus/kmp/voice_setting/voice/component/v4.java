package com.larus.kmp.voice_setting.voice.component;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class v4 implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f352580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f352584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f352585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f352586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f352587h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f352588i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, String> f352589j;

    /* JADX WARN: Multi-variable type inference failed */
    public v4() {
        Object[] r100 = 0 == true ? 1 : 0;
        Object[] r101 = 0 == true ? 1 : 0;
        this(null, r100, r101, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v4) == true) goto L8;
        return false;
    L8:
        v4 r101 = (v4) r100;
        if (Intrinsics.areEqual(this.f352580a, r101.f352580a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352581b, r101.f352581b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352582c, r101.f352582c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352583d, r101.f352583d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f352584e, r101.f352584e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f352585f, r101.f352585f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f352586g, r101.f352586g) == true) goto L30;
        return false;
    L30:
        if (this.f352587h == r101.f352587h) goto L33;
        return false;
    L33:
        if (this.f352588i == r101.f352588i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f352589j, r101.f352589j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f352580a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f352581b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f352582c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f352583d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f352584e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        int r114 = (((((r112 + r101) * 31) + this.f352585f.hashCode()) * 31) + this.f352586g.hashCode()) * 31;
        int r115 = 1231;
        if (this.f352587h == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r114 + r116) * 31;
        if (this.f352588i == true) goto L31;
        r115 = 1237;
    L31:
        return ((r117 + r115) * 31) + this.f352589j.hashCode();
    L25:
        r116 = 1237;
        goto L26
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
        return "VoiceEntryArgsData(source=" + this.f352580a + ", botId=" + this.f352581b + ", conversationId=" + this.f352582c + ", languageCode=" + this.f352583d + ", selectedVoiceId=" + this.f352584e + ", enterMethod=" + this.f352585f + ", trackParams=" + this.f352586g + ", isFromVoiceCloneScheme=" + this.f352587h + ", disableVoiceCloneDialogAnimation=" + this.f352588i + ", extras=" + this.f352589j + ')';
    }

    public /* synthetic */ v4(String r110, String r111, Map r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r113 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r113 & 32) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r113 & 64) == 0) goto L17;
        String r114 = "";
    L19:
        if ((r113 & 512) == 0) goto L21;
        Map r115 = MapsKt.emptyMap();
    L22:
        this(r100, null, null, r101, null, r102, r114, false, false, r115);
        return;
    L21:
        r115 = r112;
        goto L22
    L17:
        r114 = null;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public v4(String r100, String r101, String r102, String r103, String r104, String r105, String r106, boolean r107, boolean r110, Map<String, String> r111) {
        Intrinsics.checkNotNullParameter(r105, "enterMethod");
        Intrinsics.checkNotNullParameter(r106, "trackParams");
        Intrinsics.checkNotNullParameter(r111, "extras");
        this.f352580a = r100;
        this.f352581b = r101;
        this.f352582c = r102;
        this.f352583d = r103;
        this.f352584e = r104;
        this.f352585f = r105;
        this.f352586g = r106;
        this.f352587h = r107;
        this.f352588i = r110;
        this.f352589j = r111;
    }
}
