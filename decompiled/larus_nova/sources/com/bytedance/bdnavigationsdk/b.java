package com.bytedance.bdnavigationsdk;

import android.content.Context;
import android.os.Build;
import com.bytedance.bdnavigationsdk.contants.Constants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f199993g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f199994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f199995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f199996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f199997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a0 f199998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b0 f199999f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f200000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f200001b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e f200002c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f200003d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final a0 f200004e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public b0 f200005f;

        public a() {
            this.f200000a = "";
            this.f200001b = "";
            com.bytedance.bdnavigationsdk.a r100 = com.bytedance.bdnavigationsdk.a.f199985a;
            if (com.bytedance.bdnavigationsdk.a.f199986b == null) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L12;
            int r102 = com.bytedance.bdnavigationsdk.utils.d.f200377a;
            String r103 = com.bytedance.bdnavigationsdk.utils.d.b(com.bytedance.bdnavigationsdk.utils.d.a(Constants.Android.getValue()));
            String r104 = com.bytedance.bdnavigationsdk.utils.d.b(com.bytedance.bdnavigationsdk.utils.d.a(Build.BRAND));
            String r105 = com.bytedance.bdnavigationsdk.utils.d.b(com.bytedance.bdnavigationsdk.utils.d.a(Build.MODEL));
            Context r106 = r100.getContext();
            String r107 = Constants.Unknown.getValue();
            r107 = r106.getPackageManager().getPackageInfo(r106.getPackageName(), 0).versionName.toString();     // Catch: Exception -> L13
        L9:
            this.f200004e = new a0(r103, r104, r105, com.bytedance.bdnavigationsdk.utils.d.b(com.bytedance.bdnavigationsdk.utils.d.a(r107)), com.bytedance.bdnavigationsdk.utils.d.b(com.bytedance.bdnavigationsdk.utils.d.a(Build.VERSION.RELEASE)), Integer.valueOf(Build.VERSION.SDK_INT));
            return;
        L12:
            throw new IllegalStateException("BDNAAppContext 尚未初始化".toString());
        L5:
            r101 = false;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdnavigationsdk.b$b, reason: collision with other inner class name */
    public static final class C2882b {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f199994a, r101.f199994a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f199995b, r101.f199995b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f199996c, r101.f199996c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f199997d, r101.f199997d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f199998e, r101.f199998e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f199999f, r101.f199999f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f199994a.hashCode() * 31) + this.f199995b.hashCode()) * 31;
        e r101 = this.f199996c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        c r105 = this.f199997d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f199998e.hashCode()) * 31;
        b0 r108 = this.f199999f;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "BDNAConfig(appId=" + this.f199994a + ", deviceId=" + this.f199995b + ", logger=" + this.f199996c + ", httpClient=" + this.f199997d + ", systemInfo=" + this.f199998e + ", tracker=" + this.f199999f + ")";
    }

    public b(String r100, String r101, e r102, c r103, a0 r104, b0 r105) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "deviceId");
        Intrinsics.checkNotNullParameter(r104, "systemInfo");
        this.f199994a = r100;
        this.f199995b = r101;
        this.f199996c = r102;
        this.f199997d = r103;
        this.f199998e = r104;
        this.f199999f = r105;
    }
}
