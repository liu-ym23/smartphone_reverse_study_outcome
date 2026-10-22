package com.bytedance.ug.sdk.share.api.entity;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.obric.miniapp.alarm.AccountType;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum ShareContentType extends Enum<ShareContentType> {
    public static final ShareContentType ALL = null;
    public static final ShareContentType AUDIO = null;
    public static final ShareContentType FILE = null;
    public static final ShareContentType H5 = null;
    public static final ShareContentType IMAGE = null;
    public static final ShareContentType MINI_APP = null;
    public static final ShareContentType SUPER_GROUP = null;
    public static final ShareContentType TEXT = null;
    public static final ShareContentType TEXT_IMAGE = null;
    public static final ShareContentType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShareContentType[] f272308a = null;
    private final String mTypeName;

    static {
        ShareContentType r100 = new ShareContentType("H5", 0, "h5");
        H5 = r100;
        ShareContentType r101 = new ShareContentType(CardAdapter.TEXT, 1, "text");
        TEXT = r101;
        ShareContentType r102 = new ShareContentType("IMAGE", 2, "image");
        IMAGE = r102;
        ShareContentType r103 = new ShareContentType("TEXT_IMAGE", 3, "text_image");
        TEXT_IMAGE = r103;
        ShareContentType r104 = new ShareContentType("VIDEO", 4, "video");
        VIDEO = r104;
        ShareContentType r105 = new ShareContentType("FILE", 5, "file");
        FILE = r105;
        ShareContentType r110 = new ShareContentType("MINI_APP", 6, "miniapp");
        MINI_APP = r110;
        ShareContentType r111 = new ShareContentType("AUDIO", 7, "music");
        AUDIO = r111;
        ShareContentType r112 = new ShareContentType("SUPER_GROUP", 8, "share_group");
        SUPER_GROUP = r112;
        ShareContentType r113 = new ShareContentType(AccountType.ALL, 9, "all");
        ALL = r113;
        f272308a = new ShareContentType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static ShareContentType[] values() {
        return (ShareContentType[]) f272308a.clone();
    }

    public String getTypeName() {
        return this.mTypeName;
    }

    public static ShareContentType valueOf(String r100) {
        return (ShareContentType) a.a(ShareContentType.class, r100);
    }

    public ShareContentType(String r100, int r101, String r102) {
        super(r100, r101);
        this.mTypeName = r102;
    }
}
