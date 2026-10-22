package com.bytedance.ee.bear.document.restore.api;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.DocViewModel;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.json.JSONObject;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements Function<Throwable, Publisher<RestoreFileResult>> {
    public b() {
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.bytedance.ee.bear.document.restore.api.RestoreFileResult$FailDataNoPermInfo, java.io.Serializable] */
    public final Object apply(Object r5) throws Exception {
        Throwable r6 = (Throwable) r5;
        if ((r6 instanceof NetService.ServerErrorException) == false) goto L20;
        String r0 = ((NetService.ServerErrorException) r6).getJson();
        if (TextUtils.isEmpty(r0) == true) goto L20;
        JSONObject r1 = new JSONObject(r0);
        RestoreFileResult r2 = new RestoreFileResult();
        r2.code = r1.optInt("code", 1);
        r2.msg = r1.optString("msg");
        r2.data = null;
        r2.failData = null;
        r2.exception = r6;
        JSONObject r7 = r1.optJSONObject("data");
        if (r7 == null) goto L21;
        JSONObject r8 = r7.optJSONObject("fail_data");
        if (r8 == null) goto L21;
        JSONObject r9 = r8.optJSONObject("no_perm_info");
        if (r9 == null) goto L21;
        ?? r3 = new RestoreFileResult.FailDataNoPermInfo();
        JSONObject r4 = r9.optJSONObject("del_operator");
        if (r4 == null) goto L15;
        r3.del_operator_id = r4.optString("id");
        r3.del_operator_cn_name = r4.optString("cn_name");
        r3.del_operator_en_name = r4.optString("en_name");
    L15:
        r3.space_name = r9.optString("space_name");
        r3.space_id = r9.optString(DocViewModel.EXTRA_SPACE_ID);
        if (r3.isValid() == false) goto L21;
        r2.failData = r3;
    L21:
        return Flowable.just(r2);
    L20:
        return Flowable.error(r6);
    }
}
