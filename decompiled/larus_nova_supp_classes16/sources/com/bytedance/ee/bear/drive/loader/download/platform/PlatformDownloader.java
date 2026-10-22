package com.bytedance.ee.bear.drive.loader.download.platform;

import c85.e;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloadStrategy;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.ProxyCallback;
import com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.IProcessor;
import g85.f;
import io.reactivex.Flowable;
import java.util.Collections;
import o75.b;
import w75.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PlatformDownloader implements IDownloader, IResourceHolder {
    private static final String TAG = "DrivePlatform_PlatformDownloader";
    private AdjusterExecutor adjusterExecutor;
    private final IApiExecutor apiExecutor;
    private e cacheHandler;
    private com.bytedance.ee.bear.drive.report.a devReport;
    private final IDownloadStrategy downloadStrategy;
    private q75.a driveConfig;
    private f mimeTypeManager;
    private ProcessorCreator processorCreator;
    private a95.a userComponentAbility;

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.IResourceHolder
    public String getAppId() {
        return this.apiExecutor.getAppId();
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.IResourceHolder
    public IApiExecutor getApiExecutor() {
        return this.apiExecutor;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.IResourceHolder
    public e getCacheHandler() {
        return this.cacheHandler;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.IResourceHolder
    public com.bytedance.ee.bear.drive.report.a getDevReport() {
        return this.devReport;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.IResourceHolder
    public IDownloadStrategy getDownloadStrategy() {
        return this.downloadStrategy;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.IResourceHolder
    public q75.a getDriveConfig() {
        return this.driveConfig;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.IResourceHolder
    public f getMimeTypeManager() {
        return this.mimeTypeManager;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader
    public void addCustomizationAdjust(IPriorityAdjuster r2) {
        AdjusterExecutor r0 = this.adjusterExecutor;
        if (r0 == null) goto L6;
        r0.addCustomizationAdjuster(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader
    public void adjustPriority(c r2) {
        this.adjusterExecutor.execPreviewAdjust(r2);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader
    public Flowable<Boolean> downloadManualCacheFile(c r3, IDownloader.ICallback r4) {
        ProxyCallback r0 = new ProxyCallback(r4);
        this.adjusterExecutor.execManualCacheAdjust(r3);
        ProcessorCreateParams r5 = new ProcessorCreateParams.Builder(r3, r0).build();
        IProcessor r6 = this.processorCreator.createSimilarFileProcessor(r5);
        return new DownloadTask(this.processorCreator.create(r5, r6), r0, this).execute();
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader
    public Flowable<Boolean> downloadPreloadFile(c r3, IDownloader.ICallback r4) {
        ProxyCallback r0 = new ProxyCallback(r4);
        this.adjusterExecutor.execPreloadAdjust(r3);
        ProcessorCreateParams r5 = new ProcessorCreateParams.Builder(r3, r0).build();
        IProcessor r6 = this.processorCreator.createNotSupportProcessor(r5);
        return new DownloadTask(this.processorCreator.create(r5, r6), r0, this).execute();
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader
    public Flowable<Boolean> downloadSourceFilePreView(c r2, IDownloader.ICallback r3) {
        ProxyCallback r0 = new ProxyCallback(r3);
        return new DownloadTask(Collections.singletonList(this.processorCreator.createSourceFilePreviewProcessor(r2, r0)), r0, this).execute();
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader
    public Flowable<Boolean> downloadPreviewFile(c r2, IDownloader.ICallback r3, DownloadOptions r4) {
        ProxyCallback r0 = new ProxyCallback(r3);
        this.adjusterExecutor.execPreviewAdjust(r2);
        ProcessorCreateParams r5 = new ProcessorCreateParams.Builder(r2, r0).downloadOptions(r4).build();
        IProcessor r6 = this.processorCreator.createNotSupportProcessor(r5);
        return new DownloadTask(this.processorCreator.create(r5, r6), r0, this).execute();
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader
    public Flowable<Boolean> downloadSourceFile(c r2, IDownloader.ICallback r3, DownloadOptions r4) {
        ProxyCallback r0 = new ProxyCallback(r3);
        ProcessorCreateParams r5 = new ProcessorCreateParams.Builder(r2, r0).downloadOptions(r4).build();
        return new DownloadTask(Collections.singletonList(this.processorCreator.createSourceFileProcessor(r5)), r0, this).execute();
    }

    private PlatformDownloader(IApiExecutor r2, IDownloadStrategy r3, e r4, a95.a r5) {
        this.userComponentAbility = r5;
        o75.a r0 = b.a();
        this.apiExecutor = r2;
        this.downloadStrategy = r3;
        this.mimeTypeManager = r0.getMimeTypeManager();
        this.cacheHandler = r4;
        this.driveConfig = r0.getDriveConfig();
        this.adjusterExecutor = new AdjusterExecutor(this);
        this.processorCreator = new ProcessorCreator(this, r5);
        this.devReport = r0.Tb();
    }

    public static IDownloader create(IApiExecutor r1, IDownloadStrategy r2, e r3, a95.a r4) {
        return new PlatformDownloader(r1, r2, r3, r4);
    }
}
