package com.bytedance.iesgurd;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f250727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f250728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f250729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f250730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, h> f250731e;

    public l() {
        this(null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L16;
        l r101 = (l) r100;
        if (this.f250727a == r101.f250727a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f250728b, r101.f250728b) == true) goto L10;
        return false;
    L10:
        if (this.f250729c == r101.f250729c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f250730d, r101.f250730d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f250731e, r101.f250731e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public final int hashCode() {
        boolean r100 = this.f250727a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.f250728b;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        long r106 = this.f250729c;
        int r107 = (((r102 + r105) * 31) + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        String r108 = this.f250730d;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        Map<String, h> r111 = this.f250731e;
        if (r111 == null) goto L17;
        r104 = r111.hashCode();
    L17:
        return r110 + r104;
    L12:
        r109 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "IESGurdUpdateResult(success=" + this.f250727a + ", errorMessage=" + this.f250728b + ", version=" + this.f250729c + ", accessKey=" + this.f250730d + ", channelInfos=" + this.f250731e + ")";
    }

    public l(String r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r101 & 2) == 0) goto L10;
        r100 = null;
    L10:
        if ((r101 & 16) == 0) goto L12;
        LinkedHashMap r103 = new LinkedHashMap();
    L13:
        this.f250727a = r102;
        this.f250728b = r100;
        this.f250729c = 0;
        this.f250730d = null;
        this.f250731e = r103;
        return;
    L12:
        r103 = null;
        goto L13
    L5:
        r102 = false;
        goto L7
    }
}
