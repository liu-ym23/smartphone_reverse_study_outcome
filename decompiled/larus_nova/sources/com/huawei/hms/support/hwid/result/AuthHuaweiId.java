package com.huawei.hms.support.hwid.result;

import android.accounts.Account;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.hwid.ap;
import com.huawei.hms.hwid.as;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.feature.result.AbstractAuthAccount;
import com.huawei.hms.utils.HMSPackageManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class AuthHuaweiId extends AbstractAuthAccount {
    public static final Parcelable.Creator<AuthHuaweiId> CREATOR = null;

    public static AuthHuaweiId createDefault() {
        return build(null, null, null, null, null, null, 0, -1, new HashSet(), null, null, null);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public int getAgeRangeFlag() {
        return CastIntegerProtector.parseInt(this.ageRange);
    L4:
        as.b("AuthHuaweiId", "Invalid ageRange NumberFormatException", true);
        return -1;
    }

    public AuthHuaweiId() {
        this.gender = -1;
        this.status = 0;
        this.grantedScopes = new HashSet();
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public int hashCode() {
        return getRequestedScopes().hashCode();
    }

    public AuthHuaweiId(Parcel r100) {
        readFromParcel(r100);
    }

    public static AuthHuaweiId fromJson(String r100) throws JSONException {
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
        if ((r100 instanceof AuthHuaweiId) == true) goto L10;
        return false;
    L10:
        return getAuthorizedScopes().equals(((AuthHuaweiId) r100).getAuthorizedScopes());
    }

    public Account getHuaweiAccount(Context r100) {
        String r101 = HMSPackageManager.getInstance(r100).getHMSPackageName();
        if (TextUtils.isEmpty(this.email) == false) goto L5;
    L8:
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L8;
        return new Account(this.email, r101);
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public AuthHuaweiId requestExtraScopes(List<Scope> r100) {
        if (ap.b(r100).booleanValue() == false) goto L5;
        this.extensionScopes.addAll(r100);
    L5:
        return this;
    }

    public static AuthHuaweiId fromJson(JSONObject r100) throws JSONException {
        AuthHuaweiId r101 = new AuthHuaweiId();
        r101.parserJson(r100);
        return r101;
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public /* bridge */ /* synthetic */ AbstractAuthAccount requestExtraScopes(List r100) {
        return requestExtraScopes(r100);
    }

    public AuthHuaweiId(String r100, String r101, String r102, String r103, String r104, String r105, int r106, int r107, Set<Scope> r108, String r110, String r111, String r112) {
        this.openId = r100;
        this.uid = r101;
        this.displayName = r102;
        this.photoUriString = r103;
        this.accessToken = r104;
        this.serviceCountryCode = r105;
        this.status = r106;
        this.gender = r107;
        this.grantedScopes = r108;
        this.serverAuthCode = r110;
        this.unionId = r111;
        this.countryCode = r112;
    }

    public static AuthHuaweiId build(String r110, String r111, String r112, String r113, String r114, String r115, int r210, int r211, Set<Scope> r212, String r213, String r214, String r215) {
        return new AuthHuaweiId(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, r215);
    }
}
