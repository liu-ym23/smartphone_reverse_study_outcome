package com.larus.asr.direct;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.FrameLayout;
import c58.g;
import c58.h;
import c58.i;
import c58.j;
import c58.k;
import c58.l;
import c58.n;
import c58.p;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.keva.Keva;
import com.larus.audio.asr.c0;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.speaker.e;
import com.larus.bmhome.chat.component.bottom.core.speaker.f;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.common_ui.view.TouchInterceptingView;
import com.larus.im.bean.message.Message;
import com.larus.im.d;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.im.observer.MessageListState;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import va8.m;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000©\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0006*\u0001B\u0018\u0000 n2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001nB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020EH\u0016J\b\u0010G\u001a\u00020EH\u0002J\b\u0010H\u001a\u00020EH\u0002J\n\u0010I\u001a\u0004\u0018\u00010;H\u0002J\b\u0010J\u001a\u00020EH\u0002J\b\u0010K\u001a\u00020EH\u0002J\b\u0010L\u001a\u00020EH\u0002J\b\u0010M\u001a\u00020EH\u0002J\b\u0010N\u001a\u00020EH\u0002J\b\u0010O\u001a\u00020EH\u0016J\b\u0010P\u001a\u000209H\u0016J\u0010\u0010Q\u001a\u00020E2\u0006\u0010R\u001a\u000209H\u0016J\u0018\u0010S\u001a\u00020E2\u0006\u0010T\u001a\u0002092\u0006\u0010U\u001a\u00020VH\u0016J\b\u0010W\u001a\u00020EH\u0016J\b\u0010X\u001a\u00020EH\u0016J\b\u0010Y\u001a\u00020EH\u0016J\b\u0010\\\u001a\u00020EH\u0002J\u0012\u0010]\u001a\u00020E2\b\u0010^\u001a\u0004\u0018\u00010?H\u0016J\n\u0010_\u001a\u0004\u0018\u00010=H\u0016J\n\u0010`\u001a\u0004\u0018\u00010?H\u0016J\u0012\u0010a\u001a\u00020E2\b\u0010^\u001a\u0004\u0018\u00010?H\u0016J\u0012\u0010b\u001a\u00020E2\b\u0010c\u001a\u0004\u0018\u00010dH\u0002J\u0012\u0010e\u001a\u00020E2\b\u0010c\u001a\u0004\u0018\u00010dH\u0002J\b\u0010f\u001a\u00020EH\u0002J\u0012\u0010g\u001a\u00020E2\b\u0010h\u001a\u0004\u0018\u00010iH\u0002J\u0012\u0010j\u001a\u00020E2\b\u0010k\u001a\u0004\u0018\u00010=H\u0002J\u0010\u0010l\u001a\u00020E2\u0006\u0010m\u001a\u00020?H\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b'\u0010(R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b,\u0010-R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u000b\u001a\u0004\b3\u00104R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010CR\u000e\u0010Z\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006o"}, d2 = {"Lcom/larus/asr/direct/AsrDirectFillComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "Lcom/larus/asr/direct/IAsrDirectFillAbility;", "<init>", "()V", "speakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "speakerAbility$delegate", "Lkotlin/Lazy;", "chatFragmentCoreAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentCoreAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentCoreAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "asrLoadingHelper", "Lcom/larus/asr/AsrLoadingHelper;", "getAsrLoadingHelper", "()Lcom/larus/asr/AsrLoadingHelper;", "asrLoadingHelper$delegate", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "loadingRunnable", "Ljava/lang/Runnable;", "speakerPressLifecycle", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/ChatSpeakerPressLifecycle;", "getSpeakerPressLifecycle", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/ChatSpeakerPressLifecycle;", "speakerPressLifecycle$delegate", "textWatcher", "Landroid/text/TextWatcher;", "isReadyToSpeakStatusWhenStart", "", "inputInterceptorView", "Lcom/larus/common_ui/view/TouchInterceptingView;", "directFillStatus", "Lcom/larus/asr/direct/IAsrDirectFillAbility$DirectFillStatus;", "directFillAsrLogId", "", "localDirectFillEnabled", "messageListener", "com/larus/asr/direct/AsrDirectFillComponent$messageListener$1", "Lcom/larus/asr/direct/AsrDirectFillComponent$messageListener$1;", "onAttach", "", "onParentViewCreated", "observeAsrSession", "initInputInterceptorListener", "getInputInterceptorView", "clearInputInterceptorView", "initIMSDKListener", "registerKeyBoardStatus", "registerChatInputTextChangeListener", "initDirectFillStatus", LiveCommonConstants.REASON_ON_DEDTROY, "isDirectFillEnabled", "setLocalDirectFillEnabled", "enabled", "startDirectFillAsr", "fromTextArea", "traceInfo", "Lcom/larus/audio/asr/AsrTraceInfo;", "onPressEnd", "cancel", "onHandsfreeEntered", "handsfreeBackfillStatusActive", "fillBackListenersRegistered", "ensureFillBackListeners", "onHandsfreeBackfill", "asrLogId", "getDirectFillStatus", "getDirectFillAsrLogId", "updateDirectFillAsrLogId", DyPayConstant.KEY_SHOW_LOADING, "anchorView", "Landroid/widget/EditText;", "dismissLoading", "tryRestoreSpeakerInputStatus", "updateDirectFillStatusAfterTextChanged", "text", "", "updateDirectFillStatus", "newStatus", "clearDirectFillAsrLogId", "reason", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AsrDirectFillComponent extends ComponentFeature implements IAsrDirectFillAbility {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f287237h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f287238i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f287239j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f287240k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f287241l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f287242m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f287243n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f287244o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final l f287245p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f287246q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public n f287247r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f287248s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TouchInterceptingView f287249t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile IAsrDirectFillAbility.DirectFillStatus f287250u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile String f287251v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f287252w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b f287253x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f287254y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f287255z;

    /* JADX INFO: loaded from: classes3.dex */
    public static final class a {
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class b implements nf9.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AsrDirectFillComponent f287256a;

        @Override // nf9.b
        public final void b(String r100, MessageListState r101, List<Message> r102) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "state");
            Intrinsics.checkNotNullParameter(r102, "msgList");
        }

        @Override // nf9.b
        public final void c(String r100, Message r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }

        @Override // nf9.b
        public final void d(String r100, Message r101) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }

        @Override // nf9.b
        public final void e(String r100, Message r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }

        @Override // nf9.b
        public final void f(String r100, Message r101) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }

        @Override // nf9.b
        public final void onMessageListReplaced(String r100, List<Message> r101, List<Message> r102) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "oldMsgList");
            Intrinsics.checkNotNullParameter(r102, "newMsgList");
        }

        public b(AsrDirectFillComponent r100) {
            this.f287256a = r100;
        }

        @Override // nf9.b
        public final void a(String r100, Message r101) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
            AsrDirectFillComponent r102 = this.f287256a;
            int r103 = AsrDirectFillComponent.A;
            y r104 = (y) r102.f287242m.getValue();
            if (r104 == null) goto L5;
            String r105 = r104.Y1();
        L7:
            if (Intrinsics.areEqual(r105, r100) == true) goto L10;
            FLogger.f375446a.i("AsrDirectFillComponent", "[OnMessageChangedObserver] receive onSendMessage event, but not for this conversation");
            return;
        L10:
            FLogger.f375446a.i("AsrDirectFillComponent", "[OnMessageChangedObserver] receive onSendMessage event, cid: " + r100 + ", msg.messageStatusLocal: " + r101.getMessageStatusLocal());
            if (r101.getMessageStatusLocal() != 10) goto L19;
            AsrDirectFillComponent r106 = this.f287256a;
            if (r106.f287248s == false) goto L17;
            r106.f287248s = false;
            ICoreInputAbility r107 = r106.P2();
            if (r107 == null) goto L17;
            r107.g2(2, true);
        L17:
            this.f287256a.Y2(null);
            return;
        L19:
            return;
        L5:
            r105 = null;
            goto L7
        }
    }

    /* JADX INFO: loaded from: classes24.dex */
    public static final class c implements e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AsrDirectFillComponent f287257a;

        @Override // com.larus.bmhome.chat.component.bottom.core.speaker.e.b
        public final void A9() {
            AsrDirectFillComponent r100 = this.f287257a;
            int r101 = AsrDirectFillComponent.A;
            com.larus.bmhome.chat.component.bottom.core.speaker.l r102 = r100.U2();
            if (r102 == null) goto L6;
            r102.A9();
            return;
        }

        public c(AsrDirectFillComponent r100) {
            this.f287257a = r100;
        }

        @Override // com.larus.bmhome.chat.component.bottom.core.speaker.e.b
        public final void B9(f r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            AsrDirectFillComponent r101 = this.f287257a;
            int r102 = AsrDirectFillComponent.A;
            com.larus.bmhome.chat.component.bottom.core.speaker.l r103 = r101.U2();
            if (r103 == null) goto L6;
            r103.e8(r100);
            return;
        }

        @Override // com.larus.bmhome.chat.component.bottom.core.speaker.e.b
        public final void C9(f r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            AsrDirectFillComponent r101 = this.f287257a;
            int r102 = AsrDirectFillComponent.A;
            com.larus.bmhome.chat.component.bottom.core.speaker.l r103 = r101.U2();
            if (r103 == null) goto L6;
            r103.B9(r100);
            return;
        }

        @Override // com.larus.bmhome.chat.component.bottom.core.speaker.e.b
        public final void D9(Function1<? super String, Boolean> r100) {
            Intrinsics.checkNotNullParameter(r100, "handle");
            AsrDirectFillComponent r101 = this.f287257a;
            int r102 = AsrDirectFillComponent.A;
            com.larus.bmhome.chat.component.bottom.core.speaker.l r103 = r101.U2();
            if (r103 == null) goto L6;
            com.larus.bmhome.chat.component.bottom.core.speaker.l.a.b(r103, r100);
            return;
        }
    }

    static {
    }

    @Override // com.larus.asr.direct.IAsrDirectFillAbility
    public final void Il() {
        this.f287252w = false;
    }

    public final void L2() {
        if (this.f287255z == false) goto L5;
        return;
    L5:
        boolean r100 = true;
        this.f287255z = true;
        m r101 = N2();
        String r102 = null;
        if (r101 == null) goto L14;
        va8.l r103 = r101.iX();
        if (r103 == null) goto L14;
        FrameLayout r104 = r103.getInput();
        if (r104 == null) goto L14;
        EditText r105 = (EditText) r104.findViewById(R.id.input_text);
        if (r105 == null) goto L14;
        n r106 = new n(this);
        r105.addTextChangedListener(r106);
    L15:
        this.f287247r = r106;
        y r107 = (y) this.f287242m.getValue();
        if (r107 == null) goto L18;
        r102 = r107.Y1();
    L18:
        FLogger.f375446a.i("AsrDirectFillComponent", "[initIMSDKListener] cvsId: " + r102);
        if (r102 != null) goto L21;
    L24:
        if (r100 == true) goto L27;
        d.e().registerOnMessageChangedObserver(r102, this.f287253x);
        return;
    L27:
        return;
    L21:
        if (r102.length() == 0) goto L24;
        r100 = false;
    L14:
        r106 = null;
        goto L15
    }

    public final m N2() {
        return (m) this.f287238i.getValue();
    }

    public final ICoreInputAbility P2() {
        return (ICoreInputAbility) this.f287239j.getValue();
    }

    @Override // com.larus.asr.direct.IAsrDirectFillAbility
    public final void R30() {
        FLogger.f375446a.i("AsrDirectFillComponent", "[HF] onHandsfreeEntered: dismiss direct-fill waiting UI (interceptor + loading)");
        ((Handler) this.f287244o.getValue()).removeCallbacks(this.f287245p);
        m r100 = N2();
        if (r100 == null) goto L9;
        va8.l r101 = r100.iX();
        if (r101 == null) goto L9;
        FrameLayout r102 = r101.getInput();
        if (r102 == null) goto L9;
        EditText r103 = (EditText) r102.findViewById(R.id.input_text);
    L10:
        T70(r103);
        TouchInterceptingView r104 = this.f287249t;
        if (r104 == null) goto L14;
        e1.o(r104);
        return;
    L14:
        return;
    L9:
        r103 = null;
        goto L10
    }

    public final com.larus.bmhome.chat.component.bottom.core.speaker.l U2() {
        return (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.f287237h.getValue();
    }

    public final e X2() {
        return (e) this.f287246q.getValue();
    }

    @Override // com.larus.asr.direct.IAsrDirectFillAbility
    public final boolean oQ() {
        if (this.f287252w == true) goto L5;
    L7:
        return false;
    L5:
        if (z2.f365865a.voiceInputDirectFillInput() == false) goto L7;
        return true;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        FLogger.f375446a.i("AsrDirectFillComponent", "[onDestroy]: running: " + X2().f299403f);
        m r100 = N2();
        String r101 = null;
        if (r100 == null) goto L9;
        va8.l r102 = r100.iX();
        if (r102 == null) goto L9;
        FrameLayout r103 = r102.getInput();
        if (r103 == null) goto L9;
        EditText r104 = (EditText) r103.findViewById(R.id.input_text);
    L10:
        T70(r104);
        TouchInterceptingView r105 = this.f287249t;
        if (r105 == null) goto L20;
        ViewParent r106 = r105.getParent();
        if ((r106 instanceof ViewGroup) == false) goto L16;
        ViewGroup r107 = (ViewGroup) r106;
    L17:
        if (r107 == null) goto L19;
        r107.removeView(r105);
    L19:
        this.f287249t = null;
        goto L20
    L16:
        r107 = null;
    L20:
        X2().d("on_destroy");
        NativeMessageServiceImpl r108 = d.e();
        y r109 = (y) this.f287242m.getValue();
        if (r109 == null) goto L23;
        r101 = r109.Y1();
    L23:
        if (r101 != null) goto L25;
        r101 = "";
    L25:
        r108.unregisterOnMessageChangedObserver(r101, this.f287253x);
        n r110 = this.f287247r;
        if (r110 == null) goto L37;
        m r111 = N2();
        if (r111 == null) goto L38;
        va8.l r112 = r111.iX();
        if (r112 == null) goto L39;
        FrameLayout r113 = r112.getInput();
        if (r113 == null) goto L40;
        EditText r114 = (EditText) r113.findViewById(R.id.input_text);
        if (r114 == null) goto L41;
        r114.removeTextChangedListener(r110);
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L9:
        r104 = null;
        goto L10
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, IAsrDirectFillAbility.class);
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [c58.l] */
    public AsrDirectFillComponent() {
        this.f287237h = LazyKt.lazy(new c58.a(this));
        this.f287238i = LazyKt.lazy(new c58.e(this));
        this.f287239j = LazyKt.lazy(new c58.f(this));
        this.f287240k = LazyKt.lazy(new g(this));
        this.f287241l = LazyKt.lazy(new h(this));
        this.f287242m = LazyKt.lazy(new i(this));
        this.f287243n = LazyKt.lazy(new j());
        this.f287244o = LazyKt.lazy(new k());
        this.f287245p = new l(this);
        this.f287246q = LazyKt.lazy(new c58.m(this));
        this.f287252w = true;
        this.f287253x = new b(this);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void B2() {
        if (oQ() == false) goto L42;
        FLogger r100 = FLogger.f375446a;
        r100.i("AsrDirectFillComponent", "onParentViewCreated");
        X2().e(new c58.c(this));
        IAsrDirectFillAbility.DirectFillStatus r101 = null;
        if (this.f287249t != null) goto L19;
        View r102 = s1a.a.getActivity(this).getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L13;
        r100.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L13;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L13:
        if ((r102 instanceof ViewGroup) == false) goto L15;
        ViewGroup r104 = (ViewGroup) r102;
    L16:
        if (r104 == null) goto L19;
        TouchInterceptingView r105 = new TouchInterceptingView(s1a.a.getActivity(this), null, 6, 0);
        r105.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        e1.o(r105);
        r105.setEventHandler(new c58.d(this));
        r104.addView(r105);
        this.f287249t = r105;
        goto L19
    L15:
        r104 = null;
    L19:
        m r106 = N2();
        if (r106 == null) goto L26;
        va8.l r107 = r106.iX();
        if (r107 == null) goto L26;
        ViewGroup r108 = r107.d();
        if (r108 == null) goto L26;
        ViewExtKt.n(r108, null, null, new c58.b(this), 3);
    L26:
        IAsrDirectFillAbility.DirectFillStatus.a r109 = IAsrDirectFillAbility.DirectFillStatus.Companion;
        int r110 = ((Keva) p.f22503a.getValue()).getInt("asr_direct_fill_status", 0);
        r109.getClass();
        Iterator<IAsrDirectFillAbility.DirectFillStatus> r111 = IAsrDirectFillAbility.DirectFillStatus.getEntries().iterator();
    L28:
        if (r111.hasNext() == false) goto L35;
        IAsrDirectFillAbility.DirectFillStatus r112 = r111.next();
        if (r112.getValue() != r110) goto L32;
        boolean r113 = true;
    L33:
        if (r113 == false) goto L28;
        r101 = r112;
        goto L35
    L32:
        r113 = false;
    L35:
        this.f287250u = r101;
        FLogger.f375446a.i("AsrDirectFillComponent", "[initDirectFillStatus] directFillStatus: " + this.f287250u);
        L2();
        return;
    }

    @Override // com.larus.asr.direct.IAsrDirectFillAbility
    public final void S60() {
        X2().f();
    }

    @Override // com.larus.asr.direct.IAsrDirectFillAbility
    public final IAsrDirectFillAbility.DirectFillStatus VY() {
        if (oQ() == true) goto L9;
        if (this.f287254y == true) goto L9;
        return null;
    L9:
        return this.f287250u;
    }

    @Override // com.larus.asr.direct.IAsrDirectFillAbility
    public final void cancel() {
        X2().b();
    }

    @Override // com.larus.asr.direct.IAsrDirectFillAbility
    public final String xl() {
        if (oQ() == true) goto L9;
        if (this.f287254y == true) goto L9;
        return null;
    L9:
        return this.f287251v;
    }

    public final void F2(String r100) {
        String r101 = this.f287251v;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        FLogger.f375446a.i("AsrDirectFillComponent", "clear direct fill asr log id, reason=".concat(r100));
        this.f287251v = null;
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final void T70(EditText r100) {
        ((Handler) this.f287244o.getValue()).removeCallbacks(this.f287245p);
        ((com.larus.asr.f) this.f287243n.getValue()).a(r100);
    }

    public final void Y2(IAsrDirectFillAbility.DirectFillStatus r100) {
        this.f287250u = r100;
        int r101 = 0;
        if (r100 != null) goto L6;
        this.f287254y = false;
        F2("status_reset");
    L8:
        Lazy r102 = p.f22503a;
        if (r100 == null) goto L11;
        r101 = r100.getValue();
    L11:
        ((Keva) p.f22503a.getValue()).storeInt("asr_direct_fill_status", r101);
        return;
    L6:
        if (r100 != IAsrDirectFillAbility.DirectFillStatus.FillBackClear) goto L8;
        F2("fill_back_clear");
        goto L8
    }

    @Override // com.larus.asr.direct.IAsrDirectFillAbility
    public final void YZ(String r100) {
        if (this.f287254y == true) goto L5;
    L15:
        FLogger.f375446a.i("AsrDirectFillComponent", "[updateDirectFillAsrLogId]: ignore stale result");
        return;
    L5:
        if (this.f287250u == null) goto L15;
        if (r100 != null) goto L10;
    L12:
        r100 = null;
    L13:
        this.f287251v = r100;
        return;
    L10:
        if ((!StringsKt.isBlank(r100)) == false) goto L12;
        goto L12
    }

    @Override // com.larus.asr.direct.IAsrDirectFillAbility
    public final void mR(String r100) {
        L2();
        this.f287254y = true;
        if (r100 != null) goto L5;
    L7:
        r100 = null;
    L8:
        this.f287251v = r100;
        FLogger.f375446a.i("AsrDirectFillComponent", "[onHandsfreeBackfill]: change status to FillBackClickSend");
        Y2(IAsrDirectFillAbility.DirectFillStatus.FillBackClickSend);
        return;
    L5:
        if ((true ^ StringsKt.isBlank(r100)) == false) goto L7;
        goto L7
    }

    @Override // com.larus.asr.direct.IAsrDirectFillAbility
    public final void il(boolean r110, c0 r210) {
        Intrinsics.checkNotNullParameter(r210, "traceInfo");
        if (X2().f299403f == false) goto L6;
        FLogger.f375446a.w("AsrDirectFillComponent", "startDirectFillAsr skipped, already running");
        return;
    L6:
        F2("start_direct_fill");
        Y2(null);
        ICoreInputAbility r100 = P2();
        if (r100 != null) goto L9;
    L11:
        boolean r101 = false;
    L12:
        this.f287248s = r101;
        X2().a();
        com.larus.bmhome.chat.component.bottom.core.speaker.l r102 = U2();
        if (r102 == null) goto L16;
        com.larus.bmhome.chat.component.bottom.core.speaker.l.a.a(r102, r110, true, null, false, c0.a(r210, 0, null, null, null, "fill_back", 127), null, null, null, null, null, 1004);
        return;
    L16:
        return;
    L9:
        if (r100.Rp() != 2) goto L11;
        r101 = true;
        goto L12
    }
}
