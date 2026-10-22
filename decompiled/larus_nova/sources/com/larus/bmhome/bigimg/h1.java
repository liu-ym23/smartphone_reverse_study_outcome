package com.larus.bmhome.bigimg;

import android.media.MediaScannerConnection;
import android.net.Uri;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes25.dex */
public final class h1 implements MediaScannerConnection.OnScanCompletedListener {
    public h1() {
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public final void onScanCompleted(String r100, Uri r101) {
        FLogger.f375446a.d("ImageFileUtils", "onScanCompleted: path: " + r100 + ", uri: " + r101);
    }
}
