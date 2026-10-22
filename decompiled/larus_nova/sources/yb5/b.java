package yb5;

import com.bytedance.lark.pb.basic.v1.DocFeed;
import com.larksuite.framework.utils.y;
import com.ss.android.lark.doc.entity.DocType;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements y.a<DocFeed, com.ss.android.lark.doc.entity.DocFeed> {
    public b() {
    }

    @Override // com.larksuite.framework.utils.y.a
    public final com.ss.android.lark.doc.entity.DocFeed get(DocFeed r100) {
        DocFeed r101 = r100;
        if (r101 != null) goto L5;
        return null;
    L5:
        com.ss.android.lark.doc.entity.DocFeed r102 = new com.ss.android.lark.doc.entity.DocFeed();
        r102.setId(r101.f253479id);
        r102.setTitle(r101.title);
        int r103 = r101.type.getValue();
        if (r103 == 113) goto L8;
    L10:
        r102.setType(DocType.forNumber(r103));
    L11:
        r102.setIconKey(r101.icon_key);
        r102.setUrl(r101.doc_url);
        r102.setCreateTime(r101.create_time.longValue());
        r102.setUpdateTime(r101.update_time.longValue());
        r102.setOwnerId(r101.owner_id);
        r102.setNewMessageCount(r101.new_message_count.intValue());
        r102.setDocMessageIds(new ArrayList(r101.doc_message_ids));
        r102.setRemind(r101.is_remind.booleanValue());
        r102.setCrossTenant(r101.is_cross_tenant.booleanValue());
        return r102;
    L8:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("apaas.miaoda.migrate_to_ccm") == false) goto L10;
        r102.setType(DocType.MIAODA);
        goto L11
    }
}
