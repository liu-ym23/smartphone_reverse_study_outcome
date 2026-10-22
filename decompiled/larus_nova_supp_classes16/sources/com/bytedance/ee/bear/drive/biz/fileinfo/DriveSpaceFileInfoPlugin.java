package com.bytedance.ee.bear.drive.biz.fileinfo;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.core.fragment.DriveMediaImmersiveVM;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u75.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/fileinfo/DriveSpaceFileInfoPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSpaceFileInfoPlugin extends AbsDrivePlugin {

    public static final class a extends b.C0306b {
        public final /* synthetic */ DrivePluginHost a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.fileinfo.DriveSpaceFileInfoPlugin$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0127a {
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

        public a(DrivePluginHost r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r3, T r4) {
            Intrinsics.checkNotNullParameter(r3, "code");
            int r5 = C0127a.a[r3.ordinal()];
            boolean r0 = true;
            if (r5 != 1) goto L5;
        L7:
            w75.a r6 = this.a.c.getFileModel();
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.ee.bear.drive.loader.model.DriveFileModel");
            f85.a r7 = (f85.a) r4;
            if (r6 == null) goto L10;
            r7.x = r6.x;
        L10:
            if (r6 == null) goto L12;
            r7.w = r6.w;
        L12:
            this.a.c.setFileModel(r7);
            DriveMediaImmersiveVM r8 = this.a.f();
            if (r8 == null) goto L15;
            r8.resolveFromFileModel(r7);
        L15:
            this.a.c.setFileName(((f85.a.C0229a) r7.a).b);
            DriveViewModel r9 = this.a.c;
            if (((f85.a.C0229a) r7.a).s == 1) goto L19;
            r0 = false;
        L19:
            r9.setRiskFlag(r0);
            return;
        L5:
            if (r5 == 2) goto L7;
        }
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveSpaceFileInfoPlugin() {
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToHost(r3);
        r3.c().c(new a(r3));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
