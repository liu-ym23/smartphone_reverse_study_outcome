package com.ss.bytertc.engine.data;

import com.ss.bytertc.engine.type.RecordingFileType;

/* JADX INFO: loaded from: classes40.dex */
public class RecordingConfig {
    public String dirPath;
    public RecordingFileType recordingFileType;

    public RecordingConfig() {
        this.recordingFileType = RecordingFileType.MP4;
    }

    public RecordingConfig(String r100, RecordingFileType r101) {
        RecordingFileType r102 = RecordingFileType.AAC;
        this.dirPath = r100;
        this.recordingFileType = r101;
    }
}
