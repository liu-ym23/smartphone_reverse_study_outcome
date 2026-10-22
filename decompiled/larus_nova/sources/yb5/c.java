package yb5;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.DocMessage;
import com.larksuite.framework.utils.y;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements y.a<DocMessage, com.ss.android.lark.doc.entity.DocMessage> {
    public c() {
    }

    @Override // com.larksuite.framework.utils.y.a
    public final com.ss.android.lark.doc.entity.DocMessage get(DocMessage r100) {
        DocMessage r101 = r100;
        if (r101 != null) goto L5;
        return null;
    L5:
        com.ss.android.lark.doc.entity.DocMessage r102 = new com.ss.android.lark.doc.entity.DocMessage();
        r102.setId(r101.f253481id);
        r102.setType(com.ss.android.lark.doc.entity.DocMessage.Type.forNumber(r101.type.getValue()));
        r102.setCreateTime(r101.create_time.longValue());
        r102.setUpdateTime(r101.update_time.longValue());
        r102.setContent(r101.content);
        r102.setDocFeedId(r101.doc_feed_id);
        String r103 = r101.from_id;
        r102.setFromId(r103);
        TextUtils.isEmpty(r103);
        return r102;
    }
}
