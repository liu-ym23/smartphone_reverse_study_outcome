package com.larus.bmhome.view.actionbar.gaokao.network;

import com.larus.network.bean.BizResponse;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes26.dex */
public final class PreloadGaokaoProvinceConfHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PreloadGaokaoProvinceConfHelper f316793a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static BizResponse<GaokaoProvinceConfResponse> f316794b;

    static {
        f316793a = new PreloadGaokaoProvinceConfHelper();
    }

    public PreloadGaokaoProvinceConfHelper() {
    }

    public static void a(CoroutineScope r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        f316794b = null;
        BuildersKt.launch$default(r100, Dispatchers.getIO(), null, new PreloadGaokaoProvinceConfHelper$preloadGaokaoProvinceConf$1(null), 2, null);
    }

    public static Object b(Continuation r100) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PreloadGaokaoProvinceConfHelper$requestGaokaoProvinceConf$2(null), r100);
    }
}
