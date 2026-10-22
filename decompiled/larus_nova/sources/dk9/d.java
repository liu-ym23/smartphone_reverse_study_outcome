package dk9;

import android.util.Pair;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements ik7.g {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @Override // ik7.g
    public final Pair getRequestTagHeader() {
        FLogger r100 = FLogger.f375446a;
        r100.i("LuckyDogTagHeaderConfig", "getRequestTagHeader, isAuto: true");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Pair<String, String> r102 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new e());     // Catch: Throwable -> L5
        r100.i("LuckyDogTagHeaderConfig", "innerGetTag, ret: " + r102);     // Catch: Throwable -> L5
        return r102;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Throwable r104 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r104 == null) goto L9;
        FLogger.f375446a.e("LuckyDogTagHeaderConfig", "innerGetTag failed", r104);
    L9:
        return null;
    }
}
