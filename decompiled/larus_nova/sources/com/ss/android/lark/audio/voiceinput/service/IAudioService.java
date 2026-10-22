package com.ss.android.lark.audio.voiceinput.service;

import com.bytedance.lark.pb.im.v1.SpeechScene;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.audio.voiceinput.utils.VoiceUtils$abortUploadAudio$1;
import com.ss.android.lark.keyboard.plugin.tool.voice.processor.RecognizeAudioData$process$1;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes34.dex */
public interface IAudioService {

    @Retention(RetentionPolicy.SOURCE)
    public @interface SpeechRecognitionAction {
        public static final int BEGIN = 1;
        public static final int END = 2;
        public static final int UNKNOWN = 0;
    }

    void Jb(String r100, int r101, String r102, String r103, byte[] r104, int r105, String r106, boolean r107, boolean r108, boolean r110, boolean r111, SpeechScene r112, boolean r113, IGetDataCallback r114);

    void Oc(String r100, int r101, String r102, String r103, byte[] r104, int r105, String r106, boolean r107, boolean r108, boolean r110, boolean r111, RecognizeAudioData$process$1 r112);

    void S4(String r100, String r101, IGetDataCallback r102);

    boolean e3(String r100, String r101);

    String ec(String r100, String r101, String r102);

    void jc(String r100, int r101, byte[] r102, boolean r103, IGetDataCallback r104);

    void xa(String r100, VoiceUtils$abortUploadAudio$1 r101);
}
