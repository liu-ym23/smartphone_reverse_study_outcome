package com.ss.android.lark.biz.im.api.extension.message;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes34.dex */
@Target({ElementType.PARAMETER, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/message/TaskType;", "", "Companion", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TaskType {
    public static final String AUDIO_TASK = "audio";
    public static final a Companion = null;
    public static final String DOCS_TASK = "doc";
    public static final String MEDIA_TASK = "media";
    public static final String MEEGO_TASK = "meego";
    public static final String MINI_APP_TASK = "mini_app";
    public static final String WEB_APP = "web_app";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f410204a = null;

        static {
            f410204a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f410204a;
    }
}
