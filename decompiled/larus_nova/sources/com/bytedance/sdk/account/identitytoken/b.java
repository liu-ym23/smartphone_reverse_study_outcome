package com.bytedance.sdk.account.identitytoken;

import android.os.SystemClock;
import com.bytedance.sdk.account.utils.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f268921k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f268922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f268923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient long f268924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f268925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f268926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f268927f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f268928g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f268929h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f268930i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final transient boolean f268931j;

    public static final class a {
        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.f268922a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f268923b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f268924c;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f268925d;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f268926e;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        String r111 = this.f268927f;
        if (r111 == null) goto L9;
        int r112 = r111.hashCode();
    L10:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f268928g;
        if (r114 == null) goto L13;
        int r115 = r114.hashCode();
    L14:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f268929h;
        if (r117 == null) goto L17;
        int r118 = r117.hashCode();
    L18:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f268930i;
        if (r120 == null) goto L21;
        r101 = r120.hashCode();
    L21:
        int r121 = (r119 + r101) * 31;
        boolean r122 = this.f268931j;
        ?? r123 = r122;
        if (r122 == false) goto L25;
        r123 = 1;
    L25:
        return r121 + r123;
    L17:
        r118 = 0;
        goto L18
    L13:
        r115 = 0;
        goto L14
    L9:
        r112 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    static {
        f268921k = new a();
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("IdentityTokenCache(identityToken=");
        String r101 = this.f268922a;
        if (r101 == null) goto L5;
        k r102 = new k(r101);
    L6:
        r100.append(r102);
        r100.append(", obtainSystemWallTimeMs=");
        r100.append(this.f268923b);
        r100.append(", obtainSystemBootTimeMs=");
        r100.append(this.f268924c);
        r100.append(", firstRefreshSystemWallTimeMs=");
        r100.append(this.f268925d);
        r100.append(", uid=");
        r100.append(this.f268926e);
        r100.append(", enterFrom=");
        r100.append(this.f268927f);
        r100.append(", sourcePath=");
        r100.append(this.f268928g);
        r100.append(", sourceLogId=");
        r100.append(this.f268929h);
        r100.append(", sourceAbTestGroup=");
        r100.append(this.f268930i);
        r100.append(", isFromStorage=");
        r100.append(this.f268931j);
        r100.append(")");
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public final boolean a() {
        com.bytedance.sdk.account.settings.common.a.a();
        long r100 = com.bytedance.sdk.account.settings.common.a.D;
        long r101 = SystemClock.elapsedRealtime();
        long r102 = System.currentTimeMillis();
        long r103 = this.f268924c;
        if (r103 > 0) goto L12;
        long r104 = this.f268923b;
        if (r102 >= r104) goto L7;
        return true;
    L7:
        if ((r102 - r104) >= (r100 * 1000)) goto L19;
        return false;
    L19:
        return true;
    L12:
        if (r101 >= r103) goto L14;
        return true;
    L14:
        if ((r101 - r103) >= (r100 * 1000)) goto L21;
        return false;
    L21:
        return true;
    }

    public final boolean b() {
        com.bytedance.sdk.account.settings.common.a.a();
        long r100 = com.bytedance.sdk.account.settings.common.a.C;
        long r101 = System.currentTimeMillis();
        long r102 = SystemClock.elapsedRealtime();
        long r103 = this.f268924c;
        if (r103 > 0) goto L12;
        long r104 = this.f268923b;
        if (r101 >= r104) goto L7;
        return true;
    L7:
        if ((r101 - r104) >= (r100 * 1000)) goto L19;
        return false;
    L19:
        return true;
    L12:
        if (r102 >= r103) goto L14;
        return true;
    L14:
        if ((r102 - r103) >= (r100 * 1000)) goto L21;
        return false;
    L21:
        return true;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L50:
        return true;
    L5:
        if ((r100 instanceof b) == false) goto L49;
        b r101 = (b) r100;
        String r102 = this.f268922a;
        k r103 = null;
        if (r102 == null) goto L9;
        k r104 = new k(r102);
    L10:
        String r105 = r101.f268922a;
        if (r105 == null) goto L14;
        r103 = new k(r105);
    L14:
        if (Intrinsics.areEqual(r104, r103) == false) goto L49;
        if (this.f268923b != r101.f268923b) goto L18;
        boolean r106 = true;
    L19:
        if (r106 == false) goto L49;
        if (this.f268924c != r101.f268924c) goto L23;
        boolean r107 = true;
    L24:
        if (r107 == false) goto L49;
        if (this.f268925d != r101.f268925d) goto L28;
        boolean r108 = true;
    L29:
        if (r108 == false) goto L49;
        if (this.f268926e != r101.f268926e) goto L33;
        boolean r109 = true;
    L34:
        if (r109 == false) goto L49;
        if (Intrinsics.areEqual(this.f268927f, r101.f268927f) == false) goto L49;
        if (Intrinsics.areEqual(this.f268928g, r101.f268928g) == false) goto L49;
        if (Intrinsics.areEqual(this.f268929h, r101.f268929h) == false) goto L49;
        if (Intrinsics.areEqual(this.f268930i, r101.f268930i) == false) goto L49;
        if (this.f268931j != r101.f268931j) goto L46;
        boolean r110 = true;
    L47:
        if (r110 == false) goto L49;
    L46:
        r110 = false;
        goto L47
    L33:
        r109 = false;
        goto L34
    L28:
        r108 = false;
        goto L29
    L23:
        r107 = false;
        goto L24
    L18:
        r106 = false;
        goto L19
    L9:
        r104 = null;
    L49:
        return false;
    }

    public /* synthetic */ b(String r110, long r111, long r112, long r210, long r211, String r212, String r213, String r214, String r215) {
        this(r110, r111, r112, r210, r211, r212, r213, r214, r215, false);
    }

    public b(String r100, long r101, long r102, long r103, long r104, String r110, String r111, String r112, String r113, boolean r114) {
        this.f268922a = r100;
        this.f268923b = r101;
        this.f268924c = r102;
        this.f268925d = r103;
        this.f268926e = r104;
        this.f268927f = r110;
        this.f268928g = r111;
        this.f268929h = r112;
        this.f268930i = r113;
        this.f268931j = r114;
    }
}
