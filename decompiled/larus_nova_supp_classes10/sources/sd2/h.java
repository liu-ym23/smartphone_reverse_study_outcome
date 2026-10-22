package sd2;

import com.bytedance.android.live.ktv.common.model.api.l;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ Function1 b;

    public h(long r1, Function1 r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void accept(Object r9) {
        com.bytedance.android.live.network.response.e r10 = (com.bytedance.android.live.network.response.e) r9;
        JSONObject r5 = new JSONObject();
        List r0 = ((l) ((ExtraResponse) r10).data).c();
        if (r0 == null) goto L5;
        int r1 = r0.size();
    L6:
        r5.put("count", r1);
        pd2.d.n.j(LinkMonitorData.ApiGetOrderedSongList, System.currentTimeMillis() - this.a, ((ExtraResponse) r10).logId, r5);
        this.b.invoke(r10);
        return;
    L5:
        r1 = 0;
        goto L6
    }
}
