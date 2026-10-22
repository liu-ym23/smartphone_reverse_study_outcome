package com.ss.android.lark.passport.signinsdk_api.env;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
public class HostEnvBean implements Serializable {

    @JSONField(name = "env_type")
    public int envType;

    @JSONField(name = "set_rust_env")
    public boolean needSetRustEnvForListenerOnly;

    @JSONField(name = "tenant_brand")
    public String tenantBrand;

    @JSONField(name = "user_unit")
    public String userUnit;

    public HostEnvBean cloneMe() {
        return new HostEnvBean(this.userUnit, this.tenantBrand, this.envType);
    }

    public String toString() {
        return "HostEnvBean{userUnit='" + this.userUnit + "', envType=" + this.envType + ", tenantBrand='" + this.tenantBrand + "', needSetRustEnvForListenerOnly='" + this.needSetRustEnvForListenerOnly + "'}";
    }

    public HostEnvBean() {
    }

    public boolean isChanged(HostEnvBean r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if (TextUtils.equals(this.userUnit, r100.userUnit) == true) goto L8;
        return true;
    L8:
        if (TextUtils.equals(this.tenantBrand, r100.tenantBrand) == true) goto L10;
        return true;
    L10:
        if (this.envType != r100.envType) goto L16;
        return false;
    L16:
        return true;
    }

    public HostEnvBean(String r100, String r101, int r102) {
        this.userUnit = r100;
        this.envType = r102;
        this.tenantBrand = r101;
    }
}
