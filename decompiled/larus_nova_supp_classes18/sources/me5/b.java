package me5;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.network.ResponseJsonResult;
import com.bytedance.ies.xbridge.utils.j;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ j66.a.a b;

    public b(a r1, j66.a.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        ResponseJsonResult r6 = (ResponseJsonResult) r5;
        a r0 = this.a;
        Intrinsics.checkNotNull(r6);
        j66.a.a r1 = this.b;
        r0.getClass();
        String r2 = ((Result) r6).msg;
        tt5.a.h("ccm-lynx: CCMNetRequestMethod", "callbackRequestSuccess msg: " + r2);
        k66.b r3 = new k66.b();
        r3.a = 200;
        int r4 = j.a;
        r3.b = j.b(r6.getResponseJson());
        Intrinsics.checkNotNull(r2);
        r1.a(r3, r2);
    }
}
