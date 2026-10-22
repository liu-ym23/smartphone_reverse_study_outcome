package ic3;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.shopping.commentv3.action.ActionType;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e extends hc3.a<fc3.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f489165a = 0;

    public static final class a {
        public a() {
        }

        public static void a(fc3.a r100, String r101, String r102, Map r110, String r111, View r112, int r113) {
            int r103 = e.f489165a;
            if ((r113 & 16) == 0) goto L5;
            boolean r104 = true;
        L7:
            if ((r113 & 64) == 0) goto L10;
            r111 = "";
        L10:
            if ((r113 & 128) == 0) goto L12;
            r112 = null;
        L12:
            Intrinsics.checkNotNullParameter(r101, "event");
            Intrinsics.checkNotNullParameter(r102, "entranceType");
            Intrinsics.checkNotNullParameter(r110, "params");
            Intrinsics.checkNotNullParameter(r111, "btmId");
            r110.put(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE, r102);
            SlcCommonAction r105 = new SlcCommonAction(ActionType.TRACKER.getType(), MapsKt.mapOf(new Pair[]{TuplesKt.to(ReportCardMonitorPlugin.EVENT_NAME, r101), TuplesKt.to("params", r110), TuplesKt.to("allow_duplicate", Boolean.valueOf(r104)), TuplesKt.to("report_type", 0), TuplesKt.to("btm_id", r111)}));
            if (r100 == null) goto L16;
            r100.a(new fc3.c(r105, r112, null, 12));
            return;
        L16:
            return;
        L5:
            r104 = false;
            goto L7
        }
    }

    static {
        new a();
    }
}
