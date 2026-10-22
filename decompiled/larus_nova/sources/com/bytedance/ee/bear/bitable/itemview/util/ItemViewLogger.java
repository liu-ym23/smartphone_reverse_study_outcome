package com.bytedance.ee.bear.bitable.itemview.util;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/util/ItemViewLogger;", "", "<init>", "(Ljava/lang/String;I)V", "ItemViewCellBiz", "ItemViewDefault", "ItemViewLinkTable", "ItemViewBackground", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ItemViewLogger extends Enum<ItemViewLogger> {
    public static final ItemViewLogger ItemViewBackground = null;
    public static final ItemViewLogger ItemViewCellBiz = null;
    public static final ItemViewLogger ItemViewDefault = null;
    public static final ItemViewLogger ItemViewLinkTable = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ItemViewLogger[] f214259a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f214260b = null;

    public static EnumEntries<ItemViewLogger> getEntries() {
        return f214260b;
    }

    static {
        ItemViewLogger r100 = new ItemViewLogger("ItemViewCellBiz", 0);
        ItemViewCellBiz = r100;
        ItemViewLogger r101 = new ItemViewLogger("ItemViewDefault", 1);
        ItemViewDefault = r101;
        ItemViewLogger r102 = new ItemViewLogger("ItemViewLinkTable", 2);
        ItemViewLinkTable = r102;
        ItemViewLogger r103 = new ItemViewLogger("ItemViewBackground", 3);
        ItemViewBackground = r103;
        ItemViewLogger[] r104 = {r100, r101, r102, r103};
        f214259a = r104;
        f214260b = EnumEntriesKt.enumEntries(r104);
    }

    public static ItemViewLogger[] values() {
        return (ItemViewLogger[]) f214259a.clone();
    }

    public static ItemViewLogger valueOf(String r100) {
        return (ItemViewLogger) r27.a.a(ItemViewLogger.class, r100);
    }

    public ItemViewLogger(String r100, int r101) {
        super(r100, r101);
    }
}
