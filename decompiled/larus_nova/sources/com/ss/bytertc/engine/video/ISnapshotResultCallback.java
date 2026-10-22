package com.ss.bytertc.engine.video;

import android.graphics.Bitmap;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.StreamIndex;

/* JADX INFO: loaded from: classes40.dex */
public interface ISnapshotResultCallback {
    void onTakeLocalSnapshotResult(long r100, StreamIndex r101, Bitmap r102, int r103);

    void onTakeRemoteSnapshotResult(long r100, RemoteStreamKey r101, Bitmap r102, int r103);
}
