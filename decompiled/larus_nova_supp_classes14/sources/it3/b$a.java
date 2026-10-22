package it3;

import bt3.b;
import com.bytedance.apm.d;
import com.bytedance.services.slardar.config.IResponseConfigListener;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mt3.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class b$a implements j {

    public class a implements Runnable {
        public final /* synthetic */ JSONObject a;

        @Override // java.lang.Runnable
        public final void run() {
            JSONObject r0 = this.a;     // Catch: Throwable -> L9
            List r1 = c.a;     // Catch: Throwable -> L9
            if (r1 == null) goto L12;
            Iterator r2 = ((CopyOnWriteArrayList) r1).iterator();     // Catch: Throwable -> L9
        L6:
            if (r2.hasNext() == false) goto L19;
            ((IResponseConfigListener) r2.next()).onResponse(r0);     // Catch: Throwable -> L9
            goto L6
        L19:
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }

        public a(JSONObject r1) {
            this.a = r1;
        }
    }

    public b$a() {
    }

    public final void onResponse(JSONObject r3) {
        if (d.k() == true) goto L5;
        return;
    L5:
        b.d.a.e(new a(r3));
    }
}
