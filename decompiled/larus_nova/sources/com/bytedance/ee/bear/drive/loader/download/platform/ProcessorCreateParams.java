package com.bytedance.ee.bear.drive.loader.download.platform;

import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import w75.c;

/* JADX INFO: loaded from: classes16.dex */
public class ProcessorCreateParams {
    public final IDownloader.ICallback callback;
    public final DownloadOptions downloadOptions;
    public final c fileModel;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.loader.download.platform.ProcessorCreateParams$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private IDownloader.ICallback callback;
        private DownloadOptions downloadOptions;
        private c fileModel;

        public ProcessorCreateParams build() {
            return new ProcessorCreateParams(this, null);
        }

        public static /* synthetic */ c access$000(Builder r100) {
            return r100.fileModel;
        }

        public static /* synthetic */ IDownloader.ICallback access$100(Builder r100) {
            return r100.callback;
        }

        public static /* synthetic */ DownloadOptions access$200(Builder r100) {
            return r100.downloadOptions;
        }

        public Builder downloadOptions(DownloadOptions r100) {
            this.downloadOptions = r100;
            return this;
        }

        public Builder(c r100, IDownloader.ICallback r101) {
            this.downloadOptions = DownloadOptions.defaultOptions();
            this.fileModel = r100;
            this.callback = r101;
        }
    }

    public String toString() {
        return "ProcessorCreateParams{fileModel=" + this.fileModel + ", callback=" + this.callback + ", downloadOptions=" + this.downloadOptions + '}';
    }

    private ProcessorCreateParams(Builder r100) {
        this.fileModel = Builder.access$000(r100);
        this.callback = Builder.access$100(r100);
        this.downloadOptions = Builder.access$200(r100);
    }

    public /* synthetic */ ProcessorCreateParams(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
