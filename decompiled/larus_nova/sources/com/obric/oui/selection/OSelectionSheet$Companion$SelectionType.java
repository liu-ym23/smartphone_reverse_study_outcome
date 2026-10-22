package com.obric.oui.selection;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/obric/oui/selection/OSelectionSheet$Companion$SelectionType", "", "Lcom/obric/oui/selection/OSelectionSheet$Companion$SelectionType;", "SINGLE", "MULTI", UserProfileEvent.POSITION_NONE, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final enum OSelectionSheet$Companion$SelectionType extends Enum<OSelectionSheet$Companion$SelectionType> {
    public static final OSelectionSheet$Companion$SelectionType MULTI = null;
    public static final OSelectionSheet$Companion$SelectionType NONE = null;
    public static final OSelectionSheet$Companion$SelectionType SINGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OSelectionSheet$Companion$SelectionType[] f402793a = null;

    public static OSelectionSheet$Companion$SelectionType valueOf(String r100) {
        return (OSelectionSheet$Companion$SelectionType) a.a(OSelectionSheet$Companion$SelectionType.class, r100);
    }

    public static OSelectionSheet$Companion$SelectionType[] values() {
        return (OSelectionSheet$Companion$SelectionType[]) f402793a.clone();
    }

    static {
        OSelectionSheet$Companion$SelectionType r100 = new OSelectionSheet$Companion$SelectionType("SINGLE", 0);
        SINGLE = r100;
        OSelectionSheet$Companion$SelectionType r101 = new OSelectionSheet$Companion$SelectionType("MULTI", 1);
        MULTI = r101;
        OSelectionSheet$Companion$SelectionType r102 = new OSelectionSheet$Companion$SelectionType(UserProfileEvent.POSITION_NONE, 2);
        NONE = r102;
        f402793a = new OSelectionSheet$Companion$SelectionType[]{r100, r101, r102};
    }

    public OSelectionSheet$Companion$SelectionType(String r100, int r101) {
        super(r100, r101);
    }
}
