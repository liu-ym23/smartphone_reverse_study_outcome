package s25;

import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.n;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import k25.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    public final void accept(Object r16) {
        Boolean r17 = (Boolean) r16;
        a r18 = this.a;
        r18.getClass();
        tt5.a.h("DBPreloadManager", "preloadDocxWithClientVarsWithoutSSR");
        AccountService$Account r0 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        int r4 = r18.a.getDocx_ssr_preload_count();
        long r5 = r18.a.getDocx_ssr_preload_uptime();
        int r19 = r18.a.getDocx_ssr_preload_look_db_limit();
        tt5.a.h("DBPreloadManager", "ssrPreloadCount: " + r4 + ", ssrPreloadUptime: " + r5 + ", ssrPreloadLookDbLimitCount: " + r19);
        e0 r7 = e0.m();
        long r9 = System.currentTimeMillis() - r5;
        r7.getClass();
        ArrayList r13 = new ArrayList();
        List<String> r110 = r7.q().e().g(r19, r0.tenantId + OfflineDoc.DASH_DELIMITER + r0.uid + "_CLIENT_VARS", n35.a.b(r0, sbb.e.o.getType(), new HashMap()), r9, r4);     // Catch: Exception -> L11
        if (hu5.a.d(r110) == true) goto L9;
        StringBuilder r1 = new StringBuilder("preloadSsrTokens: ");     // Catch: Exception -> L11
        ArrayList r6 = (ArrayList) r110;     // Catch: Exception -> L11
        r1.append(r6.size());     // Catch: Exception -> L11
        tt5.a.h("OfflineDataManager", r1.toString());     // Catch: Exception -> L11
        int r2 = Math.min(r6.size(), r4);     // Catch: Exception -> L11
        int r8 = 0;
    L7:
        if (r8 >= r2) goto L14;
        r13.add(new OfflineDoc((String) ListProtector.get(r110, r8), "", sbb.e.o.b, DocsOpenSource.db_preload.name()));     // Catch: Exception -> L11
        r8 = r8 + 1;     // Catch: Exception -> L11
    L14:
        if (hu5.a.d(r13) == true) goto L16;
        tt5.a.h("DBPreloadManager", "preload ssr from db size: " + r13.size());
        ((n) org.koin.java.a.c(n.class, null, null, 6)).n(r13);
        return;
    L16:
        tt5.a.h("DBPreloadManager", "no db ssr preload.");
        return;
    L9:
        tt5.a.h("OfflineDataManager", "preloadSsrTokens is empty.");     // Catch: Exception -> L11
    L11:
        e = move-exception;
        iu5.d.c(new Exception("loadDocxWithClientVarsWithoutSSR", e));
        goto L14
    }
}
