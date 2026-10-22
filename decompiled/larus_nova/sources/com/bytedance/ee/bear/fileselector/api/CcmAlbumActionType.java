package com.bytedance.ee.bear.fileselector.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes16.dex */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
public @interface CcmAlbumActionType {
    public static final int ACTION_TYPE_CONFIRM = 1;
    public static final int ACTION_TYPE_SEND = 0;
}
