package com.bytedance.bdnavigationsdk;

import android.content.Context;
import android.os.Build;
import com.bytedance.bdnavigationsdk.contants.Constants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final /* synthetic */ int g = 0;
    public final String a;
    public final String b;
    public final e c;
    public final c d;
    public final a0 e;
    public final b0 f;

    public static final class a {
        public String a;
        public String b;
        public e c;
        public c d;
        public final a0 e;
        public b0 f;

        public a() {
            this.a = "";
            this.b = "";
            com.bytedance.bdnavigationsdk.a r0 = com.bytedance.bdnavigationsdk.a.a;
            if (com.bytedance.bdnavigationsdk.a.b == null) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L12;
            int r3 = com.bytedance.bdnavigationsdk.utils.d.a;
            String r4 = com.bytedance.bdnavigationsdk.utils.d.b(com.bytedance.bdnavigationsdk.utils.d.a(Constants.Android.getValue()));
            String r5 = com.bytedance.bdnavigationsdk.utils.d.b(com.bytedance.bdnavigationsdk.utils.d.a(Build.BRAND));
            String r6 = com.bytedance.bdnavigationsdk.utils.d.b(com.bytedance.bdnavigationsdk.utils.d.a(Build.MODEL));
            Context r2 = r0.getContext();
            String r7 = Constants.Unknown.getValue();
            r7 = r2.getPackageManager().getPackageInfo(r2.getPackageName(), 0).versionName.toString();     // Catch: Exception -> L13
        L9:
            this.e = new a0(r4, r5, r6, com.bytedance.bdnavigationsdk.utils.d.b(com.bytedance.bdnavigationsdk.utils.d.a(r7)), com.bytedance.bdnavigationsdk.utils.d.b(com.bytedance.bdnavigationsdk.utils.d.a(Build.VERSION.RELEASE)), Integer.valueOf(Build.VERSION.SDK_INT));
            return;
        L12:
            throw new IllegalStateException("BDNAAppContext 尚未初始化".toString());
        L5:
            r1 = false;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdnavigationsdk.b$b, reason: collision with other inner class name */
    public static final class C0130b {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        e r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        c r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.e.hashCode()) * 31;
        b0 r8 = this.f;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "BDNAConfig(appId=" + this.a + ", deviceId=" + this.b + ", logger=" + this.c + ", httpClient=" + this.d + ", systemInfo=" + this.e + ", tracker=" + this.f + ")";
    }

    public b(String r2, String r3, e r4, c r5, a0 r6, b0 r7) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "deviceId");
        Intrinsics.checkNotNullParameter(r6, "systemInfo");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
