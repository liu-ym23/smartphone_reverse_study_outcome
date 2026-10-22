package com.bytedance.awemeopen.apps.framework.comment.api.constants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/api/constants/CommentPublishScene;", "", "Companion", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface CommentPublishScene {
    public static final String COMMENT_LIST = "comment_list";
    public static final String CONVERSATION_PAGE = "conversation_page";
    public static final a Companion = null;
    public static final String LUCKYCAT_SQUARE_COMMENT = "luckycat_square_comment";
    public static final String NOTIFICATION_RAPID_COMMENT = "notification_rapid_comment";
    public static final String RAPID_INPUT = "rapid_input";
    public static final String UNKNOWN = "unknown";
    public static final String VIDEO_BOTTOM_INPUT = "video_bottom_input";

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.a;
    }
}
