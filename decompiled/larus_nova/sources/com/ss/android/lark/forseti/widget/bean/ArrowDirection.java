package com.ss.android.lark.forseti.widget.bean;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/forseti/widget/bean/ArrowDirection;", "", "<init>", "(Ljava/lang/String;I)V", "TOP", "BOTTOM", "LEFT", "RIGHT", UserProfileEvent.POSITION_NONE, "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ArrowDirection extends Enum<ArrowDirection> {
    public static final ArrowDirection BOTTOM = null;
    public static final ArrowDirection LEFT = null;
    public static final ArrowDirection NONE = null;
    public static final ArrowDirection RIGHT = null;
    public static final ArrowDirection TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArrowDirection[] f424738a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f424739b = null;

    public static EnumEntries<ArrowDirection> getEntries() {
        return f424739b;
    }

    static {
        ArrowDirection r100 = new ArrowDirection("TOP", 0);
        TOP = r100;
        ArrowDirection r101 = new ArrowDirection("BOTTOM", 1);
        BOTTOM = r101;
        ArrowDirection r102 = new ArrowDirection("LEFT", 2);
        LEFT = r102;
        ArrowDirection r103 = new ArrowDirection("RIGHT", 3);
        RIGHT = r103;
        ArrowDirection r104 = new ArrowDirection(UserProfileEvent.POSITION_NONE, 4);
        NONE = r104;
        ArrowDirection[] r105 = {r100, r101, r102, r103, r104};
        f424738a = r105;
        f424739b = EnumEntriesKt.enumEntries(r105);
    }

    public static ArrowDirection[] values() {
        return (ArrowDirection[]) f424738a.clone();
    }

    public static ArrowDirection valueOf(String r100) {
        return (ArrowDirection) a.a(ArrowDirection.class, r100);
    }

    public ArrowDirection(String r100, int r101) {
        super(r100, r101);
    }
}
