package com.larus.common.venue.impl.venue.component;

import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.router.SmartRouter;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.o0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.larus.bmhome.chat.component.bottom.core.h9;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.bmhome.chat.component.fastsend.e0;
import com.larus.bmhome.chat.d4;
import com.larus.bmhome.chat.j4;
import com.larus.btm.api.IBTMService;
import com.larus.common.apphost.AppHost;
import com.larus.common.venue.api.AssistantBizScene;
import com.larus.common.venue.impl.venue.api.JumpSomewherePocket;
import com.larus.common.venue.impl.venue.api.Pocket;
import com.larus.nova.R;
import com.larus.platform.model.action.SuggestedActionScene;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import v19.c7;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\b\u0018\u0000 \u0085\u00012\u00020\u00012\u00020\u0002:\u0002\u0085\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010V\u001a\u00020WH\u0016J\u0010\u0010X\u001a\u00020W2\u0006\u0010Y\u001a\u00020UH\u0017J$\u0010Z\u001a\u001e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020]0[j\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020]`^H\u0002J\f\u0010_\u001a\u00020G*\u00020`H\u0002J\f\u0010a\u001a\u00020G*\u00020`H\u0002J\f\u0010b\u001a\u00020W*\u00020`H\u0002J\b\u0010c\u001a\u00020WH\u0016J\b\u0010d\u001a\u00020WH\u0002J\b\u0010e\u001a\u00020WH\u0002J\b\u0010f\u001a\u00020WH\u0016J\b\u0010g\u001a\u00020WH\u0016J\b\u0010h\u001a\u00020WH\u0016J\b\u0010i\u001a\u00020GH\u0016J\u0010\u0010j\u001a\u00020W2\u0006\u0010k\u001a\u00020GH\u0016J\b\u0010l\u001a\u00020mH\u0016J0\u0010n\u001a\u00020W2\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020\\2\u0006\u0010t\u001a\u00020\\2\u0006\u0010u\u001a\u00020GH\u0002J\u0012\u0010v\u001a\u00020W2\b\b\u0002\u0010s\u001a\u00020\\H\u0002J.\u0010w\u001a\u00020W2\u0012\u0010x\u001a\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\\0y2\b\b\u0002\u0010t\u001a\u00020\\2\u0006\u0010u\u001a\u00020GH\u0002J*\u0010z\u001a\u00020W2\u0006\u0010{\u001a\u00020r2\b\b\u0002\u0010s\u001a\u00020\\2\u0006\u0010t\u001a\u00020\\2\u0006\u0010u\u001a\u00020GH\u0002J*\u0010|\u001a\u00020W2\b\u0010q\u001a\u0004\u0018\u00010r2\u0006\u0010s\u001a\u00020\\2\u0006\u0010t\u001a\u00020\\2\u0006\u0010u\u001a\u00020GH\u0016J.\u0010}\u001a\u0010\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\\\u0018\u00010~2\u0016\u0010\u007f\u001a\u0012\u0012\u0004\u0012\u00020\\\u0012\u0006\u0012\u0004\u0018\u00010]\u0018\u00010~H\u0002J#\u0010\u0080\u0001\u001a\u0004\u0018\u00010\\2\u0016\u0010\u007f\u001a\u0012\u0012\u0004\u0012\u00020\\\u0012\u0006\u0012\u0004\u0018\u00010]\u0018\u00010~H\u0002J$\u0010\u0081\u0001\u001a\u0004\u0018\u00010\\2\u0017\u0010\u0082\u0001\u001a\u0012\u0012\u0004\u0012\u00020\\\u0012\u0006\u0012\u0004\u0018\u00010]\u0018\u00010~H\u0002J\t\u0010\u0083\u0001\u001a\u00020WH\u0016J\t\u0010\u0084\u0001\u001a\u00020WH\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u001d\u0010$\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\n\u001a\u0004\b&\u0010'R\u001d\u0010)\u001a\u0004\u0018\u00010*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b+\u0010,R\u0016\u0010.\u001a\u0004\u0018\u00010/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u001d\u00102\u001a\u0004\u0018\u0001038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\n\u001a\u0004\b4\u00105R\u001d\u00107\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\n\u001a\u0004\b9\u0010:R\u001d\u0010<\u001a\u0004\u0018\u00010=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\n\u001a\u0004\b>\u0010?R\u001d\u0010A\u001a\u0004\u0018\u00010B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\n\u001a\u0004\bC\u0010DR\u000e\u0010F\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010J\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\n\u001a\u0004\bL\u0010MR\u001d\u0010O\u001a\u0004\u0018\u00010P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\n\u001a\u0004\bQ\u0010RR\u0010\u0010T\u001a\u0004\u0018\u00010UX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0086\u0001"}, d2 = {"Lcom/larus/common/venue/impl/venue/component/FlowCommonVenueInputComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/common/venue/impl/venue/ability/FlowCommonVenueInputAbility;", "<init>", "()V", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "flowCommonVenueLynxAbility", "Lcom/larus/common/venue/impl/venue/ability/FlowCommonVenueLynxAbility;", "getFlowCommonVenueLynxAbility", "()Lcom/larus/common/venue/impl/venue/ability/FlowCommonVenueLynxAbility;", "flowCommonVenueLynxAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "speakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "speakerAbility$delegate", "chatCameraAbility", "Lcom/larus/bmhome/camera/IChatCameraAbility;", "getChatCameraAbility", "()Lcom/larus/bmhome/camera/IChatCameraAbility;", "chatCameraAbility$delegate", "multimodalInputAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "getMultimodalInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "multimodalInputAbility$delegate", "bottomMenuAbility", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "getBottomMenuAbility", "()Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "suggestedActionAbility", "Lcom/larus/bmhome/chat/action/ISuggestedActionAbility;", "getSuggestedActionAbility", "()Lcom/larus/bmhome/chat/action/ISuggestedActionAbility;", "suggestedActionAbility$delegate", "fastSendImageAbility", "Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "getFastSendImageAbility", "()Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "fastSendImageAbility$delegate", "argumentData", "Lcom/larus/common/venue/impl/venue/launcher/FlowCommonVenueArgumentData;", "getArgumentData", "()Lcom/larus/common/venue/impl/venue/launcher/FlowCommonVenueArgumentData;", "argumentData$delegate", "inputVisibleStatus", "", "viewCreatedTimeMs", "", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "coreInputManager", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "getCoreInputManager", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "coreInputManager$delegate", "rootView", "Landroid/view/View;", "onAttach", "", "onViewCreated", "view", "buildCommonVenueCameraEventExt", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "interceptActionSendWhenSpeak", "Lcom/larus/bmhome/chat/component/bottom/core/InputView$Operator;", "interceptActionSend", "renderActionEntranceVisibility", "onResume", "toChatPage", "backToChatPage", "handleSendMessagePageEnd", "recoveryInputContainerVisibleStatus", "forceShowInputContainer", "isInputVisibleStatus", "setInputContainerVisible", "visible", "getBottomInset", "", "handleUploadInputPocketSendMessage", "pocket", "Lcom/larus/common/venue/impl/venue/api/Pocket;", "onSendParams", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "scene", "asrResult", "fromAsr", "handleTraceBeforeSendMessage", "appendCommonVenueMessageExt", "newExtMap", "", "sendMessage", "params", "handleSendMessageAndGoChatPage", "getMessageExtFromPocketDict", "", "originData", "getChatLiteOption", "dictToJson", "dict", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowCommonVenueInputComponent extends BaseContentWidget implements v09.a {
    public static final /* synthetic */ int B = 0;
    public View A;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f326488m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f326489n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f326490o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f326491p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f326492q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f326493r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f326494s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f326495t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f326496u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f326497v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f326498w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f326499x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f326500y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f326501z;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f326502a = null;

        static {
            int[] r100 = new int[SuggestedActionScene.values().length];
            r100[SuggestedActionScene.AttachmentAreaSingleImg.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[SuggestedActionScene.AttachmentAreaMultiImg.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f326502a = r100;
        }
    }

    public static final class c implements Function0<bc8.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f326503a;

        public c(AttachReceiver r100) {
            this.f326503a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [bc8.a, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final bc8.a invoke() {
            AttachReceiver r100 = this.f326503a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(bc8.a.class));
        }
    }

    public static final class d implements Function0<e0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f326504a;

        public d(AttachReceiver r100) {
            this.f326504a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.fastsend.e0, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final e0 invoke() {
            AttachReceiver r100 = this.f326504a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(e0.class));
        }
    }

    public static final class e implements Function0<ICoreInputAbility> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f326505a;

        public e(AttachReceiver r100) {
            this.f326505a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final ICoreInputAbility invoke() {
            AttachReceiver r100 = this.f326505a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(ICoreInputAbility.class));
        }
    }

    public static final class f implements Function0<va8.o> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f326506a;

        public f(AttachReceiver r100) {
            this.f326506a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.o] */
        @Override // kotlin.jvm.functions.Function0
        public final va8.o invoke() {
            AttachReceiver r100 = this.f326506a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.o.class));
        }
    }

    public static final class g implements Function0<com.larus.bmhome.chat.component.cvs.y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f326507a;

        public g(AttachReceiver r100) {
            this.f326507a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.cvs.y, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.chat.component.cvs.y invoke() {
            AttachReceiver r100 = this.f326507a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.cvs.y.class));
        }
    }

    public static final class h implements Function0<v09.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f326508a;

        public h(AttachReceiver r100) {
            this.f326508a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, v09.b] */
        @Override // kotlin.jvm.functions.Function0
        public final v09.b invoke() {
            AttachReceiver r100 = this.f326508a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(v09.b.class));
        }
    }

    public static final class i implements Function0<com.larus.bmhome.instruction.g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f326509a;

        public i(AttachReceiver r100) {
            this.f326509a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.instruction.g, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.instruction.g invoke() {
            AttachReceiver r100 = this.f326509a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.g.class));
        }
    }

    public static final class j implements Function0<com.larus.bmhome.chat.component.bottom.core.speaker.l> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f326510a;

        public j(AttachReceiver r100) {
            this.f326510a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.core.speaker.l, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.chat.component.bottom.core.speaker.l invoke() {
            AttachReceiver r100 = this.f326510a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.core.speaker.l.class));
        }
    }

    public static final class k implements Function0<zb8.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f326511a;

        public k(AttachReceiver r100) {
            this.f326511a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, zb8.e] */
        @Override // kotlin.jvm.functions.Function0
        public final zb8.e invoke() {
            AttachReceiver r100 = this.f326511a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(zb8.e.class));
        }
    }

    public static final class l implements Function0<com.larus.bmhome.chat.component.bottom.multimodal.g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f326512a;

        public l(AttachReceiver r100) {
            this.f326512a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.multimodal.g, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.chat.component.bottom.multimodal.g invoke() {
            AttachReceiver r100 = this.f326512a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.multimodal.g.class));
        }
    }

    public static final class m implements Function0<g1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f326513a;

        public m(AttachReceiver r100) {
            this.f326513a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.attachment.g1, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final g1 invoke() {
            AttachReceiver r100 = this.f326513a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(g1.class));
        }
    }

    public static final class n implements Function0<x09.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f326514a;

        public n(AttachReceiver r100) {
            this.f326514a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.c, x09.a] */
        @Override // kotlin.jvm.functions.Function0
        public final x09.a invoke() {
            AttachReceiver r100 = this.f326514a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).g(Reflection.getOrCreateKotlinClass(x09.a.class));
        }
    }

    static {
    }

    public final v09.b B3() {
        return (v09.b) this.f326491p.getValue();
    }

    public final void H3() {
        com.larus.bmhome.chat.api.e0 r100 = AuthModelDelegate.f297134b.e().getValue();
        if (r100 == null) goto L7;
        LaunchInfo r101 = r100.f297186a;
        if (r101 == null) goto L7;
        String r102 = r101.W();
    L8:
        Bundle r103 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argBotId", r102)});
        com.bytedance.router.i r104 = SmartRouter.buildRoute(getContext(), "//flow/chat_page");
        r104.f267554c.putExtras(r103);
        r104.f267555d = R.anim.larus_router_slide_in_right;
        r104.f267556e = R.anim.larus_router_no_anim;
        r104.d();
        return;
    L7:
        r102 = null;
        goto L8
    }

    @Override // v09.a
    public final int K7() {
        View r100 = this.A;
        if (r100 == null) goto L5;
        View r101 = r100.findViewById(R.id.input);
    L7:
        if (r101 == null) goto L10;
        r101.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return (int) c7.d(Integer.valueOf(r101.getMeasuredHeight()));
    L10:
        return 0;
    L5:
        r101 = null;
        goto L7
    }

    public final HashMap<String, Object> Y2() {
        HashMap<String, Object> r100 = new HashMap();
        r100.put("chat_key", Long.valueOf(System.currentTimeMillis()));
        x09.a r101 = h3();
        if (r101 == null) goto L6;
        String r102 = r101.a();
        if (r102 == null) goto L6;
    L7:
        r100.put("action_bar_key", r102);
        v09.b r103 = B3();
        if (r103 == null) goto L17;
        String r104 = r103.nd();
        if (r104 == null) goto L17;
        if ((!StringsKt.isBlank(r104)) == true) goto L15;
        r104 = null;
    L15:
        if (r104 == null) goto L17;
        JSONObject r105 = new JSONObject();
        r105.put("common_venue_type", r104);
        Unit r106 = Unit.INSTANCE;
        r100.put("extra_params", r105);
    L17:
        return r100;
    L6:
        r102 = "";
        goto L7
    }

    public final x09.a h3() {
        return (x09.a) this.f326499x.getValue();
    }

    @Override // v09.a
    public final void h6() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L15
        FragmentActivity r101 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();     // Catch: Throwable -> L15
        if (r101 != null) goto L5;
        H3();     // Catch: Throwable -> L15
    L13:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
        return;
    L5:
        ComponentCallbacks2 r102 = AppHost.f326268a.a().a(r101, null);     // Catch: Throwable -> L15
        boolean r103 = r102 instanceof d4;     // Catch: Throwable -> L15
        if ((r102 instanceof j4) == true) goto L8;
    L10:
        if (r103 == false) goto L12;
        FragmentActivity r104 = s1a.a.getActivity(this);     // Catch: Throwable -> L15
        Intent r105 = new Intent();     // Catch: Throwable -> L15
        r105.putExtra("is_need_scroll_last", true);     // Catch: Throwable -> L15
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r104.setResult(-1, r105);     // Catch: Throwable -> L15
        s1a.a.getActivity(this).finish();     // Catch: Throwable -> L15
        goto L13
    L12:
        H3();     // Catch: Throwable -> L15
        goto L13
    L8:
        if (((j4) r102).s1() == false) goto L10;
        r103 = true;
    L15:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        IBTMService r100 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r100 == null) goto L6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r100.f(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        com.larus.bmhome.chat.component.bottom.core.speaker.l r100 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.f326493r.getValue();
        if (r100 == null) goto L5;
        r100.b3(new com.larus.common.venue.impl.venue.component.b(this));
    L5:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r101 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.f326493r.getValue();
        if (r101 == null) goto L9;
        r101.KH(new com.larus.common.venue.impl.venue.component.c(this));
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onStop() {
        AudioServiceDelegate r100 = AudioServiceDelegate.f288288a;
        o0.a.a(r100.h0(), null, null, null, null, null, null, null, 112);
        r100.h0().b();
        r100.h0().f();
    }

    public final ICoreInputAbility p3() {
        return (ICoreInputAbility) this.f326488m.getValue();
    }

    @Override // v09.a
    public final void u9() {
        View r100 = this.A;
        if (r100 == null) goto L8;
        View r101 = r100.findViewById(R.id.input);
        if (r101 == null) goto L9;
        e1.x(r101);
        return;
    L9:
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, v09.a.class);
    }

    public final z8 z3() {
        return (z8) this.f326501z.getValue();
    }

    public FlowCommonVenueInputComponent() {
        this.f326488m = LazyKt.lazy(new e(this));
        this.f326489n = LazyKt.lazy(new f(this));
        this.f326490o = LazyKt.lazy(new g(this));
        this.f326491p = LazyKt.lazy(new h(this));
        this.f326492q = LazyKt.lazy(new i(this));
        this.f326493r = LazyKt.lazy(new j(this));
        this.f326494s = LazyKt.lazy(new k(this));
        this.f326495t = LazyKt.lazy(new l(this));
        this.f326496u = LazyKt.lazy(new m(this));
        this.f326497v = LazyKt.lazy(new c(this));
        this.f326498w = LazyKt.lazy(new d(this));
        this.f326499x = LazyKt.lazy(new n(this));
        this.f326500y = LazyKt.lazy(new com.larus.common.venue.impl.venue.component.k());
        this.f326501z = LazyKt.lazy(new com.larus.common.venue.impl.venue.component.l(this));
    }

    public final f1 m3() {
        return (f1) s1a.d.a(this).getAbility(f1.class);
    }

    public final void C3(String r100) {
        com.larus.bmhome.chat.component.cvs.y r101 = (com.larus.bmhome.chat.component.cvs.y) this.f326490o.getValue();
        if (r101 == null) goto L47;
        wc9.e r102 = r101.h();
        if (r102 == null) goto L48;
        String r103 = r102.f559198a;
        IAIChatRenderTraceService.Companion r104 = IAIChatRenderTraceService.f365896a;
        Map<String, String> r105 = r104.d(r103);
        v09.b r106 = B3();
        String r107 = "";
        if (r106 == null) goto L14;
        ClickPocketInfo r108 = r106.Ka();
        if (r108 == null) goto L14;
        Pocket r109 = r108.getPocket();
        if (r109 == null) goto L14;
        String r110 = r109.getPocketId();
        if (r110 == null) goto L14;
    L15:
        if (r105 == null) goto L18;
        Map<String, String> r111 = MapsKt.toMutableMap(r105);
        if (r111 == null) goto L18;
    L19:
        r111.put("common_venue_guide_card_id", r110);
        if ((!StringsKt.isBlank(r110)) == false) goto L22;
        r111.put("is_common_venue_guide", "1");
    L22:
        v09.b r112 = B3();
        if (r112 == null) goto L28;
        String r113 = r112.nd();
        if (r113 == null) goto L28;
        r107 = r113;
    L28:
        r111.put("common_venue_type", r107);
        x09.a r114 = h3();
        String r115 = null;
        if (r114 == null) goto L31;
        String r116 = r114.a();
    L32:
        r111.put("action_bar_key", r116);
        x09.a r117 = h3();
        if (r117 == null) goto L35;
        String r118 = r117.c();
    L36:
        r111.put("enter_method", r118);
        x09.a r119 = h3();
        if (r119 == null) goto L40;
        r115 = r119.a();
    L40:
        if (com.larus.utils.o0.d(r115) == false) goto L43;
        r111.put("must_override_action_bar_key", "1");
    L43:
        if (com.larus.utils.o0.d(r100) == false) goto L45;
        r111.put("must_override_scene", "1");
    L45:
        r111.put("scene", r100);
        r104.c(r103, r111);
        return;
    L35:
        r118 = null;
        goto L36
    L31:
        r116 = null;
    L18:
        r111 = new LinkedHashMap();
    L14:
        r110 = "";
        goto L15
    L48:
        return;
    }

    public final boolean D3(g9.c r100) {
        E3(r100);
        v09.b r101 = B3();
        String r102 = null;
        if (r101 == null) goto L5;
        ClickPocketInfo r103 = r101.Ka();
    L7:
        if (r103 == null) goto L71;
        v09.b r104 = B3();
        if (r104 == null) goto L13;
        ClickPocketInfo r105 = r104.Ka();
        if (r105 == null) goto L13;
        Pocket r106 = r105.getPocket();
    L14:
        if (r106 == null) goto L72;
        v09.b r107 = B3();
        if (r107 == null) goto L27;
        ClickPocketInfo r108 = r107.Ka();
        if (r108 == null) goto L27;
        Pocket r109 = r108.getPocket();
        if (r109 == null) goto L27;
        Integer r110 = r109.getPocketType();
        if (r110 == null) goto L27;
        if (r110.intValue() != 1) goto L27;
        boolean r111 = true;
    L28:
        if (r111 == true) goto L73;
        v09.b r112 = B3();
        if (r112 == null) goto L41;
        ClickPocketInfo r113 = r112.Ka();
        if (r113 == null) goto L41;
        Pocket r114 = r113.getPocket();
        if (r114 == null) goto L41;
        Integer r115 = r114.getPocketType();
        if (r115 == null) goto L41;
        if (r115.intValue() != 4) goto L41;
        boolean r116 = true;
    L42:
        if (r116 == false) goto L55;
        v09.b r117 = B3();
        if (r117 == null) goto L52;
        ClickPocketInfo r118 = r117.Ka();
        if (r118 == null) goto L52;
        Pocket r119 = r118.getPocket();
        if (r119 == null) goto L52;
        JumpSomewherePocket r120 = r119.getJumpSomewherePocket();
        if (r120 == null) goto L52;
        String r121 = r120.getJumpSchemaUrl();
    L54:
        if (com.larus.utils.o0.d(r121) == false) goto L55;
        return false;
    L52:
        r121 = null;
    L55:
        h9 r122 = r100.h();
        r122.a(1.0f);
        r122.b(true);
        r122.e(true);
        va8.o r123 = (va8.o) this.f326489n.getValue();
        if (r123 == null) goto L59;
        r102 = r123.u7();
    L59:
        if (com.larus.utils.o0.d(r102) == false) goto L68;
        ICoreInputAbility r124 = p3();
        if (r124 != null) goto L63;
    L65:
        boolean r125 = false;
    L66:
        if (r125 == true) goto L68;
        r100.i().e(false);
    L69:
        r100.e().e(false);
        r100.d().e(false);
        r100.g().e(false);
        r100.f().e(false);
        r100.k().d(4);
        r100.j().e(true);
        return true;
    L63:
        if (r124.l6() != true) goto L65;
        r125 = true;
    L68:
        h9 r126 = r100.i();
        r126.a(1.0f);
        r126.b(true);
        r126.e(true);
    L41:
        r116 = false;
        goto L42
    L73:
        return false;
    L27:
        r111 = false;
        goto L28
    L72:
        return false;
    L13:
        r106 = null;
        goto L14
    L71:
        return false;
    L5:
        r103 = null;
        goto L7
    }

    public final void E3(g9.c r100) {
        boolean r101 = false;
        r100.c().e(false);
        r100.b().c(v19.c.b(R.attr.larus_icon_chat_action_camera, getContext(), R.drawable.larus_icon_chat_action_camera));
        h9 r102 = r100.a();
        va8.o r103 = (va8.o) this.f326489n.getValue();
        if (r103 == null) goto L5;
        String r104 = r103.u7();
    L7:
        if (r104 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        if (r105 == true) goto L21;
        ICoreInputAbility r106 = p3();
        if (r106 != null) goto L17;
    L19:
        boolean r107 = false;
    L20:
        if (r107 == true) goto L21;
    L22:
        r102.e(r101);
        return;
    L17:
        if (r106.J8() != true) goto L19;
        r107 = true;
    L21:
        r101 = true;
        goto L22
    L9:
        if (r104.length() == 0) goto L12;
        r105 = false;
        goto L13
    L5:
        r104 = null;
        goto L7
    }

    @Override // v09.a
    public final void T9(boolean r100) {
        if (r100 == false) goto L9;
        View r101 = this.A;
        if (r101 == null) goto L15;
        View r102 = r101.findViewById(R.id.input);
        if (r102 == null) goto L16;
        e1.x(r102);
        return;
    L16:
        return;
    L15:
        return;
    L9:
        View r103 = this.A;
        if (r103 == null) goto L18;
        View r104 = r103.findViewById(R.id.input);
        if (r104 == null) goto L19;
        e1.o(r104);
        return;
    L19:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.larus.common.venue.impl.venue.component.g] */
    /* JADX WARN: Type inference failed for: r3v9, types: [com.larus.common.venue.impl.venue.component.f] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.larus.common.venue.impl.venue.component.d] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.common.venue.impl.venue.component.e] */
    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r110) {
        Intrinsics.checkNotNullParameter(r110, "view");
        this.A = r110;
        if (r110 == null) goto L7;
        View r100 = r110.findViewById(R.id.input);
        if (r100 == null) goto L7;
        r100.setBackgroundColor(0);
    L7:
        View r101 = this.A;
        if (r101 == null) goto L12;
        View r102 = r101.findViewById(R.id.input_delegate);
        if (r102 == null) goto L12;
        r102.setBackgroundColor(0);
    L12:
        ICoreInputAbility r103 = p3();
        if (r103 == null) goto L15;
        r103.tr(new com.larus.common.venue.impl.venue.component.a(this));
    L15:
        f1 r104 = m3();
        if (r104 == null) goto L18;
        r104.HN();
    L18:
        f1 r105 = m3();
        if (r105 == null) goto L21;
        r105.TA();
    L21:
        com.larus.bmhome.chat.component.bottom.multimodal.g r106 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.f326495t.getValue();
        if (r106 == null) goto L24;
        r106.Xc(Boolean.FALSE);
    L24:
        com.larus.bmhome.chat.component.bottom.multimodal.g r107 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.f326495t.getValue();
        if (r107 == null) goto L27;
        r107.bh(true);
    L27:
        com.larus.bmhome.chat.component.bottom.multimodal.g r108 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.f326495t.getValue();
        if (r108 == null) goto L30;
        r108.M6();
    L30:
        x09.a r109 = h3();
        if (r109 == null) goto L33;
        Integer r111 = r109.b();
    L34:
        AssistantBizScene r112 = AssistantBizScene.EcomPrePurchase;
        int r113 = r112.getValue();
        if (r111 != null) goto L38;
    L40:
        int r114 = AssistantBizScene.Travel.getValue();
        if (r111 != null) goto L44;
    L46:
        final String r115 = "ecom_page";
    L47:
        f1 r116 = m3();
        if (r116 == 0) goto L50;
        r116.B50(new com.larus.common.venue.impl.venue.component.d(this, r115));
    L50:
        f1 r117 = m3();
        if (r117 == null) goto L53;
        r117.g20();
    L53:
        z8 r118 = z3();
        if (r118 == null) goto L56;
        r118.z9(false);
    L56:
        z8 r119 = z3();
        if (r119 == null) goto L59;
        r119.R8();
    L59:
        z8 r120 = z3();
        if (r120 == null) goto L62;
        r120.s9();
    L62:
        z8 r121 = z3();
        if (r121 == null) goto L65;
        r121.f9(true);
    L65:
        z8 r122 = z3();
        if (r122 == null) goto L68;
        r122.X8();
    L68:
        z8 r123 = z3();
        if (r123 == null) goto L71;
        r123.n9(true);
    L71:
        z8 r124 = z3();
        if (r124 == null) goto L74;
        r124.S8(true);
    L74:
        z8 r125 = z3();
        int r126 = 2;
        if (r125 == null) goto L77;
        r125.W8(new z8.c(new com.larus.common.venue.impl.venue.component.e(this, r115), r126));
    L77:
        g1 r127 = (g1) this.f326496u.getValue();
        if (r127 == null) goto L80;
        r127.yj();
    L80:
        int r128 = r112.getValue();
        if (r111 != null) goto L84;
    L88:
        bc8.a r129 = (bc8.a) this.f326497v.getValue();
        if (r129 == 0) goto L91;
        r129.Gh(new com.larus.common.venue.impl.venue.component.g(this));
    L91:
        e0 r130 = (e0) this.f326498w.getValue();
        if (r130 == null) goto L94;
        r130.qD();
    L94:
        va8.o r131 = (va8.o) this.f326489n.getValue();
        if (r131 == null) goto L97;
        r131.C40(ContextCompat.getColor(r110.getContext(), R.color.larus_neutral_100_day));
    L97:
        z8 r132 = z3();
        if (r132 == null) goto L100;
        r132.y9(1, new g9.a(new com.larus.common.venue.impl.venue.component.h(this)));
    L100:
        z8 r133 = z3();
        if (r133 == null) goto L103;
        r133.y9(2, new g9.a(new com.larus.common.venue.impl.venue.component.i(this)));
    L103:
        z8 r134 = z3();
        if (r134 == null) goto L106;
        r134.y9(3, new g9.a(new com.larus.common.venue.impl.venue.component.j(this)));
    L106:
        View r135 = r110.findViewById(R.id.action_bar_container);
        if (r135 == null) goto L113;
        ViewGroup.LayoutParams r136 = r135.getLayoutParams();
        if (r136 == null) goto L112;
        r136.height = 0;
        r135.setLayoutParams(r136);
        goto L113
    L112:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L113:
        zb8.e r137 = (zb8.e) this.f326494s.getValue();
        if (r137 == null) goto L116;
        r137.y80();
    L116:
        ICoreInputAbility r138 = p3();
        if (r138 == null) goto L122;
        g9.c r139 = r138.q20();
        if (r139 == null) goto L122;
        E3(r139);
    L122:
        if (Intrinsics.areEqual(r115, "ecom_page") == false) goto L126;
        IBTMService r140 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r140 == null) goto L126;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r140.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), "a35794.b106421");
    L126:
        System.currentTimeMillis();
        return;
    L84:
        if (r111.intValue() != r128) goto L88;
        g1 r141 = (g1) this.f326496u.getValue();
        if (r141 == 0) goto L88;
        r141.nJ(new com.larus.common.venue.impl.venue.component.f());
        goto L88
    L44:
        if (r111.intValue() != r114) goto L46;
        r115 = "travel_page";
        goto L47
    L38:
        if (r111.intValue() != r113) goto L40;
    L33:
        r111 = null;
        goto L34
    }

    @Override // v09.a
    public final void C7(ICoreInputAbility.OnSendParams r110, String r111, String r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r111, "scene");
        Intrinsics.checkNotNullParameter(r112, "asrResult");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new FlowCommonVenueInputComponent$handleSendMessageAndGoChatPage$1(r110, this, r111, r112, r113, null), 2, null);
    }

    public final void G3(ICoreInputAbility.OnSendParams r310, String r410, String r411, boolean r412) {
        C3(r410);
        LinkedHashMap r100 = new LinkedHashMap();
        Map<String, String> r101 = r310.messageExt;
        if (r101 == null) goto L7;
        boolean r102 = true;
        if ((!r101.isEmpty()) != true) goto L7;
    L8:
        if (r102 == false) goto L10;
        r100.putAll(r101);
    L10:
        r100.putAll(new LinkedHashMap());
        ICoreInputAbility.OnSendParams r103 = ICoreInputAbility.OnSendParams.copy$default(r310, null, null, null, null, null, null, null, null, 0, false, null, false, false, false, null, null, null, null, false, null, r100, null, null, null, null, null, null, null, null, null, null, null, null, -1048577, 1, null);
        ICoreInputAbility r104 = p3();
        if (r104 == null) goto L13;
        r104.E0(r103);
    L13:
        v09.b r105 = B3();
        if (r105 == null) goto L16;
        r105.K9();
    L16:
        h6();
        return;
    L7:
        r102 = false;
        goto L8
    }
}
