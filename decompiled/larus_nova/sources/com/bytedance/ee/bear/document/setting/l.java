package com.bytedance.ee.bear.document.setting;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.setting.model.UserInfoModel;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class l<T extends Result> implements NetService.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l<T> f221760a = null;

    static {
        f221760a = new l();
    }

    public l() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result<UserInfoModel> parse(String r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Result<UserInfoModel> r101 = new Result();
        JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L12
        JSONObject r103 = r102.optJSONObject("data");     // Catch: Exception -> L12
        if (r102.optInt("code") != 0) goto L14;
        if (r103 == null) goto L14;
        UserInfoModel r104 = new UserInfoModel();     // Catch: Exception -> L12
        boolean r105 = true;
        if (r103.optInt("leader_id", 1) != 0) goto L10;
        r105 = false;
    L10:
        r104.setHasLeader(r105);     // Catch: Exception -> L12
        r101.setData(r104);     // Catch: Exception -> L12
    L14:
        return r101;
    L12:
        e = move-exception;
        tt5.a.d("SettingDataModel", "exception : " + e.getMessage());
        goto L14
    }
}
