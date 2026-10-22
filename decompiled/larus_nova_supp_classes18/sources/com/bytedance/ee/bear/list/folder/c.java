package com.bytedance.ee.bear.list.folder;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import org.reactivestreams.Publisher;
import uc5.q1;
import uc5.u1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements Function<DocumentListInfo, Publisher<DocumentListInfo>> {
    public final NetService a;

    public c(NetService r1) {
        this.a = r1;
    }

    public final Object apply(Object r9) throws Exception {
        final DocumentListInfo r10 = (DocumentListInfo) r9;
        if (hu5.a.d(r10.getDocumentList()) == false) goto L5;
        tt5.a.h("GetAndSetDocumentExternalFunction", "GetAndSetDocumentExternalFunction()...list is empty");
        return Flowable.just(r10);
    L5:
        Document r0 = r10.getParent();
        if (r0 != null) goto L8;
    L17:
        tt5.a.h("GetAndSetDocumentExternalFunction", "GetAndSetDocumentExternalFunction()...not old share folder or fg is close");
        return Flowable.just(r10);
    L8:
        if (FolderVersion.isPersonalFolder(r0.L1, r0.P1) == true) goto L17;
        NetService.d r1 = this.a.Vc(new u1());
        ArrayList<Document> r2 = r10.getDocumentList();
        NetService.f r3 = new NetService.f("/space/api/explorer/obj/show_external_hint/");
        ((NetService.e) r3).c = 1;
        GetDocumentExternalPermParam r4 = new GetDocumentExternalPermParam();
        ArrayList r5 = new ArrayList();
        Iterator<Document> r6 = r2.iterator();
    L12:
        if (r6.hasNext() == false) goto L16;
        Document r7 = r6.next();
        if (r7.getType() == sbb.e.f.b) goto L12;
        GetDocumentExternalPermParam.ObjsBean r8 = new GetDocumentExternalPermParam.ObjsBean();
        r8.setType(r7.getType());
        r8.setToken(r7.d);
        r5.add(r8);
        goto L12
    L16:
        r4.setObjs(r5);
        ((NetService.e) r3).j = JSON.toJSONString(r4);
        return r1.a(r3).map(new q1(r10)).onErrorReturnItem(r10);
    }
}
