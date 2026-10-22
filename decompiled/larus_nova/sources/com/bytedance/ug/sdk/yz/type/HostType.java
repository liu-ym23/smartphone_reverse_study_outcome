package com.bytedance.ug.sdk.yz.type;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum HostType extends Enum<HostType> {
    public static final HostType FM = null;
    public static final HostType NEWS_ARTICLE = null;
    public static final HostType NEWS_ARTICLE_LITE = null;
    public static final HostType NONE = null;
    public static final HostType NOVEL = null;
    public static final HostType WU_KONG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HostType[] f272363a = null;
    public int value;

    static {
        HostType r100 = new HostType("NEWS_ARTICLE", 0, 0);
        NEWS_ARTICLE = r100;
        HostType r101 = new HostType("NOVEL", 1, 1);
        NOVEL = r101;
        HostType r102 = new HostType("FM", 2, 2);
        FM = r102;
        HostType r103 = new HostType("NEWS_ARTICLE_LITE", 3, 3);
        NEWS_ARTICLE_LITE = r103;
        HostType r104 = new HostType("WU_KONG", 4, 4);
        WU_KONG = r104;
        HostType r105 = new HostType(UserProfileEvent.POSITION_NONE, 5, 5);
        NONE = r105;
        f272363a = new HostType[]{r100, r101, r102, r103, r104, r105};
    }

    public static HostType[] values() {
        return (HostType[]) f272363a.clone();
    }

    public static HostType valueOf(String r100) {
        return (HostType) a.a(HostType.class, r100);
    }

    public HostType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
