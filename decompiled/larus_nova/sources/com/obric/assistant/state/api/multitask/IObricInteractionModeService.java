package com.obric.assistant.state.api.multitask;

import com.obric.assistant.state.api.multitask.state.ModeEndReason;
import com.obric.assistant.state.api.multitask.state.ModeRefreshSource;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JK\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bH&¢\u0006\u0002\u0010\fJA\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bH&¢\u0006\u0002\u0010\u0012J0\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bH&J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/state/api/multitask/IObricInteractionModeService;", "", "startMode", "", "botId", "conversationId", "interactionType", "Lcom/obric/assistant/state/api/multitask/state/ObricInteractionType;", "timeoutMillis", "", "ext", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/ObricInteractionType;Ljava/lang/Long;Ljava/util/Map;)Ljava/lang/String;", "refreshMode", "", "sessionId", "source", "Lcom/obric/assistant/state/api/multitask/state/ModeRefreshSource;", "(Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/ModeRefreshSource;Ljava/lang/Long;Ljava/util/Map;)V", "endMode", "reason", "Lcom/obric/assistant/state/api/multitask/state/ModeEndReason;", "getActiveMode", "Lcom/obric/assistant/state/api/multitask/ActiveModeSnapshot;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricInteractionModeService {

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a {
        public static /* synthetic */ void a(ObricInteractionModeServiceDelegate r100, String r101, ModeEndReason r102) {
            r100.b(r101, r102, MapsKt.emptyMap());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ String b(ObricInteractionModeServiceDelegate r100, String r101, String r102, ObricInteractionType r103, Map r110, int r111) {
            if ((r111 & 16) == 0) goto L6;
            r110 = MapsKt.emptyMap();
        L6:
            return r100.d(r101, r102, r103, null, r110);
        }
    }

    void a(String r100, ModeRefreshSource r101, Long r102, Map<String, ? extends Object> r103);

    void b(String r100, ModeEndReason r101, Map<String, ? extends Object> r102);

    zga.a c(String r100);

    String d(String r100, String r101, ObricInteractionType r102, Long r103, Map<String, ? extends Object> r104);
}
