package ub5;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.jsbridge.v2.RNBridgeV2$getCallback$1;
import com.bytedance.ee.bear.jsbridge.v2.RNMessage;
import com.bytedance.ee.bear.rn.p;
import com.ss.android.lark.officesdk.utils.di.j;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import swb.o;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final String a;
    public final Map<String, i<Object>> b;
    public final Map<String, c<String>> c;

    /* JADX INFO: renamed from: ub5.a$a, reason: collision with other inner class name */
    public static final class C0307a {
    }

    static {
    }

    public a() {
        p r0 = p.a;
        this.a = "RNBridge#" + Integer.toHexString(hashCode());
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
    }

    public final void b(RNMessage r5) {
        final String r1 = r5.getCallbackID();     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r1) == true) goto L6;
        m r2 = new RNBridgeV2$getCallback$1(this, r1);     // Catch: Throwable -> L18
    L7:
        String r3 = r5.getApiName();     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r3) == false) goto L10;
        j.b(this.a, "handlerName is empty");     // Catch: Throwable -> L18
        i r4 = null;
    L11:
        if (r4 != null) goto L13;
        return;
    L13:
        if (r5.getData() != null) goto L15;
        String r6 = "";
    L16:
        r4.handle(r6, r2);     // Catch: Throwable -> L18
        return;
    L15:
        r6 = String.valueOf(r5.getData());     // Catch: Throwable -> L18
        goto L16
    L10:
        r4 = (i) ((ConcurrentHashMap) this.b).get(r3);     // Catch: Throwable -> L18
        goto L11
    L6:
        r2 = new b();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        j.c(this.a, "", th);
        o.a(this.a, th);
    }

    public static final void a(a r1, String r2, Object r3) {
        r1.getClass();
        p r4 = p.a;
        RNMessage r0 = new RNMessage();
        r0.setCallbackID(r2);
        r0.setData(r3);
        r4.b(JSON.toJSONString(r0));
    }
}
