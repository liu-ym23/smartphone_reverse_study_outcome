package sd2;

import com.bytedance.android.live.ktv.common.model.api.l;
import com.bytedance.android.live.ktv.common.model.api.w0;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f541441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f541442b;

    public h(long r100, Function1 r101) {
        this.f541441a = r100;
        this.f541442b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        JSONObject r102 = new JSONObject();
        List<w0> r103 = ((l) r101.data).c();
        if (r103 == null) goto L5;
        int r104 = r103.size();
    L6:
        r102.put("count", r104);
        pd2.d.f528658n.j(LinkMonitorData.ApiGetOrderedSongList, System.currentTimeMillis() - this.f541441a, r101.logId, r102);
        this.f541442b.invoke(r101);
        return;
    L5:
        r104 = 0;
        goto L6
    }
}
