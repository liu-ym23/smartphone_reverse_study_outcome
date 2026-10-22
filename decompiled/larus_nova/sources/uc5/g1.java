package uc5;

import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class g1 {
    public static ArrayList<String> a(List<Document> r100) {
        ArrayList<String> r101 = new ArrayList();
        if (hu5.a.d(r100) == false) goto L5;
        return r101;
    L5:
        Iterator r102 = ((ArrayList) r100).iterator();
    L7:
        if (r102.hasNext() == false) goto L14;
        Document r103 = (Document) r102.next();
        if (r103 == null) goto L7;
        if (d(r103.f227872c) == true) goto L7;
        r101.add(r103.f227872c);
        goto L7
    L14:
        return r101;
    }

    public static boolean b(List<Document> r100) {
        if (hu5.a.d(r100) == false) goto L5;
        return false;
    L5:
        Iterator r101 = ((ArrayList) r100).iterator();
    L7:
        if (r101.hasNext() == false) goto L14;
        Document r102 = (Document) r101.next();
        if (r102 == null) goto L7;
        if (r102.getType() != sbb.e.f541295f.f541317b) goto L7;
        return true;
    L14:
        return false;
    }

    public static Document c(List<Document> r100) {
        if (hu5.a.d(r100) == false) goto L5;
        return null;
    L5:
        Iterator<Document> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        Document r102 = r101.next();
        if (r102 == null) goto L7;
        if (r102.b() == false) goto L7;
        return r102;
    L13:
        return null;
    }

    public static boolean d(String r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.length() == 0) goto L7;
        return false;
    }
}
