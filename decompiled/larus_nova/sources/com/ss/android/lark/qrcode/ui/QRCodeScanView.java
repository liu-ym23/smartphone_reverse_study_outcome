package com.ss.android.lark.qrcode.ui;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import com.larksuite.component.ui.loading.LKUIStatus;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.mvp.IView;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.vesdk.VECameraSettings;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public class QRCodeScanView implements com.ss.android.lark.qrcode.ui.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f439013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FragmentActivity f439014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.ss.android.lark.qrcode.ui.c.a f439015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a0 f439016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ScannerView f439017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VECameraSettings.CAMERA_FLASH_MODE f439018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f439019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LKUIStatus f439020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f439021i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a2c.a f439022j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c2c.a f439023k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Long f439024l;

    @BindView(8716)
    FrameLayout mCustomViewContainer;

    @BindView(8828)
    ImageView mFlashLight;

    @BindView(8829)
    TextView mFlashLightTips;

    @BindView(9522)
    CommonTitleBar mMyTitleBar;

    public class a extends OrientationEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f439025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TabletState f439026b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ QRCodeScanView f439027c;

        @Override // android.view.OrientationEventListener
        public final void onOrientationChanged(int r100) {
            if (this.f439025a != r100) goto L5;
            return;
        L5:
            if (r100 <= 80) goto L13;
            if (r100 >= 90) goto L13;
            if (this.f439026b != TabletState.ROTATION_90) goto L11;
            this.f439027c.f439016d.getClass();
            this.f439027c.f439016d.getClass();
        L11:
            this.f439026b = TabletState.ROTATION_270;
        L13:
            if (r100 > 260) goto L15;
        L20:
            this.f439025a = r100;
            return;
        L15:
            if (r100 >= 280) goto L20;
            if (this.f439026b != TabletState.ROTATION_270) goto L19;
            this.f439027c.f439016d.getClass();
            this.f439027c.f439016d.getClass();
        L19:
            this.f439026b = TabletState.ROTATION_90;
            goto L20
        }

        public a(QRCodeScanView r100, FragmentActivity r101) {
            this.f439027c = r100;
            super(r101);
            this.f439025a = -1;
            this.f439026b = TabletState.NULL;
        }
    }

    public class b implements com.ss.android.lark.utils.h.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ QRCodeScanView f439028a;

        public b(QRCodeScanView r100) {
            this.f439028a = r100;
        }

        @Override // com.ss.android.lark.utils.h.e
        public final void a(boolean r100) {
            if (r100 == false) goto L4;
            fsb.f.b().i("FastQRCodeOnStart");
            this.f439028a.f439016d.getClass();
            fsb.f.b().h("FastQRCodeOnStart");
            fsb.f.b().e();
            return;
        L4:
            fsb.f.b().d();
        }
    }

    public interface c {
        void a(QRCodeScanView r100);

        void b();

        void c(View r100);
    }

    @Override // com.ss.android.lark.qrcode.ui.c
    public final void J4() {
        this.f439016d.getClass();
    }

    @Override // com.ss.android.lark.qrcode.ui.c
    public final void K4() {
        FragmentActivity r100 = this.f439014b;
        b r101 = new b(this);
        int r102 = com.ss.android.lark.utils.n.f444741a;
        com.ss.android.lark.utils.h.d(r100, r101, "android.permission.CAMERA", null, new com.ss.android.lark.utils.l(R.string.Lark_Core_CameraAccess_Title, R.string.Lark_Core_CameraAccessForScanCode_Desc, R.string.Lark_Core_CameraAccess_Title, R.string.Lark_Core_CameraAccessForScanCode_Desc, null, null, 240));
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        this.f439013a.a(this);
        if ((this.f439014b.getResources().getConfiguration().screenLayout & 15) < 3) goto L5;
        boolean r100 = true;
    L6:
        a r101 = new a(this, this.f439014b);
        this.f439021i = r101;
        if (r101.canDetectOrientation() == false) goto L10;
        if (r100 == false) goto L10;
    L15:
        this.f439021i.enable();
        this.f439019g = true;
    L17:
        WindowInsetsUtils.f(this.f439014b);
        WindowInsetsUtils.e(this.f439014b);
        WindowInsetsUtils.d(this.f439014b);
        CommonTitleBar r102 = this.mMyTitleBar;
        r102.setLeftImageDrawable(UDIconUtils.getIconDrawable(r102.getContext(), R.drawable.ud_icon_close_outlined));
        this.mMyTitleBar.getLeftDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        this.mMyTitleBar.setLeftClickListener(new r(this));
        this.mMyTitleBar.setImmersive(true);
        h.c.f439070a.getClass();
        fsb.f.b().i("FastQRCodeOnCreate");
        long r103 = System.currentTimeMillis();
        if (this.f439019g == false) goto L22;
        ScannerView r104 = this.f439017e;
        if (r104 == null) goto L22;
        this.f439016d.getClass();
        Intrinsics.checkNotNullParameter(r104, "scannerView");
    L22:
        a0 r105 = this.f439016d;
        FragmentActivity r106 = this.f439014b;
        this.f439015c.getFormats();
        s r107 = new s(this, r103);
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "activity");
        Intrinsics.checkNotNullParameter(r107, "listener");
        r105.f439039a = r107;
        Log.i("QRCode-VESDKQRCodeScanner", "OfficeSDK VESDKQRCodeScanner is disabled");
        fsb.f.b().h("FastQRCodeOnCreate");
        this.mFlashLight.setOnClickListener(new u(this));
        FrameLayout r108 = this.mCustomViewContainer;
        if (r108 == null) goto L33;
        if ((r108.getContext() instanceof Activity) == false) goto L33;
        View r109 = ((Activity) this.mCustomViewContainer.getContext()).getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L31;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r110 = ThreadMethodProxy.currentThread();
        if (r110 == com.larus.home.impl.utils.c.f346341a) goto L31;
        com.larus.home.impl.utils.c.a(r110, "getDecorView");
    L31:
        LKUIStatus.b r111 = new LKUIStatus.b((ViewGroup) r109);
        r111.f284257b = UIHelper.getString(R.string.Lark_Legacy_LoadingWait);
        this.f439020h = new LKUIStatus(r111);
    L33:
        if (this.f439022j.isFeatureGatingEnable("core.scan.flashlight") == false) goto L36;
        a0 r112 = this.f439016d;
        v r113 = new v();
        r112.getClass();
        Intrinsics.checkNotNullParameter(r113, "listener");
        return;
    L36:
        return;
    L10:
        if (this.f439021i.canDetectOrientation() == false) goto L16;
        a2c.a r114 = z1c.a.f569729a;
        if (r114 == null) goto L16;
        if (r114.isFeatureGatingEnable("im.scan_code.use_new_scanner_view.forall") == true) goto L15;
    L16:
        this.f439021i.disable();
        goto L17
    L5:
        r100 = false;
        goto L6
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        this.f439021i.disable();
    }

    @Override // com.ss.android.lark.qrcode.ui.c
    public final void f() {
        this.f439016d.f439039a = null;
        this.f439021i.disable();
        this.mMyTitleBar.getLeftDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    }

    @Override // com.ss.android.lark.qrcode.ui.c
    public final void hideLoading() {
        UICallbackExecutor.execute(new q(this));
    }

    @Override // com.ss.android.lark.qrcode.ui.c
    public final void onResume() {
        this.f439016d.getClass();
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f439015c = (com.ss.android.lark.qrcode.ui.c.a) r100;
    }

    @Override // com.ss.android.lark.qrcode.ui.c
    public final void showToast(String r100) {
        LKUIToast.show(this.f439014b, r100);
    }

    public QRCodeScanView(QRCodeScanFragment.b r100, FragmentActivity r101) {
        this.f439019g = false;
        this.f439022j = z1c.a.f569729a;
        this.f439023k = new c2c.a();
        this.f439024l = Long.valueOf(System.currentTimeMillis());
        this.f439013a = r100;
        this.f439014b = r101;
        this.f439016d = new a0();
    }

    public QRCodeScanView(QRCodeScanFragment.b r100, FragmentActivity r101, int[] r102) {
        this.f439019g = false;
        this.f439022j = z1c.a.f569729a;
        this.f439023k = new c2c.a();
        this.f439024l = Long.valueOf(System.currentTimeMillis());
        this.f439013a = r100;
        this.f439014b = r101;
        Intrinsics.checkNotNullParameter(r102, "formats");
        this.f439016d = new a0();
    }
}
