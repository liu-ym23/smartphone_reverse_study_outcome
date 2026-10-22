package com.bytedance.locallife.groupon.struct;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/GrouponGeneralDotStyle;", "", "", "value", "I", "getValue", "()I", "STYLE_NORMAL", "STYLE_COUNT", "STYLE_TEXT", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum GrouponGeneralDotStyle extends Enum<GrouponGeneralDotStyle> {
    public static final GrouponGeneralDotStyle STYLE_COUNT = null;
    public static final GrouponGeneralDotStyle STYLE_NORMAL = null;
    public static final GrouponGeneralDotStyle STYLE_TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GrouponGeneralDotStyle[] f258823a = null;
    private final int value;

    public static GrouponGeneralDotStyle valueOf(String r100) {
        return (GrouponGeneralDotStyle) r27.a.a(GrouponGeneralDotStyle.class, r100);
    }

    public static GrouponGeneralDotStyle[] values() {
        return (GrouponGeneralDotStyle[]) f258823a.clone();
    }

    static {
        GrouponGeneralDotStyle r100 = new GrouponGeneralDotStyle("STYLE_NORMAL", 0, 1);
        STYLE_NORMAL = r100;
        GrouponGeneralDotStyle r101 = new GrouponGeneralDotStyle("STYLE_COUNT", 1, 2);
        STYLE_COUNT = r101;
        GrouponGeneralDotStyle r102 = new GrouponGeneralDotStyle("STYLE_TEXT", 2, 3);
        STYLE_TEXT = r102;
        f258823a = new GrouponGeneralDotStyle[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public GrouponGeneralDotStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
