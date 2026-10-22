package com.larus.voicecall.impl.subtitle;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes32.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/voicecall/impl/subtitle/SubtitleListUpdateType;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface SubtitleListUpdateType {
    public static final String ASR_NEW = "asr_new";
    public static final String ASR_REWRITE = "asr_rewrite";
    public static final a Companion = null;
    public static final String DEEP_THINKING = "deep_thinking";
    public static final String INSERT_PHOTO = "insert_photo";
    public static final String PHOTO_PLACE_DELETE = "photo_place_delete";
    public static final String PHOTO_PLACE_UPDATE = "photo_place_update";
    public static final String RETRY_IMAGE_HOLDER = "retry_image_holder";
    public static final String SCENE_MODE_CHANGE = "scene_mode_change";
    public static final String THINKING = "thinking";
    public static final String TTS_APPEND = "tts_append";
    public static final String TTS_DELETE = "tts_delete";
    public static final String TTS_NEW = "tts_new";
    public static final String TTS_REWRITE = "tts_rewrite";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f378833a = null;

        static {
            f378833a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f378833a;
    }
}
