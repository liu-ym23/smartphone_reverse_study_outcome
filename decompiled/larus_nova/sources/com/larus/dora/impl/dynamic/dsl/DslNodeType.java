package com.larus.dora.impl.dynamic.dsl;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/dynamic/dsl/DslNodeType;", "", "<init>", "(Ljava/lang/String;I)V", "PAGE", "LAYER", "CARD", "TABS", "TAB", "SUBPAGE", "SUBPAGES", "NAV_BAR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DslNodeType extends Enum<DslNodeType> {

    @SerializedName(BrowserDependency.UrlClickType.CARD)
    public static final DslNodeType CARD = null;

    @SerializedName(GXTemplateKey.GAIAX_LAYER)
    public static final DslNodeType LAYER = null;

    @SerializedName("nav_bar")
    public static final DslNodeType NAV_BAR = null;

    @SerializedName("page")
    public static final DslNodeType PAGE = null;

    @SerializedName("subpage")
    public static final DslNodeType SUBPAGE = null;

    @SerializedName("subpages")
    public static final DslNodeType SUBPAGES = null;

    @SerializedName("tab")
    public static final DslNodeType TAB = null;

    @SerializedName("tabs")
    public static final DslNodeType TABS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DslNodeType[] f335167a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335168b = null;

    public static EnumEntries<DslNodeType> getEntries() {
        return f335168b;
    }

    static {
        DslNodeType r100 = new DslNodeType("PAGE", 0);
        PAGE = r100;
        DslNodeType r101 = new DslNodeType("LAYER", 1);
        LAYER = r101;
        DslNodeType r102 = new DslNodeType("CARD", 2);
        CARD = r102;
        DslNodeType r103 = new DslNodeType("TABS", 3);
        TABS = r103;
        DslNodeType r104 = new DslNodeType("TAB", 4);
        TAB = r104;
        DslNodeType r105 = new DslNodeType("SUBPAGE", 5);
        SUBPAGE = r105;
        DslNodeType r110 = new DslNodeType("SUBPAGES", 6);
        SUBPAGES = r110;
        DslNodeType r111 = new DslNodeType("NAV_BAR", 7);
        NAV_BAR = r111;
        DslNodeType[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f335167a = r112;
        f335168b = EnumEntriesKt.enumEntries(r112);
    }

    public static DslNodeType[] values() {
        return (DslNodeType[]) f335167a.clone();
    }

    public static DslNodeType valueOf(String r100) {
        return (DslNodeType) r27.a.a(DslNodeType.class, r100);
    }

    public DslNodeType(String r100, int r101) {
        super(r100, r101);
    }
}
