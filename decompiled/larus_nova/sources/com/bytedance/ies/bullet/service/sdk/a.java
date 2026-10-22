package com.bytedance.ies.bullet.service.sdk;

import com.bytedance.ies.bullet.service.schema.SchemaMonitorEvent;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import t36.g;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements g {
    public a() {
    }

    @Override // t36.g
    public final void a(SchemaMonitorEvent r100, t36.d r101, Map<String, String> r102, Map<String, String> r103, Map<String, Long> r104) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "schemaData");
        Intrinsics.checkNotNullParameter(r102, "info");
    }

    @Override // t36.g
    public final void log(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
    }
}
