package com.bytedance.ug.sdk.share.impl.model;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;

/* JADX INFO: loaded from: classes22.dex */
public final enum ShareTokenType extends Enum<ShareTokenType> {
    public static final ShareTokenType IMAGE = null;
    public static final ShareTokenType TEXT = null;
    public static final ShareTokenType TEXT_SYS_OPT = null;
    public static final ShareTokenType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShareTokenType[] f272356a = null;

    static {
        ShareTokenType r100 = new ShareTokenType("IMAGE", 0);
        IMAGE = r100;
        ShareTokenType r101 = new ShareTokenType("VIDEO", 1);
        VIDEO = r101;
        ShareTokenType r102 = new ShareTokenType(CardAdapter.TEXT, 2);
        TEXT = r102;
        ShareTokenType r103 = new ShareTokenType("TEXT_SYS_OPT", 3);
        TEXT_SYS_OPT = r103;
        f272356a = new ShareTokenType[]{r100, r101, r102, r103};
    }

    public static ShareTokenType[] values() {
        return (ShareTokenType[]) f272356a.clone();
    }

    public static ShareTokenType valueOf(String r100) {
        return (ShareTokenType) r27.a.a(ShareTokenType.class, r100);
    }

    public ShareTokenType(String r100, int r101) {
        super(r100, r101);
    }
}
