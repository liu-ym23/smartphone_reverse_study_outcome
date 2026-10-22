package com.bytedance.ee.bear.drive.loader.download.platform.processor;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.loader.download.platform.ProcessorContext;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IPreviewGetModel;

/* JADX INFO: loaded from: classes16.dex */
public class ArchiveTreeProcessor extends AbsServerTransformProcessor {
    private static final String TAG = "ArchiveTreeProcessor";

    public ArchiveTreeProcessor(ProcessorContext r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsServerTransformProcessor
    public boolean checkReadyResult(IPreviewGetModel r100) {
        String r101 = r100.getExtra();
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L9;
        tt5.a.k(TAG, "checkReadyResult() extra is empty");
        return false;
    L9:
        getProcessorContext().getFileModel().o(r101);
        return true;
    }
}
