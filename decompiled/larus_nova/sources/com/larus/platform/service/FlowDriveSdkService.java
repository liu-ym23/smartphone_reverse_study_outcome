package com.larus.platform.service;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.baidu.platform.comapi.map.MapController;
import com.google.gson.Gson;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalInputComponent;
import com.larus.platform.api.DriveFileSelectScene;
import com.larus.platform.api.FlowDriveFileSendInfo;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.api.IAiFilePreviewService;
import com.larus.platform.api.IFlowDriveSdkService;
import com.larus.platform.api.fileselect.DriveUplinkInfo;
import com.larus.platform.api.fileselect.SelectDialogParam;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0011J(\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096@¢\u0006\u0002\u0010\u0011J,\u0010!\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001c0'J\u0012\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010\u0016J0\u0010+\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0016JL\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u00162\u0006\u00102\u001a\u0002032\u000e\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001052\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010=\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010@\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020?H\u0016JG\u0010A\u001a\u00020\u001c2\u0006\u0010/\u001a\u0002002\b\u0010B\u001a\u0004\u0018\u00010\u00162\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u00101\u001a\u0004\u0018\u00010\u00162\b\u0010>\u001a\u0004\u0018\u00010EH\u0016¢\u0006\u0002\u0010FJ$\u0010G\u001a\u00020\u001c2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u00162\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0010\u0010J\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020KH\u0016J\u0010\u0010L\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020KH\u0016J \u0010M\u001a\u00020\u001c2\b\u00101\u001a\u0004\u0018\u00010\u00162\f\u0010N\u001a\b\u0012\u0004\u0012\u00020O05H\u0016JO\u0010P\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020R2\u0006\u0010\"\u001a\u00020#2%\u0010S\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(W\u0012\u0004\u0012\u00020\u001c\u0018\u00010T2\u000e\u0010X\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010'H\u0016Ja\u0010Y\u001a\u0004\u0018\u00010\u00162\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010Z\u001a\u00020\u00162\u0006\u0010[\u001a\u0002082\u0006\u0010\\\u001a\u0002082#\u0010S\u001a\u001f\u0012\u0013\u0012\u00110\u0016¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(]\u0012\u0004\u0012\u00020\u001c\u0018\u00010T2\u000e\u0010X\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010'H\u0016JJ\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020\u00162\u0006\u0010`\u001a\u0002062\u0006\u0010\"\u001a\u00020#2\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001c0T2\u0014\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010TH\u0016J \u0010a\u001a\u0004\u0018\u00010\u00162\u0006\u0010_\u001a\u00020\u00162\u0006\u0010`\u001a\u000206H\u0096@¢\u0006\u0002\u0010bJ\u0018\u0010c\u001a\u0004\u0018\u00010\u00162\u0006\u0010d\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010eJ\u0014\u0010f\u001a\u0004\u0018\u00010g2\b\u0010h\u001a\u0004\u0018\u00010\u0016H\u0016J\u000f\u0010i\u001a\u0004\u0018\u000108H\u0016¢\u0006\u0002\u0010jJ\u000f\u0010k\u001a\u0004\u0018\u000108H\u0016¢\u0006\u0002\u0010jJ\u0018\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u0002082\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J#\u0010o\u001a\u0004\u0018\u00010\u00162\b\u0010n\u001a\u0004\u0018\u00010D2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010pJ\u0019\u0010q\u001a\u0004\u0018\u0001082\b\u0010r\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010sR\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006t"}, d2 = {"Lcom/larus/platform/service/FlowDriveSdkService;", "Lcom/larus/platform/api/IFlowDriveSdkService;", "<init>", "()V", "service", "getService", "()Lcom/larus/platform/api/IFlowDriveSdkService;", "service$delegate", "Lkotlin/Lazy;", "aiFilePreviewService", "Lcom/larus/platform/api/IAiFilePreviewService;", "getAiFilePreviewService", "()Lcom/larus/platform/api/IAiFilePreviewService;", "aiFilePreviewService$delegate", "supportsLocalFilePreview", "", "prepareLocalFilePreview", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openLocalFilePreview", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "filePath", "", "fileName", "localFileProviderAuthority", "isDriveAccessible", "isDriveAccessibleForColdStart", "needsInitializeWhenDriveAccessible", "", "needsInitialize", "isPickerInitialized", "getDriveStorage", "Lcom/larus/platform/api/DriveUserStorageData;", "openAiFilePreview", "scope", "Lkotlinx/coroutines/CoroutineScope;", "request", "Lcom/larus/platform/model/office/AiFilePreviewRequest;", "fallback", "Lkotlin/Function0;", "parseDriveUplinkInfo", "Lcom/larus/platform/api/fileselect/DriveUplinkInfo;", "rawInfo", "openDriveUplinkPreview", "sourceConversationId", "sourceBotId", "triggerDriveFileSelection", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "scene", "Lcom/larus/platform/api/DriveFileSelectScene;", "allowDriveFileTypeList", "", "Lcom/larus/platform/api/FlowDriveFileType;", "currentSize", "", "selectionStore", "Lcom/larus/platform/api/fileselect/IChatFileSelectionStore;", "dialogParam", "Lcom/larus/platform/api/fileselect/SelectDialogParam;", "registerDriveFileSelectionCallback", "callback", "Lcom/larus/platform/api/IFlowDriveFileSelectionCallback;", "unregisterDriveFileSelectionCallback", "showChatFileSelectDialog", "conversationId", "lastChatTime", "", "Lcom/larus/platform/api/fileselect/IChatFileSelectCallback;", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/platform/api/fileselect/SelectDialogParam;Ljava/lang/String;Lcom/larus/platform/api/fileselect/IChatFileSelectCallback;)V", "showChatFileSelectedListDialog", "selectedListener", "Lcom/larus/platform/api/fileselect/IChatFileSelectedListListener;", "registerChatFileSelectionCallback", "Lcom/larus/platform/api/fileselect/IChatFileSelectionCallback;", "unregisterChatFileSelectionCallback", "dispatchChatFileSelection", "selectedList", "Lcom/larus/platform/api/FlowSelectedFileItem;", "registerDriveResource", MapController.ITEM_LAYER_TAG, "Lcom/larus/platform/api/FlowDriveFileItem;", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "resourceId", "onFailure", "getImageCoverUrl", "token", "height", "width", "url", "getUrlByObjToken", "objToken", "fileType", "getUrlByObjTokenSuspend", "(Ljava/lang/String;Lcom/larus/platform/api/FlowDriveFileType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchDriveVideoPreviewUrl", "fileToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseDriveFileSendInfo", "Lcom/larus/platform/api/FlowDriveFileSendInfo;", "jsonString", "getFloatChatShowPercent", "()Ljava/lang/Integer;", "isFloatChat", "getUploadFileTypeMobParam", "Lcom/larus/platform/api/fileselect/UploadFileTypeMobParam;", "ccmType", "getOriginFileType", "(Ljava/lang/Long;Ljava/lang/String;)Ljava/lang/String;", "getCcmObjType", "originFileType", "(Ljava/lang/String;)Ljava/lang/Integer;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowDriveSdkService implements IFlowDriveSdkService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FlowDriveSdkService f365704a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365705b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f365706c = null;

    private FlowDriveSdkService() {
    }

    static {
        f365704a = new FlowDriveSdkService();
        f365705b = LazyKt.lazy(new o0());
        f365706c = LazyKt.lazy(new p0());
    }

    public static IFlowDriveSdkService a() {
        return (IFlowDriveSdkService) f365705b.getValue();
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final Integer A() {
        IFlowDriveSdkService r100 = a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.A();
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final Integer R() {
        IFlowDriveSdkService r100 = a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.R();
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final boolean h() {
        IFlowDriveSdkService r100 = a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.h();
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final boolean l() {
        IFlowDriveSdkService r100 = a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.l();
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final boolean o() {
        IFlowDriveSdkService r100 = a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.o();
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final boolean u() {
        IFlowDriveSdkService r100 = a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.u();
    }

    public static DriveUplinkInfo C(String r100) {
        if (r100 == null) goto L42;
        boolean r101 = true;
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L45;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        Object r103 = Result.m9449constructorimpl((DriveUplinkInfo) new Gson().fromJson(r100, DriveUplinkInfo.class));     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r103) == false) goto L17;
        r103 = null;
    L17:
        DriveUplinkInfo r104 = (DriveUplinkInfo) r103;
        if (r104 == null) goto L43;
        String r105 = r104.getFileToken();
        if (r105 != null) goto L22;
    L25:
        boolean r106 = true;
    L26:
        if (r106 == false) goto L37;
        String r107 = r104.getUrl();
        if (r107 != null) goto L30;
    L33:
        boolean r108 = true;
    L34:
        if (r108 == false) goto L37;
        r101 = false;
        goto L37
    L30:
        if (StringsKt.isBlank(r107) == true) goto L33;
        r108 = false;
    L37:
        if (r101 == true) goto L39;
        return null;
    L39:
        return r104;
    L22:
        if (StringsKt.isBlank(r105) == true) goto L25;
        r106 = false;
        goto L26
    L43:
        return null;
    L12:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L45:
        return null;
    L42:
        return null;
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final Object d(Continuation<? super com.larus.platform.api.p> r100) {
        IFlowDriveSdkService r101 = a();
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.d(r100);
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final void e(MultimodalInputComponent.c r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        IFlowDriveSdkService r101 = a();
        if (r101 == null) goto L6;
        r101.e(r100);
        return;
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final FlowDriveFileSendInfo m(String r100) {
        IFlowDriveSdkService r101 = a();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.m(r100);
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final Integer p(String r100) {
        IFlowDriveSdkService r101 = a();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.p(r100);
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final void r(MultimodalInputComponent.d r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        IFlowDriveSdkService r101 = a();
        if (r101 == null) goto L6;
        r101.r(r100);
        return;
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final Object v(Continuation<? super Boolean> r100) {
        if ((r100 instanceof FlowDriveSdkService$prepareLocalFilePreview$1) == false) goto L7;
        FlowDriveSdkService$prepareLocalFilePreview$1 r101 = (FlowDriveSdkService$prepareLocalFilePreview$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L19:
        boolean r106 = ((Boolean) r103).booleanValue();
    L22:
        return Boxing.boxBoolean(r106);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        IFlowDriveSdkService r107 = a();
        if (r107 == null) goto L20;
        r101.label = 1;
        r103 = r107.v(r101);
        if (r103 != r104) goto L19;
        return r104;
    L20:
        r106 = false;
    L7:
        r101 = new FlowDriveSdkService$prepareLocalFilePreview$1(this, r100);
        goto L8
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final void x(MultimodalInputComponent.c r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        IFlowDriveSdkService r101 = a();
        if (r101 == null) goto L6;
        r101.x(r100);
        return;
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final void y(MultimodalInputComponent.d r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        IFlowDriveSdkService r101 = a();
        if (r101 == null) goto L6;
        r101.y(r100);
        return;
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final Object b(String r100, Continuation<? super String> r101) {
        IFlowDriveSdkService r102 = a();
        if (r102 != null) goto L5;
        return null;
    L5:
        return r102.b(r100, r101);
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final aq9.g c(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "fileName");
        IFlowDriveSdkService r102 = a();
        if (r102 == null) goto L7;
        aq9.g r103 = r102.c(r100, r101);
        if (r103 == null) goto L7;
        return r103;
    L7:
        return new aq9.g(null, null);
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final String g(Long r100, String r101) {
        IFlowDriveSdkService r102 = a();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.g(r100, r101);
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final void w(String r100, List<com.larus.platform.api.u> r101) {
        Intrinsics.checkNotNullParameter(r101, "selectedList");
        IFlowDriveSdkService r102 = a();
        if (r102 == null) goto L6;
        r102.w(r100, r101);
        return;
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final Object i(String r100, FlowDriveFileType r101, Continuation<? super String> r102) {
        IFlowDriveSdkService r103 = a();
        if (r103 != null) goto L5;
        return null;
    L5:
        return r103.i(r100, r101, r102);
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final void n(FragmentManager r100, String r101, aq9.c r102) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        IFlowDriveSdkService r103 = a();
        if (r103 == null) goto L6;
        r103.n(r100, r101, r102);
        return;
    }

    public static boolean B(Context r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        DriveUplinkInfo r104 = C(r101);
        if (r104 != null) goto L5;
        return false;
    L5:
        IAiFilePreviewService r105 = (IAiFilePreviewService) f365706c.getValue();
        if (r105 != null) goto L8;
        return false;
    L8:
        if (r105.a(r100, r104, r102, r103) != true) goto L12;
        return true;
    L12:
        return false;
    }

    public final void j(Context r100, CoroutineScope r101, cr9.a r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r102, "request");
        Intrinsics.checkNotNullParameter(r103, "fallback");
        q0 r104 = new q0(r101, new AtomicBoolean(false), r103);
        boolean r105 = !StringsKt.isBlank(r102.f465107a);
        IAiFilePreviewService r106 = (IAiFilePreviewService) f365706c.getValue();
        if (r105 == false) goto L8;
        if (r106 == null) goto L8;
        r106.j(r100, r101, r102, r104);
        return;
    L8:
        r104.invoke();
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final boolean s(FragmentActivity r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "filePath");
        Intrinsics.checkNotNullParameter(r102, "fileName");
        Intrinsics.checkNotNullParameter(r103, "localFileProviderAuthority");
        IFlowDriveSdkService r104 = a();
        if (r104 != null) goto L7;
        return false;
    L7:
        return r104.s(r100, r101, r102, r103);
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final void t(com.larus.platform.api.s r100, LifecycleCoroutineScope r101, com.larus.bmhome.chat.component.bottom.attachment.z0 r102, com.larus.bmhome.chat.component.bottom.attachment.a1 r103) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "scope");
        IFlowDriveSdkService r104 = a();
        if (r104 == null) goto L6;
        r104.t(r100, r101, r102, r103);
        return;
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final void q(FragmentManager r100, String r101, Long r110, SelectDialogParam r111, com.larus.bmhome.chat.component.bottom.bottommenu.d1 r112) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        IFlowDriveSdkService r102 = a();
        if (r102 == null) goto L6;
        r102.q(r100, r101, r110, r111, r112);
        return;
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final void z(String r100, FlowDriveFileType r101, LifecycleCoroutineScope r110, Function1 r111, Function1 r112) {
        Intrinsics.checkNotNullParameter(r100, "objToken");
        Intrinsics.checkNotNullParameter(r101, "fileType");
        Intrinsics.checkNotNullParameter(r110, "scope");
        Intrinsics.checkNotNullParameter(r111, "onSuccess");
        IFlowDriveSdkService r102 = a();
        if (r102 == null) goto L6;
        r102.z(r100, r101, r110, r111, r112);
        return;
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final String f(CoroutineScope r100, String r110, int r111, int r112, Function1<? super String, Unit> r113, Function0<Unit> r114) {
        Intrinsics.checkNotNullParameter(r110, "token");
        IFlowDriveSdkService r101 = a();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f(r100, r110, r111, r112, r113, r114);
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final void k(FragmentManager r100, DriveFileSelectScene r110, List r111, int r112, com.larus.platform.api.fileselect.a r113, SelectDialogParam r114) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        Intrinsics.checkNotNullParameter(r110, "scene");
        Intrinsics.checkNotNullParameter(r113, "selectionStore");
        IFlowDriveSdkService r101 = a();
        if (r101 == null) goto L6;
        r101.k(r100, r110, r111, r112, r113, r114);
        return;
    }
}
