package com.bytedance.ee.bear.more.protocol3.panel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/more/protocol3/panel/ItemUIStyle;", "", "<init>", "(Ljava/lang/String;I)V", "FEISHU", "DOUBAO", "features-more-panel-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ItemUIStyle extends Enum<ItemUIStyle> {
    public static final ItemUIStyle DOUBAO = null;
    public static final ItemUIStyle FEISHU = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ItemUIStyle[] f234911a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f234912b = null;

    public static EnumEntries<ItemUIStyle> getEntries() {
        return f234912b;
    }

    static {
        ItemUIStyle r100 = new ItemUIStyle("FEISHU", 0);
        FEISHU = r100;
        ItemUIStyle r101 = new ItemUIStyle("DOUBAO", 1);
        DOUBAO = r101;
        ItemUIStyle[] r102 = {r100, r101};
        f234911a = r102;
        f234912b = EnumEntriesKt.enumEntries(r102);
    }

    public static ItemUIStyle[] values() {
        return (ItemUIStyle[]) f234911a.clone();
    }

    public static ItemUIStyle valueOf(String r100) {
        return (ItemUIStyle) r27.a.a(ItemUIStyle.class, r100);
    }

    public ItemUIStyle(String r100, int r101) {
        super(r100, r101);
    }
}
