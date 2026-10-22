package com.bytedance.dora.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface PlayCommand {
    public static final int NEXT = 5;
    public static final int PAUSE = 3;
    public static final int PLAY = 2;
    public static final int PREV = 4;
    public static final int SWITCH = 1;
}
