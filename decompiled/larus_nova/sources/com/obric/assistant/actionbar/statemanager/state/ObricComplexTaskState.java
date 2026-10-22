package com.obric.assistant.actionbar.statemanager.state;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/actionbar/statemanager/state/ObricComplexTaskState;", "Lcom/obric/assistant/actionbar/statemanager/interfaces/ObricTaskState;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "IDLE", "CLARIFYING", "RUNNING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricComplexTaskState extends Enum<ObricComplexTaskState> {
    public static final ObricComplexTaskState CLARIFYING = null;
    public static final ObricComplexTaskState IDLE = null;
    public static final ObricComplexTaskState RUNNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricComplexTaskState[] f385256a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f385257b = null;
    private final String value;

    public static EnumEntries<ObricComplexTaskState> getEntries() {
        return f385257b;
    }

    static {
        ObricComplexTaskState r100 = new ObricComplexTaskState("IDLE", 0, "complex_idle");
        IDLE = r100;
        ObricComplexTaskState r101 = new ObricComplexTaskState("CLARIFYING", 1, "complex_clarifying");
        CLARIFYING = r101;
        ObricComplexTaskState r102 = new ObricComplexTaskState("RUNNING", 2, "complex_running");
        RUNNING = r102;
        ObricComplexTaskState[] r103 = {r100, r101, r102};
        f385256a = r103;
        f385257b = EnumEntriesKt.enumEntries(r103);
    }

    public static ObricComplexTaskState[] values() {
        return (ObricComplexTaskState[]) f385256a.clone();
    }

    public String getValue() {
        return this.value;
    }

    public static ObricComplexTaskState valueOf(String r100) {
        return (ObricComplexTaskState) a.a(ObricComplexTaskState.class, r100);
    }

    public ObricComplexTaskState(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
