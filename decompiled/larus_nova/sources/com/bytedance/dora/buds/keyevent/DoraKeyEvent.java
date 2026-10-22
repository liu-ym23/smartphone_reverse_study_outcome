package com.bytedance.dora.buds.keyevent;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface DoraKeyEvent {
    public static final int DOUBLE_CLICK = 1;
    public static final int INVALID = 0;
    public static final int LONG_PRESS = 4;
    public static final int SINGLE_CLICK = 2;
    public static final int TRIPLE_CLICK = 3;
}
