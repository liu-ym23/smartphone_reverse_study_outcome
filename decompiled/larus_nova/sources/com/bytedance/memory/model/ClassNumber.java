package com.bytedance.memory.model;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public class ClassNumber implements Serializable {
    private static final long serialVersionUID = -3511673943004282406L;
    private String mClassName;
    private int mCount;

    public ClassNumber() {
    }

    public String toString() {
        JSONObject r100 = new JSONObject();
        r100.put("object_class", this.mClassName);     // Catch: JSONException -> L5
        r100.put("instance_count", this.mCount);     // Catch: JSONException -> L5
    L8:
        return r100.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public String getClassName() {
        return this.mClassName;
    }

    public int getCount() {
        return this.mCount;
    }

    public void setClassName(String r100) {
        this.mClassName = r100;
    }

    public void setCount(int r100) {
        this.mCount = r100;
    }
}
