package fd5;

import com.bytedance.ee.bear.list.dto.Document;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k {

    public interface a {
        boolean z(String r1);
    }

    public static boolean a(String r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    public static String c(Document r2) {
        if (a(r2.F) == true) goto L7;
        return r2.F;
    L7:
        if (r2.getType() == sbb.e.n.b) goto L9;
        return "";
    L9:
        if (r2.y1 == sbb.e.l.b) goto L12;
        return "";
    L12:
        return com.bytedance.ee.bear.list.thumbnail.b.c(r2);
    }

    public static boolean b(Document r5, a r6) {
        int r0 = r5.getType();
        sbb.e r1 = sbb.e.l;
        if (r0 != r1.b) goto L5;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L13;
    L25:
        return false;
    L13:
        if (a(r5.H) == false) goto L25;
        if (a(r5.q) == true) goto L17;
    L20:
        boolean r3 = true;
    L21:
        if (r3 == false) goto L25;
        if (r6.z(c(r5)) == false) goto L25;
        return true;
    L17:
        if (a(r5.V0) == false) goto L20;
        r3 = false;
        goto L21
    L5:
        if (r5.getType() == sbb.e.n.b) goto L7;
    L9:
        r2 = false;
        goto L11
    L7:
        if (r5.y1 != r1.b) goto L9;
        goto L9
    }
}
