package com.bytedance.ee.bear.drive.biz.preview.image;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.biz.permission.DriveThirdPartyPermissionVM;
import com.bytedance.ee.bear.drive.biz.permission.model.ThirdPartyAttachmentPermission;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.image.thumb.DriveImageThumbViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.drive.render.k;
import com.bytedance.ee.util.ui.n;
import com.larus.apm.impl.protector.RunnableProtector;
import java.text.DecimalFormat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n*\u0001\u001e\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u001a\u0010 \u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010!\u001a\u00020\u000fH\u0002J\u0012\u0010\"\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0017\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000fH\u0002J\b\u0010)\u001a\u00020\u000bH\u0002J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\tH\u0002J\u000e\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/image/DriveImageThumbLoadingPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "mImageThumbView", "Lcom/bytedance/ee/bear/drive/biz/preview/image/DriveImageThumbView;", "mMainPageRootRl", "Landroid/view/ViewGroup;", "mForceGone", "", "onAttachPreview", "", "onDetachPreview", "getInitImageThumbView", "getLoadingActionBottomMarginDp", "", "onAttachToUIContainer", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onAttachToHost", "initObserve", "findMainPageRoot", "thumbViewModel", "Lcom/bytedance/ee/bear/drive/view/preview/image/thumb/DriveImageThumbViewModel;", "trackFileInfoExtra", "fileModel", "Lcom/bytedance/ee/bear/drive/core/model/AbsFileModel;", "imageThumbLoadListener", "com/bytedance/ee/bear/drive/biz/preview/image/DriveImageThumbLoadingPlugin$imageThumbLoadListener$1", "Lcom/bytedance/ee/bear/drive/biz/preview/image/DriveImageThumbLoadingPlugin$imageThumbLoadListener$1;", "trackLoadThumbStageStart", "percent", "trackLoadThumbStageEnd", "showImageFileSize", "fileSize", "", "(Ljava/lang/Long;)V", "showImageLoadingProgress", "progress", "showImageDownloadSuccess", "setImageThumbViewVisible", "visible", "updateForceGone", "force", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveImageThumbLoadingPlugin extends AbsDrivePreviewPlugin {
    public static final a Companion = null;
    private static final int DEFAULT_LOADING_ACTION_BOTTOM_MARGIN_DP = 65;
    private static final String TAG = "DriveImageThumbLoadingPlugin";
    private final c imageThumbLoadListener;
    private boolean mForceGone;
    private DriveImageThumbView mImageThumbView;
    private ViewGroup mMainPageRootRl;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ DriveImageThumbLoadingPlugin a;

        public b(DriveImageThumbLoadingPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            DriveImageThumbLoadingPlugin.access$thumbViewModel(this.a).isOnImageDowngrade().postValue(Boolean.TRUE);
        }
    }

    public static final class c extends u75.b.C0306b {
        public final /* synthetic */ DriveImageThumbLoadingPlugin a;

        public c(DriveImageThumbLoadingPlugin r1) {
            this.a = r1;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void b(z r5) {
            Intrinsics.checkNotNullParameter(r5, "previewFileModel");
            Intrinsics.checkNotNullParameter(r5, "previewFileModel");
            w75.a r0 = this.a.getHost().c.getFileModel();
            DriveImageThumbLoadingPlugin.access$trackFileInfoExtra(this.a, r0);
            if (r0 != null) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r2 == false) goto L10;
            return;
        L10:
            DriveImageThumbLoadingPlugin.access$thumbViewModel(this.a).isOnImageThumbProcess().setValue(Boolean.TRUE);
            if (r5.j == false) goto L14;
            DriveImageThumbLoadingPlugin.access$trackLoadThumbStageEnd(this.a, r0);
            DriveImageThumbLoadingPlugin.access$showImageFileSize(this.a, Long.valueOf(r5.e));
            return;
        L14:
            DriveImageThumbLoadingPlugin.access$setImageThumbViewVisible(this.a, false);
            DriveImageThumbLoadingPlugin.access$thumbViewModel(this.a).isOnImageDowngrade().postValue(Boolean.FALSE);
            return;
        L5:
            if (r0.x == true) goto L7;
            r2 = true;
            goto L8
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void c(ErrCode r4) {
            Intrinsics.checkNotNullParameter(r4, "code");
            Intrinsics.checkNotNullParameter(r4, "code");
            w75.a r5 = this.a.getHost().c.getFileModel();
            if (r5 == null) goto L28;
            g85.f r0 = o75.b.a().getMimeTypeManager();
            w75.b r1 = r5.c();
            Long r2 = null;
            if (r1 == null) goto L7;
            String r3 = r1.k;
        L9:
            if (((g85.b) r0).j(r3, null) == false) goto L29;
            DriveImageThumbLoadingPlugin.access$trackFileInfoExtra(this.a, r5);
            if (r5.x == true) goto L14;
            return;
        L14:
            MutableLiveData<Boolean> r6 = DriveImageThumbLoadingPlugin.access$thumbViewModel(this.a).isOnImageThumbProcess();
            Boolean r7 = Boolean.TRUE;
            r6.setValue(r7);
            if (r5.e() == false) goto L19;
            DriveImageThumbLoadingPlugin.access$thumbViewModel(this.a).isOnImageDowngrade().postValue(r7);
            return;
        L19:
            if (DriveImageThumbLoadingPlugin.access$getMForceGone$p(this.a) == true) goto L21;
            Toast.showFailureText(DriveImageThumbLoadingPlugin.access$getActivity(this.a), 2131887258);
        L21:
            DriveImageThumbLoadingPlugin r8 = this.a;
            w75.a r9 = r8.getHost().c.getFileModel();
            if (r9 == null) goto L26;
            w75.b r10 = r9.c();
            if (r10 == null) goto L26;
            r2 = Long.valueOf(r10.c);
        L26:
            DriveImageThumbLoadingPlugin.access$showImageFileSize(r8, r2);
            return;
        L29:
            return;
        L7:
            r3 = null;
            goto L9
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void onProgress(int r4) {
            w75.a r0 = this.a.getHost().c.getFileModel();
            if (r0 != null) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r2 == false) goto L10;
            return;
        L10:
            DriveImageThumbLoadingPlugin.access$trackLoadThumbStageStart(this.a, r0, r4);
            if (r0 != null) goto L13;
            return;
        L13:
            if (r0.e() != true) goto L16;
            return;
        L16:
            if (r4 >= 100) goto L18;
            DriveImageThumbLoadingPlugin.access$showImageLoadingProgress(this.a, r4);
            return;
        L18:
            DriveImageThumbLoadingPlugin.access$showImageDownloadSuccess(this.a);
            return;
        L5:
            if (r0.x == true) goto L7;
            r2 = true;
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r2, T r3) {
            Intrinsics.checkNotNullParameter(r2, "code");
            Intrinsics.checkNotNullParameter(r2, "code");
            if (r2 == InfoCode.HitCache) goto L5;
            return;
        L5:
            if ((r3 instanceof w75.a) == false) goto L19;
            w75.a r0 = (w75.a) r3;
            DriveImageThumbLoadingPlugin.access$trackFileInfoExtra(this.a, r0);
            if (r0.e() == true) goto L10;
            return;
        L10:
            if ((r3 instanceof f85.a) == false) goto L13;
            Long r4 = Long.valueOf(((f85.a.C0229a) ((f85.a) r3).a).c);
        L16:
            r0.x = true;
            DriveImageThumbLoadingPlugin.access$thumbViewModel(this.a).isOnImageThumbProcess().setValue(Boolean.TRUE);
            DriveImageThumbLoadingPlugin.access$showImageFileSize(this.a, r4);
            return;
        L13:
            if ((r3 instanceof f85.b) == false) goto L15;
            r4 = Long.valueOf(((f85.b.a) ((f85.b) r3).a).c);
            goto L16
        L15:
            r4 = null;
            goto L16
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ DriveImageThumbViewModel a;
        public final /* synthetic */ DrivePluginHost b;

        public d(DriveImageThumbViewModel r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r2) {
            if (((Boolean) r2).booleanValue() == true) goto L6;
            return;
        L6:
            if (j.a.a.getNetworkState().a() == true) goto L9;
            return;
        L9:
            if (Intrinsics.areEqual(this.a.isOnImageThumbProcess().getValue(), Boolean.TRUE) == false) goto L18;
            w75.a r3 = this.b.c.getFileModel();
            if (r3 == null) goto L14;
            r3.g(false);
        L14:
            this.b.c().a();
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DriveImageThumbLoadingPlugin b;

        public e(DrivePluginHost r1, DriveImageThumbLoadingPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            boolean r4 = ((ConnectionService.NetworkState) r3).a();
            w75.a r0 = this.a.c.getFileModel();
            if (r0 == null) goto L7;
            boolean r1 = true;
            if (r0.x != true) goto L7;
        L8:
            if (r1 == false) goto L17;
            DriveImageThumbView r2 = DriveImageThumbLoadingPlugin.access$getInitImageThumbView(this.b);
            if (r2 == null) goto L13;
            r2.setEnable(r4);
        L13:
            if (r4 == false) goto L16;
            DriveImageThumbLoadingPlugin.access$thumbViewModel(this.b).isOnImageDowngrade().postValue(Boolean.TRUE);
            return;
        L16:
            return;
        L17:
            return;
        L7:
            r1 = false;
            goto L8
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ DriveImageThumbLoadingPlugin a;

        public f(DriveImageThumbLoadingPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            ThirdPartyAttachmentPermission r4 = (ThirdPartyAttachmentPermission) r3;
            if (r4 == null) goto L8;
            DriveImageThumbLoadingPlugin r0 = this.a;
            if (r4.getView() == 1) goto L9;
            r0.updateForceGone(true);
            return;
        L9:
            return;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ DriveImageThumbLoadingPlugin a;

        public g(DriveImageThumbLoadingPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            u55.b r3 = (u55.b) r2;
            if (r3 == null) goto L8;
            DriveImageThumbLoadingPlugin r0 = this.a;
            if (r3.e() == true) goto L9;
            r0.updateForceGone(true);
            return;
        L9:
            return;
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ DriveImageThumbLoadingPlugin a;

        public h(DriveImageThumbLoadingPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Integer r3 = (Integer) r2;
            if (r3 != null) goto L6;
        L7:
            this.a.updateForceGone(true);
            return;
        L6:
            if (r3.intValue() != 0) goto L7;
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ DriveImageThumbLoadingPlugin a;

        public i(DriveImageThumbLoadingPlugin r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DriveImageThumbLoadingPlugin.access$setImageThumbViewVisible(this.a, false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void findMainPageRoot() {
        if (this.mMainPageRootRl != null) goto L6;
        this.mMainPageRootRl = (ViewGroup) findViewById(2131379451);
    L6:
        if (this.mMainPageRootRl != null) goto L9;
        tt5.a.d("DriveComponent", "DriveImageThumbLoadingPlugin() find mainPageRootRl null");
        return;
    }

    private final DriveImageThumbView getInitImageThumbView() {
        if (this.mImageThumbView != null) goto L6;
        DriveImageThumbView r0 = new DriveImageThumbView(getActivity(), null, 6, 0);
        RelativeLayout.LayoutParams r1 = new RelativeLayout.LayoutParams(-2, -2);
        r1.bottomMargin = n.c(getLoadingActionBottomMarginDp());
        r1.addRule(12);
        r1.addRule(14, -1);
        r0.setLayoutParams(r1);
        r0.setVisibility(8);
        r0.setOnClickListener(new b(this));
        this.mImageThumbView = r0;
    L6:
        return this.mImageThumbView;
    }

    private final DriveImageThumbViewModel thumbViewModel() {
        return (DriveImageThumbViewModel) viewModel(DriveImageThumbViewModel.class);
    }

    public DriveImageThumbLoadingPlugin() {
        this.imageThumbLoadListener = new c(this);
    }

    private final int getLoadingActionBottomMarginDp() {
        k r0 = getDriveUIConfig();
        if (r0 == null) goto L7;
        k.c r1 = r0.d();
        if (r1 == null) goto L7;
        return r1.c;
    L7:
        return DEFAULT_LOADING_ACTION_BOTTOM_MARGIN_DP;
    }

    private final void showImageDownloadSuccess() {
        DriveImageThumbView r0 = getInitImageThumbView();
        if (r0 == null) goto L6;
        r0.getLoadingActionViewFromXml().setText(r0.getContext().getString(2131889461));
        r0.postDelayed(new i(this), 1000);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        DriveImageThumbView r0 = getInitImageThumbView();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getParent() != null) goto L11;
        ViewGroup r1 = this.mMainPageRootRl;
        if (r1 == null) goto L12;
        r1.addView(r0);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        DriveImageThumbView r0 = getInitImageThumbView();
        if (r0 == null) goto L8;
        ViewGroup r1 = this.mMainPageRootRl;
        if (r1 == null) goto L9;
        r1.removeView(r0);
        return;
    L9:
        return;
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveImageThumbLoadingPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ DriveImageThumbView access$getInitImageThumbView(DriveImageThumbLoadingPlugin r0) {
        return r0.getInitImageThumbView();
    }

    public static final /* synthetic */ boolean access$getMForceGone$p(DriveImageThumbLoadingPlugin r0) {
        return r0.mForceGone;
    }

    public static final /* synthetic */ void access$showImageDownloadSuccess(DriveImageThumbLoadingPlugin r0) {
        r0.showImageDownloadSuccess();
    }

    public static final /* synthetic */ DriveImageThumbViewModel access$thumbViewModel(DriveImageThumbLoadingPlugin r0) {
        return r0.thumbViewModel();
    }

    private final void initObserve(DrivePluginHost r5) {
        DriveImageThumbViewModel r0 = thumbViewModel();
        r0.isOnImageDowngrade().observe(getLifecycleOwner(), new d(r0, r5));
        j.a.a.a().observe(getLifecycleOwner(), new e(r5, this));
        ((DriveThirdPartyPermissionVM) viewModel(DriveThirdPartyPermissionVM.class)).livePerm().observe(getLifecycleOwner(), new f(this));
        ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().observe(getLifecycleOwner(), new g(this));
        k75.a.i(r5).getLiveOuterDlpCode().observe(getLifecycleOwner(), new h(this));
    }

    private final void setImageThumbViewVisible(boolean r4) {
        DriveImageThumbView r0 = this.mImageThumbView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0 == null) goto L7;
        Integer r1 = Integer.valueOf(r0.getVisibility());
    L8:
        if (r4 == false) goto L17;
        if (r1 != null) goto L12;
    L13:
        DriveImageThumbView r2 = this.mImageThumbView;
        if (r2 == null) goto L17;
        r2.setVisibility(0);
        goto L17
    L12:
        if (r1.intValue() != 0) goto L13;
    L17:
        if (r4 == true) goto L26;
        if (r1 != null) goto L21;
    L22:
        DriveImageThumbView r5 = this.mImageThumbView;
        if (r5 == null) goto L26;
        r5.setVisibility(8);
        goto L26
    L21:
        if (r1.intValue() != 8) goto L22;
    L26:
        if (this.mForceGone == false) goto L31;
        DriveImageThumbView r6 = this.mImageThumbView;
        if (r6 == null) goto L32;
        r6.setVisibility(8);
        return;
    L32:
        return;
    L31:
        return;
    L7:
        r1 = null;
        goto L8
    }

    private final void showImageFileSize(Long r5) {
        DriveImageThumbView r0 = getInitImageThumbView();
        if (r0 == null) goto L9;
        if (r5 == null) goto L6;
        Double r6 = Double.valueOf(r5.longValue());
    L7:
        r0.getLoadingActionViewFromXml().setText(xo5.a.c(r0.getContext(), 2131889462, "image_size", wu5.a.a(r6, "0B", new DecimalFormat("#.##"))));
        setImageThumbViewVisible(true);
        return;
    L6:
        r6 = null;
        goto L7
    }

    private final void showImageLoadingProgress(int r5) {
        DriveImageThumbView r0 = getInitImageThumbView();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r5 >= 0) goto L8;
        r5 = 0;
    L10:
        TextView r1 = r0.getLoadingActionViewFromXml();
        StringCompanionObject r2 = StringCompanionObject.INSTANCE;
        r1.setText(String.format("%s%%", Arrays.copyOf(new Object[]{Integer.valueOf(r5)}, 1)));
        setImageThumbViewVisible(true);
        return;
    L8:
        if (r5 <= 100) goto L10;
        r5 = 100;
        goto L10
    }

    private final void trackFileInfoExtra(w75.a r5) {
        g85.f r0 = o75.b.a().getMimeTypeManager();
        String r1 = null;
        if (r5 == null) goto L7;
        w75.b r2 = r5.c();
        if (r2 == null) goto L7;
        String r3 = r2.k;
    L8:
        boolean r4 = ((g85.b) r0).j(r3, null);
        if (r5 == null) goto L11;
        Boolean r6 = Boolean.valueOf(r5.e());
    L12:
        com.bytedance.ee.bear.drive.report.a r7 = k75.a.b(getHost());
        String r8 = getHost().c.getOpenEntity().getFileId();
        if (r4 == false) goto L15;
        r1 = String.valueOf(r6);
    L15:
        r7.t(r8, "thumbnail_type", r1);
        return;
    L11:
        r6 = null;
    L7:
        r3 = null;
        goto L8
    }

    private final void trackLoadThumbStageEnd(w75.a r4) {
        if (r4 == null) goto L7;
        w75.b r1 = r4.c();
        if (r1 == null) goto L7;
        String r2 = r1.a;
    L9:
        if (TextUtils.isEmpty(r2) == false) goto L11;
        return;
    L11:
        k75.a.b(getHost()).s("load_thumb", r4, null);
        return;
    L7:
        r2 = null;
        goto L9
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToHost(r3);
        r3.c().c(this.imageThumbLoadListener);
        initObserve(r3);
    }

    public final void updateForceGone(boolean r3) {
        tt5.a.h(TAG, "updateForceGone: " + r3);
        this.mForceGone = r3;
        setImageThumbViewVisible(false);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$setImageThumbViewVisible(DriveImageThumbLoadingPlugin r0, boolean r1) {
        r0.setImageThumbViewVisible(r1);
    }

    public static final /* synthetic */ void access$showImageFileSize(DriveImageThumbLoadingPlugin r0, Long r1) {
        r0.showImageFileSize(r1);
    }

    public static final /* synthetic */ void access$showImageLoadingProgress(DriveImageThumbLoadingPlugin r0, int r1) {
        r0.showImageLoadingProgress(r1);
    }

    public static final /* synthetic */ void access$trackFileInfoExtra(DriveImageThumbLoadingPlugin r0, w75.a r1) {
        r0.trackFileInfoExtra(r1);
    }

    public static final /* synthetic */ void access$trackLoadThumbStageEnd(DriveImageThumbLoadingPlugin r0, w75.a r1) {
        r0.trackLoadThumbStageEnd(r1);
    }

    private final void trackLoadThumbStageStart(w75.a r3, int r4) {
        if (r3 == null) goto L7;
        w75.b r5 = r3.c();
        if (r5 == null) goto L7;
        String r6 = r5.a;
    L8:
        if (r4 <= 0) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r6) == true) goto L15;
        k75.a.b(getHost()).b(r6, "load_thumb", null);
        return;
    L15:
        return;
    L7:
        r6 = null;
        goto L8
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin
    public void onAttachToUIContainer(DrivePluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.onAttachToUIContainer(r2, r3);
        findMainPageRoot();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }

    public static final /* synthetic */ void access$trackLoadThumbStageStart(DriveImageThumbLoadingPlugin r0, w75.a r1, int r2) {
        r0.trackLoadThumbStageStart(r1, r2);
    }
}
