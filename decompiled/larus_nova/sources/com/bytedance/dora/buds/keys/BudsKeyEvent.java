package com.bytedance.dora.buds.keys;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface BudsKeyEvent {
    public static final int DOUBLE_CLICK = 1;
    public static final int EXTRA_LONG_PRESS = 6;
    public static final int LONG_PRESS = 5;
    public static final int PRESS = 3;
    public static final int SINGLE_CLICK = 0;
    public static final int SWIPE_DOWN = 17;
    public static final int SWIPE_UP = 16;
    public static final int TRIPLE_CLICK = 2;
    public static final int UP = 4;
}
