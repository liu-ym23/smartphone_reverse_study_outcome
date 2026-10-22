package tb5;

import android.text.TextUtils;
import com.bytedance.ee.bear.jsbridge.Message;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class p extends a {
    public final String a;
    public final Map<String, g> b;
    public final f.b c;

    public p() {
        com.bytedance.ee.bear.rn.o r0 = com.bytedance.ee.bear.rn.o.a;
        this.a = "RNBridge#" + Integer.toHexString(hashCode());
        this.b = new ConcurrentHashMap();
        this.c = r0;
    }

    public final void c(Message r5) {
        m r1 = a(r5.a);     // Catch: Throwable -> L11
        String r2 = r5.e;     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r2) == false) goto L6;
        com.ss.android.lark.officesdk.utils.di.j.b(this.a, "handlerName is empty");     // Catch: Throwable -> L11
        g r3 = null;
    L7:
        if (r3 == null) goto L9;
        r3.a(r5.d, r1);     // Catch: Throwable -> L11
        return;
    L9:
        com.ss.android.lark.officesdk.utils.di.j.f(this.a, "dispatchMsgFromJS " + r5.e);     // Catch: Throwable -> L11
        return;
    L6:
        r3 = (g) ((ConcurrentHashMap) this.b).get(r2);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d(this.a, th);
    }

    @Override // tb5.a
    public final void b(String r2, String r3) {
        Message r0 = new Message();
        r0.b = r2;
        r0.c = r3;
        f.b r4 = this.c;
        if (r4 == null) goto L6;
        r4.b(r0.b());
        return;
    }
}
