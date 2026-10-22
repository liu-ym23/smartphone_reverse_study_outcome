package com.bytedance.ee.bear.quoto;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes18.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface SingleFileQuotaType {
    public static final int QUOTA_TYPE_DUPLICATE = 2;
    public static final int QUOTA_TYPE_SAVE = 3;
    public static final int QUOTA_TYPE_UPLOAD = 1;
}
