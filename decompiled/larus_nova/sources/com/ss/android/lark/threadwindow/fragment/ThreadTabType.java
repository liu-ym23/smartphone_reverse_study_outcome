package com.ss.android.lark.threadwindow.fragment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes38.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ThreadTabType {
    public static final int ALL = 0;
    public static final int FILTER_ALL = 8;
    public static final int FILTER_CONTAINER = 1001;
    public static final int FILTER_FOLLOW = 7;
    public static final int FILTER_FOLLOW_OLD = 1;
    public static final int FILTER_MY_MENTION = 6;
    public static final int FILTER_MY_MENTION_UNREAD = 9;
    public static final int FILTER_MY_OWN = 4;
    public static final int FILTER_MY_REPLY = 5;
    public static final int Recommand = 1000;
    public static final int UNKNOWN = -1;
}
