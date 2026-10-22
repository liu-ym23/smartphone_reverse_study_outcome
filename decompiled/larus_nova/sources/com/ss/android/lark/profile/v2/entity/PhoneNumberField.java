package com.ss.android.lark.profile.v2.entity;

import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/PhoneNumberField;", "Lcom/ss/android/lark/profile/v2/entity/BaseField;", "Ljava/io/Serializable;", "<init>", "()V", "number", "", "getNumber", "()Ljava/lang/String;", "setNumber", "(Ljava/lang/String;)V", CommonConstant.KEY_COUNTRY_CODE, "getCountryCode", "setCountryCode", "rateLimited", "", "getRateLimited", "()Z", "setRateLimited", "(Z)V", "isPlain", "setPlain", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhoneNumberField extends BaseField {
    private String countryCode;
    private boolean isPlain;
    private String number;
    private boolean rateLimited;

    public PhoneNumberField() {
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getNumber() {
        return this.number;
    }

    public final boolean getRateLimited() {
        return this.rateLimited;
    }

    public final boolean isPlain() {
        return this.isPlain;
    }

    public final void setCountryCode(String r100) {
        this.countryCode = r100;
    }

    public final void setNumber(String r100) {
        this.number = r100;
    }

    public final void setPlain(boolean r100) {
        this.isPlain = r100;
    }

    public final void setRateLimited(boolean r100) {
        this.rateLimited = r100;
    }
}
