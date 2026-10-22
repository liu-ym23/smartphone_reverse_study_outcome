package com.ss.android.lark.filedetail.impl.detail;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
class FileTransmissionPresenter$5$1 implements IGetDataCallback<List<wbb.d.c>> {
    final /* synthetic */ s this$1;

    public FileTransmissionPresenter$5$1(s r100) {
        this.this$1 = r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Log.i("FileTransmissionPresenter", "download file: IMFileRiskTag list is null or empty, allows download file.");
        throw null;
    }

    public void onSuccess(List<wbb.d.c> r100) {
        Log.i("FileTransmissionPresenter", "download file: getIMFileRiskTagByKeys success.");
        if (r100 != null) goto L5;
        return;
    L5:
        if (CollectionUtils.isEmpty(r100) == false) goto L7;
        return;
    L7:
        if (r100.size() > 0) goto L9;
        return;
    L9:
        if (((wbb.d.c) ListProtector.get(r100, 0)).f559037a == false) goto L12;
        Log.i("FileTransmissionPresenter", "restrictOperation is true, ready to check if user can download risk file.");
        wbb.d r101 = vbb.a.a();
        com.ss.android.lark.download.service.impl.j r102 = (com.ss.android.lark.download.service.impl.j) r101;
        r102.c(new AnonymousClass1(this));
        return;
    L12:
        Log.i("FileTransmissionPresenter", "restrictOperation is false, allows download file.");
        throw null;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((List) r100);
    }
}
