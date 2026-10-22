package org.bouncycastle.jcajce.provider.symmetric.util;

import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.cms.GCMParameters;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes42.dex */
public class GcmSpecUtil {
    static final Class gcmSpecClass = null;

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    static final Method f525382iv = null;
    static final Method tLen = null;

    static {
        Class r100 = ClassUtil.loadClass(GcmSpecUtil.class, "javax.crypto.spec.GCMParameterSpec");
        gcmSpecClass = r100;
        if (r100 == null) goto L5;
        tLen = extractMethod("getTLen");
        Method r101 = extractMethod("getIV");
    L6:
        f525382iv = r101;
        return;
    L5:
        r101 = null;
        tLen = null;
        goto L6
    }

    public GcmSpecUtil() {
    }

    public static AEADParameters extractAeadParameters(final KeyParameter r100, final AlgorithmParameterSpec r101) throws InvalidAlgorithmParameterException {
        return (AEADParameters) AccessController.doPrivileged(new AnonymousClass2(r100, r101));
    L5:
        throw new InvalidAlgorithmParameterException("Cannot process GCMParameterSpec.");
    }

    public static GCMParameters extractGcmParameters(final AlgorithmParameterSpec r100) throws InvalidParameterSpecException {
        return (GCMParameters) AccessController.doPrivileged(new AnonymousClass3(r100));
    L5:
        throw new InvalidParameterSpecException("Cannot process GCMParameterSpec");
    }

    public static AlgorithmParameterSpec extractGcmSpec(ASN1Primitive r100) throws InvalidParameterSpecException {
        GCMParameters r101 = GCMParameters.getInstance(r100);     // Catch: Exception -> L4 NoSuchMethodException -> L7
        return (AlgorithmParameterSpec) gcmSpecClass.getConstructor(new Class[]{Integer.TYPE, byte[].class}).newInstance(new Object[]{Integers.valueOf(r101.getIcvLen() * 8), r101.getNonce()});
    L4:
        e = move-exception;
        throw new InvalidParameterSpecException("Construction failed: " + e.getMessage());
    L8:
        throw new InvalidParameterSpecException("No constructor found!");
    }

    private static Method extractMethod(final String r100) {
        return (Method) AccessController.doPrivileged(new AnonymousClass1(r100));
    L4:
        return null;
    }

    public static boolean gcmSpecExists() {
        if (gcmSpecClass == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isGcmSpec(Class r100) {
        if (gcmSpecClass != r100) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isGcmSpec(AlgorithmParameterSpec r100) {
        Class r101 = gcmSpecClass;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.isInstance(r100) == false) goto L7;
        return true;
    }
}
