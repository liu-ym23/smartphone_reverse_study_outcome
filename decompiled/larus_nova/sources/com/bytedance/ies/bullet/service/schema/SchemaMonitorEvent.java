package com.bytedance.ies.bullet.service.schema;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/SchemaMonitorEvent;", "", "CONVERT", "GENERATE", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum SchemaMonitorEvent extends Enum<SchemaMonitorEvent> {
    public static final SchemaMonitorEvent CONVERT = null;
    public static final SchemaMonitorEvent GENERATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SchemaMonitorEvent[] f248115a = null;

    public static SchemaMonitorEvent valueOf(String r100) {
        return (SchemaMonitorEvent) a.a(SchemaMonitorEvent.class, r100);
    }

    public static SchemaMonitorEvent[] values() {
        return (SchemaMonitorEvent[]) f248115a.clone();
    }

    static {
        SchemaMonitorEvent r100 = new SchemaMonitorEvent("CONVERT", 0);
        CONVERT = r100;
        SchemaMonitorEvent r101 = new SchemaMonitorEvent("GENERATE", 1);
        GENERATE = r101;
        f248115a = new SchemaMonitorEvent[]{r100, r101};
    }

    public SchemaMonitorEvent(String r100, int r101) {
        super(r100, r101);
    }
}
