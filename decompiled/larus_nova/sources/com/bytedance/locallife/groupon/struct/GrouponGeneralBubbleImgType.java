package com.bytedance.locallife.groupon.struct;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/GrouponGeneralBubbleImgType;", "", "", "value", "I", "getValue", "()I", "TYPE_RECTANGLE", "TYPE_CIRCLE", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum GrouponGeneralBubbleImgType extends Enum<GrouponGeneralBubbleImgType> {
    public static final GrouponGeneralBubbleImgType TYPE_CIRCLE = null;
    public static final GrouponGeneralBubbleImgType TYPE_RECTANGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GrouponGeneralBubbleImgType[] f258819a = null;
    private final int value;

    public static GrouponGeneralBubbleImgType valueOf(String r100) {
        return (GrouponGeneralBubbleImgType) r27.a.a(GrouponGeneralBubbleImgType.class, r100);
    }

    public static GrouponGeneralBubbleImgType[] values() {
        return (GrouponGeneralBubbleImgType[]) f258819a.clone();
    }

    static {
        GrouponGeneralBubbleImgType r100 = new GrouponGeneralBubbleImgType("TYPE_RECTANGLE", 0, 0);
        TYPE_RECTANGLE = r100;
        GrouponGeneralBubbleImgType r101 = new GrouponGeneralBubbleImgType("TYPE_CIRCLE", 1, 1);
        TYPE_CIRCLE = r101;
        f258819a = new GrouponGeneralBubbleImgType[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public GrouponGeneralBubbleImgType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
