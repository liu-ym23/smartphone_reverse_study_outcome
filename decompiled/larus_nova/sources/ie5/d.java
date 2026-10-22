package ie5;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.ee.bear.lark.dependency.k f489478a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f489479b;

    static {
        int r100 = k.f489487a;
        f489478a = (com.bytedance.ee.bear.lark.dependency.k) k.a.a(com.bytedance.ee.bear.lark.dependency.k.class);
        f489479b = "";
    }

    public static String a() {
        StringBuilder r100 = new StringBuilder();
        if (TextUtils.isEmpty(f489479b) == false) goto L13;
        boolean r101 = f489478a.isUsPackage();
        boolean r102 = eu5.c.a();
        if (r101 == false) goto L9;
        if (r102 == false) goto L8;
        String r103 = "https://tosv.byted.org/obj/gecko-internal-sg/";
    L12:
        f489479b = r103;
        goto L13
    L8:
        r103 = "https://lf16-sourcecdn-tos.ibytedtos.com/obj/byte-gurd-source-sg/";
        goto L12
    L9:
        if (r102 == false) goto L11;
        r103 = "https://tosv.byted.org/obj/gecko-internal/";
        goto L12
    L11:
        r103 = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/";
    L13:
        r100.append(f489479b);
        if (eu5.c.a() == false) goto L16;
        String r104 = "internal/ccm/lynx";
    L17:
        r100.append(r104);
        r100.append("/docs_lynx_channel");
        return r100.toString();
    L16:
        r104 = "online/ccm/lynx";
        goto L17
    }
}
