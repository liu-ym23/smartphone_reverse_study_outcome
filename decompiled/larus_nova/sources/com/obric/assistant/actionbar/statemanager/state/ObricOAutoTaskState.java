package com.obric.assistant.actionbar.statemanager.state;

import com.ss.android.ugc.aweme.search.common.result.recycler.ECSaasScrollViewController;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/actionbar/statemanager/state/ObricOAutoTaskState;", "Lcom/obric/assistant/actionbar/statemanager/interfaces/ObricTaskState;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "IDLE", "EXECUTING", "WAITING", "CLARIFYING", "CALL_USER", "PAUSED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricOAutoTaskState extends Enum<ObricOAutoTaskState> {
    public static final ObricOAutoTaskState CALL_USER = null;
    public static final ObricOAutoTaskState CLARIFYING = null;
    public static final ObricOAutoTaskState EXECUTING = null;
    public static final ObricOAutoTaskState IDLE = null;
    public static final ObricOAutoTaskState PAUSED = null;
    public static final ObricOAutoTaskState WAITING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricOAutoTaskState[] f385258a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f385259b = null;
    private final String value;

    public static EnumEntries<ObricOAutoTaskState> getEntries() {
        return f385259b;
    }

    static {
        ObricOAutoTaskState r100 = new ObricOAutoTaskState("IDLE", 0, ECSaasScrollViewController.SEARCH_SCROLL_STATE_IDLE);
        IDLE = r100;
        ObricOAutoTaskState r101 = new ObricOAutoTaskState("EXECUTING", 1, "executing");
        EXECUTING = r101;
        ObricOAutoTaskState r102 = new ObricOAutoTaskState("WAITING", 2, "waiting");
        WAITING = r102;
        ObricOAutoTaskState r103 = new ObricOAutoTaskState("CLARIFYING", 3, "clarifying");
        CLARIFYING = r103;
        ObricOAutoTaskState r104 = new ObricOAutoTaskState("CALL_USER", 4, "call_user");
        CALL_USER = r104;
        ObricOAutoTaskState r105 = new ObricOAutoTaskState("PAUSED", 5, "paused");
        PAUSED = r105;
        ObricOAutoTaskState[] r110 = {r100, r101, r102, r103, r104, r105};
        f385258a = r110;
        f385259b = EnumEntriesKt.enumEntries(r110);
    }

    public static ObricOAutoTaskState[] values() {
        return (ObricOAutoTaskState[]) f385258a.clone();
    }

    public String getValue() {
        return this.value;
    }

    public static ObricOAutoTaskState valueOf(String r100) {
        return (ObricOAutoTaskState) a.a(ObricOAutoTaskState.class, r100);
    }

    public ObricOAutoTaskState(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
