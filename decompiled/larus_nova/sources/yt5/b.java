package yt5;

import com.bytedance.ee.permission.sdk.doc.GetPublicPermissionApi$Result;
import com.larus.sheet.operation.f;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends wt5.b<a, GetPublicPermissionApi$Result> {
    @Override // wt5.b
    public final wt5.b.C8160b<GetPublicPermissionApi$Result> a(String r100) {
    L16:
        e = move-exception;
        return new wt5.b.C8160b(null, e);
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
        return new wt5.b.C8160b(r103, null);
    L7:
        r101 = r100;
        goto L8
    }

    public b(a r100, Class r101, f.b r102) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "resultClass");
        super(r100, r101, r102);
    }
}
