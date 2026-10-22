package com.bytedance.ee.bear.office.list.adapter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0015\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/office/list/adapter/OfficeLongPressMenuAction;", "", "<init>", "(Ljava/lang/String;I)V", "ASK_DOUBAO", "SHARE", "DOWNLOAD", "EXPORT_AS", "MULTI_SELECT", "STAR", "COPY_LINK", "MORE", "RENAME", "MAKE_COPY", "MOVE_TO", "ADD_SHORTCUT", "SECRET_SETTING", "DELETE_SOURCE", "REMOVE_RECENT", "SORT", "FILTER", "TOGGLE_DISPLAY_MODE", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeLongPressMenuAction extends Enum<OfficeLongPressMenuAction> {
    public static final OfficeLongPressMenuAction ADD_SHORTCUT = null;
    public static final OfficeLongPressMenuAction ASK_DOUBAO = null;
    public static final OfficeLongPressMenuAction COPY_LINK = null;
    public static final OfficeLongPressMenuAction DELETE_SOURCE = null;
    public static final OfficeLongPressMenuAction DOWNLOAD = null;
    public static final OfficeLongPressMenuAction EXPORT_AS = null;
    public static final OfficeLongPressMenuAction FILTER = null;
    public static final OfficeLongPressMenuAction MAKE_COPY = null;
    public static final OfficeLongPressMenuAction MORE = null;
    public static final OfficeLongPressMenuAction MOVE_TO = null;
    public static final OfficeLongPressMenuAction MULTI_SELECT = null;
    public static final OfficeLongPressMenuAction REMOVE_RECENT = null;
    public static final OfficeLongPressMenuAction RENAME = null;
    public static final OfficeLongPressMenuAction SECRET_SETTING = null;
    public static final OfficeLongPressMenuAction SHARE = null;
    public static final OfficeLongPressMenuAction SORT = null;
    public static final OfficeLongPressMenuAction STAR = null;
    public static final OfficeLongPressMenuAction TOGGLE_DISPLAY_MODE = null;
    public static final /* synthetic */ OfficeLongPressMenuAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeLongPressMenuAction> getEntries() {
        return b;
    }

    static {
        OfficeLongPressMenuAction r0 = new OfficeLongPressMenuAction("ASK_DOUBAO", 0);
        ASK_DOUBAO = r0;
        OfficeLongPressMenuAction r1 = new OfficeLongPressMenuAction("SHARE", 1);
        SHARE = r1;
        OfficeLongPressMenuAction r3 = new OfficeLongPressMenuAction("DOWNLOAD", 2);
        DOWNLOAD = r3;
        OfficeLongPressMenuAction r5 = new OfficeLongPressMenuAction("EXPORT_AS", 3);
        EXPORT_AS = r5;
        OfficeLongPressMenuAction r7 = new OfficeLongPressMenuAction("MULTI_SELECT", 4);
        MULTI_SELECT = r7;
        OfficeLongPressMenuAction r9 = new OfficeLongPressMenuAction("STAR", 5);
        STAR = r9;
        OfficeLongPressMenuAction r11 = new OfficeLongPressMenuAction("COPY_LINK", 6);
        COPY_LINK = r11;
        OfficeLongPressMenuAction r13 = new OfficeLongPressMenuAction("MORE", 7);
        MORE = r13;
        OfficeLongPressMenuAction r15 = new OfficeLongPressMenuAction("RENAME", 8);
        RENAME = r15;
        OfficeLongPressMenuAction r14 = new OfficeLongPressMenuAction("MAKE_COPY", 9);
        MAKE_COPY = r14;
        OfficeLongPressMenuAction r12 = new OfficeLongPressMenuAction("MOVE_TO", 10);
        MOVE_TO = r12;
        OfficeLongPressMenuAction r10 = new OfficeLongPressMenuAction("ADD_SHORTCUT", 11);
        ADD_SHORTCUT = r10;
        OfficeLongPressMenuAction r8 = new OfficeLongPressMenuAction("SECRET_SETTING", 12);
        SECRET_SETTING = r8;
        OfficeLongPressMenuAction r6 = new OfficeLongPressMenuAction("DELETE_SOURCE", 13);
        DELETE_SOURCE = r6;
        OfficeLongPressMenuAction r4 = new OfficeLongPressMenuAction("REMOVE_RECENT", 14);
        REMOVE_RECENT = r4;
        OfficeLongPressMenuAction r2 = new OfficeLongPressMenuAction("SORT", 15);
        SORT = r2;
        OfficeLongPressMenuAction r16 = new OfficeLongPressMenuAction("FILTER", 16);
        FILTER = r16;
        OfficeLongPressMenuAction r17 = new OfficeLongPressMenuAction("TOGGLE_DISPLAY_MODE", 17);
        TOGGLE_DISPLAY_MODE = r17;
        OfficeLongPressMenuAction[] r18 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17};
        a = r18;
        b = EnumEntriesKt.enumEntries(r18);
    }

    public static OfficeLongPressMenuAction[] values() {
        return (OfficeLongPressMenuAction[]) a.clone();
    }

    public static OfficeLongPressMenuAction valueOf(String r1) {
        return (OfficeLongPressMenuAction) r27.a.a(OfficeLongPressMenuAction.class, r1);
    }

    public OfficeLongPressMenuAction(String r1, int r2) {
        super(r1, r2);
    }
}
