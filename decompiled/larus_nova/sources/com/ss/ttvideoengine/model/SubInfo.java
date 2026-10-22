package com.ss.ttvideoengine.model;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class SubInfo {
    public static final String KEY_FORMAT = "format";
    public static final String KEY_LANGUAGE_ID = "language_id";
    public static final String KEY_SUB_ID = "sub_id";
    public static final String KEY_VERSION = "version";
    public static final int VALUE_SUB_INFO_FORMAT = 2;
    public static final int VALUE_SUB_INFO_ID = 0;
    public static final int VALUE_SUB_INFO_LANGUAGE_ID = 1;
    public static final int VALUE_SUB_INFO_VERSION = 3;
    private String mFormat;
    private int mLanguageId;
    private int mSubId;
    private String mVersion;

    public SubInfo() {
    }

    public void extractFields(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mSubId = r100.optInt(KEY_SUB_ID);
        this.mLanguageId = r100.optInt(KEY_LANGUAGE_ID);
        this.mFormat = r100.optString(KEY_FORMAT);
        this.mVersion = r100.optString("version");
    }

    public int getValueInt(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return -1;
    L8:
        return this.mLanguageId;
    L10:
        return this.mSubId;
    }

    public String getValueStr(int r100) {
        if (r100 == 2) goto L11;
        if (r100 == 3) goto L9;
        return "";
    L9:
        return this.mVersion;
    L11:
        return this.mFormat;
    }
}
