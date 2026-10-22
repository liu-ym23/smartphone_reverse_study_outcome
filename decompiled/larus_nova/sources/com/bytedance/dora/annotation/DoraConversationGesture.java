package com.bytedance.dora.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface DoraConversationGesture {
    public static final int DOUBLE_CLICK = 64;
    public static final int HEAD_AGREE = 1;
    public static final int HEAD_DISAGREE = 2;
    public static final int NONE = 0;
    public static final int PINCH_ONCE = 73;
    public static final int PINCH_TWICE = 74;
    public static final int PRESS = 85;
}
