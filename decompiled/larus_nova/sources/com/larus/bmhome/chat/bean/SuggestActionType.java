package com.larus.bmhome.chat.bean;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/chat/bean/SuggestActionType;", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface SuggestActionType {
    public static final String AI_PODCAST = "ai_podcast";
    public static final String ALBUM_IMAGE = "ALBUM_IMAGE";
    public static final String AVATAR = "AVATAR";
    public static final String BOT_RECOMMEND = "BOT_RECOMMEND";
    public static final String CALL = "CALL";
    public static final a Companion = null;
    public static final String FILL_MSG = "FILL_MSG";
    public static final String IMAGE_TEMPLATE = "IMAGE_TEMPLATE";
    public static final String IMAGE_TO_IMAGE = "IMAGE_TO_IMAGE";
    public static final String MUSIC = "MUSIC";
    public static final String PHOTO = "PHOTO";
    public static final String SCHEMA = "SCHEMA";
    public static final String SEND_MSG = "SEND_MSG";
    public static final String TEXT_TO_IMAGE = "TEXT_TO_IMAGE";
    public static final String UNKNOWN = "";
    public static final String VIDEO = "VIDEO";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f297437a = null;

        static {
            f297437a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f297437a;
    }
}
