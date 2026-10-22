package com.bytedance.ee.bear.drive.loader.download.platform.processor;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.loader.download.platform.ProcessorContext;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IPreviewGetModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ArchiveTreeProcessor extends AbsServerTransformProcessor {
    private static final String TAG = "ArchiveTreeProcessor";

    public ArchiveTreeProcessor(ProcessorContext r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsServerTransformProcessor
    public boolean checkReadyResult(IPreviewGetModel r2) {
        String r3 = r2.getExtra();
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        if (TextUtils.isEmpty(r3) == false) goto L9;
        tt5.a.k(TAG, "checkReadyResult() extra is empty");
        return false;
    L9:
        getProcessorContext().getFileModel().o(r3);
        return true;
    }
}
