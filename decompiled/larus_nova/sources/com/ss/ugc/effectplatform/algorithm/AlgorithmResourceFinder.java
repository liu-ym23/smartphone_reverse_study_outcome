package com.ss.ugc.effectplatform.algorithm;

import bytekn.foundation.logger.Logger;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel;
import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;
import com.ss.ugc.effectplatform.task.x0;
import com.ss.ugc.effectplatform.util.k;
import com.ss.ugc.effectplatform.util.r;
import com.ss.ugc.effectplatform.util.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 $2\u00020\u0001:\u0001%B!\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\"\u0010#J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0014J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0002H\u0014J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/ss/ugc/effectplatform/algorithm/AlgorithmResourceFinder;", "", "", "nameStr", "", "businessId", "modelUri", "", "checkModelMd5", "findResourceUri", MapBundleKey.MapObjKey.OBJ_DIR, "realFindResourceUri", "isResourceAvailable", "", "markModelUsed", "isExactBuiltInResource", "getBuiltInResourceUrl", "modelName", "errorMessage", "onModelNotFound", "onModelFound", "filePath", "readAssetFileAsString", "", "getEffectHandle", "Lcom/ss/ugc/effectplatform/cache/a;", "algorithmModelCache", "Lcom/ss/ugc/effectplatform/cache/a;", "Lcom/ss/ugc/effectplatform/algorithm/d;", "buildInAssetsManager", "Lcom/ss/ugc/effectplatform/algorithm/d;", "Lhlc/e;", "eventListener", "Lhlc/e;", "<init>", "(Lcom/ss/ugc/effectplatform/cache/a;Lcom/ss/ugc/effectplatform/algorithm/d;Lhlc/e;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public class AlgorithmResourceFinder {
    public static final a Companion = null;
    public static final String MD5_ERROR = "asset://md5_error";
    public static final String NOT_FOUND = "asset://not_found";
    public static final String RESOURCE_MANAGER_NOT_INITIALIZED = "asset://not_initialized";
    public static final String TAG = "AlgorithmResourceFinder";
    private final com.ss.ugc.effectplatform.cache.a algorithmModelCache;
    private final d buildInAssetsManager;
    private final hlc.e eventListener;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public long getEffectHandle() {
        return 0;
    }

    public void onModelFound(String r100) {
    }

    public String findResourceUri(String r100) {
        String r101 = k.d(r100);
        com.ss.ugc.effectplatform.model.d r102 = this.algorithmModelCache.i(r101);
        if (r102 == null) goto L5;
        boolean r103 = true;
    L6:
        String r104 = null;
        if (r103 == false) goto L13;
        int r105 = t.f458048a;
        StringBuilder r106 = new StringBuilder(MSkiaImageRegionDecoder.FILE_PREFIX);
        if (r102 == null) goto L11;
        r104 = r102.f457422f;
    L11:
        r106.append(r104);
        return UriProtector.parse(r106.toString()).toString();
    L13:
        if (isExactBuiltInResource(r100) == true) goto L15;
        return null;
    L15:
        return getBuiltInResourceUrl(r100);
    L5:
        r103 = false;
        goto L6
    }

    public String getBuiltInResourceUrl(String r100) {
        d r101 = this.buildInAssetsManager;
        r101.getClass();
        return "asset://model/" + r101.a(r100);
    }

    public boolean isExactBuiltInResource(String r100) {
        return this.buildInAssetsManager.b(r100);
    }

    public final boolean isResourceAvailable(String r100) {
        String r101 = findResourceUri(r100);
        if (r101 != null) goto L5;
    L9:
        return false;
    L5:
        if ((!Intrinsics.areEqual(r101, MD5_ERROR)) == false) goto L9;
        if ((!Intrinsics.areEqual(r101, NOT_FOUND)) == false) goto L9;
        return true;
    }

    public final void markModelUsed(String r100) {
        this.algorithmModelCache.d(k.d(r100));
    }

    public final String readAssetFileAsString(String r100) {
        return this.buildInAssetsManager.f(r100);
    }

    public void onModelNotFound(String r100, String r101) {
        RuntimeException r102 = new RuntimeException("model not found neither in asset nor disk " + r101);
        hlc.e r103 = this.eventListener;
        if (r103 == null) goto L6;
        r103.onModelNotFound(null, r102);
        return;
    }

    public AlgorithmResourceFinder(com.ss.ugc.effectplatform.cache.a r100, d r101, hlc.e r102) {
        this.algorithmModelCache = r100;
        this.buildInAssetsManager = r101;
        this.eventListener = r102;
    }

    private final boolean checkModelMd5(String r110, int r111, String r112) {
        if (r112 != null) goto L5;
    L26:
        return false;
    L5:
        if (isExactBuiltInResource(r110) == true) goto L26;
        String r100 = k.d(r110);
        String r113 = k.b(r112);
        x0.f457978k.getClass();
        com.ss.ugc.effectplatform.model.c r101 = x0.b(x0.a.a(), r111);
        if (this.algorithmModelCache.f457267k.V == false) goto L9;
        String r102 = bytekn.foundation.utils.c.a(r100);
    L11:
        if (r101 != null) goto L27;
    L18:
        ExtendedUrlModel r114 = null;
    L19:
        if (r114 != null) goto L22;
        Logger.e$default(Logger.INSTANCE, TAG, "expected model info not found in model list - " + r110, null, 4, null);
        return false;
    L22:
        String r115 = r114.getUri();
        if (r.a(r113, r115) == true) goto L26;
        String r116 = r110 + " md5 = " + r113 + " expectedMd5 = " + r115;
        Logger.INSTANCE.d(TAG, "findResourceUri called with nameStr = [" + r110 + "], asset://md5_error\n" + r116);
        onModelNotFound(r100, r116);
        return true;
    L27:
        r114 = r101.a(r102);     // Catch: IllegalArgumentException -> L14
    L14:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "model info not found in model list", e);
        x0.f457978k.getClass();
        ModelInfo r117 = x0.a.a().d(r111, r102, true);
        if (r117 == null) goto L18;
        r114 = r117.getFile_url();
        goto L19
    L9:
        r102 = r100;
        goto L11
    }

    public final String realFindResourceUri(int r110, String r111, String r112) {
        Logger.INSTANCE.d(TAG, "findResourceUri() called with nameStr = [" + r112 + ']');
        String r100 = findResourceUri(r112);
        if (checkModelMd5(r112, r110, r100) == false) goto L9;
        return MD5_ERROR;
    L9:
        if (r100 != null) goto L12;
        Logger.e$default(Logger.INSTANCE, TAG, "findResourceUri called with nameStr = [" + r112 + "], returned result: [asset://not_found]", null, 4, null);
        return NOT_FOUND;
    L12:
        Logger.INSTANCE.d(TAG, "findResourceUri called with nameStr = [" + r112 + "], returned result: [" + r100 + ']');
        onModelFound(r112);
        return r100;
    L7:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "findResourceUri called with nameStr = [" + r112 + "], exception hanppens", e);
        goto L9
    }
}
