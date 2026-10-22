package com.bytedance.ee.bear.operation.api.event;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface OperationScene {
    public static final int SCENE_CREATE_TRANSCRIPT = 2;
    public static final int SCENE_DOWNLOAD = 3;
    public static final int SCENE_PERMISSION = 4;
    public static final int SCENE_SHARE = 1;
    public static final int SCENE_UNKNOWN = 0;
}
