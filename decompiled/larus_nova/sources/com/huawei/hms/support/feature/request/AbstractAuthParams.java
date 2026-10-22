package com.huawei.hms.support.feature.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.api.Api;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AbstractAuthParams implements Parcelable, Api.ApiOptions.HasOptions {
    public static final Scope EMAIL = null;
    public static final Scope OPENID = null;
    public static final Scope PROFILE = null;
    public static final Scope SCOPE_GAMES = null;
    public static final PermissionInfo UID_DYNAMIC_PERMISSION = null;
    protected ArrayList<PermissionInfo> permissionArrayList;
    protected final ArrayList<Scope> scopeArrayList;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        UID_DYNAMIC_PERMISSION = new PermissionInfo().setPermissionUri(CommonConstant.PERMISSION.UID);
        PROFILE = new Scope("profile");
        EMAIL = new Scope("email");
        OPENID = new Scope("openid");
        SCOPE_GAMES = new Scope(CommonConstant.SCOPE.SCOPE_ACCOUNT_GAME);
    }

    public Scope[] getScopeArray() {
        ArrayList<Scope> r100 = this.scopeArrayList;
        return (Scope[]) r100.toArray(new Scope[r100.size()]);
    }

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

    public JSONObject toJsonObject() throws JSONException {
        JSONObject r100 = new JSONObject();
        if (this.scopeArrayList == null) goto L10;
        JSONArray r101 = new JSONArray();
        Iterator<Scope> r102 = this.scopeArrayList.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r101.put(scopeToJson(r102.next()));
        goto L6
    L8:
        r100.put("scopeArrayList", r101);
    L10:
        if (this.permissionArrayList == null) goto L16;
        JSONArray r103 = new JSONArray();
        Iterator<PermissionInfo> r104 = this.permissionArrayList.iterator();
    L13:
        if (r104.hasNext() == false) goto L15;
        r103.put(permissionToJson(r104.next()));
        goto L13
    L15:
        r100.put("permissionArrayList", r103);
    L16:
        return r100;
    }

    public String toJson() throws JSONException {
        return toJsonObject().toString();
    }

    public List<PermissionInfo> getPermissionInfos() {
        return this.permissionArrayList;
    }

    public List<Scope> getRequestScopeList() {
        return this.scopeArrayList;
    }

    public static PermissionInfo jsonToPermission(JSONObject r100) {
        String r101 = r100.optString("permission", null);
        return new PermissionInfo().setPermissionUri(r101);
    }

    public static Scope jsonToScope(JSONObject r100) {
        return new Scope(r100.optString(com.huawei.hms.support.feature.result.CommonConstant.KEY_SCOPE_URI, null));
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AbstractAuthParams) == true) goto L8;
        return false;
    L8:
        AbstractAuthParams r101 = (AbstractAuthParams) r100;
        if (isListEquals(this.scopeArrayList, r101.scopeArrayList) == true) goto L11;
    L13:
        return false;
    L11:
        if (isListEquals(this.permissionArrayList, r101.permissionArrayList) == false) goto L13;
        return true;
    }

    public JSONObject permissionToJson(PermissionInfo r100) throws JSONException {
        JSONObject r101 = new JSONObject();
        if (r100.getPermission() == null) goto L5;
        r101.put("permission", r100.getPermission());
    L5:
        return r101;
    }

    public JSONObject scopeToJson(Scope r100) throws JSONException {
        JSONObject r101 = new JSONObject();
        if (r100.getScopeUri() == null) goto L5;
        r101.put(com.huawei.hms.support.feature.result.CommonConstant.KEY_SCOPE_URI, r100.getScopeUri());
    L5:
        return r101;
    }

    public AbstractAuthParams(Set<Scope> r100, Set<PermissionInfo> r101) {
        this(new ArrayList(r100), new ArrayList(r101));
    }

    public <T> boolean isListEquals(ArrayList<T> r100, ArrayList<T> r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if (r100.size() == r101.size()) goto L10;
        return false;
    L10:
        return r100.containsAll(r101);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeList(this.scopeArrayList);
        r100.writeList(this.permissionArrayList);
    }

    public AbstractAuthParams(ArrayList<Scope> r100, ArrayList<PermissionInfo> r101) {
        this.scopeArrayList = r100;
        this.permissionArrayList = r101;
    }
}
