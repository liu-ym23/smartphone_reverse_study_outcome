package com.larus.bmhome.chat.component.receive;

import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.gson.Gson;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalDowngradeData;
import com.larus.bmhome.chat.component.bottom.p1;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.input.ChatInputService;
import com.larus.bmhome.chat.model.ImportedImageRouteMode;
import com.larus.bmhome.chat.model.ImportedImageRouteParam;
import com.larus.bmhome.chat.model.j1;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.bmhome.utils.ReferenceMessage;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.nova.R;
import com.larus.platform.api.FlowDriveFileSendInfo;
import com.larus.platform.api.IFlowDriveSdkService;
import com.larus.platform.api.fileselect.DriveUplinkInfo;
import com.larus.platform.model.action.DirectSendData;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import com.larus.platform.service.FlowDriveSdkService;
import com.larus.platform.service.i2;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.SafeExtKt;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.ttm.player.MediaPlayer;
import hq9.j4;
import hq9.w4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import tx9.x0;
import yc9.v0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u008c\u00012\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0002\u008c\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010O\u001a\u0004\u0018\u00010PH\u0002J\b\u0010Q\u001a\u00020RH\u0016J\b\u0010S\u001a\u00020RH\u0016J\b\u0010T\u001a\u00020RH\u0016J\b\u0010U\u001a\u00020RH\u0016J\b\u0010V\u001a\u00020RH\u0016J\b\u0010W\u001a\u00020XH\u0002J\b\u0010Y\u001a\u00020RH\u0002J\b\u0010Z\u001a\u00020RH\u0002J\b\u0010[\u001a\u00020XH\u0002J\b\u0010\\\u001a\u00020RH\u0002J$\u0010]\u001a\u00020R2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020`0_2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020R0bH\u0002J\u001e\u0010c\u001a\u00020`2\u0006\u0010d\u001a\u00020`2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020`0_H\u0002J\u0010\u0010e\u001a\u00020R2\u0006\u0010d\u001a\u00020`H\u0016JJ\u0010f\u001a\u00020R2\b\u0010g\u001a\u0004\u0018\u00010L2\b\u0010d\u001a\u0004\u0018\u00010`2\u000e\u0010h\u001a\n\u0012\u0004\u0012\u00020i\u0018\u00010_2\b\u0010j\u001a\u0004\u0018\u00010`2\b\u0010k\u001a\u0004\u0018\u00010`2\b\u0010l\u001a\u0004\u0018\u00010mH\u0016J\u0010\u0010n\u001a\u00020X2\u0006\u0010o\u001a\u00020`H\u0002J:\u0010e\u001a\u00020R2\u0006\u0010p\u001a\u00020`2\u0006\u0010q\u001a\u00020`2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010`2\b\b\u0002\u0010s\u001a\u00020X2\n\b\u0002\u0010t\u001a\u0004\u0018\u00010`H\u0002J\b\u0010u\u001a\u00020RH\u0002J.\u0010v\u001a\u00020R2\u000e\u0010w\u001a\n\u0012\u0004\u0012\u00020x\u0018\u00010_2\b\b\u0002\u0010y\u001a\u00020X2\n\b\u0002\u0010t\u001a\u0004\u0018\u00010`H\u0002J\u0010\u0010z\u001a\u00020R2\u0006\u0010{\u001a\u00020|H\u0002J\u0018\u0010}\u001a\u00020R2\u0006\u0010~\u001a\u00020x2\u0006\u0010{\u001a\u00020|H\u0002J\u0018\u0010\u007f\u001a\u00020R2\u0006\u0010~\u001a\u00020x2\u0006\u0010{\u001a\u00020|H\u0002J)\u0010\u0080\u0001\u001a\u00020R2\f\u0010w\u001a\b\u0012\u0004\u0012\u00020x0_2\u0006\u0010y\u001a\u00020X2\b\u0010t\u001a\u0004\u0018\u00010`H\u0002J\u0018\u0010\u0081\u0001\u001a\u00020R2\r\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020x0_H\u0002J\u0018\u0010\u0083\u0001\u001a\u00020R2\r\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020x0_H\u0002J\u0018\u0010\u0084\u0001\u001a\u00020X2\r\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020x0_H\u0002J\u001f\u0010\u0085\u0001\u001a\u00020X2\r\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020x0_H\u0082@¢\u0006\u0003\u0010\u0086\u0001J\t\u0010\u0087\u0001\u001a\u00020RH\u0016J\u001b\u0010\u0088\u0001\u001a\u00020R2\u0006\u0010g\u001a\u00020L2\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0002J\t\u0010\u008b\u0001\u001a\u00020RH\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u000b\u001a\u0004\b1\u00102R\u001d\u00104\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u000b\u001a\u0004\b6\u00107R\u001d\u00109\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u000b\u001a\u0004\b;\u0010<R\u001d\u0010>\u001a\u0004\u0018\u00010?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u000b\u001a\u0004\b@\u0010AR\u001d\u0010C\u001a\u0004\u0018\u00010D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u000b\u001a\u0004\bE\u0010FR\u000e\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010J\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008d\u0001"}, d2 = {"Lcom/larus/bmhome/chat/component/receive/ChatReceiveServiceComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "Lcom/larus/bmhome/chat/component/receive/IChatReceiveServiceAbility;", "<init>", "()V", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "fragmentAbility", "Lcom/larus/bmhome/chat/component/IChatFragmentAbility;", "getFragmentAbility", "()Lcom/larus/bmhome/chat/component/IChatFragmentAbility;", "fragmentAbility$delegate", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "listComponentAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getListComponentAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "listComponentAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "chatMessageAbility", "Lcom/larus/bmhome/chat/component/IChatMessageAbility;", "getChatMessageAbility", "()Lcom/larus/bmhome/chat/component/IChatMessageAbility;", "chatMessageAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "referenceMsgAbility", "Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "getReferenceMsgAbility", "()Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "referenceMsgAbility$delegate", "multimodalInputAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "getMultimodalInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "multimodalInputAbility$delegate", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "skillAbility", "Lcom/larus/bmhome/chat/component/skill/ISkillAbility;", "getSkillAbility", "()Lcom/larus/bmhome/chat/component/skill/ISkillAbility;", "skillAbility$delegate", "chatBottomAbility", "Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "getChatBottomAbility", "()Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "chatBottomAbility$delegate", "hasHandleAutoSend", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pendingAutoSendConversationListener", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility$ChangeListener;", "Lcom/larus/im/bean/conversation/Conversation;", "pendingAutoSendModeJob", "Lkotlinx/coroutines/Job;", "currentChatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "onAttach", "", WidgetCostModule.TYPE_ON_CREATE, "onParentViewCreated", WidgetCostModule.TYPE_ON_START, "handleAutoSendIfNeed", "shouldWaitForAutoSendContext", "", "observeConversationForPendingAutoSend", "clearPendingAutoSendConversationListener", "handleImportedImageRoute", "handleAutoSendText", "prepareAutoSendSkills", "skillIds", "", "", "onComplete", "Lkotlin/Function0;", "rewriteAutoSendText", "text", "autoSendText", "autoSendUploadedFileAndText", "conversation", "fileList", "Lcom/larus/platform/model/UploadedFileInfo;", "txtScene", "fromScene", "driveSendInfo", "Lcom/larus/platform/api/FlowDriveFileSendInfo;", "shouldDowngradeRouteQueryAutoSend", "key", "sendText", "scene", "referenceText", "forceDowngrade", "replacementToken", "handleAutoSendUris", "autoSendUris", "sendUris", "Landroid/net/Uri;", "replaceModeDraftAfterValidation", "routeImportedImage", "param", "Lcom/larus/bmhome/chat/model/ImportedImageRouteParam;", "routeImportedImageInner", "imageUri", "cacheImportedImageTrace", "autoSendUrisInner", "onPasteUris", "uris", "onPasteUrisInner", "checkDowngrade", "checkDowngradeOpt", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", LiveCommonConstants.REASON_ON_DEDTROY, "interruptAndSendDrive", "info", "Lcom/larus/platform/model/SendDriveFileInfo;", "handleSendDriveFile", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatReceiveServiceComponent extends ComponentFeature implements m0 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f301349x = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f301350h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f301351i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f301352j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f301353k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f301354l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f301355m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f301356n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f301357o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f301358p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f301359q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f301360r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f301361s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f301362t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final AtomicBoolean f301363u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public k0 f301364v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Job f301365w;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes25.dex */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f301366a = null;

        static {
            int[] r100 = new int[ImportedImageRouteMode.values().length];
            r100[ImportedImageRouteMode.Attachment.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ImportedImageRouteMode.DirectSend.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f301366a = r100;
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.bmhome.chat.component.receive.s] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.bmhome.chat.component.receive.t] */
    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void B2() {
        FLogger.f375446a.i("ChatReceiveServiceComponent", "onParentViewCreated");
        gd8.f r100 = Y2();
        if (r100 == null) goto L10;
        LarusPageChatBinding r101 = r100.e();
        if (r101 == null) goto L11;
        ChatConstraintLayout r102 = r101.f311085a;
        if (r102 == null) goto L12;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r102.setOnDragListener(new c(com.larus.ui.arch.component.internal.attach.a.b(this, this), new s(this), new t(this)));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final gd8.f Y2() {
        return (gd8.f) this.f301351i.getValue();
    }

    public final p1 cr() {
        return (p1) this.f301362t.getValue();
    }

    public final de8.c f1() {
        return (de8.c) this.f301350h.getValue();
    }

    public final com.larus.bmhome.chat.component.bottom.reference.a g5() {
        return (com.larus.bmhome.chat.component.bottom.reference.a) this.f301358p.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        FLogger.f375446a.i("ChatReceiveServiceComponent", WidgetCostModule.TYPE_ON_CREATE);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r100 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r100 == null) goto L21;
        String r101 = r100.getString("send_drive_file_info");
        if (r101 != null) goto L19;
        return;
    L19:
        j4 r102 = (j4) new Gson().fromJson(r101, j4.class);     // Catch: Exception -> L18
        com.larus.bmhome.chat.component.cvs.y r103 = u0();
        if (r103 == null) goto L11;
        wc9.e r104 = r103.h();
    L12:
        if (r104 != null) goto L16;
        i0 r105 = new i0(this, r102);
        com.larus.bmhome.chat.component.cvs.y r106 = u0();
        if (r106 == null) goto L23;
        com.larus.bmhome.chat.component.cvs.y.b.b(r106, r105);
        return;
    L23:
        return;
    L16:
        Intrinsics.checkNotNull(r102);
        h3(r104, r102);
        return;
    L11:
        r104 = null;
    L25:
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        k0 r100 = this.f301364v;
        if (r100 == null) goto L7;
        com.larus.bmhome.chat.component.cvs.y r101 = u0();
        if (r101 == null) goto L7;
        r101.lQ(r100);
    L7:
        this.f301364v = null;
        Job r102 = this.f301365w;
        if (r102 == null) goto L10;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L10:
        this.f301365w = null;
        FLogger.f375446a.i("ChatReceiveServiceComponent", LiveCommonConstants.REASON_ON_DEDTROY);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.bmhome.chat.component.receive.r] */
    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onStart() {
        va8.o r100 = (va8.o) this.f301355m.getValue();
        if (r100 == 0) goto L6;
        r100.CF(new r(this));
        return;
    }

    public final com.larus.bmhome.chat.component.cvs.y u0() {
        return (com.larus.bmhome.chat.component.cvs.y) this.f301352j.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, m0.class);
    }

    @Override // com.larus.bmhome.chat.component.receive.m0
    public final void yy() {
        if (this.f301363u.get() == false) goto L5;
        return;
    L5:
        z2 r100 = z2.f365865a;
        final String r101 = null;
        boolean r102 = false;
        String r103 = "auto_send_text";
        if (z2.c4() == true) goto L37;
        Bundle r104 = f1().f468086b;
        if (r104 == null) goto L10;
        String r105 = r104.getString("auto_send_text");
    L11:
        if (r105 != null) goto L13;
    L16:
        boolean r106 = true;
    L17:
        if (r106 == false) goto L19;
    L21:
        boolean r107 = false;
    L22:
        if (r107 == false) goto L159;
        com.larus.bmhome.chat.component.cvs.y r108 = u0();
        if (r108 == null) goto L28;
        wc9.e r109 = r108.h();
        if (r109 == null) goto L28;
        String r110 = r109.f559198a;
    L29:
        if (r110 != null) goto L31;
    L34:
        boolean r111 = true;
    L35:
        if (r111 == false) goto L159;
    L153:
        boolean r112 = true;
    L161:
        if (r112 == false) goto L198;
        com.larus.bmhome.chat.component.cvs.y r113 = u0();
        if (r113 != null) goto L166;
        return;
    L166:
        if (this.f301364v != null) goto L168;
        k0 r114 = new k0(this);
        this.f301364v = r114;
        com.larus.bmhome.chat.component.cvs.y.b.b(r113, r114);
        boolean r115 = true;
    L170:
        if (z2.c4() == true) goto L172;
    L176:
        FLogger.f375446a.i("ChatReceiveServiceComponent", "wait conversation and mode draft identity before handling external prefill");
        if (r115 == false) goto L269;
        wc9.e r116 = r113.h();
        if (r116 == null) goto L188;
        String r117 = r116.f559198a;
        if (r117 == null) goto L188;
        if (r117.length() <= 0) goto L185;
        boolean r118 = true;
    L186:
        if (r118 != true) goto L188;
        r102 = true;
        goto L188
    L185:
        r118 = false;
    L188:
        if (r102 == false) goto L270;
        gd8.f r119 = Y2();
        if (r119 == null) goto L271;
        LarusPageChatBinding r120 = r119.e();
        if (r120 == null) goto L272;
        ChatConstraintLayout r121 = r120.f311085a;
        if (r121 == null) goto L273;
        r121.post(new b0(this));
        return;
    L273:
        return;
    L272:
        return;
    L271:
        return;
    L270:
        return;
    L269:
        return;
    L172:
        if (this.f301365w != null) goto L176;
        com.larus.bmhome.chat.mode.e r122 = (com.larus.bmhome.chat.mode.e) s1a.d.a(this).getAbility(com.larus.bmhome.chat.mode.e.class);
        if (r122 == null) goto L176;
        Job r123 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, CoroutineStart.LAZY, new ChatReceiveServiceComponent$observeConversationForPendingAutoSend$modeJob$1(r122, this, null), 1, null);
        this.f301365w = r123;
        r123.start();
        goto L176
    L168:
        r115 = false;
        goto L170
    L198:
        if (this.f301363u.compareAndSet(false, true) == true) goto L200;
        return;
    L200:
        k0 r124 = this.f301364v;
        if (r124 == null) goto L205;
        com.larus.bmhome.chat.component.cvs.y r125 = u0();
        if (r125 == null) goto L205;
        r125.lQ(r124);
    L205:
        this.f301364v = null;
        Job r126 = this.f301365w;
        if (r126 == null) goto L208;
        Job.DefaultImpls.cancel$default(r126, null, 1, null);
    L208:
        this.f301365w = null;
        FLogger.f375446a.i("ChatReceiveServiceComponent", "handleAutoSendIfNeed");
        de8.c r127 = f1();
        Bundle r128 = r127.f468086b;
        if (r128 == null) goto L211;
        String r129 = r128.getString("imported_image_route_param");
    L212:
        Bundle r130 = r127.f468086b;
        if (r130 == null) goto L215;
        r130.remove("imported_image_route_param");
    L215:
        ImportedImageRouteParam.Companion.getClass();
        if (r129 != null) goto L218;
    L221:
        boolean r131 = true;
    L222:
        if (r131 == false) goto L267;
        final ImportedImageRouteParam r132 = null;
    L233:
        if (r132 == null) goto L243;
        gd8.f r133 = Y2();
        if (r133 == null) goto L242;
        LarusPageChatBinding r134 = r133.e();
        if (r134 == null) goto L242;
        ChatConstraintLayout r135 = r134.f311085a;
        if (r135 == null) goto L242;
        SafeExtKt.b(r135, new j(this, r132), 200);
    L242:
        r102 = true;
    L243:
        if (r102 == false) goto L245;
        return;
    L245:
        Bundle r136 = f1().f468086b;
        if (r136 == null) goto L248;
        final String r137 = r136.getString("entry_draft_replacement_token");
    L249:
        gd8.f r138 = Y2();
        if (r138 == null) goto L256;
        LarusPageChatBinding r139 = r138.e();
        if (r139 == null) goto L256;
        ChatConstraintLayout r140 = r139.f311085a;
        if (r140 == null) goto L256;
        SafeExtKt.b(r140, new v(this, r137), 200);
    L256:
        Bundle r141 = f1().f468086b;
        if (r141 == null) goto L259;
        r101 = r141.getString("entry_draft_replacement_token");
    L259:
        gd8.f r142 = Y2();
        if (r142 == null) goto L275;
        LarusPageChatBinding r143 = r142.e();
        if (r143 == null) goto L276;
        ChatConstraintLayout r144 = r143.f311085a;
        if (r144 == null) goto L277;
        SafeExtKt.b(r144, new u(this, r101), 200);
        return;
    L277:
        return;
    L276:
        return;
    L275:
        return;
    L248:
        r137 = null;
        goto L249
    L267:
        Result.Companion r145 = Result.Companion;     // Catch: Throwable -> L226
        Object r146 = Result.m9449constructorimpl((ImportedImageRouteParam) new Gson().fromJson(r129, ImportedImageRouteParam.class));     // Catch: Throwable -> L226
    L229:
        if (Result.m9455isFailureimpl(r146) == false) goto L231;
        r146 = null;
    L231:
        r132 = (ImportedImageRouteParam) r146;
    L226:
        th = move-exception;
        Result.Companion r147 = Result.Companion;
        r146 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L229
    L218:
        if (r129.length() == 0) goto L221;
        r131 = false;
        goto L222
    L211:
        r129 = null;
        goto L212
    L31:
        if (r110.length() == 0) goto L34;
        r111 = false;
    L28:
        r110 = null;
    L159:
        r112 = false;
        goto L161
    L19:
        if (z3("auto_send_text") == true) goto L21;
        r107 = true;
        goto L22
    L13:
        if (r105.length() == 0) goto L16;
        r106 = false;
        goto L17
    L10:
        r105 = null;
        goto L11
    L37:
        Bundle r148 = f1().f468086b;
        if (r148 == null) goto L40;
        String r149 = r148.getString("share_to_chat_text");
    L41:
        if (r149 != null) goto L43;
    L46:
        boolean r150 = true;
    L47:
        if (r150 == true) goto L49;
        r103 = "share_to_chat_text";
    L62:
        if (r103 == null) goto L64;
        boolean r151 = true;
    L65:
        if (r103 != null) goto L67;
    L69:
        boolean r152 = false;
    L71:
        if (z2.c4() == true) goto L73;
    L87:
        boolean r153 = false;
    L88:
        if (r151 == true) goto L91;
        if (r153 == false) goto L159;
    L91:
        com.larus.bmhome.chat.component.cvs.y r154 = u0();
        if (r154 == null) goto L96;
        wc9.e r155 = r154.h();
        if (r155 == null) goto L96;
        String r156 = r155.f559198a;
    L97:
        if (r156 != null) goto L99;
    L102:
        boolean r157 = true;
    L103:
        if (r157 == true) goto L153;
        if (r153 == false) goto L159;
        p1 r158 = cr();
        if (r158 == null) goto L110;
        j1 r159 = r158.Y3();
    L112:
        if ((r159 instanceof com.larus.bmhome.chat.model.n) == false) goto L114;
        com.larus.bmhome.chat.model.n r160 = (com.larus.bmhome.chat.model.n) r159;
    L115:
        if (r160 == null) goto L153;
        if (Intrinsics.areEqual(r160.f307539a, r156) == false) goto L153;
        if (ic8.n.s(r156) == false) goto L159;
        if (r160.f307547i == false) goto L159;
        com.larus.bmhome.chat.api.e0 r161 = AuthModelDelegate.f297134b.e().getValue();
        if (r161 == null) goto L128;
        Integer r162 = Integer.valueOf(r161.f297187b);
    L129:
        if (r162 != null) goto L131;
    L135:
        boolean r163 = false;
    L136:
        if (r163 == true) goto L138;
    L142:
        String r164 = r160.f307540b;
        if (r164 != null) goto L145;
    L148:
        boolean r165 = true;
    L149:
        if (r165 == true) goto L153;
        String r166 = r160.f307541c;
        if (r166 == null) goto L153;
        if (Intrinsics.areEqual(r166, "office") == false) goto L157;
        String r167 = "__mobile_new_session_mode_draft_office__";
    L158:
        r112 = !Intrinsics.areEqual(r164, r167);
        goto L161
    L157:
        r167 = "__mobile_new_session_mode_draft_chat__";
        goto L158
    L145:
        if (r164.length() == 0) goto L148;
        r165 = false;
        goto L149
    L138:
        if (com.larus.bmhome.chat.mode.b.a() != null) goto L142;
        String r168 = com.larus.bmhome.chat.model.n.D(r160, r156, "external_prefill_without_mode_config", "chat", true, false, null, 100);
        Bundle r169 = f1().f468086b;
        if (r169 == null) goto L159;
        r169.putString("entry_draft_replacement_token", r168);
        goto L159
    L131:
        if (r162.intValue() == 0) goto L135;
        if (r162.intValue() == 1) goto L135;
        r163 = true;
        goto L136
    L128:
        r162 = null;
        goto L129
    L114:
        r160 = null;
        goto L115
    L110:
        r159 = null;
        goto L112
    L99:
        if (r156.length() == 0) goto L102;
        r157 = false;
    L96:
        r156 = null;
        goto L97
    L73:
        if (f1().A() == false) goto L85;
        Bundle r170 = f1().f468086b;
        if (r170 == null) goto L77;
        String r171 = r170.getString("auto_send_uris");
    L78:
        if (r171 != null) goto L80;
    L83:
        boolean r172 = true;
    L84:
        if (r172 == true) goto L85;
    L86:
        r153 = true;
        goto L88
    L80:
        if (StringsKt.isBlank(r171) == true) goto L83;
        r172 = false;
        goto L84
    L77:
        r171 = null;
    L85:
        if (r152 == false) goto L87;
    L67:
        if (z3(r103) != true) goto L69;
        r152 = true;
        goto L71
    L64:
        r151 = false;
        goto L65
    L49:
        Bundle r173 = f1().f468086b;
        if (r173 == null) goto L52;
        String r174 = r173.getString("auto_send_text");
    L53:
        if (r174 != null) goto L55;
    L58:
        boolean r175 = true;
    L59:
        if (r175 == false) goto L62;
        r103 = null;
        goto L62
    L55:
        if (r174.length() == 0) goto L58;
        r175 = false;
        goto L59
    L52:
        r174 = null;
        goto L53
    L43:
        if (r149.length() == 0) goto L46;
        r150 = false;
        goto L47
    L40:
        r149 = null;
        goto L41
    }

    public ChatReceiveServiceComponent() {
        this.f301350h = LazyKt.lazy(new c0(this));
        this.f301351i = LazyKt.lazy(new g0(this));
        this.f301352j = LazyKt.lazy(new h0(this));
        this.f301353k = LazyKt.lazy(new k(this));
        this.f301354l = LazyKt.lazy(new l(this));
        this.f301355m = LazyKt.lazy(new m(this));
        this.f301356n = LazyKt.lazy(new n(this));
        this.f301357o = LazyKt.lazy(new o(this));
        this.f301358p = LazyKt.lazy(new p(this));
        this.f301359q = LazyKt.lazy(new q(this));
        this.f301360r = LazyKt.lazy(new d0(this));
        this.f301361s = LazyKt.lazy(new e0(this));
        this.f301362t = LazyKt.lazy(new f0(this));
        this.f301363u = new AtomicBoolean(false);
    }

    public static boolean X2(List r110) {
        MultimodalDowngradeData r100 = ChatInputService.f303327b.A6();
        boolean r101 = false;
        if (r100 == null) goto L10;
        Integer r102 = r100.getFileDowngrade();
        if (r102 == null) goto L10;
        if (r102.intValue() != 1) goto L10;
        boolean r103 = true;
    L11:
        String r104 = null;
        if (r103 == false) goto L48;
        List r105 = r110;
        if ((r105 instanceof Collection) == true) goto L16;
    L18:
        Iterator r106 = r105.iterator();
    L20:
        if (r106.hasNext() == false) goto L29;
        Uri r107 = (Uri) r106.next();
        ImFileUtil.f314899a.getClass();
        if (ImFileUtil.w(r107) == false) goto L24;
    L26:
        boolean r108 = false;
    L27:
        if (r108 == false) goto L20;
        boolean r109 = true;
    L30:
        if (r109 == false) goto L48;
        FLogger.f375446a.i("ChatReceiveServiceComponent", "fileDowngrade = 1, return");
        t19.s r111 = t19.s.f544207a;
        AppHost.Companion r112 = AppHost.f326268a;
        Application r113 = r112.getApplication();
        z2 r114 = z2.f365865a;
        FlowDowngradeToastConfig r115 = r114.getFlowDowngradeToastConfig();
        if (r115 == null) goto L34;
        String r116 = r115.getTrafficDegradationFeatureDisableCn();
    L35:
        if (r116 != null) goto L37;
    L38:
        r101 = true;
    L39:
        if (r101 == false) goto L42;
        String r117 = r112.getApplication().getString(R.string.larus_trafficDegradation_featureDisable_cn);
    L41:
        String r118 = r117;
        Intrinsics.checkNotNull(r118);
        t19.s.j(r111, r113, r118, null, false, 28);
        x0.a("atm_dg_file_dg");
        return true;
    L42:
        FlowDowngradeToastConfig r119 = r114.getFlowDowngradeToastConfig();
        if (r119 == null) goto L45;
        r104 = r119.getTrafficDegradationFeatureDisableCn();
    L45:
        r117 = String.valueOf(r104);
        goto L41
    L37:
        if (r116.length() != 0) goto L39;
    L34:
        r116 = null;
        goto L35
    L24:
        if (ImFileUtil.y(r107) == true) goto L26;
        r108 = true;
    L29:
        r109 = false;
        goto L30
    L16:
        if (r105.isEmpty() == false) goto L18;
    L48:
        if (r100 == null) goto L55;
        Integer r120 = r100.getVideoDowngrade();
        if (r120 == null) goto L55;
        if (r120.intValue() != 1) goto L55;
        boolean r121 = true;
    L56:
        if (r121 == false) goto L87;
        List r122 = r110;
        if ((r122 instanceof Collection) == true) goto L60;
    L62:
        Iterator r123 = r122.iterator();
    L64:
        if (r123.hasNext() == false) goto L68;
        Uri r124 = (Uri) r123.next();
        ImFileUtil.f314899a.getClass();
        if (ImFileUtil.y(r124) == false) goto L64;
        boolean r125 = true;
    L69:
        if (r125 == false) goto L87;
        FLogger.f375446a.i("ChatReceiveServiceComponent", "videoDowngrade = 1, return");
        t19.s r126 = t19.s.f544207a;
        AppHost.Companion r127 = AppHost.f326268a;
        Application r128 = r127.getApplication();
        z2 r129 = z2.f365865a;
        FlowDowngradeToastConfig r130 = r129.getFlowDowngradeToastConfig();
        if (r130 == null) goto L73;
        String r131 = r130.getTrafficDegradationFeatureDisableCn();
    L74:
        if (r131 != null) goto L76;
    L77:
        r101 = true;
    L78:
        if (r101 == false) goto L81;
        String r132 = r127.getApplication().getString(R.string.larus_trafficDegradation_featureDisable_cn);
    L80:
        String r133 = r132;
        Intrinsics.checkNotNull(r133);
        t19.s.j(r126, r128, r133, null, false, 28);
        x0.a("atm_dg_video_dg");
        return true;
    L81:
        FlowDowngradeToastConfig r134 = r129.getFlowDowngradeToastConfig();
        if (r134 == null) goto L84;
        r104 = r134.getTrafficDegradationFeatureDisableCn();
    L84:
        r132 = String.valueOf(r104);
        goto L80
    L76:
        if (r131.length() != 0) goto L78;
    L73:
        r131 = null;
    L68:
        r125 = false;
        goto L69
    L60:
        if (r122.isEmpty() == false) goto L62;
    L87:
        return false;
    L55:
        r121 = false;
    L10:
        r103 = false;
        goto L11
    }

    @Override // com.larus.bmhome.chat.component.receive.m0
    public final void KS(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        N2(this, r100, "router_auto_send");
    }

    public final void m3(List<? extends Uri> r110) {
        com.larus.bmhome.instruction.g r100 = (com.larus.bmhome.instruction.g) this.f301357o.getValue();
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        ICoreInputAbility r103 = (ICoreInputAbility) this.f301354l.getValue();
        if (r103 != null) goto L11;
    L13:
        boolean r104 = false;
    L15:
        if (r104 == true) goto L19;
        if (r102 == true) goto L19;
        FLogger.f375446a.i("ChatReceiveServiceComponent", "[onPasteUris] enableSendImageMenu is not true");
        return;
    L19:
        com.larus.bmhome.instruction.g r105 = (com.larus.bmhome.instruction.g) this.f301357o.getValue();
        if (r105 != null) goto L22;
    L24:
        boolean r106 = false;
    L25:
        if (r106 == false) goto L29;
        if (r102 == true) goto L29;
        FLogger.f375446a.i("ChatReceiveServiceComponent", "[onPasteUris] isInstructionOpen() is true, but no support image");
        return;
    L29:
        com.larus.bmhome.chat.component.bottom.reference.a r107 = g5();
        if (r107 != null) goto L32;
    L34:
        boolean r108 = false;
    L35:
        if (r108 == false) goto L45;
        com.larus.bmhome.chat.component.bottom.reference.a r109 = g5();
        if (r109 != null) goto L39;
    L41:
        boolean r111 = false;
    L42:
        if (r111 == true) goto L45;
        FLogger.f375446a.i("ChatReceiveServiceComponent", "[onPasteUris] hasReferenceMsg is true");
        return;
    L39:
        if (r109.LX() != true) goto L41;
        r111 = true;
    L45:
        ICoreInputAbility r112 = (ICoreInputAbility) this.f301354l.getValue();
        if (r112 == null) goto L48;
        Integer r113 = Integer.valueOf(r112.Rp());
    L49:
        if (r113 != null) goto L52;
    L53:
        if (r113 != null) goto L56;
    L58:
        FLogger.f375446a.i("ChatReceiveServiceComponent", "[onPasteUris] lastStatus() is not READY_TO_INPUT or READY_TO_SEND, which is = " + r113);
        return;
    L56:
        if (r113.intValue() != 3) goto L58;
    L59:
        com.larus.bmhome.chat.component.bottom.multimodal.g r114 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.f301359q.getValue();
        if (r114 == null) goto L75;
        List<? extends Uri> r115 = r110;
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
        Iterator<T> r117 = r115.iterator();
    L63:
        if (r117.hasNext() == false) goto L65;
        r116.add(new com.larus.bmhome.chat.component.bottom.multimodal.a.C4037a((Uri) r117.next(), null, 2));
        goto L63
    L65:
        g1 r118 = (g1) this.f301360r.getValue();
        if (r118 != null) goto L68;
    L70:
        r101 = false;
    L71:
        r114.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(r116, new com.larus.bmhome.chat.component.bottom.multimodal.g1(r101, MultimodalBizScene.ChatPasteUri, false), null, null, null, 28));
        return;
    L68:
        if (r118.mT() != true) goto L70;
    L75:
        return;
    L52:
        if (r113.intValue() == 1) goto L59;
    L48:
        r113 = null;
        goto L49
    L32:
        if (r107.i9() != true) goto L34;
        r108 = true;
        goto L35
    L22:
        if (r105.z0() != true) goto L24;
        r106 = true;
        goto L25
    L11:
        if (r103.Qd(false) != true) goto L13;
        r104 = true;
        goto L15
    L5:
        if (r100.HM() != true) goto L7;
        r102 = true;
        goto L8
    }

    public final boolean z3(String r100) {
        if (z2.f365865a.getRouterConfig().b() == true) goto L5;
    L7:
        return false;
    L5:
        if (f1().u(r100) == false) goto L7;
        return true;
    }

    public final void PR(List<String> r100, Function0<Unit> r101) {
        if (r100.isEmpty() == false) goto L6;
        r101.invoke();
        return;
    L6:
        be8.a r102 = (be8.a) this.f301361s.getValue();
        if (r102 != null) goto L10;
        FLogger.f375446a.i("ChatReceiveServiceComponent", "prepare auto send skills skipped, skill ability unavailable, requestedCount=" + r100.size());
        r101.invoke();
        return;
    L10:
        r102.PR(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h3(wc9.e r510, j4 r511) {
        String r100 = r510.f559198a;
        String r101 = "";
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        int r102 = 1;
        if (r100.length() <= 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L13;
        gd8.g r104 = (gd8.g) this.f301356n.getValue();
        if (r104 == null) goto L13;
        r104.mh(r100, "send_drive_file", OmniBreakReason.OmniBreakReason_SEND_NEW_MSG);
    L13:
        String r110 = r511.d();
        List<w4> r105 = r511.b();
        if (r105 == null) goto L16;
        List r106 = CollectionsKt.filterNotNull(r105);
    L17:
        String r107 = r511.c();
        FlowDriveFileSendInfo r108 = r511.a();
        List r109 = r106;
        if (r109 != null) goto L20;
    L23:
        boolean r111 = true;
    L24:
        if (r111 == true) goto L139;
        ArrayList r112 = new ArrayList();
        Iterator r113 = r106.iterator();
    L28:
        if (r113.hasNext() == false) goto L79;
        w4 r114 = (w4) r113.next();
        if (r114.d() != r102) goto L32;
        boolean r115 = true;
    L34:
        if (r114.d() != 2) goto L36;
        boolean r116 = true;
    L37:
        String r117 = r114.e() + System.currentTimeMillis();
        FlowDriveSdkService r118 = FlowDriveSdkService.f365704a;
        String r119 = r118.g(Long.valueOf(r114.a()), r114.b());
        DriveUplinkInfo r120 = new DriveUplinkInfo(r114.f(), r114.e(), r114.b(), r114.a(), r114.a(), "input_ai_space");
        LinkedHashMap r121 = new LinkedHashMap();
        Iterator r122 = r113;
        r121.put("drive_uplink_info", r120.toString());
        if (r119 == null) goto L40;
        String r123 = (String) r121.put("originFileTypeString", r119);
    L40:
        String r124 = r114.f();
        if (r124 != null) goto L43;
    L48:
        r121.put("upload_from", "drive");
        r121.put("upload_way", "input_ai_space");
        if (r115 == false) goto L51;
        UplinkEntityType r125 = UplinkEntityType.EntityTypeImage;
    L52:
        int r126 = r125.getValue();
        if (r115 == false) goto L55;
        String r310 = r101;
        UplinkEntityContent r210 = new UplinkEntityContent(null, new Image(r114.e(), null, r114.h(), r114.g(), null, null, r117, null, null, null, null, null, null, null, 16306, null), 1, null == true ? 1 : 0);
    L78:
        int r127 = FileParseState.SUCCESS.getValue();
        int r128 = FileReviewState.ACCESS.getValue();
        int r129 = UpLinkState.SUCCESS.getValue();
        r112.add(new UplinkFileEntity(Integer.valueOf(r126), r210, r117, null, Integer.valueOf(r128), Integer.valueOf(r127), 100, Integer.valueOf(r129), Boolean.FALSE, false, y0.j(r114.e()), null, null, r121, 6664, null));
        r113 = r122;
        r101 = r310;
        r102 = 1;
        goto L28
    L55:
        String r130 = r114.b();
        String r131 = r114.e();
        int r132 = r114.d();
        if (r132 != 2) goto L58;
        int r133 = FileType.FileTypeVideo.getValue();
    L62:
        Integer r134 = Integer.valueOf(r133);
        Long r135 = Long.valueOf(r114.c());
        String r136 = null;
        if (r116 == true) goto L65;
        r310 = r101;
        VideoExtension r211 = null;
    L77:
        Image r137 = null;
        r210 = new UplinkEntityContent(new UplinkFileInfo(r130, r131, null, r134, r135, r136, r211, null, null, null, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_FIND_STREAM_INFO_COST, null), r137, 2, null == true ? 1 : 0);
        goto L78
    L65:
        VideoExtension r138 = new VideoExtension(null, null, null, null, null, null, null, null, null, null, 1023, null);
        r310 = r101;
        r138.setVid(r114.e());
        r138.setDuration(Float.valueOf(r114.i()));
        String r139 = r114.e();
        if (r139 != null) goto L68;
        String r212 = r310;
    L70:
        if (r212.length() <= 0) goto L72;
        boolean r140 = true;
    L73:
        if (r140 == false) goto L75;
        String r213 = IFlowDriveSdkService.a.a(r118, LifecycleOwnerKt.getLifecycleScope(this), r212, 480, 480, null, 48);
    L76:
        r138.setCover(new Image(null, null, null, new ImageObj(r213, 0, 0, null, null, 30, null), null, null, null, null, null, null, null, null, null, null, 16375, null));
        Unit r141 = Unit.INSTANCE;
        r211 = r138;
        goto L77
    L75:
        r213 = null;
        goto L76
    L72:
        r140 = false;
        goto L73
    L68:
        r212 = r139;
        goto L70
    L58:
        if (r132 == 3) goto L60;
        r133 = FileType.FileTypeFile.getValue();
        goto L62
    L60:
        r133 = FileType.FileTypeAudio.getValue();
        goto L62
    L51:
        r125 = UplinkEntityType.EntityTypeFile;
        goto L52
    L43:
        if ((!StringsKt.isBlank(r124)) == true) goto L46;
        r124 = null;
    L46:
        if (r124 == null) goto L48;
        String r142 = (String) r121.put("originUrl", r124);
        goto L48
    L36:
        r116 = false;
        goto L37
    L32:
        r115 = false;
        goto L34
    L79:
        String r311 = r101;
        NestedFileContent r410 = new NestedFileContent(r112, null, false, null, 14, null);
        LinkedHashMap r143 = new LinkedHashMap();
        if (r108 == null) goto L83;
        r143.put("drive_media_send_override_current_page", "ai_space_detail");
    L83:
        if (Intrinsics.areEqual(r107, ObricActionBarTrackType.SPEAK) == false) goto L86;
        r143.put("drive_add_speak_duration", "1");
    L86:
        if ((!r143.isEmpty()) == false) goto L88;
        LinkedHashMap r144 = r143;
    L89:
        if (r108 == null) goto L107;
        JSONObject r145 = new JSONObject();
        String r146 = r108.getCollectionId();
        if (r146 == null) goto L93;
        r145.put("collection_id", r146);
    L93:
        String r147 = r108.getCollectionName();
        if (r147 == null) goto L96;
        r145.put("collection_name", r147);
    L96:
        String r148 = r108.getContentType();
        if (r148 == null) goto L99;
        r145.put("content_type", r148);
    L99:
        String r149 = r108.getContentSecType();
        if (r149 == null) goto L103;
        r145.put("content_sec_type", r149);
    L103:
        if (r145.length() <= 0) goto L105;
        Map r150 = MapsKt.mapOf(TuplesKt.to("drive_file_send_info", r145.toString()));
    L106:
        Map r151 = r150;
    L108:
        ArrayList r152 = new ArrayList();
        if (v0.h(r410) <= 0) goto L111;
        int r153 = wf9.b.f559489a;
        LinkedHashMap r411 = r144;
        Map r412 = r151;
        r152.add(new ai8.f(r410, com.flow.kmp.common.util.i.a(), null, null, r411, r412, false, null, (ChatPageContext) s1a.d.a(this).a(ChatPageContext.class), null, 716));
    L111:
        if (r110 != null) goto L113;
    L119:
        boolean r154 = false;
    L120:
        if (r154 == false) goto L123;
        int r155 = wf9.b.f559489a;
        r152.add(new ai8.h(r110, com.flow.kmp.common.util.i.a(), null, null, r144, r151, false, false, (ChatPageContext) s1a.d.a(this).a(ChatPageContext.class), null, 716));
    L123:
        if ((!r152.isEmpty()) == false) goto L137;
        u7 r156 = (u7) this.f301353k.getValue();
        if (r156 == null) goto L127;
        r156.TP(false);
    L127:
        gd8.g r157 = (gd8.g) this.f301356n.getValue();
        if (r157 == null) goto L138;
        if (r107 != null) goto L131;
        String r158 = r311;
    L132:
        gd8.g.a.a(r157, r510, r158, r152, r107, null, null, 48);
        return;
    L131:
        r158 = r107;
        goto L132
    L138:
        return;
    L137:
        return;
    L113:
        if (r110.length() <= 0) goto L115;
        boolean r159 = true;
    L117:
        if (r159 != true) goto L119;
        r154 = true;
        goto L120
    L115:
        r159 = false;
        goto L117
    L105:
        r150 = null;
        goto L106
    L107:
        r151 = null;
        goto L108
    L88:
        r144 = null;
        goto L89
    L139:
        return;
    L20:
        if (r109.isEmpty() == true) goto L23;
        r111 = false;
        goto L24
    L16:
        r106 = null;
        goto L17
    L8:
        r103 = false;
        goto L9
    }

    public final void p3(Uri r210, ImportedImageRouteParam r211) {
        if (r211.getMode() != ImportedImageRouteMode.DirectSend) goto L13;
        String r100 = r211.getText();
        if (r100 != null) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == false) goto L13;
        ImportedImageRouteMode r102 = ImportedImageRouteMode.Attachment;
    L16:
        Map<String, String> r110 = r211.toMultimodalEventExt();
        int r103 = b.f301366a[r102.ordinal()];
        LinkedHashMap r104 = null;
        if (r103 == 1) goto L54;
        if (r103 != 2) goto L53;
        List r105 = CollectionsKt.listOf(new com.larus.bmhome.chat.component.bottom.multimodal.a.C4037a(r210, null, 2));
        com.larus.bmhome.chat.component.bottom.multimodal.g1 r106 = new com.larus.bmhome.chat.component.bottom.multimodal.g1(false, MultimodalBizScene.ImportedImageRoute, false);
        String r111 = r211.getText();
        String r112 = r211.getEnterMethod();
        Map<String, String> r107 = r211.getMsgExt();
        if (r107 == null) goto L35;
        LinkedHashMap r108 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r109 = r107.entrySet().iterator();
    L23:
        if (r109.hasNext() == false) goto L30;
        Map.Entry<String, String> r113 = r109.next();
        if (r113.getValue() == null) goto L27;
        boolean r114 = true;
    L28:
        if (r114 == false) goto L23;
        r108.put(r113.getKey(), r113.getValue());
        goto L23
    L27:
        r114 = false;
        goto L28
    L30:
        LinkedHashMap r115 = new LinkedHashMap(MapsKt.mapCapacity(r108.size()));
        Iterator r116 = r108.entrySet().iterator();
    L32:
        if (r116.hasNext() == false) goto L34;
        Map.Entry r117 = (Map.Entry) r116.next();
        Object r118 = r117.getKey();
        Object r119 = r117.getValue();
        Intrinsics.checkNotNull(r119);
        r115.put(r118, (String) r119);
        goto L32
    L34:
        LinkedHashMap r120 = r115;
    L36:
        String r121 = r211.getSceneForText();
        Map<String, String> r122 = r211.getEventExt();
        if (r122 == null) goto L51;
        LinkedHashMap r123 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r124 = r122.entrySet().iterator();
    L40:
        if (r124.hasNext() == false) goto L47;
        Map.Entry<String, String> r125 = r124.next();
        if (r125.getValue() == null) goto L44;
        boolean r126 = true;
    L45:
        if (r126 == false) goto L40;
        r123.put(r125.getKey(), r125.getValue());
        goto L40
    L44:
        r126 = false;
        goto L45
    L47:
        r104 = new LinkedHashMap(MapsKt.mapCapacity(r123.size()));
        Iterator r127 = r123.entrySet().iterator();
    L49:
        if (r127.hasNext() == false) goto L51;
        Map.Entry r128 = (Map.Entry) r127.next();
        Object r129 = r128.getKey();
        Object r130 = r128.getValue();
        Intrinsics.checkNotNull(r130);
        r104.put(r129, (String) r130);
    L51:
        com.larus.bmhome.chat.component.bottom.multimodal.n r131 = new com.larus.bmhome.chat.component.bottom.multimodal.n(r105, r106, com.larus.bmhome.chat.component.bottom.multimodal.o.d(new DirectSendData(r111, r112, r120, r121, r104, null, false, 96, null)), r110, null, 16);
    L55:
        com.larus.bmhome.chat.component.bottom.multimodal.g r132 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.f301359q.getValue();
        if (r132 == null) goto L59;
        r132.gx(r131);
    L59:
        if (r102 != ImportedImageRouteMode.Attachment) goto L79;
        ICoreInputAbility r133 = (ICoreInputAbility) this.f301354l.getValue();
        if (r133 == null) goto L63;
        r133.g2(1, true);
    L63:
        va8.o r134 = (va8.o) this.f301355m.getValue();
        if (r134 == null) goto L80;
        r134.E40();
        return;
    L80:
        return;
    L79:
        return;
    L35:
        r120 = null;
        goto L36
    L53:
        throw new NoWhenBranchMatchedException();
    L54:
        r131 = new com.larus.bmhome.chat.component.bottom.multimodal.n(CollectionsKt.listOf(new com.larus.bmhome.chat.component.bottom.multimodal.a.C4037a(r210, null, 2)), new com.larus.bmhome.chat.component.bottom.multimodal.g1(true, MultimodalBizScene.ImportedImageRoute, false), null, r110, null, 20);
        goto L55
    L7:
        if (StringsKt.isBlank(r100) == true) goto L10;
        r101 = false;
    L13:
        r102 = r211.getMode();
        if (r102 != null) goto L16;
        r102 = ImportedImageRouteMode.Attachment;
        goto L16
    }

    public static final Object F2(ChatReceiveServiceComponent r110, List r111, Continuation r210) {
        List r100 = r111;
        r110.getClass();
        if ((r210 instanceof ChatReceiveServiceComponent$checkDowngradeOpt$1) == false) goto L7;
        ChatReceiveServiceComponent$checkDowngradeOpt$1 r101 = (ChatReceiveServiceComponent$checkDowngradeOpt$1) r210;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = false;
        String r112 = null;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r103);
    L60:
        if (((Boolean) r103).booleanValue() == false) goto L78;
        FLogger.f375446a.i("ChatReceiveServiceComponent", "videoDowngrade = 1, return");
        t19.s r113 = t19.s.f544207a;
        AppHost.Companion r107 = AppHost.f326268a;
        Application r114 = r107.getApplication();
        z2 r108 = z2.f365865a;
        FlowDowngradeToastConfig r109 = r108.getFlowDowngradeToastConfig();
        if (r109 == null) goto L64;
        String r115 = r109.getTrafficDegradationFeatureDisableCn();
    L65:
        if (r115 != null) goto L67;
    L68:
        r106 = true;
    L69:
        if (r106 == false) goto L72;
        String r116 = r107.getApplication().getString(R.string.larus_trafficDegradation_featureDisable_cn);
    L71:
        String r117 = r116;
        Intrinsics.checkNotNull(r117);
        t19.s.j(r113, r114, r117, null, false, 28);
        x0.a("atm_dg_video_dg");
        return Boxing.boxBoolean(true);
    L72:
        FlowDowngradeToastConfig r118 = r108.getFlowDowngradeToastConfig();
        if (r118 == null) goto L75;
        r112 = r118.getTrafficDegradationFeatureDisableCn();
    L75:
        r116 = String.valueOf(r112);
        goto L71
    L67:
        if (r115.length() != 0) goto L69;
    L64:
        r115 = null;
    L78:
        return Boxing.boxBoolean(false);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        MultimodalDowngradeData r119 = (MultimodalDowngradeData) r101.L$1;
        List r120 = (List) r101.L$0;
        ResultKt.throwOnFailure(r103);
        MultimodalDowngradeData r121 = r119;
        r100 = r120;
        Object r122 = r103;
    L30:
        if (((Boolean) r122).booleanValue() == false) goto L47;
        FLogger.f375446a.i("ChatReceiveServiceComponent", "fileDowngrade = 1, return");
        t19.s r123 = t19.s.f544207a;
        AppHost.Companion r124 = AppHost.f326268a;
        Application r125 = r124.getApplication();
        z2 r126 = z2.f365865a;
        FlowDowngradeToastConfig r127 = r126.getFlowDowngradeToastConfig();
        if (r127 == null) goto L34;
        String r128 = r127.getTrafficDegradationFeatureDisableCn();
    L35:
        if (r128 != null) goto L37;
    L38:
        r106 = true;
    L39:
        if (r106 == false) goto L42;
        String r129 = r124.getApplication().getString(R.string.larus_trafficDegradation_featureDisable_cn);
    L41:
        String r130 = r129;
        Intrinsics.checkNotNull(r130);
        t19.s.j(r123, r125, r130, null, false, 28);
        x0.a("atm_dg_file_dg");
        return Boxing.boxBoolean(true);
    L42:
        FlowDowngradeToastConfig r131 = r126.getFlowDowngradeToastConfig();
        if (r131 == null) goto L45;
        r112 = r131.getTrafficDegradationFeatureDisableCn();
    L45:
        r129 = String.valueOf(r112);
        goto L41
    L37:
        if (r128.length() != 0) goto L39;
    L34:
        r128 = null;
    L47:
        if (r121 == null) goto L54;
        Integer r132 = r121.getVideoDowngrade();
        if (r132 == null) goto L54;
        if (r132.intValue() != 1) goto L54;
        boolean r133 = true;
    L55:
        if (r133 == false) goto L78;
        CoroutineDispatcher r134 = Dispatchers.getIO();
        ChatReceiveServiceComponent$checkDowngradeOpt$hasVideo$1 r135 = new ChatReceiveServiceComponent$checkDowngradeOpt$hasVideo$1(r100, null);
        r101.L$0 = null;
        r101.L$1 = null;
        r101.label = 2;
        r103 = BuildersKt.withContext(r134, r135, r101);
        if (r103 != r104) goto L60;
        return r104;
    L54:
        r133 = false;
        goto L55
    L16:
        ResultKt.throwOnFailure(r103);
        r121 = ChatInputService.f303327b.A6();
        if (r121 == null) goto L24;
        Integer r136 = r121.getFileDowngrade();
        if (r136 == null) goto L24;
        if (r136.intValue() != 1) goto L24;
        boolean r137 = true;
    L25:
        if (r137 == false) goto L47;
        CoroutineDispatcher r138 = Dispatchers.getIO();
        ChatReceiveServiceComponent$checkDowngradeOpt$hasFile$1 r139 = new ChatReceiveServiceComponent$checkDowngradeOpt$hasFile$1(r100, null);
        r101.L$0 = r100;
        r101.L$1 = r121;
        r101.label = 1;
        r122 = BuildersKt.withContext(r138, r139, r101);
        if (r122 != r104) goto L30;
        return r104;
    L24:
        r137 = false;
    L7:
        r101 = new ChatReceiveServiceComponent$checkDowngradeOpt$1(r110, r210);
        goto L8
    }

    public static /* synthetic */ void N2(ChatReceiveServiceComponent r100, String r101, String r102) {
        r100.L2(r101, r102, null, false, null);
    }

    public final void P2(List<? extends Uri> r110, boolean r111, String r112) {
        FLogger.f375446a.i("ChatReceiveServiceComponent", "auto send uris:" + r110);
        List<? extends Uri> r100 = r110;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        com.larus.bmhome.chat.model.n r102 = null;
        if (r101 == false) goto L28;
        if (r111 == false) goto L50;
        z2 r103 = z2.f365865a;
        if (z2.c4() == false) goto L51;
        p1 r104 = cr();
        if (r104 == null) goto L17;
        j1 r105 = r104.Y3();
    L19:
        if ((r105 instanceof com.larus.bmhome.chat.model.n) == false) goto L21;
        r102 = (com.larus.bmhome.chat.model.n) r105;
    L21:
        if (r102 == null) goto L23;
        r102.f307542d = true;
    L23:
        p1 r106 = cr();
        if (r106 == null) goto L52;
        r106.cb(false);
        return;
    L52:
        return;
    L17:
        r105 = null;
        goto L19
    L51:
        return;
    L50:
        return;
    L28:
        if (z2.f365865a.optPasteFile() == false) goto L31;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatReceiveServiceComponent$autoSendUris$1(this, r110, r111, r112, null), 3, null);
        return;
    L31:
        if (X2(r110) == false) goto L48;
        if (r111 == true) goto L34;
        return;
    L34:
        if (z2.c4() == false) goto L54;
        p1 r107 = cr();
        if (r107 == null) goto L38;
        j1 r108 = r107.Y3();
    L40:
        if ((r108 instanceof com.larus.bmhome.chat.model.n) == false) goto L42;
        r102 = (com.larus.bmhome.chat.model.n) r108;
    L42:
        if (r102 == null) goto L44;
        r102.f307542d = true;
    L44:
        p1 r109 = cr();
        if (r109 == null) goto L55;
        r109.cb(false);
        return;
    L55:
        return;
    L38:
        r108 = null;
        goto L40
    L54:
        return;
    L48:
        U2(r110, r111, r112);
        return;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public final void U2(final List<? extends Uri> r110, final boolean r210, final String r211) {
        if (l0.a(r110) == true) goto L6;
        List r100 = CollectionsKt.mutableListOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE"});
        i2 r101 = i2.f365748b;
        Intrinsics.checkNotNullParameter(this, "<this>");
        i2.q(com.larus.ui.arch.component.internal.attach.a.b(this, this), r100, new a0(this, r110, r210, r211));
        return;
    L6:
        ChatControlTrace.f309996b.getClass();
        boolean r102 = true;
        ChatControlTrace.A = true;
        p1 r103 = cr();
        if (r103 == null) goto L9;
        j1 r104 = r103.Y3();
    L11:
        if ((r104 instanceof com.larus.bmhome.chat.model.n) == false) goto L13;
        com.larus.bmhome.chat.model.n r105 = (com.larus.bmhome.chat.model.n) r104;
    L14:
        if (r105 == null) goto L16;
        String r106 = r105.f307539a;
    L17:
        if (r105 == null) goto L19;
        String r107 = r105.f307541c;
    L21:
        if (r105 == null) goto L58;
        String r111 = r105.f307540b;
        if (r111 == null) goto L58;
        if (r210 == false) goto L55;
        z2 r112 = z2.f365865a;
        if (z2.c4() == false) goto L55;
        if (f1().A() == false) goto L55;
        if (r211 != null) goto L31;
    L34:
        boolean r113 = true;
    L35:
        if (r113 == true) goto L55;
        if (r106 != null) goto L38;
    L41:
        boolean r114 = true;
    L42:
        if (r114 == true) goto L55;
        if (r107 != null) goto L45;
    L48:
        boolean r108 = true;
    L49:
        if (r108 == true) goto L55;
        if (Intrinsics.areEqual(r111, "__mobile_new_session_mode_draft_chat__") == false) goto L53;
    L54:
        boolean r109 = true;
    L56:
        if (r109 != true) goto L58;
        boolean r115 = true;
    L59:
        if (r210 == false) goto L79;
        z2 r116 = z2.f365865a;
        if (z2.c4() == false) goto L79;
        if (r105 != null) goto L64;
    L66:
        boolean r117 = false;
    L67:
        if (r117 == false) goto L79;
        if (r106 == null) goto L72;
        Lazy r118 = ic8.n.f489237a;
        Intrinsics.checkNotNullParameter(r106, "<this>");
        if (com.larus.im.j.f(r106) != true) goto L72;
        boolean r119 = true;
    L73:
        if (r119 == false) goto L79;
        if (r115 == true) goto L79;
        FLogger.f375446a.w("ChatReceiveServiceComponent", "skip shared attachment entry without replacement candidate");
        r105.f307542d = true;
        p1 r120 = cr();
        if (r120 == null) goto L108;
        r120.cb(false);
        return;
    L108:
        return;
    L72:
        r119 = false;
        goto L73
    L64:
        if (r105.f307547i != true) goto L66;
        r117 = true;
    L79:
        if (r115 == true) goto L86;
        com.larus.bmhome.instruction.g r121 = (com.larus.bmhome.instruction.g) this.f301357o.getValue();
        if (r121 == null) goto L83;
        r121.A1();
    L83:
        u7 r122 = (u7) this.f301353k.getValue();
        if (r122 == null) goto L86;
        r122.TP(false);
    L86:
        com.larus.bmhome.chat.component.bottom.multimodal.g r123 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.f301359q.getValue();
        if (r123 == null) goto L109;
        List<? extends Uri> r124 = r110;
        ArrayList r125 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r124, 10));
        Iterator<T> r126 = r124.iterator();
    L90:
        if (r126.hasNext() == false) goto L92;
        r125.add(new com.larus.bmhome.chat.component.bottom.multimodal.a.C4037a((Uri) r126.next(), null, 2));
        goto L90
    L92:
        g1 r127 = (g1) this.f301360r.getValue();
        if (r127 != null) goto L95;
    L97:
        r102 = false;
    L98:
        com.larus.bmhome.chat.component.bottom.multimodal.g1 r128 = new com.larus.bmhome.chat.component.bottom.multimodal.g1(r102, MultimodalBizScene.ChatReceiveUri, false);
        if (r115 == false) goto L104;
        if (r211 != null) goto L102;
        String r129 = "";
    L103:
        Map r130 = MapsKt.mapOf(TuplesKt.to("mobile_new_session_mode_draft_replacement", r129));
    L105:
        r123.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(r125, r128, null, r130, null, 20));
        return;
    L102:
        r129 = r211;
        goto L103
    L104:
        r130 = MapsKt.emptyMap();
        goto L105
    L95:
        if (r127.mT() != true) goto L97;
    L109:
        return;
    L53:
        if (Intrinsics.areEqual(r111, "__mobile_new_session_mode_draft_office__") == false) goto L55;
    L45:
        if (StringsKt.isBlank(r107) == true) goto L48;
        r108 = false;
        goto L49
    L38:
        if (StringsKt.isBlank(r106) == true) goto L41;
        r114 = false;
        goto L42
    L31:
        if (StringsKt.isBlank(r211) == true) goto L34;
        r113 = false;
    L55:
        r109 = false;
    L58:
        r115 = false;
        goto L59
    L19:
        r107 = null;
        goto L21
    L16:
        r106 = null;
        goto L17
    L13:
        r105 = null;
        goto L14
    L9:
        r104 = null;
        goto L11
    }

    public final void L2(String r210, String r211, String r310, boolean r311, String r312) {
        com.larus.bmhome.chat.component.cvs.y r100 = u0();
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.Y1();
    L6:
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        FLogger r103 = FLogger.f375446a;
        r103.i("ChatReceiveServiceComponent", "auto send text, conversationId:" + r102 + ",text:" + r210 + ",scene:" + r211);
        boolean r110 = true;
        if (r210.length() <= 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L86;
        ChatControlTrace r105 = ChatControlTrace.f309996b;
        boolean r106 = !Intrinsics.areEqual(r211, "router_auto_send");
        r105.getClass();
        ChatControlTrace.A = r106;
        com.larus.bmhome.instruction.g r107 = (com.larus.bmhome.instruction.g) this.f301357o.getValue();
        if (r107 == null) goto L16;
        r107.A1();
    L16:
        u7 r108 = (u7) this.f301353k.getValue();
        if (r108 == null) goto L19;
        r108.TP(false);
    L19:
        if (r311 == false) goto L22;
        z2 r109 = z2.f365865a;
        if (z2.c4() == false) goto L22;
    L35:
        ReferenceInfo r111 = null;
    L37:
        if (r311 == true) goto L54;
        r103.i("ChatReceiveServiceComponent", "autosend scene=" + r211 + " , forceDowngrade=" + r311 + " , sending");
        gd8.g r112 = (gd8.g) this.f301356n.getValue();
        if (r112 == null) goto L41;
        boolean r113 = false;
        gd8.g.a.b(r112, r102, r210, r211, null, false, null, r111, null, new z(this), null, MediaPlayer.MEDIA_PLAYER_OPTION_SYNCHRONIZATION_GROUP_ID);
    L42:
        if (r310 != null) goto L44;
    L47:
        if (r110 == true) goto L87;
        com.larus.bmhome.chat.component.bottom.reference.a r114 = g5();
        if (r114 == null) goto L51;
        r114.sZ();
    L51:
        com.larus.bmhome.chat.component.bottom.reference.a r115 = g5();
        if (r115 == null) goto L88;
        r115.Ek(r113);
        return;
    L88:
        return;
    L87:
        return;
    L44:
        if (r310.length() == 0) goto L47;
        r110 = false;
        goto L47
    L41:
        r113 = false;
        goto L42
    L54:
        r103.i("ChatReceiveServiceComponent", "autosend scene=" + r211 + " , forceDowngrade=" + r311 + " , prefield");
        z2 r116 = z2.f365865a;
        if (z2.c4() == false) goto L82;
        p1 r117 = cr();
        if (r117 == null) goto L59;
        j1 r118 = r117.Y3();
    L60:
        if (r118 != null) goto L62;
        String r119 = "ChatReceiveServiceComponent";
    L73:
        boolean r120 = false;
    L74:
        if (r120 == false) goto L81;
        p1 r121 = cr();
        if (r121 == null) goto L78;
        r121.cb(false);
    L78:
        va8.o r122 = (va8.o) this.f301355m.getValue();
        if (r122 == null) goto L90;
        r122.E40();
        return;
    L90:
        return;
    L81:
        r103.w(r119, "ignore stale route-query draft replacement");
        return;
    L62:
        if (r310 != null) goto L64;
    L69:
        String r123 = r101;
        r119 = "ChatReceiveServiceComponent";
        if (j1.a.c(r118, r210, null, true, null, r312, r123, 8) != true) goto L73;
        r120 = true;
        goto L74
    L64:
        if ((!StringsKt.isBlank(r310)) == false) goto L66;
        String r124 = r310;
    L67:
        if (r124 == null) goto L69;
        r101 = new ReferenceMessage(null, r124, null, true, true, 0, null, null, 229, null).toJsonString();
        goto L69
    L66:
        r124 = null;
        goto L67
    L59:
        r118 = null;
        goto L60
    L82:
        ICoreInputAbility r125 = (ICoreInputAbility) this.f301354l.getValue();
        if (r125 == null) goto L93;
        ICoreInputAbility.b.d(r125, r210, true, true, null, null, false, 56);
        return;
    L93:
        return;
    L22:
        if (r310 != null) goto L24;
    L27:
        boolean r126 = true;
    L28:
        if (r126 == true) goto L35;
        com.larus.bmhome.chat.component.bottom.reference.a r127 = g5();
        if (r127 == null) goto L32;
        r127.L60(r310, false);
    L32:
        com.larus.bmhome.chat.component.bottom.reference.a r128 = g5();
        if (r128 == null) goto L35;
        r111 = r128.T6();
        goto L37
    L24:
        if (r310.length() == 0) goto L27;
        r126 = false;
        goto L28
    L86:
        return;
    L11:
        r104 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }
}
