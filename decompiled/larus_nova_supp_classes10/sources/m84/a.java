package m84;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.d;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements BDLocationCallback {
    public final /* synthetic */ BDLocationCallback a;

    public a() {
        this.a = null;
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public final void onError(BDLocationException r2) {
        BDLocationCallback r0 = this.a;
        if (r0 == null) goto L6;
        r0.onError(r2);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public final void onLocationChanged(BDLocation r20) {
        ArrayList r1 = new ArrayList();
        Object[] r2 = {r20};
        f06.b r12 = new f06.b();
        g06.a r3 = (g06.a) ApiHookConfig.b.get(101330);
        if (r3 == null) goto L5;
        f06.a[] r4 = r3.i;
    L6:
        f06.a[] r10 = r4;
        int r9 = r10.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r10[r8];
        int r16 = r8;
        int r17 = r9;
        f06.a[] r18 = r10;
        d r5 = r7.preInvoke(101330, "com/bytedance/bdlocation_impl/utils/LocationImplUtil$1", "onLocationChanged", this, r2, "void", r12);     // Catch: Exception -> L23
        if (r5.a == true) goto L17;
        r1.add(r7);     // Catch: Exception -> L23
    L17:
        if (r5.a == false) goto L19;
        return;
    L19:
        BDLocationCallback r6 = this.a;
        if (r6 == null) goto L29;
        r6.onLocationChanged(r20);
        return;
    L29:
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        r10 = r18;
        goto L8
    L15:
        r5 = new d(false, null);
        goto L17
    L5:
        r4 = ApiHookConfig.d;
        goto L6
    }
}
