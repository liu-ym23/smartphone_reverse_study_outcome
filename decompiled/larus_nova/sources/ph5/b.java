package ph5;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ErrorResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: classes18.dex */
public interface b {
    void a(String r100, String r101);

    void b(PermissionRequest r100, UserPermissionEntity r101, d r102);

    Flowable<String> c(String r100);

    PermissionRequest d(BaseEntity r100, String r101);

    ErrorResponse e(String r100, Integer r101, String r102, Throwable r103);

    PermissionResponse f(PermissionRequest r100, UserPermissionEntity r101);
}
