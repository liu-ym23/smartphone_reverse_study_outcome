package yb5;

import com.bytedance.lark.pb.basic.v1.DocFeed;
import com.larksuite.framework.utils.y;
import com.ss.android.lark.doc.entity.DocType;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements y.a<DocFeed, com.ss.android.lark.doc.entity.DocFeed> {
    public b() {
    }

    public final Object get(Object r5) {
        DocFeed r6 = (DocFeed) r5;
        if (r6 != null) goto L5;
        return null;
    L5:
        com.ss.android.lark.doc.entity.DocFeed r0 = new com.ss.android.lark.doc.entity.DocFeed();
        r0.setId(r6.id);
        r0.setTitle(r6.title);
        int r1 = r6.type.getValue();
        if (r1 == 113) goto L8;
    L10:
        r0.setType(DocType.forNumber(r1));
    L11:
        r0.setIconKey(r6.icon_key);
        r0.setUrl(r6.doc_url);
        r0.setCreateTime(r6.create_time.longValue());
        r0.setUpdateTime(r6.update_time.longValue());
        r0.setOwnerId(r6.owner_id);
        r0.setNewMessageCount(r6.new_message_count.intValue());
        r0.setDocMessageIds(new ArrayList(r6.doc_message_ids));
        r0.setRemind(r6.is_remind.booleanValue());
        r0.setCrossTenant(r6.is_cross_tenant.booleanValue());
        return r0;
    L8:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("apaas.miaoda.migrate_to_ccm") == false) goto L10;
        r0.setType(DocType.MIAODA);
        goto L11
    }
}
