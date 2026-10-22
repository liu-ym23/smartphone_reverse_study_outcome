package com.bytedance.android.livesdk.livecommerce.actionrecord.consumer;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.actionrecord.event.EventType;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class TrackerConsumer implements a {
    public final Map<String, String> a;

    @Override // com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.a
    public final String a() {
        return "tracker";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.a
    public final Set<EventType> b() {
        return SetsKt.setOf(new EventType[]{EventType.RATE_START, EventType.RATE_SUCCESS, EventType.RATE_FAILURE, EventType.RATE_SINGLE});
    }

    public TrackerConsumer(Map<String, String> r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.a
    public final boolean c(vg2.a r18) {
        Intrinsics.checkNotNullParameter(r18, "event");
        String r1 = ECAppInfoService.e.getServerDeviceId();     // Catch: Exception -> L47
        if (r1 == null) goto L9;
        Long r2 = StringsKt.toLongOrNull(r1);     // Catch: Exception -> L47
        if (r2 == null) goto L9;
        long r3 = r2.longValue();     // Catch: Exception -> L47
    L10:
        long r4 = 10000;
        long r5 = r3 % 10000;
        String r6 = r18.d + '_' + r18.e;
        String r7 = r18.getType().toString();
        Map<String, String> r8 = EComABUtils.getArsTrackerSampling();
        Object r9 = r8.get("default_sampling_rate");
        if ((r9 instanceof Double) == true) goto L13;
        r9 = null;
    L13:
        Double r10 = (Double) r9;
        CharSequence r11 = r8.get("events");
        if ((r11 instanceof List) == true) goto L16;
        r11 = null;
    L16:
        List r12 = (List) r11;
        if (r12 == null) goto L36;
        Iterator r13 = r12.iterator();
    L20:
        if (r13.hasNext() == false) goto L36;
        Map r14 = (Map) r13.next();
        Object r15 = r14.get("module_action");
        if ((r15 instanceof String) == true) goto L24;
        r15 = null;
    L24:
        String r16 = (String) r15;
        Object r17 = r14.get("event_type");
        if ((r17 instanceof String) == true) goto L27;
        r17 = null;
    L27:
        String r19 = (String) r17;
        Object r20 = r14.get("sampling_rate");
        if ((r20 instanceof Double) == true) goto L30;
        r20 = null;
    L30:
        Double r21 = (Double) r20;
        if (Intrinsics.areEqual(r16, r6) == false) goto L20;
        if (Intrinsics.areEqual(r19, r7) == false) goto L20;
        if (r21 == null) goto L40;
        double r22 = r21.doubleValue();
    L38:
        r4 = (long) r22;
    L40:
        if (r5 >= r4) goto L42;
        boolean r23 = true;
    L43:
        if (r23 == true) goto L45;
        return false;
    L45:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new TrackerConsumer$receive$1(this, r18, null), 2, null);
        return true;
    L42:
        r23 = false;
    L36:
        if (r10 == null) goto L40;
        r22 = r10.doubleValue();
    L9:
        r3 = 0;
        goto L10
    }
}
