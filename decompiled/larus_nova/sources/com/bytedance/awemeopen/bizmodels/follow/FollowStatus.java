package com.bytedance.awemeopen.bizmodels.follow;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes44.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface FollowStatus {
    public static final int FOLLOW_STATUS_FOLLOWED = 1;
    public static final int FOLLOW_STATUS_FOLLOW_REQUESTING = 4;
    public static final int FOLLOW_STATUS_MUTUAL_FOLLOWED = 2;
    public static final int FOLLOW_STATUS_NONE = 0;
    public static final int FOLLOW_STATUS_REVERSE_FOLLOWED = 3;
}
