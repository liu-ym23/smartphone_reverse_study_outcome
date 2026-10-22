package com.bytedance.ee.bear.contract.drive.sdk.entity.open;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface PreviewType {
    public static final int PREVIEW_TYPE_BLOCK = 3;
    public static final int PREVIEW_TYPE_BLOCK_FULLSCREEN = 4;
    public static final int PREVIEW_TYPE_CHAT_GROUP = 2;
    public static final int PREVIEW_TYPE_NORMAL = 0;
    public static final int PREVIEW_TYPE_VC = 1;
}
