package com.bytedance.locallife.groupon.struct;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/GrouponGeneralBubbleOnShowAction;", "", "", "value", "I", "getValue", "()I", "ACTION_POLLING", "ACTION_REFRESH_FEED", "ACTION_REFRESH_DIAMOND", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum GrouponGeneralBubbleOnShowAction extends Enum<GrouponGeneralBubbleOnShowAction> {
    public static final GrouponGeneralBubbleOnShowAction ACTION_POLLING = null;
    public static final GrouponGeneralBubbleOnShowAction ACTION_REFRESH_DIAMOND = null;
    public static final GrouponGeneralBubbleOnShowAction ACTION_REFRESH_FEED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GrouponGeneralBubbleOnShowAction[] f258820a = null;
    private final int value;

    public static GrouponGeneralBubbleOnShowAction valueOf(String r100) {
        return (GrouponGeneralBubbleOnShowAction) r27.a.a(GrouponGeneralBubbleOnShowAction.class, r100);
    }

    public static GrouponGeneralBubbleOnShowAction[] values() {
        return (GrouponGeneralBubbleOnShowAction[]) f258820a.clone();
    }

    static {
        GrouponGeneralBubbleOnShowAction r100 = new GrouponGeneralBubbleOnShowAction("ACTION_POLLING", 0, 1);
        ACTION_POLLING = r100;
        GrouponGeneralBubbleOnShowAction r101 = new GrouponGeneralBubbleOnShowAction("ACTION_REFRESH_FEED", 1, 2);
        ACTION_REFRESH_FEED = r101;
        GrouponGeneralBubbleOnShowAction r102 = new GrouponGeneralBubbleOnShowAction("ACTION_REFRESH_DIAMOND", 2, 3);
        ACTION_REFRESH_DIAMOND = r102;
        f258820a = new GrouponGeneralBubbleOnShowAction[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public GrouponGeneralBubbleOnShowAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
