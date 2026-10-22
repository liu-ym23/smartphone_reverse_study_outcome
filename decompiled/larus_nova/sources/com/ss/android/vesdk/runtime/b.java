package com.ss.android.vesdk.runtime;

import android.text.TextUtils;
import com.obric.sva.sdk.controller.Global;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;

/* JADX INFO: loaded from: classes40.dex */
public final class b extends VERecorderResManager {
    @Override // com.ss.android.vesdk.runtime.VERecorderResManager
    public final String getSegmentDirPath() {
        if (TextUtils.isEmpty(this.mSegmentDirPath) == false) goto L6;
        this.mSegmentDirPath = this.mWorkspace + File.separator + DBDefinition.SEGMENT_TABLE_NAME;
    L6:
        return this.mSegmentDirPath;
    }

    public b(String r100) {
        super(r100);
    }

    @Override // com.ss.android.vesdk.runtime.VERecorderResManager
    public final String genSegmentAudioPath(int r100) {
        return d.b(this.mWorkspace, DBDefinition.SEGMENT_TABLE_NAME) + File.separator + r100 + Global.SUFFIX_WAV_FILE;
    }

    @Override // com.ss.android.vesdk.runtime.VERecorderResManager
    public final String genSegmentVideoPath(int r100) {
        return d.b(this.mWorkspace, DBDefinition.SEGMENT_TABLE_NAME) + File.separator + r100 + ".mp4";
    }
}
