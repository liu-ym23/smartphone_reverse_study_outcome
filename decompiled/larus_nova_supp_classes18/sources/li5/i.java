package li5;

import com.bytedance.ee.bear.basesdk.apiimpl.b2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.middleground_permission_export.model.j a;

    public i(b2 r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        tt5.a.e("DocPermissionManager", "removeUserPermission error:", r5, false);
        this.a.b(r5);
    }
}
