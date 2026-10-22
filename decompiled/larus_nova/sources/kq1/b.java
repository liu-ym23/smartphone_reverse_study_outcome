package kq1;

import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayPaidInfo;
import com.bytedance.android.livesdkapi.replay.paid.PaidReplayScene;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes8.dex */
public interface b {
    MutableLiveData<Integer> a();

    void b(FrameLayout r100, ReplayPaidInfo r101, @PaidReplayScene String r102, Map<String, String> r103, vlc.d r104, boolean r105);

    long c(long r100);

    MutableLiveData<Long> getReplayPaidCountDown();

    void release();

    void setOnBuyTicketAction(Function0<Unit> r100);
}
