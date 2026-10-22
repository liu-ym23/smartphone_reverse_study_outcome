package com.obric.assistant.interaction.base.mode;

import com.obric.assistant.interaction.base.interact.IStatable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/assistant/interaction/base/mode/MicMuteState;", "Lcom/obric/assistant/interaction/base/interact/IStatable;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "UNMUTE", "MUTE", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MicMuteState extends Enum<MicMuteState> implements IStatable {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MicMuteState[] $VALUES = null;
    public static final MicMuteState MUTE = null;
    public static final MicMuteState NA = null;
    public static final MicMuteState UNMUTE = null;

    private static final /* synthetic */ MicMuteState[] $values() {
        return new MicMuteState[]{NA, UNMUTE, MUTE};
    }

    public static EnumEntries<MicMuteState> getEntries() {
        return $ENTRIES;
    }

    static {
        NA = new MicMuteState("NA", 0);
        UNMUTE = new MicMuteState("UNMUTE", 1);
        MUTE = new MicMuteState("MUTE", 2);
        MicMuteState[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static MicMuteState[] values() {
        return (MicMuteState[]) $VALUES.clone();
    }

    public static MicMuteState valueOf(String r100) {
        return (MicMuteState) a.a(MicMuteState.class, r100);
    }

    private MicMuteState(String r100, int r101) {
        super(r100, r101);
    }
}
