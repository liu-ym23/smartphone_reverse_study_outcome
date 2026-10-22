package com.larus.home.impl.main.side_bar.view.group.datasource;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/group/datasource/GroupSortPolicy;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UpdateTime", "CreateTime", "PinTime", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GroupSortPolicy extends Enum<GroupSortPolicy> {
    public static final GroupSortPolicy CreateTime = null;
    public static final GroupSortPolicy PinTime = null;
    public static final GroupSortPolicy UpdateTime = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GroupSortPolicy[] f345202a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f345203b = null;
    private final int value;

    public static EnumEntries<GroupSortPolicy> getEntries() {
        return f345203b;
    }

    static {
        GroupSortPolicy r100 = new GroupSortPolicy("UpdateTime", 0, 0);
        UpdateTime = r100;
        GroupSortPolicy r101 = new GroupSortPolicy("CreateTime", 1, 1);
        CreateTime = r101;
        GroupSortPolicy r102 = new GroupSortPolicy("PinTime", 2, 2);
        PinTime = r102;
        GroupSortPolicy[] r103 = {r100, r101, r102};
        f345202a = r103;
        f345203b = EnumEntriesKt.enumEntries(r103);
    }

    public static GroupSortPolicy[] values() {
        return (GroupSortPolicy[]) f345202a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static GroupSortPolicy valueOf(String r100) {
        return (GroupSortPolicy) a.a(GroupSortPolicy.class, r100);
    }

    public GroupSortPolicy(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
