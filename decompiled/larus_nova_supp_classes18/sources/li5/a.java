package li5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.middleground.permission.setting.manager.BatchUserPermissionResult;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements NetService.c<BatchUserPermissionResult> {
    public final ArrayList<String> a;
    public final String b;

    public a(ArrayList<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "userIds");
        this.a = r2;
        this.b = "BatchUserPermissionParser";
    }

    public final Result parse(String r14) {
        BatchUserPermissionResult r0 = new BatchUserPermissionResult();
        JSONObject r15 = new JSONObject(r14).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Throwable -> L17
        if (r15 == null) goto L6;
        JSONObject r16 = r15.optJSONObject("permissions_v2");     // Catch: Throwable -> L17
    L7:
        HashMap r2 = new HashMap();     // Catch: Throwable -> L17
        Iterator<String> r3 = this.a.iterator();     // Catch: Throwable -> L17
    L9:
        if (r3.hasNext() == false) goto L15;
        String r4 = r3.next();     // Catch: Throwable -> L17
        if (r16 == null) goto L13;
        int r6 = r16.optInt(r4);     // Catch: Throwable -> L17
    L14:
        r2.put(r4, new DocUserPermission(r6, 0, null, null, 14, null));     // Catch: Throwable -> L17
        goto L9
    L13:
        r6 = 0;
        goto L14
    L15:
        ((Result) r0).data = r2;     // Catch: Throwable -> L17
    L19:
        return r0;
    L6:
        r16 = null;
    L17:
        th = move-exception;
        tt5.a.f(this.b, th, false);
        goto L19
    }
}
