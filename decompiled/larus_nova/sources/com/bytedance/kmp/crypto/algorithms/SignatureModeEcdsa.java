package com.bytedance.kmp.crypto.algorithms;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/kmp/crypto/algorithms/SignatureModeEcdsa;", "", "(Ljava/lang/String;I)V", "SHA1withECDSA", "SHA224withECDSA", "SHA256withECDSA", "SHA384withECDSA", "SHA512withECDSA", "bytecrypto-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum SignatureModeEcdsa extends Enum<SignatureModeEcdsa> {
    public static final SignatureModeEcdsa SHA1withECDSA = null;
    public static final SignatureModeEcdsa SHA224withECDSA = null;
    public static final SignatureModeEcdsa SHA256withECDSA = null;
    public static final SignatureModeEcdsa SHA384withECDSA = null;
    public static final SignatureModeEcdsa SHA512withECDSA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SignatureModeEcdsa[] f251237a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f251238b = null;

    public static EnumEntries<SignatureModeEcdsa> getEntries() {
        return f251238b;
    }

    public static SignatureModeEcdsa valueOf(String r100) {
        return (SignatureModeEcdsa) a.a(SignatureModeEcdsa.class, r100);
    }

    public static SignatureModeEcdsa[] values() {
        return (SignatureModeEcdsa[]) f251237a.clone();
    }

    static {
        SignatureModeEcdsa r100 = new SignatureModeEcdsa("SHA1withECDSA", 0);
        SHA1withECDSA = r100;
        SignatureModeEcdsa r101 = new SignatureModeEcdsa("SHA224withECDSA", 1);
        SHA224withECDSA = r101;
        SignatureModeEcdsa r102 = new SignatureModeEcdsa("SHA256withECDSA", 2);
        SHA256withECDSA = r102;
        SignatureModeEcdsa r103 = new SignatureModeEcdsa("SHA384withECDSA", 3);
        SHA384withECDSA = r103;
        SignatureModeEcdsa r104 = new SignatureModeEcdsa("SHA512withECDSA", 4);
        SHA512withECDSA = r104;
        SignatureModeEcdsa[] r105 = {r100, r101, r102, r103, r104};
        f251237a = r105;
        f251238b = EnumEntriesKt.enumEntries(r105);
    }

    public SignatureModeEcdsa(String r100, int r101) {
        super(r100, r101);
    }
}
