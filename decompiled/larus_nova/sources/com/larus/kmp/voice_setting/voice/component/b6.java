package com.larus.kmp.voice_setting.voice.component;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b6 implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VoiceRootRouteKind f352167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f352171e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f352172f;

    public b6() {
        this(null, null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b6) == true) goto L8;
        return false;
    L8:
        b6 r101 = (b6) r100;
        if (this.f352167a == r101.f352167a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352168b, r101.f352168b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352169c, r101.f352169c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352170d, r101.f352170d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f352171e, r101.f352171e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f352172f, r101.f352172f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f352167a.hashCode() * 31) + this.f352168b.hashCode()) * 31;
        String r101 = this.f352169c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f352170d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f352171e;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return ((r107 + r102) * 31) + this.f352172f.hashCode();
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceRootRouteStateData(kind=" + this.f352167a + ", routeKey=" + this.f352168b + ", source=" + this.f352169c + ", selectedVoiceId=" + this.f352170d + ", activeTabKey=" + this.f352171e + ", extras=" + this.f352172f + ')';
    }

    public b6(VoiceRootRouteKind r100, String r101, String r102, String r103, Map r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = VoiceRootRouteKind.NONE;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r105 & 32) == 0) goto L17;
        r104 = MapsKt.emptyMap();
    L17:
        Intrinsics.checkNotNullParameter(r100, "kind");
        Intrinsics.checkNotNullParameter(r101, "routeKey");
        Intrinsics.checkNotNullParameter(r104, "extras");
        this.f352167a = r100;
        this.f352168b = r101;
        this.f352169c = r102;
        this.f352170d = r103;
        this.f352171e = null;
        this.f352172f = r104;
    }
}
