package ie5;

import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static final com.bytedance.ee.bear.lark.dependency.k a = null;
    public static String b;

    static {
        int r0 = k.a;
        a = (com.bytedance.ee.bear.lark.dependency.k) k.a.a(com.bytedance.ee.bear.lark.dependency.k.class);
        b = "";
    }

    public static String a() {
        StringBuilder r0 = new StringBuilder();
        if (TextUtils.isEmpty(b) == false) goto L13;
        boolean r1 = a.isUsPackage();
        boolean r2 = eu5.c.a();
        if (r1 == false) goto L9;
        if (r2 == false) goto L8;
        String r3 = "https://tosv.byted.org/obj/gecko-internal-sg/";
    L12:
        b = r3;
        goto L13
    L8:
        r3 = "https://lf16-sourcecdn-tos.ibytedtos.com/obj/byte-gurd-source-sg/";
        goto L12
    L9:
        if (r2 == false) goto L11;
        r3 = "https://tosv.byted.org/obj/gecko-internal/";
        goto L12
    L11:
        r3 = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/";
    L13:
        r0.append(b);
        if (eu5.c.a() == false) goto L16;
        String r4 = "internal/ccm/lynx";
    L17:
        r0.append(r4);
        r0.append("/docs_lynx_channel");
        return r0.toString();
    L16:
        r4 = "online/ccm/lynx";
        goto L17
    }
}
