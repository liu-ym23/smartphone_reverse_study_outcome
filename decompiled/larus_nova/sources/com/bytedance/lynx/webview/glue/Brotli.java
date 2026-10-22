package com.bytedance.lynx.webview.glue;

import android.content.res.AssetManager;
import l17.k;

/* JADX INFO: loaded from: classes21.dex */
public class Brotli {
    public Brotli() {
    }

    public static native boolean decompressAssetsFile(AssetManager r100, String r101, String r102);

    private static native boolean decompressFile(String r100, String r101);

    public static boolean decompress(String r100, String r101) {
        return decompressFile(r100, r101);
    L4:
        th = move-exception;
        th.printStackTrace();
        k.b(new String[]{"decompress error:" + th.toString()});
        return false;
    }
}
