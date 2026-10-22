package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper;

import com.bytedance.awemeopen.apps.framework.utils.AosPreloadHelper;
import com.bytedance.awemeopen.domain.feed.preload.AosPreloadCacheStrategy;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class RecommendFirstBrushDataHelper {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(final String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, AosPreloadCacheStrategy r22, final w24.a r23, boolean r24, final Function1 r25) {
        Intrinsics.checkNotNullParameter(r22, "cacheStrategy");
        Intrinsics.checkNotNullParameter(r25, "callBack");
        Function1<List<r14.c>, Unit> r12 = new RecommendFirstBrushDataHelper$packageFirstBrushData$callBackWrap$1(r13, r23, r25);
        AosPreloadHelper r0 = AosPreloadHelper.a;
        Intrinsics.checkNotNullParameter(r22, "cacheStragy");
        Intrinsics.checkNotNullParameter(r12, "callBack");
        AosPreloadHelper.b.u0(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r24, r12);
    }
}
