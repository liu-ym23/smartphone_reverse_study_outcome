package com.obric.assistant.activation.presentation.runtime.surface;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/activation/presentation/runtime/surface/ObricRootSurfaceEvent;", "", "<init>", "(Ljava/lang/String;I)V", "INITIAL", "CREATED", "REPLACED", "runtime_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricRootSurfaceEvent extends Enum<ObricRootSurfaceEvent> {
    public static final ObricRootSurfaceEvent CREATED = null;
    public static final ObricRootSurfaceEvent INITIAL = null;
    public static final ObricRootSurfaceEvent REPLACED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricRootSurfaceEvent[] f385558a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f385559b = null;

    public static EnumEntries<ObricRootSurfaceEvent> getEntries() {
        return f385559b;
    }

    static {
        ObricRootSurfaceEvent r100 = new ObricRootSurfaceEvent("INITIAL", 0);
        INITIAL = r100;
        ObricRootSurfaceEvent r101 = new ObricRootSurfaceEvent("CREATED", 1);
        CREATED = r101;
        ObricRootSurfaceEvent r102 = new ObricRootSurfaceEvent("REPLACED", 2);
        REPLACED = r102;
        ObricRootSurfaceEvent[] r103 = {r100, r101, r102};
        f385558a = r103;
        f385559b = EnumEntriesKt.enumEntries(r103);
    }

    public static ObricRootSurfaceEvent[] values() {
        return (ObricRootSurfaceEvent[]) f385558a.clone();
    }

    public static ObricRootSurfaceEvent valueOf(String r100) {
        return (ObricRootSurfaceEvent) a.a(ObricRootSurfaceEvent.class, r100);
    }

    public ObricRootSurfaceEvent(String r100, int r101) {
        super(r100, r101);
    }
}
