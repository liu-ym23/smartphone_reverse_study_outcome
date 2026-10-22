package com.ss.android.lark.picker.config;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/picker/config/DepartmentSelectableScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ONLY_OWNER_OR_LEADER", "ALL_DEPARTMENT", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DepartmentSelectableScene extends Enum<DepartmentSelectableScene> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DepartmentSelectableScene[] $VALUES = null;
    public static final DepartmentSelectableScene ALL_DEPARTMENT = null;
    public static final DepartmentSelectableScene ONLY_OWNER_OR_LEADER = null;
    private final int value;

    private static final /* synthetic */ DepartmentSelectableScene[] $values() {
        return new DepartmentSelectableScene[]{ONLY_OWNER_OR_LEADER, ALL_DEPARTMENT};
    }

    public static EnumEntries<DepartmentSelectableScene> getEntries() {
        return $ENTRIES;
    }

    static {
        ONLY_OWNER_OR_LEADER = new DepartmentSelectableScene("ONLY_OWNER_OR_LEADER", 0, 0);
        ALL_DEPARTMENT = new DepartmentSelectableScene("ALL_DEPARTMENT", 1, 1);
        DepartmentSelectableScene[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static DepartmentSelectableScene[] values() {
        return (DepartmentSelectableScene[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DepartmentSelectableScene valueOf(String r100) {
        return (DepartmentSelectableScene) a.a(DepartmentSelectableScene.class, r100);
    }

    private DepartmentSelectableScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
