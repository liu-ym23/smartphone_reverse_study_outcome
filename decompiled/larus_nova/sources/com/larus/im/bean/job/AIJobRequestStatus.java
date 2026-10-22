package com.larus.im.bean.job;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0087\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/im/bean/job/AIJobRequestStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "IDLE", "LOADING", "SUCCESS", "FAILURE", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AIJobRequestStatus extends Enum<AIJobRequestStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AIJobRequestStatus[] $VALUES = null;
    public static final a Companion = null;
    public static final AIJobRequestStatus FAILURE = null;
    public static final AIJobRequestStatus IDLE = null;
    public static final AIJobRequestStatus LOADING = null;
    public static final AIJobRequestStatus SUCCESS = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ AIJobRequestStatus[] $values() {
        return new AIJobRequestStatus[]{IDLE, LOADING, SUCCESS, FAILURE};
    }

    public static EnumEntries<AIJobRequestStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        IDLE = new AIJobRequestStatus("IDLE", 0, 0);
        LOADING = new AIJobRequestStatus("LOADING", 1, 1);
        SUCCESS = new AIJobRequestStatus("SUCCESS", 2, 2);
        FAILURE = new AIJobRequestStatus("FAILURE", 3, 3);
        AIJobRequestStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static AIJobRequestStatus[] values() {
        return (AIJobRequestStatus[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AIJobRequestStatus valueOf(String r100) {
        return (AIJobRequestStatus) r27.a.a(AIJobRequestStatus.class, r100);
    }

    private AIJobRequestStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
