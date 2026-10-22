package li5;

import com.bytedance.ee.bear.basesdk.apiimpl.b2;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground_permission_export.model.j f509365a;

    public h(b2 r100) {
        this.f509365a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        SimpleRequestResult r101 = (SimpleRequestResult) r100;
        tt5.a.h("DocPermissionManager", "removeUserPermission succeed");
        this.f509365a.c(-1);
    }
}
