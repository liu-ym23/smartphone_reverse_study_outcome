package com.larus.bmhome.chat.model.strategy.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/model/strategy/block/PermissionStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PERMISSION_STATUS_UNSPECIFIED", "GRANTED", "DENIED", "NOT_DETERMINED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PermissionStatus extends Enum<PermissionStatus> {
    public static final PermissionStatus DENIED = null;
    public static final PermissionStatus GRANTED = null;
    public static final PermissionStatus NOT_DETERMINED = null;
    public static final PermissionStatus PERMISSION_STATUS_UNSPECIFIED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PermissionStatus[] f308011a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f308012b = null;
    private final int value;

    public static EnumEntries<PermissionStatus> getEntries() {
        return f308012b;
    }

    static {
        PermissionStatus r100 = new PermissionStatus("PERMISSION_STATUS_UNSPECIFIED", 0, 0);
        PERMISSION_STATUS_UNSPECIFIED = r100;
        PermissionStatus r101 = new PermissionStatus("GRANTED", 1, 1);
        GRANTED = r101;
        PermissionStatus r102 = new PermissionStatus("DENIED", 2, 2);
        DENIED = r102;
        PermissionStatus r103 = new PermissionStatus("NOT_DETERMINED", 3, 3);
        NOT_DETERMINED = r103;
        PermissionStatus[] r104 = {r100, r101, r102, r103};
        f308011a = r104;
        f308012b = EnumEntriesKt.enumEntries(r104);
    }

    public static PermissionStatus[] values() {
        return (PermissionStatus[]) f308011a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static PermissionStatus valueOf(String r100) {
        return (PermissionStatus) r27.a.a(PermissionStatus.class, r100);
    }

    public PermissionStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
