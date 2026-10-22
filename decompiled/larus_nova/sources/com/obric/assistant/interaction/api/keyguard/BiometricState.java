package com.obric.assistant.interaction.api.keyguard;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/api/keyguard/BiometricState;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "DISABLED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BiometricState extends Enum<BiometricState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ BiometricState[] $VALUES = null;
    public static final BiometricState DEFAULT = null;
    public static final BiometricState DISABLED = null;

    private static final /* synthetic */ BiometricState[] $values() {
        return new BiometricState[]{DEFAULT, DISABLED};
    }

    public static EnumEntries<BiometricState> getEntries() {
        return $ENTRIES;
    }

    static {
        DEFAULT = new BiometricState("DEFAULT", 0);
        DISABLED = new BiometricState("DISABLED", 1);
        BiometricState[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static BiometricState[] values() {
        return (BiometricState[]) $VALUES.clone();
    }

    public static BiometricState valueOf(String r100) {
        return (BiometricState) a.a(BiometricState.class, r100);
    }

    private BiometricState(String r100, int r101) {
        super(r100, r101);
    }
}
