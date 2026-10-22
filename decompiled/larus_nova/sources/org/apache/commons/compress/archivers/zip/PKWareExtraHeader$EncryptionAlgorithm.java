package org.apache.commons.compress.archivers.zip;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum PKWareExtraHeader$EncryptionAlgorithm extends Enum<PKWareExtraHeader$EncryptionAlgorithm> {
    private static final /* synthetic */ PKWareExtraHeader$EncryptionAlgorithm[] $VALUES = null;
    public static final PKWareExtraHeader$EncryptionAlgorithm AES128 = null;
    public static final PKWareExtraHeader$EncryptionAlgorithm AES192 = null;
    public static final PKWareExtraHeader$EncryptionAlgorithm AES256 = null;
    public static final PKWareExtraHeader$EncryptionAlgorithm DES = null;
    public static final PKWareExtraHeader$EncryptionAlgorithm RC2 = null;
    public static final PKWareExtraHeader$EncryptionAlgorithm RC2pre52 = null;
    public static final PKWareExtraHeader$EncryptionAlgorithm RC4 = null;
    public static final PKWareExtraHeader$EncryptionAlgorithm TripleDES168 = null;
    public static final PKWareExtraHeader$EncryptionAlgorithm TripleDES192 = null;
    public static final PKWareExtraHeader$EncryptionAlgorithm UNKNOWN = null;
    private static final Map<Integer, PKWareExtraHeader$EncryptionAlgorithm> codeToEnum = null;
    private final int code;

    static {
        int r100 = 0;
        PKWareExtraHeader$EncryptionAlgorithm r101 = new PKWareExtraHeader$EncryptionAlgorithm("DES", 0, 26113);
        DES = r101;
        PKWareExtraHeader$EncryptionAlgorithm r102 = new PKWareExtraHeader$EncryptionAlgorithm("RC2pre52", 1, 26114);
        RC2pre52 = r102;
        PKWareExtraHeader$EncryptionAlgorithm r103 = new PKWareExtraHeader$EncryptionAlgorithm("TripleDES168", 2, 26115);
        TripleDES168 = r103;
        PKWareExtraHeader$EncryptionAlgorithm r104 = new PKWareExtraHeader$EncryptionAlgorithm("TripleDES192", 3, 26121);
        TripleDES192 = r104;
        PKWareExtraHeader$EncryptionAlgorithm r105 = new PKWareExtraHeader$EncryptionAlgorithm("AES128", 4, 26126);
        AES128 = r105;
        PKWareExtraHeader$EncryptionAlgorithm r106 = new PKWareExtraHeader$EncryptionAlgorithm("AES192", 5, 26127);
        AES192 = r106;
        PKWareExtraHeader$EncryptionAlgorithm r110 = new PKWareExtraHeader$EncryptionAlgorithm("AES256", 6, 26128);
        AES256 = r110;
        PKWareExtraHeader$EncryptionAlgorithm r111 = new PKWareExtraHeader$EncryptionAlgorithm("RC2", 7, 26370);
        RC2 = r111;
        PKWareExtraHeader$EncryptionAlgorithm r112 = new PKWareExtraHeader$EncryptionAlgorithm("RC4", 8, 26625);
        RC4 = r112;
        PKWareExtraHeader$EncryptionAlgorithm r113 = new PKWareExtraHeader$EncryptionAlgorithm("UNKNOWN", 9, 65535);
        UNKNOWN = r113;
        $VALUES = new PKWareExtraHeader$EncryptionAlgorithm[]{r101, r102, r103, r104, r105, r106, r110, r111, r112, r113};
        HashMap r107 = new HashMap();
        PKWareExtraHeader$EncryptionAlgorithm[] r108 = values();
        int r109 = r108.length;
    L3:
        if (r100 >= r109) goto L5;
        PKWareExtraHeader$EncryptionAlgorithm r114 = r108[r100];
        r107.put(Integer.valueOf(r114.getCode()), r114);
        r100 = r100 + 1;
        goto L3
    L5:
        codeToEnum = Collections.unmodifiableMap(r107);
    }

    public static PKWareExtraHeader$EncryptionAlgorithm[] values() {
        return (PKWareExtraHeader$EncryptionAlgorithm[]) $VALUES.clone();
    }

    public int getCode() {
        return this.code;
    }

    public static PKWareExtraHeader$EncryptionAlgorithm getAlgorithmByCode(int r100) {
        return codeToEnum.get(Integer.valueOf(r100));
    }

    public static PKWareExtraHeader$EncryptionAlgorithm valueOf(String r100) {
        return (PKWareExtraHeader$EncryptionAlgorithm) a.a(PKWareExtraHeader$EncryptionAlgorithm.class, r100);
    }

    private PKWareExtraHeader$EncryptionAlgorithm(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
