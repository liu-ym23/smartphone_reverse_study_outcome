package com.ss.android.lark.optrace.extension.clientduration;

import com.ss.android.lark.optrace.extension.TracingExtension;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes37.dex */
public abstract class TracingClientDurationExtension implements TracingExtension {
    public static final long DEFAULT_DURATION = -1;
    Map<String, TracingClientDurationEvent> eventStartMap;

    public abstract long duration(String r100);

    public abstract long end(String r100);

    public abstract void endAll();

    @Override // com.ss.android.lark.optrace.extension.TracingExtension
    public abstract /* synthetic */ TracingExtension mergeExtension(TracingExtension r100);

    public abstract void start(String r100);

    public String toString() {
        return "TracingClientDurationExtension{eventStartMap=" + this.eventStartMap + '}';
    }

    public TracingClientDurationExtension() {
        this.eventStartMap = new ConcurrentHashMap();
    }
}
