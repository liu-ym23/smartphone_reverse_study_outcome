package com.lynx.devtool.recorder;

import android.content.Context;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public class LynxRecorderOpenUrlModule extends LynxModule {
    private static final String TAG = "LynxRecorderOpenUrlModule";

    public LynxRecorderOpenUrlModule(Context r100) {
        super(r100);
    }

    @LynxMethod
    public void openSchema(ReadableMap r100) {
        LLog.e(TAG, r100.toString());
        LynxRecorderPageManager.getInstance().replayPageFromOpenSchema(r100);
    }
}
