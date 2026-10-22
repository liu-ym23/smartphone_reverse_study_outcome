package com.larus.platform.api;

import com.larus.platform.model.music.ThirdPartyMusicPlatform;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f365152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f365153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f365154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f365155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p4 f365156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<String> f365157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f365158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f365159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f365160i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f365161j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function4<? super Integer, ? super Boolean, ? super ThirdPartyMusicPlatform, ? super Integer, Unit> f365162k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i5) == true) goto L8;
        return false;
    L8:
        i5 r101 = (i5) r100;
        if (Intrinsics.areEqual(this.f365152a, r101.f365152a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365153b, r101.f365153b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365154c, r101.f365154c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f365155d, r101.f365155d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f365156e, r101.f365156e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f365157f, r101.f365157f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f365158g, r101.f365158g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f365159h, r101.f365159h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f365160i, r101.f365160i) == true) goto L36;
        return false;
    L36:
        if (this.f365161j == r101.f365161j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f365162k, r101.f365162k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f365152a.hashCode() * 31) + this.f365153b.hashCode()) * 31) + this.f365154c.hashCode()) * 31;
        String r101 = this.f365155d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        p4 r105 = this.f365156e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f365157f.hashCode()) * 31;
        String r108 = this.f365158g;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f365159h;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f365160i;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        if (this.f365161j == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r116 + r117) * 31;
        Function4<? super Integer, ? super Boolean, ? super ThirdPartyMusicPlatform, ? super Integer, Unit> r119 = this.f365162k;
        if (r119 == null) goto L31;
        r102 = r119.hashCode();
    L31:
        return r118 + r102;
    L25:
        r117 = 1237;
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
        return "StartMusicAuthAdditionalJSBParams(id=" + this.f365152a + ", subTitle=" + this.f365153b + ", mainTitle=" + this.f365154c + ", bottomTipTitle=" + this.f365155d + ", musicTraceInfo=" + this.f365156e + ", authTargetList=" + this.f365157f + ", lunaClientKey=" + this.f365158g + ", lunaScope=" + this.f365159h + ", lunaState=" + this.f365160i + ", isNewApplication=" + this.f365161j + ", onMusicPlatformAuthResult=" + this.f365162k + ')';
    }

    public i5(String r100, String r101, String r102, String r103, p4 r104, ArrayList r105, String r106, String r107, String r110, boolean r111, ol9.l r112) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "subTitle");
        Intrinsics.checkNotNullParameter(r102, "mainTitle");
        Intrinsics.checkNotNullParameter(r105, "authTargetList");
        this.f365152a = r100;
        this.f365153b = r101;
        this.f365154c = r102;
        this.f365155d = r103;
        this.f365156e = r104;
        this.f365157f = r105;
        this.f365158g = r106;
        this.f365159h = r107;
        this.f365160i = r110;
        this.f365161j = r111;
        this.f365162k = r112;
    }
}
