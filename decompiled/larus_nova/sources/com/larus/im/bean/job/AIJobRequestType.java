package com.larus.im.bean.job;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/im/bean/job/AIJobRequestType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "JOB_CHAIN", "RECOMMEND_JOB", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AIJobRequestType extends Enum<AIJobRequestType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AIJobRequestType[] $VALUES = null;
    public static final a Companion = null;
    public static final AIJobRequestType JOB_CHAIN = null;
    public static final AIJobRequestType RECOMMEND_JOB = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ AIJobRequestType[] $values() {
        return new AIJobRequestType[]{JOB_CHAIN, RECOMMEND_JOB};
    }

    public static EnumEntries<AIJobRequestType> getEntries() {
        return $ENTRIES;
    }

    static {
        JOB_CHAIN = new AIJobRequestType("JOB_CHAIN", 0, 1);
        RECOMMEND_JOB = new AIJobRequestType("RECOMMEND_JOB", 1, 2);
        AIJobRequestType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static AIJobRequestType[] values() {
        return (AIJobRequestType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AIJobRequestType valueOf(String r100) {
        return (AIJobRequestType) r27.a.a(AIJobRequestType.class, r100);
    }

    private AIJobRequestType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
