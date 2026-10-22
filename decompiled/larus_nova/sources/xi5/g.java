package xi5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NetService f563960a;

    public static final class a implements NetService.c<Result<Boolean>> {
        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<Boolean> parse(String r100) throws NetService.ParseException {
            Intrinsics.checkNotNullParameter(r100, "json");
            Result<Boolean> r101 = new Result();
            JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L13
            JSONArray r103 = r102.optJSONObject("data").optJSONArray("setting");     // Catch: JSONException -> L13
            if (r103 != null) goto L6;
            r103 = new JSONArray();     // Catch: JSONException -> L13
        L6:
            r101.code = JSONObjectProtectorUtils.getInt(r102, "code");     // Catch: JSONException -> L13
            int r104 = r103.length();     // Catch: JSONException -> L13
            int r105 = 0;
        L7:
            if (r105 >= r104) goto L15;
            JSONObject r106 = r103.optJSONObject(r105);     // Catch: JSONException -> L13
            if (TextUtils.equals(r106.optString("settingKey"), "allow_config_show_collaboration_avatar") == true) goto L10;
            r105 = r105 + 1;
            goto L7
        L10:
            r101.data = Boolean.valueOf(r106.optBoolean("enabled"));     // Catch: JSONException -> L13
        L15:
            return r101;
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

    public g(NetService r100) {
        Intrinsics.checkNotNullParameter(r100, "netService");
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f563960a = r100;
    }
}
