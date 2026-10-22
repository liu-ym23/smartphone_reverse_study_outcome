package uf5;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageResultBean;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m0 {
    public static MessageResultBean b(String r3) throws JSONException {
        String r0 = JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(new JSONObject(r3), WikiFolderPushPlugin.DATA), "body");
        MessageResultBean r1 = (MessageResultBean) JSON.parseObject(r0, MessageResultBean.class);
        List<MessageBean> r4 = JSON.parseArray(JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(new JSONObject(r0), WikiFolderPushPlugin.DATA), "messages"), MessageBean.class);
        r1.getData().setMessage(r4);
        return r1;
    }

    public static MessageResultBean c(String r1) throws JSONException {
        return (MessageResultBean) JSON.parseObject(JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(new JSONObject(r1), WikiFolderPushPlugin.DATA), "body"), MessageResultBean.class);
    }

    public static boolean e(String r3, Map<String, String> r4) {
        tt5.a.h("MessageDataUtils", "[AutoShowFeed]autoShowFeed");
        if (iu5.b.b(r3) == false) goto L7;
        tt5.a.h("MessageDataUtils", "[AutoShowFeed]isLarkPush: true");
        return true;
    L7:
        if (iu5.b.a(r3) == true) goto L10;
        tt5.a.h("MessageDataUtils", "[AutoShowFeed]isLarkFeed: false");
        return false;
    L10:
        if (r4 == null) goto L12;
        int r5 = yu5.c.f(r4.get("unread_badge_count"), 0);
    L13:
        if (r5 <= 0) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == false) goto L19;
        tt5.a.h("MessageDataUtils", "[AutoShowFeed]hasUnread: true");
        return true;
    L19:
        return false;
    L15:
        r6 = false;
        goto L16
    L12:
        r5 = 0;
        goto L13
    }

    public static void a(MessageResultBean r4, String r5, o r6) {
        Iterator<MessageBean> r7 = r4.getData().getMessage().iterator();
    L4:
        if (r7.hasNext() == false) goto L14;
        MessageBean r0 = r7.next();
        boolean r1 = Objects.equals(r0.getUser_id(), r5);
        if ("MESSAGE_DOC_CONTENT_REACTION".equals(r0.getType()) == false) goto L8;
        tt5.a.h("MessageDataUtils", "remove isUserReactionFeedEnable = false");
        r7.remove();
    L8:
        if (r1 == false) goto L10;
        tt5.a.h("MessageDataUtils", "remove: sendByMe, messageId = " + r0.getMessageId());
        r7.remove();
    L10:
        if (r6 == null) goto L4;
        if (((ConcurrentHashMap) r6.a).containsKey(r0.getMessageId()) == false) goto L4;
        tt5.a.h("MessageDataUtils", "has read:" + r0.getMessageId());
        r0.setReadStatus(2);
        goto L4
    }

    public static void d(String r7, MessageResultBean r8, int[] r9) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        List<MessageBean> r3 = r8.getData().getMessage();     // Catch: Exception -> L13
        if (r3 == null) goto L10;
        int r4 = r3.size();     // Catch: Exception -> L13
        Iterator<MessageBean> r5 = r3.iterator();     // Catch: Exception -> L17
    L8:
        if (r5.hasNext() == false) goto L11;
        MessageBean r6 = r5.next();     // Catch: Exception -> L17
        r0.add(Integer.valueOf(r6.getDelete()));     // Catch: Exception -> L17
        r1.add(Integer.valueOf(r6.getFinish()));     // Catch: Exception -> L17
    L11:
        int r10 = r8.getData().getCountUnreadMessage();     // Catch: Exception -> L17
    L15:
        r9[0] = r4;
        r9[1] = r10;
        tt5.a.h("MessageDataUtils", r7 + ": " + r4 + " un read: " + r10 + " deleteStatus:" + r0.toString() + " finishStatus:" + r1.toString());
        return;
    L14:
        r10 = 0;
        goto L15
    L10:
        r4 = 0;
    L13:
        r4 = 0;
        goto L14
    }
}
