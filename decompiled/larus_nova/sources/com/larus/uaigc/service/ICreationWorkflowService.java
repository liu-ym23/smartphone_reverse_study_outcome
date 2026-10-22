package com.larus.uaigc.service;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewStub;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentActivity;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.bmhome.creative.loading.MessageLoadingUIState;
import com.larus.platform.api.creation.UserCreation;
import com.larus.uaigc.bean.chat.ImageDetailFragmentDsl;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 f2\u00020\u0001:\u0001fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001e\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\rH&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u000bH&J\"\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000bH&J\"\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000bH&J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u000bH&J\u0016\u0010\u001d\u001a\u00020\u000b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001fH&J\b\u0010 \u001a\u00020\u000bH&J\u0012\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010#H&J8\u0010$\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020'2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00030)H&J$\u0010*\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00030)H&J*\u0010+\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u00152\b\b\u0002\u0010%\u001a\u00020\u000bH&J\u001a\u0010.\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020/2\b\b\u0002\u00100\u001a\u000201H&J<\u00102\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020/2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00103\u001a\u00020\u000b2\u0016\b\u0002\u00104\u001a\u0010\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u0003\u0018\u00010)H&J\u0018\u00106\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020/2\u0006\u00107\u001a\u000208H&J\b\u00109\u001a\u00020:H&J\u0010\u0010;\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020<H&J*\u0010=\u001a\u0004\u0018\u00010>2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH¦@¢\u0006\u0002\u0010CJ*\u0010D\u001a\u0004\u0018\u00010>2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH¦@¢\u0006\u0002\u0010CJ\b\u0010E\u001a\u00020FH&J*\u0010G\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010H\u001a\b\u0012\u0004\u0012\u00020J0I2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010LH'J \u0010M\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020OH&J\u0012\u0010Q\u001a\u00020>2\b\b\u0002\u0010R\u001a\u00020BH&J\b\u0010S\u001a\u00020TH&J\u0010\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020XH&J.\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020X2\u0014\u0010^\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020a\u0018\u00010`0_H&J\b\u0010b\u001a\u00020\u0003H&J\u0016\u0010c\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020dH¦@¢\u0006\u0002\u0010e¨\u0006g"}, d2 = {"Lcom/larus/uaigc/service/ICreationWorkflowService;", "", "openCreatePage", "", "config", "Lcom/larus/uaigc/bean/createpage/ICreatePageConfig;", "openCreatePageForResult", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "openAICreationAppletCreatePage", "", "openCanvasInAICreationApplet", "Lcom/larus/canvas/service/bean/ICanvasInitConfig;", "getCanvasInAICreationAppletIntent", "prewarmAICreationApplet", "shouldOpenAICreationAppletFromBottomTab", "openCreationDetailInApplet", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "asRoot", "openImageRemoveInApplet", "openProfileInApplet", "openNativeMineProfileFromAICreationApplet", "notifyAICreationAppletPublishSuccess", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "navigateBackInAICreationApplet", "onFallback", "Lkotlin/Function0;", "closeAICreationApplet", "isAICreationAppletActivity", "activity", "Landroid/app/Activity;", "routeNativeBelowAICreationApplet", "clearAICreationHomeMemory", "closeDelayMs", "", "routeAction", "Lkotlin/Function1;", "routeNativeBelowAICreationAppletAndMoveToBack", "openChatBelowAICreationAppletIfNeeded", "isChatDoublePage", "params", "sendRemoteImageAndTextMessage", "Lcom/larus/uaigc/bean/ImageEditSendMessageStrategyConfig;", "instructionType", "", "sendImageAndTextMessage", "needPreprocessImage", "uploadSuccessCallback", "Lcom/larus/uaigc/bean/UploadSuccessData;", "sendImageRemoveMessage", "imageEditDataWithMask", "Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;", "getAspectRatioSelectStrategy", "Lcom/larus/uaigc/bean/IAspectRatioSelectStrategy;", "getCreationIntent", "Lcom/larus/uaigc/bean/createpage/CreatePageConfig;", "saveBitmapToCleanableDir", "Ljava/io/File;", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "fileName", "", "(Landroid/content/Context;Landroid/graphics/Bitmap;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveBitMapToFile", "createImageRemoveDialogFragment", "Lcom/larus/uaigc/bean/remove/IImageRemoveDialogFragment;", "openBigImagesFragment", "properties", "Lcom/larus/uaigc/bean/chat/ImageDetailFragmentProp;", "Lcom/larus/bmhome/creation/bean/ICreationContentData;", "galleryContext", "Lcom/larus/uaigc/bean/chat/gallery/CreationGalleryContext;", "copyUri", "sourceUri", "Landroid/net/Uri;", "destinationUri", "buildSendImgCacheFile", "formatSuffix", "creationPagePerfMonitorHelper", "Lcom/larus/uaigc/bean/createpage/trace/ICreationPagePerfMonitorHelper;", "createCreationQueuingTaskViewModel", "Lcom/larus/bmhome/chat/component/loading/ICreationQueuingTaskViewModel;", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "createImageLoadingProgressComponent", "Lcom/larus/uaigc/bean/chat/loading/ILoadingProgress;", "sketchProgressLoadingViewStub", "Landroid/view/ViewStub;", "scope", "loadingProgressState", "Lkotlin/Lazy;", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/bmhome/creative/loading/MessageLoadingUIState;", "clearCreationActionbarDependencyCache", "sendCreationMessage", "Lcom/larus/uaigc/bean/createpage/CreationSendMessageConfig;", "(Lcom/larus/uaigc/bean/createpage/CreationSendMessageConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICreationWorkflowService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f373940a = null;

    @Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0001J\t\u0010\n\u001a\u00020\u000bH\u0096\u0001J!\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096\u0001J/\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0014\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d0\u001cH\u0096\u0001J\t\u0010\u001f\u001a\u00020 H\u0096\u0001J\t\u0010!\u001a\u00020\"H\u0096\u0001J\t\u0010#\u001a\u00020$H\u0096\u0001J\u0013\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(H\u0096\u0001J\u0011\u0010)\u001a\u00020&2\u0006\u0010'\u001a\u00020*H\u0096\u0001J\u0013\u0010+\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0001J\t\u0010,\u001a\u00020\u000bH\u0096\u0001J\u0017\u0010,\u001a\u00020\u000b2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0.H\u0096\u0001J\u0011\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u000201H\u0096\u0001J\u0011\u00102\u001a\u00020\u000b2\u0006\u0010'\u001a\u000203H\u0096\u0001J)\u00104\u001a\u00020\t2\u0006\u00105\u001a\u0002062\f\u00107\u001a\b\u0012\u0004\u0012\u000209082\b\u0010:\u001a\u0004\u0018\u00010;H\u0097\u0001J\u0011\u0010<\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(H\u0096\u0001J)\u0010=\u001a\u00020\u000b2\u0006\u00105\u001a\u0002062\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010B\u001a\u00020\t2\u0006\u0010'\u001a\u000203H\u0096\u0001J\u001f\u0010C\u001a\u00020\t2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020&0E2\u0006\u0010'\u001a\u000203H\u0096\u0001J!\u0010F\u001a\u00020\u000b2\u0006\u00105\u001a\u0002062\u0006\u0010G\u001a\u00020@2\u0006\u0010H\u001a\u00020\u000bH\u0096\u0001J!\u0010I\u001a\u00020\u000b2\u0006\u00105\u001a\u0002062\u0006\u0010G\u001a\u00020@2\u0006\u0010H\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010J\u001a\u00020\u000b2\u0006\u00105\u001a\u000206H\u0096\u0001J\u0019\u0010K\u001a\u00020\u000b2\u0006\u00105\u001a\u0002062\u0006\u0010G\u001a\u00020@H\u0096\u0001J\t\u0010L\u001a\u00020\tH\u0096\u0001J5\u0010M\u001a\u00020\u000b2\u0006\u00105\u001a\u0002062\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020O2\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\t0QH\u0096\u0001J%\u0010R\u001a\u00020\u000b2\u0006\u00105\u001a\u0002062\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\t0QH\u0096\u0001J*\u0010S\u001a\u0004\u0018\u00010\u00052\b\u00105\u001a\u0004\u0018\u0001062\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0007H\u0096A¢\u0006\u0002\u0010WJ*\u0010X\u001a\u0004\u0018\u00010\u00052\b\u00105\u001a\u0004\u0018\u0001062\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0007H\u0096A¢\u0006\u0002\u0010WJ\u0016\u0010Y\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020ZH\u0096A¢\u0006\u0002\u0010[J7\u0010\\\u001a\u00020\t2\u0006\u0010'\u001a\u00020]2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\u000b2\u0014\u0010a\u001a\u0010\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020\t\u0018\u00010QH\u0096\u0001J\u0019\u0010c\u001a\u00020\t2\u0006\u0010'\u001a\u00020]2\u0006\u0010d\u001a\u00020eH\u0096\u0001J\u0019\u0010f\u001a\u00020\t2\u0006\u0010'\u001a\u00020]2\u0006\u0010^\u001a\u00020_H\u0096\u0001J\t\u0010g\u001a\u00020\u000bH\u0096\u0001¨\u0006h"}, d2 = {"Lcom/larus/uaigc/service/ICreationWorkflowService$Companion;", "Lcom/larus/uaigc/service/ICreationWorkflowService;", "<init>", "()V", "buildSendImgCacheFile", "Ljava/io/File;", "formatSuffix", "", "clearCreationActionbarDependencyCache", "", "closeAICreationApplet", "", "copyUri", "activity", "Landroid/app/Activity;", "sourceUri", "Landroid/net/Uri;", "destinationUri", "createCreationQueuingTaskViewModel", "Lcom/larus/bmhome/chat/component/loading/ICreationQueuingTaskViewModel;", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "createImageLoadingProgressComponent", "Lcom/larus/uaigc/bean/chat/loading/ILoadingProgress;", "sketchProgressLoadingViewStub", "Landroid/view/ViewStub;", "scope", "loadingProgressState", "Lkotlin/Lazy;", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/bmhome/creative/loading/MessageLoadingUIState;", "createImageRemoveDialogFragment", "Lcom/larus/uaigc/bean/remove/IImageRemoveDialogFragment;", "creationPagePerfMonitorHelper", "Lcom/larus/uaigc/bean/createpage/trace/ICreationPagePerfMonitorHelper;", "getAspectRatioSelectStrategy", "Lcom/larus/uaigc/bean/IAspectRatioSelectStrategy;", "getCanvasInAICreationAppletIntent", "Landroid/content/Intent;", "config", "Lcom/larus/canvas/service/bean/ICanvasInitConfig;", "getCreationIntent", "Lcom/larus/uaigc/bean/createpage/CreatePageConfig;", "isAICreationAppletActivity", "navigateBackInAICreationApplet", "onFallback", "Lkotlin/Function0;", "notifyAICreationAppletPublishSuccess", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "openAICreationAppletCreatePage", "Lcom/larus/uaigc/bean/createpage/ICreatePageConfig;", "openBigImagesFragment", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "properties", "Lcom/larus/uaigc/bean/chat/ImageDetailFragmentProp;", "Lcom/larus/bmhome/creation/bean/ICreationContentData;", "galleryContext", "Lcom/larus/uaigc/bean/chat/gallery/CreationGalleryContext;", "openCanvasInAICreationApplet", "openChatBelowAICreationAppletIfNeeded", "isChatDoublePage", "params", "Landroid/os/Bundle;", "clearAICreationHomeMemory", "openCreatePage", "openCreatePageForResult", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "openCreationDetailInApplet", "bundle", "asRoot", "openImageRemoveInApplet", "openNativeMineProfileFromAICreationApplet", "openProfileInApplet", "prewarmAICreationApplet", "routeNativeBelowAICreationApplet", "closeDelayMs", "", "routeAction", "Lkotlin/Function1;", "routeNativeBelowAICreationAppletAndMoveToBack", "saveBitMapToFile", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "fileName", "(Landroid/content/Context;Landroid/graphics/Bitmap;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveBitmapToCleanableDir", "sendCreationMessage", "Lcom/larus/uaigc/bean/createpage/CreationSendMessageConfig;", "(Lcom/larus/uaigc/bean/createpage/CreationSendMessageConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendImageAndTextMessage", "Lcom/larus/uaigc/bean/ImageEditSendMessageStrategyConfig;", "instructionType", "", "needPreprocessImage", "uploadSuccessCallback", "Lcom/larus/uaigc/bean/UploadSuccessData;", "sendImageRemoveMessage", "imageEditDataWithMask", "Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;", "sendRemoteImageAndTextMessage", "shouldOpenAICreationAppletFromBottomTab", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ICreationWorkflowService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f373941c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ICreationWorkflowService f373942b;

        static {
            f373941c = new Companion();
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final void A(ActivityResultLauncher<Intent> r100, ny9.c r101) {
            Intrinsics.checkNotNullParameter(r100, "activityResultLauncher");
            Intrinsics.checkNotNullParameter(r101, "config");
            this.f373942b.A(r100, r101);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final xy9.b E() {
            return this.f373942b.E();
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final hy9.c F() {
            return this.f373942b.F();
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final void G(hy9.f r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "config");
            this.f373942b.G(r100, r101);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final boolean H(Function0<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "onFallback");
            return this.f373942b.H(r100);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final ly9.a I(ViewStub r100, CoroutineScope r101, Lazy<? extends i1<MessageLoadingUIState>> r102) {
            Intrinsics.checkNotNullParameter(r100, "sketchProgressLoadingViewStub");
            Intrinsics.checkNotNullParameter(r101, "scope");
            Intrinsics.checkNotNullParameter(r102, "loadingProgressState");
            return this.f373942b.I(r100, r101, r102);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final void J() {
            this.f373942b.J();
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final boolean K(Context r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "bundle");
            return this.f373942b.K(r100, r101);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final boolean L() {
            return this.f373942b.L();
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final void M(FragmentActivity r100, Uri r101, Uri r102) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "sourceUri");
            Intrinsics.checkNotNullParameter(r102, "destinationUri");
            this.f373942b.M(r100, r101, r102);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final boolean N(ny8.e r100) {
            Intrinsics.checkNotNullParameter(r100, "config");
            return this.f373942b.N(r100);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final boolean O(Context r100, Bundle r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "bundle");
            return this.f373942b.O(r100, r101, r102);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final zd8.a P(CoroutineScope r100) {
            Intrinsics.checkNotNullParameter(r100, "viewModelScope");
            return this.f373942b.P(r100);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final void Q(hy9.f r100, int r101, boolean r102, Function1<? super hy9.j, Unit> r103) {
            Intrinsics.checkNotNullParameter(r100, "config");
            this.f373942b.Q(r100, r101, r102, r103);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final void R(UserCreation r100) {
            Intrinsics.checkNotNullParameter(r100, "userCreation");
            this.f373942b.R(r100);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final boolean S(Context r100, Function1<? super Context, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "routeAction");
            return this.f373942b.S(r100, r101);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final File T(String r100) {
            Intrinsics.checkNotNullParameter(r100, "formatSuffix");
            return this.f373942b.T(r100);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final boolean U(Context r100, boolean r101, Bundle r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "params");
            return this.f373942b.U(r100, r101, r102, r103);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final boolean V() {
            return this.f373942b.V();
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final Object W(CreationSendMessageConfig r100, Continuation<? super Boolean> r101) {
            return this.f373942b.W(r100, r101);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final void X() {
            this.f373942b.X();
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final vy9.a Y() {
            return this.f373942b.Y();
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final boolean Z() {
            return this.f373942b.Z();
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final boolean a0(Context r100, long r101, Function1 r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "routeAction");
            return this.f373942b.a0(r100, r101, r102);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        @ImageDetailFragmentDsl
        public final void b0(Context r100, iy9.a<? extends zo8.a> r101, jy9.x r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "properties");
            this.f373942b.b0(r100, r101, r102);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final boolean c0(ny9.b r100) {
            Intrinsics.checkNotNullParameter(r100, "config");
            return this.f373942b.c0(r100);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final boolean d0(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return this.f373942b.d0(r100);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final Object e(Context r100, Bitmap r101, String r102, Continuation<? super File> r103) {
            return this.f373942b.e(r100, r101, r102, r103);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final boolean e0(Context r100, Bundle r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "bundle");
            return this.f373942b.e0(r100, r101, r102);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final void f0(ny9.c r100) {
            Intrinsics.checkNotNullParameter(r100, "config");
            this.f373942b.f0(r100);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final Object m(Context r100, Bitmap r101, String r102, Continuation<? super File> r103) {
            return this.f373942b.m(r100, r101, r102, r103);
        }

        @Override // com.larus.uaigc.service.ICreationWorkflowService
        public final void x(hy9.f r100, ImageEditDataWithMask r101) {
            Intrinsics.checkNotNullParameter(r100, "config");
            Intrinsics.checkNotNullParameter(r101, "imageEditDataWithMask");
            this.f373942b.x(r100, r101);
        }

        private Companion() {
            ICreationWorkflowService r100 = (ICreationWorkflowService) ServiceManager.get().getService(ICreationWorkflowService.class);
            if (r100 != null) goto L5;
            r100 = new ICreationWorkflowServiceNoop();
        L5:
            this.f373942b = r100;
        }
    }

    /* JADX INFO: loaded from: classes31.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(Companion r100, hy9.f r101, int r102, boolean r103, Function1 r104, int r105) {
            if ((r105 & 2) == 0) goto L6;
            r102 = 4;
        L6:
            if ((r105 & 4) == 0) goto L9;
            r103 = true;
        L9:
            if ((r105 & 8) == 0) goto L11;
            r104 = null;
        L11:
            r100.Q(r101, r102, r103, r104);
        }
    }

    static {
        f373940a = Companion.f373941c;
    }

    void A(ActivityResultLauncher<Intent> r100, ny9.c r101);

    xy9.b E();

    hy9.c F();

    void G(hy9.f r100, int r101);

    boolean H(Function0<Unit> r100);

    ly9.a I(ViewStub r100, CoroutineScope r101, Lazy<? extends i1<MessageLoadingUIState>> r102);

    void J();

    boolean K(Context r100, Bundle r101);

    boolean L();

    void M(FragmentActivity r100, Uri r101, Uri r102);

    boolean N(ny8.e r100);

    boolean O(Context r100, Bundle r101, boolean r102);

    zd8.a P(CoroutineScope r100);

    void Q(hy9.f r100, int r101, boolean r102, Function1<? super hy9.j, Unit> r103);

    void R(UserCreation r100);

    boolean S(Context r100, Function1<? super Context, Unit> r101);

    File T(String r100);

    boolean U(Context r100, boolean r101, Bundle r102, boolean r103);

    boolean V();

    Object W(CreationSendMessageConfig r100, Continuation<? super Boolean> r101);

    void X();

    vy9.a Y();

    boolean Z();

    boolean a0(Context r100, long r101, Function1 r102);

    @ImageDetailFragmentDsl
    void b0(Context r100, iy9.a<? extends zo8.a> r101, jy9.x r102);

    boolean c0(ny9.b r100);

    boolean d0(Context r100);

    Object e(Context r100, Bitmap r101, String r102, Continuation<? super File> r103);

    boolean e0(Context r100, Bundle r101, boolean r102);

    void f0(ny9.c r100);

    Object m(Context r100, Bitmap r101, String r102, Continuation<? super File> r103);

    void x(hy9.f r100, ImageEditDataWithMask r101);
}
