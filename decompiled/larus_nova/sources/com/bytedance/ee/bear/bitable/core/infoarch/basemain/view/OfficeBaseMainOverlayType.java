package com.bytedance.ee.bear.bitable.core.infoarch.basemain.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/core/infoarch/basemain/view/OfficeBaseMainOverlayType;", "", "<init>", "(Ljava/lang/String;I)V", "FORM", "NATIVE_VIEW", "LINKED_DOCX", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeBaseMainOverlayType extends Enum<OfficeBaseMainOverlayType> {
    public static final OfficeBaseMainOverlayType FORM = null;
    public static final OfficeBaseMainOverlayType LINKED_DOCX = null;
    public static final OfficeBaseMainOverlayType NATIVE_VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeBaseMainOverlayType[] f210532a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f210533b = null;

    public static EnumEntries<OfficeBaseMainOverlayType> getEntries() {
        return f210533b;
    }

    static {
        OfficeBaseMainOverlayType r100 = new OfficeBaseMainOverlayType("FORM", 0);
        FORM = r100;
        OfficeBaseMainOverlayType r101 = new OfficeBaseMainOverlayType("NATIVE_VIEW", 1);
        NATIVE_VIEW = r101;
        OfficeBaseMainOverlayType r102 = new OfficeBaseMainOverlayType("LINKED_DOCX", 2);
        LINKED_DOCX = r102;
        OfficeBaseMainOverlayType[] r103 = {r100, r101, r102};
        f210532a = r103;
        f210533b = EnumEntriesKt.enumEntries(r103);
    }

    public static OfficeBaseMainOverlayType[] values() {
        return (OfficeBaseMainOverlayType[]) f210532a.clone();
    }

    public static OfficeBaseMainOverlayType valueOf(String r100) {
        return (OfficeBaseMainOverlayType) a.a(OfficeBaseMainOverlayType.class, r100);
    }

    public OfficeBaseMainOverlayType(String r100, int r101) {
        super(r100, r101);
    }
}
