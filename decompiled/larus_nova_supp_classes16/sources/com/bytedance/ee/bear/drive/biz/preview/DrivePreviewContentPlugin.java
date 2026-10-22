package com.bytedance.ee.bear.drive.biz.preview;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u75.b;
import w75.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/DrivePreviewContentPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "mListener", "Lcom/bytedance/ee/bear/drive/core/load/IFileLoader$LoadListener;", "previewViewModel", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/PreviewViewModel;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onAttachPreview", "onDetachPreview", "onDetachFromUIContainer", "postCreatorTenantId", "InternalLoadListener", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePreviewContentPlugin extends AbsDrivePreviewPlugin {
    private final b.a mListener;
    private PreviewViewModel previewViewModel;

    public final class a extends b.C0306b {
        public final /* synthetic */ DrivePreviewContentPlugin a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.DrivePreviewContentPlugin$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0133a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[InfoCode.values().length];
                r0[InfoCode.HitCache.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[InfoCode.FileInfoSuccess.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public a(DrivePreviewContentPlugin r1) {
            this.a = r1;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void b(z r2) {
            Intrinsics.checkNotNullParameter(r2, "fileModel");
            d(r2);
        }

        public final void d(z r2) {
            DrivePluginHost r0 = this.a.getHost();
            if (r0 == null) goto L10;
            DriveViewModel r1 = r0.c;
            if (r1 == null) goto L10;
            BaseOpenEntity r3 = r1.getOpenEntity();
            if (r3 == null) goto L10;
            String r4 = r3.getMountPoint();
            if (r4 == null) goto L10;
        L11:
            r2.t = r4;
            AbsPreviewView r5 = this.a.getPreviewView(r2);
            this.a.removeAndAddPreviewView(r5);
            this.a.getHost().c().b();
            return;
        L10:
            r4 = "";
            goto L11
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r4, T r5) {
            Intrinsics.checkNotNullParameter(r4, "code");
            int r6 = C0133a.a[r4.ordinal()];
            boolean r1 = true;
            if (r6 != 1) goto L5;
            StringBuilder r7 = new StringBuilder("onInfo#HitCache, data is null?=");
            if (r5 == 0) goto L15;
            r1 = false;
        L15:
            r7.append(r1);
            tt5.a.h("DriveComponent", r7.toString());
            if ((r5 instanceof w75.a) == true) goto L18;
            return;
        L18:
            d(((w75.a) r5).i());
            return;
        L5:
            if (r6 != 2) goto L21;
            StringBuilder r8 = new StringBuilder("onInfo#FileInfoSuccess, data is AbsFileModel?=");
            boolean r9 = r5 instanceof w75.a;
            r8.append(r9);
            tt5.a.h("DriveComponent", r8.toString());
            if (r9 == true) goto L10;
            return;
        L10:
            DrivePreviewContentPlugin r10 = this.a;
            r10.postCreatorTenantId(r10.getHost());
            return;
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DrivePreviewContentPlugin() {
        this.mListener = new a(this);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        tt5.a.h("DriveComponent", "onAttachPreview() called, lifecycleOwner=" + getLifecycleOwner());
        getHost().c().c(this.mListener);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        tt5.a.h("DriveComponent", "onDetachPreview() called, lifecycleOwner=" + getLifecycleOwner());
        getHost().c().g(this.mListener);
        removePreviewView();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToHost(r3);
        k75.a.i(r3).setBizType(r3.c.getBizType());
        this.previewViewModel = (PreviewViewModel) viewModel(PreviewViewModel.class);
        postCreatorTenantId(r3);
    }

    public final void postCreatorTenantId(DrivePluginHost r5) {
        String r0 = "";
        Intrinsics.checkNotNullParameter(r5, "host");
        c r6 = r5.c.getIFileModel();     // Catch: Throwable -> L9
        if (r6 == null) goto L12;
        String r7 = r6.a();     // Catch: Throwable -> L9
        if (r7 == null) goto L12;
        r0 = r7;
    L12:
        if (qyb.a.a(r0) == false) goto L19;
        PreviewViewModel r8 = this.previewViewModel;
        if (r8 == null) goto L20;
        r8.postLiveCreatorTenantId(r0);
        return;
    L20:
        return;
    L19:
        return;
    L9:
        th = move-exception;
        tt5.a.e("DriveComponent", "get tenantId error", th, false);
        goto L12
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin
    public void onAttachToUIContainer(DrivePluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.onAttachToUIContainer(r2, r3);
        tt5.a.h("DriveComponent", "onAttachToUIContainer() called, lifecycleOwner=" + getLifecycleOwner());
    }

    public void onDetachFromUIContainer(DrivePluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.onDetachFromUIContainer(r2, r3);
        tt5.a.h("DriveComponent", "onDetachFromUIContainer() called, lifecycleOwner=" + getLifecycleOwner());
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DrivePluginHost) r1, r2);
    }
}
