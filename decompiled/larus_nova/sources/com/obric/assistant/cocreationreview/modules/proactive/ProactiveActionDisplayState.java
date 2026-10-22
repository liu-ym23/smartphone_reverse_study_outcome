package com.obric.assistant.cocreationreview.modules.proactive;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/cocreationreview/modules/proactive/ProactiveActionDisplayState;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "ADOPTED", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ProactiveActionDisplayState extends Enum<ProactiveActionDisplayState> {
    public static final ProactiveActionDisplayState ADOPTED = null;
    public static final ProactiveActionDisplayState DEFAULT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProactiveActionDisplayState[] f387460a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f387461b = null;

    public static EnumEntries<ProactiveActionDisplayState> getEntries() {
        return f387461b;
    }

    static {
        ProactiveActionDisplayState r100 = new ProactiveActionDisplayState("DEFAULT", 0);
        DEFAULT = r100;
        ProactiveActionDisplayState r101 = new ProactiveActionDisplayState("ADOPTED", 1);
        ADOPTED = r101;
        ProactiveActionDisplayState[] r102 = {r100, r101};
        f387460a = r102;
        f387461b = EnumEntriesKt.enumEntries(r102);
    }

    public static ProactiveActionDisplayState[] values() {
        return (ProactiveActionDisplayState[]) f387460a.clone();
    }

    public static ProactiveActionDisplayState valueOf(String r100) {
        return (ProactiveActionDisplayState) r27.a.a(ProactiveActionDisplayState.class, r100);
    }

    public ProactiveActionDisplayState(String r100, int r101) {
        super(r100, r101);
    }
}
