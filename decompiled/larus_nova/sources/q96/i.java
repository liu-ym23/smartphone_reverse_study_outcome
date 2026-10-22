package q96;

import com.bytedance.kmp.crypto.PaddingModeRsa;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f532119a = null;

    static {
        int[] r100 = new int[PaddingModeRsa.values().length];
        r100[PaddingModeRsa.PKCS1Padding.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r100[PaddingModeRsa.OAEPWithSHA1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r100[PaddingModeRsa.OAEPWithSHA256.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        f532119a = r100;
    }
}
