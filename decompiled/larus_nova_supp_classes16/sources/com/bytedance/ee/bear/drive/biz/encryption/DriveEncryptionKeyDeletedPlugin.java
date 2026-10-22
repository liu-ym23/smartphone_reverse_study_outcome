package com.bytedance.ee.bear.drive.biz.encryption;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.image.DriveImageThumbLoadingPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\b\u0010\b\u001a\u00020\u0005H\u0002¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/encryption/DriveEncryptionKeyDeletedPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "showEncryptionKeyDeletedUI", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveEncryptionKeyDeletedPlugin extends AbsDrivePreviewPlugin {
    public static final a Companion = null;
    public static final String TAG = "DriveEncryptionKeyDeleted";

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ DriveEncryptionVM a;

        public b(DriveEncryptionVM r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.h(DriveEncryptionKeyDeletedPlugin.TAG, "received ENCRYPTION_KEY_DELETED");     // Catch: Throwable -> L4
            this.a.getEncryptionKeyDeleted().postValue(Boolean.TRUE);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ DriveEncryptionKeyDeletedPlugin a;

        public c(DriveEncryptionKeyDeletedPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            tt5.a.h(DriveEncryptionKeyDeletedPlugin.TAG, "encryptionKeyDeleted liveData=" + r4);
            if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L6;
            DriveEncryptionKeyDeletedPlugin.access$getTitleBar(this.a).setTitle("");
            DriveEncryptionKeyDeletedPlugin.access$getTitleBar(this.a).setSubTitle("");
            DriveEncryptionKeyDeletedPlugin.access$showEncryptionKeyDeletedUI(this.a);
            int r5 = com.bytedance.ee.bear.drive.biz.cache.a.a;
            com.bytedance.ee.bear.drive.biz.cache.a.C0118a.a();
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void showEncryptionKeyDeletedUI() {
        SpaceEmptyState r0 = new SpaceEmptyState(getContext());
        r0.setImageSizeResource(2131165486);
        r0.setImageRes(2131232537);
        r0.setDesc(getResources().getString(2131887105));
        r0.showPrimaryAction(false);
        r0.showSecondaryAction(false);
        removeAndAddPreviewView(r0);
        DriveImageThumbLoadingPlugin r1 = (DriveImageThumbLoadingPlugin) findPlugin(DriveImageThumbLoadingPlugin.class);
        if (r1 == null) goto L6;
        r1.updateForceGone(true);
        return;
    }

    public DriveEncryptionKeyDeletedPlugin() {
    }

    public static final /* synthetic */ TitleBar access$getTitleBar(DriveEncryptionKeyDeletedPlugin r0) {
        return r0.getTitleBar();
    }

    public static final /* synthetic */ void access$showEncryptionKeyDeletedUI(DriveEncryptionKeyDeletedPlugin r0) {
        r0.showEncryptionKeyDeletedUI();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r5) {
        Intrinsics.checkNotNullParameter(r5, "host");
        super.onAttachToHost(r5);
        DriveEncryptionVM r6 = (DriveEncryptionVM) viewModel(DriveEncryptionVM.class);
        addErrorHandler(new b(r6), new ErrCode[]{ErrCode.ENCRYPTION_KEY_DELETED});
        r6.getEncryptionKeyDeleted().observe(getLifecycleOwner(), new c(this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
