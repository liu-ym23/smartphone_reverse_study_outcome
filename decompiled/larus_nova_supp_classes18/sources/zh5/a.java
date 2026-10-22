package zh5;

import com.bytedance.ee.bear.middleground.permission.permsdkimpl.offline.OfflinePermissionModel;
import com.google.gson.Gson;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a<T, R> implements Function {
    public final /* synthetic */ com.bytedance.ee.bear.middleground.permission.permsdkimpl.offline.a a;
    public final /* synthetic */ Ref.ObjectRef<OfflinePermissionModel> b;

    public a(com.bytedance.ee.bear.middleground.permission.permsdkimpl.offline.a r1, Ref.ObjectRef<OfflinePermissionModel> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r4) {
        String r5 = (String) r4;
        com.bytedance.ee.bear.middleground.permission.permsdkimpl.offline.a r6 = this.a;
        OfflinePermissionModel r0 = (OfflinePermissionModel) this.b.element;
        r6.getClass();
        String r1 = new Gson().toJson(r0, OfflinePermissionModel.class);     // Catch: Throwable -> L5
        com.ss.android.lark.storage.kv.repo.a r2 = ay4.b.d("permission_offline", 6);     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L5
        r2.putString("cache_data", du5.b.e(r1));     // Catch: Throwable -> L5
        tt5.a.h("PermissionOfflineCache", "writeToCache finish");     // Catch: Throwable -> L5
        return "success";
    L5:
        th = move-exception;
        tt5.a.d("PermissionOfflineCache", "writeToCache error " + th.getMessage());
        return "success";
    }
}
