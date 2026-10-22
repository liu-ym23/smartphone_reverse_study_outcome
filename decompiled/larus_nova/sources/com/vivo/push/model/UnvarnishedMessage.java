package com.vivo.push.model;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.vivo.push.util.q;
import com.vivo.push.util.t;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class UnvarnishedMessage {
    private static final String TAG = "UnvarnishedMessage";
    private String mMessage;
    private long mMsgId;
    private Map<String, String> mParams;
    private int mTargetType;
    private String mTragetContent;
    private int mTransmissionMessageEventType;

    public boolean isTransMsgArrive() {
        if (this.mTransmissionMessageEventType != 0) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean isTransMsgExpired() {
        if (this.mTransmissionMessageEventType != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public String unpackToJson() {
        JSONArray r100 = new JSONArray();
        r100.put(this.mTargetType);
        r100.put(this.mTragetContent);
        r100.put(this.mMessage);
        Object r101 = this.mParams;
        if (r101 != null) goto L5;
        r101 = new HashMap();
    L5:
        r100.put(r101);
        return r100.toString();
    }

    public UnvarnishedMessage() {
        this.mParams = new HashMap();
        this.mTransmissionMessageEventType = 0;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public long getMsgId() {
        return this.mMsgId;
    }

    public Map<String, String> getParams() {
        return this.mParams;
    }

    public int getTargetType() {
        return this.mTargetType;
    }

    public String getTragetContent() {
        return this.mTragetContent;
    }

    public UnvarnishedMessage(String r100) {
        this.mParams = new HashMap();
        this.mTransmissionMessageEventType = 0;
        packToObj(r100);
    }

    private void packToObj(String r100) {
    L9:
        e = move-exception;
        e.printStackTrace();
        t.a(TAG, "unvarnishedMsg pack to obj error", e);
        return;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        t.a(TAG, "unvarnishedMsg pack to obj is null");     // Catch: JSONException -> L9
        return;
    L7:
        JSONArray r101 = new JSONArray(r100);     // Catch: JSONException -> L9
        this.mTargetType = r101.optInt(0);     // Catch: JSONException -> L9
        this.mTragetContent = JSONArrayProtectorUtils.getString(r101, 1);     // Catch: JSONException -> L9
        this.mMessage = JSONArrayProtectorUtils.getString(r101, 2);     // Catch: JSONException -> L9
        this.mParams = q.a(new JSONObject(JSONArrayProtectorUtils.getString(r101, 3)));     // Catch: JSONException -> L9
    }

    public void setMessage(String r100) {
        this.mMessage = r100;
    }

    public void setMsgId(long r100) {
        this.mMsgId = r100;
    }

    public void setParams(Map<String, String> r100) {
        this.mParams = r100;
    }

    public void setTargetType(int r100) {
        this.mTargetType = r100;
    }

    public void setTragetContent(String r100) {
        this.mTragetContent = r100;
    }

    public void setTransmissionMessageEventType(int r100) {
        this.mTransmissionMessageEventType = r100;
    }
}
