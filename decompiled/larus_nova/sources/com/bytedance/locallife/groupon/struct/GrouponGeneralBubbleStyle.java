package com.bytedance.locallife.groupon.struct;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/GrouponGeneralBubbleStyle;", "", "", "value", "I", "getValue", "()I", "STYLE_DEFAULT", "STYLE_IMG_TEXT", "STYLE_ICON_TEXT", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum GrouponGeneralBubbleStyle extends Enum<GrouponGeneralBubbleStyle> {
    public static final GrouponGeneralBubbleStyle STYLE_DEFAULT = null;
    public static final GrouponGeneralBubbleStyle STYLE_ICON_TEXT = null;
    public static final GrouponGeneralBubbleStyle STYLE_IMG_TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GrouponGeneralBubbleStyle[] f258821a = null;
    private final int value;

    public static GrouponGeneralBubbleStyle valueOf(String r100) {
        return (GrouponGeneralBubbleStyle) r27.a.a(GrouponGeneralBubbleStyle.class, r100);
    }

    public static GrouponGeneralBubbleStyle[] values() {
        return (GrouponGeneralBubbleStyle[]) f258821a.clone();
    }

    static {
        GrouponGeneralBubbleStyle r100 = new GrouponGeneralBubbleStyle("STYLE_DEFAULT", 0, 1);
        STYLE_DEFAULT = r100;
        GrouponGeneralBubbleStyle r101 = new GrouponGeneralBubbleStyle("STYLE_IMG_TEXT", 1, 2);
        STYLE_IMG_TEXT = r101;
        GrouponGeneralBubbleStyle r102 = new GrouponGeneralBubbleStyle("STYLE_ICON_TEXT", 2, 3);
        STYLE_ICON_TEXT = r102;
        f258821a = new GrouponGeneralBubbleStyle[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public GrouponGeneralBubbleStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
