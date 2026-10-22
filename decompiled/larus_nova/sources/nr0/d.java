package nr0;

import com.bytedance.android.live.profit.lottery.LotteryState;
import com.bytedance.android.live.profit.lottery.ParticipateStatus;
import com.bytedance.android.live.profit.lottery.i;
import com.bytedance.android.live.profit.lottery.l;
import com.bytedance.android.live.profit.lottery.t;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f520158a;

    public d(i r100) {
        this.f520158a = r100;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        Intrinsics.checkNotNullParameter((ParticipateStatus) r100, "it");
        com.bytedance.android.live.profit.lottery.g r101 = this.f520158a.getCurrentLottery().getValue();
        if (r101 == null) goto L11;
        LotteryState r102 = r101.getState();
        if (r102 == null) goto L11;
        t r103 = l.a(r102);
        if (r103 == null) goto L11;
        if (r103.f88197d != 52) goto L11;
        return true;
    L11:
        return false;
    }
}
