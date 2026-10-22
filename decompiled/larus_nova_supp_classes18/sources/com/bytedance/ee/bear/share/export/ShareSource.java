package com.bytedance.ee.bear.share.export;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ShareSource {
    public static final int FROM_DOC = 2;
    public static final int FROM_LIST_GRID = 1;
    public static final int FROM_LIST_LEFT_SLIDE = 0;
    public static final int TEMPLATE_CUSTOM = 4;
    public static final int TEMPLATE_SYSTEM = 3;
}
