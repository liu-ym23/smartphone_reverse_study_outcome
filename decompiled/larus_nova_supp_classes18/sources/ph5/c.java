package ph5;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface c {
    FileBizDomain a(BizDomain r1);

    PermissionRequest b(String r1);

    String c(int r1);

    boolean d(PermissionResponse r1);

    boolean e(PermissionResponse r1);
}
