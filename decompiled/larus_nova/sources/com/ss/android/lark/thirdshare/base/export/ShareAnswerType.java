package com.ss.android.lark.thirdshare.base.export;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes38.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ShareAnswerType {
    public static final String BAN = "ban";
    public static final String DOWNGRADE_TO_SYSTEM_SHARE = "downgrade_to_system_share";
    public static final String DOWNGRADE_TO_SYSTEM_SHARE_BY_SPECIFIC_APP = "downgrade_to_system_share_by_specific_app";
    public static final String DOWNGRADE_TO_WAKEUP_BY_TIP = "downgrade_to_wakeup_by_tip";
}
