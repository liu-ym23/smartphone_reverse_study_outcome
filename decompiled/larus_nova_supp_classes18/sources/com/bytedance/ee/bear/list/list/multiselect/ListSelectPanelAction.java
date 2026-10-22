package com.bytedance.ee.bear.list.list.multiselect;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
    public static final /* synthetic */ ListSelectPanelAction[] a = null;

    static {
        ListSelectPanelAction r0 = new ListSelectPanelAction("SHARE", 0);
        SHARE = r0;
        ListSelectPanelAction r1 = new ListSelectPanelAction("DOWNLOAD", 1);
        DOWNLOAD = r1;
        ListSelectPanelAction r3 = new ListSelectPanelAction("RENAME", 2);
        RENAME = r3;
        ListSelectPanelAction r5 = new ListSelectPanelAction("MOVE_TO", 3);
        MOVE_TO = r5;
        ListSelectPanelAction r7 = new ListSelectPanelAction("DELETE_SOURCE", 4);
        DELETE_SOURCE = r7;
        ListSelectPanelAction r9 = new ListSelectPanelAction("REMOVE_RECENT", 5);
        REMOVE_RECENT = r9;
        ListSelectPanelAction r11 = new ListSelectPanelAction("CANCEL_FAVORITE", 6);
        CANCEL_FAVORITE = r11;
        ListSelectPanelAction r13 = new ListSelectPanelAction("CREATE_COPY", 7);
        CREATE_COPY = r13;
        ListSelectPanelAction r15 = new ListSelectPanelAction("ADD_SHORTCUT", 8);
        ADD_SHORTCUT = r15;
        ListSelectPanelAction r14 = new ListSelectPanelAction("OFFLINE", 9);
        OFFLINE = r14;
        ListSelectPanelAction r12 = new ListSelectPanelAction("FOLLOW_UPDATE", 10);
        FOLLOW_UPDATE = r12;
        ListSelectPanelAction r10 = new ListSelectPanelAction("SECURITY_LEVEL", 11);
        SECURITY_LEVEL = r10;
        a = new ListSelectPanelAction[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
    }

    public static ListSelectPanelAction[] values() {
        return (ListSelectPanelAction[]) a.clone();
    }

    public static ListSelectPanelAction valueOf(String r1) {
        return (ListSelectPanelAction) a.a(ListSelectPanelAction.class, r1);
    }

    public ListSelectPanelAction(String r1, int r2) {
        super(r1, r2);
    }
}
