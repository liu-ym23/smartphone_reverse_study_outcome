package com.bytedance.locallife.groupon.struct;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/GrouponGeneralBubbleUploadImpressionScene;", "", "", "value", "I", "getValue", "()I", "DISAPPEAR", "CLICK", "DISAPPEAR_OR_CLICK", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum GrouponGeneralBubbleUploadImpressionScene extends Enum<GrouponGeneralBubbleUploadImpressionScene> {
    public static final GrouponGeneralBubbleUploadImpressionScene CLICK = null;
    public static final GrouponGeneralBubbleUploadImpressionScene DISAPPEAR = null;
    public static final GrouponGeneralBubbleUploadImpressionScene DISAPPEAR_OR_CLICK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GrouponGeneralBubbleUploadImpressionScene[] f258822a = null;
    private final int value;

    public static GrouponGeneralBubbleUploadImpressionScene valueOf(String r100) {
        return (GrouponGeneralBubbleUploadImpressionScene) r27.a.a(GrouponGeneralBubbleUploadImpressionScene.class, r100);
    }

    public static GrouponGeneralBubbleUploadImpressionScene[] values() {
        return (GrouponGeneralBubbleUploadImpressionScene[]) f258822a.clone();
    }

    static {
        GrouponGeneralBubbleUploadImpressionScene r100 = new GrouponGeneralBubbleUploadImpressionScene("DISAPPEAR", 0, 1);
        DISAPPEAR = r100;
        GrouponGeneralBubbleUploadImpressionScene r101 = new GrouponGeneralBubbleUploadImpressionScene("CLICK", 1, 2);
        CLICK = r101;
        GrouponGeneralBubbleUploadImpressionScene r102 = new GrouponGeneralBubbleUploadImpressionScene("DISAPPEAR_OR_CLICK", 2, 3);
        DISAPPEAR_OR_CLICK = r102;
        f258822a = new GrouponGeneralBubbleUploadImpressionScene[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public GrouponGeneralBubbleUploadImpressionScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
