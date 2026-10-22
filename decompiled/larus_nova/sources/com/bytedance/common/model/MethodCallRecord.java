package com.bytedance.common.model;

import android.text.TextUtils;
import com.bytedance.common.push.BaseJson;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class MethodCallRecord extends BaseJson {
    private String args;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f202964id;
    private List listArgs;
    private String methodName;
    private String originProcessSuffix;
    private String targetProcessSuffix;

    public String toString() {
        return "MethodCallRecord{originProcessSuffix='" + this.originProcessSuffix + "', targetProcessSuffix='" + this.targetProcessSuffix + "', methodName='" + this.methodName + "', args='" + this.args + "', id='" + this.f202964id + "'}";
    }

    public String getArgs() {
        return this.args;
    }

    public String getId() {
        return this.f202964id;
    }

    public List getListArgs() {
        return this.listArgs;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public String getOriginProcessSuffix() {
        return this.originProcessSuffix;
    }

    public String getTargetProcessSuffix() {
        return this.targetProcessSuffix;
    }

    public MethodCallRecord(String r100, String r101, String r102, List r103) {
        this.originProcessSuffix = r100;
        this.targetProcessSuffix = r101;
        this.methodName = r102;
        this.listArgs = r103;
        if (r103 != null) goto L5;
        this.args = new JSONObject().toString();
        return;
    L5:
        JSONObject r104 = new JSONObject();
        int r105 = 0;
    L7:
        if (r105 >= r103.size()) goto L9;
        add(r104, r105 + "", ListProtector.get(r103, r105).toString());
        r105 = r105 + 1;
        goto L7
    L9:
        this.args = r104.toString();
    }

    public MethodCallRecord(String r100, String r101, String r102, String r103, String r104) {
        this.originProcessSuffix = r100;
        this.targetProcessSuffix = r101;
        this.methodName = r102;
        this.args = r103;
        this.f202964id = r104;
        if (TextUtils.isEmpty(r103) == true) goto L14;
        JSONObject r105 = new JSONObject(r103);     // Catch: JSONException -> L8
        int r106 = r105.length();     // Catch: JSONException -> L8
        this.listArgs = new ArrayList();     // Catch: JSONException -> L8
        int r107 = 0;
    L5:
        if (r107 >= r106) goto L15;
        this.listArgs.add(JSONObjectProtectorUtils.getString(r105, r107 + ""));     // Catch: JSONException -> L8
        r107 = r107 + 1;
        goto L5
    L15:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
