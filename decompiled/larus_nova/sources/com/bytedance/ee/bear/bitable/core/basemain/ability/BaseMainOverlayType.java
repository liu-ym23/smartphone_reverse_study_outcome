package com.bytedance.ee.bear.bitable.core.basemain.ability;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/core/basemain/ability/BaseMainOverlayType;", "", "<init>", "(Ljava/lang/String;I)V", "ITEM_VIEW", "FORM", "LINKED_DOCUMENT", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BaseMainOverlayType extends Enum<BaseMainOverlayType> {
    public static final BaseMainOverlayType FORM = null;
    public static final BaseMainOverlayType ITEM_VIEW = null;
    public static final BaseMainOverlayType LINKED_DOCUMENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BaseMainOverlayType[] f210112a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f210113b = null;

    public static EnumEntries<BaseMainOverlayType> getEntries() {
        return f210113b;
    }

    static {
        BaseMainOverlayType r100 = new BaseMainOverlayType("ITEM_VIEW", 0);
        ITEM_VIEW = r100;
        BaseMainOverlayType r101 = new BaseMainOverlayType("FORM", 1);
        FORM = r101;
        BaseMainOverlayType r102 = new BaseMainOverlayType("LINKED_DOCUMENT", 2);
        LINKED_DOCUMENT = r102;
        BaseMainOverlayType[] r103 = {r100, r101, r102};
        f210112a = r103;
        f210113b = EnumEntriesKt.enumEntries(r103);
    }

    public static BaseMainOverlayType[] values() {
        return (BaseMainOverlayType[]) f210112a.clone();
    }

    public static BaseMainOverlayType valueOf(String r100) {
        return (BaseMainOverlayType) r27.a.a(BaseMainOverlayType.class, r100);
    }

    public BaseMainOverlayType(String r100, int r101) {
        super(r100, r101);
    }
}
