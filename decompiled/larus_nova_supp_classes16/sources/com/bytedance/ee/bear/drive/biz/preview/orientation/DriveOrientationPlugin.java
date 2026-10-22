package com.bytedance.ee.bear.drive.biz.preview.orientation;

import android.content.Context;
import android.content.res.Configuration;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.biz.preview.titlebar.DriveTitleBarVisibilityPlugin;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.drive.render.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru5.h;
import w55.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\u001c\u0010\u0014\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020\nH\u0002J\b\u0010!\u001a\u00020\nH\u0002J\b\u0010\"\u001a\u00020\nH\u0002J\b\u0010#\u001a\u00020\nH\u0002J\b\u0010$\u001a\u00020\u000eH\u0002J\u000e\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\nJ\b\u0010'\u001a\u00020\u000eH\u0002J\b\u0010(\u001a\u00020\u000eH\u0002J\u0010\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020+H\u0002J\b\u00102\u001a\u00020\u000eH\u0002J\b\u00103\u001a\u00020\nH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b.\u0010/¨\u00065"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/orientation/DriveOrientationPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "<init>", "()V", "orientationStateDetector", "Lcom/bytedance/ee/util/orientation/IOrientationStateDetector;", "orientationStateChangeHandler", "Lcom/bytedance/ee/bear/drive/biz/preview/orientation/DriveSdkOrientationStateChangeHandler;", SimpleItemModel.ITEM_STYLE_DISABLE, "", "loadListener", "Lcom/bytedance/ee/bear/drive/core/load/IFileLoader$LoadListener;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onAttachPreview", "startDetect", "stopDetect", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachPreview", "onBackPressed", "onConfigurationChanged", "newConfiguration", "Landroid/content/res/Configuration;", "isPhoneLandscape", "currentDeviceLandscape", "handleOrientation", "configuration", "enableUpdateTitleBar", "isDocX", "shouldDisableVideoLandscape", "isCurrentPreviewVideo", "forcePortraitForVideoLandscape", "forcePortrait", "force", "startDriveFileLoadingObserver", "stopDriveFileLoadingObserver", "onDriveFileLoaded", "driveFileModel", "Lcom/bytedance/ee/bear/drive/loader/model/DriveFileModel;", "forcePortraitObserver", "Landroidx/lifecycle/Observer;", "getForcePortraitObserver", "()Landroidx/lifecycle/Observer;", "forcePortraitObserver$delegate", "Lkotlin/Lazy;", "observeForcePortrait", "isPdfMarkCommentEnabled", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveOrientationPlugin extends AbsDrivePlugin implements sa5.d {
    public static final a Companion = null;
    public static final String TAG = "DriveOrientationPlugin";
    private boolean disable;
    private final Lazy forcePortraitObserver$delegate;
    private u75.b.a loadListener;
    private com.bytedance.ee.bear.drive.biz.preview.orientation.b orientationStateChangeHandler;
    private ru5.a orientationStateDetector;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.bytedance.ee.bear.drive.biz.preview.orientation.d {
        public final /* synthetic */ DriveOrientationPlugin a;

        @Override // com.bytedance.ee.bear.drive.biz.preview.orientation.d
        public final int a() {
            if (DriveOrientationPlugin.access$getActivity(this.a) != null) goto L7;
            return -1;
        L7:
            return DriveOrientationPlugin.access$getActivity(this.a).getRequestedOrientation();
        }

        @Override // com.bytedance.ee.bear.drive.biz.preview.orientation.d
        public final boolean isLandscape() {
            if (DriveOrientationPlugin.access$getActivity(this.a) == null) goto L8;
            int r0 = com.bytedance.ee.bear.drive.biz.preview.orientation.a.a;
            if (com.bytedance.ee.bear.drive.biz.preview.orientation.a.C0152a.a(DriveOrientationPlugin.access$getActivity(this.a)) == false) goto L10;
            return true;
        L10:
            return false;
        L8:
            return false;
        }

        public b(DriveOrientationPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.biz.preview.orientation.d
        public final void b(boolean r3) {
            if (DriveOrientationPlugin.access$getActivity(this.a) == null) goto L11;
            if (r3 == false) goto L6;
            return;
        L6:
            if (DriveOrientationPlugin.access$getActivity(this.a).getRequestedOrientation() != (-1)) goto L8;
            return;
        L8:
            if (DriveOrientationPlugin.access$getActivity(this.a).getRequestedOrientation() == 14) goto L14;
            DriveOrientationPlugin.access$getActivity(this.a).setRequestedOrientation(-1);
            return;
        L14:
            return;
        }
    }

    public static final class c implements ru5.a.a {
        public final /* synthetic */ DriveOrientationPlugin a;

        public final LifecycleOwner a() {
            return DriveOrientationPlugin.access$getLifecycleOwner(this.a);
        }

        public final Context provideContext() {
            return DriveOrientationPlugin.access$getContext(this.a);
        }

        public c(DriveOrientationPlugin r1) {
            this.a = r1;
        }

        public final <T extends ViewModel> T b(Class<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "clazz");
            return (T) DriveOrientationPlugin.access$viewModel(this.a, r2);
        }
    }

    public static final class d extends u75.b.C0306b {
        public final /* synthetic */ DriveOrientationPlugin a;

        public d(DriveOrientationPlugin r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r2, T r3) {
            Intrinsics.checkNotNullParameter(r2, "code");
            if (r2 == InfoCode.FileInfoSuccess) goto L5;
            return;
        L5:
            if ((r3 instanceof f85.a) == false) goto L9;
            tt5.a.h(DriveOrientationPlugin.TAG, "startDriveFileLoadingObserver - onInfo, load success.");
            DriveOrientationPlugin.access$stopDriveFileLoadingObserver(this.a);
            DriveOrientationPlugin.access$onDriveFileLoaded(this.a, (f85.a) r3);
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final Observer<Boolean> getForcePortraitObserver() {
        return (Observer) this.forcePortraitObserver$delegate.getValue();
    }

    private final void observeForcePortrait() {
        PreviewViewModel r0 = (PreviewViewModel) viewModel(PreviewViewModel.class);
        if (r0 != null) goto L6;
        tt5.a.d(TAG, "observeForcePortrait, previewVM is null.");
        return;
    L6:
        tt5.a.h(TAG, "observeForcePortrait");
        r0.liveInnerForcePortrait.removeObserver(getForcePortraitObserver());
        r0.liveInnerForcePortrait.observe(getLifecycleOwner(), getForcePortraitObserver());
    }

    private final void startDetect() {
        if (this.disable == false) goto L5;
    L16:
        tt5.a.h(TAG, "startDetect() disable=" + this.disable + ' ');
        return;
    L5:
        if (isDocX() == true) goto L16;
        if (shouldDisableVideoLandscape() == false) goto L11;
        tt5.a.h(TAG, "startDetect() skip, videoLandscapeEnabled=false");
        stopDetect();
        forcePortraitForVideoLandscape();
        return;
    L11:
        ru5.a r0 = this.orientationStateDetector;
        if (r0 == null) goto L14;
        r0.a();
    L14:
        h r1 = new h(new c(this));
        this.orientationStateDetector = r1;
        r1.b(this.orientationStateChangeHandler);
    }

    private final void startDriveFileLoadingObserver() {
        tt5.a.h(TAG, "startDriveFileLoadingObserver, loadListener: " + this.loadListener);
        u75.b.a r0 = this.loadListener;
        if (r0 == null) goto L5;
        getHost().c().g(r0);
    L5:
        d r1 = new d(this);
        this.loadListener = r1;
        getHost().c().c(r1);
    }

    private final void stopDetect() {
        if (this.disable == false) goto L5;
    L11:
        tt5.a.h(TAG, "stopDetect() disable=" + this.disable + ' ');
        return;
    L5:
        if (isDocX() == true) goto L11;
        ru5.a r0 = this.orientationStateDetector;
        if (r0 == null) goto L13;
        r0.a();
        return;
    }

    private final void stopDriveFileLoadingObserver() {
        tt5.a.h(TAG, "stopDriveFileLoadingObserver, loadListener: " + this.loadListener);
        u75.b.a r0 = this.loadListener;
        if (r0 == null) goto L6;
        this.loadListener = null;
        getHost().c().g(r0);
        return;
    }

    @Override // sa5.d
    public boolean onBackPressed() {
        com.bytedance.ee.bear.drive.biz.preview.orientation.b r0 = this.orientationStateChangeHandler;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        r0.onBackPressed();
        return false;
    L7:
        return false;
    }

    public DriveOrientationPlugin() {
        this.forcePortraitObserver$delegate = LazyKt.lazy(new DriveOrientationPlugin$forcePortraitObserver$2(this));
    }

    private final boolean enableUpdateTitleBar() {
        if (Intrinsics.areEqual(k75.a.i(getHost()).liveInnerIsPresentationMode().getValue(), Boolean.TRUE) == true) goto L5;
        return true;
    L5:
        if (getHost().c.isVCFollowMode() == true) goto L7;
        return true;
    L7:
        if (isDocX() == false) goto L13;
        return false;
    L13:
        return true;
    }

    private final void forcePortraitForVideoLandscape() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getRequestedOrientation() == 1) goto L9;
        r0.setRequestedOrientation(1);
        return;
    }

    private final boolean isCurrentPreviewVideo() {
        w75.a r0 = getHost().c.getFileModel();
        BaseOpenEntity r1 = getHost().c.getOpenEntity();
        String r2 = null;
        if (r0 == null) goto L6;
        String r3 = r0.f;
        if (r3 == null) goto L6;
    L15:
        if (r0 == null) goto L20;
        String r4 = r0.r;
        if (r4 == null) goto L20;
        r2 = r4;
    L23:
        return ((g85.b) o75.b.a().getMimeTypeManager()).o(r3, r2);
    L20:
        if (r1 == null) goto L23;
        r2 = r1.getMimeType();
    L6:
        if (r0 == null) goto L10;
        w75.b r5 = r0.c();
        if (r5 == null) goto L10;
        r3 = r5.k;
    L11:
        if (r3 != null) goto L15;
        if (r1 == null) goto L14;
        r3 = r1.getFileExt();
        goto L15
    L14:
        r3 = null;
    L10:
        r3 = null;
        goto L11
    }

    private final boolean isDocX() {
        DrivePluginHost r0 = getHost();
        if (r0 == null) goto L9;
        DriveViewModel r1 = r0.c;
        if (r1 == null) goto L9;
        BaseOpenEntity r2 = r1.getOpenEntity();
        if (r2 == null) goto L9;
        String r3 = r2.getMountPoint();
    L11:
        return Intrinsics.areEqual("docx_file", r3);
    L9:
        r3 = null;
        goto L11
    }

    private final boolean isPdfMarkCommentEnabled() {
        w75.a r0 = getHost().c.getFileModel();
        if (r0 == null) goto L8;
        w75.b r1 = r0.c();
        if (r1 == null) goto L8;
        String r2 = r1.k;
        if (r2 == null) goto L8;
    L9:
        boolean r3 = i75.h.k(r2);
        boolean r4 = n.d;
        if (r3 == false) goto L13;
        if (r4 == false) goto L13;
        boolean r5 = true;
    L14:
        tt5.a.h(TAG, "isPdfMarkCommentEnabled: " + r5 + ", isPdf: " + r3 + ", fg: " + r4);
        return r5;
    L13:
        r5 = false;
    L8:
        r2 = "";
        goto L9
    }

    private final boolean shouldDisableVideoLandscape() {
        k r0 = getDriveUIConfig();
        if (r0 == null) goto L7;
        k.h r1 = r0.getVideo();
        if (r1 == null) goto L7;
        boolean r2 = r1.a;
    L8:
        if (r2 == false) goto L11;
        return false;
    L11:
        boolean r3 = isCurrentPreviewVideo();
        tt5.a.h(TAG, "shouldDisableVideoLandscape, isVideo=" + r3);
        return r3;
    L7:
        r2 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        tt5.a.h(TAG, "onAttachPreview()");
        startDriveFileLoadingObserver();
        this.orientationStateChangeHandler = new com.bytedance.ee.bear.drive.biz.preview.orientation.b(getHost().c.getOpenEntity().getFileId(), new b(this));
        startDetect();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        tt5.a.h(TAG, "onDetachPreview()");
        stopDriveFileLoadingObserver();
        stopDetect();
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveOrientationPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ Context access$getContext(DriveOrientationPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ LifecycleOwner access$getLifecycleOwner(DriveOrientationPlugin r0) {
        return r0.getLifecycleOwner();
    }

    public static final /* synthetic */ void access$stopDriveFileLoadingObserver(DriveOrientationPlugin r0) {
        r0.stopDriveFileLoadingObserver();
    }

    private final void handleOrientation(Configuration r2) {
        if (r2.orientation != 2) goto L5;
        boolean r3 = true;
    L6:
        boolean r4 = isPhoneLandscape(r3);
        if (enableUpdateTitleBar() == false) goto L11;
        DriveTitleBarVisibilityPlugin r0 = (DriveTitleBarVisibilityPlugin) findPlugin(DriveTitleBarVisibilityPlugin.class);
        if (r0 == null) goto L11;
        r0.updateOrientation(r4);
    L11:
        if (r4 == false) goto L13;
        getUIContainer().hideStatusBar();
        return;
    L13:
        getUIContainer().a();
        return;
    L5:
        r3 = false;
        goto L6
    }

    private final boolean isPhoneLandscape(boolean r1) {
        if (r1 == true) goto L4;
    L6:
        return false;
    L4:
        if (ku5.c.k(getContext()) == true) goto L6;
        return true;
    }

    private final void onDriveFileLoaded(f85.a r5) {
        if (shouldDisableVideoLandscape() == false) goto L5;
        tt5.a.h(TAG, "onDriveFileLoaded, videoLandscapeEnabled=false");
        stopDetect();
        forcePortraitForVideoLandscape();
    L5:
        Boolean r6 = Boolean.valueOf(isPdfMarkCommentEnabled());
        tt5.a.h(TAG, "onDriveFileLoaded, isPdfMarkCommentEnabled: " + r6.booleanValue());
        if (r6.booleanValue() == true) goto L9;
        r6 = null;
    L9:
        if (r6 == null) goto L12;
        r6.booleanValue();
        observeForcePortrait();
        return;
    }

    public final void forcePortrait(boolean r3) {
        tt5.a.h(TAG, "forcePortrait() force = " + r3);
        FragmentActivity r0 = getActivity();
        if (r3 == false) goto L5;
        stopDetect();
        int r4 = 1;
    L6:
        r0.setRequestedOrientation(r4);
        return;
    L5:
        startDetect();
        r4 = -1;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
        if (r2.c.getOpenEntity().getPreviewType() != 3) goto L5;
        boolean r3 = true;
    L6:
        this.disable = r3;
        tt5.a.h(TAG, "onAttachToHost() disable=" + this.disable);
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r4) {
        Intrinsics.checkNotNullParameter(r4, "newConfiguration");
        super.onConfigurationChanged(r4);
        if (this.disable == false) goto L5;
        return;
    L5:
        if (getHost().c.isInBlockState() == false) goto L8;
        return;
    L8:
        if (shouldDisableVideoLandscape() == false) goto L14;
        tt5.a.h(TAG, "onConfigurationChanged() skip, videoLandscapeEnabled=false");
        forcePortraitForVideoLandscape();
        DriveTitleBarVisibilityPlugin r5 = (DriveTitleBarVisibilityPlugin) findPlugin(DriveTitleBarVisibilityPlugin.class);
        if (r5 == null) goto L12;
        r5.updateOrientation(false);
    L12:
        getUIContainer().a();
        return;
    L14:
        tt5.a.h(TAG, "onConfigurationChanged() newConfiguration.orientation=" + Integer.valueOf(r4.orientation));
        handleOrientation(r4);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$onDriveFileLoaded(DriveOrientationPlugin r0, f85.a r1) {
        r0.onDriveFileLoaded(r1);
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveOrientationPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }

    public void onAttachToUIContainer(DrivePluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        if (shouldDisableVideoLandscape() == false) goto L9;
        forcePortraitForVideoLandscape();
        if (r2 == null) goto L15;
        r2.a();
        return;
    L15:
        return;
    L9:
        if (getActivity() == null) goto L16;
        int r3 = com.bytedance.ee.bear.drive.biz.preview.orientation.a.a;
        if (isPhoneLandscape(com.bytedance.ee.bear.drive.biz.preview.orientation.a.C0152a.a(getActivity())) == false) goto L17;
        if (r2 == null) goto L18;
        r2.hideStatusBar();
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }
}
