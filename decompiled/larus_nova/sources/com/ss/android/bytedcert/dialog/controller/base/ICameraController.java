package com.ss.android.bytedcert.dialog.controller.base;

import com.ss.android.bytedcert.config.ThemeConfig;
import com.ss.android.bytedcert.model.LiveInfo;
import osa.b;

/* JADX INFO: loaded from: classes34.dex */
public interface ICameraController {
    int getCameraStartType();

    b getCertInfo();

    LiveInfo getLiveInfo();

    ThemeConfig getThemeConfig();

    boolean isGLPause();

    boolean isLiveSdkPaused();

    void setTimestamp(String r100, String r101);
}
