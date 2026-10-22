package rd2;

import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ Function1 b;

    public k(long r1, Function1 r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        mb0.c.a.a(pd2.d.n, LinkMonitorData.ApiGetSongWaitingList, System.currentTimeMillis() - this.a, r8);
        ExceptionUtils.handleException(s1.getContext(), r8);
        this.b.invoke(r8);
    }
}
