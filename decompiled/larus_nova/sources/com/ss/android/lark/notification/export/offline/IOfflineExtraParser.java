package com.ss.android.lark.notification.export.offline;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes36.dex */
public interface IOfflineExtraParser {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Direct {
        public static final int TO_DEFAULT = 1;
        public static final int TO_DOC = 4;
        public static final int TO_LATEST_UNREAD_MESSAGE = 2;
        public static final int TO_MESSAGE = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ParserType {
        public static final String CALENDAR = "calendar";
        public static final String CHAT = "chat";
        public static final String DIAGNOSE = "diagnose";
        public static final String DOC = "doc";
        public static final String KNOWLEDGE_AI = "knowledgeAI";
        public static final String MAIL = "mail";
        public static final String OPEN_APP_CHAT = "open_app_chat";
        public static final String OPEN_FEED = "open_feed";
        public static final String REPLY_IN_THREAD = "reply_in_thread";
        public static final String SUBSCRIPTIONS_NEWS = "subscriptions_news";
        public static final String THREAD = "thread";
        public static final String TODO = "todo";
    }
}
