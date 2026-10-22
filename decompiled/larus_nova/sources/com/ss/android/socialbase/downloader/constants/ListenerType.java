package com.ss.android.socialbase.downloader.constants;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.lark.banner.export.entity.BannerBizName;
import r27.a;

/* JADX INFO: loaded from: classes6.dex */
public final enum ListenerType extends Enum<ListenerType> {
    private static final /* synthetic */ ListenerType[] $VALUES = null;
    public static final ListenerType MAIN = null;
    public static final ListenerType NONE = null;
    public static final ListenerType NOTIFICATION = null;
    public static final ListenerType SUB = null;

    static {
        ListenerType r100 = new ListenerType(AccountType.MAIN, 0);
        MAIN = r100;
        ListenerType r101 = new ListenerType("SUB", 1);
        SUB = r101;
        ListenerType r102 = new ListenerType(BannerBizName.NOTIFICATION, 2);
        NOTIFICATION = r102;
        ListenerType r103 = new ListenerType(UserProfileEvent.POSITION_NONE, 3);
        NONE = r103;
        $VALUES = new ListenerType[]{r100, r101, r102, r103};
    }

    public static ListenerType[] values() {
        return (ListenerType[]) $VALUES.clone();
    }

    public static ListenerType valueOf(String r100) {
        return (ListenerType) a.a(ListenerType.class, r100);
    }

    private ListenerType(String r100, int r101) {
        super(r100, r101);
    }
}
