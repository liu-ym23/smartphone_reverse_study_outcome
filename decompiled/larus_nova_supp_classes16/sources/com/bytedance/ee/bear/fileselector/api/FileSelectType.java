package com.bytedance.ee.bear.fileselector.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
public @interface FileSelectType {
    public static final int OPEN_CCM_ALBUM = 2;
    public static final int OPEN_FILE_PICKER = 4;
    public static final int OPEN_FULL_SCREEN_ALBUM = 3;
    public static final int OPEN_LARK_CAMERA = 1;
    public static final int UNKNOWN = 0;
}
