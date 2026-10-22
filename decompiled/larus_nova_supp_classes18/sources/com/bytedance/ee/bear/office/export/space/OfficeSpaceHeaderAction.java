package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderAction;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "OPEN_MENU", "SEARCH", "CREATE_DOC", "CREATE_PPT", "CREATE_SHEET", "CREATE_BITABLE", "CREATE_FOLDER", "UPLOAD_IMAGE", "UPLOAD_FILE", "SELECT", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSpaceHeaderAction extends Enum<OfficeSpaceHeaderAction> implements Serializable {
    public static final OfficeSpaceHeaderAction CREATE_BITABLE = null;
    public static final OfficeSpaceHeaderAction CREATE_DOC = null;
    public static final OfficeSpaceHeaderAction CREATE_FOLDER = null;
    public static final OfficeSpaceHeaderAction CREATE_PPT = null;
    public static final OfficeSpaceHeaderAction CREATE_SHEET = null;
    public static final OfficeSpaceHeaderAction OPEN_MENU = null;
    public static final OfficeSpaceHeaderAction SEARCH = null;
    public static final OfficeSpaceHeaderAction SELECT = null;
    public static final OfficeSpaceHeaderAction UPLOAD_FILE = null;
    public static final OfficeSpaceHeaderAction UPLOAD_IMAGE = null;
    public static final /* synthetic */ OfficeSpaceHeaderAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeSpaceHeaderAction> getEntries() {
        return b;
    }

    static {
        OfficeSpaceHeaderAction r0 = new OfficeSpaceHeaderAction("OPEN_MENU", 0);
        OPEN_MENU = r0;
        OfficeSpaceHeaderAction r1 = new OfficeSpaceHeaderAction("SEARCH", 1);
        SEARCH = r1;
        OfficeSpaceHeaderAction r3 = new OfficeSpaceHeaderAction("CREATE_DOC", 2);
        CREATE_DOC = r3;
        OfficeSpaceHeaderAction r5 = new OfficeSpaceHeaderAction("CREATE_PPT", 3);
        CREATE_PPT = r5;
        OfficeSpaceHeaderAction r7 = new OfficeSpaceHeaderAction("CREATE_SHEET", 4);
        CREATE_SHEET = r7;
        OfficeSpaceHeaderAction r9 = new OfficeSpaceHeaderAction("CREATE_BITABLE", 5);
        CREATE_BITABLE = r9;
        OfficeSpaceHeaderAction r11 = new OfficeSpaceHeaderAction("CREATE_FOLDER", 6);
        CREATE_FOLDER = r11;
        OfficeSpaceHeaderAction r13 = new OfficeSpaceHeaderAction("UPLOAD_IMAGE", 7);
        UPLOAD_IMAGE = r13;
        OfficeSpaceHeaderAction r15 = new OfficeSpaceHeaderAction("UPLOAD_FILE", 8);
        UPLOAD_FILE = r15;
        OfficeSpaceHeaderAction r14 = new OfficeSpaceHeaderAction("SELECT", 9);
        SELECT = r14;
        OfficeSpaceHeaderAction[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static OfficeSpaceHeaderAction[] values() {
        return (OfficeSpaceHeaderAction[]) a.clone();
    }

    public static OfficeSpaceHeaderAction valueOf(String r1) {
        return (OfficeSpaceHeaderAction) r27.a.a(OfficeSpaceHeaderAction.class, r1);
    }

    public OfficeSpaceHeaderAction(String r1, int r2) {
        super(r1, r2);
    }
}
