package com.ss.bytertc.engine.data;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class EngineConfig {
    private static final String TAG = "EngineConfig";
    public String appID;
    public Context context;
    public Object eglContext;
    public String nativeLoadPath;
    public JSONObject parameters;

    public EngineConfig() {
        this.context = null;
        this.eglContext = null;
        this.nativeLoadPath = null;
        this.parameters = null;
    }
}
