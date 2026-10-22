package com.obric.assistant.interaction.base.mode;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/assistant/interaction/base/mode/AssistantMode;", "", "<init>", "(Ljava/lang/String;I)V", "NullMode", "DefaultMode", "TextMode", "RealtimeCallMode", "ManualHalfDuplex", "AutoHalfDuplex", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AssistantMode extends Enum<AssistantMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AssistantMode[] $VALUES = null;
    public static final AssistantMode AutoHalfDuplex = null;
    public static final AssistantMode DefaultMode = null;
    public static final AssistantMode ManualHalfDuplex = null;
    public static final AssistantMode NullMode = null;
    public static final AssistantMode RealtimeCallMode = null;
    public static final AssistantMode TextMode = null;

    private static final /* synthetic */ AssistantMode[] $values() {
        return new AssistantMode[]{NullMode, DefaultMode, TextMode, RealtimeCallMode, ManualHalfDuplex, AutoHalfDuplex};
    }

    public static EnumEntries<AssistantMode> getEntries() {
        return $ENTRIES;
    }

    static {
        NullMode = new AssistantMode("NullMode", 0);
        DefaultMode = new AssistantMode("DefaultMode", 1);
        TextMode = new AssistantMode("TextMode", 2);
        RealtimeCallMode = new AssistantMode("RealtimeCallMode", 3);
        ManualHalfDuplex = new AssistantMode("ManualHalfDuplex", 4);
        AutoHalfDuplex = new AssistantMode("AutoHalfDuplex", 5);
        AssistantMode[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static AssistantMode[] values() {
        return (AssistantMode[]) $VALUES.clone();
    }

    public static AssistantMode valueOf(String r100) {
        return (AssistantMode) a.a(AssistantMode.class, r100);
    }

    private AssistantMode(String r100, int r101) {
        super(r100, r101);
    }
}
