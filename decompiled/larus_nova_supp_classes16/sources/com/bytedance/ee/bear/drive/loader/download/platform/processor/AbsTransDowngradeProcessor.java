package com.bytedance.ee.bear.drive.loader.download.platform.processor;

import android.text.TextUtils;
import c85.e;
import com.bytedance.ee.bear.drive.loader.download.platform.IResourceHolder;
import com.bytedance.ee.bear.drive.loader.download.platform.ProcessorContext;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloadStrategy;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IPreviewGetModel;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.misc.TransformRecorder;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import g85.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class AbsTransDowngradeProcessor extends AbsProcessor {
    protected final IApiExecutor apiExecutor;
    protected final e cacheHandler;
    protected final IDownloader.ICallback callback;
    protected final w75.c fileModel;
    protected volatile boolean isDowngraded;
    protected final f mimeTypeManager;
    protected IApiExecutor.PreviewGet previewGet;
    protected final DrivePriority.DownloadPriority priority;
    protected final IDownloadStrategy strategy;
    protected final TransformRecorder transformRecorder;

    public final IPreviewGetModel getPreviewGetData() throws Throwable {
        if (this.strategy.enablePreviewGetPolling() == false) goto L5;
        IApiExecutor.PreviewGet r0 = this.apiExecutor.pollPreviewGet();
        this.previewGet = r0;
        r0.setTransformStartListener(new AnonymousClass1(this));
        return this.previewGet.execute(this.fileModel);
    L5:
        return this.apiExecutor.pullPreviewGet(this.fileModel);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsProcessor
    public void onShutdown() {
        IApiExecutor.PreviewGet r0 = this.previewGet;
        if (r0 == null) goto L6;
        r0.shutdown();
        return;
    }

    public AbsTransDowngradeProcessor(ProcessorContext r2) {
        super(r2);
        this.isDowngraded = false;
        this.transformRecorder = new TransformRecorder(r2);
        this.fileModel = r2.getFileModel();
        this.callback = r2.getCallback();
        IResourceHolder r3 = r2.getResourceHolder();
        this.cacheHandler = r3.getCacheHandler();
        this.apiExecutor = r3.getApiExecutor();
        this.strategy = r3.getDownloadStrategy();
        this.priority = r3.getDownloadStrategy().downloadPriority();
        this.mimeTypeManager = o75.b.a().getMimeTypeManager();
    }

    public final boolean isResultReady(IPreviewGetModel r1) {
        if (r1.getStatus() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSupportDowngrade(int r3, w75.c r4) {
        String r5 = r4.I();
        if (r3 == 1) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r5) == false) goto L8;
        return false;
    L8:
        if (this.isDowngraded == false) goto L10;
        return false;
    L10:
        if (((g85.b) this.mimeTypeManager).l(r5) == true) goto L12;
        return false;
    L12:
        if (((g85.b) this.mimeTypeManager).m(r5) == false) goto L14;
    L15:
        this.isDowngraded = true;
        return true;
    L14:
        if (((g85.b) this.mimeTypeManager).j(r5, null) == true) goto L15;
        return false;
    }
}
