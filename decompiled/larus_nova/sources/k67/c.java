package k67;

import com.bytedance.privacy.exception.BdPrivacyException;

/* JADX INFO: loaded from: classes21.dex */
public final class c {
    public static void b(String r100, Object r101) throws BdPrivacyException {
        if (r101 == null) goto L5;
        return;
    L5:
        throw new BdPrivacyException(r100.concat(" is null"), -2);
    }

    public static void a(String r100, String r101, int r102) throws BdPrivacyException {
        b(r100, r101);
        if (r101.isEmpty() == true) goto L10;
        if (r101.length() > r102) goto L8;
        return;
    L8:
        throw new BdPrivacyException(r100 + " exceeds max length " + r102, -3);
    L10:
        throw new BdPrivacyException(r100.concat(" is empty"), -3);
    }
}
