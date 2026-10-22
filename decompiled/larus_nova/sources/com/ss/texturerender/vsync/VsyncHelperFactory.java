package com.ss.texturerender.vsync;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.ss.texturerender.DeviceManager;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;

/* JADX INFO: loaded from: classes40.dex */
public final class VsyncHelperFactory {
    private static String TAG = "VsyncHelperFactory";

    public VsyncHelperFactory() {
    }

    public static IVsyncHelper createVsyncHelper(Context r100, int r101, Bundle r102) {
        if (DeviceManager.isVRDevice() == true) goto L5;
        float r103 = 60.0f;
        if (r102 == null) goto L9;
        float r104 = r102.getFloat(TextureRenderKeys.KEY_IS_VSYNC_FPS);
    L10:
        Display r105 = null;
        if (r100 == null) goto L15;
        r100 = r100.getApplicationContext();
        WindowManager r106 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r106 == null) goto L15;
        r105 = r106.getDefaultDisplay();
    L15:
        if (r105 == null) goto L17;
        r103 = r105.getRefreshRate();
    L17:
        TextureRenderLog.d(r101, TAG, "fpsWanted:" + r104 + ",defaultDisplayRefreshRate:" + r103);
        if (r104 >= r103) goto L25;
        if (r104 <= 0.0f) goto L25;
        return new LocalVsyncHelper(r101, r104);
    L25:
        return new VsyncHelper(r100, r101);
    L9:
        r104 = 60.0f;
        goto L10
    L5:
        return new VRVsyncHelper();
    }
}
