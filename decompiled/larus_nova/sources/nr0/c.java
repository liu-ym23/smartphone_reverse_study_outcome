package nr0;

import com.android.ttcjpaysdk.base.weboffline.CJPayWebOfflineWorker;
import com.bytedance.android.live.profit.lottery.LotteryState;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f520157a = null;

    static {
        f520157a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        LotteryState r101 = (LotteryState) r100;
        if ((r101 instanceof LotteryState.b) == false) goto L13;
        CompositeDisposable r102 = h.f520161a;
        JSONObject r103 = new JSONObject();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L7
        Result.m9449constructorimpl(r103.put("is_participated", ((LotteryState.b) r101).f88025b.f88165a));     // Catch: Throwable -> L7
    L9:
        Unit r105 = Unit.INSTANCE;
        h.d(CJPayWebOfflineWorker.CJ_PAY_WEB_OFFLINE_FINISHED, r103);
        LotteryState.b r106 = (LotteryState.b) r101;
        h.a(r106.f88024a.f88194a, true, r106.f88025b.f88165a);
        return;
    L7:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }
}
