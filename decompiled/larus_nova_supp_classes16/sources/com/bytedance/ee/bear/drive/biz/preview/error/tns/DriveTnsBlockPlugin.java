package com.bytedance.ee.bear.drive.biz.preview.error.tns;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.fragment.DriveMainFragment;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.middleground.permission.export.ui.model.DocReportPubParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/tns/DriveTnsBlockPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "handlePageJump", "code", "Lcom/bytedance/ee/bear/drive/loader/model/ErrCode;", "navigateToTnsBlockPage", "replaceId", "", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveTnsBlockPlugin extends AbsDrivePreviewPlugin {
    public static final a Companion = null;
    public static final String TAG = "DriveTnsBlockPlugin";

    public static final class a {
        public a() {
        }
    }

    public static final class b extends u75.b.C0306b {
        public final /* synthetic */ DriveTnsBlockPlugin a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ErrCode.values().length];
                r0[ErrCode.TNS_BLOCK_VIEW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                a = r0;
            }
        }

        public b(DriveTnsBlockPlugin r1) {
            this.a = r1;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void c(ErrCode r3) {
            Intrinsics.checkNotNullParameter(r3, "code");
            if (a.a[r3.ordinal()] != 1) goto L6;
            tt5.a.h(DriveTnsBlockPlugin.TAG, "TNS_BLOCK_VIEW");
            DriveTnsBlockPlugin.access$handlePageJump(this.a, r3);
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveTnsBlockPlugin() {
    }

    private final void handlePageJump(ErrCode r4) {
        Fragment r0 = getLifecycleOwner();
        if (r0 == null) goto L5;
        FragmentManager r1 = r0.getParentFragmentManager();
    L7:
        if (isUIContainerDetached() == true) goto L16;
        if (r1 == null) goto L16;
        if (getHost().c.isVCFollowMode() == false) goto L13;
        int r2 = 2131370283;
    L14:
        removePreviewView();
        navigateToTnsBlockPage(r2, r4);
        o75.b.a().H7().a();
        int r5 = com.bytedance.ee.bear.drive.biz.cache.a.a;
        com.bytedance.ee.bear.drive.biz.cache.a.C0118a.b(getHost().c, null, getHost().b());
        return;
    L13:
        r2 = -1;
    L16:
        tt5.a.d(TAG, " isUIContainerDetached=" + isUIContainerDetached());
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        r2.c().c(new b(this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$handlePageJump(DriveTnsBlockPlugin r0, ErrCode r1) {
        r0.handlePageJump(r1);
    }

    private final void navigateToTnsBlockPage(int r18, ErrCode r19) {
        if (r19.getCause() != null) goto L6;
        tt5.a.d(TAG, "navigateToTnsBlockPage error");
        return;
    L6:
        Throwable r0 = r19.getCause();
        if (r0 == null) goto L9;
        Throwable r1 = r0.getCause();
    L10:
        String r7 = sh5.a.a(r1);
        DocReportPubParam r2 = new DocReportPubParam(getHost().c.getOpenEntity().getFileId(), 12, "", "", "", DiagramData$RESULT.FAIL, DiagramData$RESULT.FAIL, DiagramData$RESULT.FAIL);
        FragmentManager r4 = getActivity().getSupportFragmentManager();
        DrivePluginHost r3 = getHost();
        boolean r5 = getHost().c.isVCFollowMode();
        boolean r6 = getHost().c.isTypeWiki();
        if (r3.a.getParentFragment() != null) goto L13;
    L19:
        Fragment r8 = null;
    L20:
        if (r8 == null) goto L22;
        int r9 = r8.getId();
    L23:
        tt5.a.h(TAG, "DriveTnsBlockPlugin  fm=" + r4 + " replaceId=" + r18);
        ((hm5.a) org.koin.java.a.c(hm5.a.class, null, null, 6)).Sb(r4, getContext(), r9, r7, r2);
        return;
    L22:
        r9 = r18;
        goto L23
    L13:
        if ((r3.a.getParentFragment() instanceof DriveMainFragment) == false) goto L19;
        r8 = r3.a.getParentFragment();
        if (r6 == false) goto L20;
        if (r8 == null) goto L20;
        if (r5 == true) goto L20;
        r8 = r8.getParentFragment();
        goto L20
    L9:
        r1 = null;
        goto L10
    }
}
