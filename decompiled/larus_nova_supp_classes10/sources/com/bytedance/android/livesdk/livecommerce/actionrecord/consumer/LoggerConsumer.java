package com.bytedance.android.livesdk.livecommerce.actionrecord.consumer;

import com.bytedance.android.livesdk.livecommerce.actionrecord.event.EventType;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LoggerConsumer implements a {
    public final Map<String, String> a;

    @Override // com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.a
    public final String a() {
        return "logger";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.a
    public final Set<EventType> b() {
        return SetsKt.setOf(new EventType[]{EventType.RATE_START, EventType.RATE_SUCCESS, EventType.RATE_FAILURE, EventType.RATE_SINGLE});
    }

    public LoggerConsumer(Map<String, String> r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.a
    public final boolean c(vg2.a r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new LoggerConsumer$receive$1(this, r8, null), 2, null);
        return true;
    }
}
