package ic3;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.shopping.commentv3.action.ActionType;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends hc3.a<fc3.b> {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public a() {
        }

        public static void a(fc3.a r7, String r8, String r9, Map r10, String r11, View r12, int r13) {
            int r0 = e.a;
            if ((r13 & 16) == 0) goto L5;
            boolean r1 = true;
        L7:
            if ((r13 & 64) == 0) goto L10;
            r11 = "";
        L10:
            if ((r13 & 128) == 0) goto L12;
            r12 = null;
        L12:
            Intrinsics.checkNotNullParameter(r8, "event");
            Intrinsics.checkNotNullParameter(r9, "entranceType");
            Intrinsics.checkNotNullParameter(r10, "params");
            Intrinsics.checkNotNullParameter(r11, "btmId");
            r10.put("entrance_type", r9);
            SlcCommonAction r14 = new SlcCommonAction(ActionType.TRACKER.getType(), MapsKt.mapOf(new Pair[]{TuplesKt.to("event_name", r8), TuplesKt.to("params", r10), TuplesKt.to("allow_duplicate", Boolean.valueOf(r1)), TuplesKt.to("report_type", 0), TuplesKt.to("btm_id", r11)}));
            if (r7 == null) goto L16;
            r7.a(new fc3.c(r14, r12, null, 12));
            return;
        L16:
            return;
        L5:
            r1 = false;
            goto L7
        }
    }

    static {
        new a();
    }
}
