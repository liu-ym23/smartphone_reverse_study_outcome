package com.ss.android.ugc.aweme.search.common.base.log;

import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostLogService;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/base/log/Logger;", "", "<init>", "()V", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f451499a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f451500b = null;

    private Logger() {
    }

    static {
        f451499a = new Logger();
        f451500b = LazyKt.lazy(Logger$isDebug$2.INSTANCE);
    }

    @JvmStatic
    public static final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "log");
        f451499a.getClass();
        if (((Boolean) f451500b.getValue()).booleanValue() == false) goto L10;
        ITradeSearchHostService r101 = TradeSearch.c(TradeSearch.f453393a);
        if (r101 == null) goto L11;
        ITradeSearchHostLogService r102 = r101.getITradeSearchHostLogService();
        if (r102 == null) goto L12;
        r102.w("ECSearchMarketingImpl", r100);
        return;
    L12:
        return;
    L11:
        return;
    }

    @JvmStatic
    public static final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "log");
        f451499a.getClass();
        if (((Boolean) f451500b.getValue()).booleanValue() == false) goto L10;
        ITradeSearchHostService r102 = TradeSearch.c(TradeSearch.f453393a);
        if (r102 == null) goto L11;
        ITradeSearchHostLogService r103 = r102.getITradeSearchHostLogService();
        if (r103 == null) goto L12;
        r103.d(r100, r101);
        return;
    L12:
        return;
    L11:
        return;
    }

    @JvmStatic
    public static final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "log");
        ITradeSearchHostService r102 = TradeSearch.c(TradeSearch.f453393a);
        if (r102 == null) goto L8;
        ITradeSearchHostLogService r103 = r102.getITradeSearchHostLogService();
        if (r103 == null) goto L9;
        r103.e(r100, r101);
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "log");
        f451499a.getClass();
        if (((Boolean) f451500b.getValue()).booleanValue() == false) goto L10;
        ITradeSearchHostService r102 = TradeSearch.c(TradeSearch.f453393a);
        if (r102 == null) goto L11;
        ITradeSearchHostLogService r103 = r102.getITradeSearchHostLogService();
        if (r103 == null) goto L12;
        r103.i(r100, r101);
        return;
    L12:
        return;
    L11:
        return;
    }

    @JvmStatic
    public static final void c(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r101, "log");
        Intrinsics.checkNotNullParameter(r102, "e");
        ITradeSearchHostService r103 = TradeSearch.c(TradeSearch.f453393a);
        if (r103 == null) goto L8;
        ITradeSearchHostLogService r104 = r103.getITradeSearchHostLogService();
        if (r104 == null) goto L9;
        r104.e(r100, r101, r102);
        return;
    L9:
        return;
    }
}
