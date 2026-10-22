package uc5;

import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g1 {
    public static ArrayList<String> a(List<Document> r3) {
        ArrayList<String> r0 = new ArrayList();
        if (hu5.a.d(r3) == false) goto L5;
        return r0;
    L5:
        Iterator r4 = ((ArrayList) r3).iterator();
    L7:
        if (r4.hasNext() == false) goto L14;
        Document r1 = (Document) r4.next();
        if (r1 == null) goto L7;
        if (d(r1.c) == true) goto L7;
        r0.add(r1.c);
        goto L7
    L14:
        return r0;
    }

    public static boolean b(List<Document> r3) {
        if (hu5.a.d(r3) == false) goto L5;
        return false;
    L5:
        Iterator r4 = ((ArrayList) r3).iterator();
    L7:
        if (r4.hasNext() == false) goto L14;
        Document r0 = (Document) r4.next();
        if (r0 == null) goto L7;
        if (r0.getType() != sbb.e.f.b) goto L7;
        return true;
    L14:
        return false;
    }

    public static Document c(List<Document> r3) {
        if (hu5.a.d(r3) == false) goto L5;
        return null;
    L5:
        Iterator<Document> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L13;
        Document r0 = r4.next();
        if (r0 == null) goto L7;
        if (r0.b() == false) goto L7;
        return r0;
    L13:
        return null;
    }

    public static boolean d(String r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }
}
