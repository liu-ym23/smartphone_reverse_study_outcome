package ph5;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;

/* JADX INFO: loaded from: classes18.dex */
public interface c {
    FileBizDomain a(BizDomain r100);

    PermissionRequest b(String r100);

    String c(int r100);

    boolean d(PermissionResponse r100);

    boolean e(PermissionResponse r100);
}
