package l68;

import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.larus.audio.audiov3.task.tts.TtsEventEnum;
import com.larus.audio.audiov3.task.tts.TtsLifeState;
import com.larus.audio.audiov3.task.tts.TtsState;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes24.dex */
public interface b {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(b r100, TtsEventEnum r101, String r110, int r111, String r112, Map r113, int r114) {
            if ((r114 & 2) == 0) goto L5;
            String r102 = "";
        L7:
            if ((r114 & 4) == 0) goto L9;
            int r103 = -1;
        L11:
            if ((r114 & 8) == 0) goto L13;
            String r104 = "";
        L15:
            if ((r114 & 16) == 0) goto L17;
            r113 = MapsKt.emptyMap();
        L17:
            r100.c(r101, r102, r103, r104, r113);
            return;
        L13:
            r104 = r112;
            goto L15
        L9:
            r103 = r111;
            goto L11
        L5:
            r102 = r110;
            goto L7
        }
    }

    void a(TtsTracer r100);

    void b(byte[] r100, boolean r101);

    void c(TtsEventEnum r100, String r101, int r102, String r103, Map<String, ? extends Object> r104);

    void d(TtsState r100);

    void e(TtsLifeState r100, String r101, Map<String, String> r102);
}
