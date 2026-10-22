package com.bytedance.ee.bear.bitable.card.viewmodel.upload;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.UploadAttachmentEntity;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.a;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class GetPendingEditHandler implements i<GetPendingEditData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f209158a;

    public static class GetPendingEditData implements NonProguard {
        public String baseToken;
        public String recordId;
        public String tableId;
        public String viewId;

        public GetPendingEditData() {
        }
    }

    public static class PendingEditResultBean implements NonProguard {
        public static final int ATTACHMENT_PENDING = 0;
        public int pendingType;

        public PendingEditResultBean(int r100) {
            this.pendingType = r100;
        }
    }

    public GetPendingEditHandler() {
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, m r101) {
        GetPendingEditData r102 = (GetPendingEditData) r100;
        a r103 = this.f209158a;
        if (r103 == null) goto L17;
        if (r102 == null) goto L17;
        ArrayList<UploadAttachmentEntity> r104 = r103.findUploadingAttachmentList(r102.recordId);
        HashMap r105 = new HashMap();
        if (r104 != null) goto L9;
    L16:
        tt5.a.h("GetPendingEditHandler", "handle. size:" + r105.size());
        r101.b(new JSONObject(r105));
        return;
    L9:
        if (r104.isEmpty() == true) goto L16;
        Iterator<UploadAttachmentEntity> r106 = r104.iterator();
    L12:
        if (r106.hasNext() == false) goto L16;
        UploadAttachmentEntity r107 = r106.next();
        if (r105.get(r107.getFieldId()) != null) goto L12;
        r105.put(r107.getFieldId(), new PendingEditResultBean(0));
    L17:
        tt5.a.d("GetPendingEditHandler", "handle, attachmentUploadManager or data is null");
    }
}
