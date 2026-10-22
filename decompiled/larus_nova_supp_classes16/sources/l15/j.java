package l15;

import com.bytedance.ee.bear.document.feed.v2.FeedPluginV2;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageResultBean;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class j implements Consumer {
    public final /* synthetic */ FeedPluginV2.b a;

    public /* synthetic */ j(FeedPluginV2.b r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        FeedPluginV2.b r0 = this.a;
        MessageResultBean r7 = (MessageResultBean) r6;
        if (FeedPluginV2.access$800(r0.a).getFeedMessageLiveData().getValue() != null) goto L6;
        if (r7 == null) goto L6;
        FeedPluginV2.access$800(r0.a).setFeedMessageData(r7.getData());
        tt5.a.h("FeedPluginV2", "getData... notify data, from rn");
        return;
    L6:
        StringBuilder r1 = new StringBuilder("getFeedMessageLiveData is null ?: ");
        boolean r3 = true;
        if (FeedPluginV2.access$800(r0.a).getFeedMessageLiveData().getValue() != null) goto L9;
        boolean r2 = true;
    L10:
        r1.append(r2);
        r1.append(", messageResultBean != null ?: ");
        if (r7 != null) goto L14;
        r3 = false;
    L14:
        r1.append(r3);
        tt5.a.h("FeedPluginV2", r1.toString());
        return;
    L9:
        r2 = false;
        goto L10
    }
}
