package com.ss.lark.android.lgw.storage.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@AppConfig(key = "lark_security_compliance_config")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/lark/android/lgw/storage/model/LgwHeadersConfig;", "", "<init>", "()V", "enableLgwStorage", "", "getEnableLgwStorage", "()Z", "setEnableLgwStorage", "(Z)V", "lark-gateway-storage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LgwHeadersConfig {

    @SerializedName("enable_lgw_storage")
    private boolean enableLgwStorage;

    public LgwHeadersConfig() {
    }
}
