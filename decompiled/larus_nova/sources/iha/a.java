package iha;

import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import com.larus.voicecall.obric.IObricRealtimeCallService;
import com.obric.assistant.audio.service.ObricLiveServiceDelegate;
import com.obric.assistant.state.api.v2.core.AssistantAliveReason;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandPriority;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandStateType;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import com.obric.assistant.state.impl.v2.ObricStateImpl;
import com.obric.assistant.state.impl.v2.core.g;
import com.obric.assistant.state.impl.v2.power.ObricPowerManager;
import com.obric.assistant.state.impl.v2.utils.f;
import eha.b;
import eha.c;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f489924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C6270a f489925b;

    /* JADX INFO: renamed from: iha.a$a, reason: collision with other inner class name */
    public static final class C6270a implements IObricRealtimeCallService.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f489926a;

        public C6270a(a r100) {
            this.f489926a = r100;
        }

        @Override // com.larus.voicecall.obric.IObricRealtimeCallService.a
        public final void onEnterRealtimeCall(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "botId");
            Intrinsics.checkNotNullParameter(r101, "conversationId");
            a r102 = this.f489926a;
            r102.f489924a = r101;
            FLogger.f375446a.i("[RealtimeCallStateHandler]", "mobRealtimeCallStart, " + r102.f489924a);
            List<bha.a> r103 = ObricStateImpl.f393176a;
            y.c(new c());
            if (f.f393224a == true) goto L6;
            CoroutineScope r104 = ObricPowerManager.f393203a;
            ObricPowerManager.c(AssistantAliveReason.REALTIME_CALL_IN_PROGRESS);
            return;
        }

        @Override // com.larus.voicecall.obric.IObricRealtimeCallService.a
        public final void onExitRealtimeCall(String r110, String r111) {
            Intrinsics.checkNotNullParameter(r110, "botId");
            Intrinsics.checkNotNullParameter(r111, "conversationId");
            a r112 = this.f489926a;
            r112.getClass();
            FLogger.f375446a.i("[RealtimeCallStateHandler]", "mobRealtimeCallEnd, " + r111);
            r112.f489924a = null;
            ObricLiveServiceDelegate r113 = ObricLiveServiceDelegate.f385676b;
            ObricInteractionScene r100 = ObricInteractionScene.REALTIME_CALL_SCENE;
            r113.l(r100.ordinal(), false);
            if (r111 == null) goto L5;
            hha.a r114 = g.f393191a;
            g.a(new ObricState(ObricIslandStateType.REALTIME_CALL_END, r111, r100, ObricIslandPriority.MEDIUM, null, null, null, 112, null));
        L5:
            List<bha.a> r115 = ObricStateImpl.f393176a;
            y.c(new b());
            if (f.f393224a == true) goto L9;
            CoroutineScope r116 = ObricPowerManager.f393203a;
            ObricPowerManager.f(AssistantAliveReason.REALTIME_CALL_IN_PROGRESS);
            return;
        }
    }

    public a() {
        this.f489925b = new C6270a(this);
    }
}
