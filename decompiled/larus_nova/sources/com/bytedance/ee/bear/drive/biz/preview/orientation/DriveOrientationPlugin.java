package com.bytedance.ee.bear.drive.biz.preview.orientation;

import android.content.Context;
import android.content.res.Configuration;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
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

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\u001c\u0010\u0014\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020\nH\u0002J\b\u0010!\u001a\u00020\nH\u0002J\b\u0010\"\u001a\u00020\nH\u0002J\b\u0010#\u001a\u00020\nH\u0002J\b\u0010$\u001a\u00020\u000eH\u0002J\u000e\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\nJ\b\u0010'\u001a\u00020\u000eH\u0002J\b\u0010(\u001a\u00020\u000eH\u0002J\u0010\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020+H\u0002J\b\u00102\u001a\u00020\u000eH\u0002J\b\u00103\u001a\u00020\nH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b.\u0010/¨\u00065"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/orientation/DriveOrientationPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "<init>", "()V", "orientationStateDetector", "Lcom/bytedance/ee/util/orientation/IOrientationStateDetector;", "orientationStateChangeHandler", "Lcom/bytedance/ee/bear/drive/biz/preview/orientation/DriveSdkOrientationStateChangeHandler;", "disable", "", "loadListener", "Lcom/bytedance/ee/bear/drive/core/load/IFileLoader$LoadListener;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onAttachPreview", "startDetect", "stopDetect", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachPreview", "onBackPressed", "onConfigurationChanged", "newConfiguration", "Landroid/content/res/Configuration;", "isPhoneLandscape", "currentDeviceLandscape", "handleOrientation", "configuration", "enableUpdateTitleBar", "isDocX", "shouldDisableVideoLandscape", "isCurrentPreviewVideo", "forcePortraitForVideoLandscape", "forcePortrait", "force", "startDriveFileLoadingObserver", "stopDriveFileLoadingObserver", "onDriveFileLoaded", "driveFileModel", "Lcom/bytedance/ee/bear/drive/loader/model/DriveFileModel;", "forcePortraitObserver", "Landroidx/lifecycle/Observer;", "getForcePortraitObserver", "()Landroidx/lifecycle/Observer;", "forcePortraitObserver$delegate", "Lkotlin/Lazy;", "observeForcePortrait", "isPdfMarkCommentEnabled", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveOrientationPlugin f223666a;

        @Override // com.bytedance.ee.bear.drive.biz.preview.orientation.d
        public final int a() {
            if (DriveOrientationPlugin.access$getActivity(this.f223666a) != null) goto L7;
            return -1;
        L7:
            return DriveOrientationPlugin.access$getActivity(this.f223666a).getRequestedOrientation();
        }

        @Override // com.bytedance.ee.bear.drive.biz.preview.orientation.d
        public final boolean isLandscape() {
            if (DriveOrientationPlugin.access$getActivity(this.f223666a) == null) goto L8;
            int r100 = com.bytedance.ee.bear.drive.biz.preview.orientation.a.f223672a;
            if (com.bytedance.ee.bear.drive.biz.preview.orientation.a.C3208a.a(DriveOrientationPlugin.access$getActivity(this.f223666a)) == false) goto L10;
            return true;
        L10:
            return false;
        L8:
            return false;
        }

        public b(DriveOrientationPlugin r100) {
            this.f223666a = r100;
        }

        @Override // com.bytedance.ee.bear.drive.biz.preview.orientation.d
        public final void b(boolean r100) {
            if (DriveOrientationPlugin.access$getActivity(this.f223666a) == null) goto L11;
            if (r100 == false) goto L6;
            return;
        L6:
            if (DriveOrientationPlugin.access$getActivity(this.f223666a).getRequestedOrientation() != (-1)) goto L8;
            return;
        L8:
            if (DriveOrientationPlugin.access$getActivity(this.f223666a).getRequestedOrientation() == 14) goto L14;
            DriveOrientationPlugin.access$getActivity(this.f223666a).setRequestedOrientation(-1);
            return;
        L14:
            return;
        }
    }

    public static final class c implements ru5.a.InterfaceC7535a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveOrientationPlugin f223667a;

        @Override // ru5.a.InterfaceC7535a
        public final LifecycleOwner a() {
            return DriveOrientationPlugin.access$getLifecycleOwner(this.f223667a);
        }

        @Override // ru5.a.InterfaceC7535a
        public final Context provideContext() {
            return DriveOrientationPlugin.access$getContext(this.f223667a);
        }

        public c(DriveOrientationPlugin r100) {
            this.f223667a = r100;
        }

        @Override // ru5.a.InterfaceC7535a
        public final <T extends ViewModel> T b(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "clazz");
            return (T) DriveOrientationPlugin.access$viewModel(this.f223667a, r100);
        }
    }

    public static final class d extends u75.b.C7844b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveOrientationPlugin f223668a;

        public d(DriveOrientationPlugin r100) {
            this.f223668a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // u75.b.C7844b, u75.b.a
        public final <T> void a(InfoCode r100, T r101) {
            Intrinsics.checkNotNullParameter(r100, "code");
            if (r100 == InfoCode.FileInfoSuccess) goto L5;
            return;
        L5:
            if ((r101 instanceof f85.a) == false) goto L9;
            tt5.a.h(DriveOrientationPlugin.TAG, "startDriveFileLoadingObserver - onInfo, load success.");
            DriveOrientationPlugin.access$stopDriveFileLoadingObserver(this.f223668a);
            DriveOrientationPlugin.access$onDriveFileLoaded(this.f223668a, (f85.a) r101);
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private final Observer<Boolean> getForcePortraitObserver() {
        return (Observer) this.forcePortraitObserver$delegate.getValue();
    }

    private final void observeForcePortrait() {
        PreviewViewModel r100 = (PreviewViewModel) viewModel(PreviewViewModel.class);
        if (r100 != null) goto L6;
        tt5.a.d(TAG, "observeForcePortrait, previewVM is null.");
        return;
    L6:
        tt5.a.h(TAG, "observeForcePortrait");
        r100.liveInnerForcePortrait.removeObserver(getForcePortraitObserver());
        r100.liveInnerForcePortrait.observe(getLifecycleOwner(), getForcePortraitObserver());
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
        ru5.a r100 = this.orientationStateDetector;
        if (r100 == null) goto L14;
        r100.a();
    L14:
        h r101 = new h(new c(this));
        this.orientationStateDetector = r101;
        r101.b(this.orientationStateChangeHandler);
    }

    private final void startDriveFileLoadingObserver() {
        tt5.a.h(TAG, "startDriveFileLoadingObserver, loadListener: " + this.loadListener);
        u75.b.a r100 = this.loadListener;
        if (r100 == null) goto L5;
        getHost().c().g(r100);
    L5:
        d r101 = new d(this);
        this.loadListener = r101;
        getHost().c().c(r101);
    }

    private final void stopDetect() {
        if (this.disable == false) goto L5;
    L11:
        tt5.a.h(TAG, "stopDetect() disable=" + this.disable + ' ');
        return;
    L5:
        if (isDocX() == true) goto L11;
        ru5.a r100 = this.orientationStateDetector;
        if (r100 == null) goto L13;
        r100.a();
        return;
    }

    private final void stopDriveFileLoadingObserver() {
        tt5.a.h(TAG, "stopDriveFileLoadingObserver, loadListener: " + this.loadListener);
        u75.b.a r100 = this.loadListener;
        if (r100 == null) goto L6;
        this.loadListener = null;
        getHost().c().g(r100);
        return;
    }

    @Override // sa5.d
    public boolean onBackPressed() {
        com.bytedance.ee.bear.drive.biz.preview.orientation.b r100 = this.orientationStateChangeHandler;
        if (r100 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        r100.onBackPressed();
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
        if (getHost().f224125c.isVCFollowMode() == true) goto L7;
        return true;
    L7:
        if (isDocX() == false) goto L13;
        return false;
    L13:
        return true;
    }

    private final void forcePortraitForVideoLandscape() {
        FragmentActivity r100 = getActivity();
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.getRequestedOrientation() == 1) goto L9;
        r100.setRequestedOrientation(1);
        return;
    }

    private final boolean isCurrentPreviewVideo() {
        w75.a r100 = getHost().f224125c.getFileModel();
        BaseOpenEntity r101 = getHost().f224125c.getOpenEntity();
        String r102 = null;
        if (r100 == null) goto L6;
        String r103 = r100.f558537f;
        if (r103 == null) goto L6;
    L15:
        if (r100 == null) goto L20;
        String r104 = r100.f558549r;
        if (r104 == null) goto L20;
        r102 = r104;
    L23:
        return ((g85.b) o75.b.a().getMimeTypeManager()).o(r103, r102);
    L20:
        if (r101 == null) goto L23;
        r102 = r101.getMimeType();
    L6:
        if (r100 == null) goto L10;
        w75.b r105 = r100.c();
        if (r105 == null) goto L10;
        r103 = r105.f558567k;
    L11:
        if (r103 != null) goto L15;
        if (r101 == null) goto L14;
        r103 = r101.getFileExt();
        goto L15
    L14:
        r103 = null;
    L10:
        r103 = null;
        goto L11
    }

    private final boolean isDocX() {
        DrivePluginHost r100 = getHost();
        if (r100 == null) goto L9;
        DriveViewModel r101 = r100.f224125c;
        if (r101 == null) goto L9;
        BaseOpenEntity r102 = r101.getOpenEntity();
        if (r102 == null) goto L9;
        String r103 = r102.getMountPoint();
    L11:
        return Intrinsics.areEqual("docx_file", r103);
    L9:
        r103 = null;
        goto L11
    }

    private final boolean isPdfMarkCommentEnabled() {
        w75.a r100 = getHost().f224125c.getFileModel();
        if (r100 == null) goto L8;
        w75.b r101 = r100.c();
        if (r101 == null) goto L8;
        String r102 = r101.f558567k;
        if (r102 == null) goto L8;
    L9:
        boolean r103 = i75.h.k(r102);
        boolean r104 = n.f558339d;
        if (r103 == false) goto L13;
        if (r104 == false) goto L13;
        boolean r105 = true;
    L14:
        tt5.a.h(TAG, "isPdfMarkCommentEnabled: " + r105 + ", isPdf: " + r103 + ", fg: " + r104);
        return r105;
    L13:
        r105 = false;
    L8:
        r102 = "";
        goto L9
    }

    private final boolean shouldDisableVideoLandscape() {
        k r100 = getDriveUIConfig();
        if (r100 == null) goto L7;
        k.h r101 = r100.getVideo();
        if (r101 == null) goto L7;
        boolean r102 = r101.f242752a;
    L8:
        if (r102 == false) goto L11;
        return false;
    L11:
        boolean r103 = isCurrentPreviewVideo();
        tt5.a.h(TAG, "shouldDisableVideoLandscape, isVideo=" + r103);
        return r103;
    L7:
        r102 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        tt5.a.h(TAG, "onAttachPreview()");
        startDriveFileLoadingObserver();
        this.orientationStateChangeHandler = new com.bytedance.ee.bear.drive.biz.preview.orientation.b(getHost().f224125c.getOpenEntity().getFileId(), new b(this));
        startDetect();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        tt5.a.h(TAG, "onDetachPreview()");
        stopDriveFileLoadingObserver();
        stopDetect();
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveOrientationPlugin r100) {
        return r100.getActivity();
    }

    public static final /* synthetic */ Context access$getContext(DriveOrientationPlugin r100) {
        return r100.getContext();
    }

    public static final /* synthetic */ LifecycleOwner access$getLifecycleOwner(DriveOrientationPlugin r100) {
        return r100.getLifecycleOwner();
    }

    public static final /* synthetic */ void access$stopDriveFileLoadingObserver(DriveOrientationPlugin r100) {
        r100.stopDriveFileLoadingObserver();
    }

    private final void handleOrientation(Configuration r100) {
        if (r100.orientation != 2) goto L5;
        boolean r101 = true;
    L6:
        boolean r102 = isPhoneLandscape(r101);
        if (enableUpdateTitleBar() == false) goto L11;
        DriveTitleBarVisibilityPlugin r103 = (DriveTitleBarVisibilityPlugin) findPlugin(DriveTitleBarVisibilityPlugin.class);
        if (r103 == null) goto L11;
        r103.updateOrientation(r102);
    L11:
        if (r102 == false) goto L13;
        getUIContainer().hideStatusBar();
        return;
    L13:
        getUIContainer().a();
        return;
    L5:
        r101 = false;
        goto L6
    }

    private final boolean isPhoneLandscape(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        return false;
    L4:
        if (ku5.c.k(getContext()) == true) goto L6;
        return true;
    }

    private final void onDriveFileLoaded(f85.a r100) {
        if (shouldDisableVideoLandscape() == false) goto L5;
        tt5.a.h(TAG, "onDriveFileLoaded, videoLandscapeEnabled=false");
        stopDetect();
        forcePortraitForVideoLandscape();
    L5:
        Boolean r101 = Boolean.valueOf(isPdfMarkCommentEnabled());
        tt5.a.h(TAG, "onDriveFileLoaded, isPdfMarkCommentEnabled: " + r101.booleanValue());
        if (r101.booleanValue() == true) goto L9;
        r101 = null;
    L9:
        if (r101 == null) goto L12;
        r101.booleanValue();
        observeForcePortrait();
        return;
    }

    public final void forcePortrait(boolean r100) {
        tt5.a.h(TAG, "forcePortrait() force = " + r100);
        FragmentActivity r101 = getActivity();
        if (r100 == false) goto L5;
        stopDetect();
        int r102 = 1;
    L6:
        r101.setRequestedOrientation(r102);
        return;
    L5:
        startDetect();
        r102 = -1;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        super.onAttachToHost(r100);
        if (r100.f224125c.getOpenEntity().getPreviewType() != 3) goto L5;
        boolean r101 = true;
    L6:
        this.disable = r101;
        tt5.a.h(TAG, "onAttachToHost() disable=" + this.disable);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfiguration");
        super.onConfigurationChanged(r100);
        if (this.disable == false) goto L5;
        return;
    L5:
        if (getHost().f224125c.isInBlockState() == false) goto L8;
        return;
    L8:
        if (shouldDisableVideoLandscape() == false) goto L14;
        tt5.a.h(TAG, "onConfigurationChanged() skip, videoLandscapeEnabled=false");
        forcePortraitForVideoLandscape();
        DriveTitleBarVisibilityPlugin r101 = (DriveTitleBarVisibilityPlugin) findPlugin(DriveTitleBarVisibilityPlugin.class);
        if (r101 == null) goto L12;
        r101.updateOrientation(false);
    L12:
        getUIContainer().a();
        return;
    L14:
        tt5.a.h(TAG, "onConfigurationChanged() newConfiguration.orientation=" + Integer.valueOf(r100.orientation));
        handleOrientation(r100);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((DrivePluginHost) r100);
    }

    public static final /* synthetic */ void access$onDriveFileLoaded(DriveOrientationPlugin r100, f85.a r101) {
        r100.onDriveFileLoaded(r101);
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveOrientationPlugin r100, Class r101) {
        return r100.viewModel(r101);
    }

    public void onAttachToUIContainer(DrivePluginHost r100, t r101) {
        super.onAttachToUIContainer(r100, r101);
        if (shouldDisableVideoLandscape() == false) goto L9;
        forcePortraitForVideoLandscape();
        if (r101 == null) goto L15;
        r101.a();
        return;
    L15:
        return;
    L9:
        if (getActivity() == null) goto L16;
        int r102 = com.bytedance.ee.bear.drive.biz.preview.orientation.a.f223672a;
        if (isPhoneLandscape(com.bytedance.ee.bear.drive.biz.preview.orientation.a.C3208a.a(getActivity())) == false) goto L17;
        if (r101 == null) goto L18;
        r101.hideStatusBar();
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, t r101) {
        onAttachToUIContainer((DrivePluginHost) r100, r101);
    }
}
