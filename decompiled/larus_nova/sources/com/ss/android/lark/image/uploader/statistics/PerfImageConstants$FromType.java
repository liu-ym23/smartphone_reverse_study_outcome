package com.ss.android.lark.image.uploader.statistics;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes36.dex */
@Target({ElementType.PARAMETER, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/image/uploader/statistics/PerfImageConstants$FromType;", "", "Companion", "image-uploader_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface PerfImageConstants$FromType {
    public static final int AVATAR = 5;
    public static final int CARD = 7;
    public static final int CHAT_ALBUM = 11;
    public static final int CHAT_HISTORY = 10;
    public static final int COVER = 9;
    public static final a Companion = null;
    public static final int IMAGE = 1;
    public static final int MEDIA = 4;
    public static final int MEMO_PICTURE = 12;
    public static final int OTHER = 20;
    public static final int POST = 2;
    public static final int REACTION = 6;
    public static final int STICKER = 3;
    public static final int UNKNOWN = 0;
    public static final int URL_PREVIEW = 8;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f426413a = null;

        static {
            f426413a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f426413a;
    }
}
