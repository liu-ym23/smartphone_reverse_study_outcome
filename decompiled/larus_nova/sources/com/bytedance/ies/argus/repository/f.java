package com.bytedance.ies.argus.repository;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, e> f246120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.argus.bean.config.e f246121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArgusGeckoFetchType f246122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f246123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f246124e;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f246120a, r101.f246120a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f246121b, r101.f246121b) == true) goto L15;
        return false;
    L15:
        if (this.f246122c == r101.f246122c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f246123d, r101.f246123d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f246124e, r101.f246124e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f246120a.hashCode() * 31;
        com.bytedance.ies.argus.bean.config.e r101 = this.f246121b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        ArgusGeckoFetchType r105 = this.f246122c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f246123d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Long r111 = this.f246124e;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
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
        return "ContainerConfigModel(conf=" + this.f246120a + ", constConfig=" + this.f246121b + ", from=" + this.f246122c + ", version=" + this.f246123d + ", createTimestamp=" + this.f246124e + ')';
    }

    public /* synthetic */ f(int r100) {
        this(MapsKt.emptyMap(), null, null, null, null);
    }

    public f(Map<String, e> r100, com.bytedance.ies.argus.bean.config.e r101, ArgusGeckoFetchType r102, String r103, Long r104) {
        Intrinsics.checkNotNullParameter(r100, "conf");
        this.f246120a = r100;
        this.f246121b = r101;
        this.f246122c = r102;
        this.f246123d = r103;
        this.f246124e = r104;
    }
}
