package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceBatchAction;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "DELETE", "REMOVE_RECENT", "CANCEL_FAVORITE", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSpaceBatchAction extends Enum<OfficeSpaceBatchAction> implements Serializable {
    public static final OfficeSpaceBatchAction CANCEL_FAVORITE = null;
    public static final OfficeSpaceBatchAction DELETE = null;
    public static final OfficeSpaceBatchAction REMOVE_RECENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeSpaceBatchAction[] f235455a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f235456b = null;

    public static EnumEntries<OfficeSpaceBatchAction> getEntries() {
        return f235456b;
    }

    static {
        OfficeSpaceBatchAction r100 = new OfficeSpaceBatchAction("DELETE", 0);
        DELETE = r100;
        OfficeSpaceBatchAction r101 = new OfficeSpaceBatchAction("REMOVE_RECENT", 1);
        REMOVE_RECENT = r101;
        OfficeSpaceBatchAction r102 = new OfficeSpaceBatchAction("CANCEL_FAVORITE", 2);
        CANCEL_FAVORITE = r102;
        OfficeSpaceBatchAction[] r103 = {r100, r101, r102};
        f235455a = r103;
        f235456b = EnumEntriesKt.enumEntries(r103);
    }

    public static OfficeSpaceBatchAction[] values() {
        return (OfficeSpaceBatchAction[]) f235455a.clone();
    }

    public static OfficeSpaceBatchAction valueOf(String r100) {
        return (OfficeSpaceBatchAction) r27.a.a(OfficeSpaceBatchAction.class, r100);
    }

    public OfficeSpaceBatchAction(String r100, int r101) {
        super(r100, r101);
    }
}
