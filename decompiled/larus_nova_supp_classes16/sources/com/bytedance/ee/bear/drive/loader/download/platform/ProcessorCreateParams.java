package com.bytedance.ee.bear.drive.loader.download.platform;

import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import w75.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

        public static /* synthetic */ c access$000(Builder r0) {
            return r0.fileModel;
        }

        public static /* synthetic */ IDownloader.ICallback access$100(Builder r0) {
            return r0.callback;
        }

        public static /* synthetic */ DownloadOptions access$200(Builder r0) {
            return r0.downloadOptions;
        }

        public Builder downloadOptions(DownloadOptions r1) {
            this.downloadOptions = r1;
            return this;
        }

        public Builder(c r2, IDownloader.ICallback r3) {
            this.downloadOptions = DownloadOptions.defaultOptions();
            this.fileModel = r2;
            this.callback = r3;
        }
    }

    public String toString() {
        return "ProcessorCreateParams{fileModel=" + this.fileModel + ", callback=" + this.callback + ", downloadOptions=" + this.downloadOptions + '}';
    }

    private ProcessorCreateParams(Builder r2) {
        this.fileModel = Builder.access$000(r2);
        this.callback = Builder.access$100(r2);
        this.downloadOptions = Builder.access$200(r2);
    }

    public /* synthetic */ ProcessorCreateParams(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }
}
