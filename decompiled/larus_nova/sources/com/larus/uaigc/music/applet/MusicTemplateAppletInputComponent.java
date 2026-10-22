package com.larus.uaigc.music.applet;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002 N\u0018\u0000 \u008b\u00012\u00060\u0001j\u0002`\u00022\u00020\u00032\u00020\u0004:\u0002\u008b\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010P\u001a\u00020\u000eH\u0016J\u0010\u0010Q\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020\u001aH\u0016J\b\u0010S\u001a\u00020\u000eH\u0016J\u0016\u0010T\u001a\u00020\u000e2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010V\u001a\u00020\u000eH\u0002J\u0010\u0010W\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020\u001aH\u0002J\b\u0010X\u001a\u00020\u000eH\u0002J\u0010\u0010Y\u001a\u00020\u000e2\u0006\u0010Z\u001a\u00020[H\u0002J\u0010\u0010\\\u001a\u00020\u000e2\u0006\u0010]\u001a\u00020\bH\u0002J\b\u0010^\u001a\u00020\u000eH\u0002J\b\u0010_\u001a\u00020\u000eH\u0002J\b\u0010`\u001a\u00020\u000eH\u0002J\b\u0010a\u001a\u00020\bH\u0002J\b\u0010b\u001a\u00020\u000eH\u0002J\b\u0010c\u001a\u00020\u000eH\u0002J\b\u0010d\u001a\u00020\u000eH\u0002J\"\u0010e\u001a\u00020\u000e2\u000e\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010g\u001a\u0004\u0018\u00010\u0015H\u0016J\n\u0010h\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010i\u001a\u00020\u000e2\u0006\u0010j\u001a\u00020\u001cH\u0002J\u0018\u0010k\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010l\u001a\u00020\u001cH\u0002J\u0013\u0010m\u001a\b\u0012\u0004\u0012\u00020o0nH\u0002¢\u0006\u0002\u0010pJ\b\u0010q\u001a\u00020\u000eH\u0002J\b\u0010r\u001a\u00020\u000eH\u0002J\b\u0010s\u001a\u00020\u000eH\u0002J\b\u0010t\u001a\u00020\u000eH\u0002J\b\u0010u\u001a\u00020\u000eH\u0002J\b\u0010v\u001a\u00020\u000eH\u0002J\n\u0010w\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010x\u001a\u00020\u000eH\u0002J\u0010\u0010y\u001a\u00020\u000e2\u0006\u0010z\u001a\u00020{H\u0002J,\u0010|\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010}2\u0014\u0010~\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010}H\u0002J\u0012\u0010\u007f\u001a\u00030\u0080\u00012\u0007\u0010\u0081\u0001\u001a\u00020\u001cH\u0002J\u0012\u0010\u0082\u0001\u001a\u00020\u000e2\u0007\u0010\u0083\u0001\u001a\u00020{H\u0002J\f\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0002J\t\u0010\u0086\u0001\u001a\u00020\u000eH\u0002J\t\u0010\u0087\u0001\u001a\u00020\u000eH\u0002J\u0012\u0010\u0088\u0001\u001a\u00020\u000e2\u0007\u0010\u0089\u0001\u001a\u00020\u001cH\u0002J\u0014\u0010\u008a\u0001\u001a\u00020\u000e2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u001cH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u001d\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b*\u0010+R\u001d\u0010-\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010'\u001a\u0004\b/\u00100R\u001d\u00102\u001a\u0004\u0018\u0001038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010'\u001a\u0004\b4\u00105R\u001d\u00107\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010'\u001a\u0004\b9\u0010:R\u001d\u0010<\u001a\u0004\u0018\u00010=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010'\u001a\u0004\b>\u0010?R\u001d\u0010A\u001a\u0004\u0018\u00010B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010'\u001a\u0004\bC\u0010DR\u001d\u0010F\u001a\u0004\u0018\u00010G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010'\u001a\u0004\bH\u0010IR\u001a\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0LX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u00020NX\u0082\u0004¢\u0006\u0004\n\u0002\u0010O¨\u0006\u008c\u0001"}, d2 = {"Lcom/larus/uaigc/music/applet/MusicTemplateAppletInputComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/uaigc/bean/instruction/IMusicLyricsEditAbility;", "Lcom/larus/uaigc/music/applet/MusicTemplateAppletInputReadyAbility;", "<init>", "()V", MessageIndication.STATUS_SENDING, "", "rootContainer", "Landroid/view/ViewGroup;", "inputReady", "pendingInputReadyAction", "Lkotlin/Function0;", "", "fullScreenEditView", "Lcom/larus/uaigc/music/applet/MusicFullScreenEditFrameLayout;", "fullScreenSelectedItems", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionItem;", "fullScreenMusicCreateManager", "Lcom/larus/bmhome/music/instructions/IMusicCreateManager;", "restoreInputAfterFullScreenEdit", "coreFullScreenEditOpen", "restoreInputAfterCoreFullScreenEdit", "templateMaskView", "Landroid/view/View;", "registeredLocalConversationId", "", "restoreInputAfterCoreFullScreenEditRunnable", "Ljava/lang/Runnable;", "appletLifecycleCallback", "com/larus/uaigc/music/applet/MusicTemplateAppletInputComponent$appletLifecycleCallback$1", "Lcom/larus/uaigc/music/applet/MusicTemplateAppletInputComponent$appletLifecycleCallback$1;", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "coreInputManager", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "getCoreInputManager", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "coreInputManager$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "speakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "speakerAbility$delegate", "editorAbility", "Lcom/larus/uaigc/music/applet/MusicAppletInstructionEditorAbility;", "getEditorAbility", "()Lcom/larus/uaigc/music/applet/MusicAppletInstructionEditorAbility;", "editorAbility$delegate", "instructionPanelAbility", "Lcom/larus/uaigc/music/applet/MusicTemplateAppletInstructionPanelAbility;", "getInstructionPanelAbility", "()Lcom/larus/uaigc/music/applet/MusicTemplateAppletInstructionPanelAbility;", "instructionPanelAbility$delegate", "argumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "argumentData$delegate", "chatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "getChatPageContext", "()Lcom/larus/bmhome/chat/bean/ChatPageContext;", "chatPageContext$delegate", "inputFocusChangeListener", "Lkotlin/Function1;", "conversationReplaceListener", "com/larus/uaigc/music/applet/MusicTemplateAppletInputComponent$conversationReplaceListener$1", "Lcom/larus/uaigc/music/applet/MusicTemplateAppletInputComponent$conversationReplaceListener$1;", "onAttach", "onViewCreated", "view", LiveCommonConstants.REASON_ON_DEDTROY, "runWhenInputReady", "action", "dispatchPendingInputReadyAction", "initRootLayout", "configInput", "observeImeChange", "parent", "Lcom/larus/bmhome/view/ChatConstraintLayout;", "onCoreFullScreenInputStatusChanged", "open", "completeCoreFullScreenInputRestore", "restoreInputFocusAfterCoreFullScreenEdit", "updateTemplateMask", "isInputPanelExpanded", "addTemplateMask", "removeTemplateMask", "collapseMusicInputPanel", "showLyricsFullScreenEditor", "selectedItems", "musicCreateManager", "resolveFullScreenEditContainer", "onFullScreenEditConfirmed", "text", "onFullScreenAiGenerate", EventConstant.Key.RETAIN_PROMPT, "buildLyricsInputFilters", "", "Landroid/text/InputFilter;", "()[Landroid/text/InputFilter;", "removeFullScreenEditView", "restoreInputFocusAfterFullScreenEdit", "showExpandedInputPanel", "openMusicInstructionEditorIfNeeded", "configFullInputBoxMobParams", "applyActionBarInputHintIfInputEmpty", "resolveActionBarInputHint", "configVisibleInputStatus", "onSend", "params", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "mergeMessageExt", "", "inputMessageExt", "onVoiceAsrResult", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/ASRWithExtResult;", "asrResult", "sendToTargetConversation", "sendParams", "resolveSendConversation", "Lcom/larus/im/bean/conversation/Conversation;", "observeLocalConversationReplacement", "unregisterLocalConversationReplacement", "syncReplacedConversationId", "conversationId", "onSendAccepted", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicTemplateAppletInputComponent extends BaseContentWidget implements wy9.d, t1 {
    public static final /* synthetic */ int K = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final u0 I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final c f373571J;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f373572m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ChatConstraintLayout f373573n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f373574o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function0<Unit> f373575p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public MusicFullScreenEditFrameLayout f373576q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List<com.larus.bmhome.actionbar.model.u> f373577r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.larus.bmhome.music.instructions.a f373578s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f373579t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f373580u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f373581v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f373582w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f373583x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final o1 f373584y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final b f373585z;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.uaigc.music.applet.MusicTemplateAppletInputComponent$a$a, reason: collision with other inner class name */
        public static final class C4511a implements ChatConstraintLayout.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C4511a f373586a = null;

            static {
                f373586a = new C4511a();
            }

            public C4511a() {
            }

            @Override // com.larus.bmhome.view.ChatConstraintLayout.b
            public final void a() {
            }

            @Override // com.larus.bmhome.view.ChatConstraintLayout.b
            public final void b() {
            }

            @Override // com.larus.bmhome.view.ChatConstraintLayout.b
            public final void onUpdate(int r100) {
            }
        }
    }

    public static final class b implements ir8.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MusicTemplateAppletInputComponent f373587a;

        @Override // ir8.c.a
        public final void a() {
            Intrinsics.checkNotNullParameter(MusicAppletPage.APP_ID, "appId");
            if (Intrinsics.areEqual(MusicAppletPage.APP_ID, MusicAppletPage.APP_ID) == false) goto L9;
            MusicTemplateAppletInputComponent r100 = this.f373587a;
            r100.f373579t = false;
            MusicFullScreenEditFrameLayout r101 = r100.f373576q;
            if (r101 == null) goto L7;
            r101.c(true);
        L7:
            this.f373587a.m3();
            return;
        }

        public b(MusicTemplateAppletInputComponent r100) {
            this.f373587a = r100;
        }
    }

    public static final class c implements com.larus.im.service.d0<wc9.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MusicTemplateAppletInputComponent f373588a;

        public c(MusicTemplateAppletInputComponent r100) {
            this.f373588a = r100;
        }

        @Override // com.larus.im.service.z
        public final void c(Object r100) {
            Intrinsics.checkNotNullParameter((wc9.e) r100, "conversation");
        }

        @Override // com.larus.im.service.d0
        public final void a(wc9.e r100, wc9.e r101) {
            Intrinsics.checkNotNullParameter(r101, "new");
            String r102 = this.f373588a.f373583x;
            if (r102 == null) goto L28;
            if (r100 == null) goto L7;
            String r103 = r100.f559198a;
        L9:
            if (Intrinsics.areEqual(r103, r102) == false) goto L29;
            MusicTemplateAppletInputComponent r104 = this.f373588a;
            String r105 = r101.f559198a;
            r104.getClass();
            if (r105.length() != 0) goto L14;
            boolean r106 = true;
        L15:
            if (r106 == true) goto L30;
            Intrinsics.checkNotNullParameter(r104, "<this>");
            Bundle r107 = com.larus.ui.arch.component.internal.attach.a.b(r104, r104).getArguments();
            if (r107 == null) goto L20;
            r107.putString("argConversationId", r105);
            r107.putString("conversation_id", r105);
        L20:
            ny9.s r108 = r104.z3();
            if (r108 == null) goto L26;
            ChatParam r109 = r108.c();
            if (r109 == null) goto L27;
            r109.f296889a = r105;
            return;
        L27:
            return;
        L26:
            return;
        L30:
            return;
        L14:
            r106 = false;
            goto L15
        L29:
            return;
        L7:
            r103 = null;
            goto L9
        }
    }

    static {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        this.f373574o = false;
        this.f373575p = null;
        CopyOnWriteArraySet<ir8.c.a> r100 = ir8.c.f495501a;
        ir8.c.c(this.f373585z);
        String r101 = this.f373583x;
        if (r101 == null) goto L6;
        com.larus.im.d.c().unRegisterConversationChangeListener(r101, this.f373571J);
        this.f373583x = null;
    L6:
        va8.o r102 = B3();
        if (r102 == null) goto L9;
        r102.oR(this.I);
    L9:
        ICoreInputAbility r103 = C3();
        if (r103 == null) goto L12;
        r103.tr(new l1());
    L12:
        ICoreInputAbility r104 = C3();
        if (r104 == null) goto L15;
        r104.r7(new m1());
    L15:
        z8 r105 = D3();
        if (r105 == null) goto L18;
        r105.j9();
    L18:
        ChatConstraintLayout r106 = this.f373573n;
        if ((r106 instanceof ChatConstraintLayout) == true) goto L22;
        r106 = null;
    L22:
        if (r106 == null) goto L24;
        r106.setOnBottomInsetUpdateListener(a.C4511a.f373586a);
    L24:
        ChatConstraintLayout r107 = this.f373573n;
        if (r107 == null) goto L27;
        r107.removeCallbacks(this.f373584y);
    L27:
        H3();
        MusicFullScreenEditFrameLayout r108 = this.f373576q;
        if (r108 == null) goto L37;
        ViewParent r109 = r108.getParent();
        if ((r109 instanceof ViewGroup) == false) goto L33;
        ViewGroup r110 = (ViewGroup) r109;
    L34:
        if (r110 == null) goto L36;
        r110.removeView(r108);
    L36:
        this.f373576q = null;
        this.f373579t = false;
        goto L37
    L33:
        r110 = null;
    L37:
        this.f373573n = null;
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.f(com.larus.ui.arch.component.internal.attach.a.b(this, this), t1.class);
    }

    public final va8.o B3() {
        return (va8.o) this.C.getValue();
    }

    public final ICoreInputAbility C3() {
        return (ICoreInputAbility) this.A.getValue();
    }

    public final z8 D3() {
        return (z8) this.B.getValue();
    }

    public final boolean E3() {
        ChatConstraintLayout r100 = this.f373573n;
        if (r100 == null) goto L9;
        View r101 = r100.findViewById(R.id.chat_input);
        if (r101 == null) goto L9;
        if (r101.getVisibility() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public final void H3() {
        View r100 = this.f373582w;
        if (r100 == null) goto L10;
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L7;
        ViewGroup r102 = (ViewGroup) r101;
    L8:
        if (r102 == null) goto L10;
        r102.removeView(r100);
        goto L10
    L7:
        r102 = null;
    L10:
        this.f373582w = null;
    }

    public final ViewGroup Q3() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r100 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r100 == null) goto L5;
        ViewParent r101 = r100.getParent();
    L7:
        if ((r101 instanceof ViewGroup) == false) goto L9;
        ViewGroup r102 = (ViewGroup) r101;
    L11:
        if ((r102 instanceof FragmentContainerView) == false) goto L16;
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r103 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r103 != null) goto L15;
        return null;
    L15:
        return (ViewGroup) r103.findViewById(android.R.id.content);
    L16:
        if (r102 == null) goto L18;
        return r102;
    L18:
        return this.f373573n;
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public final void V3() {
        if (this.f373579t == true) goto L5;
        return;
    L5:
        va8.o r100 = B3();
        if (r100 == null) goto L8;
        r100.E40();
    L8:
        ICoreInputAbility r101 = C3();
        if (r101 == null) goto L12;
        ICoreInputAbility.b.e(r101, "music_full_screen_edit_close", null, false, 6);
        return;
    }

    public final void W3() {
        ChatConstraintLayout r100 = this.f373573n;
        if (r100 == null) goto L7;
        View r101 = r100.findViewById(R.id.start_write_entry_container);
        if (r101 == null) goto L7;
        com.larus.utils.e1.o(r101);
    L7:
        ChatConstraintLayout r102 = this.f373573n;
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(R.id.chat_input);
        if (r103 == null) goto L12;
        com.larus.utils.e1.x(r103);
    L12:
        u1 r104 = (u1) this.F.getValue();
        if (r104 == null) goto L15;
        r104.yD();
    L15:
        Y2();
    }

    public final void Y2() {
        ChatConstraintLayout r100 = this.f373573n;
        if (r100 == null) goto L15;
        ViewGroup r101 = (ViewGroup) r100.findViewById(R.id.template_container);
        if (r101 == null) goto L16;
        View r102 = this.f373582w;
        if (r102 == null) goto L10;
        ViewParent r103 = r102.getParent();
    L11:
        if (r103 != r101) goto L13;
        return;
    L13:
        H3();
        View r104 = new View(getContext());
        r104.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r104.setBackgroundColor(0);
        com.larus.utils.e1.d(r104, new v0(this));
        this.f373582w = r104;
        r101.addView(r104);
        return;
    L10:
        r103 = null;
        goto L11
    L16:
        return;
    }

    public final void p3() {
        kr8.n r100 = kr8.n.f505865a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        kr8.o r101 = kr8.n.a(com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments(), null, null, null, null, null, 62);
        z8 r102 = D3();
        if (r102 == null) goto L6;
        r102.g9(MapsKt.mapOf(new Pair[]{TuplesKt.to("current_page", "template_page"), TuplesKt.to("app_enter_method", r101.f505869b), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FROM_ENTRANCE, r101.f505872e), TuplesKt.to("app_key", r101.f505870c)}));
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, wy9.d.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, t1.class);
        CopyOnWriteArraySet<ir8.c.a> r100 = ir8.c.f495501a;
        b r101 = this.f373585z;
        Intrinsics.checkNotNullParameter(r101, "callback");
        ir8.c.f495501a.add(r101);
    }

    public final ny9.s z3() {
        return (ny9.s) this.G.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.uaigc.music.applet.o1] */
    /* JADX WARN: Type inference failed for: r0v18, types: [com.larus.uaigc.music.applet.u0] */
    public MusicTemplateAppletInputComponent() {
        this.f373584y = new o1(this);
        this.f373585z = new b(this);
        this.A = LazyKt.lazy(new p1(this));
        this.B = LazyKt.lazy(new q1(this));
        this.C = LazyKt.lazy(new r1(this));
        this.D = LazyKt.lazy(new p0(this));
        this.E = LazyKt.lazy(new q0(this));
        this.F = LazyKt.lazy(new r0(this));
        this.G = LazyKt.lazy(new s0(this));
        this.H = LazyKt.lazy(new t0(this));
        this.I = new u0(this);
        this.f373571J = new c(this);
    }

    public final void X3() {
        if (E3() == false) goto L5;
        Y2();
        return;
    L5:
        H3();
    }

    public final void h3() {
        va8.o r100 = B3();
        boolean r101 = false;
        if (r100 == null) goto L12;
        String r102 = r100.u7();
        if (r102 == null) goto L12;
        if (r102.length() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 != true) goto L12;
        r101 = true;
        goto L12
    L9:
        r103 = false;
    L12:
        if (r101 == false) goto L14;
        return;
    L14:
        f r104 = (f) this.E.getValue();
        String r105 = null;
        if (r104 == null) goto L21;
        String r106 = r104.O3(r104.S4());
        if (r106 == null) goto L21;
        if ((!StringsKt.isBlank(r106)) == false) goto L21;
    L22:
        if (r104 == null) goto L32;
        com.larus.bmhome.actionbar.model.r r107 = r104.getCurrentInstructionConf();
        if (r107 == null) goto L32;
        com.larus.bmhome.actionbar.model.h1 r108 = r107.f295410c;
        if (r108 == null) goto L32;
        String r109 = r108.f295180a;
        if (r109 == null) goto L32;
        if ((!StringsKt.isBlank(r109)) == false) goto L32;
    L33:
        ny9.s r110 = z3();
        if (r110 == null) goto L36;
        com.larus.bmhome.actionbar.model.z0 r111 = r110.f();
    L37:
        if (r111 == null) goto L47;
        com.larus.bmhome.actionbar.model.r r112 = r111.f295621q;
        if (r112 == null) goto L47;
        com.larus.bmhome.actionbar.model.h1 r113 = r112.f295410c;
        if (r113 == null) goto L47;
        String r114 = r113.f295180a;
        if (r114 == null) goto L47;
        if ((!StringsKt.isBlank(r114)) == false) goto L47;
    L48:
        if (r111 == null) goto L66;
        com.larus.bmhome.actionbar.model.r r115 = r111.f295621q;
        if (r115 == null) goto L66;
        com.larus.bmhome.actionbar.model.y r116 = r115.f295416i;
        if (r116 == null) goto L66;
        ArrayList<com.larus.bmhome.actionbar.model.z0> r117 = r116.f295561a;
        if (r117 == null) goto L66;
        com.larus.bmhome.actionbar.model.z0 r118 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.firstOrNull(r117);
        if (r118 == null) goto L66;
        com.larus.bmhome.actionbar.model.r r119 = r118.f295621q;
        if (r119 == null) goto L66;
        com.larus.bmhome.actionbar.model.h1 r120 = r119.f295410c;
        if (r120 == null) goto L66;
        String r121 = r120.f295180a;
        if (r121 == null) goto L66;
        if ((true ^ StringsKt.isBlank(r121)) == false) goto L66;
        r105 = r121;
    L66:
        if (r106 != null) goto L72;
        if (r109 != null) goto L71;
        if (r114 != null) goto L70;
        r106 = r105;
        goto L72
    L70:
        r106 = r114;
        goto L72
    L71:
        r106 = r109;
    L72:
        if (r106 != null) goto L74;
        return;
    L74:
        ICoreInputAbility r122 = C3();
        if (r122 == null) goto L78;
        r122.M5(r106);
        return;
    L78:
        return;
    L47:
        r114 = null;
        goto L48
    L36:
        r111 = null;
    L32:
        r109 = null;
    L21:
        r106 = null;
        goto L22
    }

    public final void m3() {
        va8.o r100 = B3();
        if (r100 == null) goto L5;
        r100.c3();
    L5:
        u1 r101 = (u1) this.F.getValue();
        if (r101 == null) goto L8;
        r101.Ub();
    L8:
        ChatConstraintLayout r102 = this.f373573n;
        if (r102 == null) goto L13;
        View r103 = r102.findViewById(R.id.chat_input);
        if (r103 == null) goto L13;
        com.larus.utils.e1.o(r103);
    L13:
        ChatConstraintLayout r104 = this.f373573n;
        if (r104 == null) goto L18;
        View r105 = r104.findViewById(R.id.start_write_entry_container);
        if (r105 == null) goto L18;
        com.larus.utils.e1.x(r105);
    L18:
        H3();
    }

    public final void G3(ICoreInputAbility.OnSendParams r810) {
        String r100 = r810.getContent();
        if (StringsKt.isBlank(StringsKt.trim(r100).toString()) == false) goto L6;
        FLogger.f375446a.i("MusicTemplateAppletInput", "ignore blank input");
        return;
    L6:
        f r101 = (f) this.E.getValue();
        if (r101 != null) goto L9;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == false) goto L16;
        FLogger.f375446a.i("MusicTemplateAppletInput", "ignore illegal music input");
        return;
    L16:
        if (this.f373572m == false) goto L19;
        FLogger.f375446a.i("MusicTemplateAppletInput", "ignore duplicate music template applet send");
        return;
    L19:
        this.f373572m = true;
        f r103 = (f) this.E.getValue();
        if (r103 != null) goto L23;
        FLogger.f375446a.e("MusicTemplateAppletInput", "send music template applet message failed, editorAbility is null");
        t19.s r104 = t19.s.f544207a;
        Application r105 = AppHost.f326268a.getApplication();
        r104.getClass();
        t19.s.s(r105, R.string.larus_notification_system_error_toast);
        this.f373572m = false;
        return;
    L23:
        ny9.s r106 = z3();
        if (r106 == null) goto L26;
        com.larus.bmhome.actionbar.model.z0 r107 = r106.f();
    L27:
        if (r107 == null) goto L29;
        String r110 = r107.f295606b;
    L30:
        if (r110 != null) goto L32;
    L35:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L40;
        FLogger.f375446a.e("MusicTemplateAppletInput", "send music template applet message failed, actionBarKey is empty");
        t19.s r109 = t19.s.f544207a;
        Application r111 = AppHost.f326268a.getApplication();
        r109.getClass();
        t19.s.s(r111, R.string.larus_notification_system_error_toast);
        this.f373572m = false;
        return;
    L40:
        if (r810.getLocalIntercepted() == false) goto L43;
        FLogger.f375446a.i("MusicTemplateAppletInput", "send music template applet message intercepted, reason:" + r810.getLocalInterceptInfo());
        this.f373572m = false;
        return;
    L43:
        String r310 = r103.y6(r100);
        String r112 = r103.Is(r100);
        if (r112 != null) goto L46;
        r112 = "";
    L46:
        String r113 = r112;
        com.larus.bmhome.instruction.j r114 = IAIChatUgcAIGCService.f365905a.e0();
        if (r107 == null) goto L49;
        Long r210 = r107.f295605a;
    L50:
        Map r115 = com.larus.bmhome.instruction.j.a.c(r114, r110, "1", r113, true, null, r210, 16);
        String r211 = r103.c0();
        Map<String, String> r116 = r810.messageExt;
        ny9.s r117 = z3();
        if (r117 == null) goto L55;
        ICoreInputAbility.MessageExtMap r118 = r117.m();
        if (r118 == null) goto L55;
        Map<String, String> r119 = r118.f298403a;
    L56:
        if (r119 != null) goto L58;
    L61:
        boolean r120 = true;
    L62:
        if (r120 == false) goto L64;
    L63:
        Map<String, String> r311 = r116;
        ChatPageContext r121 = r810.chatPageContext;
        if (r121 != null) goto L70;
        r121 = (ChatPageContext) this.H.getValue();
    L70:
        ICoreInputAbility.OnSendParams r122 = ICoreInputAbility.OnSendParams.copy$default(r810, r310, null, null, null, null, r115, null, null, 1, false, null, false, false, false, null, r211, null, null, false, "chat_action_bar", r311, null, null, null, null, null, null, null, null, r121, null, null, null, -538476834, 1, null);
        ICoreInputAbility r123 = C3();
        if (r123 != null) goto L73;
        FLogger.f375446a.e("MusicTemplateAppletInput", "send music template applet message failed, coreInputAbility is null");
        t19.s r124 = t19.s.f544207a;
        Application r125 = AppHost.f326268a.getApplication();
        r124.getClass();
        t19.s.s(r125, R.string.larus_notification_system_error_toast);
        this.f373572m = false;
        return;
    L73:
        ny9.s r126 = z3();
        if (r126 == null) goto L79;
        ChatParam r127 = r126.c();
        if (r127 == null) goto L79;
        String r128 = r127.f296889a;
        if (r128 == null) goto L79;
    L82:
        String r410 = r128;
    L84:
        if (r410 != null) goto L86;
    L89:
        boolean r129 = true;
    L90:
        if (r129 == false) goto L92;
        FLogger.f375446a.i("MusicTemplateAppletInput", "send music template applet message without explicit conversation");
        wc9.e r130 = null;
    L93:
        if (r130 != null) goto L135;
        FLogger.f375446a.e("MusicTemplateAppletInput", "send music template applet message failed, target conversation is empty");
        t19.s r131 = t19.s.f544207a;
        Application r132 = AppHost.f326268a.getApplication();
        r131.getClass();
        t19.s.s(r132, R.string.larus_notification_system_error_toast);
        this.f373572m = false;
        return;
    L135:
        r123.JJ(r130);     // Catch: Throwable -> L121 Exception -> L123
        r123.E0(r122);     // Catch: Throwable -> L121 Exception -> L123
        r123.JJ(null);
        String r133 = r130.f559198a;
        kr8.n r134 = kr8.n.f505865a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        kr8.o r135 = kr8.n.a(com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments(), null, null, null, null, null, 62);
        monitor-enter(r134);
        Intrinsics.checkNotNullParameter(r135, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L118
        if (r133 != null) goto L101;
    L106:
        monitor-exit(r134);
        ICoreInputAbility r136 = C3();
        if (r136 == null) goto L110;
        r136.qp(false);
    L110:
        ICoreInputAbility r137 = C3();
        if (r137 == null) goto L113;
        r137.p80(true);
    L113:
        this.f373572m = false;
        MutableSharedFlow<w1> r138 = b0.f373593a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r139 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r139 == null) goto L116;
        String r140 = r139.getString(MusicAppletPage.KEY_SOURCE_CREATION_SESSION_ID);
    L117:
        b0.f373595c.tryEmit(new v1(r133, r140));
        return;
    L116:
        r140 = null;
        goto L117
    L101:
        if ((!StringsKt.isBlank(r133)) == false) goto L103;
        String r141 = r133;
    L104:
        if (r141 == null) goto L106;
        kr8.n.f505866b.put(r141, r135);     // Catch: Throwable -> L118
        goto L106
    L103:
        r141 = null;
    L118:
        th = move-exception;
        throw th;
    L123:
        e = move-exception;
        wc9.e r142 = null;
        FLogger.f375446a.e("MusicTemplateAppletInput", "send music template applet message failed", e);     // Catch: Throwable -> L128
        t19.s r143 = t19.s.f544207a;     // Catch: Throwable -> L128
        Application r144 = AppHost.f326268a.getApplication();     // Catch: Throwable -> L128
        r143.getClass();     // Catch: Throwable -> L128
        t19.s.s(r144, R.string.larus_notification_system_error_toast);     // Catch: Throwable -> L128
        this.f373572m = false;     // Catch: Throwable -> L128
        r123.JJ(null);
        return;
    L128:
        th = th;
    L129:
        r123.JJ(r142);
        throw th;
    L121:
        th = th;
        r142 = null;
        goto L129
    L92:
        r130 = new wc9.e(r410, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, 0, null, null, 0, -2, 63);
        goto L93
    L86:
        if (r410.length() == 0) goto L89;
        r129 = false;
    L79:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r145 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r145 == null) goto L83;
        r128 = r145.getString("argConversationId");
        goto L82
    L83:
        r410 = null;
        goto L84
    L64:
        if (r116 != null) goto L66;
        r116 = MapsKt.emptyMap();
    L66:
        r116 = MapsKt.toMutableMap(r116);
        r116.putAll(r119);
        goto L63
    L58:
        if (r119.isEmpty() == true) goto L61;
        r120 = false;
    L55:
        r119 = null;
        goto L56
    L49:
        r210 = null;
        goto L50
    L32:
        if (r110.length() == 0) goto L35;
        r108 = false;
        goto L36
    L29:
        r110 = null;
        goto L30
    L26:
        r107 = null;
        goto L27
    L9:
        if (r101.x(r100) != true) goto L11;
        r102 = true;
        goto L12
    }

    @Override // com.larus.uaigc.music.applet.t1
    public final void kK(final g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (this.f373574o == false) goto L7;
        ChatConstraintLayout r101 = this.f373573n;
        if (r101 == null) goto L9;
        r101.post(new w0(r100));
        return;
    L9:
        return;
    L7:
        this.f373575p = r100;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if ((r100 instanceof ChatConstraintLayout) == false) goto L5;
        ChatConstraintLayout r101 = (ChatConstraintLayout) r100;
    L7:
        if (r101 == null) goto L10;
        this.f373573n = r101;
        r101.setDisableBottomPadding(true);
        r101.setDisableTopPadding(true);
        r101.k6(getContext());
        com.larus.utils.e1.d(r101, new n1(this));
        r101.setOnBottomInsetUpdateListener(new s1(this));
    L10:
        z8 r102 = D3();
        boolean r103 = false;
        if (r102 == null) goto L13;
        r102.z9(false);
    L13:
        z8 r104 = D3();
        if (r104 == null) goto L16;
        r104.s9();
    L16:
        ViewGroup r105 = Q3();
        if (r105 == null) goto L21;
        ICoreInputAbility r106 = C3();
        if (r106 == null) goto L21;
        r106.m1(r105);
    L21:
        ICoreInputAbility r107 = C3();
        if (r107 == null) goto L24;
        r107.r7(new MusicTemplateAppletInputComponent$configInput$2(this));
    L24:
        z8 r108 = D3();
        if (r108 == null) goto L27;
        r108.w8();
    L27:
        z8 r109 = D3();
        if (r109 == null) goto L30;
        r109.c9();
    L30:
        z8 r110 = D3();
        if (r110 == null) goto L33;
        r110.f9(true);
    L33:
        z8 r111 = D3();
        if (r111 == null) goto L36;
        r111.w9(false);
    L36:
        p3();
        ICoreInputAbility r112 = C3();
        if (r112 == null) goto L39;
        r112.s20(8);
    L39:
        va8.o r113 = B3();
        if (r113 == null) goto L42;
        r113.Jv();
    L42:
        z8 r114 = D3();
        if (r114 == null) goto L45;
        r114.R8();
    L45:
        g9.a r115 = new g9.a(new x0());
        g9.a r116 = new g9.a(new y0(this));
        z8 r117 = D3();
        if (r117 == null) goto L48;
        r117.y9(1, r115);
    L48:
        z8 r118 = D3();
        if (r118 == null) goto L51;
        r118.y9(3, r116);
    L51:
        ICoreInputAbility r119 = C3();
        if (r119 == null) goto L54;
        r119.tr(new o0(this));
    L54:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r120 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.D.getValue();
        if (r120 == null) goto L57;
        r120.b3(new z0(this));
    L57:
        va8.o r121 = B3();
        if (r121 == null) goto L60;
        r121.GM(this.I);
    L60:
        ICoreInputAbility r122 = C3();
        if (r122 == null) goto L63;
        r122.g2(1, true);
    L63:
        h3();
        ny9.s r123 = z3();
        if (r123 == null) goto L69;
        ChatParam r124 = r123.c();
        if (r124 == null) goto L69;
        String r125 = r124.f296889a;
        if (r125 == null) goto L69;
    L73:
        if (r125 != null) goto L75;
    L76:
        r103 = true;
    L77:
        if (r103 == false) goto L79;
    L82:
        this.f373574o = true;
        final Function0<Unit> r126 = this.f373575p;
        if (r126 == null) goto L90;
        this.f373575p = null;
        ChatConstraintLayout r127 = this.f373573n;
        if (r127 == null) goto L89;
        r127.post(new k1(r126));
        return;
    L89:
        return;
    L90:
        return;
    L79:
        if (com.larus.im.j.f(r125) == false) goto L82;
        this.f373583x = r125;
        com.larus.im.d.c().registerConversationChangeListener(r125, this.f373571J);
        goto L82
    L75:
        if (r125.length() != 0) goto L77;
    L69:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r128 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r128 == null) goto L72;
        r125 = r128.getString("argConversationId");
        goto L73
    L72:
        r125 = null;
        goto L73
    L5:
        r101 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wy9.d
    public final void AA(List r110, com.larus.bmhome.music.instructions.g r111) {
        MusicFullScreenEditFrameLayout r100 = this.f373576q;
        ViewGroup.MarginLayoutParams r101 = null;
        Object[] r102 = 0;
        if (r100 == null) goto L5;
        ViewParent r103 = r100.getParent();
    L6:
        if (r103 == null) goto L8;
        return;
    L8:
        ViewGroup r104 = Q3();
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r105 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r104 != null) goto L13;
        if (r105 != null) goto L13;
        FLogger.f375446a.e("MusicTemplateAppletInput", "show music full screen edit failed, target container and activity are null");
        return;
    L13:
        this.f373577r = r110;
        this.f373578s = r111;
        int r106 = 0;
        if (E3() == false) goto L23;
        va8.o r112 = B3();
        if (r112 != null) goto L18;
    L20:
        boolean r113 = false;
    L21:
        if (r113 == false) goto L23;
        boolean r114 = true;
    L24:
        this.f373579t = r114;
        kr8.n r115 = kr8.n.f505865a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        kr8.o r116 = kr8.n.a(com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments(), null, null, null, null, null, 62);
        Intrinsics.checkNotNullParameter(r116, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("template_page", "currentPage");
        JSONObject r107 = kr8.n.k(r116, "template_page");
        r107.put(com.bytedance.android.ec.core.event.a.KEY_FROM_ENTRANCE, r116.f505872e);
        kr8.n.g("create_lyrics_click", r107);
        va8.o r117 = B3();
        if (r117 == null) goto L27;
        r117.vI(false);
    L27:
        u1 r118 = (u1) this.F.getValue();
        if (r118 == null) goto L30;
        r118.Ub();
    L30:
        ViewGroup.LayoutParams r119 = new ViewGroup.LayoutParams(-1, -1);
        final MusicFullScreenEditFrameLayout r108 = new MusicFullScreenEditFrameLayout(getContext(), r102 == true ? 1 : 0, 6, r106);
        final int r109 = z2.f365865a.getMusicCreateConfig().f486643a;
        InputFilter[] r120 = {new com.larus.bmhome.music.utils.a(r109, new j1(this, r109))};
        Function1<? super String, Unit> r121 = new b1(this);
        Function1<? super String, Unit> r122 = new c1(this, r108);
        Function0<Unit> r123 = new d1(this);
        Function0<Unit> r124 = new e1(this, r108);
        Intrinsics.checkNotNullParameter(r121, "onUpdateInputText");
        Intrinsics.checkNotNullParameter(r122, "onAiGenerate");
        Intrinsics.checkNotNullParameter(r123, "onClosing");
        Intrinsics.checkNotNullParameter(r124, "onDismiss");
        r108.f373550d = r121;
        r108.f373551e = r122;
        r108.f373552f = r123;
        r108.f373553g = r124;
        r108.f373547a.f373240l.setFilters(r120);
        r108.setLayoutParams(r119);
        r108.setOnClickListener(new f1());
        com.larus.utils.e1.d(r108.f373547a.f373234f, new q(r108));
        com.larus.utils.e1.d(r108.f373547a.f373230b, new r(r108));
        r108.setInputText("");
        Context r125 = r108.getContext();
        if ((r125 instanceof FragmentActivity) == false) goto L33;
        FragmentActivity r126 = (FragmentActivity) r125;
    L34:
        if (r126 == null) goto L36;
        int r127 = com.larus.utils.u.b(r126);
    L37:
        Context r128 = r108.getContext();
        if ((r128 instanceof FragmentActivity) == false) goto L40;
        FragmentActivity r129 = (FragmentActivity) r128;
    L41:
        if (r129 == null) goto L59;
        int r130 = com.larus.utils.u.c(r129);
        if (r130 != 0) goto L45;
    L47:
        if (r127 == 0) goto L59;
        ViewGroup.LayoutParams r131 = r108.f373547a.f373232d.getLayoutParams();
        if ((r131 instanceof ViewGroup.MarginLayoutParams) == false) goto L51;
        r101 = (ViewGroup.MarginLayoutParams) r131;
    L51:
        if (r101 == null) goto L53;
        r106 = r101.bottomMargin;
    L53:
        if (r106 == r127) goto L59;
        ConstraintLayout r132 = r108.f373547a.f373232d;
        ViewGroup.LayoutParams r133 = r132.getLayoutParams();
        if (r133 == null) goto L58;
        ViewGroup.MarginLayoutParams r134 = (ViewGroup.MarginLayoutParams) r133;
        r134.bottomMargin = r127;
        r132.setLayoutParams(r134);
        goto L59
    L58:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L45:
        if (r108.f373547a.f373235g.getPaddingTop() == r130) goto L47;
        FrameLayout r135 = r108.f373547a.f373235g;
        r135.setPadding(r135.getPaddingLeft(), r130, r135.getPaddingRight(), r135.getPaddingBottom());
    L59:
        this.f373576q = r108;
        if (r104 == null) goto L62;
        r104.addView(r108, r119);
        return;
    L62:
        if (r105 == null) goto L66;
        r105.addContentView(r108, r119);
        return;
    L66:
        return;
    L40:
        r129 = null;
        goto L41
    L36:
        r127 = 0;
        goto L37
    L33:
        r126 = null;
        goto L34
    L18:
        if (r112.w() != true) goto L20;
        r113 = true;
    L23:
        r114 = false;
        goto L24
    L5:
        r103 = null;
        goto L6
    }
}
