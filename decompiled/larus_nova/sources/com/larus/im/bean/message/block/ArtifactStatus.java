package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/im/bean/message/block/ArtifactStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "GENERATING", "GENERATED", "DELETED", "OUTDATED", "UNSUPPORTED", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ArtifactStatus extends Enum<ArtifactStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ArtifactStatus[] $VALUES = null;
    public static final ArtifactStatus DELETED = null;
    public static final ArtifactStatus GENERATED = null;
    public static final ArtifactStatus GENERATING = null;
    public static final ArtifactStatus OUTDATED = null;
    public static final ArtifactStatus UNKNOWN = null;
    public static final ArtifactStatus UNSUPPORTED = null;
    private final int value;

    private static final /* synthetic */ ArtifactStatus[] $values() {
        return new ArtifactStatus[]{UNKNOWN, GENERATING, GENERATED, DELETED, OUTDATED, UNSUPPORTED};
    }

    public static EnumEntries<ArtifactStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        UNKNOWN = new ArtifactStatus("UNKNOWN", 0, 0);
        GENERATING = new ArtifactStatus("GENERATING", 1, 1);
        GENERATED = new ArtifactStatus("GENERATED", 2, 2);
        DELETED = new ArtifactStatus("DELETED", 3, 3);
        OUTDATED = new ArtifactStatus("OUTDATED", 4, 4);
        UNSUPPORTED = new ArtifactStatus("UNSUPPORTED", 5, 5);
        ArtifactStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ArtifactStatus[] values() {
        return (ArtifactStatus[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ArtifactStatus valueOf(String r100) {
        return (ArtifactStatus) a.a(ArtifactStatus.class, r100);
    }

    private ArtifactStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
