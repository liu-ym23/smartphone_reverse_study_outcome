package com.larus.bmhome.creative;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes26.dex */
@Target({ElementType.METHOD, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/creative/CreativeScene;", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface CreativeScene {
    public static final String AI_BEAUTIFY_IMAGE = "ai_beautify_image";
    public static final String AVATAR_IMAGE = "avatar_image";
    public static final a Companion = null;
    public static final String IMAGE = "image";
    public static final String IMAGE_TO_IMAGE = "image2image";
    public static final String MUSIC = "music";
    public static final String VIDEO = "video";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f310756a = null;

        static {
            f310756a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f310756a;
    }
}
