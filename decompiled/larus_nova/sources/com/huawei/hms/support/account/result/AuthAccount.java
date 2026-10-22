package com.huawei.hms.support.account.result;

import android.accounts.Account;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.hwid.ap;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.feature.result.AbstractAuthAccount;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.huawei.hms.utils.HMSPackageManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class AuthAccount extends AbstractAuthAccount {
    public static final Parcelable.Creator<AuthAccount> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f277701a;

    public static AuthAccount createDefault() {
        return build(null, null, null, null, null, null, 0, -1, new HashSet(), null, null, null, 0);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public JSONObject toJsonObject() throws JSONException {
        JSONObject r100 = new JSONObject();
        if (getUid() == null) goto L6;
        r100.put("uid", getUid());
    L6:
        if (getOpenId() == null) goto L9;
        r100.put("openId", getOpenId());
    L9:
        if (getDisplayName() == null) goto L12;
        r100.put(CommonConstant.KEY_DISPLAY_NAME, getDisplayName());
    L12:
        if (getAvatarUriString() == null) goto L15;
        r100.put(CommonConstant.KEY_PHOTO_URI, getAvatarUriString());
    L15:
        if (getAccessToken() == null) goto L17;
        r100.put("accessToken", getAccessToken());
    L17:
        r100.put("status", getStatus());
        r100.put("gender", getGender());
        if (getAuthorizationCode() == null) goto L21;
        r100.put(CommonConstant.KEY_SERVER_AUTH_CODE, getAuthorizationCode());
    L21:
        if (getServiceCountryCode() == null) goto L24;
        r100.put(CommonConstant.KEY_SERVICE_COUNTRY_CODE, getServiceCountryCode());
    L24:
        if (getCountryCode() == null) goto L27;
        r100.put(CommonConstant.KEY_COUNTRY_CODE, getCountryCode());
    L27:
        if (getUnionId() == null) goto L30;
        r100.put(CommonConstant.KEY_UNION_ID, getUnionId());
    L30:
        if (getEmail() == null) goto L33;
        r100.put("email", getEmail());
    L33:
        if (getIdToken() == null) goto L35;
        r100.put("idToken", getIdToken());
    L35:
        r100.put(CommonConstant.KEY_EXPIRATION_TIME_SECS, getExpirationTimeSecs());
        if (getGivenName() == null) goto L39;
        r100.put(CommonConstant.KEY_GIVEN_NAME, getGivenName());
    L39:
        if (getFamilyName() == null) goto L42;
        r100.put(CommonConstant.KEY_FAMILY_NAME, getFamilyName());
    L42:
        if (getAgeRange() == null) goto L44;
        r100.put(CommonConstant.KEY_AGE_RANGE, getAgeRange());
    L44:
        r100.put(CommonConstant.KEY_HOME_ZONE, getHomeZone());
        r100.put(CommonConstant.KEY_ACCOUNT_FLAG, getAccountFlag());
        r100.put(CommonConstant.KEY_CARRIER_ID, getCarrierId());
        return jsonPutOpt(jsonPutScopes(r100));
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public String toString() {
        return "{uid: " + this.uid + ",displayName: " + this.displayName + ",photoUriString: " + this.photoUriString + ",status: " + this.status + ",gender: " + this.gender + ",serviceCountryCode: " + this.serviceCountryCode + ",countryCode: " + this.countryCode + CommonConstant.KEY_ACCOUNT_FLAG + this.f277701a + '}';
    }

    public AuthAccount() {
        this.gender = -1;
        this.status = 0;
        this.grantedScopes = new HashSet();
        this.f277701a = 0;
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public int hashCode() {
        return getRequestedScopes().hashCode();
    }

    public int getAccountFlag() {
        return this.f277701a;
    }

    public AuthAccount(Parcel r100) {
        readFromParcel(r100);
    }

    public static AuthAccount fromJson(String r100) throws JSONException {
        if (TextUtils.isEmpty(r100) == true) goto L7;
        return fromJson(new JSONObject(r100));
    L7:
        throw new JSONException("invalid json format");
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof AuthAccount) == true) goto L10;
        return false;
    L10:
        return getAuthorizedScopes().equals(((AuthAccount) r100).getAuthorizedScopes());
    }

    public Account getAccount(Context r100) {
        String r101 = HMSPackageManager.getInstance(r100).getHMSPackageName();
        if (TextUtils.isEmpty(this.email) == false) goto L5;
    L8:
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L8;
        return new Account(this.email, r101);
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public void parserJson(JSONObject r100) throws JSONException {
        super.parserJson(r100);
        this.f277701a = r100.optInt(CommonConstant.KEY_ACCOUNT_FLAG, 0);
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public void readFromParcel(Parcel r100) {
        super.readFromParcel(r100);
        this.f277701a = r100.readInt();
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public AuthAccount requestExtraScopes(List<Scope> r100) {
        if (ap.b(r100).booleanValue() == false) goto L5;
        this.extensionScopes.addAll(r100);
    L5:
        return this;
    }

    public static AuthAccount fromJson(JSONObject r100) throws JSONException {
        AuthAccount r101 = new AuthAccount();
        r101.parserJson(r100);
        return r101;
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public /* bridge */ /* synthetic */ AbstractAuthAccount requestExtraScopes(List r100) {
        return requestExtraScopes(r100);
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeInt(this.f277701a);
    }

    public AuthAccount(String r100, String r101, String r102, String r103, String r104, String r105, int r106, int r107, Set<Scope> r108, String r110, String r111, String r112, int r113) {
        this.openId = r100;
        this.uid = r101;
        this.photoUriString = r103;
        this.displayName = r102;
        this.accessToken = r104;
        this.serviceCountryCode = r105;
        this.gender = r107;
        this.status = r106;
        this.serverAuthCode = r110;
        this.grantedScopes = r108;
        this.unionId = r111;
        this.countryCode = r112;
        this.carrierId = r113;
    }

    public static AuthAccount build(String r110, String r111, String r112, String r113, String r114, String r210, int r211, int r212, Set<Scope> r213, String r214, String r215, String r216, int r217) {
        return new AuthAccount(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, r217);
    }
}
