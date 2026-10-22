package com.obric.aiagent.assistant.idl.bean;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/MessageContentType;", "", "Companion", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface MessageContentType {
    public static final int AUDIO_TXT = 11;
    public static final int AWEME_VIDEO_LIST = 9;
    public static final int BLOCK_CONTENT = 9999;
    public static final int BOT_MAKER = 51;
    public static final int CARD = 50;
    public static final int CONTENT_TYPE_CREATION = 2022;
    public static final int CONTENT_TYPE_LYRICS_TO_SONG = 70;
    public static final int CONTENT_TYPE_LYRICS_TO_SONGS_BY_LIST = 72;
    public static final int CONTENT_TYPE_LYRICS_TO_SONG_LYRIC = 71;
    public static final int CONTENT_TYPE_MULTI_CONTENT = 66;
    public static final int CONTENT_TYPE_USER_EVALUATE = 67;
    public static final int CONTENT_TYPE_VIDEO_GENERATE = 2021;
    public static final a Companion = null;
    public static final int EXPERT = 60;
    public static final int FILE = 7;
    public static final int FORM_MSG = 53;
    public static final int IMAGE = 6;
    public static final int MUSIC = 3;
    public static final int OTHER = 800;
    public static final int SEARCH_LIST = 8;
    public static final int SUGGEST = 2;
    public static final int SYS_MSG = 1001;
    public static final int TIME_STAMP = 1002;
    public static final int TIPS = 1003;
    public static final int TXT = 1;
    public static final int UNSPECIFIED = 0;
    public static final int VIDEO = 5;
    public static final int WEBVIEW = 4;
    public static final int WIDGET = 100;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f384505a = null;

        static {
            f384505a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f384505a;
    }
}
