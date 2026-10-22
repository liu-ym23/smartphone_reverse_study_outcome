package dg5;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageResultBean;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import io.reactivex.functions.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class v0 implements Function {
    public final /* synthetic */ d1 a;

    public /* synthetic */ v0(d1 r1) {
        this.a = r1;
    }

    public final Object apply(Object r7) {
        d1 r0 = this.a;
        String r8 = (String) r7;
        r0.getClass();
        int r2 = 0;
        MessageResultBean r3 = new MessageResultBean();     // Catch: JSONException -> L5
        r3.setData((MessageResultBean.Data) JSON.parseObject(r8, MessageResultBean.Data.class));     // Catch: JSONException -> L5
        JSONObject r9 = new JSONObject();     // Catch: JSONException -> L5
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L5
        r4.put("body", JSON.toJSONString(r3));     // Catch: JSONException -> L5
        r9.put(WikiFolderPushPlugin.DATA, r4);     // Catch: JSONException -> L5
    L7:
        MessageResultBean r10 = uf5.m0.c(r9.toString());
        r2 = r10.getData().getMessage().size();     // Catch: Exception -> L10
    L12:
        tt5.a.h("PanelViewModel", "from web, messageCount:" + r2);
        String r1 = r0.e();
        r0.e.getToken();
        int r5 = r0.e.getDocumentType().b;
        uf5.m0.a(r10, r1, r0.o);
        return r10;
    L10:
        e = move-exception;
        tt5.a.f("PanelViewModel", e, false);
    L5:
        e = move-exception;
        tt5.a.f("MessageDataUtils", e, false);
        r9 = new JSONObject();
        goto L7
    }
}
