package com.larus.dora.impl.device.ailab;

import com.tencent.open.SocialConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class t {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy<String> f333562h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy<String> f333563i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy<String> f333564j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy<String> f333565k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f333566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f333567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f333568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f333569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f333570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f333571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f333572g;

    public static final class a {
        public static String a() {
            return t.f333565k.getValue();
        }

        public static String b() {
            return t.f333562h.getValue();
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (this.f333566a == r101.f333566a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f333567b, r101.f333567b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f333568c, r101.f333568c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f333569d, r101.f333569d) == true) goto L21;
        return false;
    L21:
        if (this.f333570e == r101.f333570e) goto L24;
        return false;
    L24:
        if (this.f333571f == r101.f333571f) goto L27;
        return false;
    L27:
        if (this.f333572g == r101.f333572g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f333566a * 31) + this.f333567b.hashCode()) * 31) + this.f333568c.hashCode()) * 31) + this.f333569d.hashCode()) * 31;
        int r101 = 1231;
        if (this.f333570e == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f333571f == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f333572g == true) goto L15;
        r101 = 1237;
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "AiLabKeyword(iconResId=" + this.f333566a + ", name=" + this.f333567b + ", desc=" + this.f333568c + ", keyword=" + this.f333569d + ", selectable=" + this.f333570e + ", isSelected=" + this.f333571f + ", isVisible=" + this.f333572g + ')';
    }

    static {
        f333562h = LazyKt.lazy(new p());
        f333563i = LazyKt.lazy(new q());
        f333564j = LazyKt.lazy(new r());
        f333565k = LazyKt.lazy(new s());
    }

    public t(int r100, String r101, String r102, String r103, boolean r104, boolean r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r103, "keyword");
        this.f333566a = r100;
        this.f333567b = r101;
        this.f333568c = r102;
        this.f333569d = r103;
        this.f333570e = r104;
        this.f333571f = r105;
        this.f333572g = r106;
    }
}
