package com.miui.easygo.manager;

import android.content.Context;
import android.os.Bundle;
import com.miui.easygo.callback.IEasyGoCallback;
import com.miui.easygo.sdk.module.EasyGoRet;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class EasyGoManager {
    private static final String TAG = "EasyGoManager";
    private Context mContext;

    private int initFunction(String r100) {
        return 560;
    }

    public int getRomSupStatus(Context r100, String r101) {
        return 0;
    }

    public List<Integer> init(String[] r100) {
        return null;
    }

    public void invokeAsync(String r100, String r101, JSONObject r102, Bundle r103, IEasyGoCallback r104) {
    }

    public EasyGoRet invokeSync(String r100, String r101, JSONObject r102, Bundle r103) {
        return null;
    }

    public void release() {
    }

    public EasyGoManager(Context r100) {
        this.mContext = null;
        this.mContext = r100;
    }
}
