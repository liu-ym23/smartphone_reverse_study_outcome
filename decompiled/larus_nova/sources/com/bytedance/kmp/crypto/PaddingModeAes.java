package com.bytedance.kmp.crypto;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/kmp/crypto/PaddingModeAes;", "", "(Ljava/lang/String;I)V", "PKCS5Padding", "PKCS7Padding", "NoPadding", "bytecrypto-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum PaddingModeAes extends Enum<PaddingModeAes> {
    public static final PaddingModeAes NoPadding = null;
    public static final PaddingModeAes PKCS5Padding = null;
    public static final PaddingModeAes PKCS7Padding = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PaddingModeAes[] f251231a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f251232b = null;

    public static EnumEntries<PaddingModeAes> getEntries() {
        return f251232b;
    }

    public static PaddingModeAes valueOf(String r100) {
        return (PaddingModeAes) a.a(PaddingModeAes.class, r100);
    }

    public static PaddingModeAes[] values() {
        return (PaddingModeAes[]) f251231a.clone();
    }

    static {
        PaddingModeAes r100 = new PaddingModeAes("PKCS5Padding", 0);
        PKCS5Padding = r100;
        PaddingModeAes r101 = new PaddingModeAes("PKCS7Padding", 1);
        PKCS7Padding = r101;
        PaddingModeAes r102 = new PaddingModeAes("NoPadding", 2);
        NoPadding = r102;
        PaddingModeAes[] r103 = {r100, r101, r102};
        f251231a = r103;
        f251232b = EnumEntriesKt.enumEntries(r103);
    }

    public PaddingModeAes(String r100, int r101) {
        super(r100, r101);
    }
}
