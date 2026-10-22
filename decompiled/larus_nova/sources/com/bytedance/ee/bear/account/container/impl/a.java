package com.bytedance.ee.bear.account.container.impl;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class a<T extends Result> implements NetService.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T> f206206a = null;

    static {
        f206206a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result<UserInfoResult> parse(String r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        tt5.a.b("UserLocalAccountServiceImpl", "userInfoPuller userInfo: " + r100);
        Result<UserInfoResult> r101 = new Result();
        JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L15
        JSONObject r103 = r102.optJSONObject("data");     // Catch: Exception -> L15
        if (r102.optInt("code") != 0) goto L17;
        if (r103 == null) goto L17;
        UserInfoResult r104 = new UserInfoResult();     // Catch: Exception -> L15
        r104.departmentId = r103.optString("department_id");     // Catch: Exception -> L15
        r104.domain = r103.optString("domain");     // Catch: Exception -> L15
        boolean r105 = false;
        if (r103.optBoolean("is_super_admin") != true) goto L9;
        boolean r106 = true;
    L10:
        r104.isSuperAdmin = r106;     // Catch: Exception -> L15
        if (r103.optInt("leader_id", 1) == 0) goto L13;
        r105 = true;
    L13:
        r104.hasLeader = r105;     // Catch: Exception -> L15
        r101.setData(r104);     // Catch: Exception -> L15
        goto L17
    L9:
        r106 = false;
    L17:
        return r101;
    L15:
        e = move-exception;
        Log.d(tt5.a.a("UserLocalAccountServiceImpl"), "exception : " + e, e);
        goto L17
    }
}
