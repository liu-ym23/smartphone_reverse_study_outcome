package com.bytedance.ee.bear.bitable.card.model.stmodel.cell;

import androidx.autofill.HintConstants;
import com.alibaba.fastjson.annotation.JSONType;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.Expose;
import com.huawei.hms.support.feature.result.CommonConstant;

/* JADX INFO: loaded from: classes15.dex */
@JSONType(ignores = {CommonConstant.KEY_COUNTRY_CODE, "provinceCode", HintConstants.AUTOFILL_HINT_PHONE_NUMBER})
public class PhoneInfo implements NonProguard {

    @Expose(deserialize = false, serialize = false)
    private String countryCode;
    private String fullPhoneNum;

    @Expose(deserialize = false, serialize = false)
    private String phoneNumber;

    @Expose(deserialize = false, serialize = false)
    private String provinceCode;

    public String toString() {
        return "PhoneInfo{countryCode='" + this.countryCode + "', provinceCode='" + this.provinceCode + "', phoneNumber='" + this.phoneNumber + "', fullPhoneNum='" + this.fullPhoneNum + "'}";
    }

    public PhoneInfo() {
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getFullPhoneNum() {
        return this.fullPhoneNum;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getProvinceCode() {
        return this.provinceCode;
    }

    public void setCountryCode(String r100) {
        this.countryCode = r100;
    }

    public void setFullPhoneNum(String r100) {
        this.fullPhoneNum = r100;
    }

    public void setPhoneNumber(String r100) {
        this.phoneNumber = r100;
    }

    public void setProvinceCode(String r100) {
        this.provinceCode = r100;
    }
}
