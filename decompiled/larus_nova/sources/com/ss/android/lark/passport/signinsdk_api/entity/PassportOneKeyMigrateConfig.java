package com.ss.android.lark.passport.signinsdk_api.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
@AppConfig(key = "passport_one_key_migrate")
public class PassportOneKeyMigrateConfig implements Serializable {

    @SerializedName("enable_migrate_by_first_install_time")
    public boolean enableMigrateByFirstInstallTime;

    @SerializedName("enable_migrate_clear_in_applog")
    public boolean enableMigrateClearInAppLog;

    @SerializedName("enable_migrate_in_process")
    public boolean enableMigrateInProcess;

    public PassportOneKeyMigrateConfig() {
        this.enableMigrateInProcess = false;
        this.enableMigrateClearInAppLog = false;
        this.enableMigrateByFirstInstallTime = false;
    }
}
