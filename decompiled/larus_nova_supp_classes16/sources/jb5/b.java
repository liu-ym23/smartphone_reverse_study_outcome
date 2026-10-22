package jb5;

import com.bytedance.ee.bear.basesdk.apisupport.w;
import com.bytedance.ee.bear.lark.dependency.v;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {

    public class a implements Runnable {
        public final /* synthetic */ x18.b a;
        public final /* synthetic */ String b;
        public final /* synthetic */ List c;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.b(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(x18.b r1, String r2, List r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static a28.a a(String r3, String r4, String r5) {
        a28.a.a r0 = new a28.a.a();
        r0.a(r5);
        r0.d("/");
        r0.g = true;
        r0.b(253402300799999L);
        r0.c(r4);
        r0.e(r3);
        return new a28.a(r0);
    }

    public static void b(String r4, String r5, List<String> r6) {
        x18.b r0 = ((v) org.koin.java.a.a(v.class)).getLarkHttpClient();
        if (r0 != null) goto L5;
        return;
    L5:
        ArrayList r1 = new ArrayList();
        Iterator r7 = ((ArrayList) r6).iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        String r2 = (String) r7.next();
        r1.add(a(r5, "bear-session", r2));
        r1.add(a(r5, "session", r2));
        goto L7
    L9:
        CoreThreadPool.getBackgroundHandler().post(new a(r0, r4, r1));
    }

    public static void c(String r3, String r4, List<String> r5, List<String> r6) {
        if (r6 != null) goto L4;
    L8:
        b(r3, r4, r5);
        return;
    L4:
        if (r6.isEmpty() == true) goto L8;
        ArrayList r0 = (ArrayList) r5;
        r0.addAll(r6);
        if (w.c() == false) goto L8;
        ArrayList r7 = new ArrayList(r5);
        tt5.a.h("CookieStorage", "setHistoryDomains()... domainList = " + r7);
        p.a().F6(r7);
        tt5.a.h("CookieStorage", "set history domains  : " + Arrays.toString(r0.toArray()));
        goto L8
    }
}
