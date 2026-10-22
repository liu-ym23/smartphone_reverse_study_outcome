package zh5;

import com.bytedance.ee.bear.middleground.permission.permsdkimpl.offline.OfflinePermissionModel;
import com.google.gson.Gson;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes18.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground.permission.permsdkimpl.offline.a f572188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<OfflinePermissionModel> f572189b;

    public a(com.bytedance.ee.bear.middleground.permission.permsdkimpl.offline.a r100, Ref.ObjectRef<OfflinePermissionModel> r101) {
        this.f572188a = r100;
        this.f572189b = r101;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        String r101 = (String) r100;
        com.bytedance.ee.bear.middleground.permission.permsdkimpl.offline.a r102 = this.f572188a;
        OfflinePermissionModel r103 = this.f572189b.element;
        r102.getClass();
        String r104 = new Gson().toJson(r103, OfflinePermissionModel.class);     // Catch: Throwable -> L5
        com.ss.android.lark.storage.kv.repo.a r105 = ay4.b.d("permission_offline", 6);     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L5
        r105.putString("cache_data", du5.b.e(r104));     // Catch: Throwable -> L5
        tt5.a.h("PermissionOfflineCache", "writeToCache finish");     // Catch: Throwable -> L5
        return "success";
    L5:
        th = move-exception;
        tt5.a.d("PermissionOfflineCache", "writeToCache error " + th.getMessage());
        return "success";
    }
}
