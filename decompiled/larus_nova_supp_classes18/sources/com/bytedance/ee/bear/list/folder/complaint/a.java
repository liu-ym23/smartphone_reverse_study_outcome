package com.bytedance.ee.bear.list.folder.complaint;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.mvp.BaseModel;
import io.reactivex.Flowable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends BaseModel implements i {
    public final String a;
    public final int b;

    @Override // com.bytedance.ee.bear.list.folder.complaint.i
    public final Flowable<SendComplaintResult> q4() {
        NetService.f r0 = new NetService.f("/space/api/platform/review/complaint/");
        ((NetService.e) r0).c = 1;
        HashMap r1 = new HashMap();
        r1.put("obj_type", String.valueOf(this.b));
        r1.put(ResourceData.KEY_OBJ_TOKEN, this.a);
        r0.d(r1);
        return ((NetService) org.koin.java.a.a(NetService.class)).Vc(new k()).a(r0);
    }

    public a(String r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
