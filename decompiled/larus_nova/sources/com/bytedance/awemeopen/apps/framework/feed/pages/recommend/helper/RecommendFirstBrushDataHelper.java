package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper;

import com.bytedance.awemeopen.apps.framework.utils.AosPreloadHelper;
import com.bytedance.awemeopen.domain.feed.preload.AosPreloadCacheStrategy;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class RecommendFirstBrushDataHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f195062a = 0;

    static {
    }

    public static void a(final String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, String r211, AosPreloadCacheStrategy r212, final w24.a r213, boolean r214, final Function1 r215) {
        Intrinsics.checkNotNullParameter(r212, "cacheStrategy");
        Intrinsics.checkNotNullParameter(r215, "callBack");
        Function1<List<r14.c>, Unit> r117 = new RecommendFirstBrushDataHelper$packageFirstBrushData$callBackWrap$1(r110, r213, r215);
        AosPreloadHelper r100 = AosPreloadHelper.f197655a;
        Intrinsics.checkNotNullParameter(r212, "cacheStragy");
        Intrinsics.checkNotNullParameter(r117, "callBack");
        AosPreloadHelper.f197656b.u0(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, r214, r117);
    }
}
