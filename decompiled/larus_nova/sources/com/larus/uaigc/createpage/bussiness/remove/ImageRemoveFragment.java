package com.larus.uaigc.createpage.bussiness.remove;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.community.ICreationPageService;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.kmp.chat.TemplateInfo$DefaultTab;
import com.larus.uaigc.api.ReviewUgcImageApi;
import com.larus.uaigc.applet.IAICreationAppletHostService;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.bean.createpage.component.sendmessage.CreationSendUiEvent;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.larus.uaigc.createpage.bussiness.remove.widget.GesturePaletteView;
import com.larus.uaigc.createpage.bussiness.remove.widget.PaintSizeControllerView;
import com.larus.uaigc.createpage.bussiness.remove.widget.PaletteControllerView;
import com.larus.uaigc.createpage.bussiness.remove.widget.PenSizeIllustrationView;
import com.larus.uaigc.createpage.utils.BitmapHelperKt;
import com.larus.uaigc.impl.databinding.LarusFragmentImageRemoveBinding;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.utils.FragmentExtKt$addOnBackPressed$callback$1;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.w0;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.ttm.player.MediaPlayer;
import java.io.File;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import v19.c7;
import v19.f7;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0090\u00012\u00020\u0001:\u0006\u008e\u0001\u008f\u0001\u0090\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0016J&\u00105\u001a\u0004\u0018\u0001002\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u001a\u0010:\u001a\u0002022\u0006\u0010;\u001a\u0002002\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0010\u0010<\u001a\u0002022\u0006\u0010=\u001a\u000200H\u0002J\b\u0010>\u001a\u000202H\u0002J\b\u0010?\u001a\u000202H\u0002J\b\u0010@\u001a\u000202H\u0016J\b\u0010A\u001a\u000202H\u0002J\u000f\u0010B\u001a\u0004\u0018\u000102H\u0003¢\u0006\u0002\u0010CJ\n\u0010D\u001a\u0004\u0018\u00010\u001cH\u0002J\u0016\u0010E\u001a\u0002022\u0006\u0010F\u001a\u00020GH\u0082@¢\u0006\u0002\u0010HJ\b\u0010I\u001a\u000202H\u0002J\u0010\u0010J\u001a\u0002022\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010K\u001a\u0002022\u0006\u0010L\u001a\u00020\bH\u0002J\b\u0010M\u001a\u000202H\u0002J\u0010\u0010N\u001a\u0002022\u0006\u0010O\u001a\u00020PH\u0002J\u000f\u0010Q\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0002\u0010CJ\b\u0010R\u001a\u000202H\u0002J\b\u0010S\u001a\u000202H\u0002J\b\u0010T\u001a\u00020\rH\u0002J\u000f\u0010U\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0002\u0010CJ\n\u0010V\u001a\u0004\u0018\u00010\u001cH\u0002J\u000f\u0010W\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0002\u0010CJ\u000f\u0010X\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0002\u0010CJ\n\u0010Y\u001a\u0004\u0018\u00010\u001cH\u0002J \u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020[2\u0006\u0010]\u001a\u00020\r2\u0006\u0010^\u001a\u00020\rH\u0002J\u0018\u0010_\u001a\u0004\u0018\u00010`2\u0006\u0010a\u001a\u00020[H\u0082@¢\u0006\u0002\u0010bJ\u0018\u0010c\u001a\u00020\u00172\b\u0010d\u001a\u0004\u0018\u000104H\u0082@¢\u0006\u0002\u0010eJ\u0010\u0010f\u001a\u00020\u00172\u0006\u0010g\u001a\u000204H\u0002J\u0016\u0010h\u001a\u00020\u00172\u0006\u0010g\u001a\u000204H\u0082@¢\u0006\u0002\u0010eJ\b\u0010i\u001a\u00020jH\u0002J\u0018\u0010k\u001a\u0004\u0018\u00010l*\u00020m2\b\u0010n\u001a\u0004\u0018\u00010\bH\u0002J\n\u0010o\u001a\u0004\u0018\u00010pH\u0002J\u0010\u0010q\u001a\u00020\u00172\u0006\u0010r\u001a\u00020sH\u0002J\u0016\u0010t\u001a\u00020\u00172\u0006\u0010u\u001a\u00020-H\u0082@¢\u0006\u0002\u0010vJ$\u0010w\u001a\u0004\u0018\u00010-2\b\u0010x\u001a\u0004\u0018\u00010y2\b\u0010d\u001a\u0004\u0018\u000104H\u0082@¢\u0006\u0002\u0010zJ\u0018\u0010{\u001a\u0004\u0018\u00010-2\u0006\u0010|\u001a\u00020-H\u0082@¢\u0006\u0002\u0010vJ\u001b\u0010}\u001a\u0004\u0018\u00010~2\b\u0010\u007f\u001a\u0004\u0018\u00010\bH\u0082@¢\u0006\u0003\u0010\u0080\u0001J\u000b\u0010\u0081\u0001\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u0082\u0001\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0002\u0010CJ\u0011\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0003\u0010\u0084\u0001J\u0010\u0010\u0085\u0001\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0002\u0010CJ\u0010\u0010\u0086\u0001\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0002\u0010CJF\u0010\u0087\u0001\u001a\u0002022\u0007\u0010\u0088\u0001\u001a\u00020\b2\u0015\u0010\u0089\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u008b\u0001\u0012\u0004\u0012\u0002020\u008a\u00012\u0014\u0010\u008c\u0001\u001a\u000f\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u0002020\u008a\u0001H\u0082@¢\u0006\u0003\u0010\u008d\u0001R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@BX\u0083\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0003\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0091\u0001"}, d2 = {"Lcom/larus/uaigc/createpage/bussiness/remove/ImageRemoveFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusFragmentImageRemoveBinding;", "pickLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "pickSDKLauncher", "Landroid/content/Intent;", "value", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "curPageStatus", "getCurPageStatus$annotations", "setCurPageStatus", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "curUploaderIdentifier", "mediaAttachment", "Lcom/larus/bmhome/actionbar/model/MediaAttachment;", "localImageUri", "ignoreImageSizeCheck", "", "initialPenSize", "creationId", "isImageReviewUnPass", "dismissPenSizeRingJob", "Lkotlinx/coroutines/Job;", "isOpenNewChatPage", "callback", "Lcom/larus/uaigc/bean/remove/IImageRemoveCallback;", "getCallback", "()Lcom/larus/uaigc/bean/remove/IImageRemoveCallback;", "setCallback", "(Lcom/larus/uaigc/bean/remove/IImageRemoveCallback;)V", "hostBackCallback", "Landroidx/activity/OnBackPressedCallback;", "hostUiPolicy", "Lcom/larus/uaigc/createpage/bussiness/remove/ImageRemoveFragment$ImageRemoveHostUiPolicy;", "getHostUiPolicy", "()Lcom/larus/uaigc/createpage/bussiness/remove/ImageRemoveFragment$ImageRemoveHostUiPolicy;", "hostUiPolicy$delegate", "Lkotlin/Lazy;", "creationSendMessageConfig", "Lcom/larus/uaigc/bean/createpage/CreationSendMessageConfig;", "coveredAppletPageViews", "", "Landroid/view/View;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "isolateAppletPageLayerOnAndroid10", "currentPageView", "restoreCoveredAppletPageViews", "hideInputOnEnter", "onDestroyView", "initLauncher", "initUploadingView", "()Lkotlin/Unit;", "doUpload", "handleUploadSuccess", "result", "Lcom/larus/platform/model/upload/ResourceUploadResult;", "(Lcom/larus/platform/model/upload/ResourceUploadResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleImageReviewRejected", "handleUploadAccepted", "requireSelectedImageUrlInBackground", "tosKey", "openSystemAlbum", "onAlbumSelected", "uri", "Landroid/net/Uri;", "initTitle", "initBackPressedCallback", "navigateBackOrCloseHost", "resolveHostBackIcon", "initControlPanel", "initPalette", "initFinishBtn", "adaptHostBottomMargin", "doFinish", "scaleBitmap", "Landroid/graphics/Bitmap;", "originBitmap", "newWidth", "newHeight", "saveBitmapToStableCreationCache", "Ljava/io/File;", SimplayerImageStrategy.RESULT_BITMAP, "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toChatPage", "data", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openChatBelowHostAfterMessagePrepared", "params", "tryDispatchCreationSendResultToCurrentChatBelowHost", "buildHostReturnUiEvent", "Lcom/larus/uaigc/bean/createpage/component/sendmessage/CreationSendUiEvent;", "findTargetChatFragment", "Lcom/larus/bmhome/chat/fragment/IChatFragment;", "Landroidx/fragment/app/FragmentManager;", "targetCvsId", "findNativeHostActivityBelowHost", "Landroidx/fragment/app/FragmentActivity;", "isValidNativeHostActivity", "activity", "Landroid/app/Activity;", "sendCreationMessage", "sendConfig", "(Lcom/larus/uaigc/bean/createpage/CreationSendMessageConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildCreationSendMessageConfig", "imageEditDataWithMask", "Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;", "(Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureCreationSendConversation", "config", "findSendConversation", "Lcom/larus/im/bean/conversation/Conversation;", "conversationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findCurrentChatBelowHostConversationId", "showNormal", "showEmpty", "()Ljava/lang/Boolean;", "showUploading", "showUploadFailed", "submitImageResourceAccess", "localPath", "onFailed", "Lkotlin/Function1;", "Lcom/larus/platform/model/upload/ResourceUploadError;", "onSuccess", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PageStatus", "ImageRemoveHostUiPolicy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageRemoveFragment extends Fragment {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f371433v = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusFragmentImageRemoveBinding f371434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ActivityResultLauncher<String> f371435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ActivityResultLauncher<Intent> f371436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StateFlowImpl f371437g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f371438h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MediaAttachment f371439i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f371440j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f371441k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f371442l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f371443m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f371444n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Job f371445o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f371446p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public xy9.a f371447q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public FragmentExtKt$addOnBackPressed$callback$1 f371448r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f371449s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CreationSendMessageConfig f371450t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<View> f371451u;

    public static final class ImageRemoveHostUiPolicy {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f371452c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f371453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f371454b;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/uaigc/createpage/bussiness/remove/ImageRemoveFragment$ImageRemoveHostUiPolicy$ExitBehavior;", "", "<init>", "(Ljava/lang/String;I)V", "NATIVE_FINISH", "HOST_BACK", "HOST_CLOSE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum ExitBehavior extends Enum<ExitBehavior> {
            public static final ExitBehavior HOST_BACK = null;
            public static final ExitBehavior HOST_CLOSE = null;
            public static final ExitBehavior NATIVE_FINISH = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ ExitBehavior[] f371455a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f371456b = null;

            public static EnumEntries<ExitBehavior> getEntries() {
                return f371456b;
            }

            static {
                ExitBehavior r100 = new ExitBehavior("NATIVE_FINISH", 0);
                NATIVE_FINISH = r100;
                ExitBehavior r101 = new ExitBehavior("HOST_BACK", 1);
                HOST_BACK = r101;
                ExitBehavior r102 = new ExitBehavior("HOST_CLOSE", 2);
                HOST_CLOSE = r102;
                ExitBehavior[] r103 = {r100, r101, r102};
                f371455a = r103;
                f371456b = EnumEntriesKt.enumEntries(r103);
            }

            public static ExitBehavior[] values() {
                return (ExitBehavior[]) f371455a.clone();
            }

            public static ExitBehavior valueOf(String r100) {
                return (ExitBehavior) r27.a.a(ExitBehavior.class, r100);
            }

            public ExitBehavior(String r100, int r101) {
                super(r100, r101);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/uaigc/createpage/bussiness/remove/ImageRemoveFragment$ImageRemoveHostUiPolicy$TitleLeadingAction;", "", "<init>", "(Ljava/lang/String;I)V", "CANCEL", "BACK", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum TitleLeadingAction extends Enum<TitleLeadingAction> {
            public static final TitleLeadingAction BACK = null;
            public static final TitleLeadingAction CANCEL = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ TitleLeadingAction[] f371457a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f371458b = null;

            public static EnumEntries<TitleLeadingAction> getEntries() {
                return f371458b;
            }

            static {
                TitleLeadingAction r100 = new TitleLeadingAction("CANCEL", 0);
                CANCEL = r100;
                TitleLeadingAction r101 = new TitleLeadingAction("BACK", 1);
                BACK = r101;
                TitleLeadingAction[] r102 = {r100, r101};
                f371457a = r102;
                f371458b = EnumEntriesKt.enumEntries(r102);
            }

            public static TitleLeadingAction[] values() {
                return (TitleLeadingAction[]) f371457a.clone();
            }

            public static TitleLeadingAction valueOf(String r100) {
                return (TitleLeadingAction) r27.a.a(TitleLeadingAction.class, r100);
            }

            public TitleLeadingAction(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final class a {
        }

        static {
        }

        public ImageRemoveHostUiPolicy(boolean r100, boolean r101) {
            this.f371453a = r100;
            this.f371454b = r101;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/uaigc/createpage/bussiness/remove/ImageRemoveFragment$PageStatus;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PageStatus {
        public static final a Companion = null;
        public static final int EMPTY = 2;
        public static final int NORMAL = 1;
        public static final int UPLOADING = 3;
        public static final int UPLOAD_FAILED = 4;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f371459a = null;

            static {
                f371459a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f371459a;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f371460a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f371461b = null;

        static {
            int[] r100 = new int[ImageRemoveHostUiPolicy.TitleLeadingAction.values().length];
            r100[ImageRemoveHostUiPolicy.TitleLeadingAction.BACK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[ImageRemoveHostUiPolicy.TitleLeadingAction.CANCEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            f371460a = r100;
            int[] r101 = new int[ImageRemoveHostUiPolicy.ExitBehavior.values().length];
            r101[ImageRemoveHostUiPolicy.ExitBehavior.HOST_BACK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r101[ImageRemoveHostUiPolicy.ExitBehavior.HOST_CLOSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r101[ImageRemoveHostUiPolicy.ExitBehavior.NATIVE_FINISH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            f371461b = r101;
        }
    }

    static {
    }

    public final ImageRemoveHostUiPolicy aa0() {
        return (ImageRemoveHostUiPolicy) this.f371449s.getValue();
    }

    public final void ba0() {
        t19.s r100 = t19.s.f544207a;
        Context r101 = getContext();
        r100.getClass();
        t19.s.s(r101, R.string.larus_reposition_image_error_msg);
        LarusFragmentImageRemoveBinding r102 = this.f371434d;
        if (r102 == null) goto L7;
        GesturePaletteView r103 = r102.f373135h;
        if (r103 == null) goto L7;
        r103.setImageBitmap(null);
    L7:
        ga0();
        this.f371444n = true;
    }

    public final Boolean ga0() {
        final LarusFragmentImageRemoveBinding r100 = this.f371434d;
        if (r100 == null) goto L5;
        this.f371437g.setValue(2);
        e1.o(r100.f373133f);
        return Boolean.valueOf(r100.f373138k.post(new e(this, r100)));
    L5:
        return null;
    }

    public final Unit ha0() {
        LarusFragmentImageRemoveBinding r100 = this.f371434d;
        if (r100 == null) goto L12;
        this.f371437g.setValue(1);
        t19.s r101 = t19.s.f544207a;
        Context r102 = getContext();
        Context r103 = getContext();
        if (r103 == null) goto L7;
        String r104 = r103.getString(R.string.larus_imageEdit_instruction_brushArea);
    L8:
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        t19.s.j(r101, r102, r104, 2000, false, 24);
        e1.o(r100.f373130c);
        e1.o(r100.f373133f);
        e1.x(r100.f373136i);
        r100.f373136i.animate().cancel();
        r100.f373136i.setAlpha(1.0f);
        PenSizeIllustrationView r105 = r100.f373136i;
        PaintSizeControllerView r106 = r100.f373129b.f371506a.f373262b;
        r105.setSize((r106.f371498a.f373284d.getProgress() + r106.f371500c) / 2);
        r100.f373136i.invalidate();
        this.f371445o = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ImageRemoveFragment$showNormal$1$1(r100, null), 3, null);
        return Unit.INSTANCE;
    L7:
        r104 = null;
        goto L8
    L12:
        return null;
    }

    public final Unit ia0() {
        LarusFragmentImageRemoveBinding r100 = this.f371434d;
        if (r100 == null) goto L13;
        this.f371437g.setValue(4);
        e1.o(r100.f373130c);
        e1.x(r100.f373133f);
        if (r100.f373135h.getViewBitmap() == null) goto L11;
        e1.x(r100.f373132e);
        View r101 = r100.f373132e;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L10;
        RectF r103 = r100.f373135h.getCurBitmapRect();
        r102.width = (int) (((double) r103.width()) + 0.5d);
        r102.height = (int) (((double) r103.height()) + 0.5d);
        r101.setLayoutParams(r102);
    L12:
        e1.o(r100.f373134g);
        e1.x(r100.f373137j);
        return Unit.INSTANCE;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L11:
        e1.o(r100.f373132e);
        goto L12
    L13:
        return null;
    }

    public final Unit ja0() {
        LarusFragmentImageRemoveBinding r100 = this.f371434d;
        if (r100 == null) goto L13;
        this.f371437g.setValue(3);
        e1.o(r100.f373130c);
        e1.x(r100.f373134g);
        e1.o(r100.f373137j);
        e1.x(r100.f373133f);
        if (r100.f373135h.getViewBitmap() == null) goto L11;
        e1.x(r100.f373132e);
        View r101 = r100.f373132e;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L10;
        RectF r103 = r100.f373135h.getCurBitmapRect();
        r102.width = (int) (((double) r103.width()) + 0.5d);
        r102.height = (int) (((double) r103.height()) + 0.5d);
        r101.setLayoutParams(r102);
    L15:
        return Unit.INSTANCE;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L11:
        e1.o(r100.f373132e);
        goto L15
    L13:
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        Iterator r100 = ((ArrayList) this.f371451u).iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        View r101 = (View) r100.next();
        if (r101.getParent() == null) goto L4;
        r101.setVisibility(0);
        goto L4
    L8:
        ((ArrayList) this.f371451u).clear();
        super.onDestroyView();
        FragmentExtKt$addOnBackPressed$callback$1 r102 = this.f371448r;
        if (r102 == null) goto L11;
        r102.remove();
    L11:
        this.f371448r = null;
        this.f371434d = null;
        ICreationResourceAccessService.a.a(ICreationResourceAccessService.f373925a, this.f371438h);
    }

    public ImageRemoveFragment() {
        this.f371437g = j1.a(2);
        this.f371438h = "";
        this.f371442l = c7.b(40);
        this.f371449s = LazyKt.lazy(new d(this));
        this.f371451u = new ArrayList();
    }

    public final FragmentActivity X90() {
        FragmentActivity r100 = getActivity();
        if (r100 != null) goto L5;
        return null;
    L5:
        List<Activity> r101 = AppHost.f326268a.a().g();
        ListIterator<Activity> r102 = r101.listIterator(r101.size());
    L7:
        if (r102.hasPrevious() == false) goto L14;
        if (r102.previous() != r100) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L7;
        int r104 = r102.nextIndex();
    L15:
        if (r104 <= 0) goto L36;
        Iterator r105 = CollectionsKt.asReversed(r101.subList(0, r104)).iterator();
    L18:
        if (r105.hasNext() == false) goto L29;
        Object r106 = r105.next();
        Activity r107 = (Activity) r106;
        cy9.a.f465949a.getClass();
        if (cy9.a.d(r107) == false) goto L22;
    L26:
        boolean r108 = false;
    L27:
        if (r108 == false) goto L18;
    L30:
        Activity r109 = (Activity) r106;
        if (r109 == null) goto L36;
        if ((r109 instanceof FragmentActivity) == true) goto L35;
        return null;
    L35:
        return (FragmentActivity) r109;
    L22:
        if (r107.isFinishing() == true) goto L26;
        if (r107.isDestroyed() == true) goto L26;
        r108 = true;
        goto L27
    L29:
        r106 = null;
    L36:
        ListIterator<Activity> r110 = r101.listIterator(r101.size());
    L38:
        if (r110.hasPrevious() == false) goto L54;
        Activity r111 = r110.previous();
        Activity r112 = r111;
        if (r112.getTaskId() == r100.getTaskId()) goto L51;
        cy9.a.f465949a.getClass();
        if (cy9.a.d(r112) == false) goto L44;
    L48:
        boolean r113 = false;
    L49:
        if (r113 == false) goto L51;
        boolean r114 = true;
    L52:
        if (r114 == false) goto L38;
    L56:
        if ((r111 instanceof FragmentActivity) == true) goto L58;
        return null;
    L58:
        return (FragmentActivity) r111;
    L44:
        if (r112.isFinishing() == true) goto L48;
        if (r112.isDestroyed() == true) goto L48;
        r113 = true;
    L51:
        r114 = false;
        goto L52
    L54:
        r111 = null;
        goto L56
    L11:
        r103 = false;
        goto L12
    L14:
        r104 = -1;
        goto L15
    }

    public final void da0() {
        ImageRemoveHostUiPolicy r100 = aa0();
        if (r100.f371453a == true) goto L6;
        ImageRemoveHostUiPolicy.ExitBehavior r101 = ImageRemoveHostUiPolicy.ExitBehavior.NATIVE_FINISH;
    L9:
        int r102 = b.f371461b[r101.ordinal()];
        if (r102 != 1) goto L12;
        ICreationWorkflowService.f373940a.H(new g(this));
        return;
    L12:
        if (r102 == 2) goto L21;
        if (r102 != 3) goto L19;
        FragmentActivity r103 = getActivity();
        if (r103 == null) goto L27;
        r103.finish();
        return;
    L27:
        return;
    L19:
        throw new NoWhenBranchMatchedException();
    L21:
        if (ICreationWorkflowService.f373940a.L() == true) goto L29;
        FragmentActivity r104 = getActivity();
        if (r104 == null) goto L30;
        r104.finish();
        return;
    L30:
        return;
    L29:
        return;
    L6:
        if (r100.f371454b == false) goto L8;
        r101 = ImageRemoveHostUiPolicy.ExitBehavior.HOST_BACK;
        goto L9
    L8:
        r101 = ImageRemoveHostUiPolicy.ExitBehavior.HOST_CLOSE;
        goto L9
    }

    public final void ca0(mr9.l r210) {
        ha0();
        String r100 = r210.f515022a;
        mr9.d r101 = r210.f515025d;
        long r102 = 0;
        if (r101 == null) goto L5;
        long r103 = r101.f514992b;
    L6:
        Long r104 = Long.valueOf(r103);
        mr9.d r105 = r210.f515025d;
        if (r105 == null) goto L9;
        r102 = r105.f514991a;
    L9:
        this.f371439i = new MediaAttachment(null, r100, new ImageUploadInfo(r104, Long.valueOf(r102)), null, null, null, null, null, null, null, null, null, 4088, null);
        String r106 = r210.f515022a;
        if (r106 != null) goto L12;
        r106 = "";
    L12:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ImageRemoveFragment$requireSelectedImageUrlInBackground$1(r106, this, null), 3, null);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public final void ea0(Uri r100) {
        LarusFragmentImageRemoveBinding r101 = this.f371434d;
        if (r101 == null) goto L27;
        File r102 = null;
        if (this.f371444n == false) goto L22;
        ImageRemoveFragment r103 = new ImageRemoveFragment();
        Bundle r104 = getArguments();
        if (r104 == null) goto L9;
        r104.putString("input_image_uri", r100.toString());
        r104.putString("media_attachment", "");
        r104.putInt("initial_pen_size", ((int) r101.f373136i.getSize()) * 2);
    L10:
        r103.setArguments(r104);
        FragmentActivity r105 = getActivity();
        if (r105 == null) goto L28;
        FragmentManager r106 = r105.getSupportFragmentManager();
        if (r106 == null) goto L29;
        FragmentTransaction r107 = r106.beginTransaction();
        if (r107 != null) goto L17;
        return;
    L17:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r107, r103, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.fragment_container) == true) goto L20;
        r107 = r107.replace(R.id.fragment_container, r103);
    L20:
        if (r107 == null) goto L31;
        r107.commitNowAllowingStateLoss();
        return;
    L31:
        return;
    L29:
        return;
    L28:
        return;
    L9:
        r104 = null;
        goto L10
    L22:
        String r108 = r100.toString();
        this.f371440j = r108;
        this.f371439i = null;
        GesturePaletteView r109 = r101.f373135h;
        Uri r110 = UriProtector.parse(r108);
        FragmentActivity r111 = getActivity();
        if (r111 == null) goto L25;
        r102 = r111.getCacheDir();
    L25:
        r109.q(r110, Uri.fromFile(new PolarisFileWrapper(r102, "ugc_image_edit_cache.jpeg")));
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        r101.setClassLoader(CreationSendMessageConfig.class.getClassLoader());
    L5:
        Bundle r102 = getArguments();
        Object r103 = null;
        if (r102 == null) goto L8;
        Serializable r104 = r102.getSerializable("media_attachment");
    L10:
        if ((r104 instanceof MediaAttachment) == false) goto L12;
        MediaAttachment r105 = (MediaAttachment) r104;
    L13:
        this.f371439i = r105;
        Bundle r106 = getArguments();
        if (r106 == null) goto L16;
        String r107 = r106.getString("input_image_uri");
    L17:
        this.f371440j = r107;
        Bundle r108 = getArguments();
        boolean r109 = false;
        if (r108 == null) goto L20;
        this.f371441k = r108.getBoolean("ignore_image_size_check", false);
    L20:
        Bundle r110 = getArguments();
        if (r110 == null) goto L23;
        String r111 = r110.getString("actionbar_creation_id");
    L24:
        this.f371443m = r111;
        Bundle r112 = getArguments();
        if (r112 == null) goto L27;
        boolean r113 = r112.getBoolean("open_new_chat_page", false);
    L28:
        this.f371446p = r113;
        Bundle r114 = getArguments();
        if (r114 == null) goto L31;
        int r115 = r114.getInt("initial_pen_size");
    L32:
        this.f371442l = r115;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L43
        Bundle r117 = getArguments();     // Catch: Throwable -> L43
        if (r117 == null) goto L36;
        Serializable r118 = r117.getSerializable("creation_send_message_config");     // Catch: Throwable -> L43
    L38:
        if ((r118 instanceof CreationSendMessageConfig) == false) goto L40;
        CreationSendMessageConfig r119 = (CreationSendMessageConfig) r118;     // Catch: Throwable -> L43
    L41:
        Object r120 = Result.m9449constructorimpl(r119);     // Catch: Throwable -> L43
    L45:
        Throwable r121 = Result.m9452exceptionOrNullimpl(r120);
        if (r121 == null) goto L49;
        FLogger.f375446a.e("ImageRemoveFragment", "read creation send config failed", r121);
    L49:
        if (Result.m9455isFailureimpl(r120) == true) goto L52;
        r103 = r120;
    L52:
        this.f371450t = (CreationSendMessageConfig) r103;
        FLogger r122 = FLogger.f375446a;
        StringBuilder r123 = new StringBuilder("onCreate hasCreationSendConfig=");
        if (this.f371450t == null) goto L55;
        r109 = true;
    L55:
        r123.append(r109);
        r123.append(", useHost=");
        r123.append(aa0().f371453a);
        r122.i("ImageRemoveFragment", r123.toString());
        return;
    L40:
        r119 = null;
        goto L41
    L36:
        r118 = null;
    L43:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L45
    L31:
        r115 = this.f371442l;
        goto L32
    L27:
        r113 = false;
        goto L28
    L23:
        r111 = null;
        goto L24
    L16:
        r107 = null;
        goto L17
    L12:
        r105 = null;
        goto L13
    L8:
        r104 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static xe8.a Z90(FragmentManager r100, String r101) {
        Iterator<T> r102 = r100.getFragments().iterator();
    L3:
        xe8.a r103 = null;
        if (r102.hasNext() == false) goto L29;
        Fragment r104 = (Fragment) r102.next();
        if ((r104 instanceof xe8.a) == false) goto L8;
        xe8.a r105 = (xe8.a) r104;
    L9:
        if (r105 == null) goto L26;
        boolean r106 = true;
        if (r101 != null) goto L13;
    L16:
        boolean r107 = true;
    L17:
        if (r107 == false) goto L19;
    L22:
        if (r106 == false) goto L24;
        r103 = r105;
    L24:
        if (r103 == null) goto L26;
        return r103;
    L19:
        if (Intrinsics.areEqual(r105.getConversationId(), r101) == true) goto L22;
        r106 = false;
        goto L22
    L13:
        if (r101.length() == 0) goto L16;
        r107 = false;
    L26:
        xe8.a r108 = Z90(r104.getChildFragmentManager(), r101);
        if (r108 == null) goto L3;
        return r108;
    L8:
        r105 = null;
        goto L9
    L29:
        return null;
    }

    public final Object W90(CreationSendMessageConfig r310, Continuation<? super CreationSendMessageConfig> r410) {
        if ((r410 instanceof ImageRemoveFragment$ensureCreationSendConversation$1) == false) goto L7;
        ImageRemoveFragment$ensureCreationSendConversation$1 r100 = (ImageRemoveFragment$ensureCreationSendConversation$1) r410;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = false;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        String r106 = (String) r100.L$1;
        CreationSendMessageConfig r107 = (CreationSendMessageConfig) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L99:
        wc9.e r108 = (wc9.e) r102;
        CreationSendMessageConfig r109 = r107;
        String r110 = r106;
    L100:
        wc9.e r111 = r108;
        if (r110 != null) goto L112;
        if (r111 == null) goto L111;
        r110 = r111.f559198a;
        if (r110 == null) goto L111;
        if (r110.length() <= 0) goto L108;
        boolean r112 = true;
    L109:
        if (r112 == false) goto L111;
    L108:
        r112 = false;
    L111:
        String r113 = null;
    L113:
        if (r111 == null) goto L124;
        if (r113 != null) goto L116;
    L119:
        boolean r114 = true;
    L120:
        if (r114 == true) goto L124;
        return CreationSendMessageConfig.copy$default(r109, r113, null, r111, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217722, null);
    L116:
        if (r113.length() == 0) goto L119;
        r114 = false;
    L124:
        FLogger r115 = FLogger.f375446a;
        StringBuilder r116 = new StringBuilder("ensureCreationSendConversation failed, conversationNull:");
        if (r111 != null) goto L127;
        boolean r117 = true;
    L128:
        r116.append(r117);
        r116.append(", cvsIdEmpty:");
        if (r113 != null) goto L131;
    L132:
        r105 = true;
    L133:
        r116.append(r105);
        r115.e("ImageRemoveFragment", r116.toString());
        return null;
    L131:
        if (r113.length() != 0) goto L133;
    L127:
        r117 = false;
    L112:
        r113 = r110;
        goto L113
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        if (aa0().f371453a == false) goto L31;
        FragmentActivity r118 = X90();
        if (r118 == null) goto L31;
        FragmentManager r119 = r118.getSupportFragmentManager();
        if (r119 == null) goto L31;
        xe8.a r120 = Z90(r119, null);
        if (r120 == null) goto L31;
        r110 = r120.getConversationId();
        if (r110 == null) goto L31;
        if (r110.length() <= 0) goto L28;
        boolean r121 = true;
    L29:
        if (r121 == false) goto L31;
    L33:
        if (aa0().f371453a == false) goto L55;
        if (r110 != null) goto L76;
        r110 = r310.getCvsId();
        if (r110 != null) goto L38;
    L43:
        r110 = null;
    L44:
        if (r110 != null) goto L76;
        wc9.e r122 = r310.getConversation();
        if (r122 == null) goto L75;
        r110 = r122.f559198a;
        if (r110 == null) goto L75;
        if (r110.length() <= 0) goto L52;
        boolean r123 = true;
    L53:
        if (r123 == false) goto L75;
    L52:
        r123 = false;
    L75:
        r110 = null;
        goto L76
    L38:
        if (r110.length() <= 0) goto L40;
        boolean r124 = true;
    L41:
        if (r124 == false) goto L43;
    L40:
        r124 = false;
    L76:
        r108 = r310.getConversation();
        if (r108 == null) goto L95;
        if (r110 != null) goto L80;
    L83:
        boolean r125 = true;
    L84:
        if (r125 == false) goto L86;
    L89:
        boolean r126 = true;
    L90:
        if (r126 == true) goto L93;
        r108 = null;
    L93:
        if (r108 == null) goto L95;
        r109 = r310;
        goto L100
    L86:
        if (Intrinsics.areEqual(r108.f559198a, r110) == true) goto L89;
        r126 = false;
        goto L90
    L80:
        if (r110.length() == 0) goto L83;
        r125 = false;
    L95:
        r100.L$0 = r310;
        r100.L$1 = r110;
        r100.label = 1;
        Object r127 = Y90(r110, r100);
        if (r127 != r103) goto L98;
        return r103;
    L98:
        r106 = r110;
        r102 = r127;
        r107 = r310;
        goto L99
    L55:
        r110 = r310.getCvsId();
        if (r110 != null) goto L58;
    L65:
        wc9.e r128 = r310.getConversation();
        if (r128 == null) goto L75;
        r110 = r128.f559198a;
        if (r110 == null) goto L75;
        if (r110.length() <= 0) goto L72;
        boolean r129 = true;
    L73:
        if (r129 == false) goto L75;
    L72:
        r129 = false;
        goto L73
    L58:
        if (r110.length() <= 0) goto L60;
        boolean r130 = true;
    L61:
        if (r130 == true) goto L64;
        r110 = null;
    L64:
        if (r110 != null) goto L76;
    L60:
        r130 = false;
        goto L61
    L28:
        r121 = false;
    L31:
        r110 = null;
    L7:
        r100 = new ImageRemoveFragment$ensureCreationSendConversation$1(this, r410);
        goto L8
    }

    public final Object Y90(String r510, Continuation<? super wc9.e> r511) {
        if ((r511 instanceof ImageRemoveFragment$findSendConversation$1) == false) goto L7;
        ImageRemoveFragment$findSendConversation$1 r100 = (ImageRemoveFragment$findSendConversation$1) r511;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        ResultKt.throwOnFailure(r102);
    L49:
        wc9.e r105 = (wc9.e) r102;
        if (r105 != null) goto L56;
        AuthModelDelegate r106 = AuthModelDelegate.f297134b;
        wc9.e r107 = r106.y().getValue();
        if (r107 != null) goto L55;
        return r106.u().getValue();
    L55:
        return r107;
    L56:
        return r105;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r108 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        String r110 = r108;
    L38:
        wc9.e r109 = (wc9.e) r102;
        if (r109 == null) goto L42;
        return r109;
    L42:
        if (aa0().f371453a == false) goto L45;
        return null;
    L45:
        return new wc9.e(r110, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, 0, null, null, 0, -2, 63);
    L17:
        String r111 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r110 = r111;
    L32:
        wc9.e r112 = (wc9.e) r102;
        if (r112 == null) goto L35;
        return r112;
    L35:
        IConversationRepoService r113 = RepoDispatcherDelegate.f307737b.f();
        r100.L$0 = r110;
        r100.label = 2;
        r102 = IConversationRepoService.a.c(r113, r110, true, null, r100, 4);
        if (r102 != r103) goto L38;
        return r103;
    L18:
        ResultKt.throwOnFailure(r102);
        if (r510 != null) goto L21;
    L46:
        IConversationRepoService r114 = RepoDispatcherDelegate.f307737b.f();
        r100.label = 3;
        r102 = r114.f(r100);
        if (r102 != r103) goto L49;
        return r103;
    L21:
        if (r510.length() <= 0) goto L23;
        boolean r115 = true;
    L24:
        if (r115 == false) goto L26;
        String r116 = r510;
    L27:
        if (r116 == null) goto L46;
        IConversationRepoService r117 = RepoDispatcherDelegate.f307737b.f();
        r100.L$0 = r116;
        r100.label = 1;
        Object r118 = IConversationRepoService.a.c(r117, r116, false, null, r100, 4);
        if (r118 != r103) goto L31;
        return r103;
    L31:
        r110 = r116;
        r102 = r118;
        goto L32
    L26:
        r116 = null;
        goto L27
    L23:
        r115 = false;
    L7:
        r100 = new ImageRemoveFragment$findSendConversation$1(this, r511);
        goto L8
    }

    public final Object fa0(CreationSendMessageConfig r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof ImageRemoveFragment$sendCreationMessage$1) == false) goto L7;
        ImageRemoveFragment$sendCreationMessage$1 r102 = (ImageRemoveFragment$sendCreationMessage$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L21
    L19:
        Object r107 = Result.m9449constructorimpl(Boxing.boxBoolean(((Boolean) r104).booleanValue()));     // Catch: Throwable -> L21
    L23:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L26;
        FLogger.f375446a.e("ImageRemoveFragment", "sendCreationMessage failed", r108);
    L26:
        Boolean r109 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r107) == true) goto L29;
        return r107;
    L29:
        return r109;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L21
        ICreationWorkflowService.Companion r111 = ICreationWorkflowService.f373940a;     // Catch: Throwable -> L21
        r102.label = 1;     // Catch: Throwable -> L21
        r104 = r111.W(r100, r102);     // Catch: Throwable -> L21
        if (r104 != r105) goto L19;
        return r105;
    L21:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = new ImageRemoveFragment$sendCreationMessage$1(this, r101);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.uaigc.createpage.bussiness.remove.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v4, types: [com.larus.uaigc.createpage.bussiness.remove.a] */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.larus.uaigc.createpage.bussiness.remove.i] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        ViewGroup r100 = null;
        int r101 = 0;
        if (aa0().f371453a == false) goto L22;
        View r112 = getView();
        if (r112 == null) goto L8;
        r112.clearFocus();
    L8:
        Context r113 = getContext();
        if (r113 == null) goto L11;
        Object r114 = r113.getSystemService("input_method");
    L13:
        if ((r114 instanceof InputMethodManager) == false) goto L15;
        InputMethodManager r115 = (InputMethodManager) r114;
    L16:
        if (r115 == null) goto L22;
        View r102 = getView();
        if (r102 == null) goto L20;
        IBinder r103 = r102.getWindowToken();
    L21:
        r115.hideSoftInputFromWindow(r103, 0);
        goto L22
    L20:
        r103 = null;
        goto L21
    L15:
        r115 = null;
        goto L16
    L11:
        r114 = null;
    L22:
        this.f371435e = registerForActivityResult(new ActivityResultContracts.GetContent(), new j(this));
        this.f371436f = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new k(this));
        LarusFragmentImageRemoveBinding r116 = this.f371434d;
        boolean r104 = true;
        if (r116 == null) goto L48;
        NovaTitleBarEx.Y5(r116.f373139l, r116.f373138k.getContext().getString(R.string.larus_imageEdit_page_remove), null, null, 6);
        if (aa0().f371453a == false) goto L46;
        NovaTitleBarEx r105 = r116.f373139l;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L45;
        ConstraintLayout.LayoutParams r107 = (ConstraintLayout.LayoutParams) r106;
        i0.f375410a.getClass();
        ((ViewGroup.MarginLayoutParams) r107).topMargin = i0.g();
        r105.setLayoutParams(r107);
        if (aa0().f371454b == false) goto L31;
        ImageRemoveHostUiPolicy.TitleLeadingAction r108 = ImageRemoveHostUiPolicy.TitleLeadingAction.BACK;
    L32:
        int r109 = b.f371460a[r108.ordinal()];
        if (r109 != 1) goto L35;
        View r117 = r116.f373139l.Z5(R.drawable.larus_ic_ai_creation_applet_back_button, true, ImageView.ScaleType.CENTER_INSIDE, r116.f373138k.getContext().getString(R.string.larus_accessibility_icon_back), new l(this));
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
        if (r118 == null) goto L43;
        ViewGroup.MarginLayoutParams r119 = (ViewGroup.MarginLayoutParams) r118;
        r119.width = c7.b(36);
        r119.height = c7.b(36);
        r119.setMarginStart(c7.b(12));
        r117.setLayoutParams(r119);
    L47:
        r116.f373139l.getBinding().f326842h.setTypeface(Typeface.defaultFromStyle(0));
        Unit r120 = Unit.INSTANCE;
        goto L48
    L43:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L35:
        if (r109 != 2) goto L38;
        r116.f373139l.c6(r116.f373138k.getContext().getString(R.string.larus_cancel), null, new m(this));
        goto L47
    L38:
        throw new NoWhenBranchMatchedException();
    L31:
        r108 = ImageRemoveHostUiPolicy.TitleLeadingAction.CANCEL;
        goto L32
    L45:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L46:
        r116.f373139l.c6(r116.f373138k.getContext().getString(R.string.larus_cancel), null, new n(this));
    L48:
        ImageRemoveHostUiPolicy r121 = aa0();
        if (this.f371448r == null) goto L51;
        boolean r122 = true;
    L53:
        if (r121.f371453a == true) goto L55;
    L58:
        r104 = false;
    L59:
        if (r104 == false) goto L62;
        this.f371448r = com.larus.utils.v.a(this, new c(this));
    L62:
        LarusFragmentImageRemoveBinding r123 = this.f371434d;
        if (r123 == null) goto L65;
        w0.e(r123.f373130c, c7.b(8));
        e1.d(r123.f373130c, new o(this));
        e1.d(r123.f373137j, new p(this));
        r123.f373133f.setOnTouchListener(new q());
        Unit r124 = Unit.INSTANCE;
    L65:
        final LarusFragmentImageRemoveBinding r125 = this.f371434d;
        if (r125 == null) goto L68;
        r125.f373129b.setConfig(new PaletteControllerView.b(new PaintSizeControllerView.b(c7.b(24), c7.b(70), new u(r125, this)), new com.larus.uaigc.createpage.bussiness.remove.a(r125), new i(r125)));
        Unit r126 = Unit.INSTANCE;
    L68:
        LarusFragmentImageRemoveBinding r127 = this.f371434d;
        if (r127 == null) goto L71;
        e1.d(r127.f373131d, new f(this));
        Unit r128 = Unit.INSTANCE;
    L71:
        final LarusFragmentImageRemoveBinding r129 = this.f371434d;
        if (r129 == null) goto L91;
        if (aa0().f371453a == false) goto L89;
        ViewGroup.LayoutParams r130 = r129.f373131d.getLayoutParams();
        if ((r130 instanceof ConstraintLayout.LayoutParams) == false) goto L79;
        ConstraintLayout.LayoutParams r131 = (ConstraintLayout.LayoutParams) r130;
    L80:
        if (r131 == null) goto L82;
        final int r132 = ((ViewGroup.MarginLayoutParams) r131).bottomMargin;
    L83:
        final int r133 = c7.b(16);
        TextView r134 = r129.f373131d;
        final ?? r135 = new com.larus.uaigc.createpage.bussiness.remove.b(r129, r132, r133);
        Intrinsics.checkNotNullParameter(r134, "<this>");
        Intrinsics.checkNotNullParameter(r135, "callback");
        WindowInsetsCompat r136 = ViewCompat.getRootWindowInsets(r134);
        if (r136 == null) goto L88;
        Insets r137 = r136.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r137 == null) goto L88;
        r135.invoke(r137);
    L88:
        ViewCompat.setOnApplyWindowInsetsListener(r134, new f7(r135));
        goto L89
    L82:
        r132 = 0;
        goto L83
    L79:
        r131 = null;
    L89:
        Unit r138 = Unit.INSTANCE;
    L91:
        if (Build.VERSION.SDK_INT != 29) goto L114;
        int r139 = com.larus.uaigc.applet.a.f370285a;
        if (IAICreationAppletHostService.f370273a.t(getArguments()) == false) goto L115;
        ViewParent r140 = r110.getParent();
        if ((r140 instanceof ViewGroup) == false) goto L98;
        r100 = (ViewGroup) r140;
    L98:
        if (r100 == null) goto L116;
        ((ArrayList) this.f371451u).clear();
        int r141 = r100.getChildCount();
    L101:
        if (r101 >= r141) goto L108;
        View r142 = r100.getChildAt(r101);
        if (r142 == r110) goto L107;
        if (r142.getVisibility() != 0) goto L107;
        List<View> r143 = this.f371451u;
        Intrinsics.checkNotNull(r142);
        ((ArrayList) r143).add(r142);
        r142.setVisibility(4);
    L107:
        r101 = r101 + 1;
        goto L101
    L108:
        r110.bringToFront();
        r100.invalidate();
        FLogger.f375446a.i("ImageRemoveFragment", "isolate applet page layer, coveredViews=" + ((ArrayList) this.f371451u).size());
        return;
    L116:
        return;
    L115:
        return;
    L114:
        return;
    L55:
        if (r121.f371454b == false) goto L58;
        if (r122 == true) goto L58;
    L51:
        r122 = false;
        goto L53
    }

    public static final Object S90(ImageRemoveFragment r100, mr9.l r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof ImageRemoveFragment$handleUploadSuccess$1) == false) goto L7;
        ImageRemoveFragment$handleUploadSuccess$1 r103 = (ImageRemoveFragment$handleUploadSuccess$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        boolean r108 = true;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = (mr9.l) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L20:
        dm9.a r109 = (dm9.a) r105;
        boolean r110 = r109 instanceof dm9.a.b;
        if (r110 == false) goto L35;
        dm9.a.b r111 = (dm9.a.b) r109;
        if (r111.f469231a.isSuccess() == false) goto L35;
        ReviewUgcImageApi.c r112 = (ReviewUgcImageApi.c) r111.f469231a.getData();
        if (r112 == null) goto L32;
        Integer r113 = r112.a();
        if (r113 == null) goto L32;
        if (r113.intValue() != 3) goto L32;
    L33:
        if (r108 == false) goto L35;
        r100.ba0();
    L41:
        return Unit.INSTANCE;
    L32:
        r108 = false;
    L35:
        if (r110 == false) goto L37;
    L39:
        r100.ca0(r101);
        goto L41
    L37:
        if (NetworkUtils.isNetworkAvailable(r100.getContext()) == true) goto L39;
        r100.ia0();
        t19.s r114 = t19.s.f544207a;
        Context r115 = r100.getContext();
        r114.getClass();
        t19.s.s(r115, R.string.larus_network_error);
        goto L41
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        com.larus.uaigc.helper.f.f373014a.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L17;
        r100.ca0(r101);
        return Unit.INSTANCE;
    L17:
        ReviewUgcImageApi.Companion r116 = ReviewUgcImageApi.f370263a;
        ImageRemoveFragment$handleUploadSuccess$checkResult$1 r117 = new ImageRemoveFragment$handleUploadSuccess$checkResult$1(r101, null);
        r103.L$0 = r101;
        r103.label = 1;
        r116.getClass();
        r105 = ReviewUgcImageApi.Companion.a(r117, r103);
        if (r105 != r106) goto L20;
        return r106;
    L7:
        r103 = new ImageRemoveFragment$handleUploadSuccess$1(r100, r102);
        goto L8
    }

    public static final Object T90(ImageRemoveFragment r100, Bitmap r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof ImageRemoveFragment$saveBitmapToStableCreationCache$1) == false) goto L7;
        ImageRemoveFragment$saveBitmapToStableCreationCache$1 r103 = (ImageRemoveFragment$saveBitmapToStableCreationCache$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        File r108 = (File) r103.L$0;
        ResultKt.throwOnFailure(r105);
        File r109 = r108;
    L19:
        if (((Boolean) r105).booleanValue() == true) goto L24;
        return null;
    L24:
        return r109;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        File r110 = ICreationWorkflowService.f373940a.T(LoadParams.ImageFormat.JPEG);
        String r111 = r110.getAbsolutePath();
        r103.L$0 = r110;
        r103.label = 1;
        Object r112 = BitmapHelperKt.e(r101, r111, 100, r103);
        if (r112 == r106) goto L23;
        r109 = r110;
        r105 = r112;
        goto L19
    L23:
        return r106;
    L7:
        r103 = new ImageRemoveFragment$saveBitmapToStableCreationCache$1(r100, r102);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r34v0, types: [androidx.fragment.app.Fragment, com.larus.uaigc.createpage.bussiness.remove.ImageRemoveFragment, java.lang.Object] */
    public static final Object U90(ImageRemoveFragment r310, Bundle r311, Continuation r312) {
        Bundle r100 = r311;
        r310.getClass();
        if ((r312 instanceof ImageRemoveFragment$toChatPage$1) == false) goto L7;
        ImageRemoveFragment$toChatPage$1 r101 = (ImageRemoveFragment$toChatPage$1) r312;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = false;
        String r110 = null;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L16;
        if (r105 != 3) goto L15;
        int r107 = r101.I$0;
        Bundle r108 = (Bundle) r101.L$0;
        ResultKt.throwOnFailure(r103);
        ?? r109 = r107;
    L90:
        if (((Boolean) r103).booleanValue() == true) goto L140;
        Bundle r111 = r108;
    L93:
        ImageRemoveHostUiPolicy r112 = r310.aa0();
        CreationSendMessageConfig r113 = r310.f371450t;
        if (r109 == 0) goto L96;
        boolean r114 = true;
    L98:
        if (r112.f371453a == false) goto L102;
        if (r113 == null) goto L102;
        if (r114 == false) goto L102;
        boolean r115 = true;
    L103:
        if (r115 == false) goto L136;
        Context r116 = r310.getContext();
        if (r116 == null) goto L128;
        Bundle r117 = new Bundle(r111);
        CreationSendMessageConfig r118 = r310.f371450t;
        if (r118 == null) goto L111;
        String r119 = r118.getBotId();
        if (r119 == null) goto L111;
    L119:
        r117.putString("argBotId", r119);
        CreationSendMessageConfig r120 = r310.f371450t;
        if (r120 == null) goto L122;
        r110 = r120.getCvsId();
    L122:
        r117.putString("argConversationId", r110);
        r117.putInt("default_tab", TemplateInfo$DefaultTab.CHAT.ordinal());
        ICreationWorkflowService.Companion r121 = ICreationWorkflowService.f373940a;
        Bundle r122 = r310.getArguments();
        if (r122 != null) goto L125;
    L127:
        r106 = r121.U(r116, r106, r117, true);
        goto L128
    L125:
        if (r122.getBoolean("is_from_chat_double_page") != true) goto L127;
        r106 = true;
    L111:
        r119 = r117.getString("argBotId");
        if (r119 != null) goto L119;
        e0 r123 = AuthModelDelegate.f297134b.e().getValue();
        if (r123 == null) goto L118;
        LaunchInfo r124 = r123.f297186a;
        if (r124 == null) goto L118;
        r119 = r124.W();
    L118:
        r119 = null;
    L128:
        if (r106 == true) goto L141;
        FLogger.f375446a.e("ImageRemoveFragment", "toChatPage dispatch applet result failed, close applet after message prepared");
        int r125 = com.larus.uaigc.applet.a.f370285a;
        if (IAICreationAppletHostService.f370273a.i(true) == true) goto L142;
        FragmentActivity r126 = r310.getActivity();
        if (r126 == null) goto L142;
        r126.finish();
    L142:
        return Boxing.boxBoolean(true);
    L141:
        return Boxing.boxBoolean(true);
    L136:
        com.bytedance.router.i r127 = SmartRouter.buildRoute(r310.getContext(), "//flow/chat_page");
        r127.f267554c.putExtras(r111);
        r127.f267555d = R.anim.larus_router_slide_in_right;
        r127.f267556e = R.anim.larus_router_no_anim;
        r127.d();
        return Boxing.boxBoolean(false);
    L102:
        r115 = false;
        goto L103
    L96:
        r114 = false;
        goto L98
    L140:
        return Boxing.boxBoolean(true);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        CreationSendMessageConfig r128 = (CreationSendMessageConfig) r101.L$1;
        Bundle r129 = (Bundle) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L35:
        boolean r130 = ((Boolean) r103).booleanValue();
        CreationSendMessageConfig r131 = r128;
        r109 = r130;
    L37:
        if (r131 == null) goto L40;
        if (r109 != 0) goto L40;
        FLogger.f375446a.e("ImageRemoveFragment", "toChatPage sendCreationMessage failed");
        return Boxing.boxBoolean(false);
    L40:
        ImageRemoveHostUiPolicy r132 = r310.aa0();
        CreationSendMessageConfig r133 = r310.f371450t;
        if (r132.f371453a == false) goto L45;
        if (r133 == null) goto L45;
        if (r109 != 0) goto L45;
        boolean r134 = true;
    L46:
        if (r134 == false) goto L48;
        FLogger.f375446a.e("ImageRemoveFragment", "toChatPage skip applet close because creation message was not sent");
        return Boxing.boxBoolean(false);
    L48:
        e0 r135 = AuthModelDelegate.f297134b.e().getValue();
        if (r135 == null) goto L53;
        LaunchInfo r136 = r135.f297186a;
        if (r136 == null) goto L53;
        String r137 = r136.W();
    L54:
        r111 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argBotId", r137)});
        Bundle r138 = r310.getArguments();
        if (r138 == null) goto L57;
        r111.putAll(r138);
    L57:
        if (r129 == null) goto L59;
        r111.putAll(r129);
    L59:
        if (r109 == 0) goto L75;
        r111.remove("image_edit_data.with_mask");
        r111.remove("creation_send_message_config");
        r111.remove("media_attachment");
        r111.remove("open_new_chat_page");
        r111.remove("ignore_image_size_check");
        r111.remove("actionbar_instruction_prompt");
        CreationSendMessageConfig r139 = r310.f371450t;
        if (r139 == null) goto L63;
        String r140 = r139.getCvsId();
    L64:
        r111.putString("argConversationId", r140);
        CreationSendMessageConfig r141 = r310.f371450t;
        if (r141 == null) goto L67;
        String r142 = r141.getCvsId();
    L68:
        CreationSendMessageConfig r143 = r310.f371450t;
        if (r143 != null) goto L71;
    L73:
        boolean r210 = false;
    L74:
        r111.putSerializable("creation_send_ui_event", new CreationSendUiEvent(r142, null, false, true, true, true, true, false, false, true, true, true, true, r210, true, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSION_TIME_MS, null));
        goto L75
    L71:
        if (r143.getClearInputContent() != true) goto L73;
        r210 = true;
        goto L74
    L67:
        r142 = null;
        goto L68
    L63:
        r140 = null;
    L75:
        ImageRemoveHostUiPolicy r144 = r310.aa0();
        CreationSendMessageConfig r145 = r310.f371450t;
        if (r144.f371453a == false) goto L80;
        if (r145 == null) goto L80;
        if (r109 == 0) goto L80;
        boolean r146 = true;
    L81:
        if (r146 == false) goto L93;
        r101.L$0 = r111;
        r101.L$1 = null;
        r101.I$0 = r109;
        r101.label = 3;
        if (r310.aa0().f371453a == true) goto L85;
        Object r147 = Boxing.boxBoolean(false);
    L86:
        if (r147 == r104) goto L145;
        Object r313 = r147;
        r108 = r111;
        r103 = r313;
        r109 = r109;
        goto L90
    L145:
        return r104;
    L85:
        r147 = BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new ImageRemoveFragment$tryDispatchCreationSendResultToCurrentChatBelowHost$2(r111, r310, null), r101);
    L80:
        r146 = false;
    L53:
        r137 = null;
    L45:
        r134 = false;
        goto L46
    L17:
        r100 = (Bundle) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L29:
        r131 = (CreationSendMessageConfig) r103;
        if (r131 == null) goto L36;
        r101.L$0 = r100;
        r101.L$1 = r131;
        r101.label = 2;
        Object r148 = r310.fa0(r131, r101);
        if (r148 == r104) goto L144;
        r129 = r100;
        r128 = r131;
        r103 = r148;
        goto L35
    L144:
        return r104;
    L36:
        r129 = r100;
        r109 = 0;
        goto L37
    L18:
        ResultKt.throwOnFailure(r103);
        if (r100 == null) goto L21;
        Serializable r149 = r100.getSerializable("image_edit_data.with_mask");
    L23:
        if ((r149 instanceof ImageEditDataWithMask) == false) goto L25;
        ImageEditDataWithMask r150 = (ImageEditDataWithMask) r149;
    L26:
        r101.L$0 = r100;
        r101.label = 1;
        r103 = r310.V90(r150, r100, r101);
        if (r103 != r104) goto L29;
        return r104;
    L25:
        r150 = null;
        goto L26
    L21:
        r149 = null;
    L7:
        r101 = new ImageRemoveFragment$toChatPage$1(r310, r312);
        goto L8
    }

    public final Object V90(ImageEditDataWithMask r310, Bundle r410, Continuation<? super CreationSendMessageConfig> r411) {
        if ((r411 instanceof ImageRemoveFragment$buildCreationSendMessageConfig$1) == false) goto L7;
        ImageRemoveFragment$buildCreationSendMessageConfig$1 r100 = (ImageRemoveFragment$buildCreationSendMessageConfig$1) r411;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 != 1) goto L15;
        ImageRemoveFragment r105 = (ImageRemoveFragment) r100.L$2;
        Bundle r106 = (Bundle) r100.L$1;
        ImageEditDataWithMask r107 = (ImageEditDataWithMask) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L76
        ImageEditDataWithMask r210 = r107;
    L34:
        CreationSendMessageConfig r108 = (CreationSendMessageConfig) r102;     // Catch: Throwable -> L76
        if (r108 != null) goto L37;
        return null;
    L37:
        r105.f371450t = r108;     // Catch: Throwable -> L76
        if (r106 == null) goto L40;
        ICoreInputAbility.MessageExtMap r109 = (ICoreInputAbility.MessageExtMap) r106.getParcelable("actionbar_instruction_message_ext_map");     // Catch: Throwable -> L76
    L42:
        if ((r109 instanceof ICoreInputAbility.MessageExtMap) == true) goto L45;
        r109 = null;
    L45:
        if (r109 == null) goto L47;
        Map<String, String> r110 = r109.f298403a;     // Catch: Throwable -> L76
    L48:
        if (r110 == null) goto L54;
        Map<String, String> r111 = r108.getActionBarInstructionMap();     // Catch: Throwable -> L76
        if (r111 != null) goto L52;
        r111 = MapsKt.emptyMap();     // Catch: Throwable -> L76
    L52:
        Map<String, String> r112 = MapsKt.plus(r111, r110);     // Catch: Throwable -> L76
        if (r112 == null) goto L54;
    L55:
        if (r106 == null) goto L58;
        String r113 = r106.getString("creation_send_trace_id");     // Catch: Throwable -> L76
        if (r113 == null) goto L58;
    L59:
        String r211 = r113;
        Bundle r114 = r105.getArguments();     // Catch: Throwable -> L76
        if (r114 == null) goto L64;
        Bundle r115 = r114.getBundle("instruction_hit_point_params");     // Catch: Throwable -> L76
        if (r115 == null) goto L64;
        ny9.u r116 = new ny9.u(new ny9.s(r115));     // Catch: Throwable -> L76
    L65:
        if (r112 != null) goto L67;
        r112 = MapsKt.emptyMap();     // Catch: Throwable -> L76
    L67:
        zd9.h.f571481a.getClass();     // Catch: Throwable -> L76
        String r117 = zd9.h.c(r210);     // Catch: Throwable -> L76
        if (r117 != null) goto L70;
        r117 = "";
    L70:
        Map r118 = MapsKt.plus(r112, MapsKt.mapOf(TuplesKt.to("image_edit_media_data", r117)));     // Catch: Throwable -> L76
        ny9.u r119 = r108.getHitPointData();     // Catch: Throwable -> L76
        if (r119 != null) goto L73;
        ny9.u r212 = r116;
    L74:
        CreationSendMessageConfig r120 = CreationSendMessageConfig.copy$default(r108, null, null, null, null, null, null, null, null, Boxing.boxInt(16), r118, null, null, r210, null, r212, null, null, null, r211, null, null, false, null, null, false, false, null, 133931263, null);     // Catch: Throwable -> L76
        r105.f371450t = r120;     // Catch: Throwable -> L76
        Object r121 = Result.m9449constructorimpl(r120);     // Catch: Throwable -> L76
    L78:
        Throwable r122 = Result.m9452exceptionOrNullimpl(r121);
        if (r122 == null) goto L82;
        FLogger.f375446a.e("ImageRemoveFragment", "buildCreationSendMessageConfig failed", r122);
    L82:
        if (Result.m9455isFailureimpl(r121) == false) goto L85;
        return null;
    L85:
        return r121;
    L73:
        r212 = r119;
    L64:
        r116 = null;
    L58:
        r113 = r108.getCreationSendTraceId();     // Catch: Throwable -> L76
    L54:
        r112 = r108.getActionBarInstructionMap();     // Catch: Throwable -> L76
        goto L55
    L47:
        r110 = null;
        goto L48
    L40:
        r109 = null;
        goto L42
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r102);
        CreationSendMessageConfig r123 = this.f371450t;
        if (r123 != null) goto L19;
        return null;
    L19:
        if (r310 != null) goto L22;
        return null;
    L22:
        if (aa0().f371453a == true) goto L27;
        ICreationPageService.f310717a.getClass();
        if (ICreationPageService.a.a() == true) goto L27;
        boolean r124 = false;
    L28:
        if (r124 == true) goto L30;
        return null;
    L30:
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L76
        r100.L$0 = r310;     // Catch: Throwable -> L76
        r100.L$1 = r410;     // Catch: Throwable -> L76
        r100.L$2 = this;     // Catch: Throwable -> L76
        r100.label = 1;     // Catch: Throwable -> L76
        r102 = W90(r123, r100);     // Catch: Throwable -> L76
        if (r102 != r103) goto L33;
        return r103;
    L33:
        r210 = r310;
        r105 = this;
        r106 = r410;
    L27:
        r124 = true;
    L76:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new ImageRemoveFragment$buildCreationSendMessageConfig$1(this, r411);
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r100 = r110.inflate(R.layout.larus_fragment_image_remove, r210, false);
        int r101 = R.id.center_icon;
        if (((ImageView) ViewBindings.findChildViewById(r100, R.id.center_icon)) == null) goto L46;
        r101 = R.id.center_text;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.center_text)) == null) goto L46;
        r101 = R.id.control_panel;
        PaletteControllerView r102 = (PaletteControllerView) ViewBindings.findChildViewById(r100, R.id.control_panel);
        if (r102 == null) goto L46;
        r101 = R.id.empty_container;
        FrameLayout r103 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.empty_container);
        if (r103 == null) goto L46;
        r101 = R.id.finish_btn;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r100, R.id.finish_btn);
        if (r104 == null) goto L46;
        r101 = R.id.gray_mask;
        View r105 = ViewBindings.findChildViewById(r100, R.id.gray_mask);
        if (r105 == null) goto L46;
        r101 = R.id.layer_above_img;
        FrameLayout r111 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.layer_above_img);
        if (r111 == null) goto L46;
        r101 = R.id.loading;
        ProgressBar r112 = (ProgressBar) ViewBindings.findChildViewById(r100, R.id.loading);
        if (r112 == null) goto L46;
        r101 = R.id.palette_view;
        GesturePaletteView r106 = (GesturePaletteView) ViewBindings.findChildViewById(r100, R.id.palette_view);
        if (r106 == null) goto L46;
        r101 = R.id.pen_size_ring;
        PenSizeIllustrationView r113 = (PenSizeIllustrationView) ViewBindings.findChildViewById(r100, R.id.pen_size_ring);
        if (r113 == null) goto L46;
        r101 = R.id.retry_ll;
        LinearLayout r114 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.retry_ll);
        if (r114 == null) goto L46;
        ConstraintLayout r107 = (ConstraintLayout) r100;
        NovaTitleBarEx r115 = (NovaTitleBarEx) ViewBindings.findChildViewById(r100, R.id.title);
        if (r115 == null) goto L44;
        final LarusFragmentImageRemoveBinding r108 = new LarusFragmentImageRemoveBinding(r107, r102, r103, r104, r105, r111, r112, r106, r113, r114, r107, r115);
        this.f371434d = r108;
        String r109 = this.f371440j;
        if (r109 == null) goto L29;
        ja0();
        ea0(UriProtector.parse(r109));
        Unit r116 = Unit.INSTANCE;
    L42:
        r106.setTransformImageListener(new ImageRemoveFragment$initPalette$1$3(this, r108));
        r106.setPenPxSize(this.f371442l);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ImageRemoveFragment$initPalette$1$4(r108, this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ImageRemoveFragment$initPalette$1$5(r108, null), 3, null);
        return r107;
    L29:
        MediaAttachment r117 = this.f371439i;
        if (r117 == null) goto L39;
        String r118 = r117.getLocalFilePath();
        if (r118 != null) goto L34;
        r118 = "";
    L34:
        Uri r119 = UriProtector.parse(r118);
        FragmentActivity r120 = getActivity();
        if (r120 == null) goto L37;
        File r121 = r120.getCacheDir();
    L38:
        r106.q(r119, Uri.fromFile(new PolarisFileWrapper(r121, "ugc_image_edit_cache.jpeg")));
        Unit r122 = Unit.INSTANCE;
    L40:
        if (r122 != null) goto L42;
        ga0();
        goto L42
    L37:
        r121 = null;
        goto L38
    L39:
        r122 = null;
        goto L40
    L44:
        r101 = R.id.title;
    L46:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }
}
