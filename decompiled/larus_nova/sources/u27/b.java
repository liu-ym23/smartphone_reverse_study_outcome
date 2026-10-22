package u27;

import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes21.dex */
public final /* synthetic */ class b {
    public static /* synthetic */ int a(String r100, int r101) {
        if (r100.length() > 1) goto L5;
    L7:
        long r102 = Long.parseLong(r100, r101);
        if ((BodyPartID.bodyIdMax & r102) != r102) goto L12;
        return (int) r102;
    L12:
        throw new NumberFormatException("Input " + r100 + " in base " + r101 + " is not in the range of an unsigned integer");
    L5:
        if (r100.charAt(0) != '+') goto L7;
        r100 = r100.substring(1);
        goto L7
    }
}
