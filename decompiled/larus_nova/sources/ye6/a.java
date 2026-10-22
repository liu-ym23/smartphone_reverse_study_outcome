package ye6;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f567390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f567391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f567392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f567393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f567394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f567395f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f567396g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f567397h;

    /* JADX INFO: renamed from: ye6.a$a, reason: collision with other inner class name */
    public static final class C8333a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f567390a, r101.f567390a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f567391b, r101.f567391b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f567392c, r101.f567392c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f567393d, r101.f567393d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f567394e, r101.f567394e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f567395f, r101.f567395f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f567396g, r101.f567396g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f567397h, r101.f567397h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((this.f567390a.hashCode() * 31) + this.f567391b.hashCode()) * 31) + this.f567392c.hashCode()) * 31) + this.f567393d.hashCode()) * 31) + this.f567394e.hashCode()) * 31) + this.f567395f.hashCode()) * 31) + this.f567396g.hashCode()) * 31) + this.f567397h.hashCode();
    }

    public final String toString() {
        return "AppInfo(applicationContext=" + this.f567390a + ", aid=" + this.f567391b + ", deviceId=" + this.f567392c + ", deviceModel=" + this.f567393d + ", osVersion=" + this.f567394e + ", appVersion=" + this.f567395f + ", devicePlatform=" + this.f567396g + ", osName=" + this.f567397h + ')';
    }

    public a(Context r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "applicationContext");
        Intrinsics.checkNotNullParameter(r101, "aid");
        Intrinsics.checkNotNullParameter(r102, "deviceId");
        Intrinsics.checkNotNullParameter(r103, "deviceModel");
        Intrinsics.checkNotNullParameter(r104, "osVersion");
        Intrinsics.checkNotNullParameter(r105, "appVersion");
        Intrinsics.checkNotNullParameter("android", "devicePlatform");
        Intrinsics.checkNotNullParameter("Android", "osName");
        this.f567390a = r100;
        this.f567391b = r101;
        this.f567392c = r102;
        this.f567393d = r103;
        this.f567394e = r104;
        this.f567395f = r105;
        this.f567396g = "android";
        this.f567397h = "Android";
    }
}
