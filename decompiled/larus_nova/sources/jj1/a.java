package jj1;

import android.os.Bundle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.room.b;
import com.bytedance.android.livesdk.room.c;
import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.bytedance.android.livesdk.utils.j5;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends c<ls2.c> {
    @Override // os2.a
    public final ls2.c d() {
        return null;
    }

    public a() {
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void f(b r110, ContainerLifecycle r111, ts2.a r112) {
        if (r111 != ContainerLifecycle.ON_VIEW_CREATE) goto L27;
        Bundle r113 = r110.f510497d;
        boolean r100 = r113.getBoolean("click_red_packet_from_preview", false);
        boolean r101 = r113.getBoolean("click_fans_red_packet_from_preview", false);
        long r102 = r113.getLong("click_red_packet_from_preview_id", 0);
        if (r110.f157610s == null) goto L11;
        if (r100 == false) goto L11;
        if (r102 == 0) goto L11;
        r113.remove("click_red_packet_from_preview");
        r113.remove("click_red_packet_from_preview_id");
        r110.f157610s.put("click_red_packet_from_preview", Boolean.valueOf(r100));
        r110.f157610s.put("click_red_packet_from_preview_id", Long.valueOf(r102));
    L11:
        if (r101 == false) goto L17;
        String r103 = r113.getString("click_fans_red_packet_from_preview_schema", "");
        if (r103.isEmpty() == true) goto L17;
        if (r110.f157610s == null) goto L17;
        r113.remove("click_fans_red_packet_from_preview");
        r113.remove("click_fans_red_packet_from_preview_schema");
        r110.f157610s.put("click_fans_red_packet_from_preview", Boolean.TRUE);
        r110.f157610s.put("click_fans_red_packet_from_preview_schema", r103);
    L17:
        int r104 = j5.f158998a;
        ALogger.i("PreviewLotteryEncode", "in func handleShortTermExtraData");
        boolean r105 = r113.getBoolean("click_lottery_from_preview");
        long r106 = r113.getLong("preview_lottery_id");
        String r114 = r113.getString("preview_extend_guide_text_function", "");
        ALogger.i("PreviewLotteryEncode", "clickLotteryFromPreview is " + r105 + "  previewLotteryId is " + r106);
        if (r110.f157610s == null) goto L27;
        if (r105 == false) goto L27;
        if (r106 == 0) goto L27;
        r113.remove("click_lottery_from_preview");
        r113.remove("preview_lottery_id");
        r110.f157610s.put("click_lottery_from_preview", Boolean.valueOf(r105));
        r110.f157610s.put("preview_lottery_id", Long.valueOf(r106));
        if (r114 == null) goto L27;
        if (r114.isEmpty() == true) goto L27;
        r113.remove("preview_extend_guide_text_function");
        r110.f157610s.put("preview_extend_guide_text_function", r114);
    L27:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
    }
}
