package com.lynx.devtool.memory;

import android.content.Context;
import com.alipay.sdk.m.p.e;
import com.lynx.debugrouter.DebugRouter;
import com.lynx.devtoolwrapper.MemoryListener;
import com.lynx.tasm.base.LLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class MemoryController implements MemoryListener.MemoryReporter {
    private static final String TAG = "MemoryController";
    private static final String TYPE = "CDP";
    private Context mContext;

    public static class MemoryControllerLoader {
        private static final MemoryController INSTANCE = null;

        private MemoryControllerLoader() {
        }

        static {
            INSTANCE = new MemoryController();
        }

        public static /* synthetic */ MemoryController access$000() {
            return INSTANCE;
        }
    }

    public MemoryController() {
    }

    public static MemoryController getInstance() {
        return MemoryControllerLoader.access$000();
    }

    public void startMemoryTracing() {
        MemoryListener.getInstance().addMemoryReporter(this);
    }

    public void stopMemoryTracing() {
        MemoryListener.getInstance().removeMemoryReporter(this);
    }

    public void init(Context r100) {
        this.mContext = r100;
    }

    @Override // com.lynx.devtoolwrapper.MemoryListener.MemoryReporter
    public void uploadImageInfo(JSONObject r100) {
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L4
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L4
        r101.put(e.f25671s, "Memory.uploadImageInfo");     // Catch: JSONException -> L4
        r102.put("data", r100);     // Catch: JSONException -> L4
        r101.put("params", r102);     // Catch: JSONException -> L4
        DebugRouter.getInstance().sendDataAsync(TYPE, -1, r101.toString());     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        LLog.e(TAG, "Memory uploadImageInfo construct JSONObject failed:" + e.toString());
    }
}
