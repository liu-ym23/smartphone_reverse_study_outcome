package com.larus.avatar.impl.upload;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.larus.avatar.impl.databinding.LarusPageDigitalAvatarUploadPictureBinding;
import com.larus.avatar.impl.upload.adapter.DigitalAvatarUploadAdapter;
import com.larus.avatar.impl.upload.adapter.DigitalAvatarUploadItemStatus;
import com.larus.avatar.impl.upload.adapter.DigitalAvatarUploadItemType;
import com.larus.avatar.impl.upload.utils.PreGenImageBitmapHelper;
import com.larus.avatar.impl.upload.utils.UploadPhotoDecoration;
import com.larus.avatar.impl.upload.viewmodel.CreateAvatarStatus;
import com.larus.avatar.impl.upload.viewmodel.DigitalAvatarUploadViewModel;
import com.larus.avatar.impl.upload.widget.RotateImageView;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.nova.R;
import com.larus.platform.model.creation.ResourceExt;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import tx9.a1;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010P\u001a\u000207H\u0016J\b\u0010Q\u001a\u00020 H\u0016J\u0012\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J&\u0010V\u001a\u0004\u0018\u00010W2\u0006\u0010X\u001a\u00020Y2\b\u0010Z\u001a\u0004\u0018\u00010[2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\b\u0010\\\u001a\u00020SH\u0016J\n\u0010]\u001a\u0004\u0018\u00010WH\u0002J\u000f\u0010^\u001a\u0004\u0018\u00010SH\u0003¢\u0006\u0002\u0010_J\b\u0010`\u001a\u00020SH\u0003J\u001c\u0010a\u001a\u00020S2\b\u0010b\u001a\u0004\u0018\u00010c2\b\u0010d\u001a\u0004\u0018\u00010cH\u0002J+\u0010e\u001a\u00020S2\b\u0010f\u001a\u0004\u0018\u00010c2\u0017\u0010g\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020S0h¢\u0006\u0002\biH\u0002J\b\u0010j\u001a\u00020SH\u0002J\b\u0010m\u001a\u00020SH\u0003J\b\u0010n\u001a\u00020SH\u0003J\b\u0010o\u001a\u00020SH\u0002J\b\u0010p\u001a\u00020SH\u0002J\u000e\u0010q\u001a\u000207H\u0082@¢\u0006\u0002\u0010rJ4\u0010s\u001a\u00020S2$\u0010t\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0v\u0012\u0006\u0012\u0004\u0018\u00010w0uH\u0082@¢\u0006\u0002\u0010xJ\u000f\u0010y\u001a\u0004\u0018\u00010SH\u0002¢\u0006\u0002\u0010_J\u0010\u0010z\u001a\u00020S2\u0006\u0010{\u001a\u000207H\u0002J\u000f\u0010~\u001a\u0004\u0018\u00010SH\u0003¢\u0006\u0002\u0010_J$\u0010\u007f\u001a\u0004\u0018\u00010S2\u0007\u0010\u0080\u0001\u001a\u0002072\t\b\u0002\u0010\u0081\u0001\u001a\u000207H\u0002¢\u0006\u0003\u0010\u0082\u0001J\n\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0002J\u001c\u0010\u0085\u0001\u001a\u00020S2\u0007\u0010\u0086\u0001\u001a\u00020W2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\t\u0010\u0087\u0001\u001a\u00020SH\u0002J\u0016\u0010\u0088\u0001\u001a\u0004\u0018\u00010E2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010 H\u0002J\t\u0010\u008a\u0001\u001a\u00020SH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010%\u001a\u0016\u0012\u0004\u0012\u00020'\u0018\u00010&j\n\u0012\u0004\u0012\u00020'\u0018\u0001`(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00108\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010A\u001a\u0016\u0012\u0004\u0012\u00020B\u0018\u00010&j\n\u0012\u0004\u0012\u00020B\u0018\u0001`(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010H\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0004\n\u0002\u0010IR\u0010\u0010J\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010K\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0004\n\u0002\u0010LR\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u0004\u0018\u00010lX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010|\u001a\u0004\u0018\u00010}X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008b\u0001"}, d2 = {"Lcom/larus/avatar/impl/upload/DigitalAvatarUploadFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/avatar/impl/databinding/LarusPageDigitalAvatarUploadPictureBinding;", "pickSDKLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "gson", "Lcom/google/gson/Gson;", "createAvatarMinUploadImgCnt", "", "createAvatarMaxUploadImgCnt", "viewModel", "Lcom/larus/avatar/impl/upload/viewmodel/DigitalAvatarUploadViewModel;", "getViewModel", "()Lcom/larus/avatar/impl/upload/viewmodel/DigitalAvatarUploadViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "uiState", "Lcom/larus/avatar/impl/upload/DigitalAvatarUploadUiState;", "preGenManager", "Lcom/larus/avatar/impl/upload/DigitalAvatarPreGenManager;", "getPreGenManager", "()Lcom/larus/avatar/impl/upload/DigitalAvatarPreGenManager;", "preGenManager$delegate", com.bytedance.android.ec.core.event.a.KEY_TRACKER, "Lcom/larus/avatar/impl/upload/DigitalAvatarUploadTracker;", "uploadActionDelegate", "Lcom/larus/avatar/impl/upload/DigitalAvatarUploadActionDelegate;", "conversationId", "", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", EventConstant.Key.RETAIN_PROMPT, "trackExtCreationTemplate", "selectImageUris", "Ljava/util/ArrayList;", "Landroid/net/Uri;", "Lkotlin/collections/ArrayList;", "previousPage", "replicaCreateId", "scene", "enterTime", "", "enterMethod", "aiGenerateTabId", "aiGenerateTabType", "aiGenerateTabName", "isFromTemplate", GXTemplateKey.GAIAX_TEMPLATE_ID, "botId", "chatType", "isRegenerateReplica", "", "preGenImages", "", "Lcom/larus/uaigc/avatar/api/PreGenImage;", "refMsgId", "isFromAvatarCreation", "selectInstructionType", "enterCreateFrom", "isFromOnboarding", "avatarDoSamePrompt", "avatarRefResourceList", "Lcom/larus/platform/model/creation/ResourceExt;", "isMockAvatar", "scanJump2UploadArgument", "Lcom/larus/avatar/impl/scan/ScanJump2UploadArgument;", "mainImage", "isReplaceAvatar", "targetInstructionItemId", "Ljava/lang/Long;", "videoInternalResourcesStr", "isCreationPrivate", "Ljava/lang/Boolean;", "creationBtnReplayInfo", "Lcom/larus/bmhome/chat/standarduikit/commonbuttonv2/CreationBtnReplayInfo;", "localMessageId", "autoLogEnterPage", "getCurrentPageName", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onResume", "initTitle", "initAddPhoto", "()Lkotlin/Unit;", "initObserver", "handleAvatarCreateResult", "currentActivity", "Landroid/app/Activity;", "previousActivity", "currentActivitySetResultOKAndFinish", "activity", "intentBlock", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "jumpBackToChat", "job", "Lkotlinx/coroutines/Job;", "initLauncher", "initPreGeneratedImages", "refreshList", "onUploadStateChanged", "checkConvRemote", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMainBotConversationInfo", "callback", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupCreateBtn", "createDigitalAvatar", "isReplicaSamePerson", "digitalAvatarUploadAdapter", "Lcom/larus/avatar/impl/upload/adapter/DigitalAvatarUploadAdapter;", "setupUploadImageList", "refreshCreateBtn", "canCreate", "isLoading", "(ZZ)Lkotlin/Unit;", "currentActionContext", "Lcom/larus/avatar/impl/upload/DigitalAvatarUploadActionDelegate$ActionContext;", "onViewCreated", "view", "initData", "parseScanJumpUploadParam", "string", LiveCommonConstants.REASON_ON_DEDTROY, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DigitalAvatarUploadFragment extends TraceFragment {
    public static final /* synthetic */ int X = 0;
    public String A;
    public String B;
    public String C;
    public String D;
    public boolean E;
    public List<ey9.k> F;
    public String G;
    public int H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f291246J;
    public String K;
    public ArrayList<ResourceExt> L;
    public boolean M;
    public com.larus.avatar.impl.scan.o N;
    public ey9.k O;
    public boolean P;
    public Long Q;
    public String R;
    public Boolean S;
    public wj8.b T;
    public String U;
    public Job V;
    public DigitalAvatarUploadAdapter W;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LarusPageDigitalAvatarUploadPictureBinding f291247e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ActivityResultLauncher<Intent> f291248f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f291249g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f291250h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f291251i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final s f291252j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f291253k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public r f291254l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public DigitalAvatarUploadActionDelegate f291255m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f291256n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public wc9.e f291257o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f291258p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f291259q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList<Uri> f291260r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f291261s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f291262t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f291263u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f291264v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f291265w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f291266x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f291267y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f291268z;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f291269a = null;

        static {
            int[] r100 = new int[CreateAvatarStatus.values().length];
            r100[CreateAvatarStatus.INIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[CreateAvatarStatus.LOADING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[CreateAvatarStatus.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[CreateAvatarStatus.FAIL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f291269a = r100;
        }
    }

    /* JADX INFO: renamed from: com.larus.avatar.impl.upload.DigitalAvatarUploadFragment$onCreate$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<DigitalAvatarUploadActionDelegate.a> {
        public AnonymousClass1(Object r100) {
            super(0, r100, DigitalAvatarUploadFragment.class, "currentActionContext", "currentActionContext()Lcom/larus/avatar/impl/upload/DigitalAvatarUploadActionDelegate$ActionContext;", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DigitalAvatarUploadActionDelegate.a invoke() {
            DigitalAvatarUploadFragment r100 = (DigitalAvatarUploadFragment) this.receiver;
            int r101 = DigitalAvatarUploadFragment.X;
            r100.getClass();
            return new DigitalAvatarUploadActionDelegate.a(r100.f291262t, r100.f291263u, r100.f291265w);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ DigitalAvatarUploadActionDelegate.a invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: com.larus.avatar.impl.upload.DigitalAvatarUploadFragment$onCreate$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass2(Object r100) {
            super(0, r100, DigitalAvatarUploadFragment.class, "onUploadStateChanged", "onUploadStateChanged()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            DigitalAvatarUploadFragment r100 = (DigitalAvatarUploadFragment) this.receiver;
            int r101 = DigitalAvatarUploadFragment.X;
            r100.Y90();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return false;
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "create_replica";
    }

    public final DigitalAvatarUploadViewModel W90() {
        return (DigitalAvatarUploadViewModel) this.f291251i.getValue();
    }

    public final void Y90() {
        LarusPageDigitalAvatarUploadPictureBinding r100 = this.f291247e;
        boolean r101 = true;
        if (r100 == null) goto L20;
        s r102 = this.f291252j;
        if (((ArrayList) r102.f291316c).isEmpty() == false) goto L9;
    L12:
        boolean r103 = true;
    L14:
        if (r103 == false) goto L16;
        e1.o(r100.f290772c);
        e1.x(r100.f290777h);
    L17:
        DigitalAvatarUploadAdapter r104 = this.W;
        if (r104 == null) goto L20;
        r104.notifyDataSetChanged();
        goto L20
    L16:
        e1.x(r100.f290772c);
        e1.o(r100.f290777h);
        goto L17
    L9:
        if (((ArrayList) r102.f291316c).size() == 1) goto L11;
    L13:
        r103 = false;
        goto L14
    L11:
        if (((q88.d) CollectionsKt.first(r102.f291316c)).f532037a != DigitalAvatarUploadItemType.ADD_IMAGE) goto L13;
    L20:
        s r105 = this.f291252j;
        List<q88.d> r106 = r105.f291316c;
        if ((r106 instanceof Collection) == true) goto L23;
    L25:
        Iterator r107 = ((ArrayList) r106).iterator();
        int r108 = 0;
    L27:
        if (r107.hasNext() == false) goto L39;
        q88.d r109 = (q88.d) r107.next();
        if (r109.f532037a == DigitalAvatarUploadItemType.IMAGE) goto L31;
    L33:
        boolean r110 = false;
    L34:
        if (r110 == false) goto L27;
        r108 = r108 + 1;
        if (r108 >= 0) goto L27;
        CollectionsKt.throwCountOverflow();
        goto L27
    L31:
        if (r109.f532038b != DigitalAvatarUploadItemStatus.SUCCESS) goto L33;
        r110 = true;
    L39:
        if (r108 < r105.f291314a) goto L61;
        int r111 = r105.c();
        List<q88.d> r112 = r105.f291316c;
        if ((r112 instanceof Collection) == true) goto L44;
    L46:
        Iterator r113 = ((ArrayList) r112).iterator();
        int r114 = 0;
    L48:
        if (r113.hasNext() == false) goto L59;
        q88.d r115 = (q88.d) r113.next();
        if (r115.f532037a == DigitalAvatarUploadItemType.IMAGE) goto L52;
    L54:
        boolean r116 = false;
    L55:
        if (r116 == false) goto L48;
        r114 = r114 + 1;
        if (r114 >= 0) goto L48;
        CollectionsKt.throwCountOverflow();
        goto L48
    L52:
        if (r115.f532042f == false) goto L54;
        r116 = true;
    L59:
        if (r114 == r111) goto L61;
    L62:
        Z90(r101, false);
        return;
    L44:
        if (((ArrayList) r112).isEmpty() == false) goto L46;
        r114 = 0;
    L61:
        r101 = false;
        goto L62
    L23:
        if (((ArrayList) r106).isEmpty() == false) goto L25;
        r108 = 0;
        goto L39
    }

    public DigitalAvatarUploadFragment() {
        new Gson();
        AuthModelDelegate r100 = AuthModelDelegate.f297134b;
        LaunchInfo r101 = r100.x().getValue();
        int r102 = 1;
        if (r101 != null) goto L5;
    L8:
        this.f291249g = r102;
        LaunchInfo r103 = r100.x().getValue();
        int r104 = 10;
        if (r103 != null) goto L11;
    L14:
        this.f291250h = r104;
        this.f291251i = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DigitalAvatarUploadViewModel.class), new DigitalAvatarUploadFragment$special$$inlined$activityViewModels$default$1(this), new DigitalAvatarUploadFragment$special$$inlined$activityViewModels$default$2(this));
        this.f291252j = new s(r102, r104);
        this.f291253k = LazyKt.lazy(new j(this));
        this.f291263u = BasicTestActionHandler.TEST_ACTION_RESET;
        this.H = 4;
        return;
    L11:
        if (r103.K() <= 0) goto L14;
        r104 = r103.K();
        goto L14
    L5:
        if (r101.L() <= 0) goto L8;
        r102 = r101.L();
        goto L8
    }

    public final void X90() {
        ci8.a r100 = ci8.b.a();
        if (r100 == null) goto L5;
        r100.c1().f0(PageType.Chat.getType());
        return;
    L5:
        Bundle r101 = getArguments();
        if (r101 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L15;
        com.bytedance.router.i r103 = SmartRouter.buildRoute(getContext(), "//flow/chat_page");
        r103.f267555d = R.anim.larus_router_slide_in_right;
        r103.f267556e = R.anim.larus_router_no_anim;
        r103.f267554c.putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("argPreviousPage", "create_replica")}));
        r103.d();
        return;
    L15:
        return;
    L8:
        if (r101.getBoolean("need_router_to_chat") != true) goto L10;
        r102 = true;
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        DigitalAvatarPreGenManager r100 = (DigitalAvatarPreGenManager) this.f291253k.getValue();
        Iterator r101 = ((LinkedHashMap) r100.f291228c).values().iterator();
    L3:
        ActivityResultLauncher<Intent> r102 = null;
        if (r101.hasNext() == false) goto L12;
        r88.a r103 = (r88.a) r101.next();
        PreGenImageBitmapHelper r104 = PreGenImageBitmapHelper.f291320a;
        Bitmap r105 = r103.f536665e;
        r104.getClass();
        if (r105 == null) goto L11;
        if (r105.isRecycled() == true) goto L11;
        r105.recycle();
    L11:
        r103.f536665e = null;
        goto L3
    L12:
        ((LinkedHashMap) r100.f291228c).clear();
        ActivityResultLauncher<Intent> r106 = this.f291248f;
        if (r106 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("pickSDKLauncher");
    L16:
        r102.unregister();
        return;
    L15:
        r102 = r106;
        goto L16
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f291264v = System.currentTimeMillis();
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r610) {
        super.onCreate(r610);
        this.f291254l = new r(this);
        this.f291248f = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new l(this));
        Bundle r100 = getArguments();
        r r110 = null;
        if (r100 == null) goto L5;
        String r101 = r100.getString("ai_generate_tab_id", "");
    L6:
        this.f291266x = r101;
        Bundle r102 = getArguments();
        if (r102 == null) goto L9;
        String r103 = r102.getString("ai_generate_tab_type", "");
    L10:
        this.f291267y = r103;
        Bundle r104 = getArguments();
        if (r104 == null) goto L13;
        String r105 = r104.getString("ai_generate_tab_name", "");
    L14:
        this.f291268z = r105;
        Bundle r106 = getArguments();
        if (r106 == null) goto L18;
        String r107 = r106.getString("enter_method", "");
        if (r107 == null) goto L18;
    L19:
        this.f291265w = r107;
        Bundle r108 = getArguments();
        String r109 = "0";
        if (r108 == null) goto L25;
        String r111 = r108.getString("is_from_template", "0");
        if (r111 == null) goto L25;
        r109 = r111;
    L25:
        this.A = r109;
        Bundle r112 = getArguments();
        if (r112 == null) goto L28;
        String r113 = r112.getString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, "");
    L29:
        this.B = r113;
        Bundle r114 = getArguments();
        if (r114 == null) goto L32;
        String r115 = r114.getString("bot_id");
    L33:
        this.C = r115;
        Bundle r116 = getArguments();
        if (r116 == null) goto L36;
        String r117 = r116.getString("chat_type");
    L37:
        this.D = r117;
        Bundle r118 = getArguments();
        if (r118 == null) goto L40;
        ArrayList<Uri> r119 = r118.getParcelableArrayList("image_uris");
    L41:
        this.f291260r = r119;
        Bundle r120 = getArguments();
        if (r120 == null) goto L44;
        String r121 = r120.getString("argConversationId");
    L45:
        this.f291256n = r121;
        Bundle r122 = getArguments();
        if (r122 == null) goto L48;
        String r123 = r122.getString("actionbar_instruction_prompt");
    L49:
        this.f291258p = r123;
        Bundle r124 = getArguments();
        if (r124 == null) goto L52;
        String r125 = r124.getString("creation_template");
    L53:
        this.f291259q = r125;
        FLogger.f375446a.i("DigitalAvatarUploadFragment", "prompt:" + this.f291258p + ",trackExtCreationTemplate:" + this.f291259q);
        Bundle r126 = getArguments();
        if (r126 == null) goto L56;
        String r127 = r126.getString("previous_page");
    L57:
        this.f291261s = r127;
        Bundle r128 = getArguments();
        if (r128 == null) goto L60;
        String r129 = r128.getString("replica_create_id", "");
    L61:
        this.f291262t = r129;
        Bundle r130 = getArguments();
        if (r130 == null) goto L65;
        String r131 = r130.getString("scene");
        if (r131 == null) goto L65;
    L66:
        this.f291263u = r131;
        Bundle r132 = getArguments();
        int r133 = 0;
        if (r132 == null) goto L69;
        boolean r134 = r132.getBoolean("is_regenerate_replica", false);
    L70:
        this.E = r134;
        Bundle r135 = getArguments();
        if (r135 == null) goto L73;
        String r136 = r135.getString("pre_gen_images");
    L74:
        PreGenImageBitmapHelper.f291320a.getClass();
        boolean r137 = true;
        if (r136 != null) goto L77;
    L80:
        boolean r138 = true;
    L82:
        if (r138 == false) goto L197;
        List<ey9.k> r139 = null;
    L95:
        this.F = r139;
        Bundle r140 = getArguments();
        if (r140 == null) goto L98;
        String r141 = r140.getString("KEY_SCAN_JUMP_UPLOAD_PARAM");
    L99:
        if (r141 != null) goto L101;
    L104:
        if (r137 == false) goto L195;
        com.larus.avatar.impl.scan.o r142 = null;
    L117:
        this.N = r142;
        PreGenImageBitmapHelper r143 = PreGenImageBitmapHelper.f291320a;
        Bundle r144 = getArguments();
        if (r144 == null) goto L120;
        String r145 = r144.getString("main_image");
    L121:
        r143.getClass();
        this.O = PreGenImageBitmapHelper.c(r145);
        Bundle r146 = getArguments();
        if (r146 == null) goto L124;
        boolean r147 = r146.getBoolean("is_replace_avatar", false);
    L125:
        this.P = r147;
        Bundle r148 = getArguments();
        if (r148 == null) goto L128;
        String r149 = r148.getString("ref_msg_id");
    L129:
        this.G = r149;
        Bundle r150 = getArguments();
        if (r150 == null) goto L132;
        r150.getBoolean("is_from_avatar_creation", false);
    L132:
        Bundle r151 = getArguments();
        int r152 = 4;
        if (r151 == null) goto L135;
        r152 = r151.getInt("select_instruction_type", 4);
    L135:
        this.H = r152;
        Bundle r153 = getArguments();
        if (r153 == null) goto L138;
        String r154 = r153.getString("enter_create_from");
    L139:
        this.I = r154;
        Bundle r155 = getArguments();
        if (r155 == null) goto L142;
        boolean r156 = r155.getBoolean("is_from_onboarding", false);
    L143:
        this.f291246J = r156;
        Bundle r157 = getArguments();
        if (r157 == null) goto L146;
        String r158 = r157.getString("avatar_dosame_default_prompt", "");
    L147:
        this.K = r158;
        Bundle r159 = getArguments();
        if (r159 == null) goto L150;
        ArrayList<ResourceExt> r160 = r159.getParcelableArrayList("avatar_ref_image");
    L151:
        this.L = r160;
        Bundle r161 = getArguments();
        if (r161 == null) goto L154;
        boolean r162 = r161.getBoolean("is_mock_avatar", false);
    L155:
        this.M = r162;
        Bundle r163 = getArguments();
        if (r163 == null) goto L158;
        Long r164 = Long.valueOf(r163.getLong("target_instruction_item_id", 0));
    L159:
        this.Q = r164;
        Bundle r165 = getArguments();
        if (r165 == null) goto L162;
        String r166 = r165.getString("key_video_internal_resource", null);
    L163:
        this.R = r166;
        Bundle r167 = getArguments();
        if (r167 == null) goto L166;
        Boolean r168 = Boolean.valueOf(r167.getBoolean("key_is_creation_private"));
    L167:
        this.S = r168;
        com.larus.avatar.impl.scan.o r169 = this.N;
        if (r169 == null) goto L170;
        W90().setScanJumpParams(r169);
    L170:
        Bundle r170 = getArguments();
        if (r170 == null) goto L173;
        Integer r171 = Integer.valueOf(r170.getInt("digital_avatar_process_type"));
    L174:
        DigitalAvatarUploadViewModel r172 = W90();
        if (r171 == null) goto L177;
        r133 = r171.intValue();
    L177:
        r172.setDigitalAvatarProcessType(r133);
        Bundle r173 = getArguments();
        if (r173 == null) goto L180;
        String r174 = r173.getString("creation_btn_rely_info");
    L181:
        this.T = PreGenImageBitmapHelper.b(r174);
        W90().setCreationBtnReplayInfo(this.T);
        Bundle r175 = getArguments();
        if (r175 == null) goto L184;
        String r176 = r175.getString("local_message_id", "");
    L185:
        this.U = r176;
        LifecycleCoroutineScope r177 = LifecycleOwnerKt.getLifecycleScope(this);
        s r178 = this.f291252j;
        DigitalAvatarUploadViewModel r179 = W90();
        DigitalAvatarPreGenManager r180 = (DigitalAvatarPreGenManager) this.f291253k.getValue();
        r r181 = this.f291254l;
        if (r181 != null) goto L188;
        Intrinsics.throwUninitializedPropertyAccessException(com.bytedance.android.ec.core.event.a.KEY_TRACKER);
        r r182 = null;
    L189:
        this.f291255m = new DigitalAvatarUploadActionDelegate(this, r177, r178, r179, r180, r182, new AnonymousClass1(this), new AnonymousClass2(this));
        r r183 = this.f291254l;
        if (r183 != null) goto L192;
        Intrinsics.throwUninitializedPropertyAccessException(com.bytedance.android.ec.core.event.a.KEY_TRACKER);
    L193:
        String r184 = this.f291261s;
        String r185 = this.f291265w;
        r110.getClass();
        Intrinsics.checkNotNullParameter("create_replica", "currentPage");
        a1.c(null, null, null, null, null, "create_replica", null, null, r185, null, null, null, null, null, null, null, r184, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r110.f291313a, null, null, null, null, null, null, null, -1049729, -16777217, 7);
        return;
    L192:
        r110 = r183;
        goto L193
    L188:
        r182 = r181;
        goto L189
    L184:
        r176 = null;
        goto L185
    L180:
        r174 = null;
        goto L181
    L173:
        r171 = null;
        goto L174
    L166:
        r168 = null;
        goto L167
    L162:
        r166 = null;
        goto L163
    L158:
        r164 = null;
        goto L159
    L154:
        r162 = false;
        goto L155
    L150:
        r160 = null;
        goto L151
    L146:
        r158 = null;
        goto L147
    L142:
        r156 = false;
        goto L143
    L138:
        r154 = null;
        goto L139
    L128:
        r149 = null;
        goto L129
    L124:
        r147 = false;
        goto L125
    L120:
        r145 = null;
        goto L121
    L195:
        Result.Companion r186 = Result.Companion;     // Catch: Throwable -> L108
        Object r187 = Result.m9449constructorimpl((com.larus.avatar.impl.scan.o) new Gson().fromJson(r141, new p().getType()));     // Catch: Throwable -> L108
    L110:
        Throwable r188 = Result.m9452exceptionOrNullimpl(r187);
        if (r188 == null) goto L114;
        FLogger.f375446a.e("DigitalAvatarUploadFragment", "parsePreGenImages error: " + r188.getMessage());
    L114:
        if (Result.m9455isFailureimpl(r187) == false) goto L116;
        r187 = null;
    L116:
        r142 = (com.larus.avatar.impl.scan.o) r187;
    L108:
        th = move-exception;
        Result.Companion r189 = Result.Companion;
        r187 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L110
    L101:
        if (StringsKt.isBlank(r141) == true) goto L104;
        r137 = false;
        goto L104
    L98:
        r141 = null;
        goto L99
    L197:
        Result.Companion r190 = Result.Companion;     // Catch: Throwable -> L86
        Object r191 = Result.m9449constructorimpl((List) new Gson().fromJson(r136, new com.larus.avatar.impl.upload.utils.b().getType()));     // Catch: Throwable -> L86
    L88:
        Throwable r192 = Result.m9452exceptionOrNullimpl(r191);
        if (r192 == null) goto L92;
        FLogger.f375446a.e("PreGenImageBitmapHelper", "parsePreGenImages error: " + r192.getMessage());
    L92:
        if (Result.m9455isFailureimpl(r191) == false) goto L94;
        r191 = null;
    L94:
        r139 = (List) r191;
    L86:
        th = move-exception;
        Result.Companion r193 = Result.Companion;
        r191 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L88
    L77:
        if (StringsKt.isBlank(r136) == true) goto L80;
        r138 = false;
        goto L82
    L73:
        r136 = null;
        goto L74
    L69:
        r134 = false;
    L65:
        r131 = BasicTestActionHandler.TEST_ACTION_RESET;
        goto L66
    L60:
        r129 = null;
        goto L61
    L56:
        r127 = null;
        goto L57
    L52:
        r125 = null;
        goto L53
    L48:
        r123 = null;
        goto L49
    L44:
        r121 = null;
        goto L45
    L40:
        r119 = null;
        goto L41
    L36:
        r117 = null;
        goto L37
    L32:
        r115 = null;
        goto L33
    L28:
        r113 = null;
    L18:
        r107 = "";
        goto L19
    L13:
        r105 = null;
        goto L14
    L9:
        r103 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public static final Object U90(DigitalAvatarUploadFragment r110, Continuation r210) {
        DigitalAvatarUploadFragment r100 = r110;
        r110.getClass();
        if ((r210 instanceof DigitalAvatarUploadFragment$checkConvRemote$1) == false) goto L7;
        DigitalAvatarUploadFragment$checkConvRemote$1 r101 = (DigitalAvatarUploadFragment$checkConvRemote$1) r210;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        int r112 = 2;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L19;
        if (r104 == 2) goto L18;
        if (r104 == 3) goto L17;
        if (r104 != 4) goto L16;
        r100 = (DigitalAvatarUploadFragment) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Object r105 = r103;
        boolean r106 = true;
    L73:
        wc9.e r107 = (wc9.e) r105;
    L74:
        r100.f291257o = r107;
        return Boxing.boxBoolean(r106);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r103);
        Object r108 = r103;
        boolean r109 = true;
    L60:
        wc9.e r113 = (wc9.e) r108;
        if (r113 == null) goto L77;
        r100.f291257o = r113;
        r100.f291256n = r113.f559198a;
        return Boxing.boxBoolean(r109);
    L77:
        return Boxing.boxBoolean(false);
    L18:
        int r114 = r101.I$0;
        wc9.e r115 = (wc9.e) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L41:
        List r116 = (List) r103;
        if (r116 == null) goto L78;
        String r117 = (String) CollectionsKt.firstOrNull(r116);
        if (r117 == null) goto L78;
        IConversationRepoService r118 = zh8.a.f572197b;
        if (r114 == 0) goto L52;
        Integer r119 = r115.f559219v;
        if (r119 == null) goto L52;
        r112 = r119.intValue();
    L52:
        if (r114 == 0) goto L56;
        wc9.e r120 = AuthModelDelegate.f297134b.y().getValue();
        if (r120 == null) goto L56;
        String r121 = r120.f559198a;
    L57:
        r101.L$0 = null;
        r101.label = 3;
        r109 = true;
        r108 = IConversationRepoService.a.a(r118, r117, r112, r121, null, false, null, null, null, null, r101, 504);
        if (r108 != r111) goto L60;
        return r111;
    L56:
        r121 = null;
    L78:
        return Boxing.boxBoolean(false);
    L19:
        ResultKt.throwOnFailure(r103);
    L30:
        wc9.e r122 = (wc9.e) r103;
    L31:
        r115 = r122;
        if (r115 != null) goto L34;
    L36:
        r114 = 0;
    L37:
        if (r115 == null) goto L78;
        r101.L$0 = r115;
        r101.I$0 = r114;
        r101.label = 2;
        r103 = ic8.n.c(r115, r101);
        if (r103 != r111) goto L41;
        return r111;
    L34:
        if (ic8.n.D(r115) != true) goto L36;
        r114 = 1;
        goto L37
    L20:
        ResultKt.throwOnFailure(r103);
        Lazy r123 = com.larus.im.j.f350569a;
        if (com.larus.im.j.f(r100.f291256n) == false) goto L65;
        r122 = IAIChatControlTraceService.a.h(IAIChatControlTraceService.f365889a, r100.f291256n);
        if (r122 != null) goto L31;
        IConversationRepoService r124 = zh8.a.f572197b;
        String r125 = r100.f291256n;
        if (r125 != null) goto L27;
        r125 = "";
    L27:
        r101.label = 1;
        r103 = IConversationRepoService.a.c(r124, r125, true, null, r101, 4);
        if (r103 != r111) goto L30;
        return r111;
    L65:
        r106 = true;
        r107 = IAIChatControlTraceService.a.h(IAIChatControlTraceService.f365889a, r100.f291256n);
        if (r107 != null) goto L74;
        IConversationRepoService r126 = zh8.a.f572197b;
        String r127 = r100.f291256n;
        if (r127 != null) goto L70;
        r127 = "";
    L70:
        r101.L$0 = r100;
        r101.label = 4;
        r105 = IConversationRepoService.a.c(r126, r127, false, null, r101, 4);
        if (r105 != r111) goto L73;
        return r111;
    L7:
        r101 = new DigitalAvatarUploadFragment$checkConvRemote$1(r100, r210);
        goto L8
    }

    public final Unit Z90(boolean r100, boolean r101) {
        LarusPageDigitalAvatarUploadPictureBinding r102 = this.f291247e;
        Drawable r103 = null;
        if (r102 == null) goto L15;
        r102.f290773d.setEnabled(r100);
        if (r100 == false) goto L7;
        r102.f290773d.setAlpha(1.0f);
        e1.x(r102.f290774e);
        e1.o(r102.f290775f);
    L14:
        return Unit.INSTANCE;
    L7:
        if (r101 == false) goto L12;
        r102.f290773d.setAlpha(1.0f);
        e1.o(r102.f290774e);
        RotateImageView r104 = r102.f290775f;
        Drawable r105 = ContextCompat.getDrawable(r104.getContext(), R.drawable.larus_digital_avatar_upload_loading_icon);
        if (r105 == null) goto L11;
        r103 = r105.mutate();
    L11:
        r104.setImageDrawable(r103);
        e1.x(r102.f290775f);
        goto L14
    L12:
        r102.f290773d.setAlpha(0.3f);
        e1.x(r102.f290774e);
        e1.o(r102.f290775f);
        goto L14
    L15:
        return null;
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [com.larus.avatar.impl.upload.i] */
    /* JADX WARN: Type inference failed for: r8v8, types: [com.larus.avatar.impl.upload.g] */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.larus.avatar.impl.upload.h] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        super.onViewCreated(r210, r211);
        LarusPageDigitalAvatarUploadPictureBinding r100 = this.f291247e;
        String r101 = null;
        if (r100 == null) goto L5;
        NovaTitleBarEx.Y5(r100.f290776g, getString(R.string.larus_mob_ccBot_AIReplica_GenerateScreen_title), null, null, 6);
        NovaTitleBarEx.b6(r100.f290776g, R.drawable.larus_digital_avatar_icon_close_page, false, null, null, new m(this), 14);
    L5:
        LarusPageDigitalAvatarUploadPictureBinding r102 = this.f291247e;
        if (r102 == null) goto L14;
        r102.f290778i.setText(getString(R.string.larus_mob_ccBot_AIReplica_GenerateScreen_desc_photoNo, new Object[]{String.valueOf(this.f291249g), String.valueOf(this.f291250h)}));
        r102.f290777h.setOnClickListener(new d(this));
        Drawable r103 = ContextCompat.getDrawable(r102.f290771b.getContext(), R.drawable.larus_icon_add_photo_fill);
        if (r103 == null) goto L10;
        Drawable r104 = DrawableCompat.wrap(r103).mutate();
    L11:
        if (r104 == null) goto L13;
        DrawableCompat.setTint(r104, ContextCompat.getColor(r102.f290771b.getContext(), R.color.larus_primary_50));
    L13:
        r102.f290771b.setImageDrawable(r104);
        Unit r105 = Unit.INSTANCE;
        goto L14
    L10:
        r104 = null;
    L14:
        DigitalAvatarPreGenManager r106 = (DigitalAvatarPreGenManager) this.f291253k.getValue();
        List<ey9.k> r107 = this.F;
        ey9.k r108 = this.O;
        r106.getClass();
        ArrayList r109 = new ArrayList();
        List<ey9.k> r110 = r107;
        if (r110 != null) goto L17;
    L20:
        boolean r111 = true;
    L21:
        if (r111 == true) goto L24;
        r109.addAll(r110);
    L24:
        if (r109.isEmpty() == false) goto L27;
        if (r108 != null) goto L27;
    L29:
        boolean r112 = false;
    L107:
        if (r112 == false) goto L109;
        Y90();
    L109:
        LarusPageDigitalAvatarUploadPictureBinding r113 = this.f291247e;
        if (r113 != null) goto L112;
    L123:
        LarusPageDigitalAvatarUploadPictureBinding r114 = this.f291247e;
        if (r114 == null) goto L143;
        int r115 = m0.f375450a;
        int r116 = 4;
        if ((((m0.b(getContext()) - (j19.c.c(16) * 2)) - (j19.c.c(8) * 3)) / 4) <= j19.c.c(110)) goto L128;
        r116 = (int) Math.floor(((m0.b(getContext()) - (j19.c.c(16) * 2)) + j19.c.c(8)) / j19.c.c(118));
    L128:
        this.W = new DigitalAvatarUploadAdapter(this.f291252j.f291316c, new g(this), new h(this), new i(this), r116);
        RecyclerView r117 = r114.f290772c;
        r117.setLayoutManager(new GridLayoutManager(r117.getContext(), r116));
        r117.addItemDecoration(new UploadPhotoDecoration(r116, j19.c.c(8), ContextCompat.getColor(r117.getContext(), android.R.color.transparent)));
        r117.setAdapter(this.W);
        Unit r118 = Unit.INSTANCE;
        return;
    L143:
        return;
    L112:
        if (this.E == false) goto L117;
        AppCompatTextView r119 = r113.f290774e;
        Context r120 = getContext();
        if (r120 != null) goto L116;
        r120 = AppHost.f326268a.getApplication().getApplicationContext();
    L116:
        r119.setText(ContextCompat.getString(r120, R.string.larus_complex_search_chat_popup_step1));
    L117:
        Z90(false, false);
        e1.d(r113.f290773d, new n(this));
        ArrayList<Uri> r121 = this.f291260r;
        if (r121 == null) goto L123;
        DigitalAvatarUploadActionDelegate r122 = this.f291255m;
        if (r122 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("uploadActionDelegate");
        r122 = null;
    L122:
        r122.getClass();
        Intrinsics.checkNotNullParameter(r121, "uris");
        BuildersKt.launch$default(r122.f291230b, null, null, new DigitalAvatarUploadActionDelegate$handlePickedImages$1(r122, r121, null), 3, null);
        Unit r123 = Unit.INSTANCE;
    L27:
        int r124 = r106.f291226a.a();
        if (r124 == 0) goto L29;
        if (r108 == null) goto L55;
        String r125 = r108.d();
        if (r125 != null) goto L35;
        r125 = r108.c();
    L35:
        String r126 = r125;
        if (r126 != null) goto L38;
    L41:
        boolean r127 = true;
    L42:
        if (r127 == false) goto L132;
    L54:
        boolean r128 = true;
    L56:
        Iterator r129 = r109.iterator();
        r112 = r128;
        int r130 = 0;
        int r131 = 0;
    L58:
        if (r129.hasNext() == false) goto L107;
        Object r132 = r129.next();
        int r133 = r130 + 1;
        if (r130 >= 0) goto L62;
        CollectionsKt.throwIndexOverflow();
    L62:
        ey9.k r134 = (ey9.k) r132;
        if (r131 >= r124) goto L106;
        String r135 = r134.d();
        if (r135 != null) goto L68;
        r135 = r134.c();
    L68:
        String r136 = r135;
        if (r136 != null) goto L71;
    L74:
        boolean r137 = true;
    L75:
        if (r137 == true) goto L106;
        List<q88.d> r138 = r106.f291226a.f291316c;
        if ((r138 instanceof Collection) == true) goto L80;
    L82:
        Iterator r139 = ((ArrayList) r138).iterator();
    L84:
        if (r139.hasNext() == false) goto L92;
        Uri r140 = ((q88.d) r139.next()).f532039c;
        if (r140 == null) goto L88;
        String r141 = r140.toString();
    L90:
        if (Intrinsics.areEqual(r141, r136) == false) goto L84;
        boolean r142 = true;
    L93:
        if (r142 == true) goto L106;
        Result.Companion r143 = Result.Companion;     // Catch: Throwable -> L97
        Object r144 = Result.m9449constructorimpl(UriProtector.parse(r136));     // Catch: Throwable -> L97
    L100:
        if (Result.m9455isFailureimpl(r144) == false) goto L102;
        r144 = r101;
    L102:
        Uri r145 = (Uri) r144;
        if (r145 != null) goto L105;
        FLogger.f375446a.e("DigitalAvatarPreGenMgr", "invalid origin uri: " + r136);
        goto L106
    L105:
        String r146 = ("pre_gen_" + r130 + '_' + r136.hashCode()) + '+' + SystemClock.uptimeMillis();
        r88.a r147 = new r88.a(r146, r145, r134);
        r106.f291228c.put(r146, r147);
        r106.f291227b.prefillPreGenImage(r146, r147.f536664d, r134);
        s r148 = r106.f291226a;
        q88.d r149 = new q88.d(DigitalAvatarUploadItemType.IMAGE, DigitalAvatarUploadItemStatus.SUCCESS, r145, r146, true, 72);
        r148.getClass();
        Intrinsics.checkNotNullParameter(r149, MapController.ITEM_LAYER_TAG);
        r148.d();
        ((ArrayList) r148.f291316c).add(r149);
        r148.b();
        r131 = r131 + 1;
        r112 = true;
    L97:
        th = move-exception;
        Result.Companion r150 = Result.Companion;
        r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L100
    L88:
        r141 = r101;
    L92:
        r142 = false;
        goto L93
    L80:
        if (((ArrayList) r138).isEmpty() == false) goto L82;
    L71:
        if (StringsKt.isBlank(r136) == true) goto L74;
        r137 = false;
    L106:
        r130 = r133;
        r101 = null;
        goto L58
    L132:
        Result.Companion r151 = Result.Companion;     // Catch: Throwable -> L45
        Object r152 = Result.m9449constructorimpl(UriProtector.parse(r126));     // Catch: Throwable -> L45
    L48:
        if (Result.m9455isFailureimpl(r152) == false) goto L50;
        r152 = null;
    L50:
        Uri r153 = (Uri) r152;
        if (r153 != null) goto L53;
        FLogger.f375446a.e("DigitalAvatarPreGenMgr", "invalid origin uri: " + r126);
        goto L54
    L53:
        r88.a r154 = new r88.a("main_img", r153, r108);
        r106.f291228c.put("main_img", r154);
        r106.f291227b.prefillPreGenImage("main_img", r154.f536664d, r108);
    L45:
        th = move-exception;
        Result.Companion r155 = Result.Companion;
        r152 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L48
    L38:
        if (StringsKt.isBlank(r126) == true) goto L41;
        r127 = false;
        goto L42
    L55:
        r128 = false;
        goto L56
    L17:
        if (r110.isEmpty() == true) goto L20;
        r111 = false;
        goto L21
    }

    public static final Object V90(DigitalAvatarUploadFragment r100, Function2 r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof DigitalAvatarUploadFragment$getMainBotConversationInfo$1) == false) goto L7;
        DigitalAvatarUploadFragment$getMainBotConversationInfo$1 r103 = (DigitalAvatarUploadFragment$getMainBotConversationInfo$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        ResultKt.throwOnFailure(r105);
    L29:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r101 = (Function2) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L24:
        wc9.e r108 = (wc9.e) r105;
    L25:
        r103.L$0 = null;
        r103.label = 2;
        if (r101.invoke(r108, r103) != r106) goto L29;
        return r106;
    L16:
        ResultKt.throwOnFailure(r105);
        ILaunchCacheService r109 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r109 == null) goto L21;
        r108 = r109.b();
        if (r108 != null) goto L25;
    L21:
        Flow r110 = FlowLiveDataConversions.asFlow(AuthModelDelegate.f297134b.y());
        DigitalAvatarUploadFragment$getMainBotConversationInfo$cvs$2 r111 = new DigitalAvatarUploadFragment$getMainBotConversationInfo$cvs$2(null);
        r103.L$0 = r101;
        r103.label = 1;
        r105 = kotlinx.coroutines.flow.e.t(r110, r111, r103);
        if (r105 != r106) goto L24;
        return r106;
    L7:
        r103 = new DigitalAvatarUploadFragment$getMainBotConversationInfo$1(r100, r102);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.larus.avatar.impl.upload.k] */
    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r210, ViewGroup r211, Bundle r212) {
        Intrinsics.checkNotNullParameter(r210, "inflater");
        View r100 = r210.inflate(R.layout.larus_page_digital_avatar_upload_picture, r211, false);
        int r101 = R.id.add_photo_icon;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r100, R.id.add_photo_icon);
        if (r102 == null) goto L53;
        r101 = R.id.chosen_photo_recycler_view;
        RecyclerView r103 = (RecyclerView) ViewBindings.findChildViewById(r100, R.id.chosen_photo_recycler_view);
        if (r103 == null) goto L53;
        r101 = R.id.create_btn;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.create_btn);
        if (r104 == null) goto L53;
        r101 = R.id.create_btn_text;
        AppCompatTextView r105 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.create_btn_text);
        if (r105 == null) goto L53;
        r101 = R.id.create_loading_icon;
        RotateImageView r110 = (RotateImageView) ViewBindings.findChildViewById(r100, R.id.create_loading_icon);
        if (r110 == null) goto L53;
        r101 = R.id.guide_title_text;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.guide_title_text)) == null) goto L53;
        r101 = R.id.image_container;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.image_container)) == null) goto L53;
        r101 = R.id.linear1;
        if (((LinearLayout) ViewBindings.findChildViewById(r100, R.id.linear1)) == null) goto L53;
        r101 = R.id.linear2;
        if (((LinearLayout) ViewBindings.findChildViewById(r100, R.id.linear2)) == null) goto L53;
        r101 = R.id.linear3;
        if (((LinearLayout) ViewBindings.findChildViewById(r100, R.id.linear3)) == null) goto L53;
        r101 = R.id.linear4;
        if (((LinearLayout) ViewBindings.findChildViewById(r100, R.id.linear4)) == null) goto L53;
        r101 = R.id.scan_example1;
        if (((SimpleDraweeView) ViewBindings.findChildViewById(r100, R.id.scan_example1)) == null) goto L53;
        r101 = R.id.scan_example2;
        if (((SimpleDraweeView) ViewBindings.findChildViewById(r100, R.id.scan_example2)) == null) goto L53;
        r101 = R.id.scan_example3;
        if (((SimpleDraweeView) ViewBindings.findChildViewById(r100, R.id.scan_example3)) == null) goto L53;
        r101 = R.id.scan_example4;
        if (((SimpleDraweeView) ViewBindings.findChildViewById(r100, R.id.scan_example4)) == null) goto L53;
        r101 = R.id.tips1;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.tips1)) == null) goto L53;
        r101 = R.id.tips2;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.tips2)) == null) goto L53;
        r101 = R.id.tips3;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.tips3)) == null) goto L53;
        r101 = R.id.tips4;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.tips4)) == null) goto L53;
        r101 = R.id.title;
        NovaTitleBarEx r111 = (NovaTitleBarEx) ViewBindings.findChildViewById(r100, R.id.title);
        if (r111 == null) goto L53;
        r101 = R.id.upload_guide_content_container;
        RoundFrameLayout r112 = (RoundFrameLayout) ViewBindings.findChildViewById(r100, R.id.upload_guide_content_container);
        if (r112 == null) goto L53;
        r101 = R.id.upload_guide_content_text;
        AppCompatTextView r113 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.upload_guide_content_text);
        if (r113 == null) goto L53;
        r101 = R.id.upload_guide_title_text;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.upload_guide_title_text)) == null) goto L53;
        this.f291247e = new LarusPageDigitalAvatarUploadPictureBinding((ConstraintLayout) r100, r102, r103, r104, r105, r110, r111, r112, r113);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new DigitalAvatarUploadFragment$initObserver$1(this, null), 2, null);
        W90().getCreateAvatarStatusLiveData().observe(getViewLifecycleOwner(), new q(new k(this)));
        LarusPageDigitalAvatarUploadPictureBinding r106 = this.f291247e;
        if (r106 != null) goto L51;
        return null;
    L51:
        return r106.f290770a;
    L53:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }
}
