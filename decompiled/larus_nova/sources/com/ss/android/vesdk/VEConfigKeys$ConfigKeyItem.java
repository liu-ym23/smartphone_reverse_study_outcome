package com.ss.android.vesdk;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes40.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface VEConfigKeys$ConfigKeyItem {
    VEConfigCenter.ConfigType configType();

    VEConfigCenter.DataType dataType();

    String defaultValue();

    String description();
}
