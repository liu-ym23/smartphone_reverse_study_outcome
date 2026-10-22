package com.ss.android.ugc.aweme.search.filter.utils;

import android.content.Context;
import android.graphics.Color;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/utils/ECSearchParseHelper;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchParseHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECSearchParseHelper f452968a = null;

    private ECSearchParseHelper() {
    }

    static {
        f452968a = new ECSearchParseHelper();
    }

    public static int d(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ECSearchFilterRes.f452967b.getClass();
        return ECSearchFilterRes.a(r101);
    }

    public static int c(Context r100, int r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r102 == null) goto L8;
        return ECSearchCommodityThemeHelper.b(ECSearchCommodityThemeHelper.f452965b, r100, r101, r102.intValue());
    L11:
        return d(r100, r101);
    L8:
        return d(r100, r101);
    }

    public static int a(Context r100, String r101, int r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != null) goto L14;
        if (r103 != null) goto L16;
        ECSearchFilterRes.f452967b.getClass();
        return ECSearchFilterRes.a(r102);
    L16:
        return ECSearchCommodityThemeHelper.b(ECSearchCommodityThemeHelper.f452965b, r100, r102, r103.intValue());
    L14:
        return Color.parseColor(r101);
    L10:
        if (r103 != null) goto L17;
        ECSearchFilterRes.f452967b.getClass();
        return ECSearchFilterRes.a(r102);
    L17:
        return ECSearchCommodityThemeHelper.b(ECSearchCommodityThemeHelper.f452965b, r100, r102, r103.intValue());
    }

    public static /* synthetic */ int b(ECSearchParseHelper r100, Context r101, String r102, int r103) {
        r100.getClass();
        return a(r101, r102, r103, null);
    }
}
