package com.ss.android.lark.framework.assembly.sp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.io.Serializable;

/* JADX INFO: loaded from: classes36.dex */
@AppConfig(key = "lark_security_keystore_config")
public class KeystoreConfig implements Serializable {

    @SerializedName("enable_keystore_mode")
    boolean keystoreMode;

    public KeystoreConfig() {
        this.keystoreMode = false;
    }

    public boolean isKeystoreMode() {
        return this.keystoreMode;
    }
}
