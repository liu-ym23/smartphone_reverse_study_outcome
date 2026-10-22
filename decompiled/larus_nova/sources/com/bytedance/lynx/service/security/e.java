package com.bytedance.lynx.service.security;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f264943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f264944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LynxSecurityErrorCode f264945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f264946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f264947e;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public final int hashCode() {
        boolean r100 = this.f264943a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.f264944b;
        int r104 = 0;
        if (r103 != null) goto L8;
        int r105 = 0;
    L9:
        int r106 = (r102 + r105) * 31;
        LynxSecurityErrorCode r107 = this.f264945c;
        if (r107 != null) goto L12;
        int r108 = 0;
    L13:
        long r109 = this.f264946d;
        int r110 = (((r106 + r108) * 31) + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        String r111 = this.f264947e;
        if (r111 == null) goto L18;
        r104 = r111.hashCode();
    L18:
        return r110 + r104;
    L12:
        r108 = r107.hashCode();
        goto L13
    L8:
        r105 = r103.hashCode();
        goto L9
    }

    public final String toString() {
        return "LynxSecurityPayloadVerificationEntity(verified=" + this.f264943a + ", errorMsg=" + this.f264944b + ", errorCode=" + this.f264945c + ", signId=" + this.f264946d + ", extraConfig=" + this.f264947e + ')';
    }

    @Override // com.bytedance.lynx.service.security.b
    public final String a() {
        return this.f264947e;
    }

    @Override // com.bytedance.lynx.service.security.b
    public final boolean b() {
        return this.f264943a;
    }

    @Override // com.bytedance.lynx.service.security.b
    public final long c() {
        return this.f264946d;
    }

    @Override // com.bytedance.lynx.service.security.b
    public final LynxSecurityErrorCode getErrorCode() {
        return this.f264945c;
    }

    @Override // com.bytedance.lynx.service.security.b
    public final String getErrorMsg() {
        return this.f264944b;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f264943a == r101.f264943a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f264944b, r101.f264944b) == true) goto L15;
        return false;
    L15:
        if (this.f264945c == r101.f264945c) goto L18;
        return false;
    L18:
        if (this.f264946d == r101.f264946d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f264947e, r101.f264947e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public e(boolean r100, String r101, LynxSecurityErrorCode r102, long r103, String r104) {
        this.f264943a = r100;
        this.f264944b = r101;
        this.f264945c = r102;
        this.f264946d = r103;
        this.f264947e = r104;
    }
}
