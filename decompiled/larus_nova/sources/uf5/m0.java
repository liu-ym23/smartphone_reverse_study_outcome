package uf5;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageResultBean;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class m0 {
    public static MessageResultBean b(String r100) throws JSONException {
        String r101 = JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(new JSONObject(r100), "data"), ContainerPosition.BODY);
        MessageResultBean r102 = (MessageResultBean) JSON.parseObject(r101, MessageResultBean.class);
        List<MessageBean> r103 = JSON.parseArray(JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(new JSONObject(r101), "data"), "messages"), MessageBean.class);
        r102.getData().setMessage(r103);
        return r102;
    }

    public static MessageResultBean c(String r100) throws JSONException {
        return (MessageResultBean) JSON.parseObject(JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(new JSONObject(r100), "data"), ContainerPosition.BODY), MessageResultBean.class);
    }

    public static boolean e(String r100, Map<String, String> r101) {
        tt5.a.h("MessageDataUtils", "[AutoShowFeed]autoShowFeed");
        if (iu5.b.b(r100) == false) goto L7;
        tt5.a.h("MessageDataUtils", "[AutoShowFeed]isLarkPush: true");
        return true;
    L7:
        if (iu5.b.a(r100) == true) goto L10;
        tt5.a.h("MessageDataUtils", "[AutoShowFeed]isLarkFeed: false");
        return false;
    L10:
        if (r101 == null) goto L12;
        int r102 = yu5.c.f(r101.get("unread_badge_count"), 0);
    L13:
        if (r102 <= 0) goto L15;
        boolean r103 = true;
    L16:
        if (r103 == false) goto L19;
        tt5.a.h("MessageDataUtils", "[AutoShowFeed]hasUnread: true");
        return true;
    L19:
        return false;
    L15:
        r103 = false;
        goto L16
    L12:
        r102 = 0;
        goto L13
    }

    public static void a(MessageResultBean r100, String r101, o r102) {
        Iterator<MessageBean> r103 = r100.getData().getMessage().iterator();
    L4:
        if (r103.hasNext() == false) goto L14;
        MessageBean r104 = r103.next();
        boolean r105 = Objects.equals(r104.getUser_id(), r101);
        if ("MESSAGE_DOC_CONTENT_REACTION".equals(r104.getType()) == false) goto L8;
        tt5.a.h("MessageDataUtils", "remove isUserReactionFeedEnable = false");
        r103.remove();
    L8:
        if (r105 == false) goto L10;
        tt5.a.h("MessageDataUtils", "remove: sendByMe, messageId = " + r104.getMessageId());
        r103.remove();
    L10:
        if (r102 == null) goto L4;
        if (((ConcurrentHashMap) r102.f549919a).containsKey(r104.getMessageId()) == false) goto L4;
        tt5.a.h("MessageDataUtils", "has read:" + r104.getMessageId());
        r104.setReadStatus(2);
        goto L4
    }

    public static void d(String r100, MessageResultBean r101, int[] r102) {
        ArrayList r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        List<MessageBean> r105 = r101.getData().getMessage();     // Catch: Exception -> L13
        if (r105 == null) goto L10;
        int r106 = r105.size();     // Catch: Exception -> L13
        Iterator<MessageBean> r107 = r105.iterator();     // Catch: Exception -> L17
    L8:
        if (r107.hasNext() == false) goto L11;
        MessageBean r108 = r107.next();     // Catch: Exception -> L17
        r103.add(Integer.valueOf(r108.getDelete()));     // Catch: Exception -> L17
        r104.add(Integer.valueOf(r108.getFinish()));     // Catch: Exception -> L17
    L11:
        int r109 = r101.getData().getCountUnreadMessage();     // Catch: Exception -> L17
    L15:
        r102[0] = r106;
        r102[1] = r109;
        tt5.a.h("MessageDataUtils", r100 + ": " + r106 + " un read: " + r109 + " deleteStatus:" + r103.toString() + " finishStatus:" + r104.toString());
        return;
    L14:
        r109 = 0;
        goto L15
    L10:
        r106 = 0;
    L13:
        r106 = 0;
        goto L14
    }
}
