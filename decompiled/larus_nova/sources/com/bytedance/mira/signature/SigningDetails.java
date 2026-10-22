package com.bytedance.mira.signature;

import android.content.pm.Signature;
import android.util.ArraySet;
import com.bytedance.mira.compat.p.HackHelper;
import com.bytedance.mira.util.ArrayUtils;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* JADX INFO: loaded from: classes21.dex */
final class SigningDetails {
    private static final int PAST_CERT_EXISTS = 0;
    public static final SigningDetails UNKNOWN = null;
    public final Signature[] pastSigningCertificates;
    public final int[] pastSigningCertificatesFlags;
    public final ArraySet<PublicKey> publicKeys;
    public final int signatureSchemeVersion;
    public final Signature[] signatures;

    public static class Builder {
        private Signature[] mPastSigningCertificates;
        private int[] mPastSigningCertificatesFlags;
        private int mSignatureSchemeVersion;
        private Signature[] mSignatures;

        private void checkInvariants() {
            if (this.mSignatures == null) goto L21;
            Signature[] r100 = this.mPastSigningCertificates;
            boolean r101 = true;
            if (r100 == null) goto L11;
            int[] r102 = this.mPastSigningCertificatesFlags;
            if (r102 == null) goto L11;
            if (r100.length != r102.length) goto L16;
        L15:
            r101 = false;
        L16:
            if (r101 == true) goto L19;
            return;
        L19:
            throw new IllegalStateException("SigningDetails must have a one to one mapping between pastSigningCertificates and pastSigningCertificatesFlags");
        L11:
            if (r100 != null) goto L16;
            if (this.mPastSigningCertificatesFlags == null) goto L15;
        L21:
            throw new IllegalStateException("SigningDetails requires the current signing certificates.");
        }

        public Builder() {
            this.mSignatureSchemeVersion = 0;
        }

        public SigningDetails build() throws CertificateException {
            checkInvariants();
            return new SigningDetails(this.mSignatures, this.mSignatureSchemeVersion, this.mPastSigningCertificates, this.mPastSigningCertificatesFlags);
        }

        public Builder setPastSigningCertificates(Signature[] r100) {
            this.mPastSigningCertificates = r100;
            return this;
        }

        public Builder setPastSigningCertificatesFlags(int[] r100) {
            this.mPastSigningCertificatesFlags = r100;
            return this;
        }

        public Builder setSignatureSchemeVersion(int r100) {
            this.mSignatureSchemeVersion = r100;
            return this;
        }

        public Builder setSignatures(Signature[] r100) {
            this.mSignatures = r100;
            return this;
        }
    }

    public @interface CertCapabilities {
        public static final int AUTH = 16;
        public static final int INSTALLED_DATA = 1;
        public static final int PERMISSION = 4;
        public static final int ROLLBACK = 8;
        public static final int SHARED_USER_ID = 2;
    }

    public @interface SignatureSchemeVersion {
        public static final int JAR = 1;
        public static final int SIGNING_BLOCK_V2 = 2;
        public static final int SIGNING_BLOCK_V3 = 3;
        public static final int UNKNOWN = 0;
    }

    static {
        UNKNOWN = new SigningDetails(null, 0, null, null, null);
    }

    public boolean hasPastSigningCertificates() {
        Signature[] r100 = this.pastSigningCertificates;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.length <= 0) goto L7;
        return true;
    }

    public boolean hasSignatures() {
        Signature[] r100 = this.signatures;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.length <= 0) goto L7;
        return true;
    }

    public int hashCode() {
        int r100 = ((Arrays.hashCode(this.signatures) * 31) + this.signatureSchemeVersion) * 31;
        ArraySet<PublicKey> r101 = this.publicKeys;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return ((((r100 + r102) * 31) + Arrays.hashCode(this.pastSigningCertificates)) * 31) + Arrays.hashCode(this.pastSigningCertificatesFlags);
    L5:
        r102 = 0;
        goto L7
    }

    public SigningDetails(SigningDetails r100) {
        if (r100 == null) goto L12;
        Signature[] r101 = r100.signatures;
        if (r101 == null) goto L7;
        this.signatures = (Signature[]) r101.clone();
    L8:
        this.signatureSchemeVersion = r100.signatureSchemeVersion;
        this.publicKeys = new ArraySet(r100.publicKeys);
        Signature[] r102 = r100.pastSigningCertificates;
        if (r102 == null) goto L11;
        this.pastSigningCertificates = (Signature[]) r102.clone();
        this.pastSigningCertificatesFlags = (int[]) r100.pastSigningCertificatesFlags.clone();
        return;
    L11:
        this.pastSigningCertificates = null;
        this.pastSigningCertificatesFlags = null;
        return;
    L7:
        this.signatures = null;
        goto L8
    L12:
        this.signatures = null;
        this.signatureSchemeVersion = 0;
        this.publicKeys = null;
        this.pastSigningCertificates = null;
        this.pastSigningCertificatesFlags = null;
    }

    public static ArraySet<PublicKey> toSigningKeys(Signature[] r100) throws CertificateException {
        ArraySet<PublicKey> r101 = new ArraySet(r100.length);
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L18;
        Method r103 = HackHelper.getMethod(Signature.class, "getPublicKey", new Class[0]);
        if (r103 == null) goto L17;
        if (r103.isAccessible() == false) goto L17;
        r101.add((PublicKey) r103.invoke(r100[r102], new Object[0]));     // Catch: Exception -> L11 InvocationTargetException -> L13 IllegalAccessException -> L15
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
        r102 = r102 + 1;
        goto L4
    L18:
        return r101;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SigningDetails) == true) goto L8;
        return false;
    L8:
        SigningDetails r101 = (SigningDetails) r100;
        if (this.signatureSchemeVersion == r101.signatureSchemeVersion) goto L12;
        return false;
    L12:
        if (areExactMatch(this.signatures, r101.signatures) == true) goto L14;
        return false;
    L14:
        ArraySet<PublicKey> r102 = this.publicKeys;
        if (r102 == null) goto L20;
        if (r102.equals(r101.publicKeys) == true) goto L23;
        return false;
    L23:
        if (Arrays.equals(this.pastSigningCertificates, r101.pastSigningCertificates) == true) goto L26;
        return false;
    L26:
        if (Arrays.equals(this.pastSigningCertificatesFlags, r101.pastSigningCertificatesFlags) == true) goto L28;
        return false;
    L28:
        return true;
    L20:
        if (r101.publicKeys == null) goto L23;
        return false;
    }

    public boolean hasAncestor(SigningDetails r100) {
        SigningDetails r101 = UNKNOWN;
        if (this == r101) goto L17;
        if (r100 == r101) goto L17;
        if (hasPastSigningCertificates() == false) goto L17;
        if (r100.signatures.length != 1) goto L17;
        int r102 = 0;
    L11:
        Signature[] r103 = this.pastSigningCertificates;
        if (r102 >= (r103.length - 1)) goto L17;
        if (r103[r102].equals(r100.signatures[r102]) == true) goto L15;
        r102 = r102 + 1;
        goto L11
    L15:
        return true;
    L17:
        return false;
    }

    public boolean hasAncestorOrSelf(SigningDetails r100) {
        SigningDetails r101 = UNKNOWN;
        if (this == r101) goto L12;
        if (r100 == r101) goto L12;
        Signature[] r102 = r100.signatures;
        if (r102.length <= 1) goto L11;
        return signaturesMatchExactly(r100);
    L11:
        return hasCertificate(r102[0]);
    L12:
        return false;
    }

    public boolean hasCertificate(byte[] r100) {
        return hasCertificate(new Signature(r100));
    }

    public boolean signaturesMatchExactly(SigningDetails r100) {
        return areExactMatch(this.signatures, r100.signatures);
    }

    public boolean hasCertificate(Signature r100) {
        return hasCertificateInternal(r100, 0);
    }

    public SigningDetails(Signature[] r100, int r101) throws CertificateException {
        this(r100, r101, null, null);
    }

    public static boolean areEffectiveMatch(Signature[] r100, Signature[] r101) throws CertificateException {
        CertificateFactory r102 = CertificateFactory.getInstance("X.509");
        Signature[] r103 = new Signature[r100.length];
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r105 >= r100.length) goto L6;
        r103[r105] = bounce(r102, r100[r105]);
        r105 = r105 + 1;
        goto L4
    L6:
        Signature[] r106 = new Signature[r101.length];
    L8:
        if (r104 >= r101.length) goto L11;
        r106[r104] = bounce(r102, r101[r104]);
        r104 = r104 + 1;
        goto L8
    L11:
        return areExactMatch(r103, r106);
    }

    public static boolean areExactMatch(Signature[] r100, Signature[] r101) {
        if (r100.length == r101.length) goto L5;
    L9:
        return false;
    L5:
        if (ArrayUtils.containsAll(r100, r101) == false) goto L9;
        if (ArrayUtils.containsAll(r101, r100) == false) goto L9;
        return true;
    }

    public static Signature bounce(CertificateFactory r100, Signature r101) throws CertificateException {
        Signature r102 = new Signature(((X509Certificate) r100.generateCertificate(new ByteArrayInputStream(r101.toByteArray()))).getEncoded());
        int r103 = r102.toByteArray().length;
        int r104 = r101.toByteArray().length;
        if (Math.abs(r103 - r104) > 2) goto L6;
        return r102;
    L6:
        throw new CertificateException("Bounced cert length looks fishy; before " + r104 + ", after " + r103);
    }

    private boolean hasCertificateInternal(Signature r100, int r101) {
        if (this != UNKNOWN) goto L6;
        return false;
    L6:
        if (hasPastSigningCertificates() == false) goto L17;
        int r102 = 0;
    L8:
        Signature[] r103 = this.pastSigningCertificates;
        if (r102 >= (r103.length - 1)) goto L17;
        if (r103[r102].equals(r100) == false) goto L16;
        if (r101 == 0) goto L15;
        if ((this.pastSigningCertificatesFlags[r102] & r101) != r101) goto L16;
    L15:
        return true;
    L16:
        r102 = r102 + 1;
    L17:
        Signature[] r104 = this.signatures;
        if (r104.length == 1) goto L20;
        return false;
    L20:
        if (r104[0].equals(r100) == false) goto L29;
        return true;
    L29:
        return false;
    }

    public boolean checkCapability(SigningDetails r100, int r101) {
        SigningDetails r102 = UNKNOWN;
        if (this == r102) goto L12;
        if (r100 == r102) goto L12;
        Signature[] r103 = r100.signatures;
        if (r103.length <= 1) goto L11;
        return signaturesMatchExactly(r100);
    L11:
        return hasCertificate(r103[0], r101);
    L12:
        return false;
    }

    public boolean checkCapabilityRecover(SigningDetails r100, int r101) throws CertificateException {
        SigningDetails r102 = UNKNOWN;
        if (r100 == r102) goto L22;
        if (this == r102) goto L22;
        if (hasPastSigningCertificates() == false) goto L21;
        if (r100.signatures.length != 1) goto L21;
        int r103 = 0;
    L11:
        Signature[] r104 = this.pastSigningCertificates;
        if (r103 >= r104.length) goto L19;
        if (areEffectiveMatch(r100.signatures[0], r104[r103]) == false) goto L18;
        if (this.pastSigningCertificatesFlags[r103] != r101) goto L18;
        return true;
    L18:
        r103 = r103 + 1;
        goto L11
    L19:
        return false;
    L21:
        return areEffectiveMatch(r100.signatures, this.signatures);
    L22:
        return false;
    }

    public boolean hasCertificate(Signature r100, int r101) {
        return hasCertificateInternal(r100, r101);
    }

    public static boolean areEffectiveMatch(Signature r100, Signature r101) throws CertificateException {
        CertificateFactory r102 = CertificateFactory.getInstance("X.509");
        return bounce(r102, r100).equals(bounce(r102, r101));
    }

    public SigningDetails(Signature[] r100, int r101, Signature[] r102, int[] r110) throws CertificateException {
        this(r100, r101, toSigningKeys(r100), r102, r110);
    }

    public SigningDetails(Signature[] r100, int r101, ArraySet<PublicKey> r102, Signature[] r103, int[] r104) {
        this.signatures = r100;
        this.signatureSchemeVersion = r101;
        this.publicKeys = r102;
        this.pastSigningCertificates = r103;
        this.pastSigningCertificatesFlags = r104;
    }
}
