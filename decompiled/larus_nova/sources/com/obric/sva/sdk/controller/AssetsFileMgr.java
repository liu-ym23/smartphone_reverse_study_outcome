package com.obric.sva.sdk.controller;

import android.content.Context;
import android.content.res.AssetManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.sva.sdk.effectplatform.EffectConstant;
import com.obric.sva.sdk.utils.FileKt;
import com.obric.sva.sdk.utils.LogUtils;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class AssetsFileMgr {
    private final String[] MODEL_ASSETS_FOLDER;
    private final String TAG;

    public AssetsFileMgr() {
        this.TAG = "AssetsFileMgr";
        this.MODEL_ASSETS_FOLDER = new String[]{"sa_qcom_model", "speech_kws_model"};
    }

    private void copyAssets(Context r110, String r210) {
        String r100 = r210;
        String r101 = HTTP.URL_DEFAULT;
        int r102 = 0;
        if (r100 != null) goto L5;
    L57:
        LogUtils.e(this.TAG, "copyAssets: invalid param", new Object[0]);
        return;
    L5:
        if (rna.c.c(r210) == false) goto L57;
        AssetManager r103 = r110.getAssets();
        String[] r104 = null;
        int r105 = 0;
    L8:
        String[] r106 = this.MODEL_ASSETS_FOLDER;
        if (r105 >= r106.length) goto L56;
        String r107 = r106[r105];
        r104 = r103.list(r107);     // Catch: IOException -> L13
    L15:
        if (r104 != null) goto L17;
    L54:
        String r111 = r101;
        AssetManager r112 = r103;
    L55:
        r105 = r105 + 1;
        r100 = r210;
        r101 = r111;
        r103 = r112;
        r102 = 0;
        goto L8
    L17:
        if (r104.length == 0) goto L54;
        String[] r108 = new String[r104.length];
        int r109 = r104.length;     // Catch: IOException -> L50
        int r113 = 0;
        int r114 = 0;
    L21:
        if (r113 >= r109) goto L46;
        String r115 = r104[r113];     // Catch: IOException -> L50
        String r116 = r107 + r101 + r115;     // Catch: IOException -> L50
        String r117 = r100 + r101 + r115;     // Catch: IOException -> L50
        InputStream r118 = r103.open(r116);     // Catch: IOException -> L50
        String r119 = this.TAG;     // Catch: IOException -> L50
        StringBuilder r120 = new StringBuilder();     // Catch: IOException -> L50
        r111 = r101;
        r120.append("copyAssets: outputFilePath = ");     // Catch: IOException -> L44
        r120.append(r117);     // Catch: IOException -> L44
        r120.append(" and sourceFile =");     // Catch: IOException -> L44
        r120.append(r116);     // Catch: IOException -> L44
        r112 = r103;
        LogUtils.d(r119, r120.toString(), new Object[0]);     // Catch: IOException -> L42
        PolarisFileWrapper r121 = new PolarisFileWrapper(r117);     // Catch: IOException -> L42
        if (r115.equals(EffectConstant.CURRENT_CONFIG_JSON) == false) goto L32;
        if (r121.exists() == false) goto L32;
        LogUtils.d(this.TAG, "copyAssets: current.json file , do not overwrite if exist,  just ignore", new Object[0]);     // Catch: IOException -> L42
    L59:
        r113 = r113 + 1;     // Catch: IOException -> L48
        r100 = r210;
        r101 = r111;
        r103 = r112;
    L48:
        e = e;
    L53:
        e.printStackTrace();
    L32:
        if (FileKt.isSameMD5(r118, r117) == false) goto L36;
        LogUtils.d(this.TAG, "copyAssets: exists yet and same md5, just ignore", new Object[0]);     // Catch: IOException -> L42
        goto L59
    L36:
        if (r121.exists() == false) goto L38;
        LogUtils.d(this.TAG, "copyAssets: delete the file due to copy again , caused by the different md5 ", new Object[0]);     // Catch: IOException -> L42
        r121.delete();     // Catch: IOException -> L42
    L38:
        LogUtils.d(this.TAG, "copyAssets: copy filename =  " + r115 + " from " + r116 + " to destDir :" + r117, new Object[0]);     // Catch: IOException -> L42
        copySingleAssetFile(r110, r116, r117);     // Catch: IOException -> L48
        r108[r114] = r117;     // Catch: IOException -> L48
        r114 = r114 + 1;     // Catch: IOException -> L48
    L42:
        e = e;
    L44:
        e = e;
    L52:
        r112 = r103;
        goto L53
    L46:
        r111 = r101;
        r112 = r103;
        LogUtils.d(this.TAG, "copyAssets: copy file number = " + r114, new Object[0]);     // Catch: IOException -> L48
    L50:
        e = e;
        r111 = r101;
    L13:
        e = move-exception;
        LogUtils.e(this.TAG, e.getMessage(), new Object[r102]);
        goto L15
    }

    public void copyAssetsIfNotExists(Context r100, String r101) {
        LogUtils.d(this.TAG, "copyAssetsIfNotExists: destDir = " + r101, new Object[0]);
        if (r101 != null) goto L6;
        LogUtils.e(this.TAG, "copyAssetsIfNotExists: invalid param", new Object[0]);
        return;
    L6:
        rna.c.a(r101);
        if (rna.c.c(r101) == false) goto L9;
        copyAssets(r100, r101);
        return;
    L9:
        LogUtils.e(this.TAG, "copyAssetsIfNotExists: create destDir failure", new Object[0]);
    }

    private void copySingleAssetFile(Context r100, String r101, String r102) throws IOException {
        InputStream r103 = r100.getAssets().open(r101);
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r102);
        byte[] r105 = new byte[1024];
    L3:
        int r106 = r103.read(r105);
        if (r106 == (-1)) goto L6;
        r104.write(r105, 0, r106);
        goto L3
    L6:
        r103.close();
        r104.flush();
        r104.close();
    }
}
