package com.bytedance.ee.bear.more.office;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/more/office/OfficeLongPressLarkAction;", "", "<init>", "(Ljava/lang/String;I)V", "MOVE_TO", "ADD_SHORTCUT", "SECRET_SETTING", "DOWNLOAD", "EXPORT_AS", "RENAME", "MAKE_COPY", "features-more-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeLongPressLarkAction extends Enum<OfficeLongPressLarkAction> {
    public static final OfficeLongPressLarkAction ADD_SHORTCUT = null;
    public static final OfficeLongPressLarkAction DOWNLOAD = null;
    public static final OfficeLongPressLarkAction EXPORT_AS = null;
    public static final OfficeLongPressLarkAction MAKE_COPY = null;
    public static final OfficeLongPressLarkAction MOVE_TO = null;
    public static final OfficeLongPressLarkAction RENAME = null;
    public static final OfficeLongPressLarkAction SECRET_SETTING = null;
    public static final /* synthetic */ OfficeLongPressLarkAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeLongPressLarkAction> getEntries() {
        return b;
    }

    static {
        OfficeLongPressLarkAction r0 = new OfficeLongPressLarkAction("MOVE_TO", 0);
        MOVE_TO = r0;
        OfficeLongPressLarkAction r1 = new OfficeLongPressLarkAction("ADD_SHORTCUT", 1);
        ADD_SHORTCUT = r1;
        OfficeLongPressLarkAction r3 = new OfficeLongPressLarkAction("SECRET_SETTING", 2);
        SECRET_SETTING = r3;
        OfficeLongPressLarkAction r5 = new OfficeLongPressLarkAction("DOWNLOAD", 3);
        DOWNLOAD = r5;
        OfficeLongPressLarkAction r7 = new OfficeLongPressLarkAction("EXPORT_AS", 4);
        EXPORT_AS = r7;
        OfficeLongPressLarkAction r9 = new OfficeLongPressLarkAction("RENAME", 5);
        RENAME = r9;
        OfficeLongPressLarkAction r11 = new OfficeLongPressLarkAction("MAKE_COPY", 6);
        MAKE_COPY = r11;
        OfficeLongPressLarkAction[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static OfficeLongPressLarkAction[] values() {
        return (OfficeLongPressLarkAction[]) a.clone();
    }

    public static OfficeLongPressLarkAction valueOf(String r1) {
        return (OfficeLongPressLarkAction) r27.a.a(OfficeLongPressLarkAction.class, r1);
    }

    public OfficeLongPressLarkAction(String r1, int r2) {
        super(r1, r2);
    }
}
