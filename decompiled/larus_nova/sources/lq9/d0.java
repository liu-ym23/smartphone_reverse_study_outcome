package lq9;

import com.mammon.audiosdk.session.type.RequestEvent;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f510330a = null;

    static {
        f510330a = CollectionsKt.mutableListOf(new String[]{RequestEvent.StartTask, RequestEvent.FinishTask, RequestEvent.StartSession, RequestEvent.FinishSession, RequestEvent.ClientInterrupt, RequestEvent.MuteCall, RequestEvent.UnmuteCall, RequestEvent.PauseCall, RequestEvent.ContinueCall, RequestEvent.TriggerBot, RequestEvent.TaskRequest});
    }
}
