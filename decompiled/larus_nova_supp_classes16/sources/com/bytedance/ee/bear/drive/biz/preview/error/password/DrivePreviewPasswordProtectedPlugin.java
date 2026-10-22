package com.bytedance.ee.bear.drive.biz.preview.error.password;

import android.view.View;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockViewSwitchManager;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/password/DrivePreviewPasswordProtectedPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "encryptedView", "Lcom/bytedance/ee/bear/drive/biz/preview/error/password/DriveFileEncryptedView;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "showPasswordProtectedErrorPage", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePreviewPasswordProtectedPlugin extends AbsDrivePreviewPlugin {
    private DriveFileEncryptedView encryptedView;

    public static final class a<T> implements Observer {
        public final /* synthetic */ DrivePreviewPasswordProtectedPlugin a;

        public a(DrivePreviewPasswordProtectedPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            if (((String) r3) == null) goto L6;
            DrivePreviewPasswordProtectedPlugin r4 = this.a;
            tt5.a.h("DriveComponent", "liveInnerPasswordProtected() show error tips page.");
            DrivePreviewPasswordProtectedPlugin.access$showPasswordProtectedErrorPage(r4);
            return;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ DrivePreviewPasswordProtectedPlugin a;

        public b(DrivePreviewPasswordProtectedPlugin r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.h("DriveComponent", "DrivePreviewPasswordProtectedPlugin() REQUEST_TRANSFORM_FILE_ENCRYPTION.");     // Catch: Throwable -> L4
            DrivePreviewPasswordProtectedPlugin.access$showPasswordProtectedErrorPage(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ DrivePreviewPasswordProtectedPlugin a;

        public c(DrivePreviewPasswordProtectedPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            tt5.a.h("DriveComponent", "DrivePreviewPasswordProtectedPlugin() open external");
            k75.a.i(this.a.getHost()).liveInnerOpenExternal().postValue(null);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ DrivePreviewPasswordProtectedPlugin a;

        public d(DrivePreviewPasswordProtectedPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            tt5.a.h("DriveComponent", "liveOuterExportVisible() visible = " + r4);
            DriveFileEncryptedView r0 = DrivePreviewPasswordProtectedPlugin.access$getEncryptedView$p(this.a);
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("encryptedView");
            r0 = null;
        L5:
            Intrinsics.checkNotNull(r4);
            boolean r5 = r4.booleanValue();
            boolean r1 = this.a.getHost().c.isInBlockState();
            r0.b = r5;
            if (r1 == true) goto L9;
            r0.a.showPrimaryAction(r5);
            return;
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void showPasswordProtectedErrorPage() {
        DriveFileEncryptedView r0 = new DriveFileEncryptedView(getContext());
        this.encryptedView = r0;
        r0.setOnOpenExternalClickListener(new c(this));
        k75.a.i(getHost()).liveOuterExportVisible().observe(getLifecycleOwner(), new d(this));
        DriveFileEncryptedView r1 = this.encryptedView;
        DriveFileEncryptedView r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("encryptedView");
        r1 = null;
    L5:
        ViewOwner r3 = getHost().e();
        r1.getClass();
        new DriveBlockViewSwitchManager(r3).a(new c65.a(r1));
        DriveFileEncryptedView r4 = this.encryptedView;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("encryptedView");
    L9:
        removeAndAddPreviewView(r2);
        return;
    L8:
        r2 = r4;
        goto L9
    }

    public DrivePreviewPasswordProtectedPlugin() {
    }

    public static final /* synthetic */ DriveFileEncryptedView access$getEncryptedView$p(DrivePreviewPasswordProtectedPlugin r0) {
        return r0.encryptedView;
    }

    public static final /* synthetic */ void access$showPasswordProtectedErrorPage(DrivePreviewPasswordProtectedPlugin r0) {
        r0.showPasswordProtectedErrorPage();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        k75.a.i(r4).liveInnerPasswordProtected().observe(getLifecycleOwner(), new a(this));
        addErrorHandler(new b(this), new ErrCode[]{ErrCode.REQUEST_TRANSFORM_FILE_ENCRYPTION});
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
