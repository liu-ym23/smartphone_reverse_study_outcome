package com.obric.assistant.state.api.multitask;

import com.obric.assistant.state.api.multitask.state.VoiceCaptureScene;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\bg\u0018\u00002\u00020\u0001JC\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\fJ7\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000eJ?\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\n2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u0011J7\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000eJ7\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/state/api/multitask/IVoiceCaptureStateProducerService;", "", "start", "", "conversationId", "", "scene", "Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;", "sessionId", "sourceType", "", "botId", "(Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "onAsrStart", "(Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;Ljava/lang/String;Ljava/lang/Integer;)V", "onCallStateChanged", "callState", "(Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;ILjava/lang/String;Ljava/lang/Integer;)V", "onAsrEnd", "end", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IVoiceCaptureStateProducerService {

    public static final class a {
        public static /* synthetic */ void a(VoiceCaptureStateProducerDelegate r100, String r101, VoiceCaptureScene r102, String r103, Integer r110) {
            r100.b(r101, r102, r103, r110, null);
        }
    }

    void a(String r100, VoiceCaptureScene r101, int r102, String r103, Integer r104);

    void b(String r100, VoiceCaptureScene r101, String r102, Integer r103, String r104);

    void c(String r100, VoiceCaptureScene r101, String r102, Integer r103);

    void d(String r100, VoiceCaptureScene r101, String r102, Integer r103);

    void e(String r100, VoiceCaptureScene r101, String r102, Integer r103);
}
