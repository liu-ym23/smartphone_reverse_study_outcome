package ph5;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ErrorResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface b {
    void a(String r1, String r2);

    void b(PermissionRequest r1, UserPermissionEntity r2, d r3);

    Flowable<String> c(String r1);

    PermissionRequest d(BaseEntity r1, String r2);

    ErrorResponse e(String r1, Integer r2, String r3, Throwable r4);

    PermissionResponse f(PermissionRequest r1, UserPermissionEntity r2);
}
