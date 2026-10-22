package sd2;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import io.reactivex.functions.Consumer;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ Function1 b;

    public f(long r1, Function1 r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void accept(Object r10) {
        com.bytedance.android.live.network.response.e r11 = (com.bytedance.android.live.network.response.e) r10;
        com.bytedance.android.live.ktv.common.model.api.h r0 = (com.bytedance.android.live.ktv.common.model.api.h) ((ExtraResponse) r11).data;
        JSONObject r6 = new JSONObject();
        r6.put("count", r0.a().size());
        com.bytedance.android.live.ktv.common.model.api.h.a r1 = (com.bytedance.android.live.ktv.common.model.api.h.a) CollectionsKt.getOrNull(r0.a(), 0);
        if (r1 == null) goto L8;
        KtvMusic r2 = r1.b();
        if (r2 == null) goto L8;
        String r3 = r2.getMTitle();
        if (r3 == null) goto L8;
    L9:
        r6.put("first_music_title", r3);
        com.bytedance.android.live.ktv.common.model.api.h.a r4 = (com.bytedance.android.live.ktv.common.model.api.h.a) CollectionsKt.getOrNull(r0.a(), 0);
        if (r4 == null) goto L14;
        KtvMusic r5 = r4.b();
        if (r5 == null) goto L14;
        long r7 = r5.getMId();
    L15:
        r6.put("first_music_id", r7);
        pd2.d.n.j(LinkMonitorData.ApiGetOrderedSongList, System.currentTimeMillis() - this.a, ((ExtraResponse) r11).logId, r6);
        this.b.invoke(r11);
        return;
    L14:
        r7 = 0;
    L8:
        r3 = "";
        goto L9
    }
}
