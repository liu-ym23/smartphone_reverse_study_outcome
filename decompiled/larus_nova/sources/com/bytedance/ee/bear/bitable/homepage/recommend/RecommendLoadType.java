package com.bytedance.ee.bear.bitable.homepage.recommend;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/recommend/RecommendLoadType;", "", "<init>", "(Ljava/lang/String;I)V", "LOAD_FIRST", "LOAD_MORE", "REFRESH", "UNKNOWN", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RecommendLoadType extends Enum<RecommendLoadType> {
    public static final RecommendLoadType LOAD_FIRST = null;
    public static final RecommendLoadType LOAD_MORE = null;
    public static final RecommendLoadType REFRESH = null;
    public static final RecommendLoadType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecommendLoadType[] f213003a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f213004b = null;

    public static EnumEntries<RecommendLoadType> getEntries() {
        return f213004b;
    }

    static {
        RecommendLoadType r100 = new RecommendLoadType("LOAD_FIRST", 0);
        LOAD_FIRST = r100;
        RecommendLoadType r101 = new RecommendLoadType("LOAD_MORE", 1);
        LOAD_MORE = r101;
        RecommendLoadType r102 = new RecommendLoadType("REFRESH", 2);
        REFRESH = r102;
        RecommendLoadType r103 = new RecommendLoadType("UNKNOWN", 3);
        UNKNOWN = r103;
        RecommendLoadType[] r104 = {r100, r101, r102, r103};
        f213003a = r104;
        f213004b = EnumEntriesKt.enumEntries(r104);
    }

    public static RecommendLoadType[] values() {
        return (RecommendLoadType[]) f213003a.clone();
    }

    public static RecommendLoadType valueOf(String r100) {
        return (RecommendLoadType) r27.a.a(RecommendLoadType.class, r100);
    }

    public RecommendLoadType(String r100, int r101) {
        super(r100, r101);
    }
}
