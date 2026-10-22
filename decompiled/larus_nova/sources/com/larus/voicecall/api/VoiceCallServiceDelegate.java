package com.larus.voicecall.api;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import b3a.a;
import b3a.b;
import b3a.c;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.EditPos;
import com.larus.voicecall.api.bean.SpeechAecDownloadResult;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import z2a.d;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J*\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\"\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0017\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010!J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\nH\u0016J \u0010&\u001a\u00020\b2\u0006\u0010#\u001a\u00020$2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000eH\u0016J(\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020,2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010-J*\u0010*\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0016J!\u0010.\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u00010\u000e2\b\u00100\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0002\u00101J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020\nH\u0016J\b\u00105\u001a\u00020\nH\u0016J\u0010\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\nH\u0016J\u0010\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\u000eH\u0016J \u0010:\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\nH\u0016J \u0010<\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\nH\u0016J.\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0>2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\nH\u0016J\u0010\u0010?\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\nH\u0016J\u0018\u0010@\u001a\u00020\b2\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010BH\u0016J\u001e\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010D2\u0006\u0010)\u001a\u00020\u000eH\u0016J\b\u0010E\u001a\u00020\nH\u0016J\u0010\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\nH\u0016J\b\u0010H\u001a\u00020\nH\u0016J\"\u0010I\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\u000e2\b\u0010K\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010L\u001a\u00020\b2\b\u0010M\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010N\u001a\u00020\b2\b\u0010M\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010O\u001a\u00020\b2\b\u0010M\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020RH\u0016J\u0010\u0010S\u001a\u00020\b2\u0006\u0010Q\u001a\u00020RH\u0016J\u0010\u0010T\u001a\u00020\b2\u0006\u0010U\u001a\u00020VH\u0016J\u0018\u0010W\u001a\u00020\b2\u0006\u0010X\u001a\u00020\u000e2\u0006\u0010Y\u001a\u00020ZH\u0016R\u0014\u0010\u0004\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006["}, d2 = {"Lcom/larus/voicecall/api/VoiceCallServiceDelegate;", "Lcom/larus/voicecall/api/IVoiceCallService;", "<init>", "()V", "_delegate", "get_delegate", "()Lcom/larus/voicecall/api/IVoiceCallService;", "initAVKit", "", "isInRealtimeCall", "", "isTopRealtimeCallActivity", "getTranslucentPages", "", "", "buildConnectionConfig", "Lcom/larus/voicecall/api/bean/PreConnectConfig;", "isRealtimeCallEnable", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "conversationId", "enableSilence", "isEditable", "curPlayingConversationId", "curPlayingBotId", "currentSceneKey", "isSupportNoSpeakingHangup", "getNoSpeakingHangupDuration", "", "getLocationPermissionState", "", "isRealtimeCallDowngradeOut", "botType", "(Ljava/lang/Integer;)Z", "startRealtimeCallNewOut", "bean", "Lcom/larus/voicecall/api/bean/StartCallPayLoadBean;", "hasReportClickCall", "startRealtimeCallWithJudgeOut", "manager", "Landroidx/fragment/app/FragmentManager;", "scene", "isRealtimeCallEnabledOut", "editPos", "Lcom/larus/platform/model/EditPos;", "(Lcom/larus/platform/model/EditPos;Lcom/larus/im/bean/bot/BotModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isMainBot", "botConversationId", "botConversationType", "(Ljava/lang/String;Ljava/lang/Integer;)Z", "getRtcNotificationService", "Lcom/larus/voicecall/api/IRtcNotificationService;", "getIsRealtimeUseCallModeAtStart", "isRealtimeSkipBtConnPermission", "autoStartFromNextRoundFrame", NotificationCompat.GROUP_KEY_SILENT, "requestRealtimeCallDegradeConfig", "callFrom", "realtimeCallDowngradeHookShow", SoloKtvContext.SOLO_PAGE_ENTRANCE, "realtimeCallDowngradeHookClick", "realtimeCallDowngradeHookClickV2", "Lkotlin/Pair;", "getRealtimeCallTtsConfig", "setOnRealtimeConfigChangeCallback", "callback", "Lkotlin/Function0;", "getDowngradeExtra", "", "isPseudoConnectEnabled", "changeFullScreenCallSwitch", "isFullScreen", "isFullScreenCall", "isUseContinueTalk", "botId", "bot", "handleMuseumInAppNotification", "rawNotify", "trackMuseumExtensionGeneralNotificationShow", "pickMuseumExtensionFromNotification", "registerMuseumInAppNotificationListener", "listener", "Lcom/larus/voicecall/api/MuseumInAppNotificationListener;", "unregisterMuseumInAppNotificationListener", "setAecModelMeta", "meta", "Lcom/larus/voicecall/api/bean/SpeechAecModelMeta;", "setAecDownloadResult", "collectionName", "result", "Lcom/larus/voicecall/api/bean/SpeechAecDownloadResult;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceCallServiceDelegate implements IVoiceCallService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final VoiceCallServiceDelegate f377087a = null;

    static {
        f377087a = new VoiceCallServiceDelegate();
    }

    private VoiceCallServiceDelegate() {
    }

    public static IVoiceCallService O() {
        IVoiceCallService r100 = (IVoiceCallService) ServiceManager.get().getService(IVoiceCallService.class);
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new VoiceCallServiceNoop();
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final Map c() {
        Intrinsics.checkNotNullParameter("avsdk", "scene");
        return O().c();
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final void C() {
        O().C();
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final boolean D() {
        return O().D();
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final boolean F() {
        return O().F();
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final long G() {
        return O().G();
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final String H() {
        return O().H();
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final String I() {
        return O().I();
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final IRtcNotificationService K() {
        return O().K();
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final int N() {
        return O().N();
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final List<String> a() {
        return O().a();
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final boolean d() {
        return O().d();
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final boolean e() {
        return O().e();
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final boolean i() {
        return O().i();
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final boolean l() {
        return O().l();
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final boolean p() {
        return O().p();
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final String s() {
        return O().s();
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final a v() {
        return O().v();
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final Pair A(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter("other", SoloKtvContext.SOLO_PAGE_ENTRANCE);
        return O().A(r100);
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final void B(String r100) {
        O().B(r100);
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final void L(d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        O().L(r100);
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final void M(com.larus.audio.tts.a r100) {
        O().M(r100);
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final boolean b(boolean r100) {
        return O().b(r100);
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final void g(String r100) {
        O().g(r100);
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final void h(String r100) {
        O().h(r100);
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final void j(d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        O().j(r100);
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final String k(boolean r100) {
        return O().k(r100);
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final void n(b r100) {
        Intrinsics.checkNotNullParameter(r100, "meta");
        O().n(r100);
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final void w(String r100) {
        Intrinsics.checkNotNullParameter(r100, "callFrom");
        O().w(r100);
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final void y(boolean r100) {
        O().y(r100);
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final boolean z(Integer r100) {
        return O().z(r100);
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final boolean E(String r100, Integer r101) {
        return O().E(r100, r101);
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final void m(String r100, SpeechAecDownloadResult r101) {
        Intrinsics.checkNotNullParameter(r100, "collectionName");
        Intrinsics.checkNotNullParameter(r101, "result");
        O().m(r100, r101);
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final void t(c r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "bean");
        O().t(r100, r101);
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final void J(c r100, FragmentManager r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "bean");
        Intrinsics.checkNotNullParameter(r101, "manager");
        Intrinsics.checkNotNullParameter(r102, "scene");
        O().J(r100, r101, r102);
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final boolean o(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, SoloKtvContext.SOLO_PAGE_ENTRANCE);
        return O().o(r100, r101, r102);
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final boolean q(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, SoloKtvContext.SOLO_PAGE_ENTRANCE);
        return O().q(r100, r101, r102);
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final boolean r(BotModel r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        return O().r(r100, r101, r102);
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final boolean u(String r100, String r101, BotModel r102) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "botId");
        return O().u(r100, r101, r102);
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final Object f(EditPos r100, BotModel r101, String r102, Continuation<? super Boolean> r103) {
        return O().f(r100, r101, r102, r103);
    }

    @Override // com.larus.voicecall.api.IVoiceCallService
    public final boolean x(BotModel r100, String r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        return O().x(r100, r101, r102, r103);
    }
}
