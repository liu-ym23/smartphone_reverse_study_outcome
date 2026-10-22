package com.bytedance.locallife.dito.common.plugin;

import android.graphics.Bitmap;
import androidx.lifecycle.Observer;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.locallife.cube.Cube;
import com.bytedance.locallife.cube.api.i.ICubeGlobalListener;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.dito.data.DitoPage;
import com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.request.ImageRequest;
import com.lynx.fresco.FrescoImagePrefetchHelper;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/dito/common/plugin/DitoImagePrefetchPlugin;", "Lcom/bytedance/locallife/dito/plugin/AbsDitoLifeCyclePlugin;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dito-common-saas_release"}, k = 1, mv = {1, 4, 3})
public final class DitoImagePrefetchPlugin extends AbsDitoLifeCyclePlugin {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f257463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Future<?> f257464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f257465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<DataSource<?>> f257466g;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DitoImagePrefetchPlugin f257467a;

        public b(DitoImagePrefetchPlugin r100) {
            this.f257467a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.bytedance.locallife.dito.data.l r101 = (com.bytedance.locallife.dito.data.l) r100;
            if (Intrinsics.areEqual(r101.getType(), "DATA_REFRESH") == true) goto L7;
            if (Intrinsics.areEqual(r101.getType(), "DATA_UPDATE") == true) goto L7;
            return;
        L7:
            if (this.f257467a.f257465f == true) goto L65;
            DitoPage r102 = r101.f258215b;
            if (r102 == null) goto L63;
            DitoImagePrefetchPlugin r103 = this.f257467a;
            c r104 = r103.f257463d;
            DitoViewModel r105 = r103.g();
            r104.getClass();
            Intrinsics.checkNotNullParameter(r102, "ditoPage");
            Intrinsics.checkNotNullParameter(r105, "viewModel");
            com.bytedance.locallife.dito.common.data.c r106 = com.bytedance.locallife.dito.common.experiment.h.d(r105.f258038d);
            if (r106 != null) goto L14;
        L25:
            com.bytedance.locallife.dito.common.data.c r107 = null;
        L26:
            c r108 = r103.f257463d;
            DitoViewModel r109 = r103.g();
            r108.getClass();
            Intrinsics.checkNotNullParameter(r102, "ditoPage");
            Intrinsics.checkNotNullParameter(r109, "viewModel");
            String r110 = r109.f258038d;
            com.bytedance.locallife.dito.common.experiment.g r111 = com.bytedance.locallife.dito.common.experiment.g.f257354d;
            Intrinsics.checkNotNullParameter(r110, "page");
            com.bytedance.locallife.dito.common.data.b r112 = com.bytedance.locallife.dito.common.experiment.g.f257354d.b(r110, null);
            if (r112 == null) goto L32;
            List<String> r113 = r112.a();
            if (r113 == null) goto L32;
            Regex r114 = c.f257554a;
            List r115 = c.a.a(r113, r102);
        L33:
            if (r107 != null) goto L35;
        L40:
            if (r115 == null) goto L64;
            Iterator<T> r116 = r115.iterator();
        L43:
            if (r116.hasNext() == false) goto L66;
            String r117 = (String) r116.next();
            Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L47
            Object r119 = Result.m9449constructorimpl(ImageRequest.fromUri(r117));     // Catch: Throwable -> L47
        L50:
            if (Result.m9455isFailureimpl(r119) == false) goto L52;
            r119 = null;
        L52:
            ImageRequest r120 = (ImageRequest) r119;
            if (r120 == null) goto L43;
            Fresco.getImagePipeline().prefetchToDiskCache(r120, null);
        L47:
            th = move-exception;
            Result.Companion r121 = Result.Companion;
            r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L50
        L66:
            return;
        L64:
            return;
        L35:
            if (r107.c() == false) goto L40;
            if (r107.a() == false) goto L39;
            r103.f257464e = TTExecutors.getIOThreadPool().submit(new h(r103, r107));
            goto L40
        L39:
            DitoImagePrefetchPlugin.s(r103, r107);
        L32:
            r115 = null;
            goto L33
        L14:
            if (r106.c() == false) goto L25;
            List<String> r122 = r106.b();
            if (r122 != null) goto L18;
        L21:
            boolean r123 = true;
        L22:
            if (r123 == true) goto L25;
            Regex r124 = c.f257554a;
            r107 = new com.bytedance.locallife.dito.common.data.c(c.a.a(r106.b(), r102), r106.a());
            goto L26
        L18:
            if (r122.isEmpty() == true) goto L21;
            r123 = false;
            goto L22
        L63:
            return;
        }
    }

    static {
    }

    public DitoImagePrefetchPlugin() {
        this.f257463d = new c();
        this.f257466g = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void j(com.bytedance.locallife.dito.data.t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        g().f258041g.H().observeForever(new b(this));
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void l(com.bytedance.locallife.dito.data.t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        this.f257465f = true;
        Future<?> r101 = this.f257464e;
        if (r101 == null) goto L5;
        r101.cancel(false);
    L5:
        this.f257464e = null;
        Iterator<T> r102 = this.f257466g.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((DataSource) r102.next()).close();
        goto L7
    L9:
        ((CopyOnWriteArrayList) this.f257466g).clear();
    }

    public static final void s(DitoImagePrefetchPlugin r100, com.bytedance.locallife.dito.common.data.c r101) {
        if (r100.f257465f == true) goto L32;
        List<String> r102 = r101.b();
        if (r102 == null) goto L26;
        Iterator<T> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L33;
        String r104 = (String) r103.next();
        if (r100.f257465f == true) goto L34;
        Object r105 = null;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L16
        kp6.a<ICubeGlobalListener> r107 = Cube.f257155a;     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r104, "imageUrl");     // Catch: Throwable -> L16
        Object r108 = Result.m9449constructorimpl(FrescoImagePrefetchHelper.prefetchImageToBitmapCache(r104, Bitmap.Config.ARGB_8888, null));     // Catch: Throwable -> L16
    L19:
        if (Result.m9455isFailureimpl(r108) == true) goto L22;
        r105 = r108;
    L22:
        DataSource r109 = (DataSource) r105;
        if (r109 == null) goto L35;
        ((CopyOnWriteArrayList) r100.f257466g).add(r109);
        r109.subscribe(new g(r100, r109), UiThreadImmediateExecutorService.getInstance());
        goto L9
    L35:
        return;
    L16:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L34:
        return;
    L33:
        return;
    L26:
        return;
    }
}
