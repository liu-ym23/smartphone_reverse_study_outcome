package dd5;

import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class a {
    public static ArrayList<Document> a(List<Document> r100, boolean r110) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList<Document> r101 = new ArrayList(r100.size());
        Iterator<Document> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L24;
        Document r103 = r102.next();
        if (r110 == true) goto L23;
        if (r103 == null) goto L23;
        int r104 = r103.getType();
        long r105 = r103.G;
        boolean r106 = true;
        if (r104 == 0) goto L14;
    L18:
        boolean r107 = false;
    L19:
        if (r107 == true) goto L22;
        r106 = false;
    L22:
        if (r106 == true) goto L7;
    L14:
        if (r105 != 140) goto L16;
    L17:
        r107 = true;
        goto L19
    L16:
        if (r105 != 141) goto L18;
    L23:
        r101.add(r103);
        goto L7
    L24:
        return r101;
    }
}
