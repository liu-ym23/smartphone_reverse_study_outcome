package com.larus.im.bean.message;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes29.dex */
@Target({ElementType.TYPE, ElementType.PARAMETER, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/im/bean/message/CreationTaskType;", "", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CreationTaskType {
    public static final int AI_BEAUTIFY = 7;
    public static final a Companion = null;
    public static final int GEN_VIDEO = 6;
    public static final int IMAGE_2_IMAGE = 2;
    public static final int TEXT_2_IMAGE = 1;
    public static final int TEXT_2_MUSIC = 4;
    public static final int TEXT_2_VIDEO = 3;
    public static final int UNKNOWN = 0;
    public static final int USER_AVATAR = 5;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f346623a = null;

        static {
            f346623a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f346623a;
    }
}
