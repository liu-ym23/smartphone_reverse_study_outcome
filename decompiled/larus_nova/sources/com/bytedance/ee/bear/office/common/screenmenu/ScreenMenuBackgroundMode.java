package com.bytedance.ee.bear.office.common.screenmenu;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/office/common/screenmenu/ScreenMenuBackgroundMode;", "", "<init>", "(Ljava/lang/String;I)V", "DIM", "BLUR_DIM", UserProfileEvent.POSITION_NONE, "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ScreenMenuBackgroundMode extends Enum<ScreenMenuBackgroundMode> {
    public static final ScreenMenuBackgroundMode BLUR_DIM = null;
    public static final ScreenMenuBackgroundMode DIM = null;
    public static final ScreenMenuBackgroundMode NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScreenMenuBackgroundMode[] f235171a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f235172b = null;

    public static EnumEntries<ScreenMenuBackgroundMode> getEntries() {
        return f235172b;
    }

    static {
        ScreenMenuBackgroundMode r100 = new ScreenMenuBackgroundMode("DIM", 0);
        DIM = r100;
        ScreenMenuBackgroundMode r101 = new ScreenMenuBackgroundMode("BLUR_DIM", 1);
        BLUR_DIM = r101;
        ScreenMenuBackgroundMode r102 = new ScreenMenuBackgroundMode(UserProfileEvent.POSITION_NONE, 2);
        NONE = r102;
        ScreenMenuBackgroundMode[] r103 = {r100, r101, r102};
        f235171a = r103;
        f235172b = EnumEntriesKt.enumEntries(r103);
    }

    public static ScreenMenuBackgroundMode[] values() {
        return (ScreenMenuBackgroundMode[]) f235171a.clone();
    }

    public static ScreenMenuBackgroundMode valueOf(String r100) {
        return (ScreenMenuBackgroundMode) r27.a.a(ScreenMenuBackgroundMode.class, r100);
    }

    public ScreenMenuBackgroundMode(String r100, int r101) {
        super(r100, r101);
    }
}
