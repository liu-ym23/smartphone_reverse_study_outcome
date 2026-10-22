package ow7;

import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes23.dex */
public final class c {
    public static void a(XmlSerializer r100, String r101, String r102) {
        if (r102 == null) goto L6;
        if (r100 == null) goto L7;
        r100.startTag(null, r101).text(r102).endTag(null, r101);
        return;
    L7:
        return;
    }
}
