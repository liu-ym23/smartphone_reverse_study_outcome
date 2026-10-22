package li5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.middleground.permission.setting.manager.BatchUserPermissionResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements NetService.c<BatchUserPermissionResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<String> f509356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f509357b;

    public a(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "userIds");
        this.f509356a = r100;
        this.f509357b = "BatchUserPermissionParser";
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r110) {
        BatchUserPermissionResult r100 = new BatchUserPermissionResult();
        JSONObject r111 = new JSONObject(r110).optJSONObject("data");     // Catch: Throwable -> L17
        if (r111 == null) goto L6;
        JSONObject r112 = r111.optJSONObject("permissions_v2");     // Catch: Throwable -> L17
    L7:
        HashMap r101 = new HashMap();     // Catch: Throwable -> L17
        Iterator<String> r102 = this.f509356a.iterator();     // Catch: Throwable -> L17
    L9:
        if (r102.hasNext() == false) goto L15;
        String r103 = r102.next();     // Catch: Throwable -> L17
        if (r112 == null) goto L13;
        int r104 = r112.optInt(r103);     // Catch: Throwable -> L17
    L14:
        r101.put(r103, new DocUserPermission(r104, 0, null, null, 14, null));     // Catch: Throwable -> L17
        goto L9
    L13:
        r104 = 0;
        goto L14
    L15:
        r100.data = r101;     // Catch: Throwable -> L17
    L19:
        return r100;
    L6:
        r112 = null;
    L17:
        th = move-exception;
        tt5.a.f(this.f509357b, th, false);
        goto L19
    }
}
