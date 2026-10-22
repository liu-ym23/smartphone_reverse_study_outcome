package com.bytedance.ee.bear.drive.biz.preview.error.size;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.NotSupportPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/size/DriveFileSizeErrorPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "handleFileSizeError", "code", "Lcom/bytedance/ee/bear/drive/loader/model/ErrCode;", "showFileSizeError", "serverPreviewStatus", "", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveFileSizeErrorPlugin extends AbsDrivePreviewPlugin {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ErrCode.values().length];
            r0[ErrCode.DRIVE_FILE_OVER_SIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ErrCode.DRIVE_FILE_ZERO_SIZE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class b extends u75.b.C0306b {
        public final /* synthetic */ DriveFileSizeErrorPlugin a;

        public b(DriveFileSizeErrorPlugin r1) {
            this.a = r1;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void c(ErrCode r2) {
            Intrinsics.checkNotNullParameter(r2, "code");
            this.a.handleFileSizeError(r2);
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveFileSizeErrorPlugin() {
    }

    private final void showFileSizeError(int r8) {
        w75.a r0 = getHost().c.getFileModel();
        if (r0 == null) goto L5;
        z r1 = r0.i();
    L6:
        z r5 = r1;
        if (r5 == null) goto L10;
        r5.h = r8;
        removeAndAddPreviewView(new NotSupportPreviewView(getHost().d(), new ViewOwner(getHost(), getLifecycleOwner()), getActivity(), r5, getHost().b()));
        dispatchToBlockHandler(2);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void handleFileSizeError(ErrCode r2) {
        Intrinsics.checkNotNullParameter(r2, "code");
        int r3 = a.a[r2.ordinal()];
        if (r3 != 1) goto L5;
        showFileSizeError(5);
        return;
    L5:
        if (r3 != 2) goto L11;
        showFileSizeError(6);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
        r2.c().c(new b(this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
