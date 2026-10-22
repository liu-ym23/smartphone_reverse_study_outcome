package com.ss.android.ugc.aweme.search.common.helper;

import com.ss.android.ugc.aweme.search.common.ICommonSearchViewHolderFactory;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.common.mob.ECSearchCardUnKnownEvent;
import com.ss.android.ugc.aweme.search.common.saas.ECSearchSaaSDepsHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/helper/ECSearchAdapterHelper;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchAdapterHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, ICommonSearchViewHolderFactory> f451620a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ECSearchAdapterHelper f451621b = null;

    private ECSearchAdapterHelper() {
    }

    static {
        f451621b = new ECSearchAdapterHelper();
        f451620a = new LinkedHashMap();
    }

    public static ICommonSearchViewHolderFactory a(int r100) {
        Map<Integer, ICommonSearchViewHolderFactory> r101 = f451620a;
        if (r101.isEmpty() == false) goto L5;
        Logger.b("SaaSDebug", "viewHolderFactory map is empty, re register view holder");
        ECSearchCardUnKnownEvent r102 = new ECSearchCardUnKnownEvent();
        r102.e(3001);
        r102.d();
        ECSearchSaaSDepsHelper.f451981a.getClass();
        ECSearchSaaSDepsHelper.c();
    L5:
        Logger.a("SaaSDebug", "getViewHolderFactory itemType = " + r100);
        return (ICommonSearchViewHolderFactory) ((LinkedHashMap) r101).get(Integer.valueOf(r100));
    }

    public static void b(ICommonSearchViewHolderFactory r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        Map<Integer, ICommonSearchViewHolderFactory> r102 = f451620a;     // Catch: Throwable -> L8
        if (r102.containsKey(Integer.valueOf(r100.getItemType())) == true) goto L6;
        Logger.a("SaaSDebug", "registerViewHolderFactory holder itemLType = " + r100.getItemType());     // Catch: Throwable -> L8
        r102.put(Integer.valueOf(r100.getItemType()), r100);     // Catch: Throwable -> L8
    L6:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
