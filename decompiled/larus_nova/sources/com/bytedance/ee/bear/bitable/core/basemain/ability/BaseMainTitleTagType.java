package com.bytedance.ee.bear.bitable.core.basemain.ability;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/core/basemain/ability/BaseMainTitleTagType;", "", "<init>", "(Ljava/lang/String;I)V", "EXTERNAL", "TEMPLATE", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BaseMainTitleTagType extends Enum<BaseMainTitleTagType> {
    public static final BaseMainTitleTagType EXTERNAL = null;
    public static final BaseMainTitleTagType TEMPLATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BaseMainTitleTagType[] f210114a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f210115b = null;

    public static EnumEntries<BaseMainTitleTagType> getEntries() {
        return f210115b;
    }

    static {
        BaseMainTitleTagType r100 = new BaseMainTitleTagType("EXTERNAL", 0);
        EXTERNAL = r100;
        BaseMainTitleTagType r101 = new BaseMainTitleTagType("TEMPLATE", 1);
        TEMPLATE = r101;
        BaseMainTitleTagType[] r102 = {r100, r101};
        f210114a = r102;
        f210115b = EnumEntriesKt.enumEntries(r102);
    }

    public static BaseMainTitleTagType[] values() {
        return (BaseMainTitleTagType[]) f210114a.clone();
    }

    public static BaseMainTitleTagType valueOf(String r100) {
        return (BaseMainTitleTagType) r27.a.a(BaseMainTitleTagType.class, r100);
    }

    public BaseMainTitleTagType(String r100, int r101) {
        super(r100, r101);
    }
}
