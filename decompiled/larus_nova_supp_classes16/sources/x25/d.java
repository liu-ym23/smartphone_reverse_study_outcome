package x25;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.offline.sync.h0;
import com.bytedance.ee.bear.document.offline.sync.preloadexecutor.subblock.SubBlockModel;
import com.bytedance.ee.bear.document.offline.sync.preloadexecutor.subblock.SubBlockType;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import k25.e0;
import org.json.JSONException;
import org.json.JSONObject;
import r25.j;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends j {
    public static CountDownLatch j;
    public final BlockingQueue<SubBlockModel> d;
    public a e;
    public final com.bytedance.ee.bear.rn.f f;
    public String g;
    public String h;
    public SubBlockModel i;

    public class a implements Runnable {
        public final /* synthetic */ d a;

        /* JADX INFO: Infinite loop detected, blocks: 8, insns: 0 */
        public final void a() {
        L6:
            this.a.h();     // Catch: Exception -> L4
            d r0 = this.a;     // Catch: Exception -> L4
            d.j(r0, (SubBlockModel) ((LinkedBlockingQueue) r0.d).take());     // Catch: Exception -> L4
        L4:
            e = move-exception;
            tt5.a.d("PreloadSubBlockExecutor", "Consumer  e: " + e);
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(d r1) {
            this.a = r1;
        }
    }

    public class b implements i<String> {
        public final /* synthetic */ d a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(d r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, m r5) {
            String r6 = (String) r4;
            if (r6 != null) goto L16;
            tt5.a.k("PreloadSubBlockExecutor", "PreloadCompleteHandler data == null");
            return;
        L16:
            JSONObject r1 = new JSONObject(r6);     // Catch: JSONException -> L13
            String r7 = r1.optString("objToken");     // Catch: JSONException -> L13
            String r2 = r1.optString("type");     // Catch: JSONException -> L13
            tt5.a.h("PreloadSubBlockExecutor", "PreloadCompleteHandler(): objToken  " + du5.b.g(r7) + "   type " + r2);     // Catch: JSONException -> L13
            SubBlockModel r8 = this.a.i;     // Catch: JSONException -> L13
            if (r8 != null) goto L8;
            return;
        L8:
            if (TextUtils.equals(r8.getObjToken(), r7) == true) goto L10;
            return;
        L10:
            if (TextUtils.equals(this.a.i.getSubBlockType().getSubBlockType(), r2) == false) goto L21;
            fo5.d.b().scheduleDirect(new e(this));     // Catch: JSONException -> L13
            d.j.countDown();     // Catch: JSONException -> L13
            return;
        L21:
            return;
        L13:
            e = move-exception;
            tt5.a.e("PreloadSubBlockExecutor", "PreloadCompleteHandler handle(): ", e, false);
        }
    }

    static {
        j = new CountDownLatch(1);
    }

    public d() {
        this.d = new LinkedBlockingQueue();
        this.f = (com.bytedance.ee.bear.rn.f) org.koin.java.a.a(com.bytedance.ee.bear.rn.f.class);
        ((com.bytedance.ee.bear.rn.j) org.koin.java.a.a(com.bytedance.ee.bear.rn.j.class)).d(new c(this)).subscribe();
    }

    public static void j(d r7, SubBlockModel r8) {
        r7.getClass();
        SubBlockType r2 = r8.getSubBlockType();     // Catch: Exception -> L20
        SubBlockType r3 = SubBlockType.COMMENTS_DATA;     // Catch: Exception -> L20
        if (r2 == r3) goto L6;
        SubBlockType r4 = r8.getSubBlockType();     // Catch: Exception -> L20
        SubBlockType r5 = SubBlockType.POLL_DATA;     // Catch: Exception -> L20
        if (r4 == r5) goto L11;
    L13:
        r7.i = r8;     // Catch: Exception -> L20
        tt5.a.b("PreloadSubBlockExecutor", "PreloadCompleteHandler(): consume  mSubBlockModel:  " + r7.i);     // Catch: Exception -> L20
        CountDownLatch r9 = new CountDownLatch(1);     // Catch: InterruptedException -> L16 Exception -> L20
        j = r9;     // Catch: InterruptedException -> L16 Exception -> L20
        r9.await(h0.j.longValue(), TimeUnit.SECONDS);     // Catch: InterruptedException -> L16 Exception -> L20
    L27:
        return;
    L16:
        e = move-exception;
        tt5.a.f("PreloadSubBlockExecutor", e, false);     // Catch: Exception -> L20
        return;
    L11:
        if (e0.m().s(r7.h, r8.getObjToken()) != null) goto L13;
        r7.f.b(String.valueOf(r8.getType()), r8.getObjToken(), r8.getDataToken(), r5.getSubBlockType());     // Catch: Exception -> L20
        goto L13
    L6:
        if (e0.m().s(r7.g, r8.getObjToken()) != null) goto L13;
        r7.f.b(String.valueOf(r8.getType()), r8.getObjToken(), r8.getDataToken(), r3.getSubBlockType());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        tt5.a.d("PreloadSubBlockExecutor", "consume()... e = " + e);
    }
}
