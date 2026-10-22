package com.bytedance.android.livesdk.livecommerce.actionrecord.consumer;

import com.bytedance.android.livesdk.livecommerce.actionrecord.event.EventType;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.a$a, reason: collision with other inner class name */
    public static final class C0060a {
        public static Map a(vg2.a r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            LinkedHashMap r0 = new LinkedHashMap();
            r0.put("module", r3.d);
            r0.put("action", r3.e);
            r0.put("action_uuid", r3.f);
            return r0;
        }
    }

    String a();

    Set<EventType> b();

    boolean c(vg2.a r1);
}
