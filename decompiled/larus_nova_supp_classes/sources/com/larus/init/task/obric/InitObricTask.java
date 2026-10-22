package com.larus.init.task.obric;

import android.util.EventsUtils;
import androidx.work.Configuration;
import androidx.work.WorkManager;
import bf6.d;
import bg9.i;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.d1;
import com.larus.audio.k0;
import com.larus.camera.contract.CameraServiceDiffContract;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.messenger.IObricIPC;
import com.obric.assistant.IClearContextInKeyguardService;
import com.obric.assistant.IDoraAuthTrustService;
import com.obric.assistant.IObricActivityService;
import com.obric.assistant.IObricAssistant;
import com.obric.assistant.IObricOmniLockscreenStateService;
import com.obric.assistant.IRemoteCard;
import com.obric.assistant.ISessionAuthenticationService;
import com.obric.assistant.activity_stack.IObricActivityStackService;
import com.obric.assistant.appchange.IObricAppChangeListenerService;
import com.obric.assistant.attention.IObricAttentionService;
import com.obric.assistant.audio.IObricAudioStatusMonitorService;
import com.obric.assistant.audio.service.ObricLiveServiceDelegate;
import com.obric.assistant.automic.IObricAutoMicService;
import com.obric.assistant.chat.IObricChatPageStateService;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.IQueryAuthenticationService;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.debug.api.IObricDebugService;
import com.obric.assistant.desktop_icon.IObricAddDesktopIconService;
import com.obric.assistant.feedback.IObricFeedbackService;
import com.obric.assistant.feedback.IObricSystemFeedback;
import com.obric.assistant.frontier.IObricFrontierStatusMonitorService;
import com.obric.assistant.interaction.api.IObricApmService;
import com.obric.assistant.interaction.api.IObricApmServiceKt;
import com.obric.assistant.interaction.api.IObricChatUILifecycleMonitor;
import com.obric.assistant.interaction.api.keyguard.IKeyguardBiometricSetting;
import com.obric.assistant.interaction.api.keyguard.ISendMsgExtService;
import com.obric.assistant.interaction.api.service.IObricShowOnLockedService;
import com.obric.assistant.login.ILoginReport;
import com.obric.assistant.login.ILoginState;
import com.obric.assistant.login.IObricAccountInfoMonitorService;
import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.assistant.onelogin.IObricOneLogin;
import com.obric.assistant.reporter.IObricReporter;
import com.obric.assistant.reporter.IObricSystemReporter;
import com.obric.assistant.searchqa.IObricSearchQaLabelingService;
import com.obric.assistant.security.ICertificateCheckService;
import com.obric.assistant.settings.IAILabService;
import com.obric.assistant.settings.IObricPersonalContextSettingApi;
import com.obric.assistant.shortcut.IObricShortCutsService;
import com.obric.assistant.special_input.ISpecialInputTask;
import com.obric.assistant.spi.app.IObricLaunchService;
import com.obric.assistant.spi.audio.IObricRealtimeCallExtService;
import com.obric.assistant.spi.feedback.IObricFeedbackPanelService;
import com.obric.assistant.state.api.multitask.IObricStateMultitaskService;
import com.obric.assistant.state.api.v2.core.IObricStateDispatcherService;
import com.obric.assistant.storage.ObricLowStorageServiceDelegate;
import com.obric.assistant.system.ITaskStackService;
import com.obric.assistant.task.IObricTaskStatusManager;
import com.obric.assistant.trace.IObricTrace;
import com.obric.assistant.trace.IObricTraceParam;
import com.obric.assistant.ttnet.IObricTTNet;
import com.obric.assistant.voice.IObricVoiceService;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.obric.audio.enroll.VoiceEnrollServiceDelegate;
import com.obric.update.api.v2.IObricUpdateService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import lha.f;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/larus/init/task/obric/InitObricTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", XmlPullParser.NO_NAMESPACE, "getScene", "()Ljava/lang/String;", "runInternal", XmlPullParser.NO_NAMESPACE, "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitObricTask extends d implements i {
    public final String a;

    public static final class a {
    }

    static {
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        ObricFeatureServiceDelegate r0 = ObricFeatureServiceDelegate.b;
        if (r0.c() == false) goto L180;
        FLogger.a.d("InitObricTask", "runInternal: called, featureObric enabled");
        IObricIPC r1 = (IObricIPC) ServiceManager.get().getService(IObricIPC.class);
        if (r1 == null) goto L7;
        r1.a();
    L7:
        IObricChatService.a.getClass();
        IObricChatService r2 = IObricChatService.a.a();
        if (r2 == null) goto L10;
        r2.init();
    L10:
        IObricAttentionService r3 = (IObricAttentionService) ServiceManager.get().getService(IObricAttentionService.class);
        if (r3 == null) goto L13;
        r3.init();
    L13:
        IObricStateMultitaskService r4 = (IObricStateMultitaskService) ServiceManager.get().getService(IObricStateMultitaskService.class);
        if (r4 == null) goto L16;
        r4.a();
    L16:
        IObricStateDispatcherService r5 = (IObricStateDispatcherService) ServiceManager.get().getService(IObricStateDispatcherService.class);
        if (r5 == null) goto L19;
        r5.c();
    L19:
        IObricDebugService r6 = (IObricDebugService) ServiceManager.get().getServiceForReal(IObricDebugService.class);
        if (r6 == null) goto L22;
        AppHost.a.getApplication();
        r6.init();
    L22:
        boolean r7 = true;
        t68.a.a.d(true);
        ObricLiveServiceDelegate.b.init();
        IObricAssistant r8 = (IObricAssistant) ServiceManager.get().getService(IObricAssistant.class);
        if (r8 == null) goto L25;
        r8.g();
    L25:
        IObricAssistant r9 = (IObricAssistant) ServiceManager.get().getService(IObricAssistant.class);
        if (r9 == null) goto L28;
        r9.f();
    L28:
        IObricAssistant r10 = (IObricAssistant) ServiceManager.get().getService(IObricAssistant.class);
        if (r10 == null) goto L31;
        r10.i();
    L31:
        IObricFrontierStatusMonitorService r11 = (IObricFrontierStatusMonitorService) ServiceManager.get().getService(IObricFrontierStatusMonitorService.class);
        if (r11 == null) goto L34;
        r11.init();
    L34:
        IObricAudioStatusMonitorService r12 = (IObricAudioStatusMonitorService) ServiceManager.get().getService(IObricAudioStatusMonitorService.class);
        if (r12 == null) goto L37;
        r12.init();
    L37:
        IObricReporter.a.getClass();
        IObricReporter r13 = IObricReporter.a.a();
        if (r13 == null) goto L47;
        r13.e();
        r13.o();
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r14 = ISecPrivacyService.a.a();
        if (r14 != null) goto L42;
    L44:
        r7 = false;
    L45:
        if (r7 == false) goto L47;
        r13.r();
        goto L47
    L42:
        if (r14.h() != true) goto L44;
    L47:
        IObricSystemReporter.a.getClass();
        IObricSystemReporter r15 = IObricSystemReporter.a.a();
        if (r15 == null) goto L50;
        r15.init();
    L50:
        IObricAutoMicService r16 = (IObricAutoMicService) ServiceManager.get().getService(IObricAutoMicService.class);
        if (r16 == null) goto L53;
        r16.c();
    L53:
        IObricTraceParam r17 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r17 == null) goto L56;
        r17.m();
    L56:
        IObricReporter r18 = IObricReporter.a.a();
        if (r18 == null) goto L59;
        r18.i();
    L59:
        IObricTrace r19 = (IObricTrace) ServiceManager.get().getService(IObricTrace.class);
        if (r19 == null) goto L62;
        r19.a();
    L62:
        IObricShowOnLockedService r20 = (IObricShowOnLockedService) ServiceManager.get().getService(IObricShowOnLockedService.class);
        if (r20 == null) goto L65;
        r20.init();
    L65:
        IObricRealtimeCallExtService r21 = (IObricRealtimeCallExtService) ServiceManager.get().getService(IObricRealtimeCallExtService.class);
        if (r21 == null) goto L68;
        r21.init();
    L68:
        CameraServiceDiffContract.b.init();
        IRemoteCard r22 = (IRemoteCard) ServiceManager.get().getService(IRemoteCard.class);
        if (r22 == null) goto L71;
        r22.init();
    L71:
        IObricTTNet r23 = (IObricTTNet) ServiceManager.get().getService(IObricTTNet.class);
        if (r23 == null) goto L74;
        r23.a();
    L74:
        IObricNetworkService r24 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r24 == null) goto L77;
        r24.init();
    L77:
        ILoginState r25 = (ILoginState) ServiceManager.get().getService(ILoginState.class);
        if (r25 == null) goto L80;
        r25.a();
    L80:
        ILoginReport r26 = (ILoginReport) ServiceManager.get().getService(ILoginReport.class);
        if (r26 == null) goto L83;
        r26.init();
    L83:
        IObricOneLogin r28 = (IObricOneLogin) ServiceManager.get().getService(IObricOneLogin.class);
        if (r28 == null) goto L86;
        r28.b();
    L86:
        IObricFeedbackPanelService r29 = (IObricFeedbackPanelService) ServiceManager.get().getService(IObricFeedbackPanelService.class);
        if (r29 == null) goto L89;
        r29.a();
    L89:
        IObricAccountInfoMonitorService r30 = (IObricAccountInfoMonitorService) ServiceManager.get().getService(IObricAccountInfoMonitorService.class);
        if (r30 == null) goto L92;
        r30.init();
    L92:
        IObricChatUILifecycleMonitor r31 = (IObricChatUILifecycleMonitor) ServiceManager.get().getService(IObricChatUILifecycleMonitor.class);
        if (r31 == null) goto L95;
        r31.init();
    L95:
        IObricChatPageStateService r32 = (IObricChatPageStateService) ServiceManager.get().getService(IObricChatPageStateService.class);
        if (r32 == null) goto L98;
        r32.init();
    L98:
        IObricAddDesktopIconService r33 = (IObricAddDesktopIconService) ServiceManager.get().getService(IObricAddDesktopIconService.class);
        if (r33 == null) goto L101;
        r33.init();
    L101:
        ITaskStackService r34 = (ITaskStackService) ServiceManager.get().getService(ITaskStackService.class);
        if (r34 == null) goto L104;
        r34.init();
    L104:
        f.a().init();
        AudioServiceDelegate r35 = AudioServiceDelegate.a;
        k0 r36 = r35.x();
        d1 r37 = r35.i0();
        r36.e();
        r37.k();
        IAILabService r38 = (IAILabService) ServiceManager.get().getService(IAILabService.class);
        if (r38 == null) goto L107;
        r38.init();
    L107:
        IObricLaunchService r39 = (IObricLaunchService) ServiceManager.get().getService(IObricLaunchService.class);
        if (r39 == null) goto L110;
        r39.init();
    L110:
        ObricLowStorageServiceDelegate.b.init();
        ISessionAuthenticationService r40 = (ISessionAuthenticationService) ServiceManager.get().getService(ISessionAuthenticationService.class);
        if (r40 == null) goto L113;
        r40.init();
    L113:
        IDoraAuthTrustService r41 = (IDoraAuthTrustService) ServiceManager.get().getService(IDoraAuthTrustService.class);
        if (r41 == null) goto L116;
        r41.init();
    L116:
        IClearContextInKeyguardService r42 = (IClearContextInKeyguardService) ServiceManager.get().getService(IClearContextInKeyguardService.class);
        if (r42 == null) goto L119;
        r42.init();
    L119:
        IObricVoiceService r43 = (IObricVoiceService) ServiceManager.get().getService(IObricVoiceService.class);
        if (r43 == null) goto L122;
        r43.j();
    L122:
        IQueryAuthenticationService r44 = (IQueryAuthenticationService) ServiceManager.get().getService(IQueryAuthenticationService.class);
        if (r44 == null) goto L125;
        r44.init();
    L125:
        IObricPersonalContextSettingApi r45 = (IObricPersonalContextSettingApi) ServiceManager.get().getService(IObricPersonalContextSettingApi.class);
        if (r45 == null) goto L128;
        r45.u();
    L128:
        IObricUpdateService r46 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r46 == null) goto L131;
        AppHost.a.getApplication();
        r46.init();
    L131:
        IObricFeedbackService.a.getClass();
        IObricFeedbackService r47 = IObricFeedbackService.a.a();
        if (r47 == null) goto L134;
        r47.init();
    L134:
        IObricSystemFeedback.a.getClass();
        if (r0.c() == false) goto L137;
        IObricSystemFeedback r48 = (IObricSystemFeedback) ServiceManager.get().getService(IObricSystemFeedback.class);
    L138:
        if (r48 == null) goto L140;
        r48.init();
    L140:
        IBluetoothHeadSetAPI r49 = (IBluetoothHeadSetAPI) ServiceManager.get().getService(IBluetoothHeadSetAPI.class);
        if (r49 == null) goto L143;
        r49.start(AppHost.a.getApplication());
    L143:
        VoiceEnrollServiceDelegate.c.n();
        IObricShortCutsService r50 = (IObricShortCutsService) ServiceManager.get().getService(IObricShortCutsService.class);
        if (r50 == null) goto L146;
        r50.a();
    L146:
        Configuration r51 = new Configuration.Builder().setMinimumLoggingLevel(3).build();
        AppHost.Companion r52 = AppHost.a;
        WorkManager.initialize(r52.getApplication(), r51);
        IObricApmService r53 = IObricApmServiceKt.getObricApmServiceDelegate();
        if (r53 == null) goto L149;
        r53.markReady();
    L149:
        ICertificateCheckService r54 = (ICertificateCheckService) ServiceManager.get().getService(ICertificateCheckService.class);
        if (r54 == null) goto L152;
        r54.a();
    L152:
        IObricTaskStatusManager r55 = (IObricTaskStatusManager) ServiceManager.get().getService(IObricTaskStatusManager.class);
        if (r55 == null) goto L155;
        r55.init();
    L155:
        IObricActivityService r56 = (IObricActivityService) ServiceManager.get().getService(IObricActivityService.class);
        if (r56 == null) goto L158;
        r56.init();
    L158:
        IObricOmniLockscreenStateService r57 = (IObricOmniLockscreenStateService) ServiceManager.get().getService(IObricOmniLockscreenStateService.class);
        if (r57 == null) goto L161;
        r57.init();
    L161:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new runInternal.3(null), 3, null);
        IObricActivityStackService r58 = (IObricActivityStackService) ServiceManager.get().getService(IObricActivityStackService.class);
        if (r58 == null) goto L164;
        r58.init();
    L164:
        ISpecialInputTask r59 = (ISpecialInputTask) ServiceManager.get().getService(ISpecialInputTask.class);
        if (r59 == null) goto L167;
        r59.init();
    L167:
        ISendMsgExtService r60 = (ISendMsgExtService) ServiceManager.get().getService(ISendMsgExtService.class);
        if (r60 == null) goto L170;
        r60.init();
    L170:
        IKeyguardBiometricSetting r61 = (IKeyguardBiometricSetting) ServiceManager.get().getService(IKeyguardBiometricSetting.class);
        if (r61 == null) goto L173;
        r61.init();
    L173:
        IObricSearchQaLabelingService.a.getClass();
        IObricSearchQaLabelingService r62 = (IObricSearchQaLabelingService) ServiceManager.get().getService(IObricSearchQaLabelingService.class, false, false);
        if (r62 == null) goto L176;
        r62.init();
    L176:
        IObricAppChangeListenerService r63 = (IObricAppChangeListenerService) ServiceManager.get().getService(IObricAppChangeListenerService.class);
        if (r63 == null) goto L181;
        r63.init(r52.getApplication());
        return;
    L181:
        return;
    L137:
        r48 = null;
        goto L138
    }

    public InitObricTask() {
        this.a = "OBRIC";
    }

    @Override // java.lang.Runnable, bg9.i
    public final void run() {
        i.a.a(this);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.a;
    }
}
