package com.ss.android.ugc.aweme.search.vision.result.v1.saas;

import android.content.Context;
import com.bytedance.common.utility.UIUtils;
import com.ss.android.ugc.aweme.search.utils.extensions.DimenExtensionsKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/v1/saas/PhotoUiUtilsSaaS;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoUiUtilsSaaS {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PhotoUiUtilsSaaS f454019a = null;

    private PhotoUiUtilsSaaS() {
    }

    static {
        f454019a = new PhotoUiUtilsSaaS();
    }

    public static int a(Context r100) {
        Integer r101 = ArraysKt.maxOrNull(new int[]{(((UIUtils.getScreenWidth(r100) - DimenExtensionsKt.b(32)) - (DimenExtensionsKt.b(12) * 2)) - 0) - DimenExtensionsKt.b(12), DimenExtensionsKt.b(167)});
        if (r101 == null) goto L6;
        return r101.intValue();
    L6:
        return DimenExtensionsKt.b(167);
    }
}
