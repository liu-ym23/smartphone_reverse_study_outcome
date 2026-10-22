package com.bytedance.ee.bear.drive.biz.comment;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/comment/DriveHeaderCommentEntryAction;", "", "<init>", "(Ljava/lang/String;I)V", "CREATE_CURRENT_PAGE_COMMENT", "OPEN_DEFAULT_ENTRY", "HIDE", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveHeaderCommentEntryAction extends Enum<DriveHeaderCommentEntryAction> {
    public static final DriveHeaderCommentEntryAction CREATE_CURRENT_PAGE_COMMENT = null;
    public static final DriveHeaderCommentEntryAction HIDE = null;
    public static final DriveHeaderCommentEntryAction OPEN_DEFAULT_ENTRY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DriveHeaderCommentEntryAction[] f222666a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f222667b = null;

    public static EnumEntries<DriveHeaderCommentEntryAction> getEntries() {
        return f222667b;
    }

    static {
        DriveHeaderCommentEntryAction r100 = new DriveHeaderCommentEntryAction("CREATE_CURRENT_PAGE_COMMENT", 0);
        CREATE_CURRENT_PAGE_COMMENT = r100;
        DriveHeaderCommentEntryAction r101 = new DriveHeaderCommentEntryAction("OPEN_DEFAULT_ENTRY", 1);
        OPEN_DEFAULT_ENTRY = r101;
        DriveHeaderCommentEntryAction r102 = new DriveHeaderCommentEntryAction("HIDE", 2);
        HIDE = r102;
        DriveHeaderCommentEntryAction[] r103 = {r100, r101, r102};
        f222666a = r103;
        f222667b = EnumEntriesKt.enumEntries(r103);
    }

    public static DriveHeaderCommentEntryAction[] values() {
        return (DriveHeaderCommentEntryAction[]) f222666a.clone();
    }

    public static DriveHeaderCommentEntryAction valueOf(String r100) {
        return (DriveHeaderCommentEntryAction) r27.a.a(DriveHeaderCommentEntryAction.class, r100);
    }

    public DriveHeaderCommentEntryAction(String r100, int r101) {
        super(r100, r101);
    }
}
