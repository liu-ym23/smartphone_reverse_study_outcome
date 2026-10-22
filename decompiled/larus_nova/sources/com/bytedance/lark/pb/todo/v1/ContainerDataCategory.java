package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ContainerDataCategory extends Enum<ContainerDataCategory> implements WireEnum {
    private static final /* synthetic */ ContainerDataCategory[] $VALUES = null;
    public static final ProtoAdapter<ContainerDataCategory> ADAPTER = null;
    public static final ContainerDataCategory CONTAINERS = null;
    public static final ContainerDataCategory SECTIONS = null;
    public static final ContainerDataCategory SECTION_REFS = null;
    public static final ContainerDataCategory TASK_MEMBERS = null;
    public static final ContainerDataCategory UNKNOWN_CATEGORY = null;
    private final int value;

    static {
        ContainerDataCategory r100 = new ContainerDataCategory("UNKNOWN_CATEGORY", 0, 0);
        UNKNOWN_CATEGORY = r100;
        ContainerDataCategory r101 = new ContainerDataCategory("CONTAINERS", 1, 1);
        CONTAINERS = r101;
        ContainerDataCategory r102 = new ContainerDataCategory("SECTIONS", 2, 2);
        SECTIONS = r102;
        ContainerDataCategory r103 = new ContainerDataCategory("SECTION_REFS", 3, 3);
        SECTION_REFS = r103;
        ContainerDataCategory r104 = new ContainerDataCategory("TASK_MEMBERS", 4, 4);
        TASK_MEMBERS = r104;
        $VALUES = new ContainerDataCategory[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(ContainerDataCategory.class);
    }

    public static ContainerDataCategory[] values() {
        return (ContainerDataCategory[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ContainerDataCategory fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return TASK_MEMBERS;
    L16:
        return SECTION_REFS;
    L18:
        return SECTIONS;
    L20:
        return CONTAINERS;
    L22:
        return UNKNOWN_CATEGORY;
    }

    public static ContainerDataCategory valueOf(String r100) {
        return (ContainerDataCategory) a.a(ContainerDataCategory.class, r100);
    }

    private ContainerDataCategory(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
