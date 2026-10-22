package com.obric.assistant.session.model;

import android.content.Context;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.common.utils.p;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.spi.audio.CallType;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import t1a.b;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0012\u001a\u00020\nH&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0001H&J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0018\u001a\u00020\u0010H&J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0002\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010!\u001a\u00020\nH&JC\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\n2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010'\u001a\u00020\nH&¢\u0006\u0002\u0010(J\u001a\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\b\b\u0002\u0010+\u001a\u00020\nH&J\b\u0010,\u001a\u00020\u0003H&J\b\u0010-\u001a\u00020\u0003H&J\u001c\u0010.\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u0001002\b\b\u0002\u00101\u001a\u00020\nH&J\u001a\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0010H&J\b\u00106\u001a\u00020\u0003H&J\b\u00107\u001a\u00020\nH&J\b\u00108\u001a\u00020\u0003H&J\u0010\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0010H&J\u0012\u0010;\u001a\u00020\n2\b\u0010<\u001a\u0004\u0018\u00010=H&J\u0012\u0010>\u001a\u00020\n2\b\u0010<\u001a\u0004\u0018\u00010=H&J\b\u0010?\u001a\u00020\u0003H&¨\u0006@"}, d2 = {"Lcom/obric/assistant/session/model/ISessionMaintaining;", "", "init", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "interactionSession", "Landroid/service/voice/VoiceInteractionSession;", "getContext", "distinguishWakeupSource", "", "args", "Landroid/os/Bundle;", "showFlags", "", "getAssistantRequestFrom", "", "getWakeupSessionName", "isAutoMicRequest", BasicTestActionHandler.TEST_ACTION_RESET, "unregisterAsrListener", "registerAsrListener", "onStopIntercom", ComplianceConstants.ComplianceRequest.MARKET_STORE, "key", "value", MonitorConstants.CONNECT_TYPE_GET, "onSessionPrepare", "onSessionProcess", "Lcom/obric/assistant/session/bean/ErrorCode;", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSessionComplete", "errorCode", "launchAssistantNow", "launchAssistantDirectly", "isMicInUse", "extra", "ignoreSpecialInput", "wakeUpClickTalk", "checkScreenLock", "(ZLandroid/os/Bundle;ZLjava/lang/Boolean;Z)V", "launchAssistant", "showOnLauncherOrKeyguard", "needUpdate", "markActivateToRecordStart", "closeSystemDialogs", "checkOpenSpecialInput", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "isVoiceInput", "launchRealtimeCall", "callType", "Lcom/obric/assistant/spi/audio/CallType;", "startupAttemptId", "closeClickTalk", "tryFinishChatActivity", "startAsrTimeout", "stopAsrTimeout", "from", "tryFinishApplet", "activity", "Landroidx/fragment/app/FragmentActivity;", "tryFinishDialogFragment", "interruptMovingBackground", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISessionMaintaining {

    public static final class a {
        public static /* synthetic */ void a(ISessionMaintaining r100, Bundle r101, Boolean r110, boolean r111, int r112) {
            if ((r112 & 1) == 0) goto L5;
            Set<String> r102 = p.f387885a;
            AppHost.Companion r103 = AppHost.f326268a;
            boolean r104 = p.f(r103.getApplication(), p.b(r103.getApplication()));
        L7:
            if ((r112 & 2) == 0) goto L9;
            Bundle r105 = null;
        L11:
            if ((r112 & 8) == 0) goto L13;
            Boolean r106 = null;
        L15:
            if ((r112 & 16) == 0) goto L17;
            boolean r107 = false;
        L18:
            r100.b(r104, r105, false, r106, r107);
            return;
        L17:
            r107 = r111;
            goto L18
        L13:
            r106 = r110;
            goto L15
        L9:
            r105 = r101;
            goto L11
        L5:
            r104 = false;
            goto L7
        }
    }

    void b(boolean r100, Bundle r101, boolean r102, Boolean r103, boolean r104);

    void c();

    void closeSystemDialogs();

    Object d(Bundle r100, Continuation<? super ErrorCode> r101);

    boolean e(Bundle r100);

    boolean f(FragmentActivity r100);

    boolean g();

    Context getContext();

    void h(String r100, Object r101);

    void i();

    void interruptMovingBackground();

    boolean j();

    void k(b r100, boolean r101);

    void l();

    void m();

    boolean n(FragmentActivity r100);

    String o();

    void p(Context r100, Bundle r101);

    void r(ErrorCode r100, Bundle r101);

    boolean s(boolean r100, boolean r101);

    void t(Context r100, VoiceInteractionSession r101);

    void u(CallType r100, String r101);

    void v();

    String w();

    void x();

    void y();
}
