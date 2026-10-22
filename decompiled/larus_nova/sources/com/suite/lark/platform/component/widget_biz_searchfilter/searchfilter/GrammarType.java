package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/GrammarType;", "", "<init>", "(Ljava/lang/String;I)V", "UnSupport", "From", "With", "InChat", "widget-biz-searchfilter_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GrammarType extends Enum<GrammarType> {
    public static final GrammarType From = null;
    public static final GrammarType InChat = null;
    public static final GrammarType UnSupport = null;
    public static final GrammarType With = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GrammarType[] f460950a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f460951b = null;

    public static EnumEntries<GrammarType> getEntries() {
        return f460951b;
    }

    static {
        GrammarType r100 = new GrammarType("UnSupport", 0);
        UnSupport = r100;
        GrammarType r101 = new GrammarType("From", 1);
        From = r101;
        GrammarType r102 = new GrammarType("With", 2);
        With = r102;
        GrammarType r103 = new GrammarType("InChat", 3);
        InChat = r103;
        GrammarType[] r104 = {r100, r101, r102, r103};
        f460950a = r104;
        f460951b = EnumEntriesKt.enumEntries(r104);
    }

    public static GrammarType[] values() {
        return (GrammarType[]) f460950a.clone();
    }

    public static GrammarType valueOf(String r100) {
        return (GrammarType) r27.a.a(GrammarType.class, r100);
    }

    public GrammarType(String r100, int r101) {
        super(r100, r101);
    }
}
