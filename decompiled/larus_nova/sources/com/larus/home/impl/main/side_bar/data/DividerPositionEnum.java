package com.larus.home.impl.main.side_bar.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/home/impl/main/side_bar/data/DividerPositionEnum;", "", "position", "", "<init>", "(Ljava/lang/String;II)V", "getPosition", "()I", "TOP", "BOTTOM", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DividerPositionEnum extends Enum<DividerPositionEnum> {
    public static final DividerPositionEnum BOTTOM = null;
    public static final DividerPositionEnum TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DividerPositionEnum[] f344424a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f344425b = null;
    private final int position;

    public static EnumEntries<DividerPositionEnum> getEntries() {
        return f344425b;
    }

    static {
        DividerPositionEnum r100 = new DividerPositionEnum("TOP", 0, 1);
        TOP = r100;
        DividerPositionEnum r101 = new DividerPositionEnum("BOTTOM", 1, 2);
        BOTTOM = r101;
        DividerPositionEnum[] r102 = {r100, r101};
        f344424a = r102;
        f344425b = EnumEntriesKt.enumEntries(r102);
    }

    public static DividerPositionEnum[] values() {
        return (DividerPositionEnum[]) f344424a.clone();
    }

    public final int getPosition() {
        return this.position;
    }

    public static DividerPositionEnum valueOf(String r100) {
        return (DividerPositionEnum) r27.a.a(DividerPositionEnum.class, r100);
    }

    public DividerPositionEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.position = r102;
    }
}
