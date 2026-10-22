package com.larus.avatar.impl.scan.component;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avatar.impl.scan.ScanCameraViewModel;
import com.larus.avatar.impl.scan.utils.VideoRecordStage;
import com.larus.avatar.impl.scan.view.ScanCameraBeautyLevel;
import com.larus.avatar.impl.scan.view.ScanErrorType;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.l1;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.camera.ve.Ratio;
import com.larus.platform.model.camera.ve.VeCameraInputParam;
import com.larus.platform.service.o3;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 R2\u00060\u0001j\u0002`\u00022\u00020\u00032\u00020\u0004:\u0001RB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u00102\u001a\u00020,H\u0016J\b\u00103\u001a\u00020,H\u0016J\u0010\u00104\u001a\u00020,2\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020,H\u0016J\b\u00108\u001a\u00020,H\u0016J\b\u00109\u001a\u00020,H\u0016J\b\u0010:\u001a\u00020,H\u0016J\b\u0010;\u001a\u00020,H\u0016J\b\u0010<\u001a\u00020,H\u0016J\u0012\u0010=\u001a\u00020,2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010>\u001a\u00020,2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010?\u001a\u00020\u0016H\u0002J\u0010\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020BH\u0016J\u0012\u0010C\u001a\u00020,2\b\u0010A\u001a\u0004\u0018\u00010DH\u0016J\b\u0010E\u001a\u00020,H\u0016J\b\u0010F\u001a\u00020,H\u0016J\u001c\u0010G\u001a\u00020,2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020,0+H\u0016J\u0010\u0010H\u001a\u00020,2\u0006\u0010I\u001a\u00020\u0016H\u0002J\b\u0010J\u001a\u00020,H\u0002J\b\u0010K\u001a\u00020,H\u0016J\b\u0010L\u001a\u00020,H\u0016J\u0010\u0010M\u001a\u00020,2\u0006\u0010A\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020,H\u0016J\n\u0010P\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010O\u001a\u00020,2\b\u0010Q\u001a\u0004\u0018\u00010#H\u0002R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\u0004\u0018\u00010#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020,0+0*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010-\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\f\u001a\u0004\b/\u00100¨\u0006S"}, d2 = {"Lcom/larus/avatar/impl/scan/component/ScanCameraComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/avatar/impl/scan/component/IScanCameraComponentAbility;", "Lcom/larus/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;", "<init>", "()V", "cameraSettings", "Lcom/larus/platform/model/camera/CameraSettings;", "getCameraSettings", "()Lcom/larus/platform/model/camera/CameraSettings;", "cameraSettings$delegate", "Lkotlin/Lazy;", "surfaceView", "Landroid/view/SurfaceView;", "camera", "Lcom/larus/platform/model/camera/ve/IVeCamera;", "previewFrameAnimator", "Landroid/animation/ObjectAnimator;", "recordingGeneration", "", "destroyed", "", "_isRecording", "Lkotlinx/coroutines/flow/MutableStateFlow;", "isRecording", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "gotoBackGround", "_recordFirstFrameFilePath", "", "recordFirstFrameFilePath", "getRecordFirstFrameFilePath", "()Ljava/lang/String;", "_recordFirstFrameBitmap", "Landroid/graphics/Bitmap;", "recordFirstFrameBitmap", "getRecordFirstFrameBitmap", "()Landroid/graphics/Bitmap;", "isOpeningCamera", "isCameraReady", "cameraReadyCallbacks", "", "Lkotlin/Function1;", "", "viewModel", "Lcom/larus/avatar/impl/scan/ScanCameraViewModel;", "getViewModel", "()Lcom/larus/avatar/impl/scan/ScanCameraViewModel;", "viewModel$delegate", "onAttach", WidgetCostModule.TYPE_ON_CREATE, "onViewCreated", "view", "Landroid/view/View;", "onPause", "onResume", LiveCommonConstants.REASON_ON_DEDTROY, "onAppBackground", "onAppForeground", "onAllActivityDestroyed", "openCamera", "checkAndOpenCamera", "hasPermission", "startRecording", "callback", "Lcom/larus/platform/model/camera/ve/IRecordStartCallback;", "stopRecording", "Lcom/larus/platform/model/camera/ve/IRecordResultCallback;", "startAudioCapture", "stopAudioCapture", "ensureCameraReady", "notifyCameraReady", "success", "markCameraReady", "showSurfaceView", "hideSurfaceView", "getFrame", "Lcom/larus/platform/model/camera/ve/IGetFrameCallback;", "showPreviewFrame", "getCamera", "originalBitmap", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScanCameraComponent extends BaseContentWidget implements com.larus.avatar.impl.scan.component.c, f09.a.b {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f290902m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SurfaceView f290903n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public pq9.j f290904o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ObjectAnimator f290905p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f290906q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f290907r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final StateFlowImpl f290908s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f290909t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f290910u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Bitmap f290911v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f290912w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f290913x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<Function1<Boolean, Unit>> f290914y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f290915z;

    public static final class a {
    }

    public static final class b implements pq9.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ pq9.e f290916a;

        public b(pq9.e r100) {
            this.f290916a = r100;
        }

        @Override // pq9.e
        public final void a(final Bitmap r100) {
            SoftReference<Handler> r101 = com.larus.utils.y.f375498a;
            final pq9.e r102 = this.f290916a;
            com.larus.utils.y.c(new n0(r102, r100));
        }
    }

    public static final class c implements pq9.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScanCameraComponent f290917a;

        @Override // pq9.b
        public final float a(float r100) {
            return r100;
        }

        @Override // pq9.b
        public final float b(float r100) {
            return r100;
        }

        @Override // pq9.b
        public final void c(int r100, float r101) {
        }

        @Override // pq9.b
        public final void surfaceCreated(SurfaceHolder r100) {
            Intrinsics.checkNotNullParameter(r100, "holder");
        }

        @Override // pq9.b
        public final void e() {
            IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r100 == null) goto L7;
            r100.H();
            if (l1.f346198a.b() != true) goto L7;
            boolean r101 = true;
        L8:
            if (r101 == false) goto L29;
            ScanCameraViewModel r102 = (ScanCameraViewModel) this.f290917a.f290915z.getValue();
            if (r102 == null) goto L13;
            ScanCameraBeautyLevel r103 = r102.getBeautyLevel();
            if (r103 == null) goto L13;
        L15:
            if (r103 != ScanCameraBeautyLevel.OFF) goto L22;
            pq9.j r104 = this.f290917a.f290904o;
            if (r104 == null) goto L19;
            r104.p();
        L19:
            FLogger.f375446a.i("ScanCameraComponent", "onFirstFrameRender clear beauty, selectedLevel=" + r103.name());
            ScanCameraComponent r105 = this.f290917a;
            r105.f290912w = false;
            r105.f290913x = true;
            r105.Y2(true);
            return;
        L22:
            if (z2.f365865a.l1() == false) goto L24;
            String r106 = r103.getCategoryKey();
        L25:
            pq9.j r107 = this.f290917a.f290904o;
            if (r107 == null) goto L28;
            r107.s("digital_avatar_video_beauty_android_v2", r106);
        L28:
            FLogger.f375446a.i("ScanCameraComponent", "onFirstFrameRender apply beauty, selectedLevel=" + r103.name() + ", targetCategoryKey=" + r106);
            goto L29
        L24:
            r106 = ScanCameraBeautyLevel.CATEGORY_KEY_BASIC;
        L13:
            r103 = ScanCameraBeautyLevel.NATURAL;
        L29:
            ScanCameraComponent r108 = this.f290917a;
            r108.f290912w = false;
            r108.f290913x = true;
            r108.Y2(true);
            return;
        L7:
            r101 = false;
            goto L8
        }

        public c(ScanCameraComponent r100) {
            this.f290917a = r100;
        }

        @Override // pq9.b
        public final void d(boolean r100) {
            this.f290917a.f290912w = false;
            com.larus.avatar.impl.scan.utils.a.a(r100, VideoRecordStage.OPEN_CAMERA, null);
            if (r100 == true) goto L6;
            ScanCameraComponent r101 = this.f290917a;
            r101.f290913x = false;
            r101.Y2(false);
            return;
        }
    }

    public static final class d implements pq9.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScanCameraComponent f290918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f290919b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ pq9.g f290920c;

        @Override // pq9.g
        public final void a(final String r100, Bitmap r101) {
            if (r101 == null) goto L4;
            Bitmap r102 = com.larus.avatar.impl.scan.utils.b.a(r101);
        L5:
            final Bitmap r103 = r102;
            SoftReference<Handler> r104 = com.larus.utils.y.f375498a;
            final ScanCameraComponent r105 = this.f290918a;
            final long r106 = this.f290919b;
            final pq9.g r107 = this.f290920c;
            com.larus.utils.y.c(new q0(r105, r106, r103, r100, r107));
            return;
        L4:
            r102 = null;
            goto L5
        }

        @Override // pq9.g
        public final void b(final boolean r100, final int r110) {
            VideoRecordStage r101 = VideoRecordStage.OPEN_CAMERA;
            if (r100 == true) goto L5;
            Integer r102 = Integer.valueOf(r110);
        L6:
            com.larus.avatar.impl.scan.utils.a.a(r100, r101, r102);
            SoftReference<Handler> r103 = com.larus.utils.y.f375498a;
            final ScanCameraComponent r104 = this.f290918a;
            final long r105 = this.f290919b;
            final pq9.g r106 = this.f290920c;
            com.larus.utils.y.c(new p0(r104, r105, r100, r106, r110));
            return;
        L5:
            r102 = null;
            goto L6
        }

        public d(ScanCameraComponent r100, long r101, pq9.g r102) {
            this.f290918a = r100;
            this.f290919b = r101;
            this.f290920c = r102;
        }
    }

    public static final class e implements pq9.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScanCameraComponent f290921a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f290922b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ pq9.f f290923c;

        @Override // pq9.f
        public final void a(final String r100, final Pair<Integer, Integer> r110) {
            Intrinsics.checkNotNullParameter(r100, "path");
            Intrinsics.checkNotNullParameter(r110, "size");
            SoftReference<Handler> r101 = com.larus.utils.y.f375498a;
            final ScanCameraComponent r102 = this.f290921a;
            final long r103 = this.f290922b;
            final pq9.f r104 = this.f290923c;
            com.larus.utils.y.c(new r0(r102, r103, r104, r100, r110));
        }

        public e(ScanCameraComponent r100, long r101, pq9.f r102) {
            this.f290921a = r100;
            this.f290922b = r101;
            this.f290923c = r102;
        }
    }

    static {
    }

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
    }

    @Override // f09.a.b
    public final void onAppBackground() {
        this.f290909t = true;
    }

    @Override // f09.a.b
    public final void onAppForeground() {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        this.f290907r = true;
        this.f290906q++;
        t1a.b r100 = com.larus.avatar.impl.scan.utils.c.d(this);
        if (r100 == null) goto L7;
        f r101 = (f) r100.getAbility(f.class);
        if (r101 == null) goto L7;
        r101.Kl();
    L7:
        ObjectAnimator r102 = this.f290905p;
        if (r102 == null) goto L10;
        r102.cancel();
    L10:
        this.f290905p = null;
        pq9.j r103 = this.f290904o;
        if (r103 == null) goto L13;
        r103.i();
    L13:
        pq9.j r104 = this.f290904o;
        if (r104 == null) goto L16;
        r104.o();
    L16:
        this.f290904o = null;
        this.f290903n = null;
        this.f290911v = null;
        this.f290910u = null;
        ((ArrayList) this.f290914y).clear();
        AppHost.f326268a.a().c(this);
    }

    @Override // com.larus.avatar.impl.scan.component.c
    public final void LA() {
        pq9.k r100 = pq9.k.f530291a;
        Ratio r101 = Ratio.RATIO_FULL_SCREEN;
        r100.getClass();
        String r102 = pq9.k.a(r101);
        ImageView r103 = null;
        if (new PolarisFileWrapper(r102).exists() == false) goto L9;
        BitmapFactory.Options r104 = new BitmapFactory.Options();
        r104.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r102, r104);
        int r105 = Math.max(r104.outWidth, r104.outHeight);
        if (r105 <= 0) goto L7;
        float r106 = r105 / 1280.0f;
    L8:
        int r107 = RangesKt.coerceAtLeast((int) r106, 1);
        BitmapFactory.Options r108 = new BitmapFactory.Options();
        r108.inSampleSize = r107;
        Bitmap r109 = BitmapFactory.decodeFile(r102, r108);
    L10:
        ObjectAnimator r110 = this.f290905p;
        if (r110 == null) goto L13;
        r110.cancel();
    L13:
        this.f290905p = null;
        if (r109 != null) goto L16;
    L28:
        if (r109 == null) goto L34;
        com.larus.avatar.impl.scan.utils.b.b(r109);
        return;
    L34:
        return;
    L16:
        if (r109.isRecycled() == true) goto L28;
        Bitmap r111 = com.larus.avatar.impl.scan.utils.b.a(r109);
        com.larus.avatar.impl.scan.utils.b.b(r109);
        if (r111 != null) goto L21;
        return;
    L21:
        if (r111.isRecycled() == true) goto L35;
        View r112 = F2();
        if (r112 == null) goto L26;
        r103 = (ImageView) r112.findViewById(R.id.preview_frame);
    L26:
        if (r103 == null) goto L32;
        r103.setImageBitmap(r111);
        e1.x(r103);
        ObjectAnimator r113 = ObjectAnimator.ofFloat(r103, View.ALPHA, new float[]{1.0f, 0.0f});
        r113.setDuration(1000);
        Intrinsics.checkNotNull(r113);
        r113.addListener(new o0(this, r103));
        this.f290905p = r113;
        r113.start();
        return;
    L32:
        return;
    L35:
        return;
    L7:
        r106 = 1.0f;
        goto L8
    L9:
        r109 = null;
        goto L10
    }

    @Override // com.larus.avatar.impl.scan.component.c
    public final void Uf() {
        SurfaceView r100 = this.f290903n;
        if (r100 == null) goto L6;
        e1.x(r100);
        return;
    }

    @Override // com.larus.avatar.impl.scan.component.c
    public final void cD() {
        SurfaceView r100 = this.f290903n;
        if (r100 == null) goto L6;
        e1.o(r100);
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onPause() {
        pq9.j r100 = this.f290904o;
        if (r100 == null) goto L6;
        r100.m(Ratio.RATIO_FULL_SCREEN);
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        if (((Boolean) this.f290908s.getValue()).booleanValue() == true) goto L5;
        LA();
    L20:
        this.f290909t = false;
        return;
    L5:
        if (this.f290909t == false) goto L12;
        t1a.b r100 = com.larus.avatar.impl.scan.utils.c.d(this);
        if (r100 == null) goto L11;
        f r101 = (f) r100.getAbility(f.class);
        if (r101 == null) goto L11;
        r101.MR();
    L11:
        final long r102 = this.f290906q;
        com.larus.utils.y.d(new k0(this, r102), 500);
        goto L20
    L12:
        Fragment r103 = com.larus.avatar.impl.scan.utils.c.b(this);
        if (r103 == null) goto L20;
        t1a.b r104 = com.larus.avatar.impl.scan.utils.c.c(r103);
        if (r104 == null) goto L20;
        com.larus.avatar.impl.scan.component.d r105 = (com.larus.avatar.impl.scan.component.d) r104.getAbility(com.larus.avatar.impl.scan.component.d.class);
        if (r105 == null) goto L20;
        r105.Gn(new o88.b(ScanErrorType.RECORD_ERROR));
        goto L20
    }

    public ScanCameraComponent() {
        this.f290902m = LazyKt.lazy(new g0());
        this.f290908s = j1.a(Boolean.FALSE);
        this.f290914y = new ArrayList();
        this.f290915z = LazyKt.lazy(new h0(this));
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget, com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        super.onCreate();
        AppHost.f326268a.a().j(this);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Fragment r100 = com.larus.avatar.impl.scan.utils.c.b(this);
        if (r100 == null) goto L6;
        s1a.a.a(r100, this, com.larus.avatar.impl.scan.component.c.class);
        return;
    }

    @Override // com.larus.avatar.impl.scan.component.c
    public final Bitmap OA() {
        return this.f290911v;
    }

    @Override // com.larus.avatar.impl.scan.component.c
    public final pq9.j getCamera() {
        return this.f290904o;
    }

    @Override // com.larus.avatar.impl.scan.component.c
    public final String sV() {
        return this.f290910u;
    }

    @Override // com.larus.avatar.impl.scan.component.c
    public final void QH(pq9.g r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (this.f290907r == false) goto L5;
        return;
    L5:
        long r101 = this.f290906q + 1;
        this.f290906q = r101;
        t1a.b r102 = com.larus.avatar.impl.scan.utils.c.d(this);
        if (r102 == null) goto L10;
        f r103 = (f) r102.getAbility(f.class);
        if (r103 == null) goto L10;
        r103.sh();
    L10:
        this.f290911v = null;
        this.f290910u = null;
        pq9.j r104 = this.f290904o;
        if (r104 == null) goto L14;
        r104.k(true, new d(this, r101, r100), true);
        return;
    }

    public final void Y2(final boolean r100) {
        final List r101 = CollectionsKt.toList(this.f290914y);
        ((ArrayList) this.f290914y).clear();
        com.larus.utils.y.c(new j0(r101, r100));
    }

    @Override // com.larus.avatar.impl.scan.component.c
    public final void ee(final v r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (this.f290913x == false) goto L9;
        if (this.f290904o == null) goto L9;
        com.larus.utils.y.c(new l0(r100));
        return;
    L9:
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.RECORD_AUDIO") == 0) goto L11;
    L13:
        boolean r101 = false;
    L14:
        if (r101 == true) goto L17;
        com.larus.utils.y.c(new m0(r100));
        return;
    L17:
        ((ArrayList) this.f290914y).add(r100);
        h3(this.f290903n);
        return;
    L11:
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.CAMERA") != 0) goto L13;
        r101 = true;
        goto L14
    }

    public final void h3(SurfaceView r100) {
        if (this.f290912w == false) goto L5;
        return;
    L5:
        Fragment r101 = com.larus.avatar.impl.scan.utils.c.b(this);
        if (r101 == null) goto L8;
        FragmentActivity r102 = r101.getActivity();
    L10:
        if (r102 == null) goto L21;
        if (r100 == null) goto L21;
        this.f290912w = true;
        this.f290913x = false;
        VeCameraInputParam r103 = new VeCameraInputParam();
        r103.setFrontCamera(true);
        r103.setPreviewRatio(Ratio.RATIO_FULL_SCREEN);
        r103.setEnableRecorder(true);
        r103.setFpsRange(new int[]{7, 24});
        pq9.j r104 = o3.f365784b.d(r102, r103);
        this.f290904o = r104;
        if (r104 != null) goto L17;
        this.f290912w = false;
        FLogger.f375446a.w("ScanCameraComponent", "openCamera failed, camera is null");
        Y2(false);
        return;
    L17:
        int r105 = z2.f365865a.getCameraSettings().getVeLogLevel();
        SurfaceHolder r106 = r100.getHolder();
        pq9.j r107 = this.f290904o;
        if (r107 == null) goto L23;
        Intrinsics.checkNotNull(r106);
        r107.q(r106, r105, null, new c(this), Boolean.TRUE, true);
        return;
    L23:
        return;
    L21:
        FLogger.f375446a.w("ScanCameraComponent", "openCamera failed, activity or surfaceView is null");
        Y2(false);
        return;
    L8:
        r102 = null;
        goto L10
    }

    @Override // com.larus.avatar.impl.scan.component.c
    public final void ml(final pq9.f r100) {
        final long r101 = this.f290906q;
        if (((Boolean) this.f290908s.getValue()).booleanValue() == false) goto L7;
        pq9.j r102 = this.f290904o;
        if (r102 == null) goto L9;
        r102.b(new e(this, r101, r100));
        return;
    L9:
        return;
    L7:
        com.larus.utils.y.c(new i0(this, r101, r100));
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
        SurfaceView r101 = (SurfaceView) r100.findViewById(R.id.surfaceView_camera);
        this.f290903n = r101;
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.RECORD_AUDIO") == 0) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        h3(r101);
        return;
    L10:
        FLogger.f375446a.i("ScanCameraComponent", "wait for video record permission before opening camera");
        return;
    L5:
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.CAMERA") != 0) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.larus.avatar.impl.scan.component.c
    public final void yx(pq9.e r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        pq9.j r101 = this.f290904o;
        if (r101 == null) goto L6;
        r101.n(new b(r100));
        return;
    }
}
