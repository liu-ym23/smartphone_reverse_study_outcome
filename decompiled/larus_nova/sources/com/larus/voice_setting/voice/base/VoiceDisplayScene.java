package com.larus.voice_setting.voice.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes32.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/voice_setting/voice/base/VoiceDisplayScene;", "", "Companion", "flow-voice-setting-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface VoiceDisplayScene {
    public static final a Companion = null;
    public static final String MY_INFO = "my_info";
    public static final String NONE = "none";
    public static final String OTHER_PROFILE = "other_profile";
    public static final String TTS_LIST_MINE = "tts_list_mine";
    public static final String TTS_LIST_RECOMMEND = "tts_list_recommend";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f376378a = null;

        static {
            f376378a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f376378a;
    }
}
