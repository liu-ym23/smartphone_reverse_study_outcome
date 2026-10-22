package md0;

import com.bytedance.android.livesdkapi.model.SeiAppData;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public interface a {

    /* JADX INFO: renamed from: md0.a$a, reason: collision with other inner class name */
    public interface InterfaceC6802a {
        boolean isVersionSupported(int r100, int r101);

        void onBusinessAppSeiUpdate(JSONObject r100);

        void onSeiUpdated(SeiAppData r100);
    }

    public interface b {
        void onKtvSeiUpdate(String r100);
    }

    public interface c extends InterfaceC6802a {
        void onAudioMvControllerUpdate(String r100);

        void onAudioSubtitleUpdate(String r100);

        void onRadioSeiUpdate(JSONObject r100);

        void onRadioTextSeiUpdate(JSONObject r100);

        void onSpeechRecognitionSeiUpdate(String r100);

        void onSpeechRhythm(String r100);

        void onVideoStateSeiUpdate(ld0.a r100);
    }
}
