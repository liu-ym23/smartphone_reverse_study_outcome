package com.bytedance.kmp.crypto;

import com.baidu.bbalbscesium.k.d.c;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/kmp/crypto/PaddingModeRsa;", "", "(Ljava/lang/String;I)V", c.f30370p, "OAEPWithSHA1", "OAEPWithSHA256", "bytecrypto-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum PaddingModeRsa extends Enum<PaddingModeRsa> {
    public static final PaddingModeRsa OAEPWithSHA1 = null;
    public static final PaddingModeRsa OAEPWithSHA256 = null;
    public static final PaddingModeRsa PKCS1Padding = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PaddingModeRsa[] f251233a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f251234b = null;

    public static EnumEntries<PaddingModeRsa> getEntries() {
        return f251234b;
    }

    public static PaddingModeRsa valueOf(String r100) {
        return (PaddingModeRsa) a.a(PaddingModeRsa.class, r100);
    }

    public static PaddingModeRsa[] values() {
        return (PaddingModeRsa[]) f251233a.clone();
    }

    static {
        PaddingModeRsa r100 = new PaddingModeRsa(c.f30370p, 0);
        PKCS1Padding = r100;
        PaddingModeRsa r101 = new PaddingModeRsa("OAEPWithSHA1", 1);
        OAEPWithSHA1 = r101;
        PaddingModeRsa r102 = new PaddingModeRsa("OAEPWithSHA256", 2);
        OAEPWithSHA256 = r102;
        PaddingModeRsa[] r103 = {r100, r101, r102};
        f251233a = r103;
        f251234b = EnumEntriesKt.enumEntries(r103);
    }

    public PaddingModeRsa(String r100, int r101) {
        super(r100, r101);
    }
}
