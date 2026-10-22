package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceLongPressAction;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "ASK_DOUBAO", "SHARE", "DOWNLOAD", "EXPORT_AS", "MULTI_SELECT", "FAVORITE", "COPY_LINK", "MORE", "RENAME", "MOVE_TO", "ADD_SHORTCUT", "SECURITY_SETTING", "DELETE", "SORT", "FILTER", "TOGGLE_DISPLAY_MODE", "MAKE_COPY", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSpaceLongPressAction extends Enum<OfficeSpaceLongPressAction> implements Serializable {
    public static final OfficeSpaceLongPressAction ADD_SHORTCUT = null;
    public static final OfficeSpaceLongPressAction ASK_DOUBAO = null;
    public static final OfficeSpaceLongPressAction COPY_LINK = null;
    public static final OfficeSpaceLongPressAction DELETE = null;
    public static final OfficeSpaceLongPressAction DOWNLOAD = null;
    public static final OfficeSpaceLongPressAction EXPORT_AS = null;
    public static final OfficeSpaceLongPressAction FAVORITE = null;
    public static final OfficeSpaceLongPressAction FILTER = null;
    public static final OfficeSpaceLongPressAction MAKE_COPY = null;
    public static final OfficeSpaceLongPressAction MORE = null;
    public static final OfficeSpaceLongPressAction MOVE_TO = null;
    public static final OfficeSpaceLongPressAction MULTI_SELECT = null;
    public static final OfficeSpaceLongPressAction RENAME = null;
    public static final OfficeSpaceLongPressAction SECURITY_SETTING = null;
    public static final OfficeSpaceLongPressAction SHARE = null;
    public static final OfficeSpaceLongPressAction SORT = null;
    public static final OfficeSpaceLongPressAction TOGGLE_DISPLAY_MODE = null;
    public static final /* synthetic */ OfficeSpaceLongPressAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeSpaceLongPressAction> getEntries() {
        return b;
    }

    static {
        OfficeSpaceLongPressAction r0 = new OfficeSpaceLongPressAction("ASK_DOUBAO", 0);
        ASK_DOUBAO = r0;
        OfficeSpaceLongPressAction r1 = new OfficeSpaceLongPressAction("SHARE", 1);
        SHARE = r1;
        OfficeSpaceLongPressAction r3 = new OfficeSpaceLongPressAction("DOWNLOAD", 2);
        DOWNLOAD = r3;
        OfficeSpaceLongPressAction r5 = new OfficeSpaceLongPressAction("EXPORT_AS", 3);
        EXPORT_AS = r5;
        OfficeSpaceLongPressAction r7 = new OfficeSpaceLongPressAction("MULTI_SELECT", 4);
        MULTI_SELECT = r7;
        OfficeSpaceLongPressAction r9 = new OfficeSpaceLongPressAction("FAVORITE", 5);
        FAVORITE = r9;
        OfficeSpaceLongPressAction r11 = new OfficeSpaceLongPressAction("COPY_LINK", 6);
        COPY_LINK = r11;
        OfficeSpaceLongPressAction r13 = new OfficeSpaceLongPressAction("MORE", 7);
        MORE = r13;
        OfficeSpaceLongPressAction r15 = new OfficeSpaceLongPressAction("RENAME", 8);
        RENAME = r15;
        OfficeSpaceLongPressAction r14 = new OfficeSpaceLongPressAction("MOVE_TO", 9);
        MOVE_TO = r14;
        OfficeSpaceLongPressAction r12 = new OfficeSpaceLongPressAction("ADD_SHORTCUT", 10);
        ADD_SHORTCUT = r12;
        OfficeSpaceLongPressAction r10 = new OfficeSpaceLongPressAction("SECURITY_SETTING", 11);
        SECURITY_SETTING = r10;
        OfficeSpaceLongPressAction r8 = new OfficeSpaceLongPressAction("DELETE", 12);
        DELETE = r8;
        OfficeSpaceLongPressAction r6 = new OfficeSpaceLongPressAction("SORT", 13);
        SORT = r6;
        OfficeSpaceLongPressAction r4 = new OfficeSpaceLongPressAction("FILTER", 14);
        FILTER = r4;
        OfficeSpaceLongPressAction r2 = new OfficeSpaceLongPressAction("TOGGLE_DISPLAY_MODE", 15);
        TOGGLE_DISPLAY_MODE = r2;
        OfficeSpaceLongPressAction r16 = new OfficeSpaceLongPressAction("MAKE_COPY", 16);
        MAKE_COPY = r16;
        OfficeSpaceLongPressAction[] r17 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16};
        a = r17;
        b = EnumEntriesKt.enumEntries(r17);
    }

    public static OfficeSpaceLongPressAction[] values() {
        return (OfficeSpaceLongPressAction[]) a.clone();
    }

    public static OfficeSpaceLongPressAction valueOf(String r1) {
        return (OfficeSpaceLongPressAction) r27.a.a(OfficeSpaceLongPressAction.class, r1);
    }

    public OfficeSpaceLongPressAction(String r1, int r2) {
        super(r1, r2);
    }
}
