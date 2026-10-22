package com.larus.bmhome.auth;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/auth/DegradeStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "WEAK_REFERENCE_DEGRADE", "FULL_DEGRADE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DegradeStatus extends Enum<DegradeStatus> {
    public static final DegradeStatus DEFAULT = null;
    public static final DegradeStatus FULL_DEGRADE = null;
    public static final DegradeStatus WEAK_REFERENCE_DEGRADE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DegradeStatus[] f295721a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f295722b = null;
    private final int value;

    public static EnumEntries<DegradeStatus> getEntries() {
        return f295722b;
    }

    static {
        DegradeStatus r100 = new DegradeStatus("DEFAULT", 0, 0);
        DEFAULT = r100;
        DegradeStatus r101 = new DegradeStatus("WEAK_REFERENCE_DEGRADE", 1, 1);
        WEAK_REFERENCE_DEGRADE = r101;
        DegradeStatus r102 = new DegradeStatus("FULL_DEGRADE", 2, 2);
        FULL_DEGRADE = r102;
        DegradeStatus[] r103 = {r100, r101, r102};
        f295721a = r103;
        f295722b = EnumEntriesKt.enumEntries(r103);
    }

    public static DegradeStatus[] values() {
        return (DegradeStatus[]) f295721a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DegradeStatus valueOf(String r100) {
        return (DegradeStatus) r27.a.a(DegradeStatus.class, r100);
    }

    public DegradeStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
