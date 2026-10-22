package bh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.EmailInfoResult;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements NetService.c<EmailInfoResult> {
    public final String a;

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "email");
        this.a = r2;
    }

    public final Result parse(String r2) {
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        JSONObject r3 = new JSONObject(r2).optJSONObject(WikiFolderPushPlugin.DATA);
        if (r3 == null) goto L10;
        JSONObject r4 = r3.optJSONObject("email_info");
        if (r4 == null) goto L10;
        String r5 = r4.optString(this.a);
    L11:
        EmailInfoResult r0 = new EmailInfoResult();
        r0.setData(r5);
        return r0;
    L10:
        r5 = null;
        goto L11
    }
}
