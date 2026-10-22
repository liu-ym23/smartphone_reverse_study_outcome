package com.bytedance.awemeopen.apps.framework.comment.api.constants;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes14.dex */
@Target({ElementType.TYPE, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"com/bytedance/awemeopen/apps/framework/comment/api/constants/CommentConstants$PresenterTag", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE, AnnotationTarget.LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface CommentConstants$PresenterTag {
    public static final String AT = "commentInputManager_at";
    public static final String CHECKER = "commentInputManager_checker";
    public static final a Companion = null;
    public static final String EDIT = "commentInputManager_edit";
    public static final String EMOJI = "commentInputManager_emoji";
    public static final String HINT = "commentInputManager_hint";
    public static final String IMAGE = "commentInputManager_image";
    public static final String KEYBOARD = "commentInputManager_keyboard";
    public static final String MULTI = "commentInputManager_multi";
    public static final String PHOTO = "commentInputManager_photo";
    public static final String PUBLISH = "commentInputManager_publish";
    public static final String UN_KNOW = "commentInputManager_un_know";
    public static final String VIDEO_REPLY = "commentInputManager_video_reply";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f194116a = null;

        static {
            f194116a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f194116a;
    }
}
