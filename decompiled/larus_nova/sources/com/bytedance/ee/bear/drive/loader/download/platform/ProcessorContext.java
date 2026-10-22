package com.bytedance.ee.bear.drive.loader.download.platform;

import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import com.ss.android.lark.passportc.entity.UserSession;
import w75.c;
import w75.d;

/* JADX INFO: loaded from: classes16.dex */
public class ProcessorContext {
    private final IDownloader.ICallback callback;
    private final DownloadOptions downloadOptions;
    private final c fileModel;
    private final d.a previewMsg;
    private final IResourceHolder resourceHolder;
    private final a95.a userComponentAbility;

    public UserSession getUserSession() {
        return this.userComponentAbility.f2278b;
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

    public ProcessorContext(c r100, IDownloader.ICallback r101, IResourceHolder r102, a95.a r103, DownloadOptions r104) {
        this.fileModel = r100;
        this.previewMsg = null;
        this.callback = r101;
        this.resourceHolder = r102;
        this.userComponentAbility = r103;
        this.downloadOptions = r104;
    }

    public ProcessorContext(c r100, d.a r101, IDownloader.ICallback r102, IResourceHolder r103, a95.a r104, DownloadOptions r105) {
        this.fileModel = r100;
        this.previewMsg = r101;
        this.callback = r102;
        this.resourceHolder = r103;
        this.userComponentAbility = r104;
        this.downloadOptions = r105;
    }
}
