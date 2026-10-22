package ll3;

import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b {
    public static final void a(kl3.a r100, String r101, String r102, com.bytedance.kmp.ec.yata.event.core.a r103) {
        Intrinsics.checkNotNullParameter(r100, "abilities");
        Intrinsics.checkNotNullParameter(r101, "selfEventName");
        Intrinsics.checkNotNullParameter(r102, "message");
        Intrinsics.checkNotNullParameter(r103, "eventInput");
        r100.a().a("yata_business_sdk_error", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "self_event_error"), TuplesKt.to("message", r102), TuplesKt.to(ReportCardMonitorPlugin.EVENT_NAME, r101)}));
    }
}
