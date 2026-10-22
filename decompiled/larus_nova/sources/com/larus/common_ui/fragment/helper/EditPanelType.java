package com.larus.common_ui.fragment.helper;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/common_ui/fragment/helper/EditPanelType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", UserProfileEvent.POSITION_NONE, "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EditPanelType extends Enum<EditPanelType> {
    public static final EditPanelType IMAGE = null;
    public static final EditPanelType NONE = null;
    public static final EditPanelType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EditPanelType[] f327594a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f327595b = null;

    public static EnumEntries<EditPanelType> getEntries() {
        return f327595b;
    }

    static {
        EditPanelType r100 = new EditPanelType("IMAGE", 0);
        IMAGE = r100;
        EditPanelType r101 = new EditPanelType("VIDEO", 1);
        VIDEO = r101;
        EditPanelType r102 = new EditPanelType(UserProfileEvent.POSITION_NONE, 2);
        NONE = r102;
        EditPanelType[] r103 = {r100, r101, r102};
        f327594a = r103;
        f327595b = EnumEntriesKt.enumEntries(r103);
    }

    public static EditPanelType[] values() {
        return (EditPanelType[]) f327594a.clone();
    }

    public static EditPanelType valueOf(String r100) {
        return (EditPanelType) a.a(EditPanelType.class, r100);
    }

    public EditPanelType(String r100, int r101) {
        super(r100, r101);
    }
}
