package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class RecordingProgress {
    public long duration;
    public long fileSize;

    public RecordingProgress(long r100, long r101) {
        this.duration = r100;
        this.fileSize = r101;
    }

    public static RecordingProgress create(long r100, long r101) {
        return new RecordingProgress(r100, r101);
    }
}
