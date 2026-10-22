package com.huawei.hms.support.api.entity.hwid;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.hwid.as;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class SignInReq implements IMessageEntity {
    private static final String KEY_DYNAMIC_PERMISSIONS = "dynamicpermissions";
    private static final String KEY_SCOPES = "scopes";
    private static final String KEY_SDK_VERSION = "sdkVersion";
    protected static final String TAG = "[SignInReq]SignInReq";

    @Packed
    public String mLocalJsonObject;

    private JSONObject getJsonObj() {
        if (this.mLocalJsonObject != null) goto L8;
        return null;
    L8:
        return new JSONObject(this.mLocalJsonObject);
    L7:
        return null;
    }

    public List<String> getPermissionInfos() {
        JSONObject r100 = getJsonObj();
        if (r100 == null) goto L5;
        JSONArray r101 = JSONObjectProtectorUtils.getJSONArray(r100, KEY_DYNAMIC_PERMISSIONS);     // Catch: JSONException -> L17
        if (r101 == null) goto L16;
        if (r101.length() <= 0) goto L16;
        ArrayList r102 = new ArrayList();     // Catch: JSONException -> L17
        int r103 = r101.length();     // Catch: JSONException -> L17
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L14;
        r102.add(JSONArrayProtectorUtils.getString(r101, r104));     // Catch: JSONException -> L17
        r104 = r104 + 1;
        goto L11
    L14:
        return r102;
    L16:
        return new ArrayList(0);
    L18:
        return new ArrayList(0);
    L5:
        return new ArrayList(0);
    }

    public List<String> getScopes() {
        JSONObject r100 = getJsonObj();
        if (r100 == null) goto L5;
        JSONArray r101 = JSONObjectProtectorUtils.getJSONArray(r100, "scopes");     // Catch: JSONException -> L17
        if (r101 == null) goto L16;
        if (r101.length() <= 0) goto L16;
        ArrayList r102 = new ArrayList();     // Catch: JSONException -> L17
        int r103 = r101.length();     // Catch: JSONException -> L17
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L14;
        r102.add(JSONArrayProtectorUtils.getString(r101, r104));     // Catch: JSONException -> L17
        r104 = r104 + 1;
        goto L11
    L14:
        return r102;
    L16:
        return new ArrayList(0);
    L18:
        return new ArrayList(0);
    L5:
        return new ArrayList(0);
    }

    public String getSignInParams() {
        JSONObject r100 = getJsonObj();
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.optString(CommonConstant.RequestParams.KEY_SIGN_IN_PARAMS);
    }

    public SignInReq() {
    }

    public SignInReq(Set<String> r100, Set<String> r101) {
        this(r100, r101, "");
    }

    public SignInReq(Set<String> r100, Set<String> r101, String r102) {
        JSONArray r103 = new JSONArray();
        Iterator<String> r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.put(r104.next());
        goto L4
    L6:
        JSONArray r105 = new JSONArray();
        Iterator<String> r106 = r101.iterator();
    L8:
        if (r106.hasNext() == false) goto L10;
        r105.put(r106.next());
        goto L8
    L10:
        JSONObject r107 = new JSONObject();
        r107.put("scopes", r103);     // Catch: JSONException -> L16
        r107.put(KEY_DYNAMIC_PERMISSIONS, r105);     // Catch: JSONException -> L16
        if (TextUtils.isEmpty(r102) == true) goto L14;
        r107.put(CommonConstant.RequestParams.KEY_SIGN_IN_PARAMS, r102);     // Catch: JSONException -> L16
    L14:
        r107.put("sdkVersion", 60900100);     // Catch: JSONException -> L16
        this.mLocalJsonObject = r107.toString();     // Catch: JSONException -> L16
        return;
    L16:
        as.d(TAG, "SignInReq JSONException", true);
        this.mLocalJsonObject = new JSONObject().toString();
    }
}
