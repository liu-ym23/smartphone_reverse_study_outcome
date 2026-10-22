package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.drive.biz.preview.viewfinder.DriveViewFinderVM;
import com.bytedance.ee.bear.drive.biz.upload.file.FileUploadFragment;
import com.bytedance.ee.bear.drive.biz.upload.multimedia.MediaUploadFragment;
import com.bytedance.ee.bear.drive.common.activity.DriveCarrierActivity;
import com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wps.WpsView;
import com.bytedance.ee.bear.drive.view.widget.DriveWebView;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.bear.fileselector.bean.FileBean;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.drive.mime.DriveLocalMime;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class WpsPreviewView extends AbsPreviewView implements sa5.a, com.bytedance.ee.bear.drive.view.preview.wps.h.a {
    private static final String TAG = "DRIVE_PREVIEW_FLOWWpsPreviewView";
    private boolean isWpsEditAvailable;
    private com.bytedance.ee.bear.drive.view.preview.wps.b mFileConfig;
    private WpsView mWpsView;
    private DriveViewFinderVM viewFinderVM;
    private com.bytedance.ee.bear.drive.view.preview.wps.h webChromeClient;

    public class a implements com.bytedance.ee.bear.drive.view.preview.wps.f {
        public final /* synthetic */ WpsPreviewView a;

        public a(WpsPreviewView r1) {
            this.a = r1;
        }
    }

    public class b implements c95.c {
        public final /* synthetic */ WpsPreviewView a;

        @Override // c95.c
        public final void onShowStart() {
            this.a.trackOpenStart();
        }

        public b(WpsPreviewView r1) {
            this.a = r1;
        }

        @Override // c95.c
        public final void b(String r3) {
            tt5.a.h(WpsPreviewView.TAG, "onShowSuccess");
            this.a.trackOpenSuccess(r3);
            this.a.trackOpenDowngradeSuccess(r3);
        }

        @Override // c95.c
        public final void a(String r5, Throwable r6) {
            tt5.a.d(WpsPreviewView.TAG, "openType: " + r5 + "  errorMessage: " + r6);
            if (this.a.mPreviewViewModel != null) goto L22;
            tt5.a.d(WpsPreviewView.TAG, "onShowFailure mPreviewViewModel is null");
            return;
        L22:
            JSONObjectProtectorUtils.getBoolean(new JSONObject(r6.getMessage()), "isSuccess");     // Catch: Exception -> L8
            this.a.mPreviewViewModel.liveInnerShowRetryPage().postValue(null);     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            tt5.a.e(WpsPreviewView.TAG, "parse wpsLoadStatus fail. ", e, false);
            String r0 = JSON.parseObject(r6.getMessage()).getString("errorType");     // Catch: Exception -> L12
        L15:
            if (TextUtils.equals(r0, "SessionFull") == false) goto L17;
            int r1 = 2131888468;
        L18:
            PreviewViewModel.a r2 = new PreviewViewModel.a();
            r2.a = this.a.mContext.getResources().getString(r1);
            r2.b = 2;
            this.a.mPreviewViewModel.getLiveInnerChangeTipsState().postValue(r2);
            this.a.mPreviewViewModel.getLiveInnerDowngrade().postValue(Integer.valueOf(DriveLocalMime.WPS.getValue()));
            this.a.trackOpenDowngradeFail(r5, r6);
            return;
        L17:
            r1 = 2131888467;
        L12:
            e = move-exception;
            tt5.a.f(WpsPreviewView.TAG, e, false);
            r0 = "";
            goto L15
        }
    }

    public class c extends za5.b {
        public final /* synthetic */ WpsPreviewView a;

        @Override // za5.b, za5.a
        public final void b() {
            WpsPreviewView.access$100(this.a);
        }

        public c(WpsPreviewView r1) {
            this.a = r1;
        }

        @Override // za5.b, za5.a
        public final void c(List<? extends FileBean> r4) {
            if (r4.size() <= 0) goto L6;
            ArrayList r0 = new ArrayList();
            r0.add(Uri.fromFile(ay4.d.a().i(((FileBean) ListProtector.get(r4, 0)).getPath())));
            Uri[] r5 = new Uri[r0.size()];
            r0.toArray(r5);
            WpsPreviewView.access$000(this.a).a(r5);
            return;
        }
    }

    public class d extends bb5.k {
        public final /* synthetic */ WpsPreviewView a;

        @Override // bb5.f
        public final void onPermissionDenied() {
            WpsPreviewView.access$100(this.a);
        }

        public d(WpsPreviewView r1) {
            this.a = r1;
        }
    }

    private void notifyWebWithEmptyValue() {
        com.bytedance.ee.bear.drive.view.preview.wps.h r1 = this.webChromeClient;
        r1.a(new Uri[0]);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView
    public /* bridge */ /* synthetic */ void clean() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public /* bridge */ /* synthetic */ boolean isPreviewSupported() {
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public /* bridge */ /* synthetic */ void onNewConfiguration(Configuration r1) {
    }

    private void initWebView() {
        WpsView r0 = this.mWpsView;
        if ((r0 instanceof BaseWebPreviewView) == true) goto L6;
        tt5.a.k(TAG, "initWebView current WebView isn't expectation");
        return;
    L6:
        DriveWebView r1 = r0.getWebView();
        new n45.c(r1.getSettings(), (com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class)).a(r1);
        if (this.mFileConfig.c == false) goto L10;
        r1.getSettings().setBuiltInZoomControls(true);
        r1.getSettings().setDisplayZoomControls(false);
    L10:
        if (this.isWpsEditAvailable == false) goto L14;
        com.bytedance.ee.bear.drive.view.preview.wps.h r2 = this.webChromeClient;
        com.bytedance.ee.bear.drive.view.widget.c r3 = r1.p;
        if (r3 == null) goto L14;
        r3.a.add(r2);
    L14:
        r1.f(new com.bytedance.ee.bear.drive.view.preview.wps.i(this.mViewOwner));
    }

    private void initWpsWebView() {
        this.isWpsEditAvailable = ((Boolean) this.mPreviewViewModel.liveInnerWPSEditModeAvailable().getValue()).booleanValue();
        WpsView r0 = getWpsView(this.mContext);
        this.mWpsView = r0;
        r0.setUserAbility(this.mUserComponentAbility);
        this.mWpsView.setWpsFileConfig(this.mFileConfig);
        WpsView r1 = this.mWpsView;
        boolean r2 = this.isWpsEditAvailable;
        r1.getClass();
        boolean r3 = com.bytedance.ee.bear.appsetting.c.a.a.f("spacekit.mobile.drive_wps_center_version_enable");
        tt5.a.h("WpsWebView", "initWpsController().. isVersionCenterEnable = " + r3);
        if (r3 == false) goto L5;
        com.bytedance.ee.bear.drive.view.preview.wps.a r4 = new com.bytedance.ee.bear.drive.view.preview.wps.n(r1, r2);
    L6:
        r1.o = r4;
        WpsView r5 = this.mWpsView;
        r5.q = new WpsView.c(this.mFileModel);
        r5.k = true;
        r5.r = false;
        r5.s = "";
        r5.w = false;
        r5.onSetup(this.mParentViewOwner, this.mViewOwner);
        this.mWpsView.setWpsLoadState(new a(this));
        initWebView();
        this.mWpsView.setOnShowViewTrackEventCallback(new b(this));
        disableBehavior();
        return;
    L5:
        r4 = new com.bytedance.ee.bear.drive.view.preview.wps.t(r1, r2);
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public boolean onBackPressed() {
        WpsView r0 = this.mWpsView;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.onBackPressed() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.h.a
    public void requestCamera() {
        tt5.a.h(TAG, "requestCamera");
        Fragment r0 = this.mViewOwner.lifecycleOwner();
        c r1 = new c(this);
        d r2 = new d(this);
        FragmentActivity r3 = r0.getActivity();
        if (r3 == null) goto L5;
        FragmentManager r4 = r3.getSupportFragmentManager();
        FileSelectConfig.h r5 = FileSelectConfig.larkCamaraBuilder();
        FileSelectConfig r6 = r5.a;
        r6.fileSelectListener = r1;
        r6.permissionCheckListener = r2;
        r6.enableImageCompress = false;
        FileSelectConfig r7 = r5.a();
        String r8 = r0.getClass().getName();
        int r9 = com.bytedance.ee.bear.fileselector.d.a;
        com.bytedance.ee.bear.fileselector.d.a.c(r3, r4, r7, r8);
        return;
    L5:
        tt5.a.k("PickerHelper", "requestCameraPicker activity is null");
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void show() {
        this.mWpsView.show();
    }

    public void trackGetInitialDataSuccess() {
        if (this.mPreviewViewModel == null) goto L6;
        HashMap r0 = new HashMap();
        r0.put("source_type", String.valueOf(this.mSourceType));
        this.mPreviewViewModel.liveInnerReportMsg().a(new a0(24, r0));
        return;
    }

    public void trackLoadTemplateSuccess() {
        if (this.mPreviewViewModel == null) goto L6;
        HashMap r0 = new HashMap();
        r0.put("source_type", String.valueOf(this.mSourceType));
        this.mPreviewViewModel.liveInnerReportMsg().a(new a0(23, r0));
        return;
    }

    public void trackWpsRenderSuccess() {
        if (this.mPreviewViewModel == null) goto L6;
        HashMap r0 = new HashMap();
        r0.put("source_type", String.valueOf(this.mSourceType));
        this.mPreviewViewModel.liveInnerReportMsg().a(new a0(25, r0));
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public View getView() {
        return this.mWpsView;
    }

    public static /* synthetic */ com.bytedance.ee.bear.drive.view.preview.wps.h access$000(WpsPreviewView r0) {
        return r0.webChromeClient;
    }

    public static /* synthetic */ void access$100(WpsPreviewView r0) {
        r0.notifyWebWithEmptyValue();
    }

    private List<Uri> getCameraReceiveValue(Intent r3) {
        ArrayList r0 = new ArrayList();
        String r4 = (String) ListProtector.get(r3.getStringArrayListExtra("SELECTED_PHOTOS"), 0);
        r0.add(Uri.fromFile(ay4.d.a().i(r4)));
        return r0;
    }

    private List<Uri> getSelectFileOrMediaReceiveValue(Intent r7) {
        String r0 = r7.getStringExtra("drive_picker_type");
        ArrayList<String> r1 = r7.getStringArrayListExtra("drive_picker_file_list");
        ArrayList r2 = (ArrayList) r7.getSerializableExtra("drive_picker_media_list");
        int r4 = 0;
        boolean r3 = r7.getBooleanExtra("drive_picker_success", false);
        boolean r8 = r7.getBooleanExtra("drive_picker_file_use_uri", false);
        if (r3 == false) goto L5;
        ArrayList r5 = new ArrayList();
        if (TextUtils.equals(r0, "drive_picker_type_file") == false) goto L16;
    L9:
        if (r4 >= r1.size()) goto L20;
        String r6 = (String) ListProtector.get(r1, r4);
        if (r8 == false) goto L13;
        Uri r9 = UriProtector.parse(r6);
    L14:
        r5.add(r9);
        r4 = r4 + 1;
        goto L9
    L13:
        r9 = Uri.fromFile(ay4.d.a().i(r6));
    L20:
        return r5;
    L16:
        if (TextUtils.equals(r0, "drive_picker_type_media") == false) goto L20;
    L18:
        if (r4 >= r2.size()) goto L20;
        String r10 = ((FileBean) ListProtector.get(r2, r4)).getPath();
        r5.add(Uri.fromFile(ay4.d.a().i(r10)));
        r4 = r4 + 1;
        goto L18
    L5:
        return new ArrayList();
    }

    private WpsView getWpsView(Context r4) {
        q85.a r0 = ((q85.c) org.koin.java.a.a(q85.c.class)).b();
        if (r0 == null) goto L12;
        BaseWebPreviewView r1 = r0.a;
        if (r1 == null) goto L12;
        if ((r1 instanceof WpsView) == false) goto L12;
        WpsView r2 = (WpsView) r1;
        r2.setPreloadStatus(r0.b);
        return r2;
    L12:
        return new WpsView(r4);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.h.a
    public void requestFilePicker(boolean r5) {
        tt5.a.h(TAG, "requestFilePicker");
        Fragment r0 = this.mViewOwner.lifecycleOwner();
        Bundle r1 = new Bundle();
        r1.putBoolean("extras_need_result", true);
        r1.putBoolean("extras_do_not_upload", true);
        r1.putBoolean("extras_multiple", r5);
        DriveCarrierActivity.F1(r0, FileUploadFragment.class, r1);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void showSelectedComment(String r2) {
        this.mWpsView.showSelectedComment(r2);
    }

    public void trackWpsStageEnd(com.bytedance.ee.bear.drive.view.preview.wps.u r4) {
        if (this.mPreviewViewModel != null) goto L5;
        return;
    L5:
        new HashMap().put("source_type", String.valueOf(this.mSourceType));
        r4.getClass();
        throw null;
    }

    public void trackWpsStageStart(com.bytedance.ee.bear.drive.view.preview.wps.u r2) {
        if (this.mPreviewViewModel != null) goto L5;
        return;
    L5:
        new HashMap();
        r2.getClass();
        throw null;
    }

    public void trackWpsStart(String r4) {
        if (this.mPreviewViewModel == null) goto L6;
        HashMap r0 = new HashMap();
        r0.put("wps_stage", r4);
        this.mPreviewViewModel.liveInnerReportMsg().a(new a0(26, r0));
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void updateComment(ArrayList<CommentRectF> r2) {
        this.mWpsView.h = r2;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.h.a
    public void requestMediaPicker(boolean r5, boolean r6) {
        tt5.a.h(TAG, "requestMediaPicker");
        Fragment r0 = this.mViewOwner.lifecycleOwner();
        Bundle r1 = new Bundle();
        r1.putBoolean("extras_need_result", true);
        r1.putBoolean("extras_do_not_upload", true);
        r1.putBoolean("extras_multiple", r5);
        if (r6 == false) goto L5;
        r1.putInt("extras_media_type", 0);
    L6:
        DriveCarrierActivity.F1(r0, MediaUploadFragment.class, r1);
        return;
    L5:
        r1.putInt("extras_media_type", 1);
        goto L6
    }

    @Override // sa5.a
    public void onActivityResult(int r2, int r3, Intent r4) {
        if (r2 != 100) goto L11;
        ArrayList r5 = new ArrayList();
        if (r4 != null) goto L7;
    L9:
        Uri[] r6 = new Uri[r5.size()];
        r5.toArray(r6);
        this.webChromeClient.a(r6);
        return;
    L7:
        if (r3 != 101) goto L9;
        r5.addAll(getSelectFileOrMediaReceiveValue(r4));
        goto L9
    }

    public WpsPreviewView(ViewOwner r2, ViewOwner r3, Context r4, z r5, a95.a r6) {
        super(r2, r3, r4, r5, r6);
        this.webChromeClient = new com.bytedance.ee.bear.drive.view.preview.wps.h(this);
        String r7 = this.mFileModel.b;
        com.bytedance.ee.bear.drive.view.preview.wps.b r8 = new com.bytedance.ee.bear.drive.view.preview.wps.b();
        r8.d = i75.h.f(r7);
        r8.e = "wps".equalsIgnoreCase(r7);
        r8.f = "et".equalsIgnoreCase(r7);
        boolean r9 = false;
        if (i75.h.g(r7) == false) goto L5;
    L8:
        boolean r10 = true;
    L9:
        r8.a = r10;
        if (i75.h.h(r7) == false) goto L12;
    L15:
        r9 = true;
    L16:
        r8.b = r9;
        r8.c = i75.h.j(r7);
        this.mFileConfig = r8;
        this.viewFinderVM = (DriveViewFinderVM) r3.viewModel(DriveViewFinderVM.class);
        initWpsWebView();
        return;
    L12:
        if (r8.d == true) goto L15;
        if (r8.f == false) goto L16;
    L5:
        if (r8.e == true) goto L8;
        r10 = false;
        goto L9
    }
}
