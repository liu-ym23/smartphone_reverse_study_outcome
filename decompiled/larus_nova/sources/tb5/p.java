package tb5;

import android.text.TextUtils;
import com.bytedance.ee.bear.jsbridge.Message;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes16.dex */
public final class p extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f545262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, g> f545263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f.b f545264c;

    public p() {
        com.bytedance.ee.bear.rn.o r100 = com.bytedance.ee.bear.rn.o.f236628a;
        this.f545262a = "RNBridge#" + Integer.toHexString(hashCode());
        this.f545263b = new ConcurrentHashMap();
        this.f545264c = r100;
    }

    public final void c(Message r100) {
        m r101 = a(r100.f227150a);     // Catch: Throwable -> L11
        String r102 = r100.f227154e;     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r102) == false) goto L6;
        com.ss.android.lark.officesdk.utils.di.j.b(this.f545262a, "handlerName is empty");     // Catch: Throwable -> L11
        g r103 = null;
    L7:
        if (r103 == null) goto L9;
        r103.a(r100.f227153d, r101);     // Catch: Throwable -> L11
        return;
    L9:
        com.ss.android.lark.officesdk.utils.di.j.f(this.f545262a, "dispatchMsgFromJS " + r100.f227154e);     // Catch: Throwable -> L11
        return;
    L6:
        r103 = (g) ((ConcurrentHashMap) this.f545263b).get(r102);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d(this.f545262a, th);
    }

    @Override // tb5.a
    public final void b(String r100, String r101) {
        Message r102 = new Message();
        r102.f227151b = r100;
        r102.f227152c = r101;
        f.b r103 = this.f545264c;
        if (r103 == null) goto L6;
        r103.b(r102.b());
        return;
    }
}
