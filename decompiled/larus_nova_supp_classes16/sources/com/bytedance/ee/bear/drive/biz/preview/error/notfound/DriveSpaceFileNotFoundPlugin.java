package com.bytedance.ee.bear.drive.biz.preview.error.notfound;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.drive.biz.preview.titlebar.DriveTitleBarVisibilityPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.impl.SpaceFileLoader;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.larus.apm.impl.protector.RunnableProtector;
import cu5.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/notfound/DriveSpaceFileNotFoundPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/error/notfound/DriveFileNotFoundPlugin;", "<init>", "()V", "mHasObserveFileNotFound", "", "handleFileNotFound", "", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSpaceFileNotFoundPlugin extends DriveFileNotFoundPlugin {
    private boolean mHasObserveFileNotFound;

    public static final class a implements Runnable {
        public final /* synthetic */ DriveSpaceFileNotFoundPlugin a;
        public final /* synthetic */ DrivePluginHost b;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.error.notfound.DriveSpaceFileNotFoundPlugin$a$a, reason: collision with other inner class name */
        public static final class C0138a<T> implements Observer {
            public final /* synthetic */ DriveSpaceFileNotFoundPlugin a;
            public final /* synthetic */ DrivePluginHost b;

            public C0138a(DriveSpaceFileNotFoundPlugin r1, DrivePluginHost r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void onChanged(Object r2) {
                b.a r3 = (b) r2;
                if ((r3 instanceof b.a) == true) goto L5;
                return;
            L5:
                if (tp5.b.b(r3.a, 920004002) == true) goto L7;
                return;
            L7:
                if (DriveSpaceFileNotFoundPlugin.access$isUIContainerAttached(this.a) == false) goto L18;
                u75.b r4 = this.b.c();
                if ((r4 instanceof SpaceFileLoader) == false) goto L11;
                SpaceFileLoader r5 = (SpaceFileLoader) r4;
            L12:
                if (r5 == null) goto L14;
                r5.h(ErrCode.FILE_NOT_FOUND);
            L14:
                DriveSpaceFileNotFoundPlugin r6 = this.a;
                r6.handleFileNotFound(DriveSpaceFileNotFoundPlugin.access$getUIContainer(r6));
                return;
            L11:
                r5 = null;
                goto L12
            }
        }

        public a(DriveSpaceFileNotFoundPlugin r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            if (DriveSpaceFileNotFoundPlugin.access$getMHasObserveFileNotFound$p(this.a) == true) goto L6;
            ((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.a.class, null, null, 6)).o(this.b).observe(this.b.getLifecycleOwner(), new C0138a(this.a, this.b));
            DriveSpaceFileNotFoundPlugin.access$setMHasObserveFileNotFound$p(this.a, true);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.error.notfound.DriveFileNotFoundPlugin, com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveSpaceFileNotFoundPlugin() {
    }

    public static final /* synthetic */ boolean access$getMHasObserveFileNotFound$p(DriveSpaceFileNotFoundPlugin r0) {
        return r0.mHasObserveFileNotFound;
    }

    public static final /* synthetic */ t access$getUIContainer(DriveSpaceFileNotFoundPlugin r0) {
        return r0.getUIContainer();
    }

    public static final /* synthetic */ boolean access$isUIContainerAttached(DriveSpaceFileNotFoundPlugin r0) {
        return r0.isUIContainerAttached();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.error.notfound.DriveFileNotFoundPlugin
    public void handleFileNotFound(t r3) {
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.handleFileNotFound(r3);
        tt5.a.h(DriveFileNotFoundPlugin.TAG, "handleFileNotFound.");
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).W(getHost().c.getOpenEntity().getFileId());
        DriveTitleBarVisibilityPlugin r4 = (DriveTitleBarVisibilityPlugin) findPlugin(DriveTitleBarVisibilityPlugin.class);
        if (r4 == null) goto L6;
        r4.updateFileNotFound(true);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.error.notfound.DriveFileNotFoundPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        if (r4.c.isTypeWiki() == false) goto L6;
        addInfoHandler(new a(this, r4), new InfoCode[]{InfoCode.PreFetchFileInfo});
        return;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.error.notfound.DriveFileNotFoundPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$setMHasObserveFileNotFound$p(DriveSpaceFileNotFoundPlugin r0, boolean r1) {
        r0.mHasObserveFileNotFound = r1;
    }
}
