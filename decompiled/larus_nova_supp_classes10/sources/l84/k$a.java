package l84;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class k$a implements BDLocationCallback {
    public final /* synthetic */ BDLocation[] a;
    public final /* synthetic */ CountDownLatch b;
    public final /* synthetic */ BDLocationException[] c;

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public final void onError(BDLocationException r3) {
        this.c[0] = r3;
        this.b.countDown();
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public final void onLocationChanged(BDLocation r20) {
        ArrayList r9 = new ArrayList();
        Object[] r10 = {r20};
        f06.b r12 = new f06.b();
        g06.a r0 = (g06.a) ApiHookConfig.b.get(101330);
        if (r0 == null) goto L5;
        f06.a[] r1 = r0.i;
    L6:
        f06.a[] r7 = r1;
        int r6 = r7.length;
        int r5 = 0;
    L8:
        if (r5 >= r6) goto L15;
        f06.a r4 = r7[r5];
        int r16 = r5;
        int r17 = r6;
        f06.a[] r18 = r7;
        f06.d r2 = r4.preInvoke(101330, "com/bytedance/bdlocation_impl/service/BDLocationService$1", "onLocationChanged", this, r10, "void", r12);     // Catch: Exception -> L21
        if (r2.a == true) goto L12;
        r9.add(r4);     // Catch: Exception -> L21
        goto L14
    L12:
        char r3 = 0;
    L17:
        if (r2.a == false) goto L19;
        return;
    L19:
        this.a[r3] = r20;
        this.b.countDown();
        return;
    L14:
        r5 = r16 + 1;
        r6 = r17;
        r7 = r18;
        goto L8
    L15:
        r3 = 0;
        r2 = new f06.d(false, null);
        goto L17
    L5:
        r1 = ApiHookConfig.d;
        goto L6
    }

    public k$a(BDLocation[] r1, CountDownLatch r2, BDLocationException[] r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
