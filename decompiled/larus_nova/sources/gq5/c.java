package gq5;

import com.ss.android.cert.manager.constants.EventConstant;
import java.util.HashMap;

/* JADX INFO: loaded from: classes18.dex */
public final class c {
    public static void a(String r100) {
        HashMap r101 = new HashMap();
        r101.put("source", r100);
        tt5.a.b("WikiReport", "client_enter_wiki" + r101);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("client_enter_wiki", r101);
    }

    public static void b(String r100, String r101, int r102, int r103, int r104) {
        HashMap r105 = new HashMap();
        r105.put("action", r100);
        r105.put(EventConstant.Key.MODULE, r101);
        if (r102 == (-1)) goto L5;
        r105.put("file_type", sbb.e.c(r102));
    L5:
        if (r103 < 0) goto L7;
        r105.put("count", Integer.valueOf(r103));
    L7:
        if (r104 < 0) goto L9;
        r105.put("index_id", Integer.valueOf(r104));
    L9:
        tt5.a.b("WikiReport", "client_wiki_home_workspace_operation" + r105);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("client_wiki_home_workspace_operation", r105);
    }
}
