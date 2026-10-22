package o78;

import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audio.controller.GlobalAudioStateEnum;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public interface b {

    /* JADX INFO: loaded from: classes24.dex */
    public static final class a {
        public static void a(String r100) {
            Intrinsics.checkNotNullParameter(GlobalAudioSceneEnum.TTS_IM, "scene");
            Intrinsics.checkNotNullParameter(r100, "uniId");
        }
    }

    void a(@GlobalAudioSceneEnum String r100, GlobalAudioStateEnum r101, Map<String, String> r102);

    void b(@GlobalAudioSceneEnum String r100, Integer r101, Integer r102);

    void c(String r100, Map r101);

    void d(@GlobalAudioSceneEnum String r100, String r101, Map<String, String> r102);
}
