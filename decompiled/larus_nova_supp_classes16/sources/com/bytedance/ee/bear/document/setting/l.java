package com.bytedance.ee.bear.document.setting;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.setting.model.UserInfoModel;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l<T extends Result> implements NetService.c {
    public static final l<T> a = null;

    static {
        a = new l();
    }

    public l() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result<UserInfoModel> parse(String r5) {
        Intrinsics.checkNotNullParameter(r5, "json");
        Result<UserInfoModel> r0 = new Result();
        JSONObject r1 = new JSONObject(r5);     // Catch: Exception -> L12
        JSONObject r6 = r1.optJSONObject("data");     // Catch: Exception -> L12
        if (r1.optInt("code") != 0) goto L14;
        if (r6 == null) goto L14;
        UserInfoModel r2 = new UserInfoModel();     // Catch: Exception -> L12
        boolean r3 = true;
        if (r6.optInt("leader_id", 1) != 0) goto L10;
        r3 = false;
    L10:
        r2.setHasLeader(r3);     // Catch: Exception -> L12
        r0.setData(r2);     // Catch: Exception -> L12
    L14:
        return r0;
    L12:
        e = move-exception;
        tt5.a.d("SettingDataModel", "exception : " + e.getMessage());
        goto L14
    }
}
