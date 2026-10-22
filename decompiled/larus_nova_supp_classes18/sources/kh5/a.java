package kh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.custompassword.model.CreatePasswordResult;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.google.gson.Gson;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements NetService.c<CreatePasswordResult> {

    /* JADX INFO: renamed from: kh5.a$a, reason: collision with other inner class name */
    public static final class C0255a {
    }

    static {
    }

    public a() {
    }

    public final Result parse(String r4) {
        JSONObject r1 = new JSONObject(r4);     // Catch: Throwable -> L8
        if (r1.optInt("code") != 0) goto L13;
        return (CreatePasswordResult) new Gson().fromJson(r1.optString(WikiFolderPushPlugin.DATA), CreatePasswordResult.class);
    L13:
        return null;
    L8:
        th = move-exception;
        tt5.a.d("CreatePasswordParser", th.getMessage());
        return null;
    }
}
