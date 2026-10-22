package vt5;

import com.bytedance.ee.permission.AbsPermissionApiExecutor;
import com.bytedance.ee.permission.doc.GetPublicPermissionApi$Result;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends AbsPermissionApiExecutor<vt5.a, GetPublicPermissionApi$Result> {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.permission.AbsPermissionApiExecutor
    public final AbsPermissionApiExecutor.a<GetPublicPermissionApi$Result> a(String r100) {
    L16:
        e = move-exception;
        return new AbsPermissionApiExecutor.a(null, e);
    L5:
        if (r100 != null) goto L7;
        String r101 = "";
    L8:
        JSONObject r102 = new JSONObject(r101).optJSONObject("data");     // Catch: Exception -> L16
        if (r102 != null) goto L11;
        r102 = new JSONObject();     // Catch: Exception -> L16
    L11:
        GetPublicPermissionApi$Result r103 = new GetPublicPermissionApi$Result();
        r103.parse(r102);
        if (r100 != null) goto L14;
        r100 = "";
    L14:
        r103.setReportPublicPermJson(r100);
        return new AbsPermissionApiExecutor.a(r103, null);
    L7:
        r101 = r100;
        goto L8
    }

    public b(vt5.a r100, ut5.a<GetPublicPermissionApi$Result> r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        super("GetPublicPermissionExecutor", r100, GetPublicPermissionApi$Result.class, r101);
    }
}
