package com.ss.android.ugc.aweme.search.vision.crop.util;

import android.graphics.RectF;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/crop/util/CropWindowUtil;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CropWindowUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CropWindowUtil f453553a = null;

    private CropWindowUtil() {
    }

    static {
        f453553a = new CropWindowUtil();
    }

    public static RectF a(String r100, int r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, "detection");
        RectF r102 = new RectF();
        List r103 = StringsKt.split$default(r100, new String[]{","}, false, 0, 6, null);     // Catch: Exception -> L5
        float r104 = CastFloatProtector.parseFloat((String) ListProtector.get(r103, 0));     // Catch: Exception -> L5
        float r105 = CastFloatProtector.parseFloat((String) ListProtector.get(r103, 1));     // Catch: Exception -> L5
        float r106 = CastFloatProtector.parseFloat((String) ListProtector.get(r103, 2));     // Catch: Exception -> L5
        float r107 = r101;
        float r111 = r110;
        float r108 = CastFloatProtector.parseFloat((String) ListProtector.get(r103, 3)) * r111;     // Catch: Exception -> L5
        r102.left = r104 * r107;     // Catch: Exception -> L5
        r102.top = r105 * r111;     // Catch: Exception -> L5
        r102.right = r106 * r107;     // Catch: Exception -> L5
        r102.bottom = r108;     // Catch: Exception -> L5
    L6:
        return r102;
    L5:
        r102.left = 0.0f;
        r102.top = 0.0f;
        r102.right = 0.0f;
        r102.bottom = 0.0f;
        goto L6
    }
}
