package zg2;

import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.live.datacontext.i;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import xg2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r4, String r5, Action r6, Map r7) {
        Intrinsics.checkNotNullParameter(r6, "action");
        Map r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("module", r6.getModule()), TuplesKt.to("action", r6.getAction())});
        if (r7 != null) goto L5;
        r7 = MapsKt.emptyMap();
    L5:
        r0.putAll(r7);
        int r8 = RoomContextController.h;
        ECContext r9 = RoomContextController.a.b(r4, r5).r();
        if (r9 == null) goto L13;
        i<yg2.a> r10 = r9.getEcLiveActionRecordService();
        if (r10 == null) goto L14;
        yg2.a r11 = (yg2.a) r10.getValue();
        if (r11 == null) goto L15;
        r11.d(new d(r6, r0));
        return;
    L15:
        return;
    L14:
        return;
    }
}
