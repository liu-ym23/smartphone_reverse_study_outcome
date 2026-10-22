package com.bytedance.ee.bear.drive.loader.download.platform.processor;

import android.app.Application;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.loader.download.platform.ProcessorContext;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.misc.RustCallback;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SourceFilePreviewProcessor extends AbsProcessor {
    private static final String PREVIEW_DOWNLOAD_KEY = "_previewType_";
    private static final String TAG = "DrivePlatform_SourceFileProcessor";

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsProcessor
    public void onShutdown() {
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsProcessor
    public IProcessor.Result onProcess() {
        tt5.a.h(TAG, " start process");
        w75.c r3 = getProcessorContext().getFileModel();
        saveLocalPath(r3);
        IApiExecutor r0 = getProcessorContext().getResourceHolder().getApiExecutor();
        IDownloader.ICallback r8 = getProcessorContext().getCallback();
        long r4 = r3.getFileSize();
        if (r3.getDetails().e != 26) goto L5;
        r4 = 0;
    L5:
        String r2 = r0.downloadByPreviewUrl(r3, r4, RustCallback.wrap(r8), getProcessorContext().getResourceHolder().getDownloadStrategy().downloadPriority());
        if (r0.isDownloadSuccess(r2) == true) goto L9;
        tt5.a.d(TAG, getClass().getSimpleName().concat(" submit rust failure, return rust key: -1"));
        return IProcessor.Result.failAndContinue(new DriveException(ErrCode.RUST_SUBMIT_ERROR, "Rust internal error, return key is -1"));
    L9:
        r8.onSubmit(r2);
        tt5.a.h(TAG, getClass().getSimpleName() + " submit rust success, return rust key: " + r2);
        return IProcessor.Result.success();
    }

    public SourceFilePreviewProcessor(ProcessorContext r1) {
        super(r1);
    }

    private void saveLocalPath(w75.c r4) {
        Application r0 = eu5.b.a;
        DriveFilePath r1 = t.f();
        r1.cacheName(t.d(r4) + PREVIEW_DOWNLOAD_KEY + r4.getDetails().e);
        r4.g(r1);
    }
}
