package f39;

import com.larus.doc.sdk.api.VoiceInputFrom;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes27.dex */
public interface g extends m1a.a {
    void Qe(boolean r100, @VoiceInputFrom String r101);

    StateFlowImpl getVoiceInputStatus();

    void notifyDocLoadSuccess();
}
