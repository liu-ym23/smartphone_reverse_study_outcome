package com.bytedance.ee.bear.drive.biz.feed;

import android.R;
import android.content.res.Configuration;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.drive.biz.comment.l1;
import com.bytedance.ee.bear.drive.biz.comment.m1;
import com.bytedance.ee.bear.drive.biz.comment.q1;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.biz.preview.DrivePreviewContentPlugin;
import com.bytedance.ee.bear.drive.biz.preview.screen.DriveFullScreenVM;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import i75.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t75.i;
import w55.l;
import w55.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u000bH\u0002J\b\u0010\"\u001a\u00020\u000bH\u0002J\b\u0010#\u001a\u00020\u000bH\u0002J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010%\u001a\u00020\u0007H\u0002J\b\u0010&\u001a\u00020\u0007H\u0002J\b\u0010'\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/feed/DriveFeedPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "mDriveFeedManager", "Lcom/bytedance/ee/bear/drive/biz/feed/DriveFeedManager;", "previewAttached", "", "loadListener", "Lcom/bytedance/ee/bear/drive/core/load/IFileLoader$LoadListener;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "onAttachPreview", "onDetachPreview", "onConfigurationChanged", "newConfiguration", "Landroid/content/res/Configuration;", "createFeedManagerByPermission", "it", "Lcom/bytedance/ee/bear/drive/biz/permission/model/DrivePermissionInfo;", "releaseFeedManager", "source", "", "identityOf", "instance", "", "instanceClearBadgeFeedManager", "Lcom/bytedance/ee/bear/drive/biz/feed/ClearBadgeFeedManager;", "instanceDefaultFeedManager", "Lcom/bytedance/ee/bear/drive/biz/feed/DefaultDriveFeedManager;", "startLoadListener", "stopLoadListener", "onLoadFinished", "updateFeedUsingNewUI", "resolveFeedUsingNewUI", "isPdfFloatCommentEnable", "isPdfMarkCommentEnabled", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveFeedPlugin extends AbsDrivePlugin {
    public static final a Companion = null;
    private static final String FG_PDF_COMMENT_HALF_STYLE_NO_TTOFFICE = "ccm.mobile.drive_pdf_comment_half_style_no_ttoffice";
    private static final String TAG = "DriveFeedPlugin";
    private u75.b.a loadListener;
    private com.bytedance.ee.bear.drive.biz.feed.c mDriveFeedManager;
    private boolean previewAttached;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.bytedance.ee.bear.drive.biz.feed.c.a {
        public final /* synthetic */ DriveFeedVM a;

        public b(DriveFeedVM r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.biz.feed.c.a
        public final void a(int r2) {
            this.a.getFeedCount().postValue(Integer.valueOf(r2));
        }
    }

    public static final class c implements m1 {
        public final /* synthetic */ DriveFeedPlugin a;

        @Override // com.bytedance.ee.bear.drive.biz.comment.m1
        public final DrivePluginHost S() {
            return this.a.getHost();
        }

        @Override // com.bytedance.ee.bear.drive.biz.comment.m1
        public FragmentActivity getActivity() {
            return DriveFeedPlugin.access$getActivity(this.a);
        }

        public c(DriveFeedPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.biz.comment.m1
        public final <T extends ViewModel> T a(Class<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "clazz");
            return (T) DriveFeedPlugin.access$viewModel(this.a, r2);
        }
    }

    public static final class d implements m1 {
        public final /* synthetic */ DriveFeedPlugin a;

        @Override // com.bytedance.ee.bear.drive.biz.comment.m1
        public final DrivePluginHost S() {
            return this.a.getHost();
        }

        @Override // com.bytedance.ee.bear.drive.biz.comment.m1
        public FragmentActivity getActivity() {
            return DriveFeedPlugin.access$getActivity(this.a);
        }

        public d(DriveFeedPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.biz.comment.m1
        public final <T extends ViewModel> T a(Class<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "clazz");
            return (T) DriveFeedPlugin.access$viewModel(this.a, r2);
        }
    }

    public static final class e implements q1 {
        public final /* synthetic */ DriveFeedPlugin a;

        public e(DriveFeedPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.biz.comment.q1
        public final AbsPreviewView get() {
            DrivePreviewContentPlugin r0 = (DrivePreviewContentPlugin) DriveFeedPlugin.access$findPlugin(this.a, DrivePreviewContentPlugin.class);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.currentPreviewView();
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ DriveFeedPlugin a;

        public f(DriveFeedPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            u55.b r3 = (u55.b) r2;
            DriveFeedPlugin.access$createFeedManagerByPermission(this.a, r3);
            if (r3 == null) goto L7;
            boolean r0 = true;
            if (r3.e() != true) goto L7;
        L8:
            if (r0 == true) goto L13;
            com.bytedance.ee.bear.drive.biz.feed.c r4 = DriveFeedPlugin.access$getMDriveFeedManager$p(this.a);
            if (r4 == null) goto L14;
            r4.f();
            return;
        L14:
            return;
        L13:
            return;
        L7:
            r0 = false;
            goto L8
        }
    }

    public static final class g implements u75.b.a {
        public final /* synthetic */ DriveFeedPlugin a;

        @Override // u75.b.a
        public final void b(z r2) {
            Intrinsics.checkNotNullParameter(r2, "previewFileModel");
        }

        @Override // u75.b.a
        public final void c(ErrCode r2) {
            Intrinsics.checkNotNullParameter(r2, "code");
        }

        @Override // u75.b.a
        public final void onProgress(int r1) {
        }

        public g(DriveFeedPlugin r1) {
            this.a = r1;
        }

        @Override // u75.b.a
        public final <I> void a(InfoCode r2, I r3) {
            Intrinsics.checkNotNullParameter(r2, "code");
            if (r2 == InfoCode.FileInfoSuccess) goto L5;
            return;
        L5:
            if ((r3 instanceof f85.a) == false) goto L9;
            this.a.getHost().c().g(this);
            DriveFeedPlugin.access$stopLoadListener(this.a);
            DriveFeedPlugin.access$onLoadFinished(this.a);
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        this.previewAttached = false;
        super.onDetachPreview();
        releaseFeedManager("onDetachPreview");
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void onLoadFinished() {
        updateFeedUsingNewUI("file_info_success");
    }

    private final void stopLoadListener() {
        u75.b.a r0 = this.loadListener;
        if (r0 == null) goto L6;
        getHost().c().g(r0);
        this.loadListener = null;
        return;
    }

    public final g55.c instanceClearBadgeFeedManager() {
        return new g55.c(new c(this), (FrameLayout) getActivity().findViewById(R.id.content));
    }

    private final boolean isPdfFloatCommentEnable() {
        w75.a r0 = getHost().c.getFileModel();
        if (r0 == null) goto L8;
        w75.b r1 = r0.c();
        if (r1 == null) goto L8;
        String r2 = r1.k;
        if (r2 == null) goto L8;
    L9:
        boolean r3 = h.k(r2);
        q75.a r4 = o75.b.a().getDriveConfig();
        boolean r5 = true;
        if (n.g().f() == false) goto L16;
        x55.a r6 = l.a;
        if (n.j(r4) == false) goto L16;
        if (n.d == false) goto L16;
        boolean r7 = true;
    L17:
        if (r3 == false) goto L20;
        if (r7 == false) goto L20;
    L21:
        tt5.a.h(TAG, "isPdfFloatCommentEnable: " + r5 + ", isPdf: " + r3 + ", isPdfQuoteCommentEnable: " + r7);
        return r5;
    L20:
        r5 = false;
    L16:
        r7 = false;
    L8:
        r2 = "";
        goto L9
    }

    private final boolean isPdfMarkCommentEnabled() {
        w75.a r0 = getHost().c.getFileModel();
        if (r0 == null) goto L8;
        w75.b r1 = r0.c();
        if (r1 == null) goto L8;
        String r2 = r1.k;
        if (r2 == null) goto L8;
    L9:
        boolean r3 = h.k(r2);
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

    private final boolean resolveFeedUsingNewUI() {
        boolean r0 = idb.f.a().isCurrentEnable(FG_PDF_COMMENT_HALF_STYLE_NO_TTOFFICE);
        boolean r1 = isPdfMarkCommentEnabled();
        if (r0 == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        int r3 = l1.a;
        if (r0 == false) goto L11;
        boolean r4 = r2;
    L12:
        tt5.a.h(TAG, "resolveFeedUsingNewUI: " + r4 + ", isHalfStyleNoTTOfficeEnabled: " + r0 + ", isPdfMarkCommentEnabled: " + r1 + ", isPdfFloatCommentEnable: " + r2);
        return r4;
    L11:
        r4 = r1;
        goto L12
    L5:
        if (isPdfFloatCommentEnable() == false) goto L7;
        r2 = true;
        goto L8
    }

    private final void startLoadListener() {
        stopLoadListener();
        g r0 = new g(this);
        getHost().c().c(r0);
        this.loadListener = r0;
    }

    public final com.bytedance.ee.bear.drive.biz.feed.b instanceDefaultFeedManager() {
        View r0 = findViewById(2131370319);
        boolean r1 = resolveFeedUsingNewUI();
        tt5.a.h(TAG, "create default feed manager, usePdfFloatingComment=" + r1);
        g55.n r2 = new g55.n(getHost().c, (DriveFullScreenVM) viewModel(DriveFullScreenVM.class), new e(this), r0);
        r2.h = r1;
        return new com.bytedance.ee.bear.drive.biz.feed.b(new d(this), (FrameLayout) getActivity().findViewById(R.id.content), r2, (i) getHost().getHostAbilityOrNull(i.class));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        this.previewAttached = true;
        createFeedManagerByPermission((u55.b) ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().getValue());
    }

    public DriveFeedPlugin() {
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveFeedPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ com.bytedance.ee.bear.drive.biz.feed.c access$getMDriveFeedManager$p(DriveFeedPlugin r0) {
        return r0.mDriveFeedManager;
    }

    public static final /* synthetic */ void access$onLoadFinished(DriveFeedPlugin r0) {
        r0.onLoadFinished();
    }

    public static final /* synthetic */ void access$stopLoadListener(DriveFeedPlugin r0) {
        r0.stopLoadListener();
    }

    private final void createFeedManagerByPermission(u55.b r7) {
        StringBuilder r0 = new StringBuilder("createFeedManagerByPermission start, plugin=");
        r0.append(identityOf(this));
        r0.append(", previewAttached=");
        r0.append(this.previewAttached);
        r0.append(", canRead=");
        Boolean r2 = null;
        if (r7 == null) goto L5;
        Boolean r3 = Boolean.valueOf(r7.e());
    L6:
        r0.append(r3);
        r0.append(", localManager=");
        r0.append(identityOf(this.mDriveFeedManager));
        tt5.a.h(TAG, r0.toString());
        if (this.previewAttached == true) goto L13;
        StringBuilder r1 = new StringBuilder("createFeedManagerByPermission skipped: preview detached, plugin=");
        r1.append(identityOf(this));
        r1.append(", canRead=");
        if (r7 == null) goto L11;
        r2 = Boolean.valueOf(r7.e());
    L11:
        r1.append(r2);
        tt5.a.h(TAG, r1.toString());
        return;
    L13:
        if (r7 != null) goto L16;
        tt5.a.k(TAG, "createFeedManagerByPermission skipped: permission is null, plugin=" + identityOf(this));
        return;
    L16:
        DriveFeedVM r4 = (DriveFeedVM) viewModel(DriveFeedVM.class);
        if (r7.e() == false) goto L32;
        com.bytedance.ee.bear.drive.biz.feed.c r8 = this.mDriveFeedManager;
        if (r8 != null) goto L22;
        this.mDriveFeedManager = instanceDefaultFeedManager();
    L24:
        r4.setDriveFeedManager(this.mDriveFeedManager);
        tt5.a.h(TAG, "attach feed manager, plugin=" + identityOf(this) + ", manager=" + identityOf(this.mDriveFeedManager));
        com.bytedance.ee.bear.drive.biz.feed.c r9 = this.mDriveFeedManager;
        if (r9 == null) goto L27;
        r9.attach();
    L27:
        com.bytedance.ee.bear.drive.biz.feed.c r10 = this.mDriveFeedManager;
        if (r10 == null) goto L43;
        r10.d(new b(r4));
    L43:
        tt5.a.h(TAG, "createFeedManagerByPermission finish, plugin=" + identityOf(this) + ", localManager=" + identityOf(this.mDriveFeedManager) + ", sharedManager=" + identityOf(r4.getDriveFeedManager()));
        return;
    L22:
        if ((r8 instanceof g55.c) == false) goto L30;
        tt5.a.h(TAG, "replace clear-badge manager, plugin=" + identityOf(this) + ", manager=" + identityOf(this.mDriveFeedManager));
        releaseFeedManager("permission readable");
        this.mDriveFeedManager = instanceDefaultFeedManager();
        goto L24
    L30:
        tt5.a.h(TAG, "createFeedManagerByPermission reuse current manager, plugin=" + identityOf(this) + ", localManager=" + identityOf(this.mDriveFeedManager) + ", sharedManager=" + identityOf(r4.getDriveFeedManager()));
        return;
    L32:
        BaseOpenEntity r11 = getHost().c.getOpenEntity();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity");
        if (iu5.b.a(((SpaceFileOpenEntity) r11).getUrl()) == false) goto L43;
        com.bytedance.ee.bear.drive.biz.feed.c r12 = this.mDriveFeedManager;
        if (r12 != null) goto L38;
        this.mDriveFeedManager = instanceClearBadgeFeedManager();
    L40:
        com.bytedance.ee.bear.drive.biz.feed.c r13 = this.mDriveFeedManager;
        if (r13 == null) goto L43;
        r13.attach();
        goto L43
    L38:
        if ((r12 instanceof com.bytedance.ee.bear.drive.biz.feed.b) == false) goto L40;
        releaseFeedManager("permission unreadable");
        this.mDriveFeedManager = instanceClearBadgeFeedManager();
        goto L40
    L5:
        r3 = null;
        goto L6
    }

    private final String identityOf(Object r3) {
        if (r3 == null) goto L5;
        String r4 = r3.getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(r3));
        if (r4 == null) goto L5;
        return r4;
    L5:
        return "null";
    }

    private final void releaseFeedManager(String r10) {
        com.bytedance.ee.bear.drive.biz.feed.c r0 = this.mDriveFeedManager;
        if (r0 != null) goto L6;
        tt5.a.h(TAG, "releaseFeedManager skipped: manager is null, source=" + r10 + ", plugin=" + identityOf(this));
        return;
    L6:
        DriveFeedVM r3 = (DriveFeedVM) viewModel(DriveFeedVM.class);
        Object r4 = r3.getDriveFeedManager();
        if (r4 != r0) goto L9;
        boolean r5 = true;
    L10:
        tt5.a.h(TAG, "releaseFeedManager start, source=" + r10 + ", plugin=" + identityOf(this) + ", manager=" + identityOf(r0) + ", sharedManager=" + identityOf(r4) + ", clearSharedManager=" + r5);
        this.mDriveFeedManager = null;
        if (r5 == false) goto L13;
        r3.setDriveFeedManager(null);
    L13:
        r0.detach();
        tt5.a.h(TAG, "releaseFeedManager finish, source=" + r10 + ", plugin=" + identityOf(this) + ", manager=" + identityOf(r0) + ", localManager=" + identityOf(this.mDriveFeedManager) + ", sharedManager=" + identityOf(r3.getDriveFeedManager()));
        return;
    L9:
        r5 = false;
        goto L10
    }

    private final void updateFeedUsingNewUI(String r6) {
        boolean r0 = resolveFeedUsingNewUI();
        com.bytedance.ee.bear.drive.biz.feed.c r1 = this.mDriveFeedManager;
        boolean r2 = r1 instanceof com.bytedance.ee.bear.drive.biz.feed.b;
        StringBuilder r3 = new StringBuilder("update feed UI, source=");
        r3.append(r6);
        r3.append(", managerType=");
        com.bytedance.ee.bear.drive.biz.feed.b r7 = null;
        if (r1 == null) goto L5;
        String r4 = r1.getClass().getSimpleName();
    L6:
        r3.append(r4);
        r3.append(", isDefaultFeedManager=");
        r3.append(r2);
        r3.append(", usePdfFloatingComment=");
        r3.append(r0);
        tt5.a.h(TAG, r3.toString());
        if (r2 == false) goto L9;
        r7 = (com.bytedance.ee.bear.drive.biz.feed.b) r1;
    L9:
        if (r7 == null) goto L12;
        r7.n.h = r0;
        return;
    L12:
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToHost(r3);
        ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().observe(getLifecycleOwner(), new f(this));
        startLoadListener();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        com.bytedance.ee.bear.drive.biz.feed.c r0 = this.mDriveFeedManager;
        if (r0 == null) goto L6;
        r0.e(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        this.previewAttached = false;
        stopLoadListener();
        releaseFeedManager("onDetachFromHost");
        super.onDetachFromHost(r2);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$createFeedManagerByPermission(DriveFeedPlugin r0, u55.b r1) {
        r0.createFeedManagerByPermission(r1);
    }

    public static final /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$findPlugin(DriveFeedPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveFeedPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }
}
