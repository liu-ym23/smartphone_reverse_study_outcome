package f55;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.drive.biz.extra_info.LikeInfoView;
import com.bytedance.ee.bear.middleground.like.export.LikePushBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ f a;
    public final /* synthetic */ String b;

    public /* synthetic */ e(f r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f r0 = this.a;
        String r1 = this.b;
        r0.getClass();
        JSONObject r2 = JSON.parseObject(r1).getJSONObject("data").getJSONObject("body").getJSONObject("data");     // Catch: Exception -> L31
        if ("LIKE".equalsIgnoreCase(r2.getString("type")) == false) goto L6;
    L7:
        LikePushBean r3 = (LikePushBean) r2.getJSONObject("data").toJavaObject(LikePushBean.class);     // Catch: Exception -> L31
        if (TextUtils.equals(r3.getUser_id(), r0.d.uid) == true) goto L10;
    L17:
        r0.a.b(r3.getCount());     // Catch: Exception -> L31
        ArrayList r4 = new ArrayList();     // Catch: Exception -> L31
        if (hu5.a.d(r3.getAhead_users()) == true) goto L23;
        Iterator r5 = r3.getAhead_users().iterator();     // Catch: Exception -> L31
    L21:
        if (r5.hasNext() == false) goto L23;
        r4.add(((LikePushBean.AheadUsersBean) r5.next()).getAvatar_url());     // Catch: Exception -> L31
    L23:
        HashMap<String, String> r6 = new HashMap();     // Catch: Exception -> L31
        if (hu5.a.d(r3.getAhead_users()) == true) goto L29;
        Iterator r7 = r3.getAhead_users().iterator();     // Catch: Exception -> L31
    L27:
        if (r7.hasNext() == false) goto L29;
        LikePushBean.AheadUsersBean r8 = (LikePushBean.AheadUsersBean) r7.next();     // Catch: Exception -> L31
        r6.put(r8.getId(), r8.getAvatar_url());     // Catch: Exception -> L31
    L29:
        r0.c(r4, r6);     // Catch: Exception -> L31
        return;
    L10:
        if (r3.isIs_liked() == false) goto L12;
        LikeInfoView.LikeState r9 = LikeInfoView.LikeState.LIKED;     // Catch: Exception -> L31
    L14:
        if (r0.a.getState().getNumber() != r9.getNumber()) goto L16;
        tt5.a.h("LikeWrapper", "like/unlike already handled, return");     // Catch: Exception -> L31
        return;
    L16:
        r0.a.c(r3.isIs_liked());     // Catch: Exception -> L31
        goto L17
    L12:
        r9 = LikeInfoView.LikeState.UNLIKE;     // Catch: Exception -> L31
        goto L14
    L6:
        if ("DISLIKE".equalsIgnoreCase(r2.getString("type")) == true) goto L7;
        return;
    L31:
        e = move-exception;
        tt5.a.e("LikeWrapper", "updateLikeInfo", e, false);
    }
}
