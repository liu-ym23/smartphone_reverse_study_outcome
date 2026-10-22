package com.obric.assistant.interaction.impl.window;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/FakeActivityStage;", "", "<init>", "(Ljava/lang/String;I)V", "INITIALIZED", "CREATED", "STARTED", "RESUMED", "STOPPED", "DESTROYED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum FakeActivityStage extends Enum<FakeActivityStage> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ FakeActivityStage[] $VALUES = null;
    public static final FakeActivityStage CREATED = null;
    public static final FakeActivityStage DESTROYED = null;
    public static final FakeActivityStage INITIALIZED = null;
    public static final FakeActivityStage RESUMED = null;
    public static final FakeActivityStage STARTED = null;
    public static final FakeActivityStage STOPPED = null;

    private static final /* synthetic */ FakeActivityStage[] $values() {
        return new FakeActivityStage[]{INITIALIZED, CREATED, STARTED, RESUMED, STOPPED, DESTROYED};
    }

    public static EnumEntries<FakeActivityStage> getEntries() {
        return $ENTRIES;
    }

    static {
        INITIALIZED = new FakeActivityStage("INITIALIZED", 0);
        CREATED = new FakeActivityStage("CREATED", 1);
        STARTED = new FakeActivityStage("STARTED", 2);
        RESUMED = new FakeActivityStage("RESUMED", 3);
        STOPPED = new FakeActivityStage("STOPPED", 4);
        DESTROYED = new FakeActivityStage("DESTROYED", 5);
        FakeActivityStage[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static FakeActivityStage[] values() {
        return (FakeActivityStage[]) $VALUES.clone();
    }

    public static FakeActivityStage valueOf(String r100) {
        return (FakeActivityStage) r27.a.a(FakeActivityStage.class, r100);
    }

    private FakeActivityStage(String r100, int r101) {
        super(r100, r101);
    }
}
