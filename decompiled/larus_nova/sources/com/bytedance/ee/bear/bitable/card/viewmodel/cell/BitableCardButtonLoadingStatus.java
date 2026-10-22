package com.bytedance.ee.bear.bitable.card.viewmodel.cell;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/viewmodel/cell/BitableCardButtonLoadingStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Default", "Loading", "Done", "Disabled", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitableCardButtonLoadingStatus extends Enum<BitableCardButtonLoadingStatus> {
    public static final BitableCardButtonLoadingStatus Default = null;
    public static final BitableCardButtonLoadingStatus Disabled = null;
    public static final BitableCardButtonLoadingStatus Done = null;
    public static final BitableCardButtonLoadingStatus Loading = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BitableCardButtonLoadingStatus[] f209002a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f209003b = null;

    public static EnumEntries<BitableCardButtonLoadingStatus> getEntries() {
        return f209003b;
    }

    static {
        BitableCardButtonLoadingStatus r100 = new BitableCardButtonLoadingStatus("Default", 0);
        Default = r100;
        BitableCardButtonLoadingStatus r101 = new BitableCardButtonLoadingStatus("Loading", 1);
        Loading = r101;
        BitableCardButtonLoadingStatus r102 = new BitableCardButtonLoadingStatus("Done", 2);
        Done = r102;
        BitableCardButtonLoadingStatus r103 = new BitableCardButtonLoadingStatus("Disabled", 3);
        Disabled = r103;
        BitableCardButtonLoadingStatus[] r104 = {r100, r101, r102, r103};
        f209002a = r104;
        f209003b = EnumEntriesKt.enumEntries(r104);
    }

    public static BitableCardButtonLoadingStatus[] values() {
        return (BitableCardButtonLoadingStatus[]) f209002a.clone();
    }

    public static BitableCardButtonLoadingStatus valueOf(String r100) {
        return (BitableCardButtonLoadingStatus) r27.a.a(BitableCardButtonLoadingStatus.class, r100);
    }

    public BitableCardButtonLoadingStatus(String r100, int r101) {
        super(r100, r101);
    }
}
