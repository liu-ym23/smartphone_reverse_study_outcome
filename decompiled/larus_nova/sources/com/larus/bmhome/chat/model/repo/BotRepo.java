package com.larus.bmhome.chat.model.repo;

import androidx.lifecycle.LiveData;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.BotApi;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.core.conversation.bot.BotServiceImpl;
import com.larus.platform.service.z2;
import com.larus.utils.livedata.NonStickyLiveData;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 z2\u00020\u0001:\u0002z{B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u000eH\u0016J8\u0010(\u001a\u0004\u0018\u00010\u00142\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*H\u0096@¢\u0006\u0002\u0010.JB\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0014\u0018\u0001002\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000e022\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020*H\u0096@¢\u0006\u0002\u00103J \u00104\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*H\u0096@¢\u0006\u0002\u00105J\u001c\u00106\u001a\b\u0012\u0004\u0012\u0002070\n2\u0006\u0010 \u001a\u00020\u000eH\u0086@¢\u0006\u0002\u00108J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u0014H\u0016J\u0016\u0010;\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000eJl\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020@2\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020*2\b\u0010F\u001a\u0004\u0018\u00010\u000e2\b\u0010G\u001a\u0004\u0018\u00010\u000e2\b\u0010H\u001a\u0004\u0018\u00010\u000e2\b\u0010I\u001a\u0004\u0018\u00010\u000e2\b\u0010J\u001a\u0004\u0018\u00010KH\u0096@¢\u0006\u0002\u0010LJ\u000e\u0010M\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u0014J\u0016\u0010N\u001a\u00020*2\u0006\u0010:\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010OJ\u001e\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u00142\u0006\u0010S\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010TJ \u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010W\u001a\u00020@H\u0096@¢\u0006\u0002\u0010XJ \u0010Y\u001a\u0004\u0018\u00010V2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010Z\u001a\u00020*H\u0096@¢\u0006\u0002\u00105J\u001e\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0\n2\b\u0010 \u001a\u0004\u0018\u00010\u000eH\u0096@¢\u0006\u0002\u00108J\u001e\u0010]\u001a\b\u0012\u0004\u0012\u00020\\0\n2\b\u0010 \u001a\u0004\u0018\u00010\u000eH\u0096@¢\u0006\u0002\u00108J(\u0010^\u001a\u00020\u001e2\u0006\u0010_\u001a\u00020`2\u0018\u0010a\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u001e0bJ\u001c\u0010c\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010_\u001a\u00020`H\u0086@¢\u0006\u0002\u0010dJ$\u0010e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010_\u001a\u00020`2\u0006\u0010f\u001a\u00020*H\u0082@¢\u0006\u0002\u0010gJ\u0014\u0010h\u001a\u00020\b*\u00020`2\u0006\u0010f\u001a\u00020*H\u0002J\u001c\u0010i\u001a\b\u0012\u0004\u0012\u00020j0\n2\u0006\u0010_\u001a\u00020kH\u0086@¢\u0006\u0002\u0010lJ\u001c\u0010m\u001a\b\u0012\u0004\u0012\u00020\u000e0\n2\u0006\u0010_\u001a\u00020nH\u0086@¢\u0006\u0002\u0010oJ$\u0010p\u001a\b\u0012\u0004\u0012\u00020q0\n2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010+\u001a\u00020rH\u0086@¢\u0006\u0002\u0010sJ\b\u0010t\u001a\u00020uH\u0002J/\u0010v\u001a\u00020*2\u0006\u0010 \u001a\u00020\u000e2\u0017\u0010w\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140b¢\u0006\u0002\bxH\u0096@¢\u0006\u0002\u0010yR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR(\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010!\u001a\u0004\u0018\u00010\"8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006|"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/BotRepo;", "Lcom/larus/bmhome/chat/model/repo/IBotRepoService;", "<init>", "()V", "actionBarConfRequestScope", "Lkotlinx/coroutines/CoroutineScope;", "pendingActionBarConfRequests", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/larus/bmhome/chat/model/repo/BotRepo$ActionBarConfRequestKey;", "Lkotlinx/coroutines/Deferred;", "Lcom/larus/network/http/Async;", "Lcom/larus/bmhome/actionbar/model/CustomActionBarConfResult;", "_botDeletedEventLive", "Lcom/larus/utils/livedata/NonStickyLiveData;", "", "botDeleteEventLive", "Landroidx/lifecycle/LiveData;", "getBotDeleteEventLive", "()Landroidx/lifecycle/LiveData;", "_botUpdateEventLive", "Lcom/larus/im/bean/bot/BotModel;", "botUpdateEventLive", "getBotUpdateEventLive", "mainBotModelStore", "Lcom/larus/bmhome/chat/model/repo/MainBotModelStore;", "getMainBotModelStore", "()Lcom/larus/bmhome/chat/model/repo/MainBotModelStore;", "mainBotModelStore$delegate", "Lkotlin/Lazy;", "preloadMainBot", "", "conversationId", "botId", "value", "Lcom/larus/im/bean/bot/SpeakerVoice;", "globalSpeakerVoice", "getGlobalSpeakerVoice", "()Lcom/larus/im/bean/bot/SpeakerVoice;", "setGlobalSpeakerVoice", "(Lcom/larus/im/bean/bot/SpeakerVoice;)V", "findBot", "forceNew", "", "scene", "syncLocal", "useMainBotCache", "(Ljava/lang/String;ZLjava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findBots", "", "botIds", "", "(Ljava/util/List;ZLjava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findBotByConversationId", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireBotFirstMet", "Lcom/larus/bmhome/chat/bean/BotOnBoarding;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveBot", "bot", "updateBotCallerName", "callerName", "requireRecommendBotData", "Lcom/larus/bmhome/chat/bean/RecommendBotData;", "recommendType", "", "pageIndex", "pageSize", "tagId", "", "withOnBoarding", "oldBotId", "triggerType", "tab", "firstBotId", "source", "Lcom/larus/basic/experience/downgrade/api/DowngradeSource;", "(IIILjava/lang/Long;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/basic/experience/downgrade/api/DowngradeSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSettings", "deleteBot", "(Lcom/larus/im/bean/bot/BotModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBotVoice", "Lcom/larus/bmhome/bot/bean/VoiceUpdateResult;", "oldBotInfo", "newVoice", "(Lcom/larus/im/bean/bot/BotModel;Lcom/larus/im/bean/bot/SpeakerVoice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireUpdateBotAccessPermission", "Lcom/larus/im/bean/bot/BotUpdateResult;", "privateStatus", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireUpdateBotMessagePush", "messagePush", "requireSubjectBotInfo", "Lcom/larus/bmhome/bot/bean/BotSubjectResult;", "resetBotSubject", "awaitCustomActionBarConf", "param", "Lcom/larus/bmhome/chat/model/repo/IBotRepoService$ActionBarConfParam;", "callback", "Lkotlin/Function1;", "requireCustomActionBarConf", "(Lcom/larus/bmhome/chat/model/repo/IBotRepoService$ActionBarConfParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestCustomActionBarConf", "useActionBarV2", "(Lcom/larus/bmhome/chat/model/repo/IBotRepoService$ActionBarConfParam;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toActionBarConfRequestKey", "reportCustomActionBarOperation", "Lcom/larus/bmhome/actionbar/model/CustomActionBarOpResult;", "Lcom/larus/bmhome/chat/model/repo/IBotRepoService$ReportActionBarOpParam;", "(Lcom/larus/bmhome/chat/model/repo/IBotRepoService$ReportActionBarOpParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportActionBarModeSwitch", "Lcom/larus/bmhome/chat/model/repo/IBotRepoService$ReportActionBarModeSwitchParam;", "(Lcom/larus/bmhome/chat/model/repo/IBotRepoService$ReportActionBarModeSwitchParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireBotActionCard", "Lcom/larus/bmhome/auth/OnboardingActionCardData;", "Lcom/larus/bmhome/auth/OnboardingActionCardData$CardScene;", "(Ljava/lang/String;Lcom/larus/bmhome/auth/OnboardingActionCardData$CardScene;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "botApi", "Lcom/larus/bmhome/chat/api/BotApi;", "updateLocalBot", "update", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ActionBarConfRequestKey", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotRepo implements IBotRepoService {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f307569g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f307570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<a, Deferred<com.larus.network.http.a<com.larus.bmhome.actionbar.model.x0>>> f307571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NonStickyLiveData<String> f307572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NonStickyLiveData f307573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final NonStickyLiveData f307574e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f307575f;

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f307576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f307577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f307578c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f307579d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f307580e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f307581f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f307576a == r101.f307576a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f307577b, r101.f307577b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f307578c, r101.f307578c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f307579d, r101.f307579d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f307580e, r101.f307580e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f307581f, r101.f307581f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            if (this.f307576a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = ((((((((r100 * 31) + this.f307577b.hashCode()) * 31) + this.f307578c.hashCode()) * 31) + this.f307579d.hashCode()) * 31) + this.f307580e.hashCode()) * 31;
            String r102 = this.f307581f;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "ActionBarConfRequestKey(useActionBarV2=" + this.f307576a + ", languageCode=" + this.f307577b + ", botId=" + this.f307578c + ", cvsId=" + this.f307579d + ", scene=" + this.f307580e + ", throughToken=" + this.f307581f + ')';
        }

        public a(boolean r100, String r101, String r102, String r103, String r104, String r105) {
            Intrinsics.checkNotNullParameter(r101, UserInfo.LANGUAGECODE);
            Intrinsics.checkNotNullParameter(r102, "botId");
            Intrinsics.checkNotNullParameter(r103, "cvsId");
            Intrinsics.checkNotNullParameter(r104, "scene");
            this.f307576a = r100;
            this.f307577b = r101;
            this.f307578c = r102;
            this.f307579d = r103;
            this.f307580e = r104;
            this.f307581f = r105;
        }
    }

    public static final class b {
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class c implements IIMCallback<uc9.t> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompletableDeferred<Boolean> f307582a;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return !com.larus.im.internal.delegate.y0.a();
        }

        public c(CompletableDeferred<Boolean> r100) {
            this.f307582a = r100;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f307582a.complete(Boolean.FALSE);
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(uc9.t r100) {
            uc9.t r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            if (r101.f549696a == false) goto L5;
            this.f307582a.complete(Boolean.TRUE);
            return;
        L5:
            this.f307582a.complete(Boolean.FALSE);
        }
    }

    public static final class d implements IIMCallback<BotModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<BotModel> f307583a;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return !com.larus.im.internal.delegate.y0.a();
        }

        public d(kotlinx.coroutines.j r100) {
            this.f307583a = r100;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f307583a.resumeWith(Result.m9449constructorimpl(null));
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(BotModel r100) {
            BotModel r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            this.f307583a.resumeWith(Result.m9449constructorimpl(r101));
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class e implements IIMCallback<Map<String, ? extends BotModel>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<Map<String, BotModel>> f307584a;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return !com.larus.im.internal.delegate.y0.a();
        }

        public e(kotlinx.coroutines.j r100) {
            this.f307584a = r100;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f307584a.resumeWith(Result.m9449constructorimpl(null));
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(Map<String, ? extends BotModel> r100) {
            Map<String, ? extends BotModel> r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            this.f307584a.resumeWith(Result.m9449constructorimpl(r101));
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class f implements IIMCallback<uc9.t> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompletableDeferred<uc9.t> f307585a;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return !com.larus.im.internal.delegate.y0.a();
        }

        public f(CompletableDeferred<uc9.t> r100) {
            this.f307585a = r100;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f307585a.complete(null);
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(uc9.t r100) {
            uc9.t r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            this.f307585a.complete(r101);
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class g implements IIMCallback<uc9.t> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompletableDeferred<uc9.t> f307586a;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return !com.larus.im.internal.delegate.y0.a();
        }

        public g(CompletableDeferred<uc9.t> r100) {
            this.f307586a = r100;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f307586a.complete(null);
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(uc9.t r100) {
            uc9.t r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            this.f307586a.complete(r101);
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class h implements IIMCallback<uc9.t> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<ub8.h> f307587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SpeakerVoice f307588b;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return !com.larus.im.internal.delegate.y0.a();
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r100, "error");
            kotlinx.coroutines.i<ub8.h> r101 = this.f307587a;
            Result.Companion r102 = Result.Companion;
            r101.resumeWith(Result.m9449constructorimpl(new ub8.h(false, this.f307588b, Long.valueOf(r100.getCode()), r100.getTips())));
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(uc9.t r100) {
            uc9.t r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            kotlinx.coroutines.i<ub8.h> r102 = this.f307587a;
            Result.Companion r103 = Result.Companion;
            r102.resumeWith(Result.m9449constructorimpl(new ub8.h(r101.f549696a, this.f307588b, null, null)));
        }

        public h(kotlinx.coroutines.j r100, SpeakerVoice r101) {
            this.f307587a = r100;
            this.f307588b = r101;
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class i implements IIMCallback<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompletableDeferred<Boolean> f307589a;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return !com.larus.im.internal.delegate.y0.a();
        }

        public i(CompletableDeferred<Boolean> r100) {
            this.f307589a = r100;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f307589a.complete(Boolean.FALSE);
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(Boolean r100) {
            boolean r101 = r100.booleanValue();
            this.f307589a.complete(Boolean.valueOf(r101));
        }
    }

    static {
    }

    public static BotApi a() {
        return BotApi.f297150a.getValue();
    }

    public BotRepo() {
        this.f307570a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f307571b = new ConcurrentHashMap();
        NonStickyLiveData<String> r100 = new NonStickyLiveData();
        this.f307572c = r100;
        this.f307573d = r100;
        this.f307574e = new NonStickyLiveData();
        this.f307575f = LazyKt.lazy(new h0());
    }

    @Override // com.larus.bmhome.chat.model.repo.IBotRepoService
    public final void h1() {
        int r100 = com.larus.bmhome.bot.a.f296498a;
    }

    @Override // com.larus.bmhome.chat.model.repo.IBotRepoService
    public final LiveData<BotModel> n1() {
        return this.f307574e;
    }

    @Override // com.larus.bmhome.chat.model.repo.IBotRepoService
    public final LiveData<String> r1() {
        return this.f307573d;
    }

    @Override // com.larus.bmhome.chat.model.repo.IBotRepoService
    public final void e1(final BotModel r100) {
        Intrinsics.checkNotNullParameter(r100, "bot");
        BotServiceImpl r101 = com.larus.im.d.a();
        String r102 = r100.getBotId();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.updateLocalBot(r102, new i0(r100), null);
    }

    public final Object b(IBotRepoService.a r110, Continuation<? super com.larus.network.http.a<com.larus.bmhome.actionbar.model.x0>> r210) {
        boolean r100 = z2.f365865a.A1();
        final a r111 = new a(r100, r110.f307692a, r110.f307693b, r110.f307694c, r110.f307695d, r110.f307696e);
        final Deferred<com.larus.network.http.a<com.larus.bmhome.actionbar.model.x0>> r101 = BuildersKt.async$default(this.f307570a, null, CoroutineStart.LAZY, new BotRepo$requireCustomActionBarConf$newRequest$1(this, r110, r100, null), 1, null);
        Deferred<com.larus.network.http.a<com.larus.bmhome.actionbar.model.x0>> r102 = this.f307571b.putIfAbsent(r111, r101);
        if (r102 == null) goto L6;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
        FLogger.f375446a.i("BotRepo", "reuse pending actionbar config request, botId=" + r110.f307693b + ", scene=" + r110.f307695d + ", useActionBarV2=" + r100);
        return r102.await(r210);
    L6:
        r101.invokeOnCompletion(new g0(this, r111, r101));
        r101.start();
        return r101.await(r210);
    }

    @Override // com.larus.bmhome.chat.model.repo.IBotRepoService
    public final Object f1(String r100, Continuation<? super com.larus.network.http.a<ub8.c>> r101) {
        a().getClass();
        return BotApi.i(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.IBotRepoService
    public final void g1(String r100, String r110) {
        if (com.larus.platform.exp.c.f365374d == false) goto L50;
        MainBotModelStore r101 = (MainBotModelStore) this.f307575f.getValue();
        Object r102 = r101.f307713a;
        monitor-enter(r102);
        boolean r103 = true;
        if (r101.f307718f == null) goto L9;
    L36:
        FLogger r104 = FLogger.f375446a;     // Catch: Throwable -> L47
        StringBuilder r105 = new StringBuilder("preload reused, cached=");     // Catch: Throwable -> L47
        if (r101.f307718f == null) goto L39;
        boolean r106 = true;
    L40:
        r105.append(r106);     // Catch: Throwable -> L47
        r105.append(", pending=");     // Catch: Throwable -> L47
        if (r101.f307719g != null) goto L44;
        r103 = false;
    L44:
        r105.append(r103);     // Catch: Throwable -> L47
        r104.d("MainBotModelStore", r105.toString());     // Catch: Throwable -> L47
        monitor-exit(r102);
        return;
    L39:
        r106 = false;
        goto L40
    L9:
        if (r101.f307719g != null) goto L36;
        wc9.e r107 = AuthModelDelegate.f297134b.y().getValue();     // Catch: Throwable -> L47
        if (r107 == null) goto L14;
        String r108 = r107.f559198a;     // Catch: Throwable -> L47
    L15:
        if (r100 != null) goto L17;
    L20:
        boolean r109 = true;
    L21:
        if (r109 == false) goto L23;
    L24:
        if (r110 != null) goto L26;
    L29:
        if (r103 == false) goto L31;
    L33:
        FLogger.f375446a.d("MainBotModelStore", "preload skipped: not main bot");     // Catch: Throwable -> L47
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L47
    L34:
        monitor-exit(r102);
        return;
    L31:
        if (Intrinsics.areEqual(r110, MainBotModelStore.f307712i.getValue()) == false) goto L33;
    L32:
        FLogger r112 = FLogger.f375446a;     // Catch: Throwable -> L47
        StringBuilder r113 = new StringBuilder("preload start, botId=");     // Catch: Throwable -> L47
        Lazy<String> r114 = MainBotModelStore.f307712i;     // Catch: Throwable -> L47
        r113.append(r114.getValue());     // Catch: Throwable -> L47
        r112.i("MainBotModelStore", r113.toString());     // Catch: Throwable -> L47
        r101.d(r114.getValue(), false, "default", true, true);     // Catch: Throwable -> L47
        goto L34
    L26:
        if (StringsKt.isBlank(r110) == true) goto L29;
        r103 = false;
        goto L29
    L23:
        if (Intrinsics.areEqual(r100, r108) == true) goto L32;
    L17:
        if (StringsKt.isBlank(r100) == true) goto L20;
        r109 = false;
        goto L21
    L14:
        r108 = null;
    L47:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.bmhome.chat.model.repo.IBotRepoService
    public final Object p1(String r100, Continuation<? super com.larus.network.http.a<ub8.c>> r101) {
        a().getClass();
        return BotApi.j(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.IBotRepoService
    public final Object s1(BotModel r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof BotRepo$deleteBot$1) == false) goto L7;
        BotRepo$deleteBot$1 r102 = (BotRepo$deleteBot$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (BotModel) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L21:
        boolean r107 = ((Boolean) r104).booleanValue();
        if (r107 == false) goto L28;
        NonStickyLiveData<String> r108 = this.f307572c;
        String r109 = r100.getBotId();
        if (r109 != null) goto L26;
        r109 = "";
    L26:
        r108.postValue(r109);
    L28:
        return Boxing.boxBoolean(r107);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        FLogger r110 = FLogger.f375446a;
        StringBuilder r111 = new StringBuilder("deleteBot: &");
        r111.append(r100.getBotId());
        r111.append('-');
        BotCreatorInfo r112 = r100.getBotCreatorInfo();
        if (r112 == null) goto L17;
        String r113 = r112.getId();
    L18:
        r111.append(r113);
        r110.i("BotRepo", r111.toString());
        CompletableDeferred r114 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        com.larus.im.d.a().deleteBot(r100, new c(r114));
        r102.L$0 = r100;
        r102.label = 1;
        r104 = r114.await(r102);
        if (r104 != r105) goto L21;
        return r105;
    L17:
        r113 = null;
    L7:
        r102 = new BotRepo$deleteBot$1(this, r101);
        goto L8
    }

    @Override // com.larus.bmhome.chat.model.repo.IBotRepoService
    public final Object j1(String r100, boolean r110, Continuation<? super BotModel> r111) {
        if ((r111 instanceof BotRepo$findBotByConversationId$1) == false) goto L7;
        BotRepo$findBotByConversationId$1 r101 = (BotRepo$findBotByConversationId$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        BotRepo$findBotByConversationId$1 r103 = r101;
        Object r112 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        boolean r106 = true;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        r100 = (String) r103.L$0;
        ResultKt.throwOnFailure(r112);
    L37:
        BotInfoCache r107 = BotInfoCache.INSTANCE;
        r107.put(r100, (BotModel) r112);
        return r112;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r110 = r103.Z$0;
        r100 = (String) r103.L$0;
        ResultKt.throwOnFailure(r112);
    L25:
        String r113 = (String) CollectionsKt.firstOrNull((List) r112);
        if (r113 != null) goto L28;
    L31:
        if (r106 == false) goto L34;
        return null;
    L34:
        r103.L$0 = r100;
        r103.label = 2;
        r112 = IBotRepoService.b.a(this, r113, r110, null, false, r103, 28);
        if (r112 != r104) goto L37;
        return r104;
    L28:
        if (StringsKt.isBlank(r113) == true) goto L31;
        r106 = false;
        goto L31
    L16:
        ResultKt.throwOnFailure(r112);
        if (r110 == true) goto L22;
        BotInfoCache r114 = BotInfoCache.INSTANCE;
        if (r114.get(r100) == null) goto L22;
        return r114.get(r100);
    L22:
        r103.L$0 = r100;
        r103.Z$0 = r110;
        r103.label = 1;
        r112 = ic8.n.b(r100, r103);
        if (r112 != r104) goto L25;
        return r104;
    L7:
        r101 = new BotRepo$findBotByConversationId$1(this, r111);
        goto L8
    }

    @Override // com.larus.bmhome.chat.model.repo.IBotRepoService
    public final Object l1(String r100, Function1<? super BotModel, BotModel> r101, Continuation<? super Boolean> r102) {
        CompletableDeferred r103 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        com.larus.im.d.a().updateLocalBot(r100, r101, new i(r103));
        return r103.await(r102);
    }

    @Override // com.larus.bmhome.chat.model.repo.IBotRepoService
    public final Object m1(String r100, boolean r101, Continuation<? super uc9.t> r102) {
        CompletableDeferred r103 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        com.larus.im.d.a().modifyMessagePush(r100, r101, new g(r103));
        return r103.await(r102);
    }

    @Override // com.larus.bmhome.chat.model.repo.IBotRepoService
    public final Object o1(String r100, int r101, Continuation<? super uc9.t> r102) {
        CompletableDeferred r103 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        com.larus.im.d.a().requireUpdateBotAccessPermission(r100, r101, new f(r103));
        return r103.await(r102);
    }

    @Override // com.larus.bmhome.chat.model.repo.IBotRepoService
    public final Object t1(BotModel r100, SpeakerVoice r101, Continuation<? super ub8.h> r102) {
        kotlinx.coroutines.j r103 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
        r103.C();
        h r104 = new h(r103, r101);
        String r105 = "";
        if (Intrinsics.areEqual(r101.getId(), "none") == false) goto L9;
        BotServiceImpl r106 = com.larus.im.d.a();
        String r107 = r100.getBotId();
        if (r107 == null) goto L8;
        r105 = r107;
    L8:
        r106.muteBot(r105, r104);
    L17:
        Object r108 = r103.B();
        if (r108 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L21:
        if (r108 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        return r108;
    L24:
        return (ub8.h) r108;
    L9:
        BotServiceImpl r109 = com.larus.im.d.a();
        String r110 = r100.getBotId();
        if (r110 != null) goto L12;
        r110 = "";
    L12:
        String r111 = r101.getId();
        if (r111 == null) goto L16;
        r105 = r111;
    L16:
        r109.modifyBotVoice(r110, r105, r101.isUgcVoice(), r104);
        goto L17
    }

    @Override // com.larus.bmhome.chat.model.repo.IBotRepoService
    public final Object i1(List<String> r110, boolean r111, String r112, boolean r113, Continuation<? super Map<String, BotModel>> r114) {
        kotlinx.coroutines.j r100 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r114), 1);
        r100.C();
        if (AppHost.f326268a.isTestChannel() == false) goto L11;
        StackTraceElement[] r101 = ThreadMethodProxy.currentThread().getStackTrace();
        if (r101.length <= 5) goto L11;
        String r102 = r101[4].getClassName() + '_' + r101[4].getLineNumber();
        by7.a r103 = new by7.a("get_bot_list_v2_call_scene");
        r103.d("scene", r102);
        if (r111 == false) goto L9;
        String r104 = "1";
    L10:
        r103.d("force_new", r104);
        r103.b();
        goto L11
    L9:
        r104 = "0";
    L11:
        com.larus.im.d.a().getBots(r110, r111, r112, r113, new e(r100));
        Object r115 = r100.B();
        if (r115 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(r114);
    L14:
        return r115;
    }

    @Override // com.larus.bmhome.chat.model.repo.IBotRepoService
    public final Object q1(String r100, boolean r110, String r111, boolean r112, boolean r113, Continuation<? super BotModel> r114) {
        if (AppHost.f326268a.isTestChannel() == false) goto L11;
        StackTraceElement[] r101 = ThreadMethodProxy.currentThread().getStackTrace();
        if (r101.length <= 5) goto L11;
        String r102 = r101[4].getClassName() + '_' + r101[4].getLineNumber();
        by7.a r103 = new by7.a("get_bot_list_v2_call_scene");
        r103.d("scene", r102);
        if (r110 == false) goto L9;
        String r104 = "1";
    L10:
        r103.d("force_new", r104);
        r103.b();
        FLogger.f375446a.d("BotRepo", "findBot caller=" + r102 + " force_new=" + r110);
        goto L11
    L9:
        r104 = "0";
    L11:
        if (r113 == true) goto L13;
    L20:
        kotlinx.coroutines.j r115 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r114), 1);
        r115.C();
        com.larus.im.d.a().getBot(r100, r110, r111, r112, new d(r115));
        Object r105 = r115.B();
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        DebugProbesKt.probeCoroutineSuspended(r114);
    L24:
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        return r105;
    L27:
        return (BotModel) r105;
    L13:
        if (com.larus.platform.exp.c.f365374d == false) goto L20;
        if (Intrinsics.areEqual(r100, MainBotModelStore.f307712i.getValue()) == false) goto L20;
        Object r106 = ((MainBotModelStore) this.f307575f.getValue()).c(r100, r110, r111, r112, r114);
        if (r106 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L28;
        return r106;
    L28:
        return (BotModel) r106;
    }

    @Override // com.larus.bmhome.chat.model.repo.IBotRepoService
    public final Object k1(int r110, int r111, int r112, Long r113, boolean r114, String r115, String r116, String r210, String r211, DowngradeSource r212, Continuation<? super ic8.o0> r213) {
        return a().h(r110, r111, RangesKt.coerceAtMost(r112, 40), r113, r114, r115, r116, r210, r211, r212, r213);
    }
}
