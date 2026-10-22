package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/PageType;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "FLOAT", "BOTTOM_SHEET", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PageType extends Enum<PageType> {
    public static final PageType BOTTOM_SHEET = null;
    public static final PageType FLOAT = null;
    public static final PageType NORMAL = null;
    public static final /* synthetic */ PageType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PageType> getEntries() {
        return b;
    }

    static {
        PageType r0 = new PageType("NORMAL", 0);
        NORMAL = r0;
        PageType r1 = new PageType("FLOAT", 1);
        FLOAT = r1;
        PageType r3 = new PageType("BOTTOM_SHEET", 2);
        BOTTOM_SHEET = r3;
        PageType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static PageType[] values() {
        return (PageType[]) a.clone();
    }

    public static PageType valueOf(String r1) {
        return (PageType) r27.a.a(PageType.class, r1);
    }

    public PageType(String r1, int r2) {
        super(r1, r2);
    }
}
