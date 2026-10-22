package com.larus.dora.impl.onboarding.othersmart;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/AvatarUiState;", "", "<init>", "(Ljava/lang/String;I)V", "WAITING", "THINKING", "SPEAKING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AvatarUiState extends Enum<AvatarUiState> {
    public static final AvatarUiState SPEAKING = null;
    public static final AvatarUiState THINKING = null;
    public static final AvatarUiState WAITING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AvatarUiState[] f337039a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f337040b = null;

    public static EnumEntries<AvatarUiState> getEntries() {
        return f337040b;
    }

    static {
        AvatarUiState r100 = new AvatarUiState("WAITING", 0);
        WAITING = r100;
        AvatarUiState r101 = new AvatarUiState("THINKING", 1);
        THINKING = r101;
        AvatarUiState r102 = new AvatarUiState("SPEAKING", 2);
        SPEAKING = r102;
        AvatarUiState[] r103 = {r100, r101, r102};
        f337039a = r103;
        f337040b = EnumEntriesKt.enumEntries(r103);
    }

    public static AvatarUiState[] values() {
        return (AvatarUiState[]) f337039a.clone();
    }

    public static AvatarUiState valueOf(String r100) {
        return (AvatarUiState) r27.a.a(AvatarUiState.class, r100);
    }

    public AvatarUiState(String r100, int r101) {
        super(r100, r101);
    }
}
