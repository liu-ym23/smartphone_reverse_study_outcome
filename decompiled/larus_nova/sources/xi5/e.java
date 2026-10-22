package xi5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.record.executor.PrivacyResult;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f563955a;

    public interface a {
    }

    public static class b implements NetService.c<Result<PrivacyResult>> {
        public b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<PrivacyResult> parse(String r100) throws NetService.ParseException {
            Result<PrivacyResult> r101 = new Result();
            JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L9
            JSONObject r103 = r102.optJSONObject("data").optJSONObject("settings");     // Catch: JSONException -> L9
            r101.code = JSONObjectProtectorUtils.getInt(r102, "code");     // Catch: JSONException -> L9
            if (r103 == null) goto L6;
            boolean r104 = JSONObjectProtectorUtils.getBoolean(r103, "allow_read_list_setting");     // Catch: JSONException -> L9
            boolean r105 = JSONObjectProtectorUtils.getBoolean(r103, "allow_show_collaboration_avatar");     // Catch: JSONException -> L9
        L7:
            r101.data = new PrivacyResult(r104, r105);     // Catch: JSONException -> L9
            r101.msg = JSONObjectProtectorUtils.getString(r102, "msg");     // Catch: JSONException -> L9
        L11:
            return r101;
        L6:
            r105 = false;
            r104 = false;
        L9:
            e = move-exception;
            tt5.a.e("GetPrivacyExecutor", "parse: ", e, false);
            e.printStackTrace();
            goto L11
        }
    }

    public e(NetService r100) {
        this.f563955a = r100;
    }
}
