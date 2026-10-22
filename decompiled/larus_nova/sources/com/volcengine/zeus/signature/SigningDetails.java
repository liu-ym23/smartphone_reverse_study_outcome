package com.volcengine.zeus.signature;

import android.content.pm.Signature;
import android.util.ArraySet;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes41.dex */
public final class SigningDetails {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f462889f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Signature[] f462890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f462891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArraySet<PublicKey> f462892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Signature[] f462893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f462894e;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CertCapabilities {
        public static final int AUTH = 16;
        public static final int INSTALLED_DATA = 1;
        public static final int PERMISSION = 4;
        public static final int ROLLBACK = 8;
        public static final int SHARED_USER_ID = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SignatureSchemeVersion {
        public static final int JAR = 1;
        public static final int SIGNING_BLOCK_V2 = 2;
        public static final int SIGNING_BLOCK_V3 = 3;
        public static final int UNKNOWN = 0;
    }

    public final int hashCode() {
        int r100 = ((Arrays.hashCode(this.f462890a) * 31) + this.f462891b) * 31;
        ArraySet<PublicKey> r101 = this.f462892c;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return ((((r100 + r102) * 31) + Arrays.hashCode(this.f462893d)) * 31) + Arrays.hashCode(this.f462894e);
    L5:
        r102 = 0;
        goto L7
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SigningDetails) == true) goto L8;
        return false;
    L8:
        SigningDetails r101 = (SigningDetails) r100;
        if (this.f462891b == r101.f462891b) goto L11;
        return false;
    L11:
        Signature[] r102 = this.f462890a;
        Signature[] r103 = r101.f462890a;
        if (r102.length == r103.length) goto L14;
    L18:
        boolean r104 = false;
    L19:
        if (r104 == true) goto L21;
        return false;
    L21:
        ArraySet<PublicKey> r105 = this.f462892c;
        if (r105 == null) goto L27;
        if (r105.equals(r101.f462892c) == true) goto L30;
        return false;
    L30:
        if (Arrays.equals(this.f462893d, r101.f462893d) == true) goto L33;
        return false;
    L33:
        if (Arrays.equals(this.f462894e, r101.f462894e) == true) goto L35;
        return false;
    L35:
        return true;
    L27:
        if (r101.f462892c == null) goto L30;
        return false;
    L14:
        if (mqc.c.a(r102, r103) == false) goto L18;
        if (mqc.c.a(r103, r102) == false) goto L18;
        r104 = true;
        goto L19
    }

    public SigningDetails(Signature[] r100, int r101, Signature[] r102, int[] r110) throws CertificateException {
        ArraySet r103 = new ArraySet(r100.length);
        int r104 = 0;
    L4:
        if (r104 >= r100.length) goto L18;
        Method r105 = zpc.a.c(Signature.class, "getPublicKey", new Class[0]);
        if (r105 == null) goto L17;
        if (r105.isAccessible() == false) goto L17;
        r103.add((PublicKey) r105.invoke(r100[r104], new Object[0]));     // Catch: Exception -> L11 InvocationTargetException -> L13 IllegalAccessException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
    L13:
        e = move-exception;
        e.printStackTrace();
    L11:
        e = move-exception;
        e.printStackTrace();
    L17:
        r104 = r104 + 1;
        goto L4
    L18:
        this(r100, r101, r103, r102, r110);
    }

    public SigningDetails(Signature[] r100, int r101, ArraySet<PublicKey> r102, Signature[] r103, int[] r104) {
        this.f462890a = r100;
        this.f462891b = r101;
        this.f462892c = r102;
        this.f462893d = r103;
        this.f462894e = r104;
    }
}
