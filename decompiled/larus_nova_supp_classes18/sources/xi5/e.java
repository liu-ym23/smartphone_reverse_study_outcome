package xi5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.record.executor.PrivacyResult;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public final NetService a;

    public interface a {
    }

    public static class b implements NetService.c<Result<PrivacyResult>> {
        public b() {
        }

        public final Result<PrivacyResult> parse(String r6) throws NetService.ParseException {
            Result<PrivacyResult> r0 = new Result();
            JSONObject r2 = new JSONObject(r6);     // Catch: JSONException -> L9
            JSONObject r7 = r2.optJSONObject(WikiFolderPushPlugin.DATA).optJSONObject(BenefitStore.FROM_SETTINGS);     // Catch: JSONException -> L9
            r0.code = JSONObjectProtectorUtils.getInt(r2, "code");     // Catch: JSONException -> L9
            if (r7 == null) goto L6;
            boolean r3 = JSONObjectProtectorUtils.getBoolean(r7, "allow_read_list_setting");     // Catch: JSONException -> L9
            boolean r8 = JSONObjectProtectorUtils.getBoolean(r7, "allow_show_collaboration_avatar");     // Catch: JSONException -> L9
        L7:
            r0.data = new PrivacyResult(r3, r8);     // Catch: JSONException -> L9
            r0.msg = JSONObjectProtectorUtils.getString(r2, "msg");     // Catch: JSONException -> L9
        L11:
            return r0;
        L6:
            r8 = false;
            r3 = false;
        L9:
            e = move-exception;
            tt5.a.e("GetPrivacyExecutor", "parse: ", e, false);
            e.printStackTrace();
            goto L11
        }
    }

    public e(NetService r1) {
        this.a = r1;
    }
}
