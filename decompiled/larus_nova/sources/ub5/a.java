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

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f549366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, i<Object>> f549367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, c<String>> f549368c;

    /* JADX INFO: renamed from: ub5.a$a, reason: collision with other inner class name */
    public static final class C7856a {
    }

    static {
    }

    public a() {
        p r100 = p.f236629a;
        this.f549366a = "RNBridge#" + Integer.toHexString(hashCode());
        this.f549367b = new ConcurrentHashMap();
        this.f549368c = new ConcurrentHashMap();
    }

    public final void b(RNMessage r100) {
        final String r101 = r100.getCallbackID();     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r101) == true) goto L6;
        m r102 = new RNBridgeV2$getCallback$1(this, r101);     // Catch: Throwable -> L18
    L7:
        String r103 = r100.getApiName();     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r103) == false) goto L10;
        j.b(this.f549366a, "handlerName is empty");     // Catch: Throwable -> L18
        i r104 = null;
    L11:
        if (r104 != null) goto L13;
        return;
    L13:
        if (r100.getData() != null) goto L15;
        String r105 = "";
    L16:
        r104.handle(r105, r102);     // Catch: Throwable -> L18
        return;
    L15:
        r105 = String.valueOf(r100.getData());     // Catch: Throwable -> L18
        goto L16
    L10:
        r104 = (i) ((ConcurrentHashMap) this.f549367b).get(r103);     // Catch: Throwable -> L18
        goto L11
    L6:
        r102 = new b();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        j.c(this.f549366a, "", th);
        o.a(this.f549366a, th);
    }

    public static final void a(a r100, String r101, Object r102) {
        r100.getClass();
        p r103 = p.f236629a;
        RNMessage r104 = new RNMessage();
        r104.setCallbackID(r101);
        r104.setData(r102);
        r103.b(JSON.toJSONString(r104));
    }
}
