package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceBatchAction;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "DELETE", "REMOVE_RECENT", "CANCEL_FAVORITE", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSpaceBatchAction extends Enum<OfficeSpaceBatchAction> implements Serializable {
    public static final OfficeSpaceBatchAction CANCEL_FAVORITE = null;
    public static final OfficeSpaceBatchAction DELETE = null;
    public static final OfficeSpaceBatchAction REMOVE_RECENT = null;
    public static final /* synthetic */ OfficeSpaceBatchAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeSpaceBatchAction> getEntries() {
        return b;
    }

    static {
        OfficeSpaceBatchAction r0 = new OfficeSpaceBatchAction("DELETE", 0);
        DELETE = r0;
        OfficeSpaceBatchAction r1 = new OfficeSpaceBatchAction("REMOVE_RECENT", 1);
        REMOVE_RECENT = r1;
        OfficeSpaceBatchAction r3 = new OfficeSpaceBatchAction("CANCEL_FAVORITE", 2);
        CANCEL_FAVORITE = r3;
        OfficeSpaceBatchAction[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static OfficeSpaceBatchAction[] values() {
        return (OfficeSpaceBatchAction[]) a.clone();
    }

    public static OfficeSpaceBatchAction valueOf(String r1) {
        return (OfficeSpaceBatchAction) r27.a.a(OfficeSpaceBatchAction.class, r1);
    }

    public OfficeSpaceBatchAction(String r1, int r2) {
        super(r1, r2);
    }
}
