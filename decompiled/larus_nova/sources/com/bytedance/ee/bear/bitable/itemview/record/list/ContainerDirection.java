package com.bytedance.ee.bear.bitable.itemview.record.list;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/list/ContainerDirection;", "", "<init>", "(Ljava/lang/String;I)V", "VERTICAL", "HORIZONTAL", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContainerDirection extends Enum<ContainerDirection> {
    public static final ContainerDirection HORIZONTAL = null;
    public static final ContainerDirection VERTICAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContainerDirection[] f214087a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f214088b = null;

    public static EnumEntries<ContainerDirection> getEntries() {
        return f214088b;
    }

    static {
        ContainerDirection r100 = new ContainerDirection("VERTICAL", 0);
        VERTICAL = r100;
        ContainerDirection r101 = new ContainerDirection("HORIZONTAL", 1);
        HORIZONTAL = r101;
        ContainerDirection[] r102 = {r100, r101};
        f214087a = r102;
        f214088b = EnumEntriesKt.enumEntries(r102);
    }

    public static ContainerDirection[] values() {
        return (ContainerDirection[]) f214087a.clone();
    }

    public static ContainerDirection valueOf(String r100) {
        return (ContainerDirection) r27.a.a(ContainerDirection.class, r100);
    }

    public ContainerDirection(String r100, int r101) {
        super(r100, r101);
    }
}
