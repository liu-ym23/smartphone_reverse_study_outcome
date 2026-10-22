package com.huawei.hms.support.account.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.feature.request.AbstractAuthParams;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class AccountAuthParams extends AbstractAuthParams {
    public static final Parcelable.Creator<AccountAuthParams> CREATOR = null;
    public static final AccountAuthParams DEFAULT_AUTH_REQUEST_PARAM = null;
    public static final AccountAuthParams DEFAULT_AUTH_REQUEST_PARAM_GAME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f277693b;

    static {
        DEFAULT_AUTH_REQUEST_PARAM = new AccountAuthParamsHelper().setId().setProfile().createParams();
        DEFAULT_AUTH_REQUEST_PARAM_GAME = new AccountAuthParamsHelper().setScope(AbstractAuthParams.SCOPE_GAMES).createParams();
        CREATOR = new AnonymousClass1();
    }

    @Override // com.huawei.hms.support.feature.request.AbstractAuthParams
    public int hashCode() {
        ArrayList<Scope> r100 = this.scopeArrayList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r102 + 31) * 31;
        ArrayList<PermissionInfo> r104 = this.permissionArrayList;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    @Override // com.huawei.hms.support.feature.request.AbstractAuthParams
    public JSONObject toJsonObject() throws JSONException {
        JSONObject r100 = super.toJsonObject();
        r100.put(CommonConstant.RequestParams.KEY_SIGN_IN_PARAMS, this.f277692a);
        return r100;
    }

    public int getIdTokenSignAlg() {
        return this.f277693b;
    }

    public String getSignInParams() {
        return this.f277692a;
    }

    private AccountAuthParams(Parcel r100) {
        super(r100.createTypedArrayList(Scope.CREATOR), r100.createTypedArrayList(PermissionInfo.CREATOR));
        this.f277692a = "";
        this.f277692a = r100.readString();
    }

    public static AccountAuthParams fromJson(String r100) throws JSONException {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return fromJsonObject(new JSONObject(r100));
    }

    public static AccountAuthParams fromJsonObject(JSONObject r100) throws JSONException {
        JSONArray r101 = JSONObjectProtectorUtils.getJSONArray(r100, "scopeArrayList");
        ArrayList r102 = new ArrayList();
        int r103 = 0;
        if (r101 == null) goto L8;
        int r104 = 0;
    L6:
        if (r104 >= r101.length()) goto L8;
        r102.add(AbstractAuthParams.jsonToScope(JSONArrayProtectorUtils.getJSONObject(r101, r104)));
        r104 = r104 + 1;
    L8:
        JSONArray r105 = JSONObjectProtectorUtils.getJSONArray(r100, "permissionArrayList");
        ArrayList r106 = new ArrayList();
        if (r105 != null) goto L11;
    L13:
        String r107 = r100.optString(CommonConstant.RequestParams.KEY_SIGN_IN_PARAMS);
        AccountAuthParams r108 = new AccountAuthParams(r102, r106);
        r108.setSignInParams(r107);
        return r108;
    L11:
        if (r103 >= r105.length()) goto L13;
        r106.add(AbstractAuthParams.jsonToPermission(JSONArrayProtectorUtils.getJSONObject(r105, r103)));
        r103 = r103 + 1;
        goto L11
    }

    @Override // com.huawei.hms.support.feature.request.AbstractAuthParams
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AccountAuthParams) == true) goto L8;
        return false;
    L8:
        AccountAuthParams r101 = (AccountAuthParams) r100;
        if (isListEquals(this.scopeArrayList, r101.scopeArrayList) == true) goto L11;
    L13:
        return false;
    L11:
        if (isListEquals(this.permissionArrayList, r101.permissionArrayList) == false) goto L13;
        return true;
    }

    public void setIdTokenSignAlg(int r100) {
        this.f277693b = r100;
    }

    public void setSignInParams(String r100) {
        this.f277692a = r100;
    }

    public AccountAuthParams(Set<Scope> r100, Set<PermissionInfo> r101) {
        this(new ArrayList(r100), new ArrayList(r101));
    }

    public AccountAuthParams(ArrayList<Scope> r100, ArrayList<PermissionInfo> r101) {
        super(r100, r101);
        this.f277692a = "";
    }

    public /* synthetic */ AccountAuthParams(Parcel r100, AnonymousClass1 r101) {
        this(r100);
    }

    public AccountAuthParams(Set<Scope> r100, Set<PermissionInfo> r101, String r102) {
        this(new ArrayList(r100), new ArrayList(r101));
        this.f277692a = r102;
    }

    public AccountAuthParams(ArrayList<Scope> r100, ArrayList<PermissionInfo> r101, String r102) {
        super(r100, r101);
        this.f277692a = r102;
    }
}
