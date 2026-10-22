package com.bytedance.ttnet.config;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class JsonOptConfig {
    private static volatile boolean mEnableJsonOpt;
    private static volatile boolean mEnableTNCJsonOpt;
    private static volatile IJsonHandler mJsonHandler;

    /* JADX INFO: loaded from: classes22.dex */
    public interface IJsonHandler {
        String optString(String r100, String[] r101);
    }

    public static class JsonWrapper {
        private JSONObject mJsonObject;
        private String mJsonStr;

        public boolean isValid() {
            if (TextUtils.isEmpty(this.mJsonStr) == false) goto L10;
            JSONObject r100 = this.mJsonObject;
            if (r100 != null) goto L7;
        L9:
            return false;
        L7:
            if (r100.length() <= 0) goto L9;
        L10:
            return true;
        }

        public JSONObject jsonObject() throws JSONException {
            if (this.mJsonObject != null) goto L6;
            this.mJsonObject = new JSONObject(this.mJsonStr);
        L6:
            return this.mJsonObject;
        }

        public String jsonStr() {
            if (TextUtils.isEmpty(this.mJsonStr) == false) goto L6;
            this.mJsonStr = this.mJsonObject.toString();
        L6:
            return this.mJsonStr;
        }

        public JsonWrapper(String r100, JSONObject r101) {
            this.mJsonStr = r100;
            this.mJsonObject = r101;
        }
    }

    public JsonOptConfig() {
    }

    public static boolean isJsonOptEnable() {
        return mEnableJsonOpt;
    }

    public static boolean isTNCJsonOptEnable() {
        return mEnableTNCJsonOpt;
    }

    public static void enableJsonOpt(boolean r100) {
        mEnableJsonOpt = r100;
    }

    public static void enableTNCJsonOpt(boolean r100) {
        mEnableTNCJsonOpt = r100;
    }

    public static boolean isValid(Object r100) {
        if ((r100 instanceof String) == false) goto L10;
        if (((String) r100).length() > 0) goto L21;
        return false;
    L21:
        return true;
    L10:
        if ((r100 instanceof JSONObject) == false) goto L17;
        if (((JSONObject) r100).length() > 0) goto L22;
        return false;
    L22:
        return true;
    L17:
        if ((r100 instanceof JsonWrapper) == true) goto L19;
        return false;
    L19:
        return ((JsonWrapper) r100).isValid();
    }

    public static JSONObject jsonObject(Object r100) throws JSONException {
        if ((r100 instanceof String) == false) goto L7;
        return new JSONObject((String) r100);
    L7:
        if ((r100 instanceof JSONObject) == false) goto L11;
        return (JSONObject) r100;
    L11:
        if ((r100 instanceof JsonWrapper) == true) goto L13;
        return null;
    L13:
        return ((JsonWrapper) r100).jsonObject();
    }

    public static void setJsonHandler(IJsonHandler r100) {
        mJsonHandler = r100;
    }

    public static JSONObject tncJSONObject(Object r100) {
        if ((r100 instanceof JSONObject) == false) goto L7;
        return (JSONObject) r100;
    L7:
        if ((r100 instanceof JsonWrapper) == false) goto L13;
        return ((JsonWrapper) r100).jsonObject().optJSONObject("data");
    L10:
        th = move-exception;
        th.printStackTrace();
    L13:
        return new JSONObject();
    }

    public static String optString(Object r100, JSONObject r101, String[] r102) {
        if (r102 != null) goto L5;
    L7:
        String r103 = null;
    L9:
        if (TextUtils.isEmpty(r103) == false) goto L12;
        return null;
    L12:
        if (mJsonHandler == null) goto L18;
        if ((r100 instanceof JsonWrapper) == false) goto L18;
        return mJsonHandler.optString(((JsonWrapper) r100).jsonStr(), r102);
    L18:
        return r101.optString(r103);
    L5:
        if (r102.length <= 0) goto L7;
        r103 = r102[r102.length - 1];
        goto L9
    }
}
