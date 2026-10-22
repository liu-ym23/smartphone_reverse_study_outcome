package com.bytedance.ee.bear.drive.loader.download.platform;

import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import com.ss.android.lark.passportc.entity.UserSession;
import w75.c;
import w75.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ProcessorContext {
    private final IDownloader.ICallback callback;
    private final DownloadOptions downloadOptions;
    private final c fileModel;
    private final d.a previewMsg;
    private final IResourceHolder resourceHolder;
    private final a95.a userComponentAbility;

    public UserSession getUserSession() {
        return this.userComponentAbility.b;
    }

    public IDownloader.ICallback getCallback() {
        return this.callback;
    }

    public DownloadOptions getDownloadOptions() {
        return this.downloadOptions;
    }

    public c getFileModel() {
        return this.fileModel;
    }

    public d.a getPreviewEntity() {
        return this.previewMsg;
    }

    public IResourceHolder getResourceHolder() {
        return this.resourceHolder;
    }

    public a95.a getUserComponentAbility() {
        return this.userComponentAbility;
    }

    public ProcessorContext(c r1, IDownloader.ICallback r2, IResourceHolder r3, a95.a r4, DownloadOptions r5) {
        this.fileModel = r1;
        this.previewMsg = null;
        this.callback = r2;
        this.resourceHolder = r3;
        this.userComponentAbility = r4;
        this.downloadOptions = r5;
    }

    public ProcessorContext(c r1, d.a r2, IDownloader.ICallback r3, IResourceHolder r4, a95.a r5, DownloadOptions r6) {
        this.fileModel = r1;
        this.previewMsg = r2;
        this.callback = r3;
        this.resourceHolder = r4;
        this.userComponentAbility = r5;
        this.downloadOptions = r6;
    }
}
