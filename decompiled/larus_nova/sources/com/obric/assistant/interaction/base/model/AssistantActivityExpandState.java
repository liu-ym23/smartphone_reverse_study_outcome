package com.obric.assistant.interaction.base.model;

import com.obric.assistant.interaction.base.interact.IStatable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/assistant/interaction/base/model/AssistantActivityExpandState;", "Lcom/obric/assistant/interaction/base/interact/IStatable;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "CHAT_WINDOW", "HALF_WINDOW", "FULL_SCREEN", "INVISIBLE", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AssistantActivityExpandState extends Enum<AssistantActivityExpandState> implements IStatable {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AssistantActivityExpandState[] $VALUES = null;
    public static final AssistantActivityExpandState CHAT_WINDOW = null;
    public static final AssistantActivityExpandState FULL_SCREEN = null;
    public static final AssistantActivityExpandState HALF_WINDOW = null;
    public static final AssistantActivityExpandState INVISIBLE = null;
    public static final AssistantActivityExpandState NA = null;

    private static final /* synthetic */ AssistantActivityExpandState[] $values() {
        return new AssistantActivityExpandState[]{NA, CHAT_WINDOW, HALF_WINDOW, FULL_SCREEN, INVISIBLE};
    }

    public static EnumEntries<AssistantActivityExpandState> getEntries() {
        return $ENTRIES;
    }

    static {
        NA = new AssistantActivityExpandState("NA", 0);
        CHAT_WINDOW = new AssistantActivityExpandState("CHAT_WINDOW", 1);
        HALF_WINDOW = new AssistantActivityExpandState("HALF_WINDOW", 2);
        FULL_SCREEN = new AssistantActivityExpandState("FULL_SCREEN", 3);
        INVISIBLE = new AssistantActivityExpandState("INVISIBLE", 4);
        AssistantActivityExpandState[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static AssistantActivityExpandState[] values() {
        return (AssistantActivityExpandState[]) $VALUES.clone();
    }

    public static AssistantActivityExpandState valueOf(String r100) {
        return (AssistantActivityExpandState) a.a(AssistantActivityExpandState.class, r100);
    }

    private AssistantActivityExpandState(String r100, int r101) {
        super(r100, r101);
    }
}
