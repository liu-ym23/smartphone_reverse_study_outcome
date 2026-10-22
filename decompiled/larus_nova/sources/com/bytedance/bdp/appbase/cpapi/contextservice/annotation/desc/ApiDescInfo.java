package com.bytedance.bdp.appbase.cpapi.contextservice.annotation.desc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ApiDescInfo {
    String category();

    String desc();

    String docAddress();

    String module();

    String supportSdkVersion();
}
