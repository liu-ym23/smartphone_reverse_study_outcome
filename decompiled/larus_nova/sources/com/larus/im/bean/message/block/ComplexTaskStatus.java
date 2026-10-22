package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/im/bean/message/block/ComplexTaskStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "CANCEL", "FINISH", "FAIL", "PROCESSING", "PAUSE", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ComplexTaskStatus extends Enum<ComplexTaskStatus> {
    public static final ComplexTaskStatus CANCEL = null;
    public static final ComplexTaskStatus FAIL = null;
    public static final ComplexTaskStatus FINISH = null;
    public static final ComplexTaskStatus PAUSE = null;
    public static final ComplexTaskStatus PROCESSING = null;
    public static final ComplexTaskStatus UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ComplexTaskStatus[] f346837a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346838b = null;
    private final int value;

    public static EnumEntries<ComplexTaskStatus> getEntries() {
        return f346838b;
    }

    static {
        ComplexTaskStatus r100 = new ComplexTaskStatus("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        ComplexTaskStatus r101 = new ComplexTaskStatus("CANCEL", 1, 1);
        CANCEL = r101;
        ComplexTaskStatus r102 = new ComplexTaskStatus("FINISH", 2, 2);
        FINISH = r102;
        ComplexTaskStatus r103 = new ComplexTaskStatus("FAIL", 3, 3);
        FAIL = r103;
        ComplexTaskStatus r104 = new ComplexTaskStatus("PROCESSING", 4, 4);
        PROCESSING = r104;
        ComplexTaskStatus r105 = new ComplexTaskStatus("PAUSE", 5, 5);
        PAUSE = r105;
        ComplexTaskStatus[] r110 = {r100, r101, r102, r103, r104, r105};
        f346837a = r110;
        f346838b = EnumEntriesKt.enumEntries(r110);
    }

    public static ComplexTaskStatus[] values() {
        return (ComplexTaskStatus[]) f346837a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ComplexTaskStatus valueOf(String r100) {
        return (ComplexTaskStatus) a.a(ComplexTaskStatus.class, r100);
    }

    public ComplexTaskStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
