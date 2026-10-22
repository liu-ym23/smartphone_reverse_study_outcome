package com.ss.android.lark.floating.enums;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/floating/enums/SideHideDirection;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "LEFT", "RIGHT", "float_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SideHideDirection extends Enum<SideHideDirection> {
    public static final SideHideDirection LEFT = null;
    public static final SideHideDirection NONE = null;
    public static final SideHideDirection RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SideHideDirection[] f421853a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f421854b = null;

    public static EnumEntries<SideHideDirection> getEntries() {
        return f421854b;
    }

    static {
        SideHideDirection r100 = new SideHideDirection(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        SideHideDirection r101 = new SideHideDirection("LEFT", 1);
        LEFT = r101;
        SideHideDirection r102 = new SideHideDirection("RIGHT", 2);
        RIGHT = r102;
        SideHideDirection[] r103 = {r100, r101, r102};
        f421853a = r103;
        f421854b = EnumEntriesKt.enumEntries(r103);
    }

    public static SideHideDirection[] values() {
        return (SideHideDirection[]) f421853a.clone();
    }

    public static SideHideDirection valueOf(String r100) {
        return (SideHideDirection) a.a(SideHideDirection.class, r100);
    }

    public SideHideDirection(String r100, int r101) {
        super(r100, r101);
    }
}
