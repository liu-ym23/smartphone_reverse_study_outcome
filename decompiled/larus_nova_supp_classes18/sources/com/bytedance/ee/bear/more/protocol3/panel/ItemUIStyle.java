package com.bytedance.ee.bear.more.protocol3.panel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/more/protocol3/panel/ItemUIStyle;", "", "<init>", "(Ljava/lang/String;I)V", "FEISHU", "DOUBAO", "features-more-panel-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ItemUIStyle extends Enum<ItemUIStyle> {
    public static final ItemUIStyle DOUBAO = null;
    public static final ItemUIStyle FEISHU = null;
    public static final /* synthetic */ ItemUIStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ItemUIStyle> getEntries() {
        return b;
    }

    static {
        ItemUIStyle r0 = new ItemUIStyle("FEISHU", 0);
        FEISHU = r0;
        ItemUIStyle r1 = new ItemUIStyle("DOUBAO", 1);
        DOUBAO = r1;
        ItemUIStyle[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ItemUIStyle[] values() {
        return (ItemUIStyle[]) a.clone();
    }

    public static ItemUIStyle valueOf(String r1) {
        return (ItemUIStyle) r27.a.a(ItemUIStyle.class, r1);
    }

    public ItemUIStyle(String r1, int r2) {
        super(r1, r2);
    }
}
