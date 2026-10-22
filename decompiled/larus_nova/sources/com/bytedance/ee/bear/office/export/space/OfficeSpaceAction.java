package com.bytedance.ee.bear.office.export.space;

import com.ss.android.download.api.config.HttpMethod;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceAction;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "OPEN", "MORE", "SHARE", HttpMethod.DOWNLOAD, "DELETE", "REMOVE_RECENT", "CANCEL_FAVORITE", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSpaceAction extends Enum<OfficeSpaceAction> implements Serializable {
    public static final OfficeSpaceAction CANCEL_FAVORITE = null;
    public static final OfficeSpaceAction DELETE = null;
    public static final OfficeSpaceAction DOWNLOAD = null;
    public static final OfficeSpaceAction MORE = null;
    public static final OfficeSpaceAction OPEN = null;
    public static final OfficeSpaceAction REMOVE_RECENT = null;
    public static final OfficeSpaceAction SHARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeSpaceAction[] f235453a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f235454b = null;

    public static EnumEntries<OfficeSpaceAction> getEntries() {
        return f235454b;
    }

    static {
        OfficeSpaceAction r100 = new OfficeSpaceAction("OPEN", 0);
        OPEN = r100;
        OfficeSpaceAction r101 = new OfficeSpaceAction("MORE", 1);
        MORE = r101;
        OfficeSpaceAction r102 = new OfficeSpaceAction("SHARE", 2);
        SHARE = r102;
        OfficeSpaceAction r103 = new OfficeSpaceAction(HttpMethod.DOWNLOAD, 3);
        DOWNLOAD = r103;
        OfficeSpaceAction r104 = new OfficeSpaceAction("DELETE", 4);
        DELETE = r104;
        OfficeSpaceAction r105 = new OfficeSpaceAction("REMOVE_RECENT", 5);
        REMOVE_RECENT = r105;
        OfficeSpaceAction r110 = new OfficeSpaceAction("CANCEL_FAVORITE", 6);
        CANCEL_FAVORITE = r110;
        OfficeSpaceAction[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f235453a = r111;
        f235454b = EnumEntriesKt.enumEntries(r111);
    }

    public static OfficeSpaceAction[] values() {
        return (OfficeSpaceAction[]) f235453a.clone();
    }

    public static OfficeSpaceAction valueOf(String r100) {
        return (OfficeSpaceAction) r27.a.a(OfficeSpaceAction.class, r100);
    }

    public OfficeSpaceAction(String r100, int r101) {
        super(r100, r101);
    }
}
