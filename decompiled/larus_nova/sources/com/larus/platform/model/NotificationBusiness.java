package com.larus.platform.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes31.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/platform/model/NotificationBusiness;", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface NotificationBusiness {
    public static final String AWEME_FEED = "aweme_feed";
    public static final String BOT_FEEDBACK = "bot_feedback";
    public static final String CANVAS_CREATION = "canvas_creation";
    public static final String COMMERCE_CREDIT = "commerce_credit";
    public static final String COMMERCE_MEMBERSHIP = "commerce_membership";
    public static final String COMMUNITY = "community";
    public static final a Companion = null;
    public static final String IM_MSG_FEEDBACK = "im_msg_feedback";
    public static final String LARK_IM_PUSH = "lark_im_push";
    public static final String OFFICE_TASK_ASK_HUMAN = "office_task_ask_human";
    public static final String REALTIME_CALL = "realtime_call";
    public static final String REAL_TIME = "realtime";
    public static final String SLIDES_PPT = "slides_ppt";
    public static final String TTS = "tts";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f365476a = null;

        static {
            f365476a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f365476a;
    }
}
