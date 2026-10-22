package bo5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.templates.dependency.TemplateCreateResult;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements NetService.c<TemplateCreateResult> {
    public a() {
    }

    public final Result parse(String r6) {
        if (r6 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L32;
        JSONObject r2 = new JSONObject(r6);     // Catch: Throwable -> L27
        JSONObject r7 = r2.optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Throwable -> L27
        String r3 = "0";
        if (r7 == null) goto L16;
        String r4 = r7.optString("obj_template_token");     // Catch: Throwable -> L27
        if (r4 == null) goto L16;
    L17:
        if (r7 == null) goto L22;
        String r5 = r7.optString("template_id");     // Catch: Throwable -> L27
        if (r5 == null) goto L22;
        r3 = r5;
    L22:
        if (r7 == null) goto L24;
        int r8 = r7.optInt("obj_type");     // Catch: Throwable -> L27
    L25:
        TemplateCreateResult r9 = new TemplateCreateResult(r4, r8, r3);     // Catch: Throwable -> L27
        ((Result) r9).code = r2.optInt("code");     // Catch: Throwable -> L27
        ((Result) r9).msg = r2.optString("msg");     // Catch: Throwable -> L27
        return r9;
    L24:
        r8 = 0;
    L16:
        r4 = "0";
    L27:
        th = move-exception;
        tt5.a.e("TemplateCreateParser", "parse()...err", th, false);
        return new TemplateCreateResult();
    L32:
        return new TemplateCreateResult();
    L5:
        if (StringsKt.isBlank(r6) == true) goto L8;
        r1 = false;
        goto L9
    }
}
