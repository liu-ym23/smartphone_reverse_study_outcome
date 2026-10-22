package com.bytedance.dora.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface VUIState {
    public static final int END = 3;
    public static final int END_CONVERSATION_SILENT = 9;
    public static final int END_SILENT = 4;
    public static final int INVALID = 0;
    public static final int PRE_END = 7;
    public static final int START = 2;
    public static final int STOP = 1;
}
