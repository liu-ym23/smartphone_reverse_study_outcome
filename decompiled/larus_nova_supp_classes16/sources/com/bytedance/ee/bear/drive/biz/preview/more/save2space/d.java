package com.bytedance.ee.bear.drive.biz.preview.more.save2space;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class d implements Function {
    public final /* synthetic */ NetService.f a;

    public /* synthetic */ d(NetService.f r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        NetService.f r0 = this.a;
        Result r5 = (Result) r4;
        if (r5 == null) goto L11;
        if (r5.getCode() != 0) goto L11;
        if (r5.getData() == null) goto L11;
        return (DriveSpaceFileAttachmentExecutor.AttachSaveResponse) r5.getData();
    L11:
        throw new Exception("saveFileToSpace error, request: " + r0);
    }
}
