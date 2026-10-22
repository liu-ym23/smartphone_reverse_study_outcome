package com.bytedance.lynx.service.security;

import com.lynx.tasm.LynxView;
import com.lynx.tasm.service.security.ILynxSecurityService;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<j8a.a> f264948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<LynxView> f264949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f264950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f264951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ByteBuffer f264952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f264953f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f264954g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LynxSecurityErrorCode f264955h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f264956i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f264957j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ILynxSecurityService.LynxTasmType f264958k;

    public static final class a {
    }

    static {
    }

    public final int hashCode() {
        String r100 = this.f264950c;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        if (this.f264953f == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        String r106 = this.f264954g;
        if (r106 == null) goto L13;
        int r107 = r106.hashCode();
    L14:
        int r108 = (r105 + r107) * 31;
        long r109 = this.f264956i;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        String r111 = this.f264957j;
        if (r111 == null) goto L18;
        r101 = r111.hashCode();
    L18:
        return r110 + r101;
    L13:
        r107 = 0;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LynxSecurityVerificationEntity(securityTarget=" + this.f264948a + ", lynxView=" + this.f264949b + ", templateUrl=" + this.f264950c + ", originTasm=" + Arrays.toString(this.f264951d) + ", originTasmBuffer=" + this.f264952e + ", verified=" + this.f264953f + ", errorMsg=" + this.f264954g + ", errorCode=" + this.f264955h + ", signId=" + this.f264956i + ", extraConfig=" + this.f264957j + ", tasmType=" + this.f264958k + ')';
    }

    @Override // com.bytedance.lynx.service.security.b
    public final String a() {
        return this.f264957j;
    }

    @Override // com.bytedance.lynx.service.security.b
    public final boolean b() {
        return this.f264953f;
    }

    @Override // com.bytedance.lynx.service.security.b
    public final long c() {
        return this.f264956i;
    }

    @Override // com.bytedance.lynx.service.security.b
    public final LynxSecurityErrorCode getErrorCode() {
        return this.f264955h;
    }

    @Override // com.bytedance.lynx.service.security.b
    public final String getErrorMsg() {
        return this.f264954g;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(f.class, r101) == true) goto L12;
        return false;
    L12:
        if (r100 == null) goto L31;
        f r102 = (f) r100;
        if (Intrinsics.areEqual(this.f264950c, r102.f264950c) == true) goto L17;
        return false;
    L17:
        if (Arrays.equals(this.f264951d, r102.f264951d) == true) goto L20;
        return false;
    L20:
        if (this.f264953f == r102.f264953f) goto L23;
        return false;
    L23:
        if (Intrinsics.areEqual(this.f264954g, r102.f264954g) == true) goto L26;
        return false;
    L26:
        if (this.f264956i == r102.f264956i) goto L29;
        return false;
    L29:
        return Intrinsics.areEqual(this.f264957j, r102.f264957j);
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.lynx.service.security.LynxSecurityVerificationEntity");
    L8:
        r101 = null;
        goto L10
    }

    public f(WeakReference<j8a.a> r100, WeakReference<LynxView> r101, String r102, byte[] r103, ByteBuffer r104, boolean r105, String r106, LynxSecurityErrorCode r107, long r110, String r111, ILynxSecurityService.LynxTasmType r112) {
        Intrinsics.checkNotNullParameter(r100, "securityTarget");
        Intrinsics.checkNotNullParameter(r101, "lynxView");
        Intrinsics.checkNotNullParameter(r112, "tasmType");
        this.f264948a = r100;
        this.f264949b = r101;
        this.f264950c = r102;
        this.f264951d = r103;
        this.f264952e = r104;
        this.f264953f = r105;
        this.f264954g = r106;
        this.f264955h = r107;
        this.f264956i = r110;
        this.f264957j = r111;
        this.f264958k = r112;
    }
}
