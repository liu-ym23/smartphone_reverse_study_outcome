package com.lynx.animax.player;

import android.media.MediaExtractor;
import com.lynx.animax.util.AnimaXLog;
import java.io.IOException;

/* JADX INFO: loaded from: classes32.dex */
public final class e {
    public static boolean a(MediaExtractor r100, String r101) {
        r100.setDataSource(r101);     // Catch: IOException -> L5
        return true;
    L5:
        e = move-exception;
        AnimaXLog.a("VideoAssetExtractor", "setDataSource IOException: " + e.getMessage());
        return false;
    }
}
