package li5;

import com.bytedance.ee.bear.basesdk.apiimpl.b2;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.middleground_permission_export.model.j a;

    public h(b2 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        SimpleRequestResult r3 = (SimpleRequestResult) r2;
        tt5.a.h("DocPermissionManager", "removeUserPermission succeed");
        this.a.c(-1);
    }
}
