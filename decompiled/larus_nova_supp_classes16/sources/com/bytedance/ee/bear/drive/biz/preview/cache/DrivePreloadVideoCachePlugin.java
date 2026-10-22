package com.bytedance.ee.bear.drive.biz.preview.cache;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.preload.n;
import com.bytedance.ee.bear.drive.preload.r;
import com.bytedance.ee.bear.drive.view.preview.video.VideoCacheViewModel;
import com.bytedance.ee.drive.preview.f;
import com.ss.ttvideoengine.IPreLoaderItemCallBackListener;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/cache/DrivePreloadVideoCachePlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePlugin;", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "<init>", "()V", "listener", "Lcom/ss/ttvideoengine/IPreLoaderItemCallBackListener;", "mDriveVideoCacheManager", "Lcom/bytedance/ee/bear/drive/preload/DriveVideoPreloadCacheManager;", "onAttachToHost", "", "host", "onDetachFromHost", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePreloadVideoCachePlugin extends BasePlugin<DrivePluginHost> {
    public static final a Companion = null;
    private static final String TAG = "DrivePreloadVideoCachePlugin";
    private IPreLoaderItemCallBackListener listener;
    private n mDriveVideoCacheManager;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DrivePreloadVideoCachePlugin b;

        public b(DrivePluginHost r1, DrivePreloadVideoCachePlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r8) {
            String r2 = (String) r8;
            w75.a r9 = this.a.c.getFileModel();
            if ((r9 instanceof f85.a) == true) goto L5;
            tt5.a.d(DrivePreloadVideoCachePlugin.TAG, "file is not from space");
            return;
        L5:
            f85.a.C0229a r0 = (f85.a.C0229a) ((f85.a) r9).a;
            if (r0 == null) goto L8;
            String r3 = r0.a;
        L9:
            if (r0 == null) goto L11;
            String r1 = r0.p;
        L12:
            String r4 = n.c(r3, r1);
            long r5 = o75.b.a().getDriveConfig().f;
            DrivePreloadVideoCachePlugin r6 = this.b;
            DrivePreloadVideoCachePlugin.access$setListener$p(r6, new com.bytedance.ee.bear.drive.biz.preview.cache.a(r6, r9));
            Map<String, String> r7 = ((f) org.koin.java.a.c(f.class, null, null, 6)).oc(r2);
            IPreLoaderItemCallBackListener r10 = DrivePreloadVideoCachePlugin.access$getListener$p(this.b);
            Intrinsics.checkNotNull(r10);
            r.a(r7, r4, r2, r5, r10);
            return;
        L11:
            r1 = null;
            goto L12
        L8:
            r3 = null;
            goto L9
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DrivePreloadVideoCachePlugin() {
    }

    public static final /* synthetic */ IPreLoaderItemCallBackListener access$getListener$p(DrivePreloadVideoCachePlugin r0) {
        return r0.listener;
    }

    public static final /* synthetic */ n access$getMDriveVideoCacheManager$p(DrivePreloadVideoCachePlugin r0) {
        return r0.mDriveVideoCacheManager;
    }

    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        this.mDriveVideoCacheManager = new n(r4.b());
        ((VideoCacheViewModel) viewModel(VideoCacheViewModel.class)).getPreLoadVideoTask().observe(r4.getLifecycleOwner(), new b(r4, this));
    }

    public void onDetachFromHost(DrivePluginHost r1) {
        super.onDetachFromHost(r1);
        this.listener = null;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$setListener$p(DrivePreloadVideoCachePlugin r0, IPreLoaderItemCallBackListener r1) {
        r0.listener = r1;
    }
}
