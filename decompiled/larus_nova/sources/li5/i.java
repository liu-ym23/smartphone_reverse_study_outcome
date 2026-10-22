package li5;

import com.bytedance.ee.bear.basesdk.apiimpl.b2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground_permission_export.model.j f509366a;

    public i(b2 r100) {
        this.f509366a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        tt5.a.e("DocPermissionManager", "removeUserPermission error:", r101, false);
        this.f509366a.b(r101);
    }
}
