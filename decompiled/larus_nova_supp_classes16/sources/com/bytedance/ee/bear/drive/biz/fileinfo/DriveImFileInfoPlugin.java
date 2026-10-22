package com.bytedance.ee.bear.drive.biz.fileinfo;

import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.preview.more.save2space.DriveImFileSaveToSpaceVM;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u75.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/fileinfo/DriveImFileInfoPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveImFileInfoPlugin extends AbsDrivePlugin {

    public static final class a extends b.C0306b {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DriveImFileInfoPlugin b;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.fileinfo.DriveImFileInfoPlugin$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0126a {
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

        public a(DrivePluginHost r1, DriveImFileInfoPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r2, T r3) {
            Intrinsics.checkNotNullParameter(r2, "code");
            int r4 = C0126a.a[r2.ordinal()];
            if (r4 == 1) goto L8;
            if (r4 == 2) goto L8;
            return;
        L8:
            if ((r3 instanceof f85.b) == true) goto L11;
            tt5.a.k("DriveComponent", "receiveFileInfo update, but data is not DriveIMFileModel im im file");
            return;
        L11:
            w75.a r5 = this.a.c.getFileModel();
            f85.b r6 = (f85.b) r3;
            if (r5 == null) goto L14;
            r6.x = r5.x;
        L14:
            if (r5 == null) goto L16;
            r6.w = r5.w;
        L16:
            this.a.c.setFileModel(r6);
            this.a.c.setFileName(((f85.b.a) r6.a).b);
            if (TextUtils.isEmpty(((f85.b.a) r6.a).o) == true) goto L20;
            ((DriveImFileSaveToSpaceVM) DriveImFileInfoPlugin.access$viewModel(this.b, DriveImFileSaveToSpaceVM.class)).getLiveFileToken().postValue(((f85.b.a) r6.a).o);
            return;
        }
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveImFileInfoPlugin() {
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToHost(r3);
        r3.c().c(new a(r3, this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveImFileInfoPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }
}
