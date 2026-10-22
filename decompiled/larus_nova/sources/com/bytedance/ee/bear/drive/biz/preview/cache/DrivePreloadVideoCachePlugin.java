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

/* JADX INFO: loaded from: classes16.dex */
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DrivePluginHost f223285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DrivePreloadVideoCachePlugin f223286b;

        public b(DrivePluginHost r100, DrivePreloadVideoCachePlugin r101) {
            this.f223285a = r100;
            this.f223286b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            w75.a r102 = this.f223285a.f224125c.getFileModel();
            if ((r102 instanceof f85.a) == true) goto L5;
            tt5.a.d(DrivePreloadVideoCachePlugin.TAG, "file is not from space");
            return;
        L5:
            f85.a.C5868a r103 = (f85.a.C5868a) ((f85.a) r102).f558532a;
            if (r103 == null) goto L8;
            String r104 = r103.f558557a;
        L9:
            if (r103 == null) goto L11;
            String r105 = r103.f475873p;
        L12:
            String r106 = n.c(r104, r105);
            long r107 = o75.b.a().getDriveConfig().f531963f;
            DrivePreloadVideoCachePlugin r108 = this.f223286b;
            DrivePreloadVideoCachePlugin.access$setListener$p(r108, new com.bytedance.ee.bear.drive.biz.preview.cache.a(r108, r102));
            Map<String, String> r109 = ((f) org.koin.java.a.c(f.class, null, null, 6)).oc(r101);
            IPreLoaderItemCallBackListener r110 = DrivePreloadVideoCachePlugin.access$getListener$p(this.f223286b);
            Intrinsics.checkNotNull(r110);
            r.a(r109, r106, r101, r107, r110);
            return;
        L11:
            r105 = null;
            goto L12
        L8:
            r104 = null;
            goto L9
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public DrivePreloadVideoCachePlugin() {
    }

    public static final /* synthetic */ IPreLoaderItemCallBackListener access$getListener$p(DrivePreloadVideoCachePlugin r100) {
        return r100.listener;
    }

    public static final /* synthetic */ n access$getMDriveVideoCacheManager$p(DrivePreloadVideoCachePlugin r100) {
        return r100.mDriveVideoCacheManager;
    }

    public void onAttachToHost(DrivePluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        super.onAttachToHost(r100);
        this.mDriveVideoCacheManager = new n(r100.b());
        ((VideoCacheViewModel) viewModel(VideoCacheViewModel.class)).getPreLoadVideoTask().observe(r100.getLifecycleOwner(), new b(r100, this));
    }

    public void onDetachFromHost(DrivePluginHost r100) {
        super.onDetachFromHost(r100);
        this.listener = null;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((DrivePluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((DrivePluginHost) r100);
    }

    public static final /* synthetic */ void access$setListener$p(DrivePreloadVideoCachePlugin r100, IPreLoaderItemCallBackListener r101) {
        r100.listener = r101;
    }
}
