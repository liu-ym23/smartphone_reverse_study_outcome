package s25;

import com.bytedance.ee.bear.contract.n;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.monitor.callback.CpuCallbackManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements Runnable {
    public final /* synthetic */ ArrayList<String> a;
    public final /* synthetic */ e b;

    public static final class a implements CpuCallbackManager.d {
        public final /* synthetic */ ArrayList<String> a;
        public final /* synthetic */ e b;

        public a(ArrayList<String> r1, e r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onIdle() {
            List r0 = CollectionsKt.toMutableList(this.a);
            int r3 = 0;
            if (r0.size() <= this.b.a.getDocs_feed_push_preload_limit()) goto L5;
            r0 = r0.subList(0, this.b.a.getDocs_feed_push_preload_limit());
        L5:
            int r1 = r0.size();
        L6:
            if (r3 >= r1) goto L8;
            ListProtector.set(r0, r3, av5.c.a((String) ListProtector.get(r0, r3), "from=docs_feed_push"));
            r3 = r3 + 1;
            goto L6
        L8:
            List r2 = r0;
            ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
            Iterator r5 = r2.iterator();
        L10:
            if (r5.hasNext() == false) goto L12;
            String r6 = (String) r5.next();
            String r7 = p.a().v8(r6);
            BearUrl r8 = p.a().Z(r7);
            r4.add(new OfflineDoc(r8.b, r7, sbb.e.g(r8.a), r8.h));
            goto L10
        L12:
            ((n) org.koin.java.a.c(n.class, null, null, 6)).g(r4);
        }
    }

    public g(ArrayList<String> r1, e r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CpuCallbackManager.a().b(new a(this.a, this.b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
