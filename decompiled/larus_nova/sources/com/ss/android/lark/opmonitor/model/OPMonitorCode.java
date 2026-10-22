package com.ss.android.lark.opmonitor.model;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.log.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public class OPMonitorCode {
    private static final String TAG = "OPMonitorCode";
    public String ID;
    public int code;
    public String domain;
    public OPMonitorLevel level;
    public String message;
    private int version;

    private String generateID() {
        return this.version + "-" + this.domain + "-" + this.code;
    }

    public int hashCode() {
        return this.ID.hashCode();
    }

    public static OPMonitorCode fromJson(String r100) {
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L4
        return new OPMonitorCode(JSONObjectProtectorUtils.getString(r101, "domain"), JSONObjectProtectorUtils.getInt(r101, "code"), OPMonitorLevel.forNumber(JSONObjectProtectorUtils.getInt(r101, "level")), JSONObjectProtectorUtils.getString(r101, "message"));
    L4:
        e = move-exception;
        Log.e(TAG, "fromJson is exception", e);
        return null;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OPMonitorCode) == true) goto L10;
        return false;
    L10:
        return this.ID.equals(((OPMonitorCode) r100).ID);
    }

    public OPMonitorCode(String r100, int r101, OPMonitorLevel r102, String r103) {
        this.version = 1;
        this.domain = r100;
        this.code = r101;
        this.level = r102;
        this.message = r103;
        this.ID = generateID();
    }
}
