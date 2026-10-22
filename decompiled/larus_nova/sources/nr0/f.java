package nr0;

import com.bytedance.android.live.profit.lottery.LotteryState;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f520160a = null;

    static {
        f520160a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        JSONObject r101 = (JSONObject) r100;
        Object r102 = r101.opt("scene");
        if ((r102 instanceof LotteryState.b) == true) goto L5;
        r102 = null;
    L5:
        LotteryState.b r103 = (LotteryState.b) r102;
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.f88024a.f88197d != 52) goto L12;
        CompositeDisposable r104 = h.f520161a;
        h.f520164d = r101.optString("schema");
        return;
    }
}
