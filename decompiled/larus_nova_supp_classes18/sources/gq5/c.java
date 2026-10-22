package gq5;

import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static void a(String r3) {
        HashMap r0 = new HashMap();
        r0.put("source", r3);
        tt5.a.b("WikiReport", "client_enter_wiki" + r0);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("client_enter_wiki", r0);
    }

    public static void b(String r2, String r3, int r4, int r5, int r6) {
        HashMap r0 = new HashMap();
        r0.put("action", r2);
        r0.put("module", r3);
        if (r4 == (-1)) goto L5;
        r0.put("file_type", sbb.e.c(r4));
    L5:
        if (r5 < 0) goto L7;
        r0.put("count", Integer.valueOf(r5));
    L7:
        if (r6 < 0) goto L9;
        r0.put("index_id", Integer.valueOf(r6));
    L9:
        tt5.a.b("WikiReport", "client_wiki_home_workspace_operation" + r0);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("client_wiki_home_workspace_operation", r0);
    }
}
