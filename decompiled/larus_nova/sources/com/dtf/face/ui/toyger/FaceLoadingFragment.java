package com.dtf.face.ui.toyger;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.dtf.face.api.IDTFragment;
import com.dtf.face.api.IDTLoadingFragment;
import com.dtf.face.api.IDTUIListener;
import com.dtf.face.config.GuideConfig;
import com.dtf.face.log.RecordService;
import com.dtf.face.ui.overlay.CommAlertOverlay;
import com.dtf.face.ui.widget.iOSLoadingView;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class FaceLoadingFragment extends Fragment implements IDTLoadingFragment {
    private ImageView ivTitleBack;
    private ImageView ivTitleClose;
    private iOSLoadingView loadingView;
    private CommAlertOverlay mCommAlertOverlay;
    private View mRootView;
    private FrameLayout mWebviewContainer;

    public class a implements CommAlertOverlay.CommAlertOverlayListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IDTLoadingFragment.IMessageBoxCB f273671a;

        @Override // com.dtf.face.ui.overlay.CommAlertOverlay.CommAlertOverlayListener
        public final void onCancel() {
            IDTLoadingFragment.IMessageBoxCB r100 = this.f273671a;
            if (r100 == null) goto L6;
            r100.onCancel();
            return;
        }

        @Override // com.dtf.face.ui.overlay.CommAlertOverlay.CommAlertOverlayListener
        public final void onConfirm() {
            IDTLoadingFragment.IMessageBoxCB r100 = this.f273671a;
            if (r100 == null) goto L6;
            r100.onOK();
            return;
        }

        public a(IDTLoadingFragment.IMessageBoxCB r100) {
            this.f273671a = r100;
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IDTFragment.ICloseCallBack f273672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FaceLoadingFragment f273673b;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f273672a.onBack();
            this.f273673b.resetExitPosition(true);
        }

        public b(FaceLoadingFragment r100, IDTFragment.ICloseCallBack r101) {
            this.f273673b = r100;
            this.f273672a = r101;
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IDTFragment.ICloseCallBack f273674a;

        public c(IDTFragment.ICloseCallBack r100) {
            this.f273674a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f273674a.onClose();
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public int getLayoutID() {
        return R.layout.dtf_fragment_face_loading;
    }

    @Override // com.dtf.face.api.IDTLoadingFragment
    public FrameLayout getAuthorizationViewContainer() {
        if (this.mWebviewContainer != null) goto L6;
        this.mWebviewContainer = (FrameLayout) findViewById(R.id.fl_webview_container);
    L6:
        return this.mWebviewContainer;
    }

    public View getLoadingView() {
        if (this.loadingView != null) goto L6;
        this.loadingView = (iOSLoadingView) findViewById(R.id.iOSLoadingView);
    L6:
        return this.loadingView;
    }

    public View getMessageBox() {
        if (this.mCommAlertOverlay != null) goto L6;
        this.mCommAlertOverlay = (CommAlertOverlay) findViewById(R.id.message_box_overlay);
    L6:
        return this.mCommAlertOverlay;
    }

    @Override // com.dtf.face.api.IDTLoadingFragment
    public void hideAuthorizationView() {
        FrameLayout r100 = getAuthorizationViewContainer();
        if (r100 == null) goto L6;
        r100.setVisibility(4);
        return;
    }

    @Override // com.dtf.face.api.IDTLoadingFragment
    public void hideLoadingView() {
        View r100 = getLoadingView();
        if (r100 == null) goto L5;
        r100.setVisibility(4);
    L5:
        ImageView r101 = (ImageView) findViewById(R.id.title_close);
        this.ivTitleClose = r101;
        if (r101 == null) goto L9;
        r101.setVisibility(0);
        return;
    }

    @Override // com.dtf.face.api.IDTLoadingFragment
    public void onUILoadSuccess() {
        ImageView r100 = (ImageView) findViewById(R.id.title_back);
        this.ivTitleBack = r100;
        if (r100 == null) goto L7;
        Bitmap r101 = ws7.c.b(ws7.c.f561063b.getTitleBackBase64(), ws7.c.f561063b.getTitleBackPath());
        if (r101 == null) goto L7;
        this.ivTitleBack.setImageBitmap(r101);
    L7:
        ImageView r102 = (ImageView) findViewById(R.id.title_close);
        this.ivTitleClose = r102;
        if (r102 == null) goto L16;
        Bitmap r103 = ws7.c.b(ws7.c.f561063b.getTitleCloseBase64(), ws7.c.f561063b.getTitleClosePath());
        if (r103 == null) goto L13;
        this.ivTitleClose.setImageBitmap(r103);
    L13:
        if (ws7.c.f561063b.needTransparentLoading(hs7.a.h().getContext()) == true) goto L17;
        this.ivTitleClose.setVisibility(0);
        return;
    L17:
        return;
    }

    @Override // com.dtf.face.api.IDTLoadingFragment
    public void showAuthorizationView() {
        FrameLayout r100 = getAuthorizationViewContainer();
        if (r100 == null) goto L5;
        r100.setVisibility(0);
    L5:
        FrameLayout r101 = (FrameLayout) findViewById(R.id.loading_container);
        if (r101 == null) goto L9;
        r101.setBackgroundColor(getResources().getColor(android.R.color.white));
        return;
    }

    @Override // com.dtf.face.api.IDTLoadingFragment
    public void showLoadingView() {
        View r100 = getLoadingView();
        if (r100 == null) goto L6;
        r100.setVisibility(0);
        return;
    }

    public FaceLoadingFragment() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_dtf_face_ui_toyger_FaceLoadingFragment_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public <T extends View> T findViewById(int r100) {
        View r101 = this.mRootView;
        if (r101 != null) goto L5;
        return null;
    L5:
        return (T) r101.findViewById(r100);
    }

    @Override // com.dtf.face.api.IDTLoadingFragment
    public void initTitleBar(boolean r100) {
        if (r100 == false) goto L6;
        js7.b.h(false, new View[]{this.ivTitleClose});
    L6:
        if (r100 == false) goto L8;
        int r101 = 0;
    L9:
        View[] r102 = {findViewById(R.id.title_back), findViewById(R.id.bar_title)};
        if (r101 == 0) goto L14;
        if (r101 == 4) goto L14;
        if (r101 == 8) goto L14;
    L20:
        ImageView r103 = this.ivTitleClose;
        if (r103 == null) goto L27;
        r103.setVisibility(0);
        return;
    L27:
        return;
    L14:
        int r104 = 0;
    L15:
        if (r104 >= 2) goto L20;
        View r105 = r102[r104];
        if (r105 == null) goto L19;
        r105.setVisibility(r101);
    L19:
        r104 = r104 + 1;
        goto L15
    L8:
        r101 = 4;
        goto L9
    }

    public void resetExitPosition(boolean r100) {
        IDTUIListener r101 = hs7.a.h().f487001m;
        if (r101 != null) goto L5;
        js7.b.h(true, new View[]{this.ivTitleClose});
        return;
    L5:
        if (r101.onIsPageScanCloseImageLeft() == false) goto L8;
        if (r100 == false) goto L8;
        this.ivTitleClose.setVisibility(4);
    L8:
        js7.b.h(r101.onIsPageScanCloseImageLeft(), new View[]{this.ivTitleClose});
    }

    @Override // com.dtf.face.api.IDTLoadingFragment
    public void setCloseCallBack(IDTFragment.ICloseCallBack r100) {
        Context r101 = hs7.a.h().getContext();
        if (r101 != null) goto L5;
    L7:
        int r102 = js7.b.f500230a;
        View r103 = findViewById(R.id.loading_title_bar);
        int r104 = r102 - 6;
        if (r104 <= 0) goto L13;
        if (r103 == null) goto L13;
        r103.setPadding(0, js7.b.a(hs7.a.h().getContext(), r104), 0, 0);
        View r105 = findViewById(R.id.fl_webview_container);
        if (r105 == null) goto L13;
        FrameLayout.LayoutParams r106 = (FrameLayout.LayoutParams) r105.getLayoutParams();
        r106.topMargin = js7.b.a(hs7.a.h().getContext(), r102 + 40);
        r105.setLayoutParams(r106);
    L13:
        ImageView r107 = (ImageView) findViewById(R.id.title_back);
        this.ivTitleBack = r107;
        if (r107 == null) goto L18;
        r107.setOnClickListener(new b(this, r100));
        Bitmap r108 = ws7.c.b(ws7.c.f561063b.getTitleBackBase64(), ws7.c.f561063b.getTitleBackPath());
        if (r108 == null) goto L18;
        this.ivTitleBack.setImageBitmap(r108);
    L18:
        ImageView r109 = (ImageView) findViewById(R.id.title_close);
        this.ivTitleClose = r109;
        if (r109 == null) goto L25;
        r109.setOnClickListener(new c(r100));
        Bitmap r110 = ws7.c.b(ws7.c.f561063b.getTitleCloseBase64(), ws7.c.f561063b.getTitleClosePath());
        if (r110 == null) goto L23;
        this.ivTitleClose.setImageBitmap(r110);
    L23:
        resetExitPosition(false);
        return;
    L25:
        return;
    L5:
        if (js7.b.f500230a != 0) goto L7;
        float r111 = js7.b.f(r101);
        Resources r112 = r101.getResources();
        js7.b.f500230a = (int) ((r111 / WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics()).density) + 0.5f);
        goto L7
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        View r103 = this.mRootView;
        if (r103 == null) goto L13;
        ViewParent r104 = r103.getParent();
        if ((r104 instanceof ViewGroup) == false) goto L12;
        ((ViewGroup) r104).removeView(this.mRootView);
    L12:
        return this.mRootView;
    L13:
        this.mRootView = r100.inflate(getLayoutID(), r101, false);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        RecordService.getInstance().recordException(th);
        goto L12
    }

    @Override // com.dtf.face.api.IDTLoadingFragment
    public void showMessageBox(String r110, String r111, String r112, String r113, String r114, IDTLoadingFragment.IMessageBoxCB r115) {
        showLoadingView();
        CommAlertOverlay r100 = (CommAlertOverlay) findViewById(R.id.message_box_overlay);
        if (hs7.a.h().l() == false) goto L13;
        int r101 = R.color.dtf_guide_permission_toast_bg;
        int r102 = R.color.dtf_dialog_msg_color;
        CommAlertOverlay r103 = (CommAlertOverlay) INVOKESTATIC_com_dtf_face_ui_toyger_FaceLoadingFragment_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.dtf.elemeverify.ui.overlay.ElemeAlertOverlay").getDeclaredConstructor(new Class[]{Context.class, AttributeSet.class}).newInstance(new Object[]{hs7.a.h().getContext(), null});     // Catch: Throwable -> L11
        ((FrameLayout) findViewById(R.id.loading_container)).addView(r103);     // Catch: Throwable -> L9
        r100 = r103;
    L14:
        if (r100 == null) goto L61;
        r100.setTitleText(r110);
        r100.setMessageText(r111);
        if (TextUtils.isEmpty(r113) == true) goto L18;
        r100.setButtonType(true);
        r100.setCancelText(r113);
    L20:
        if (TextUtils.isEmpty(r112) == true) goto L22;
        r100.setConfirmText(r112);
    L22:
        Context r104 = r100.getContext();
        ws7.c.a r105 = new ws7.c.a();
        GuideConfig r106 = ws7.c.f561063b;
        if ("Z1030".equals(r114) == false) goto L25;
    L54:
        r105 = r106.getDialogPermissionFailedConfig(r104, r101);
    L55:
        ws7.c.a(r100, r105);
        r100.setVisibility(0);
        r100.setCommAlertOverlayListener(new a(r115));
        return;
    L25:
        if ("Z1019".equals(r114) == true) goto L54;
        if ("Z1025".equals(r114) == false) goto L30;
    L53:
        r105 = r106.getDialogNetworkFailedConfig(r104, r101);
        goto L55
    L30:
        if ("Z1011".equals(r114) == true) goto L53;
        if ("Z1012".equals(r114) == true) goto L53;
        if ("Z1028".equals(r114) == true) goto L53;
        if ("Z1040".equals(r114) == true) goto L53;
        if ("Z1002".equals(r114) == false) goto L41;
    L52:
        r105 = r106.getDialogSupportFailedConfig(r104, r101);
        goto L55
    L41:
        if ("Z1021".equals(r114) == true) goto L52;
        if ("Z1018".equals(r114) == true) goto L52;
        if ("Z1004".equals(r114) == true) goto L52;
        if ("Z1003".equals(r114) == true) goto L52;
        if ("Z1008".equals(r114) == false) goto L55;
        r105 = r106.getDialogExitConfig(r104, r101, r102);
        goto L55
    L18:
        r100.setButtonType(false);
        goto L20
    L61:
        return;
    L9:
        th = th;
        r100 = r103;
    L12:
        RecordService.getInstance().recordException(th);
    L11:
        th = th;
        goto L12
    L13:
        r101 = R.color.dtf_dialog_confirm_color;
        r102 = R.color.dtf_dialog_cancel_color;
        goto L14
    }
}
