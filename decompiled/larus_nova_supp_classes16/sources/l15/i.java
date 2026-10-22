package l15;

import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.util.MessageResultBeanParserV2;
import io.reactivex.functions.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class i implements Function {
    public /* synthetic */ i() {
    }

    public final Object apply(Object r4) {
        JSONObject r0 = new JSONObject((String) r4).optJSONObject("data");
        if (r0 == null) goto L5;
        JSONObject r1 = r0.optJSONObject("body");
    L6:
        if (r1 != null) goto L10;
        tt5.a.h("FeedPluginV2", "getData... body is null, from rn");
        return null;
    L10:
        return MessageResultBeanParserV2.a(r1.optString("data", ""));
    L5:
        r1 = null;
        goto L6
    }
}
