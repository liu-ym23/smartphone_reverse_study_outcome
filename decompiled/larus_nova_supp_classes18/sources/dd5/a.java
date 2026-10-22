package dd5;

import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static ArrayList<Document> a(List<Document> r9, boolean r10) {
        if (r9 != null) goto L5;
        return null;
    L5:
        ArrayList<Document> r0 = new ArrayList(r9.size());
        Iterator<Document> r11 = r9.iterator();
    L7:
        if (r11.hasNext() == false) goto L24;
        Document r1 = r11.next();
        if (r10 == true) goto L23;
        if (r1 == null) goto L23;
        int r2 = r1.getType();
        long r3 = r1.G;
        boolean r5 = true;
        if (r2 == 0) goto L14;
    L18:
        boolean r4 = false;
    L19:
        if (r4 == true) goto L22;
        r5 = false;
    L22:
        if (r5 == true) goto L7;
    L14:
        if (r3 != 140) goto L16;
    L17:
        r4 = true;
        goto L19
    L16:
        if (r3 != 141) goto L18;
    L23:
        r0.add(r1);
        goto L7
    L24:
        return r0;
    }
}
