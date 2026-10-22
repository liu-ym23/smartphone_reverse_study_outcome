package zsc;

import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes41.dex */
public abstract class h {
    public static void b(uvc.b r100, uvc.b r101) {
        Text r102 = null;
        Text r103 = null;
        int r104 = 0;
    L3:
        if (r100 == null) goto L14;
        if ((r100 instanceof Text) == false) goto L10;
        r103 = (Text) r100;
        if (r102 != null) goto L9;
        r102 = r103;
    L9:
        r104 = r104 + r103.f525783h.length();
    L11:
        if (r100 == r101) goto L14;
        r100 = r100.f551904e;
        goto L3
    L10:
        a(r102, r103, r104);
        r102 = null;
        r103 = null;
        r104 = 0;
    L14:
        a(r102, r103, r104);
    }

    public static void a(Text r100, Text r101, int r102) {
        if (r100 == null) goto L11;
        if (r101 == null) goto L12;
        if (r100 == r101) goto L13;
        StringBuilder r103 = new StringBuilder(r102);
        r103.append(r100.f525783h);
        uvc.b r104 = r100.f551904e;
        uvc.b r105 = r101.f551904e;
    L6:
        if (r104 == r105) goto L8;
        r103.append(((Text) r104).f525783h);
        uvc.b r106 = r104.f551904e;
        r104.g();
        r104 = r106;
        goto L6
    L8:
        r100.f525783h = r103.toString();
        return;
    L13:
        return;
    L12:
        return;
    }
}
