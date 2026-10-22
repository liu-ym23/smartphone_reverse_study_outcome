package tj5;

import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.more.PageViewResult;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.Flowable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k {
    public final NetService.d<PageViewResult> a;

    public static class a implements NetService.c<PageViewResult> {
        public a() {
        }

        public final Result parse(String r4) throws NetService.ParseException {
            int r5 = JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(new JSONObject(r4), WikiFolderPushPlugin.DATA), "comments_count");     // Catch: JSONException -> L9
            if (r5 < 0) goto L7;
            PageViewResult r1 = new PageViewResult();     // Catch: JSONException -> L9
            r1.commentsCount = r5;     // Catch: JSONException -> L9
            return r1;
        L7:
            tt5.a.d("PageViewServiceExecutor", "parse comment count fail, invalid comments_count");     // Catch: JSONException -> L9
            throw new NetService.ParseException();     // Catch: JSONException -> L9
        L9:
            e = move-exception;
            tt5.a.e("PageViewServiceExecutor", "parse comment count fail", e, false);
            throw new NetService.ParseException();
        }
    }

    public static class b implements NetService.c<PageViewResult> {
        public b() {
        }

        public final Result parse(String r10) throws NetService.ParseException {
            PageViewResult r5 = new PageViewResult();
            JSONObject r11 = new JSONObject(r10).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: JSONException -> L9
            if (r11 == null) goto L11;
            r5.pv = JSONObjectProtectorUtils.getInt(r11, "pv");     // Catch: JSONException -> L9
            r5.uv = JSONObjectProtectorUtils.getInt(r11, "uv");     // Catch: JSONException -> L9
            r5.likeCount = JSONObjectProtectorUtils.getInt(r11, "like_count");     // Catch: JSONException -> L9
            r5.ownerId = JSONObjectProtectorUtils.getString(r11, "owner_user_id");     // Catch: JSONException -> L9
            r5.creationTime = JSONObjectProtectorUtils.getLong(r11, "create_timestamp");     // Catch: JSONException -> L9
            JSONObject r6 = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r11, "entities"), "users");     // Catch: JSONException -> L9
            JSONObject r7 = JSONObjectProtectorUtils.getJSONObject(r6, r5.ownerId);     // Catch: JSONException -> L9
            r5.ownerAvatarUrl = JSONObjectProtectorUtils.getString(r7, "avatar_url");     // Catch: JSONException -> L9
            r5.ownerEnName = JSONObjectProtectorUtils.getString(r7, "en_name");     // Catch: JSONException -> L9
            r5.ownerName = JSONObjectProtectorUtils.getString(r7, "name");     // Catch: JSONException -> L9
            r5.pvToday = JSONObjectProtectorUtils.getInt(r11, "pv_today");     // Catch: JSONException -> L9
            r5.uvToday = JSONObjectProtectorUtils.getInt(r11, "uv_today");     // Catch: JSONException -> L9
            r5.likeCountToday = JSONObjectProtectorUtils.getInt(r11, "like_count_today");     // Catch: JSONException -> L9
            r5.commentsCount = JSONObjectProtectorUtils.getInt(r11, "comments_count");     // Catch: JSONException -> L9
            r5.commentsCountToday = JSONObjectProtectorUtils.getInt(r11, "comments_count_today");     // Catch: JSONException -> L9
            r5.displayName = DisplayName.parseDisplayName(r7.optJSONObject("display_name"));     // Catch: JSONException -> L9
            String r8 = r11.optString("creator_user_id");     // Catch: JSONException -> L9
            r5.creatorId = r8;     // Catch: JSONException -> L9
            JSONObject r9 = r6.optJSONObject(r8);     // Catch: JSONException -> L9
            r5.creatorAvatarUrl = r9.optString("avatar_url");     // Catch: JSONException -> L9
            r5.creatorEnName = r9.optString("en_name");     // Catch: JSONException -> L9
            r5.creatorName = r9.optString("name");     // Catch: JSONException -> L9
            r5.creatorDisplayName = DisplayName.parseDisplayName(r9.optJSONObject("display_name"));     // Catch: JSONException -> L9
            r5.lastModifiedTime = r11.optLong("edit_timestamp");     // Catch: JSONException -> L9
            if (r11.has("file_size") == false) goto L11;
            r5.documentSize = Long.valueOf(r11.optLong("file_size", 0));     // Catch: JSONException -> L9
        L11:
            return r5;
        L9:
            e = move-exception;
            tt5.a.e("PageViewServiceExecutor", "parse fail", e, false);
            goto L11
        }
    }

    public k() {
        this.a = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new b());
    }

    public static Flowable a(int r3, String r4) {
        NetService.d r0 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new a());
        String r5 = String.valueOf(r3);
        NetService.f r1 = new NetService.f("/api/obj_stats/get/");
        r1.b("obj_type", r5);
        r1.b(ResourceData.KEY_TOKEN, r4);
        return r0.a(r1);
    }
}
