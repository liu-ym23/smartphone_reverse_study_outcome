package com.bytedance.ee.bear.bitable.loading;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/loading/ELoadingType;", "", "<init>", "(Ljava/lang/String;I)V", "GLOBAL", "GLOBAL_SHARE_RECORD", "GLOBAL_BASE_ADD", "FORM_VIEW", "HEADER", "VIEW_CATALOG", "TOOL_BAR", "VIEW_CONTAINER", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ELoadingType extends Enum<ELoadingType> {
    public static final ELoadingType FORM_VIEW = null;
    public static final ELoadingType GLOBAL = null;
    public static final ELoadingType GLOBAL_BASE_ADD = null;
    public static final ELoadingType GLOBAL_SHARE_RECORD = null;
    public static final ELoadingType HEADER = null;
    public static final ELoadingType TOOL_BAR = null;
    public static final ELoadingType VIEW_CATALOG = null;
    public static final ELoadingType VIEW_CONTAINER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ELoadingType[] f214594a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f214595b = null;

    public static EnumEntries<ELoadingType> getEntries() {
        return f214595b;
    }

    static {
        ELoadingType r100 = new ELoadingType("GLOBAL", 0);
        GLOBAL = r100;
        ELoadingType r101 = new ELoadingType("GLOBAL_SHARE_RECORD", 1);
        GLOBAL_SHARE_RECORD = r101;
        ELoadingType r102 = new ELoadingType("GLOBAL_BASE_ADD", 2);
        GLOBAL_BASE_ADD = r102;
        ELoadingType r103 = new ELoadingType("FORM_VIEW", 3);
        FORM_VIEW = r103;
        ELoadingType r104 = new ELoadingType("HEADER", 4);
        HEADER = r104;
        ELoadingType r105 = new ELoadingType("VIEW_CATALOG", 5);
        VIEW_CATALOG = r105;
        ELoadingType r110 = new ELoadingType("TOOL_BAR", 6);
        TOOL_BAR = r110;
        ELoadingType r111 = new ELoadingType("VIEW_CONTAINER", 7);
        VIEW_CONTAINER = r111;
        ELoadingType[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f214594a = r112;
        f214595b = EnumEntriesKt.enumEntries(r112);
    }

    public static ELoadingType[] values() {
        return (ELoadingType[]) f214594a.clone();
    }

    public static ELoadingType valueOf(String r100) {
        return (ELoadingType) r27.a.a(ELoadingType.class, r100);
    }

    public ELoadingType(String r100, int r101) {
        super(r100, r101);
    }
}
