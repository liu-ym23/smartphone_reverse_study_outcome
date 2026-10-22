package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.android.ec.core.event.a;
import com.larksuite.framework.apiplugin.entity.LKBasePluginResult;
import com.ss.android.lark.log.Log;
import j18.k;

/* JADX INFO: loaded from: classes24.dex */
public class LKBaseRequestModel extends LKBaseModel {
    private static final String TAG = "LKBaseRequestModel";

    @JSONField(name = "appIdentify")
    public String mAppIdentify;

    @JSONField(serialize = false)
    private LKBasePluginResult.b.a mArrayBuffer;

    @JSONField(name = "isBackground")
    public boolean mIsBackground;

    @JSONField(serialize = false)
    private transient k mOutputParams;

    public String toString() {
        return JSON.toJSONString(this);
    L4:
        e = move-exception;
        Log.e(TAG, a.KEY_EXCEPTION, e);
        return "LKBaseRequestModel{mAppIdentify='" + this.mAppIdentify + "', mIsBackground=" + this.mIsBackground + '}';
    }

    public LKBaseRequestModel() {
    }

    public LKBasePluginResult.b.a getArrayBuffers() {
        return this.mArrayBuffer;
    }

    public k getOutputParams() {
        return this.mOutputParams;
    }

    public void setArrayBuffer(LKBasePluginResult.b.a r100) {
        this.mArrayBuffer = r100;
    }

    public void setOutputParams(k r100) {
        this.mOutputParams = r100;
    }
}
