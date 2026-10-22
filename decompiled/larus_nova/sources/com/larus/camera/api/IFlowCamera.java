package com.larus.camera.api;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.CameraResultOutOpenParams;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.OutputParam;
import com.ss.android.lark.utils.statistics.PerfLog;
import ex8.b;
import ix8.c;
import ix8.d;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J$\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&Jl\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u00192\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H&J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00142\u0006\u0010#\u001a\u00020\bH\u0016J \u0010$\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00142\u0006\u0010#\u001a\u00020\bH\u0016J\u001a\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010&\u001a\u00020\u0017H\u0016J\u0018\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H&J&\u0010/\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,2\u0014\b\u0002\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001901H&JL\u00102\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\f\u00103\u001a\b\u0012\u0004\u0012\u000205042\u0006\u0010\u001e\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010\u00172\u0006\u00106\u001a\u00020\u00192\b\b\u0002\u00107\u001a\u00020\u0019H&J\b\u00108\u001a\u000209H&J8\u0010?\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u00192\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00030B2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00030BH&J\u0010\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u0017H&J$\u0010F\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010G\u001a\u00020H2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0005H&J6\u0010J\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030B2\u0010\b\u0002\u0010L\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010MH&J\u001e\u0010N\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00030MH\u0016J\u0010\u0010P\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020RH\u0016J\u001a\u0010S\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020R2\b\u0010T\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00170V2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00170VH&J\u001c\u0010X\u001a\u00020\u00032\b\u0010Y\u001a\u0004\u0018\u00010\u00172\b\u0010Z\u001a\u0004\u0018\u00010\u0017H&J\u0010\u0010[\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020]H&J\u000e\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00170VH&J\u000e\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00170VH\u0016J\u0016\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020cH\u0096@¢\u0006\u0002\u0010dJ\b\u0010e\u001a\u00020RH&R\u001e\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030<0;X¦\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006f"}, d2 = {"Lcom/larus/camera/api/IFlowCamera;", "", "observe", "", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "observer", "Landroidx/lifecycle/Observer;", "Lcom/larus/camera/api/params/CameraOutputContext;", "setCommandListener", "onCommand", "Lcom/larus/camera/api/ICameraCommandListener;", "getCommandListener", "setRouteDelegate", "delegate", "Lcom/larus/camera/api/ICameraRouteDelegate;", "start", "activity", "Landroidx/fragment/app/FragmentActivity;", "param", "Lcom/larus/camera/api/params/InputParam;", "result", "captureMode", "", "eduCheck", "", "imagePath", "albumUri", "Landroid/net/Uri;", "supportMark", "supportCrop", "botId", "inputParam", "outputParam", "Lcom/larus/camera/api/params/OutputParam;", "outputContext", "editImage", "cacheEditResultBitmap", "path", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "peekCachedImage", "openCameraResultFirst", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "Lcom/larus/camera/api/params/CameraResultOutOpenParams;", "openCameraCaptureFirst", "intentBooleanExtras", "", "editPhoto", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "isInjectInput", "enableOriginalImageDeferredEdit", "createCameraRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "qrcodeScanSuccessFlow", "Lkotlin/Lazy;", "Lkotlinx/coroutines/flow/SharedFlow;", "getQrcodeScanSuccessFlow", "()Lkotlin/Lazy;", "registerHostScanCodeCallback", "onlyFromCamera", "onResult", "Lkotlin/Function1;", "onFailure", "cancelHostScanCodeCallback", "message", "takeByCamera", "cameraConfig", "Lcom/larus/camera/api/params/CameraConfig;", "forsetiFragment", "registerResultForCamera", "onSuccess", "onFail", "Lkotlin/Function0;", "registerSendCompletedForCamera", LynxVideoManagerLite.EVENT_ON_PLAY_COMPLETED, "setEmptyResultAndFinishCamera", "resultCode", "", "completeCameraCreationMessageSent", "conversationId", "saveCapturedImage2Album", "", "sendCompressImages", "updatePreview2CompressCache", "previewPath", "compressPath", "cleanBottomPhotoPickerInCamera", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getCameraCaptureActivityClassNames", "getCameraResultActivityClassNames", "requestVLMIntent", "Lcom/larus/camera/api/vlm/VLMIntentDetectResult;", "request", "Lcom/larus/camera/api/vlm/VLMIntentDetectRequest;", "(Lcom/larus/camera/api/vlm/VLMIntentDetectRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMultiOutputParamListSize", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFlowCamera {

    /* JADX INFO: loaded from: classes26.dex */
    public static final class a {
        public static /* synthetic */ void a(IFlowCamera r110, FragmentActivity r111, String r112, String r113, Uri r114, boolean r115, boolean r116, InputParam r117, int r210) {
            if ((r210 & 32) == 0) goto L5;
            boolean r100 = false;
        L7:
            if ((r210 & 64) == 0) goto L9;
            boolean r101 = false;
        L11:
            if ((r210 & 256) == 0) goto L13;
            InputParam r118 = null;
        L14:
            r110.e(r111, r112, r113, r114, r100, r101, r118, null);
            return;
        L13:
            r118 = r117;
            goto L14
        L9:
            r101 = r116;
            goto L11
        L5:
            r100 = r115;
            goto L7
        }
    }

    void A(FragmentActivity r100, String r101, ActivityResultLauncher<Intent> r102, boolean r103, String r104, boolean r105, boolean r106);

    boolean b(String r100);

    Lazy<d1<Unit>> c();

    Object d(c r100, Continuation<? super d> r101);

    void e(FragmentActivity r100, String r101, String r102, Uri r103, boolean r104, boolean r105, InputParam r106, OutputParam r107);

    void f(b r100);

    void g(FragmentActivity r100, InputParam r101, Fragment r102);

    void h(String r100);

    List<String> i();

    void j(FragmentActivity r100, InputParam r101, CameraOutputContext r102);

    void k(String r100, Bitmap r101);

    void l(FragmentManager r100);

    void m(Fragment r100, Function1<? super CameraOutputContext, Unit> r101, Function0<Unit> r102);

    boolean n(FragmentActivity r100, InputParam r101, CameraOutputContext r102);

    boolean o(Context r100, CameraResultOutOpenParams r101);

    void p(Fragment r100, Function0<Unit> r101);

    Bitmap q(String r100);

    void r(Fragment r100, hx8.a r101, Fragment r102);

    boolean s(boolean r100, Function1<? super String, Unit> r101, Function1<? super String, Unit> r102);

    b t();

    com.larus.camera.impl.starter.d u();

    List<String> v();

    boolean w(Context r100, Map<String, Boolean> r101);

    void x(String r100, String r101);

    int y();

    List<String> z(List<String> r100);
}
