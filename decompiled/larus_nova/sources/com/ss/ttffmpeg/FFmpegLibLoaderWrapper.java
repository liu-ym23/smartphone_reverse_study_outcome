package com.ss.ttffmpeg;

/* JADX INFO: loaded from: classes40.dex */
public final class FFmpegLibLoaderWrapper {
    public FFmpegLibLoaderWrapper() {
    }

    public static synchronized String getFFmpegVersion() {
        monitor-enter(FFmpegLibLoaderWrapper.class);
        monitor-exit(FFmpegLibLoaderWrapper.class);
        return "1.1.252.50-net4-opus";
    }
}
