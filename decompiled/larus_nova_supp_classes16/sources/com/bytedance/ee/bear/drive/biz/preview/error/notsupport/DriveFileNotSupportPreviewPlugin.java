package com.bytedance.ee.bear.drive.biz.preview.error.notsupport;

import android.view.View;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.size.DriveFileSizeErrorPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.NotSupportPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.drive.render.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/notsupport/DriveFileNotSupportPreviewPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "showFileNotSupport", "isEncryptedFile", "", "isDriveFullscreenTriggerEnabled", "showFileHandover", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveFileNotSupportPreviewPlugin extends AbsDrivePreviewPlugin {

    public static final class a<T> implements Observer {
        public final /* synthetic */ DriveFileNotSupportPreviewPlugin a;

        public a(DriveFileNotSupportPreviewPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Intrinsics.checkNotNullParameter((String) r4, "it");
            DriveFileNotSupportPreviewPlugin.showFileNotSupport$default(this.a, false, 1, null);
        }
    }

    public static final class b extends u75.b.C0306b {
        public final /* synthetic */ DriveFileNotSupportPreviewPlugin a;

        public b(DriveFileNotSupportPreviewPlugin r1) {
            this.a = r1;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void c(ErrCode r6) {
            Intrinsics.checkNotNullParameter(r6, "code");
            if (r6 != ErrCode.PREVIEW_FAILED_DO_NOT_DOWNGRADE) goto L7;
            DriveFileNotSupportPreviewPlugin.access$showFileHandover(this.a);
            return;
        L7:
            if (r6 != ErrCode.DRIVE_FILE_ENCRYPTED) goto L10;
            DriveFileNotSupportPreviewPlugin.access$showFileNotSupport(this.a, false);
            return;
        L10:
            ErrCode r0 = ErrCode.DRIVE_FILE_NOT_SUPPORT_PREVIEW;
            if (r6 != r0) goto L23;
            Throwable r3 = r6.getCause();
            if ((r3 instanceof DriveException) == true) goto L15;
        L20:
            DriveFileNotSupportPreviewPlugin.showFileNotSupport$default(this.a, false, 1, null);
            return;
        L15:
            if (((DriveException) r3).getErrorCode() == r0) goto L20;
            Throwable r1 = r6.getCause();
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ee.bear.drive.loader.model.DriveException");
            ErrCode r2 = ((DriveException) r1).getErrorCode();
            DriveFileSizeErrorPlugin r4 = (DriveFileSizeErrorPlugin) DriveFileNotSupportPreviewPlugin.access$findPlugin(this.a, DriveFileSizeErrorPlugin.class);
            if (r4 == null) goto L23;
            r4.handleFileSizeError(r2);
        L23:
            if (r6 != ErrCode.ENCRYPTION_KEY_NOT_SUPPORT) goto L26;
            DriveFileNotSupportPreviewPlugin.access$showFileNotSupport(this.a, true);
            return;
        }
    }

    public static final class c extends t {
        public final /* synthetic */ DriveFileNotSupportPreviewPlugin c;

        public c(DriveFileNotSupportPreviewPlugin r1) {
            this.c = r1;
        }

        public final void a(View r2) {
            k75.a.i(this.c.getHost()).liveInnerSingleTap().postValue(null);
        }
    }

    public static final class d extends t {
        public final /* synthetic */ DriveFileNotSupportPreviewPlugin c;

        public d(DriveFileNotSupportPreviewPlugin r1) {
            this.c = r1;
        }

        public final void a(View r2) {
            k75.a.i(this.c.getHost()).liveInnerSingleTap().postValue(null);
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void showFileHandover() {
        tt5.a.h("DriveComponent", "showFileHandover");
        w75.a r0 = ((DrivePluginHost) getHost()).c.getFileModel();
        if (r0 != null) goto L6;
        tt5.a.k("DriveComponent", "showFileHandover, getFileModel is null");
        return;
    L6:
        NotSupportPreviewView r1 = new NotSupportPreviewView(((DrivePluginHost) getHost()).d(), new ViewOwner(getHost(), getLifecycleOwner()), getActivity(), r0.i(), ((DrivePluginHost) getHost()).b());
        r1.setHandoverFile(getActivity().getString(2131888398));
        if (((DrivePluginHost) getHost()).c.isInBlockState() == false) goto L9;
    L11:
        removeAndAddPreviewView(r1);
        dispatchToBlockHandler(1);
        return;
    L9:
        if (isDriveFullscreenTriggerEnabled() == false) goto L11;
        r1.setOnClickListener(new c(this));
        goto L11
    }

    private final boolean isDriveFullscreenTriggerEnabled() {
        k r0 = getDriveUIConfig();
        boolean r2 = false;
        if (r0 == null) goto L10;
        k.d r1 = r0.b();
        if (r1 == null) goto L10;
        if (r1.a == true) goto L10;
        r2 = true;
    L10:
        return !r2;
    }

    public DriveFileNotSupportPreviewPlugin() {
    }

    public static final /* synthetic */ void access$showFileHandover(DriveFileNotSupportPreviewPlugin r0) {
        r0.showFileHandover();
    }

    private final void showFileNotSupport(boolean r8) {
        tt5.a.h("DriveComponent", "show unsupport");
        if (((DrivePluginHost) getHost()).c.getFileModel() != null) goto L6;
        tt5.a.k("DriveComponent", "showFileNotSupport() but getFileModel is null");
        return;
    L6:
        w75.a r0 = ((DrivePluginHost) getHost()).c.getFileModel();
        if (r0 == null) goto L18;
        z r5 = r0.i();
        if (r5 == null) goto L19;
        NotSupportPreviewView r1 = new NotSupportPreviewView(((DrivePluginHost) getHost()).d(), new ViewOwner(getHost(), getLifecycleOwner()), getActivity(), r5, ((DrivePluginHost) getHost()).b());
        r1.setEncryptedFile(r8);
        if (((DrivePluginHost) getHost()).c.isInBlockState() == false) goto L14;
    L16:
        removeAndAddPreviewView(r1);
        dispatchToBlockHandler(1);
        return;
    L14:
        if (isDriveFullscreenTriggerEnabled() == false) goto L16;
        r1.setOnClickListener(new d(this));
        goto L16
    L19:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        k75.a.i(r4).liveInnerUnsupprtPreview().observe(getLifecycleOwner(), new a(this));
        r4.c().c(new b(this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ f access$findPlugin(DriveFileNotSupportPreviewPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ void access$showFileNotSupport(DriveFileNotSupportPreviewPlugin r0, boolean r1) {
        r0.showFileNotSupport(r1);
    }

    public static /* synthetic */ void showFileNotSupport$default(DriveFileNotSupportPreviewPlugin r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.showFileNotSupport(r1);
    }
}
