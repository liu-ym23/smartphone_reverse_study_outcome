package xi5;

import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.record.viewhistory.RecordListResult;
import com.bytedance.ee.bear.widgets.tagview.DisplayTagInfoV1;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f {
    public final NetService a;
    public NetService.f b;

    public class a implements Consumer<RecordListResult> {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        public final void accept(Object r3) throws Exception {
            RecordListResult r4 = (RecordListResult) r3;
            tt5.a.b("GetRecordListExecutor", "GetRecordListExecutor doAction accept  result=" + r4);
            c r0 = this.a;
            if (r0 == null) goto L6;
            r0.a(r4);
            return;
        }
    }

    public class b implements Consumer<Throwable> {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void accept(Object r4) throws Exception {
            Throwable r5 = (Throwable) r4;
            tt5.a.e("GetRecordListExecutor", "GetRecordListExecutor doAction failed", r5, false);
            c r0 = this.a;
            if (r0 == null) goto L6;
            r0.onError(r5);
            return;
        }
    }

    public interface c {
        void a(RecordListResult r1);

        void onError(Throwable r1) throws Exception;
    }

    public static class d implements NetService.c<RecordListResult> {
        public d() {
        }

        public final Result parse(String r8) throws NetService.ParseException {
            RecordListResult r0 = new RecordListResult();
            JSONObject r2 = new JSONObject(r8);     // Catch: JSONException -> L10
            r0.setCode(r2.optInt("code"));     // Catch: JSONException -> L10
            JSONObject r9 = r2.optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: JSONException -> L10
            if (r9 == null) goto L12;
            r0.uv = r9.optInt("uv");     // Catch: JSONException -> L10
            r0.uvHidden = r9.optInt("hidden_uv");     // Catch: JSONException -> L10
            r0.nextPageToken = r9.optString("next_page_token");     // Catch: JSONException -> L10
            JSONArray r10 = JSONObjectProtectorUtils.getJSONArray(r9, "users");     // Catch: JSONException -> L10
            r0.users = new ArrayList();     // Catch: JSONException -> L10
            int r3 = 0;
        L7:
            if (r3 >= r10.length()) goto L12;
            JSONObject r4 = JSONArrayProtectorUtils.getJSONObject(r10, r3);     // Catch: JSONException -> L10
            RecordListResult.a r5 = new RecordListResult.a();     // Catch: JSONException -> L10
            r5.a = r4.optString(ResourceData.KEY_ID);     // Catch: JSONException -> L10
            r5.b = r4.optString("name");     // Catch: JSONException -> L10
            r5.c = r4.optString("en_name");     // Catch: JSONException -> L10
            r5.f = r4.optString("avatar_url");     // Catch: JSONException -> L10
            r5.g = r4.optString("department");     // Catch: JSONException -> L10
            r5.h = r4.optLong("last_view_time");     // Catch: JSONException -> L10
            r5.i = r4.optInt("user_type");     // Catch: JSONException -> L10
            r5.j = r4.optBoolean("is_external");     // Catch: JSONException -> L10
            r4.optBoolean("is_resigned");     // Catch: JSONException -> L10
            r5.k = r4.optBoolean("can_show_profile");     // Catch: JSONException -> L10
            r4.optString("tenant_id");     // Catch: JSONException -> L10
            r4.optString("tenant_name");     // Catch: JSONException -> L10
            r5.d = DisplayName.parseDisplayName(r4.optJSONObject("display_name"));     // Catch: JSONException -> L10
            r5.e = DisplayTagInfoV1.parseDisplayTagInfoV1(r4.optJSONObject("display_tag"));     // Catch: JSONException -> L10
            r0.users.add(r5);     // Catch: JSONException -> L10
            r3 = r3 + 1;
        L12:
            return r0;
        L10:
            e = move-exception;
            tt5.a.e("GetRecordListExecutor", "parse fail", e, false);
            goto L12
        }
    }

    public f() {
        this.a = (NetService) org.koin.java.a.a(NetService.class);
    }

    public final Disposable a(xi5.a r4, c r5) {
        NetService.f r0 = new NetService.f("/api/obj_stats/get_view_detail/");
        this.b = r0;
        ((NetService.e) r0).c = 2;
        r0.b(ResourceData.KEY_TOKEN, r4.a);
        this.b.b("obj_type", String.valueOf(r4.getType()));
        this.b.b("page_size", String.valueOf(r4.d));
        this.b.b("next_page_token", r4.c);
        NetService.f r1 = this.b;
        if (r4.e == false) goto L5;
        String r6 = "true";
    L6:
        r1.b("get_view_count", r6);
        return this.a.Vc(new d()).a(this.b).subscribe(new a(r5), new b(r5));
    L5:
        r6 = "false";
        goto L6
    }
}
