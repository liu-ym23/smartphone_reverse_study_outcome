package com.ss.android.lark.biz.im.api.message;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes34.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface PinSupportType {
    public static final int AUDIO = 32;
    public static final int CALENDAR_GENERAL_CARD = 1048576;
    public static final int CARD = 262144;
    public static final int FILE = 8;
    public static final int FOLDER = 32768;
    public static final int IMAGE = 4;
    public static final int LOCATION = 2048;
    public static final int MEDIA = 128;
    public static final int MERGE_FORWARD = 64;
    public static final int POST = 2;
    public static final int PROFILE = 8192;
    public static final int REPLY_IN_THREAD_MERGE_FORWARD = 524288;
    public static final int SEARCH_RESULT = 4096;
    public static final int SHARE_CALENDAR_EVENT = 256;
    public static final int SHARE_GROUP_CHAT = 16;
    public static final int STICKER = 1024;
    public static final int TEXT = 1;
    public static final int THREAD_MERGE_FORWARD = 65536;
    public static final int TODO = 16384;
    public static final int UNKNOWN = -1;
    public static final int VOTE = 512;
    public static final int VOTE_NEW = 131072;
}
