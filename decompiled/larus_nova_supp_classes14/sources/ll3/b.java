package ll3;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final void a(kl3.a r3, String r4, String r5, com.bytedance.kmp.ec.yata.event.core.a r6) {
        Intrinsics.checkNotNullParameter(r3, "abilities");
        Intrinsics.checkNotNullParameter(r4, "selfEventName");
        Intrinsics.checkNotNullParameter(r5, "message");
        Intrinsics.checkNotNullParameter(r6, "eventInput");
        r3.a().a("yata_business_sdk_error", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "self_event_error"), TuplesKt.to("message", r5), TuplesKt.to("event_name", r4)}));
    }
}
