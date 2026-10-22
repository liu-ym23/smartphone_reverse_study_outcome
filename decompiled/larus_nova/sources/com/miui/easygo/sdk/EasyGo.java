package com.miui.easygo.sdk;

import android.content.Context;
import android.os.Bundle;
import com.huawei.easygo.BuildConfig;
import com.miui.easygo.callback.IEasyGoCallback;
import com.miui.easygo.manager.EasyGoManager;
import com.miui.easygo.sdk.module.EasyGoRet;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class EasyGo {
    private static final String TAG = "EasyGo";
    private EasyGoManager mEasyGoManager;

    public final void release() {
        EasyGoManager r100 = this.mEasyGoManager;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    public EasyGo(Context r100) {
        this.mEasyGoManager = null;
        if (getRomSupStatus(r100) != 0) goto L6;
        this.mEasyGoManager = new EasyGoManager(r100);
        return;
    }

    private List<Integer> assembleInitFailRet(String[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return Collections.nCopies(r100.length, 507);
    }

    private int getRomSupStatus(Context r100) {
        return new EasyGoManager(r100).getRomSupStatus(r100, BuildConfig.VERSION_NAME);
    L4:
        return 509;
    L8:
        return 506;
    L6:
        return 508;
    }

    public final List<Integer> init(String[] r100) {
        EasyGoManager r101 = this.mEasyGoManager;
        if (r101 != null) goto L6;
        return assembleInitFailRet(r100);
    L6:
        return r101.init(r100);
    }

    public final EasyGoRet invokeSync(String r100, String r101, JSONObject r102, Bundle r103) {
        EasyGoManager r104 = this.mEasyGoManager;
        if (r104 != null) goto L6;
        return new EasyGoRet(507, new Bundle());
    L6:
        return r104.invokeSync(r100, r101, r102, r103);
    }

    public final void invokeAsync(String r100, String r101, JSONObject r102, Bundle r110, IEasyGoCallback r111) {
        EasyGoManager r103 = this.mEasyGoManager;
        if (r103 == null) goto L6;
        r103.invokeAsync(r100, r101, r102, r110, r111);
        return;
    }
}
