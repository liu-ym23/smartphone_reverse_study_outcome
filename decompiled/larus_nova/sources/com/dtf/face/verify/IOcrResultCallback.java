package com.dtf.face.verify;

import android.app.Activity;
import com.dtf.face.api.IDTUIListener;
import com.dtf.face.config.OSSConfig;

/* JADX INFO: loaded from: classes22.dex */
public interface IOcrResultCallback {
    Class<? extends Activity> getFaceVerifyClazz();

    OSSConfig getOSSConfig();

    IDTUIListener getUiCustomListener();

    void init();

    boolean needUseOss();

    void sendResAndExit(String r100);

    void updateBackBitmap(byte[] r100);

    void updateFrontBitmap(byte[] r100);

    void updateOcrInfo(String r100, String r101);
}
