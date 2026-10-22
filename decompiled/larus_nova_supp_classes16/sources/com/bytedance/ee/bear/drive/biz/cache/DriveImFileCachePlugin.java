package com.bytedance.ee.bear.drive.biz.cache;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bitable.homepage.list.a0;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.preview.imattachment.DriveImAttachmentDefaultPreviewModelStatePlugin;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.streaming.StreamingCache;
import com.ss.android.lark.vfs.VFSPath;
import f85.b;
import fo5.d;
import io.reactivex.Flowable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y45.e;
import y45.f;
import y45.g;
import y45.h;
import y45.i;
import y45.j;
import y45.k;
import y45.l;
import y45.m;
import y45.n;
import y45.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/cache/DriveImFileCachePlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveImFileCachePlugin extends AbsDrivePlugin {

    public static final class a<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;

        public a(DrivePluginHost r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            if (r6 != null) goto L5;
        L37:
            tt5.a.d(DriveImAttachmentDefaultPreviewModelStatePlugin.TAG, "dataSource is null");
            return;
        L5:
            if (this.a.c == null) goto L37;
            if ((r6 instanceof VFSPath) == false) goto L17;
            tt5.a.h(DriveImAttachmentDefaultPreviewModelStatePlugin.TAG, "liveInnerSaveCache() ds=String");
            final b r0 = (b) this.a.c.getFileModel();
            VFSPath r7 = (VFSPath) r6;
            final a95.a r1 = this.a.b();
            if (r0 != null) goto L12;
        L15:
            tt5.a.d("DriveSdk", "SdkStreamingCacheUtils#saveStreamingDownloadFile param error");
            return;
        L12:
            if (((b.a) r0.a) == null) goto L15;
            final t r2 = t.l();
            b.a r3 = (b.a) r0.a;
            final String r4 = t.e(r3.m, r3.a);
            Flowable.just(r7).observeOn(d.b()).filter(new j()).map(new k(r4, r1, r0)).flatMap(new l(r0, r4, r2, r1)).subscribe(new a0(), new m());
            return;
        L17:
            if ((r6 instanceof byte[]) == false) goto L25;
            tt5.a.h("DriveSdk", "liveInnerSaveCache() ds=byte[]");
            final b r5 = (b) this.a.c.getFileModel();
            final byte[] r8 = (byte[]) r6;
            final a95.a r9 = this.a.b();
            if (r5 != null) goto L21;
        L23:
            tt5.a.h("DriveSdk", "SdkStreamingCacheUtils#saveProgressiveSource param empty!!!");
            return;
        L21:
            if (((b.a) r5.a) == null) goto L23;
            tt5.a.h("DriveSdk", "SdkStreamingCacheUtils#saveProgressiveSource start!!!");
            final t r10 = t.l();
            b.a r11 = (b.a) r5.a;
            final String r12 = t.e(r11.m, r11.a);
            Flowable.fromCallable(new f(r12, r5, r9, r8)).flatMap(new g(r5, r12, r10, r9)).subscribeOn(d.b()).observeOn(d.d()).subscribe(new h(), new i());
            return;
        L25:
            if ((r6 instanceof y75.b) == false) goto L34;
            tt5.a.h("DriveSdk", "liveInnerSaveCache() ds=ExcelSubCacheModel");
            final b r13 = (b) this.a.c.getFileModel();
            final a95.a r14 = this.a.b();
            if (r13 != null) goto L29;
        L32:
            tt5.a.d("DriveSdk", "SdkStreamingCacheUtils#saveStreamingDownloadFile param error");
            return;
        L29:
            if (((b.a) r13.a) == null) goto L32;
            final t r16 = t.l();
            b.a r17 = (b.a) r13.a;
            final String r18 = t.e(r17.m, r17.a);
            Flowable.just("").observeOn(d.b()).flatMap(new n(r13, r18, r16, r14)).subscribe(new a0(), new o());
            return;
        L34:
            if ((r6 instanceof StreamingCache) == false) goto L45;
            tt5.a.h("DriveComponent", "liveInnerSaveCache() ds=StreamingCache]");
            DriveViewModel r19 = this.a.c;
            Intrinsics.checkNotNullParameter(r19, "<this>");
            e.a(com.bytedance.ee.bear.drive.config.strategy.j.b(r19), this.a.c.getIFileModel(), (StreamingCache) r6, this.a.b());
            return;
        }
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveImFileCachePlugin() {
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        k75.a.i(r4).liveInnerSaveCache().observe(getLifecycleOwner(), new a(r4));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
