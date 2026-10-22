package com.ss.android.lark.app.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.PictureDrawable;
import android.os.Build;
import android.text.TextUtils;
import ava.d;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.integration.webp.WebpGlideLibraryModule;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DataCacheKey;
import com.bumptech.glide.load.engine.ResourceCacheKey;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.LarkDiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.cache.SafeKeyGenerator;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.monitor.GlideDiskCacheMonitor;
import com.bumptech.glide.monitor.GlideMonitorSettings;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.caverock.androidsvg.SVG;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.image.impl.avatar.AvatarImageNameManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.rustinfrabridge.netstate.api.WSConnState$ConnState;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import com.suite.lark.platform.component.storage.file.dirs.k;
import dva.e;
import dva.f;
import dva.g;
import dva.h;
import dva.i;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public abstract class RootGlideModule extends AppGlideModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f408707a;

    public class a implements SafeKeyGenerator.IKeyGeneratorHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f408708a;

        public a(Context r100) {
            this.f408708a = r100;
        }

        @Override // com.bumptech.glide.load.engine.cache.SafeKeyGenerator.IKeyGeneratorHandler
        public final String generateSafeKey(Key r100) {
            if ((r100 instanceof DataCacheKey) == false) goto L9;
            DataCacheKey r101 = (DataCacheKey) r100;
            if ((r101.getSourceKey() instanceof AvatarImage) == false) goto L9;
            AvatarImage r102 = (AvatarImage) r101.getSourceKey();
            return AvatarImageNameManager.inst().generateFileName(this.f408708a, r102);
        L9:
            throw new IllegalArgumentException("avatar key invalid");
        }

        @Override // com.bumptech.glide.load.engine.cache.SafeKeyGenerator.IKeyGeneratorHandler
        public final boolean handleDataCacheKey(Key r100) {
            if ((r100 instanceof DataCacheKey) == true) goto L5;
        L7:
            return false;
        L5:
            if ((((DataCacheKey) r100).getSourceKey() instanceof AvatarImage) == false) goto L7;
            return true;
        }

        @Override // com.bumptech.glide.load.engine.cache.SafeKeyGenerator.IKeyGeneratorHandler
        public final boolean handleResourceCacheKey(Key r100) {
            if ((r100 instanceof ResourceCacheKey) == true) goto L5;
        L7:
            return false;
        L5:
            if ((((ResourceCacheKey) r100).getSourceKey() instanceof AvatarImage) == false) goto L7;
            return true;
        }
    }

    public static class b implements ConnectivityMonitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConnectivityMonitor.ConnectivityListener f408709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f408710b;

        @Override // com.bumptech.glide.manager.LifecycleListener
        public final void onDestroy() {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public final void onStart() {
            this.f408710b = true;
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public final void onStop() {
            if (this.f408710b == false) goto L7;
            this.f408710b = false;
            return;
        }

        public b(ConnectivityMonitor.ConnectivityListener r100) {
            this.f408709a = r100;
        }
    }

    public static class c implements ConnectivityMonitorFactory, h3c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile boolean f408711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<WeakReference<b>> f408712b;

        public c() {
            this.f408711a = false;
            this.f408712b = new ArrayList();
        }

        @Override // h3c.a
        public final void a(WSConnState$ConnState r100) {
            if (r100 != WSConnState$ConnState.Connected) goto L5;
            final boolean r101 = true;
        L6:
            CoreThreadPool.getDefault().getUIExecutor().execute(new d(this, r101));
            return;
        L5:
            r101 = false;
            goto L6
        }

        @Override // com.bumptech.glide.manager.ConnectivityMonitorFactory
        public final ConnectivityMonitor build(Context r100, ConnectivityMonitor.ConnectivityListener r101) {
            if (this.f408711a == true) goto L5;
            List<h3c.a> r102 = com.ss.android.lark.rustinfrabridge.netstate.impl.d.f439712a;
            com.ss.android.lark.rustinfrabridge.netstate.impl.d.b.f439716a.getClass();
            ((CopyOnWriteArrayList) com.ss.android.lark.rustinfrabridge.netstate.impl.d.f439712a).add(this);
            this.f408711a = true;
        L5:
            b r103 = new b(r101);
            List<WeakReference<b>> r104 = this.f408712b;
            ArrayList r105 = (ArrayList) r104;
            r105.add(new WeakReference(r103));
            return r103;
        }
    }

    @Override // com.bumptech.glide.module.AppGlideModule
    public final boolean isManifestParsingEnabled() {
        return false;
    }

    public RootGlideModule() {
    }

    @Override // com.bumptech.glide.module.AppGlideModule, com.bumptech.glide.module.AppliesOptions
    public final void applyOptions(final Context r110, GlideBuilder r111) {
        ImageUtils.f444666d = true;
        WebpGlideLibraryModule.sSupportWebpAnimation = true;
        int r100 = com.suite.lark.platform.component.storage.file.dirs.d.f460639a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = com.ss.android.lark.diskmanage.storage.d.f(r110);
        String r102 = z.c(r110);
        if (TextUtils.isEmpty(r102) == false) goto L5;
        r102 = PullConfiguration.PROCESS_NAME_MAIN;
    L5:
        boolean r103 = r102.contains("miniapp");
        if (r103 == false) goto L8;
        r102 = "miniapp";
    L8:
        final String r104 = r101 + r102 + File.separator;
        FileUtils.t(r104);
        if (z.e(r110) == false) goto L11;
        int r105 = 157286400;
    L14:
        DiskLruCacheFactory.CacheDirectoryGetter r106 = new ava.a(r104);
        DiskLruCacheFactory.CacheDirectoryGetter r107 = new ava.b(r110);
        a r108 = new a(r110);
        long r112 = r105;
        LarkDiskLruCacheFactory r109 = new LarkDiskLruCacheFactory(r106, r107, r112, r108);
        Log.i("LarkGlideModule", "use unistore disk cache");
        com.ss.android.lark.app.glide.diskcache.b.a r113 = new com.ss.android.lark.app.glide.diskcache.b.a();
        SafeKeyGenerator r114 = new SafeKeyGenerator(r108);
        Intrinsics.checkNotNullParameter(r114, "generator");
        r113.f408726a = r114;
        Intrinsics.checkNotNullParameter(r108, "handler");
        r113.f408727b = r108;
        r113.f408730e = r112;
        Intrinsics.checkNotNullParameter(r109, "factory");
        r113.f408728c = r109;
        ava.c r115 = new ava.c(this);
        Intrinsics.checkNotNullParameter(r115, ShortVideoSegments.KEY_PROP_PROVIDER);
        r113.f408729d = r115;
        r111.setDiskCache(new com.ss.android.lark.app.glide.diskcache.b(r113));
        if (GlideMonitorSettings.getMonitor().getEnable() != 1) goto L27;
        String r116 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();
        com.suite.lark.platform.component.storage.file.dirs.d r117 = new com.suite.lark.platform.component.storage.file.dirs.d();
        if (r116 != null) goto L19;
        r116 = "";
    L19:
        VFSFile r118 = r117.d(LarkFileStorage.f(r116)).toFile();
        VFSFiles r119 = VFSFiles.f444819b;
        ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();
        k.a r120 = k.f460651a;
        monitor-enter(k.class);
        String r121 = k.f460651a.a(r110, "LarkGlideModule");     // Catch: Throwable -> L24
        monitor-exit(k.class);
        GlideDiskCacheMonitor.onStart(r118, r119.i(r121));
    L24:
        th = move-exception;
        throw th;
    L27:
        r111.setConnectivityMonitorFactory(new c());
        MemorySizeCalculator.Builder r122 = new MemorySizeCalculator.Builder(r110);
        if (Build.VERSION.SDK_INT >= 26) goto L30;
        r122.setMaxSizeMultiplier(0.2f);
        r122.setLowMemoryMaxSizeMultiplier(0.15f);
        r122.setMemoryCacheScreens(1.5f);
        r122.setBitmapPoolScreens(0.8f);
        r122.setArrayPoolSize(2097152);
    L31:
        r111.setMemorySizeCalculator(r122);
        return;
    L30:
        r122.setMaxSizeMultiplier(0.3f);
        r122.setLowMemoryMaxSizeMultiplier(0.2f);
        r122.setMemoryCacheScreens(2.0f);
        r122.setBitmapPoolScreens(1.0f);
        r122.setArrayPoolSize(4194304);
        goto L31
    L11:
        if (r103 == false) goto L13;
        r105 = 41943040;
        goto L14
    L13:
        r105 = 62914560;
        goto L14
    }

    @Override // com.bumptech.glide.module.LibraryGlideModule, com.bumptech.glide.module.RegistersComponents
    public final void registerComponents(Context r100, Glide r101, Registry r110) {
        super.registerComponents(r100, r101, r110);
        if (f408707a != null) goto L5;
        f408707a = Boolean.valueOf(com.ss.android.lark.featuregating.b.b(LarkAppContext.inst().getContext()).a("render_svg_image"));
    L5:
        Log.i("LarkGlideModule", "isSupportRenderSVGImage: " + f408707a);
        if (f408707a.booleanValue() == false) goto L8;
        BitmapEncoder r102 = new BitmapEncoder(r101.getArrayPool());
        f r103 = new f();
        g r104 = new g();
        dva.c r105 = new dva.c(r103);
        r110.register(SVG.class, Bitmap.class, r104).register(SVG.class, PictureDrawable.class, new h()).append("SVG", InputStream.class, SVG.class, r103).append("SVG", ByteBuffer.class, SVG.class, r105).append(Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, new e(r103, r104)).append(Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, new dva.b(r105, r104)).append(SVG.class, new i(r102));
    L8:
        r110.replace(GlideUrl.class, InputStream.class, new com.ss.android.lark.app.glide.loader.a.C4744a());
        r101.setIsDowngradeFGEnabled(Boolean.valueOf(FeatureGatingModule.getFeatureGatingService().isCurrentEnable("lark.assemble.glide.downgrade_memory_on_trim")));
    }
}
