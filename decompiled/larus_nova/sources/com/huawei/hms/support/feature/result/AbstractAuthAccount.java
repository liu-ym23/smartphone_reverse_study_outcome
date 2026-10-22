package com.huawei.hms.support.feature.result;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.huawei.hms.hwid.ap;
import com.huawei.hms.hwid.as;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AbstractAuthAccount implements Parcelable {
    protected String accessToken;
    protected String ageRange;
    protected int carrierId;
    protected String countryCode;
    protected String displayName;
    protected String email;
    protected long expirationTimeSecs;
    protected Set<Scope> extensionScopes;
    protected String familyName;
    protected int gender;
    protected String givenName;
    protected Set<Scope> grantedScopes;
    protected int homeZone;
    protected String idToken;
    protected String openId;
    protected String photoUriString;
    protected String serverAuthCode;
    protected String serviceCountryCode;
    protected int status;
    protected String uid;
    protected String unionId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Uri getAvatarUri() {
        String r100 = this.photoUriString;
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        return UriProtector.parse(r100);
    }

    public Set<Scope> getRequestedScopes() {
        HashSet r100 = new HashSet(this.grantedScopes);
        r100.addAll(this.extensionScopes);
        return r100;
    }

    public boolean isExpired() {
        if (this.expirationTimeSecs > 300) goto L5;
        return false;
    L5:
        if ((System.currentTimeMillis() / 1000) < (this.expirationTimeSecs - 300)) goto L9;
        return true;
    L9:
        return false;
    }

    public JSONObject toJsonObject() throws JSONException {
        JSONObject r100 = new JSONObject();
        if (getUid() == null) goto L6;
        r100.put("uid", getUid());
    L6:
        if (getOpenId() == null) goto L9;
        r100.put("openId", getOpenId());
    L9:
        if (getAvatarUriString() == null) goto L12;
        r100.put(CommonConstant.KEY_PHOTO_URI, getAvatarUriString());
    L12:
        if (getAccessToken() == null) goto L15;
        r100.put("accessToken", getAccessToken());
    L15:
        if (getDisplayName() == null) goto L17;
        r100.put(CommonConstant.KEY_DISPLAY_NAME, getDisplayName());
    L17:
        r100.put("status", getStatus());
        r100.put("gender", getGender());
        if (getCountryCode() == null) goto L21;
        r100.put(CommonConstant.KEY_COUNTRY_CODE, getCountryCode());
    L21:
        if (getUnionId() == null) goto L24;
        r100.put(CommonConstant.KEY_UNION_ID, getUnionId());
    L24:
        if (getEmail() == null) goto L27;
        r100.put("email", getEmail());
    L27:
        if (getAuthorizationCode() == null) goto L30;
        r100.put(CommonConstant.KEY_SERVER_AUTH_CODE, getAuthorizationCode());
    L30:
        if (getServiceCountryCode() == null) goto L33;
        r100.put(CommonConstant.KEY_SERVICE_COUNTRY_CODE, getServiceCountryCode());
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
        r100.put(CommonConstant.KEY_CARRIER_ID, getCarrierId());
        return jsonPutOpt(jsonPutScopes(r100));
    }

    public String toString() {
        return "{uid: " + this.uid + ",displayName: " + this.displayName + ",photoUriString: " + this.photoUriString + ",status: " + this.status + ",gender: " + this.gender + ",serviceCountryCode: " + this.serviceCountryCode + ",countryCode: " + this.countryCode + '}';
    }

    public AbstractAuthAccount() {
        this.extensionScopes = new HashSet();
        this.gender = -1;
        this.status = 0;
        this.grantedScopes = new HashSet();
    }

    public int hashCode() {
        return getRequestedScopes().hashCode();
    }

    public String toJson() throws JSONException {
        return toJsonObject().toString();
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getAgeRange() {
        return this.ageRange;
    }

    public String getAuthorizationCode() {
        return this.serverAuthCode;
    }

    public Set<Scope> getAuthorizedScopes() {
        return this.grantedScopes;
    }

    public String getAvatarUriString() {
        return this.photoUriString;
    }

    public int getCarrierId() {
        return this.carrierId;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getEmail() {
        return this.email;
    }

    public long getExpirationTimeSecs() {
        return this.expirationTimeSecs;
    }

    public Set<Scope> getExtensionScopes() {
        return this.extensionScopes;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public int getGender() {
        return this.gender;
    }

    public String getGivenName() {
        return this.givenName;
    }

    public int getHomeZone() {
        return this.homeZone;
    }

    public String getIdToken() {
        return this.idToken;
    }

    public String getOpenId() {
        return this.openId;
    }

    public String getServiceCountryCode() {
        return this.serviceCountryCode;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUnionId() {
        return this.unionId;
    }

    public AbstractAuthAccount(Parcel r100) {
        this.extensionScopes = new HashSet();
        readFromParcel(r100);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof AbstractAuthAccount) == true) goto L10;
        return false;
    L10:
        return getAuthorizedScopes().equals(((AbstractAuthAccount) r100).getAuthorizedScopes());
    }

    public JSONObject jsonPutOpt(JSONObject r100) throws JSONException {
        if (getExtensionScopes() == null) goto L9;
        JSONArray r101 = new JSONArray();
        Iterator<Scope> r102 = getExtensionScopes().iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        Scope r103 = r102.next();
        JSONObject r104 = new JSONObject();
        r104.putOpt(CommonConstant.KEY_SCOPE_URI, r103.getScopeUri());
        r101.put(r104);
        goto L6
    L8:
        r100.putOpt(CommonConstant.KEY_EXTENSION_SCOPES, r101);
    L9:
        return r100;
    }

    public JSONObject jsonPutScopes(JSONObject r100) throws JSONException {
        if (getAuthorizedScopes() == null) goto L9;
        JSONArray r101 = new JSONArray();
        Iterator<Scope> r102 = getAuthorizedScopes().iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        Scope r103 = r102.next();
        JSONObject r104 = new JSONObject();
        r104.putOpt(CommonConstant.KEY_SCOPE_URI, r103.getScopeUri());
        r101.put(r104);
        goto L6
    L8:
        r100.put(CommonConstant.KEY_GRANTED_SCOPES, r101);
    L9:
        return r100;
    }

    public void parserJson(JSONObject r100) throws JSONException {
        this.uid = r100.optString("uid", null);
        this.openId = r100.optString("openId", null);
        this.displayName = r100.optString(CommonConstant.KEY_DISPLAY_NAME, null);
        this.photoUriString = r100.optString(CommonConstant.KEY_PHOTO_URI, null);
        this.accessToken = r100.optString("accessToken", null);
        this.status = r100.optInt("status", -1);
        this.gender = r100.optInt("gender", -1);
        this.serverAuthCode = r100.optString(CommonConstant.KEY_SERVER_AUTH_CODE, null);
        this.serviceCountryCode = r100.optString(CommonConstant.KEY_SERVICE_COUNTRY_CODE, null);
        this.countryCode = r100.optString(CommonConstant.KEY_COUNTRY_CODE, null);
        if (r100.toString().contains(CommonConstant.KEY_GRANTED_SCOPES) == false) goto L5;
        JSONArray r101 = JSONObjectProtectorUtils.getJSONArray(r100, CommonConstant.KEY_GRANTED_SCOPES);
    L7:
        if (r101 == null) goto L16;
        HashSet r102 = new HashSet();
        int r103 = 0;
    L10:
        if (r103 >= r101.length()) goto L15;
        String r104 = JSONArrayProtectorUtils.getJSONObject(r101, r103).optString(CommonConstant.KEY_SCOPE_URI, null);
        if (r104 == null) goto L14;
        r102.add(new Scope(r104));
    L14:
        r103 = r103 + 1;
        goto L10
    L15:
        this.grantedScopes = r102;
    L16:
        this.unionId = r100.optString(CommonConstant.KEY_UNION_ID, null);
        this.email = r100.optString("email", null);
        this.idToken = r100.optString("idToken", null);
        this.expirationTimeSecs = 0;
        if (r100.toString().contains(CommonConstant.KEY_EXPIRATION_TIME_SECS) == true) goto L23;
    L21:
        this.givenName = r100.optString(CommonConstant.KEY_GIVEN_NAME, null);
        this.familyName = r100.optString(CommonConstant.KEY_FAMILY_NAME, null);
        this.ageRange = r100.optString(CommonConstant.KEY_AGE_RANGE, null);
        this.homeZone = r100.optInt(CommonConstant.KEY_HOME_ZONE, 0);
        this.carrierId = r100.optInt(CommonConstant.KEY_CARRIER_ID, 0);
        return;
    L23:
        this.expirationTimeSecs = CastLongProtector.parseLong(JSONObjectProtectorUtils.getString(r100, CommonConstant.KEY_EXPIRATION_TIME_SECS));     // Catch: NumberFormatException -> L20
    L20:
        as.d("[AccountSDK]AbstractAuthAccount", "NumberFormatException", true);
        goto L21
    L5:
        r101 = null;
        goto L7
    }

    public void readFromParcel(Parcel r100) {
        this.uid = r100.readString();
        this.openId = r100.readString();
        this.displayName = r100.readString();
        this.photoUriString = r100.readString();
        this.accessToken = r100.readString();
        this.status = r100.readInt();
        this.gender = r100.readInt();
        this.serverAuthCode = r100.readString();
        this.serviceCountryCode = r100.readString();
        this.countryCode = r100.readString();
        this.grantedScopes = new HashSet(r100.readArrayList(Scope.class.getClassLoader()));
        this.unionId = r100.readString();
        this.email = r100.readString();
        this.idToken = r100.readString();
        this.expirationTimeSecs = r100.readLong();
        this.givenName = r100.readString();
        this.familyName = r100.readString();
        this.ageRange = r100.readString();
        this.homeZone = r100.readInt();
        this.carrierId = r100.readInt();
    }

    public AbstractAuthAccount requestExtraScopes(List<Scope> r100) {
        if (ap.b(r100).booleanValue() == false) goto L5;
        this.extensionScopes.addAll(r100);
    L5:
        return this;
    }

    public void setAgeRange(String r100) {
        this.ageRange = r100;
    }

    public void setAvatarUriString(String r100) {
        this.photoUriString = r100;
    }

    public void setCarrierId(int r100) {
        this.carrierId = r100;
    }

    public void setEmail(String r100) {
        this.email = r100;
    }

    public void setExpirationTimeSecs(long r100) {
        this.expirationTimeSecs = r100;
    }

    public void setExtensionScopes(Set<Scope> r100) {
        this.extensionScopes = r100;
    }

    public void setFamilyName(String r100) {
        this.familyName = r100;
    }

    public void setGivenName(String r100) {
        this.givenName = r100;
    }

    public void setHomeZone(int r100) {
        this.homeZone = r100;
    }

    public void setIdToken(String r100) {
        this.idToken = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.uid);
        r100.writeString(this.openId);
        r100.writeString(this.displayName);
        r100.writeString(this.photoUriString);
        r100.writeString(this.accessToken);
        r100.writeInt(this.status);
        r100.writeInt(this.gender);
        r100.writeString(this.serverAuthCode);
        r100.writeString(this.serviceCountryCode);
        r100.writeString(this.countryCode);
        r100.writeList(new ArrayList(this.grantedScopes));
        r100.writeString(this.unionId);
        r100.writeString(this.email);
        r100.writeString(this.idToken);
        r100.writeLong(this.expirationTimeSecs);
        r100.writeString(this.givenName);
        r100.writeString(this.familyName);
        r100.writeString(this.ageRange);
        r100.writeInt(this.homeZone);
        r100.writeInt(this.carrierId);
    }
}
