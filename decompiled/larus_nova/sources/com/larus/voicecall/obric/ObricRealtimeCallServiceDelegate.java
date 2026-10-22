package com.larus.voicecall.obric;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b78.h;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.audio.call.a;
import com.larus.audio.call.arch.c;
import com.larus.audio.call.plugins.c1;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import com.larus.trace.tracespan.span.b;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAvatar;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u0010\u000b\u001a\u00020\fH\u0096\u0001J\t\u0010\r\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J[\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u00102 \u0010\u001c\u001a\u001c\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001dH\u0096\u0001J\u001d\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0!2\u0006\u0010\"\u001a\u00020#H\u0096\u0001J\t\u0010$\u001a\u00020\nH\u0096\u0001J\t\u0010%\u001a\u00020\u000eH\u0096\u0001J\u0011\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001eH\u0096\u0001J\t\u0010)\u001a\u00020\nH\u0096\u0001J\u0013\u0010*\u001a\u0004\u0018\u00010#2\u0006\u0010+\u001a\u00020,H\u0096\u0001J\u0013\u0010-\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010/H\u0096\u0001J\t\u00100\u001a\u000201H\u0096\u0001J\u0016\u00102\u001a\u00020\u00052\u0006\u0010(\u001a\u000203H\u0096A¢\u0006\u0002\u00104J\t\u00105\u001a\u00020\u0010H\u0096\u0001J\t\u00106\u001a\u00020\u0010H\u0096\u0001J\u0011\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u000209H\u0096\u0001J\u0011\u0010:\u001a\u00020\u00102\u0006\u0010;\u001a\u00020<H\u0096\u0001J\u0018\u0010=\u001a\u00020\u00102\b\u0010>\u001a\u0004\u0018\u00010\u000eH\u0096\u0001¢\u0006\u0002\u0010?J\t\u0010@\u001a\u00020\u0010H\u0096\u0001J\t\u0010A\u001a\u00020\u0010H\u0096\u0001J\u0087\u0001\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\n2\b\u0010G\u001a\u0004\u0018\u00010H2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\n0J2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\n0J2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0M2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\n0J2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\n0J2\u0006\u0010P\u001a\u00020\u000eH\u0096\u0001J\u0011\u0010Q\u001a\u00020\u00052\u0006\u0010+\u001a\u00020,H\u0096\u0001J\u0011\u0010R\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010S\u001a\u00020\u00052\u0006\u0010T\u001a\u00020\u0010H\u0096\u0001J\u0011\u0010U\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0096\u0001¨\u0006V"}, d2 = {"Lcom/larus/voicecall/obric/ObricRealtimeCallServiceDelegate;", "Lcom/larus/voicecall/obric/IObricRealtimeCallService;", "<init>", "()V", "addRealtimeCallActivityStateCallback", "", "callback", "Lcom/larus/voicecall/obric/IObricRealtimeCallService$IObricRealtimeCallActivityStateListener;", "bindForegroundService", "reason", "", "buildConnectionConfig", "Lcom/larus/im/service/IMediaService$PreConnectConfig;", "callSampleRate", "", "enableSubtitleAsrSeg", "", "generateRealtimeCallService", "Lcom/larus/audio/call/AbsRealtimeCallService;", "sessionCreator", "Lcom/larus/audio/call/utils/IAudioSessionCreator;", "spanWrap", "Lcom/larus/trace/tracespan/span/ITraceSpanWrap;", "spanScene", "lifecycleScope", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "skipDowngradePluginForClickTalk", "collectBizPlugin", "Lkotlin/Function2;", "Lcom/larus/audio/call/arch/ICommonPluginContext;", "Lcom/larus/audio/call/arch/ILLMPluginRegistry;", "getConversationIdAndBotId", "Lkotlin/Pair;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "getFlagArgumentLandingFeatureScene", "getLoudNormAlgoType", "getPlugin", "Lcom/larus/audio/call/plugins/IUIStatePluginProvider;", PerfLog.PARAM_KEY_CONTEXT_ID, "getRealtimeCallActivityName", "getRealtimeCallFragment", "activity", "Landroidx/fragment/app/FragmentActivity;", "getRealtimeStyleId", MmEndWindowAvatar.TYPE_SPEAKER, "Lcom/larus/im/bean/bot/SpeakerVoice;", "getTargetLoudness", "", "initRealtimeCallParams", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAutoInterrupt", "isCurrentSessionUsingOneshot", "isQuery", "msg", "Lcom/larus/im/bean/message/Message;", "isRealtimeCallActivity", TTVideoEngineInterface.PLAY_API_KEY_AC, "Landroid/app/Activity;", "isRealtimeCallDowngradeByCall", "botType", "(Ljava/lang/Integer;)Z", "isRtcEnabled", "isScreenShareEnable", "onRealtimeDestroy", "botId", "localConversationId", "conversationId", "localCallId", "tracer", "Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "imAsrMsgNum", "Ljava/util/concurrent/CopyOnWriteArraySet;", "imTtsMsgNum", "imTtsPreQueryMsgMap", "Ljava/util/concurrent/ConcurrentHashMap;", "vuiAsrMsgIdSet", "vuiChatRespMsgIdSet", "vuiTtsRespMsgNum", "preCloseCamera", "removeRealtimeCallActivityStateCallback", "setIsInCall", "isInCall", "unBindAndDismissForegroundService", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricRealtimeCallServiceDelegate implements IObricRealtimeCallService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricRealtimeCallServiceDelegate f379667b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricRealtimeCallService f379668a;

    static {
        f379667b = new ObricRealtimeCallServiceDelegate();
    }

    @Override // com.larus.voicecall.obric.IObricRealtimeCallService
    public final boolean a() {
        return this.f379668a.a();
    }

    @Override // com.larus.voicecall.obric.IObricRealtimeCallService
    public final float b() {
        return this.f379668a.b();
    }

    @Override // com.larus.voicecall.obric.IObricRealtimeCallService
    public final int c() {
        return this.f379668a.c();
    }

    @Override // com.larus.voicecall.obric.IObricRealtimeCallService
    public final boolean d(Integer r100) {
        return this.f379668a.d(r100);
    }

    @Override // com.larus.voicecall.obric.IObricRealtimeCallService
    public final int e() {
        return this.f379668a.e();
    }

    @Override // com.larus.voicecall.obric.IObricRealtimeCallService
    public final a f(h r100, b r101, Function0 r110, boolean r111, Function2 r112) {
        Intrinsics.checkNotNullParameter(r100, "sessionCreator");
        Intrinsics.checkNotNullParameter(r101, "spanWrap");
        Intrinsics.checkNotNullParameter("continuous_talk", "spanScene");
        Intrinsics.checkNotNullParameter(r110, "lifecycleScope");
        return this.f379668a.f(r100, r101, r110, r111, r112);
    }

    @Override // com.larus.voicecall.obric.IObricRealtimeCallService
    public final boolean g() {
        return this.f379668a.g();
    }

    @Override // com.larus.voicecall.obric.IObricRealtimeCallService
    public final String h(SpeakerVoice r100) {
        return this.f379668a.h(r100);
    }

    @Override // com.larus.voicecall.obric.IObricRealtimeCallService
    public final boolean i(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        return this.f379668a.i(r100);
    }

    @Override // com.larus.voicecall.obric.IObricRealtimeCallService
    public final Pair<String, String> j(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        return this.f379668a.j(r100);
    }

    @Override // com.larus.voicecall.obric.IObricRealtimeCallService
    public final void k(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f379668a.k(r100);
    }

    @Override // com.larus.voicecall.obric.IObricRealtimeCallService
    public final void l(IObricRealtimeCallService.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f379668a.l(r100);
    }

    @Override // com.larus.voicecall.obric.IObricRealtimeCallService
    public final void m() {
        this.f379668a.m();
    }

    @Override // com.larus.voicecall.obric.IObricRealtimeCallService
    public final boolean n() {
        return this.f379668a.n();
    }

    @Override // com.larus.voicecall.obric.IObricRealtimeCallService
    public final c1 o(c r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f379668a.o(r100);
    }

    @Override // com.larus.voicecall.obric.IObricRealtimeCallService
    public final Fragment p(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return this.f379668a.p(r100);
    }

    @Override // com.larus.voicecall.obric.IObricRealtimeCallService
    public final String q() {
        return this.f379668a.q();
    }

    @Override // com.larus.voicecall.obric.IObricRealtimeCallService
    public final Object r(Context r100, Continuation<? super Unit> r101) {
        return this.f379668a.r(r100, r101);
    }

    @Override // com.larus.voicecall.obric.IObricRealtimeCallService
    public final boolean s(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, TTVideoEngineInterface.PLAY_API_KEY_AC);
        return this.f379668a.s(r100);
    }

    @Override // com.larus.voicecall.obric.IObricRealtimeCallService
    public final void t(String r110, String r111, String r112, String r113, CopyOnWriteArraySet r114, CopyOnWriteArraySet r115, ConcurrentHashMap r116, CopyOnWriteArraySet r117, CopyOnWriteArraySet r210) {
        Intrinsics.checkNotNullParameter(r110, "botId");
        Intrinsics.checkNotNullParameter(r111, "localConversationId");
        Intrinsics.checkNotNullParameter(r112, "conversationId");
        Intrinsics.checkNotNullParameter(r113, "localCallId");
        Intrinsics.checkNotNullParameter(r114, "imAsrMsgNum");
        Intrinsics.checkNotNullParameter(r115, "imTtsMsgNum");
        Intrinsics.checkNotNullParameter(r116, "imTtsPreQueryMsgMap");
        Intrinsics.checkNotNullParameter(r117, "vuiAsrMsgIdSet");
        Intrinsics.checkNotNullParameter(r210, "vuiChatRespMsgIdSet");
        this.f379668a.t(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    @Override // com.larus.voicecall.obric.IObricRealtimeCallService
    public final String u() {
        return this.f379668a.u();
    }

    private ObricRealtimeCallServiceDelegate() {
        IObricRealtimeCallService r100 = (IObricRealtimeCallService) ServiceManager.get().getService(IObricRealtimeCallService.class);
        if (r100 != null) goto L5;
        r100 = new ObricRealtimeCallServiceNoop();
    L5:
        this.f379668a = r100;
    }
}
