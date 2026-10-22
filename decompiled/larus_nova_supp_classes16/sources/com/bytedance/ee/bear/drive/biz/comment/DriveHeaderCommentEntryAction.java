package com.bytedance.ee.bear.drive.biz.comment;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/comment/DriveHeaderCommentEntryAction;", "", "<init>", "(Ljava/lang/String;I)V", "CREATE_CURRENT_PAGE_COMMENT", "OPEN_DEFAULT_ENTRY", "HIDE", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveHeaderCommentEntryAction extends Enum<DriveHeaderCommentEntryAction> {
    public static final DriveHeaderCommentEntryAction CREATE_CURRENT_PAGE_COMMENT = null;
    public static final DriveHeaderCommentEntryAction HIDE = null;
    public static final DriveHeaderCommentEntryAction OPEN_DEFAULT_ENTRY = null;
    public static final /* synthetic */ DriveHeaderCommentEntryAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DriveHeaderCommentEntryAction> getEntries() {
        return b;
    }

    static {
        DriveHeaderCommentEntryAction r0 = new DriveHeaderCommentEntryAction("CREATE_CURRENT_PAGE_COMMENT", 0);
        CREATE_CURRENT_PAGE_COMMENT = r0;
        DriveHeaderCommentEntryAction r1 = new DriveHeaderCommentEntryAction("OPEN_DEFAULT_ENTRY", 1);
        OPEN_DEFAULT_ENTRY = r1;
        DriveHeaderCommentEntryAction r3 = new DriveHeaderCommentEntryAction("HIDE", 2);
        HIDE = r3;
        DriveHeaderCommentEntryAction[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static DriveHeaderCommentEntryAction[] values() {
        return (DriveHeaderCommentEntryAction[]) a.clone();
    }

    public static DriveHeaderCommentEntryAction valueOf(String r1) {
        return (DriveHeaderCommentEntryAction) r27.a.a(DriveHeaderCommentEntryAction.class, r1);
    }

    public DriveHeaderCommentEntryAction(String r1, int r2) {
        super(r1, r2);
    }
}
