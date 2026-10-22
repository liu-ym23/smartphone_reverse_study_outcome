package yh5;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface c {
    void a(PermissionRequest r1, i r2);

    PermissionResponse b(PermissionRequest r1, UserPermissionEntity r2);
}
