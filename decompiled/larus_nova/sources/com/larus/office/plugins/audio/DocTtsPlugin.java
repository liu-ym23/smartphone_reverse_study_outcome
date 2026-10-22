package com.larus.office.plugins.audio;

import android.app.Application;
import android.os.SystemClock;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowTtsClientService;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.larus.bmhome.chat.model.repo.x1;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.office.OfficeInputParam;
import com.larus.office.w;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import t19.s;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 12\u00020\u0001:\u000212B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001c\u0010\u001e\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J \u0010\"\u001a\u00020\u00162\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030%0$H\u0016J\u0006\u0010&\u001a\u00020\u0016J\u0006\u0010'\u001a\u00020\u0016J\u0006\u0010(\u001a\u00020\u0016J\u0006\u0010)\u001a\u00020\u0016J\u0006\u0010*\u001a\u00020\u0011J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u0011H\u0002J\u0010\u0010,\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u0011H\u0002J\u0006\u0010-\u001a\u00020\u0011J\b\u0010.\u001a\u00020\u0016H\u0002J\u0010\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u00063"}, d2 = {"Lcom/larus/office/plugins/audio/DocTtsPlugin;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "docId", "", "getDocId", "()Ljava/lang/String;", "setDocId", "(Ljava/lang/String;)V", "ttsReader", "Lcom/larus/bmhome/chat/model/repo/ITtsReader;", "getTtsReader", "()Lcom/larus/bmhome/chat/model/repo/ITtsReader;", "ttsReader$delegate", "Lkotlin/Lazy;", "startedTts", "", "startTtsTime", "", "onTtsStateChanged", "Lkotlin/Function1;", "", "getOnTtsStateChanged", "()Lkotlin/jvm/functions/Function1;", "setOnTtsStateChanged", "(Lkotlin/jvm/functions/Function1;)V", "onAttachToHost", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromHost", "getBridgeHandlers", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "startTts", "startTtsFromMorePanel", "tryStopTts", "stopTtsFromMorePanel", "isPlaying", "dispatchTtsStateChanged", "notifyTtsPlayStateChange", "isEditing", "mobStartTts", "mobTtsEnd", "endMethod", "Companion", "TryStopTtsPlayHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocTtsPlugin extends OfficeDocumentPlugin {
    private static final String BIZ_TRY_STOP_TTS_PLAY = "biz.util.tryStopTtsPlay";
    public static final a Companion = null;
    private static final String JS_TTS_PLAY_STATE_CHANGE = "javascript:window.flow.biz.util.ttsPlayStateChange";
    private static final String TAG = "DocTtsPlugin";
    private String docId;
    private Function1<? super Boolean, Unit> onTtsStateChanged;
    private long startTtsTime;
    private boolean startedTts;
    private final Lazy ttsReader$delegate;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocTtsPlugin f362356a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(DocTtsPlugin r100) {
            this.f362356a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            Void r102 = (Void) r100;
            this.f362356a.tryStopTts();
            if (r101 == null) goto L6;
            r101.b(new JSONObject());
            return;
        }
    }

    /* JADX INFO: renamed from: com.larus.office.plugins.audio.DocTtsPlugin$mobStartTts$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.office.plugins.audio.DocTtsPlugin$mobStartTts$1", f = "DocTtsPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DocTtsPlugin this$0;

        public AnonymousClass1(DocTtsPlugin r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            o r101 = o.f365780a;
            org.json.JSONObject r102 = new org.json.JSONObject();
            r102.put("page_token", this.this$0.getDocId());
            r102.put(AiProactiveTaskViewModel.PARAM_START_METHOD, "click_doc_play");
            Unit r103 = Unit.INSTANCE;
            r101.reportEvent("start_tts", r102);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.office.plugins.audio.DocTtsPlugin$mobTtsEnd$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.office.plugins.audio.DocTtsPlugin$mobTtsEnd$1", f = "DocTtsPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C114811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $endMethod;
        int label;
        final /* synthetic */ DocTtsPlugin this$0;

        public C114811(DocTtsPlugin r100, String r101, Continuation<? super C114811> r102) {
            this.this$0 = r100;
            this.$endMethod = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C114811(this.this$0, this.$endMethod, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C114811) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            long r101 = SystemClock.elapsedRealtime() - DocTtsPlugin.access$getStartTtsTime$p(this.this$0);
            o r102 = o.f365780a;
            org.json.JSONObject r103 = new org.json.JSONObject();
            DocTtsPlugin r104 = this.this$0;
            String r105 = this.$endMethod;
            r103.put("page_token", r104.getDocId());
            r103.put(AiProactiveTaskViewModel.PARAM_START_METHOD, "click_doc_play");
            r103.put("end_method", r105);
            r103.put("duration", r101);
            Unit r106 = Unit.INSTANCE;
            r102.reportEvent("finish_tts", r103);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ x1 a() {
        return ttsReader_delegate$lambda$0();
    }

    public static /* synthetic */ Unit c(DocTtsPlugin r100, String r101) {
        return startTts$lambda$2(r100, r101);
    }

    public static /* synthetic */ Unit d(DocTtsPlugin r100) {
        return startTts$lambda$1(r100);
    }

    public final boolean isEditing() {
        return false;
    }

    @Override // com.bytedance.ee.bear.document.OfficeDocumentPlugin, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private final x1 getTtsReader() {
        return (x1) this.ttsReader$delegate.getValue();
    }

    private static final x1 ttsReader_delegate$lambda$0() {
        x1.f307866a.getClass();
        return x1.a.a();
    }

    public final void startTts() {
        if (AudioServiceDelegate.f288288a.P().isRecording() == false) goto L6;
        FLogger.f375446a.i(TAG, "[TTS][AI_NOTE_RECORDING] can not start tts when ai note is recording.");
        s r100 = s.f544207a;
        AppHost.Companion r101 = AppHost.f326268a;
        Application r102 = r101.getApplication();
        String r103 = r101.getApplication().getString(R.string.larus_memo_recording_deny_actions_error_toast);
        r100.getClass();
        s.t(r102, r103);
        return;
    L6:
        IFlowSdkDepend r104 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r104 == null) goto L13;
        com.larus.home.impl.sdk.s r105 = r104.s0();
        if (r105 == null) goto L13;
        if (r105.c() != true) goto L13;
        boolean r106 = true;
    L14:
        if (r106 == false) goto L17;
        FLogger.f375446a.i(TAG, "[TTS][DORA_WAKE_UP] can not start tts when dora is wake up.");
        s r107 = s.f544207a;
        AppHost.Companion r108 = AppHost.f326268a;
        Application r109 = r108.getApplication();
        String r110 = r108.getApplication().getString(R.string.larus_disable_voice_limit);
        r107.getClass();
        s.t(r109, r110);
        return;
    L17:
        dispatchTtsStateChanged(true);
        mobStartTts();
        this.startTtsTime = SystemClock.elapsedRealtime();
        x1 r111 = getTtsReader();
        String r112 = this.docId;
        r111.k6(r112, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("doc_page_token", r112), TuplesKt.to("tts_scene", "doc")}), new com.larus.office.plugins.audio.b(this), new c(this));
        this.startedTts = true;
        return;
    L13:
        r106 = false;
        goto L14
    }

    public final void tryStopTts() {
        if (this.startedTts == false) goto L6;
        this.startedTts = false;
        getTtsReader().i6("enter_doc_edit_mode", false);
        dispatchTtsStateChanged(false);
        return;
    }

    public DocTtsPlugin() {
        this.docId = "";
        this.ttsReader$delegate = LazyKt.lazy(new com.larus.office.plugins.audio.a());
    }

    private final void mobStartTts() {
        ChameleonPluginHost r100 = getHost();
        if (r100 == null) goto L10;
        Fragment r101 = r100.getFragment();
        if (r101 == null) goto L11;
        LifecycleCoroutineScope r102 = LifecycleOwnerKt.getLifecycleScope(r101);
        if (r102 == null) goto L12;
        BuildersKt.launch$default(r102, Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final String getDocId() {
        return this.docId;
    }

    public final Function1<Boolean, Unit> getOnTtsStateChanged() {
        return this.onTtsStateChanged;
    }

    public final boolean isPlaying() {
        return this.startedTts;
    }

    public final void startTtsFromMorePanel() {
        startTts();
    }

    public final void stopTtsFromMorePanel() {
        tryStopTts();
    }

    public static final /* synthetic */ long access$getStartTtsTime$p(DocTtsPlugin r100) {
        return r100.startTtsTime;
    }

    private final void dispatchTtsStateChanged(boolean r100) {
        Function1<? super Boolean, Unit> r101 = this.onTtsStateChanged;
        if (r101 == null) goto L5;
        r101.invoke(Boolean.valueOf(r100));
    L5:
        notifyTtsPlayStateChange(r100);
    }

    private final void mobTtsEnd(String r100) {
        ChameleonPluginHost r101 = getHost();
        if (r101 == null) goto L10;
        Fragment r102 = r101.getFragment();
        if (r102 == null) goto L11;
        LifecycleCoroutineScope r103 = LifecycleOwnerKt.getLifecycleScope(r102);
        if (r103 == null) goto L12;
        BuildersKt.launch$default(r103, Dispatchers.getIO(), null, new C114811(this, r100, null), 2, null);
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void notifyTtsPlayStateChange(boolean r100) {
        ChameleonPluginHost r101 = getHost();
        if (r101 != null) goto L6;
        FLogger.f375446a.e(TAG, "notifyTtsPlayStateChange: host is null");
        return;
    L6:
        WebView r102 = r101.getWeb().getWebView();
        JSONObject r103 = new JSONObject();
        r103.put2("isPlaying", Boolean.valueOf(r100));
        Unit r104 = Unit.INSTANCE;
        ap5.a.a(r102, JS_TTS_PLAY_STATE_CHANGE, r103, null);
    }

    private static final Unit startTts$lambda$1(DocTtsPlugin r100) {
        ChameleonPluginHost r101 = r100.getHost();
        if (r101 == null) goto L9;
        Fragment r102 = r101.getFragment();
        if (r102 == null) goto L9;
        LifecycleCoroutineScope r103 = LifecycleOwnerKt.getLifecycleScope(r102);
        if (r103 == null) goto L9;
        BuildersKt.launch$default(r103, Dispatchers.getMain(), null, new DocTtsPlugin$startTts$1$1(r100, null), 2, null);
    L9:
        r100.mobTtsEnd("auto_end");
        r100.startedTts = false;
        return Unit.INSTANCE;
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        super.getBridgeHandlers(r100);
        r100.put(BIZ_TRY_STOP_TTS_PLAY, new b(this));
    }

    public void onAttachToHost(ChameleonPluginHost r100) {
        super.onAttachToHost(r100);
        if (r100 == null) goto L9;
        w r101 = (w) r100.getHostAbility(w.class);
        if (r101 == null) goto L9;
        OfficeInputParam r102 = r101.f363627a;
        if (r102 == null) goto L9;
        String r103 = r102.getResourceId();
    L10:
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        this.docId = r103;
        return;
    L9:
        r103 = null;
        goto L10
    }

    public void onDetachFromHost(ChameleonPluginHost r100) {
        super.onDetachFromHost(r100);
        IFlowTtsClientService.f288300a.getClass();
        IFlowTtsClientService.a.a().n(false);
        IFlowTtsClientService.a.a().f("DocTtsPlugin_detach");
        this.startedTts = false;
        dispatchTtsStateChanged(false);
    }

    public final void setDocId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.docId = r100;
    }

    public final void setOnTtsStateChanged(Function1<? super Boolean, Unit> r100) {
        this.onTtsStateChanged = r100;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((ChameleonPluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((ChameleonPluginHost) r100);
    }

    public static final /* synthetic */ void access$dispatchTtsStateChanged(DocTtsPlugin r100, boolean r101) {
        r100.dispatchTtsStateChanged(r101);
    }

    private static final Unit startTts$lambda$2(DocTtsPlugin r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "it");
        r100.startedTts = false;
        r100.mobTtsEnd("interrupted");
        ChameleonPluginHost r102 = r100.getHost();
        if (r102 == null) goto L10;
        Fragment r103 = r102.getFragment();
        if (r103 == null) goto L10;
        LifecycleCoroutineScope r104 = LifecycleOwnerKt.getLifecycleScope(r103);
        if (r104 == null) goto L10;
        BuildersKt.launch$default(r104, Dispatchers.getMain(), null, new DocTtsPlugin$startTts$2$1(r101, r100, null), 2, null);
    L10:
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, t r101) {
        onAttachToUIContainer((ChameleonPluginHost) r100, r101);
    }

    public void onAttachToUIContainer(ChameleonPluginHost r100, t r101) {
        super.onAttachToUIContainer(r100, r101);
    }
}
