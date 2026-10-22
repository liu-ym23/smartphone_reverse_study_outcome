package com.bytedance.kmp.crypto.algorithms;

import com.baidu.mapauto.auth.util.RSAUtil;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/kmp/crypto/algorithms/SignatureModeRsa;", "", "(Ljava/lang/String;I)V", "SHA1withRSA", RSAUtil.SIGNATURE_ALGORITHM, "SHA512withRSA", "bytecrypto-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum SignatureModeRsa extends Enum<SignatureModeRsa> {
    public static final SignatureModeRsa SHA1withRSA = null;
    public static final SignatureModeRsa SHA256withRSA = null;
    public static final SignatureModeRsa SHA512withRSA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SignatureModeRsa[] f251239a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f251240b = null;

    public static EnumEntries<SignatureModeRsa> getEntries() {
        return f251240b;
    }

    public static SignatureModeRsa valueOf(String r100) {
        return (SignatureModeRsa) a.a(SignatureModeRsa.class, r100);
    }

    public static SignatureModeRsa[] values() {
        return (SignatureModeRsa[]) f251239a.clone();
    }

    static {
        SignatureModeRsa r100 = new SignatureModeRsa("SHA1withRSA", 0);
        SHA1withRSA = r100;
        SignatureModeRsa r101 = new SignatureModeRsa(RSAUtil.SIGNATURE_ALGORITHM, 1);
        SHA256withRSA = r101;
        SignatureModeRsa r102 = new SignatureModeRsa("SHA512withRSA", 2);
        SHA512withRSA = r102;
        SignatureModeRsa[] r103 = {r100, r101, r102};
        f251239a = r103;
        f251240b = EnumEntriesKt.enumEntries(r103);
    }

    public SignatureModeRsa(String r100, int r101) {
        super(r100, r101);
    }
}
