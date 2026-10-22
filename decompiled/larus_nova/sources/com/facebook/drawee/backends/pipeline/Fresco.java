package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.components.DraweeAsyncConfig;
import com.facebook.drawee.controller.IAbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.core.IImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imageutils.FrescoSoLoader;
import com.fackbook.drawee.DefaultDraweeConfig;
import javax.annotation.Nullable;
import kotlin.Lazy;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public class Fresco {
    private static final Class<?> TAG = null;
    private static boolean sCanReInitialize;
    private static PipelineDraweeControllerBuilderSupplier sDraweeControllerBuilderSupplier;
    private static IAbstractDraweeControllerBuilder sIDraweeControllerBuilderSupplier;
    private static volatile boolean sIsInitialized;
    private static volatile boolean sIsLazyInit;

    private Fresco() {
    }

    public static void shutDown() {
        sDraweeControllerBuilderSupplier = null;
        SimpleDraweeView.shutDown();
        ImagePipelineFactory.shutDown();
    }

    static {
        TAG = Fresco.class;
        sIsInitialized = false;
        sIsLazyInit = false;
        sCanReInitialize = true;
    }

    private static void tryInitDraweeControllerBuilderSupplier() {
        if (sDraweeControllerBuilderSupplier != null) goto L8;
        DefaultDraweeConfig.f274112c.getClass();
        Lazy r100 = DefaultDraweeConfig.f274111b;
        KProperty[] r101 = DefaultDraweeConfig.f274110a;
        KProperty r102 = r101[0];
        if (((Supplier) r100.getValue()) == null) goto L8;
        KProperty r103 = r101[0];
        sDraweeControllerBuilderSupplier = (PipelineDraweeControllerBuilderSupplier) ((Supplier) r100.getValue());
    L8:
        if (sDraweeControllerBuilderSupplier != null) goto L13;
        IAbstractDraweeControllerBuilder r104 = sIDraweeControllerBuilderSupplier;
        if (r104 == null) goto L14;
        sDraweeControllerBuilderSupplier = (PipelineDraweeControllerBuilderSupplier) r104.getAbstractDraweeControllerBuilder();
        return;
    L14:
        return;
    }

    public static boolean getAsyncAttachEnabled() {
        return DraweeAsyncConfig.isAttachEnabled();
    }

    public static boolean getAsyncRequestEnabled() {
        return DraweeAsyncConfig.isRequestEnabled();
    }

    public static PipelineDraweeControllerBuilderSupplier getDraweeControllerBuilderSupplier() {
        tryInitDraweeControllerBuilderSupplier();
        return sDraweeControllerBuilderSupplier;
    }

    public static ImagePipeline getImagePipeline() {
        return getImagePipelineFactory().getImagePipeline();
    }

    public static ImagePipelineFactory getImagePipelineFactory() {
        return ImagePipelineFactory.getInstance();
    }

    public static boolean hasBeenInitialized() {
        if (isLazyInit() == false) goto L7;
        return sIsLazyInit;
    L7:
        return sIsInitialized;
    }

    public static PipelineDraweeControllerBuilder newDraweeControllerBuilder() {
        tryInitDraweeControllerBuilderSupplier();
        return sDraweeControllerBuilderSupplier.get();
    }

    public static boolean isLazyInit() {
        return sIsLazyInit;
    }

    public static void initialize(Context r100) {
        initialize(r100, null, null);
    }

    public static void setAsyncAttachEnabled(boolean r100) {
        DraweeAsyncConfig.setAttachEnabled(r100);
    }

    public static void setAsyncRequestEnabled(boolean r100) {
        DraweeAsyncConfig.setRequestEnabled(r100);
    }

    public static void setCanReInitialize(boolean r100) {
        sCanReInitialize = r100;
    }

    public static void setIsLazyInit(boolean r100) {
        sIsLazyInit = r100;
        ImagePipelineConfig.sIsLazyInit = r100;
    }

    public static /* synthetic */ PipelineDraweeControllerBuilderSupplier access$000(Context r100, DraweeConfig r101) {
        return createControllerBuilderSupplier(r100, r101);
    }

    private static PipelineDraweeControllerBuilderSupplier createControllerBuilderSupplier(Context r100, @Nullable DraweeConfig r101) {
        if (DraweeAsyncConfig.isRequestEnabled() == true) goto L10;
        if (DraweeAsyncConfig.isAttachEnabled() == true) goto L10;
        return new PipelineDraweeControllerBuilderSupplier(r100, r101);
    L10:
        return new AsyncPipelineDraweeControllerBuilderSupplier(r100, r101);
    }

    public static void initialize(Context r100, @Nullable IImagePipelineConfig r101) {
        initialize(r100, r101, null, null);
    }

    private static void initializeDrawee(final Context r100, @Nullable final DraweeConfig r101) {
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("Fresco.initializeDrawee");
    L5:
        IAbstractDraweeControllerBuilder r102 = new AnonymousClass1(r100, r101);
        sIDraweeControllerBuilderSupplier = r102;
        SimpleDraweeView.initialize(r102);
        if (FrescoSystrace.isTracing() == false) goto L9;
        FrescoSystrace.endSection();
        return;
    }

    public static void initialize(Context r100, @Nullable ImagePipelineConfig r101) {
        initialize(r100, r101, null);
    }

    public static void initialize(Context r100, @Nullable ImagePipelineConfig r101, @Nullable DraweeConfig r102) {
        if (FrescoSystrace.isTracing() == false) goto L6;
        FrescoSystrace.beginSection("Fresco#initialize");
    L6:
        if (sIsLazyInit == false) goto L10;
        FLog.d(TAG, "I will not continue initialization，Because lazy loading is set up");
        return;
    L10:
        if (sIsInitialized == false) goto L17;
        FLog.e(TAG, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        if (sCanReInitialize == false) goto L14;
    L37:
    L25:
        e = move-exception;
        FLog.w(TAG, e, "Could not initialize SoLoader", new Object[0]);
        if (FrescoSystrace.isTracing() == false) goto L29;
        FrescoSystrace.endSection();
    L29:
        Context r103 = r100.getApplicationContext();
        if (r101 != null) goto L32;
        ImagePipelineFactory.initialize(r103);
    L33:
        initializeDrawee(r103, r102);
        if (FrescoSystrace.isTracing() == false) goto L40;
        FrescoSystrace.endSection();
        return;
    L40:
        return;
    L32:
        ImagePipelineFactory.initialize(r101);
        getImagePipelineFactory().setSplitMemCache(FrescoCacheMonitorUtil.isSplitMemCache());
        getImagePipelineFactory().setEnableSingleCache(FrescoCacheMonitorUtil.isEnableSingleCache());
        getImagePipelineFactory().setEnableBigImgCache(FrescoCacheMonitorUtil.isEnableBigImgCache());
        getImagePipelineFactory().setBigImgSizeLimit(FrescoCacheMonitorUtil.getBigImgSizeLimit());
        getImagePipelineFactory().setSplitPrefetchCache(FrescoCacheMonitorUtil.isSplitPrefetchCache());
        getImagePipelineFactory().setNewLocalVideoThumbnailOptEnabled(FrescoCacheMonitorUtil.isNewLocalVideoThumbnailOptEnabled());
        goto L33
    L19:
        if (FrescoSystrace.isTracing() == false) goto L21;
        FrescoSystrace.beginSection("Fresco.initialize->SoLoader.init");     // Catch: Exception -> L25
    L21:
        FrescoSoLoader.initSoLoader(r100);     // Catch: Exception -> L25
        if (FrescoSystrace.isTracing() == false) goto L29;
        FrescoSystrace.endSection();     // Catch: Exception -> L25
        goto L29
    L14:
        if (FrescoSystrace.isTracing() == false) goto L39;
        FrescoSystrace.endSection();
        return;
    L39:
        return;
    L17:
        sIsInitialized = true;
        goto L37
    }

    public static void initialize(Context r100, @Nullable IImagePipelineConfig r101, @Nullable DraweeConfig r102, @Nullable Boolean r103) {
        if (FrescoSystrace.isTracing() == false) goto L6;
        FrescoSystrace.beginSection("Fresco#initialize");
    L6:
        if (sIsLazyInit == false) goto L10;
        FLog.d(TAG, "I will not continue initialization，Because lazy loading is set up");
        return;
    L10:
        if (sIsInitialized == false) goto L12;
        FLog.w(TAG, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
    L35:
    L20:
        e = move-exception;
        FLog.w(TAG, e, "Could not initialize SoLoader", new Object[0]);
        if (FrescoSystrace.isTracing() == false) goto L24;
        FrescoSystrace.endSection();
    L24:
        Context r104 = r100.getApplicationContext();
        if (r101 != null) goto L27;
        ImagePipelineFactory.initialize(r104);
    L28:
        initializeDrawee(r104, r102);
        if (Boolean.TRUE.equals(r103) == false) goto L32;
        tryInitDraweeControllerBuilderSupplier();
    L32:
        if (FrescoSystrace.isTracing() == false) goto L37;
        FrescoSystrace.endSection();
        return;
    L37:
        return;
    L27:
        ImagePipelineFactory.initialize(r101, r103);
        getImagePipelineFactory().setSplitMemCache(FrescoCacheMonitorUtil.isSplitMemCache());
        getImagePipelineFactory().setEnableSingleCache(FrescoCacheMonitorUtil.isEnableSingleCache());
        getImagePipelineFactory().setEnableBigImgCache(FrescoCacheMonitorUtil.isEnableBigImgCache());
        getImagePipelineFactory().setBigImgSizeLimit(FrescoCacheMonitorUtil.getBigImgSizeLimit());
        getImagePipelineFactory().setSplitPrefetchCache(FrescoCacheMonitorUtil.isSplitPrefetchCache());
        getImagePipelineFactory().setNewLocalVideoThumbnailOptEnabled(FrescoCacheMonitorUtil.isNewLocalVideoThumbnailOptEnabled());
        goto L28
    L14:
        if (FrescoSystrace.isTracing() == false) goto L16;
        FrescoSystrace.beginSection("Fresco.initialize->SoLoader.init");     // Catch: Exception -> L20
    L16:
        FrescoSoLoader.initSoLoader(r100);     // Catch: Exception -> L20
        if (FrescoSystrace.isTracing() == false) goto L24;
        FrescoSystrace.endSection();     // Catch: Exception -> L20
        goto L24
    L12:
        sIsInitialized = true;
        goto L35
    }
}
