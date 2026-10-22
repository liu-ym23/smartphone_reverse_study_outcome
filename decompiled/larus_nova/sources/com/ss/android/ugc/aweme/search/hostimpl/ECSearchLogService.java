package com.ss.android.ugc.aweme.search.hostimpl;

import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostLogService;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ps3.b;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/hostimpl/ECSearchLogService;", "Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchHostLogService;", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchLogService implements ITradeSearchHostLogService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECSearchLogService f453271a = null;

    private ECSearchLogService() {
    }

    static {
        f453271a = new ECSearchLogService();
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostLogService
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "log");
        b.a(new String[]{r101});
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostLogService
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "log");
        b.a(new String[]{r101});
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostLogService
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "log");
        b.a(new String[]{r101});
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostLogService
    public final void v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "log");
        b.a(new String[]{r101});
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostLogService
    public final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "log");
        b.a(new String[]{r101});
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostLogService
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r101, "log");
        Intrinsics.checkNotNullParameter(r102, "e");
        b.a(new String[]{r101 + "\nstackTrace:\n:" + ExceptionsKt.stackTraceToString(r102)});
    }
}
