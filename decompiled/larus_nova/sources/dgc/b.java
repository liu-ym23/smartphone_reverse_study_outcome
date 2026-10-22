package dgc;

import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes38.dex */
public final class b {
    public static final String a(String r100) {
        return r100.replaceAll("\"", "&quot;").replaceAll("'", "&apos").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("&", "&amp;");
    }

    public static final String b(String r100, XmlPullParser r101) {
        int r102 = r101.getAttributeCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r101.getAttributeName(r103).equals(r100) == true) goto L7;
        r103 = r103 + 1;
        goto L3
    L7:
        return r101.getAttributeValue(r103);
    L9:
        return null;
    }
}
