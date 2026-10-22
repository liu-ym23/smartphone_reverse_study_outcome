package com.larus.bmhome.view.resourcebar.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/view/resourcebar/bean/ItemStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UPLINKING", "UPLINK_SUCCESS", "UPLINK_FAILED", "PARSE_FAILED", "INSPECT_FAILED", "SUCCESS", "EXPIRED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ItemStatus extends Enum<ItemStatus> {
    public static final ItemStatus EXPIRED = null;
    public static final ItemStatus INSPECT_FAILED = null;
    public static final ItemStatus PARSE_FAILED = null;
    public static final ItemStatus SUCCESS = null;
    public static final ItemStatus UPLINKING = null;
    public static final ItemStatus UPLINK_FAILED = null;
    public static final ItemStatus UPLINK_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ItemStatus[] f317151a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f317152b = null;
    private final int value;

    public static EnumEntries<ItemStatus> getEntries() {
        return f317152b;
    }

    static {
        ItemStatus r100 = new ItemStatus("UPLINKING", 0, 0);
        UPLINKING = r100;
        ItemStatus r101 = new ItemStatus("UPLINK_SUCCESS", 1, 1);
        UPLINK_SUCCESS = r101;
        ItemStatus r102 = new ItemStatus("UPLINK_FAILED", 2, 2);
        UPLINK_FAILED = r102;
        ItemStatus r103 = new ItemStatus("PARSE_FAILED", 3, 3);
        PARSE_FAILED = r103;
        ItemStatus r104 = new ItemStatus("INSPECT_FAILED", 4, 4);
        INSPECT_FAILED = r104;
        ItemStatus r105 = new ItemStatus("SUCCESS", 5, 5);
        SUCCESS = r105;
        ItemStatus r110 = new ItemStatus("EXPIRED", 6, 6);
        EXPIRED = r110;
        ItemStatus[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f317151a = r111;
        f317152b = EnumEntriesKt.enumEntries(r111);
    }

    public static ItemStatus[] values() {
        return (ItemStatus[]) f317151a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ItemStatus valueOf(String r100) {
        return (ItemStatus) a.a(ItemStatus.class, r100);
    }

    public ItemStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
