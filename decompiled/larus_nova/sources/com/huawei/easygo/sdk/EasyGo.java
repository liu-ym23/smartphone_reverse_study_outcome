package com.huawei.easygo.sdk;

import android.content.Context;
import android.os.Bundle;
import com.huawei.easygo.BuildConfig;
import com.huawei.easygo.callback.IEasyGoCallback;
import com.huawei.easygo.manager.EasyGoManager;
import com.huawei.easygo.sdk.module.EasyGoRet;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public final class EasyGo {
    private static final String TAG = "EasyGo";
    private EasyGoManager mEasyGoManager;

    public void release() {
        EasyGoManager r100 = this.mEasyGoManager;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.release();
    }

    public EasyGo(Context r100) {
        this.mEasyGoManager = null;
        if (getRomSupStatus(r100) != 0) goto L6;
        this.mEasyGoManager = new EasyGoManager(r100);
        return;
    }

    private List<Integer> assembleInitFailRet(String[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
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

    public List<Integer> init(String[] r100) {
        EasyGoManager r101 = this.mEasyGoManager;
        if (r101 != null) goto L7;
        return assembleInitFailRet(r100);
    L7:
        return r101.init(r100);
    }

    public EasyGoRet invokeSync(String r100, String r101, JSONObject r102, Bundle r103) {
        EasyGoManager r104 = this.mEasyGoManager;
        if (r104 != null) goto L7;
        return new EasyGoRet(507, new Bundle());
    L7:
        return new EasyGoRet(r104.invokeSync(r100, r101, r102, r103));
    }

    public void invokeAsync(String r100, String r101, JSONObject r102, Bundle r110, IEasyGoCallback r111) {
        EasyGoManager r103 = this.mEasyGoManager;
        if (r103 != null) goto L5;
        return;
    L5:
        r103.invokeAsync(r100, r101, r102, r110, r111);
    }
}
