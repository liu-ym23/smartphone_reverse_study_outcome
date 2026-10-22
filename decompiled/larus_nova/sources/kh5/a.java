package kh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.custompassword.model.CreatePasswordResult;
import com.google.gson.Gson;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements NetService.c<CreatePasswordResult> {

    /* JADX INFO: renamed from: kh5.a$a, reason: collision with other inner class name */
    public static final class C6554a {
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
        JSONObject r101 = new JSONObject(r100);     // Catch: Throwable -> L8
        if (r101.optInt("code") != 0) goto L13;
        return (CreatePasswordResult) new Gson().fromJson(r101.optString("data"), CreatePasswordResult.class);
    L13:
        return null;
    L8:
        th = move-exception;
        tt5.a.d("CreatePasswordParser", th.getMessage());
        return null;
    }
}
