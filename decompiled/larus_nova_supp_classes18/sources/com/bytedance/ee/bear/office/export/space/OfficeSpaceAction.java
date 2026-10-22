package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceAction;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "OPEN", "MORE", "SHARE", "DOWNLOAD", "DELETE", "REMOVE_RECENT", "CANCEL_FAVORITE", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSpaceAction extends Enum<OfficeSpaceAction> implements Serializable {
    public static final OfficeSpaceAction CANCEL_FAVORITE = null;
    public static final OfficeSpaceAction DELETE = null;
    public static final OfficeSpaceAction DOWNLOAD = null;
    public static final OfficeSpaceAction MORE = null;
    public static final OfficeSpaceAction OPEN = null;
    public static final OfficeSpaceAction REMOVE_RECENT = null;
    public static final OfficeSpaceAction SHARE = null;
    public static final /* synthetic */ OfficeSpaceAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeSpaceAction> getEntries() {
        return b;
    }

    static {
        OfficeSpaceAction r0 = new OfficeSpaceAction("OPEN", 0);
        OPEN = r0;
        OfficeSpaceAction r1 = new OfficeSpaceAction("MORE", 1);
        MORE = r1;
        OfficeSpaceAction r3 = new OfficeSpaceAction("SHARE", 2);
        SHARE = r3;
        OfficeSpaceAction r5 = new OfficeSpaceAction("DOWNLOAD", 3);
        DOWNLOAD = r5;
        OfficeSpaceAction r7 = new OfficeSpaceAction("DELETE", 4);
        DELETE = r7;
        OfficeSpaceAction r9 = new OfficeSpaceAction("REMOVE_RECENT", 5);
        REMOVE_RECENT = r9;
        OfficeSpaceAction r11 = new OfficeSpaceAction("CANCEL_FAVORITE", 6);
        CANCEL_FAVORITE = r11;
        OfficeSpaceAction[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static OfficeSpaceAction[] values() {
        return (OfficeSpaceAction[]) a.clone();
    }

    public static OfficeSpaceAction valueOf(String r1) {
        return (OfficeSpaceAction) r27.a.a(OfficeSpaceAction.class, r1);
    }

    public OfficeSpaceAction(String r1, int r2) {
        super(r1, r2);
    }
}
