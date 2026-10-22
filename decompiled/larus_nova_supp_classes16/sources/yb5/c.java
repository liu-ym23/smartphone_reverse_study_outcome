package yb5;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.DocMessage;
import com.larksuite.framework.utils.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements y.a<DocMessage, com.ss.android.lark.doc.entity.DocMessage> {
    public c() {
    }

    public final Object get(Object r4) {
        DocMessage r5 = (DocMessage) r4;
        if (r5 != null) goto L5;
        return null;
    L5:
        com.ss.android.lark.doc.entity.DocMessage r0 = new com.ss.android.lark.doc.entity.DocMessage();
        r0.setId(r5.id);
        r0.setType(com.ss.android.lark.doc.entity.DocMessage.Type.forNumber(r5.type.getValue()));
        r0.setCreateTime(r5.create_time.longValue());
        r0.setUpdateTime(r5.update_time.longValue());
        r0.setContent(r5.content);
        r0.setDocFeedId(r5.doc_feed_id);
        String r6 = r5.from_id;
        r0.setFromId(r6);
        TextUtils.isEmpty(r6);
        return r0;
    }
}
