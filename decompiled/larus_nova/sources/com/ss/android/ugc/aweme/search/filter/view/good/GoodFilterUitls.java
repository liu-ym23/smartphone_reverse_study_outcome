package com.ss.android.ugc.aweme.search.filter.view.good;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.filter.utils.ECSearchCommodityThemeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/good/GoodFilterUitls;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GoodFilterUitls {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GoodFilterUitls f453241a = null;

    private GoodFilterUitls() {
    }

    static {
        f453241a = new GoodFilterUitls();
    }

    public static boolean b(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.equals("c_slide_filter") != true) goto L6;
        return true;
    }

    public static int a(Context r100, Integer r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == null) goto L7;
        return ECSearchCommodityThemeHelper.b(ECSearchCommodityThemeHelper.f452965b, r100, r102, r101.intValue());
    L7:
        return ContextCompat.getColor(r100, r102);
    L8:
        return 0;
    }
}
