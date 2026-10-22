package com.bytedance.locallife.groupon.struct;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/GrouponGeneralBubbleAction;", "", "", "value", "I", "getValue", "()I", "ACTION_UNKNOWN", "ACTION_SHOW_BUBBLE", "ACTION_HIDE_BUBBLE", "ACTION_SHOW_DOT", "ACTION_UPDATE_DOT", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum GrouponGeneralBubbleAction extends Enum<GrouponGeneralBubbleAction> {
    public static final GrouponGeneralBubbleAction ACTION_HIDE_BUBBLE = null;
    public static final GrouponGeneralBubbleAction ACTION_SHOW_BUBBLE = null;
    public static final GrouponGeneralBubbleAction ACTION_SHOW_DOT = null;
    public static final GrouponGeneralBubbleAction ACTION_UNKNOWN = null;
    public static final GrouponGeneralBubbleAction ACTION_UPDATE_DOT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GrouponGeneralBubbleAction[] f258818a = null;
    private final int value;

    public static GrouponGeneralBubbleAction valueOf(String r100) {
        return (GrouponGeneralBubbleAction) r27.a.a(GrouponGeneralBubbleAction.class, r100);
    }

    public static GrouponGeneralBubbleAction[] values() {
        return (GrouponGeneralBubbleAction[]) f258818a.clone();
    }

    static {
        GrouponGeneralBubbleAction r100 = new GrouponGeneralBubbleAction("ACTION_UNKNOWN", 0, 0);
        ACTION_UNKNOWN = r100;
        GrouponGeneralBubbleAction r101 = new GrouponGeneralBubbleAction("ACTION_SHOW_BUBBLE", 1, 1);
        ACTION_SHOW_BUBBLE = r101;
        GrouponGeneralBubbleAction r102 = new GrouponGeneralBubbleAction("ACTION_HIDE_BUBBLE", 2, 2);
        ACTION_HIDE_BUBBLE = r102;
        GrouponGeneralBubbleAction r103 = new GrouponGeneralBubbleAction("ACTION_SHOW_DOT", 3, 3);
        ACTION_SHOW_DOT = r103;
        GrouponGeneralBubbleAction r104 = new GrouponGeneralBubbleAction("ACTION_UPDATE_DOT", 4, 4);
        ACTION_UPDATE_DOT = r104;
        f258818a = new GrouponGeneralBubbleAction[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public GrouponGeneralBubbleAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
