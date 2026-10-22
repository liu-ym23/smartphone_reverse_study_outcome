package com.bytedance.ee.bear.list.list.multiselect;

import com.ss.android.download.api.config.HttpMethod;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
public final enum ListSelectPanelAction extends Enum<ListSelectPanelAction> {
    public static final ListSelectPanelAction ADD_SHORTCUT = null;
    public static final ListSelectPanelAction CANCEL_FAVORITE = null;
    public static final ListSelectPanelAction CREATE_COPY = null;
    public static final ListSelectPanelAction DELETE_SOURCE = null;
    public static final ListSelectPanelAction DOWNLOAD = null;
    public static final ListSelectPanelAction FOLLOW_UPDATE = null;
    public static final ListSelectPanelAction MOVE_TO = null;
    public static final ListSelectPanelAction OFFLINE = null;
    public static final ListSelectPanelAction REMOVE_RECENT = null;
    public static final ListSelectPanelAction RENAME = null;
    public static final ListSelectPanelAction SECURITY_LEVEL = null;
    public static final ListSelectPanelAction SHARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ListSelectPanelAction[] f228607a = null;

    static {
        ListSelectPanelAction r100 = new ListSelectPanelAction("SHARE", 0);
        SHARE = r100;
        ListSelectPanelAction r101 = new ListSelectPanelAction(HttpMethod.DOWNLOAD, 1);
        DOWNLOAD = r101;
        ListSelectPanelAction r102 = new ListSelectPanelAction("RENAME", 2);
        RENAME = r102;
        ListSelectPanelAction r103 = new ListSelectPanelAction("MOVE_TO", 3);
        MOVE_TO = r103;
        ListSelectPanelAction r104 = new ListSelectPanelAction("DELETE_SOURCE", 4);
        DELETE_SOURCE = r104;
        ListSelectPanelAction r105 = new ListSelectPanelAction("REMOVE_RECENT", 5);
        REMOVE_RECENT = r105;
        ListSelectPanelAction r110 = new ListSelectPanelAction("CANCEL_FAVORITE", 6);
        CANCEL_FAVORITE = r110;
        ListSelectPanelAction r111 = new ListSelectPanelAction("CREATE_COPY", 7);
        CREATE_COPY = r111;
        ListSelectPanelAction r112 = new ListSelectPanelAction("ADD_SHORTCUT", 8);
        ADD_SHORTCUT = r112;
        ListSelectPanelAction r113 = new ListSelectPanelAction("OFFLINE", 9);
        OFFLINE = r113;
        ListSelectPanelAction r114 = new ListSelectPanelAction("FOLLOW_UPDATE", 10);
        FOLLOW_UPDATE = r114;
        ListSelectPanelAction r115 = new ListSelectPanelAction("SECURITY_LEVEL", 11);
        SECURITY_LEVEL = r115;
        f228607a = new ListSelectPanelAction[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
    }

    public static ListSelectPanelAction[] values() {
        return (ListSelectPanelAction[]) f228607a.clone();
    }

    public static ListSelectPanelAction valueOf(String r100) {
        return (ListSelectPanelAction) a.a(ListSelectPanelAction.class, r100);
    }

    public ListSelectPanelAction(String r100, int r101) {
        super(r100, r101);
    }
}
