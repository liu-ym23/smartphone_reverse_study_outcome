package nr0;

import com.bytedance.android.live.profit.lottery.LotteryState;
import com.bytedance.android.live.profit.lottery.ParticipateStatus;
import com.bytedance.android.live.profit.lottery.i;
import com.bytedance.android.live.profit.lottery.l;
import com.bytedance.android.live.profit.lottery.t;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f520159a;

    public e(i r100) {
        this.f520159a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((ParticipateStatus) r100) != ParticipateStatus.PARTICIPATEINSUCCESS) goto L5;
        CompositeDisposable r101 = h.f520161a;
        h.d("participate_success", null);
    L5:
        com.bytedance.android.live.profit.lottery.g r102 = this.f520159a.getCurrentLottery().getValue();
        if (r102 == null) goto L13;
        LotteryState r103 = r102.getState();
        if (r103 == null) goto L14;
        t r104 = l.a(r103);
        if (r104 == null) goto L15;
        h.a(r104.f88194a, false, true);
        return;
    L15:
        return;
    L14:
        return;
    }
}
