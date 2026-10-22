package com.obric.assistant.state.api.multitask;

import com.obric.assistant.state.api.multitask.state.ModeEndReason;
import com.obric.assistant.state.api.multitask.state.ModeRefreshSource;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zga.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0096\u0001J\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0001J>\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0096\u0001¢\u0006\u0002\u0010\u0015JH\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0096\u0001¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/state/api/multitask/ObricInteractionModeServiceDelegate;", "Lcom/obric/assistant/state/api/multitask/IObricInteractionModeService;", "<init>", "()V", "endMode", "", "sessionId", "", "reason", "Lcom/obric/assistant/state/api/multitask/state/ModeEndReason;", "ext", "", "", "getActiveMode", "Lcom/obric/assistant/state/api/multitask/ActiveModeSnapshot;", "botId", "refreshMode", "source", "Lcom/obric/assistant/state/api/multitask/state/ModeRefreshSource;", "timeoutMillis", "", "(Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/ModeRefreshSource;Ljava/lang/Long;Ljava/util/Map;)V", "startMode", "conversationId", "interactionType", "Lcom/obric/assistant/state/api/multitask/state/ObricInteractionType;", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/ObricInteractionType;Ljava/lang/Long;Ljava/util/Map;)Ljava/lang/String;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricInteractionModeServiceDelegate implements IObricInteractionModeService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricInteractionModeServiceDelegate f392941b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricInteractionModeService f392942a;

    static {
        f392941b = new ObricInteractionModeServiceDelegate();
    }

    @Override // com.obric.assistant.state.api.multitask.IObricInteractionModeService
    public final void a(String r100, ModeRefreshSource r101, Long r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r103, "ext");
        this.f392942a.a(r100, r101, r102, r103);
    }

    @Override // com.obric.assistant.state.api.multitask.IObricInteractionModeService
    public final void b(String r100, ModeEndReason r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "reason");
        Intrinsics.checkNotNullParameter(r102, "ext");
        this.f392942a.b(r100, r101, r102);
    }

    @Override // com.obric.assistant.state.api.multitask.IObricInteractionModeService
    public final a c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        return this.f392942a.c(r100);
    }

    @Override // com.obric.assistant.state.api.multitask.IObricInteractionModeService
    public final String d(String r100, String r101, ObricInteractionType r110, Long r111, Map<String, ? extends Object> r112) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        Intrinsics.checkNotNullParameter(r110, "interactionType");
        Intrinsics.checkNotNullParameter(r112, "ext");
        return this.f392942a.d(r100, r101, r110, r111, r112);
    }

    private ObricInteractionModeServiceDelegate() {
        this.f392942a = (IObricInteractionModeService) ServiceManager.get().getService(IObricInteractionModeService.class);
    }
}
