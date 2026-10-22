package xi5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g {
    public NetService a;

    public static final class a implements NetService.c<Result<Boolean>> {
        public a() {
        }

        public final Result<Boolean> parse(String r8) throws NetService.ParseException {
            Intrinsics.checkNotNullParameter(r8, "json");
            Result<Boolean> r0 = new Result();
            JSONObject r2 = new JSONObject(r8);     // Catch: JSONException -> L13
            JSONArray r9 = r2.optJSONObject(WikiFolderPushPlugin.DATA).optJSONArray("setting");     // Catch: JSONException -> L13
            if (r9 != null) goto L6;
            r9 = new JSONArray();     // Catch: JSONException -> L13
        L6:
            r0.code = JSONObjectProtectorUtils.getInt(r2, "code");     // Catch: JSONException -> L13
            int r3 = r9.length();     // Catch: JSONException -> L13
            int r4 = 0;
        L7:
            if (r4 >= r3) goto L15;
            JSONObject r5 = r9.optJSONObject(r4);     // Catch: JSONException -> L13
            if (TextUtils.equals(r5.optString("settingKey"), "allow_config_show_collaboration_avatar") == true) goto L10;
            r4 = r4 + 1;
            goto L7
        L10:
            r0.data = Boolean.valueOf(r5.optBoolean("enabled"));     // Catch: JSONException -> L13
        L15:
            return r0;
        L13:
            e = move-exception;
            tt5.a.e("GetShowAvatarExecutor", "parse: ", e, false);
            e.printStackTrace();
            goto L15
        }
    }

    public static final class b {
    }

    static {
    }

    public g(NetService r2) {
        Intrinsics.checkNotNullParameter(r2, "netService");
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }
}
