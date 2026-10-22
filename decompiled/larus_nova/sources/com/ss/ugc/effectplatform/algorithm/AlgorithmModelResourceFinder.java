package com.ss.ugc.effectplatform.algorithm;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ugc.effectplatform.EffectConfig;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001\"B)\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0011\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0082 J\u0006\u0010\u000b\u001a\u00020\bJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0014J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/ss/ugc/effectplatform/algorithm/AlgorithmModelResourceFinder;", "Lcom/ss/ugc/effectplatform/algorithm/AlgorithmResourceFinder;", "", "modelName", "", "mobModelFound", "errorMsg", "mobModelNotFound", "", "effectHandle", "nativeCreateResourceFinder", "getNativeResourceFinder", "nameStr", "", "isExactBuiltInResource", "getBuiltInResourceUrl", "errorMessage", "onModelNotFound", "onModelFound", "Lcom/ss/ugc/effectplatform/cache/a;", "algorithmModelCache", "Lcom/ss/ugc/effectplatform/cache/a;", "Lcom/ss/ugc/effectplatform/algorithm/d;", "buildInAssetsManager", "Lcom/ss/ugc/effectplatform/algorithm/d;", "Lhlc/e;", "eventListener", "Lhlc/e;", "Lcom/ss/ugc/effectplatform/EffectConfig;", "effectConfig", "Lcom/ss/ugc/effectplatform/EffectConfig;", "<init>", "(Lcom/ss/ugc/effectplatform/cache/a;Lcom/ss/ugc/effectplatform/algorithm/d;Lhlc/e;Lcom/ss/ugc/effectplatform/EffectConfig;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class AlgorithmModelResourceFinder extends AlgorithmResourceFinder {
    public static final a Companion = null;
    private static final String TAG = "ResourceFinder";
    private static final ConcurrentHashMap<String, Boolean> modelsNotFoundRecord = null;
    private final com.ss.ugc.effectplatform.cache.a algorithmModelCache;
    private final d buildInAssetsManager;
    private final EffectConfig effectConfig;
    private final hlc.e eventListener;

    public static final class a {
        public a() {
        }
    }

    private final native long nativeCreateResourceFinder(long r100);

    static {
        Companion = new a();
        modelsNotFoundRecord = new ConcurrentHashMap();
    }

    public final long getNativeResourceFinder() {
        b.f457241c.a();
        return nativeCreateResourceFinder(0);
    }

    private final void mobModelFound(String r100) {
        EffectConfig r101 = this.effectConfig;
        klc.a r102 = r101.f457176v.f1239a;
        if (r102 == null) goto L6;
        klc.b.j(r102, true, r101, r100, "");
        return;
    }

    @JvmStatic
    public static final void modelNotFound(String r100) {
        Companion.getClass();
        Logger.e$default(Logger.INSTANCE, TAG, "modelNotFound:nameStr=" + r100, null, 4, null);
        AlgorithmResourceManager.Companion.getInstance().getResourceFinder().onModelNotFound(r100, AlgorithmResourceFinder.NOT_FOUND);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.ugc.effectplatform.algorithm.AlgorithmResourceFinder
    public String getBuiltInResourceUrl(final String r100) {
        final d r101 = this.buildInAssetsManager;
        String r102 = r101.f457247c.get(r100);
        if (r102 != null) goto L11;
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        r103.element = "";
        r101.d(r100, new BuiltInResourceManager$getMappingModelUrlWithoutVersion$2(r101, r100, r103));
        if ((!StringsKt.isBlank((String) r103.element)) == true) goto L10;
        String r104 = "asset://model/" + r100;
        r101.f457247c.put(r100, r104);
        return r104;
    L10:
        return (String) r103.element;
    L11:
        return r102;
    }

    @Override // com.ss.ugc.effectplatform.algorithm.AlgorithmResourceFinder
    public boolean isExactBuiltInResource(final String r100) {
        final d r101 = this.buildInAssetsManager;
        Boolean r102 = r101.f457246b.get(r100);
        if (r102 != null) goto L25;
        boolean r103 = true;
        if (r101.d(r100, new BuiltInResourceManager$existMappingModelWithoutVersion$2(r101, r100)) == false) goto L8;
        return true;
    L8:
        String r104 = "model/" + r100;
        boolean r105 = false;
        if (r101.g(r104) == false) goto L23;
    L20:
        r101.f457246b.put(r100, Boolean.valueOf(r105));
        return r105;
    L23:
        bytekn.foundation.io.file.b r106 = r101.e(r104);     // Catch: Throwable -> L18 Exception -> L22
        if (r106 != null) goto L15;
        r103 = false;
    L15:
        if (r106 == null) goto L17;
        FileManager.b(r106);
    L17:
        r105 = r103;
        goto L20
    L18:
        th = move-exception;
        throw th;
    L25:
        return r102.booleanValue();
    }

    @Override // com.ss.ugc.effectplatform.algorithm.AlgorithmResourceFinder
    public void onModelFound(String r100) {
        mobModelFound(r100);
    }

    @JvmStatic
    public static final String findResourceUri(String r100, String r101) {
        Companion.getClass();
        AlgorithmResourceManager.Companion r102 = AlgorithmResourceManager.Companion;
        if (r102.isInitialized() == true) goto L5;
        return AlgorithmResourceFinder.RESOURCE_MANAGER_NOT_INITIALIZED;
    L5:
        int r103 = b0.a.f16820a;
        long r104 = System.currentTimeMillis();
        String r105 = r102.getInstance().getResourceFinder().realFindResourceUri(0, r100, r101);
        int r106 = e.f457252a;
        Logger.INSTANCE.d("checkEffect", "findResourceUri name: " + r101 + ", result: " + r105 + ", time cost: " + (System.currentTimeMillis() - r104) + " ms");
        return r105;
    }

    private final void mobModelNotFound(String r100, String r101) {
        ConcurrentHashMap<String, Boolean> r102 = modelsNotFoundRecord;
        if (r102.contains(r100) == false) goto L5;
        return;
    L5:
        r102.put(r100, Boolean.TRUE);
        EffectConfig r103 = this.effectConfig;
        klc.a r104 = r103.f457176v.f1239a;
        if (r104 == null) goto L9;
        klc.b.j(r104, false, r103, r100, r101);
        return;
    }

    @Override // com.ss.ugc.effectplatform.algorithm.AlgorithmResourceFinder
    public void onModelNotFound(String r100, String r101) {
        super.onModelNotFound(r100, r101);
        mobModelNotFound(r100, r101);
    }

    public AlgorithmModelResourceFinder(com.ss.ugc.effectplatform.cache.a r100, d r101, hlc.e r102, EffectConfig r103) {
        super(r100, r101, r102);
        this.algorithmModelCache = r100;
        this.buildInAssetsManager = r101;
        this.eventListener = r102;
        this.effectConfig = r103;
    }
}
