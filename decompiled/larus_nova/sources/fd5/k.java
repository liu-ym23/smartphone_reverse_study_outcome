package fd5;

import com.bytedance.ee.bear.list.dto.Document;

/* JADX INFO: loaded from: classes18.dex */
public final class k {

    public interface a {
        boolean z(String r100);
    }

    public static boolean a(String r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.length() == 0) goto L7;
        return false;
    }

    public static String c(Document r100) {
        if (a(r100.F) == true) goto L7;
        return r100.F;
    L7:
        if (r100.getType() == sbb.e.f541303n.f541317b) goto L9;
        return "";
    L9:
        if (r100.f227908y1 == sbb.e.f541301l.f541317b) goto L12;
        return "";
    L12:
        return com.bytedance.ee.bear.list.thumbnail.b.c(r100);
    }

    public static boolean b(Document r100, a r101) {
        int r102 = r100.getType();
        sbb.e r103 = sbb.e.f541301l;
        if (r102 != r103.f541317b) goto L5;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == true) goto L13;
    L25:
        return false;
    L13:
        if (a(r100.H) == false) goto L25;
        if (a(r100.f227895q) == true) goto L17;
    L20:
        boolean r105 = true;
    L21:
        if (r105 == false) goto L25;
        if (r101.z(c(r100)) == false) goto L25;
        return true;
    L17:
        if (a(r100.V0) == false) goto L20;
        r105 = false;
        goto L21
    L5:
        if (r100.getType() == sbb.e.f541303n.f541317b) goto L7;
    L9:
        r104 = false;
        goto L11
    L7:
        if (r100.f227908y1 != r103.f541317b) goto L9;
        goto L9
    }
}
