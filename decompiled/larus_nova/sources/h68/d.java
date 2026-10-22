package h68;

import com.larus.audio.audiov3.config.task.sami.asr.ReportType;
import com.larus.audio.audiov3.task.asr.AsrEventEnum;
import com.larus.audio.audiov3.task.asr.AsrLifeState;
import com.larus.audio.audiov3.task.asr.AsrState;
import com.larus.audio.audiov3.task.asr.sami.data.SamiAsrDataBin;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface d {
    void a(y58.b r100);

    void b(b r100);

    void c(SamiAsrDataBin r100);

    void d(AsrLifeState r100, String r101, Map<String, String> r102);

    void e(AsrState r100);

    void f(y58.b r100, ReportType r101);

    void onEvent(AsrEventEnum r100);
}
