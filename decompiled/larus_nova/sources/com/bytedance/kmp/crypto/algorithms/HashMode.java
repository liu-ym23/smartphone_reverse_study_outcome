package com.bytedance.kmp.crypto.algorithms;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/kmp/crypto/algorithms/HashMode;", "", "(Ljava/lang/String;I)V", "HmacMD5", "HmacSHA1", "HmacSHA256", "bytecrypto-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum HashMode extends Enum<HashMode> {
    public static final HashMode HmacMD5 = null;
    public static final HashMode HmacSHA1 = null;
    public static final HashMode HmacSHA256 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HashMode[] f251235a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f251236b = null;

    public static EnumEntries<HashMode> getEntries() {
        return f251236b;
    }

    public static HashMode valueOf(String r100) {
        return (HashMode) a.a(HashMode.class, r100);
    }

    public static HashMode[] values() {
        return (HashMode[]) f251235a.clone();
    }

    static {
        HashMode r100 = new HashMode("HmacMD5", 0);
        HmacMD5 = r100;
        HashMode r101 = new HashMode("HmacSHA1", 1);
        HmacSHA1 = r101;
        HashMode r102 = new HashMode("HmacSHA256", 2);
        HmacSHA256 = r102;
        HashMode[] r103 = {r100, r101, r102};
        f251235a = r103;
        f251236b = EnumEntriesKt.enumEntries(r103);
    }

    public HashMode(String r100, int r101) {
        super(r100, r101);
    }
}
