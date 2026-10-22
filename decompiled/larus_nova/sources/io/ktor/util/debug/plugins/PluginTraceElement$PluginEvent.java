package io.ktor.util.debug.plugins;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"io/ktor/util/debug/plugins/PluginTraceElement$PluginEvent", "", "Lio/ktor/util/debug/plugins/PluginTraceElement$PluginEvent;", "STARTED", "FINISHED", "ktor-utils"}, k = 1, mv = {1, 8, 0})
public final enum PluginTraceElement$PluginEvent extends Enum<PluginTraceElement$PluginEvent> {
    public static final PluginTraceElement$PluginEvent FINISHED = null;
    public static final PluginTraceElement$PluginEvent STARTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PluginTraceElement$PluginEvent[] f491956a = null;

    public static PluginTraceElement$PluginEvent valueOf(String r100) {
        return (PluginTraceElement$PluginEvent) a.a(PluginTraceElement$PluginEvent.class, r100);
    }

    public static PluginTraceElement$PluginEvent[] values() {
        return (PluginTraceElement$PluginEvent[]) f491956a.clone();
    }

    static {
        PluginTraceElement$PluginEvent r100 = new PluginTraceElement$PluginEvent("STARTED", 0);
        STARTED = r100;
        PluginTraceElement$PluginEvent r101 = new PluginTraceElement$PluginEvent("FINISHED", 1);
        FINISHED = r101;
        f491956a = new PluginTraceElement$PluginEvent[]{r100, r101};
    }

    public PluginTraceElement$PluginEvent(String r100, int r101) {
        super(r100, r101);
    }
}
