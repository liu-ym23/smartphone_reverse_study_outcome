package com.bytedance.locallife.cube;

import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.locallife.cube.api.config.CubeConfig;
import com.bytedance.locallife.cube.api.config.CubeCreateThreadStrategy;
import com.bytedance.locallife.cube.api.i.ICubeGlobalListener;
import com.bytedance.locallife.cube.api.i.IPoiLynxKitDelegate;
import com.bytedance.locallife.cube.api.model.CubeInternalSchemaModel;
import com.bytedance.locallife.cube.api.model.FileLoadOptions;
import com.bytedance.locallife.cube.api.model.TemplateBundleBuildOptions;
import com.bytedance.locallife.cube.decode.LynxTemplateDecodeImpl;
import com.bytedance.locallife.cube.impl.CubeDelegateManager;
import com.bytedance.locallife.cube.preload.LynxTemplatePreLoader;
import com.bytedance.locallife.cube.preload.Type;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import p46.f;

/* JADX INFO: loaded from: classes21.dex */
public final class Cube {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kp6.a<ICubeGlobalListener> f257155a = null;

    public Cube() {
    }

    static {
        f257155a = new kp6.a();
    }

    public static m16.b b(Map r100) {
        m16.b r101 = new m16.b();
        f r102 = new f();
        r102.f527681a = r100;
        r101.d(f.class, r102);
        return r101;
    }

    public static void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "urlKey");
        Gson r101 = com.bytedance.locallife.cube.preload.a.f257260a;
        Intrinsics.checkNotNullParameter(r100, "urlKey");
        ((ArrayList) com.bytedance.locallife.cube.preload.a.f257261b).add(r100);
    }

    public static void j(CubeConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        ConcurrentHashMap<Integer, List<IPoiLynxKitDelegate>> r101 = CubeDelegateManager.f257211a;
        CubeDelegateManager.m(r100);
    }

    public static void k(IPoiLynxKitDelegate r100) {
        ConcurrentHashMap<Integer, List<IPoiLynxKitDelegate>> r101 = CubeDelegateManager.f257211a;
        CubeDelegateManager.n(r100);
    }

    public static IPoiLynxKitDelegate c(CubeConfig r100, final CubeInternalSchemaModel r101, final long r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        IPoiLynxKitDelegate r103 = CubeDelegateManager.i(r100, r101);
        if (r103 == null) goto L5;
        gp6.d.a(r103, new Cube$getDelegate$1$1(r102, r101));
        return r103;
    L5:
        return null;
    }

    public static /* synthetic */ IPoiLynxKitDelegate d(CubeConfig r100, CubeInternalSchemaModel r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        long r103 = System.currentTimeMillis();
    L10:
        return c(r100, r101, r103);
    L8:
        r103 = 0;
        goto L10
    }

    public static void g(String r100, List r101, boolean r102, Type r103) {
        Intrinsics.checkNotNullParameter(r100, "timing");
        Intrinsics.checkNotNullParameter(r101, "templates");
        Intrinsics.checkNotNullParameter(r103, "dynamic");
        ResourceLoaderService r104 = LynxTemplatePreLoader.f257257a;
        LynxTemplatePreLoader.e(r101, r102, r103, 0);
    }

    public static void h(Map r100, CubeConfig r101, CubeCreateThreadStrategy r102, CubeCreateThreadStrategy r103, Function2 r104) {
        Intrinsics.checkNotNullParameter(r100, "cardInfo");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "createThreadStrategy");
        Intrinsics.checkNotNullParameter(r103, "loadThreadStrategy");
        CubeDelegateManager.f(r101, r100, r102, r103, r104);
    }

    public static void a(String r100, boolean r110, FileLoadOptions r111, TemplateBundleBuildOptions r112, boolean r113, int r114) {
        if ((r114 & 4) == 0) goto L5;
        r111 = new FileLoadOptions(false, false, 3, null);
    L5:
        FileLoadOptions r101 = r111;
        if ((r114 & 8) == 0) goto L8;
        TemplateBundleBuildOptions r102 = null;
    L10:
        if ((r114 & 16) == 0) goto L12;
        boolean r103 = false;
    L13:
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "fileLoadOptions");
        LynxTemplateDecodeImpl.INSTANCE.cacheTemplateBundleByUrl(r100, r110, r101, r102, r103);
        return;
    L12:
        r103 = r113;
        goto L13
    L8:
        r102 = r112;
        goto L10
    }

    public static void e(CubeConfig r100, int r110, CubeCreateThreadStrategy r111, Function2 r112, Function0 r113, int r114) {
        if ((r114 & 2) == 0) goto L5;
        int r101 = 1;
    L7:
        if ((r114 & 4) == 0) goto L9;
        r111 = CubeCreateThreadStrategy.ON_CALLER_THREAD;
    L9:
        CubeCreateThreadStrategy r102 = r111;
        if ((r114 & 8) == 0) goto L12;
        Function2 r103 = null;
    L14:
        if ((r114 & 16) == 0) goto L16;
        Function0 r104 = null;
    L17:
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r102, "createThreadStrategy");
        CubeDelegateManager.e(r100, r101, null, r102, r102, r103, false, r104, 64);
        return;
    L16:
        r104 = r113;
        goto L17
    L12:
        r103 = r112;
        goto L14
    L5:
        r101 = r110;
        goto L7
    }

    public static void f(List r110, CubeConfig r111, CubeCreateThreadStrategy r112, CubeCreateThreadStrategy r113, Function2 r114, boolean r115) {
        Intrinsics.checkNotNullParameter(r110, "schemas");
        Intrinsics.checkNotNullParameter(r111, "config");
        Intrinsics.checkNotNullParameter(r112, "createThreadStrategy");
        Intrinsics.checkNotNullParameter(r113, "loadThreadStrategy");
        CubeDelegateManager.e(r111, 0, r110, r112, r113, r114, r115, null, 128);
    }
}
